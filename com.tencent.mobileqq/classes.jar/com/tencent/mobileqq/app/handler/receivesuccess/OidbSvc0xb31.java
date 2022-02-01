package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.RspBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31.SimilarItem;

public class OidbSvc0xb31
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    if ("OidbSvc.0xb31".equalsIgnoreCase(paramString)) {
      a(paramMessageHandler.n, paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow.");
    }
    long l = paramToServiceMsg.extraData.getLong("toUin");
    paramToServiceMsg = new oidb_0xb31.RspBody();
    int i = OidbWrapper.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0) {
      if (paramToServiceMsg.items.has())
      {
        paramToServiceMsg = paramToServiceMsg.items.get();
        if ((paramToServiceMsg != null) && (!paramToServiceMsg.isEmpty()))
        {
          paramFromServiceMsg = (oidb_0xb31.SimilarItem)paramToServiceMsg.get(0);
          if (paramFromServiceMsg != null)
          {
            try
            {
              paramToServiceMsg = new JSONObject();
              if (paramFromServiceMsg.icon_url.has()) {
                paramToServiceMsg.put("icon_url", paramFromServiceMsg.icon_url.get());
              }
              if (paramFromServiceMsg.jump_url.has()) {
                paramToServiceMsg.put("jump_url", paramFromServiceMsg.jump_url.get());
              }
              if (paramFromServiceMsg.name.has()) {
                paramToServiceMsg.put("name", paramFromServiceMsg.name.get());
              }
              if (paramFromServiceMsg.sub_title.has()) {
                paramToServiceMsg.put("sub_title", paramFromServiceMsg.sub_title.get());
              }
              if (paramFromServiceMsg.title.has()) {
                paramToServiceMsg.put("title", paramFromServiceMsg.title.get());
              }
              if (paramFromServiceMsg.type.has()) {
                paramToServiceMsg.put("type", paramFromServiceMsg.type.get());
              }
              if (paramFromServiceMsg.url.has()) {
                paramToServiceMsg.put("url", paramFromServiceMsg.url.get());
              }
              if (paramFromServiceMsg.show_both_head.has()) {
                paramToServiceMsg.put("show_both_head", paramFromServiceMsg.show_both_head.get());
              }
              paramToServiceMsg.put("friend_uin", l);
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = new StringBuilder();
                paramFromServiceMsg.append("handleGetCommonHobbyForAIOShow content is: ");
                paramFromServiceMsg.append(paramToServiceMsg.toString());
                QLog.d("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
              }
              ((INewFriendService)paramQQAppInterface.getRuntimeService(INewFriendService.class)).insertCommonHobbyForAIOShowNewsMsg(paramToServiceMsg.toString(), String.valueOf(l));
            }
            catch (Exception paramQQAppInterface)
            {
              if (!QLog.isColorLevel()) {
                break label459;
              }
            }
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetCommonHobbyForAIOShow exception: ");
            paramToServiceMsg.append(QLog.getStackTraceString(paramQQAppInterface));
            QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow index == 0 item is null.");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow items is empty.");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow items not has.");
      }
    }
    label459:
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("handleGetCommonHobbyForAIOShow. result is: ");
      paramQQAppInterface.append(i);
      QLog.d("Q.msg.MessageHandler", 2, paramQQAppInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.OidbSvc0xb31
 * JD-Core Version:    0.7.0.1
 */