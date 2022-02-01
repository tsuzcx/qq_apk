package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class WifiSdkHandler
  extends BusinessHandler
{
  public WifiSdkHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "WifiCloudCheckSvc.req");
    localToServiceMsg.addAttribute("request_type", Integer.valueOf(paramInt));
    super.send(localToServiceMsg);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return WifiSdkObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WifiSdkHandler, onReceive resultCode: ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append(" errorMsg: ");
      localStringBuilder.append(paramFromServiceMsg.getBusinessFailMsg());
      localStringBuilder.append(" serviceCmd: ");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      QLog.i("WifiSdk", 2, localStringBuilder.toString());
    }
    int i = 0;
    try
    {
      if ("WifiCloudCheckSvc.req".equals(paramToServiceMsg.getServiceCmd()))
      {
        int j = ((Integer)paramToServiceMsg.getAttribute("request_type")).intValue();
        i = j;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("WifiSdkHandler, onReceive type: ");
          paramToServiceMsg.append(j);
          QLog.i("WifiSdk", 2, paramToServiceMsg.toString());
          i = j;
        }
      }
      super.notifyUI(i, paramFromServiceMsg.isSuccess(), paramObject);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("WifiSdkHandler, onReceive exception: ");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.i("WifiSdk", 2, paramFromServiceMsg.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.WifiSdkHandler
 * JD-Core Version:    0.7.0.1
 */