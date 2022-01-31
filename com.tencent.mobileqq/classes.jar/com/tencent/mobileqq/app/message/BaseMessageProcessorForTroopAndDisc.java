package com.tencent.mobileqq.app.message;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr.LocationInfo;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;
import zso;
import zsp;

public class BaseMessageProcessorForTroopAndDisc
  extends BaseMessageProcessor
{
  protected Comparator a;
  
  public BaseMessageProcessorForTroopAndDisc(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilComparator = new zsp(this);
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if ((paramMessageRecord == null) || ((!"com.tencent.homeworkContent".equals(paramMessageRecord.appName)) && (!"com.tencent.test.homeworkContent".equals(paramMessageRecord.appName)))) {}
    }
    else
    {
      do
      {
        return true;
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break;
        }
        paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      } while ((paramMessageRecord != null) && (paramMessageRecord.mMsgServiceID == 60));
    }
    return false;
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForArkApp)) && ("com.tencent.qqopen.teamup".equals(((MessageForArkApp)paramMessageRecord).ark_app_message.appName));
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      bool1 = bool2;
      if (paramMessageRecord.ark_app_message != null)
      {
        bool1 = bool2;
        if (ArkAiAppCenter.a(paramMessageRecord.ark_app_message.appName)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    long l7;
    Object localObject7;
    long l8;
    long l3;
    long l2;
    long l9;
    Object localObject2;
    int m;
    int k;
    int j;
    long l1;
    label233:
    Object localObject3;
    label284:
    byte b2;
    MessageRecord localMessageRecord;
    byte b1;
    int i;
    label960:
    Object localObject6;
    long l5;
    Object localObject8;
    Object localObject9;
    Object localObject10;
    int i1;
    label2377:
    int n;
    for (;;)
    {
      MessageInfo localMessageInfo;
      try
      {
        l7 = System.currentTimeMillis();
        if ((paramPBDecodeContext == null) || (paramMsg == null) || (paramArrayList == null)) {
          break label6734;
        }
        localObject7 = (msg_comm.MsgHead)paramMsg.msg_head.get();
        l8 = ((msg_comm.MsgHead)localObject7).from_uin.get();
        ((msg_comm.MsgHead)localObject7).to_uin.get();
        l3 = ((msg_comm.MsgHead)localObject7).msg_seq.get();
        l2 = ((msg_comm.MsgHead)localObject7).msg_time.get();
        l9 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (paramPBDecodeContext.c == 1026)
        {
          l3 = Utils.a(((msg_comm.MsgHead)localObject7).msg_seq.get());
          l2 = Utils.a(((msg_comm.MsgHead)localObject7).msg_time.get());
        }
        if (!paramMsg.content_head.has()) {
          break label6722;
        }
        localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
        m = ((msg_comm.ContentHead)localObject2).div_seq.get();
        k = ((msg_comm.ContentHead)localObject2).pkg_num.get();
        j = ((msg_comm.ContentHead)localObject2).pkg_index.get();
        localObject2 = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(l8), String.valueOf(l8));
        if (((Long)((Pair)localObject2).first).longValue() != 4294967295L)
        {
          l1 = ((Long)((Pair)localObject2).first).longValue();
          break label6736;
          localObject3 = new ArrayList();
          localMessageInfo = new MessageInfo();
          if (paramMsg.appshare_info.has())
          {
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject3, paramMsg, paramPBDecodeContext.e, l2, false);
            localObject2 = null;
            l1 = 0L;
            if ((((List)localObject3).size() == 0) && (k > 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "<---decodeSinglePbMsg_GroupDis, empty long msg fragment");
              }
              localObject4 = (MessageForText)MessageRecordFactory.a(-1000);
              ((MessageForText)localObject4).msgtype = -1000;
              ((MessageForText)localObject4).msg = "";
              ((List)localObject3).add(localObject4);
            }
            b2 = 0;
            Iterator localIterator = ((List)localObject3).iterator();
            localObject3 = null;
            if (!localIterator.hasNext()) {
              break label3933;
            }
            localMessageRecord = (MessageRecord)localIterator.next();
            localMessageRecord.time = l2;
            localMessageRecord.msgseq = l2;
            localMessageRecord.shmsgseq = l3;
            localMessageRecord.msgUid = l1;
            localMessageRecord.selfuin = str;
            localMessageRecord.istroop = paramPBDecodeContext.c;
            localMessageRecord.senderuin = String.valueOf(l8);
            localMessageRecord.frienduin = String.valueOf(paramPBDecodeContext.e);
            localMessageRecord.longMsgId = m;
            localMessageRecord.longMsgCount = k;
            localMessageRecord.longMsgIndex = j;
            if (((localMessageRecord instanceof MessageForFoldMsg)) && (QLog.isColorLevel())) {
              QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, frienduin: %s, senduin: %s, msguid: %s, shmsgseq: %s content: %s", new Object[] { localMessageRecord.frienduin, localMessageRecord.senderuin, Long.valueOf(localMessageRecord.msgUid), Long.valueOf(localMessageRecord.shmsgseq), localMessageRecord.getLogColorContent() }));
            }
            if (paramPBDecodeContext.d == 127)
            {
              localMessageRecord.msg = "PTT_URL";
              localMessageRecord.msgtype = -2006;
              localMessageRecord.isread = true;
            }
            if (localMessageRecord.msgtype == -1035) {
              ((ChatMessage)localMessageRecord).parse();
            }
            b1 = b2;
            if (((msg_comm.MsgHead)localObject7).msg_flag.has())
            {
              b1 = b2;
              if ((((msg_comm.MsgHead)localObject7).msg_flag.get() & 1L) == 1L)
              {
                b1 = b2;
                if (localMessageRecord.msgtype != -2058)
                {
                  b2 = 1;
                  localMessageInfo.b.a(l3, localMessageRecord.uniseq);
                  b1 = b2;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "receive the TroopMsg from TroopSpecialAttention!");
                    b1 = b2;
                  }
                }
              }
            }
            if (a(localMessageRecord)) {
              localMessageInfo.d.a(l3, localMessageRecord.uniseq);
            }
            if (b(localMessageRecord)) {
              localMessageInfo.p.a(l3, localMessageRecord.uniseq);
            }
            if (c(localMessageRecord)) {
              localMessageInfo.t.a(l3, localMessageRecord.uniseq);
            }
            if (localMessageRecord.msgtype == -1049)
            {
              localObject4 = (MessageForReplyText)localMessageRecord;
              if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((MessageForReplyText)localObject4).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
                localMessageInfo.i.a(l3, localMessageRecord.uniseq);
              }
            }
            if (localMessageRecord.msgtype == -5015) {
              localMessageInfo.s.a(l3, localMessageRecord.uniseq);
            }
            if (localMessageRecord.msgtype == -2058) {
              EmojiStickerManager.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            if (((localMessageRecord.msgtype != -2058) || (paramMessageInfo.q.a != -1L) || (paramMessageInfo.q.b != -1L)) || (localMessageRecord.msgtype == -1035))
            {
              localObject4 = (MessageForMixedMsg)localMessageRecord;
              i = 0;
              if (i < ((MessageForMixedMsg)localObject4).msgElemList.size())
              {
                localObject6 = (MessageRecord)((MessageForMixedMsg)localObject4).msgElemList.get(i);
                if (!(localObject6 instanceof MessageForReplyText)) {
                  break label6754;
                }
                localObject4 = (MessageForReplyText)localObject6;
                if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((MessageForReplyText)localObject4).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
                  localMessageInfo.i.a(l3, localMessageRecord.uniseq);
                }
              }
            }
            if (localMessageRecord.msgtype == -2044)
            {
              localObject4 = (MessageForTroopTopic)localMessageRecord;
              ((TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97)).a(TroopTopicDetailInfo.copyFrom((MessageForTroopTopic)localObject4));
            }
            if ((localMessageRecord.msgtype == -2035) || (localMessageRecord.msgtype == -2038))
            {
              localObject4 = (MessageForDeliverGiftTips)localMessageRecord;
              localObject6 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForDeliverGiftTips)localObject4).istroop, ((MessageForDeliverGiftTips)localObject4).frienduin, ((MessageForDeliverGiftTips)localObject4).senderuin);
              if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                ((MessageForDeliverGiftTips)localObject4).senderName = ((String)localObject6);
              }
              if (!((MessageForDeliverGiftTips)localObject4).isFromNearby)
              {
                localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                if (!TextUtils.isEmpty((CharSequence)localObject6))
                {
                  if ((!((String)localObject6).equals(((MessageForDeliverGiftTips)localObject4).receiverUin + "")) && (!((MessageForDeliverGiftTips)localObject4).isToAll())) {
                    continue;
                  }
                  localMessageInfo.e.a(l3, localMessageRecord.uniseq);
                }
                localObject6 = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222);
                if (localObject6 != null) {
                  ((AIOAnimationControlManager)localObject6).b((MessageForDeliverGiftTips)localObject4);
                }
              }
            }
            if (NearbyFlowerUtil.a(localMessageRecord))
            {
              localObject4 = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localMessageRecord);
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
              {
                if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((NearbyFlowerMessage)localObject4).rUin)) {
                  break label2910;
                }
                localMessageInfo.e.a(l3, localMessageRecord.uniseq);
              }
            }
            if ((localMessageRecord instanceof MessageForStructing))
            {
              localObject4 = StructMsgFactory.a(localMessageRecord.msgData);
              if ((localObject4 instanceof StructMsgForGeneralShare))
              {
                localObject4 = (StructMsgForGeneralShare)localObject4;
                if ((localObject4 == null) || (((StructMsgForGeneralShare)localObject4).mMsgServiceID != 75)) {
                  break label2947;
                }
                localObject4 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                l5 = localMessageRecord.uniseq;
                localObject4 = localMessageRecord.frienduin;
                localObject8 = new BaseMessageManager.AddMessageContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                localObject6 = ((BaseMessageManager.AddMessageContext)localObject8).jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
                localObject8 = ((BaseMessageManager.AddMessageContext)localObject8).jdField_a_of_type_JavaUtilMap;
                localObject6 = ((RecentUserProxy)localObject6).a((String)localObject4, 1);
                TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord.frienduin, StructMsgForGeneralShare.eventId, localMessageRecord.shmsgseq, new zso(this, false, localMessageInfo, l3, l5, (RecentUser)localObject6, (String)localObject4, localMessageRecord, (Map)localObject8));
              }
            }
            if ((localMessageRecord instanceof MessageForTroopFile)) {
              localMessageInfo.k.a(l3, localMessageRecord.uniseq);
            }
            if (TroopBindPublicAccountMgr.a(localMessageRecord)) {
              localMessageInfo.g.a(l3, localMessageRecord.uniseq);
            }
            if (localMessageRecord.msgtype == -2039)
            {
              localObject6 = (MessageForApollo)localMessageRecord;
              localObject8 = new ArrayList(2);
              localObject9 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
              localObject4 = null;
              if (QLog.isColorLevel()) {
                localObject4 = new StringBuilder("decode apollo troop msg: ").append(", id: ").append(((MessageForApollo)localObject6).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject6).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject6).isDoubleAction()).append(", time: ").append(localMessageRecord.time).append("\nsender: ").append(localMessageRecord.senderuin);
              }
              if (!localMessageRecord.isSend())
              {
                localObject10 = ((ApolloManager)localObject9).b(((MessageForApollo)localObject6).senderuin);
                if (QLog.isColorLevel()) {
                  ((StringBuilder)localObject4).append(", update time: ").append(((ApolloBaseInfo)localObject10).apolloUpdateTime);
                }
                if ((localMessageRecord.time > ((ApolloBaseInfo)localObject10).apolloUpdateTime) && ((((ApolloBaseInfo)localObject10).apolloServerTS < ((MessageForApollo)localObject6).mApolloMessage.sender_ts) || (((ApolloBaseInfo)localObject10).apolloStatus != ((MessageForApollo)localObject6).mApolloMessage.sender_status) || (((ApolloBaseInfo)localObject10).apolloVipFlag != (((MessageForApollo)localObject6).mApolloMessage.flag >> 30 & 0x1))))
                {
                  ((ApolloBaseInfo)localObject10).apolloStatus = ((MessageForApollo)localObject6).mApolloMessage.sender_status;
                  ((ApolloBaseInfo)localObject10).apolloServerTS = ((MessageForApollo)localObject6).mApolloMessage.sender_ts;
                  ((ApolloBaseInfo)localObject10).apolloVipFlag = (((MessageForApollo)localObject6).mApolloMessage.flag >> 30 & 0x1);
                  ((ApolloBaseInfo)localObject10).apolloUpdateTime = localMessageRecord.time;
                  ((ArrayList)localObject8).add(localObject10);
                  if (QLog.isColorLevel()) {
                    ((StringBuilder)localObject4).append("\n save apollo info: ").append(((ApolloBaseInfo)localObject10).apolloVipFlag).append("|").append(((ApolloBaseInfo)localObject10).apolloStatus).append("|").append(((ApolloBaseInfo)localObject10).apolloLocalTS).append("|").append(((ApolloBaseInfo)localObject10).apolloServerTS).append("|").append(((ApolloBaseInfo)localObject10).apolloUpdateTime);
                  }
                }
              }
              if ((((MessageForApollo)localObject6).isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((MessageForApollo)localObject6).mApolloMessage.peer_uin + "")))
              {
                localObject10 = ((ApolloManager)localObject9).b(((MessageForApollo)localObject6).mApolloMessage.peer_uin + "");
                if (QLog.isColorLevel()) {
                  ((StringBuilder)localObject4).append("\n peer: ").append(((ApolloBaseInfo)localObject10).uin).append(", update time: ").append(((ApolloBaseInfo)localObject10).apolloUpdateTime);
                }
                if ((localMessageRecord.time > ((ApolloBaseInfo)localObject10).apolloUpdateTime) && ((((ApolloBaseInfo)localObject10).apolloServerTS < ((MessageForApollo)localObject6).mApolloMessage.peer_ts) || (((ApolloBaseInfo)localObject10).apolloStatus != ((MessageForApollo)localObject6).mApolloMessage.peer_status) || (((ApolloBaseInfo)localObject10).apolloVipFlag != (((MessageForApollo)localObject6).mApolloMessage.flag >> 31 & 0x1))))
                {
                  ((ApolloBaseInfo)localObject10).apolloStatus = ((MessageForApollo)localObject6).mApolloMessage.peer_status;
                  ((ApolloBaseInfo)localObject10).apolloServerTS = ((MessageForApollo)localObject6).mApolloMessage.peer_ts;
                  ((ApolloBaseInfo)localObject10).apolloVipFlag = (((MessageForApollo)localObject6).mApolloMessage.flag >> 31 & 0x1);
                  ((ApolloBaseInfo)localObject10).apolloUpdateTime = localMessageRecord.time;
                  ((ArrayList)localObject8).add(localObject10);
                  if (QLog.isColorLevel()) {
                    ((StringBuilder)localObject4).append("\n save apollo info ").append(((ApolloBaseInfo)localObject10).apolloVipFlag).append("|").append(((ApolloBaseInfo)localObject10).apolloStatus).append("|").append(((ApolloBaseInfo)localObject10).apolloLocalTS).append("|").append(((ApolloBaseInfo)localObject10).apolloServerTS).append("|").append(((ApolloBaseInfo)localObject10).apolloUpdateTime);
                  }
                }
              }
              if (((ArrayList)localObject8).size() > 0) {
                ((ApolloManager)localObject9).b((List)localObject8);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, ((StringBuilder)localObject4).toString());
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
              {
                i1 = ((ApolloManager)localObject9).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
                localObject4 = "";
                if (((MessageForApollo)localObject6).msgType != 0) {
                  break label3103;
                }
                localObject4 = String.valueOf(((MessageForApollo)localObject6).mApolloMessage.id);
                if (localMessageRecord.istroop != 1) {
                  break label6763;
                }
                i = 1;
                localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false);
                n = i;
                if (localObject8 != null)
                {
                  n = i;
                  if (((HotChatManager)localObject8).b(localMessageRecord.frienduin)) {
                    n = 3;
                  }
                }
                VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(localMessageRecord.senderuin), n, ((MessageForApollo)localObject6).msgType, new String[] { localObject4, Integer.toString(i1), Integer.toString(ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000L) });
              }
            }
            if (paramMessageInfo != null)
            {
              if (localMessageInfo.c.a != -1L) {
                localMessageInfo.c.b = localMessageRecord.uniseq;
              }
              if (localMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a != -1L) {
                localMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.b = localMessageRecord.uniseq;
              }
              if ((l3 > this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramPBDecodeContext.e), paramPBDecodeContext.c)) && (localMessageInfo.a()))
              {
                paramMessageInfo.a(localMessageInfo);
                localMessageRecord.mMessageInfo = localMessageInfo;
              }
            }
            if (((paramPBDecodeContext.c != 1) && (paramPBDecodeContext.c != 1026) && (paramPBDecodeContext.c != 3000)) || (localObject2 == null) || (TextUtils.equals(localMessageRecord.selfuin, localMessageRecord.senderuin))) {
              break label3343;
            }
            i = 0;
            localObject4 = ((List)localObject2).iterator();
            label2662:
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            if (!((im_msg_body.Elem)((Iterator)localObject4).next()).anon_group_msg.has()) {
              break label6697;
            }
            i = 1;
            break label6751;
          }
        }
        else
        {
          l1 = ((Long)((Pair)localObject2).second).longValue();
          break label6736;
        }
        if (!paramMsg.msg_body.has()) {
          break label6706;
        }
        localObject2 = (im_msg_body.MsgBody)paramMsg.msg_body.get();
        if (!((im_msg_body.MsgBody)localObject2).rich_text.has()) {
          break label6706;
        }
        localObject4 = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject2).rich_text.get();
        if (!((im_msg_body.RichText)localObject4).attr.has()) {
          break label6700;
        }
        l1 = MessageUtils.a(((im_msg_body.Attr)((im_msg_body.RichText)localObject4).attr.get()).random.get());
        label2792:
        localObject2 = ((im_msg_body.RichText)localObject4).elems.get();
        if (((im_msg_body.RichText)localObject4).ptt.has())
        {
          MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, (List)localObject3);
          continue;
        }
        localMessageInfo.jdField_a_of_type_JavaLangString = String.valueOf(paramPBDecodeContext.e);
        localMessageInfo.jdField_a_of_type_Int = paramPBDecodeContext.c;
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject3, paramMsg, false, false, localMessageInfo);
        continue;
        if (((MessageForDeliverGiftTips)localObject4).animationPackageId <= 0) {
          continue;
        }
        localMessageInfo.f.a(l3, localMessageRecord.uniseq);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((NearbyFlowerMessage)localObject4).sUin)) {
          continue;
        }
      }
      catch (Throwable paramMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis failure : ", paramMsg);
        }
        return null;
      }
      label2910:
      localMessageInfo.f.a(l3, localMessageRecord.uniseq);
      continue;
      label2947:
      if ((localObject4 != null) && (((StructMsgForGeneralShare)localObject4).mMsgServiceID == 19) && (!((StructMsgForGeneralShare)localObject4).mMsgBrief.startsWith("新建群相册")) && (!((StructMsgForGeneralShare)localObject4).mMsgBrief.equals("评论了照片")))
      {
        localMessageInfo.l.a(l3, localMessageRecord.uniseq);
      }
      else if ((localObject4 != null) && (((StructMsgForGeneralShare)localObject4).mMsgServiceID == 106))
      {
        if ((((StructMsgForGeneralShare)localObject4).atMembers != null) && (((StructMsgForGeneralShare)localObject4).atMembers.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          localMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(l3, localMessageRecord.uniseq);
        }
      }
      else if ((localObject4 != null) && (((StructMsgForGeneralShare)localObject4).mMsgServiceID == 107))
      {
        localMessageInfo.r.a(l3, localMessageRecord.uniseq);
        continue;
        label3103:
        if (ApolloGameUtil.a(((MessageForApollo)localObject6).msgType)) {
          localObject4 = "" + ((MessageForApollo)localObject6).gameId;
        }
      }
    }
    Object localObject4 = ((List)localObject2).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject6 = (im_msg_body.Elem)((Iterator)localObject4).next();
      if ((i == 0) && (((im_msg_body.Elem)localObject6).extra_info.has()))
      {
        localObject6 = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject6).extra_info.get();
        if (((im_msg_body.ExtraInfo)localObject6).uint32_msg_tail_id.has())
        {
          n = ((im_msg_body.ExtraInfo)localObject6).uint32_msg_tail_id.get();
          if (n > 0)
          {
            localObject6 = MessageRecordFactory.a(-1002);
            if (localObject6 != null)
            {
              localObject8 = Integer.toString(n);
              localObject9 = new SafeMsg.SafeMoreInfo();
              ((SafeMsg.SafeMoreInfo)localObject9).strMsgTxt.set((String)localObject8);
              ((MessageRecord)localObject6).init(localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.senderuin, (String)localObject8, localMessageRecord.time, -1002, localMessageRecord.istroop, localMessageRecord.msgseq);
              ((MessageRecord)localObject6).isread = true;
              ((MessageRecord)localObject6).shmsgseq = localMessageRecord.shmsgseq;
              ((MessageRecord)localObject6).msgData = ((SafeMsg.SafeMoreInfo)localObject9).toByteArray();
              paramArrayList.add(localObject6);
            }
          }
        }
      }
    }
    label3343:
    label3521:
    Object localObject5;
    label3603:
    label3933:
    boolean bool1;
    boolean bool2;
    double d1;
    label3997:
    boolean bool3;
    label4112:
    boolean bool4;
    label4172:
    label4199:
    double d2;
    if (paramPBDecodeContext.c != 1)
    {
      localObject4 = localObject3;
      if (paramPBDecodeContext.c != 1026) {}
    }
    else
    {
      localObject4 = localObject3;
      if (localObject2 != null)
      {
        localObject6 = ((List)localObject2).iterator();
        do
        {
          localObject4 = localObject3;
          if (!((Iterator)localObject6).hasNext()) {
            break label6690;
          }
          localObject8 = (im_msg_body.Elem)((Iterator)localObject6).next();
          if (((im_msg_body.Elem)localObject8).anon_group_msg.has())
          {
            localObject8 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject8).anon_group_msg.get();
            i = ((im_msg_body.AnonymousGroupMsg)localObject8).uint32_flags.get();
            localObject4 = ((im_msg_body.AnonymousGroupMsg)localObject8).str_anon_id.get().toByteArray();
            localObject6 = ((im_msg_body.AnonymousGroupMsg)localObject8).str_anon_nick.get().toByteArray();
            n = ((im_msg_body.AnonymousGroupMsg)localObject8).uint32_head_portrait.get();
            i1 = ((im_msg_body.AnonymousGroupMsg)localObject8).uint32_expire_time.get();
            localObject8 = ((im_msg_body.AnonymousGroupMsg)localObject8).str_rank_color.get().toStringUtf8();
            if (localObject4 == null) {
              break label6769;
            }
            for (;;)
            {
              try
              {
                localObject4 = new String((byte[])localObject4, "ISO-8859-1");
                if (localObject6 == null)
                {
                  localObject6 = "";
                  localMessageRecord.saveExtInfoToExtStr("anonymous", AnonymousChatHelper.a(i, (String)localObject4, (String)localObject6, n, i1, (String)localObject8));
                  localMessageRecord.extLong |= 0x3;
                  localObject4 = localObject3;
                  if (!QLog.isColorLevel()) {
                    break label6690;
                  }
                  QLog.d("anonymous_decode", 2, "anonymous_flags = " + i);
                  paramArrayList.add(localMessageRecord);
                  b2 = b1;
                }
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                localUnsupportedEncodingException.printStackTrace();
                break label6769;
              }
              localObject6 = new String((byte[])localObject6);
            }
          }
          localObject5 = localObject3;
          if (((im_msg_body.Elem)localObject8).extra_info.has())
          {
            localObject9 = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject8).extra_info.get();
            localObject3 = ((im_msg_body.ExtraInfo)localObject9).bytes_sender_title.get().toStringUtf8();
            i = ((im_msg_body.ExtraInfo)localObject9).uint32_flags.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc.troop.special_msg", 2, "dwFlags:" + i);
            }
            localObject5 = localObject3;
            if (((im_msg_body.ExtraInfo)localObject9).uint32_new_group_flag.has())
            {
              localObject10 = paramPBDecodeContext.e + "";
              localObject5 = localObject3;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject10) != ((im_msg_body.ExtraInfo)localObject9).uint32_new_group_flag.get())
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject10, Integer.valueOf(((im_msg_body.ExtraInfo)localObject9).uint32_new_group_flag.get()));
                localObject5 = localObject3;
              }
            }
          }
          localObject3 = localObject5;
        } while (!((im_msg_body.Elem)localObject8).group_business_msg.has());
        localObject8 = TroopBusinessUtil.TroopBusinessMessage.a(((im_msg_body.Elem)localObject8).group_business_msg);
        TroopBusinessUtil.a(localMessageRecord, (TroopBusinessUtil.TroopBusinessMessage)localObject8);
        localObject9 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageRecord.frienduin == null) {}
        for (localObject3 = "";; localObject3 = localMessageRecord.frienduin)
        {
          ReportController.b((QQAppInterface)localObject9, "P_CliOper", "Grp_AIO", "", "five_m", "revice_msg", 0, 0, (String)localObject3, localMessageRecord.msgtype + "", ((TroopBusinessUtil.TroopBusinessMessage)localObject8).c, "");
          localObject3 = localObject5;
          break;
        }
        bool1 = false;
        bool2 = false;
        j = -100;
        if ((paramPBDecodeContext.c == 1) || (paramPBDecodeContext.c == 1026))
        {
          d1 = -100.0D;
          i = -1;
          localObject5 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject7).group_info.get();
          if (localObject5 != null)
          {
            l1 = ((msg_comm.GroupInfo)localObject5).group_code.get();
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              i = -1;
              d1 = -100.0D;
              k = 0;
              bool3 = false;
              bool1 = bool2;
              bool2 = bool3;
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  paramMessageInfo = (im_msg_body.Elem)((Iterator)localObject2).next();
                  if (paramMessageInfo.general_flags.has())
                  {
                    if (!paramMessageInfo.general_flags.uint32_group_type.has()) {}
                  }
                  else {
                    switch (paramMessageInfo.general_flags.uint32_group_type.get())
                    {
                    case 1: 
                      bool2 = bool3;
                      bool1 = bool4;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive general_flags.uint32_group_type, isPubGroupVisitor = " + bool3 + ", isHotChatMsg = " + bool4);
                        bool1 = bool4;
                        bool2 = bool3;
                      }
                      if (paramMessageInfo.general_flags.uint32_glamour_level.has())
                      {
                        j = paramMessageInfo.general_flags.uint32_glamour_level.get();
                        m = i;
                        if (paramMessageInfo.general_flags.bytes_pb_reserve.has())
                        {
                          localObject7 = new generalflags.ResvAttr();
                          ((generalflags.ResvAttr)localObject7).mergeFrom(paramMessageInfo.general_flags.bytes_pb_reserve.get().toByteArray());
                          if (!((generalflags.ResvAttr)localObject7).uint32_nearby_charm_level.has()) {
                            break label6845;
                          }
                          m = ((generalflags.ResvAttr)localObject7).uint32_nearby_charm_level.get();
                          label4267:
                          if (!((generalflags.ResvAttr)localObject7).uint32_global_group_level.has()) {
                            break label6852;
                          }
                          i1 = ((generalflags.ResvAttr)localObject7).uint32_global_group_level.get();
                          label4288:
                          n = i;
                          if (((generalflags.ResvAttr)localObject7).uint32_title_id.has())
                          {
                            int i2 = ((generalflags.ResvAttr)localObject7).uint32_title_id.get();
                            if (i2 > 0) {
                              i = i2;
                            }
                            n = i;
                            if (QLog.isColorLevel())
                            {
                              QLog.d("TroopRankConfig", 2, "decodeSinglePbMsg_GroupDis, titleId=" + i2 + ", troopUin=" + l1 + ", sender=" + l8 + ", msgTime=" + l2 + ", isSaveDb=" + paramBoolean);
                              n = i;
                            }
                          }
                          localObject6 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                          if (localObject6 != null) {
                            ((TroopManager)localObject6).a(String.valueOf(l1), String.valueOf(l8), m, i1);
                          }
                          m = n;
                          if (paramPBDecodeContext.c == 1)
                          {
                            m = n;
                            if (((generalflags.ResvAttr)localObject7).uint32_custom_featureid.has())
                            {
                              m = n;
                              if (localObject6 != null)
                              {
                                m = n;
                                if (((generalflags.ResvAttr)localObject7).uint32_custom_featureid.get() == 19713)
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d(".troop.qidian_private_troop", 2, "decodeSinglePbMsg_GroupDis, hasPrivateTroopFlag, troopUin=" + l1);
                                  }
                                  localObject7 = ((TroopManager)localObject6).a(String.valueOf(l1));
                                  m = n;
                                  if (localObject7 != null)
                                  {
                                    m = n;
                                    if (!((TroopInfo)localObject7).isQidianPrivateTroop())
                                    {
                                      ((TroopInfo)localObject7).setQidianPrivateTroopFlag();
                                      ((TroopManager)localObject6).b((TroopInfo)localObject7);
                                      m = n;
                                      if (QLog.isColorLevel())
                                      {
                                        QLog.d(".troop.qidian_private_troop", 2, "set privateTroop flag, troopUin=" + l1);
                                        m = n;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                        if ((paramPBDecodeContext.c == 1) && (paramMessageInfo.general_flags.uint64_group_rank_seq.has()))
                        {
                          localObject6 = String.valueOf(l1);
                          if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.c())) {
                            break label6859;
                          }
                          bool3 = true;
                          label4677:
                          if (bool3)
                          {
                            localObject7 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a((String)localObject6);
                            if (localObject7 == null) {
                              break label6787;
                            }
                            l5 = paramMessageInfo.general_flags.uint64_group_rank_seq.get();
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + (String)localObject6 + ", serverRankSeq=" + l5 + ", localRankSeq=" + ((TroopInfo)localObject7).dwGroupLevelSeq + ", isSyncMsgFinish=" + bool3);
                            }
                            if (l5 <= ((TroopInfo)localObject7).dwGroupLevelSeq) {
                              break label6787;
                            }
                            ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).c((String)localObject6, false);
                            break label6787;
                            if (!paramMessageInfo.general_flags.uint32_to_uin_flag.has()) {
                              break label6776;
                            }
                            if (paramMessageInfo.general_flags.uint32_to_uin_flag.get() != 2) {
                              break label6829;
                            }
                            bool2 = true;
                            break label6818;
                          }
                          if (!QLog.isColorLevel()) {
                            break label6787;
                          }
                          QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + (String)localObject6 + ", isSyncMsgFinish=" + bool3);
                          break label6787;
                          if ((paramMessageInfo.extra_info.has()) && (paramMessageInfo.extra_info.uint32_flags.has()))
                          {
                            d2 = d1;
                            if (!bool1) {
                              break label6880;
                            }
                            m = paramMessageInfo.extra_info.uint32_flags.get();
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "elem.extra_info.uint32_flags:" + m + "|groupCode:" + l1 + "fromUin:" + l8);
                            }
                            if ((m & 0x10) != 16) {
                              break label6865;
                            }
                            paramMessageInfo = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(l1 + "");
                            localObject6 = l8 + "";
                            if ((paramMessageInfo == null) || (paramMessageInfo.adminUins.contains(localObject6))) {
                              break label6865;
                            }
                            paramMessageInfo.adminUins.add(localObject6);
                            break label6865;
                          }
                          if (paramMessageInfo.pub_group.has())
                          {
                            if (!QLog.isColorLevel()) {
                              break label6627;
                            }
                            if (((im_msg_body.PubGroup)paramMessageInfo.pub_group.get()).bytes_nickname.has())
                            {
                              paramMessageInfo = ((im_msg_body.PubGroup)paramMessageInfo.pub_group.get()).bytes_nickname.get().toStringUtf8();
                              label5170:
                              QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive  pub_group,bytes_nickname = " + paramMessageInfo);
                              bool3 = bool1;
                              k = 1;
                              bool1 = bool2;
                              bool2 = bool3;
                              break label6803;
                            }
                          }
                          else
                          {
                            d2 = d1;
                            if (!paramMessageInfo.elem_flags2.has()) {
                              break label6880;
                            }
                            d2 = d1;
                            if (!((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_longtitude.has()) {
                              break label6880;
                            }
                            d2 = d1;
                            if (!((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_latitude.has()) {
                              break label6880;
                            }
                            if (l9 == l8) {
                              continue;
                            }
                            m = ((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_longtitude.get();
                            n = ((im_msg_body.ElemFlags2)paramMessageInfo.elem_flags2.get()).uint32_latitude.get();
                            d2 = d1;
                            if (m == 1)
                            {
                              d2 = d1;
                              if (n == 1) {
                                d2 = -1001.0D;
                              }
                            }
                            paramMessageInfo = TroopMemberLbsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                            d1 = d2;
                            if (m != 0)
                            {
                              d1 = d2;
                              if (n != 0)
                              {
                                d1 = d2;
                                if (m != 1)
                                {
                                  d1 = d2;
                                  if (n != 1)
                                  {
                                    d2 = TroopMemberLbsHelper.a(n, m, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                                    if ((paramMessageInfo != null) && (paramMessageInfo.b != 0L))
                                    {
                                      d1 = d2;
                                      if (paramMessageInfo.a != 0L) {}
                                    }
                                    else
                                    {
                                      TroopMemberLbsHelper.a(String.valueOf(l1), String.valueOf(l8), n, m, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                                      d1 = d2;
                                    }
                                  }
                                }
                              }
                            }
                            long l6 = 0L;
                            l5 = 0L;
                            if (paramMessageInfo != null)
                            {
                              l6 = paramMessageInfo.a;
                              l5 = paramMessageInfo.b;
                            }
                            d2 = d1;
                            if (!QLog.isColorLevel()) {
                              break label6880;
                            }
                            QLog.d("Q.troopMemberDistance", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + l1 + ", memberUin=" + l8 + ", memberLoction=[" + m + "," + n + "], selfLocation=[" + l6 + "," + l5 + "], dis=" + d1);
                            d2 = d1;
                            break label6880;
                            label5603:
                            localObject2 = String.valueOf(l1);
                            localObject6 = String.valueOf(l8);
                            paramPBDecodeContext = ((msg_comm.GroupInfo)localObject5).group_card.get().toByteArray();
                            m = ((msg_comm.GroupInfo)localObject5).group_level.get();
                            try
                            {
                              paramPBDecodeContext = new String(paramPBDecodeContext, "utf-8");
                              n = ((msg_comm.GroupInfo)localObject5).group_card_type.get();
                              if (bool1) {
                                ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(l1);
                              }
                              if (!bool2) {
                                break label6902;
                              }
                              paramMessageInfo = paramArrayList.iterator();
                              while (paramMessageInfo.hasNext()) {
                                ((MessageRecord)paramMessageInfo.next()).isOpenTroopMessage = true;
                              }
                            }
                            catch (UnsupportedEncodingException paramPBDecodeContext)
                            {
                              for (;;)
                              {
                                paramPBDecodeContext.printStackTrace();
                                paramPBDecodeContext = null;
                              }
                              paramMessageInfo = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                              if (paramMessageInfo == null) {
                                break label6902;
                              }
                            }
                            if (paramMessageInfo.f((String)localObject2)) {
                              break label6902;
                            }
                            paramMessageInfo = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                            if (paramMessageInfo == null) {
                              break label6902;
                            }
                            paramMessageInfo.f((String)localObject2, false);
                            break label6902;
                            label5790:
                            if (j != -100)
                            {
                              paramMessageInfo = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                              if (paramMessageInfo != null) {
                                paramMessageInfo.a((String)localObject2, (String)localObject6, j);
                              }
                            }
                            if (paramBoolean) {
                              paramMessageInfo = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                            }
                            switch (n)
                            {
                            case 1: 
                              paramMessageInfo.a((String)localObject2, (String)localObject6, paramPBDecodeContext, i, null, null, 0, 1, 100, l3, b2, 0L, d1);
                            case 2: 
                              for (;;)
                              {
                                label5872:
                                paramMessageInfo.a((String)localObject2, (String)localObject6, (String)localObject3);
                                paramPBDecodeContext = null;
                                label5911:
                                if ((localObject6 == null) || (((String)localObject6).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                                  break label6943;
                                }
                                paramMessageInfo = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
                                if (paramMessageInfo.a((String)localObject2)) {
                                  break label6943;
                                }
                                if (!paramMessageInfo.b((String)localObject2)) {
                                  break label6340;
                                }
                                j = paramArrayList.size();
                                i = 0;
                                k = j - 1;
                                if (k < 0) {
                                  break label6340;
                                }
                                localObject3 = (MessageRecord)paramArrayList.get(k);
                                j = i;
                                if (!TroopBindPublicAccountMgr.a((MessageRecord)localObject3)) {
                                  break label6936;
                                }
                                if ((!TextUtils.isEmpty(((MessageRecord)localObject3).msg)) || (((MessageRecord)localObject3).msgData != null)) {
                                  break;
                                }
                                break label6918;
                                paramMessageInfo.a((String)localObject2, (String)localObject6, paramPBDecodeContext, i, null, null, 0, 1, 100, l3, b2, 0L, d1);
                                continue;
                                paramMessageInfo.a((String)localObject2, (String)localObject6, "", i, paramPBDecodeContext, null, 0, 1, 100, l3, b2, 0L, d1);
                              }
                              paramMessageInfo = new TroopMemberInfo();
                              paramMessageInfo.troopuin = ((String)localObject2);
                              paramMessageInfo.memberuin = ((String)localObject6);
                              switch (n)
                              {
                              case 1: 
                                paramMessageInfo.troopnick = paramPBDecodeContext;
                              case 2: 
                                for (;;)
                                {
                                  label6136:
                                  paramMessageInfo.level = i;
                                  paramMessageInfo.realLevel = m;
                                  paramMessageInfo.sex = 1;
                                  paramMessageInfo.age = 0;
                                  paramMessageInfo.distance = 100;
                                  paramMessageInfo.msgseq = l3;
                                  if (b2 != 1) {
                                    break label6930;
                                  }
                                  paramBoolean = true;
                                  label6191:
                                  paramMessageInfo.isTroopFollowed = paramBoolean;
                                  paramMessageInfo.distanceToSelf = d1;
                                  paramMessageInfo.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
                                  paramPBDecodeContext = paramMessageInfo;
                                  break;
                                  paramMessageInfo.troopnick = paramPBDecodeContext;
                                  continue;
                                  paramMessageInfo.troopnick = "";
                                  paramMessageInfo.friendnick = paramPBDecodeContext;
                                }
                                j = i;
                                if (i == 0)
                                {
                                  paramMessageInfo.a((String)localObject2, ((MessageRecord)localObject3).uniseq);
                                  j = 1;
                                }
                                if (QLog.isColorLevel()) {
                                  QLog.d("TroopBindPublicAccountMgr.redDot", 2, "decodePBAccountMSg:" + (String)localObject2 + "," + ((MessageRecord)localObject3).uniseq + "," + ((MessageRecord)localObject3).shmsgseq);
                                }
                                paramMessageInfo.c((String)localObject2);
                                break label6936;
                                label6340:
                                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject2) != 3) {
                                  break label6943;
                                }
                                if (QLog.isColorLevel()) {
                                  QLog.d(".troop.closeRcvMsgTmp", 2, "Shield troop recv msg:" + (String)localObject2);
                                }
                                ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a((String)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, 0);
                                break label6943;
                              }
                              break;
                            }
                          }
                        }
                      }
                      break;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label6416:
    label6803:
    label6936:
    label6943:
    for (;;)
    {
      i = MessageProtoCodec.a(paramMsg);
      j = MessageProtoCodec.f(paramMsg);
      k = MessageProtoCodec.c(paramMsg);
      m = MessageProtoCodec.b(paramMsg);
      n = MessageProtoCodec.d(paramMsg);
      i1 = MessageProtoCodec.e(paramMsg);
      paramMsg = paramArrayList.iterator();
      while (paramMsg.hasNext())
      {
        paramArrayList = (MessageRecord)paramMsg.next();
        paramArrayList.vipBubbleDiyTextId = i;
        Object localObject1;
        paramArrayList.vipBubbleID = SVIPHandler.a((int)localObject1, i);
        paramArrayList.vipSubBubbleId = j;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramArrayList.time);
        if (j != 0) {
          paramArrayList.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(j));
        }
        if (k > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(k));
        }
        if (n > 0) {
          paramArrayList.saveExtInfoToExtStr("vip_face_id", String.valueOf(n));
        }
        if (m >= 0) {
          paramArrayList.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(m));
        }
        if (i1 > 0) {
          paramArrayList.saveExtInfoToExtStr(MessageConstants.m, String.valueOf(i1));
        }
      }
      MsgAutoMonitorUtil.a().g(System.currentTimeMillis() - l7);
      return paramPBDecodeContext;
      label6627:
      label6763:
      label6769:
      label6776:
      do
      {
        paramPBDecodeContext = null;
        break label5911;
        paramMessageInfo = null;
        break label5170;
        bool3 = bool1;
        k = 1;
        bool1 = bool2;
        bool2 = bool3;
        break label6803;
        i = m;
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        break label6803;
        break label4199;
        break label4172;
        k = 0;
        bool2 = false;
        break label5603;
        l1 = 0L;
        break label3997;
        paramPBDecodeContext = null;
        break label6416;
        localObject3 = localObject5;
        break label3603;
        break label6751;
        l1 = 0L;
        break label2792;
        localObject2 = null;
        l1 = 0L;
        break label284;
        do
        {
          l4 = l1;
          break label233;
          j = 0;
          k = 0;
          m = 0;
          break;
          return null;
        } while (l1 != -1L);
        long l4 = 0L;
        break label233;
        break label2662;
        i += 1;
        break label960;
        i = 2;
        break label2377;
        localObject5 = "";
        break label3521;
        bool3 = bool2;
        bool4 = bool1;
        break label4112;
        i = m;
        bool3 = bool2;
        bool2 = bool1;
        bool1 = bool3;
        for (;;)
        {
          bool3 = bool2;
          bool2 = bool1;
          bool1 = bool3;
          break;
          for (;;)
          {
            bool3 = bool2;
            bool4 = bool1;
            break;
            bool2 = false;
          }
          bool4 = true;
          bool3 = bool2;
          break label4112;
          m = -100;
          break label4267;
          i1 = -100;
          break label4288;
          bool3 = false;
          break label4677;
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          continue;
          bool3 = bool1;
          d1 = d2;
          bool1 = bool2;
          bool2 = bool3;
        }
        break label5603;
        if (k == 0) {
          break label5790;
        }
      } while (!bool1);
      label6690:
      label6697:
      label6700:
      label6706:
      label6722:
      label6734:
      label6736:
      label6751:
      label6754:
      label6902:
      break label5790;
      label6818:
      label6829:
      label6845:
      label6852:
      label6859:
      label6865:
      label6880:
      break label5872;
      for (;;)
      {
        k -= 1;
        break;
        break label6136;
        paramBoolean = false;
        break label6191;
        i = j;
      }
    }
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_seq_" + l;
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "handle push . notifySendMessageSuccessful" + paramMessageRecord.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      a(6003, true, new Object[] { paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.uniseq) });
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord.msgseq);
      if (MsgProxyUtils.o(paramMessageRecord.msgtype))
      {
        paramMessageRecord = new MessageObserver.StatictisInfo();
        paramMessageRecord.b = 1000;
        paramMessageRecord.c = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(5006, true, new Object[] { paramMessageRecord });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageProcessorForTroopAndDisc
 * JD-Core Version:    0.7.0.1
 */