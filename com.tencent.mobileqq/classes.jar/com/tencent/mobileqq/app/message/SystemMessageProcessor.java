package com.tencent.mobileqq.app.message;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendPushUtil;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.api.handler.ITroopBatchInfohandler;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.onlinepush.api.ITroopOnlinePushHandler;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppHandler;
import com.tencent.mobileqq.troop.troopmemberlevel.api.ITroopMemberLevelHandler;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationConfig;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfig;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopSuspiciousHelper;
import com.tencent.mobileqq.troop.util.TroopSystemMsgUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.DelDecideInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.DelMsgInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.DelUnDecideInfo;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.ReqBody;
import tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.RspBody;
import tencent.mobileim.structmsg.structmsg.FlagInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.ReqNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.ReqSystemMsgRead;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class SystemMessageProcessor
  extends BaseMessageProcessor
{
  private ArrayList<Integer> a;
  private int q;
  private int r;
  private int s;
  private final int t = 2;
  private final int u = 2;
  private final int v = 2;
  
  public SystemMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  private int a(List<structmsg.StructMsg> paramList, int paramInt1, int paramInt2)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    int i = paramInt1 - 1;
    while (i >= 0)
    {
      Object localObject = (structmsg.StructMsg)paramList.get(i);
      paramInt1 = paramInt2;
      if (localObject != null)
      {
        paramInt1 = paramInt2;
        if (((structmsg.StructMsg)localObject).msg.has())
        {
          paramInt1 = paramInt2;
          if (((structmsg.SystemMsg)((structmsg.StructMsg)localObject).msg.get()).uint32_c2c_invite_join_group_flag.has())
          {
            paramInt1 = paramInt2;
            if (((structmsg.SystemMsg)((structmsg.StructMsg)localObject).msg.get()).uint32_c2c_invite_join_group_flag.get() > 0)
            {
              int j = ((structmsg.SystemMsg)((structmsg.StructMsg)localObject).msg.get()).group_msg_type.get();
              int k = ((structmsg.SystemMsg)((structmsg.StructMsg)localObject).msg.get()).sub_type.get();
              paramInt1 = ((structmsg.StructMsg)localObject).uint32_unread_flag.get();
              long l1 = ((structmsg.StructMsg)localObject).msg.group_code.get();
              long l2 = ((structmsg.StructMsg)localObject).msg_time.get();
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("uint32_c2c_invite_join_group_flag not 0 groupMsgType:");
                ((StringBuilder)localObject).append(j);
                ((StringBuilder)localObject).append(" subType:");
                ((StringBuilder)localObject).append(k);
                ((StringBuilder)localObject).append("  unread_flag:");
                ((StringBuilder)localObject).append(paramInt1);
                ((StringBuilder)localObject).append("  unreadCount:");
                ((StringBuilder)localObject).append(paramInt2);
                ((StringBuilder)localObject).append(" troopCode:");
                ((StringBuilder)localObject).append(l1);
                ((StringBuilder)localObject).append("  msgTime:");
                ((StringBuilder)localObject).append(l2);
                QLog.i("SystemMessageProcessor", 2, ((StringBuilder)localObject).toString());
              }
              if (paramInt1 == 0)
              {
                paramInt1 = paramInt2;
                if (i >= paramInt2) {}
              }
              else
              {
                paramInt1 = paramInt2 - 1;
              }
              if ((j == 2) && (k == 2))
              {
                localObject = String.format("%s_%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
                if ((localTroopManager != null) && (!localTroopManager.j((String)localObject))) {}
              }
              else
              {
                paramList.remove(i);
              }
            }
          }
        }
      }
      i -= 1;
      paramInt2 = paramInt1;
    }
    return paramInt2;
  }
  
  private String a()
  {
    Object localObject = ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (MessageForSystemMsg)((List)localObject).get(((List)localObject).size() - 1);
        ((MessageForSystemMsg)localObject).parse();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((MessageForSystemMsg)localObject).structMsg.msg.req_uin_nick.get());
        localStringBuilder.append(" ");
        localStringBuilder.append(((MessageForSystemMsg)localObject).structMsg.msg.msg_describe.get());
        return localStringBuilder.toString();
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "mLocalDataList is null !");
    }
    return "";
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = a();
    }
    return str;
  }
  
  private String a(structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (paramRspSystemMsgNew.msg_display.has()) {
      return paramRspSystemMsgNew.msg_display.get();
    }
    return "";
  }
  
  @NotNull
  private ArrayList<MessageRecord> a(int paramInt1, String paramString, List<structmsg.StructMsg> paramList, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = false;
    while (i < paramInt2)
    {
      Object localObject2 = MessageRecordFactory.a(-2018);
      ((MessageRecord)localObject2).msgtype = -2018;
      ((MessageRecord)localObject2).selfuin = paramString;
      ((MessageRecord)localObject2).frienduin = AppConstants.TROOP_SYSTEM_MSG_UIN;
      structmsg.StructMsg localStructMsg = (structmsg.StructMsg)paramList.get(i);
      int j = localStructMsg.msg.group_msg_type.get();
      int k = TroopSystemMsgUtils.a(j);
      Object localObject1;
      if (k == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localStructMsg.msg.action_uin.get());
        ((StringBuilder)localObject1).append("");
        ((MessageRecord)localObject2).senderuin = ((StringBuilder)localObject1).toString();
      }
      else if (k == 2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localStructMsg.req_uin.get());
        ((StringBuilder)localObject1).append("");
        ((MessageRecord)localObject2).senderuin = ((StringBuilder)localObject1).toString();
      }
      ((MessageRecord)localObject2).istroop = 0;
      MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localObject2;
      localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)localStructMsg.get());
      localMessageForSystemMsg.shmsgseq = localMessageForSystemMsg.structMsg.msg_seq.get();
      k = localMessageForSystemMsg.structMsg.msg_type.get();
      int m = localMessageForSystemMsg.structMsg.msg.sub_type.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("requestFrom:");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" isLatestPushMsgProcessed:");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(" type:");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(" groupMsgType:");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" subType:");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(" troopUin:");
        ((StringBuilder)localObject1).append(localStructMsg.msg.group_code.get());
        ((StringBuilder)localObject1).append(" msgTime:");
        ((StringBuilder)localObject1).append(localStructMsg.msg_time.get());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("processGroupSystemMsg-->");
        localStringBuilder.append(((StringBuilder)localObject1).toString());
        QLog.d("SystemMessageProcessor", 2, localStringBuilder.toString());
      }
      if ((k != 1) || (SystemMsgUtils.a(m)))
      {
        if (m == 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(localStructMsg.msg.action_uin.get());
          ((StringBuilder)localObject1).append("");
          ((MessageRecord)localObject2).senderuin = ((StringBuilder)localObject1).toString();
        }
        localObject1 = new boolean[1];
        localObject1[0] = 1;
        if ((paramInt1 == 1) && (!bool))
        {
          a(paramInt3, i, localStructMsg, j, localMessageForSystemMsg, m, (boolean[])localObject1);
          bool = true;
        }
        else
        {
          b(paramInt3, i, localStructMsg, j, localMessageForSystemMsg, m, (boolean[])localObject1);
        }
        ((MessageRecord)localObject2).msgData = localMessageForSystemMsg.structMsg.toByteArray();
        if (localObject1[0] != 0) {
          localArrayList.add(localMessageForSystemMsg);
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("processGroupSystemMsg-->isAdd2Loacal:");
          ((StringBuilder)localObject2).append(localObject1[0]);
          QLog.d("SystemMessageProcessor", 2, ((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  @Nullable
  private structmsg.RspSystemMsgNew a(byte[] paramArrayOfByte, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (paramRspSystemMsgNew != null) {
      return paramRspSystemMsgNew;
    }
    paramRspSystemMsgNew = null;
    try
    {
      structmsg.RspSystemMsgNew localRspSystemMsgNew = new structmsg.RspSystemMsgNew();
      try
      {
        localRspSystemMsgNew.mergeFrom(paramArrayOfByte);
        return localRspSystemMsgNew;
      }
      catch (Exception paramRspSystemMsgNew)
      {
        paramArrayOfByte = localRspSystemMsgNew;
      }
      if (!QLog.isColorLevel()) {
        return paramArrayOfByte;
      }
    }
    catch (Exception localException)
    {
      paramArrayOfByte = paramRspSystemMsgNew;
      paramRspSystemMsgNew = localException;
    }
    QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb error:", paramRspSystemMsgNew);
    return paramArrayOfByte;
  }
  
  @Nullable
  private structmsg.StructMsg a(ArrayList<MessageRecord> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (MessageRecord)paramArrayList.next();
      if ((localObject instanceof MessageForSystemMsg))
      {
        localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
        if ((localObject != null) && (((structmsg.StructMsg)localObject).msg.has()) && (((structmsg.StructMsg)localObject).msg.group_msg_type.has()))
        {
          int i = ((structmsg.StructMsg)localObject).msg.group_msg_type.get();
          if ((i != 13) && (i != 6)) {
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, structmsg.StructMsg paramStructMsg, int paramInt3)
  {
    long l = paramStructMsg.msg.group_code.get();
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, String.format("handlePassiveExit online troopUin: %s, msgType: %s, i: %s, unreadCount: %s", new Object[] { String.valueOf(l), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
    ITroopPushHandler localITroopPushHandler = (ITroopPushHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_PUSH_HANDLER);
    if (localITroopPushHandler != null)
    {
      if (paramInt3 == 8) {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      }
      localITroopPushHandler.a(String.valueOf(paramStructMsg.msg.group_code.get()), paramInt3, paramStructMsg.msg_time.get(), paramInt1);
    }
  }
  
  private void a(int paramInt1, int paramInt2, structmsg.StructMsg paramStructMsg, int paramInt3, MessageForSystemMsg paramMessageForSystemMsg, int paramInt4, boolean[] paramArrayOfBoolean)
  {
    if ((paramInt3 == 2) && (paramInt4 == 2))
    {
      a(paramInt2, paramStructMsg, paramMessageForSystemMsg, paramArrayOfBoolean);
      return;
    }
    if (paramInt3 == 3)
    {
      d(paramStructMsg);
      return;
    }
    if (paramInt3 == 19)
    {
      b(paramStructMsg);
      return;
    }
    if (paramInt3 == 17)
    {
      a(paramStructMsg);
      return;
    }
    if (paramInt3 == 15)
    {
      c(paramStructMsg);
      return;
    }
    if ((paramInt3 != 13) && (paramInt3 != 6))
    {
      if ((paramInt3 == 8) || (paramInt3 == 7)) {
        a(paramInt1, paramInt2, paramStructMsg, paramInt3);
      }
    }
    else {
      a(paramInt2, paramStructMsg, paramInt3);
    }
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendGroupSystemMsgToVideo, msgType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], troopUin[");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("], userUin[");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("]");
      QLog.w("SystemMessageProcessor", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("tencent.video.q2v.GroupSystemMsg");
    ((Intent)localObject).putExtra("type", paramInt);
    ((Intent)localObject).putExtra("relationType", 1);
    ((Intent)localObject).putExtra("relationId", paramLong1);
    ((Intent)localObject).putExtra("userUin", paramLong2);
    if ((paramInt == 3) || (paramInt == 15)) {
      ((Intent)localObject).putExtra("needSendCmd", true);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().sendBroadcast((Intent)localObject);
    if ((paramInt == 7) || (paramInt == 8)) {
      ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getAVNotifyCenter().b(paramLong1);
    }
  }
  
  private void a(int paramInt1, INewFriendService paramINewFriendService, int paramInt2, String paramString, long paramLong)
  {
    if (a(paramInt1, paramLong))
    {
      if (QLog.isColorLevel())
      {
        paramINewFriendService = new StringBuilder();
        paramINewFriendService.append("sentSeq == respSeq | unreadCount = ");
        paramINewFriendService.append(paramInt1);
        paramINewFriendService.append(" | newFriendLastMsgTime = 0");
        QLog.d("SystemMessageProcessor", 2, paramINewFriendService.toString());
      }
    }
    else
    {
      paramString = a(paramString);
      if ((paramInt2 != paramInt1) && (paramInt1 == 0)) {
        ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).setReaded(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
      }
      paramINewFriendService.refreshNotificationWithFriendSystemMessage(new FriendSystemMessage(paramString, paramLong));
    }
  }
  
  private void a(int paramInt1, String paramString, structmsg.RspSystemMsgNew paramRspSystemMsgNew, List<structmsg.StructMsg> paramList, int paramInt2, int paramInt3, ITroopNotificationService paramITroopNotificationService, TroopNotificationEntryConfig paramTroopNotificationEntryConfig, int paramInt4, boolean paramBoolean)
  {
    b(paramList);
    ArrayList localArrayList = a(paramInt1, paramString, paramList, paramInt2, paramInt3);
    Object localObject = a(localArrayList);
    RecentManagerFor3rdPart localRecentManagerFor3rdPart = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.RECENT_MANAGER_FOR_3RDPART);
    if (localObject != null)
    {
      GroupSystemMsgController.a().a((structmsg.StructMsg)localObject);
      if ((paramTroopNotificationEntryConfig == null) || (!paramTroopNotificationEntryConfig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        long l = ((structmsg.StructMsg)localObject).msg_time.get();
        if ((paramInt3 != 0) || (paramBoolean))
        {
          localRecentManagerFor3rdPart.a(AppConstants.TROOP_NOTIFICATION_UIN, 9000, HardCodeUtil.a(2131691101), l, l);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("processNormalGroupSystemMsg, create notification node to user list unreadCount");
            ((StringBuilder)localObject).append(paramInt3);
            ((StringBuilder)localObject).append(" isLogin");
            ((StringBuilder)localObject).append(paramBoolean);
            QLog.d("SystemMessageProcessor", 1, ((StringBuilder)localObject).toString());
          }
        }
        if (paramInt4 != 0) {
          ReportController.b(null, "dc00898", "", "", "0X800B528", "0X800B528", 0, 0, "", "", null, null);
        }
      }
    }
    a(paramString, paramRspSystemMsgNew, paramInt3, paramITroopNotificationService, false, localArrayList);
    a(paramString, paramRspSystemMsgNew);
    if ((paramTroopNotificationEntryConfig == null) || (!paramTroopNotificationEntryConfig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
    {
      paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(Conversation.class);
      if ((paramString != null) && ((paramInt3 > 0) || (paramBoolean)))
      {
        paramString.sendMessage(paramString.obtainMessage(1009));
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 1, "processNormalGroupSystemMsg, refresh notification node");
        }
      }
    }
    boolean bool = false;
    e((structmsg.StructMsg)paramList.get(0));
    a(4005, true, localArrayList);
    paramString = (TroopNotificationConfig)QConfigManager.a().a(634);
    if ((paramITroopNotificationService != null) && (!paramITroopNotificationService.isTroopNotificaitonGetAll()) && (paramBoolean) && (paramString != null) && (paramString.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "Begin Auto Get Next");
      }
      c(0);
    }
    paramBoolean = bool;
    if (paramRspSystemMsgNew.uint32_has_suspicious_flag.get() == 1) {
      paramBoolean = true;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("processNormalGroupSystemMsg requestSuspiciousList :hasSuspiciousMsg = ");
      paramString.append(paramBoolean);
      QLog.d("SystemMessageProcessor", 2, paramString.toString());
    }
    if (paramBoolean) {
      TroopSuspiciousHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
  
  private void a(int paramInt1, structmsg.StructMsg paramStructMsg, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processGroupSystemMsg-->msgPos:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",msgTime:");
      ((StringBuilder)localObject1).append(paramStructMsg.msg_time);
      ((StringBuilder)localObject1).append(",msgType:");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(":delete troopMember, delete troop, clear local history");
      QLog.d("SystemMessageProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramStructMsg.msg.group_code.get());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramStructMsg.req_uin.get());
      localStringBuilder.append("");
      ((TroopManager)localObject1).b((String)localObject2, localStringBuilder.toString());
      ((TroopManager)localObject1).a(paramStructMsg.msg.group_code.get(), paramStructMsg.msg_time.get());
    }
  }
  
  private void a(int paramInt, structmsg.StructMsg paramStructMsg, MessageForSystemMsg paramMessageForSystemMsg, boolean[] paramArrayOfBoolean)
  {
    String str = String.valueOf(paramStructMsg.msg.group_code.get());
    TroopManager localTroopManager1 = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    a(str, localTroopManager1);
    structmsg.MsgInviteExt localMsgInviteExt;
    if (paramMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.has()) {
      localMsgInviteExt = (structmsg.MsgInviteExt)paramMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.get();
    } else {
      localMsgInviteExt = null;
    }
    int i;
    if (localMsgInviteExt != null) {
      i = localMsgInviteExt.uint32_wait_state.get();
    } else {
      i = -1;
    }
    if ((i == 2) || (i == 4))
    {
      TroopManager localTroopManager2 = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localTroopManager2.e(localTroopManager2.b(str));
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageForSystemMsg, localMsgInviteExt, str);
      if (QLog.isColorLevel())
      {
        paramMessageForSystemMsg = new StringBuilder();
        paramMessageForSystemMsg.append("processGroupSystemMsg-->msgPos:");
        paramMessageForSystemMsg.append(paramInt);
        paramMessageForSystemMsg.append(":addFriendTipsMr");
        QLog.d("SystemMessageProcessor", 2, paramMessageForSystemMsg.toString());
      }
    }
    if (i == 4) {
      paramArrayOfBoolean[0] = false;
    } else if (paramStructMsg.msg.uint32_c2c_invite_join_group_flag.get() != 0) {
      paramArrayOfBoolean[0] = false;
    }
    paramMessageForSystemMsg = (ITroopBatchInfohandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_BATCH_INFO_HANDLER);
    if (paramMessageForSystemMsg != null) {
      paramMessageForSystemMsg.a(str, Boolean.valueOf(false));
    }
    localTroopManager1.k(String.format("%s_%s", new Object[] { str, Long.valueOf(paramStructMsg.msg_time.get()) }));
  }
  
  private void a(FriendsManager paramFriendsManager, int paramInt, INewFriendService paramINewFriendService, ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean)
  {
    int i = paramArrayList.size();
    long l1 = ((MessageRecord)paramArrayList.get(i - 1)).time;
    long l2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getOldestSysMsgTime(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    Object localObject = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "");
    String str = AppConstants.FRIEND_SYSTEM_MSG_UIN;
    boolean bool2 = false;
    localObject = ((IMessageFacade)localObject).getAIOList(str, 0, l2);
    a(paramFriendsManager, paramArrayList, i, l1, (List)localObject, ((List)localObject).iterator());
    if (((List)localObject).size() == 0) {
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setOldestSysMsgTime(this.jdField_a_of_type_ComTencentCommonAppAppInterface, l1);
    } else if (paramArrayList.size() < 20) {
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setHasNoMoreMsg(true, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    paramFriendsManager = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "");
    paramString = String.valueOf(paramString);
    boolean bool1 = bool2;
    if (MessageHandlerUtils.a(paramArrayList))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundStop) {
        bool1 = true;
      }
    }
    paramFriendsManager.addMessage(paramArrayList, paramString, bool1);
    paramINewFriendService.loadNewFriendMsg(true);
    a(paramArrayList);
    a("handleGetSystemMsgResp", true, paramInt, paramBoolean, false);
  }
  
  private void a(FriendsManager paramFriendsManager, ArrayList<MessageRecord> paramArrayList, int paramInt, long paramLong, List<ChatMessage> paramList, Iterator<ChatMessage> paramIterator)
  {
    if (paramInt < 20) {
      while (paramIterator.hasNext())
      {
        paramFriendsManager = (ChatMessage)paramIterator.next();
        ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, paramFriendsManager.uniseq, false);
        paramIterator.remove();
      }
    }
    a(paramFriendsManager, paramArrayList, paramLong, paramIterator);
  }
  
  private void a(FriendsManager paramFriendsManager, ArrayList<MessageRecord> paramArrayList, long paramLong, Iterator<ChatMessage> paramIterator)
  {
    while (paramIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramIterator.next();
      if (localChatMessage.time >= paramLong)
      {
        ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, localChatMessage.uniseq, false);
        paramIterator.remove();
      }
      else if ((localChatMessage instanceof MessageForSystemMsg))
      {
        Object localObject1 = (MessageForSystemMsg)localChatMessage;
        if (((MessageForSystemMsg)localObject1).structMsg == null) {
          ((MessageForSystemMsg)localObject1).parse();
        }
        String str = ((MessageForSystemMsg)localObject1).senderuin;
        int i = ((MessageForSystemMsg)localObject1).structMsg.msg.sub_type.get();
        if ((i == 13) && (paramFriendsManager.b(str)))
        {
          ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, localChatMessage.uniseq, false);
          paramIterator.remove();
        }
        else if ((i == 1) || (i == 13))
        {
          localObject1 = paramArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((localObject2 instanceof MessageForSystemMsg))
            {
              int j = ((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get();
              localObject2 = ((MessageRecord)localObject2).senderuin;
              if ((j == i) && (localObject2 != null) && (((String)localObject2).equals(str)))
              {
                ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, localChatMessage.uniseq, false);
                paramIterator.remove();
              }
            }
          }
        }
      }
    }
  }
  
  private void a(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    for (;;)
    {
      try
      {
        if ((paramProtoReq.busiData != null) && ((paramProtoReq.busiData instanceof Integer)))
        {
          i = ((Integer)paramProtoReq.busiData).intValue();
          paramProtoReq = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
          structmsg.RspNextSystemMsg localRspNextSystemMsg = new structmsg.RspNextSystemMsg();
          localRspNextSystemMsg.mergeFrom((byte[])paramProtoResp.resp.getWupBuffer());
          if (localRspNextSystemMsg.head.result.get() != 0) {
            a(4006, false, null);
          }
          if (i == 3)
          {
            a(paramProtoReq, localRspNextSystemMsg);
            return;
          }
          b(paramProtoReq, localRspNextSystemMsg);
          return;
        }
      }
      catch (Exception paramProtoResp)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", paramProtoResp);
        }
        return;
      }
      int i = 0;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, FriendsManager paramFriendsManager, List<structmsg.StructMsg> paramList, int paramInt1, int paramInt2, INewFriendService paramINewFriendService, String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList(paramInt1);
    if (paramFromServiceMsg.getUin() == null) {
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    } else {
      paramFromServiceMsg = paramFromServiceMsg.getUin();
    }
    boolean bool1;
    if (paramInt2 > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i = 0;
    for (;;)
    {
      Object localObject1 = paramList;
      if (i >= paramInt1) {
        break;
      }
      MessageRecord localMessageRecord = MessageRecordFactory.a(-2050);
      localMessageRecord.msgtype = -2050;
      localMessageRecord.selfuin = paramFromServiceMsg;
      localMessageRecord.frienduin = AppConstants.FRIEND_SYSTEM_MSG_UIN;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((structmsg.StructMsg)((List)localObject1).get(i)).req_uin.get());
      ((StringBuilder)localObject2).append("");
      localMessageRecord.senderuin = ((StringBuilder)localObject2).toString();
      localMessageRecord.istroop = 0;
      localMessageRecord.time = ((structmsg.StructMsg)((List)localObject1).get(i)).msg_time.get();
      boolean bool2;
      if (((structmsg.StructMsg)((List)localObject1).get(i)).uint32_unread_flag.get() == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localMessageRecord.isread = bool2;
      localObject2 = (MessageForSystemMsg)localMessageRecord;
      ((MessageForSystemMsg)localObject2).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject1).get(i)).get());
      int j = ((MessageForSystemMsg)localObject2).structMsg.msg_type.get();
      int k = ((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("<---handleGetFriendSystemMsgResp|i = ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", isRead = ");
        ((StringBuilder)localObject1).append(localMessageRecord.isread);
        ((StringBuilder)localObject1).append(", time = ");
        ((StringBuilder)localObject1).append(localMessageRecord.time);
        ((StringBuilder)localObject1).append(", uin = ");
        ((StringBuilder)localObject1).append(localMessageRecord.senderuin);
        QLog.e("Q.systemmsg.", 2, ((StringBuilder)localObject1).toString());
      }
      if (i == 0)
      {
        localMessageRecord.extStr = paramString;
        if (k == 13) {
          bool1 = false;
        }
      }
      if ((j == 1) && (!SystemMsgUtils.a(k)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb filtered");
        }
      }
      else
      {
        localMessageRecord.msgData = ((MessageForSystemMsg)localObject2).structMsg.toByteArray();
        ((ChatMessage)localMessageRecord).parse();
        localArrayList.add(localObject2);
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      a(paramFriendsManager, paramInt2, paramINewFriendService, localArrayList, paramFromServiceMsg, bool1);
    } else {
      paramINewFriendService.loadNewFriendMsg(true);
    }
    paramINewFriendService.refreshNotificationWithFriendSystemMessage(new FriendSystemMessage(paramString, paramLong));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt1, String paramString, structmsg.RspSystemMsgNew paramRspSystemMsgNew, List<structmsg.StructMsg> paramList, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0) {
      return;
    }
    this.q = 0;
    int i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processNormalGroupSystemMsg, localUnreadCount");
      ((StringBuilder)localObject1).append(i);
      QLog.d("SystemMessageProcessor", 1, ((StringBuilder)localObject1).toString());
    }
    ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_seq", paramRspSystemMsgNew.latest_group_seq.get());
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt3);
    Object localObject1 = (ITroopNotificationService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopNotificationService.class, "");
    TroopNotificationEntryConfig localTroopNotificationEntryConfig = (TroopNotificationEntryConfig)QConfigManager.a().a(691);
    if ((localTroopNotificationEntryConfig != null) && (localTroopNotificationEntryConfig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) && (localObject1 != null)) {
      ((ITroopNotificationService)localObject1).notifyUnreadCountChanged(paramInt3);
    }
    i = paramInt3 - i;
    ((IConversationFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IConversationFacade.class, "")).increaseUnread(AppConstants.TROOP_NOTIFICATION_UIN, 9000, i);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("processNormalGroupSystemMsg, unreadCount - localUnreadCount");
      ((StringBuilder)localObject2).append(i);
      QLog.d("SystemMessageProcessor", 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = (TroopInfoManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    boolean bool;
    if (paramToServiceMsg.getServiceCmd().equals("ProfileService.Pb.ReqSystemMsgNew"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "CMD_GET_SYSTEM_MSG_BOTH");
      }
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).clearHistory(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, true, true);
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).clearHistory(AppConstants.TROOP_SYSTEM_RIBBON_MSG_UIN, 0, true, true);
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("following_group_seq", paramRspSystemMsgNew.following_group_seq.get());
      if (localObject1 != null)
      {
        ((ITroopNotificationService)localObject1).clearAllMsgCache();
        ((ITroopNotificationService)localObject1).setTroopNotificaitonGetAll(false);
      }
      GroupSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramToServiceMsg = (ITroopNotificationService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopNotificationService.class, "");
      if (paramToServiceMsg != null) {
        paramToServiceMsg.setTroopNotificaitonGetAll(false);
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    a(paramInt1, paramString, paramRspSystemMsgNew, paramList, paramInt2, paramInt3, (ITroopNotificationService)localObject1, localTroopNotificationEntryConfig, i, bool);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int i = paramToServiceMsg.extraData.getInt("type");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l3);
    if (paramToServiceMsg != null)
    {
      if ((paramFromServiceMsg.getResultCode() == 2901) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, "msf"))) {
        return;
      }
      if ((480000L == l4) || (paramToServiceMsg.a()))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleSendSystemMsgReadedReportError type=");
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(";reqSeq=");
          paramToServiceMsg.append(l3);
          paramToServiceMsg.append(";latestFriendSeq=");
          paramToServiceMsg.append(l1);
          paramToServiceMsg.append(";latestGroupSeq=");
          paramToServiceMsg.append(l2);
          QLog.d("SystemMessageProcessor", 2, paramToServiceMsg.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l3);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    structmsg.RspSystemMsgNew localRspSystemMsgNew = a((byte[])paramObject, paramRspSystemMsgNew);
    if ((localRspSystemMsgNew != null) && (localRspSystemMsgNew.head.result.get() == 0))
    {
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramObject = localRspSystemMsgNew.friendmsgs.get();
      int j = paramObject.size();
      int k = localRspSystemMsgNew.unread_friend_count.get();
      int i = localRspSystemMsgNew.uint32_un_read_count3.get();
      boolean bool;
      if (localRspSystemMsgNew.uint32_over.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setSysMsgOverValue(this.jdField_a_of_type_ComTencentCommonAppAppInterface, bool);
      INewFriendService localINewFriendService = (INewFriendService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendService.class, "");
      int m = localINewFriendService.getUnreadSystemMessageCount();
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setUnReadFriendSystemMsgNum(this.jdField_a_of_type_ComTencentCommonAppAppInterface, k);
      int n = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
      if (QLog.isColorLevel())
      {
        paramRspSystemMsgNew = new StringBuilder();
        paramRspSystemMsgNew.append("processFriendSystemMsg-->requestFrom:");
        paramRspSystemMsgNew.append(n);
        QLog.d("SystemMessageProcessor", 2, paramRspSystemMsgNew.toString());
        paramRspSystemMsgNew = new StringBuilder(128);
        paramRspSystemMsgNew.append("<---handleGetFriendSystemMsgResp : decode pb MsgsSize = ");
        paramRspSystemMsgNew.append(j);
        paramRspSystemMsgNew.append(" latest_friend_seq");
        paramRspSystemMsgNew.append(localRspSystemMsgNew.latest_friend_seq.get());
        paramRspSystemMsgNew.append(" latest_group_seq");
        paramRspSystemMsgNew.append(localRspSystemMsgNew.latest_group_seq.get());
        paramRspSystemMsgNew.append(" following_friend_seq");
        paramRspSystemMsgNew.append(localRspSystemMsgNew.following_friend_seq.get());
        paramRspSystemMsgNew.append(" following_group_seq");
        paramRspSystemMsgNew.append(localRspSystemMsgNew.following_group_seq.get());
        paramRspSystemMsgNew.append(" unreadCount");
        paramRspSystemMsgNew.append(k);
        paramRspSystemMsgNew.append(" localunreadCount");
        paramRspSystemMsgNew.append(m);
        paramRspSystemMsgNew.append(" isSysMsgOver");
        paramRspSystemMsgNew.append(bool);
        paramRspSystemMsgNew.append(" unreadCountForSuspicious");
        paramRspSystemMsgNew.append(i);
        QLog.d("Q.systemmsg.", 2, paramRspSystemMsgNew.toString());
      }
      if (a(j, k, n))
      {
        ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).clearHistory(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        localINewFriendService.reloadNewFriendMsg();
        a(4014, true, null);
        return;
      }
      String str = a(localRspSystemMsgNew);
      long l1 = 0L;
      if (paramObject.size() > 0)
      {
        paramRspSystemMsgNew = paramObject;
        l1 = ((structmsg.StructMsg)paramRspSystemMsgNew.get(0)).msg_time.get();
        a(paramToServiceMsg, localRspSystemMsgNew, paramRspSystemMsgNew);
      }
      this.q = 0;
      long l2 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_friend_seq_47");
      long l3 = localRspSystemMsgNew.latest_friend_seq.get();
      if (l2 == l3)
      {
        a(k, localINewFriendService, m, str, l1);
        return;
      }
      if ((k == 0) && (j == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_friend_seq_47", localRspSystemMsgNew.latest_friend_seq.get());
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("following_friend_seq_47", localRspSystemMsgNew.following_friend_seq.get());
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setHasNoMoreMsg(false, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (i == 0)
      {
        a(paramFromServiceMsg, localFriendsManager, paramObject, j, k, localINewFriendService, str, l1);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("<---handleGetFriendSystemMsgResp : clear local data. sentSeq:");
          paramToServiceMsg.append(l2);
          paramToServiceMsg.append(" respSeq:");
          paramToServiceMsg.append(l3);
          QLog.e("Q.systemmsg.", 2, paramToServiceMsg.toString());
        }
        ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).clearHistory(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        localINewFriendService.reloadNewFriendMsg();
      }
      a(4005, true, null);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("rspSystemMsg.head.result.get()");
      paramObject.append(localRspSystemMsgNew.head.result.get());
      QLog.e("SystemMessageProcessor", 2, paramObject.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, structmsg.RspSystemMsgNew paramRspSystemMsgNew, List<structmsg.StructMsg> paramList)
  {
    structmsg.SystemMsg localSystemMsg = ((structmsg.StructMsg)paramList.get(0)).msg;
    if ((localSystemMsg != null) && (localSystemMsg.has()))
    {
      if ((localSystemMsg.bytes_game_nick.has()) && (((structmsg.StructMsg)paramList.get(0)).req_uin.has()))
      {
        String str = localSystemMsg.bytes_game_nick.get().toStringUtf8();
        long l = ((structmsg.StructMsg)paramList.get(0)).req_uin.get();
        KplHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(l), str);
      }
      if (localSystemMsg.bytes_game_msg.has())
      {
        paramList = localSystemMsg.bytes_game_msg.get().toStringUtf8();
        KplHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramList);
      }
      if (paramRspSystemMsgNew.bytes_game_nick.has()) {
        KplHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramToServiceMsg.getUin(), paramRspSystemMsgNew.bytes_game_nick.get());
      }
    }
  }
  
  private void a(String paramString, TroopManager paramTroopManager)
  {
    if (paramTroopManager.b(paramString) == null)
    {
      TroopInfo localTroopInfo = new TroopInfo();
      localTroopInfo.troopuin = paramString;
      paramTroopManager.a(localTroopInfo);
      if (QLog.isColorLevel())
      {
        paramTroopManager = new StringBuilder();
        paramTroopManager.append("processGroupSystemMsg--> add troop : ");
        paramTroopManager.append(paramString);
        QLog.d("SystemMessageProcessor", 2, paramTroopManager.toString());
      }
      paramTroopManager = (ITroopMngHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
      ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
      ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
      localITroopInfoHandler.a(localTroopInfo.troopuin, false, "SystemMessageProcessor.AgreeGroupInvation", true, true, true, false);
      localITroopMemberListHandler.a(1, TroopFileHandler.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
      ((ITroopMemberLevelHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LEVEL_HANDLER)).a(paramString);
      paramTroopManager.a(TroopMngObserver.h, true, new Object[] { paramString });
    }
  }
  
  private void a(String paramString, structmsg.RspNextSystemMsg paramRspNextSystemMsg)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (paramRspNextSystemMsg != null) && (!TextUtils.isEmpty(paramString))) {
      TroopSuspiciousHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramRspNextSystemMsg, paramString);
    }
  }
  
  private void a(String paramString, structmsg.RspNextSystemMsg paramRspNextSystemMsg, ArrayList<MessageRecord> paramArrayList)
  {
    paramString = (ITroopNotificationService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopNotificationService.class, "");
    if (paramArrayList.size() > 0)
    {
      if (paramArrayList.size() < 100)
      {
        GroupSystemMsgController.a().a(true, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        if (paramString != null) {
          paramString.setTroopNotificaitonGetAll(true);
        }
      }
      long l2 = paramRspNextSystemMsg.following_group_seq.get();
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("following_group_seq");
      }
      if (QLog.isColorLevel())
      {
        paramRspNextSystemMsg = new StringBuilder();
        paramRspNextSystemMsg.append("<---sendGetNextGroupSystemMsg : decode pb following_group_seq");
        paramRspNextSystemMsg.append(l1);
        QLog.e("Q.systemmsg.", 2, paramRspNextSystemMsg.toString());
      }
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("following_group_seq", l1);
      int i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (paramString != null) {
        paramString.addMessageRecord(paramArrayList, i);
      }
      a("handleGetSystemMsgResp", true, paramArrayList.size(), false, false);
      a(4005, true, paramArrayList);
      return;
    }
    GroupSystemMsgController.a().a(true, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (paramString != null) {
      paramString.setTroopNotificaitonGetAll(true);
    }
  }
  
  private void a(String paramString, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if ((paramRspSystemMsgNew.msg_ribbon_group.has()) && (paramRspSystemMsgNew.msg_ribbon_group.get() != null))
    {
      Object localObject1 = (structmsg.StructMsg)paramRspSystemMsgNew.msg_ribbon_group.get();
      paramRspSystemMsgNew = MessageRecordFactory.a(-2018);
      paramRspSystemMsgNew.selfuin = paramString;
      paramRspSystemMsgNew.frienduin = AppConstants.TROOP_SYSTEM_RIBBON_MSG_UIN;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((structmsg.StructMsg)localObject1).req_uin.get());
      ((StringBuilder)localObject2).append("");
      paramRspSystemMsgNew.senderuin = ((StringBuilder)localObject2).toString();
      paramRspSystemMsgNew.istroop = 0;
      localObject2 = (MessageForSystemMsg)paramRspSystemMsgNew;
      ((MessageForSystemMsg)localObject2).structMsg = ((structmsg.StructMsg)localObject1);
      paramRspSystemMsgNew.msgData = ((MessageForSystemMsg)localObject2).structMsg.toByteArray();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramRspSystemMsgNew);
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).addMessage((ArrayList)localObject1, String.valueOf(paramString), true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "ribbon info");
      }
    }
  }
  
  private void a(String paramString, structmsg.RspSystemMsgNew paramRspSystemMsgNew, int paramInt, ITroopNotificationService paramITroopNotificationService, boolean paramBoolean, ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList.size() > 0)
    {
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).clearHistory(AppConstants.TROOP_SYSTEM_RIBBON_MSG_UIN, 0, true, true);
      if (paramITroopNotificationService != null) {
        paramITroopNotificationService.addMessageRecord(paramArrayList, paramInt);
      }
      a("handleGetSystemMsgResp", true, paramInt, paramBoolean, false);
      if (!TextUtils.isEmpty(paramRspSystemMsgNew.grp_msg_display.get())) {
        GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramRspSystemMsgNew.grp_msg_display.get());
      }
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    String str = "";
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)((AppInterface)localObject1).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
    localRecentUser.msgType = 25;
    localRecentUser.displayName = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getNewFriendTag();
    Object localObject2 = (MessageForSystemMsg)paramList.get(0);
    ((MessageForSystemMsg)localObject2).parse();
    if (!TextUtils.isEmpty(((MessageForSystemMsg)localObject2).extStr))
    {
      localObject1 = ((MessageForSystemMsg)localObject2).extStr;
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((MessageForSystemMsg)localObject2).structMsg.msg.req_uin_nick.get());
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(((MessageForSystemMsg)localObject2).structMsg.msg.msg_describe.get());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localRecentUser.lastmsgtime = ((MessageForSystemMsg)localObject2).time;
    localRecentUser.msgData = ((String)localObject1).getBytes();
    localRecentUser.msg = localObject1;
    localRecentUser.reParse();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mDataList.size() ");
      ((StringBuilder)localObject2).append(paramList.size());
      ((StringBuilder)localObject2).append(" | msg = ");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = str;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("SystemMessageProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    localRecentUserProxy.b(localRecentUser);
  }
  
  private void a(structmsg.RspSystemMsgNew paramRspSystemMsgNew, List<structmsg.StructMsg> paramList, int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (paramRspSystemMsgNew != null) && (paramList != null) && (!TextUtils.isEmpty(paramString))) {
      TroopSuspiciousHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramRspSystemMsgNew, paramList, paramInt, paramString);
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStructMsg.msg.group_code.get());
    localStringBuilder.append("");
    paramStructMsg = localTroopManager.b(localStringBuilder.toString());
    if (paramStructMsg != null)
    {
      paramStructMsg.dwCmdUinUinFlag = 0L;
      localTroopManager.b(paramStructMsg);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt2 == 0) && (paramInt1 == 0) && (paramInt3 == 2);
  }
  
  private boolean a(int paramInt, long paramLong)
  {
    return (paramInt != 0) && (paramLong == 0L);
  }
  
  @Nullable
  private structmsg.RspSystemMsgNew b(byte[] paramArrayOfByte, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (paramRspSystemMsgNew != null) {
      return paramRspSystemMsgNew;
    }
    paramRspSystemMsgNew = null;
    try
    {
      structmsg.RspSystemMsgNew localRspSystemMsgNew = new structmsg.RspSystemMsgNew();
      try
      {
        localRspSystemMsgNew.mergeFrom(paramArrayOfByte);
        return localRspSystemMsgNew;
      }
      catch (Exception paramRspSystemMsgNew)
      {
        paramArrayOfByte = localRspSystemMsgNew;
      }
      if (!QLog.isColorLevel()) {
        return paramArrayOfByte;
      }
    }
    catch (Exception localException)
    {
      paramArrayOfByte = paramRspSystemMsgNew;
      paramRspSystemMsgNew = localException;
    }
    QLog.e("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb error:", paramRspSystemMsgNew);
    return paramArrayOfByte;
  }
  
  private void b(int paramInt1, int paramInt2, structmsg.StructMsg paramStructMsg, int paramInt3, MessageForSystemMsg paramMessageForSystemMsg, int paramInt4, boolean[] paramArrayOfBoolean)
  {
    long l;
    if ((paramInt3 == 2) && (paramInt4 == 2))
    {
      l = paramStructMsg.msg.group_code.get();
      if (paramMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.has()) {
        paramStructMsg = (structmsg.MsgInviteExt)paramMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.get();
      } else {
        paramStructMsg = null;
      }
      if (paramStructMsg != null) {
        paramInt1 = paramStructMsg.uint32_wait_state.get();
      } else {
        paramInt1 = -1;
      }
      if ((paramInt1 == 2) || (paramInt1 == 4)) {
        UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageForSystemMsg, paramStructMsg, String.valueOf(l));
      }
      if (paramInt1 == 4) {
        paramArrayOfBoolean[0] = false;
      }
    }
    else if ((paramInt3 != 8) && (paramInt3 != 7))
    {
      if ((paramInt3 == 13) || (paramInt3 == 6))
      {
        paramMessageForSystemMsg = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if ((paramMessageForSystemMsg != null) && (!paramMessageForSystemMsg.a(paramStructMsg.msg.group_code.get(), paramStructMsg.msg_time.get())))
        {
          if (QLog.isColorLevel())
          {
            paramArrayOfBoolean = new StringBuilder();
            paramArrayOfBoolean.append("processGroupSystemMsg-->msgPos:");
            paramArrayOfBoolean.append(paramInt2);
            paramArrayOfBoolean.append(",msgTime:");
            paramArrayOfBoolean.append(paramStructMsg.msg_time);
            paramArrayOfBoolean.append(",msgType:");
            paramArrayOfBoolean.append(paramInt3);
            paramArrayOfBoolean.append(":delete troopMember, delete troop, clear local history");
            QLog.d("SystemMessageProcessor", 2, paramArrayOfBoolean.toString());
          }
          paramArrayOfBoolean = new StringBuilder();
          paramArrayOfBoolean.append(paramStructMsg.msg.group_code.get());
          paramArrayOfBoolean.append("");
          paramArrayOfBoolean = paramArrayOfBoolean.toString();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramStructMsg.req_uin.get());
          ((StringBuilder)localObject).append("");
          localObject = ((StringBuilder)localObject).toString();
          ITroopOnlinePushHandler localITroopOnlinePushHandler = (ITroopOnlinePushHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER);
          if (localITroopOnlinePushHandler != null) {
            localITroopOnlinePushHandler.a(paramArrayOfBoolean, (String)localObject, true);
          }
          paramMessageForSystemMsg.a(paramStructMsg.msg.group_code.get(), paramStructMsg.msg_time.get());
        }
      }
    }
    else
    {
      l = paramStructMsg.msg.group_code.get();
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, String.format("handlePassiveExit offline troopUin: %s, msgType: %s, i: %s, unreadCount: %s", new Object[] { String.valueOf(l), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
      }
      if (paramInt2 < paramInt1)
      {
        paramMessageForSystemMsg = (ITroopPushHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_PUSH_HANDLER);
        if (paramMessageForSystemMsg != null)
        {
          if (paramInt3 == 8) {
            paramInt1 = 2;
          } else {
            paramInt1 = 1;
          }
          paramMessageForSystemMsg.a(String.valueOf(paramStructMsg.msg.group_code.get()), paramInt3, paramStructMsg.msg_time.get(), paramInt1);
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SystemMessageProcessor", 4, "processGroupSystemMsg");
    }
    paramObject = b((byte[])paramObject, paramRspSystemMsgNew);
    paramRspSystemMsgNew = new StringBuilder();
    if ((paramObject != null) && (paramObject.head.result.get() == 0))
    {
      paramRspSystemMsgNew = paramObject.groupmsgs.get();
      int j = a(paramRspSystemMsgNew, paramRspSystemMsgNew.size(), paramObject.unread_group_count.get());
      int i = paramRspSystemMsgNew.size();
      j = Math.max(j, 0);
      if (paramFromServiceMsg.getUin() == null) {
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      } else {
        paramFromServiceMsg = paramFromServiceMsg.getUin();
      }
      int k = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
      if (k == 3) {
        a(paramObject, paramRspSystemMsgNew, j, paramFromServiceMsg);
      } else {
        a(paramToServiceMsg, k, paramFromServiceMsg, paramObject, paramRspSystemMsgNew, i, j);
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("<---handleGetGroupSystemMsgResp : decode pb groupMsgsSize = ");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append(" latest_friend_seq");
        paramToServiceMsg.append(paramObject.latest_friend_seq.get());
        paramToServiceMsg.append(" latest_group_seq");
        paramToServiceMsg.append(paramObject.latest_group_seq.get());
        paramToServiceMsg.append(" following_friend_seq");
        paramToServiceMsg.append(paramObject.following_friend_seq.get());
        paramToServiceMsg.append(" following_group_seq");
        paramToServiceMsg.append(paramObject.following_group_seq.get());
        paramToServiceMsg.append(" uint32_has_suspicious_flag = ");
        paramToServiceMsg.append(paramObject.uint32_has_suspicious_flag.get());
        paramToServiceMsg.append(" unreadCount");
        paramToServiceMsg.append(j);
        paramToServiceMsg.append(" requestFrom = ");
        paramToServiceMsg.append(k);
        QLog.d("SystemMessageProcessor", 2, paramToServiceMsg.toString());
      }
      return;
    }
    paramRspSystemMsgNew.setLength(0);
    if (QLog.isColorLevel()) {
      QLog.e("SystemMessageProcessor", 2, paramRspSystemMsgNew.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void b(String paramString, structmsg.RspNextSystemMsg paramRspNextSystemMsg)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramRspNextSystemMsg.msgs.get();
    int j = localList.size();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<---handleGetNextNormalGroupSystemMsgSucc Resp : decode pb size = ");
      ((StringBuilder)localObject1).append(j);
      QLog.e("Q.systemmsg.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashSet();
    int i = 0;
    while (i < j)
    {
      Object localObject3 = (structmsg.StructMsg)((structmsg.StructMsg)localList.get(i)).get();
      if ((localObject3 == null) || (!((structmsg.StructMsg)localObject3).msg_seq.has()) || (!((Set)localObject1).contains(Long.valueOf(((structmsg.StructMsg)localObject3).msg_seq.get()))))
      {
        Object localObject2 = MessageRecordFactory.a(-2018);
        ((MessageRecord)localObject2).msgtype = -2018;
        ((MessageRecord)localObject2).selfuin = paramString;
        ((MessageRecord)localObject2).frienduin = AppConstants.TROOP_SYSTEM_MSG_UIN;
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((structmsg.StructMsg)localList.get(i)).req_uin.get());
        ((StringBuilder)localObject4).append("");
        ((MessageRecord)localObject2).senderuin = ((StringBuilder)localObject4).toString();
        ((MessageRecord)localObject2).istroop = 0;
        localObject4 = (MessageForSystemMsg)localObject2;
        ((MessageForSystemMsg)localObject4).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)localList.get(i)).get());
        ((MessageRecord)localObject2).msgData = ((MessageForSystemMsg)localObject4).structMsg.toByteArray();
        localArrayList.add(localObject4);
        if ((localObject3 != null) && (((structmsg.StructMsg)localObject3).msg_seq.has())) {
          ((Set)localObject1).add(Long.valueOf(((structmsg.StructMsg)localObject3).msg_seq.get()));
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(" type:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject2).msgtype);
          ((StringBuilder)localObject3).append(" selfuin:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject2).selfuin);
          ((StringBuilder)localObject3).append(" frienduin:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject2).frienduin);
          ((StringBuilder)localObject3).append(" senderuin:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject2).senderuin);
          ((StringBuilder)localObject3).append(" istroop:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject2).istroop);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleGetNextNormalGroupSystemMsgSucc-->");
          ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
          QLog.d("SystemMessageProcessor", 2, ((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
    a(paramString, paramRspNextSystemMsg, localArrayList);
    h();
  }
  
  private void b(List<structmsg.StructMsg> paramList)
  {
    Collections.sort(paramList, new SystemMessageProcessor.1(this));
  }
  
  private void b(structmsg.StructMsg paramStructMsg)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStructMsg.msg.group_code.get());
    localStringBuilder.append("");
    paramStructMsg = localTroopManager.b(localStringBuilder.toString());
    if (paramStructMsg != null)
    {
      paramStructMsg.dwCmdUinUinFlag = 1L;
      localTroopManager.b(paramStructMsg);
    }
  }
  
  private void c(structmsg.StructMsg paramStructMsg)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramStructMsg.msg.group_code.get());
    ((StringBuilder)localObject).append("");
    paramStructMsg = localTroopManager.b(((StringBuilder)localObject).toString());
    if (paramStructMsg != null)
    {
      paramStructMsg.dwCmdUinUinFlag = 0L;
      if (paramStructMsg.Administrator != null)
      {
        if (paramStructMsg.Administrator.startsWith("|")) {
          paramStructMsg.Administrator = paramStructMsg.Administrator.substring(1);
        }
        if (paramStructMsg.Administrator.endsWith("|")) {
          paramStructMsg.Administrator = paramStructMsg.Administrator.substring(0, paramStructMsg.Administrator.length() - 1);
        }
      }
      else
      {
        paramStructMsg.Administrator = "";
      }
      localObject = paramStructMsg.Administrator;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      localStringBuilder.append("|");
      localObject = ((String)localObject).replace(localStringBuilder.toString(), "");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("|");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      paramStructMsg.Administrator = ((String)localObject).replace(localStringBuilder.toString(), "").replace(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "");
      localTroopManager.b(paramStructMsg);
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getUin() == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    } else {
      paramFromServiceMsg.getUin();
    }
    Object localObject2;
    try
    {
      localObject1 = new structmsg.RspSystemMsgNew();
      try
      {
        ((structmsg.RspSystemMsgNew)localObject1).mergeFrom((byte[])paramObject);
        localObject2 = localObject1;
      }
      catch (Exception localException1) {}
      localObject2 = localObject1;
    }
    catch (Exception localException2)
    {
      localObject1 = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("SystemMessageProcessor", 2, "<---handleGetSystemMsgRespNew : decode pb error:", localException2);
      localObject2 = localObject1;
    }
    Object localObject1 = new StringBuilder();
    if ((localObject2 != null) && (localObject2.head.result.get() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, "SystemMessageProcessor: listsize");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject, localObject2);
      b(paramToServiceMsg, paramFromServiceMsg, paramObject, localObject2);
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("processSystemMsg error ");
    paramObject.append(localObject2.head.result.get());
    ((StringBuilder)localObject1).append(paramObject.toString());
    if (QLog.isColorLevel()) {
      QLog.e("SystemMessageProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void d(structmsg.StructMsg paramStructMsg)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStructMsg.msg.group_code.get());
    localStringBuilder.append("");
    paramStructMsg = ((TroopManager)localObject).b(localStringBuilder.toString());
    if (paramStructMsg != null)
    {
      paramStructMsg.dwCmdUinUinFlag = 1L;
      if (paramStructMsg.Administrator != null)
      {
        if (paramStructMsg.Administrator.startsWith("|")) {
          paramStructMsg.Administrator = paramStructMsg.Administrator.substring(1);
        }
        if (paramStructMsg.Administrator.endsWith("|")) {
          paramStructMsg.Administrator = paramStructMsg.Administrator.substring(0, paramStructMsg.Administrator.length() - 1);
        }
      }
      else
      {
        paramStructMsg.Administrator = "";
      }
      if (!paramStructMsg.Administrator.contains(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramStructMsg.Administrator);
        localStringBuilder.append("|");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        paramStructMsg.Administrator = localStringBuilder.toString();
      }
      ((TroopManager)localObject).b(paramStructMsg);
      localObject = (ITroopAppHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER);
      if (localObject != null) {
        ((ITroopAppHandler)localObject).b(Long.parseLong(paramStructMsg.troopuin));
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int i = paramToServiceMsg.extraData.getInt("type");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l3) == null) {
      return;
    }
    if (paramObject != null)
    {
      paramToServiceMsg = new structmsg.RspSystemMsgRead();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("<---handleSendSystemMsgReadedReport :type = ");
          paramObject.append(i);
          paramObject.append(" decode pb:");
          QLog.e("SystemMessageProcessor", 2, paramObject.toString(), paramFromServiceMsg);
        }
      }
      int j = paramToServiceMsg.head.result.get();
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l3);
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleSendSystemMsgReadedReport type =");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append(";reqSeq=");
        paramToServiceMsg.append(l3);
        paramToServiceMsg.append(";resultCode=");
        paramToServiceMsg.append(j);
        paramToServiceMsg.append(";latestFriendSeq=");
        paramToServiceMsg.append(l1);
        paramToServiceMsg.append(";latestGroupSeq=");
        paramToServiceMsg.append(l2);
        QLog.d("SystemMessageProcessor", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  private void e(structmsg.StructMsg paramStructMsg)
  {
    if (paramStructMsg.msg.has())
    {
      int i;
      if (((structmsg.SystemMsg)paramStructMsg.msg.get()).group_msg_type.has()) {
        i = ((structmsg.SystemMsg)paramStructMsg.msg.get()).group_msg_type.get();
      } else {
        i = -1;
      }
      long l1;
      if (((structmsg.SystemMsg)paramStructMsg.msg.get()).group_code.has()) {
        l1 = ((structmsg.SystemMsg)paramStructMsg.msg.get()).group_code.get();
      } else {
        l1 = -1L;
      }
      long l2;
      if (paramStructMsg.req_uin.has()) {
        l2 = paramStructMsg.req_uin.get();
      } else {
        l2 = -1L;
      }
      if ((i != -1) && (l2 != -1L) && (l1 != -1L)) {
        a(i, l1, l2);
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getUin() == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    } else {
      paramFromServiceMsg.getUin();
    }
    boolean bool1 = false;
    boolean bool2 = false;
    try
    {
      paramFromServiceMsg = new structmsg.RspSystemMsgAction();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = paramFromServiceMsg;
      }
      catch (Exception localException1) {}
      paramObject = paramFromServiceMsg;
    }
    catch (Exception localException2)
    {
      paramFromServiceMsg = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgAction : decode pb:", localException2);
      paramObject = paramFromServiceMsg;
    }
    if (paramObject != null)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSendSystemMsgAction result id=");
        paramFromServiceMsg.append(paramObject.head.result.get());
        QLog.d("SystemMessageProcessor", 2, paramFromServiceMsg.toString());
      }
      if (paramObject.head.result.get() == 0)
      {
        bool1 = true;
      }
      else
      {
        str = paramObject.head.msg_fail.get();
        paramFromServiceMsg = str;
        if (str == null) {
          paramFromServiceMsg = "";
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramFromServiceMsg);
        bool1 = bool2;
      }
      String str = paramObject.msg_detail.get();
      paramFromServiceMsg = str;
      if (str == null) {
        paramFromServiceMsg = "";
      }
      int i = -1;
      if (paramObject.remark_result.has()) {
        i = paramObject.remark_result.get();
      }
      paramToServiceMsg.extraData.putString("system_msg_action_resp_key", paramFromServiceMsg);
      paramToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", paramObject.head.result.get());
      paramToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", paramObject.type.get());
      paramToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", paramObject.msg_invalid_decided.get());
      paramToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
    }
    a(4011, bool1, paramToServiceMsg);
  }
  
  private void h()
  {
    TroopNotificationConfig localTroopNotificationConfig = (TroopNotificationConfig)QConfigManager.a().a(634);
    if (localTroopNotificationConfig != null)
    {
      ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopNotificationService.class, "");
      int i = localTroopNotificationConfig.d;
      List localList = ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getAllMessages(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null);
      if ((localITroopNotificationService != null) && (!localITroopNotificationService.isTroopNotificaitonGetAll()) && (localList != null) && (localList.size() < i) && (localTroopNotificationConfig.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "Auto Get Msg Continue");
        }
        c(0);
      }
    }
  }
  
  private void i()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    long l1 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_friend_seq_47");
    long l2 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l1);
    localReqSystemMsgRead.latest_group_seq.set(l2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendSystemMsgReadedReport latestFriendSeq=");
      localStringBuilder.append(l1);
      localStringBuilder.append(";latestGroupSeq=");
      localStringBuilder.append(l2);
      QLog.d("SystemMessageProcessor", 2, localStringBuilder.toString());
    }
    a(true, true, false, 0L, new SystemMessageProcessor.3(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 4;
    Object localObject1 = "ProfileService.Pb.ReqSystemMsgNew";
    structmsg.FlagInfo localFlagInfo;
    if (paramInt1 != 2)
    {
      if (paramInt1 != 3)
      {
        if (paramInt1 != 4)
        {
          localFlagInfo = null;
          i = 0;
        }
        else
        {
          localFlagInfo = new structmsg.FlagInfo();
          localFlagInfo.GrpMsg_Kick_Admin.set(1);
          localFlagInfo.GrpMsg_HiddenGrp.set(1);
          localFlagInfo.GrpMsg_WordingDown.set(1);
          localFlagInfo.GrpMsg_GetOfficialAccount.set(1);
          localFlagInfo.GrpMsg_GetPayInGroup.set(1);
          localFlagInfo.FrdMsg_Discuss2ManyChat.set(1);
          localFlagInfo.FrdMsg_GetBusiCard.set(1);
          localFlagInfo.FrdMsg_NeedWaitingMsg.set(1);
          localFlagInfo.GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
          localFlagInfo.FrdMsg_uint32_need_all_unread_msg.set(1);
          localFlagInfo.GrpMsg_get_transfer_group_msg_flag.set(1);
          localFlagInfo.GrpMsg_NeedAutoAdminWording.set(1);
          localFlagInfo.GrpMsg_get_quit_pay_group_msg_flag.set(1);
          localFlagInfo.GrpMsg_support_invite_auto_join.set(1);
          localFlagInfo.GrpMsg_mask_invite_auto_join.set(1);
          localFlagInfo.GrpMsg_GetDisbandedByAdmin.set(1);
          localFlagInfo.GrpMsg_GetC2cInviteJoinGroup.set(1);
          localObject2 = (TroopInfoManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
        }
      }
      else
      {
        localFlagInfo = new structmsg.FlagInfo();
        localFlagInfo.GrpMsg_Kick_Admin.set(1);
        localFlagInfo.GrpMsg_HiddenGrp.set(1);
        localFlagInfo.GrpMsg_WordingDown.set(1);
        localFlagInfo.GrpMsg_GetOfficialAccount.set(1);
        localFlagInfo.GrpMsg_GetPayInGroup.set(1);
        localFlagInfo.FrdMsg_Discuss2ManyChat.set(1);
        localFlagInfo.FrdMsg_NeedWaitingMsg.set(1);
        localFlagInfo.GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
        localFlagInfo.GrpMsg_get_transfer_group_msg_flag.set(1);
        localFlagInfo.GrpMsg_NeedAutoAdminWording.set(1);
        localFlagInfo.GrpMsg_get_quit_pay_group_msg_flag.set(1);
        localFlagInfo.GrpMsg_support_invite_auto_join.set(1);
        localFlagInfo.GrpMsg_mask_invite_auto_join.set(1);
        localFlagInfo.GrpMsg_GetDisbandedByAdmin.set(1);
        localFlagInfo.GrpMsg_GetC2cInviteJoinGroup.set(1);
        localObject1 = "ProfileService.Pb.ReqSystemMsgNew.Group";
        i = 3;
      }
    }
    else
    {
      localFlagInfo = new structmsg.FlagInfo();
      localFlagInfo.FrdMsg_GetBusiCard.set(1);
      localFlagInfo.FrdMsg_Discuss2ManyChat.set(1);
      localFlagInfo.FrdMsg_NeedWaitingMsg.set(1);
      localFlagInfo.FrdMsg_uint32_need_all_unread_msg.set(1);
      localFlagInfo.GrpMsg_GetC2cInviteJoinGroup.set(1);
      localObject1 = "ProfileService.Pb.ReqSystemMsgNew.Friend";
      i = 2;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<---sendGetSystemMsg type=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" latest_friend_seq = ");
      ((StringBuilder)localObject2).append(((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_friend_seq_47"));
      ((StringBuilder)localObject2).append(" latest_group_seq = ");
      ((StringBuilder)localObject2).append(((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_seq"));
      ((StringBuilder)localObject2).append(" last_group_suspicious_seq = ");
      ((StringBuilder)localObject2).append(((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_suspicious_seq"));
      QLog.w("Q.systemmsg.", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg((String)localObject1);
    Object localObject2 = new structmsg.ReqSystemMsgNew();
    ((structmsg.ReqSystemMsgNew)localObject2).msg_num.set(20);
    ((structmsg.ReqSystemMsgNew)localObject2).checktype.set(i);
    PBUInt64Field localPBUInt64Field = ((structmsg.ReqSystemMsgNew)localObject2).latest_friend_seq;
    long l;
    if (paramBoolean) {
      l = 0L;
    } else {
      l = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_friend_seq_47");
    }
    localPBUInt64Field.set(l);
    if (paramInt2 == 3)
    {
      localPBUInt64Field = ((structmsg.ReqSystemMsgNew)localObject2).latest_group_seq;
      if (paramBoolean) {
        l = 0L;
      } else {
        l = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_suspicious_seq");
      }
      localPBUInt64Field.set(l);
    }
    else
    {
      localPBUInt64Field = ((structmsg.ReqSystemMsgNew)localObject2).latest_group_seq;
      if (paramBoolean) {
        l = 0L;
      } else {
        l = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_seq");
      }
      localPBUInt64Field.set(l);
    }
    if (localFlagInfo != null) {
      ((structmsg.ReqSystemMsgNew)localObject2).flag.set(localFlagInfo);
    }
    ((structmsg.ReqSystemMsgNew)localObject2).is_get_frd_ribbon.set(false);
    ((structmsg.ReqSystemMsgNew)localObject2).version.set(1000);
    ((structmsg.ReqSystemMsgNew)localObject2).is_get_grp_ribbon.set(false);
    ((structmsg.ReqSystemMsgNew)localObject2).friend_msg_type_flag.set(1L);
    if (paramInt2 == 3) {
      ((structmsg.ReqSystemMsgNew)localObject2).uint32_req_msg_type.set(2);
    } else {
      ((structmsg.ReqSystemMsgNew)localObject2).uint32_req_msg_type.set(1);
    }
    ((ToServiceMsg)localObject1).extraData.putInt("getSystemMsgSender", paramInt2);
    ((ToServiceMsg)localObject1).putWupBuffer(((structmsg.ReqSystemMsgNew)localObject2).toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6)
  {
    a(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4, paramInt5, paramSystemMsgActionInfo, paramInt6, "");
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append(paramLong1);
    paramString.append("_");
    paramString.append(paramInt1);
    paramString = paramString.toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendFriendSystemMsgAction logStr=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.systemmsg.", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new structmsg.ReqSystemMsgAction();
    ((structmsg.ReqSystemMsgAction)localObject).msg_type.set(paramInt1);
    ((structmsg.ReqSystemMsgAction)localObject).msg_seq.set(paramLong1);
    ((structmsg.ReqSystemMsgAction)localObject).req_uin.set(paramLong2);
    ((structmsg.ReqSystemMsgAction)localObject).sub_type.set(paramInt2);
    ((structmsg.ReqSystemMsgAction)localObject).src_id.set(paramInt3);
    ((structmsg.ReqSystemMsgAction)localObject).sub_src_id.set(paramInt4);
    ((structmsg.ReqSystemMsgAction)localObject).group_msg_type.set(paramInt5);
    ((structmsg.ReqSystemMsgAction)localObject).action_info.set(paramSystemMsgActionInfo);
    ((structmsg.ReqSystemMsgAction)localObject).language.set(1000);
    paramSystemMsgActionInfo = new ProtoReqManagerImpl.ProtoReq();
    paramSystemMsgActionInfo.setEasyRetryMode();
    paramSystemMsgActionInfo.ssoCmd = "ProfileService.Pb.ReqSystemMsgAction.Group";
    paramSystemMsgActionInfo.reqBody = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Group");
    ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
    paramSystemMsgActionInfo.busiData = localObject;
    paramSystemMsgActionInfo.callback = new SystemMessageProcessor.11(this);
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(paramSystemMsgActionInfo);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    long l = paramInt1 + paramLong1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendFriendSystemMsgAction logStr=");
      ((StringBuilder)localObject1).append(l);
      QLog.d("Q.systemmsg.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new structmsg.ReqSystemMsgAction();
    ((structmsg.ReqSystemMsgAction)localObject2).msg_type.set(paramInt1);
    ((structmsg.ReqSystemMsgAction)localObject2).msg_seq.set(paramLong1);
    ((structmsg.ReqSystemMsgAction)localObject2).req_uin.set(paramLong2);
    ((structmsg.ReqSystemMsgAction)localObject2).sub_type.set(paramInt2);
    ((structmsg.ReqSystemMsgAction)localObject2).src_id.set(paramInt3);
    ((structmsg.ReqSystemMsgAction)localObject2).sub_src_id.set(paramInt4);
    ((structmsg.ReqSystemMsgAction)localObject2).group_msg_type.set(paramInt5);
    ((structmsg.ReqSystemMsgAction)localObject2).action_info.set(paramSystemMsgActionInfo);
    Object localObject1 = new ProtoReqManagerImpl.ProtoReq();
    ((ProtoReqManagerImpl.ProtoReq)localObject1).setEasyRetryMode();
    ((ProtoReqManagerImpl.ProtoReq)localObject1).ssoCmd = "ProfileService.Pb.ReqSystemMsgAction.Friend";
    ((ProtoReqManagerImpl.ProtoReq)localObject1).reqBody = ((structmsg.ReqSystemMsgAction)localObject2).toByteArray();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Friend");
    ((ToServiceMsg)localObject2).addAttribute("_tag_LOGSTR", String.valueOf(l));
    ((ToServiceMsg)localObject2).extraData.putInt("system_msg_action_type", paramInt6);
    ((ToServiceMsg)localObject2).extraData.putBoolean("isUncommonlyUsedFrd", paramBoolean);
    ((ProtoReqManagerImpl.ProtoReq)localObject1).busiData = localObject2;
    ((ProtoReqManagerImpl.ProtoReq)localObject1).callback = new SystemMessageProcessor.2(this, paramInt6, paramInt3, paramSystemMsgActionInfo, paramStructMsg, paramLong2);
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq((ProtoReqManagerImpl.ProtoReq)localObject1);
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    case 6004: 
    case 6005: 
    case 6007: 
    default: 
      return;
    case 6009: 
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "handleGetDelAllSysMsg Error!");
      }
      b(8039, false, new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    case 6008: 
      b(4015, false, paramToServiceMsg);
      return;
    case 6006: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 6003: 
      this.s = 0;
      return;
    case 6002: 
      this.q = 0;
      return;
    }
    this.r = 0;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, long paramLong1, long paramLong2, msg_comm.MsgHead paramMsgHead)
  {
    if ((paramInt == 85) || (paramInt == 36))
    {
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramArrayOfByte, paramLong1, paramLong2, paramMsgHead);
      b(2001, true, null);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 6004: 
    case 6005: 
    default: 
      return;
    case 6009: 
      b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    case 6008: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      b(4015, false, null);
      a(getClass().getName(), paramInt);
      return;
    case 6007: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        f((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6006: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        e((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2], null);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2], null);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int paramInt3)
  {
    String str = String.valueOf(paramLong2);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if ((paramInt1 != 188) && (paramInt1 != 189))
    {
      if (paramInt1 == 190) {
        localFriendsManager.a(str, false);
      }
    }
    else
    {
      i();
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt3))) {
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt3));
      boolean bool;
      if (paramLong1 == paramLong2) {
        bool = true;
      } else {
        bool = false;
      }
      localFriendListHandler.addFriendToFriendList(str, 0, 3999, null, bool, false, paramLong3);
    }
  }
  
  public void a(long paramLong1, long paramLong2, short paramShort, int paramInt1, msg_comm.Msg paramMsg, int paramInt2)
  {
    String str = String.valueOf(paramLong2);
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if ((paramShort != 188) && (paramShort != 189))
    {
      if (paramShort == 190) {
        ((FriendsManager)localObject).a(str, false);
      }
    }
    else
    {
      i();
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt2))) {
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt2));
      localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      localObject = SystemMsg.decode(this.jdField_a_of_type_ComTencentCommonAppAppInterface, HexUtil.bytes2HexStr((byte[])localObject), str, paramInt1);
      if (localObject != null) {
        localObject = ((SystemMsg)localObject).strGameName;
      } else {
        localObject = "";
      }
      localFriendListHandler.addFriendToFriendList(str, 0, 3999, (String)localObject, true, false, paramMsg.msg_head.msg_time.get());
      NewFriendPushUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong1, paramLong2, paramShort, paramMsg, paramInt2);
    }
  }
  
  public void a(structmsg.StructMsg paramStructMsg, String paramString, int paramInt, long paramLong)
  {
    Oidb_0x5cf.ReqBody localReqBody = new Oidb_0x5cf.ReqBody();
    Oidb_0x5cf.DelMsgInfo localDelMsgInfo = new Oidb_0x5cf.DelMsgInfo();
    localReqBody.uint32_version.set(1);
    localReqBody.uint32_type.set(9);
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    localReqBody.uint64_touin.set(Long.parseLong((String)localObject));
    localReqBody.fixed32_sequence.set((int)paramStructMsg.msg_seq.get());
    localDelMsgInfo.uint32_platform.set(2);
    if (paramStructMsg.msg.sub_type.get() < 2)
    {
      localObject = new Oidb_0x5cf.DelUnDecideInfo();
      ((Oidb_0x5cf.DelUnDecideInfo)localObject).uint64_uin.set(paramStructMsg.req_uin.get());
      localDelMsgInfo.rpt_msg_undecide_info.add((MessageMicro)localObject);
    }
    else
    {
      localObject = new Oidb_0x5cf.DelDecideInfo();
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint64_uin.set(paramStructMsg.req_uin.get());
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint32_time.set((int)paramStructMsg.msg_time.get());
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint32_req_type.set(paramStructMsg.msg.sub_type.get());
      localDelMsgInfo.rpt_msg_decide_info.add((MessageMicro)localObject);
    }
    localReqBody.msg_del_msg_info.set(localDelMsgInfo);
    paramStructMsg = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.makeOIDBPkg("OidbSvc.0x5cf_0", 1487, 0, localReqBody.toByteArray());
    paramStructMsg.extraData.putString("frienduin", paramString);
    paramStructMsg.extraData.putInt("istroop", paramInt);
    paramStructMsg.extraData.putLong("uniseq", paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.sendPbReq(paramStructMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l2 = i;
    System.currentTimeMillis();
    long l3 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_friend_seq_47");
    long l1;
    if (paramBoolean) {
      l1 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_suspicious_seq");
    } else {
      l1 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_seq");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendGroupSystemMsgReadedReport reqSeq=");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(";latestFriendSeq=");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(";latestGroupSeq=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", isSuspicoius=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.systemmsg.", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new structmsg.ReqSystemMsgRead();
    ((structmsg.ReqSystemMsgRead)localObject).latest_group_seq.set(l1);
    ((structmsg.ReqSystemMsgRead)localObject).checktype.set(3);
    if (paramBoolean) {
      ((structmsg.ReqSystemMsgRead)localObject).uint32_req_msg_type.set(2);
    }
    ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
    localProtoReq.ssoCmd = "ProfileService.Pb.ReqSystemMsgRead.Group";
    localProtoReq.reqBody = ((structmsg.ReqSystemMsgRead)localObject).toByteArray();
    localProtoReq.callback = new SystemMessageProcessor.5(this, l2, l3, l1);
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(localProtoReq);
  }
  
  public void b()
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l1 = i;
    System.currentTimeMillis();
    long l2 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_friend_seq_47");
    long l3 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_seq");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendSystemMsgReadedReport reqSeq=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(";latestFriendSeq=");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(";latestGroupSeq=");
      ((StringBuilder)localObject).append(l3);
      QLog.d("Q.systemmsg.", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new structmsg.ReqSystemMsgRead();
    ((structmsg.ReqSystemMsgRead)localObject).latest_friend_seq.set(l2);
    ((structmsg.ReqSystemMsgRead)localObject).checktype.set(2);
    ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
    localProtoReq.ssoCmd = "ProfileService.Pb.ReqSystemMsgRead.Friend";
    localProtoReq.reqBody = ((structmsg.ReqSystemMsgRead)localObject).toByteArray();
    localProtoReq.callback = new SystemMessageProcessor.4(this, l1, l2, l3);
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(localProtoReq);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 2, true);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    case 6004: 
    case 6005: 
    default: 
      return;
    case 6009: 
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "handleGetDelAllSysMsg timeout!");
      }
      b(8039, false, new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      return;
    case 6008: 
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "handleGetDelSingleSysMsg Error!");
      }
      b(4015, false, paramToServiceMsg);
      return;
    case 6007: 
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "onSendSystemMsgActionError");
      }
      b(4012, false, paramToServiceMsg);
      return;
    case 6006: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 6003: 
      paramInt = this.s;
      if (paramInt < 2)
      {
        this.s = (paramInt + 1);
        a(3);
        return;
      }
      this.s = 0;
      return;
    case 6002: 
      paramInt = this.q;
      if (paramInt < 2)
      {
        this.q = (paramInt + 1);
        a(4);
        return;
      }
      this.q = 0;
      return;
    }
    paramInt = this.r;
    if (paramInt < 2)
    {
      this.r = (paramInt + 1);
      a(2);
      return;
    }
    this.r = 0;
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "handleDelAllSysMsg");
    }
    paramToServiceMsg = new Oidb_0x5cf.RspBody();
    BaseMessageHandler localBaseMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler;
    int i = BaseMessageHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleDelAllSysMsg. ");
      paramToServiceMsg.append(i);
      QLog.w("Q.systemmsg.", 2, paramToServiceMsg.toString());
    }
    if (bool)
    {
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).clearHistory(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
      ((INewFriendService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendService.class, "")).reloadNewFriendMsg();
    }
    b(8039, bool, new Object[] { Integer.valueOf(i) });
  }
  
  public void c()
  {
    a(false);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg("ProfileService.Pb.ReqNextSystemMsg.Group");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<---sendGetNextGroupSystemMsgfollowing_group_seq = ");
      ((StringBuilder)localObject1).append(((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("following_group_seq"));
      ((StringBuilder)localObject1).append("following_group_seq = ");
      ((StringBuilder)localObject1).append(((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("following_group_suspicious_seq"));
      ((StringBuilder)localObject1).append(" requestFrom =");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.w("Q.systemmsg.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new structmsg.ReqNextSystemMsg();
    ((structmsg.ReqNextSystemMsg)localObject1).msg_num.set(100);
    if (paramInt == 3)
    {
      ((structmsg.ReqNextSystemMsg)localObject1).following_group_seq.set(((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("following_group_suspicious_seq"));
      ((structmsg.ReqNextSystemMsg)localObject1).uint32_req_msg_type.set(2);
    }
    else
    {
      ((structmsg.ReqNextSystemMsg)localObject1).following_group_seq.set(((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("following_group_seq"));
    }
    ((structmsg.ReqNextSystemMsg)localObject1).checktype.set(3);
    ((structmsg.ReqNextSystemMsg)localObject1).version.set(1000);
    Object localObject2 = new structmsg.FlagInfo();
    ((structmsg.FlagInfo)localObject2).GrpMsg_Kick_Admin.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_WordingDown.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_GetOfficialAccount.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_GetPayInGroup.set(1);
    ((structmsg.FlagInfo)localObject2).FrdMsg_Discuss2ManyChat.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_NeedAutoAdminWording.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_get_transfer_group_msg_flag.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_get_quit_pay_group_msg_flag.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_support_invite_auto_join.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_mask_invite_auto_join.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_GetDisbandedByAdmin.set(1);
    ((structmsg.FlagInfo)localObject2).GrpMsg_GetC2cInviteJoinGroup.set(1);
    ((structmsg.ReqNextSystemMsg)localObject1).flag.set((MessageMicro)localObject2);
    localObject2 = new ProtoReqManagerImpl.ProtoReq();
    ((ProtoReqManagerImpl.ProtoReq)localObject2).setEasyRetryMode();
    ((ProtoReqManagerImpl.ProtoReq)localObject2).ssoCmd = "ProfileService.Pb.ReqNextSystemMsg.Group";
    ((ProtoReqManagerImpl.ProtoReq)localObject2).reqBody = ((structmsg.ReqNextSystemMsg)localObject1).toByteArray();
    ((ProtoReqManagerImpl.ProtoReq)localObject2).busiData = new Integer(paramInt);
    ((ProtoReqManagerImpl.ProtoReq)localObject2).callback = new SystemMessageProcessor.10(this);
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq((ProtoReqManagerImpl.ProtoReq)localObject2);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      Oidb_0x5cf.RspBody localRspBody = new Oidb_0x5cf.RspBody();
      BaseMessageHandler localBaseMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler;
      int i = BaseMessageHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (i == 0)
      {
        paramFromServiceMsg = paramToServiceMsg.extraData.getString("frienduin");
        i = paramToServiceMsg.extraData.getInt("istroop");
        long l = paramToServiceMsg.extraData.getLong("uniseq");
        ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(paramFromServiceMsg, i, l, false);
        if (QLog.isColorLevel()) {
          QLog.w("Q.systemmsg.", 2, "<---handleGetDelSingleSysMsg Success!");
        }
        b(4014, true, paramToServiceMsg);
        return;
      }
      if (i == 1)
      {
        b(4014, true, paramToServiceMsg);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "<---handleGetDelSingleSysMsg Error!");
      }
      b(4015, false, paramToServiceMsg);
      return;
    }
    b(4015, false, null);
  }
  
  public void d()
  {
    long l = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_suspicious_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l);
    localReqSystemMsgRead.uint32_req_msg_type.set(2);
    localReqSystemMsgRead.type.set(1);
    localReqSystemMsgRead.checktype.set(3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearSystemMsg latestGroupSeq=");
      localStringBuilder.append(l);
      QLog.d("SystemMessageProcessor", 2, localStringBuilder.toString());
    }
    a(true, true, false, 0L, new SystemMessageProcessor.7(this, l, localReqSystemMsgRead));
  }
  
  public void e()
  {
    long l1 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_friend_seq_47");
    long l2 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l2);
    localReqSystemMsgRead.type.set(1);
    localReqSystemMsgRead.checktype.set(3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearSystemMsg latestFriendSeq=");
      localStringBuilder.append(l1);
      localStringBuilder.append(";latestGroupSeq=");
      localStringBuilder.append(l2);
      QLog.d("SystemMessageProcessor", 2, localStringBuilder.toString());
    }
    a(true, true, false, 0L, new SystemMessageProcessor.8(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "clearAllSystemMsg");
    }
    Object localObject = new Oidb_0x5cf.ReqBody();
    ((Oidb_0x5cf.ReqBody)localObject).uint32_version.set(1);
    ((Oidb_0x5cf.ReqBody)localObject).uint32_type.set(10);
    ((Oidb_0x5cf.ReqBody)localObject).uint64_touin.set(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin());
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.makeOIDBPkg("OidbSvc.0x5cf_1", 1487, 0, ((Oidb_0x5cf.ReqBody)localObject).toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg("ProfileService.Pb.ReqNextSystemMsg.Friend");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<---sendGetNextFriendSystemMsgfollowing_friend_seq = ");
      ((StringBuilder)localObject1).append(((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("following_friend_seq_47"));
      QLog.w("Q.systemmsg.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new structmsg.ReqNextSystemMsg();
    ((structmsg.ReqNextSystemMsg)localObject1).msg_num.set(20);
    ((structmsg.ReqNextSystemMsg)localObject1).following_friend_seq.set(((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e("following_friend_seq_47"));
    ((structmsg.ReqNextSystemMsg)localObject1).checktype.set(2);
    ((structmsg.ReqNextSystemMsg)localObject1).version.set(1000);
    ((structmsg.ReqNextSystemMsg)localObject1).friend_msg_type_flag.set(1L);
    Object localObject2 = new structmsg.FlagInfo();
    ((structmsg.FlagInfo)localObject2).FrdMsg_GetBusiCard.set(1);
    ((structmsg.FlagInfo)localObject2).FrdMsg_Discuss2ManyChat.set(1);
    ((structmsg.FlagInfo)localObject2).FrdMsg_NeedWaitingMsg.set(1);
    ((structmsg.ReqNextSystemMsg)localObject1).flag.set((MessageMicro)localObject2);
    localObject2 = new ProtoReqManagerImpl.ProtoReq();
    ((ProtoReqManagerImpl.ProtoReq)localObject2).setEasyRetryMode();
    ((ProtoReqManagerImpl.ProtoReq)localObject2).ssoCmd = "ProfileService.Pb.ReqNextSystemMsg.Friend";
    ((ProtoReqManagerImpl.ProtoReq)localObject2).reqBody = ((structmsg.ReqNextSystemMsg)localObject1).toByteArray();
    ((ProtoReqManagerImpl.ProtoReq)localObject2).callback = new SystemMessageProcessor.9(this);
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq((ProtoReqManagerImpl.ProtoReq)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor
 * JD-Core Version:    0.7.0.1
 */