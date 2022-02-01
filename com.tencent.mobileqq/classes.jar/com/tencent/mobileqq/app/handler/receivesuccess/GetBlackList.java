package com.tencent.mobileqq.app.handler.receivesuccess;

import AccostSvc.RespGetBlackList;
import AccostSvc.RespHeader;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

public class GetBlackList
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (("AccostSvc.ReqGetBlackList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
    {
      paramToServiceMsg = (RespGetBlackList)paramObject;
      if (paramToServiceMsg.stHeader.eReplyCode == 0)
      {
        int j = paramToServiceMsg.vBlackListUin.size();
        if (j > 0)
        {
          paramFromServiceMsg = (FriendsManager)paramMessageHandler.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
          int i = 0;
          while (i < j)
          {
            paramObject = new StringBuilder();
            paramObject.append(((Long)paramToServiceMsg.vBlackListUin.get(i)).longValue());
            paramObject.append("");
            paramObject = paramObject.toString();
            if (!paramFromServiceMsg.b(paramObject)) {
              paramFromServiceMsg.b(paramObject);
            }
            i += 1;
          }
        }
        if (paramToServiceMsg.lNextMid == -1L) {
          return;
        }
        paramMessageHandler.b(paramToServiceMsg.lNextMid);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.GetBlackList
 * JD-Core Version:    0.7.0.1
 */