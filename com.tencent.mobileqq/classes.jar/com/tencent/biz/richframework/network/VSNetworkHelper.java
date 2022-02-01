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
    if (mNetworkImpl == null) {}
    for (;;)
    {
      try
      {
        if (mNetworkImpl == null) {
          init();
        }
        return mInstance;
      }
      finally {}
      if (!mNetworkImpl.needReinitialize()) {
        continue;
      }
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
      mNetworkImpl.onInit();
      mIsInit = true;
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        localInstantiationException.printStackTrace();
      }
    }
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
    return (mNetworkImpl != null) && (mNetworkImpl.isValidLog(paramString));
  }
  
  private void responseCache(BaseRequest paramBaseRequest)
  {
    if (paramBaseRequest.isEnableCache())
    {
      RFLog.d("VSNetworkHelper| Protocol Cache", RFLog.USR, "start to response cache,CmdName:" + paramBaseRequest.getCmdName() + " Seq:" + paramBaseRequest.getCurrentSeq());
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
    if (mNetworkImpl != null)
    {
      mNetworkImpl.onRelease();
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
    if (mNetworkImpl != null)
    {
      mNetworkImpl.sendRequest(paramBaseRequest, paramBaseRequest.encode(), getReceivedCall());
      paramBaseRequest.generateSendTimeStamp();
      responseCache(paramBaseRequest);
    }
    if (isValidLog(paramBaseRequest.getCmdName())) {
      RFLog.i("VSNetworkHelper", RFLog.CLR, String.format("VSNetworkHelper: sendRequest: success, contextHashCode:%s, seq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramBaseRequest.getCurrentSeq()) }));
    }
    if (isValidLog(paramBaseRequest.getCmdName())) {
      RFLog.i("VSNetworkHelper", RFLog.CLR, "onSend Info:CmdName:" + paramBaseRequest.getCmdName() + " | TraceId:" + paramBaseRequest.getTraceId() + " | SeqNum:" + paramBaseRequest.getCurrentSeq() + " | request encode size:" + 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.VSNetworkHelper
 * JD-Core Version:    0.7.0.1
 */