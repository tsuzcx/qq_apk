package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.statistics.product.IApollo644ReportHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.service.message.codec.decoder.AppShareInfoDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.GrpDisPTTDecoder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.NotNull;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;

public class BaseMessageProcessorForTroopAndDisc
  extends BaseMessageProcessor
{
  protected Comparator a;
  
  public BaseMessageProcessorForTroopAndDisc(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilComparator = new BaseMessageProcessorForTroopAndDisc.2(this);
  }
  
  private byte a(msg_comm.MsgHead paramMsgHead, long paramLong, MessageInfo paramMessageInfo, byte paramByte, MessageRecord paramMessageRecord)
  {
    byte b = paramByte;
    if (paramMsgHead.msg_flag.has())
    {
      b = paramByte;
      if ((paramMsgHead.msg_flag.get() & 1L) == 1L)
      {
        b = paramByte;
        if (paramMessageRecord.msgtype != -2058)
        {
          paramByte = 1;
          paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(17, paramLong, paramMessageRecord.uniseq);
          b = paramByte;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "receive the TroopMsg from TroopSpecialAttention!");
            b = paramByte;
          }
        }
      }
    }
    return b;
  }
  
  private BaseMessageProcessorForTroopAndDisc.TroopHotChatTopicHandler a(ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, MessageInfo paramMessageInfo1, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, int paramInt1, int paramInt2, int paramInt3, List<MessageRecord> paramList, List<im_msg_body.Elem> paramList1, MessageInfo paramMessageInfo2, byte paramByte, String paramString2)
  {
    Iterator localIterator = paramList.iterator();
    paramList = paramString2;
    while (localIterator.hasNext())
    {
      paramString2 = (MessageRecord)localIterator.next();
      paramString2.time = paramLong3;
      paramString2.msgseq = paramLong3;
      paramString2.shmsgseq = paramLong2;
      paramString2.msgUid = paramLong4;
      paramString2.selfuin = paramString1;
      paramString2.istroop = paramPBDecodeContext.jdField_e_of_type_Int;
      paramString2.senderuin = String.valueOf(paramLong1);
      paramString2.frienduin = String.valueOf(paramPBDecodeContext.jdField_e_of_type_Long);
      paramString2.longMsgId = paramInt1;
      paramString2.longMsgCount = paramInt2;
      paramString2.longMsgIndex = paramInt3;
      if (((paramString2 instanceof MessageForFoldMsg)) && (QLog.isColorLevel())) {
        QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, frienduin: %s, senduin: %s, msguid: %s, shmsgseq: %s content: %s", new Object[] { paramString2.frienduin, paramString2.senderuin, Long.valueOf(paramString2.msgUid), Long.valueOf(paramString2.shmsgseq), paramString2.getLogColorContent() }));
      }
      if (paramPBDecodeContext.f == 127)
      {
        paramString2.msg = "PTT_URL";
        paramString2.msgtype = -2006;
        paramString2.isread = true;
      }
      b(paramString2);
      paramByte = a(paramMsgHead, paramLong2, paramMessageInfo2, paramByte, paramString2);
      b(paramLong2, paramMessageInfo2, paramString2);
      a(paramLong2, paramMessageInfo2, paramString2);
      c(paramLong2, paramMessageInfo2, paramString2);
      h(paramLong2, paramMessageInfo2, paramString2);
      g(paramLong2, paramMessageInfo2, paramString2);
      a(paramPBDecodeContext, paramLong2, paramList1, paramMessageInfo2, paramString2);
      n(paramLong2, paramMessageInfo2, paramString2);
      f(paramLong2, paramMessageInfo2, paramString2);
      c(paramString2);
      m(paramLong2, paramMessageInfo2, paramString2);
      l(paramLong2, paramMessageInfo2, paramString2);
      k(paramLong2, paramMessageInfo2, paramString2);
      j(paramLong2, paramMessageInfo2, paramString2);
      e(paramLong2, paramMessageInfo2, paramString2);
      d(paramLong2, paramMessageInfo2, paramString2);
      i(paramLong2, paramMessageInfo2, paramString2);
      d(paramString2);
      a(paramPBDecodeContext, paramMessageInfo1, paramLong2, paramMessageInfo2, paramString2);
      a(paramArrayList, paramPBDecodeContext, paramList1, paramString2);
      paramList = a(paramPBDecodeContext, paramList1, paramList, paramString2);
      paramArrayList.add(paramString2);
    }
    return new BaseMessageProcessorForTroopAndDisc.TroopHotChatTopicHandler(this, paramArrayList, paramPBDecodeContext, paramBoolean, paramMsgHead, paramLong1, paramLong2, paramLong3, paramLong5, paramList1, paramByte, paramList).a();
  }
  
  private TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, int paramInt, BaseMessageProcessorForTroopAndDisc.TroopHotChatTopicHandler paramTroopHotChatTopicHandler)
  {
    int i = paramTroopHotChatTopicHandler.a();
    int j = paramTroopHotChatTopicHandler.b();
    int k = paramTroopHotChatTopicHandler.c();
    int m = paramTroopHotChatTopicHandler.d();
    int n = paramTroopHotChatTopicHandler.e();
    int i1 = paramTroopHotChatTopicHandler.f();
    int i2 = paramTroopHotChatTopicHandler.g();
    paramTroopHotChatTopicHandler = paramTroopHotChatTopicHandler.a();
    int i3 = MessageProtoCodec.a(paramMsg);
    int i4 = MessageProtoCodec.e(paramMsg);
    int i5 = MessageProtoCodec.c(paramMsg);
    int i6 = MessageProtoCodec.b(paramMsg);
    int i7 = MessageProtoCodec.d(paramMsg);
    paramMsg = paramArrayList.iterator();
    while (paramMsg.hasNext())
    {
      paramArrayList = (MessageRecord)paramMsg.next();
      paramArrayList.vipBubbleDiyTextId = i3;
      paramArrayList.vipBubbleID = SVIPHandler.a(paramInt, i3);
      paramArrayList.vipSubBubbleId = i4;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d(paramArrayList.time);
      if (i4 != 0) {
        paramArrayList.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(i4));
      }
      if (i5 > 0) {
        paramArrayList.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i5));
      }
      if (i7 >= 0) {
        paramArrayList.saveExtInfoToExtStr("vip_face_id", String.valueOf(i7));
      }
      if (i6 >= 0) {
        paramArrayList.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(i6));
      }
      if (i > 0) {
        paramArrayList.saveExtInfoToExtStr("vip_type", String.valueOf(i));
      }
      if (j > 0) {
        paramArrayList.saveExtInfoToExtStr("vip_level", String.valueOf(j));
      }
      if (k > 0) {
        paramArrayList.saveExtInfoToExtStr("bigClub_type", String.valueOf(k));
      }
      if (m > 0) {
        paramArrayList.saveExtInfoToExtStr("bigClub_level", String.valueOf(m));
      }
      if (n > 0) {
        paramArrayList.saveExtInfoToExtStr("vip_card_id", String.valueOf(n));
      }
      if (i1 > 0) {
        paramArrayList.saveExtInfoToExtStr("vip_ext_card_id", String.valueOf(i1));
      }
      if (i2 > 0) {
        paramArrayList.saveExtInfoToExtStr("vip_diy_font_id", String.valueOf(i2));
      }
    }
    return paramTroopHotChatTopicHandler;
  }
  
  private String a(PBDecodeContext paramPBDecodeContext, List<im_msg_body.Elem> paramList, String paramString, MessageRecord paramMessageRecord)
  {
    Iterator localIterator;
    if (paramPBDecodeContext.jdField_e_of_type_Int != 1)
    {
      localObject = paramString;
      if (paramPBDecodeContext.jdField_e_of_type_Int != 1026) {}
    }
    else
    {
      localObject = paramString;
      if (paramList != null) {
        localIterator = paramList.iterator();
      }
    }
    do
    {
      localObject = paramString;
      if (localIterator.hasNext())
      {
        localObject = (im_msg_body.Elem)localIterator.next();
        if (((im_msg_body.Elem)localObject).anon_group_msg.has())
        {
          a(paramMessageRecord, (im_msg_body.Elem)localObject);
          localObject = paramString;
        }
      }
      else
      {
        return localObject;
      }
      paramList = paramString;
      if (((im_msg_body.Elem)localObject).extra_info.has()) {
        paramList = a(paramPBDecodeContext, (im_msg_body.Elem)localObject);
      }
      paramString = paramList;
    } while (!((im_msg_body.Elem)localObject).group_business_msg.has());
    Object localObject = TroopBusinessUtil.TroopBusinessMessage.a(((im_msg_body.Elem)localObject).group_business_msg);
    TroopBusinessUtil.a(paramMessageRecord, (TroopBusinessUtil.TroopBusinessMessage)localObject);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramMessageRecord.frienduin == null) {}
    for (paramString = "";; paramString = paramMessageRecord.frienduin)
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "revice_msg", 0, 0, paramString, paramMessageRecord.msgtype + "", ((TroopBusinessUtil.TroopBusinessMessage)localObject).c, "");
      paramString = paramList;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decode group_business_msg:" + localObject);
      paramString = paramList;
      break;
    }
  }
  
  @NotNull
  private String a(PBDecodeContext paramPBDecodeContext, im_msg_body.Elem paramElem)
  {
    paramElem = (im_msg_body.ExtraInfo)paramElem.extra_info.get();
    String str = paramElem.bytes_sender_title.get().toStringUtf8();
    int i = paramElem.uint32_flags.get();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc.troop.special_msg", 2, "dwFlags:" + i);
    }
    if (paramElem.uint32_new_group_flag.has())
    {
      paramPBDecodeContext = paramPBDecodeContext.jdField_e_of_type_Long + "";
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramPBDecodeContext) != paramElem.uint32_new_group_flag.get()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setTroopMsgFilterToServer(paramPBDecodeContext, Integer.valueOf(paramElem.uint32_new_group_flag.get()));
      }
    }
    return str;
  }
  
  private void a(int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList.size() == 0) && (paramInt > 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "<---decodeSinglePbMsg_GroupDis, empty long msg fragment");
      }
      MessageForText localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
      localMessageForText.msgtype = -1000;
      localMessageForText.msg = "";
      paramList.add(localMessageForText);
    }
  }
  
  private void a(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForTroopConfess)) && (((MessageForTroopConfess)paramMessageRecord).isToSelf)) {
      paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(10, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void a(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    paramStructMsgForGeneralShare = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    long l = paramMessageRecord.uniseq;
    paramStructMsgForGeneralShare = paramMessageRecord.frienduin;
    Object localObject2 = new BaseMessageManager.AddMessageContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject1 = ((BaseMessageManager.AddMessageContext)localObject2).jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    localObject2 = ((BaseMessageManager.AddMessageContext)localObject2).jdField_a_of_type_JavaUtilMap;
    localObject1 = ((RecentUserProxy)localObject1).a(paramStructMsgForGeneralShare, 1);
    TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin, StructMsgForGeneralShare.eventId, paramMessageRecord.shmsgseq, new BaseMessageProcessorForTroopAndDisc.1(this, false, paramMessageInfo, paramLong, l, (RecentUser)localObject1, paramStructMsgForGeneralShare, paramMessageRecord, (Map)localObject2));
  }
  
  private void a(MessageRecord paramMessageRecord, MessageForApollo paramMessageForApollo, ArrayList<ApolloBaseInfo> paramArrayList, IApolloManagerService paramIApolloManagerService, StringBuilder paramStringBuilder)
  {
    if ((paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
    {
      paramIApolloManagerService = paramIApolloManagerService.getApolloBaseInfo(paramMessageForApollo.mApolloMessage.peer_uin + "");
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("\n peer: ").append(paramIApolloManagerService.uin).append(", update time: ").append(paramIApolloManagerService.apolloUpdateTime);
      }
      if ((paramMessageRecord.time > paramIApolloManagerService.apolloUpdateTime) && ((paramIApolloManagerService.apolloServerTS < paramMessageForApollo.mApolloMessage.peer_ts) || (paramIApolloManagerService.apolloStatus != paramMessageForApollo.mApolloMessage.peer_status) || (paramIApolloManagerService.superYellowDiamondFlag != (paramMessageForApollo.mApolloMessage.flag >> 31 & 0x1)) || ((paramMessageForApollo.is3dAction()) && (paramMessageForApollo.mApollo3DMessage != null) && (paramIApolloManagerService.cmshow3dFlag != paramMessageForApollo.mApollo3DMessage.peerStatus_3D))))
      {
        paramIApolloManagerService.apolloStatus = paramMessageForApollo.mApolloMessage.peer_status;
        paramIApolloManagerService.apolloServerTS = paramMessageForApollo.mApolloMessage.peer_ts;
        paramIApolloManagerService.superYellowDiamondFlag = (paramMessageForApollo.mApolloMessage.flag >> 31 & 0x1);
        if ((paramMessageForApollo.is3dAction()) && (paramMessageForApollo.mApollo3DMessage != null)) {
          paramIApolloManagerService.cmshow3dFlag = paramMessageForApollo.mApollo3DMessage.peerStatus_3D;
        }
        paramIApolloManagerService.apolloUpdateTime = paramMessageRecord.time;
        paramArrayList.add(paramIApolloManagerService);
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("\n save apollo info ").append(paramIApolloManagerService.apolloVipFlag).append("|").append(paramIApolloManagerService.apolloStatus).append("|").append(paramIApolloManagerService.apolloLocalTS).append("|").append(paramIApolloManagerService.apolloServerTS).append("|").append(paramIApolloManagerService.cmshow3dFlag).append("|").append(paramIApolloManagerService.apolloUpdateTime);
        }
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, im_msg_body.Elem paramElem)
  {
    Object localObject2 = (im_msg_body.AnonymousGroupMsg)paramElem.anon_group_msg.get();
    int i = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_flags.get();
    paramElem = ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_id.get().toByteArray();
    Object localObject1 = ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_nick.get().toByteArray();
    int j = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_head_portrait.get();
    int k = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_expire_time.get();
    localObject2 = ((im_msg_body.AnonymousGroupMsg)localObject2).str_rank_color.get().toStringUtf8();
    if (paramElem != null) {}
    for (;;)
    {
      try
      {
        paramElem = new String(paramElem, "ISO-8859-1");
        if (localObject1 != null) {
          break label181;
        }
        localObject1 = "";
        paramMessageRecord.saveExtInfoToExtStr("anonymous", AnonymousChatHelper.a(i, paramElem, (String)localObject1, j, k, (String)localObject2));
        paramMessageRecord.extLong |= 0x3;
        if (QLog.isColorLevel()) {
          QLog.d("anonymous_decode", 2, "anonymous_flags = " + i);
        }
        return;
      }
      catch (UnsupportedEncodingException paramElem)
      {
        paramElem.printStackTrace();
      }
      paramElem = "";
      continue;
      label181:
      localObject1 = new String((byte[])localObject1);
    }
  }
  
  private void a(PBDecodeContext paramPBDecodeContext, long paramLong, List<im_msg_body.Elem> paramList, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (((paramPBDecodeContext.jdField_e_of_type_Int == 1) || (paramPBDecodeContext.jdField_e_of_type_Int == 1026)) && (paramList != null))
    {
      paramPBDecodeContext = paramList.iterator();
      while (paramPBDecodeContext.hasNext())
      {
        paramList = (im_msg_body.Elem)paramPBDecodeContext.next();
        if ((paramList.general_flags.has()) && (paramList.general_flags.bytes_pb_reserve.has()))
        {
          generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
          localResvAttr.mergeFrom(paramList.general_flags.bytes_pb_reserve.get().toByteArray());
          if ((localResvAttr.uint32_group_savedb_flag.has()) && ((localResvAttr.uint32_group_savedb_flag.get() & 0x1) == 1))
          {
            paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(23, paramLong, paramMessageRecord.uniseq);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis, should show shop ark");
            }
          }
        }
      }
    }
  }
  
  private void a(PBDecodeContext paramPBDecodeContext, MessageInfo paramMessageInfo1, long paramLong, MessageInfo paramMessageInfo2, MessageRecord paramMessageRecord)
  {
    if (paramMessageInfo1 != null)
    {
      paramMessageInfo2.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(13, paramMessageRecord.uniseq);
      paramMessageInfo2.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(24, paramMessageRecord.uniseq);
      if ((paramLong > this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(String.valueOf(paramPBDecodeContext.jdField_e_of_type_Long), paramPBDecodeContext.jdField_e_of_type_Int)) && (paramMessageInfo2.a()))
      {
        paramMessageInfo1.a(paramMessageInfo2);
        paramMessageRecord.mMessageInfo = paramMessageInfo2;
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, List<im_msg_body.Elem> paramList, MessageRecord paramMessageRecord)
  {
    boolean bool;
    if (((paramPBDecodeContext.jdField_e_of_type_Int == 1) || (paramPBDecodeContext.jdField_e_of_type_Int == 1026) || (paramPBDecodeContext.jdField_e_of_type_Int == 3000)) && (paramList != null) && (!TextUtils.equals(paramMessageRecord.selfuin, paramMessageRecord.senderuin)))
    {
      paramPBDecodeContext = paramList.iterator();
      bool = false;
      if (paramPBDecodeContext.hasNext())
      {
        if (!((im_msg_body.Elem)paramPBDecodeContext.next()).anon_group_msg.has()) {
          break label102;
        }
        bool = true;
      }
    }
    label102:
    for (;;)
    {
      break;
      a(paramArrayList, paramList, paramMessageRecord, bool);
      return;
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, List<im_msg_body.Elem> paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (im_msg_body.Elem)paramList.next();
      if ((!paramBoolean) && (((im_msg_body.Elem)localObject).extra_info.has()))
      {
        localObject = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject).extra_info.get();
        if (((im_msg_body.ExtraInfo)localObject).uint32_msg_tail_id.has())
        {
          int i = ((im_msg_body.ExtraInfo)localObject).uint32_msg_tail_id.get();
          if (i > 0)
          {
            localObject = MessageRecordFactory.a(-1002);
            if (localObject != null)
            {
              String str = Integer.toString(i);
              SafeMsg.SafeMoreInfo localSafeMoreInfo = new SafeMsg.SafeMoreInfo();
              localSafeMoreInfo.strMsgTxt.set(str);
              ((MessageRecord)localObject).init(paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.senderuin, str, paramMessageRecord.time, -1002, paramMessageRecord.istroop, paramMessageRecord.msgseq);
              ((MessageRecord)localObject).isread = true;
              ((MessageRecord)localObject).shmsgseq = paramMessageRecord.shmsgseq;
              ((MessageRecord)localObject).msgData = localSafeMoreInfo.toByteArray();
              paramArrayList.add(localObject);
            }
          }
        }
      }
    }
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
  
  private void b(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1) && (TroopKeywordManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessageRecord.msg, paramMessageRecord.frienduin))) {
      paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(16, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -1035) {
      ((ChatMessage)paramMessageRecord).parse();
    }
  }
  
  private void b(MessageRecord paramMessageRecord, MessageForApollo paramMessageForApollo, ArrayList<ApolloBaseInfo> paramArrayList, IApolloManagerService paramIApolloManagerService, StringBuilder paramStringBuilder)
  {
    if (!paramMessageRecord.isSend())
    {
      paramIApolloManagerService = paramIApolloManagerService.getApolloBaseInfo(paramMessageForApollo.senderuin);
      if (QLog.isColorLevel()) {
        paramStringBuilder.append(", update time: ").append(paramIApolloManagerService.apolloUpdateTime);
      }
      if ((paramMessageRecord.time > paramIApolloManagerService.apolloUpdateTime) && ((paramIApolloManagerService.apolloServerTS < paramMessageForApollo.mApolloMessage.sender_ts) || (paramIApolloManagerService.apolloStatus != paramMessageForApollo.mApolloMessage.sender_status) || (paramIApolloManagerService.superYellowDiamondFlag != (paramMessageForApollo.mApolloMessage.flag >> 30 & 0x1)) || ((paramMessageForApollo.is3dAction()) && (paramMessageForApollo.mApollo3DMessage != null) && (paramIApolloManagerService.cmshow3dFlag != paramMessageForApollo.mApollo3DMessage.senderStatus_3D))))
      {
        paramIApolloManagerService.apolloStatus = paramMessageForApollo.mApolloMessage.sender_status;
        paramIApolloManagerService.apolloServerTS = paramMessageForApollo.mApolloMessage.sender_ts;
        paramIApolloManagerService.superYellowDiamondFlag = (paramMessageForApollo.mApolloMessage.flag >> 30 & 0x1);
        if ((paramMessageForApollo.is3dAction()) && (paramMessageForApollo.mApollo3DMessage != null)) {
          paramIApolloManagerService.cmshow3dFlag = paramMessageForApollo.mApollo3DMessage.senderStatus_3D;
        }
        paramIApolloManagerService.apolloUpdateTime = paramMessageRecord.time;
        paramArrayList.add(paramIApolloManagerService);
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("\n save apollo info: ").append(paramIApolloManagerService.apolloVipFlag).append("|").append(paramIApolloManagerService.apolloStatus).append("|").append(paramIApolloManagerService.apolloLocalTS).append("|").append(paramIApolloManagerService.apolloServerTS).append("|").append(paramIApolloManagerService.cmshow3dFlag).append("|").append(paramIApolloManagerService.apolloUpdateTime);
        }
      }
    }
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForArkApp)) && ("com.tencent.qqopen.teamup".equals(((MessageForArkApp)paramMessageRecord).ark_app_message.appName));
  }
  
  private void c(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (a(paramMessageRecord)) {
      paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(5, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2058) {
      EmojiStickerManager.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
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
  
  private void d(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (TroopBindPublicAccountMgr.a(paramMessageRecord)) {
      paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(8, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2039)
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramMessageRecord;
      ArrayList localArrayList = new ArrayList(2);
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      StringBuilder localStringBuilder = new StringBuilder();
      if (QLog.isColorLevel()) {
        localStringBuilder.append("decode apollo troop msg: ").append(", id: ").append(localMessageForApollo.mApolloMessage.id).append(", name: ").append(new String(localMessageForApollo.mApolloMessage.name)).append(", doubleAction: ").append(localMessageForApollo.isDoubleAction()).append(", time: ").append(paramMessageRecord.time).append("\nsender: ").append(paramMessageRecord.senderuin);
      }
      b(paramMessageRecord, localMessageForApollo, localArrayList, localIApolloManagerService, localStringBuilder);
      a(paramMessageRecord, localMessageForApollo, localArrayList, localIApolloManagerService, localStringBuilder);
      if (localArrayList.size() > 0) {
        localIApolloManagerService.bulkSaveOrUpdateApolloBaseInfos(localArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, localStringBuilder.toString());
      }
      ((IApollo644ReportHelper)QRoute.api(IApollo644ReportHelper.class)).reportApolloRevTroopMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, localMessageForApollo, localIApolloManagerService);
    }
  }
  
  private void e(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForTroopFile)) {
      paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(3, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void e(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype != -5008) {}
    AIOAnimationControlManager localAIOAnimationControlManager;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramMessageRecord instanceof MessageForArkApp));
        paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      } while ((paramMessageRecord.ark_app_message == null) || (!paramMessageRecord.ark_app_message.appName.equals("com.tencent.qzone.qungift")));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "com.tencent.qzone.qungift");
      }
      localAIOAnimationControlManager = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    } while (localAIOAnimationControlManager == null);
    localAIOAnimationControlManager.a(paramMessageRecord.ark_app_message.metaList, paramMessageRecord.isread, paramMessageRecord.shmsgseq);
  }
  
  private void f(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -5015) {
      paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(6, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void g(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (c(paramMessageRecord)) {
      paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(20, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void h(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (b(paramMessageRecord)) {
      paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(19, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void i(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype == -5008) && ((paramMessageRecord instanceof MessageForArkApp)))
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramMessageRecord;
      if ((localMessageForArkApp.ark_app_message != null) && (localMessageForArkApp.ark_app_message.appName.equals("com.tencent.mannounce"))) {
        paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(11, paramLong, paramMessageRecord.uniseq);
      }
    }
  }
  
  private void j(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      localObject = StructMsgFactory.a(paramMessageRecord.msgData);
      if ((localObject instanceof StructMsgForGeneralShare))
      {
        localObject = (StructMsgForGeneralShare)localObject;
        if ((localObject == null) || (((StructMsgForGeneralShare)localObject).mMsgServiceID != 75)) {
          break label59;
        }
        a(paramLong, paramMessageInfo, paramMessageRecord, (StructMsgForGeneralShare)localObject);
      }
    }
    label59:
    do
    {
      do
      {
        return;
        if ((localObject != null) && (((StructMsgForGeneralShare)localObject).mMsgServiceID == 19) && (!((StructMsgForGeneralShare)localObject).mMsgBrief.startsWith(HardCodeUtil.a(2131701101))) && (!((StructMsgForGeneralShare)localObject).mMsgBrief.equals(HardCodeUtil.a(2131701095))))
        {
          paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(2, paramLong, paramMessageRecord.uniseq);
          return;
        }
        if ((localObject == null) || (((StructMsgForGeneralShare)localObject).mMsgServiceID != 106)) {
          break;
        }
      } while ((((StructMsgForGeneralShare)localObject).atMembers == null) || (!((StructMsgForGeneralShare)localObject).atMembers.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())));
      paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(24, paramLong, paramMessageRecord.uniseq);
      return;
    } while ((localObject == null) || (((StructMsgForGeneralShare)localObject).mMsgServiceID != 107));
    paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(12, paramLong, paramMessageRecord.uniseq);
  }
  
  private void k(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    Object localObject;
    if (NearbyFlowerUtil.a(paramMessageRecord))
    {
      localObject = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)paramMessageRecord);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((NearbyFlowerMessage)localObject).rUin)) {
          break label104;
        }
        paramMessageInfo = paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramMessageRecord.istroop != 1) {
          break label98;
        }
        paramMessageInfo.a((AppRuntime)localObject, bool, paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
      }
    }
    label98:
    label104:
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((NearbyFlowerMessage)localObject).sUin)) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(7, paramLong, paramMessageRecord.uniseq);
  }
  
  private void l(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    e(paramMessageRecord);
    MessageForDeliverGiftTips localMessageForDeliverGiftTips;
    if ((paramMessageRecord.msgtype == -2035) || (paramMessageRecord.msgtype == -2038))
    {
      localMessageForDeliverGiftTips = (MessageForDeliverGiftTips)paramMessageRecord;
      Object localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForDeliverGiftTips.istroop, localMessageForDeliverGiftTips.frienduin, localMessageForDeliverGiftTips.senderuin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localMessageForDeliverGiftTips.senderName = ((String)localObject);
      }
      if (!localMessageForDeliverGiftTips.isFromNearby)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if ((!((String)localObject).equals(localMessageForDeliverGiftTips.receiverUin + "")) && (!localMessageForDeliverGiftTips.isToAll())) {
            break label214;
          }
          paramMessageInfo = paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo;
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramMessageRecord.istroop != 1) {
            break label208;
          }
          paramMessageInfo.a((AppRuntime)localObject, bool, paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
        }
      }
    }
    for (;;)
    {
      paramMessageInfo = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (paramMessageInfo != null) {
        paramMessageInfo.b(localMessageForDeliverGiftTips);
      }
      return;
      label208:
      bool = false;
      break;
      label214:
      if (localMessageForDeliverGiftTips.animationPackageId > 0) {
        paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(7, paramLong, paramMessageRecord.uniseq);
      }
    }
  }
  
  private void m(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    Object localObject;
    int i;
    if (paramMessageRecord.msgtype == -1035)
    {
      localObject = (MessageForMixedMsg)paramMessageRecord;
      i = 0;
    }
    for (;;)
    {
      if (i < ((MessageForMixedMsg)localObject).msgElemList.size())
      {
        MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(i);
        if (!(localMessageRecord instanceof MessageForReplyText)) {
          break label135;
        }
        localObject = (MessageForReplyText)localMessageRecord;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((MessageForReplyText)localObject).mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
          paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(22, paramLong, paramMessageRecord.uniseq);
        }
      }
      return;
      label135:
      i += 1;
    }
  }
  
  private void n(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -1049)
    {
      MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin + ""))) {
        paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(22, paramLong, paramMessageRecord.uniseq);
      }
    }
  }
  
  protected TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    for (;;)
    {
      long l1;
      ArrayList localArrayList;
      im_msg_body.RichText localRichText;
      MessageInfo localMessageInfo;
      try
      {
        long l5 = System.currentTimeMillis();
        if ((paramPBDecodeContext == null) || (paramMsg == null) || (paramArrayList == null)) {
          break;
        }
        msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
        long l6 = localMsgHead.from_uin.get();
        localMsgHead.to_uin.get();
        long l3 = localMsgHead.msg_seq.get();
        long l2 = localMsgHead.msg_time.get();
        l1 = 0L;
        long l7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (paramPBDecodeContext.jdField_e_of_type_Int == 1026)
        {
          l3 = Utils.a(localMsgHead.msg_seq.get());
          l2 = Utils.a(localMsgHead.msg_time.get());
        }
        int i = 0;
        int j = 0;
        int k = 0;
        if (paramMsg.content_head.has())
        {
          localObject = (msg_comm.ContentHead)paramMsg.content_head.get();
          i = ((msg_comm.ContentHead)localObject).div_seq.get();
          j = ((msg_comm.ContentHead)localObject).pkg_num.get();
          k = ((msg_comm.ContentHead)localObject).pkg_index.get();
        }
        long l8 = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(l6), String.valueOf(l6));
        localArrayList = new ArrayList();
        localRichText = null;
        localMessageInfo = new MessageInfo();
        if (paramMsg.appshare_info.has())
        {
          AppShareInfoDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localArrayList, paramMsg, paramPBDecodeContext.jdField_e_of_type_Long, l2, false);
          localObject = localRichText;
          l4 = l1;
          a(j, localArrayList);
          paramPBDecodeContext = a(paramArrayList, paramPBDecodeContext, paramBoolean, paramMessageInfo, localMsgHead, l6, l3, l2, l4, l7, str, i, j, k, localArrayList, (List)localObject, localMessageInfo, (byte)0, null);
          paramMsg = a(paramMsg, paramArrayList, (int)l8, paramPBDecodeContext);
          MsgAutoMonitorUtil.getInstance().addDecodeGrpDisMsgTime(System.currentTimeMillis() - l5);
          return paramMsg;
        }
      }
      catch (Throwable paramMsg)
      {
        paramMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis failure : ", paramMsg);
        }
        return null;
      }
      long l4 = l1;
      Object localObject = localRichText;
      if (paramMsg.msg_body.has())
      {
        im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)paramMsg.msg_body.get();
        l4 = l1;
        localObject = localRichText;
        if (localMsgBody.rich_text.has())
        {
          localRichText = (im_msg_body.RichText)localMsgBody.rich_text.get();
          if (localRichText.attr.has()) {
            l1 = MessageUtils.a(((im_msg_body.Attr)localRichText.attr.get()).random.get());
          }
          localObject = localRichText.elems.get();
          if (localRichText.ptt.has())
          {
            new GrpDisPTTDecoder().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localArrayList, null);
            l4 = l1;
          }
          else
          {
            localMessageInfo.jdField_a_of_type_JavaLangString = String.valueOf(paramPBDecodeContext.jdField_e_of_type_Long);
            localMessageInfo.jdField_a_of_type_Int = paramPBDecodeContext.jdField_e_of_type_Int;
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localArrayList, paramMsg, false, false, localMessageInfo);
            l4 = l1;
          }
        }
      }
    }
    return null;
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_seq_" + l;
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  protected void a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramMessageRecord))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "handle push . notifySendMessageSuccessful" + paramMessageRecord.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      a(6003, true, new Object[] { paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.uniseq) });
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord.msgseq);
      if (MsgProxyUtils.i(paramMessageRecord.msgtype))
      {
        StatictisInfo localStatictisInfo = new StatictisInfo();
        localStatictisInfo.b = 1000;
        localStatictisInfo.c = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(5006, true, new Object[] { Long.valueOf(paramMessageRecord.uniseq), localStatictisInfo });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc
 * JD-Core Version:    0.7.0.1
 */