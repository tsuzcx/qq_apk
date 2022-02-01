package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xefe.oidb_cmd0xefe.RspBody;

public class GetBoxFilterResp
{
  public static void a(QQAppInterface paramQQAppInterface, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("RegPrxySvc.GetBoxFilter".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject == null)
      {
        QLog.e("Q.msg.MessageHandler", 1, "handleGetBoxFilterResp return by null data");
        return;
      }
      paramFromServiceMsg = new oidb_cmd0xefe.RspBody();
      if ((paramObject instanceof oidb_cmd0xefe.RspBody)) {
        paramToServiceMsg = (oidb_cmd0xefe.RspBody)paramObject;
      } else {
        try
        {
          paramToServiceMsg = (oidb_cmd0xefe.RspBody)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        }
        catch (Exception paramObject)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            QLog.e("Q.msg.MessageHandler", 2, "<---handleGetBoxFilterResp : decode oidb_cmd0xefe.RspBody:", paramObject);
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
      }
      paramQQAppInterface = (ITempMsgBoxManager)paramQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
      if (paramToServiceMsg.mute_friend.has())
      {
        paramFromServiceMsg = paramToServiceMsg.mute_friend.get().iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (Long)paramFromServiceMsg.next();
          if (!paramQQAppInterface.hasFilter(String.valueOf(paramObject)))
          {
            paramQQAppInterface.addToFilterList(String.valueOf(paramObject));
            paramQQAppInterface.removeFromWhiteList(String.valueOf(paramObject));
          }
        }
      }
      if (paramToServiceMsg.whitelist.has())
      {
        paramFromServiceMsg = paramToServiceMsg.whitelist.get().iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (Long)paramFromServiceMsg.next();
          paramQQAppInterface.addToWhiteList(String.valueOf(paramObject));
          paramQQAppInterface.removeFromFilterList(String.valueOf(paramObject));
        }
      }
      if (paramToServiceMsg.update_time.has())
      {
        long l = paramToServiceMsg.update_time.get();
        ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).saveUpdateTime(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.GetBoxFilterResp
 * JD-Core Version:    0.7.0.1
 */