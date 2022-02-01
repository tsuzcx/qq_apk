package com.tencent.biz.richframework.network;

import android.content.Context;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.delegate.VSBaseNetwork;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class VSNetworkHelper
{
  public static final String CACHE_TAG = "VSNetworkHelper| Protocol Cache";
  public static final String ERROR_CACHE_PREFIX = "_VSNetworkHelperCache";
  public static final String ERROR_TIMEOUT_PREFIX = "_VSNetworkHelperTimeOut";
  public static final String TAG = "VSNetworkHelper";
  private static final VSDispatchObserver mDispatchObserver = new VSDispatchObserver();
  private static Class<? extends VSBaseNetwork> mImplClass;
  private static final VSNetworkHelper mInstance = new VSNetworkHelper();
  private static volatile boolean mIsInit = false;
  private static VSBaseNetwork mNetworkImpl;
  private VSNetworkHelper.OnReceivedCall mReceivedCall;
  
  private byte[] convertInputStreamtoByteArray(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  private long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    return l;
  }
  
  public static VSDispatchObserver getDispatchObserver()
  {
    return mDispatchObserver;
  }
  
  public static VSNetworkHelper getInstance()
  {
    VSBaseNetwork localVSBaseNetwork = mNetworkImpl;
    if (localVSBaseNetwork == null) {
      try
      {
        if (mNetworkImpl == null) {
          init();
        }
      }
      finally {}
    } else if (localObject1.needReinitialize()) {
      try
      {
        if (mNetworkImpl.needReinitialize())
        {
          mInstance.release();
          init();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public static VSBaseNetwork getNetworkImpl()
  {
    return mNetworkImpl;
  }
  
  private static void init()
  {
    if (mIsInit) {
      return;
    }
    mImplClass = RFApplication.getDelegateImpl(VSBaseNetwork.class);
    if ((RFApplication.isDebug()) && (mImplClass == null)) {
      throw new RuntimeException("please invoke setNetworkImpl method to bind implemention");
    }
    try
    {
      mNetworkImpl = (VSBaseNetwork)mImplClass.newInstance();
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    mNetworkImpl.onInit();
    mIsInit = true;
  }
  
  public static boolean isProtocolCache(String paramString)
  {
    if (paramString != null) {
      return paramString.startsWith("_VSNetworkHelperCache");
    }
    return false;
  }
  
  public static boolean isTimeOutRetCode(int paramInt)
  {
    return paramInt == -100001;
  }
  
  public static boolean isValidLog(String paramString)
  {
    VSBaseNetwork localVSBaseNetwork = mNetworkImpl;
    return (localVSBaseNetwork != null) && (localVSBaseNetwork.isValidLog(paramString));
  }
  
  private void responseCache(BaseRequest paramBaseRequest)
  {
    if (paramBaseRequest.isEnableCache())
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start to response cache,CmdName:");
      localStringBuilder.append(paramBaseRequest.getCmdName());
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(paramBaseRequest.getCurrentSeq());
      RFLog.d("VSNetworkHelper| Protocol Cache", i, localStringBuilder.toString());
      RFThreadManager.execute(new VSNetworkHelper.1(this, paramBaseRequest), RFThreadManager.Normal);
    }
  }
  
  public void cancelRequest(Context paramContext)
  {
    if (paramContext != null)
    {
      RFLog.i("VSNetworkHelper", RFLog.CLR, String.format("VSNetworkHelper: cancelRequest：success, contextHashCode:%s", new Object[] { Integer.valueOf(paramContext.hashCode()) }));
      getDispatchObserver().cancelAllRequest(paramContext);
    }
  }
  
  public void cancelRequest(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      RFLog.i("VSNetworkHelper", RFLog.CLR, String.format("VSNetworkHelper: cancelRequest：success, contextHashCode:%s", new Object[] { Integer.valueOf(paramContext.hashCode()) }));
      getDispatchObserver().cancelRequest(paramContext, paramInt);
    }
  }
  
  public VSNetworkHelper.OnReceivedCall getReceivedCall()
  {
    if (this.mReceivedCall == null) {
      this.mReceivedCall = new VSNetworkHelper.OnReceivedCall();
    }
    return this.mReceivedCall;
  }
  
  public void release()
  {
    RFLog.i("VSNetworkHelper", RFLog.CLR, "VSNetworkHelper: release");
    getDispatchObserver().release();
    VSBaseNetwork localVSBaseNetwork = mNetworkImpl;
    if (localVSBaseNetwork != null)
    {
      localVSBaseNetwork.onRelease();
      mNetworkImpl = null;
    }
    mIsInit = false;
  }
  
  public int sendRequest(int paramInt, BaseRequest paramBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    if (paramBaseRequest == null) {
      return 0;
    }
    paramBaseRequest.setContextHashCode(paramInt);
    getDispatchObserver().setCallBack(paramBaseRequest, paramonVSRspCallBack);
    paramonVSRspCallBack = mNetworkImpl;
    if (paramonVSRspCallBack != null)
    {
      paramonVSRspCallBack.sendRequest(paramBaseRequest, paramBaseRequest.encode(), getReceivedCall());
      paramBaseRequest.generateSendTimeStamp();
      responseCache(paramBaseRequest);
    }
    if (isValidLog(paramBaseRequest.getCmdName())) {
      RFLog.i("VSNetworkHelper", RFLog.CLR, String.format("VSNetworkHelper: sendRequest: success, contextHashCode:%s, seq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBaseRequest.getCurrentSeq()) }));
    }
    if (isValidLog(paramBaseRequest.getCmdName()))
    {
      paramInt = RFLog.CLR;
      paramonVSRspCallBack = new StringBuilder();
      paramonVSRspCallBack.append("onSend Info:CmdName:");
      paramonVSRspCallBack.append(paramBaseRequest.getCmdName());
      paramonVSRspCallBack.append(" | TraceId:");
      paramonVSRspCallBack.append(paramBaseRequest.getTraceId());
      paramonVSRspCallBack.append(" | SeqNum:");
      paramonVSRspCallBack.append(paramBaseRequest.getCurrentSeq());
      paramonVSRspCallBack.append(" | request encode size:");
      paramonVSRspCallBack.append(0);
      RFLog.i("VSNetworkHelper", paramInt, paramonVSRspCallBack.toString());
    }
    return paramBaseRequest.getCurrentSeq();
  }
  
  public int sendRequest(Context paramContext, BaseRequest paramBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = RFApplication.getApplication();
    }
    int i = -1;
    if (localContext != null) {
      i = localContext.hashCode();
    }
    return sendRequest(i, paramBaseRequest, paramonVSRspCallBack);
  }
  
  public int sendRequest(BaseRequest paramBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    return sendRequest(null, paramBaseRequest, paramonVSRspCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.VSNetworkHelper
 * JD-Core Version:    0.7.0.1
 */