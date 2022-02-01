package com.tencent.mobileqq.activity.recent.msgbox;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.api.IFilterMsgBoxHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xefe.oidb_cmd0xefe.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FilterMsgBoxHandler
  extends BusinessHandler
  implements IFilterMsgBoxHandler
{
  protected FilterMsgBoxHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiverOxefe() called with: resultCode = [");
      localStringBuilder.append(i);
      localStringBuilder.append("], req = [");
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append("], res = [");
      localStringBuilder.append(paramFromServiceMsg);
      localStringBuilder.append("]");
      QLog.d("FilterMsgBoxHandler", 2, localStringBuilder.toString());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.d("FilterMsgBoxHandler", 1, "onReceiverOxefe()  e =", paramFromServiceMsg);
      }
      notifyUI(paramToServiceMsg.uint32_result.get(), true, null);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendDelPbReq() called with: uin = [");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.d("FilterMsgBoxHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_cmd0xefe.ReqBody();
    ((oidb_cmd0xefe.ReqBody)localObject).friend_uin.set(paramLong);
    ((oidb_cmd0xefe.ReqBody)localObject).last_ts.set(FilterMsgBoxUtil.a());
    sendPbReq(makeOIDBPkg("OidbSvc.0xefe", 3838, 3, ((oidb_cmd0xefe.ReqBody)localObject).toByteArray()));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return FilterMsgBoxObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      if ("OidbSvc.0xefe".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("[onReceive] params: res: ");
    paramToServiceMsg.append(paramFromServiceMsg);
    paramToServiceMsg.append(". data: ");
    paramToServiceMsg.append(paramObject);
    QLog.e("FilterMsgBoxHandler", 1, paramToServiceMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxHandler
 * JD-Core Version:    0.7.0.1
 */