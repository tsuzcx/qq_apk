import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.SystemMessageProcessor.2;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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

public class aogd
  extends acvl
{
  private int jdField_a_of_type_Int;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private int b;
  private int c;
  private final int d = 2;
  private final int e = 2;
  private final int f = 2;
  
  public aogd(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(anhk.M, 0);
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
    int i = paramToServiceMsg.extraData.getInt("type");
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
      QLog.d("SystemMessageProcessor", 2, "handleSendSystemMsgReadedReportError type=" + i + ";reqSeq=" + l3 + ";latestFriendSeq=" + l1 + ";latestGroupSeq=" + l2);
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
            int m;
            int k;
            int j;
            boolean bool1;
            aiyr localaiyr;
            int i;
            int n;
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
      localObject1 = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject2 = paramRspSystemMsgNew.friendmsgs.get();
      m = ((List)localObject2).size();
      k = paramRspSystemMsgNew.unread_friend_count.get();
      j = paramRspSystemMsgNew.uint32_un_read_count3.get();
      if (paramRspSystemMsgNew.uint32_over.get() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        bdgm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1);
        localaiyr = (aiyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
        i = localaiyr.c();
        bdgm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k);
        n = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "processFriendSystemMsg-->requestFrom:" + n);
        }
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder(128);
          paramObject.append("<---handleGetFriendSystemMsgResp : decode pb MsgsSize = ").append(m).append(" latest_friend_seq").append(paramRspSystemMsgNew.latest_friend_seq.get()).append(" latest_group_seq").append(paramRspSystemMsgNew.latest_group_seq.get()).append(" following_friend_seq").append(paramRspSystemMsgNew.following_friend_seq.get()).append(" following_group_seq").append(paramRspSystemMsgNew.following_group_seq.get()).append(" unreadCount").append(k).append(" localunreadCount").append(i).append(" isSysMsgOver").append(bool1).append(" unreadCountForSuspicious").append(j);
          QLog.d("Q.systemmsg.", 2, paramObject.toString());
        }
        if ((k != 0) || (m != 0) || (n != 2)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.M, 0);
        localaiyr.b();
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
      this.jdField_a_of_type_Int = 0;
      j = 0;
      l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47");
      l3 = paramRspSystemMsgNew.latest_friend_seq.get();
      if (l2 != l3) {
        break label884;
      }
      if ((k == 0) || (l1 != 0L)) {
        break label826;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SystemMessageProcessor", 2, "sentSeq == respSeq | unreadCount = " + k + " | newFriendLastMsgTime = 0");
    return;
    label826:
    paramToServiceMsg = paramObject;
    if (TextUtils.isEmpty(paramObject)) {
      paramToServiceMsg = a();
    }
    if ((i != k) && (k == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.M, 0, true, true);
    }
    localaiyr.a(new ajas(paramToServiceMsg, l1));
    return;
    label884:
    i = j;
    if (k == 0)
    {
      i = j;
      if (m == 0) {
        i = 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47", paramRspSystemMsgNew.latest_friend_seq.get());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_friend_seq_47", paramRspSystemMsgNew.following_friend_seq.get());
    bdgm.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    label1328:
    label1334:
    label1340:
    label1876:
    if (i == 0)
    {
      paramRspSystemMsgNew = new ArrayList(m);
      if (paramFromServiceMsg.getUin() == null)
      {
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if (k <= 0) {
          break label1328;
        }
        bool1 = true;
        label997:
        i = 0;
        label1000:
        if (i >= m) {
          break label1370;
        }
        paramFromServiceMsg = bbzh.a(-2050);
        paramFromServiceMsg.msgtype = -2050;
        paramFromServiceMsg.selfuin = paramToServiceMsg;
        paramFromServiceMsg.frienduin = anhk.M;
        paramFromServiceMsg.senderuin = (((structmsg.StructMsg)((List)localObject2).get(i)).req_uin.get() + "");
        paramFromServiceMsg.istroop = 0;
        paramFromServiceMsg.time = ((structmsg.StructMsg)((List)localObject2).get(i)).msg_time.get();
        if (((structmsg.StructMsg)((List)localObject2).get(i)).uint32_unread_flag.get() != 0) {
          break label1334;
        }
        bool2 = true;
        label1124:
        paramFromServiceMsg.isread = bool2;
        localObject3 = (MessageForSystemMsg)paramFromServiceMsg;
        ((MessageForSystemMsg)localObject3).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get());
        j = ((MessageForSystemMsg)localObject3).structMsg.msg_type.get();
        n = ((MessageForSystemMsg)localObject3).structMsg.msg.sub_type.get();
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp|i = " + i + ", isRead = " + paramFromServiceMsg.isread + ", time = " + paramFromServiceMsg.time + ", uin = " + paramFromServiceMsg.senderuin);
        }
        if (i != 0) {
          break label2015;
        }
        paramFromServiceMsg.extStr = paramObject;
        if (n != 13) {
          break label2015;
        }
        bool1 = false;
        if ((j != 1) || (bdgo.a(n))) {
          break label1340;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : decode pb filtered");
        }
      }
      for (;;)
      {
        i += 1;
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
        i = paramRspSystemMsgNew.size();
        l2 = ((MessageRecord)paramRspSystemMsgNew.get(i - 1)).time;
        l3 = bdgm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.M, 0, l3);
        localObject2 = paramFromServiceMsg.iterator();
        if (i < 20) {
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (ChatMessage)((Iterator)localObject2).next();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(anhk.M, 0, ((ChatMessage)localObject1).uniseq, false);
            ((Iterator)localObject2).remove();
          }
        }
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ChatMessage)((Iterator)localObject2).next();
          if (((ChatMessage)localObject3).time >= l2)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(anhk.M, 0, ((ChatMessage)localObject3).uniseq, false);
            ((Iterator)localObject2).remove();
          }
          else if ((localObject3 instanceof MessageForSystemMsg))
          {
            Object localObject4 = (MessageForSystemMsg)localObject3;
            if (((MessageForSystemMsg)localObject4).structMsg == null) {
              ((MessageForSystemMsg)localObject4).parse();
            }
            str = ((MessageForSystemMsg)localObject4).senderuin;
            i = ((MessageForSystemMsg)localObject4).structMsg.msg.sub_type.get();
            if ((i == 13) && (((anmw)localObject1).b(str)))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(anhk.M, 0, ((ChatMessage)localObject3).uniseq, false);
              ((Iterator)localObject2).remove();
            }
            else if ((i == 1) || (i == 13))
            {
              localObject4 = paramRspSystemMsgNew.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                Object localObject5 = (MessageRecord)((Iterator)localObject4).next();
                if ((localObject5 instanceof MessageForSystemMsg))
                {
                  j = ((MessageForSystemMsg)localObject5).structMsg.msg.sub_type.get();
                  localObject5 = ((MessageRecord)localObject5).senderuin;
                  if ((j == i) && (localObject5 != null) && (((String)localObject5).equals(str)))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(anhk.M, 0, ((ChatMessage)localObject3).uniseq, false);
                    ((Iterator)localObject2).remove();
                  }
                }
              }
            }
          }
        }
        if (paramFromServiceMsg.size() == 0)
        {
          bdgm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2);
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          paramToServiceMsg = String.valueOf(paramToServiceMsg);
          if ((!anqc.a(paramRspSystemMsgNew)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
            break label1925;
          }
          bool2 = true;
          paramFromServiceMsg.a(paramRspSystemMsgNew, paramToServiceMsg, bool2);
          localaiyr.a(true);
          a(paramRspSystemMsgNew);
          a("handleGetSystemMsgResp", true, k, bool1, false);
          localaiyr.a(new ajas(paramObject, l1));
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
      bdgm.a().a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label1925:
      bool2 = false;
      break label1842;
      localaiyr.a(true);
      break label1876;
      if (QLog.isColorLevel()) {
        QLog.e("Q.systemmsg.", 2, "<---handleGetFriendSystemMsgResp : clear local data. sentSeq:" + l2 + " respSeq:" + l3);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.M, 0);
      localaiyr.b();
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    aong localaong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = (RecentUser)localaong.findRecentUserByUin(anhk.D, 4000);
    localRecentUser.msgType = 26;
    localRecentUser.displayName = aiyr.jdField_a_of_type_JavaLangString;
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
      localaong.saveRecentUser(localRecentUser);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, structmsg.RspSystemMsgNew paramRspSystemMsgNew)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SystemMessageProcessor", 4, "processGroupSystemMsg");
    }
    awne localawne = (awne)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
    int m = paramToServiceMsg.extraData.getInt("getSystemMsgSender");
    bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->requestFrom:" + m);
    }
    String str1;
    if (paramFromServiceMsg.getUin() == null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localObject2 = null;
      if (paramRspSystemMsgNew == null) {
        break label168;
      }
      label101:
      paramObject = new StringBuilder();
      if ((paramRspSystemMsgNew != null) && (paramRspSystemMsgNew.head.result.get() == 0)) {
        break label224;
      }
      paramObject.setLength(0);
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageProcessor", 2, paramObject.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    }
    label168:
    label224:
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
            int i;
            Object localObject1;
            int k;
            int n;
            int i1;
            Object localObject3;
            int i2;
            int i3;
            boolean bool3;
            boolean bool2;
            String str2;
            Object localObject4;
            Object localObject5;
            paramObject = localObject2;
            continue;
            long l2 = -1L;
            continue;
            long l1 = -1L;
            continue;
            int j = -1;
            continue;
            paramToServiceMsg = null;
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
        break label101;
      }
      QLog.e("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb error:", localException1);
      paramRspSystemMsgNew = paramObject;
      break label101;
      paramFromServiceMsg = paramRspSystemMsgNew.groupmsgs.get();
      j = paramFromServiceMsg.size();
      i = paramRspSystemMsgNew.unread_group_count.get();
      paramObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      j -= 1;
      if (j >= 0)
      {
        localObject1 = (structmsg.StructMsg)paramFromServiceMsg.get(j);
        if ((localObject1 == null) || (!((structmsg.StructMsg)localObject1).msg.has()) || (!((structmsg.SystemMsg)((structmsg.StructMsg)localObject1).msg.get()).uint32_c2c_invite_join_group_flag.has()) || (((structmsg.SystemMsg)((structmsg.StructMsg)localObject1).msg.get()).uint32_c2c_invite_join_group_flag.get() <= 0)) {
          break label4218;
        }
        k = ((structmsg.SystemMsg)((structmsg.StructMsg)localObject1).msg.get()).group_msg_type.get();
        n = ((structmsg.SystemMsg)((structmsg.StructMsg)localObject1).msg.get()).sub_type.get();
        i1 = ((structmsg.StructMsg)localObject1).uint32_unread_flag.get();
        l1 = ((structmsg.StructMsg)localObject1).msg.group_code.get();
        l2 = ((structmsg.StructMsg)localObject1).msg_time.get();
        if (QLog.isColorLevel()) {
          QLog.i("SystemMessageProcessor", 2, "uint32_c2c_invite_join_group_flag not 0 groupMsgType:" + k + " subType:" + n + "  unread_flag:" + i1 + "  unreadCount:" + i + " troopCode:" + l1 + "  msgTime:" + l2);
        }
        if ((i1 == 0) && (j >= i)) {
          break label4215;
        }
        i -= 1;
        if ((k == 2) && (n == 2))
        {
          localObject1 = String.format("%s_%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
          if ((paramObject == null) || (paramObject.k((String)localObject1))) {}
        }
        for (;;)
        {
          j -= 1;
          break;
          paramFromServiceMsg.remove(j);
        }
      }
      n = paramFromServiceMsg.size();
      i1 = Math.max(i, 0);
      i = bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "<---handleGetGroupSystemMsgResp : decode pb groupMsgsSize = " + n + " latest_friend_seq" + paramRspSystemMsgNew.latest_friend_seq.get() + " latest_group_seq" + paramRspSystemMsgNew.latest_group_seq.get() + " following_friend_seq" + paramRspSystemMsgNew.following_friend_seq.get() + " following_group_seq" + paramRspSystemMsgNew.following_group_seq.get() + " uint32_has_suspicious_flag = " + paramRspSystemMsgNew.uint32_has_suspicious_flag.get() + " unreadCount" + i1 + " localUnreadCount" + i + " requestFrom = " + m);
      }
      if (m == 3)
      {
        ajga.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspSystemMsgNew, paramFromServiceMsg, i1, str1);
        return;
      }
      ajga.a(paramRspSystemMsgNew, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (n == 0);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq", paramRspSystemMsgNew.latest_group_seq.get());
    bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(anhk.W, 9000, i1 - i);
    paramObject = new ArrayList();
    i = 0;
    if (paramToServiceMsg.getServiceCmd().equals("ProfileService.Pb.ReqSystemMsgNew"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageProcessor", 2, "CMD_GET_SYSTEM_MSG_BOTH");
      }
      j = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.N, 0, true, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.S, 0, true, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_group_seq", paramRspSystemMsgNew.following_group_seq.get());
      ajfn.a();
      bdgn.a().a(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      i = j;
      if (localawne != null)
      {
        localawne.a(false);
        i = j;
      }
    }
    Collections.sort(paramFromServiceMsg, new aoge(this));
    j = 0;
    if (j < n)
    {
      localObject1 = bbzh.a(-2018);
      ((MessageRecord)localObject1).msgtype = -2018;
      ((MessageRecord)localObject1).selfuin = str1;
      ((MessageRecord)localObject1).frienduin = anhk.N;
      localObject3 = (structmsg.StructMsg)paramFromServiceMsg.get(j);
      k = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
      i2 = bfup.a(k);
      if (i2 == 1) {
        ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)localObject3).msg.action_uin.get() + "");
      }
      for (;;)
      {
        ((MessageRecord)localObject1).istroop = 0;
        localObject2 = (MessageForSystemMsg)localObject1;
        ((MessageForSystemMsg)localObject2).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)localObject3).get());
        ((MessageForSystemMsg)localObject2).shmsgseq = ((MessageForSystemMsg)localObject2).structMsg.msg_seq.get();
        i2 = ((MessageForSystemMsg)localObject2).structMsg.msg_type.get();
        i3 = ((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("requestFrom:").append(m);
          paramToServiceMsg.append(" isLatestPushMsgProcessed:").append(bool1);
          paramToServiceMsg.append(" type:").append(i2);
          paramToServiceMsg.append(" groupMsgType:").append(k);
          paramToServiceMsg.append(" subType:").append(i3);
          paramToServiceMsg.append(" troopUin:").append(((structmsg.StructMsg)localObject3).msg.group_code.get());
          paramToServiceMsg.append(" msgTime:").append(((structmsg.StructMsg)localObject3).msg_time.get());
          QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->" + paramToServiceMsg.toString());
        }
        if ((i2 != 1) || (bdgo.a(i3))) {
          break label1416;
        }
        bool3 = bool1;
        j += 1;
        bool1 = bool3;
        break;
        if (i2 == 2) {
          ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)localObject3).req_uin.get() + "");
        }
      }
      label1416:
      if (i3 == 1) {
        ((MessageRecord)localObject1).senderuin = (((structmsg.StructMsg)localObject3).msg.action_uin.get() + "");
      }
      bool3 = true;
      bool2 = true;
      if ((m == 1) && (!bool1)) {
        if ((k == 2) && (i3 == 2))
        {
          str2 = String.valueOf(((structmsg.StructMsg)localObject3).msg.group_code.get());
          localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (((TroopManager)localObject4).b(str2) == null)
          {
            paramToServiceMsg = new TroopInfo();
            paramToServiceMsg.troopuin = str2;
            ((TroopManager)localObject4).a(paramToServiceMsg);
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg--> add troop : " + str2);
            }
            localObject5 = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            ((anwd)localObject5).a(paramToServiceMsg.troopuin, false, "", true, true, true, false);
            ((anwd)localObject5).a(1, anie.a(paramToServiceMsg.troopuin), 0L, 2, 0, 0, true);
            ((anwd)localObject5).f(str2);
            ((anwd)localObject5).notifyUI(127, true, new Object[] { str2 });
          }
          if (((MessageForSystemMsg)localObject2).structMsg.msg.msg_invite_extinfo.has())
          {
            paramToServiceMsg = (structmsg.MsgInviteExt)((MessageForSystemMsg)localObject2).structMsg.msg.msg_invite_extinfo.get();
            label1685:
            if (paramToServiceMsg == null) {
              break label1942;
            }
            k = paramToServiceMsg.uint32_wait_state.get();
            label1698:
            if ((k == 2) || (k == 4))
            {
              localObject5 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
              ((TroopManager)localObject5).e(((TroopManager)localObject5).b(str2));
              auxd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForSystemMsg)localObject2, paramToServiceMsg, str2);
              if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + j + ":addFriendTipsMr");
              }
            }
            if (k != 4) {
              break label1948;
            }
            bool1 = false;
            label1796:
            paramToServiceMsg = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.a(str2, Boolean.valueOf(false));
            }
            ((TroopManager)localObject4).m(String.format("%s_%s", new Object[] { str2, Long.valueOf(((structmsg.StructMsg)localObject3).msg_time.get()) }));
            bool3 = true;
            bool2 = bool1;
            bool1 = bool3;
          }
        }
      }
      for (;;)
      {
        ((MessageRecord)localObject1).msgData = ((MessageForSystemMsg)localObject2).structMsg.toByteArray();
        if (bool2) {
          paramObject.add(localObject2);
        }
        bool3 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->isAdd2Loacal:" + bool2);
        bool3 = bool1;
        break;
        paramToServiceMsg = null;
        break label1685;
        label1942:
        k = -1;
        break label1698;
        label1948:
        if (((structmsg.StructMsg)localObject3).msg.uint32_c2c_invite_join_group_flag.get() == 0) {
          break label4209;
        }
        bool1 = false;
        break label1796;
        if (k == 3)
        {
          paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localObject3 = paramToServiceMsg.b(((structmsg.StructMsg)localObject3).msg.group_code.get() + "");
          if (localObject3 != null)
          {
            ((TroopInfo)localObject3).dwCmdUinUinFlag = 1L;
            if (((TroopInfo)localObject3).Administrator == null) {
              break label2205;
            }
            if (((TroopInfo)localObject3).Administrator.startsWith("|")) {
              ((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.substring(1);
            }
            if (!((TroopInfo)localObject3).Administrator.endsWith("|")) {}
          }
          label2205:
          for (((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.substring(0, ((TroopInfo)localObject3).Administrator.length() - 1);; ((TroopInfo)localObject3).Administrator = "")
          {
            if (!((TroopInfo)localObject3).Administrator.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
              ((TroopInfo)localObject3).Administrator = (((TroopInfo)localObject3).Administrator + "|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            paramToServiceMsg.b((TroopInfo)localObject3);
            paramToServiceMsg = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.c(Long.parseLong(((TroopInfo)localObject3).troopuin));
            }
            bool1 = true;
            break;
          }
        }
        if (k == 19)
        {
          paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localObject3 = paramToServiceMsg.b(((structmsg.StructMsg)localObject3).msg.group_code.get() + "");
          if (localObject3 != null)
          {
            ((TroopInfo)localObject3).dwCmdUinUinFlag = 1L;
            paramToServiceMsg.b((TroopInfo)localObject3);
          }
          bool1 = true;
        }
        else if (k == 17)
        {
          paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          localObject3 = paramToServiceMsg.b(((structmsg.StructMsg)localObject3).msg.group_code.get() + "");
          if (localObject3 != null)
          {
            ((TroopInfo)localObject3).dwCmdUinUinFlag = 0L;
            paramToServiceMsg.b((TroopInfo)localObject3);
          }
          bool1 = true;
        }
        else
        {
          if (k == 15)
          {
            paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            localObject3 = paramToServiceMsg.b(((structmsg.StructMsg)localObject3).msg.group_code.get() + "");
            if (localObject3 != null)
            {
              ((TroopInfo)localObject3).dwCmdUinUinFlag = 0L;
              if (((TroopInfo)localObject3).Administrator == null) {
                break label2607;
              }
              if (((TroopInfo)localObject3).Administrator.startsWith("|")) {
                ((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.substring(1);
              }
              if (!((TroopInfo)localObject3).Administrator.endsWith("|")) {}
            }
            label2607:
            for (((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.substring(0, ((TroopInfo)localObject3).Administrator.length() - 1);; ((TroopInfo)localObject3).Administrator = "")
            {
              ((TroopInfo)localObject3).Administrator = ((TroopInfo)localObject3).Administrator.replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "|", "").replace("|" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "").replace(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
              paramToServiceMsg.b((TroopInfo)localObject3);
              bool1 = true;
              break;
            }
          }
          if ((k == 13) || (k == 6))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + j + ",msgTime:" + ((structmsg.StructMsg)localObject3).msg_time + ",msgType:" + k + ":delete troopMember, delete troop, clear local history");
            }
            paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg.c(((structmsg.StructMsg)localObject3).msg.group_code.get() + "", ((structmsg.StructMsg)localObject3).req_uin.get() + "");
              paramToServiceMsg.a(((structmsg.StructMsg)localObject3).msg.group_code.get(), ((structmsg.StructMsg)localObject3).msg_time.get());
            }
            bool1 = true;
          }
          else
          {
            if ((k != 8) && (k != 7)) {
              break label4203;
            }
            l1 = ((structmsg.StructMsg)localObject3).msg.group_code.get();
            if (QLog.isColorLevel()) {
              QLog.d("SystemMessageProcessor", 2, String.format("handlePassiveExit online troopUin: %s, msgType: %s, i: %s, unreadCount: %s", new Object[] { String.valueOf(l1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i1) }));
            }
            paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.a((structmsg.StructMsg)localObject3);
            }
            bool1 = true;
            continue;
            if ((k == 2) && (i3 == 2))
            {
              l1 = ((structmsg.StructMsg)localObject3).msg.group_code.get();
              if (((MessageForSystemMsg)localObject2).structMsg.msg.msg_invite_extinfo.has())
              {
                paramToServiceMsg = (structmsg.MsgInviteExt)((MessageForSystemMsg)localObject2).structMsg.msg.msg_invite_extinfo.get();
                label2971:
                if (paramToServiceMsg == null) {
                  break label3032;
                }
              }
              label3032:
              for (k = paramToServiceMsg.uint32_wait_state.get();; k = -1)
              {
                if ((k == 2) || (k == 4)) {
                  auxd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForSystemMsg)localObject2, paramToServiceMsg, String.valueOf(l1));
                }
                bool2 = bool3;
                if (k == 4) {
                  bool2 = false;
                }
                break;
                paramToServiceMsg = null;
                break label2971;
              }
            }
            if ((k == 8) || (k == 7))
            {
              l1 = ((structmsg.StructMsg)localObject3).msg.group_code.get();
              if (QLog.isColorLevel()) {
                QLog.d("SystemMessageProcessor", 2, String.format("handlePassiveExit offline troopUin: %s, msgType: %s, i: %s, unreadCount: %s", new Object[] { String.valueOf(l1), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i1) }));
              }
              if (j < i1)
              {
                paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                if (paramToServiceMsg != null) {
                  paramToServiceMsg.a((structmsg.StructMsg)localObject3);
                }
              }
            }
            else if ((k == 13) || (k == 6))
            {
              paramToServiceMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
              if ((paramToServiceMsg != null) && (!paramToServiceMsg.a(((structmsg.StructMsg)localObject3).msg.group_code.get(), ((structmsg.StructMsg)localObject3).msg_time.get())))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SystemMessageProcessor", 2, "processGroupSystemMsg-->msgPos:" + j + ",msgTime:" + ((structmsg.StructMsg)localObject3).msg_time + ",msgType:" + k + ":delete troopMember, delete troop, clear local history");
                }
                str2 = ((structmsg.StructMsg)localObject3).msg.group_code.get() + "";
                localObject4 = ((structmsg.StructMsg)localObject3).req_uin.get() + "";
                localObject5 = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                if (localObject5 != null) {
                  ((anwd)localObject5).a(str2, (String)localObject4, true);
                }
                paramToServiceMsg.a(((structmsg.StructMsg)localObject3).msg.group_code.get(), ((structmsg.StructMsg)localObject3).msg_time.get());
              }
            }
          }
        }
      }
    }
    localObject1 = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
    localObject2 = paramObject.iterator();
    do
    {
      do
      {
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramToServiceMsg = (MessageRecord)((Iterator)localObject2).next();
        } while (!(paramToServiceMsg instanceof MessageForSystemMsg));
        paramToServiceMsg = ((MessageForSystemMsg)paramToServiceMsg).getSystemMsg();
      } while ((paramToServiceMsg == null) || (!paramToServiceMsg.msg.has()) || (!paramToServiceMsg.msg.group_msg_type.has()));
      j = paramToServiceMsg.msg.group_msg_type.get();
    } while ((j == 13) || (j == 6));
    if (paramToServiceMsg != null)
    {
      bdgn.a().a(paramToServiceMsg);
      l1 = paramToServiceMsg.msg_time.get();
      if ((i1 != 0) || (i != 0)) {
        ((antp)localObject1).a(anhk.W, 9000, anni.a(2131690949), l1, l1);
      }
    }
    paramToServiceMsg = null;
    localObject1 = ajfn.d();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = a((List)localObject1, paramObject);
        if (paramObject.size() > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.S, 0, true, true);
          if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            localObject2 = String.valueOf(str1);
            if ((!anqc.a(paramObject)) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
              break label4162;
            }
            bool1 = true;
            ((QQMessageFacade)localObject1).a(paramToServiceMsg, (String)localObject2, bool1);
          }
          ThreadManager.getUIHandler().post(new SystemMessageProcessor.2(this, paramObject, i1));
          a("handleGetSystemMsgResp", true, i1, false, false);
          if (!TextUtils.isEmpty(paramRspSystemMsgNew.grp_msg_display.get())) {
            bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspSystemMsgNew.grp_msg_display.get());
          }
        }
        if ((paramRspSystemMsgNew.msg_ribbon_group.has()) && (paramRspSystemMsgNew.msg_ribbon_group.get() != null))
        {
          paramRspSystemMsgNew = (structmsg.StructMsg)paramRspSystemMsgNew.msg_ribbon_group.get();
          paramToServiceMsg = bbzh.a(-2018);
          paramToServiceMsg.selfuin = str1;
          paramToServiceMsg.frienduin = anhk.S;
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
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if ((paramToServiceMsg != null) && ((i1 > 0) || (i != 0))) {
          paramToServiceMsg.sendMessage(paramToServiceMsg.obtainMessage(1009));
        }
        paramToServiceMsg = (structmsg.StructMsg)paramFromServiceMsg.get(0);
        if (paramToServiceMsg.msg.has())
        {
          if (!((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_msg_type.has()) {
            break label4192;
          }
          j = ((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_msg_type.get();
          if (!((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_code.has()) {
            break label4184;
          }
          l1 = ((structmsg.SystemMsg)paramToServiceMsg.msg.get()).group_code.get();
          if (!paramToServiceMsg.req_uin.has()) {
            break label4176;
          }
          l2 = paramToServiceMsg.req_uin.get();
          if ((j != -1) && (l2 != -1L) && (l1 != -1L)) {
            a(j, l1, l2);
          }
        }
        a(4005, true, paramObject);
        new ArrayList();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.N, 0, null);
        paramToServiceMsg = (aqlz)aqlk.a().a(634);
        if ((localawne.a()) || (i == 0) || (!paramToServiceMsg.a)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "Begin Auto Get Next");
        }
        c(0);
        return;
      }
      finally {}
      label4162:
      bool1 = false;
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
  
  public List<MessageRecord> a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList1 == null) || (paramList2 == null)) {
      return localArrayList;
    }
    HashSet localHashSet = new HashSet();
    paramList1 = paramList1.iterator();
    structmsg.StructMsg localStructMsg;
    while (paramList1.hasNext())
    {
      localStructMsg = ((MessageForSystemMsg)paramList1.next()).getSystemMsg();
      if ((localStructMsg != null) && (localStructMsg.msg_seq.has())) {
        localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
      }
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (MessageRecord)paramList1.next();
      localStructMsg = ((MessageForSystemMsg)paramList2).getSystemMsg();
      if ((localStructMsg != null) && (localStructMsg.msg_seq.has()) && (!localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get()))))
      {
        localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
        localArrayList.add(paramList2);
      }
    }
    return localArrayList;
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
    a(true, true, false, 0L, new aogj(this, l1, l2, localReqSystemMsgRead));
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
        QLog.w("Q.systemmsg.", 2, "<---sendGetSystemMsg type=" + paramInt1 + " latest_friend_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47") + " latest_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq") + " last_group_suspicious_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_suspicious_seq"));
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
          break label768;
        }
        localPBUInt64Field = localReqSystemMsgNew.latest_group_seq;
        if (!paramBoolean) {
          break label750;
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
          break label810;
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
      localObject2 = (awne)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
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
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47");
      break label193;
      label750:
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_suspicious_seq");
      break label219;
      label768:
      localPBUInt64Field = localReqSystemMsgNew.latest_group_seq;
      if (paramBoolean) {}
      for (l = 0L;; l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq"))
      {
        localPBUInt64Field.set(l);
        break;
      }
      label810:
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
    paramSystemMsgActionInfo = new bdxe();
    paramSystemMsgActionInfo.a();
    paramSystemMsgActionInfo.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Group";
    paramSystemMsgActionInfo.jdField_a_of_type_ArrayOfByte = paramString.toByteArray();
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Group");
    paramString.addAttribute("_tag_LOGSTR", String.valueOf(l));
    paramString.extraData.putInt("system_msg_action_type", paramInt6);
    paramSystemMsgActionInfo.jdField_a_of_type_JavaLangObject = paramString;
    paramSystemMsgActionInfo.jdField_a_of_type_Bdxd = new aogh(this);
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
    bdxe localbdxe = new bdxe();
    localbdxe.a();
    localbdxe.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgAction.Friend";
    localbdxe.jdField_a_of_type_ArrayOfByte = ((structmsg.ReqSystemMsgAction)localObject).toByteArray();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("ProfileService.Pb.ReqSystemMsgAction.Friend");
    ((ToServiceMsg)localObject).addAttribute("_tag_LOGSTR", String.valueOf(l));
    ((ToServiceMsg)localObject).extraData.putInt("system_msg_action_type", paramInt6);
    ((ToServiceMsg)localObject).extraData.putBoolean("isUncommonlyUsedFrd", paramBoolean);
    localbdxe.jdField_a_of_type_JavaLangObject = localObject;
    localbdxe.jdField_a_of_type_Bdxd = new aogi(this, paramInt6, paramInt3, paramSystemMsgActionInfo, paramStructMsg, paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbdxe);
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
      auxd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte, paramLong1, paramLong2, paramMsgHead);
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
    anmw localanmw = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
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
    localanmw.a(str, false);
  }
  
  public void a(long paramLong1, long paramLong2, short paramShort, int paramInt1, msg_comm.Msg paramMsg, int paramInt2)
  {
    String str = String.valueOf(paramLong2);
    Object localObject = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
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
      localObject = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bgmj.a((byte[])localObject), String.valueOf(str), paramInt1);
      if (localObject != null) {}
      for (localObject = ((SystemMsg)localObject).strGameName;; localObject = "")
      {
        localFriendListHandler.a(String.valueOf(str), 0, 3999, (String)localObject, true, false, paramMsg.msg_head.msg_time.get());
        aizg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong1, paramLong2, paramShort, paramMsg, paramInt2);
        return;
      }
    }
    ((anmw)localObject).a(str, false);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.systemmsg.", 2, "handleDelAllSysMsg");
    }
    paramToServiceMsg = new Oidb_0x5cf.RspBody();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i = MessageHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.systemmsg.", 2, "handleDelAllSysMsg. " + i);
      }
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.M, 0);
        ((aiyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b();
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
    int i = bbxc.jdField_a_of_type_Int;
    bbxc.jdField_a_of_type_Int = i + 1;
    long l2 = i;
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
      bdxe localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Group";
      localbdxe.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
      localbdxe.jdField_a_of_type_Bdxd = new aogl(this, l2, l3, l1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbdxe);
      return;
    }
  }
  
  public void b()
  {
    int i = bbxc.jdField_a_of_type_Int;
    bbxc.jdField_a_of_type_Int = i + 1;
    long l1 = i;
    System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_friend_seq_47");
    long l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("last_group_seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "sendSystemMsgReadedReport reqSeq=" + l1 + ";latestFriendSeq=" + l2 + ";latestGroupSeq=" + l3);
    }
    structmsg.ReqSystemMsgRead localReqSystemMsgRead = new structmsg.ReqSystemMsgRead();
    localReqSystemMsgRead.latest_friend_seq.set(l2);
    localReqSystemMsgRead.checktype.set(2);
    bdxe localbdxe = new bdxe();
    localbdxe.jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqSystemMsgRead.Friend";
    localbdxe.jdField_a_of_type_ArrayOfByte = localReqSystemMsgRead.toByteArray();
    localbdxe.jdField_a_of_type_Bdxd = new aogk(this, l1, l2, l3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbdxe);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i = MessageHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (i == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("frienduin");
      i = paramToServiceMsg.extraData.getInt("istroop");
      long l = paramToServiceMsg.extraData.getLong("uniseq");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFromServiceMsg, i, l, false);
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
      QLog.w("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsgfollowing_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_group_seq") + "following_group_seq = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e("following_group_suspicious_seq") + " requestFrom =" + paramInt);
    }
    structmsg.ReqNextSystemMsg localReqNextSystemMsg = new structmsg.ReqNextSystemMsg();
    localReqNextSystemMsg.msg_num.set(100);
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
      localObject = new bdxe();
      ((bdxe)localObject).a();
      ((bdxe)localObject).jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Group";
      ((bdxe)localObject).jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
      ((bdxe)localObject).jdField_a_of_type_JavaLangObject = new Integer(paramInt);
      ((bdxe)localObject).jdField_a_of_type_Bdxd = new aogg(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a((bdxe)localObject);
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
    a(true, true, false, 0L, new aogm(this, l, localReqSystemMsgRead));
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
    a(true, true, false, 0L, new aogn(this, l1, l2, localReqSystemMsgRead));
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
    localObject = new bdxe();
    ((bdxe)localObject).a();
    ((bdxe)localObject).jdField_a_of_type_JavaLangString = "ProfileService.Pb.ReqNextSystemMsg.Friend";
    ((bdxe)localObject).jdField_a_of_type_ArrayOfByte = localReqNextSystemMsg.toByteArray();
    ((bdxe)localObject).jdField_a_of_type_Bdxd = new aogf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a((bdxe)localObject);
  }
  
  public void h()
  {
    c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogd
 * JD-Core Version:    0.7.0.1
 */