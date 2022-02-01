import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ark.open.ArkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.hiboom.hiboom_type.Hiboom_Type;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;
import localpb.richMsg.RichMsg.PicRec;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ActivityGiftInfo;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.InteractGift;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ResvAttr;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.source_msg.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.AnimationImageShow;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype15;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype20;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype23;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype33;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype5;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype8;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.ArkAppElem;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.DeliverGiftMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupPubAccountInfo;
import tencent.im.msg.im_msg_body.LifeOnlineAccount;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MarketTrans;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TipsInfo;
import tencent.im.msg.im_msg_body.TransElem;
import tencent.im.msg.obj_msg.MsgContentInfo;
import tencent.im.msg.obj_msg.MsgContentInfo.MsgFile;
import tencent.im.msg.obj_msg.ObjMsg;

public class bblb
{
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  
  private int a(List<im_msg_body.Elem> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((localElem.text.has()) && (localElem.text.bytes_pb_reserve.has())) {}
      for (;;)
      {
        try
        {
          TextMsgExtPb.ResvAttr localResvAttr = new TextMsgExtPb.ResvAttr();
          localResvAttr.mergeFrom(localElem.text.bytes_pb_reserve.get().toByteArray());
          int j = i;
          if (localResvAttr.text_analysis_result.has()) {
            j = localResvAttr.text_analysis_result.get();
          }
          i = j;
        }
        catch (Exception localException)
        {
          QLog.e("DecodeMsg", 1, "parse TextMsgExtPb.ResvAttr error, ", localException);
        }
      }
    }
    return i;
  }
  
  private int a(im_msg_body.CommonElem paramCommonElem)
  {
    int i = 0;
    if (paramCommonElem.uint32_business_type.has()) {
      i = paramCommonElem.uint32_business_type.get();
    }
    return i;
  }
  
  private long a(List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong, MessageForStructing paramMessageForStructing)
  {
    long l3 = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(amxb.class.getSimpleName(), 2, "Received flower message");
    }
    Object localObject = NearbyFlowerMessage.getFlowerMsgVersion(paramMessageForStructing);
    long l2;
    if ((!"1".equals(localObject)) && (!"2".equals(localObject)))
    {
      l2 = paramLong;
      if (!"3".equals(localObject)) {}
    }
    else
    {
      localObject = (msg_comm.GroupInfo)paramMsg.msg_head.group_info.get();
      if (localObject == null) {
        break label243;
      }
    }
    label238:
    label243:
    for (long l1 = ((msg_comm.GroupInfo)localObject).group_code.get();; l1 = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i(amxb.class.getSimpleName(), 2, "decodePBMsgElems, groupCode:" + l1);
      }
      l2 = paramLong;
      if (l1 <= 0L) {
        if (!paramMsg.msg_head.from_uin.has()) {
          break label238;
        }
      }
      for (paramLong = paramMsg.msg_head.from_uin.get();; paramLong = 0L)
      {
        l1 = l3;
        if (paramMsg.msg_head.to_uin.has()) {
          l1 = paramMsg.msg_head.to_uin.get();
        }
        paramList.add(((amxb)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getManager(124)).a(Long.toString(paramLong), Long.toString(l1), paramMessageForStructing.istroop, paramMessageForStructing.structingMsg));
        l2 = paramLong;
        return l2;
      }
    }
  }
  
  private long a(msg_comm.Msg paramMsg, long paramLong, int paramInt)
  {
    long l;
    if (paramInt != 82)
    {
      l = paramLong;
      if (paramInt != 43) {}
    }
    else
    {
      l = paramLong;
      if (paramMsg.msg_head.group_info != null)
      {
        l = paramLong;
        if (paramMsg.msg_head.group_info.group_code.has()) {
          l = paramMsg.msg_head.group_info.group_code.get();
        }
      }
    }
    return l;
  }
  
  private ChatMessage a(bdyi parambdyi, ArrayList<Object> paramArrayList, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList1, long paramLong1, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong2, String paramString3, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      parambdyi = new MessageForFoldMsg();
      ((MessageForFoldMsg)parambdyi).init(paramBoolean1, paramString1, paramString2, paramLong1, true);
    }
    do
    {
      return parambdyi;
      if (paramBoolean3)
      {
        parambdyi = (ChatMessage)bbli.a(-1051);
        parambdyi.saveExtInfoToExtStr("long_text_recv_state", "1");
        parambdyi.removeExtInfoToExtStr("long_text_msg_resid");
        return parambdyi;
      }
      if (paramLong2 != 0L)
      {
        parambdyi = new MessageForWantGiftMsg();
        ((MessageForWantGiftMsg)parambdyi).wantGiftSenderUin = paramLong2;
        ((MessageForWantGiftMsg)parambdyi).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, paramLong2 + "");
        ((MessageForWantGiftMsg)parambdyi).msgtype = -2056;
        return parambdyi;
      }
      paramString1 = (ChatMessage)bbli.a(-1000);
      if ((parambdyi != null) && (paramArrayList1 != null)) {
        bevq.a(parambdyi.jdField_a_of_type_Int, paramArrayList1, paramString1);
      }
      if (paramString3 != null) {
        paramString1.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", paramString3);
      }
      parambdyi = paramString1;
    } while (paramArrayList.size() <= 0);
    parambdyi = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramArrayList1 = paramArrayList.next();
      if ((paramArrayList1 instanceof MessageForText.AtTroopMemberInfo)) {
        parambdyi.add((MessageForText.AtTroopMemberInfo)paramArrayList1);
      }
    }
    paramString1.atInfoTempList = parambdyi;
    return paramString1;
  }
  
  private MessageForDeliverGiftTips a(String paramString1, String paramString2, im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:GiftMsg;\n");
    }
    paramStringBuilder = a(paramDeliverGiftMsg);
    paramStringBuilder.senderName = paramString1;
    paramStringBuilder.grayTipContent = paramDeliverGiftMsg.bytes_gray_tip_content.get().toStringUtf8();
    paramStringBuilder.animationPackageId = paramDeliverGiftMsg.uint32_animation_package_id.get();
    paramStringBuilder.animationPackageUrl = paramDeliverGiftMsg.bytes_animation_package_url_a.get().toStringUtf8();
    paramStringBuilder.remindBrief = paramDeliverGiftMsg.bytes_remind_brief.get().toStringUtf8();
    paramStringBuilder.giftId = paramDeliverGiftMsg.uint32_gift_id.get();
    paramStringBuilder.giftCount = paramDeliverGiftMsg.uint32_gift_count.get();
    paramStringBuilder.animationBrief = paramDeliverGiftMsg.bytes_animation_brief.get().toStringUtf8();
    paramStringBuilder.senderUin = paramDeliverGiftMsg.uint64_sender_uin.get();
    paramStringBuilder.receiverUin = paramDeliverGiftMsg.uint64_receiver_uin.get();
    d(paramDeliverGiftMsg, paramStringBuilder);
    c(paramDeliverGiftMsg, paramStringBuilder);
    e(paramDeliverGiftMsg, paramStringBuilder);
    paramStringBuilder.rcvName = paramString2;
    b(paramDeliverGiftMsg, paramStringBuilder);
    a(paramDeliverGiftMsg, paramList, paramMsg, paramStringBuilder);
    a(paramDeliverGiftMsg, paramStringBuilder);
    if (QLog.isColorLevel()) {
      QLog.i(".troop.send_gift", 2, "MessageProtoCodec.decodePBMsgElems  decode send gift gray tips" + paramStringBuilder.msg);
    }
    a(paramStringBuilder);
    return paramStringBuilder;
  }
  
  @NonNull
  private MessageForDeliverGiftTips a(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg)
  {
    int i = paramDeliverGiftMsg.uint32_animation_package_id.get();
    int j = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
    if ((i == 0) && ((j < 1000) || (j > 2000)))
    {
      paramDeliverGiftMsg = (MessageForDeliverGiftTips)bbli.a(-2035);
      paramDeliverGiftMsg.msgtype = -2035;
      return paramDeliverGiftMsg;
    }
    paramDeliverGiftMsg = (MessageForTroopGift)bbli.a(-2038);
    paramDeliverGiftMsg.msgtype = -2038;
    return paramDeliverGiftMsg;
  }
  
  @NonNull
  private MessageForPic a(msg_comm.Msg paramMsg, boolean paramBoolean, CustomFaceExtPb.ResvAttr paramResvAttr)
  {
    if (paramBoolean)
    {
      MessageForPic localMessageForPic = (MessageForPic)bbli.a(-5015);
      localMessageForPic.msgtype = -5015;
      ((MessageForTroopEffectPic)localMessageForPic).effectId = ((CustomFaceExtPb.AnimationImageShow)paramResvAttr.msg_image_show.get()).int32_effect_id.get();
      localMessageForPic.frienduin = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.group_code.get());
      localMessageForPic.istroop = 1;
      paramMsg = (beyh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if (paramMsg != null) {
        paramMsg.a((beyv)localMessageForPic, false);
      }
      return localMessageForPic;
    }
    paramMsg = (MessageForPic)bbli.a(-2000);
    paramMsg.msgtype = -2000;
    return paramMsg;
  }
  
  @NonNull
  private MessageForPubAccount a(String paramString, PAMessage paramPAMessage)
  {
    MessageForPubAccount localMessageForPubAccount = (MessageForPubAccount)bbli.a(-3006);
    localMessageForPubAccount.msgtype = -3006;
    localMessageForPubAccount.msg = paramString;
    localMessageForPubAccount.mPAMessage = paramPAMessage;
    try
    {
      localMessageForPubAccount.msgData = ueg.a(paramPAMessage);
      return localMessageForPubAccount;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localMessageForPubAccount;
  }
  
  @Nullable
  private MessageForReplyText a(MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, List<MessageRecord> paramList, bble parambble, bdyi parambdyi, MessageForReplyText paramMessageForReplyText)
  {
    if ((!TextUtils.isEmpty(paramMessageForReplyText.mSourceMsgInfo.mAnonymousNickName)) || (paramAtTroopMemberInfo == null)) {}
    Object localObject;
    do
    {
      do
      {
        return paramMessageForReplyText;
        if (paramList.size() > 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("zivonchen", 2, "");
      return paramMessageForReplyText;
      localObject = (MessageRecord)paramList.get(0);
      if ((localObject instanceof MessageForText)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("zivonchen", 2, "replytext 内容为空，有回复消息，但第一个消息体不是文本消息");
    return paramMessageForReplyText;
    MessageForReplyText localMessageForReplyText = (MessageForReplyText)bbli.a(-1049);
    MessageRecord.copyMessageRecordBaseField(localMessageForReplyText, (MessageRecord)localObject);
    MessageRecord.copyMessageRecordStatusField(localMessageForReplyText, (MessageRecord)localObject);
    localMessageForReplyText.atInfoList = paramMessageForReplyText.atInfoList;
    localMessageForReplyText.msg = ((MessageRecord)localObject).msg;
    localMessageForReplyText.mSourceMsgInfo = paramMessageForReplyText.mSourceMsgInfo;
    localMessageForReplyText.msgtype = -1049;
    int i;
    if ((!TextUtils.isEmpty(localMessageForReplyText.msg)) && (localMessageForReplyText.msg.length() >= paramAtTroopMemberInfo.textLen + paramAtTroopMemberInfo.startPos))
    {
      localObject = localMessageForReplyText.msg;
      localMessageForReplyText.msg = "";
      if (paramAtTroopMemberInfo.startPos > 0) {
        localMessageForReplyText.msg = ((String)localObject).substring(0, paramAtTroopMemberInfo.startPos);
      }
      paramMessageForReplyText = "";
      i = paramAtTroopMemberInfo.startPos + paramAtTroopMemberInfo.textLen;
      if (i + 1 < ((String)localObject).length()) {
        paramMessageForReplyText = ((String)localObject).substring(i, i + 1);
      }
      if (!paramMessageForReplyText.equals(" ")) {
        break label362;
      }
    }
    label362:
    for (localMessageForReplyText.msg += ((String)localObject).substring(i + 1);; localMessageForReplyText.msg += ((String)localObject).substring(i))
    {
      if ((paramAtTroopMemberInfo.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin())) && (parambble.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo == null)) {
        parambdyi.jdField_a_of_type_Bdyj.b(24, -1L);
      }
      paramList.remove(0);
      paramList.add(0, localMessageForReplyText);
      return null;
    }
  }
  
  public static MessageForVIPDonate a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("DecodeMsg", 1, "content is empty ");
      localObject = null;
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "createVIPDonateMsg: msg = " + paramString);
    }
    JSONObject localJSONObject;
    VIPDonateMsg localVIPDonateMsg;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject == null) {
          break label444;
        }
        MessageForVIPDonate localMessageForVIPDonate = (MessageForVIPDonate)bbli.a(-2047);
        localMessageForVIPDonate.msgtype = -2047;
        localVIPDonateMsg = new VIPDonateMsg();
        if (localJSONObject.has("title"))
        {
          localObject = localJSONObject.getString("title");
          localVIPDonateMsg.title = ((String)localObject);
          if (!localJSONObject.has("footer")) {
            break label328;
          }
          localObject = localJSONObject.getString("footer");
          localVIPDonateMsg.footer = ((String)localObject);
          if (!paramBoolean) {
            break label348;
          }
          if (!localJSONObject.has("sendsubtitle")) {
            break label333;
          }
          localObject = localJSONObject.getString("sendsubtitle");
          localVIPDonateMsg.subTitle = ((String)localObject);
          if (!localJSONObject.has("sendurl")) {
            break label338;
          }
          localObject = localJSONObject.getString("sendurl");
          localVIPDonateMsg.jumpUrl = ((String)localObject);
          if (!localJSONObject.has("sendbrief")) {
            break label343;
          }
          localObject = localJSONObject.getString("sendbrief");
          localVIPDonateMsg.brief = ((String)localObject);
          localMessageForVIPDonate.donateMsg = localVIPDonateMsg;
          localMessageForVIPDonate.msg = localMessageForVIPDonate.getSummaryMsg();
          localMessageForVIPDonate.msgData = anwz.a(localVIPDonateMsg);
          localObject = localMessageForVIPDonate;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("vipdonateMsgparse", 2, "donateMsg = " + localMessageForVIPDonate.donateMsg);
          return localMessageForVIPDonate;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("DecodeMsg", 1, "vipdonate json error :json = " + paramString);
        return null;
      }
      str = null;
      continue;
      label328:
      str = null;
      continue;
      label333:
      str = null;
      continue;
      label338:
      str = null;
      continue;
      label343:
      str = null;
    }
    label348:
    if (localJSONObject.has("recvsubtitle"))
    {
      str = localJSONObject.getString("recvsubtitle");
      label368:
      localVIPDonateMsg.subTitle = str;
      if (!localJSONObject.has("recvurl")) {
        break label434;
      }
      str = localJSONObject.getString("recvurl");
      localVIPDonateMsg.jumpUrl = str;
      if (!localJSONObject.has("recvbrief")) {
        break label439;
      }
    }
    label394:
    label434:
    label439:
    for (String str = localJSONObject.getString("recvbrief");; str = null)
    {
      localVIPDonateMsg.brief = str;
      break;
      str = null;
      break label368;
      str = null;
      break label394;
    }
    label444:
    return null;
  }
  
  private static PAMessage a(String paramString)
  {
    return ueg.a(paramString);
  }
  
  @Nullable
  private PAMessage a(List<im_msg_body.Elem> paramList, String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint64_msg_id.has())) {
        paramString.mMsgId = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint64_msg_id.get();
      }
    }
    return paramString;
  }
  
  private Boolean a(List<im_msg_body.Elem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
        if ((localElem.market_trans.has()) || (localElem.rich_msg.has())) {
          return Boolean.valueOf(true);
        }
      }
    }
    return Boolean.valueOf(false);
  }
  
  @NotNull
  private String a(MessageForStructing paramMessageForStructing)
  {
    String str = "";
    Object localObject = str;
    if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgUrl)) {
      paramMessageForStructing = Uri.parse(paramMessageForStructing.structingMsg.mMsgUrl);
    }
    try
    {
      paramMessageForStructing = paramMessageForStructing.getQueryParameter("article_id");
      localObject = paramMessageForStructing;
      if (paramMessageForStructing == null) {
        localObject = "";
      }
      return localObject;
    }
    catch (Exception paramMessageForStructing)
    {
      for (;;)
      {
        paramMessageForStructing.printStackTrace();
        paramMessageForStructing = str;
      }
    }
  }
  
  @NonNull
  private String a(ByteStringMicro paramByteStringMicro)
  {
    String str = "";
    if (paramByteStringMicro != null) {
      str = paramByteStringMicro.toStringUtf8();
    }
    return str;
  }
  
  private static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 2 < paramString.length()))
      {
        int j = (paramString.charAt(i + 1) - 'A') * 128 + paramString.charAt(i + 2) - 65;
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "faceIndex:" + j);
        }
        j = QQSysFaceUtil.convertToLocal(j);
        if (j >= 0)
        {
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append((char)j);
        }
        i = i + 1 + 1;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  private String a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, boolean paramBoolean)
  {
    String str = null;
    Object localObject = paramList.iterator();
    paramList = null;
    if (((Iterator)localObject).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject).next();
      if (!localElem.text.has()) {
        break label160;
      }
      paramList = (im_msg_body.Text)localElem.text.get();
    }
    label160:
    for (;;)
    {
      break;
      localObject = str;
      if (paramList != null)
      {
        localObject = str;
        if (paramList.str.has())
        {
          paramList = paramList.str.get().toStringUtf8();
          localObject = paramList;
          if (paramBoolean)
          {
            str = bblk.a(paramList, false);
            localObject = paramList;
            if (str.length() > 0)
            {
              localObject = (MessageForText)bbli.a(-1000);
              ((MessageForText)localObject).msgtype = -1000;
              ((MessageForText)localObject).msg = str;
              paramList1.add(localObject);
              localObject = paramList;
            }
          }
        }
      }
      return localObject;
    }
  }
  
  @NonNull
  private StringBuilder a(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder != null) {
      return new StringBuilder(paramStringBuilder);
    }
    return new StringBuilder();
  }
  
  private StringBuilder a(StringBuilder paramStringBuilder1, List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder2, long paramLong, bdyi parambdyi, bble parambble, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    bble localbble = parambble;
    if (parambble == null) {
      localbble = new bble();
    }
    bbld localbbld = null;
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = localbble.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo;
    parambble = null;
    StringBuilder localStringBuilder = a(paramStringBuilder1);
    boolean bool = false;
    Iterator localIterator = paramList.iterator();
    paramList = localAtTroopMemberInfo;
    paramStringBuilder1 = localbbld;
    while (localIterator.hasNext())
    {
      localbbld = new bbld(this, paramStringBuilder2, paramLong, parambdyi, paramArrayList, paramStringBuilder1, paramList, parambble, localStringBuilder, bool, (im_msg_body.Elem)localIterator.next()).a();
      paramStringBuilder1 = localbbld.a();
      paramList = localbbld.b();
      parambble = localbbld.a();
      bool = localbbld.a();
    }
    localbble.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo = paramList;
    a(localbble, paramStringBuilder1, parambble);
    return localStringBuilder;
  }
  
  @NonNull
  private CustomFaceExtPb.ResvAttr a(im_msg_body.CustomFace paramCustomFace)
  {
    CustomFaceExtPb.ResvAttr localResvAttr = new CustomFaceExtPb.ResvAttr();
    try
    {
      localResvAttr.mergeFrom(paramCustomFace.bytes_pb_reserve.get().toByteArray());
      return localResvAttr;
    }
    catch (InvalidProtocolBufferMicroException paramCustomFace)
    {
      paramCustomFace.printStackTrace();
    }
    return localResvAttr;
  }
  
  @Nullable
  private im_msg_body.CommonElem a(List<im_msg_body.Elem> paramList)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.common_elem.has()) {
        break label56;
      }
      paramList = (im_msg_body.CommonElem)localElem.common_elem.get();
    }
    label56:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  @Nullable
  private im_msg_body.CustomFace a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramCustomFace != null) {}
    do
    {
      return paramCustomFace;
      paramCustomFace = localObject;
    } while (paramElem == null);
    if (paramBoolean) {
      return (im_msg_body.CustomFace)paramElem.hc_flash_pic.get();
    }
    return (im_msg_body.CustomFace)paramElem.custom_face.get();
  }
  
  private im_msg_body.GeneralFlags a(List<im_msg_body.Elem> paramList)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.general_flags.has()) {
        break label56;
      }
      paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
    }
    label56:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  @Nullable
  private im_msg_body.GroupPubAccountInfo a(List<im_msg_body.Elem> paramList)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if ((!localElem.group_pub_acc_info.has()) || (!localElem.group_pub_acc_info.uint64_pub_account.has())) {
        break label69;
      }
      paramList = (im_msg_body.GroupPubAccountInfo)localElem.group_pub_acc_info.get();
    }
    label69:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  private im_msg_body.RichMsg a(List<im_msg_body.Elem> paramList)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.rich_msg.has()) {
        break label56;
      }
      paramList = (im_msg_body.RichMsg)localElem.rich_msg.get();
    }
    label56:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  private im_msg_body.Text a(List<im_msg_body.Elem> paramList)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.text.has()) {
        break label56;
      }
      paramList = (im_msg_body.Text)localElem.text.get();
    }
    label56:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  @Nullable
  private im_msg_body.TransElem a(List<im_msg_body.Elem> paramList)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.trans_elem_info.has()) {
        break label56;
      }
      paramList = (im_msg_body.TransElem)localElem.trans_elem_info.get();
    }
    label56:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  private void a(int paramInt, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof RecommendCommonMessage)) {
      paramChatMessage.saveExtInfoToExtStr("ark_text_analysis_flag", String.valueOf(paramInt));
    }
  }
  
  private void a(long paramLong, MessageForStructing paramMessageForStructing)
  {
    if (((2171946401L == paramLong) || (2173223560L == paramLong) || (2062433139L == paramLong) || (3434959637L == paramLong)) && ((paramMessageForStructing.structingMsg instanceof AbsShareMsg)))
    {
      if (2171946401L == paramLong) {
        ugf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForStructing, 11);
      }
      ((AbsShareMsg)paramMessageForStructing.structingMsg).clearItems();
      paramMessageForStructing.extInt = 1;
      paramMessageForStructing.extLong = 1;
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "decode structMsg form XIN_KANDIAN, items = " + ((AbsShareMsg)paramMessageForStructing.structingMsg).getStructMsgItemLists().size());
      }
    }
  }
  
  private void a(bble parambble, MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, byte[] paramArrayOfByte)
  {
    parambble = parambble.jdField_a_of_type_JavaUtilArrayList;
    if ((parambble == null) || ((paramAtTroopMemberInfo == null) && (paramArrayOfByte == null))) {}
    do
    {
      return;
      if (parambble.isEmpty())
      {
        parambble.add(paramAtTroopMemberInfo);
        parambble.add(paramArrayOfByte);
        return;
      }
    } while ((parambble.size() != 2) || ((parambble.get(0) != null) && (parambble.get(1) != null)));
    if (parambble.get(0) == null) {
      if (parambble.get(1) != null) {
        break label104;
      }
    }
    for (;;)
    {
      parambble.clear();
      parambble.add(paramAtTroopMemberInfo);
      parambble.add(paramArrayOfByte);
      return;
      paramAtTroopMemberInfo = parambble.get(0);
      break;
      label104:
      paramArrayOfByte = parambble.get(1);
    }
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForText)) {
      bfdm.a(paramChatMessage);
    }
  }
  
  private void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if ((paramMessageForDeliverGiftTips.summary == null) || (paramMessageForDeliverGiftTips.rcvName == null) || (paramMessageForDeliverGiftTips.rcvName.length() <= 0)) {}
    Object localObject1;
    int i;
    int j;
    do
    {
      do
      {
        return;
        Pattern localPattern = Pattern.compile(amtj.a(2131705769));
        localObject2 = paramMessageForDeliverGiftTips.msg;
        localObject1 = localObject2;
        if (!paramMessageForDeliverGiftTips.isToAll())
        {
          localObject1 = localObject2;
          if (paramMessageForDeliverGiftTips.msg.startsWith("["))
          {
            i = paramMessageForDeliverGiftTips.msg.indexOf("]");
            localObject1 = localObject2;
            if (i != -1)
            {
              localObject1 = localObject2;
              if (i < paramMessageForDeliverGiftTips.msg.length()) {
                localObject1 = paramMessageForDeliverGiftTips.msg.substring(i + 1);
              }
            }
          }
        }
        localObject2 = localPattern.matcher((CharSequence)localObject1);
      } while (!((Matcher)localObject2).find());
      Object localObject2 = ((Matcher)localObject2).group();
      i = ((String)localObject1).indexOf((String)localObject2);
      j = ((String)localObject1).lastIndexOf((String)localObject2);
    } while ((i <= 0) || (j != i));
    paramMessageForDeliverGiftTips.senderName = ((String)localObject1).substring(0, i);
  }
  
  private void a(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, MessageForReplyText paramMessageForReplyText)
  {
    try
    {
      paramMessageForReplyText.extLong |= 0x1;
      paramMessageForReplyText.mSourceMsgInfo = paramSourceMsgInfo;
      if (paramSourceMsgInfo.getSourceMsg() != null)
      {
        paramMessageForReplyText.setSourceMessageRecord(paramSourceMsgInfo.unPackSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app));
        if ((paramMessageForReplyText.getSourceMessage() != null) && (aszt.a(paramMessageForReplyText.getSourceMessage())))
        {
          String str = paramMessageForReplyText.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
          ChatMessage localChatMessage = aszt.a((ChatMessage)paramMessageForReplyText.getSourceMessage());
          ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, paramMessageForReplyText.getSourceMessage());
          if ((!TextUtils.isEmpty(str)) && (localChatMessage != null))
          {
            int i = Integer.parseInt(str);
            if ((i == 1) || (i == 2))
            {
              QLog.i("DecodeMsg<QFile>", 1, "decode mix inner reply file msg, msg uniseq[" + localChatMessage.uniseq + "]");
              aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)paramMessageForReplyText.getSourceMessage());
            }
          }
        }
      }
      paramMessageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(anwz.a(paramSourceMsgInfo)));
      return;
    }
    catch (Exception paramSourceMsgInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramSourceMsgInfo.getMessage());
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      paramMessageForStructing = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      String str = paramMessageForStructing.animResId;
      betn.a().a(str, null);
      betn.a().a(paramMessageForStructing.atMembers);
    }
  }
  
  private void a(String paramString, ChatMessage paramChatMessage)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramChatMessage.saveExtInfoToExtStr("small_description", paramString);
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    String str = BaseApplication.getContext().getString(2131694223);
    MessageForText localMessageForText = (MessageForText)bbli.a(-1000);
    localMessageForText.msgtype = -1000;
    localMessageForText.msg = str;
    paramList.add(localMessageForText);
  }
  
  private void a(List<im_msg_body.Elem> paramList, MessageForStructing paramMessageForStructing)
  {
    paramList = paramList.iterator();
    while ((paramList.hasNext()) && (!a(paramMessageForStructing, (im_msg_body.Elem)paramList.next()))) {}
  }
  
  private void a(List<im_msg_body.Elem> paramList, PAMessage paramPAMessage)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint64_msg_id.has())) {
        paramPAMessage.mMsgId = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint64_msg_id.get();
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, String paramString, int paramInt, hiboom_type.Hiboom_Type paramHiboom_Type)
  {
    if (!paramHiboom_Type.uint32_hiboom_type.has())
    {
      QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom no type");
      return;
    }
    int i = paramHiboom_Type.uint32_hiboom_type.get();
    if (!auen.a(i))
    {
      QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom type not support: type = " + i);
      return;
    }
    HiBoomMessage localHiBoomMessage = new HiBoomMessage();
    localHiBoomMessage.id = paramInt;
    localHiBoomMessage.text = paramString;
    localHiBoomMessage.type = i;
    paramHiboom_Type = (MessageForHiBoom)bbli.a(-5014);
    paramHiboom_Type.mHiBoomMessage = localHiBoomMessage;
    paramHiboom_Type.msgtype = -5014;
    paramHiboom_Type.msg = paramString;
    try
    {
      paramHiboom_Type.msgData = anwz.a(localHiBoomMessage);
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.MessagePBElemDecoder", 2, "receive hiboom message id = " + paramInt + "message = " + paramString.charAt(0));
      }
      paramList.add(paramHiboom_Type);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("HiBoomFont.MessagePBElemDecoder", 1, "getBytesFromObject error, ", localException);
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, String paramString, hummer_commelem.MsgElemInfo_servtype14 paramMsgElemInfo_servtype14)
  {
    if (!paramMsgElemInfo_servtype14.uint32_id.has()) {
      return;
    }
    int i = paramMsgElemInfo_servtype14.uint32_id.get();
    if (!paramMsgElemInfo_servtype14.reserve_Info.has())
    {
      QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom no reserve_info");
      return;
    }
    paramMsgElemInfo_servtype14 = paramMsgElemInfo_servtype14.reserve_Info.get().toByteArray();
    hiboom_type.Hiboom_Type localHiboom_Type = new hiboom_type.Hiboom_Type();
    localHiboom_Type.mergeFrom(paramMsgElemInfo_servtype14);
    a(paramList, paramString, i, localHiboom_Type);
  }
  
  private void a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder, MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, List<MessageRecord> paramList1, bble parambble, bdyi parambdyi)
  {
    paramList = a(paramList, paramStringBuilder);
    if (paramList == null) {}
    do
    {
      return;
      paramStringBuilder = (MessageForReplyText)bbli.a(-1049);
      a(paramList, paramStringBuilder);
      paramList = a(paramAtTroopMemberInfo, paramList1, parambble, parambdyi, paramStringBuilder);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "sb.length == 0");
      }
    } while (paramList == null);
    paramList1.add(0, paramList);
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi, String paramString, int paramInt, hummer_commelem.MsgElemInfo_servtype14 paramMsgElemInfo_servtype14)
  {
    if (paramInt == 0) {
      a(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi, paramString, paramMsgElemInfo_servtype14);
    }
    while (paramInt != 1) {
      return;
    }
    a(paramList1, paramString, paramMsgElemInfo_servtype14);
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi, String paramString, hummer_commelem.MsgElemInfo_servtype14 paramMsgElemInfo_servtype14)
  {
    if (!((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a()) {
      f(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi);
    }
    do
    {
      return;
      if (!ArkUtil.isDeviceSupportArkMsg())
      {
        QLog.i("FlashChat", 1, "decodePBMsgElems_FlashChat is false, ignore msg.");
        return;
      }
    } while ((!paramMsgElemInfo_servtype14.uint32_id.has()) || (!paramMsgElemInfo_servtype14.reserve_Info.has()));
    int j = paramMsgElemInfo_servtype14.uint32_id.get();
    String str = paramMsgElemInfo_servtype14.reserve_Info.get().toStringUtf8();
    if (!paramMsgElemInfo_servtype14.reserve_Info.has())
    {
      QLog.i("flashchat", 1, "ecodePBMsgElems_FlashChat, reserve_Info not exist.");
      return;
    }
    Object localObject = paramMsgElemInfo_servtype14.reserve_Info.get().toByteArray();
    if (localObject.length <= 0)
    {
      QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat, reserve_Info empty.");
      return;
    }
    paramMsgElemInfo_servtype14 = null;
    localObject = bciq.a((byte[])localObject, -1);
    if ((localObject != null) && (localObject.length > 0))
    {
      try
      {
        localObject = new String((byte[])localObject, "UTF-8");
        paramMsgElemInfo_servtype14 = (hummer_commelem.MsgElemInfo_servtype14)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label185:
          QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat convert failed");
        }
      }
      localObject = new ArkFlashChatMessage();
      ((ArkFlashChatMessage)localObject).fromAppXml(paramMsgElemInfo_servtype14);
      ((ArkFlashChatMessage)localObject).appResId = j;
      ((ArkFlashChatMessage)localObject).promptText = paramString;
      paramString = (MessageForArkFlashChat)bbli.a(-5013);
      paramString.msgtype = -5013;
      paramString.msgData = ((ArkFlashChatMessage)localObject).toBytes();
      paramString.parse();
      if ((TextUtils.isEmpty(paramString.ark_app_message.appName)) || (TextUtils.isEmpty(paramString.ark_app_message.appView))) {
        break label385;
      }
      paramList1.add(paramString);
    }
    for (int i = 1;; i = 0)
    {
      QLog.d("flashchat", 2, "decodePBMsgElems_FlashChat id = " + j + ", reserveInfo = " + str + ", arkData = " + paramMsgElemInfo_servtype14);
      if (i != 0) {
        break;
      }
      f(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi);
      return;
      QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat empty.");
      break label185;
      label385:
      QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat not valid..");
    }
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi, im_msg_body.GeneralFlags paramGeneralFlags, boolean paramBoolean, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing.structingMsg == null)
    {
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("c2cMsgContent.data:null;\n");
      }
      i(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi);
      return;
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {}
    for (;;)
    {
      int i;
      try
      {
        paramStringBuilder = new generalflags.ResvAttr();
        paramStringBuilder.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        if ((!paramStringBuilder.bytes_kpl_info.has()) || (!paramStringBuilder.bytes_kpl_info.has())) {
          break label478;
        }
        i = 1;
        paramList = paramStringBuilder.bytes_kpl_info.get().toStringUtf8();
        if (paramStringBuilder.bytes_oac_msg_extend.has()) {
          paramMessageForStructing.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", paramStringBuilder.bytes_oac_msg_extend.get().toStringUtf8());
        }
      }
      catch (Exception paramList)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
        paramList.printStackTrace();
        paramList = null;
        i = 0;
        continue;
        paramList1.add(paramList);
        return;
      }
      if (i != 0)
      {
        paramMessageForStructing.saveExtInfoToExtStr("msg_ext_key", "Y");
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "resv a kpl struct message !");
        }
        KplRoleInfo.handleKplFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
      }
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg need to pull longtextmsg!");
        }
        try
        {
          if (!(paramMessageForStructing.structingMsg instanceof AbsShareMsg)) {
            break label460;
          }
          paramList = (ChatMessage)bbli.a(-1051);
          paramList.saveExtInfoToExtStr("long_text_recv_state", "3");
          paramList.saveExtInfoToExtStr("long_text_msg_resid", paramMessageForStructing.structingMsg.mResid);
          paramStringBuilder = ((AbsShareMsg)paramMessageForStructing.structingMsg).getStructMsgItemLists();
          if (paramStringBuilder == null) {
            continue;
          }
          paramStringBuilder = paramStringBuilder.iterator();
          continue;
          if (!paramStringBuilder.hasNext()) {
            continue;
          }
          paramMsg = (bcgw)paramStringBuilder.next();
          if (!(paramMsg instanceof bcgx)) {
            continue;
          }
          paramMsg = ((bcgx)paramMsg).jdField_a_of_type_JavaUtilArrayList;
          if (paramMsg == null) {
            continue;
          }
          paramMsg = paramMsg.iterator();
          if (!paramMsg.hasNext()) {
            continue;
          }
          parambdyi = (bcgw)paramMsg.next();
          if (!(parambdyi instanceof StructMsgItemTitle)) {
            continue;
          }
          paramList.msg = ((StructMsgItemTitle)parambdyi).b();
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("DecodeMsg", 2, "longtextmsg getMsg from structMsg msg:" + paramList.msg);
          continue;
          paramList1.add(paramMessageForStructing);
        }
        catch (Exception paramList)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "failed to pull longtextmsg exception!", paramList);
          }
        }
      }
      else
      {
        return;
      }
      label460:
      if (QLog.isColorLevel())
      {
        QLog.d("DecodeMsg", 2, "absShareMsg is null");
        continue;
        label478:
        paramList = null;
        i = 0;
        continue;
        paramList = null;
        i = 0;
      }
    }
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, msg_comm.Msg paramMsg, im_msg_body.GeneralFlags paramGeneralFlags, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[0] != 1) {
      return;
    }
    int i = PkgTools.getShortData(paramArrayOfByte, 1);
    int j = paramArrayOfByte[3];
    Object localObject = new byte[i - 1];
    PkgTools.copyData((byte[])localObject, 0, paramArrayOfByte, 4, i - 1);
    paramArrayOfByte = (byte[])localObject;
    if (j == 1) {
      paramArrayOfByte = a((byte[])localObject);
    }
    localObject = null;
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        if (paramArrayOfByte.length <= 0) {
          break label210;
        }
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          paramList = a(paramList, paramArrayOfByte);
          localObject = paramList;
          paramList = paramArrayOfByte;
          if (paramMsg.msg_head.from_uin.has())
          {
            long l = paramMsg.msg_head.from_uin.get();
            if (agjp.a(l + "")) {
              break;
            }
          }
          if (localObject == null) {
            break;
          }
          paramList = a(paramList, (PAMessage)localObject);
          a(paramGeneralFlags, paramList);
          paramList1.add(paramList);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramList = paramArrayOfByte;
            paramArrayOfByte = localException;
          }
        }
        paramArrayOfByte = paramArrayOfByte;
        paramList = "";
      }
      paramArrayOfByte.printStackTrace();
      continue;
      label210:
      paramList = null;
      paramArrayOfByte = "";
    }
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, msg_comm.Msg paramMsg, im_msg_body.TransElem paramTransElem, im_msg_body.GeneralFlags paramGeneralFlags, int paramInt, byte[] paramArrayOfByte)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      a(paramList1);
      return;
    case 16: 
      a(paramList, paramList1, paramMsg, paramGeneralFlags, paramArrayOfByte);
      return;
    }
    a(paramList1, paramMsg, paramTransElem, paramArrayOfByte);
  }
  
  private void a(List<MessageRecord> paramList1, msg_comm.Msg paramMsg, List<MessageRecord> paramList2, byte[] paramArrayOfByte, bdyi parambdyi, MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo)
  {
    Iterator localIterator;
    int j;
    MessageRecord localMessageRecord;
    if (paramList1.size() > 1)
    {
      localIterator = paramList1.iterator();
      j = 0;
      i = 0;
      if (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if (((localMessageRecord.msgtype == -1000) || (localMessageRecord.msgtype == -1049)) && (i == 0))
        {
          i = 1;
          j += 1;
          label82:
          if (j < 2) {
            break label284;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (paramMsg.msg_head.from_uin.has())
      {
        long l = paramMsg.msg_head.from_uin.get();
        if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin(), Long.toString(l))) {}
      }
      for (j = 1;; j = 0)
      {
        if (i != 0)
        {
          paramMsg = new ArrayList();
          localIterator = paramList1.iterator();
          for (;;)
          {
            label161:
            if (!localIterator.hasNext()) {
              break label305;
            }
            localMessageRecord = (MessageRecord)localIterator.next();
            if ((localMessageRecord.msgtype != -1000) && (localMessageRecord.msgtype != -1049) && (localMessageRecord.msgtype != -2000))
            {
              if (paramMsg.size() > 0) {
                if (j == 0) {
                  break label287;
                }
              }
              label284:
              label287:
              for (paramList1 = null;; paramList1 = paramArrayOfByte)
              {
                paramList2.add(bblf.a(paramMsg, paramList1, parambdyi));
                paramMsg.clear();
                paramList2.add(localMessageRecord);
                break label161;
                if (localMessageRecord.msgtype != -2000) {
                  break label436;
                }
                j += 1;
                break label82;
                break;
              }
            }
            paramMsg.add(localMessageRecord);
          }
          label305:
          if (paramMsg.size() > 0)
          {
            if (j != 0) {
              paramArrayOfByte = null;
            }
            paramList1 = bblf.a(paramMsg, paramArrayOfByte, parambdyi);
            paramList2.add(paramList1);
            ((MessageForMixedMsg)paramList1).mAtInfo = paramAtTroopMemberInfo;
            paramMsg.clear();
          }
        }
        for (;;)
        {
          return;
          if (paramArrayOfByte == null)
          {
            paramList2.addAll(paramList1);
            return;
          }
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            paramMsg = (MessageRecord)paramList1.next();
            if (((paramMsg instanceof MessageForText)) && (j == 0)) {
              paramMsg.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(paramArrayOfByte));
            }
            paramList2.add(paramMsg);
          }
        }
      }
      label436:
      break label82;
    }
  }
  
  private void a(List<MessageRecord> paramList, msg_comm.Msg paramMsg, im_msg_body.TransElem paramTransElem, byte[] paramArrayOfByte)
  {
    int k = paramTransElem.elem_value.get().size();
    int j = 0;
    int i = 0;
    int m;
    if (k > 3)
    {
      m = j + 1;
      if (j <= 100) {
        break label38;
      }
    }
    for (;;)
    {
      label38:
      Object localObject;
      for (;;)
      {
        return;
        int n = paramArrayOfByte[i];
        int i1 = PkgTools.getShortData(paramArrayOfByte, i + 1);
        j = k - (i1 + 3);
        k = i1 + 3 + i;
        if (n != 1)
        {
          i = k;
          k = j;
          j = m;
          break;
        }
        paramTransElem = new byte[i1];
        PkgTools.copyData(paramTransElem, 0, paramArrayOfByte, i + 3, i1);
        localObject = new obj_msg.ObjMsg();
        try
        {
          paramTransElem = (obj_msg.ObjMsg)((obj_msg.ObjMsg)localObject).mergeFrom(paramTransElem);
          if (paramTransElem.uint32_msg_type.get() == 6L) {
            break label178;
          }
          i = k;
          k = j;
          j = m;
        }
        catch (Exception paramTransElem)
        {
          i = k;
          k = j;
          j = m;
        }
      }
      break;
      label178:
      paramArrayOfByte = new TroopFileData();
      paramArrayOfByte.fileUrl = new String(((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.bytes_file_path.get().toByteArray());
      paramArrayOfByte.bisID = ((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.uint32_bus_id.get();
      paramArrayOfByte.fileName = ((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.str_file_name.get();
      paramArrayOfByte.lfileSize = ((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.uint64_file_size.get();
      paramArrayOfByte.lastTime = ((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.int64_dead_time.get();
      paramArrayOfByte.sha1 = new String(((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.bytes_file_sha1.get().toByteArray());
      paramArrayOfByte.md5 = new String(((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.bytes_file_md5.get().toByteArray());
      paramArrayOfByte.uuid = UUID.nameUUIDFromBytes(paramArrayOfByte.fileUrl.getBytes()).toString();
      if (((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.bytes_ext.has()) {
        localObject = ((obj_msg.MsgContentInfo)paramTransElem.msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        paramArrayOfByte.width = ((JSONObject)localObject).optInt("width");
        paramArrayOfByte.height = ((JSONObject)localObject).optInt("height");
        paramArrayOfByte.duration = ((JSONObject)localObject).optInt("duration");
        paramArrayOfByte.yybApkPackageName = ((JSONObject)localObject).optString("yyb_apk_package_name_key");
        paramArrayOfByte.yybApkName = ((JSONObject)localObject).optString("yyb_apk_name_key");
        paramArrayOfByte.yybApkIconUrl = ((JSONObject)localObject).optString("yyb_apk_icon_url_key");
        paramArrayOfByte.dspFileName = new String(paramTransElem.bytes_title.get().toByteArray());
        paramArrayOfByte.dspFileName = aszt.a(paramArrayOfByte.dspFileName);
        paramArrayOfByte.dspFileSize = new String(((ByteStringMicro)paramTransElem.rpt_bytes_abstact.get(0)).toByteArray());
        bfav.a(paramMsg.msg_head.group_info.group_code.get()).a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramArrayOfByte.fileUrl, paramArrayOfByte);
        localObject = new StringBuilder("decodePBMshElems==>").append(paramArrayOfByte.toString());
        paramTransElem = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramMsg.msg_head.group_info.group_code.get()).a(paramArrayOfByte.fileUrl);
        if (paramTransElem != null)
        {
          paramTransElem = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getFileManagerDataCenter().a(paramTransElem.e);
          if (paramTransElem != null) {
            paramTransElem.lastTime = paramArrayOfByte.lastTime;
          }
          MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)bbli.a(-2017);
          localMessageForTroopFile.msgtype = -2017;
          localMessageForTroopFile.msg = amtj.a(2131705772);
          try
          {
            localMessageForTroopFile.msgData = anwz.a(paramArrayOfByte);
            localMessageForTroopFile.parse();
            paramList.add(localMessageForTroopFile);
            if (paramTransElem != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getMessageFacade().updateMsgContentByUniseq(paramMsg.msg_head.group_info.group_code.get() + "", 1, paramTransElem.structMsgSeq, localMessageForTroopFile.msgData);
              ((StringBuilder)localObject).append("|updateMsgContentByUniseq, msgSeq:").append(paramTransElem.structMsgSeq);
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("DecodeMsg", 2, "<TroopFile> " + ((StringBuilder)localObject).toString());
            return;
          }
          catch (Exception paramArrayOfByte)
          {
            for (;;)
            {
              paramArrayOfByte.printStackTrace();
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          paramTransElem = null;
        }
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2, StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder.length() > 0) && (!paramBoolean1) && (!paramBoolean2))
    {
      MessageForText localMessageForText = (MessageForText)bbli.a(-1000);
      localMessageForText.msgtype = -1000;
      localMessageForText.msg = paramStringBuilder.toString();
      paramList.add(localMessageForText);
      paramStringBuilder.delete(0, paramStringBuilder.length());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    TroopManager localTroopManager;
    long l;
    do
    {
      do
      {
        return;
        localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getManager(52);
      } while (!paramMsg.msg_head.group_info.has());
      l = paramMsg.msg_head.group_info.group_code.get();
      paramMsg = localTroopManager.b(String.valueOf(l));
    } while (paramMsg == null);
    paramMsg.associatePubAccount = paramLong;
    localTroopManager.b(paramMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getBusinessHandler(20).notifyUI(79, true, new Object[] { Long.valueOf(l) });
  }
  
  private void a(msg_comm.Msg paramMsg, byte[] paramArrayOfByte, ChatMessage paramChatMessage)
  {
    int j = 0;
    int i = j;
    if (paramMsg.msg_head.from_uin.has())
    {
      long l = paramMsg.msg_head.from_uin.get();
      i = j;
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin(), Long.toString(l))) {
        i = 1;
      }
    }
    if ((paramArrayOfByte != null) && (i == 0)) {
      paramChatMessage.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(paramArrayOfByte));
    }
  }
  
  private void a(msg_comm.Msg paramMsg, byte[] paramArrayOfByte, MessageForStructing paramMessageForStructing, String paramString, boolean paramBoolean, bblm parambblm)
  {
    if ((parambblm.jdField_a_of_type_Int == 1008) && (QLog.isColorLevel()))
    {
      paramMsg = new StringBuilder().append("msgId=uniseq:").append(paramMessageForStructing.uniseq).append(", serviceType(Pa-129,140,142):").append(((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).service_type.get()).append(", xmlContentLength:");
      if (paramArrayOfByte != null) {
        break label124;
      }
    }
    label124:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      QLog.d("PaOldLongMsg", 2, i + ", longMsgResId:" + paramString + ", isPaNewLongMsg:" + paramBoolean);
      return;
    }
  }
  
  private void a(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!(paramMessageForDeliverGiftTips instanceof MessageForTroopGift)) {
      return;
    }
    MessageForTroopGift localMessageForTroopGift = (MessageForTroopGift)paramMessageForDeliverGiftTips;
    localMessageForTroopGift.bagId = paramDeliverGiftMsg.bytes_to_all_gift_id.get().toStringUtf8();
    localMessageForTroopGift.title = paramDeliverGiftMsg.bytes_stmessage_title.get().toStringUtf8();
    localMessageForTroopGift.subtitle = paramDeliverGiftMsg.bytes_stmessage_subtitle.get().toStringUtf8();
    localMessageForTroopGift.message = paramDeliverGiftMsg.bytes_stmessage_message.get().toStringUtf8();
    localMessageForTroopGift.giftPicId = paramDeliverGiftMsg.uint32_stmessage_giftpicid.get();
    localMessageForTroopGift.comefrom = paramDeliverGiftMsg.bytes_stmessage_comefrom.get().toStringUtf8();
    localMessageForTroopGift.exflag = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
    if (paramDeliverGiftMsg.bytes_stmessage_gifturl.has()) {
      localMessageForTroopGift.giftUrl = paramDeliverGiftMsg.bytes_stmessage_gifturl.get().toStringUtf8();
    }
    ((MessageForTroopGift)paramMessageForDeliverGiftTips).prewrite();
  }
  
  private void a(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, List<MessageRecord> paramList, msg_comm.Msg paramMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    bfdz localbfdz = (bfdz)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getManager(81);
    if (localbfdz == null) {
      return;
    }
    paramMessageForDeliverGiftTips.grayTipsEntity = new TroopTipsEntity();
    paramMessageForDeliverGiftTips.grayTipsEntity.isSupportImage = true;
    paramMessageForDeliverGiftTips.grayTipsEntity.troopUin = String.valueOf(paramMsg.msg_head.group_info.group_code.get());
    paramMessageForDeliverGiftTips.grayTipsEntity.optContent = paramMessageForDeliverGiftTips.grayTipContent;
    localbfdz.a(paramMessageForDeliverGiftTips.grayTipsEntity);
    paramMessageForDeliverGiftTips.msg = paramMessageForDeliverGiftTips.grayTipsEntity.optContent;
    if ((paramMessageForDeliverGiftTips instanceof MessageForTroopGift))
    {
      paramMsg = (MessageForTroopGift)paramMessageForDeliverGiftTips;
      paramMsg.bagId = paramDeliverGiftMsg.bytes_to_all_gift_id.get().toStringUtf8();
      paramMsg.title = paramDeliverGiftMsg.bytes_stmessage_title.get().toStringUtf8();
      paramMsg.subtitle = paramDeliverGiftMsg.bytes_stmessage_subtitle.get().toStringUtf8();
      paramMsg.message = paramDeliverGiftMsg.bytes_stmessage_message.get().toStringUtf8();
      paramMsg.giftPicId = paramDeliverGiftMsg.uint32_stmessage_giftpicid.get();
      paramMsg.comefrom = paramDeliverGiftMsg.bytes_stmessage_comefrom.get().toStringUtf8();
      paramMsg.exflag = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
      if (paramDeliverGiftMsg.bytes_stmessage_gifturl.has()) {
        paramMsg.giftUrl = paramDeliverGiftMsg.bytes_stmessage_gifturl.get().toStringUtf8();
      }
    }
    if (TextUtils.isEmpty(paramMessageForDeliverGiftTips.summary)) {
      paramMessageForDeliverGiftTips.summary = paramMessageForDeliverGiftTips.msg;
    }
    if (paramMessageForDeliverGiftTips.grayTipsEntity.highlightNum != 0) {
      bfdz.a(paramMessageForDeliverGiftTips, paramMessageForDeliverGiftTips.grayTipsEntity.highlightItems);
    }
    if ((paramMessageForDeliverGiftTips instanceof MessageForTroopGift)) {
      ((MessageForTroopGift)paramMessageForDeliverGiftTips).prewrite();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin().equals(paramMessageForDeliverGiftTips.receiverUin + ""))) {
      if (paramMessageForDeliverGiftTips.remindBrief != null) {
        paramMessageForDeliverGiftTips.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramMessageForDeliverGiftTips.remindBrief.split("#")[0]);
      }
    }
    for (;;)
    {
      paramList.add(paramMessageForDeliverGiftTips);
      return;
      if ((paramMessageForDeliverGiftTips.remindBrief != null) && (paramMessageForDeliverGiftTips.remindBrief.split("#").length > 1)) {
        paramMessageForDeliverGiftTips.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramMessageForDeliverGiftTips.remindBrief.split("#")[1]);
      }
    }
  }
  
  private void a(im_msg_body.Elem paramElem, im_msg_body.NotOnlineImage paramNotOnlineImage, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    BaseApplication.getContext().getString(2131694223);
    boolean bool;
    if (paramNotOnlineImage != null) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("flash", 2, "parsePBMsgElems_OfflineMsg hasComFlashPic=" + bool);
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:NotOnlineImage;\n hasComFlashPic=" + bool);
      }
      int i = 0;
      if (paramNotOnlineImage == null)
      {
        QLog.d("flash", 2, "offlineImg null");
        return;
        if (paramElem != null)
        {
          paramNotOnlineImage = (im_msg_body.NotOnlineImage)paramElem.not_online_image.get();
          bool = false;
        }
      }
      else
      {
        int j;
        if (paramNotOnlineImage != null)
        {
          j = paramNotOnlineImage.file_len.get();
          i = paramNotOnlineImage.img_type.get();
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] file_len=" + j);
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] imgType=" + i);
          }
          paramNotOnlineImage.flag.get().toByteArray();
          String str1 = paramNotOnlineImage.str_thumb_url.get();
          String str2 = paramNotOnlineImage.str_400_url.get();
          int i1 = paramNotOnlineImage.uint32_thumb_width.get();
          int i2 = paramNotOnlineImage.uint32_thumb_height.get();
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "[NotOnlineImage] ThumbWidth=" + i1 + ",ThumbHeight=" + i2);
          }
          if (paramNotOnlineImage.uint32_file_id.has()) {}
          for (int k = paramNotOnlineImage.uint32_file_id.get();; k = 0)
          {
            String str3 = paramNotOnlineImage.str_big_url.get();
            String str4 = paramNotOnlineImage.str_orig_url.get();
            int i3 = paramNotOnlineImage.pic_width.get();
            int i4 = paramNotOnlineImage.pic_height.get();
            int m = paramNotOnlineImage.uint32_show_len.get();
            int n = paramNotOnlineImage.uint32_download_len.get();
            if (QLog.isDevelopLevel()) {
              QLog.d("peak_pgjpeg", 4, "MessageProtoCodec.decodePBMsgElems(): showLen " + m + ", downloadLen " + n + ", fileLen " + j);
            }
            int i5 = paramNotOnlineImage.original.get();
            if (paramNotOnlineImage.res_id.has()) {
              paramElem = paramNotOnlineImage.res_id.get().toStringUtf8();
            }
            for (;;)
            {
              Object localObject1;
              if ((paramElem != null) && (!paramElem.equals("")))
              {
                localObject1 = "";
                paramMsg = (msg_comm.Msg)localObject1;
                if (paramNotOnlineImage.pic_md5.has())
                {
                  localObject2 = paramNotOnlineImage.pic_md5.get().toByteArray();
                  paramMsg = (msg_comm.Msg)localObject1;
                  if (localObject2 != null)
                  {
                    paramMsg = (msg_comm.Msg)localObject1;
                    if (localObject2.length > 0) {
                      paramMsg = HexUtil.bytes2HexStr((byte[])localObject2);
                    }
                  }
                }
                Object localObject2 = TransfileUtile.makeTransFileProtocolData(paramElem, j, 1, false, paramElem, paramMsg, "picplatform", str1, str2, str3, str4, i5, 0);
                localObject1 = new RichMsg.PicRec();
                ((RichMsg.PicRec)localObject1).localPath.set(paramElem);
                ((RichMsg.PicRec)localObject1).size.set(j);
                ((RichMsg.PicRec)localObject1).type.set(1);
                ((RichMsg.PicRec)localObject1).isRead.set(false);
                ((RichMsg.PicRec)localObject1).uuid.set(paramElem);
                ((RichMsg.PicRec)localObject1).md5.set(paramMsg);
                ((RichMsg.PicRec)localObject1).serverStorageSource.set("picplatform");
                ((RichMsg.PicRec)localObject1).thumbMsgUrl.set(str1);
                ((RichMsg.PicRec)localObject1).bigthumbMsgUrl.set(str2);
                ((RichMsg.PicRec)localObject1).uint32_thumb_width.set(i1);
                ((RichMsg.PicRec)localObject1).uint32_thumb_height.set(i2);
                ((RichMsg.PicRec)localObject1).uint32_width.set(i3);
                ((RichMsg.PicRec)localObject1).uint32_height.set(i4);
                if (paramNotOnlineImage.uint32_file_id.has()) {
                  ((RichMsg.PicRec)localObject1).groupFileID.set(k);
                }
                ((RichMsg.PicRec)localObject1).bigMsgUrl.set(str3);
                ((RichMsg.PicRec)localObject1).rawMsgUrl.set(str4);
                ((RichMsg.PicRec)localObject1).fileSizeFlag.set(i5);
                ((RichMsg.PicRec)localObject1).uiOperatorFlag.set(0);
                ((RichMsg.PicRec)localObject1).version.set(5);
                ((RichMsg.PicRec)localObject1).isReport.set(0);
                if (QLog.isColorLevel()) {
                  paramStringBuilder.append("content:").append((String)localObject2).append("\n");
                }
                if (i5 != 1) {
                  break label1195;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("DecodeMsg", 2, "[NotOnlineImage] showLen =" + m + ",downloadLen = " + n + ",raw photo msg,clear progressjpg info!");
                }
                k = 0;
                j = 0;
              }
              for (;;)
              {
                ((RichMsg.PicRec)localObject1).uint32_show_len.set(k);
                ((RichMsg.PicRec)localObject1).uint32_download_len.set(j);
                ((RichMsg.PicRec)localObject1).uint32_image_type.set(i);
                if (paramNotOnlineImage.bytes_pb_reserve.has()) {
                  ((RichMsg.PicRec)localObject1).bytes_pb_reserved.set(paramNotOnlineImage.bytes_pb_reserve.get());
                }
                paramElem = (MessageForPic)bbli.a(-2000);
                if (bool) {
                  amrp.a(paramElem, false);
                }
                paramElem.msgtype = -2000;
                paramElem.msgData = ((RichMsg.PicRec)localObject1).toByteArray();
                paramElem.parse();
                paramList.add(paramElem);
                return;
                if (!paramNotOnlineImage.download_path.has()) {
                  break label1206;
                }
                paramElem = paramNotOnlineImage.download_path.get().toStringUtf8();
                break;
                if (QLog.isColorLevel()) {
                  paramStringBuilder.append("serverPath is null or empty string : " + paramElem);
                }
                paramElem = (msg_comm.MsgHead)paramMsg.msg_head.get();
                long l1 = paramElem.msg_seq.get();
                long l2 = paramElem.msg_uid.get();
                long l3 = paramElem.msg_time.get();
                long l4 = paramElem.from_uin.get();
                long l5 = paramElem.to_uin.get();
                paramElem = new HashMap();
                paramElem.put("param_FailCode", String.valueOf(10002));
                paramElem.put("fromUin", String.valueOf(l4));
                paramElem.put("toUin", String.valueOf(l5));
                paramElem.put("msgSeq", String.valueOf(l1));
                paramElem.put("msgUid", String.valueOf(l2));
                paramElem.put("msgtime", String.valueOf(l3));
                paramNotOnlineImage = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin();
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramNotOnlineImage, "actMessageEvent", false, 0L, 0L, paramElem, "");
                return;
                label1195:
                j = n;
                k = m;
              }
              label1206:
              paramElem = null;
            }
          }
          j = 0;
        }
      }
      paramNotOnlineImage = null;
      bool = false;
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, ChatMessage paramChatMessage)
  {
    localObject2 = null;
    localObject3 = null;
    j = 0;
    localObject1 = localObject2;
    i = j;
    if (paramGeneralFlags != null)
    {
      localObject1 = localObject2;
      i = j;
      if (!paramGeneralFlags.bytes_pb_reserve.has()) {}
    }
    try
    {
      localObject1 = new generalflags.ResvAttr();
      ((generalflags.ResvAttr)localObject1).mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
      if ((!((generalflags.ResvAttr)localObject1).bytes_kpl_info.has()) || (!((generalflags.ResvAttr)localObject1).bytes_kpl_info.has())) {
        break label172;
      }
      i = 1;
      paramGeneralFlags = ((generalflags.ResvAttr)localObject1).bytes_kpl_info.get().toStringUtf8();
    }
    catch (Exception paramGeneralFlags)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
        }
        paramGeneralFlags.printStackTrace();
        localObject1 = localObject2;
        i = j;
        continue;
        i = 0;
        paramGeneralFlags = localObject3;
      }
    }
    localObject1 = paramGeneralFlags;
    if (i != 0)
    {
      paramChatMessage.saveExtInfoToExtStr("msg_ext_key", "Y");
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "resv a kpl text message !");
      }
      KplRoleInfo.handleKplFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, MessageForPubAccount paramMessageForPubAccount)
  {
    if ((paramGeneralFlags == null) || (!paramGeneralFlags.bytes_pb_reserve.has())) {}
    for (;;)
    {
      return;
      try
      {
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        localResvAttr.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        if (localResvAttr.bytes_oac_msg_extend.has())
        {
          paramMessageForPubAccount.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", localResvAttr.bytes_oac_msg_extend.get().toStringUtf8());
          return;
        }
      }
      catch (Throwable paramGeneralFlags)
      {
        QLog.e("DecodeMsg", 2, "decodePBMsgElems_TransElemInfo()-MessageForPubAccount: parse generalflags error! " + QLog.getStackTraceString(paramGeneralFlags));
      }
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, MessageForStructing paramMessageForStructing)
  {
    if ((paramGeneralFlags != null) && (paramGeneralFlags.babyq_guide_msg_cookie.has())) {}
    try
    {
      byte[] arrayOfByte = paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
      String str = bftf.a(arrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg, guideMsgCookie: " + str + " ,byte: " + Arrays.toString(paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
      }
      paramMessageForStructing.saveExtInfoToExtStr("guide_msg_cookie", str);
      ((amoa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(53)).a(arrayOfByte);
      return;
    }
    catch (Exception paramGeneralFlags)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DecodeMsg", 2, "get richmsg guideMsgCookie error!", paramGeneralFlags);
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, MessageForStructing paramMessageForStructing, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramMessageForStructing.structingMsg.sourceAccoutType != 0))
    {
      paramMessageForStructing.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
      if ((TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgBrief)) || (paramMessageForStructing.structingMsg.mEmptyMsgBriefModified)) {
        paramMessageForStructing.structingMsg.mMsgBrief = AbsStructMsg.PA_DEFAULT_MSG_BRIEF;
      }
      ajvj.a(paramGeneralFlags, paramMessageForStructing);
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, List<MessageRecord> paramList)
  {
    if ((paramGeneralFlags != null) && (paramGeneralFlags.babyq_guide_msg_cookie.has())) {}
    try
    {
      if (paramList.size() > 0)
      {
        paramList = (MessageRecord)paramList.get(0);
        byte[] arrayOfByte = paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
        String str = bftf.a(arrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "decodePBMsgElems_Pic, guideMsgCookie: " + str + " ,byte: " + Arrays.toString(paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
        }
        paramList.saveExtInfoToExtStr("guide_msg_cookie", str);
        ((amoa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(53)).a(arrayOfByte);
      }
      return;
    }
    catch (Exception paramGeneralFlags)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DecodeMsg", 2, "get pic msg guideMsgCookie error!", paramGeneralFlags);
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, boolean paramBoolean, String paramString, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi)
  {
    Object localObject = a(paramList, paramList1, false);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)bbli.a(-5008);
    localMessageForArkApp.msgtype = -5008;
    if (localObject != null) {
      localMessageForArkApp.compatibleMsg = ((String)localObject);
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {}
    try
    {
      localObject = new generalflags.ResvAttr();
      ((generalflags.ResvAttr)localObject).mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
      if (((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.has()) {
        localMessageForArkApp.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", ((generalflags.ResvAttr)localObject).bytes_oac_msg_extend.get().toStringUtf8());
      }
      if (((generalflags.ResvAttr)localObject).uint32_service_msg_type.has())
      {
        paramGeneralFlags = new JSONObject(paramString).optString("appid");
        if (!TextUtils.isEmpty(paramGeneralFlags)) {
          localMessageForArkApp.saveExtInfoToExtStr("appid", paramGeneralFlags);
        }
      }
    }
    catch (Throwable paramGeneralFlags)
    {
      for (;;)
      {
        QLog.e("DecodeMsg", 2, "decodePBMsgElems_ArkApp() parse generalflags error! " + QLog.getStackTraceString(paramGeneralFlags));
        continue;
        QLog.i("DecodeMsg", 1, "decode msg, ark message is not valid..");
      }
    }
    paramGeneralFlags = new ArkAppMessage();
    paramGeneralFlags.fromAppXml(paramString);
    localMessageForArkApp.msgData = paramGeneralFlags.toBytes();
    localMessageForArkApp.parse();
    if ((!TextUtils.isEmpty(localMessageForArkApp.ark_app_message.appName)) && (!TextUtils.isEmpty(localMessageForArkApp.ark_app_message.appView)))
    {
      paramList1.add(localMessageForArkApp);
      paramBoolean = true;
      if (!paramBoolean) {
        f(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi);
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "decodePBMsgElems, isBlessMsg: true ,updateFlag: " + paramInt);
      }
      paramChatMessage.isBlessMsg = true;
      if (paramInt > -1) {
        if ((paramInt & 0x1) != 1) {
          break label65;
        }
      }
    }
    label65:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramChatMessage.needUpdateMsgTag = paramBoolean;
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, MessageForPic paramMessageForPic)
  {
    if (paramBoolean1) {
      amtr.a(paramMessageForPic, false);
    }
    if (paramBoolean2) {
      amrp.a(paramMessageForPic, false);
    }
  }
  
  private boolean a(MessageForStructing paramMessageForStructing, im_msg_body.Elem paramElem)
  {
    Object localObject;
    if (paramElem.not_online_image.has())
    {
      localObject = (im_msg_body.NotOnlineImage)paramElem.not_online_image.get();
      paramMessageForStructing = (StructMsgForImageShare)paramMessageForStructing.structingMsg;
      paramMessageForStructing.thumbHeight = ((im_msg_body.NotOnlineImage)localObject).uint32_thumb_height.get();
      paramMessageForStructing.thumbWidth = ((im_msg_body.NotOnlineImage)localObject).uint32_thumb_width.get();
      paramMessageForStructing.width = ((im_msg_body.NotOnlineImage)localObject).pic_width.get();
      paramMessageForStructing.height = ((im_msg_body.NotOnlineImage)localObject).pic_height.get();
      paramMessageForStructing.thumbUrl = ((im_msg_body.NotOnlineImage)localObject).str_thumb_url.get();
      paramMessageForStructing.bigUrl = ((im_msg_body.NotOnlineImage)localObject).str_big_url.get();
      paramMessageForStructing.rawUrl = ((im_msg_body.NotOnlineImage)localObject).str_orig_url.get();
      if (paramElem.not_online_image.bytes_pb_reserve.has()) {}
      try
      {
        localObject = new NotOnlineImageExtPb.ResvAttr();
        ((NotOnlineImageExtPb.ResvAttr)localObject).mergeFrom(paramElem.not_online_image.bytes_pb_reserve.get().toByteArray());
        paramMessageForStructing.mImageBizType = ((NotOnlineImageExtPb.ResvAttr)localObject).uint32_image_biz_type.get();
        return true;
      }
      catch (InvalidProtocolBufferMicroException paramMessageForStructing)
      {
        for (;;)
        {
          paramMessageForStructing.printStackTrace();
        }
      }
    }
    if (paramElem.custom_face.has())
    {
      localObject = (im_msg_body.CustomFace)paramElem.custom_face.get();
      paramMessageForStructing = (StructMsgForImageShare)paramMessageForStructing.structingMsg;
      paramMessageForStructing.thumbHeight = ((im_msg_body.CustomFace)localObject).uint32_thumb_height.get();
      paramMessageForStructing.thumbWidth = ((im_msg_body.CustomFace)localObject).uint32_thumb_width.get();
      paramMessageForStructing.width = ((im_msg_body.CustomFace)localObject).uint32_width.get();
      paramMessageForStructing.height = ((im_msg_body.CustomFace)localObject).uint32_height.get();
      paramMessageForStructing.rawUrl = ((im_msg_body.CustomFace)localObject).str_orig_url.get();
      paramMessageForStructing.thumbUrl = ((im_msg_body.CustomFace)localObject).str_thumb_url.get();
      paramMessageForStructing.bigUrl = ((im_msg_body.CustomFace)localObject).str_big_url.get();
      paramMessageForStructing.rawUrl = ((im_msg_body.CustomFace)localObject).str_orig_url.get();
      if (paramElem.custom_face.bytes_pb_reserve.has()) {}
      try
      {
        localObject = new CustomFaceExtPb.ResvAttr();
        ((CustomFaceExtPb.ResvAttr)localObject).mergeFrom(paramElem.custom_face.bytes_pb_reserve.get().toByteArray());
        paramMessageForStructing.mImageBizType = ((CustomFaceExtPb.ResvAttr)localObject).uint32_image_biz_type.get();
        return true;
      }
      catch (InvalidProtocolBufferMicroException paramMessageForStructing)
      {
        for (;;)
        {
          paramMessageForStructing.printStackTrace();
        }
      }
    }
    return false;
  }
  
  private boolean a(List<im_msg_body.Elem> paramList)
  {
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((!localElem.bless_msg.has()) || (localElem.bless_msg.uint32_msg_type.get() != 1)) {
        break label59;
      }
      bool = true;
    }
    label59:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  private boolean a(List<MessageRecord> paramList, long paramLong, MessageForStructing paramMessageForStructing)
  {
    if (!(paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {}
    do
    {
      do
      {
        return false;
        Object localObject = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mWarningTips;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", (String)localObject);
        }
        if (((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).isPayMessage()) {
          paramMessageForStructing.saveExtInfoToExtStr("pa_pay_message", "1");
        }
        localObject = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mPARedPacket;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = MessageForQQWalletMsg.createQQWalletMsg((String)localObject, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin());
          if (localObject != null)
          {
            paramList.add(localObject);
            return true;
          }
        }
      } while (paramMessageForStructing.structingMsg.mMsgServiceID != 74);
      paramMessageForStructing = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mVipDonateStr;
    } while (TextUtils.isEmpty(paramMessageForStructing));
    if (String.valueOf(paramLong).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
    for (boolean bool = true;; bool = false)
    {
      paramMessageForStructing = a(paramMessageForStructing, bool);
      if (paramMessageForStructing == null) {
        break;
      }
      paramList.add(paramMessageForStructing);
      return true;
    }
  }
  
  private boolean a(List<MessageRecord> paramList, MessageForStructing paramMessageForStructing)
  {
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)bbli.a(-2054);
    localMessageForTroopSign.msgtype = -2054;
    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
    localMessageForTroopSign.structingMsg = localStructMsgForGeneralShare;
    localMessageForTroopSign.msg = localStructMsgForGeneralShare.mMsgBrief;
    localMessageForTroopSign.doPrewrite();
    paramList.add(localMessageForTroopSign);
    paramMessageForStructing.structingMsg = null;
    return true;
  }
  
  private boolean a(List<im_msg_body.Elem> paramList, MessageForStructing paramMessageForStructing, String paramString)
  {
    Object localObject2;
    Object localObject1;
    if (!StringUtil.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, new Object[] { "decodePBMsgElems_RichMsg longMsgResId=", paramString });
      }
      localObject2 = "";
      paramList = paramList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!paramList.hasNext()) {
          break;
        }
        localObject1 = (im_msg_body.Elem)paramList.next();
      } while (!((im_msg_body.Elem)localObject1).pub_acc_info.has());
      paramList = (List<im_msg_body.Elem>)localObject2;
      if (((im_msg_body.Elem)localObject1).pub_acc_info.string_long_msg_url.get() != null) {
        paramList = ((im_msg_body.Elem)localObject1).pub_acc_info.string_long_msg_url.get();
      }
      localObject2 = ((im_msg_body.Elem)localObject1).pub_acc_info.bytes_download_key.get();
      localObject1 = paramList;
      if (localObject2 == null) {
        break label197;
      }
      localObject2 = StructLongMessageDownloadProcessor.bytesToHexString(((ByteStringMicro)localObject2).toByteArray());
      localObject1 = paramList;
    }
    label197:
    for (paramList = (List<im_msg_body.Elem>)localObject2;; paramList = "")
    {
      if ((!StringUtil.isEmpty((String)localObject1)) && (!StringUtil.isEmpty(paramList)) && (!StringUtil.isEmpty(paramString)))
      {
        paramMessageForStructing.saveExtInfoToExtStr("pub_long_msg_url", (String)localObject1);
        paramMessageForStructing.saveExtInfoToExtStr("pub_long_msg_download_key", paramList);
        paramMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", paramString);
        return true;
      }
      return false;
    }
  }
  
  private boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, msg_comm.Msg paramMsg, im_msg_body.GeneralFlags paramGeneralFlags, im_msg_body.Text paramText, byte[] paramArrayOfByte, long paramLong1, MessageForStructing paramMessageForStructing, long paramLong2, int paramInt)
  {
    if (paramMessageForStructing.structingMsg == null) {
      return false;
    }
    if (a(paramList1, paramLong1, paramMessageForStructing)) {
      return true;
    }
    a(paramGeneralFlags, paramMessageForStructing, a(paramMsg));
    b(paramList, paramMessageForStructing);
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg serviceId" + paramMessageForStructing.structingMsg.mMsgServiceID);
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 37) {
      return true;
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 499) {
      return a(paramList1, paramArrayOfByte, paramMessageForStructing, paramLong2, paramInt);
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 52) {
      paramLong1 = a(paramList1, paramMsg, paramLong1, paramMessageForStructing);
    }
    do
    {
      for (;;)
      {
        a(paramLong1, paramMessageForStructing);
        paramMessageForStructing.structingMsg.mCompatibleText = a(paramList, paramList1, false);
        paramMessageForStructing.msgData = paramMessageForStructing.structingMsg.getBytes();
        return false;
        if ((paramMessageForStructing.structingMsg.mMsgServiceID == 80) && ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
        {
          if (b(paramList1, paramText, paramMessageForStructing)) {
            return true;
          }
        }
        else
        {
          if ((paramMessageForStructing.structingMsg.mMsgServiceID == 118) && ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))) {
            return a(paramList1, paramText, paramMessageForStructing);
          }
          if ((paramMessageForStructing.structingMsg.mMsgServiceID == 104) && ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))) {
            return a(paramList1, paramGeneralFlags, paramText, paramMessageForStructing, paramLong2);
          }
          if ((paramMessageForStructing.structingMsg.mMsgServiceID == 90) && ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))) {
            return a(paramList1, paramMessageForStructing);
          }
          if (((paramMessageForStructing.structingMsg.mMsgServiceID == 83) || (paramMessageForStructing.structingMsg.mMsgServiceID == 108) || (paramMessageForStructing.structingMsg.mMsgServiceID == 114) || (paramMessageForStructing.structingMsg.mMsgServiceID == 116)) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData)))
          {
            b(paramMessageForStructing);
          }
          else if (((paramMessageForStructing.structingMsg.mMsgServiceID == 5) || (paramMessageForStructing.structingMsg.mMsgServiceID == 137)) && ((paramMessageForStructing.structingMsg instanceof StructMsgForImageShare)))
          {
            a(paramList, paramMessageForStructing);
          }
          else
          {
            if (paramMessageForStructing.structingMsg.mMsgServiceID != 106) {
              break;
            }
            a(paramMessageForStructing);
          }
        }
      }
    } while (paramMessageForStructing.structingMsg.mMsgServiceID != 126);
    return a(paramList1, paramArrayOfByte, paramLong2, paramInt);
  }
  
  private boolean a(List<MessageRecord> paramList, im_msg_body.GeneralFlags paramGeneralFlags, im_msg_body.Text paramText, MessageForStructing paramMessageForStructing, long paramLong)
  {
    MessageForTroopPobing localMessageForTroopPobing = (MessageForTroopPobing)bbli.a(-2059);
    localMessageForTroopPobing.msgtype = -2059;
    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
    if ((TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText)) && (paramText != null) && (paramText.str.has())) {
      localStructMsgForGeneralShare.mCompatibleText = paramText.str.get().toStringUtf8();
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {}
    try
    {
      paramText = new generalflags.ResvAttr();
      paramText.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
      if ((paramText.uint32_troop_pobing_template.has()) && (paramText.uint32_troop_pobing_template.get() > 0)) {
        localStructMsgForGeneralShare.pobingTemplateId = paramText.uint32_troop_pobing_template.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "uint32_troop_pobing_template: " + localStructMsgForGeneralShare.pobingTemplateId);
      }
      localMessageForTroopPobing.structingMsg = localStructMsgForGeneralShare;
      localMessageForTroopPobing.doPrewrite();
      localMessageForTroopPobing.doParse();
      if (TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText))
      {
        localMessageForTroopPobing.doParse();
        localStructMsgForGeneralShare.mCompatibleText = MessageForTroopPobing.buildCompatibleText();
        localMessageForTroopPobing.doPrewrite();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + localStructMsgForGeneralShare.mCompatibleText);
        }
      }
      paramList.add(localMessageForTroopPobing);
      paramMessageForStructing.structingMsg = null;
      new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_obj").a(new String[] { paramLong + "" }).a();
      new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_welcome").a(new String[] { paramLong + "", "", "" + TroopUtils.convSfToReportParam(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong)) }).a();
      return true;
    }
    catch (InvalidProtocolBufferMicroException paramGeneralFlags)
    {
      for (;;)
      {
        QLog.e("DecodeMsg", 1, "decode uint32_troop_pobing_template fail: ", paramGeneralFlags);
      }
    }
  }
  
  private boolean a(List<MessageRecord> paramList, im_msg_body.Text paramText, MessageForStructing paramMessageForStructing)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)bbli.a(-7002);
    localMessageForTribeShortVideo.msgtype = -7002;
    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
    if ((TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText)) && (paramText != null) && (paramText.str.has())) {
      localStructMsgForGeneralShare.mCompatibleText = paramText.str.get().toStringUtf8();
    }
    localMessageForTribeShortVideo.structingMsg = localStructMsgForGeneralShare;
    localMessageForTribeShortVideo.doPrewrite();
    if (TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText))
    {
      localMessageForTribeShortVideo.doParse();
      localStructMsgForGeneralShare.mCompatibleText = MessageForTribeShortVideo.buildCompatibleText();
      localMessageForTribeShortVideo.doPrewrite();
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "recv shortVideoMsg, mCompatibleText isEmpty, rebuild:" + localStructMsgForGeneralShare.mCompatibleText);
      }
    }
    paramList.add(localMessageForTribeShortVideo);
    paramMessageForStructing.structingMsg = null;
    return true;
  }
  
  private boolean a(List<MessageRecord> paramList, byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    paramArrayOfByte = MessageForStarLeague.decodeMsgFromXmlBuff(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramInt, paramLong, paramArrayOfByte, -1);
    paramArrayOfByte.msgData = paramArrayOfByte.getBytes();
    paramArrayOfByte.msg = paramArrayOfByte.getSummaryMsg();
    paramList.add(paramArrayOfByte);
    return true;
  }
  
  private boolean a(List<MessageRecord> paramList, byte[] paramArrayOfByte, MessageForStructing paramMessageForStructing, long paramLong, int paramInt)
  {
    MessageForTroopFee localMessageForTroopFee = (MessageForTroopFee)bbli.a(-2036);
    paramArrayOfByte = MessageForTroopFee.decodeMsgFromXmlBuff(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramInt, paramLong, paramArrayOfByte, -1);
    if (paramArrayOfByte != null) {
      localMessageForTroopFee.copyFrom(paramArrayOfByte);
    }
    localMessageForTroopFee.msgtype = -2036;
    localMessageForTroopFee.msg = localMessageForTroopFee.getSummaryMsg();
    localMessageForTroopFee.msgData = localMessageForTroopFee.getBytes();
    paramList.add(localMessageForTroopFee);
    paramMessageForStructing.structingMsg = null;
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_fee", 2, "Troop Fee has decode suceess" + localMessageForTroopFee.getSummaryMsg());
    }
    return true;
  }
  
  private boolean a(msg_comm.Msg paramMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMsg.msg_head.c2c_tmp_msg_head.service_type.has())
    {
      int i = paramMsg.msg_head.c2c_tmp_msg_head.service_type.get();
      if ((i != 129) && (i != 140))
      {
        bool1 = bool2;
        if (i != 142) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(msg_comm.Msg paramMsg, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    if (!paramBoolean) {
      return false;
    }
    paramStringBuilder.append(BaseApplication.getContext().getString(2131694223));
    paramMsg = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l1 = paramMsg.msg_seq.get();
    long l2 = paramMsg.msg_uid.get();
    long l3 = paramMsg.msg_time.get();
    long l4 = paramMsg.from_uin.get();
    long l5 = paramMsg.to_uin.get();
    paramMsg = new HashMap();
    paramMsg.put("param_FailCode", String.valueOf(10001));
    paramMsg.put("fromUin", String.valueOf(l4));
    paramMsg.put("toUin", String.valueOf(l5));
    paramMsg.put("msgSeq", String.valueOf(l1));
    paramMsg.put("msgUid", String.valueOf(l2));
    paramMsg.put("msgtime", String.valueOf(l3));
    paramStringBuilder = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramStringBuilder, "actMessageEvent", false, 0L, 0L, paramMsg, "");
    if (QLog.isColorLevel()) {
      QLog.d("flash", 2, "parsePBMsgElemsCustomFace isC2C");
    }
    return true;
  }
  
  private boolean a(im_msg_body.CustomFace paramCustomFace)
  {
    boolean bool = false;
    if (paramCustomFace != null) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(im_msg_body.Elem paramElem)
  {
    boolean bool = false;
    if (paramElem != null) {
      bool = paramElem.hc_flash_pic.has();
    }
    return bool;
  }
  
  private boolean a(im_msg_body.GeneralFlags paramGeneralFlags)
  {
    if ((paramGeneralFlags != null) && (paramGeneralFlags.long_text_flag.get() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg, longTextFlag: true");
      }
      return true;
    }
    return false;
  }
  
  private byte[] a(im_msg_body.GeneralFlags paramGeneralFlags, byte[] paramArrayOfByte, MessageForStructing paramMessageForStructing, long paramLong, int paramInt, String paramString, boolean paramBoolean, bblm parambblm)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "begin getEmptyGeneralStructMsg");
      }
      paramMessageForStructing.structingMsg = ((StructMsgForGeneralShare)bchh.a());
    }
    do
    {
      return paramArrayOfByte;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
        break;
      }
    } while ((parambblm.jdField_a_of_type_Int != 1008) || (TextUtils.isEmpty(paramString)));
    if (QLog.isColorLevel()) {
      QLog.d("PaOldLongMsg", 2, "msgId=uniseq:" + paramMessageForStructing.uniseq + ", begin getEmptyGeneralStructMsg for PA oldLongMsg!");
    }
    paramMessageForStructing.structingMsg = ((StructMsgForGeneralShare)bchh.a());
    paramMessageForStructing.saveExtInfoToExtStr("pub_old_long_msg", "1");
    paramMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", paramString);
    paramMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
    return paramArrayOfByte;
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, new Object[] { "begin getStructMsgFromXmlBuff: type=", Integer.valueOf(paramInt), ", code=", Long.valueOf(paramLong) });
    }
    int i = -1;
    paramGeneralFlags = bgae.a(paramArrayOfByte, paramGeneralFlags, -1);
    if (paramGeneralFlags != null) {
      i = 0;
    }
    for (;;)
    {
      paramMessageForStructing.structingMsg = bchh.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramInt, paramLong, paramGeneralFlags, i);
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "StructMsg = " + paramMessageForStructing.structingMsg);
      }
      return paramGeneralFlags;
      paramGeneralFlags = paramArrayOfByte;
    }
  }
  
  private byte[] a(im_msg_body.RichMsg paramRichMsg)
  {
    byte[] arrayOfByte = null;
    if (paramRichMsg.bytes_template_1.has()) {
      arrayOfByte = paramRichMsg.bytes_template_1.get().toByteArray();
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte1 = new byte[1024];
      while (!localInflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte1, 0, localInflater.inflate(arrayOfByte1));
      }
      try
      {
        byte[] arrayOfByte2;
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        for (;;)
        {
          localInflater.end();
          return paramArrayOfByte;
          arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          paramArrayOfByte = arrayOfByte2;
          try
          {
            localByteArrayOutputStream.close();
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  private int b(List<im_msg_body.Elem> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((!localElem.elem_flags2.has()) || (!localElem.elem_flags2.uint32_msg_rpt_cnt.has())) {
        break label67;
      }
      i = localElem.elem_flags2.uint32_msg_rpt_cnt.get();
    }
    label67:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  @Nullable
  private String b(List<im_msg_body.Elem> paramList)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if ((!localElem.text.has()) || (!localElem.text.str.has())) {
        break label116;
      }
      paramList = localElem.text.str.get().toStringUtf8();
      if ((paramList.startsWith("[")) && (paramList.endsWith("]"))) {
        paramList = HexUtil.bytes2HexStr(localElem.text.str.get().toByteArray());
      }
    }
    label116:
    for (;;)
    {
      break;
      paramList = "";
      continue;
      return paramList;
    }
  }
  
  @Nullable
  private im_msg_body.GeneralFlags b(List<im_msg_body.Elem> paramList)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.general_flags.has()) {
        break label56;
      }
      paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
    }
    label56:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  private void b(int paramInt, ChatMessage paramChatMessage)
  {
    if (paramInt > 0)
    {
      paramChatMessage.setRepeatCount(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "MessageForText ====> repeatCount = " + paramChatMessage.getRepeatCount());
      }
    }
  }
  
  private void b(MessageForStructing paramMessageForStructing)
  {
    String str = a(paramMessageForStructing);
    odq.a(null, "", "0X8007238", "0X8007238", 0, 0, str, "", "", "");
    odq.a("0X8007238", "", str, "", "", "");
    paramMessageForStructing.structingMsg.mMsgActionData = a(paramMessageForStructing.structingMsg.mMsgActionData);
  }
  
  private void b(List<im_msg_body.Elem> paramList, MessageForStructing paramMessageForStructing)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((localElem.life_online.has()) && (((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint64_unique_id.has())) {
        paramMessageForStructing.structingMsg.msgId = ((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint64_unique_id.get();
      }
    }
  }
  
  private void b(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!paramDeliverGiftMsg.bytes_comefrom_link.has()) {
      return;
    }
    paramMessageForDeliverGiftTips.jumpUrl = paramDeliverGiftMsg.bytes_comefrom_link.get().toStringUtf8();
  }
  
  private void b(im_msg_body.GeneralFlags paramGeneralFlags, ChatMessage paramChatMessage)
  {
    if ((paramGeneralFlags != null) && (paramGeneralFlags.babyq_guide_msg_cookie.has())) {}
    try
    {
      byte[] arrayOfByte = paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
      String str = bftf.a(arrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, guideMsgCookie: " + str + ",bytes: " + Arrays.toString(paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
      }
      paramChatMessage.saveExtInfoToExtStr("guide_msg_cookie", str);
      ((amoa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(53)).a(arrayOfByte);
      return;
    }
    catch (Exception paramGeneralFlags)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DecodeMsg", 2, "get text guideMsgCookie error!", paramGeneralFlags);
    }
  }
  
  private void b(im_msg_body.GeneralFlags paramGeneralFlags, List<MessageRecord> paramList)
  {
    Object localObject = null;
    int i = 0;
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {}
    for (;;)
    {
      try
      {
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        localResvAttr.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        if ((!localResvAttr.bytes_kpl_info.has()) || (!localResvAttr.bytes_kpl_info.has())) {
          break label176;
        }
        int j = 1;
        paramGeneralFlags = localResvAttr.bytes_kpl_info.get().toStringUtf8();
        i = j;
      }
      catch (Exception paramGeneralFlags)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
        paramGeneralFlags.printStackTrace();
        paramGeneralFlags = null;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("KplMessage", 2, "resv a kpl pic message !");
        KplRoleInfo.handleKplFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramGeneralFlags);
      }
      if (i != 0)
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          ((MessageRecord)paramList.next()).saveExtInfoToExtStr("msg_ext_key", "Y");
          continue;
        }
      }
      return;
      label176:
      i = 0;
      paramGeneralFlags = localObject;
      continue;
      paramGeneralFlags = null;
    }
  }
  
  private boolean b(List<MessageRecord> paramList, im_msg_body.Text paramText, MessageForStructing paramMessageForStructing)
  {
    if (vla.i())
    {
      MessageForQQStory localMessageForQQStory = (MessageForQQStory)bbli.a(-2051);
      localMessageForQQStory.msgtype = -2051;
      StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      if ((TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText)) && (paramText != null) && (paramText.str.has())) {
        localStructMsgForGeneralShare.mCompatibleText = paramText.str.get().toStringUtf8();
      }
      localMessageForQQStory.structingMsg = localStructMsgForGeneralShare;
      localMessageForQQStory.doPrewrite();
      if (TextUtils.isEmpty(localStructMsgForGeneralShare.mCompatibleText))
      {
        localMessageForQQStory.doParse();
        localStructMsgForGeneralShare.mCompatibleText = MessageForQQStory.buildCompatibleText(localMessageForQQStory.authorName, localMessageForQQStory.brief, localMessageForQQStory.srcName);
        localMessageForQQStory.doPrewrite();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + localStructMsgForGeneralShare.mCompatibleText);
        }
      }
      paramList.add(localMessageForQQStory);
      paramMessageForStructing.structingMsg = null;
      return true;
    }
    paramMessageForStructing.structingMsg = null;
    if (paramText != null)
    {
      paramText.str.set(ByteStringMicro.copyFromUtf8(vla.a()));
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "recv storyMsg, isSDKAPISupportStory==false, txtMsg==null");
    }
    return false;
  }
  
  private boolean b(im_msg_body.GeneralFlags paramGeneralFlags)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramGeneralFlags != null) {
      if (paramGeneralFlags.long_text_flag.get() != 2)
      {
        bool1 = bool2;
        if (paramGeneralFlags.long_text_flag.get() != 1) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, longTextFlag: true");
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int c(List<im_msg_body.Elem> paramList)
  {
    paramList = paramList.iterator();
    int i = -1;
    if (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((!localElem.bless_msg.has()) || (localElem.bless_msg.uint32_msg_type.get() != 1) || (!localElem.bless_msg.uint32_ex_flag.has())) {
        break label81;
      }
      i = localElem.bless_msg.uint32_ex_flag.get();
    }
    label81:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  @Nullable
  private im_msg_body.GeneralFlags c(List<im_msg_body.Elem> paramList)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.general_flags.has()) {
        break label56;
      }
      paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
    }
    label56:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  private void c(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (paramDeliverGiftMsg.bytes_receiver_pic.has()) {
      paramMessageForDeliverGiftTips.receiverHead = paramDeliverGiftMsg.bytes_receiver_pic.get().toStringUtf8();
    }
  }
  
  @Nullable
  private im_msg_body.GeneralFlags d(List<im_msg_body.Elem> paramList)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.general_flags.has()) {
        break label56;
      }
      paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
    }
    label56:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  private void d(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!paramDeliverGiftMsg.bytes_receiver_name.has()) {
      return;
    }
    paramMessageForDeliverGiftTips.receiverName = paramDeliverGiftMsg.bytes_receiver_name.get().toStringUtf8();
  }
  
  private void e(im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!paramDeliverGiftMsg.bytes_pb_reserve.has()) {
      return;
    }
    ResvAttrForGiftMsg.ResvAttr localResvAttr = new ResvAttrForGiftMsg.ResvAttr();
    for (;;)
    {
      try
      {
        localResvAttr.mergeFrom(paramDeliverGiftMsg.bytes_pb_reserve.get().toByteArray());
        paramMessageForDeliverGiftTips.sendScore = localResvAttr.int32_send_score.get();
        paramMessageForDeliverGiftTips.recvScore = localResvAttr.int32_recv_score.get();
        if (localResvAttr.bytes_charm_heroism.has()) {
          paramMessageForDeliverGiftTips.charmHeroism = localResvAttr.bytes_charm_heroism.get().toStringUtf8();
        }
        paramMessageForDeliverGiftTips.btFlag = localResvAttr.uint32_button_flag.get();
        paramMessageForDeliverGiftTips.objColor = localResvAttr.uint32_obj_color.get();
        if (localResvAttr.activity_gift_info.has())
        {
          paramDeliverGiftMsg = (ResvAttrForGiftMsg.ActivityGiftInfo)localResvAttr.activity_gift_info.get();
          paramMessageForDeliverGiftTips.is_activity_gift = paramDeliverGiftMsg.is_activity_gift.get();
          paramMessageForDeliverGiftTips.activity_text_color = paramDeliverGiftMsg.text_color.get();
          paramMessageForDeliverGiftTips.activity_text = paramDeliverGiftMsg.text.get();
          paramMessageForDeliverGiftTips.activity_url = paramDeliverGiftMsg.url.get();
          paramMessageForDeliverGiftTips.animationType = localResvAttr.uint32_animation_type.get();
          if (!localResvAttr.msg_interact_gift.has()) {
            break;
          }
          paramMessageForDeliverGiftTips.interactId = localResvAttr.msg_interact_gift.bytes_interact_id.get().toStringUtf8();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramDeliverGiftMsg)
      {
        paramDeliverGiftMsg.printStackTrace();
        return;
      }
      paramMessageForDeliverGiftTips.is_activity_gift = 0;
    }
  }
  
  public bblc a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder, long paramLong, bdyi parambdyi)
  {
    bblc localbblc = new bblc(this);
    localbblc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = a(paramList, paramStringBuilder);
    bble localbble = new bble();
    Object localObject = localbble.jdField_a_of_type_JavaUtilArrayList;
    StringBuilder localStringBuilder = a(null, paramList, paramStringBuilder, paramLong, parambdyi, localbble, null);
    if ((localObject != null) && (((ArrayList)localObject).size() == 2)) {
      if (((ArrayList)localObject).get(0) != null)
      {
        paramList = (MessageForText.AtTroopMemberInfo)((ArrayList)localObject).get(0);
        paramStringBuilder = paramList;
        if (((ArrayList)localObject).get(1) != null) {
          localbblc.jdField_a_of_type_ArrayOfByte = ((byte[])((ArrayList)localObject).get(1));
        }
      }
    }
    for (paramStringBuilder = paramList;; paramStringBuilder = null)
    {
      int i;
      if ((localStringBuilder.length() > 0) && (localbblc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null))
      {
        localbblc.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        if ((TextUtils.isEmpty(localbblc.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName)) && (paramStringBuilder != null) && (!TextUtils.isEmpty(localbblc.jdField_a_of_type_JavaLangString)) && (localbblc.jdField_a_of_type_JavaLangString.length() >= paramStringBuilder.textLen + paramStringBuilder.startPos))
        {
          localbblc.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo = paramStringBuilder;
          localObject = localbblc.jdField_a_of_type_JavaLangString;
          localbblc.jdField_a_of_type_JavaLangString = "";
          if (paramStringBuilder.startPos > 0) {
            localbblc.jdField_a_of_type_JavaLangString = ((String)localObject).substring(0, paramStringBuilder.startPos);
          }
          paramList = "";
          i = paramStringBuilder.startPos + paramStringBuilder.textLen;
          if (i + 1 < ((String)localObject).length()) {
            paramList = ((String)localObject).substring(i, i + 1);
          }
          if (!paramList.equals(" ")) {
            break label381;
          }
        }
      }
      label381:
      for (localbblc.jdField_a_of_type_JavaLangString += ((String)localObject).substring(i + 1);; localbblc.jdField_a_of_type_JavaLangString += ((String)localObject).substring(i))
      {
        localbblc.b = ((String)localObject).substring(paramStringBuilder.startPos, paramStringBuilder.startPos + paramStringBuilder.textLen);
        if ((paramStringBuilder.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin())) && (localbble.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo == null)) {
          parambdyi.jdField_a_of_type_Bdyj.b(24, -1L);
        }
        return localbblc;
      }
      paramList = null;
      break;
    }
  }
  
  public MarkFaceMessage a(im_msg_body.Elem paramElem, List<MessageRecord> paramList, StringBuilder paramStringBuilder, long paramLong)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketFace;\n");
    }
    im_msg_body.MarketFace localMarketFace = (im_msg_body.MarketFace)paramElem.market_face.get();
    if (localMarketFace != null)
    {
      paramElem = new MarkFaceMessage();
      paramElem.cFaceInfo = localMarketFace.uint32_face_info.get();
      paramElem.index = 0L;
      paramElem.cSubType = localMarketFace.uint32_sub_type.get();
      paramElem.dwMSGItemType = localMarketFace.uint32_item_type.get();
      paramElem.dwTabID = localMarketFace.uint32_tab_id.get();
      paramElem.sbfKey = localMarketFace.bytes_key.get().toByteArray();
      paramElem.sbufID = localMarketFace.bytes_face_id.get().toByteArray();
      paramElem.mediaType = localMarketFace.uint32_media_type.get();
      paramElem.imageWidth = 200;
      paramElem.imageHeight = 200;
      paramElem.mobileparam = localMarketFace.bytes_mobileparam.get().toByteArray();
      MarketFaceExtPb.ResvAttr localResvAttr;
      if (localMarketFace.bytes_pb_reserve.has())
      {
        paramElem.resvAttr = localMarketFace.bytes_pb_reserve.get().toByteArray();
        localResvAttr = new MarketFaceExtPb.ResvAttr();
      }
      try
      {
        localResvAttr.mergeFrom(paramElem.resvAttr);
        paramElem.copywritingType = localResvAttr.uint32_source_type.get();
        paramElem.copywritingContent = localResvAttr.str_source_name.get();
        paramElem.jumpUrl = localResvAttr.str_source_jump_url.get();
        paramElem.beginTime = localResvAttr.uint32_start_time.get();
        paramElem.endTime = localResvAttr.uint32_end_time.get();
        paramElem.from = localResvAttr.str_source_type_name.get();
        if (localResvAttr.uint32_emoji_type.get() != 2) {
          break label599;
        }
        bool = true;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        try
        {
          for (;;)
          {
            paramStringBuilder.msgData = anwz.a(paramElem);
            paramList.add(paramStringBuilder);
            return paramElem;
            boolean bool = false;
            continue;
            bool = false;
            continue;
            localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
            QLog.e("DecodeMsg", 1, "mergeFrom resvAttr error e = " + localInvalidProtocolBufferMicroException);
          }
          paramElem.faceName = paramStringBuilder;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      paramElem.isAPNG = bool;
      if (localResvAttr.uint32_has_ip_product.get() == 1)
      {
        bool = true;
        paramElem.hasIpProduct = bool;
        if (localResvAttr.uint32_voice_item_height_arr.has()) {
          paramElem.voicePrintItems = localResvAttr.uint32_voice_item_height_arr.get();
        }
        if (localResvAttr.str_back_color.has()) {
          paramElem.backColor = localResvAttr.str_back_color.get();
        }
        if (localResvAttr.str_volume_color.has()) {
          paramElem.volumeColor = localResvAttr.str_volume_color.get();
        }
        if (QLog.isColorLevel()) {
          paramStringBuilder.append(" mediaType = ").append(paramElem.mediaType).append("\n");
        }
        if (localMarketFace.bytes_face_name.has())
        {
          paramStringBuilder = localMarketFace.bytes_face_name.get().toStringUtf8();
          if ((TextUtils.isEmpty(paramStringBuilder)) || (paramStringBuilder.length() <= 1) || (paramStringBuilder.charAt(0) != '[') || (paramStringBuilder.charAt(paramStringBuilder.length() - 1) != ']')) {
            break label643;
          }
          paramElem.faceName = paramStringBuilder.substring(1, paramStringBuilder.length() - 1);
        }
        paramStringBuilder = (MessageForMarketFace)bbli.a(-2007);
        paramStringBuilder.msgtype = -2007;
        paramStringBuilder.msg = "it is marketface";
        paramStringBuilder.mMarkFaceMessage = paramElem;
        if ((paramElem.mobileparam != null) && (paramElem.mobileparam.length > 0)) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, "CliOper", "", "", "MbJieshou", "MbXiaoxi", 0, 0, "", "", "", "");
        }
      }
    }
    label599:
    return null;
  }
  
  public MessageForReplyText.SourceMsgInfo a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder)
  {
    im_msg_body.Elem localElem = null;
    Iterator localIterator = paramList.iterator();
    paramList = null;
    Object localObject;
    if (localIterator.hasNext())
    {
      localObject = (im_msg_body.Elem)localIterator.next();
      if (((im_msg_body.Elem)localObject).src_msg.has())
      {
        localObject = (im_msg_body.SourceMsg)((im_msg_body.Elem)localObject).src_msg.get();
        paramList = (List<im_msg_body.Elem>)localObject;
        if (((im_msg_body.SourceMsg)localObject).bytes_src_msg.has()) {
          paramList = (List<im_msg_body.Elem>)localObject;
        }
      }
    }
    for (;;)
    {
      localObject = localElem;
      if (paramList != null)
      {
        localObject = localElem;
        if (paramList.elems.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:SrcMsg;\n");
          }
          paramStringBuilder = paramList.elems.get();
          localObject = new MessageForReplyText.SourceMsgInfo();
          ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgSeq = ((Integer)paramList.uint32_orig_seqs.get(0)).intValue();
          ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgText = a(paramStringBuilder);
          ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgTime = paramList.uint32_time.get();
          ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgSenderUin = paramList.uint64_sender_uin.get();
          if (paramList.bytes_troop_name.has()) {}
          for (((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgTroopName = paramList.bytes_troop_name.get().toStringUtf8();; ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgTroopName = null)
          {
            ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgToUin = paramList.uint64_to_uin.get();
            ((MessageForReplyText.SourceMsgInfo)localObject).mSourceSummaryFlag = paramList.uint32_flag.get();
            paramStringBuilder = paramStringBuilder.iterator();
            while (paramStringBuilder.hasNext())
            {
              localElem = (im_msg_body.Elem)paramStringBuilder.next();
              if (localElem.anon_group_msg.has()) {
                ((MessageForReplyText.SourceMsgInfo)localObject).mAnonymousNickName = ((im_msg_body.AnonymousGroupMsg)localElem.anon_group_msg.get()).str_anon_nick.get().toStringUtf8();
              }
            }
            break;
          }
          if (paramList.uint32_type.has()) {
            ((MessageForReplyText.SourceMsgInfo)localObject).mType = paramList.uint32_type.get();
          }
          if (paramList.bytes_richMsg.has()) {
            ((MessageForReplyText.SourceMsgInfo)localObject).mRichMsg = paramList.bytes_richMsg.get().toStringUtf8();
          }
          if (paramList.bytes_pb_reserve.has()) {
            paramStringBuilder = new source_msg.ResvAttr();
          }
        }
      }
      try
      {
        paramStringBuilder.mergeFrom(paramList.bytes_pb_reserve.get().toByteArray());
        if (paramStringBuilder.uint32_ori_msgtype.has()) {
          ((MessageForReplyText.SourceMsgInfo)localObject).oriMsgType = paramStringBuilder.uint32_ori_msgtype.get();
        }
        if ((paramStringBuilder.uint64_orig_uids.has()) && (!paramStringBuilder.uint64_orig_uids.isEmpty())) {
          ((MessageForReplyText.SourceMsgInfo)localObject).origUid = ((Long)paramStringBuilder.uint64_orig_uids.get(0)).longValue();
        }
      }
      catch (InvalidProtocolBufferMicroException paramStringBuilder)
      {
        for (;;)
        {
          paramStringBuilder.printStackTrace();
        }
      }
      if (paramList.bytes_src_msg.has()) {
        ((MessageForReplyText.SourceMsgInfo)localObject).setSourceMsgByte(paramList.bytes_src_msg.get().toByteArray());
      }
      return localObject;
    }
  }
  
  public String a(List<im_msg_body.Elem> paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    StringBuilder localStringBuilder2 = new StringBuilder("<---decodePbElems:");
    int i = 0;
    int k = paramList.size();
    int j = 0;
    if (j < k)
    {
      Object localObject = (im_msg_body.Elem)paramList.get(j);
      if (((im_msg_body.Elem)localObject).text.has()) {
        if (i != 0) {
          i = 0;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        if (QLog.isColorLevel()) {
          localStringBuilder2.append("elemType:Text;\n");
        }
        localStringBuilder1.length();
        localObject = (im_msg_body.Text)((im_msg_body.Elem)localObject).text.get();
        if (((im_msg_body.Text)localObject).str.has()) {
          localStringBuilder1.append(bblk.a(((im_msg_body.Text)localObject).str.get().toStringUtf8(), false));
        }
        continue;
        int m;
        if (((im_msg_body.Elem)localObject).face.has())
        {
          if (QLog.isColorLevel()) {
            localStringBuilder2.append("elemType:Face;\n");
          }
          if (((im_msg_body.Face)((im_msg_body.Elem)localObject).face.get()).index.has())
          {
            m = QQSysFaceUtil.convertToLocal(((im_msg_body.Face)((im_msg_body.Elem)localObject).face.get()).index.get());
            if (m >= 0)
            {
              localStringBuilder1.append('\024');
              localStringBuilder1.append((char)m);
            }
          }
        }
        else if (((im_msg_body.Elem)localObject).small_emoji.has())
        {
          if (QLog.isColorLevel()) {
            localStringBuilder2.append("elemType:small_emoji;\n");
          }
          if (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.has())
          {
            i = (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
            m = 0xFFFF & ((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).packIdSum.get();
            char[] arrayOfChar = aqyy.a(i, m);
            if ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).imageType.has()) && ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject).small_emoji.get()).imageType.get() & 0xFFFF) == 2))
            {
              arrayOfChar[3] = 'ǿ';
              if (QLog.isColorLevel()) {
                QLog.d("DecodeMsg", 2, "get apng epid = " + i + " eid = " + m);
              }
            }
            localStringBuilder1.append('\024');
            localStringBuilder1.append(arrayOfChar[3]);
            localStringBuilder1.append(arrayOfChar[2]);
            localStringBuilder1.append(arrayOfChar[1]);
            localStringBuilder1.append(arrayOfChar[0]);
            i = 1;
          }
        }
        else if ((((im_msg_body.Elem)localObject).common_elem.has()) && (33 == ((im_msg_body.Elem)localObject).common_elem.uint32_service_type.get()))
        {
          if (QLog.isColorLevel()) {
            localStringBuilder2.append("elemType:NewSysFaceMsg;\n");
          }
          localStringBuilder1.append(a((im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get()));
        }
      }
    }
    return localStringBuilder1.toString();
  }
  
  public String a(im_msg_body.CommonElem paramCommonElem)
  {
    String str = "";
    Object localObject = str;
    if (paramCommonElem != null)
    {
      localObject = str;
      if (!paramCommonElem.bytes_pb_elem.has()) {}
    }
    try
    {
      localObject = new hummer_commelem.MsgElemInfo_servtype33();
      ((hummer_commelem.MsgElemInfo_servtype33)localObject).mergeFrom(paramCommonElem.bytes_pb_elem.get().toByteArray());
      if (((hummer_commelem.MsgElemInfo_servtype33)localObject).bytes_text.has()) {
        ((hummer_commelem.MsgElemInfo_servtype33)localObject).bytes_text.get().toStringUtf8();
      }
      int i = QQSysFaceUtil.convertToLocal(((hummer_commelem.MsgElemInfo_servtype33)localObject).uint32_index.get());
      localObject = str;
      if (i >= 0) {
        localObject = QQSysFaceUtil.getFaceString(i);
      }
      return localObject;
    }
    catch (InvalidProtocolBufferMicroException paramCommonElem)
    {
      paramCommonElem.printStackTrace();
    }
    return "";
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    Object localObject1 = null;
    Object localObject2 = paramList.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!localElem.market_trans.has()) {
        break label328;
      }
      localObject1 = (im_msg_body.MarketTrans)localElem.market_trans.get();
    }
    label328:
    for (;;)
    {
      break;
      if (localObject1 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:MarketTrans;\n");
      }
      int i = ((im_msg_body.MarketTrans)localObject1).int32_flag.get();
      localObject1 = bchh.a(((im_msg_body.MarketTrans)localObject1).bytes_xml.get().toByteArray(), i);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("c2cMsgContent.data:null;\n");
        }
        a(paramList, paramList1, true);
        return;
      }
      paramStringBuilder = paramList.iterator();
      while (paramStringBuilder.hasNext())
      {
        localObject2 = (im_msg_body.Elem)paramStringBuilder.next();
        if ((((im_msg_body.Elem)localObject2).life_online.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.has())) {
          ((AbsStructMsg)localObject1).msgId = ((im_msg_body.LifeOnlineAccount)((im_msg_body.Elem)localObject2).life_online.get()).uint64_unique_id.get();
        }
      }
      paramList = a(paramList, paramList1, false);
      if (paramList != null) {
        ((AbsStructMsg)localObject1).mCompatibleText = paramList;
      }
      paramList = (MessageForStructing)bbli.a(-2011);
      paramList.msgtype = -2011;
      paramList.msg = "MarketTrans";
      paramList.structingMsg = ((AbsStructMsg)localObject1);
      paramList.msgData = paramList.structingMsg.getBytes();
      paramList1.add(paramList);
      return;
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    im_msg_body.TransElem localTransElem = a(paramList);
    im_msg_body.GeneralFlags localGeneralFlags = c(paramList);
    if (localTransElem == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:TransElemInfo;\n");
    }
    int i = localTransElem.elem_type.get();
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("transElemType:").append(i).append(";\n");
    }
    byte[] arrayOfByte = localTransElem.elem_value.get().toByteArray();
    if (arrayOfByte.length == 0)
    {
      paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
      return;
    }
    a(paramList, paramList1, paramMsg, localTransElem, localGeneralFlags, i, arrayOfByte);
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi)
  {
    im_msg_body.CommonElem localCommonElem = a(paramList);
    String str = a(paramList);
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "decodePBMsgElems_FlashChat  common_lem" + localCommonElem + ", text " + str);
    }
    if (localCommonElem == null) {
      return;
    }
    int i = a(localCommonElem);
    hummer_commelem.MsgElemInfo_servtype14 localMsgElemInfo_servtype14 = new hummer_commelem.MsgElemInfo_servtype14();
    try
    {
      localMsgElemInfo_servtype14.mergeFrom(localCommonElem.bytes_pb_elem.get().toByteArray());
      a(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi, str, i, localMsgElemInfo_servtype14);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi, boolean paramBoolean)
  {
    int i = 0;
    im_msg_body.Elem localElem = null;
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:MarketFace;\n");
    }
    Iterator localIterator = paramList.iterator();
    paramList = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.market_face.has())
      {
        if (!localArrayList.isEmpty())
        {
          b(localArrayList, paramList1, paramStringBuilder, paramMsg, parambdyi, paramBoolean);
          localArrayList.clear();
        }
        paramList = a(localElem, paramList1, paramStringBuilder, ((im_msg_body.Attr)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).attr.get()).time.get());
        i = 1;
      }
      for (;;)
      {
        for (;;)
        {
          break;
          if ((i != 0) && (localElem.text.has()) && (paramList != null))
          {
            paramList.faceName = ((im_msg_body.Text)localElem.text.get()).str.get().toStringUtf8();
            if ((paramList.faceName.charAt(0) == '[') && (paramList.faceName.charAt(paramList.faceName.length() - 1) == ']')) {
              paramList.faceName = paramList.faceName.substring(1, paramList.faceName.length() - 1);
            }
            try
            {
              ((MessageRecord)paramList1.get(paramList1.size() - 1)).msgData = anwz.a(paramList);
              if (QLog.isColorLevel()) {
                paramStringBuilder.append("filter the text expalin:").append(((im_msg_body.Text)localElem.text.get()).str.get()).append("\n");
              }
              i = 0;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("MessageForMarketFace", 1, "decodePBMsgElems_MarketFace: ", localException);
              }
            }
          }
        }
        localArrayList.add(localElem);
      }
    }
    if (!localArrayList.isEmpty())
    {
      b(localArrayList, paramList1, paramStringBuilder, paramMsg, parambdyi, paramBoolean);
      localArrayList.clear();
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)localIterator.next();
    } while (!paramList.hc_flash_pic.has());
    for (;;)
    {
      if (paramList == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:FlashPic;\n");
      }
      a(paramList, null, paramList1, paramStringBuilder, paramMsg, paramBoolean);
      return;
      paramList = null;
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramStringBuilder = (im_msg_body.Elem)paramList.next();
    } while (!paramStringBuilder.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)paramStringBuilder.common_elem.get();; paramList = null)
    {
      if (paramList == null) {}
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "QQ 18 Parse msg found common_lem elemType = UpdateStrangerAvatar;\n");
        }
        paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype13();
        try
        {
          paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          if ((paramStringBuilder.uint32_sys_head_id.has()) && (paramStringBuilder.uint32_head_flag.has()))
          {
            int i = paramStringBuilder.uint32_sys_head_id.get();
            int j = paramStringBuilder.uint32_head_flag.get();
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "QQ 18 elemType:UpdateStrangerAvatar system id = " + i + ", headType = " + j);
            }
            long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
            paramList = (anwp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(199);
            if ((paramList != null) && (paramList.a()))
            {
              paramList.a(String.valueOf(l), i, j);
              return;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
      }
    }
  }
  
  public void a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    a(paramElem, paramCustomFace, paramList, paramStringBuilder, paramMsg, paramBoolean, null);
  }
  
  public void a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean, bdyi parambdyi)
  {
    boolean bool2 = a(paramElem);
    boolean bool3 = a(paramCustomFace);
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:CustomFace: isC2C:").append(paramBoolean).append(";\n");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (a(paramMsg, paramBoolean, localStringBuilder)) {
      return;
    }
    a(paramList, bool2, bool3, localStringBuilder);
    paramCustomFace = a(paramElem, paramCustomFace, bool2);
    if (QLog.isColorLevel()) {
      QLog.d("flash", 2, "parsePBMsgElemsCustomFace hasComFlashPic=" + bool3);
    }
    if (paramCustomFace == null)
    {
      QLog.d("DecodeMsg", 2, "parsePBMsgElemsCustomFace customface is null");
      return;
    }
    paramElem = paramCustomFace.str_file_path.get();
    String str1 = paramCustomFace.str_big_url.get();
    String str2 = paramCustomFace.str_orig_url.get();
    String str3 = paramCustomFace.str_thumb_url.get();
    String str4 = paramCustomFace.str_400_url.get();
    int m = paramCustomFace.uint32_thumb_width.get();
    int n = paramCustomFace.uint32_thumb_height.get();
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "[CustomFace] ThumbWidth=" + m + ",ThumbHeight=" + n + "downURLBigThum400=" + str4);
    }
    int j = paramCustomFace.uint32_show_len.get();
    int i = paramCustomFace.uint32_download_len.get();
    long l1 = paramCustomFace.uint32_file_id.get();
    long l2 = paramCustomFace.uint32_size.get() & 0xFFFFFFFF;
    int k = paramCustomFace.image_type.get();
    if (QLog.isColorLevel())
    {
      QLog.d("DecodeMsg", 2, "[CustomFace] uint32_size=" + l2);
      QLog.d("DecodeMsg", 2, "[CustomFace] imgType=" + k);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "MessageProtoCodec.decodePBMsgElems(): showLen " + j + ", downloadLen " + i + ", fileLen " + l2);
    }
    Object localObject2 = paramCustomFace.bytes_md5.get().toByteArray();
    Object localObject1 = paramCustomFace.bytes_signature.get().toByteArray();
    Object localObject3 = paramCustomFace.bytes_flag.get().toByteArray();
    int i1 = (int)(paramCustomFace.uint32_width.get() & 0xFFFFFFFF);
    int i2 = (int)(paramCustomFace.uint32_height.get() & 0xFFFFFFFF);
    localObject2 = HexUtil.bytes2HexStr((byte[])localObject2);
    HexUtil.bytes2HexStr((byte[])localObject1);
    HexUtil.bytes2HexStr((byte[])localObject3);
    int i3 = paramCustomFace.uint32_origin.get();
    localObject3 = TranDbRecord.PicDbRecord.makeDbRecord(paramElem, 0L, 1, false, paramElem, (String)localObject2, "picplatform", str3, str4, str1, str2, i3, 0);
    localObject1 = new RichMsg.PicRec();
    ((RichMsg.PicRec)localObject1).localPath.set(paramElem);
    ((RichMsg.PicRec)localObject1).size.set(l2);
    ((RichMsg.PicRec)localObject1).type.set(1);
    ((RichMsg.PicRec)localObject1).isRead.set(false);
    ((RichMsg.PicRec)localObject1).uuid.set(paramElem);
    ((RichMsg.PicRec)localObject1).groupFileID.set(l1 & 0xFFFFFFFF);
    if (localObject2 != null) {
      ((RichMsg.PicRec)localObject1).md5.set((String)localObject2);
    }
    ((RichMsg.PicRec)localObject1).serverStorageSource.set("picplatform");
    ((RichMsg.PicRec)localObject1).thumbMsgUrl.set(str3);
    ((RichMsg.PicRec)localObject1).bigthumbMsgUrl.set(str4);
    ((RichMsg.PicRec)localObject1).uint32_thumb_width.set(m);
    ((RichMsg.PicRec)localObject1).uint32_thumb_height.set(n);
    ((RichMsg.PicRec)localObject1).uint32_width.set(i1);
    ((RichMsg.PicRec)localObject1).uint32_height.set(i2);
    ((RichMsg.PicRec)localObject1).bigMsgUrl.set(str1);
    ((RichMsg.PicRec)localObject1).rawMsgUrl.set(str2);
    ((RichMsg.PicRec)localObject1).fileSizeFlag.set(0);
    ((RichMsg.PicRec)localObject1).uiOperatorFlag.set(0);
    ((RichMsg.PicRec)localObject1).version.set(5);
    ((RichMsg.PicRec)localObject1).isReport.set(0);
    ((RichMsg.PicRec)localObject1).fileSizeFlag.set(i3);
    if (i3 == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "[customFace] showLen =" + j + ",downloadLen = " + i + ",raw photo msg,clear progressjpg info!");
      }
      j = 0;
      i = 0;
    }
    for (;;)
    {
      ((RichMsg.PicRec)localObject1).uint32_show_len.set(j);
      ((RichMsg.PicRec)localObject1).uint32_download_len.set(i);
      ((RichMsg.PicRec)localObject1).enableEnc.set(true);
      ((RichMsg.PicRec)localObject1).uint32_image_type.set(k);
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("protocolStr:").append((String)localObject3).append("\n");
      }
      if (paramCustomFace.bytes_pb_reserve.has()) {
        ((RichMsg.PicRec)localObject1).bytes_pb_reserved.set(paramCustomFace.bytes_pb_reserve.get());
      }
      boolean bool1 = false;
      paramElem = null;
      paramBoolean = bool1;
      if (paramCustomFace.bytes_pb_reserve.has())
      {
        paramCustomFace = a(paramCustomFace);
        paramElem = paramCustomFace;
        paramBoolean = bool1;
        if (paramCustomFace.msg_image_show.has())
        {
          paramBoolean = true;
          paramElem = paramCustomFace;
        }
      }
      paramElem = a(paramMsg, paramBoolean, paramElem);
      a(bool2, bool3, paramElem);
      if (parambdyi != null) {
        paramElem.istroop = parambdyi.jdField_a_of_type_Int;
      }
      paramElem.msgData = ((RichMsg.PicRec)localObject1).toByteArray();
      paramElem.parse();
      paramList.add(paramElem);
      localStringBuilder.delete(0, localStringBuilder.length());
      return;
    }
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    Object localObject1 = null;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (im_msg_body.Elem)localIterator.next();
      if (!((im_msg_body.Elem)localObject3).deliver_gift_msg.has()) {}
    }
    for (Object localObject2 = localObject3;; localObject2 = null)
    {
      if (localObject2 == null)
      {
        return false;
        localObject2 = localObject1;
        if (((im_msg_body.Elem)localObject3).pub_group.has()) {
          localObject2 = ((im_msg_body.Elem)localObject3).pub_group.bytes_nickname.get().toStringUtf8();
        }
        localObject1 = localObject2;
        if (!((im_msg_body.Elem)localObject3).text.has()) {
          break;
        }
        localObject3 = ((im_msg_body.Text)((im_msg_body.Elem)localObject3).text.get()).str.get().toStringUtf8();
        localObject1 = localObject2;
        if (!((String)localObject3).startsWith("@")) {
          break;
        }
        paramList = ((String)localObject3).substring(1);
        localObject1 = localObject2;
        break;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:GiftMsg;\n");
      }
      paramList = a(localObject1, paramList, ((im_msg_body.Elem)localObject2).deliver_gift_msg, paramList1, paramStringBuilder, paramMsg);
      paramList1 = new Intent("tencent.video.q2v.VideoSendGift");
      paramList1.putExtra("data", ((im_msg_body.Elem)localObject2).deliver_gift_msg.toByteArray());
      paramList1.putExtra("troopUin", paramList.grayTipsEntity.troopUin);
      paramList1.putExtra("shmsgSeq", paramMsg.msg_head.msg_seq.get());
      paramList1.putExtra("senderName", paramList.senderName);
      paramList1.putExtra("rcvName", paramList.rcvName);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramList1);
      return true;
    }
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean, bdyi parambdyi)
  {
    Object localObject2;
    String str1;
    Object localObject1;
    label82:
    im_msg_body.Elem localElem;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin() == paramMsg.msg_head.to_uin.get())
      {
        parambdyi = paramMsg.msg_head.from_uin.get() + "";
        localObject2 = null;
        str1 = null;
        localObject1 = null;
        Iterator localIterator = paramList.iterator();
        paramList = (List<im_msg_body.Elem>)localObject2;
        if (!localIterator.hasNext()) {
          break label309;
        }
        localElem = (im_msg_body.Elem)localIterator.next();
        if (!localElem.pub_group.has()) {
          break label415;
        }
        str1 = localElem.pub_group.bytes_nickname.get().toStringUtf8();
      }
    }
    label415:
    for (;;)
    {
      localObject2 = localObject1;
      if (localElem.text.has())
      {
        String str2 = ((im_msg_body.Text)localElem.text.get()).str.get().toStringUtf8();
        localObject2 = localObject1;
        if (str2 != null)
        {
          localObject2 = localObject1;
          if (str2.startsWith("@")) {
            localObject2 = str2.substring(1);
          }
        }
      }
      if (localElem.common_elem.has()) {
        paramList = localElem.common_elem;
      }
      for (;;)
      {
        localObject1 = localObject2;
        break label82;
        parambdyi = paramMsg.msg_head.to_uin.get() + "";
        break;
        if (parambdyi != null) {}
        for (parambdyi = parambdyi.jdField_a_of_type_JavaLangString;; parambdyi = paramMsg.msg_head.to_uin.get() + "") {
          break;
        }
        label309:
        if (paramList == null) {
          return false;
        }
        localObject2 = new hummer_commelem.MsgElemInfo_servtype8();
        try
        {
          ((hummer_commelem.MsgElemInfo_servtype8)localObject2).mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:GiftMsg;\n");
          }
          paramList = a(str1, localObject1, ((hummer_commelem.MsgElemInfo_servtype8)localObject2).wifi_deliver_gift_msg, paramList1, paramStringBuilder, paramMsg);
          paramList.frienduin = parambdyi;
          paramList.isFromNearby = true;
          paramList1 = (beyh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
          if (paramList1 != null) {
            paramList1.b(paramList);
          }
          return true;
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          return false;
        }
      }
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    MessageForIncompatibleGrayTips localMessageForIncompatibleGrayTips = null;
    Iterator localIterator = paramList.iterator();
    do
    {
      paramList = localMessageForIncompatibleGrayTips;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)localIterator.next();
    } while (!paramList.tips_info.has());
    paramList = (im_msg_body.TipsInfo)paramList.tips_info.get();
    if (paramList == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:TipsInfo;\n");
      }
      localMessageForIncompatibleGrayTips = (MessageForIncompatibleGrayTips)bbli.a(-5002);
      if (localMessageForIncompatibleGrayTips.parseTextXML(paramList.text.get()).booleanValue())
      {
        paramList1.add(localMessageForIncompatibleGrayTips);
        return;
      }
    } while (!QLog.isColorLevel());
    paramStringBuilder.append("TipsInfo parse failed;\n");
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi)
  {
    Object localObject1 = null;
    Object localObject2 = paramList.iterator();
    Object localObject3;
    for (im_msg_body.CommonElem localCommonElem = null; ((Iterator)localObject2).hasNext(); localCommonElem = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject3).common_elem.get())
    {
      localObject3 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!((im_msg_body.Elem)localObject3).common_elem.has()) {
        break label498;
      }
    }
    a(paramList);
    if (QLog.isColorLevel()) {
      QLog.d("ArkBabyq", 2, "decodePBMsgElems_ArkBabyqReply  common_lem" + localCommonElem);
    }
    if (localCommonElem == null) {
      return;
    }
    localObject2 = new hummer_commelem.MsgElemInfo_servtype19();
    try
    {
      ((hummer_commelem.MsgElemInfo_servtype19)localObject2).mergeFrom(localCommonElem.bytes_pb_elem.get().toByteArray());
      if (!ArkUtil.isDeviceSupportArkMsg())
      {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply is false, ignore msg.");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    if (((hummer_commelem.MsgElemInfo_servtype19)localObject2).bytes_data.has())
    {
      ((hummer_commelem.MsgElemInfo_servtype19)localObject2).bytes_data.get().toStringUtf8();
      localObject2 = ((hummer_commelem.MsgElemInfo_servtype19)localObject2).bytes_data.get().toByteArray();
      if ((localObject2 == null) || (localObject2.length <= 0))
      {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply, bytes_data empty.");
        return;
      }
      localObject2 = bciq.a((byte[])localObject2, -1);
      if (localObject2 != null)
      {
        int i = localObject2.length;
        if (i > 0)
        {
          try
          {
            localObject2 = new String((byte[])localObject2, "UTF-8");
            localObject1 = localObject2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              label257:
              QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply convert failed");
            }
          }
          localObject2 = a(paramList, paramList1, false);
          localObject3 = (MessageForArkBabyqReply)bbli.a(-5016);
          ((MessageForArkBabyqReply)localObject3).msgtype = -5016;
          if (localObject2 != null) {
            ((MessageForArkBabyqReply)localObject3).compatibleMsg = ((String)localObject2);
          }
          ((MessageForArkBabyqReply)localObject3).fromAppXml(localObject1);
          if (localCommonElem.uint32_business_type.get() == 2) {
            break label501;
          }
        }
      }
    }
    label498:
    label501:
    for (boolean bool = true;; bool = false)
    {
      ((MessageForArkBabyqReply)localObject3).showAsBabyq = bool;
      ((MessageForArkBabyqReply)localObject3).msgData = ((MessageForArkBabyqReply)localObject3).toBytes();
      ((MessageForArkBabyqReply)localObject3).parse();
      if ((TextUtils.isEmpty(((MessageForArkBabyqReply)localObject3).babyqReplyText)) && (!((MessageForArkBabyqReply)localObject3).isFailed) && ((((MessageForArkBabyqReply)localObject3).mArkBabyqReplyCardList == null) || (((MessageForArkBabyqReply)localObject3).mArkBabyqReplyCardList.size() <= 0))) {
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply not valid..");
      }
      for (bool = false;; bool = true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkBabyq", 2, "decodePBMsgElems_ArkBabyqReply hasArkBabyQMsg = " + bool);
        }
        if (bool) {
          break;
        }
        f(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi);
        return;
        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply empty.");
        break label257;
        paramList1.add(localObject3);
      }
      QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply, bytes_data not exist.");
      return;
      break;
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder("");
    int i = 0;
    bble localbble = new bble();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList(2);
    im_msg_body.GeneralFlags localGeneralFlags = null;
    Iterator localIterator = paramList.iterator();
    im_msg_body.Elem localElem;
    Object localObject3;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localElem = (im_msg_body.Elem)localIterator.next();
        MessageForText localMessageForText;
        if (localElem.custom_face.has())
        {
          localObject3 = localObject2;
          if (((StringBuilder)localObject1).length() > 0)
          {
            localMessageForText = (MessageForText)bbli.a(-1000);
            localMessageForText.msgtype = -1000;
            localMessageForText.msg = ((StringBuilder)localObject1).toString();
            localMessageForText.atInfoList = ((ArrayList)localObject2);
            localObject3 = new ArrayList(2);
            localArrayList.add(localMessageForText);
            ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          }
          a(localElem, null, localArrayList, paramStringBuilder, paramMsg, paramBoolean, parambdyi);
        }
        for (localObject2 = localObject3;; localObject2 = localObject3)
        {
          break;
          if (!localElem.not_online_image.has()) {
            break label300;
          }
          localObject3 = localObject2;
          if (((StringBuilder)localObject1).length() > 0)
          {
            localMessageForText = (MessageForText)bbli.a(-1000);
            localMessageForText.msgtype = -1000;
            localMessageForText.msg = ((StringBuilder)localObject1).toString();
            localMessageForText.atInfoList = ((ArrayList)localObject2);
            localObject3 = new ArrayList(2);
            localArrayList.add(localMessageForText);
            ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          }
          a(localElem, null, localArrayList, paramStringBuilder, paramMsg);
        }
        label300:
        if (acey.a(localElem).booleanValue())
        {
          if (i != 0)
          {
            i = 0;
            continue;
          }
          if (!localElem.small_emoji.has()) {
            break label647;
          }
          i = 1;
        }
      }
    }
    label647:
    for (;;)
    {
      localObject3 = new ArrayList();
      ((List)localObject3).add(localElem);
      localObject1 = a((StringBuilder)localObject1, (List)localObject3, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), parambdyi, localbble, (ArrayList)localObject2);
      break;
      if (localElem.general_flags.has())
      {
        localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
        break;
        if (((StringBuilder)localObject1).length() > 0)
        {
          localObject3 = (MessageForText)bbli.a(-1000);
          ((MessageForText)localObject3).msgtype = -1000;
          ((MessageForText)localObject3).msg = ((StringBuilder)localObject1).toString();
          ((MessageForText)localObject3).atInfoList = ((ArrayList)localObject2);
          if (parambdyi != null) {
            bevq.a(parambdyi.jdField_a_of_type_Int, (ArrayList)localObject2, (ChatMessage)localObject3);
          }
          localArrayList.add(localObject3);
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
        }
        localObject2 = localbble.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject2 != null) && (((ArrayList)localObject2).size() == 2)) {
          if (((ArrayList)localObject2).get(0) != null)
          {
            localObject1 = (MessageForText.AtTroopMemberInfo)((ArrayList)localObject2).get(0);
            if (((ArrayList)localObject2).get(1) != null)
            {
              localObject3 = (byte[])((ArrayList)localObject2).get(1);
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
        }
        for (;;)
        {
          a(paramList, paramStringBuilder, (MessageForText.AtTroopMemberInfo)localObject2, localArrayList, localbble, parambdyi);
          a(localGeneralFlags, localArrayList);
          b(localGeneralFlags, localArrayList);
          a(localArrayList, paramMsg, paramList1, (byte[])localObject1, parambdyi, (MessageForText.AtTroopMemberInfo)localObject2);
          return;
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
          localObject1 = null;
          break;
          localObject1 = null;
          localObject2 = null;
        }
      }
      break;
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    Object localObject;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localObject = (im_msg_body.Elem)paramList.next();
    } while (!((im_msg_body.Elem)localObject).common_elem.has());
    for (paramList = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get();; paramList = null)
    {
      if (paramList == null) {}
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "decodePBMsgElems_FlashPicCommen isC2C=" + paramBoolean);
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("ELEM_FlashPicCommen;\n");
          }
          localObject = new hummer_commelem.MsgElemInfo_servtype3();
          try
          {
            ((hummer_commelem.MsgElemInfo_servtype3)localObject).mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
            if (!paramBoolean)
            {
              if (!((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_troop_pic.has()) {
                continue;
              }
              a(null, (im_msg_body.CustomFace)((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_troop_pic.get(), paramList1, paramStringBuilder, paramMsg, paramBoolean);
            }
          }
          catch (InvalidProtocolBufferMicroException paramList)
          {
            paramList.printStackTrace();
            return;
          }
        }
      } while (!((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_c2c_pic.has());
      a(null, (im_msg_body.NotOnlineImage)((hummer_commelem.MsgElemInfo_servtype3)localObject).flash_c2c_pic.get(), paramList1, paramStringBuilder, paramMsg);
      return;
    }
  }
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramList.next();
    } while (!localElem.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)localElem.common_elem.get();; paramList = null)
    {
      if (paramList == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:QQStoryComment;\n");
      }
      paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype5();
      try
      {
        paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
        paramList = (MessageForQQStoryComment)bbli.a(-2052);
        paramList.vid = paramStringBuilder.vid.get().toStringUtf8();
        paramList.comment = paramStringBuilder.comment_content.get().toStringUtf8();
        paramList.coverUrl = paramStringBuilder.cover.get().toStringUtf8();
        paramList.title = paramStringBuilder.title.get().toStringUtf8();
        paramList.summary = paramStringBuilder.summary.get().toStringUtf8();
        paramList.createTime = paramStringBuilder.createTime.get();
        paramList.author = paramStringBuilder.author.get();
        paramList.prewrite();
        paramList1.add(paramList);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramList)
      {
        paramList.printStackTrace();
        return;
      }
    }
  }
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi)
  {
    Object localObject3 = null;
    Iterator localIterator = paramList.iterator();
    im_msg_body.GeneralFlags localGeneralFlags = null;
    Object localObject1 = null;
    im_msg_body.ArkAppElem localArkAppElem = null;
    im_msg_body.Elem localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.ark_app.has()) {
        localArkAppElem = (im_msg_body.ArkAppElem)localElem.ark_app.get();
      }
      if (!localElem.light_app.has()) {
        break label439;
      }
      localObject1 = (im_msg_body.LightAppElem)localElem.light_app.get();
    }
    label439:
    for (;;)
    {
      if (localElem.general_flags.has()) {
        localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
      }
      for (;;)
      {
        break;
        paramStringBuilder.append("elemType:ArkApp/LightApp;\n");
        if (!ArkUtil.isDeviceSupportArkMsg())
        {
          QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isDeviceSupportArkMsg is false, ignore msg.");
          if (a(paramList).booleanValue())
          {
            f(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi);
            return;
          }
          paramList = (MessageForText)bbli.a(-1000);
          paramList.msgtype = -1000;
          paramList.msg = BaseApplication.getContext().getString(2131693343);
          paramList1.add(paramList);
          return;
        }
        if (ArkAppCenter.b())
        {
          QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isPANonShow is true, ignore msg.");
          return;
        }
        if (localArkAppElem != null)
        {
          if (!localArkAppElem.bytes_data.has())
          {
            QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data not exist.");
            return;
          }
          localObject1 = localArkAppElem.bytes_data.get().toByteArray();
        }
        for (;;)
        {
          if ((localObject1 == null) || (localObject1.length <= 0))
          {
            QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data is empty.");
            return;
            if (localObject1 != null)
            {
              if (!((im_msg_body.LightAppElem)localObject1).bytes_data.has())
              {
                QLog.i("ArkApp", 1, "decode msg, light_app.bytes_data not exist.");
                return;
              }
              localObject1 = ((im_msg_body.LightAppElem)localObject1).bytes_data.get().toByteArray();
            }
          }
          else
          {
            localObject1 = bciq.a((byte[])localObject1, -1);
            if ((localObject1 != null) && (localObject1.length > 0)) {}
            for (;;)
            {
              try
              {
                localObject1 = new String((byte[])localObject1, "UTF-8");
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  break;
                }
                QLog.i("ArkApp", 1, "decode msg, ark data is empty.");
                return;
              }
              catch (Exception localException)
              {
                QLog.i("ArkApp", 1, "decode msg, raw data cannot convert to string.");
                localObject2 = localObject3;
                continue;
              }
              QLog.i("ArkApp", 1, "decode msg, raw data is empty.");
              localObject2 = localObject3;
            }
            a(localGeneralFlags, false, localObject2, paramList, paramList1, paramStringBuilder, paramMsg, parambdyi);
            return;
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public void d(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramList.next();
    } while (!localElem.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)localElem.common_elem.get();; paramList = null)
    {
      if (paramList == null) {}
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:TroopStoryComment;\n");
        }
        paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype15();
        try
        {
          paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          paramList = (MessageForQQStoryComment)bbli.a(-2052);
          paramList.vid = paramStringBuilder.vid.get().toStringUtf8();
          paramList.comment = paramStringBuilder.comment_content.get().toStringUtf8();
          paramList.coverUrl = paramStringBuilder.cover.get().toStringUtf8();
          paramList.title = paramStringBuilder.title.get().toStringUtf8();
          paramList.summary = paramStringBuilder.summary.get().toStringUtf8();
          paramList.createTime = paramStringBuilder.createTime.get();
          paramList.author = paramStringBuilder.author.get();
          paramList.ctrVersion = paramStringBuilder.ctr_version.get();
          if (paramList.ctrVersion <= 1)
          {
            paramList.prewrite();
            paramList1.add(paramList);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
      }
    }
  }
  
  public void d(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi)
  {
    Object localObject2 = null;
    Object localObject3 = paramList.iterator();
    Object localObject1 = null;
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (im_msg_body.Elem)((Iterator)localObject3).next();
      if (!((im_msg_body.Elem)localObject4).common_elem.has()) {
        break label463;
      }
      localObject1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject4).common_elem.get();
    }
    label436:
    label450:
    label463:
    for (;;)
    {
      break;
      a(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("ArkSdkShare", 2, "decodePBMsgElems_ArkSdkApp  common_lem" + localObject1);
      }
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        localObject3 = new hummer_commelem.MsgElemInfo_servtype20();
        try
        {
          ((hummer_commelem.MsgElemInfo_servtype20)localObject3).mergeFrom(((im_msg_body.CommonElem)localObject1).bytes_pb_elem.get().toByteArray());
          if (!ArkUtil.isDeviceSupportArkMsg())
          {
            QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp is false, ignore msg.");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
        if (!((hummer_commelem.MsgElemInfo_servtype20)localObject3).bytes_data.has()) {
          break;
        }
        ((hummer_commelem.MsgElemInfo_servtype20)localObject3).bytes_data.get().toStringUtf8();
        localObject3 = ((hummer_commelem.MsgElemInfo_servtype20)localObject3).bytes_data.get().toByteArray();
        if ((localObject3 == null) || (localObject3.length <= 0))
        {
          QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp, bytes_data empty.");
          return;
        }
        localObject3 = bciq.a((byte[])localObject3, -1);
        if (localObject3 != null)
        {
          i = localObject3.length;
          if (i > 0)
          {
            try
            {
              localObject3 = new String((byte[])localObject3, "UTF-8");
              localObject2 = localObject3;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp convert failed");
              }
            }
            localObject4 = a(paramList, paramList1, false);
            localObject3 = (MessageForArkApp)bbli.a(-5017);
            ((MessageForArkApp)localObject3).msgtype = -5017;
            if (((im_msg_body.CommonElem)localObject1).uint32_business_type.get() == 1) {
              ((MessageForArkApp)localObject3).saveExtInfoToExtStr(bbkv.e, "1");
            }
            if (localObject4 != null) {
              ((MessageForArkApp)localObject3).compatibleMsg = ((String)localObject4);
            }
            localObject1 = new ArkAppMessage();
            ((ArkAppMessage)localObject1).fromAppXml(localObject2);
            ((MessageForArkApp)localObject3).msgData = ((ArkAppMessage)localObject1).toBytes();
            ((MessageForArkApp)localObject3).parse();
            if ((TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appName)) || (TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appView))) {
              break label436;
            }
            paramList1.add(localObject3);
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label450;
          }
          f(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi);
          return;
          QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp empty.");
          break;
          QLog.i("arksdk", 1, "decode msg, ark message is not valid..");
        }
      }
      QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp, bytes_data not exist.");
      return;
    }
  }
  
  public void e(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    im_msg_body.CommonElem localCommonElem1 = null;
    paramList = (List<im_msg_body.Elem>)localObject;
    localObject = paramList;
    im_msg_body.CommonElem localCommonElem2 = localCommonElem1;
    if (localIterator.hasNext())
    {
      localObject = (im_msg_body.Elem)localIterator.next();
      if (!((im_msg_body.Elem)localObject).common_elem.has()) {
        break label87;
      }
      localCommonElem1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get();
      if (paramList == null) {
        break label417;
      }
      localCommonElem2 = localCommonElem1;
      localObject = paramList;
    }
    for (;;)
    {
      if (localCommonElem2 != null) {
        break label128;
      }
      return;
      label87:
      if (!((im_msg_body.Elem)localObject).text.has()) {
        break label414;
      }
      paramList = (im_msg_body.Text)((im_msg_body.Elem)localObject).text.get();
      if (localCommonElem1 == null) {
        break;
      }
      localObject = paramList;
      localCommonElem2 = localCommonElem1;
    }
    label128:
    label414:
    label417:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:TroopStory;\n");
      }
      for (paramList = new hummer_commelem.MsgElemInfo_servtype16();; paramList = ((im_msg_body.Text)localObject).str.get().toStringUtf8()) {
        try
        {
          paramList.mergeFrom(localCommonElem2.bytes_pb_elem.get().toByteArray());
          int i = paramList.ctr_version.get();
          if (i > 1) {
            break;
          }
          paramStringBuilder = (MessageForTroopStory)bbli.a(-2057);
          paramStringBuilder.uid = paramList.uid.get();
          paramStringBuilder.unionId = paramList.unionID.get().toStringUtf8();
          paramStringBuilder.storyId = paramList.storyID.get().toStringUtf8();
          paramStringBuilder.md5 = paramList.md5.get().toStringUtf8();
          paramStringBuilder.thumbUrl = paramList.thumbUrl.get().toStringUtf8();
          paramStringBuilder.doodleUrl = paramList.doodleUrl.get().toStringUtf8();
          paramStringBuilder.videoWidth = paramList.videoWidth.get();
          paramStringBuilder.videoHeight = paramList.videoHeight.get();
          paramStringBuilder.sourceName = paramList.sourceName.get().toStringUtf8();
          paramStringBuilder.sourceActionType = paramList.sourceActionType.get().toStringUtf8();
          paramStringBuilder.sourceActionData = paramList.sourceActionData.get().toStringUtf8();
          if (localObject == null)
          {
            paramList = "";
            paramStringBuilder.compatibleText = paramList;
            paramStringBuilder.ctrVersion = i;
            paramStringBuilder.msg = MessageForTroopStory.MSG_CONTENT;
            paramStringBuilder.serial();
            paramList1.add(paramStringBuilder);
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.d("TroopStory", 4, paramStringBuilder.toDebugString());
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
      }
    }
  }
  
  public void e(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi)
  {
    MessageForQQWalletMsg.decodePBMsgElemWalletMsg(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramList, paramList1, paramStringBuilder, paramMsg, parambdyi);
  }
  
  public void f(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeEmoMsg;\n");
    }
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramStringBuilder = (im_msg_body.Elem)paramList.next();
    } while (!paramStringBuilder.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)paramStringBuilder.common_elem.get();; paramList = null)
    {
      if (paramList == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeEmoMsg null commomElem!");
        }
      }
      for (;;)
      {
        return;
        paramStringBuilder = new MessageForPokeEmo();
        paramStringBuilder.msgtype = -5018;
        hummer_commelem.MsgElemInfo_servtype23 localMsgElemInfo_servtype23;
        if (paramList.bytes_pb_elem.has()) {
          localMsgElemInfo_servtype23 = new hummer_commelem.MsgElemInfo_servtype23();
        }
        try
        {
          localMsgElemInfo_servtype23.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          paramStringBuilder.pokeemoId = localMsgElemInfo_servtype23.uint32_face_type.get();
          paramStringBuilder.pokeemoPressCount = localMsgElemInfo_servtype23.uint32_face_bubble_count.get();
          paramStringBuilder.summary = localMsgElemInfo_servtype23.bytes_face_summary.get().toStringUtf8();
          paramStringBuilder.initMsg();
          paramList1.add(paramStringBuilder);
          if (QLog.isColorLevel())
          {
            QLog.d("PokeEmoMsg", 2, "decodePbElems, common_elem type 23, pokeemoId:" + paramStringBuilder.pokeemoId + " ,pokeemoPressCount:" + paramStringBuilder.pokeemoPressCount);
            return;
          }
        }
        catch (Exception paramList)
        {
          for (;;)
          {
            QLog.d("PokeEmoMsg", 1, "decodePBMsgElems_PokeEmoMsg exception!", paramList);
          }
        }
      }
    }
  }
  
  public void f(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "begin decodePBMsgElems_RichMsg");
    }
    Object localObject = a(paramList);
    im_msg_body.GeneralFlags localGeneralFlags = a(paramList);
    im_msg_body.Text localText = a(paramList);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "richMsg is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:RichMsg;\n");
    }
    boolean bool1 = a(localGeneralFlags);
    byte[] arrayOfByte = a((im_msg_body.RichMsg)localObject);
    if (paramMsg.msg_head.from_uin.has()) {}
    for (long l1 = paramMsg.msg_head.from_uin.get();; l1 = 0L)
    {
      MessageForStructing localMessageForStructing = new MessageForStructing();
      localMessageForStructing.msgtype = -2011;
      long l2 = paramMsg.msg_head.to_uin.get();
      int i = paramMsg.msg_head.msg_type.get();
      l2 = a(paramMsg, l2, i);
      localObject = a(((im_msg_body.RichMsg)localObject).bytes_msg_resid.get());
      boolean bool2 = a(paramList, localMessageForStructing, (String)localObject);
      bblm localbblm = bbmc.a(paramMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(paramMsg, arrayOfByte, localMessageForStructing, (String)localObject, bool2, localbblm);
      a(localGeneralFlags, localMessageForStructing);
      if (a(paramList, paramList1, paramMsg, localGeneralFlags, localText, a(localGeneralFlags, arrayOfByte, localMessageForStructing, l2, i, (String)localObject, bool2, localbblm), l1, localMessageForStructing, l2, i)) {
        break;
      }
      localMessageForStructing.msg = "richMsg";
      a(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi, localGeneralFlags, bool1, localMessageForStructing);
      return;
    }
  }
  
  public void g(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi)
  {
    Object localObject1 = a(paramList);
    im_msg_body.GeneralFlags localGeneralFlags = b(paramList);
    if (localObject1 == null) {
      return;
    }
    long l = ((im_msg_body.GroupPubAccountInfo)localObject1).uint64_pub_account.get();
    localObject1 = null;
    boolean bool = false;
    MessageForPubAccount localMessageForPubAccount = (MessageForPubAccount)bbli.a(-3006);
    localMessageForPubAccount.msgtype = -3006;
    localMessageForPubAccount.associatePubAccUin = l;
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = (im_msg_body.Elem)localIterator.next();
        if ((((im_msg_body.Elem)localObject2).text.has()) && (((im_msg_body.Elem)localObject2).text.str.has()))
        {
          localMessageForPubAccount.msg = localStringBuilder.toString();
          localObject1 = new PAMessage();
          ((PAMessage)localObject1).msg = localStringBuilder.toString();
          localMessageForPubAccount.msgData = ueg.a((PAMessage)localObject1);
        }
        else if (((im_msg_body.Elem)localObject2).trans_elem_info.has())
        {
          localObject2 = (im_msg_body.TransElem)((im_msg_body.Elem)localObject2).trans_elem_info.get();
          int i = ((im_msg_body.TransElem)localObject2).elem_type.get();
          localObject2 = ((im_msg_body.TransElem)localObject2).elem_value.get().toByteArray();
          if (i != 16)
          {
            paramStringBuilder.append("PubAccount Message type is not 16.\n");
          }
          else if ((localObject2 == null) || (localObject2.length == 0))
          {
            paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
          }
          else
          {
            if (localObject2[0] != 1) {
              break label454;
            }
            i = PkgTools.getShortData((byte[])localObject2, 1);
            int j = localObject2[3];
            byte[] arrayOfByte = new byte[i - 1];
            PkgTools.copyData(arrayOfByte, 0, (byte[])localObject2, 4, i - 1);
            localObject2 = arrayOfByte;
            if (j == 1) {
              localObject2 = a(arrayOfByte);
            }
            if (localObject2 == null) {
              break;
            }
          }
        }
      }
    }
    label454:
    for (;;)
    {
      try
      {
        if (localObject2.length > 0)
        {
          localObject2 = new String((byte[])localObject2, "utf-8");
          localStringBuilder.append((String)localObject2);
          localObject2 = a((String)localObject2);
          localObject1 = localObject2;
          bool = true;
          a(localGeneralFlags, localMessageForPubAccount);
        }
      }
      catch (Exception localException)
      {
        paramStringBuilder.append("PubAccount Message parse decodeContext.mPamag exception.\n");
      }
      continue;
      if (localObject1 != null)
      {
        a(paramList, (PAMessage)localObject1);
        localMessageForPubAccount.mPAMessage = ((PAMessage)localObject1);
        localMessageForPubAccount.msgData = ueg.a((PAMessage)localObject1);
      }
      a(paramMsg, l, bool);
      paramList1.add(localMessageForPubAccount);
      if (bool) {
        break;
      }
      f(paramList, paramList1, paramStringBuilder, paramMsg, parambdyi);
      return;
    }
  }
  
  public void h(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi)
  {
    paramList = a(paramList, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), parambdyi);
    paramMsg = paramList.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    if (paramList.jdField_a_of_type_JavaLangString != null)
    {
      paramStringBuilder = (ChatMessage)bbli.a(-1049);
      paramStringBuilder.msg = paramList.jdField_a_of_type_JavaLangString;
      parambdyi = (MessageForReplyText)paramStringBuilder;
    }
    try
    {
      parambdyi.extLong |= 0x1;
      if (paramMsg.getSourceMsg() != null)
      {
        parambdyi.setSourceMessageRecord(paramMsg.unPackSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app));
        if ((parambdyi.getSourceMessage() != null) && (aszt.a(parambdyi.getSourceMessage())))
        {
          str = parambdyi.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
          ChatMessage localChatMessage = aszt.a((ChatMessage)parambdyi.getSourceMessage());
          ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, parambdyi.getSourceMessage());
          if ((!TextUtils.isEmpty(str)) && (localChatMessage != null))
          {
            int i = Integer.parseInt(str);
            if ((i == 1) || (i == 2))
            {
              QLog.i("DecodeMsg<QFile>", 1, "decode reply file msg, msg uniseq[" + localChatMessage.uniseq + "]");
              aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)parambdyi.getSourceMessage());
            }
          }
        }
      }
      String str = HexUtil.bytes2HexStr(anwz.a(paramMsg));
      parambdyi.mSourceMsgInfo = paramMsg;
      parambdyi.saveExtInfoToExtStr("sens_msg_source_msg_info", str);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, "reply:" + parambdyi + " sourceMsg=" + parambdyi.getSourceMessage());
      }
    }
    catch (Exception paramMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramMsg.getMessage());
        }
      }
    }
    if (paramList.jdField_a_of_type_ArrayOfByte != null) {
      paramStringBuilder.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(paramList.jdField_a_of_type_ArrayOfByte));
    }
    paramList1.add(paramStringBuilder);
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "reply msgRand = " + bblk.a(paramStringBuilder.msgUid) + ", msgUid = " + paramStringBuilder.msgUid);
    }
  }
  
  public void i(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bdyi parambdyi)
  {
    im_msg_body.GeneralFlags localGeneralFlags = d(paramList);
    boolean bool4 = a(paramList);
    int m = c(paramList);
    int n = b(paramList);
    String str2 = b(paramList);
    int i1 = a(paramList);
    Object localObject = new bble();
    ArrayList localArrayList1 = ((bble)localObject).jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = new ArrayList(2);
    StringBuilder localStringBuilder = a(null, paramList, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), parambdyi, (bble)localObject, localArrayList2);
    if ((localArrayList1 != null) && (localArrayList1.size() == 2) && (localArrayList1.get(1) != null)) {}
    for (paramStringBuilder = (byte[])localArrayList1.get(1);; paramStringBuilder = null)
    {
      if (localStringBuilder.length() == 0) {
        return;
      }
      long l3 = 0L;
      boolean bool2 = false;
      localObject = null;
      String str1 = null;
      int k = 0;
      int i = 0;
      int j = 0;
      boolean bool3 = false;
      long l1 = 0L;
      paramList = null;
      long l2;
      long l5;
      long l4;
      if (localGeneralFlags != null)
      {
        l2 = l3;
        l5 = l1;
        if (localGeneralFlags.bytes_pb_reserve.has())
        {
          i = k;
          l4 = l3;
          l5 = l1;
        }
      }
      for (;;)
      {
        boolean bool5;
        try
        {
          generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
          i = k;
          l4 = l3;
          l5 = l1;
          localResvAttr.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
          l2 = l3;
          i = k;
          l4 = l3;
          l5 = l1;
          if (localResvAttr.redbag_msg_sender_uin.has())
          {
            i = 1;
            j = 1;
            l4 = l3;
            l5 = l1;
            l2 = localResvAttr.redbag_msg_sender_uin.get();
          }
          l3 = l1;
          i = j;
          l4 = l2;
          l5 = l1;
          if (localResvAttr.want_gift_sender_uin.has())
          {
            i = j;
            l4 = l2;
            l5 = l1;
            l3 = localResvAttr.want_gift_sender_uin.get();
          }
          i = j;
          l4 = l2;
          l5 = l3;
          if (localResvAttr.bytes_oac_msg_extend.has())
          {
            i = j;
            l4 = l2;
            l5 = l3;
            paramList = localResvAttr.bytes_oac_msg_extend.get().toStringUtf8();
          }
          i = j;
          j = i;
          l1 = l2;
          if (i == 0)
          {
            j = i;
            l1 = l2;
            if (localGeneralFlags.uint64_uin.has())
            {
              i = 1;
              l2 = localGeneralFlags.uint64_uin.get();
              j = i;
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.d("msgFold", 2, "from old version");
                l1 = l2;
                j = i;
              }
            }
          }
          if (j == 0) {
            break label829;
          }
          if (localGeneralFlags.uint32_prp_fold.get() != 1) {
            break label789;
          }
          bool2 = true;
          localObject = localGeneralFlags.bytes_rp_id.get().toStringUtf8();
          str1 = localGeneralFlags.bytes_rp_index.get().toStringUtf8();
          bool5 = ajul.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          bool1 = bool3;
          if (ajul.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app))
          {
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label795;
            }
            bool1 = true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, redBagSender: %s, foldFlag: %s, redBagId: %s, index: %s, foldSwitch: %s, isValidFoldMsg: %s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool2), localObject, str1, Boolean.valueOf(ajul.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), Boolean.valueOf(bool1) }));
          }
          if (!String.valueOf(paramMsg.msg_head.from_uin.get()).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            break label822;
          }
          bool2 = false;
          l2 = l1;
          paramList = a(parambdyi, localArrayList1, localArrayList2, l2, bool2, (String)localObject, str1, bool1, l3, paramList, b(localGeneralFlags));
          paramList.msg = localStringBuilder.toString();
          a(paramList);
          a(paramMsg, paramStringBuilder, paramList);
          b(localGeneralFlags, paramList);
          a(bool4, m, paramList);
          b(n, paramList);
          a(localGeneralFlags, paramList);
          a(str2, paramList);
          a(i1, paramList);
          paramList1.add(paramList);
          return;
        }
        catch (Exception paramList)
        {
          QLog.e("msgFold", 1, "prase ResvAttr error, ", paramList);
          l2 = l4;
        }
        paramList = null;
        l3 = l5;
        continue;
        label789:
        bool2 = false;
        continue;
        label795:
        boolean bool1 = bool3;
        if (!TextUtils.isEmpty(str1))
        {
          bool1 = bool3;
          if (bool5)
          {
            bool1 = true;
            continue;
            label822:
            l2 = l1;
            continue;
            label829:
            bool1 = false;
            l2 = l1;
            continue;
            paramList = null;
            bool1 = false;
            l2 = l3;
            l3 = l1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblb
 * JD-Core Version:    0.7.0.1
 */