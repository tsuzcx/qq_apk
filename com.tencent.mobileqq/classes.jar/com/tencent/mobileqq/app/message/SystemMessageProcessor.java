package com.tencent.mobileqq.app.message;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendPushUtil;
import com.tencent.mobileqq.activity.contact.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.TroopNotificationConfig;
import com.tencent.mobileqq.config.TroopNotificationEntryConfig;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.model.TroopInfoManager;
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
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.utils.TroopUtils;
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
  private int jdField_a_of_type_Int;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = null;
  private int b;
  private int c;
  private final int d = 2;
  private final int e = 2;
  private final int f = 2;
  
  public SystemMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private int a(List<structmsg.StructMsg> paramList, int paramInt1, int paramInt2)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    int i = paramInt1 - 1;
    paramInt1 = paramInt2;
    paramInt2 = i;
    if (paramInt2 >= 0)
    {
      Object localObject = (structmsg.StructMsg)paramList.get(paramInt2);
      if ((localObject == null) || (!((structmsg.StructMsg)localObject).msg.has()) || (!((structmsg.SystemMsg)((structmsg.StructMsg)localObject).msg.get()).uint32_c2c_invite_join_group_flag.has()) || (((structmsg.SystemMsg)((structmsg.StructMsg)localObject).msg.get()).uint32_c2c_invite_join_group_flag.get() <= 0)) {
        break label340;
      }
      i = ((structmsg.SystemMsg)((structmsg.StructMsg)localObject).msg.get()).group_msg_type.get();
      int j = ((structmsg.SystemMsg)((structmsg.StructMsg)localObject).msg.get()).sub_type.get();
      int k = ((structmsg.StructMsg)localObject).uint32_unread_flag.get();
      long l1 = ((structmsg.StructMsg)localObject).msg.group_code.get();
      long l2 = ((structmsg.StructMsg)localObject).msg_time.get();
      if (QLog.isColorLevel()) {
        QLog.i("SystemMessageProcessor", 2, "uint32_c2c_invite_join_group_flag not 0 groupMsgType:" + i + " subType:" + j + "  unread_flag:" + k + "  unreadCount:" + paramInt1 + " troopCode:" + l1 + "  msgTime:" + l2);
      }
      if ((k == 0) && (paramInt2 >= paramInt1)) {
        break label337;
      }
      paramInt1 -= 1;
      label263:
      if ((i == 2) && (j == 2))
      {
        localObject = String.format("%s_%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        if ((localTroopManager == null) || (localTroopManager.k((String)localObject))) {}
      }
    }
    label337:
    label340:
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.remove(paramInt2);
      continue;
      return paramInt1;
      break label263;
    }
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "mLocalDataList is null !");
      }
    }
    while ((localObject == null) || (((List)localObject).size() <= 0)) {
      return "";
    }
    localObject = (MessageForSystemMsg)((List)localObject).get(((List)localObject).size() - 1);
    ((MessageForSystemMsg)localObject).parse();
    return ((MessageForSystemMsg)localObject).structMsg.msg.req_uin_nick.get() + " " + ((MessageForSystemMsg)localObject).structMsg.msg.msg_describe.get();
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
    String str = "";
    if (paramRspSystemMsgNew.msg_display.has()) {
      str = paramRspSystemMsgNew.msg_display.get();
    }
    return str;
  }
  
  @NotNull
  private ArrayList<MessageRecord> a(int paramInt1, String paramString, List<structmsg.StructMsg> paramList, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool1 = false;
    int i = 0;
    if (i < paramInt2)
    {
      MessageRecord localMessageRecord = MessageRecordFactory.a(-2018);
      localMessageRecord.msgtype = -2018;
      localMessageRecord.selfuin = paramString;
      localMessageRecord.frienduin = AppConstants.TROOP_SYSTEM_MSG_UIN;
      structmsg.StructMsg localStructMsg = (structmsg.StructMsg)paramList.get(i);
      int j = localStructMsg.msg.group_msg_type.get();
      int k = TroopUtils.a(j);
      if (k == 1) {
        localMessageRecord.senderuin = (localStructMsg.msg.action_uin.get() + "");
      }
      MessageForSystemMsg localMessageForSystemMsg;
      int m;
      for (;;)
      {
        localMessageRecord.istroop = 0;
        localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)localStructMsg.get());
        localMessageForSystemMsg.shmsgseq = localMessageForSystemMsg.structMsg.msg_seq.get();
        k = localMessageForSystemMsg.structMsg.msg_type.get();
        m = localMessageForSystemMsg.structMsg.msg.sub_type.get();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("requestFrom:").append(paramInt1);
          ((StringBuilder)localObject).append(" isLatestPushMsgProcessed:").append(bool1);
          ((StringBuilder)localObject).append(" type:").append(k);
          ((StringBuilder)localObject).append(" groupMsgType:").append(j);
          ((StringBuilder)localObject).append(" subType:").append(m);
          ((StringBuilder)localObject).append(" troopUin:").append(localStructMsg.msg.group_code.get());
          ((StringBuilder)localObject).append(" msgTime:").append(localStructMsg.msg_time.get());
          QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->" + ((StringBuilder)localObject).toString());
        }
        if ((k != 1) || (SystemMsgUtils.a(m))) {
          break label415;
        }
        i += 1;
        break;
        if (k == 2) {
          localMessageRecord.senderuin = (localStructMsg.req_uin.get() + "");
        }
      }
      label415:
      if (m == 1) {
        localMessageRecord.senderuin = (localStructMsg.msg.action_uin.get() + "");
      }
      Object localObject = new boolean[1];
      localObject[0] = 1;
      if ((paramInt1 == 1) && (!bool1)) {
        a(paramInt3, i, localStructMsg, j, localMessageForSystemMsg, m, (boolean[])localObject);
      }
      for (boolean bool2 = true;; bool2 = bool1)
      {
        localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        if (localObject[0] != 0) {
          localArrayList.add(localMessageForSystemMsg);
        }
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->isAdd2Loacal:" + localObject[0]);
        bool1 = bool2;
        break;
        b(paramInt3, i, localStructMsg, j, localMessageForSystemMsg, m, (boolean[])localObject);
      }
    }
    return localArrayList;
  }
  
  @Nullable
  private structmsg.RspSystemMsgNew a(byte[] paramArrayOfByte, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    structmsg.RspSystemMsgNew localRspSystemMsgNew;
    if (paramRspSystemMsgNew != null) {
      localRspSystemMsgNew = paramRspSystemMsgNew;
    }
    do
    {
      return localRspSystemMsgNew;
      try
      {
        paramRspSystemMsgNew = new structmsg.RspSystemMsgNew();
        try
        {
          paramRspSystemMsgNew.mergeFrom(paramArrayOfByte);
          return paramRspSystemMsgNew;
        }
        catch (Exception localException)
        {
          paramArrayOfByte = paramRspSystemMsgNew;
          paramRspSystemMsgNew = localException;
        }
      }
      catch (Exception paramRspSystemMsgNew)
      {
        for (;;)
        {
          byte[] arrayOfByte;
          paramArrayOfByte = null;
        }
      }
      arrayOfByte = paramArrayOfByte;
    } while (!QLog.isColorLevel());
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
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null) {
      localTroopManager.a(paramStructMsg);
    }
  }
  
  private void a(int paramInt1, int paramInt2, structmsg.StructMsg paramStructMsg, int paramInt3, MessageForSystemMsg paramMessageForSystemMsg, int paramInt4, boolean[] paramArrayOfBoolean)
  {
    if ((paramInt3 == 2) && (paramInt4 == 2)) {
      a(paramInt2, paramStructMsg, paramMessageForSystemMsg, paramArrayOfBoolean);
    }
    do
    {
      return;
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
      if ((paramInt3 == 13) || (paramInt3 == 6))
      {
        a(paramInt2, paramStructMsg, paramInt3);
        return;
      }
    } while ((paramInt3 != 8) && (paramInt3 != 7));
    a(paramInt1, paramInt2, paramStructMsg, paramInt3);
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SystemMessageProcessor", 1, "sendGroupSystemMsgToVideo, msgType[" + paramInt + "], troopUin[" + paramLong1 + "], userUin[" + paramLong2 + "]");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.GroupSystemMsg");
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("relationType", 1);
    localIntent.putExtra("relationId", paramLong1);
    localIntent.putExtra("userUin", paramLong2);
    if ((paramInt == 3) || (paramInt == 15)) {
      localIntent.putExtra("needSendCmd", true);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
    if ((paramInt == 7) || (paramInt == 8)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().c(paramLong1);
    }
  }
  
  private void a(int paramInt1, NewFriendManager paramNewFriendManager, int paramInt2, String paramString, long paramLong)
  {
    if (a(paramInt1, paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "sentSeq == respSeq | unreadCount = " + paramInt1 + " | newFriendLastMsgTime = 0");
      }
      return;
    }
    paramString = a(paramString);
    if ((paramInt2 != paramInt1) && (paramInt1 == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
    }
    paramNewFriendManager.a(new FriendSystemMessage(paramString, paramLong));
  }
  
  private void a(int paramInt1, structmsg.StructMsg paramStructMsg, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + paramInt1 + ",msgTime:" + paramStructMsg.msg_time + ",msgType:" + paramInt2 + ":delete troopMember, delete troop, clear local history");
    }
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null)
    {
      localTroopManager.c(paramStructMsg.msg.group_code.get() + "", paramStructMsg.req_uin.get() + "");
      localTroopManager.a(paramStructMsg.msg.group_code.get(), paramStructMsg.msg_time.get());
    }
  }
  
  private void a(int paramInt, structmsg.StructMsg paramStructMsg, MessageForSystemMsg paramMessageForSystemMsg, boolean[] paramArrayOfBoolean)
  {
    String str = String.valueOf(paramStructMsg.msg.group_code.get());
    TroopManager localTroopManager1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    a(str, localTroopManager1);
    structmsg.MsgInviteExt localMsgInviteExt;
    int i;
    if (paramMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.has())
    {
      localMsgInviteExt = (structmsg.MsgInviteExt)paramMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.get();
      if (localMsgInviteExt == null) {
        break label254;
      }
      i = localMsgInviteExt.uint32_wait_state.get();
      label87:
      if ((i == 2) || (i == 4))
      {
        TroopManager localTroopManager2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        localTroopManager2.e(localTroopManager2.b(str));
        UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForSystemMsg, localMsgInviteExt, str);
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + paramInt + ":addFriendTipsMr");
        }
      }
      if (i != 4) {
        break label260;
      }
      paramArrayOfBoolean[0] = false;
    }
    for (;;)
    {
      paramMessageForSystemMsg = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (paramMessageForSystemMsg != null) {
        paramMessageForSystemMsg.a(str, Boolean.valueOf(false));
      }
      localTroopManager1.k(String.format("%s_%s", new Object[] { str, Long.valueOf(paramStructMsg.msg_time.get()) }));
      return;
      localMsgInviteExt = null;
      break;
      label254:
      i = -1;
      break label87;
      label260:
      if (paramStructMsg.msg.uint32_c2c_invite_join_group_flag.get() != 0) {
        paramArrayOfBoolean[0] = false;
      }
    }
  }
  
  private void a(FriendsManager paramFriendsManager, int paramInt, NewFriendManager paramNewFriendManager, ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean)
  {
    int i = paramArrayList.size();
    long l1 = ((MessageRecord)paramArrayList.get(i - 1)).time;
    long l2 = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l2);
    a(paramFriendsManager, paramArrayList, i, l1, localList, localList.iterator());
    if (localList.size() == 0)
    {
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1);
      paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      paramString = String.valueOf(paramString);
      if ((!MessageHandlerUtils.a(paramArrayList)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop)) {
        break label190;
      }
    }
    label190:
    for (boolean bool = true;; bool = false)
    {
      paramFriendsManager.a(paramArrayList, paramString, bool);
      paramNewFriendManager.a(true);
      a(paramArrayList);
      a("handleGetSystemMsgResp", true, paramInt, paramBoolean, false);
      return;
      if (paramArrayList.size() >= 20) {
        break;
      }
      FriendSystemMsgController.a().a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
    }
  }
  
  private void a(FriendsManager paramFriendsManager, ArrayList<MessageRecord> paramArrayList, int paramInt, long paramLong, List<ChatMessage> paramList, Iterator<ChatMessage> paramIterator)
  {
    if (paramInt < 20) {
      while (paramIterator.hasNext())
      {
        paramFriendsManager = (ChatMessage)paramIterator.next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, paramFriendsManager.uniseq, false);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, localChatMessage.uniseq, false);
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, localChatMessage.uniseq, false);
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
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, localChatMessage.uniseq, false);
                paramIterator.remove();
              }
            }
          }
        }
      }
    }
  }
  
  private void a(TroopInfoManager paramTroopInfoManager)
  {
    TroopNotificationConfig localTroopNotificationConfig = (TroopNotificationConfig)QConfigManager.a().a(634);
    if (localTroopNotificationConfig != null)
    {
      int i = localTroopNotificationConfig.d;
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null);
      if ((!paramTroopInfoManager.a()) && (localList != null) && (localList.size() < i) && (localTroopNotificationConfig.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "Auto Get Msg Continue");
        }
        c(0);
      }
    }
  }
  
  private void a(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    try
    {
      if ((paramProtoReq.busiData != null) && ((paramProtoReq.busiData instanceof Integer)))
      {
        i = ((Integer)paramProtoReq.busiData).intValue();
        paramProtoReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        structmsg.RspNextSystemMsg localRspNextSystemMsg = new structmsg.RspNextSystemMsg();
        localRspNextSystemMsg.mergeFrom((byte[])paramProtoResp.resp.getWupBuffer());
        if ((localRspNextSystemMsg == null) || (localRspNextSystemMsg.head.result.get() != 0)) {
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
      int i;
      while (QLog.isColorLevel())
      {
        QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", paramProtoResp);
        return;
        i = 0;
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, FriendsManager paramFriendsManager, List<structmsg.StructMsg> paramList, int paramInt1, int paramInt2, NewFriendManager paramNewFriendManager, String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList(paramInt1);
    boolean bool1;
    label34:
    int i;
    label37:
    MessageRecord localMessageRecord;
    boolean bool2;
    label165:
    MessageForSystemMsg localMessageForSystemMsg;
    if (paramFromServiceMsg.getUin() == null)
    {
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (paramInt2 <= 0) {
        break label387;
      }
      bool1 = true;
      i = 0;
      if (i >= paramInt1) {
        break label431;
      }
      localMessageRecord = MessageRecordFactory.a(-2050);
      localMessageRecord.msgtype = -2050;
      localMessageRecord.selfuin = paramFromServiceMsg;
      localMessageRecord.frienduin = AppConstants.FRIEND_SYSTEM_MSG_UIN;
      localMessageRecord.senderuin = (((structmsg.StructMsg)paramList.get(i)).req_uin.get() + "");
      localMessageRecord.istroop = 0;
      localMessageRecord.time = ((structmsg.StructMsg)paramList.get(i)).msg_time.get();
      if (((structmsg.StructMsg)paramList.get(i)).uint32_unread_flag.get() != 0) {
        break label393;
      }
      bool2 = true;
      localMessageRecord.isread = bool2;
      localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
      localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramList.get(i)).get());
      int j = localMessageForSystemMsg.structMsg.msg_type.get();
      int k = localMessageForSystemMsg.structMsg.msg.sub_type.get();
      if (QLog.isColorLevel()) {
        QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp|i = " + i + ", isRead = " + localMessageRecord.isread + ", time = " + localMessageRecord.time + ", uin = " + localMessageRecord.senderuin);
      }
      bool2 = bool1;
      if (i == 0)
      {
        localMessageRecord.extStr = paramString;
        bool2 = bool1;
        if (k == 13) {
          bool2 = false;
        }
      }
      if ((j != 1) || (SystemMsgUtils.a(k))) {
        break label399;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb filtered");
      }
    }
    for (;;)
    {
      i += 1;
      bool1 = bool2;
      break label37;
      paramFromServiceMsg = paramFromServiceMsg.getUin();
      break;
      label387:
      bool1 = false;
      break label34;
      label393:
      bool2 = false;
      break label165;
      label399:
      localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
      ((ChatMessage)localMessageRecord).parse();
      localArrayList.add(localMessageForSystemMsg);
    }
    label431:
    if (localArrayList.size() > 0) {
      a(paramFriendsManager, paramInt2, paramNewFriendManager, localArrayList, paramFromServiceMsg, bool1);
    }
    for (;;)
    {
      paramNewFriendManager.a(new FriendSystemMessage(paramString, paramLong));
      return;
      paramNewFriendManager.a(true);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt1, String paramString, structmsg.RspSystemMsgNew paramRspSystemMsgNew, List<structmsg.StructMsg> paramList, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 0) {
      return;
    }
    this.jdField_a_of_type_Int = 0;
    int i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 1, "processNormalGroupSystemMsg, localUnreadCount" + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_seq", paramRspSystemMsgNew.latest_group_seq.get());
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt3);
    TroopNotificationManager localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    TroopNotificationEntryConfig localTroopNotificationEntryConfig = (TroopNotificationEntryConfig)QConfigManager.a().a(691);
    if ((localTroopNotificationEntryConfig != null) && (localTroopNotificationEntryConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (localTroopNotificationManager != null)) {
      localTroopNotificationManager.a(paramInt3);
    }
    i = paramInt3 - i;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, i);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 1, "processNormalGroupSystemMsg, unreadCount - localUnreadCount" + i);
    }
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    boolean bool1 = false;
    if (paramToServiceMsg.getServiceCmd().equals("ProfileService.Pb.ReqSystemMsgNew"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "CMD_GET_SYSTEM_MSG_BOTH");
      }
      boolean bool2 = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, true, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.TROOP_SYSTEM_RIBBON_MSG_UIN, 0, true, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("following_group_seq", paramRspSystemMsgNew.following_group_seq.get());
      if (localTroopNotificationManager != null) {
        localTroopNotificationManager.b();
      }
      GroupSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bool1 = bool2;
      if (localTroopInfoManager != null)
      {
        localTroopInfoManager.a(false);
        bool1 = bool2;
      }
    }
    b(paramList);
    paramToServiceMsg = a(paramInt1, paramString, paramList, paramInt2, paramInt3);
    structmsg.StructMsg localStructMsg = a(paramToServiceMsg);
    RecentManagerFor3rdPart localRecentManagerFor3rdPart = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_MANAGER_FOR_3RDPART);
    if (localStructMsg != null)
    {
      GroupSystemMsgController.a().a(localStructMsg);
      if ((localTroopNotificationEntryConfig == null) || (!localTroopNotificationEntryConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        long l = localStructMsg.msg_time.get();
        if ((paramInt3 != 0) || (bool1))
        {
          localRecentManagerFor3rdPart.a(AppConstants.TROOP_NOTIFICATION_UIN, 9000, HardCodeUtil.a(2131691181), l, l);
          if (QLog.isColorLevel()) {
            QLog.d("SystemMessageProcessor", 1, "processNormalGroupSystemMsg, create notification node to user list unreadCount" + paramInt3 + " isLogin" + bool1);
          }
        }
        if (i != 0) {
          ReportController.b(null, "dc00898", "", "", "0X800B528", "0X800B528", 0, 0, "", "", null, null);
        }
      }
    }
    a(paramString, paramRspSystemMsgNew, paramInt3, localTroopNotificationManager, false, paramToServiceMsg);
    a(paramString, paramRspSystemMsgNew);
    if ((localTroopNotificationEntryConfig == null) || (!localTroopNotificationEntryConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if ((paramString != null) && ((paramInt3 > 0) || (bool1)))
      {
        paramString.sendMessage(paramString.obtainMessage(1009));
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 1, "processNormalGroupSystemMsg, refresh notification node");
        }
      }
    }
    e((structmsg.StructMsg)paramList.get(0));
    a(4005, true, paramToServiceMsg);
    paramToServiceMsg = (TroopNotificationConfig)QConfigManager.a().a(634);
    if ((!localTroopInfoManager.a()) && (bool1) && (paramToServiceMsg != null) && (paramToServiceMsg.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "Begin Auto Get Next");
      }
      c(0);
    }
    if (paramRspSystemMsgNew.uint32_has_suspicious_flag.get() == 1) {}
    for (bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "processNormalGroupSystemMsg requestSuspiciousList :hasSuspiciousMsg = " + bool1);
      }
      if (!bool1) {
        break;
      }
      TroopSuspiciousHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
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
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label130;
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      paramToServiceMsg.getClass();
      if (!paramFromServiceMsg.a(paramToServiceMsg, "msf")) {
        break label130;
      }
    }
    label130:
    while ((480000L != l4) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReportError type=" + i + ";reqSeq=" + l3 + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    paramObject = a((byte[])paramObject, paramRspSystemMsgNew);
    if ((paramObject == null) || (paramObject.head.result.get() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, "rspSystemMsg.head.result.get()" + paramObject.head.result.get());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramRspSystemMsgNew = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    List localList = paramObject.friendmsgs.get();
    int k = localList.size();
    int m = paramObject.unread_friend_count.get();
    int j = paramObject.uint32_un_read_count3.get();
    if (paramObject.uint32_over.get() == 1) {}
    NewFriendManager localNewFriendManager;
    for (boolean bool = true;; bool = false)
    {
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
      localNewFriendManager = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
      i = localNewFriendManager.c();
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m);
      int n = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
      if (QLog.isColorLevel())
      {
        QLog.d("SystemMessageProcessor", 2, "processFriendSystemMsg-->requestFrom:" + n);
        localObject = new StringBuilder(128);
        ((StringBuilder)localObject).append("<---handleGetFriendSystemMsgResp : decode pb MsgsSize = ").append(k).append(" latest_friend_seq").append(paramObject.latest_friend_seq.get()).append(" latest_group_seq").append(paramObject.latest_group_seq.get()).append(" following_friend_seq").append(paramObject.following_friend_seq.get()).append(" following_group_seq").append(paramObject.following_group_seq.get()).append(" unreadCount").append(m).append(" localunreadCount").append(i).append(" isSysMsgOver").append(bool).append(" unreadCountForSuspicious").append(j);
        QLog.d("Q.systemmsg.", 2, ((StringBuilder)localObject).toString());
      }
      if (!a(k, m, n)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
      localNewFriendManager.b();
      a(4014, true, null);
      return;
    }
    Object localObject = a(paramObject);
    long l1 = 0L;
    if (localList.size() > 0)
    {
      l1 = ((structmsg.StructMsg)localList.get(0)).msg_time.get();
      a(paramToServiceMsg, paramObject, localList);
    }
    this.jdField_a_of_type_Int = 0;
    j = 0;
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_friend_seq_47");
    long l3 = paramObject.latest_friend_seq.get();
    if (l2 == l3)
    {
      a(m, localNewFriendManager, i, (String)localObject, l1);
      return;
    }
    int i = j;
    if (m == 0)
    {
      i = j;
      if (k == 0) {
        i = 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_friend_seq_47", paramObject.latest_friend_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("following_friend_seq_47", paramObject.following_friend_seq.get());
    FriendSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 0) {
      a(paramFromServiceMsg, paramRspSystemMsgNew, localList, k, m, localNewFriendManager, (String)localObject, l1);
    }
    for (;;)
    {
      a(4005, true, null);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : clear local data. sentSeq:" + l2 + " respSeq:" + l3);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
      localNewFriendManager.b();
    }
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
        KplRoleInfo.saveGameNickWithUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), str);
      }
      if (localSystemMsg.bytes_game_msg.has())
      {
        paramList = localSystemMsg.bytes_game_msg.get().toStringUtf8();
        KplRoleInfo.saveKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
      }
      if (paramRspSystemMsgNew.bytes_game_nick.has()) {
        KplRoleInfo.saveGameNickWithUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg.getUin(), paramRspSystemMsgNew.bytes_game_nick.get());
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
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg--> add troop : " + paramString);
      }
      paramTroopManager = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      ((TroopInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(localTroopInfo.troopuin, false, "SystemMessageProcessor.AgreeGroupInvation", true, true, true, false);
      paramTroopManager.a(1, BizTroopHandler.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
      paramTroopManager.f(paramString);
      paramTroopManager.notifyUI(TroopNotificationConstants.bx, true, new Object[] { paramString });
    }
  }
  
  private void a(String paramString, structmsg.RspNextSystemMsg paramRspNextSystemMsg)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramRspNextSystemMsg != null) && (!TextUtils.isEmpty(paramString))) {
      TroopSuspiciousHelper.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspNextSystemMsg, paramString);
    }
  }
  
  private void a(String paramString, structmsg.RspNextSystemMsg paramRspNextSystemMsg, ArrayList<MessageRecord> paramArrayList, TroopInfoManager paramTroopInfoManager)
  {
    if (paramArrayList.size() > 0)
    {
      if (paramArrayList.size() < 100)
      {
        GroupSystemMsgController.a().a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramTroopInfoManager != null) {
          paramTroopInfoManager.a(true);
        }
      }
      long l2 = paramRspNextSystemMsg.following_group_seq.get();
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("following_group_seq");
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg : decode pb following_group_seq" + l1);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("following_group_seq", l1);
      paramString = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
      int i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramString != null) {
        paramString.a(paramArrayList, i);
      }
      a("handleGetSystemMsgResp", true, paramArrayList.size(), false, false);
      a(4005, true, paramArrayList);
    }
    do
    {
      return;
      GroupSystemMsgController.a().a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (paramTroopInfoManager == null);
    paramTroopInfoManager.a(true);
  }
  
  private void a(String paramString, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if ((paramRspSystemMsgNew.msg_ribbon_group.has()) && (paramRspSystemMsgNew.msg_ribbon_group.get() != null))
    {
      Object localObject = (structmsg.StructMsg)paramRspSystemMsgNew.msg_ribbon_group.get();
      paramRspSystemMsgNew = MessageRecordFactory.a(-2018);
      paramRspSystemMsgNew.selfuin = paramString;
      paramRspSystemMsgNew.frienduin = AppConstants.TROOP_SYSTEM_RIBBON_MSG_UIN;
      paramRspSystemMsgNew.senderuin = (((structmsg.StructMsg)localObject).req_uin.get() + "");
      paramRspSystemMsgNew.istroop = 0;
      MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)paramRspSystemMsgNew;
      localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)localObject);
      paramRspSystemMsgNew.msgData = localMessageForSystemMsg.structMsg.toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramRspSystemMsgNew);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((ArrayList)localObject, String.valueOf(paramString), true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "ribbon info");
      }
    }
  }
  
  private void a(String paramString, structmsg.RspSystemMsgNew paramRspSystemMsgNew, int paramInt, TroopNotificationManager paramTroopNotificationManager, boolean paramBoolean, ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.TROOP_SYSTEM_RIBBON_MSG_UIN, 0, true, true);
      if (paramTroopNotificationManager != null) {
        paramTroopNotificationManager.a(paramArrayList, paramInt);
      }
      a("handleGetSystemMsgResp", true, paramInt, paramBoolean, false);
      if (!TextUtils.isEmpty(paramRspSystemMsgNew.grp_msg_display.get())) {
        GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspSystemMsgNew.grp_msg_display.get());
      }
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
    localRecentUser.msgType = 26;
    localRecentUser.displayName = NewFriendManager.a;
    Object localObject = (MessageForSystemMsg)paramList.get(0);
    ((MessageForSystemMsg)localObject).parse();
    if (!TextUtils.isEmpty(((MessageForSystemMsg)localObject).extStr)) {}
    for (String str = ((MessageForSystemMsg)localObject).extStr;; str = ((MessageForSystemMsg)localObject).structMsg.msg.req_uin_nick.get() + " " + ((MessageForSystemMsg)localObject).structMsg.msg.msg_describe.get())
    {
      localRecentUser.lastmsgtime = ((MessageForSystemMsg)localObject).time;
      localRecentUser.msgData = str.getBytes();
      localRecentUser.msg = str;
      localRecentUser.reParse();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("mDataList.size() ").append(paramList.size()).append(" | msg = ");
        paramList = str;
        if (TextUtils.isEmpty(str)) {
          paramList = "";
        }
        QLog.d("SystemMessageProcessor", 2, paramList);
      }
      localRecentUserProxy.b(localRecentUser);
      return;
    }
  }
  
  private void a(structmsg.RspSystemMsgNew paramRspSystemMsgNew, List<structmsg.StructMsg> paramList, int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramRspSystemMsgNew != null) && (paramList != null) && (!TextUtils.isEmpty(paramString))) {
      TroopSuspiciousHelper.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspSystemMsgNew, paramList, paramInt, paramString);
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    paramStructMsg = localTroopManager.b(paramStructMsg.msg.group_code.get() + "");
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
    structmsg.RspSystemMsgNew localRspSystemMsgNew;
    if (paramRspSystemMsgNew != null) {
      localRspSystemMsgNew = paramRspSystemMsgNew;
    }
    do
    {
      return localRspSystemMsgNew;
      try
      {
        paramRspSystemMsgNew = new structmsg.RspSystemMsgNew();
        try
        {
          paramRspSystemMsgNew.mergeFrom(paramArrayOfByte);
          return paramRspSystemMsgNew;
        }
        catch (Exception localException)
        {
          paramArrayOfByte = paramRspSystemMsgNew;
          paramRspSystemMsgNew = localException;
        }
      }
      catch (Exception paramRspSystemMsgNew)
      {
        for (;;)
        {
          byte[] arrayOfByte;
          paramArrayOfByte = null;
        }
      }
      arrayOfByte = paramArrayOfByte;
    } while (!QLog.isColorLevel());
    QLog.e("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb error:", paramRspSystemMsgNew);
    return paramArrayOfByte;
  }
  
  private void b(int paramInt1, int paramInt2, structmsg.StructMsg paramStructMsg, int paramInt3, MessageForSystemMsg paramMessageForSystemMsg, int paramInt4, boolean[] paramArrayOfBoolean)
  {
    long l;
    if ((paramInt3 == 2) && (paramInt4 == 2))
    {
      l = paramStructMsg.msg.group_code.get();
      if (paramMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.has())
      {
        paramStructMsg = (structmsg.MsgInviteExt)paramMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.get();
        if (paramStructMsg == null) {
          break label112;
        }
        paramInt1 = paramStructMsg.uint32_wait_state.get();
        label71:
        if ((paramInt1 == 2) || (paramInt1 == 4)) {
          UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForSystemMsg, paramStructMsg, String.valueOf(l));
        }
        if (paramInt1 == 4) {
          paramArrayOfBoolean[0] = false;
        }
      }
    }
    label112:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramStructMsg = null;
            break;
            paramInt1 = -1;
            break label71;
            if ((paramInt3 != 8) && (paramInt3 != 7)) {
              break label227;
            }
            l = paramStructMsg.msg.group_code.get();
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, String.format("handlePassiveExit offline troopUin: %s, msgType: %s, i: %s, unreadCount: %s", new Object[] { String.valueOf(l), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
            }
          } while (paramInt2 >= paramInt1);
          paramMessageForSystemMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        } while (paramMessageForSystemMsg == null);
        paramMessageForSystemMsg.a(paramStructMsg);
        return;
      } while ((paramInt3 != 13) && (paramInt3 != 6));
      paramMessageForSystemMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    } while ((paramMessageForSystemMsg == null) || (paramMessageForSystemMsg.a(paramStructMsg.msg.group_code.get(), paramStructMsg.msg_time.get())));
    label227:
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + paramInt2 + ",msgTime:" + paramStructMsg.msg_time + ",msgType:" + paramInt3 + ":delete troopMember, delete troop, clear local history");
    }
    paramArrayOfBoolean = paramStructMsg.msg.group_code.get() + "";
    String str = paramStructMsg.req_uin.get() + "";
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localTroopHandler != null) {
      localTroopHandler.a(paramArrayOfBoolean, str, true);
    }
    paramMessageForSystemMsg.a(paramStructMsg.msg.group_code.get(), paramStructMsg.msg_time.get());
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SystemMessageProcessor", 4, "processGroupSystemMsg");
    }
    paramObject = b((byte[])paramObject, paramRspSystemMsgNew);
    paramRspSystemMsgNew = new StringBuilder();
    if ((paramObject == null) || (paramObject.head.result.get() != 0))
    {
      paramRspSystemMsgNew.setLength(0);
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, paramRspSystemMsgNew.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    }
    label323:
    label339:
    for (;;)
    {
      return;
      paramRspSystemMsgNew = paramObject.groupmsgs.get();
      int j = a(paramRspSystemMsgNew, paramRspSystemMsgNew.size(), paramObject.unread_group_count.get());
      int i = paramRspSystemMsgNew.size();
      j = Math.max(j, 0);
      int k;
      if (paramFromServiceMsg.getUin() == null)
      {
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        k = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
        if (k != 3) {
          break label323;
        }
        a(paramObject, paramRspSystemMsgNew, j, paramFromServiceMsg);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label339;
        }
        QLog.d("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb groupMsgsSize = " + i + " latest_friend_seq" + paramObject.latest_friend_seq.get() + " latest_group_seq" + paramObject.latest_group_seq.get() + " following_friend_seq" + paramObject.following_friend_seq.get() + " following_group_seq" + paramObject.following_group_seq.get() + " uint32_has_suspicious_flag = " + paramObject.uint32_has_suspicious_flag.get() + " unreadCount" + j + " requestFrom = " + k);
        return;
        paramFromServiceMsg = paramFromServiceMsg.getUin();
        break;
        a(paramToServiceMsg, k, paramFromServiceMsg, paramObject, paramRspSystemMsgNew, i, j);
      }
    }
  }
  
  private void b(String paramString, structmsg.RspNextSystemMsg paramRspNextSystemMsg)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramRspNextSystemMsg.msgs.get();
    int j = ((List)localObject1).size();
    if (QLog.isColorLevel()) {
      QLog.e("Q.systemmsg.", 2, "<---handleGetNextNormalGroupSystemMsgSucc Resp : decode pb size = " + j);
    }
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < j)
    {
      Object localObject2 = (structmsg.StructMsg)((structmsg.StructMsg)((List)localObject1).get(i)).get();
      if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg_seq.has()) && (localHashSet.contains(Long.valueOf(((structmsg.StructMsg)localObject2).msg_seq.get())))) {}
      for (;;)
      {
        i += 1;
        break;
        MessageRecord localMessageRecord = MessageRecordFactory.a(-2018);
        localMessageRecord.msgtype = -2018;
        localMessageRecord.selfuin = paramString;
        localMessageRecord.frienduin = AppConstants.TROOP_SYSTEM_MSG_UIN;
        localMessageRecord.senderuin = (((structmsg.StructMsg)((List)localObject1).get(i)).req_uin.get() + "");
        localMessageRecord.istroop = 0;
        MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject1).get(i)).get());
        localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        localArrayList.add(localMessageForSystemMsg);
        if ((localObject2 != null) && (((structmsg.StructMsg)localObject2).msg_seq.has())) {
          localHashSet.add(Long.valueOf(((structmsg.StructMsg)localObject2).msg_seq.get()));
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" type:").append(localMessageRecord.msgtype);
          ((StringBuilder)localObject2).append(" selfuin:").append(localMessageRecord.selfuin);
          ((StringBuilder)localObject2).append(" frienduin:").append(localMessageRecord.frienduin);
          ((StringBuilder)localObject2).append(" senderuin:").append(localMessageRecord.senderuin);
          ((StringBuilder)localObject2).append(" istroop:").append(localMessageRecord.istroop);
          QLog.d("SystemMessageProcessor", 2, "handleGetNextNormalGroupSystemMsgSucc-->" + ((StringBuilder)localObject2).toString());
        }
      }
    }
    localObject1 = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    a(paramString, paramRspNextSystemMsg, localArrayList, (TroopInfoManager)localObject1);
    a((TroopInfoManager)localObject1);
  }
  
  private void b(List<structmsg.StructMsg> paramList)
  {
    Collections.sort(paramList, new SystemMessageProcessor.1(this));
  }
  
  private void b(structmsg.StructMsg paramStructMsg)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    paramStructMsg = localTroopManager.b(paramStructMsg.msg.group_code.get() + "");
    if (paramStructMsg != null)
    {
      paramStructMsg.dwCmdUinUinFlag = 1L;
      localTroopManager.b(paramStructMsg);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getUin() == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    }
    Object localObject2;
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = new structmsg.RspSystemMsgNew();
      }
      catch (Exception localException1)
      {
        localObject1 = null;
      }
      try
      {
        ((structmsg.RspSystemMsgNew)localObject1).mergeFrom((byte[])paramObject);
        localObject2 = localObject1;
        localObject1 = new StringBuilder();
        if ((localObject2 != null) && (localObject2.head.result.get() == 0)) {
          break;
        }
        ((StringBuilder)localObject1).append("processSystemMsg error " + localObject2.head.result.get());
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception localException2)
      {
        break label145;
      }
      paramFromServiceMsg.getUin();
      continue;
      label145:
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e("SystemMessageProcessor", 2, "<---handleGetSystemMsgRespNew : decode pb error:", localException1);
        localObject2 = localObject1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("SystemMessageProcessor", 2, "SystemMessageProcessor: listsize");
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject, localObject2);
    b(paramToServiceMsg, paramFromServiceMsg, paramObject, localObject2);
  }
  
  private void c(structmsg.StructMsg paramStructMsg)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    paramStructMsg = localTroopManager.b(paramStructMsg.msg.group_code.get() + "");
    if (paramStructMsg != null)
    {
      paramStructMsg.dwCmdUinUinFlag = 0L;
      if (paramStructMsg.Administrator == null) {
        break label210;
      }
      if (paramStructMsg.Administrator.startsWith("|")) {
        paramStructMsg.Administrator = paramStructMsg.Administrator.substring(1);
      }
      if (!paramStructMsg.Administrator.endsWith("|")) {}
    }
    label210:
    for (paramStructMsg.Administrator = paramStructMsg.Administrator.substring(0, paramStructMsg.Administrator.length() - 1);; paramStructMsg.Administrator = "")
    {
      paramStructMsg.Administrator = paramStructMsg.Administrator.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "|", "").replace("|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "").replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
      localTroopManager.b(paramStructMsg);
      return;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int i = paramToServiceMsg.extraData.getInt("type");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3) == null) {}
    for (;;)
    {
      return;
      if (paramObject == null) {
        continue;
      }
      paramToServiceMsg = new structmsg.RspSystemMsgRead();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          continue;
        }
        int j = paramToServiceMsg.head.result.get();
        if (j == 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReport type =" + i + ";reqSeq=" + l3 + ";resultCode=" + j + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgReadedReport :type = " + i + " decode pb:", paramFromServiceMsg);
          }
        }
      }
    }
  }
  
  private void d(structmsg.StructMsg paramStructMsg)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    paramStructMsg = ((TroopManager)localObject).b(paramStructMsg.msg.group_code.get() + "");
    if (paramStructMsg != null)
    {
      paramStructMsg.dwCmdUinUinFlag = 1L;
      if (paramStructMsg.Administrator == null) {
        break label211;
      }
      if (paramStructMsg.Administrator.startsWith("|")) {
        paramStructMsg.Administrator = paramStructMsg.Administrator.substring(1);
      }
      if (!paramStructMsg.Administrator.endsWith("|")) {}
    }
    label211:
    for (paramStructMsg.Administrator = paramStructMsg.Administrator.substring(0, paramStructMsg.Administrator.length() - 1);; paramStructMsg.Administrator = "")
    {
      if (!paramStructMsg.Administrator.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        paramStructMsg.Administrator = (paramStructMsg.Administrator + "|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      ((TroopManager)localObject).b(paramStructMsg);
      localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localObject != null) {
        ((TroopHandler)localObject).c(Long.parseLong(paramStructMsg.troopuin));
      }
      return;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getUin() == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new structmsg.RspSystemMsgAction();
      }
      catch (Exception paramObject)
      {
        int i;
        paramFromServiceMsg = null;
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgAction : decode pb:", paramObject);
        }
        continue;
        String str = paramFromServiceMsg.head.msg_fail.get();
        paramObject = str;
        if (str == null) {
          paramObject = "";
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramObject);
        bool = false;
        continue;
      }
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          break label300;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgAction result id=" + paramFromServiceMsg.head.result.get());
        }
        if (paramFromServiceMsg.head.result.get() != 0) {
          continue;
        }
        bool = true;
        str = paramFromServiceMsg.msg_detail.get();
        paramObject = str;
        if (str == null) {
          paramObject = "";
        }
        i = -1;
        if (paramFromServiceMsg.remark_result.has()) {
          i = paramFromServiceMsg.remark_result.get();
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_key", paramObject);
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", paramFromServiceMsg.head.result.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", paramFromServiceMsg.type.get());
        paramToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", paramFromServiceMsg.msg_invalid_decided.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
      }
      catch (Exception paramObject)
      {
        continue;
        bool = false;
        continue;
      }
      a(4011, bool, paramToServiceMsg);
      return;
      paramFromServiceMsg.getUin();
    }
  }
  
  private void e(structmsg.StructMsg paramStructMsg)
  {
    if (paramStructMsg.msg.has()) {
      if (!((structmsg.SystemMsg)paramStructMsg.msg.get()).group_msg_type.has()) {
        break label147;
      }
    }
    label147:
    for (int i = ((structmsg.SystemMsg)paramStructMsg.msg.get()).group_msg_type.get();; i = -1)
    {
      if (((structmsg.SystemMsg)paramStructMsg.msg.get()).group_code.has()) {}
      for (long l1 = ((structmsg.SystemMsg)paramStructMsg.msg.get()).group_code.get();; l1 = -1L)
      {
        if (paramStructMsg.req_uin.has()) {}
        for (long l2 = paramStructMsg.req_uin.get();; l2 = -1L)
        {
          if ((i != -1) && (l2 != -1L) && (l1 != -1L)) {
            a(i, l1, l2);
          }
          return;
        }
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
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_friend_seq_47");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l1);
    localReqSystemMsgRead.latest_group_seq.set(l2);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "sendSystemMsgReadedReport latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new SystemMessageProcessor.3(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject2 = "ProfileService.Pb.ReqSystemMsgNew";
    int i = 0;
    Object localObject1 = null;
    structmsg.ReqSystemMsgNew localReqSystemMsgNew;
    PBUInt64Field localPBUInt64Field;
    long l;
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "<---sendGetSystemMsg type=" + paramInt1 + " latest_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_friend_seq_47") + " latest_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_seq") + " last_group_suspicious_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_suspicious_seq"));
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg((String)localObject2);
      localReqSystemMsgNew = new structmsg.ReqSystemMsgNew();
      localReqSystemMsgNew.msg_num.set(20);
      localReqSystemMsgNew.checktype.set(i);
      localPBUInt64Field = localReqSystemMsgNew.latest_friend_seq;
      if (paramBoolean)
      {
        l = 0L;
        label193:
        localPBUInt64Field.set(l);
        if (paramInt2 != 3) {
          break label769;
        }
        localPBUInt64Field = localReqSystemMsgNew.latest_group_seq;
        if (!paramBoolean) {
          break label751;
        }
        l = 0L;
        label219:
        localPBUInt64Field.set(l);
        if (localObject1 != null) {
          localReqSystemMsgNew.flag.set((MessageMicro)localObject1);
        }
        localReqSystemMsgNew.is_get_frd_ribbon.set(false);
        localReqSystemMsgNew.version.set(1000);
        localReqSystemMsgNew.is_get_grp_ribbon.set(false);
        localReqSystemMsgNew.friend_msg_type_flag.set(1L);
        if (paramInt2 != 3) {
          break label811;
        }
        localReqSystemMsgNew.uint32_req_msg_type.set(2);
      }
      break;
    }
    for (;;)
    {
      ((ToServiceMsg)localObject2).extraData.putInt("getSystemMsgSender", paramInt2);
      ((ToServiceMsg)localObject2).putWupBuffer(localReqSystemMsgNew.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq((ToServiceMsg)localObject2);
      return;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).GrpMsg_Kick_Admin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_HiddenGrp.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_WordingDown.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetOfficialAccount.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetPayInGroup.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_GetBusiCard.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_uint32_need_all_unread_msg.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_get_transfer_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_NeedAutoAdminWording.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_get_quit_pay_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_support_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_mask_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetDisbandedByAdmin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetC2cInviteJoinGroup.set(1);
      localObject2 = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
      i = 4;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew";
      break;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew.Friend";
      i = 2;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).FrdMsg_GetBusiCard.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_uint32_need_all_unread_msg.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetC2cInviteJoinGroup.set(1);
      break;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew.Group";
      i = 3;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).GrpMsg_Kick_Admin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_HiddenGrp.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_WordingDown.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetOfficialAccount.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetPayInGroup.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_get_transfer_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_NeedAutoAdminWording.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_get_quit_pay_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_support_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_mask_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetDisbandedByAdmin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetC2cInviteJoinGroup.set(1);
      break;
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_friend_seq_47");
      break label193;
      label751:
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_suspicious_seq");
      break label219;
      label769:
      localPBUInt64Field = localReqSystemMsgNew.latest_group_seq;
      if (paramBoolean) {}
      for (l = 0L;; l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_seq"))
      {
        localPBUInt64Field.set(l);
        break;
      }
      label811:
      localReqSystemMsgNew.uint32_req_msg_type.set(1);
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6)
  {
    a(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4, paramInt5, paramSystemMsgActionInfo, paramInt6, "");
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, String paramString)
  {
    paramString = paramLong1 + "_" + paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgAction logStr=" + paramString);
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Group");
    ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
    paramSystemMsgActionInfo.busiData = localObject;
    paramSystemMsgActionInfo.callback = new SystemMessageProcessor.11(this);
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(paramSystemMsgActionInfo);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    long l = paramInt1 + paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgAction logStr=" + l);
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
    ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
    localProtoReq.setEasyRetryMode();
    localProtoReq.ssoCmd = "ProfileService.Pb.ReqSystemMsgAction.Friend";
    localProtoReq.reqBody = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Friend");
    ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", String.valueOf(l));
    ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
    ((ToServiceMsg)localObject).extraData.putBoolean("isUncommonlyUsedFrd", paramBoolean);
    localProtoReq.busiData = localObject;
    localProtoReq.callback = new SystemMessageProcessor.2(this, paramInt6, paramInt3, paramSystemMsgActionInfo, paramStructMsg, paramLong2);
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(localProtoReq);
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
    case 6002: 
      this.jdField_a_of_type_Int = 0;
      return;
    case 6001: 
      this.b = 0;
      return;
    case 6003: 
      this.c = 0;
      return;
    case 6006: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 6008: 
      b(4015, false, paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleGetDelAllSysMsg Error!");
    }
    b(8039, false, new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) });
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, long paramLong1, long paramLong2, msg_comm.MsgHead paramMsgHead)
  {
    if ((paramInt == 85) || (paramInt == 36))
    {
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte, paramLong1, paramLong2, paramMsgHead);
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
    case 6002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2], null);
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
    case 6006: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6007: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        e((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6008: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      b(4015, false, null);
      a(getClass().getName(), paramInt);
      return;
    }
    a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int paramInt3)
  {
    String str = String.valueOf(paramLong2);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if ((paramInt1 == 188) || (paramInt1 == 189))
    {
      i();
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt3))) {}
    }
    while (paramInt1 != 190)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt3));
      if (paramLong1 == paramLong2) {}
      for (boolean bool = true;; bool = false)
      {
        localFriendListHandler.addFriendToFriendList(str, 0, 3999, null, bool, false, paramLong3);
        return;
      }
    }
    localFriendsManager.a(str, false);
  }
  
  public void a(long paramLong1, long paramLong2, short paramShort, int paramInt1, msg_comm.Msg paramMsg, int paramInt2)
  {
    String str = String.valueOf(paramLong2);
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if ((paramShort == 188) || (paramShort == 189))
    {
      i();
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt2))) {}
    }
    while (paramShort != 190)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt2));
      localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      localObject = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, HexUtil.bytes2HexStr((byte[])localObject), str, paramInt1);
      if (localObject != null) {}
      for (localObject = ((SystemMsg)localObject).strGameName;; localObject = "")
      {
        localFriendListHandler.addFriendToFriendList(str, 0, 3999, (String)localObject, true, false, paramMsg.msg_head.msg_time.get());
        NewFriendPushUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong1, paramLong2, paramShort, paramMsg, paramInt2);
        return;
      }
    }
    ((FriendsManager)localObject).a(str, false);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "handleDelAllSysMsg");
    }
    paramToServiceMsg = new Oidb_0x5cf.RspBody();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
    int i = MessageHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "handleDelAllSysMsg. " + i);
      }
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).b();
      }
      b(8039, bool, new Object[] { Integer.valueOf(i) });
      return;
    }
  }
  
  public void a(structmsg.StructMsg paramStructMsg, String paramString, int paramInt, long paramLong)
  {
    Oidb_0x5cf.ReqBody localReqBody = new Oidb_0x5cf.ReqBody();
    Oidb_0x5cf.DelMsgInfo localDelMsgInfo = new Oidb_0x5cf.DelMsgInfo();
    localReqBody.uint32_version.set(1);
    localReqBody.uint32_type.set(9);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localReqBody.uint64_touin.set(Long.parseLong((String)localObject));
    localReqBody.fixed32_sequence.set((int)paramStructMsg.msg_seq.get());
    localDelMsgInfo.uint32_platform.set(2);
    if (paramStructMsg.msg.sub_type.get() < 2)
    {
      localObject = new Oidb_0x5cf.DelUnDecideInfo();
      ((Oidb_0x5cf.DelUnDecideInfo)localObject).uint64_uin.set(paramStructMsg.req_uin.get());
      localDelMsgInfo.rpt_msg_undecide_info.add((MessageMicro)localObject);
    }
    for (;;)
    {
      localReqBody.msg_del_msg_info.set(localDelMsgInfo);
      paramStructMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().makeOIDBPkg("OidbSvc.0x5cf_0", 1487, 0, localReqBody.toByteArray());
      paramStructMsg.extraData.putString("frienduin", paramString);
      paramStructMsg.extraData.putInt("istroop", paramInt);
      paramStructMsg.extraData.putLong("uniseq", paramLong);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq(paramStructMsg);
      return;
      localObject = new Oidb_0x5cf.DelDecideInfo();
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint64_uin.set(paramStructMsg.req_uin.get());
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint32_time.set((int)paramStructMsg.msg_time.get());
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint32_req_type.set(paramStructMsg.msg.sub_type.get());
      localDelMsgInfo.rpt_msg_decide_info.add((MessageMicro)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l2 = i;
    System.currentTimeMillis();
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_friend_seq_47");
    if (paramBoolean) {}
    for (long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_suspicious_seq");; l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_seq"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendGroupSystemMsgReadedReport reqSeq=" + l2 + ";latestFriendSeq=" + l3 + ";latestGroupSeq=" + l1 + ", isSuspicoius=" + paramBoolean);
      }
      structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
      localReqSystemMsgRead.latest_group_seq.set(l1);
      localReqSystemMsgRead.checktype.set(3);
      if (paramBoolean) {
        localReqSystemMsgRead.uint32_req_msg_type.set(2);
      }
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "ProfileService.Pb.ReqSystemMsgRead.Group";
      localProtoReq.reqBody = localReqSystemMsgRead.toByteArray();
      localProtoReq.callback = new SystemMessageProcessor.5(this, l2, l3, l1);
      ((IProtoReqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(localProtoReq);
      return;
    }
  }
  
  public void b()
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l1 = i;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendSystemMsgReadedReport reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l2);
    localReqSystemMsgRead.checktype.set(2);
    ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
    localProtoReq.ssoCmd = "ProfileService.Pb.ReqSystemMsgRead.Friend";
    localProtoReq.reqBody = localReqSystemMsgRead.toByteArray();
    localProtoReq.callback = new SystemMessageProcessor.4(this, l1, l2, l3);
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(localProtoReq);
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
    case 6002: 
      if (this.jdField_a_of_type_Int < 2)
      {
        this.jdField_a_of_type_Int += 1;
        a(4);
        return;
      }
      this.jdField_a_of_type_Int = 0;
      return;
    case 6001: 
      if (this.b < 2)
      {
        this.b += 1;
        a(2);
        return;
      }
      this.b = 0;
      return;
    case 6003: 
      if (this.c < 2)
      {
        this.c += 1;
        a(3);
        return;
      }
      this.c = 0;
      return;
    case 6006: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 6007: 
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "onSendSystemMsgActionError");
      }
      b(4012, false, paramToServiceMsg);
      return;
    case 6008: 
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "handleGetDelSingleSysMsg Error!");
      }
      b(4015, false, paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleGetDelAllSysMsg timeout!");
    }
    b(8039, false, new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) });
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      b(4015, false, null);
      return;
    }
    Oidb_0x5cf.RspBody localRspBody = new Oidb_0x5cf.RspBody();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
    int i = MessageHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (i == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("frienduin");
      i = paramToServiceMsg.extraData.getInt("istroop");
      long l = paramToServiceMsg.extraData.getLong("uniseq");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramFromServiceMsg, i, l, false);
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
  }
  
  public void c()
  {
    a(false);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("ProfileService.Pb.ReqNextSystemMsg.Group");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsgfollowing_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("following_group_seq") + "following_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("following_group_suspicious_seq") + " requestFrom =" + paramInt);
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(100);
    if (paramInt == 3)
    {
      localReqNextSystemMsg.following_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("following_group_suspicious_seq"));
      localReqNextSystemMsg.uint32_req_msg_type.set(2);
    }
    for (;;)
    {
      localReqNextSystemMsg.checktype.set(3);
      localReqNextSystemMsg.version.set(1000);
      Object localObject = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject).GrpMsg_Kick_Admin.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_WordingDown.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_GetOfficialAccount.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_GetPayInGroup.set(1);
      ((structmsg.FlagInfo)localObject).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_NotAllowJoinGrp_InviteNotFrd.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_NeedAutoAdminWording.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_get_transfer_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_get_quit_pay_group_msg_flag.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_support_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_mask_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_GetDisbandedByAdmin.set(1);
      ((structmsg.FlagInfo)localObject).GrpMsg_GetC2cInviteJoinGroup.set(1);
      localReqNextSystemMsg.flag.set((MessageMicro)localObject);
      localObject = new ProtoReqManagerImpl.ProtoReq();
      ((ProtoReqManagerImpl.ProtoReq)localObject).setEasyRetryMode();
      ((ProtoReqManagerImpl.ProtoReq)localObject).ssoCmd = "ProfileService.Pb.ReqNextSystemMsg.Group";
      ((ProtoReqManagerImpl.ProtoReq)localObject).reqBody = localReqNextSystemMsg.toByteArray();
      ((ProtoReqManagerImpl.ProtoReq)localObject).busiData = new Integer(paramInt);
      ((ProtoReqManagerImpl.ProtoReq)localObject).callback = new SystemMessageProcessor.10(this);
      ((IProtoReqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq((ProtoReqManagerImpl.ProtoReq)localObject);
      return;
      localReqNextSystemMsg.following_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("following_group_seq"));
    }
  }
  
  public void d()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_suspicious_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l);
    localReqSystemMsgRead.uint32_req_msg_type.set(2);
    localReqSystemMsgRead.type.set(1);
    localReqSystemMsgRead.checktype.set(3);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "clearSystemMsg latestGroupSeq=" + l);
    }
    a(true, true, false, 0L, new SystemMessageProcessor.7(this, l, localReqSystemMsgRead));
  }
  
  public void e()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_friend_seq_47");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l2);
    localReqSystemMsgRead.type.set(1);
    localReqSystemMsgRead.checktype.set(3);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "clearSystemMsg latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
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
    ((Oidb_0x5cf.ReqBody)localObject).uint64_touin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().makeOIDBPkg("OidbSvc.0x5cf_1", 1487, 0, ((Oidb_0x5cf.ReqBody)localObject).toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("ProfileService.Pb.ReqNextSystemMsg.Friend");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsgfollowing_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("following_friend_seq_47"));
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(20);
    localReqNextSystemMsg.following_friend_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().e("following_friend_seq_47"));
    localReqNextSystemMsg.checktype.set(2);
    localReqNextSystemMsg.version.set(1000);
    localReqNextSystemMsg.friend_msg_type_flag.set(1L);
    Object localObject = new structmsg.FlagInfo();
    ((structmsg.FlagInfo)localObject).FrdMsg_GetBusiCard.set(1);
    ((structmsg.FlagInfo)localObject).FrdMsg_Discuss2ManyChat.set(1);
    ((structmsg.FlagInfo)localObject).FrdMsg_NeedWaitingMsg.set(1);
    localReqNextSystemMsg.flag.set((MessageMicro)localObject);
    localObject = new ProtoReqManagerImpl.ProtoReq();
    ((ProtoReqManagerImpl.ProtoReq)localObject).setEasyRetryMode();
    ((ProtoReqManagerImpl.ProtoReq)localObject).ssoCmd = "ProfileService.Pb.ReqNextSystemMsg.Friend";
    ((ProtoReqManagerImpl.ProtoReq)localObject).reqBody = localReqNextSystemMsg.toByteArray();
    ((ProtoReqManagerImpl.ProtoReq)localObject).callback = new SystemMessageProcessor.9(this);
    ((IProtoReqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq((ProtoReqManagerImpl.ProtoReq)localObject);
  }
  
  public void h()
  {
    c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor
 * JD-Core Version:    0.7.0.1
 */