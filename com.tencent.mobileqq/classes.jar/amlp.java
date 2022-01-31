import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
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
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.ProtoReqManager;
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

public class amlp
  extends absm
{
  private ArrayList<Integer> a;
  private int d;
  private int e;
  private int f;
  private final int g = 2;
  private final int h = 2;
  private final int i = 2;
  
  public amlp(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.M, 0);
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
    if ((paramInt == 7) || (paramInt == 8)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramLong1);
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
            Object localObject1;
            Object localObject2;
            int n;
            int m;
            int k;
            boolean bool1;
            alxr localalxr;
            int j;
            int i1;
            long l1;
            long l2;
            Object localObject3;
            String str;
            long l3;
            boolean bool2;
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
      localObject1 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject2 = paramRspSystemMsgNew.friendmsgs.get();
      n = ((List)localObject2).size();
      m = paramRspSystemMsgNew.unread_friend_count.get();
      k = paramRspSystemMsgNew.uint32_un_read_count3.get();
      if (paramRspSystemMsgNew.uint32_over.get() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1);
        localalxr = (alxr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
        j = localalxr.c();
        bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m);
        i1 = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "processFriendSystemMsg-->requestFrom:" + i1);
        }
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder(128);
          paramObject.append("<---handleGetFriendSystemMsgResp : decode pb MsgsSize = ").append(n).append(" latest_friend_seq").append(paramRspSystemMsgNew.latest_friend_seq.get()).append(" latest_group_seq").append(paramRspSystemMsgNew.latest_group_seq.get()).append(" following_friend_seq").append(paramRspSystemMsgNew.following_friend_seq.get()).append(" following_group_seq").append(paramRspSystemMsgNew.following_group_seq.get()).append(" unreadCount").append(m).append(" localunreadCount").append(j).append(" isSysMsgOver").append(bool1).append(" unreadCountForSuspicious").append(k);
          QLog.d("Q.systemmsg.", 2, paramObject.toString());
        }
        if ((m != 0) || (n != 0) || (i1 != 2)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.M, 0);
        localalxr.b();
        a(4014, true, null);
        return;
      }
      if (!paramRspSystemMsgNew.msg_display.has()) {
        break label2018;
      }
      paramObject = paramRspSystemMsgNew.msg_display.get();
      l1 = 0L;
      if (((List)localObject2).size() > 0)
      {
        l2 = ((structmsg.StructMsg)((List)localObject2).get(0)).msg_time.get();
        localObject3 = ((structmsg.StructMsg)((List)localObject2).get(0)).msg;
        l1 = l2;
        if (localObject3 != null)
        {
          l1 = l2;
          if (((structmsg.SystemMsg)localObject3).has())
          {
            if ((((structmsg.SystemMsg)localObject3).bytes_game_nick.has()) && (((structmsg.StructMsg)((List)localObject2).get(0)).req_uin.has()))
            {
              str = ((structmsg.SystemMsg)localObject3).bytes_game_nick.get().toStringUtf8();
              l1 = ((structmsg.StructMsg)((List)localObject2).get(0)).req_uin.get();
              KplRoleInfo.saveGameNickWithUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), str);
            }
            if (((structmsg.SystemMsg)localObject3).bytes_game_msg.has())
            {
              localObject3 = ((structmsg.SystemMsg)localObject3).bytes_game_msg.get().toStringUtf8();
              KplRoleInfo.saveKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3);
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
      l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47");
      l3 = paramRspSystemMsgNew.latest_friend_seq.get();
      if (l2 != l3) {
        break label884;
      }
      if ((m == 0) || (l1 != 0L)) {
        break label826;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SystemMessageProcessor", 2, "sentSeq == respSeq | unreadCount = " + m + " | newFriendLastMsgTime = 0");
    return;
    label826:
    paramToServiceMsg = paramObject;
    if (TextUtils.isEmpty(paramObject)) {
      paramToServiceMsg = a();
    }
    if ((j != m) && (m == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.M, 0, true, true);
    }
    localalxr.a(new avui(paramToServiceMsg, l1));
    return;
    label884:
    j = k;
    if (m == 0)
    {
      j = k;
      if (n == 0) {
        j = 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47", paramRspSystemMsgNew.latest_friend_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_friend_seq_47", paramRspSystemMsgNew.following_friend_seq.get());
    bafi.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    label1328:
    label1334:
    label1340:
    label1876:
    if (j == 0)
    {
      paramRspSystemMsgNew = new ArrayList(n);
      if (paramFromServiceMsg.getUin() == null)
      {
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if (m <= 0) {
          break label1328;
        }
        bool1 = true;
        label997:
        j = 0;
        label1000:
        if (j >= n) {
          break label1370;
        }
        paramFromServiceMsg = azaf.a(-2050);
        paramFromServiceMsg.msgtype = -2050;
        paramFromServiceMsg.selfuin = paramToServiceMsg;
        paramFromServiceMsg.frienduin = alof.M;
        paramFromServiceMsg.senderuin = (((structmsg.StructMsg)((List)localObject2).get(j)).req_uin.get() + "");
        paramFromServiceMsg.istroop = 0;
        paramFromServiceMsg.time = ((structmsg.StructMsg)((List)localObject2).get(j)).msg_time.get();
        if (((structmsg.StructMsg)((List)localObject2).get(j)).uint32_unread_flag.get() != 0) {
          break label1334;
        }
        bool2 = true;
        label1124:
        paramFromServiceMsg.isread = bool2;
        localObject3 = (MessageForSystemMsg)paramFromServiceMsg;
        ((MessageForSystemMsg)localObject3).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(j)).get());
        k = ((MessageForSystemMsg)localObject3).structMsg.msg_type.get();
        i1 = ((MessageForSystemMsg)localObject3).structMsg.msg.sub_type.get();
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp|i = " + j + ", isRead = " + paramFromServiceMsg.isread + ", time = " + paramFromServiceMsg.time + ", uin = " + paramFromServiceMsg.senderuin);
        }
        if (j != 0) {
          break label2015;
        }
        paramFromServiceMsg.extStr = paramObject;
        if (i1 != 13) {
          break label2015;
        }
        bool1 = false;
        if ((k != 1) || (bafk.a(i1))) {
          break label1340;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb filtered");
        }
      }
      for (;;)
      {
        j += 1;
        break label1000;
        paramToServiceMsg = paramFromServiceMsg.getUin();
        break;
        bool1 = false;
        break label997;
        bool2 = false;
        break label1124;
        paramFromServiceMsg.msgData = ((MessageForSystemMsg)localObject3).structMsg.toByteArray();
        ((ChatMessage)paramFromServiceMsg).parse();
        paramRspSystemMsgNew.add(localObject3);
      }
      label1370:
      if (paramRspSystemMsgNew.size() > 0)
      {
        j = paramRspSystemMsgNew.size();
        l2 = ((MessageRecord)paramRspSystemMsgNew.get(j - 1)).time;
        l3 = bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.M, 0, l3);
        localObject2 = paramFromServiceMsg.iterator();
        if (j < 20) {
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (ChatMessage)((Iterator)localObject2).next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.M, 0, ((ChatMessage)localObject1).uniseq, false);
            ((Iterator)localObject2).remove();
          }
        }
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ChatMessage)((Iterator)localObject2).next();
          if (((ChatMessage)localObject3).time >= l2)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.M, 0, ((ChatMessage)localObject3).uniseq, false);
            ((Iterator)localObject2).remove();
          }
          else if ((localObject3 instanceof MessageForSystemMsg))
          {
            Object localObject4 = (MessageForSystemMsg)localObject3;
            if (((MessageForSystemMsg)localObject4).structMsg == null) {
              ((MessageForSystemMsg)localObject4).parse();
            }
            str = ((MessageForSystemMsg)localObject4).senderuin;
            j = ((MessageForSystemMsg)localObject4).structMsg.msg.sub_type.get();
            if ((j == 13) && (((alto)localObject1).b(str)))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.M, 0, ((ChatMessage)localObject3).uniseq, false);
              ((Iterator)localObject2).remove();
            }
            else if ((j == 1) || (j == 13))
            {
              localObject4 = paramRspSystemMsgNew.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                Object localObject5 = (MessageRecord)((Iterator)localObject4).next();
                if ((localObject5 instanceof MessageForSystemMsg))
                {
                  k = ((MessageForSystemMsg)localObject5).structMsg.msg.sub_type.get();
                  localObject5 = ((MessageRecord)localObject5).senderuin;
                  if ((k == j) && (localObject5 != null) && (((String)localObject5).equals(str)))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.M, 0, ((ChatMessage)localObject3).uniseq, false);
                    ((Iterator)localObject2).remove();
                  }
                }
              }
            }
          }
        }
        if (paramFromServiceMsg.size() == 0)
        {
          bafi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2);
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          paramToServiceMsg = String.valueOf(paramToServiceMsg);
          if ((!alww.a(paramRspSystemMsgNew)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
            break label1925;
          }
          bool2 = true;
          paramFromServiceMsg.a(paramRspSystemMsgNew, paramToServiceMsg, bool2);
          localalxr.a(true);
          a(paramRspSystemMsgNew);
          a("handleGetSystemMsgResp", true, m, bool1, false);
          localalxr.a(new avui(paramObject, l1));
        }
      }
    }
    for (;;)
    {
      label1842:
      a(4005, true, null);
      return;
      if (paramRspSystemMsgNew.size() >= 20) {
        break;
      }
      bafi.a().a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label1925:
      bool2 = false;
      break label1842;
      localalxr.a(true);
      break label1876;
      if (QLog.isColorLevel()) {
        QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : clear local data. sentSeq:" + l2 + " respSeq:" + l3);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.M, 0);
      localalxr.b();
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    amnz localamnz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localamnz.a(alof.D, 4000);
    localRecentUser.msgType = 26;
    localRecentUser.displayName = alxr.jdField_a_of_type_JavaLangString;
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
      localamnz.a(localRecentUser);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SystemMessageProcessor", 4, "processGroupSystemMsg");
    }
    int m = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
    bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->requestFrom:" + m);
    }
    String str1;
    if (paramFromServiceMsg.getUin() == null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localMessageForSystemMsg = null;
      if (paramRspSystemMsgNew == null) {
        break label154;
      }
      label87:
      paramObject = new StringBuilder();
      if ((paramRspSystemMsgNew != null) && (paramRspSystemMsgNew.head.result.get() == 0)) {
        break label210;
      }
      paramObject.setLength(0);
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, paramObject.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    }
    label154:
    label210:
    do
    {
      for (;;)
      {
        return;
        str1 = paramFromServiceMsg.getUin();
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
            int k;
            int n;
            int i1;
            int i2;
            Object localObject1;
            Object localObject2;
            int i3;
            boolean bool3;
            boolean bool2;
            String str2;
            Object localObject3;
            Object localObject4;
            paramObject = localMessageForSystemMsg;
            continue;
            long l2 = -1L;
            continue;
            long l1 = -1L;
            continue;
            int j = -1;
            continue;
            bool1 = true;
            continue;
            bool1 = true;
            continue;
          }
        }
      }
      paramRspSystemMsgNew = paramObject;
      if (!QLog.isColorLevel()) {
        break label87;
      }
      QLog.e("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb error:", localException1);
      paramRspSystemMsgNew = paramObject;
      break label87;
      paramFromServiceMsg = paramRspSystemMsgNew.groupmsgs.get();
      k = paramFromServiceMsg.size();
      j = paramRspSystemMsgNew.unread_group_count.get();
      paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      k -= 1;
      if (k >= 0)
      {
        paramObject = (structmsg.StructMsg)paramFromServiceMsg.get(k);
        if ((paramObject == null) || (!paramObject.msg.has()) || (!((structmsg.SystemMsg)paramObject.msg.get()).uint32_c2c_invite_join_group_flag.has()) || (((structmsg.SystemMsg)paramObject.msg.get()).uint32_c2c_invite_join_group_flag.get() <= 0)) {
          break label3881;
        }
        n = ((structmsg.SystemMsg)paramObject.msg.get()).group_msg_type.get();
        i1 = ((structmsg.SystemMsg)paramObject.msg.get()).sub_type.get();
        i2 = paramObject.uint32_unread_flag.get();
        l1 = paramObject.msg.group_code.get();
        l2 = paramObject.msg_time.get();
        if (QLog.isColorLevel()) {
          QLog.i("SystemMessageProcessor", 2, "uint32_c2c_invite_join_group_flag not 0 groupMsgType:" + n + " subType:" + i1 + "  unread_flag:" + i2 + "  unreadCount:" + j + " troopCode:" + l1 + "  msgTime:" + l2);
        }
        if ((i2 == 0) && (k >= j)) {
          break label3878;
        }
        j -= 1;
        if ((n == 2) && (i1 == 2))
        {
          paramObject = String.format("%s_%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
          if ((paramToServiceMsg == null) || (paramToServiceMsg.k(paramObject))) {}
        }
        for (;;)
        {
          k -= 1;
          break;
          paramFromServiceMsg.remove(k);
        }
      }
      n = paramFromServiceMsg.size();
      i1 = Math.max(j, 0);
      j = bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb groupMsgsSize = " + n + " latest_friend_seq" + paramRspSystemMsgNew.latest_friend_seq.get() + " latest_group_seq" + paramRspSystemMsgNew.latest_group_seq.get() + " following_friend_seq" + paramRspSystemMsgNew.following_friend_seq.get() + " following_group_seq" + paramRspSystemMsgNew.following_group_seq.get() + " uint32_has_suspicious_flag = " + paramRspSystemMsgNew.uint32_has_suspicious_flag.get() + " unreadCount" + i1 + " localUnreadCount" + j + " requestFrom = " + m);
      }
      if (m == 3)
      {
        ahql.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspSystemMsgNew, paramFromServiceMsg, i1, str1);
        return;
      }
      ahql.a(paramRspSystemMsgNew, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (n == 0);
    this.d = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq", paramRspSystemMsgNew.latest_group_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_group_seq", paramRspSystemMsgNew.following_group_seq.get());
    bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(alof.W, 9000, i1 - j);
    paramObject = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.N, 0, true, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.S, 0, true, false);
    bafj.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramToServiceMsg = (auga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    if (paramToServiceMsg != null) {
      paramToServiceMsg.a(false);
    }
    Collections.sort(paramFromServiceMsg, new amlq(this));
    j = 0;
    if (j < n)
    {
      localObject1 = azaf.a(-2018);
      ((MessageRecord)localObject1).msgtype = -2018;
      ((MessageRecord)localObject1).selfuin = str1;
      ((MessageRecord)localObject1).frienduin = alof.N;
      localObject2 = (structmsg.StructMsg)paramFromServiceMsg.get(j);
      k = ((structmsg.StructMsg)localObject2).msg.group_msg_type.get();
      i2 = bcpx.a(k);
      if (i2 == 1) {
        ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)localObject2).msg.action_uin.get() + "");
      }
      for (;;)
      {
        ((MessageRecord)localObject1).istroop = 0;
        localMessageForSystemMsg = (MessageForSystemMsg)localObject1;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)localObject2).get());
        localMessageForSystemMsg.shmsgseq = localMessageForSystemMsg.structMsg.msg_seq.get();
        i2 = localMessageForSystemMsg.structMsg.msg_type.get();
        i3 = localMessageForSystemMsg.structMsg.msg.sub_type.get();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("requestFrom:").append(m);
          paramToServiceMsg.append(" isLatestPushMsgProcessed:").append(bool1);
          paramToServiceMsg.append(" type:").append(i2);
          paramToServiceMsg.append(" groupMsgType:").append(k);
          paramToServiceMsg.append(" subType:").append(i3);
          paramToServiceMsg.append(" troopUin:").append(((structmsg.StructMsg)localObject2).msg.group_code.get());
          paramToServiceMsg.append(" msgTime:").append(((structmsg.StructMsg)localObject2).msg_time.get());
          QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->" + paramToServiceMsg.toString());
        }
        if ((i2 != 1) || (bafk.a(i3))) {
          break label1356;
        }
        bool3 = bool1;
        j += 1;
        bool1 = bool3;
        break;
        if (i2 == 2) {
          ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)localObject2).req_uin.get() + "");
        }
      }
      label1356:
      if (i3 == 1) {
        ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)localObject2).msg.action_uin.get() + "");
      }
      bool3 = true;
      bool2 = true;
      if ((m == 1) && (!bool1)) {
        if ((k == 2) && (i3 == 2))
        {
          str2 = String.valueOf(((structmsg.StructMsg)localObject2).msg.group_code.get());
          localObject3 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (((TroopManager)localObject3).b(str2) == null)
          {
            paramToServiceMsg = new TroopInfo();
            paramToServiceMsg.troopuin = str2;
            ((TroopManager)localObject3).a(paramToServiceMsg);
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg--> add troop : " + str2);
            }
            localObject4 = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            ((amdu)localObject4).a(paramToServiceMsg.troopuin, false, "", true, true, true, false);
            ((amdu)localObject4).a(1, aloz.a(paramToServiceMsg.troopuin), 0L, 2, 0, 0, true);
            ((amdu)localObject4).notifyUI(127, true, new Object[] { str2 });
          }
          if (localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.has())
          {
            paramToServiceMsg = (structmsg.MsgInviteExt)localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.get();
            label1618:
            if (paramToServiceMsg == null) {
              break label1875;
            }
            k = paramToServiceMsg.uint32_wait_state.get();
            label1631:
            if ((k == 2) || (k == 4))
            {
              localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
              ((TroopManager)localObject4).e(((TroopManager)localObject4).b(str2));
              aspz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForSystemMsg, paramToServiceMsg, str2);
              if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + j + ":addFriendTipsMr");
              }
            }
            if (k != 4) {
              break label1881;
            }
            bool1 = false;
            label1729:
            paramToServiceMsg = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.a(str2, Boolean.valueOf(false));
            }
            ((TroopManager)localObject3).m(String.format("%s_%s", new Object[] { str2, Long.valueOf(((structmsg.StructMsg)localObject2).msg_time.get()) }));
            bool3 = true;
            bool2 = bool1;
            bool1 = bool3;
          }
        }
      }
      for (;;)
      {
        ((MessageRecord)localObject1).msgData = localMessageForSystemMsg.structMsg.toByteArray();
        if (bool2) {
          paramObject.add(localMessageForSystemMsg);
        }
        bool3 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->isAdd2Loacal:" + bool2);
        bool3 = bool1;
        break;
        paramToServiceMsg = null;
        break label1618;
        label1875:
        k = -1;
        break label1631;
        label1881:
        if (((structmsg.StructMsg)localObject2).msg.uint32_c2c_invite_join_group_flag.get() == 0) {
          break label3872;
        }
        bool1 = false;
        break label1729;
        if (k == 3)
        {
          paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localObject2 = paramToServiceMsg.b(((structmsg.StructMsg)localObject2).msg.group_code.get() + "");
          if (localObject2 != null)
          {
            ((TroopInfo)localObject2).dwCmdUinUinFlag = 1L;
            if (((TroopInfo)localObject2).Administrator == null) {
              break label2138;
            }
            if (((TroopInfo)localObject2).Administrator.startsWith("|")) {
              ((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.substring(1);
            }
            if (!((TroopInfo)localObject2).Administrator.endsWith("|")) {}
          }
          label2138:
          for (((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.substring(0, ((TroopInfo)localObject2).Administrator.length() - 1);; ((TroopInfo)localObject2).Administrator = "")
          {
            if (!((TroopInfo)localObject2).Administrator.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
              ((TroopInfo)localObject2).Administrator = (((TroopInfo)localObject2).Administrator + "|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            paramToServiceMsg.b((TroopInfo)localObject2);
            paramToServiceMsg = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.c(Long.parseLong(((TroopInfo)localObject2).troopuin));
            }
            bool1 = true;
            break;
          }
        }
        if (k == 19)
        {
          paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localObject2 = paramToServiceMsg.b(((structmsg.StructMsg)localObject2).msg.group_code.get() + "");
          if (localObject2 != null)
          {
            ((TroopInfo)localObject2).dwCmdUinUinFlag = 1L;
            paramToServiceMsg.b((TroopInfo)localObject2);
          }
          bool1 = true;
        }
        else if (k == 17)
        {
          paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localObject2 = paramToServiceMsg.b(((structmsg.StructMsg)localObject2).msg.group_code.get() + "");
          if (localObject2 != null)
          {
            ((TroopInfo)localObject2).dwCmdUinUinFlag = 0L;
            paramToServiceMsg.b((TroopInfo)localObject2);
          }
          bool1 = true;
        }
        else
        {
          if (k == 15)
          {
            paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            localObject2 = paramToServiceMsg.b(((structmsg.StructMsg)localObject2).msg.group_code.get() + "");
            if (localObject2 != null)
            {
              ((TroopInfo)localObject2).dwCmdUinUinFlag = 0L;
              if (((TroopInfo)localObject2).Administrator == null) {
                break label2540;
              }
              if (((TroopInfo)localObject2).Administrator.startsWith("|")) {
                ((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.substring(1);
              }
              if (!((TroopInfo)localObject2).Administrator.endsWith("|")) {}
            }
            label2540:
            for (((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.substring(0, ((TroopInfo)localObject2).Administrator.length() - 1);; ((TroopInfo)localObject2).Administrator = "")
            {
              ((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "|", "").replace("|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "").replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
              paramToServiceMsg.b((TroopInfo)localObject2);
              bool1 = true;
              break;
            }
          }
          if ((k == 13) || (k == 6))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + j + ",msgTime:" + ((structmsg.StructMsg)localObject2).msg_time + ",msgType:" + k + ":delete troopMember, delete troop, clear local history");
            }
            paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg.c(((structmsg.StructMsg)localObject2).msg.group_code.get() + "", ((structmsg.StructMsg)localObject2).req_uin.get() + "");
              paramToServiceMsg.a(((structmsg.StructMsg)localObject2).msg.group_code.get(), ((structmsg.StructMsg)localObject2).msg_time.get());
            }
            bool1 = true;
          }
          else
          {
            if ((k != 8) && (k != 7)) {
              break label3866;
            }
            l1 = ((structmsg.StructMsg)localObject2).msg.group_code.get();
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, String.format("handlePassiveExit online troopUin: %s, msgType: %s, i: %s, unreadCount: %s", new Object[] { String.valueOf(l1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i1) }));
            }
            paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.a((structmsg.StructMsg)localObject2);
            }
            bool1 = true;
            continue;
            if ((k == 2) && (i3 == 2))
            {
              l1 = ((structmsg.StructMsg)localObject2).msg.group_code.get();
              if (localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.has())
              {
                paramToServiceMsg = (structmsg.MsgInviteExt)localMessageForSystemMsg.structMsg.msg.msg_invite_extinfo.get();
                label2904:
                if (paramToServiceMsg == null) {
                  break label2965;
                }
              }
              label2965:
              for (k = paramToServiceMsg.uint32_wait_state.get();; k = -1)
              {
                if ((k == 2) || (k == 4)) {
                  aspz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForSystemMsg, paramToServiceMsg, String.valueOf(l1));
                }
                bool2 = bool3;
                if (k == 4) {
                  bool2 = false;
                }
                break;
                paramToServiceMsg = null;
                break label2904;
              }
            }
            if ((k == 8) || (k == 7))
            {
              l1 = ((structmsg.StructMsg)localObject2).msg.group_code.get();
              if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, String.format("handlePassiveExit offline troopUin: %s, msgType: %s, i: %s, unreadCount: %s", new Object[] { String.valueOf(l1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i1) }));
              }
              if (j < i1)
              {
                paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                if (paramToServiceMsg != null) {
                  paramToServiceMsg.a((structmsg.StructMsg)localObject2);
                }
              }
            }
            else if ((k == 13) || (k == 6))
            {
              paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
              if ((paramToServiceMsg != null) && (!paramToServiceMsg.a(((structmsg.StructMsg)localObject2).msg.group_code.get(), ((structmsg.StructMsg)localObject2).msg_time.get())))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + j + ",msgTime:" + ((structmsg.StructMsg)localObject2).msg_time + ",msgType:" + k + ":delete troopMember, delete troop, clear local history");
                }
                str2 = ((structmsg.StructMsg)localObject2).msg.group_code.get() + "";
                localObject3 = ((structmsg.StructMsg)localObject2).req_uin.get() + "";
                localObject4 = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                if (localObject4 != null) {
                  ((amdu)localObject4).a(str2, (String)localObject3, true);
                }
                paramToServiceMsg.a(((structmsg.StructMsg)localObject2).msg.group_code.get(), ((structmsg.StructMsg)localObject2).msg_time.get());
              }
            }
          }
        }
      }
    }
    if (paramObject.size() > 0)
    {
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject1 = String.valueOf(str1);
      if ((!alww.a(paramObject)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
        break label3830;
      }
    }
    label3830:
    for (bool1 = true;; bool1 = false)
    {
      paramToServiceMsg.a(paramObject, (String)localObject1, bool1);
      a("handleGetSystemMsgResp", true, i1, false, false);
      if (!TextUtils.isEmpty(paramRspSystemMsgNew.grp_msg_display.get())) {
        bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspSystemMsgNew.grp_msg_display.get());
      }
      if ((paramRspSystemMsgNew.msg_ribbon_group.has()) && (paramRspSystemMsgNew.msg_ribbon_group.get() != null))
      {
        paramRspSystemMsgNew = (structmsg.StructMsg)paramRspSystemMsgNew.msg_ribbon_group.get();
        paramToServiceMsg = azaf.a(-2018);
        paramToServiceMsg.selfuin = str1;
        paramToServiceMsg.frienduin = alof.S;
        paramToServiceMsg.senderuin = (paramRspSystemMsgNew.req_uin.get() + "");
        paramToServiceMsg.istroop = 0;
        localObject1 = (MessageForSystemMsg)paramToServiceMsg;
        ((MessageForSystemMsg)localObject1).structMsg = paramRspSystemMsgNew;
        paramToServiceMsg.msgData = ((MessageForSystemMsg)localObject1).structMsg.toByteArray();
        paramRspSystemMsgNew = new ArrayList();
        paramRspSystemMsgNew.add(paramToServiceMsg);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspSystemMsgNew, String.valueOf(str1), true);
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.", 2, "ribbon info");
        }
      }
      paramToServiceMsg = (ambg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
      paramRspSystemMsgNew = ((MessageForSystemMsg)paramObject.get(0)).getSystemMsg();
      bafj.a().a(paramRspSystemMsgNew);
      l1 = paramRspSystemMsgNew.msg_time.get();
      paramToServiceMsg.a(alof.W, 9000, alud.a(2131691142), l1, l1);
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.sendMessage(paramToServiceMsg.obtainMessage(1009));
      }
      paramToServiceMsg = (structmsg.StructMsg)paramFromServiceMsg.get(0);
      if (paramToServiceMsg.msg.has())
      {
        if (!((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_msg_type.has()) {
          break label3860;
        }
        j = ((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_msg_type.get();
        if (!((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_code.has()) {
          break label3852;
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
      a(4005, true, paramObject);
      return;
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
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l1);
    localReqSystemMsgRead.latest_group_seq.set(l2);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "sendSystemMsgReadedReport latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new amlu(this, l1, l2, localReqSystemMsgRead));
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject2 = "ProfileService.Pb.ReqSystemMsgNew";
    int j = 0;
    Object localObject1 = null;
    structmsg.ReqSystemMsgNew localReqSystemMsgNew;
    PBUInt64Field localPBUInt64Field;
    long l;
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "<---sendGetSystemMsg type=" + paramInt1 + " latest_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47") + " latest_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq") + " last_group_suspicious_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_suspicious_seq"));
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg((String)localObject2);
      localReqSystemMsgNew = new structmsg.ReqSystemMsgNew();
      localReqSystemMsgNew.msg_num.set(20);
      localReqSystemMsgNew.checktype.set(j);
      localPBUInt64Field = localReqSystemMsgNew.latest_friend_seq;
      if (paramBoolean)
      {
        l = 0L;
        label193:
        localPBUInt64Field.set(l);
        if (paramInt2 != 3) {
          break label754;
        }
        localPBUInt64Field = localReqSystemMsgNew.latest_group_seq;
        if (!paramBoolean) {
          break label736;
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
          break label796;
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
      ((structmsg.FlagInfo)localObject1).GrpMsg_mask_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetDisbandedByAdmin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetC2cInviteJoinGroup.set(1);
      break;
      localObject2 = "ProfileService.Pb.ReqSystemMsgNew.Friend";
      j = 2;
      localObject1 = new structmsg.FlagInfo();
      ((structmsg.FlagInfo)localObject1).FrdMsg_GetBusiCard.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_Discuss2ManyChat.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_NeedWaitingMsg.set(1);
      ((structmsg.FlagInfo)localObject1).FrdMsg_uint32_need_all_unread_msg.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetC2cInviteJoinGroup.set(1);
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
      ((structmsg.FlagInfo)localObject1).GrpMsg_mask_invite_auto_join.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetDisbandedByAdmin.set(1);
      ((structmsg.FlagInfo)localObject1).GrpMsg_GetC2cInviteJoinGroup.set(1);
      break;
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47");
      break label193;
      label736:
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_suspicious_seq");
      break label219;
      label754:
      localPBUInt64Field = localReqSystemMsgNew.latest_group_seq;
      if (paramBoolean) {}
      for (l = 0L;; l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq"))
      {
        localPBUInt64Field.set(l);
        break;
      }
      label796:
      localReqSystemMsgNew.uint32_req_msg_type.set(1);
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
    paramSystemMsgActionInfo = new bavq();
    paramSystemMsgActionInfo.a();
    paramSystemMsgActionInfo.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Group";
    paramSystemMsgActionInfo.jdField_a_of_type_ArrayOfByte = paramString.toByteArray();
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Group");
    paramString.addAttribute("_tag_LOGSTR", String.valueOf(l));
    paramString.extraData.putInt("system_msg_action_type", paramInt6);
    paramSystemMsgActionInfo.jdField_a_of_type_JavaLangObject = paramString;
    paramSystemMsgActionInfo.jdField_a_of_type_Bavp = new amls(this);
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
    bavq localbavq = new bavq();
    localbavq.a();
    localbavq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Friend";
    localbavq.jdField_a_of_type_ArrayOfByte = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Friend");
    ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", String.valueOf(l));
    ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
    ((ToServiceMsg)localObject).extraData.putBoolean("isUncommonlyUsedFrd", paramBoolean);
    localbavq.jdField_a_of_type_JavaLangObject = localObject;
    localbavq.jdField_a_of_type_Bavp = new amlt(this, paramInt6, paramInt3, paramSystemMsgActionInfo, paramStructMsg, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbavq);
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
      aspz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte, paramLong1, paramLong2, paramMsgHead);
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
    alto localalto = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if ((paramInt1 == 188) || (paramInt1 == 189))
    {
      i();
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
    localalto.a(str, false);
  }
  
  public void a(long paramLong1, long paramLong2, short paramShort, int paramInt1, msg_comm.Msg paramMsg, int paramInt2)
  {
    String str = String.valueOf(paramLong2);
    Object localObject = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
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
      localObject = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bdhe.a((byte[])localObject), String.valueOf(str), paramInt1);
      if (localObject != null) {}
      for (localObject = ((SystemMsg)localObject).strGameName;; localObject = "")
      {
        localFriendListHandler.a(String.valueOf(str), 0, 3999, (String)localObject, true, false, paramMsg.msg_head.msg_time.get());
        ahme.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong1, paramLong2, paramShort, paramMsg, paramInt2);
        return;
      }
    }
    ((alto)localObject).a(str, false);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "handleDelAllSysMsg");
    }
    paramToServiceMsg = new Oidb_0x5cf.RspBody();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int j = MessageHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (j == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "handleDelAllSysMsg. " + j);
      }
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(alof.M, 0);
        ((alxr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b();
      }
      b(8039, bool, new Object[] { Integer.valueOf(j) });
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
      paramStructMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().makeOIDBPkg("OidbSvc.0x5cf_0", 1487, 0, localReqBody.toByteArray());
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
    int j = ayxz.a;
    ayxz.a = j + 1;
    long l2 = j;
    System.currentTimeMillis();
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47");
    if (paramBoolean) {}
    for (long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_suspicious_seq");; l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq"))
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
      bavq localbavq = new bavq();
      localbavq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Group";
      localbavq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
      localbavq.jdField_a_of_type_Bavp = new amlw(this, l2, l3, l1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbavq);
      return;
    }
  }
  
  public void b()
  {
    int j = ayxz.a;
    ayxz.a = j + 1;
    long l1 = j;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendSystemMsgReadedReport reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l2);
    localReqSystemMsgRead.checktype.set(2);
    bavq localbavq = new bavq();
    localbavq.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Friend";
    localbavq.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localbavq.jdField_a_of_type_Bavp = new amlv(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbavq);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int j = MessageHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
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
  
  public void c()
  {
    a(false);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("ProfileService.Pb.ReqNextSystemMsg.Group");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsgfollowing_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_group_seq") + "following_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_group_suspicious_seq") + " requestFrom =" + paramInt);
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(20);
    if (paramInt == 3)
    {
      localReqNextSystemMsg.following_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_group_suspicious_seq"));
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
      localObject = new bavq();
      ((bavq)localObject).a();
      ((bavq)localObject).jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Group";
      ((bavq)localObject).jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
      ((bavq)localObject).jdField_a_of_type_JavaLangObject = new Integer(paramInt);
      ((bavq)localObject).jdField_a_of_type_Bavp = new amlr(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a((bavq)localObject);
      return;
      localReqNextSystemMsg.following_group_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_group_seq"));
    }
  }
  
  public void d()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_suspicious_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l);
    localReqSystemMsgRead.uint32_req_msg_type.set(2);
    localReqSystemMsgRead.type.set(1);
    localReqSystemMsgRead.checktype.set(3);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "clearSystemMsg latestGroupSeq=" + l);
    }
    a(true, true, false, 0L, new amlx(this, l, localReqSystemMsgRead));
  }
  
  public void e()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47");
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq");
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_group_seq.set(l2);
    localReqSystemMsgRead.type.set(1);
    localReqSystemMsgRead.checktype.set(3);
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "clearSystemMsg latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
    }
    a(true, true, false, 0L, new amly(this, l1, l2, localReqSystemMsgRead));
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().makeOIDBPkg("OidbSvc.0x5cf_1", 1487, 0, ((Oidb_0x5cf.ReqBody)localObject).toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("ProfileService.Pb.ReqNextSystemMsg.Friend");
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsgfollowing_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_friend_seq_47"));
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(20);
    localReqNextSystemMsg.following_friend_seq.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_friend_seq_47"));
    localReqNextSystemMsg.checktype.set(2);
    localReqNextSystemMsg.version.set(1000);
    localReqNextSystemMsg.friend_msg_type_flag.set(1L);
    Object localObject = new structmsg.FlagInfo();
    ((structmsg.FlagInfo)localObject).FrdMsg_GetBusiCard.set(1);
    ((structmsg.FlagInfo)localObject).FrdMsg_Discuss2ManyChat.set(1);
    ((structmsg.FlagInfo)localObject).FrdMsg_NeedWaitingMsg.set(1);
    localReqNextSystemMsg.flag.set((MessageMicro)localObject);
    localObject = new bavq();
    ((bavq)localObject).a();
    ((bavq)localObject).jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Friend";
    ((bavq)localObject).jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
    ((bavq)localObject).jdField_a_of_type_Bavp = new amlz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a((bavq)localObject);
  }
  
  public void h()
  {
    c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amlp
 * JD-Core Version:    0.7.0.1
 */