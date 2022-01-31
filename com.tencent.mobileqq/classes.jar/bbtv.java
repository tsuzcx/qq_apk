import PushNotifyPack.GroupMsgReadedNotify;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.msg.im_msg_body.MsgBody;

public class bbtv
  extends absp
{
  public Comparator b = new bbtw(this);
  
  public bbtv(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private long a(ArrayList<msg_comm.Msg> paramArrayList, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2, String paramString1, String paramString2)
  {
    paramString2 = new ArrayList();
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1);
    if (paramArrayList == null) {
      return l1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB : troopUin: " + paramString1 + ", msgs size:" + paramArrayList.size());
    }
    Iterator localIterator = paramArrayList.iterator();
    long l3;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramArrayList = (msg_comm.Msg)localIterator.next();
        if (paramArrayList == null) {
          continue;
        }
        Object localObject = (msg_comm.MsgHead)paramArrayList.msg_head.get();
        l2 = ((msg_comm.MsgHead)localObject).msg_seq.get();
        l3 = ((msg_comm.MsgHead)localObject).msg_uid.get();
        long l4 = ((msg_comm.MsgHead)localObject).to_uin.get();
        long l5 = ((msg_comm.MsgHead)localObject).from_uin.get();
        long l6 = ((msg_comm.MsgHead)localObject).msg_time.get();
        int i = ((msg_comm.MsgHead)localObject).user_active.get();
        int j = ((msg_comm.MsgHead)localObject).from_instid.get();
        localObject = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject).group_info.get();
        int k = ((msg_comm.GroupInfo)localObject).group_type.get();
        long l7 = ((msg_comm.GroupInfo)localObject).group_code.get();
        long l8 = ((msg_comm.GroupInfo)localObject).group_info_seq.get();
        bbpd localbbpd = new bbpd();
        localObject = a((msg_comm.GroupInfo)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB : troopUin: " + paramString1 + ", fromUin:" + l5 + ",toUin:" + l4 + ",msgTime:" + l6 + ",msgSeq:" + l2 + ",msgUid:" + l3 + ",userActive:" + i + ",fromInstid:" + j + ",groupCode:" + l7 + ",groupType:" + k + ",groupSeq:" + l8 + ",cardName:" + bdeu.a((String)localObject) + ",hasAppShare:" + paramArrayList.appshare_info.has() + ",hasMsgBody:" + paramArrayList.msg_body.has());
        }
        localObject = new ArrayList();
        azai localazai = new azai();
        localazai.e = Long.valueOf(paramString1).longValue();
        localazai.jdField_c_of_type_Int = 1;
        localazai.d = k;
        if (paramArrayList.content_head.has())
        {
          msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)paramArrayList.content_head.get();
          i = localContentHead.div_seq.get();
          j = localContentHead.pkg_index.get();
          k = localContentHead.pkg_num.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB ContentHead: troopUin: " + paramString1 + ", divSeq:" + i + ",pkgIndex:" + j + ",pkgNum:" + k);
          }
        }
        l3 = System.currentTimeMillis();
        try
        {
          paramArrayList = a(paramArrayList, (ArrayList)localObject, localazai, true, localbbpd);
          if (paramArrayList != null) {
            paramString2.add(paramArrayList);
          }
          if (QLog.isColorLevel())
          {
            l4 = System.currentTimeMillis();
            QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB decodeSinglePbMsg_GroupDis: troopUin: " + paramString1 + ", cost=" + (l4 - l3));
          }
          if ((localObject != null) && (((ArrayList)localObject).size() != 0))
          {
            alww.a((List)localObject);
            paramArrayList2.addAll((Collection)localObject);
            if (l2 > l1) {
              l1 = l2;
            }
          }
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramArrayList);
            }
            paramArrayList = null;
          }
        }
      }
    }
    long l2 = System.currentTimeMillis();
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramString2);
    if (QLog.isColorLevel())
    {
      l3 = System.currentTimeMillis();
      QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB  saveTroopMemberNickAndLevelAndExtraInfo: troopUin: " + paramString1 + ", cost=" + (l3 - l2));
      l2 = l3;
    }
    for (;;)
    {
      if (paramArrayList2 != null) {
        a(paramArrayList2, paramArrayList1, true);
      }
      if (QLog.isColorLevel())
      {
        l3 = System.currentTimeMillis();
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---groupMsgRecordHandle_PB  msgListFilter: troopUin: " + paramString1 + ", cost=" + (l3 - l2));
      }
      return l1;
    }
  }
  
  @Nullable
  private String a(msg_comm.GroupInfo paramGroupInfo)
  {
    if ((paramGroupInfo.group_card.has()) && (paramGroupInfo.group_card.get() != null))
    {
      paramGroupInfo = paramGroupInfo.group_card.get().toByteArray();
      try
      {
        paramGroupInfo = new String(paramGroupInfo, "utf-8");
        return paramGroupInfo;
      }
      catch (UnsupportedEncodingException paramGroupInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "getCardName fail", paramGroupInfo);
        }
      }
    }
    return null;
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, MessageRecord paramMessageRecord)
  {
    String str;
    int i;
    if ((paramLong1 == 10000L) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.structingMsg != null) && (paramMessageRecord.structingMsg.mMsgServiceID == 60))
      {
        paramMessageRecord = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        str = String.valueOf(paramLong2);
        if (paramMessageRecord == null) {
          break label211;
        }
        paramMessageRecord = paramMessageRecord.b(paramString);
        if (paramMessageRecord == null) {
          break label205;
        }
        if ((!TextUtils.isEmpty(paramMessageRecord.troopowneruin)) || (!TextUtils.isEmpty(paramMessageRecord.Administrator))) {
          break label145;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if ((i != 2) || (paramMessageRecord == null)) {
        ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).c(Long.parseLong(paramString));
      }
      return;
      label145:
      if ((!TextUtils.isEmpty(paramMessageRecord.troopowneruin)) && (paramMessageRecord.troopowneruin.equalsIgnoreCase(str)))
      {
        i = 0;
      }
      else if ((!TextUtils.isEmpty(paramMessageRecord.Administrator)) && (paramMessageRecord.Administrator.contains(str)))
      {
        i = 1;
      }
      else
      {
        label205:
        i = 2;
        continue;
        label211:
        paramMessageRecord = null;
        i = 2;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList<msg_comm.Msg> paramArrayList, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, String paramString)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("groupuin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = String.valueOf(paramPbGetGroupMsgResp.group_code.get());
    }
    localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1);
    if (paramArrayList != null) {
      l1 = a(paramArrayList, (ArrayList)localObject2, (ArrayList)localObject3, (String)localObject1, paramString);
    }
    for (;;)
    {
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).e((String)localObject1);
      boolean bool1 = false;
      long l2;
      if ((paramPbGetGroupMsgResp.result.get() == 104) && (((ArrayList)localObject2).size() == 0))
      {
        l2 = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetGroupMsgResp.return_end_seq.get());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "initGetPullTroopMsg reply 104 !! reqEndSeq = " + l2);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1, l2);
      }
      for (int j = 1;; j = 0)
      {
        paramArrayList = new StringBuilder(128);
        int i;
        label690:
        boolean bool2;
        if (((ArrayList)localObject2).size() > 0)
        {
          Collections.sort((List)localObject2, this.b);
          paramToServiceMsg = new ArrayList();
          paramPbGetGroupMsgResp = new ArrayList();
          i = ((ArrayList)localObject2).size() - 1;
          if (i >= 0)
          {
            localObject3 = (MessageRecord)((ArrayList)localObject2).get(i);
            if (QLog.isColorLevel())
            {
              paramArrayList.setLength(0);
              paramArrayList.append("----------initGetPullTroopMsg update send message  mr.senderuin: ").append(((MessageRecord)localObject3).senderuin).append(" mr.msgtype: ").append(((MessageRecord)localObject3).msgtype).append(" mr.frienduin: ").append(((MessageRecord)localObject3).frienduin).append(" mr.shmsgseq: ").append(((MessageRecord)localObject3).shmsgseq).append(" mr.time:").append(((MessageRecord)localObject3).time).append(" mr.msg: ").append(((MessageRecord)localObject3).getLogColorContent());
              QLog.d("Q.msg.TroopMessageProcessor", 2, paramArrayList.toString());
            }
            if (((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || ((nav.a((MessageRecord)localObject3)) && (nav.b((MessageRecord)localObject3))))
            {
              if (nav.a((MessageRecord)localObject3))
              {
                ((MessageRecord)localObject3).senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                localObject4 = nav.a((MessageRecord)localObject3);
                nav.a().a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).vipBubbleID, ((naw)localObject4).jdField_b_of_type_Int, ((naw)localObject4).jdField_b_of_type_JavaLangString, ((naw)localObject4).jdField_c_of_type_Int, ((naw)localObject4).a, ((naw)localObject4).jdField_c_of_type_JavaLangString);
              }
              Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, 1, (MessageRecord)localObject3);
              if (localObject4 == null) {
                break label690;
              }
              if (((localObject3 instanceof MessageForText)) && ((localObject4 instanceof MessageForText)) && (((MessageRecord)localObject3).getRepeatCount() > 0))
              {
                ((MessageRecord)localObject4).setRepeatCount(((MessageRecord)localObject3).getRepeatCount());
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.TroopMessageProcessor", 2, "<---initGetPullTroopMsg_PB ===> update findMr.repeatCount=" + ((MessageRecord)localObject3).getRepeatCount());
                }
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d()) {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop, ((MessageRecord)localObject4).uniseq);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject3).frienduin, 1, ((MessageRecord)localObject4).uniseq, ((MessageRecord)localObject3).shmsgseq, ((MessageRecord)localObject3).time);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, ((MessageRecord)localObject3).shmsgseq);
            }
            for (;;)
            {
              i -= 1;
              break;
              if (!paramPbGetGroupMsgResp.contains(((MessageRecord)localObject3).senderuin)) {
                paramPbGetGroupMsgResp.add(((MessageRecord)localObject3).senderuin);
              }
              paramToServiceMsg.add(0, localObject3);
            }
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (paramPbGetGroupMsgResp != null) && (paramPbGetGroupMsgResp.size() > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (ayzl.a == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              ayzl.a = new ayzq();
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (ayzl.a.a == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              ayzl.a.a = new ConcurrentHashMap();
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            ayzl.a.a.put(localObject1, paramPbGetGroupMsgResp);
          }
          if (paramToServiceMsg.size() > 0)
          {
            paramPbGetGroupMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1);
            if (paramPbGetGroupMsgResp == null) {
              break label1341;
            }
            paramArrayList = (absl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1);
            l2 = ((Long)paramPbGetGroupMsgResp[0]).longValue();
            int k = paramToServiceMsg.size();
            i = 0;
            while (i < k)
            {
              paramPbGetGroupMsgResp = (MessageRecord)paramToServiceMsg.get(i);
              if ((paramPbGetGroupMsgResp instanceof MessageForMarketFace)) {
                aufm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)paramPbGetGroupMsgResp);
              }
              if ((((MessageRecord)paramToServiceMsg.get(i)).senderuin != null) && (((MessageRecord)paramToServiceMsg.get(i)).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
              {
                ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
                ((MessageRecord)paramToServiceMsg.get(i)).issend = 2;
              }
              if (l2 >= ((MessageRecord)paramToServiceMsg.get(i)).shmsgseq) {
                ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
              }
              i += 1;
            }
            if (paramArrayList.a((String)localObject1, 1, paramToServiceMsg, paramString)) {
              break label1341;
            }
            bool2 = alww.a(paramToServiceMsg);
            i = abti.a(paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramPbGetGroupMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop))
            {
              bool1 = true;
              paramPbGetGroupMsgResp.a(paramToServiceMsg, paramString, bool1, false);
              paramArrayList.b((String)localObject1, 1, l2);
              paramArrayList.a((String)localObject1, paramToServiceMsg);
              bool1 = bool2;
            }
          }
        }
        for (;;)
        {
          if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1) == 1))
          {
            paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1);
            if (paramArrayList != null)
            {
              l2 = ((Long)paramArrayList[0]).longValue();
              ((absl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1)).b((String)localObject1, 1, l2);
            }
          }
          if (l1 >= 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.TroopMessageProcessor", 2, "groupMsgRecordHandle info.lGroupCode: " + (String)localObject1 + " info.lsMsgSeq: " + l1);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, l1);
          }
          bool2 = alww.b(paramToServiceMsg);
          a("initGetPullTroopMsg", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool1, bool2, paramToServiceMsg), false);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg);
          ((bduj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a(paramToServiceMsg);
          if (paramToServiceMsg.size() > 0) {
            amky.a((MessageRecord)paramToServiceMsg.get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          return;
          bool1 = false;
          break;
          j = 1;
          i = 0;
          bool1 = false;
          continue;
          j = 1;
          paramToServiceMsg = (ToServiceMsg)localObject2;
          i = 0;
          continue;
          label1341:
          i = 0;
          bool1 = false;
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, ArrayList<msg_comm.Msg> paramArrayList, String paramString)
  {
    paramString = new ArrayList();
    bbpd localbbpd = new bbpd();
    Object localObject1;
    if (paramArrayList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---refreshTroopHead_PB: size:" + paramArrayList.size());
      }
      localObject1 = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramArrayList = (msg_comm.Msg)localIterator.next();
          if (paramArrayList == null) {
            continue;
          }
          Object localObject2 = (msg_comm.MsgHead)paramArrayList.msg_head.get();
          long l1 = ((msg_comm.MsgHead)localObject2).msg_seq.get();
          long l2 = ((msg_comm.MsgHead)localObject2).msg_uid.get();
          long l3 = ((msg_comm.MsgHead)localObject2).to_uin.get();
          long l4 = ((msg_comm.MsgHead)localObject2).from_uin.get();
          long l5 = ((msg_comm.MsgHead)localObject2).msg_time.get();
          int i = ((msg_comm.MsgHead)localObject2).user_active.get();
          int j = ((msg_comm.MsgHead)localObject2).from_instid.get();
          localObject2 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject2).group_info.get();
          int k = ((msg_comm.GroupInfo)localObject2).group_type.get();
          long l6 = ((msg_comm.GroupInfo)localObject2).group_code.get();
          long l7 = ((msg_comm.GroupInfo)localObject2).group_info_seq.get();
          Object localObject3 = a((msg_comm.GroupInfo)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMessageProcessor", 2, "<---refreshTroopHead_PB : fromUin:" + l4 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l1 + ",msgUid:" + l2 + ",userActive:" + i + ",fromInstid:" + j + ",groupCode:" + l6 + ",groupType:" + k + ",groupSeq:" + l7 + ",Hascard:" + ((msg_comm.GroupInfo)localObject2).group_card.has() + ",cardName:" + bdeu.a((String)localObject3) + ",hasAppShare:" + paramArrayList.appshare_info.has() + ",hasMsgBody:" + paramArrayList.msg_body.has());
          }
          localObject2 = new ArrayList();
          localObject3 = new azai();
          ((azai)localObject3).e = paramPbGetGroupMsgResp.group_code.get();
          ((azai)localObject3).jdField_c_of_type_Int = 1;
          ((azai)localObject3).d = k;
          if (paramArrayList.content_head.has())
          {
            msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)paramArrayList.content_head.get();
            i = localContentHead.div_seq.get();
            j = localContentHead.pkg_index.get();
            k = localContentHead.pkg_num.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.TroopMessageProcessor", 2, "<---refreshTroopHead_PB ContentHead: divSeq:" + i + ",pkgIndex:" + j + ",pkgNum:" + k);
            }
          }
          try
          {
            paramArrayList = a(paramArrayList, (ArrayList)localObject2, (azai)localObject3, true, localbbpd);
            if (paramArrayList != null)
            {
              paramArrayList.level = -1;
              ((ArrayList)localObject1).add(paramArrayList);
            }
            if (((ArrayList)localObject2).size() != 0)
            {
              alww.a((List)localObject2);
              if (paramString != null) {
                a((ArrayList)localObject2, paramString, true);
              }
            }
          }
          catch (Exception paramArrayList)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramArrayList);
              }
              paramArrayList = null;
            }
          }
        }
      }
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a((List)localObject1);
    }
    paramArrayList = paramString.iterator();
    while (paramArrayList.hasNext())
    {
      localObject1 = (MessageRecord)paramArrayList.next();
      if ((((MessageRecord)localObject1).senderuin != null) && (((MessageRecord)localObject1).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        ((MessageRecord)localObject1).issend = 2;
      }
      ((MessageRecord)localObject1).isread = true;
    }
    Collections.sort(paramString, this.b);
    paramArrayList = paramPbGetGroupMsgResp.group_code.toString();
    ((auga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37)).a(paramArrayList, localbbpd);
    paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
    paramArrayList = new ArrayList();
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.putLong("beginSeq", paramPbGetGroupMsgResp.return_begin_seq.get());
      paramToServiceMsg.putLong("endSeq", paramPbGetGroupMsgResp.return_end_seq.get());
      paramToServiceMsg.putBoolean("success", true);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramPbGetGroupMsgResp.group_code.get()), 1, paramString, paramArrayList, paramToServiceMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
    ((bduj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a(paramString);
  }
  
  private void a(String paramString, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (((paramMessageRecord1 instanceof MessageForText)) && ((paramMessageRecord2 instanceof MessageForText)) && (paramMessageRecord1.getRepeatCount() > 0))
    {
      paramMessageRecord2.setRepeatCount(paramMessageRecord1.getRepeatCount());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group ===> update findMr.repeatCount=" + paramMessageRecord2.getRepeatCount());
      }
    }
    long l = paramMessageRecord2.shmsgseq;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, paramMessageRecord1.shmsgseq, paramMessageRecord1.time);
    Object localObject1;
    if (paramMessageRecord1.msgtype == -2011)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.frienduin, 1, paramMessageRecord1.shmsgseq, -5020);
      if ((localObject1 != null) && ((localObject1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject1).tipParam != null) && (((MessageForUniteGrayTip)localObject1).tipParam.jdField_b_of_type_Int == 3276802))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(paramMessageRecord1.frienduin, 1, ((MessageRecord)localObject1).uniseq);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord1.frienduin, 1, (MessageRecord)localObject1);
        QLog.i("Q.msg.TroopMessageProcessor" + bagj.i, 1, "updateGroupMsgSeqAndTime. docs gray msg. shmsgseq = " + paramMessageRecord1.shmsgseq + ", grayMsgType = " + -5020 + ", grayUniSeq = " + ((MessageRecord)localObject1).uniseq);
      }
    }
    label342:
    label361:
    while (paramMessageRecord1.msgtype != -2000)
    {
      if (paramMessageRecord2.msgtype != -2017) {
        break;
      }
      localObject1 = abti.a(paramMessageRecord2, paramMessageRecord1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, (byte[])localObject1);
      afcu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord2.uniseq);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord2)) {
        break label888;
      }
      a(paramMessageRecord2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramMessageRecord1.shmsgseq);
      return;
    }
    label900:
    label906:
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramMessageRecord1.frienduin, 1, l, -5040);
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label900;
        }
        localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
        if (!QLog.isColorLevel()) {
          break label906;
        }
        QLog.i("Q.msg.TroopMessageProcessorTroopGrayTipUtils", 2, "updateGroupMsgSeqAndTime. grayMr = " + localObject1);
      }
      catch (Exception localException)
      {
        QLog.i("Q.msg.TroopMessageProcessorTroopGrayTipUtils", 1, "update grayTip seq exception", localException);
      }
      if ((localObject1 == null) || (!(localObject1 instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)localObject1).tipParam == null) || (((MessageForUniteGrayTip)localObject1).tipParam.jdField_b_of_type_Int != 131086)) {
        break;
      }
      l = Long.parseLong(((MessageRecord)localObject1).getExtInfoFromExtStr("grayLastUniseq"));
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.TroopMessageProcessorTroopGrayTipUtils", 2, "updateGroupMsgSeqAndTime. TroopGrayTip. grayMr.lastUniseq=" + l);
      }
      if (l != paramMessageRecord2.uniseq) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.frienduin, 1, ((MessageRecord)localObject1).uniseq, paramMessageRecord1.shmsgseq, paramMessageRecord1.time);
      break;
      break;
      if ((azwa.a(paramMessageRecord2)) || (paramMessageRecord2.msgtype == -2048))
      {
        if (paramMessageRecord1.msgtype == -2048)
        {
          localObject2 = (MessageForTroopReward)paramMessageRecord1;
          ((MessageForTroopReward)localObject2).mediaPath = ((MessageForTroopReward)paramMessageRecord2).mediaPath;
          ((MessageForTroopReward)localObject2).prewrite();
          paramMessageRecord1.msgData = ((MessageForTroopReward)localObject2).msgData;
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_reward", 2, "replace msg,rewardId:" + ((MessageForTroopReward)localObject2).rewardId);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, paramMessageRecord1.msgData);
        a(999, true, paramMessageRecord1.frienduin);
        break label342;
      }
      if (paramMessageRecord2.msgtype != -1049) {
        break label342;
      }
      Object localObject2 = (MessageForReplyText)paramMessageRecord2;
      ((MessageForReplyText)paramMessageRecord1).extStr = ((MessageForReplyText)localObject2).extStr;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, "extStr", paramMessageRecord1.extStr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord1.frienduin, 1, paramMessageRecord2.uniseq, "extLong", Integer.valueOf(paramMessageRecord1.extLong));
      break label342;
      label888:
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord1, paramMessageRecord2);
      break label361;
      localObject2 = null;
    }
  }
  
  private void a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---TroopMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.TroopMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, boolean paramBoolean)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).group_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject2 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
    long l2 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l6 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l3 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    long l4 = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l7 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int i1 = ((msg_comm.MsgHead)localObject1).user_active.get();
    int i2 = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l8 = ((msg_comm.GroupInfo)localObject2).group_code.get();
    int n = ((msg_comm.GroupInfo)localObject2).group_type.get();
    long l9 = ((msg_comm.GroupInfo)localObject2).group_info_seq.get();
    label178:
    long l5;
    Object localObject3;
    int k;
    int i;
    int j;
    if (paramFromServiceMsg.getUin() == null)
    {
      localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      l5 = ((Long)localObject1).longValue();
      localObject3 = a((msg_comm.GroupInfo)localObject2);
      localObject1 = new ArrayList();
      if (!paramMsg.content_head.has()) {
        break label1694;
      }
      localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
      k = ((msg_comm.ContentHead)localObject2).div_seq.get();
      i = ((msg_comm.ContentHead)localObject2).pkg_index.get();
      int m = ((msg_comm.ContentHead)localObject2).pkg_num.get();
      j = i;
      i = m;
    }
    for (;;)
    {
      String str;
      boolean bool1;
      label355:
      boolean bool2;
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int = i1;
        str = String.valueOf(l8);
        localObject2 = new ArrayList();
        azai localazai = new azai();
        localazai.e = l8;
        localazai.jdField_c_of_type_Int = 1;
        localazai.d = n;
        Object localObject4;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder().append("<---handleMsgPush_PB_Group : needAck ").append(paramBoolean).append(" pushMsg ");
          if (paramPbPushMsg != null)
          {
            bool1 = true;
            QLog.d("Q.msg.TroopMessageProcessor", 2, bool1);
          }
        }
        else
        {
          if ((paramBoolean) && (paramPbPushMsg != null)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l5, paramPbPushMsg.svrip.get(), paramFromServiceMsg.getRequestSsoSeq(), paramPbPushMsg);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str) != 2) {
            break label467;
          }
        }
        label467:
        for (paramBoolean = true;; paramBoolean = false)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a()) {
            break label473;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : isNeedPushMsg false");
          return;
          localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
          break label178;
          bool1 = false;
          break label355;
        }
        label473:
        paramPbPushMsg = (auga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
        if (!MessageHandler.b)
        {
          if (paramBoolean) {
            break label608;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, new Object[] { paramMsg, paramFromServiceMsg });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : unfinished troopuin=" + str);
          return;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, new Object[] { paramMsg, paramFromServiceMsg });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : isSyncNormalMsgFinish false");
          return;
        }
        label608:
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder("<---handleMsgPush_PB_Group : before analysis :");
          ((StringBuilder)localObject4).append(" fromUin:").append(l2).append(" toUin:").append(l6).append(" msgTime:").append(l4).append(" msgSeq:").append(l3).append(" msgUid:").append(l7).append(" userActive:").append(i1).append(" fromInstid:").append(i2).append(" groupCode:").append(l8).append(" groupType:").append(n).append(" groupSeq:").append(l9).append(" cardName:").append(bdeu.a((String)localObject3)).append(" hasAppShare:").append(paramMsg.appshare_info.has()).append(" bFinished:").append(paramBoolean).append(" divSeq:").append(k).append(" pkgIndex:").append(j).append(" pkgNum:").append(i);
          QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject4).toString());
          if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
          {
            l6 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() / 1000L;
            QLog.d("Q.msg.TroopMessageProcessor", 2, "push_cost=" + (l6 - l4) + ",type=GROUP_PUSH_MSG");
          }
        }
        ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).e(str);
        paramFromServiceMsg = new bbpd();
        try
        {
          a(paramMsg, (ArrayList)localObject1, localazai, true, paramFromServiceMsg);
          alww.a((List)localObject1);
          if (((ArrayList)localObject1).size() == 0)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : msg list is empty after decode.");
            return;
          }
        }
        catch (Exception paramMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
            }
          }
          a((ArrayList)localObject1, (ArrayList)localObject2, true);
          paramMsg = new ArrayList();
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            j = ((ArrayList)localObject2).size();
            i = 0;
            if (i < j)
            {
              localObject3 = (MessageRecord)((ArrayList)localObject2).get(i);
              a(l2, l5, str, (MessageRecord)localObject3);
              if ((localObject3 instanceof MessageForMarketFace)) {
                aufm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)localObject3);
              }
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder("<---handleMsgPush_PB_Group : after analysis :");
                ((StringBuilder)localObject4).append(" mr.senderuin:").append(((MessageRecord)localObject3).senderuin).append(" mr.msgtype:").append(((MessageRecord)localObject3).msgtype).append(" mr.frienduin:").append(((MessageRecord)localObject3).frienduin).append(" mr.shmsgseq:").append(((MessageRecord)localObject3).shmsgseq).append(" mr.time:").append(((MessageRecord)localObject3).time).append(" mr.msg:").append(((MessageRecord)localObject3).getLogColorContent());
                QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject4).toString());
              }
              if (((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || ((nav.a((MessageRecord)localObject3)) && (nav.b((MessageRecord)localObject3))))
              {
                if (nav.a((MessageRecord)localObject3))
                {
                  ((MessageRecord)localObject3).senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                  localObject4 = nav.a((MessageRecord)localObject3);
                  nav.a().a(String.valueOf(localazai.e), ((MessageRecord)localObject3).vipBubbleID, ((naw)localObject4).jdField_b_of_type_Int, ((naw)localObject4).jdField_b_of_type_JavaLangString, ((naw)localObject4).jdField_c_of_type_Int, ((naw)localObject4).a, ((naw)localObject4).jdField_c_of_type_JavaLangString);
                }
                localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, 1, (MessageRecord)localObject3);
                if (localObject4 != null) {
                  a(str, (MessageRecord)localObject3, (MessageRecord)localObject4);
                }
              }
              for (;;)
              {
                i += 1;
                break;
                ((MessageRecord)localObject3).isread = true;
                ((MessageRecord)localObject3).issend = 2;
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, 1, ((MessageRecord)localObject3).shmsgseq);
                paramMsg.add(localObject3);
                if ((localObject3 instanceof MessageForTroopFile)) {
                  ((bajc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(272)).a((ChatMessage)localObject3);
                }
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMsg);
          bool1 = alww.a(paramMsg);
          bool2 = alww.b(paramMsg);
          i = abti.a(paramMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramPbPushMsg.a(str, paramFromServiceMsg);
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (!bool1) {
            break label1688;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {}
      label1688:
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramFromServiceMsg.a(paramMsg, String.valueOf(l5), paramBoolean);
        azpz.a(0, 1, 1, paramMsg.size());
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, l3);
          paramFromServiceMsg = (MessageRecord)((ArrayList)localObject1).get(0);
          ((bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).c(paramFromServiceMsg);
        }
        if (n == 127) {
          break;
        }
        a("handleMsgPush_PB_Group", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool1, bool2, paramMsg), false);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramMsg);
        ((bduj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a((List)localObject2);
        l1 = System.currentTimeMillis() - l1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "decodecMsg cost:" + l1);
        }
        amky.a("actGroupDecodeCost", l1);
        if (((ArrayList)localObject2).size() <= 0) {
          break;
        }
        amky.a((MessageRecord)((ArrayList)localObject2).get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      label1694:
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, azai paramazai)
  {
    return null;
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList;
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2], ((Boolean)paramVarArgs[3]).booleanValue());
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetGroupMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      localArrayList = new ArrayList();
      a((ArrayList)paramVarArgs[2], localArrayList);
      a((ToServiceMsg)paramVarArgs[0], (msg_svc.PbGetGroupMsgResp)paramVarArgs[1], localArrayList, (String)paramVarArgs[3]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    String str = String.valueOf(paramGroupMsgReadedNotify.lGroupCode);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "GroupMsgReadedNotify lGroupCode is " + paramGroupMsgReadedNotify.lGroupCode + ", lMemberSeq  is " + paramGroupMsgReadedNotify.lMemberSeq);
    }
    Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str);
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2))
    {
      long l = ((Long)arrayOfObject[0]).longValue();
      ((Long)arrayOfObject[1]).longValue();
      if (l < paramGroupMsgReadedNotify.lMemberSeq) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, new Object[] { Long.valueOf(paramGroupMsgReadedNotify.lMemberSeq), Long.valueOf(paramGroupMsgReadedNotify.lGroupMsgSeq) });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 1, paramGroupMsgReadedNotify.lMemberSeq);
    if (paramGroupMsgReadedNotify.lMemberSeq >= 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.a(str, 1);
    }
    paramGroupMsgReadedNotify = (bcml)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
    if (paramGroupMsgReadedNotify.b(str))
    {
      paramGroupMsgReadedNotify.d(str);
      if (!paramGroupMsgReadedNotify.a(str)) {
        paramGroupMsgReadedNotify.b(str);
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    if (!paramString.matches("^\\d+$")) {
      return;
    }
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbGroupReadedReportReq localPbGroupReadedReportReq = new msg_svc.PbGroupReadedReportReq();
    localPbGroupReadedReportReq.group_code.set(Long.valueOf(paramString).longValue());
    localPbGroupReadedReportReq.last_read_seq.set(paramLong);
    localPbMsgReadedReportReq.grp_read_report.add(localPbGroupReadedReportReq);
    a(localPbMsgReadedReportReq);
  }
  
  public void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "doSomeAfterGetPullTroopMsg doSome:" + paramInt + " troopUin:" + paramString);
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    }
    ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramString, paramPbGetGroupMsgResp, paramInt);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtv
 * JD-Core Version:    0.7.0.1
 */