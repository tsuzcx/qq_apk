package com.tencent.biz.richframework.network;

import com.tencent.biz.richframework.network.delegate.VSBaseNetwork;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.servlet.VSBaseServlet;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;
import cooperation.qqcircle.report.outbox.SimpleTaskQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class MobileQQVSNetworkImpl
  extends VSBaseNetwork
{
  private static volatile String mCurrentAccount;
  
  public String getAccountId()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
  }
  
  public String getQUA()
  {
    return QCircleServiceImpl.getQZoneService().getQUA3();
  }
  
  public boolean isValidLog(String paramString)
  {
    return (paramString != null) && (!paramString.endsWith(".DataReport"));
  }
  
  public boolean needReinitialize()
  {
    return (mCurrentAccount != null) && (!mCurrentAccount.equals(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount()));
  }
  
  public void onInit()
  {
    QCircleInvokeProxy.invoke(1, 1, new Object[0]);
    mCurrentAccount = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
  }
  
  public void onRelease()
  {
    QCircleInvokeProxy.invoke(2, 1, new Object[0]);
    QCircleHostGlobalInfo.releaseWhenAccountChange();
    QCircleReportOutboxTaskQueue.getInstance().resetTaskList();
    mCurrentAccount = null;
  }
  
  public void sendRequest(BaseRequest paramBaseRequest, byte[] paramArrayOfByte, VSNetworkHelper.OnReceivedCall paramOnReceivedCall)
  {
    paramOnReceivedCall = new NewIntent(MobileQQ.getContext(), VSBaseServlet.class);
    paramOnReceivedCall.putExtra("key_request_data", paramArrayOfByte);
    paramOnReceivedCall.putExtra("key_request", paramBaseRequest);
    MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(paramOnReceivedCall);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.MobileQQVSNetworkImpl
 * JD-Core Version:    0.7.0.1
 */