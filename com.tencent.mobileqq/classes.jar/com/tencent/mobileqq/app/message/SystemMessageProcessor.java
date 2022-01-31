package com.tencent.mobileqq.app.message;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
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
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
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
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import zqv;
import zqw;
import zqx;
import zqy;
import zqz;
import zra;
import zrb;
import zrc;
import zrd;

public class SystemMessageProcessor
  extends BaseMessageProcessor
{
  private ArrayList a;
  private int d;
  private int e;
  private int f;
  private final int g = 2;
  private final int h = 2;
  private final int i = 2;
  
  public SystemMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.K, 0);
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
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l4 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int j = paramToServiceMsg.extraData.getInt("type");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label123;
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      paramToServiceMsg.getClass();
      if (!paramFromServiceMsg.a(paramToServiceMsg, "msf")) {
        break label123;
      }
    }
    label123:
    while ((480000L != l4) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReportError type=" + j + ";reqSeq=" + l3 + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (paramRspSystemMsgNew != null)
    {
      if ((paramRspSystemMsgNew != null) && (paramRspSystemMsgNew.head.result.get() == 0)) {
        break label133;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, "rspSystemMsg.head.result.get()" + paramRspSystemMsgNew.head.result.get());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    }
    label133:
    do
    {
      for (;;)
      {
        return;
        try
        {
          for (;;)
          {
            paramRspSystemMsgNew = new structmsg.RspSystemMsgNew();
            try
            {
              paramRspSystemMsgNew.mergeFrom((byte[])paramObject);
            }
            catch (Exception localException1)
            {
              paramObject = paramRspSystemMsgNew;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            FriendsManager localFriendsManager;
            Object localObject1;
            int n;
            int m;
            boolean bool1;
            NewFriendManager localNewFriendManager;
            int j;
            int k;
            long l1;
            long l2;
            Object localObject2;
            String str;
            boolean bool2;
            int i1;
            long l3;
            paramObject = null;
            continue;
            continue;
            paramObject = "";
          }
        }
      }
      paramRspSystemMsgNew = paramObject;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb error:", localException1);
      paramRspSystemMsgNew = paramObject;
      break;
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localObject1 = paramRspSystemMsgNew.friendmsgs.get();
      n = ((List)localObject1).size();
      m = paramRspSystemMsgNew.unread_friend_count.get();
      if (paramRspSystemMsgNew.uint32_over.get() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1);
        localNewFriendManager = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
        j = localNewFriendManager.c();
        FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m);
        k = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "processFriendSystemMsg-->requestFrom:" + k);
        }
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder(128);
          paramObject.append("<---handleGetFriendSystemMsgResp : decode pb MsgsSize = ").append(n).append(" latest_friend_seq").append(paramRspSystemMsgNew.latest_friend_seq.get()).append(" latest_group_seq").append(paramRspSystemMsgNew.latest_group_seq.get()).append(" following_friend_seq").append(paramRspSystemMsgNew.following_friend_seq.get()).append(" following_group_seq").append(paramRspSystemMsgNew.following_group_seq.get()).append(" unreadCount").append(m).append(" localunreadCount").append(j).append(" isSysMsgOver").append(bool1);
          QLog.d("Q.systemmsg.", 2, paramObject.toString());
        }
        if ((m != 0) || (n != 0) || (k != 2)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.K, 0);
        localNewFriendManager.a();
        a(4014, true, null);
        return;
      }
      if (!paramRspSystemMsgNew.msg_display.has()) {
        break label1866;
      }
      paramObject = paramRspSystemMsgNew.msg_display.get();
      l1 = 0L;
      if (((List)localObject1).size() > 0)
      {
        l2 = ((structmsg.StructMsg)((List)localObject1).get(0)).msg_time.get();
        localObject2 = ((structmsg.StructMsg)((List)localObject1).get(0)).msg;
        l1 = l2;
        if (localObject2 != null)
        {
          l1 = l2;
          if (((structmsg.SystemMsg)localObject2).has())
          {
            if ((((structmsg.SystemMsg)localObject2).bytes_game_nick.has()) && (((structmsg.StructMsg)((List)localObject1).get(0)).req_uin.has()))
            {
              str = ((structmsg.SystemMsg)localObject2).bytes_game_nick.get().toStringUtf8();
              l1 = ((structmsg.StructMsg)((List)localObject1).get(0)).req_uin.get();
              KplRoleInfo.saveGameNickWithUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), str);
            }
            if (((structmsg.SystemMsg)localObject2).bytes_game_msg.has())
            {
              localObject2 = ((structmsg.SystemMsg)localObject2).bytes_game_msg.get().toStringUtf8();
              KplRoleInfo.saveKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
            }
            l1 = l2;
            if (paramRspSystemMsgNew.bytes_game_nick.has())
            {
              KplRoleInfo.saveGameNickWithUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg.getUin(), paramRspSystemMsgNew.bytes_game_nick.get());
              l1 = l2;
            }
          }
        }
      }
      this.d = 0;
      k = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47") != paramRspSystemMsgNew.latest_friend_seq.get()) {
        break label855;
      }
      if ((m == 0) || (l1 != 0L)) {
        break label797;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SystemMessageProcessor", 2, "sentSeq == respSeq | unreadCount = " + m + " | newFriendLastMsgTime = 0");
    return;
    label797:
    paramToServiceMsg = paramObject;
    if (TextUtils.isEmpty(paramObject)) {
      paramToServiceMsg = a();
    }
    if ((j != m) && (m == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.K, 0, true, true);
    }
    localNewFriendManager.a(new FriendSystemMessage(paramToServiceMsg, l1));
    return;
    label855:
    j = k;
    if (m == 0)
    {
      j = k;
      if (n == 0) {
        j = 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47", paramRspSystemMsgNew.latest_friend_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47", paramRspSystemMsgNew.following_friend_seq.get());
    FriendSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (j == 0)
    {
      paramRspSystemMsgNew = new ArrayList(n);
      if (paramFromServiceMsg.getUin() == null)
      {
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if (m <= 0) {
          break label1299;
        }
        bool1 = true;
        label968:
        j = 0;
        label971:
        if (j >= n) {
          break label1341;
        }
        paramFromServiceMsg = MessageRecordFactory.a(-2050);
        paramFromServiceMsg.msgtype = -2050;
        paramFromServiceMsg.selfuin = paramToServiceMsg;
        paramFromServiceMsg.frienduin = AppConstants.K;
        paramFromServiceMsg.senderuin = (((structmsg.StructMsg)((List)localObject1).get(j)).req_uin.get() + "");
        paramFromServiceMsg.istroop = 0;
        paramFromServiceMsg.time = ((structmsg.StructMsg)((List)localObject1).get(j)).msg_time.get();
        if (((structmsg.StructMsg)((List)localObject1).get(j)).uint32_unread_flag.get() != 0) {
          break label1305;
        }
        bool2 = true;
        label1095:
        paramFromServiceMsg.isread = bool2;
        localObject2 = (MessageForSystemMsg)paramFromServiceMsg;
        ((MessageForSystemMsg)localObject2).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject1).get(j)).get());
        k = ((MessageForSystemMsg)localObject2).structMsg.msg_type.get();
        i1 = ((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get();
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp|i = " + j + ", isRead = " + paramFromServiceMsg.isread + ", time = " + paramFromServiceMsg.time + ", uin = " + paramFromServiceMsg.senderuin);
        }
        if (j != 0) {
          break label1863;
        }
        paramFromServiceMsg.extStr = paramObject;
        if (i1 != 13) {
          break label1863;
        }
        bool1 = false;
        if ((k != 1) || (SystemMsgUtils.a(i1))) {
          break label1311;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb filtered");
        }
      }
      for (;;)
      {
        j += 1;
        break label971;
        paramToServiceMsg = paramFromServiceMsg.getUin();
        break;
        label1299:
        bool1 = false;
        break label968;
        label1305:
        bool2 = false;
        break label1095;
        label1311:
        paramFromServiceMsg.msgData = ((MessageForSystemMsg)localObject2).structMsg.toByteArray();
        ((ChatMessage)paramFromServiceMsg).parse();
        paramRspSystemMsgNew.add(localObject2);
      }
      label1341:
      if (paramRspSystemMsgNew.size() > 0)
      {
        l2 = ((MessageRecord)paramRspSystemMsgNew.get(paramRspSystemMsgNew.size() - 1)).time;
        l3 = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.K, 0, l3);
        localObject1 = paramFromServiceMsg.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
          if (((ChatMessage)localObject2).time >= l2)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.K, 0, ((ChatMessage)localObject2).uniseq, false);
            ((Iterator)localObject1).remove();
          }
          else if ((localObject2 instanceof MessageForSystemMsg))
          {
            Object localObject3 = (MessageForSystemMsg)localObject2;
            if (((MessageForSystemMsg)localObject3).structMsg == null) {
              ((MessageForSystemMsg)localObject3).parse();
            }
            str = ((MessageForSystemMsg)localObject3).senderuin;
            j = ((MessageForSystemMsg)localObject3).structMsg.msg.sub_type.get();
            if ((j == 13) && (localFriendsManager.b(str)))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.K, 0, ((ChatMessage)localObject2).uniseq, false);
              ((Iterator)localObject1).remove();
            }
            else if ((j == 1) || (j == 13))
            {
              localObject3 = paramRspSystemMsgNew.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                Object localObject4 = (MessageRecord)((Iterator)localObject3).next();
                if ((localObject4 instanceof MessageForSystemMsg))
                {
                  k = ((MessageForSystemMsg)localObject4).structMsg.msg.sub_type.get();
                  localObject4 = ((MessageRecord)localObject4).senderuin;
                  if ((k == j) && (localObject4 != null) && (((String)localObject4).equals(str)))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.K, 0, ((ChatMessage)localObject2).uniseq, false);
                    ((Iterator)localObject1).remove();
                  }
                }
              }
            }
          }
        }
        if (paramFromServiceMsg.size() == 0)
        {
          FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2);
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          paramToServiceMsg = String.valueOf(paramToServiceMsg);
          if ((!MessageHandlerUtils.a(paramRspSystemMsgNew)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
            break label1833;
          }
          bool2 = true;
          label1750:
          paramFromServiceMsg.a(paramRspSystemMsgNew, paramToServiceMsg, bool2);
          localNewFriendManager.a(true);
          a(paramRspSystemMsgNew);
          a("handleGetSystemMsgResp", true, m, bool1, false);
          label1784:
          localNewFriendManager.a(new FriendSystemMessage(paramObject, l1));
        }
      }
    }
    for (;;)
    {
      a(4005, true, null);
      return;
      if (paramRspSystemMsgNew.size() >= 20) {
        break;
      }
      FriendSystemMsgController.a().a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label1833:
      bool2 = false;
      break label1750;
      localNewFriendManager.a(true);
      break label1784;
      localNewFriendManager.a();
    }
  }
  
  private void a(List paramList)
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.C, 4000);
    localRecentUser.msgType = 22;
    localRecentUser.displayName = "新朋友";
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
      localRecentUserProxy.a(localRecentUser);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        ((StringBuilder)localObject1).setLength(0);
        if (QLog.isColorLevel()) {
          QLog.e("SystemMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception localException2)
      {
        break label115;
      }
      paramFromServiceMsg.getUin();
      continue;
      label115:
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
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SystemMessageProcessor", 4, "processGroupSystemMsg");
    }
    int i2 = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
    j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->requestFrom:" + i2);
    }
    String str;
    if (paramFromServiceMsg.getUin() == null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (paramRspSystemMsgNew == null) {
        break label151;
      }
      label84:
      paramObject = new StringBuilder();
      if ((paramRspSystemMsgNew != null) && (paramRspSystemMsgNew.head.result.get() == 0)) {
        break label207;
      }
      paramObject.setLength(0);
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, paramObject.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    }
    label151:
    label207:
    do
    {
      for (;;)
      {
        return;
        str = paramFromServiceMsg.getUin();
        break;
        try
        {
          for (;;)
          {
            paramRspSystemMsgNew = new structmsg.RspSystemMsgNew();
            try
            {
              paramRspSystemMsgNew.mergeFrom((byte[])paramObject);
            }
            catch (Exception localException1)
            {
              paramObject = paramRspSystemMsgNew;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i3;
            int i4;
            int k;
            int n;
            Object localObject1;
            MessageForSystemMsg localMessageForSystemMsg;
            int i5;
            int i1;
            Object localObject2;
            Object localObject3;
            boolean bool;
            paramObject = null;
            continue;
            long l2 = -1L;
            continue;
            long l1 = -1L;
            continue;
            j = -1;
            continue;
            j = k;
            int m = i1;
            continue;
            j = 1;
          }
        }
      }
      paramRspSystemMsgNew = paramObject;
      if (!QLog.isColorLevel()) {
        break label84;
      }
      QLog.e("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb error:", localException1);
      paramRspSystemMsgNew = paramObject;
      break label84;
      paramFromServiceMsg = paramRspSystemMsgNew.groupmsgs.get();
      i3 = paramFromServiceMsg.size();
      i4 = paramRspSystemMsgNew.unread_group_count.get();
      k = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb groupMsgsSize = " + i3 + " latest_friend_seq" + paramRspSystemMsgNew.latest_friend_seq.get() + " latest_group_seq" + paramRspSystemMsgNew.latest_group_seq.get() + " following_friend_seq" + paramRspSystemMsgNew.following_friend_seq.get() + " following_group_seq" + paramRspSystemMsgNew.following_group_seq.get() + " unreadCount" + i4 + " localUnreadCount" + k);
      }
    } while (i3 == 0);
    this.d = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq", paramRspSystemMsgNew.latest_group_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq", paramRspSystemMsgNew.following_group_seq.get());
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i4);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.S, 9000, i4 - k);
    paramObject = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.L, 0, true, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.O, 0, true, false);
    GroupSystemMsgController.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Collections.sort(paramFromServiceMsg, new zqv(this));
    n = 0;
    if (n < i3)
    {
      localObject1 = MessageRecordFactory.a(-2018);
      ((MessageRecord)localObject1).msgtype = -2018;
      ((MessageRecord)localObject1).selfuin = str;
      ((MessageRecord)localObject1).frienduin = AppConstants.L;
      m = ((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg.group_msg_type.get();
      k = TroopUtils.a(m);
      if (k == 1) {
        ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg.action_uin.get() + "");
      }
      for (;;)
      {
        ((MessageRecord)localObject1).istroop = 0;
        localMessageForSystemMsg = (MessageForSystemMsg)localObject1;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)paramFromServiceMsg.get(n)).get());
        k = localMessageForSystemMsg.structMsg.msg_type.get();
        i5 = localMessageForSystemMsg.structMsg.msg.sub_type.get();
        if ((k != 1) || (SystemMsgUtils.a(i5))) {
          break label782;
        }
        k = j;
        n += 1;
        j = k;
        break;
        if (k == 2) {
          ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)paramFromServiceMsg.get(n)).req_uin.get() + "");
        }
      }
      label782:
      if (i5 == 1) {
        ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg.action_uin.get() + "");
      }
      i1 = 1;
      if ((i2 == 1) && (j == 0))
      {
        k = 1;
        if ((m == 2) && (i5 == 2))
        {
          localObject2 = String.valueOf(((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg.group_code.get());
          localObject3 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (((TroopManager)localObject3).a((String)localObject2) == null)
          {
            paramToServiceMsg = new TroopInfo();
            paramToServiceMsg.troopuin = ((String)localObject2);
            ((TroopManager)localObject3).a(paramToServiceMsg);
            localObject3 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            ((TroopHandler)localObject3).b(paramToServiceMsg.troopuin, false);
            ((TroopHandler)localObject3).a(paramToServiceMsg.troopuin, (byte)1, paramToServiceMsg.dwTimeStamp, 0);
          }
          if (localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.has())
          {
            j = ((structmsg.MsgInviteExt)localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.get()).uint32_wait_state.get();
            label1010:
            if ((j != 2) && (j != 4)) {
              break label3012;
            }
            paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            paramToServiceMsg.d(paramToServiceMsg.a((String)localObject2));
            l1 = localMessageForSystemMsg.structMsg.msg.action_uin.get();
            k = -1;
            paramToServiceMsg = null;
            if (localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.uint32_src_type.has())
            {
              k = localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.uint32_src_type.get();
              paramToServiceMsg = String.valueOf(localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.uint64_src_code.get());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, -1L, true, String.valueOf(l1), k, paramToServiceMsg);
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + n + ":addFriendTipsMr");
            }
            if (j != 4) {
              break label3012;
            }
            j = 0;
            paramToServiceMsg = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.a((String)localObject2, Boolean.valueOf(false));
            }
            k = 1;
            m = j;
            j = k;
          }
        }
        for (;;)
        {
          ((MessageRecord)localObject1).msgData = localMessageForSystemMsg.structMsg.toByteArray();
          k = j;
          if (m == 0) {
            break;
          }
          paramObject.add(localMessageForSystemMsg);
          k = j;
          break;
          j = -1;
          break label1010;
          if (m == 3)
          {
            localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            paramToServiceMsg = ((TroopManager)localObject2).a(((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg.group_code.get() + "");
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg.dwCmdUinUinFlag = 1L;
              if (paramToServiceMsg.Administrator == null) {
                break label1518;
              }
              if (paramToServiceMsg.Administrator.startsWith("|")) {
                paramToServiceMsg.Administrator = paramToServiceMsg.Administrator.substring(1);
              }
              if (!paramToServiceMsg.Administrator.endsWith("|")) {}
            }
            label1518:
            for (paramToServiceMsg.Administrator = paramToServiceMsg.Administrator.substring(0, paramToServiceMsg.Administrator.length() - 1);; paramToServiceMsg.Administrator = "")
            {
              if (!paramToServiceMsg.Administrator.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                paramToServiceMsg.Administrator = (paramToServiceMsg.Administrator + "|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              }
              ((TroopManager)localObject2).b(paramToServiceMsg);
              localObject2 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
              if (localObject2 != null) {
                ((TroopHandler)localObject2).c(Long.parseLong(paramToServiceMsg.troopuin));
              }
              j = 1;
              m = i1;
              break;
            }
          }
          if (m == 19)
          {
            paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            localObject2 = paramToServiceMsg.a(((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg.group_code.get() + "");
            if (localObject2 != null)
            {
              ((TroopInfo)localObject2).dwCmdUinUinFlag = 1L;
              paramToServiceMsg.b((TroopInfo)localObject2);
            }
            j = 1;
            m = i1;
          }
          else if (m == 17)
          {
            paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            localObject2 = paramToServiceMsg.a(((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg.group_code.get() + "");
            if (localObject2 != null)
            {
              ((TroopInfo)localObject2).dwCmdUinUinFlag = 0L;
              paramToServiceMsg.b((TroopInfo)localObject2);
            }
            j = 1;
            m = i1;
          }
          else
          {
            if (m == 15)
            {
              paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              localObject2 = paramToServiceMsg.a(((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg.group_code.get() + "");
              if (localObject2 != null)
              {
                ((TroopInfo)localObject2).dwCmdUinUinFlag = 0L;
                if (((TroopInfo)localObject2).Administrator == null) {
                  break label1958;
                }
                if (((TroopInfo)localObject2).Administrator.startsWith("|")) {
                  ((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.substring(1);
                }
                if (!((TroopInfo)localObject2).Administrator.endsWith("|")) {}
              }
              label1958:
              for (((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.substring(0, ((TroopInfo)localObject2).Administrator.length() - 1);; ((TroopInfo)localObject2).Administrator = "")
              {
                ((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "|", "").replace("|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "").replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
                paramToServiceMsg.b((TroopInfo)localObject2);
                j = 1;
                m = i1;
                break;
              }
            }
            if ((m != 13) && (m != 6) && (m != 7)) {
              break label3001;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + n + ",msgTime:" + ((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg_time + ",msgType:" + m + ":delete troopMember, delete troop, clear local history");
            }
            paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            if (paramToServiceMsg != null)
            {
              localObject2 = ((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg.group_code.get() + "";
              paramToServiceMsg.c((String)localObject2, ((structmsg.StructMsg)paramFromServiceMsg.get(n)).req_uin.get() + "");
              if (m == 7)
              {
                paramToServiceMsg.b((String)localObject2);
                DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
              }
            }
            j = 1;
            m = i1;
          }
        }
      }
      k = j;
      if (m == 2)
      {
        k = j;
        if (i5 == 2)
        {
          localObject2 = String.valueOf(((structmsg.StructMsg)paramFromServiceMsg.get(n)).msg.group_code.get());
          if (localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.has()) {}
          for (m = ((structmsg.MsgInviteExt)localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.get()).uint32_wait_state.get();; m = -1)
          {
            if (m != 2)
            {
              k = j;
              if (m != 4) {
                break label3001;
              }
            }
            if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b((String)localObject2) <= 0L)
            {
              l1 = localMessageForSystemMsg.structMsg.msg.action_uin.get();
              k = -1;
              paramToServiceMsg = null;
              if (localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.uint32_src_type.has())
              {
                k = localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.uint32_src_type.get();
                paramToServiceMsg = String.valueOf(localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.uint64_src_code.get());
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, -1L, true, String.valueOf(l1), k, paramToServiceMsg);
            }
            k = j;
            if (m != 4) {
              break label3001;
            }
            m = 0;
            break;
          }
        }
      }
    }
    else
    {
      if (paramObject.size() > 0)
      {
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject1 = String.valueOf(str);
        if ((!MessageHandlerUtils.a(paramObject)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
          break label2966;
        }
      }
      label2966:
      for (bool = true;; bool = false)
      {
        paramToServiceMsg.a(paramObject, (String)localObject1, bool);
        a("handleGetSystemMsgResp", true, i4, false, false);
        if (!TextUtils.isEmpty(paramRspSystemMsgNew.grp_msg_display.get())) {
          GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspSystemMsgNew.grp_msg_display.get());
        }
        if ((paramRspSystemMsgNew.msg_ribbon_group.has()) && (paramRspSystemMsgNew.msg_ribbon_group.get() != null))
        {
          paramRspSystemMsgNew = (structmsg.StructMsg)paramRspSystemMsgNew.msg_ribbon_group.get();
          paramToServiceMsg = MessageRecordFactory.a(-2018);
          paramToServiceMsg.selfuin = str;
          paramToServiceMsg.frienduin = AppConstants.O;
          paramToServiceMsg.senderuin = (paramRspSystemMsgNew.req_uin.get() + "");
          paramToServiceMsg.istroop = 0;
          localObject1 = (MessageForSystemMsg)paramToServiceMsg;
          ((MessageForSystemMsg)localObject1).structMsg = paramRspSystemMsgNew;
          paramToServiceMsg.msgData = ((MessageForSystemMsg)localObject1).structMsg.toByteArray();
          paramRspSystemMsgNew = new ArrayList();
          paramRspSystemMsgNew.add(paramToServiceMsg);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspSystemMsgNew, String.valueOf(str), true);
          if (QLog.isColorLevel()) {
            QLog.d("Q.systemmsg.", 2, "ribbon info");
          }
        }
        paramToServiceMsg = (RecentManagerFor3rdPart)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
        paramObject = ((MessageForSystemMsg)paramObject.get(0)).getSystemMsg();
        GroupSystemMsgController.a().a(paramObject);
        l1 = paramObject.msg_time.get();
        paramToServiceMsg.a(AppConstants.S, 9000, "群通知", l1, l1);
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if (paramToServiceMsg != null) {
          paramToServiceMsg.sendMessage(paramToServiceMsg.obtainMessage(1009));
        }
        paramToServiceMsg = (structmsg.StructMsg)paramFromServiceMsg.get(0);
        if (paramToServiceMsg.msg.has())
        {
          if (!((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_msg_type.has()) {
            break label2995;
          }
          j = ((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_msg_type.get();
          if (!((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_code.has()) {
            break label2987;
          }
          l1 = ((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_code.get();
          if (!paramToServiceMsg.req_uin.has()) {
            break;
          }
          l2 = paramToServiceMsg.req_uin.get();
          if ((j != -1) && (l2 != -1L) && (l1 != -1L)) {
            a(j, l1, l2);
          }
        }
        a(4005, true, null);
        return;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("latestFriendSeq");
    long l2 = paramToServiceMsg.extraData.getLong("latestGroupSeq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    int j = paramToServiceMsg.extraData.getInt("type");
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
        int k = paramToServiceMsg.head.result.get();
        if (k == 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l3);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReport type =" + j + ";reqSeq=" + l3 + ";resultCode=" + k + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SystemMessageProcessor", 2, "<---handleSendSystemMsgReadedReport :type = " + j + " decode pb:", paramFromServiceMsg);
          }
        }
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        int j;
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
        j = -1;
        if (paramFromServiceMsg.remark_result.has()) {
          j = paramFromServiceMsg.remark_result.get();
        }
        paramToServiceMsg.extraData.putString("system_msg_action_resp_key", paramObject);
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", paramFromServiceMsg.head.result.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", paramFromServiceMsg.type.get());
        paramToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", paramFromServiceMsg.msg_invalid_decided.get());
        paramToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", j);
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
  
  private void g()
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
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l1);
    localReqSystemMsgRead.latest_group_seq.set(l2);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "sendSystemMsgReadedReport latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new zqy(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l2 = 0L;
    Object localObject1 = null;
    Object localObject2;
    int j;
    structmsg.ReqSystemMsgNew localReqSystemMsgNew;
    PBUInt64Field localPBUInt64Field;
    switch (paramInt1)
    {
    default: 
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew";
      j = 0;
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "<---sendGetSystemMsg type=" + paramInt1 + " latest_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47") + " latest_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq"));
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((String)localObject2);
      localReqSystemMsgNew = new structmsg.ReqSystemMsgNew();
      localReqSystemMsgNew.msg_num.set(20);
      localReqSystemMsgNew.checktype.set(j);
      localPBUInt64Field = localReqSystemMsgNew.latest_friend_seq;
      if (paramBoolean)
      {
        l1 = 0L;
        label171:
        localPBUInt64Field.set(l1);
        localPBUInt64Field = localReqSystemMsgNew.latest_group_seq;
        if (!paramBoolean) {
          break label633;
        }
      }
      break;
    }
    label633:
    for (long l1 = l2;; l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq"))
    {
      localPBUInt64Field.set(l1);
      if (localObject1 != null) {
        localReqSystemMsgNew.flag.set((MessageMicro)localObject1);
      }
      localReqSystemMsgNew.is_get_frd_ribbon.set(false);
      localReqSystemMsgNew.version.set(1000);
      localReqSystemMsgNew.is_get_grp_ribbon.set(false);
      localReqSystemMsgNew.friend_msg_type_flag.set(1L);
      ((ToServiceMsg)localObject2).extraData.putInt("getSystemMsgSender", paramInt2);
      ((ToServiceMsg)localObject2).putWupBuffer(localReqSystemMsgNew.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ToServiceMsg)localObject2);
      return;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew";
      j = 4;
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
      break;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).FrdMsg_GetBusiCard.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_uint32_need_all_unread_msg.set(1);
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew.Friend";
      j = 2;
      break;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew.Group";
      j = 3;
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
      break;
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
      break label171;
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6)
  {
    a(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4, paramInt5, paramSystemMsgActionInfo, paramInt6, "");
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, String paramString)
  {
    long l = paramInt1 + paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgAction logStr=" + l);
    }
    paramString = new structmsg.ReqSystemMsgAction();
    paramString.msg_type.set(paramInt1);
    paramString.msg_seq.set(paramLong1);
    paramString.req_uin.set(paramLong2);
    paramString.sub_type.set(paramInt2);
    paramString.src_id.set(paramInt3);
    paramString.sub_src_id.set(paramInt4);
    paramString.group_msg_type.set(paramInt5);
    paramString.action_info.set(paramSystemMsgActionInfo);
    paramString.language.set(1000);
    paramSystemMsgActionInfo = new ProtoReqManager.ProtoReq();
    paramSystemMsgActionInfo.a();
    paramSystemMsgActionInfo.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Group";
    paramSystemMsgActionInfo.jdField_a_of_type_ArrayOfByte = paramString.toByteArray();
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqSystemMsgAction.Group");
    paramString.addAttribute("_tag_LOGSTR", String.valueOf(l));
    paramString.extraData.putInt("system_msg_action_type", paramInt6);
    paramSystemMsgActionInfo.jdField_a_of_type_JavaLangObject = paramString;
    paramSystemMsgActionInfo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new zqw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(paramSystemMsgActionInfo);
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
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.a();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Friend";
    localProtoReq.jdField_a_of_type_ArrayOfByte = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqSystemMsgAction.Friend");
    ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", String.valueOf(l));
    ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
    ((ToServiceMsg)localObject).extraData.putBoolean("isUncommonlyUsedFrd", paramBoolean);
    localProtoReq.jdField_a_of_type_JavaLangObject = localObject;
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new zqx(this, paramInt6, paramInt3, paramSystemMsgActionInfo, paramStructMsg, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localProtoReq);
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
      this.d = 0;
      return;
    case 6001: 
      this.e = 0;
      return;
    case 6003: 
      this.f = 0;
      return;
    case 6006: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    b(4015, false, paramToServiceMsg);
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
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
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
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 6007: 
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
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    b(4015, false, null);
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong1, int paramInt, byte[] paramArrayOfByte, long paramLong2, long paramLong3, long paramLong4)
  {
    if ((paramInt == 85) || (paramInt == 36))
    {
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      TroopInfo localTroopInfo2 = localTroopManager.a(String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte)));
      TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      TroopInfo localTroopInfo1 = localTroopInfo2;
      if (localTroopInfo2 == null)
      {
        localTroopInfo1 = new TroopInfo();
        localTroopInfo1.troopuin = String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte));
        localTroopInfo1.troopcode = String.valueOf(paramLong2);
        localTroopManager.a(localTroopInfo1);
        localTroopHandler.a(localTroopInfo1.troopuin, (byte)1, localTroopInfo1.dwTimeStamp, 0);
      }
      localTroopHandler.a(localTroopInfo1.troopuin, Boolean.valueOf(false));
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "handleTroopSystemMessageResp-->msgTime:" + paramLong3 + ":addFriendTipsMr");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(localTroopInfo1.troopuin, paramLong3, true, null);
      b(2001, true, null);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int paramInt3)
  {
    String str = String.valueOf(paramLong2);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if ((paramInt1 == 188) || (paramInt1 == 189))
    {
      g();
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt3))) {}
    }
    while (paramInt1 != 190)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt3));
      str = String.valueOf(str);
      if (paramLong1 == paramLong2) {}
      for (boolean bool = true;; bool = false)
      {
        localFriendListHandler.a(str, 0, 3999, null, bool, false, paramLong3);
        return;
      }
    }
    localFriendsManager.a(str, false);
  }
  
  public void a(long paramLong1, long paramLong2, short paramShort, int paramInt1, msg_comm.Msg paramMsg, int paramInt2)
  {
    String str = String.valueOf(paramLong2);
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if ((paramShort == 188) || (paramShort == 189))
    {
      g();
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt2))) {}
    }
    while (paramShort != 190)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt2));
      localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      localObject = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, HexUtil.a((byte[])localObject), String.valueOf(str), paramInt1);
      if (localObject != null) {}
      for (localObject = ((SystemMsg)localObject).strGameName;; localObject = "")
      {
        localFriendListHandler.a(String.valueOf(str), 0, 3999, (String)localObject, true, false, paramMsg.msg_head.msg_time.get());
        return;
      }
    }
    ((FriendsManager)localObject).a(str, false);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      b(4015, false, null);
      return;
    }
    Oidb_0x5cf.RspBody localRspBody = new Oidb_0x5cf.RspBody();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int j = MessageHandler.a(paramFromServiceMsg, paramObject, localRspBody);
    if (j == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("frienduin");
      j = paramToServiceMsg.extraData.getInt("istroop");
      long l = paramToServiceMsg.extraData.getLong("uniseq");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFromServiceMsg, j, l, false);
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "<---handleGetDelSingleSysMsg Success!");
      }
      b(4014, true, paramToServiceMsg);
      return;
    }
    if (j == 1)
    {
      b(4014, true, paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---handleGetDelSingleSysMsg Error!");
    }
    b(4015, false, paramToServiceMsg);
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
      paramStructMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("OidbSvc.0x5cf_0", 1487, 0, localReqBody.toByteArray());
      paramStructMsg.extraData.putString("frienduin", paramString);
      paramStructMsg.extraData.putInt("istroop", paramInt);
      paramStructMsg.extraData.putLong("uniseq", paramLong);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramStructMsg);
      return;
      localObject = new Oidb_0x5cf.DelDecideInfo();
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint64_uin.set(paramStructMsg.req_uin.get());
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint32_time.set((int)paramStructMsg.msg_time.get());
      ((Oidb_0x5cf.DelDecideInfo)localObject).uint32_req_type.set(paramStructMsg.msg.sub_type.get());
      localDelMsgInfo.rpt_msg_decide_info.add((MessageMicro)localObject);
    }
  }
  
  public void b()
  {
    int j = MobileQQService.a;
    MobileQQService.a = j + 1;
    long l1 = j;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendSystemMsgReadedReport reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l2);
    localReqSystemMsgRead.checktype.set(2);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Friend";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new zqz(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localProtoReq);
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
      if (this.d < 2)
      {
        this.d += 1;
        a(4);
        return;
      }
      this.d = 0;
      return;
    case 6001: 
      if (this.e < 2)
      {
        this.e += 1;
        a(2);
        return;
      }
      this.e = 0;
      return;
    case 6003: 
      if (this.f < 2)
      {
        this.f += 1;
        a(3);
        return;
      }
      this.f = 0;
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
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "handleGetDelSingleSysMsg Error!");
    }
    b(4015, false, paramToServiceMsg);
  }
  
  public void c()
  {
    int j = MobileQQService.a;
    MobileQQService.a = j + 1;
    long l1 = j;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendGroupSystemMsgReadedReport reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l3);
    localReqSystemMsgRead.checktype.set(3);
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Group";
    localProtoReq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new zra(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localProtoReq);
  }
  
  public void d()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_friend_seq_47");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l2);
    localReqSystemMsgRead.type.set(1);
    localReqSystemMsgRead.checktype.set(3);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "clearSystemMsg latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new zrb(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqNextSystemMsg.Friend");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsgfollowing_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47"));
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(20);
    localReqNextSystemMsg.following_friend_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_friend_seq_47"));
    localReqNextSystemMsg.checktype.set(2);
    localReqNextSystemMsg.version.set(1000);
    localReqNextSystemMsg.friend_msg_type_flag.set(1L);
    Object localObject = new structmsg.FlagInfo();
    ((structmsg.FlagInfo)localObject).FrdMsg_GetBusiCard.set(1);
    ((structmsg.FlagInfo)localObject).FrdMsg_Discuss2ManyChat.set(1);
    ((structmsg.FlagInfo)localObject).FrdMsg_NeedWaitingMsg.set(1);
    localReqNextSystemMsg.flag.set((MessageMicro)localObject);
    localObject = new ProtoReqManager.ProtoReq();
    ((ProtoReqManager.ProtoReq)localObject).a();
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Friend";
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new zrc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a((ProtoReqManager.ProtoReq)localObject);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("ProfileService.Pb.ReqNextSystemMsg.Group");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsgfollowing_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq"));
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(20);
    localReqNextSystemMsg.following_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d("following_group_seq"));
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
    localReqNextSystemMsg.flag.set((MessageMicro)localObject);
    localObject = new ProtoReqManager.ProtoReq();
    ((ProtoReqManager.ProtoReq)localObject).a();
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Group";
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
    ((ProtoReqManager.ProtoReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = new zrd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a((ProtoReqManager.ProtoReq)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor
 * JD-Core Version:    0.7.0.1
 */