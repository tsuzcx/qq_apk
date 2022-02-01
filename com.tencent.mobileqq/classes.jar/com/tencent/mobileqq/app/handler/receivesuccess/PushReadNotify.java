package com.tencent.mobileqq.app.handler.receivesuccess;

import PushNotifyPack.C2CMsgReadedNotify;
import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import PushNotifyPack.SvcRequestPushReadedNotify;
import com.tencent.imcore.message.C2CMessageProcessor;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PushReadNotify
{
  private static void a(MessageHandler paramMessageHandler, SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify, List<Object> paramList)
  {
    if (paramSvcRequestPushReadedNotify.vGroupReadedNotify != null)
    {
      if (paramSvcRequestPushReadedNotify.vGroupReadedNotify.size() <= 0) {
        return;
      }
      paramList.addAll(paramSvcRequestPushReadedNotify.vGroupReadedNotify);
      paramSvcRequestPushReadedNotify = paramSvcRequestPushReadedNotify.vGroupReadedNotify.iterator();
      while (paramSvcRequestPushReadedNotify.hasNext())
      {
        Object localObject = (GroupMsgReadedNotify)paramSvcRequestPushReadedNotify.next();
        paramList = String.valueOf(((GroupMsgReadedNotify)localObject).lGroupCode);
        if (paramMessageHandler.a.getMsgCache().a(paramList) == 1)
        {
          paramMessageHandler.a.getMsgCache().a(paramList, (GroupMsgReadedNotify)localObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("GroupMsgReadedNotify unfinished groupUin=");
            ((StringBuilder)localObject).append(paramList);
            QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          ((TroopMessageProcessor)paramMessageHandler.a("troop_processor")).a((GroupMsgReadedNotify)localObject);
        }
      }
    }
  }
  
  private static void a(MessageHandler paramMessageHandler, SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify, List<Object> paramList, boolean paramBoolean)
  {
    if (paramSvcRequestPushReadedNotify.vC2CReadedNotify != null)
    {
      if (paramSvcRequestPushReadedNotify.vC2CReadedNotify.size() <= 0) {
        return;
      }
      Object localObject1;
      if (paramBoolean)
      {
        paramList = (ISubAccountService)paramMessageHandler.a.getRuntimeService(ISubAccountService.class, null);
        paramSvcRequestPushReadedNotify = paramSvcRequestPushReadedNotify.vC2CReadedNotify.iterator();
        int i = 0;
        while (paramSvcRequestPushReadedNotify.hasNext())
        {
          Object localObject2 = (C2CMsgReadedNotify)paramSvcRequestPushReadedNotify.next();
          Object localObject3 = Long.toString(((C2CMsgReadedNotify)localObject2).lPeerUin);
          localObject1 = Long.toString(((C2CMsgReadedNotify)localObject2).lBindedUin);
          int j = paramList.removeMessage((String)localObject1, (String)localObject3);
          i += j;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handlePushReadedNotify C2CMsgReadedNotify curFriendUin is ");
            ((StringBuilder)localObject3).append(((C2CMsgReadedNotify)localObject2).lPeerUin);
            ((StringBuilder)localObject3).append(", lLastReadTime  is ");
            ((StringBuilder)localObject3).append(((C2CMsgReadedNotify)localObject2).lLastReadTime);
            ((StringBuilder)localObject3).append(" isSubAccount=");
            ((StringBuilder)localObject3).append(paramBoolean);
            ((StringBuilder)localObject3).append(" changed=");
            ((StringBuilder)localObject3).append(j);
            QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject3).toString());
          }
          if (i != 0)
          {
            paramMessageHandler.a.getConversationFacade().d((String)localObject1, 7000, i);
            if (paramMessageHandler.a.isLogin()) {
              ((IAppBadgeService)paramMessageHandler.a.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handlePushReadedNotify subUin=");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("increaseUnread=");
              ((StringBuilder)localObject2).append(i);
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
            }
          }
          paramMessageHandler.a.getMessageFacade().a(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, localObject1 });
        }
      }
      paramList.addAll(paramSvcRequestPushReadedNotify.vC2CReadedNotify);
      paramSvcRequestPushReadedNotify = paramSvcRequestPushReadedNotify.vC2CReadedNotify.iterator();
      while (paramSvcRequestPushReadedNotify.hasNext())
      {
        paramList = (C2CMsgReadedNotify)paramSvcRequestPushReadedNotify.next();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("C2CMsgReadedNotify curFriendUin is ");
          ((StringBuilder)localObject1).append(paramList.lPeerUin);
          ((StringBuilder)localObject1).append(", lLastReadTime  is ");
          ((StringBuilder)localObject1).append(paramList.lLastReadTime);
          ((StringBuilder)localObject1).append(" isSubAccount=");
          ((StringBuilder)localObject1).append(paramBoolean);
          QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
        }
        ((C2CMessageProcessor)paramMessageHandler.a("c2c_processor")).a(paramList);
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"MessageSvc.PushReaded".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    paramToServiceMsg = (SvcRequestPushReadedNotify)paramObject;
    paramFromServiceMsg = new ArrayList();
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handlePushReadedNotify() vC2CReadedNotify=");
      paramObject.append(paramToServiceMsg.vC2CReadedNotify);
      paramObject.append(", vGroupReadedNotify=");
      paramObject.append(paramToServiceMsg.vGroupReadedNotify);
      paramObject.append(", vDisMsgReadedNotify=");
      paramObject.append(paramToServiceMsg.vDisReadedNotify);
      QLog.d("Q.msg.MessageHandler", 2, paramObject.toString());
    }
    a(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg, a(paramToServiceMsg));
    a(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg);
    b(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg);
    if (paramFromServiceMsg.size() > 0) {
      paramMessageHandler.notifyUI(6004, true, paramFromServiceMsg.toArray());
    }
  }
  
  private static boolean a(SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify)
  {
    boolean bool;
    if ((paramSvcRequestPushReadedNotify.cNotifyType & 0x8) == 8)
    {
      bool = true;
      if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "handlePushReadedNotify() isSubAccount=true");
        return true;
      }
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  private static void b(MessageHandler paramMessageHandler, SvcRequestPushReadedNotify paramSvcRequestPushReadedNotify, List<Object> paramList)
  {
    if (paramSvcRequestPushReadedNotify.vDisReadedNotify != null)
    {
      if (paramSvcRequestPushReadedNotify.vDisReadedNotify.size() <= 0) {
        return;
      }
      paramList.addAll(paramSvcRequestPushReadedNotify.vDisReadedNotify);
      paramSvcRequestPushReadedNotify = paramSvcRequestPushReadedNotify.vDisReadedNotify.iterator();
      while (paramSvcRequestPushReadedNotify.hasNext())
      {
        Object localObject = (DisMsgReadedNotify)paramSvcRequestPushReadedNotify.next();
        paramList = String.valueOf(((DisMsgReadedNotify)localObject).lDisUin);
        if (paramMessageHandler.a.getMsgCache().b(paramList) == 1)
        {
          paramMessageHandler.a.getMsgCache().a(paramList, (DisMsgReadedNotify)localObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("DisMsgReadedNotify unfinished discussionUin=");
            ((StringBuilder)localObject).append(paramList);
            QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          ((DiscMessageProcessor)paramMessageHandler.a("disc_processor")).a((DisMsgReadedNotify)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.PushReadNotify
 * JD-Core Version:    0.7.0.1
 */