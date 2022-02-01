package com.tencent.biz.richframework.network;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.QCircleHostGlobalInfo;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.network.servlet.VSBaseServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;
import cooperation.qqcircle.report.outbox.SimpleTaskQueue;
import mqq.app.AppRuntime;
import zqh;

public class VSNetworkHelper
{
  public static final String CACHE_TAG = "VSNetworkHelper| Protocol Cache";
  public static final String ERROR_CACHE_PREFIX = "_VSNetworkHelperCache";
  public static final String ERROR_TIMEOUT_PREFIX = "_VSNetworkHelperTimeOut";
  public static final String TAG = "VSNetworkHelper";
  private static volatile String mCurrentAccount;
  private static final VSDispatchObserver mDispatchObserver = new VSDispatchObserver();
  private static final VSNetworkHelper mInstance = new VSNetworkHelper();
  private VSNetworkHelper.NetStateChangeListener mNetStateChangeListener;
  
  public static VSDispatchObserver getDispatchObserver()
  {
    return mDispatchObserver;
  }
  
  public static VSNetworkHelper getInstance()
  {
    if (mCurrentAccount == null) {}
    for (;;)
    {
      try
      {
        if (mCurrentAccount == null) {
          init();
        }
        return mInstance;
      }
      finally {}
      if (!isDifferentAccount()) {
        continue;
      }
      try
      {
        if (isDifferentAccount())
        {
          mInstance.release();
          init();
        }
      }
      finally {}
    }
  }
  
  private static void init()
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: registerObserver");
    mCurrentAccount = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    BaseApplicationImpl.getApplication().getRuntime().registObserver(getDispatchObserver());
    QCircleInvokeProxy.invoke(1, 1, new Object[0]);
  }
  
  private static boolean isDifferentAccount()
  {
    return (mCurrentAccount != null) && (!mCurrentAccount.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
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
    return (paramString != null) && (!paramString.endsWith(".DataReport"));
  }
  
  public void cancelRequest(Context paramContext)
  {
    if (paramContext != null)
    {
      QLog.i("VSNetworkHelper", 2, String.format("VSNetworkHelper: cancelRequest：success, contextHashCode:%s", new Object[] { Integer.valueOf(paramContext.hashCode()) }));
      getDispatchObserver().cancelAllRequest(paramContext);
    }
  }
  
  public void cancelRequest(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      QLog.i("VSNetworkHelper", 2, String.format("VSNetworkHelper: cancelRequest：success, contextHashCode:%s", new Object[] { Integer.valueOf(paramContext.hashCode()) }));
      getDispatchObserver().cancelRequest(paramContext, paramInt);
    }
  }
  
  public void release()
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: release");
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(getDispatchObserver());
    getDispatchObserver().release();
    zqh.a();
    QCircleInvokeProxy.invoke(2, 1, new Object[0]);
    QCircleHostGlobalInfo.releaseWhenAccountChange();
    QCircleReportOutboxTaskQueue.getInstance().resetTaskList();
    mCurrentAccount = null;
    if (this.mNetStateChangeListener != null) {
      this.mNetStateChangeListener.onRelease();
    }
  }
  
  public int sendRequest(int paramInt, VSBaseRequest paramVSBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    if (paramVSBaseRequest == null) {
      return 0;
    }
    paramVSBaseRequest.setContextHashCode(paramInt);
    getDispatchObserver().setCallBack(paramVSBaseRequest, paramonVSRspCallBack);
    paramonVSRspCallBack = new VSNetworkHelper.RequestIntent(this, BaseApplicationImpl.getApplication(), VSBaseServlet.class);
    paramonVSRspCallBack.putExtra("key_request_data", paramVSBaseRequest);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramonVSRspCallBack);
    if (isValidLog(paramVSBaseRequest.getCmdName())) {
      QLog.i("VSNetworkHelper", 2, String.format("VSNetworkHelper: sendRequest: success, contextHashCode:%s, seq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramVSBaseRequest.getCurrentSeq()) }));
    }
    return paramVSBaseRequest.getCurrentSeq();
  }
  
  public void sendRequest(Context paramContext, VSBaseRequest paramVSBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    sendRequest(localObject.hashCode(), paramVSBaseRequest, paramonVSRspCallBack);
  }
  
  public void sendRequest(VSBaseRequest paramVSBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    sendRequest(null, paramVSBaseRequest, paramonVSRspCallBack);
  }
  
  public void setNetStateChangeListener(VSNetworkHelper.NetStateChangeListener paramNetStateChangeListener)
  {
    this.mNetStateChangeListener = paramNetStateChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.VSNetworkHelper
 * JD-Core Version:    0.7.0.1
 */