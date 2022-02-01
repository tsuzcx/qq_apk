import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ark.open.ArkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.VIPDonateMsg;
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
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
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
import tencent.im.msg.im_msg_body.OnlineImage;
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

public class bbzc
{
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  
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
          break label423;
        }
        MessageForVIPDonate localMessageForVIPDonate = (MessageForVIPDonate)bbzh.a(-2047);
        localMessageForVIPDonate.msgtype = -2047;
        localVIPDonateMsg = new VIPDonateMsg();
        if (localJSONObject.has("title"))
        {
          localObject = localJSONObject.getString("title");
          localVIPDonateMsg.title = ((String)localObject);
          if (!localJSONObject.has("footer")) {
            break label313;
          }
          localObject = localJSONObject.getString("footer");
          localVIPDonateMsg.footer = ((String)localObject);
          if (!paramBoolean) {
            break label333;
          }
          if (!localJSONObject.has("sendsubtitle")) {
            break label318;
          }
          localObject = localJSONObject.getString("sendsubtitle");
          localVIPDonateMsg.subTitle = ((String)localObject);
          if (!localJSONObject.has("sendurl")) {
            break label323;
          }
          localObject = localJSONObject.getString("sendurl");
          localVIPDonateMsg.jumpUrl = ((String)localObject);
          if (!localJSONObject.has("sendbrief")) {
            break label328;
          }
          localObject = localJSONObject.getString("sendbrief");
          localVIPDonateMsg.brief = ((String)localObject);
          localMessageForVIPDonate.donateMsg = localVIPDonateMsg;
          localMessageForVIPDonate.msg = localMessageForVIPDonate.getSummaryMsg();
          localMessageForVIPDonate.msgData = aopw.a(localVIPDonateMsg);
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
      label313:
      str = null;
      continue;
      label318:
      str = null;
      continue;
      label323:
      str = null;
      continue;
      label328:
      str = null;
    }
    label333:
    if (localJSONObject.has("recvsubtitle"))
    {
      str = localJSONObject.getString("recvsubtitle");
      label351:
      localVIPDonateMsg.subTitle = str;
      if (!localJSONObject.has("recvurl")) {
        break label413;
      }
      str = localJSONObject.getString("recvurl");
      label375:
      localVIPDonateMsg.jumpUrl = str;
      if (!localJSONObject.has("recvbrief")) {
        break label418;
      }
    }
    label413:
    label418:
    for (String str = localJSONObject.getString("recvbrief");; str = null)
    {
      localVIPDonateMsg.brief = str;
      break;
      str = null;
      break label351;
      str = null;
      break label375;
    }
    label423:
    return null;
  }
  
  private static PAMessage a(String paramString)
  {
    paramString = txp.a(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
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
        j = arvq.b(j);
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
            str = bbzj.a(paramList, false);
            localObject = paramList;
            if (str.length() > 0)
            {
              localObject = (MessageForText)bbzh.a(-1000);
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
  
  private void a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder, MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, List<MessageRecord> paramList1, bbze parambbze, bepr parambepr)
  {
    paramList = a(paramList, paramStringBuilder);
    if (paramList != null) {
      paramStringBuilder = (MessageForReplyText)bbzh.a(-1049);
    }
    try
    {
      paramStringBuilder.extLong |= 0x1;
      paramStringBuilder.mSourceMsgInfo = paramList;
      if (paramList.getSourceMsg() != null)
      {
        paramStringBuilder.setSourceMessageRecord(paramList.unPackSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app));
        if ((paramStringBuilder.getSourceMessage() != null) && (atvo.a(paramStringBuilder.getSourceMessage())))
        {
          localObject = paramStringBuilder.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
          ChatMessage localChatMessage = atvo.a((ChatMessage)paramStringBuilder.getSourceMessage());
          atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, paramStringBuilder.getSourceMessage());
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localChatMessage != null))
          {
            i = Integer.parseInt((String)localObject);
            if ((i == 1) || (i == 2))
            {
              QLog.i("DecodeMsg<QFile>", 1, "decode mix inner reply file msg, msg uniseq[" + localChatMessage.uniseq + "]");
              atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)paramStringBuilder.getSourceMessage());
            }
          }
        }
      }
      paramStringBuilder.saveExtInfoToExtStr("sens_msg_source_msg_info", bgmj.a(aopw.a(paramList)));
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        Object localObject;
        int i;
        if (QLog.isColorLevel())
        {
          QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramList.getMessage());
          continue;
          ((MessageForReplyText)localObject).msg += paramStringBuilder.substring(i);
          continue;
          paramList = paramStringBuilder;
          if (QLog.isColorLevel())
          {
            QLog.w("zivonchen", 2, "replytext 内容为空，有回复消息，但第一个消息体不是文本消息");
            paramList = paramStringBuilder;
            continue;
            paramList = paramStringBuilder;
            if (QLog.isColorLevel())
            {
              QLog.w("zivonchen", 2, "");
              paramList = paramStringBuilder;
            }
          }
        }
      }
    }
    paramList = paramStringBuilder;
    if (TextUtils.isEmpty(paramStringBuilder.mSourceMsgInfo.mAnonymousNickName))
    {
      paramList = paramStringBuilder;
      if (paramAtTroopMemberInfo != null)
      {
        if (paramList1.size() <= 0) {
          break label665;
        }
        paramList = (MessageRecord)paramList1.get(0);
        if (!(paramList instanceof MessageForText)) {
          break label642;
        }
        localObject = (MessageForReplyText)bbzh.a(-1049);
        MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramList);
        MessageRecord.copyMessageRecordStatusField((MessageRecord)localObject, paramList);
        ((MessageForReplyText)localObject).atInfoList = paramStringBuilder.atInfoList;
        ((MessageForReplyText)localObject).msg = paramList.msg;
        ((MessageForReplyText)localObject).mSourceMsgInfo = paramStringBuilder.mSourceMsgInfo;
        ((MessageForReplyText)localObject).msgtype = -1049;
        if ((!TextUtils.isEmpty(((MessageForReplyText)localObject).msg)) && (((MessageForReplyText)localObject).msg.length() >= paramAtTroopMemberInfo.textLen + paramAtTroopMemberInfo.startPos))
        {
          paramStringBuilder = ((MessageForReplyText)localObject).msg;
          ((MessageForReplyText)localObject).msg = "";
          if (paramAtTroopMemberInfo.startPos > 0) {
            ((MessageForReplyText)localObject).msg = paramStringBuilder.substring(0, paramAtTroopMemberInfo.startPos);
          }
          paramList = "";
          i = paramAtTroopMemberInfo.startPos + paramAtTroopMemberInfo.textLen;
          if (i + 1 < paramStringBuilder.length()) {
            paramList = paramStringBuilder.substring(i, i + 1);
          }
          if (!paramList.equals(" ")) {
            break label607;
          }
          ((MessageForReplyText)localObject).msg += paramStringBuilder.substring(i + 1);
          if ((paramAtTroopMemberInfo.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin())) && (parambbze.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo == null)) {
            parambepr.jdField_a_of_type_Beps.b(24, -1L);
          }
        }
        paramList1.remove(0);
        paramList1.add(0, localObject);
        paramList = null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "sb.length == 0");
    }
    if (paramList != null) {
      paramList1.add(0, paramList);
    }
  }
  
  private void a(List<MessageRecord> paramList1, msg_comm.Msg paramMsg, List<MessageRecord> paramList2, byte[] paramArrayOfByte, bepr parambepr, MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo)
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
                paramList2.add(bbzf.a(paramMsg, paramList1, parambepr));
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
            paramList1 = bbzf.a(paramMsg, paramArrayOfByte, parambepr);
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
              paramMsg.saveExtInfoToExtStr("sens_msg_ctrl_info", bgmj.a(paramArrayOfByte));
            }
            paramList2.add(paramMsg);
          }
        }
      }
      label436:
      break label82;
    }
  }
  
  private void a(im_msg_body.Elem paramElem, im_msg_body.NotOnlineImage paramNotOnlineImage, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    BaseApplication.getContext().getString(2131694102);
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
                      paramMsg = bgmj.a((byte[])localObject2);
                    }
                  }
                }
                Object localObject2 = bdzv.a(paramElem, j, 1, false, paramElem, paramMsg, "picplatform", str1, str2, str3, str4, i5, 0);
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
                  break label1192;
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
                paramElem = (MessageForPic)bbzh.a(-2000);
                if (bool) {
                  anlk.a(paramElem, false);
                }
                paramElem.msgtype = -2000;
                paramElem.msgData = ((RichMsg.PicRec)localObject1).toByteArray();
                paramElem.parse();
                paramList.add(paramElem);
                return;
                if (!paramNotOnlineImage.download_path.has()) {
                  break label1203;
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
                bctj.a(BaseApplication.getContext()).a(paramNotOnlineImage, "actMessageEvent", false, 0L, 0L, paramElem, "");
                return;
                label1192:
                j = n;
                k = m;
              }
              label1203:
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
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, List<MessageRecord> paramList)
  {
    if ((paramGeneralFlags != null) && (paramGeneralFlags.babyq_guide_msg_cookie.has())) {}
    try
    {
      if (paramList.size() > 0)
      {
        paramList = (MessageRecord)paramList.get(0);
        byte[] arrayOfByte = paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
        String str = bgjw.a(arrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("DecodeMsg", 2, "decodePBMsgElems_Pic, guideMsgCookie: " + str + " ,byte: " + Arrays.toString(paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
        }
        paramList.saveExtInfoToExtStr("guide_msg_cookie", str);
        ((anhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(arrayOfByte);
      }
      return;
    }
    catch (Exception paramGeneralFlags)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DecodeMsg", 2, "get pic msg guideMsgCookie error!", paramGeneralFlags);
    }
  }
  
  private void a(im_msg_body.GeneralFlags paramGeneralFlags, boolean paramBoolean, String paramString, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr)
  {
    Object localObject = a(paramList, paramList1, false);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)bbzh.a(-5008);
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
        f(paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
      }
      return;
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
  
  public bbzd a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder, long paramLong, bepr parambepr)
  {
    bbzd localbbzd = new bbzd(this);
    localbbzd.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = a(paramList, paramStringBuilder);
    bbze localbbze = new bbze();
    Object localObject = localbbze.jdField_a_of_type_JavaUtilArrayList;
    StringBuilder localStringBuilder = a(null, paramList, paramStringBuilder, paramLong, parambepr, localbbze, null);
    if ((localObject != null) && (((ArrayList)localObject).size() == 2)) {
      if (((ArrayList)localObject).get(0) != null)
      {
        paramList = (MessageForText.AtTroopMemberInfo)((ArrayList)localObject).get(0);
        paramStringBuilder = paramList;
        if (((ArrayList)localObject).get(1) != null) {
          localbbzd.jdField_a_of_type_ArrayOfByte = ((byte[])((ArrayList)localObject).get(1));
        }
      }
    }
    for (paramStringBuilder = paramList;; paramStringBuilder = null)
    {
      int i;
      if ((localStringBuilder.length() > 0) && (localbbzd.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null))
      {
        localbbzd.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        if ((TextUtils.isEmpty(localbbzd.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName)) && (paramStringBuilder != null) && (!TextUtils.isEmpty(localbbzd.jdField_a_of_type_JavaLangString)) && (localbbzd.jdField_a_of_type_JavaLangString.length() >= paramStringBuilder.textLen + paramStringBuilder.startPos))
        {
          localbbzd.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo = paramStringBuilder;
          localObject = localbbzd.jdField_a_of_type_JavaLangString;
          localbbzd.jdField_a_of_type_JavaLangString = "";
          if (paramStringBuilder.startPos > 0) {
            localbbzd.jdField_a_of_type_JavaLangString = ((String)localObject).substring(0, paramStringBuilder.startPos);
          }
          paramList = "";
          i = paramStringBuilder.startPos + paramStringBuilder.textLen;
          if (i + 1 < ((String)localObject).length()) {
            paramList = ((String)localObject).substring(i, i + 1);
          }
          if (!paramList.equals(" ")) {
            break label379;
          }
        }
      }
      label379:
      for (localbbzd.jdField_a_of_type_JavaLangString += ((String)localObject).substring(i + 1);; localbbzd.jdField_a_of_type_JavaLangString += ((String)localObject).substring(i))
      {
        localbbzd.b = ((String)localObject).substring(paramStringBuilder.startPos, paramStringBuilder.startPos + paramStringBuilder.textLen);
        if ((paramStringBuilder.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin())) && (localbbze.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo == null)) {
          parambepr.jdField_a_of_type_Beps.b(24, -1L);
        }
        return localbbzd;
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
          break label593;
        }
        bool = true;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        try
        {
          for (;;)
          {
            paramStringBuilder.msgData = aopw.a(paramElem);
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
            break label637;
          }
          paramElem.faceName = paramStringBuilder.substring(1, paramStringBuilder.length() - 1);
        }
        paramStringBuilder = (MessageForMarketFace)bbzh.a(-2007);
        paramStringBuilder.msgtype = -2007;
        paramStringBuilder.msg = "it is marketface";
        paramStringBuilder.mMarkFaceMessage = paramElem;
        if ((paramElem.mobileparam != null) && (paramElem.mobileparam.length > 0)) {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, "CliOper", "", "", "MbJieshou", "MbXiaoxi", 0, 0, "", "", "", "");
        }
      }
    }
    label593:
    label637:
    return null;
  }
  
  public MessageForDeliverGiftTips a(String paramString1, String paramString2, im_msg_body.DeliverGiftMsg paramDeliverGiftMsg, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:GiftMsg;\n");
    }
    int i = paramDeliverGiftMsg.uint32_animation_package_id.get();
    int j = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
    if ((i == 0) && ((j < 1000) || (j > 2000)))
    {
      paramStringBuilder = (MessageForDeliverGiftTips)bbzh.a(-2035);
      paramStringBuilder.msgtype = -2035;
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
      if (paramDeliverGiftMsg.bytes_receiver_name.has()) {
        paramStringBuilder.receiverName = paramDeliverGiftMsg.bytes_receiver_name.get().toStringUtf8();
      }
      if (paramDeliverGiftMsg.bytes_receiver_pic.has()) {
        paramStringBuilder.receiverHead = paramDeliverGiftMsg.bytes_receiver_pic.get().toStringUtf8();
      }
      if (paramDeliverGiftMsg.bytes_pb_reserve.has()) {
        paramString1 = new ResvAttrForGiftMsg.ResvAttr();
      }
    }
    for (;;)
    {
      try
      {
        paramString1.mergeFrom(paramDeliverGiftMsg.bytes_pb_reserve.get().toByteArray());
        paramStringBuilder.sendScore = paramString1.int32_send_score.get();
        paramStringBuilder.recvScore = paramString1.int32_recv_score.get();
        if (paramString1.bytes_charm_heroism.has()) {
          paramStringBuilder.charmHeroism = paramString1.bytes_charm_heroism.get().toStringUtf8();
        }
        paramStringBuilder.btFlag = paramString1.uint32_button_flag.get();
        paramStringBuilder.objColor = paramString1.uint32_obj_color.get();
        if (!paramString1.activity_gift_info.has()) {
          continue;
        }
        ResvAttrForGiftMsg.ActivityGiftInfo localActivityGiftInfo = (ResvAttrForGiftMsg.ActivityGiftInfo)paramString1.activity_gift_info.get();
        paramStringBuilder.is_activity_gift = localActivityGiftInfo.is_activity_gift.get();
        paramStringBuilder.activity_text_color = localActivityGiftInfo.text_color.get();
        paramStringBuilder.activity_text = localActivityGiftInfo.text.get();
        paramStringBuilder.activity_url = localActivityGiftInfo.url.get();
        paramStringBuilder.animationType = paramString1.uint32_animation_type.get();
        if (paramString1.msg_interact_gift.has()) {
          paramStringBuilder.interactId = paramString1.msg_interact_gift.bytes_interact_id.get().toStringUtf8();
        }
      }
      catch (InvalidProtocolBufferMicroException paramString1)
      {
        paramString1.printStackTrace();
        continue;
        if ((paramStringBuilder.remindBrief == null) || (paramStringBuilder.remindBrief.split("#").length <= 1)) {
          continue;
        }
        paramStringBuilder.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramStringBuilder.remindBrief.split("#")[1]);
        continue;
      }
      paramStringBuilder.rcvName = paramString2;
      if (paramDeliverGiftMsg.bytes_comefrom_link.has()) {
        paramStringBuilder.jumpUrl = paramDeliverGiftMsg.bytes_comefrom_link.get().toStringUtf8();
      }
      paramString1 = (bfuk)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getManager(81);
      if (paramString1 != null)
      {
        paramStringBuilder.grayTipsEntity = new TroopTipsEntity();
        paramStringBuilder.grayTipsEntity.isSupportImage = true;
        paramStringBuilder.grayTipsEntity.troopUin = String.valueOf(paramMsg.msg_head.group_info.group_code.get());
        paramStringBuilder.grayTipsEntity.optContent = paramStringBuilder.grayTipContent;
        paramString1.a(paramStringBuilder.grayTipsEntity);
        paramStringBuilder.msg = paramStringBuilder.grayTipsEntity.optContent;
        if ((paramStringBuilder instanceof MessageForTroopGift))
        {
          paramString1 = (MessageForTroopGift)paramStringBuilder;
          paramString1.bagId = paramDeliverGiftMsg.bytes_to_all_gift_id.get().toStringUtf8();
          paramString1.title = paramDeliverGiftMsg.bytes_stmessage_title.get().toStringUtf8();
          paramString1.subtitle = paramDeliverGiftMsg.bytes_stmessage_subtitle.get().toStringUtf8();
          paramString1.message = paramDeliverGiftMsg.bytes_stmessage_message.get().toStringUtf8();
          paramString1.giftPicId = paramDeliverGiftMsg.uint32_stmessage_giftpicid.get();
          paramString1.comefrom = paramDeliverGiftMsg.bytes_stmessage_comefrom.get().toStringUtf8();
          paramString1.exflag = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
          if (paramDeliverGiftMsg.bytes_stmessage_gifturl.has()) {
            paramString1.giftUrl = paramDeliverGiftMsg.bytes_stmessage_gifturl.get().toStringUtf8();
          }
        }
        if (TextUtils.isEmpty(paramStringBuilder.summary)) {
          paramStringBuilder.summary = paramStringBuilder.msg;
        }
        if (paramStringBuilder.grayTipsEntity.highlightNum != 0) {
          bfuk.a(paramStringBuilder, paramStringBuilder.grayTipsEntity.highlightItems);
        }
        if ((paramStringBuilder instanceof MessageForTroopGift)) {
          ((MessageForTroopGift)paramStringBuilder).prewrite();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin() == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin().equals(paramStringBuilder.receiverUin + ""))) {
          continue;
        }
        if (paramStringBuilder.remindBrief != null) {
          paramStringBuilder.saveExtInfoToExtStr("troop_send_gift_ext_remind", paramStringBuilder.remindBrief.split("#")[0]);
        }
        paramList.add(paramStringBuilder);
      }
      if ((paramStringBuilder instanceof MessageForTroopGift))
      {
        paramString1 = (MessageForTroopGift)paramStringBuilder;
        paramString1.bagId = paramDeliverGiftMsg.bytes_to_all_gift_id.get().toStringUtf8();
        paramString1.title = paramDeliverGiftMsg.bytes_stmessage_title.get().toStringUtf8();
        paramString1.subtitle = paramDeliverGiftMsg.bytes_stmessage_subtitle.get().toStringUtf8();
        paramString1.message = paramDeliverGiftMsg.bytes_stmessage_message.get().toStringUtf8();
        paramString1.giftPicId = paramDeliverGiftMsg.uint32_stmessage_giftpicid.get();
        paramString1.comefrom = paramDeliverGiftMsg.bytes_stmessage_comefrom.get().toStringUtf8();
        paramString1.exflag = paramDeliverGiftMsg.uint32_stmessage_exflag.get();
        if (paramDeliverGiftMsg.bytes_stmessage_gifturl.has()) {
          paramString1.giftUrl = paramDeliverGiftMsg.bytes_stmessage_gifturl.get().toStringUtf8();
        }
        ((MessageForTroopGift)paramStringBuilder).prewrite();
      }
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "MessageProtoCodec.decodePBMsgElems  decode send gift gray tips" + paramStringBuilder.msg);
      }
      if ((paramStringBuilder.summary != null) && (paramStringBuilder.rcvName != null) && (paramStringBuilder.rcvName.length() > 0))
      {
        paramDeliverGiftMsg = Pattern.compile(anni.a(2131705432));
        paramString2 = paramStringBuilder.msg;
        paramString1 = paramString2;
        if (!paramStringBuilder.isToAll())
        {
          paramString1 = paramString2;
          if (paramStringBuilder.msg.startsWith("["))
          {
            i = paramStringBuilder.msg.indexOf("]");
            paramString1 = paramString2;
            if (i != -1)
            {
              paramString1 = paramString2;
              if (i < paramStringBuilder.msg.length()) {
                paramString1 = paramStringBuilder.msg.substring(i + 1);
              }
            }
          }
        }
        paramString2 = paramDeliverGiftMsg.matcher(paramString1);
        if (paramString2.find())
        {
          paramString2 = paramString2.group();
          i = paramString1.indexOf(paramString2);
          j = paramString1.lastIndexOf(paramString2);
          if ((i > 0) && (j == i)) {
            paramStringBuilder.senderName = paramString1.substring(0, i);
          }
        }
      }
      return paramStringBuilder;
      paramStringBuilder = (MessageForTroopGift)bbzh.a(-2038);
      paramStringBuilder.msgtype = -2038;
      break;
      paramStringBuilder.is_activity_gift = 0;
    }
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
          localStringBuilder1.append(bbzj.a(((im_msg_body.Text)localObject).str.get().toStringUtf8(), false));
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
            m = arvq.b(((im_msg_body.Face)((im_msg_body.Elem)localObject).face.get()).index.get());
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
            char[] arrayOfChar = arpm.a(i, m);
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
      int i = arvq.b(((hummer_commelem.MsgElemInfo_servtype33)localObject).uint32_index.get());
      localObject = str;
      if (i >= 0) {
        localObject = arvq.b(i);
      }
      return localObject;
    }
    catch (InvalidProtocolBufferMicroException paramCommonElem)
    {
      paramCommonElem.printStackTrace();
    }
    return "";
  }
  
  public StringBuilder a(StringBuilder paramStringBuilder1, List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder2, long paramLong, bepr parambepr, bbze parambbze, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    bbze localbbze = parambbze;
    if (parambbze == null) {
      localbbze = new bbze();
    }
    Object localObject2 = null;
    Object localObject1 = localbbze.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo;
    parambbze = null;
    if (paramStringBuilder1 != null) {}
    int i;
    for (StringBuilder localStringBuilder = new StringBuilder(paramStringBuilder1);; localStringBuilder = new StringBuilder(""))
    {
      i = 0;
      Iterator localIterator = paramList.iterator();
      paramStringBuilder1 = (StringBuilder)localObject2;
      paramList = (List<im_msg_body.Elem>)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1268;
        }
        localObject1 = (im_msg_body.Elem)localIterator.next();
        if (!((im_msg_body.Elem)localObject1).text.has()) {
          break label630;
        }
        if (QLog.isColorLevel()) {
          paramStringBuilder2.append("elemType:Text;\n");
        }
        if (i == 0) {
          break;
        }
        i = 0;
      }
    }
    localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject1).text.get();
    int m = localStringBuilder.length();
    if (((im_msg_body.Text)localObject1).str.has()) {
      localStringBuilder.append(bbzj.a(((im_msg_body.Text)localObject1).str.get().toStringUtf8(), false));
    }
    label219:
    int k;
    int j;
    label274:
    label377:
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo;
    if (((im_msg_body.Text)localObject1).attr_6_buf.has())
    {
      localObject1 = ((im_msg_body.Text)localObject1).attr_6_buf.get();
      if (localObject1 != null)
      {
        localObject2 = ((ByteStringMicro)localObject1).toByteArray();
        if ((parambepr != null) && ((parambepr.jdField_a_of_type_Int == 3000) || (parambepr.jdField_a_of_type_Int == 1)) && (paramArrayList != null) && (localObject2 != null) && (localObject2.length != 0))
        {
          n = bgva.a((byte[])localObject2, 0);
          k = 2;
          j = 0;
          if ((j < n) && (k < 2048))
          {
            localObject1 = new MessageForText.AtTroopMemberInfo();
            if (((MessageForText.AtTroopMemberInfo)localObject1).readFrom((byte[])localObject2, k)) {
              break label471;
            }
          }
        }
        if ((parambepr == null) || ((!parambepr.jdField_a_of_type_Beps.a(24, paramLong)) && (!parambepr.jdField_a_of_type_Beps.a(13, paramLong)) && (paramList != null)) || (localObject2 == null) || (localObject2.length == 0)) {
          break label1406;
        }
        int n = bgva.a((byte[])localObject2, 0);
        k = 2;
        j = 0;
        localObject1 = paramStringBuilder1;
        if ((j >= n) || (k >= 2048)) {
          break label1398;
        }
        localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
        paramStringBuilder1 = (StringBuilder)localObject1;
        if (j == 0)
        {
          paramStringBuilder1 = (StringBuilder)localObject1;
          if (localObject1 == null) {
            paramStringBuilder1 = localAtTroopMemberInfo;
          }
        }
        if (localAtTroopMemberInfo.readFrom((byte[])localObject2, k)) {
          break label513;
        }
        localObject1 = paramList;
        paramList = paramStringBuilder1;
        paramStringBuilder1 = (StringBuilder)localObject1;
      }
    }
    for (;;)
    {
      localObject1 = parambbze;
      parambbze = paramList;
      paramList = paramStringBuilder1;
      paramStringBuilder1 = (StringBuilder)localObject1;
      label452:
      localObject1 = parambbze;
      parambbze = paramStringBuilder1;
      paramStringBuilder1 = (StringBuilder)localObject1;
      break;
      localObject2 = null;
      break label219;
      label471:
      k += ((MessageForText.AtTroopMemberInfo)localObject1).length();
      ((MessageForText.AtTroopMemberInfo)localObject1).startPos = ((short)(((MessageForText.AtTroopMemberInfo)localObject1).startPos + m));
      j = (short)(j + 1);
      paramArrayList.add(localObject1);
      break label274;
      label513:
      k += localAtTroopMemberInfo.length();
      localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + m));
      j = (short)(j + 1);
      if (localAtTroopMemberInfo.isIncludingAll()) {
        parambepr.jdField_a_of_type_Beps.b(13, paramLong);
      }
      if (localAtTroopMemberInfo.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin()))
      {
        parambepr.jdField_a_of_type_Beps.b(24, paramLong);
        if ((localAtTroopMemberInfo != paramStringBuilder1) && (paramList == null) && (paramStringBuilder1.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin()))) {
          paramList = localAtTroopMemberInfo;
        }
      }
      for (;;)
      {
        localObject1 = paramStringBuilder1;
        break label377;
        label630:
        if (((im_msg_body.Elem)localObject1).face.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:Face;\n");
          }
          if (!((im_msg_body.Face)((im_msg_body.Elem)localObject1).face.get()).index.has()) {
            break label1255;
          }
          j = arvq.b(((im_msg_body.Face)((im_msg_body.Elem)localObject1).face.get()).index.get());
          if (j >= 0)
          {
            localStringBuilder.append('\024');
            localStringBuilder.append((char)j);
          }
          localObject1 = paramStringBuilder1;
          paramStringBuilder1 = parambbze;
          parambbze = (bbze)localObject1;
          break label452;
        }
        if (((im_msg_body.Elem)localObject1).small_emoji.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:small_emoji;\n");
          }
          if (!((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject1).small_emoji.get()).packIdSum.has()) {
            break label1255;
          }
          i = (((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject1).small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
          j = 0xFFFF & ((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject1).small_emoji.get()).packIdSum.get();
          localObject2 = arpm.a(i, j);
          if ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject1).small_emoji.get()).imageType.has()) && ((((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject1).small_emoji.get()).imageType.get() & 0xFFFF) == 2))
          {
            localObject2[3] = 511;
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "get apng epid = " + i + " eid = " + j);
            }
          }
          localStringBuilder.append('\024');
          localStringBuilder.append(localObject2[3]);
          localStringBuilder.append(localObject2[2]);
          localStringBuilder.append(localObject2[1]);
          localStringBuilder.append(localObject2[0]);
          i = 1;
          localObject1 = paramStringBuilder1;
          paramStringBuilder1 = parambbze;
          parambbze = (bbze)localObject1;
          break label452;
        }
        if (((im_msg_body.Elem)localObject1).online_image.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:OnlineImage;\n");
          }
          localStringBuilder.append(BaseApplication.getContext().getString(2131694102));
          localObject1 = paramStringBuilder1;
          paramStringBuilder1 = parambbze;
          parambbze = (bbze)localObject1;
          break label452;
        }
        if (((im_msg_body.Elem)localObject1).bankcode_ctrl_info.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType: bankcode_ctrlinfo;\n");
          }
          localObject2 = ((im_msg_body.Elem)localObject1).bankcode_ctrl_info.get().toByteArray();
          j = localObject2[0];
          k = localObject2[(localObject2.length - 1)];
          if ((j != 40) || (k != 41))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            paramStringBuilder2.append("elemType: bankcode_ctrlinfo buffer error;\n");
            break;
          }
          if (ByteBuffer.wrap((byte[])localObject2, 2, 2).getShort() != 29786) {
            break;
          }
          j = ByteBuffer.wrap((byte[])localObject2, 4, 2).getShort();
          if (j <= 0) {
            break;
          }
          localObject1 = new byte[j];
          System.arraycopy(localObject2, 6, localObject1, 0, j);
          parambbze = paramStringBuilder1;
          paramStringBuilder1 = (StringBuilder)localObject1;
          break label452;
        }
        if ((((im_msg_body.Elem)localObject1).common_elem.has()) && (33 == ((im_msg_body.Elem)localObject1).common_elem.uint32_service_type.get()))
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:NewSysFaceMsg;\n");
          }
          localStringBuilder.append(a((im_msg_body.CommonElem)((im_msg_body.Elem)localObject1).common_elem.get()));
        }
        label1255:
        localObject1 = paramStringBuilder1;
        paramStringBuilder1 = parambbze;
        parambbze = (bbze)localObject1;
        break label452;
        label1268:
        localbbze.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo = paramList;
        paramList = localbbze.jdField_a_of_type_JavaUtilArrayList;
        if ((paramList != null) && ((paramStringBuilder1 != null) || (parambbze != null)))
        {
          if (!paramList.isEmpty()) {
            break label1316;
          }
          paramList.add(paramStringBuilder1);
          paramList.add(parambbze);
        }
        label1316:
        while ((paramList.size() != 2) || ((paramList.get(0) != null) && (paramList.get(1) != null))) {
          return localStringBuilder;
        }
        if (paramList.get(0) == null) {
          if (paramList.get(1) != null) {
            break label1385;
          }
        }
        for (;;)
        {
          paramList.clear();
          paramList.add(paramStringBuilder1);
          paramList.add(parambbze);
          return localStringBuilder;
          paramStringBuilder1 = paramList.get(0);
          break;
          label1385:
          parambbze = paramList.get(1);
        }
      }
      label1398:
      paramStringBuilder1 = paramList;
      paramList = (List<im_msg_body.Elem>)localObject1;
      continue;
      label1406:
      localObject1 = paramStringBuilder1;
      paramStringBuilder1 = paramList;
      paramList = (List<im_msg_body.Elem>)localObject1;
    }
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
      localObject1 = bcwd.a(((im_msg_body.MarketTrans)localObject1).bytes_xml.get().toByteArray(), i);
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
      paramList = (MessageForStructing)bbzh.a(-2011);
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
    Object localObject1 = null;
    Object localObject3 = paramList.iterator();
    Object localObject2 = null;
    if (((Iterator)localObject3).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject3).next();
      if (localElem.trans_elem_info.has()) {
        localObject2 = (im_msg_body.TransElem)localElem.trans_elem_info.get();
      }
      if (!localElem.general_flags.has()) {
        break label1594;
      }
      localObject1 = (im_msg_body.GeneralFlags)localElem.general_flags.get();
    }
    label1206:
    label1594:
    for (;;)
    {
      break;
      if (localObject2 == null) {}
      int i;
      int j;
      StringBuilder localStringBuilder;
      label444:
      label449:
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("elemType:TransElemInfo;\n");
            }
            i = ((im_msg_body.TransElem)localObject2).elem_type.get();
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("transElemType:").append(i).append(";\n");
            }
            localObject3 = ((im_msg_body.TransElem)localObject2).elem_value.get().toByteArray();
            if ((localObject3 == null) || (localObject3.length == 0))
            {
              paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
              return;
            }
            switch (i)
            {
            default: 
              return;
            case 3: 
              paramList = BaseApplication.getContext().getString(2131694102);
              paramStringBuilder = (MessageForText)bbzh.a(-1000);
              paramStringBuilder.msgtype = -1000;
              paramStringBuilder.msg = paramList;
              paramList1.add(paramStringBuilder);
              return;
            }
          } while (localObject3[0] != 1);
          i = bgva.a((byte[])localObject3, 1);
          j = localObject3[3];
          localObject2 = new byte[i - 1];
          bgva.a((byte[])localObject2, 0, (byte[])localObject3, 4, i - 1);
          paramStringBuilder = (StringBuilder)localObject2;
          if (j == 1) {
            paramStringBuilder = a((byte[])localObject2);
          }
          if (paramStringBuilder == null) {
            break label1586;
          }
          try
          {
            if (paramStringBuilder.length <= 0) {
              break label1586;
            }
            paramStringBuilder = new String(paramStringBuilder, "utf-8");
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              long l;
              paramList = "";
              paramStringBuilder = null;
            }
          }
          try
          {
            localObject2 = a(paramStringBuilder);
            if (localObject2 == null) {
              break label627;
            }
            try
            {
              paramList = paramList.iterator();
              while (paramList.hasNext())
              {
                localObject3 = (im_msg_body.Elem)paramList.next();
                if ((((im_msg_body.Elem)localObject3).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject3).elem_flags2.get()).uint64_msg_id.has())) {
                  ((PAMessage)localObject2).mMsgId = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject3).elem_flags2.get()).uint64_msg_id.get();
                }
              }
              ((Exception)localObject2).printStackTrace();
            }
            catch (Exception localException4)
            {
              paramList = (List<im_msg_body.Elem>)localObject2;
              localObject2 = localException4;
              localStringBuilder = paramStringBuilder;
              paramStringBuilder = paramList;
              paramList = localStringBuilder;
            }
          }
          catch (Exception localException3)
          {
            localStringBuilder = null;
            paramList = paramStringBuilder;
            paramStringBuilder = localStringBuilder;
            break label444;
            paramList = null;
            break label1380;
          }
          if (!paramMsg.msg_head.from_uin.has()) {
            break;
          }
          l = paramMsg.msg_head.from_uin.get();
        } while (ahdq.a(l + ""));
      } while (paramStringBuilder == null);
      paramMsg = (MessageForPubAccount)bbzh.a(-3006);
      paramMsg.msgtype = -3006;
      paramMsg.msg = paramList.toString();
      paramMsg.mPAMessage = paramStringBuilder;
      for (;;)
      {
        for (;;)
        {
          try
          {
            paramMsg.msgData = txp.a(paramStringBuilder);
            if ((localObject1 == null) || (!((im_msg_body.GeneralFlags)localObject1).bytes_pb_reserve.has())) {}
          }
          catch (Exception paramList)
          {
            try
            {
              paramList = new generalflags.ResvAttr();
              paramList.mergeFrom(((im_msg_body.GeneralFlags)localObject1).bytes_pb_reserve.get().toByteArray());
              if (paramList.bytes_oac_msg_extend.has()) {
                paramMsg.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", paramList.bytes_oac_msg_extend.get().toStringUtf8());
              }
              paramList1.add(paramMsg);
              return;
              label627:
              paramList = paramStringBuilder;
              paramStringBuilder = (StringBuilder)localObject2;
              break label449;
              paramList = paramList;
              paramList.printStackTrace();
            }
            catch (Throwable paramList)
            {
              QLog.e("DecodeMsg", 2, "decodePBMsgElems_TransElemInfo()-MessageForPubAccount: parse generalflags error! " + QLog.getStackTraceString(paramList));
              continue;
            }
          }
          int k = ((im_msg_body.TransElem)localObject2).elem_value.get().size();
          j = 0;
          i = 0;
          for (;;)
          {
            if (k <= 3) {
              break label850;
            }
            int m = j + 1;
            if (j > 100) {
              break;
            }
            int n = localStringBuilder[i];
            int i1 = bgva.a(localStringBuilder, i + 1);
            j = k - (i1 + 3);
            k = i1 + 3 + i;
            if (n != 1)
            {
              i = k;
              k = j;
              j = m;
            }
            else
            {
              paramList = new byte[i1];
              bgva.a(paramList, 0, localStringBuilder, i + 3, i1);
              paramStringBuilder = new obj_msg.ObjMsg();
              try
              {
                paramList = (obj_msg.ObjMsg)paramStringBuilder.mergeFrom(paramList);
                if (paramList.uint32_msg_type.get() == 6L) {
                  break label852;
                }
                i = k;
                k = j;
                j = m;
              }
              catch (Exception paramList)
              {
                i = k;
                k = j;
                j = m;
              }
            }
          }
          label850:
          break;
          label852:
          paramStringBuilder = new TroopFileData();
          paramStringBuilder.fileUrl = new String(((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_file_path.get().toByteArray());
          paramStringBuilder.bisID = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.uint32_bus_id.get();
          paramStringBuilder.fileName = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.str_file_name.get();
          paramStringBuilder.lfileSize = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.uint64_file_size.get();
          paramStringBuilder.lastTime = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.int64_dead_time.get();
          paramStringBuilder.sha1 = new String(((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_file_sha1.get().toByteArray());
          paramStringBuilder.md5 = new String(((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_file_md5.get().toByteArray());
          paramStringBuilder.uuid = UUID.nameUUIDFromBytes(paramStringBuilder.fileUrl.getBytes()).toString();
          if (((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_ext.has()) {
            localObject1 = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
          }
          try
          {
            for (;;)
            {
              localObject1 = new JSONObject((String)localObject1);
              paramStringBuilder.width = ((JSONObject)localObject1).optInt("width");
              paramStringBuilder.height = ((JSONObject)localObject1).optInt("height");
              paramStringBuilder.duration = ((JSONObject)localObject1).optInt("duration");
              paramStringBuilder.yybApkPackageName = ((JSONObject)localObject1).optString("yyb_apk_package_name_key");
              paramStringBuilder.yybApkName = ((JSONObject)localObject1).optString("yyb_apk_name_key");
              paramStringBuilder.yybApkIconUrl = ((JSONObject)localObject1).optString("yyb_apk_icon_url_key");
              paramStringBuilder.dspFileName = new String(paramList.bytes_title.get().toByteArray());
              paramStringBuilder.dspFileName = atvo.a(paramStringBuilder.dspFileName);
              paramStringBuilder.dspFileSize = new String(((ByteStringMicro)paramList.rpt_bytes_abstact.get(0)).toByteArray());
              bfrg.a(paramMsg.msg_head.group_info.group_code.get()).a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramStringBuilder.fileUrl, paramStringBuilder);
              localObject1 = new StringBuilder("decodePBMshElems==>").append(paramStringBuilder.toString());
              paramList = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramMsg.msg_head.group_info.group_code.get()).a(paramStringBuilder.fileUrl);
              if (paramList != null)
              {
                paramList = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.a().a(paramList.e);
                if (paramList != null) {
                  paramList.lastTime = paramStringBuilder.lastTime;
                }
                label1380:
                localObject2 = (MessageForTroopFile)bbzh.a(-2017);
                ((MessageForTroopFile)localObject2).msgtype = -2017;
                ((MessageForTroopFile)localObject2).msg = anni.a(2131705435);
                try
                {
                  ((MessageForTroopFile)localObject2).msgData = aopw.a(paramStringBuilder);
                  ((MessageForTroopFile)localObject2).parse();
                  paramList1.add(localObject2);
                  if (paramList != null)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.a().a(paramMsg.msg_head.group_info.group_code.get() + "", 1, paramList.structMsgSeq, ((MessageForTroopFile)localObject2).msgData);
                    ((StringBuilder)localObject1).append("|updateMsgContentByUniseq, msgSeq:").append(paramList.structMsgSeq);
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("DecodeMsg", 2, "<TroopFile> " + ((StringBuilder)localObject1).toString());
                  return;
                }
                catch (Exception paramStringBuilder)
                {
                  for (;;)
                  {
                    paramStringBuilder.printStackTrace();
                  }
                }
              }
            }
          }
          catch (Exception localException1)
          {
            break label1206;
          }
        }
        paramList = "";
        paramStringBuilder = null;
      }
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr)
  {
    int j = 0;
    Object localObject1 = null;
    Object localObject2 = paramList.iterator();
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if (!((im_msg_body.Elem)localObject3).common_elem.has()) {
        break label872;
      }
      localObject1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject3).common_elem.get();
    }
    label572:
    label589:
    label872:
    for (;;)
    {
      break;
      localObject3 = a(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("DecodeMsg", 2, "decodePBMsgElems_FlashChat  common_lem" + localObject1 + ", text " + (String)localObject3);
      }
      if (localObject1 == null) {
        return;
      }
      if (((im_msg_body.CommonElem)localObject1).uint32_business_type.has()) {}
      for (int i = ((im_msg_body.CommonElem)localObject1).uint32_business_type.get();; i = 0)
      {
        localObject2 = new hummer_commelem.MsgElemInfo_servtype14();
        try
        {
          ((hummer_commelem.MsgElemInfo_servtype14)localObject2).mergeFrom(((im_msg_body.CommonElem)localObject1).bytes_pb_elem.get().toByteArray());
          if (i != 0) {
            break label589;
          }
          if (!((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a())
          {
            f(paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramList)
        {
          paramList.printStackTrace();
          return;
        }
        if (!ArkUtil.isDeviceSupportArkMsg())
        {
          QLog.i("FlashChat", 1, "decodePBMsgElems_FlashChat is false, ignore msg.");
          return;
        }
        if ((!((hummer_commelem.MsgElemInfo_servtype14)localObject2).uint32_id.has()) || (!((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.has())) {
          break;
        }
        int k = ((hummer_commelem.MsgElemInfo_servtype14)localObject2).uint32_id.get();
        String str = ((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.get().toStringUtf8();
        if (!((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.has())
        {
          QLog.i("flashchat", 1, "ecodePBMsgElems_FlashChat, reserve_Info not exist.");
          return;
        }
        localObject2 = ((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.get().toByteArray();
        if ((localObject2 == null) || (localObject2.length <= 0))
        {
          QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat, reserve_Info empty.");
          return;
        }
        localObject1 = null;
        localObject2 = bcxm.a((byte[])localObject2, -1);
        if (localObject2 != null)
        {
          i = localObject2.length;
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
                label372:
                QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat convert failed");
              }
            }
            localObject2 = new ArkFlashChatMessage();
            ((ArkFlashChatMessage)localObject2).fromAppXml((String)localObject1);
            ((ArkFlashChatMessage)localObject2).appResId = k;
            ((ArkFlashChatMessage)localObject2).promptText = ((String)localObject3);
            localObject3 = (MessageForArkFlashChat)bbzh.a(-5013);
            ((MessageForArkFlashChat)localObject3).msgtype = -5013;
            ((MessageForArkFlashChat)localObject3).msgData = ((ArkFlashChatMessage)localObject2).toBytes();
            ((MessageForArkFlashChat)localObject3).parse();
            if ((TextUtils.isEmpty(((MessageForArkFlashChat)localObject3).ark_app_message.appName)) || (TextUtils.isEmpty(((MessageForArkFlashChat)localObject3).ark_app_message.appView))) {
              break label572;
            }
            paramList1.add(localObject3);
          }
        }
        for (i = 1;; i = j)
        {
          QLog.d("flashchat", 2, "decodePBMsgElems_FlashChat id = " + k + ", reserveInfo = " + str + ", arkData = " + (String)localObject1);
          if (i != 0) {
            break;
          }
          f(paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
          return;
          QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat empty.");
          break label372;
          QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat not valid..");
        }
        if ((i != 1) || (!localException.uint32_id.has())) {
          break;
        }
        i = localException.uint32_id.get();
        if (localException.reserve_Info.has())
        {
          paramList = localException.reserve_Info.get().toByteArray();
          paramStringBuilder = new hiboom_type.Hiboom_Type();
          paramStringBuilder.mergeFrom(paramList);
          if (paramStringBuilder.uint32_hiboom_type.has())
          {
            j = paramStringBuilder.uint32_hiboom_type.get();
            if (auzk.a(j))
            {
              paramStringBuilder = new HiBoomMessage();
              paramStringBuilder.id = i;
              paramStringBuilder.text = ((String)localObject3);
              paramStringBuilder.type = j;
              paramList = (MessageForHiBoom)bbzh.a(-5014);
              paramList.mHiBoomMessage = paramStringBuilder;
              paramList.msgtype = -5014;
              paramList.msg = ((String)localObject3);
              try
              {
                paramList.msgData = aopw.a(paramStringBuilder);
                if (QLog.isColorLevel()) {
                  QLog.d("HiBoomFont.MessagePBElemDecoder", 2, "receive hiboom message id = " + i + "message = " + ((String)localObject3).charAt(0));
                }
                paramList1.add(paramList);
                return;
              }
              catch (Exception paramStringBuilder)
              {
                for (;;)
                {
                  QLog.e("HiBoomFont.MessagePBElemDecoder", 1, "getBytesFromObject error, ", paramStringBuilder);
                }
              }
            }
            QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom type not support: type = " + j);
            return;
          }
          QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom no type");
          return;
        }
        QLog.i("HiBoomFont", 1, "decodePBMsgElems_Hiboom no reserve_info");
        return;
      }
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr, boolean paramBoolean)
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
          b(localArrayList, paramList1, paramStringBuilder, paramMsg, parambepr, paramBoolean);
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
              ((MessageRecord)paramList1.get(paramList1.size() - 1)).msgData = aopw.a(paramList);
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
      b(localArrayList, paramList1, paramStringBuilder, paramMsg, parambepr, paramBoolean);
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
            paramList = (aopm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(199);
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
  
  public void a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean, bepr parambepr)
  {
    if (paramElem != null) {}
    for (boolean bool1 = paramElem.hc_flash_pic.has();; bool1 = false)
    {
      if (paramCustomFace != null) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:CustomFace: isC2C:").append(paramBoolean).append(";\n");
        }
        StringBuilder localStringBuilder = new StringBuilder("");
        if (paramBoolean)
        {
          localStringBuilder.append(BaseApplication.getContext().getString(2131694102));
          paramElem = (msg_comm.MsgHead)paramMsg.msg_head.get();
          l1 = paramElem.msg_seq.get();
          l2 = paramElem.msg_uid.get();
          long l3 = paramElem.msg_time.get();
          long l4 = paramElem.from_uin.get();
          long l5 = paramElem.to_uin.get();
          paramElem = new HashMap();
          paramElem.put("param_FailCode", String.valueOf(10001));
          paramElem.put("fromUin", String.valueOf(l4));
          paramElem.put("toUin", String.valueOf(l5));
          paramElem.put("msgSeq", String.valueOf(l1));
          paramElem.put("msgUid", String.valueOf(l2));
          paramElem.put("msgtime", String.valueOf(l3));
          paramCustomFace = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin();
          bctj.a(BaseApplication.getContext()).a(paramCustomFace, "actMessageEvent", false, 0L, 0L, paramElem, "");
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElems_CustomFace isC2C");
          }
          return;
        }
        if ((localStringBuilder.length() > 0) && (!bool1) && (!bool2))
        {
          localObject1 = (MessageForText)bbzh.a(-1000);
          ((MessageForText)localObject1).msgtype = -1000;
          ((MessageForText)localObject1).msg = localStringBuilder.toString();
          paramList.add(localObject1);
          localStringBuilder.delete(0, localStringBuilder.length());
        }
        Object localObject1 = null;
        if (paramCustomFace != null) {}
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElems_CustomFace hasComFlashPic=" + bool2);
          }
          if (paramCustomFace != null) {
            break;
          }
          QLog.d("DecodeMsg", 2, "parsePBMsgElems_CustomFace customface is null");
          return;
          paramCustomFace = (im_msg_body.CustomFace)localObject1;
          if (paramElem != null) {
            if (bool1) {
              paramCustomFace = (im_msg_body.CustomFace)paramElem.hc_flash_pic.get();
            } else {
              paramCustomFace = (im_msg_body.CustomFace)paramElem.custom_face.get();
            }
          }
        }
        paramElem = paramCustomFace.str_file_path.get();
        paramCustomFace.str_shortcut.get();
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
        long l2 = paramCustomFace.uint32_file_type.get();
        l2 = paramCustomFace.uint32_server_ip.get();
        l2 = paramCustomFace.uint32_server_port.get();
        l2 = paramCustomFace.uint32_useful.get();
        l2 = paramCustomFace.uint32_size.get() & 0xFFFFFFFF;
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
        localObject1 = paramCustomFace.bytes_signature.get().toByteArray();
        paramCustomFace.bytes_buffer.get().toByteArray();
        Object localObject3 = paramCustomFace.bytes_flag.get().toByteArray();
        int i1 = (int)(paramCustomFace.uint32_width.get() & 0xFFFFFFFF);
        int i2 = (int)(paramCustomFace.uint32_height.get() & 0xFFFFFFFF);
        localObject2 = bgmj.a((byte[])localObject2);
        bgmj.a((byte[])localObject1);
        bgmj.a((byte[])localObject3);
        int i3 = paramCustomFace.uint32_origin.get();
        localObject3 = bdzh.a(paramElem, 0L, 1, false, paramElem, (String)localObject2, "picplatform", str3, str4, str1, str2, i3, 0);
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
          i = 0;
          if (paramCustomFace.bytes_pb_reserve.has()) {
            paramStringBuilder = new CustomFaceExtPb.ResvAttr();
          }
          for (;;)
          {
            try
            {
              paramStringBuilder.mergeFrom(paramCustomFace.bytes_pb_reserve.get().toByteArray());
              if (paramStringBuilder.msg_image_show.has())
              {
                paramElem = (MessageForPic)bbzh.a(-5015);
                paramElem.msgtype = -5015;
                ((MessageForTroopEffectPic)paramElem).effectId = ((CustomFaceExtPb.AnimationImageShow)paramStringBuilder.msg_image_show.get()).int32_effect_id.get();
                paramElem.frienduin = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.group_code.get());
                paramElem.istroop = 1;
                paramCustomFace = (bfos)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
                if (paramCustomFace != null) {
                  paramCustomFace.a((bfpg)paramElem, false);
                }
                i = 1;
                if (i == 0)
                {
                  paramElem = (MessageForPic)bbzh.a(-2000);
                  paramElem.msgtype = -2000;
                }
                if (bool1) {
                  annq.a(paramElem, false);
                }
                if (bool2) {
                  anlk.a(paramElem, false);
                }
                if (parambepr != null) {
                  paramElem.istroop = parambepr.jdField_a_of_type_Int;
                }
                paramElem.msgData = ((RichMsg.PicRec)localObject1).toByteArray();
                paramElem.parse();
                paramList.add(paramElem);
                localStringBuilder.delete(0, localStringBuilder.length());
                return;
              }
            }
            catch (InvalidProtocolBufferMicroException paramElem)
            {
              paramElem.printStackTrace();
              continue;
            }
            paramElem = null;
          }
        }
      }
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
  
  public boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean, bepr parambepr)
  {
    Object localObject2;
    String str1;
    Object localObject1;
    label81:
    im_msg_body.Elem localElem;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin() == paramMsg.msg_head.to_uin.get())
      {
        parambepr = paramMsg.msg_head.from_uin.get() + "";
        localObject2 = null;
        str1 = null;
        localObject1 = null;
        Iterator localIterator = paramList.iterator();
        paramList = (List<im_msg_body.Elem>)localObject2;
        if (!localIterator.hasNext()) {
          break label306;
        }
        localElem = (im_msg_body.Elem)localIterator.next();
        if (!localElem.pub_group.has()) {
          break label412;
        }
        str1 = localElem.pub_group.bytes_nickname.get().toStringUtf8();
      }
    }
    label412:
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
        break label81;
        parambepr = paramMsg.msg_head.to_uin.get() + "";
        break;
        if (parambepr != null) {}
        for (parambepr = parambepr.jdField_a_of_type_JavaLangString;; parambepr = paramMsg.msg_head.to_uin.get() + "") {
          break;
        }
        label306:
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
          paramList.frienduin = parambepr;
          paramList.isFromNearby = true;
          paramList1 = (bfos)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
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
      localMessageForIncompatibleGrayTips = (MessageForIncompatibleGrayTips)bbzh.a(-5002);
      if (localMessageForIncompatibleGrayTips.parseTextXML(paramList.text.get()).booleanValue())
      {
        paramList1.add(localMessageForIncompatibleGrayTips);
        return;
      }
    } while (!QLog.isColorLevel());
    paramStringBuilder.append("TipsInfo parse failed;\n");
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr)
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
      localObject2 = bcxm.a((byte[])localObject2, -1);
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
          localObject3 = (MessageForArkBabyqReply)bbzh.a(-5016);
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
        f(paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
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
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder("");
    int i = 0;
    bbze localbbze = new bbze();
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
            localMessageForText = (MessageForText)bbzh.a(-1000);
            localMessageForText.msgtype = -1000;
            localMessageForText.msg = ((StringBuilder)localObject1).toString();
            localMessageForText.atInfoList = ((ArrayList)localObject2);
            localObject3 = new ArrayList(2);
            localArrayList.add(localMessageForText);
            ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          }
          a(localElem, null, localArrayList, paramStringBuilder, paramMsg, paramBoolean, parambepr);
        }
        for (localObject2 = localObject3;; localObject2 = localObject3)
        {
          break;
          if (!localElem.not_online_image.has()) {
            break label299;
          }
          localObject3 = localObject2;
          if (((StringBuilder)localObject1).length() > 0)
          {
            localMessageForText = (MessageForText)bbzh.a(-1000);
            localMessageForText.msgtype = -1000;
            localMessageForText.msg = ((StringBuilder)localObject1).toString();
            localMessageForText.atInfoList = ((ArrayList)localObject2);
            localObject3 = new ArrayList(2);
            localArrayList.add(localMessageForText);
            ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          }
          a(localElem, null, localArrayList, paramStringBuilder, paramMsg);
        }
        label299:
        if (aczi.a(localElem).booleanValue())
        {
          if (i != 0)
          {
            i = 0;
            continue;
          }
          if (!localElem.small_emoji.has()) {
            break label646;
          }
          i = 1;
        }
      }
    }
    label646:
    for (;;)
    {
      localObject3 = new ArrayList();
      ((List)localObject3).add(localElem);
      localObject1 = a((StringBuilder)localObject1, (List)localObject3, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), parambepr, localbbze, (ArrayList)localObject2);
      break;
      if (localElem.general_flags.has())
      {
        localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
        break;
        if (((StringBuilder)localObject1).length() > 0)
        {
          localObject3 = (MessageForText)bbzh.a(-1000);
          ((MessageForText)localObject3).msgtype = -1000;
          ((MessageForText)localObject3).msg = ((StringBuilder)localObject1).toString();
          ((MessageForText)localObject3).atInfoList = ((ArrayList)localObject2);
          if (parambepr != null) {
            bfmd.a(parambepr.jdField_a_of_type_Int, (ArrayList)localObject2, (ChatMessage)localObject3);
          }
          localArrayList.add(localObject3);
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
        }
        localObject2 = localbbze.jdField_a_of_type_JavaUtilArrayList;
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
          a(paramList, paramStringBuilder, (MessageForText.AtTroopMemberInfo)localObject2, localArrayList, localbbze, parambepr);
          a(localGeneralFlags, localArrayList);
          b(localGeneralFlags, localArrayList);
          a(localArrayList, paramMsg, paramList1, (byte[])localObject1, parambepr, (MessageForText.AtTroopMemberInfo)localObject2);
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
        paramList = (MessageForQQStoryComment)bbzh.a(-2052);
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
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr)
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
            f(paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
            return;
          }
          paramList = (MessageForText)bbzh.a(-1000);
          paramList.msgtype = -1000;
          paramList.msg = BaseApplication.getContext().getString(2131693242);
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
            localObject1 = bcxm.a((byte[])localObject1, -1);
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
            a(localGeneralFlags, false, localObject2, paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
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
          paramList = (MessageForQQStoryComment)bbzh.a(-2052);
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
  
  public void d(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr)
  {
    Object localObject2 = null;
    Object localObject3 = paramList.iterator();
    Object localObject1 = null;
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (im_msg_body.Elem)((Iterator)localObject3).next();
      if (!((im_msg_body.Elem)localObject4).common_elem.has()) {
        break label464;
      }
      localObject1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject4).common_elem.get();
    }
    label437:
    label451:
    label464:
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
        localObject3 = bcxm.a((byte[])localObject3, -1);
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
            localObject3 = (MessageForArkApp)bbzh.a(-5017);
            ((MessageForArkApp)localObject3).msgtype = -5017;
            if (((im_msg_body.CommonElem)localObject1).uint32_business_type.get() == 1) {
              ((MessageForArkApp)localObject3).saveExtInfoToExtStr(bbyw.e, "1");
            }
            if (localObject4 != null) {
              ((MessageForArkApp)localObject3).compatibleMsg = ((String)localObject4);
            }
            localObject1 = new ArkAppMessage();
            ((ArkAppMessage)localObject1).fromAppXml(localObject2);
            ((MessageForArkApp)localObject3).msgData = ((ArkAppMessage)localObject1).toBytes();
            ((MessageForArkApp)localObject3).parse();
            if ((TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appName)) || (TextUtils.isEmpty(((MessageForArkApp)localObject3).ark_app_message.appView))) {
              break label437;
            }
            paramList1.add(localObject3);
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label451;
          }
          f(paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
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
        break label416;
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
        break label413;
      }
      paramList = (im_msg_body.Text)((im_msg_body.Elem)localObject).text.get();
      if (localCommonElem1 == null) {
        break;
      }
      localObject = paramList;
      localCommonElem2 = localCommonElem1;
    }
    label128:
    label413:
    label416:
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
          paramStringBuilder = (MessageForTroopStory)bbzh.a(-2057);
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
  
  public void e(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr)
  {
    MessageForQQWalletMsg.decodePBMsgElemWalletMsg(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
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
  
  public void f(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "begin decodePBMsgElems_RichMsg");
    }
    Object localObject4 = null;
    Object localObject6 = paramList.iterator();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject5;
    if (((Iterator)localObject6).hasNext())
    {
      localObject5 = (im_msg_body.Elem)((Iterator)localObject6).next();
      if (!((im_msg_body.Elem)localObject5).rich_msg.has()) {
        break label4262;
      }
    }
    label285:
    label2338:
    label4262:
    for (Object localObject1 = (im_msg_body.RichMsg)((im_msg_body.Elem)localObject5).rich_msg.get();; localObject1 = localObject2)
    {
      if (((im_msg_body.Elem)localObject5).general_flags.has()) {}
      for (localObject2 = (im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject5).general_flags.get();; localObject2 = localObject3)
      {
        if (((im_msg_body.Elem)localObject5).text.has()) {}
        for (localObject3 = (im_msg_body.Text)((im_msg_body.Elem)localObject5).text.get();; localObject3 = localObject4)
        {
          localObject5 = localObject2;
          localObject2 = localObject1;
          localObject4 = localObject3;
          localObject3 = localObject5;
          break;
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DecodeMsg", 2, "richMsg is null");
            }
            return;
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:RichMsg;\n");
          }
          int i = 0;
          int k = i;
          if (localObject3 != null)
          {
            k = i;
            if (((im_msg_body.GeneralFlags)localObject3).long_text_flag.get() == 1)
            {
              i = 1;
              k = i;
              if (QLog.isColorLevel())
              {
                QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg, longTextFlag: true");
                k = i;
              }
            }
          }
          if (((im_msg_body.RichMsg)localObject2).bytes_template_1.has()) {}
          for (localObject1 = ((im_msg_body.RichMsg)localObject2).bytes_template_1.get().toByteArray();; localObject1 = null)
          {
            long l1;
            MessageForStructing localMessageForStructing;
            long l3;
            int m;
            long l2;
            if (paramMsg.msg_head.from_uin.has())
            {
              l1 = paramMsg.msg_head.from_uin.get();
              localMessageForStructing = new MessageForStructing();
              localMessageForStructing.msgtype = -2011;
              l3 = paramMsg.msg_head.to_uin.get();
              m = paramMsg.msg_head.msg_type.get();
              if (m != 82)
              {
                l2 = l3;
                if (m != 43) {}
              }
              else
              {
                l2 = l3;
                if (paramMsg.msg_head.group_info != null)
                {
                  l2 = l3;
                  if (paramMsg.msg_head.group_info.group_code.has()) {
                    l2 = paramMsg.msg_head.group_info.group_code.get();
                  }
                }
              }
              localObject2 = ((im_msg_body.RichMsg)localObject2).bytes_msg_resid.get();
              if (localObject2 == null) {
                break label4235;
              }
            }
            for (localObject6 = ((ByteStringMicro)localObject2).toStringUtf8();; localObject6 = "")
            {
              Object localObject7;
              if (!bgsp.a((String)localObject6))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("DecodeMsg", 2, new Object[] { "decodePBMsgElems_RichMsg longMsgResId=", localObject6 });
                }
                localObject2 = "";
                localObject7 = paramList.iterator();
                do
                {
                  localObject5 = localObject2;
                  if (!((Iterator)localObject7).hasNext()) {
                    break;
                  }
                  localObject5 = (im_msg_body.Elem)((Iterator)localObject7).next();
                } while (!((im_msg_body.Elem)localObject5).pub_acc_info.has());
                if (((im_msg_body.Elem)localObject5).pub_acc_info.string_long_msg_url.get() != null) {
                  localObject2 = ((im_msg_body.Elem)localObject5).pub_acc_info.string_long_msg_url.get();
                }
                localObject7 = ((im_msg_body.Elem)localObject5).pub_acc_info.bytes_download_key.get();
                localObject5 = localObject2;
                if (localObject7 == null) {
                  break label4228;
                }
                localObject7 = StructLongMessageDownloadProcessor.a(((ByteStringMicro)localObject7).toByteArray());
                localObject5 = localObject2;
              }
              for (localObject2 = localObject7;; localObject2 = "")
              {
                if ((!bgsp.a((String)localObject5)) && (!bgsp.a((String)localObject2)) && (!bgsp.a((String)localObject6)))
                {
                  localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_url", (String)localObject5);
                  localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_download_key", (String)localObject2);
                  localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", (String)localObject6);
                }
                for (boolean bool = true;; bool = false) {
                  for (;;)
                  {
                    localObject2 = bcab.a(paramMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    if ((((bbzl)localObject2).jdField_a_of_type_Int == 1008) && (QLog.isColorLevel()))
                    {
                      localObject5 = new StringBuilder().append("msgId=").append(localMessageForStructing.uniseq).append(", serviceType(Pa-129,140,142):").append(((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).service_type.get()).append(", xmlContentLength:");
                      if (localObject1 == null)
                      {
                        i = 0;
                        QLog.d("PaOldLongMsg", 2, i + ", longMsgResId:" + (String)localObject6 + ", isPaNewLongMsg:" + bool);
                      }
                    }
                    else if ((localObject3 == null) || (!((im_msg_body.GeneralFlags)localObject3).babyq_guide_msg_cookie.has())) {}
                    try
                    {
                      localObject5 = ((im_msg_body.GeneralFlags)localObject3).babyq_guide_msg_cookie.get().toByteArray();
                      localObject7 = bgjw.a((byte[])localObject5);
                      if (QLog.isColorLevel()) {
                        QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg, guideMsgCookie: " + (String)localObject7 + " ,byte: " + Arrays.toString(((im_msg_body.GeneralFlags)localObject3).babyq_guide_msg_cookie.get().toByteArray()));
                      }
                      localMessageForStructing.saveExtInfoToExtStr("guide_msg_cookie", (String)localObject7);
                      ((anhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a((byte[])localObject5);
                      if (bool)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("DecodeMsg", 2, "begin getEmptyGeneralStructMsg");
                        }
                        localMessageForStructing.structingMsg = ((StructMsgForGeneralShare)bcwd.a());
                        if (localMessageForStructing.structingMsg == null) {
                          break label2290;
                        }
                        if (!(localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
                          break label1416;
                        }
                        localObject2 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mWarningTips;
                        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                          localMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", (String)localObject2);
                        }
                        if (((StructMsgForGeneralShare)localMessageForStructing.structingMsg).isPayMessage()) {
                          localMessageForStructing.saveExtInfoToExtStr("pa_pay_message", "1");
                        }
                        localObject2 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mPARedPacket;
                        if (TextUtils.isEmpty((CharSequence)localObject2)) {
                          break label1334;
                        }
                        localObject2 = MessageForQQWalletMsg.createQQWalletMsg((String)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin());
                        if (localObject2 == null) {
                          break label1334;
                        }
                        paramList1.add(localObject2);
                        return;
                        l1 = 0L;
                        break label285;
                        i = localObject1.length;
                      }
                    }
                    catch (Exception localException)
                    {
                      for (;;)
                      {
                        if (QLog.isColorLevel())
                        {
                          QLog.d("DecodeMsg", 2, "get richmsg guideMsgCookie error!", localException);
                          continue;
                          if ((localObject1 == null) || (localObject1.length == 0))
                          {
                            if ((((bbzl)localObject2).jdField_a_of_type_Int == 1008) && (!TextUtils.isEmpty((CharSequence)localObject6)))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d("PaOldLongMsg", 2, "msgId=" + localMessageForStructing.uniseq + ", begin getEmptyGeneralStructMsg for PA oldLongMsg!");
                              }
                              localMessageForStructing.structingMsg = ((StructMsgForGeneralShare)bcwd.a());
                              localMessageForStructing.saveExtInfoToExtStr("pub_old_long_msg", "1");
                              localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", (String)localObject6);
                              localMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
                            }
                          }
                          else
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("DecodeMsg", 2, new Object[] { "begin getStructMsgFromXmlBuff: type=", Integer.valueOf(m), ", code=", Long.valueOf(l2) });
                            }
                            localObject2 = bgtl.a((byte[])localObject1, (im_msg_body.GeneralFlags)localObject3, -1);
                            if (localObject2 != null) {
                              i = 0;
                            }
                            for (;;)
                            {
                              localMessageForStructing.structingMsg = bcwd.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, m, l2, (byte[])localObject2, i);
                              localObject1 = localObject2;
                              if (!QLog.isColorLevel()) {
                                break label917;
                              }
                              QLog.d("StructMsg", 2, "StructMsg = " + localMessageForStructing.structingMsg);
                              localObject1 = localObject2;
                              break label917;
                              label1334:
                              if (localMessageForStructing.structingMsg.mMsgServiceID == 74)
                              {
                                localObject2 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mVipDonateStr;
                                if (!TextUtils.isEmpty((CharSequence)localObject2))
                                {
                                  bool = false;
                                  if (String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                                    bool = true;
                                  }
                                  localObject2 = a((String)localObject2, bool);
                                  if (localObject2 != null)
                                  {
                                    paramList1.add(localObject2);
                                    return;
                                  }
                                }
                              }
                              int j = 0;
                              i = j;
                              if (paramMsg.msg_head.c2c_tmp_msg_head.service_type.has())
                              {
                                int n = paramMsg.msg_head.c2c_tmp_msg_head.service_type.get();
                                if ((n != 129) && (n != 140))
                                {
                                  i = j;
                                  if (n != 142) {}
                                }
                                else
                                {
                                  i = 1;
                                }
                              }
                              if ((i != 0) || (localMessageForStructing.structingMsg.sourceAccoutType != 0))
                              {
                                localMessageForStructing.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
                                if ((TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgBrief)) || (localMessageForStructing.structingMsg.mEmptyMsgBriefModified)) {
                                  localMessageForStructing.structingMsg.mMsgBrief = AbsStructMsg.PA_DEFAULT_MSG_BRIEF;
                                }
                                akmh.a((im_msg_body.GeneralFlags)localObject3, localMessageForStructing);
                              }
                              localObject2 = paramList.iterator();
                              while (((Iterator)localObject2).hasNext())
                              {
                                im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject2).next();
                                if ((localElem.life_online.has()) && (((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint64_unique_id.has())) {
                                  localMessageForStructing.structingMsg.msgId = ((im_msg_body.LifeOnlineAccount)localElem.life_online.get()).uint64_unique_id.get();
                                }
                              }
                              if (QLog.isColorLevel()) {
                                QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg serviceId" + localMessageForStructing.structingMsg.mMsgServiceID);
                              }
                              if (localMessageForStructing.structingMsg.mMsgServiceID == 37) {
                                break;
                              }
                              if (localMessageForStructing.structingMsg.mMsgServiceID == 499)
                              {
                                paramList = (MessageForTroopFee)bbzh.a(-2036);
                                paramStringBuilder = MessageForTroopFee.decodeMsgFromXmlBuff(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, m, l2, (byte[])localObject1, -1);
                                if (paramStringBuilder != null) {
                                  paramList.copyFrom(paramStringBuilder);
                                }
                                paramList.msgtype = -2036;
                                paramList.msg = paramList.getSummaryMsg();
                                paramList.msgData = paramList.getBytes();
                                paramList1.add(paramList);
                                localMessageForStructing.structingMsg = null;
                                if (!QLog.isColorLevel()) {
                                  break;
                                }
                                QLog.d(".troop.troop_fee", 2, "Troop Fee has decode suceess" + paramList.getSummaryMsg());
                                return;
                              }
                              if (localMessageForStructing.structingMsg.mMsgServiceID == 52)
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d(anqt.class.getSimpleName(), 2, "Received flower message");
                                }
                                localObject1 = NearbyFlowerMessage.getFlowerMsgVersion(localMessageForStructing);
                                if ((!"1".equals(localObject1)) && (!"2".equals(localObject1)))
                                {
                                  l3 = l1;
                                  if (!"3".equals(localObject1)) {}
                                }
                                else
                                {
                                  localObject1 = (msg_comm.GroupInfo)paramMsg.msg_head.group_info.get();
                                  if (localObject1 == null) {
                                    break label4203;
                                  }
                                }
                              }
                              label3641:
                              label4203:
                              for (l2 = ((msg_comm.GroupInfo)localObject1).group_code.get();; l2 = 0L)
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.i(anqt.class.getSimpleName(), 2, "decodePBMsgElems, groupCode:" + l2);
                                }
                                l3 = l1;
                                if (l2 <= 0L)
                                {
                                  if (!paramMsg.msg_head.from_uin.has()) {
                                    break label2332;
                                  }
                                  l1 = paramMsg.msg_head.from_uin.get();
                                  if (!paramMsg.msg_head.to_uin.has()) {
                                    break label2338;
                                  }
                                  l2 = paramMsg.msg_head.to_uin.get();
                                  paramList1.add(((anqt)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getManager(124)).a(Long.toString(l1), Long.toString(l2), localMessageForStructing.istroop, localMessageForStructing.structingMsg));
                                  l3 = l1;
                                }
                                label2290:
                                do
                                {
                                  for (;;)
                                  {
                                    if (((2171946401L == l3) || (2173223560L == l3) || (2062433139L == l3) || (3434959637L == l3)) && ((localMessageForStructing.structingMsg instanceof AbsShareMsg)))
                                    {
                                      if (2171946401L == l3) {
                                        tzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing, 11);
                                      }
                                      ((AbsShareMsg)localMessageForStructing.structingMsg).clearItems();
                                      localMessageForStructing.extInt = 1;
                                      localMessageForStructing.extLong = 1;
                                      if (QLog.isColorLevel()) {
                                        QLog.d("DecodeMsg", 2, "decode structMsg form XIN_KANDIAN, items = " + ((AbsShareMsg)localMessageForStructing.structingMsg).getStructMsgItemLists().size());
                                      }
                                    }
                                    localMessageForStructing.structingMsg.mCompatibleText = a(paramList, paramList1, false);
                                    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
                                    localMessageForStructing.msg = "richMsg";
                                    if (localMessageForStructing.structingMsg != null) {
                                      break label3701;
                                    }
                                    if (QLog.isColorLevel()) {
                                      paramStringBuilder.append("c2cMsgContent.data:null;\n");
                                    }
                                    i(paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
                                    return;
                                    l1 = 0L;
                                    break;
                                    l2 = 0L;
                                    break label2076;
                                    if ((localMessageForStructing.structingMsg.mMsgServiceID == 80) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                                    {
                                      if (wfg.i())
                                      {
                                        paramList = (MessageForQQStory)bbzh.a(-2051);
                                        paramList.msgtype = -2051;
                                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject4 != null) && (localObject4.str.has())) {
                                          paramStringBuilder.mCompatibleText = localObject4.str.get().toStringUtf8();
                                        }
                                        paramList.structingMsg = paramStringBuilder;
                                        paramList.doPrewrite();
                                        if (TextUtils.isEmpty(paramStringBuilder.mCompatibleText))
                                        {
                                          paramList.doParse();
                                          paramStringBuilder.mCompatibleText = MessageForQQStory.buildCompatibleText(paramList.authorName, paramList.brief, paramList.srcName);
                                          paramList.doPrewrite();
                                          if (QLog.isColorLevel()) {
                                            QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + paramStringBuilder.mCompatibleText);
                                          }
                                        }
                                        paramList1.add(paramList);
                                        localMessageForStructing.structingMsg = null;
                                        return;
                                      }
                                      localMessageForStructing.structingMsg = null;
                                      if (localObject4 != null)
                                      {
                                        localObject4.str.set(ByteStringMicro.copyFromUtf8(wfg.a()));
                                        return;
                                      }
                                      l3 = l1;
                                      if (QLog.isColorLevel())
                                      {
                                        QLog.d("Q.qqstory.share", 2, "recv storyMsg, isSDKAPISupportStory==false, txtMsg==null");
                                        l3 = l1;
                                      }
                                    }
                                    else
                                    {
                                      if ((localMessageForStructing.structingMsg.mMsgServiceID == 118) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                                      {
                                        paramList = (MessageForTribeShortVideo)bbzh.a(-7002);
                                        paramList.msgtype = -7002;
                                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject4 != null) && (localObject4.str.has())) {
                                          paramStringBuilder.mCompatibleText = localObject4.str.get().toStringUtf8();
                                        }
                                        paramList.structingMsg = paramStringBuilder;
                                        paramList.doPrewrite();
                                        if (TextUtils.isEmpty(paramStringBuilder.mCompatibleText))
                                        {
                                          paramList.doParse();
                                          paramStringBuilder.mCompatibleText = MessageForTribeShortVideo.buildCompatibleText();
                                          paramList.doPrewrite();
                                          if (QLog.isColorLevel()) {
                                            QLog.d("DecodeMsg", 2, "recv shortVideoMsg, mCompatibleText isEmpty, rebuild:" + paramStringBuilder.mCompatibleText);
                                          }
                                        }
                                        paramList1.add(paramList);
                                        localMessageForStructing.structingMsg = null;
                                        return;
                                      }
                                      if ((localMessageForStructing.structingMsg.mMsgServiceID == 104) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                                      {
                                        paramList = (MessageForTroopPobing)bbzh.a(-2059);
                                        paramList.msgtype = -2059;
                                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject4 != null) && (localObject4.str.has())) {
                                          paramStringBuilder.mCompatibleText = localObject4.str.get().toStringUtf8();
                                        }
                                        if ((localObject3 != null) && (((im_msg_body.GeneralFlags)localObject3).bytes_pb_reserve.has())) {}
                                        try
                                        {
                                          paramMsg = new generalflags.ResvAttr();
                                          paramMsg.mergeFrom(((im_msg_body.GeneralFlags)localObject3).bytes_pb_reserve.get().toByteArray());
                                          if ((paramMsg.uint32_troop_pobing_template.has()) && (paramMsg.uint32_troop_pobing_template.get() > 0)) {
                                            paramStringBuilder.pobingTemplateId = paramMsg.uint32_troop_pobing_template.get();
                                          }
                                          if (QLog.isColorLevel()) {
                                            QLog.d("DecodeMsg", 2, "uint32_troop_pobing_template: " + paramStringBuilder.pobingTemplateId);
                                          }
                                          paramList.structingMsg = paramStringBuilder;
                                          paramList.doPrewrite();
                                          paramList.doParse();
                                          if (TextUtils.isEmpty(paramStringBuilder.mCompatibleText))
                                          {
                                            paramList.doParse();
                                            paramStringBuilder.mCompatibleText = MessageForTroopPobing.buildCompatibleText();
                                            paramList.doPrewrite();
                                            if (QLog.isColorLevel()) {
                                              QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + paramStringBuilder.mCompatibleText);
                                            }
                                          }
                                          paramList1.add(paramList);
                                          localMessageForStructing.structingMsg = null;
                                          new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_obj").a(new String[] { l2 + "" }).a();
                                          new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_welcome").a(new String[] { l2 + "", "", "" + bfup.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2)) }).a();
                                          return;
                                        }
                                        catch (InvalidProtocolBufferMicroException paramMsg)
                                        {
                                          for (;;)
                                          {
                                            QLog.e("DecodeMsg", 1, "decode uint32_troop_pobing_template fail: ", paramMsg);
                                          }
                                        }
                                      }
                                      if ((localMessageForStructing.structingMsg.mMsgServiceID == 90) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                                      {
                                        paramList = (MessageForTroopSign)bbzh.a(-2054);
                                        paramList.msgtype = -2054;
                                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        paramList.structingMsg = paramStringBuilder;
                                        paramList.msg = paramStringBuilder.mMsgBrief;
                                        paramList.doPrewrite();
                                        paramList1.add(paramList);
                                        localMessageForStructing.structingMsg = null;
                                        return;
                                      }
                                      l3 = l1;
                                      if (localMessageForStructing.structingMsg.mMsgServiceID != 43) {
                                        if (((localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116)) && (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgActionData)))
                                        {
                                          localObject1 = a(localMessageForStructing);
                                          oat.a(null, "", "0X8007238", "0X8007238", 0, 0, (String)localObject1, "", "", "");
                                          oat.a("0X8007238", "", (String)localObject1, "", "", "");
                                          localMessageForStructing.structingMsg.mMsgActionData = a(localMessageForStructing.structingMsg.mMsgActionData);
                                          l3 = l1;
                                        }
                                        else if (((localMessageForStructing.structingMsg.mMsgServiceID == 5) || (localMessageForStructing.structingMsg.mMsgServiceID == 137)) && ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare)))
                                        {
                                          localObject1 = paramList.iterator();
                                          do
                                          {
                                            l3 = l1;
                                            if (!((Iterator)localObject1).hasNext()) {
                                              break;
                                            }
                                          } while (!a(localMessageForStructing, (im_msg_body.Elem)((Iterator)localObject1).next()));
                                          l3 = l1;
                                        }
                                        else
                                        {
                                          if (localMessageForStructing.structingMsg.mMsgServiceID != 106) {
                                            break label3641;
                                          }
                                          l3 = l1;
                                          if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
                                          {
                                            localObject1 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                            localObject2 = ((StructMsgForGeneralShare)localObject1).animResId;
                                            bfke.a().a((String)localObject2, null);
                                            bfke.a().a(((StructMsgForGeneralShare)localObject1).atMembers);
                                            l3 = l1;
                                          }
                                        }
                                      }
                                    }
                                  }
                                  l3 = l1;
                                } while (localMessageForStructing.structingMsg.mMsgServiceID != 126);
                                paramList = MessageForStarLeague.decodeMsgFromXmlBuff(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, m, l2, (byte[])localObject1, -1);
                                paramList.msgData = paramList.getBytes();
                                paramList.msg = paramList.getSummaryMsg();
                                paramList1.add(paramList);
                                return;
                                label3701:
                                j = 0;
                                m = 0;
                                paramStringBuilder = null;
                                paramMsg = null;
                                paramList = paramStringBuilder;
                                i = j;
                                if (localObject3 != null)
                                {
                                  paramList = paramStringBuilder;
                                  i = j;
                                  if (!((im_msg_body.GeneralFlags)localObject3).bytes_pb_reserve.has()) {}
                                }
                                try
                                {
                                  parambepr = new generalflags.ResvAttr();
                                  parambepr.mergeFrom(((im_msg_body.GeneralFlags)localObject3).bytes_pb_reserve.get().toByteArray());
                                  paramStringBuilder = paramMsg;
                                  j = m;
                                  if (parambepr.bytes_kpl_info.has())
                                  {
                                    paramStringBuilder = paramMsg;
                                    j = m;
                                    if (parambepr.bytes_kpl_info.has())
                                    {
                                      j = 1;
                                      paramStringBuilder = parambepr.bytes_kpl_info.get().toStringUtf8();
                                    }
                                  }
                                  paramList = paramStringBuilder;
                                  i = j;
                                  if (parambepr.bytes_oac_msg_extend.has())
                                  {
                                    localMessageForStructing.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", parambepr.bytes_oac_msg_extend.get().toStringUtf8());
                                    i = j;
                                    paramList = paramStringBuilder;
                                  }
                                }
                                catch (Exception paramList)
                                {
                                  for (;;)
                                  {
                                    if (QLog.isColorLevel()) {
                                      QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
                                    }
                                    paramList.printStackTrace();
                                    i = 0;
                                    paramList = null;
                                  }
                                  paramList1.add(paramList);
                                  return;
                                }
                                if (i != 0)
                                {
                                  localMessageForStructing.saveExtInfoToExtStr("msg_ext_key", "Y");
                                  if (QLog.isColorLevel()) {
                                    QLog.d("KplMessage", 2, "resv a kpl struct message !");
                                  }
                                  KplRoleInfo.handleKplFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
                                }
                                if (k != 0)
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg need to pull longtextmsg!");
                                  }
                                  try
                                  {
                                    if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
                                    {
                                      paramList = (ChatMessage)bbzh.a(-1051);
                                      paramList.saveExtInfoToExtStr("long_text_recv_state", "3");
                                      paramList.saveExtInfoToExtStr("long_text_msg_resid", localMessageForStructing.structingMsg.mResid);
                                      paramStringBuilder = ((AbsShareMsg)localMessageForStructing.structingMsg).getStructMsgItemLists();
                                      if (paramStringBuilder != null)
                                      {
                                        paramStringBuilder = paramStringBuilder.iterator();
                                        for (;;)
                                        {
                                          if (paramStringBuilder.hasNext())
                                          {
                                            paramMsg = (bcvs)paramStringBuilder.next();
                                            if ((paramMsg instanceof bcvt))
                                            {
                                              paramMsg = ((bcvt)paramMsg).jdField_a_of_type_JavaUtilArrayList;
                                              if (paramMsg != null)
                                              {
                                                paramMsg = paramMsg.iterator();
                                                if (paramMsg.hasNext())
                                                {
                                                  parambepr = (bcvs)paramMsg.next();
                                                  if (!(parambepr instanceof StructMsgItemTitle)) {
                                                    break;
                                                  }
                                                  paramList.msg = ((StructMsgItemTitle)parambepr).b();
                                                  if (QLog.isDevelopLevel())
                                                  {
                                                    QLog.d("DecodeMsg", 2, "longtextmsg getMsg from structMsg msg:" + paramList.msg);
                                                    continue;
                                                    paramList1.add(localMessageForStructing);
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                  catch (Exception paramList)
                                  {
                                    if (QLog.isColorLevel()) {
                                      QLog.d("DecodeMsg", 2, "failed to pull longtextmsg exception!", paramList);
                                    }
                                  }
                                }
                                for (;;)
                                {
                                  return;
                                  if (QLog.isColorLevel()) {
                                    QLog.d("DecodeMsg", 2, "absShareMsg is null");
                                  }
                                }
                              }
                              i = -1;
                              localObject2 = localObject1;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void g(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr)
  {
    Object localObject2 = null;
    Object localObject6 = paramList.iterator();
    Object localObject1 = null;
    Object localObject7;
    Object localObject3;
    if (((Iterator)localObject6).hasNext())
    {
      localObject7 = (im_msg_body.Elem)((Iterator)localObject6).next();
      localObject3 = localObject1;
      if (((im_msg_body.Elem)localObject7).group_pub_acc_info.has())
      {
        localObject3 = localObject1;
        if (((im_msg_body.Elem)localObject7).group_pub_acc_info.uint64_pub_account.has()) {
          localObject3 = (im_msg_body.GroupPubAccountInfo)((im_msg_body.Elem)localObject7).group_pub_acc_info.get();
        }
      }
      if (!((im_msg_body.Elem)localObject7).general_flags.has()) {
        break label895;
      }
    }
    label184:
    label895:
    for (localObject1 = (im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject7).general_flags.get();; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      if (localObject1 == null) {
        return;
      }
      long l1 = ((im_msg_body.GroupPubAccountInfo)localObject1).uint64_pub_account.get();
      localObject1 = null;
      int i = 0;
      localObject7 = (MessageForPubAccount)bbzh.a(-3006);
      ((MessageForPubAccount)localObject7).msgtype = -3006;
      ((MessageForPubAccount)localObject7).associatePubAccUin = l1;
      StringBuilder localStringBuilder = new StringBuilder("");
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        localObject3 = (im_msg_body.Elem)localIterator.next();
        if ((((im_msg_body.Elem)localObject3).text.has()) && (((im_msg_body.Elem)localObject3).text.str.has()))
        {
          ((MessageForPubAccount)localObject7).msg = localStringBuilder.toString();
          localObject3 = new PAMessage();
          ((PAMessage)localObject3).msg = localStringBuilder.toString();
          ((MessageForPubAccount)localObject7).msgData = txp.a((PAMessage)localObject3);
        }
      }
      for (;;)
      {
        localObject1 = localObject3;
        break label184;
        if (((im_msg_body.Elem)localObject3).trans_elem_info.has())
        {
          localObject3 = (im_msg_body.TransElem)((im_msg_body.Elem)localObject3).trans_elem_info.get();
          int j = ((im_msg_body.TransElem)localObject3).elem_type.get();
          localObject3 = ((im_msg_body.TransElem)localObject3).elem_value.get().toByteArray();
          if (j != 16)
          {
            paramStringBuilder.append("PubAccount Message type is not 16.\n");
            break label184;
          }
          if ((localObject3 == null) || (localObject3.length == 0))
          {
            paramStringBuilder.append("transElemByte is null or transElemByte.length == 0\n");
            break label184;
          }
          if (localObject3[0] == 1)
          {
            i = bgva.a((byte[])localObject3, 1);
            j = localObject3[3];
            localObject6 = new byte[i - 1];
            bgva.a((byte[])localObject6, 0, (byte[])localObject3, 4, i - 1);
            localObject3 = localObject6;
            if (j == 1) {
              localObject3 = a((byte[])localObject6);
            }
            if (localObject3 == null) {}
          }
          for (;;)
          {
            try
            {
              for (;;)
              {
                if (localObject3.length > 0)
                {
                  localObject3 = new String((byte[])localObject3, "utf-8");
                  localStringBuilder.append((String)localObject3);
                  localObject3 = a((String)localObject3);
                  localObject1 = localObject3;
                  j = 1;
                  i = j;
                  localObject3 = localObject1;
                  if (localObject2 == null) {
                    break;
                  }
                  i = j;
                  localObject3 = localObject1;
                  if (!((im_msg_body.GeneralFlags)localObject2).bytes_pb_reserve.has()) {
                    break;
                  }
                  try
                  {
                    localObject6 = new generalflags.ResvAttr();
                    ((generalflags.ResvAttr)localObject6).mergeFrom(((im_msg_body.GeneralFlags)localObject2).bytes_pb_reserve.get().toByteArray());
                    i = j;
                    localObject3 = localObject1;
                    if (!((generalflags.ResvAttr)localObject6).bytes_oac_msg_extend.has()) {
                      break;
                    }
                    ((MessageForPubAccount)localObject7).saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", ((generalflags.ResvAttr)localObject6).bytes_oac_msg_extend.get().toStringUtf8());
                    i = j;
                    localObject3 = localObject1;
                  }
                  catch (Throwable localThrowable)
                  {
                    QLog.e("DecodeMsg", 2, "decodePBMsgElems_TransElemInfo()-MessageForPubAccount: parse generalflags error! " + QLog.getStackTraceString(localThrowable));
                    i = j;
                    Object localObject4 = localObject1;
                  }
                }
              }
            }
            catch (Exception localException)
            {
              paramStringBuilder.append("PubAccount Message parse decodeContext.mPamag exception.\n");
            }
            continue;
            if (localObject1 != null)
            {
              localObject2 = paramList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject5 = (im_msg_body.Elem)((Iterator)localObject2).next();
                if ((((im_msg_body.Elem)localObject5).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject5).elem_flags2.get()).uint64_msg_id.has())) {
                  ((PAMessage)localObject1).mMsgId = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject5).elem_flags2.get()).uint64_msg_id.get();
                }
              }
              ((MessageForPubAccount)localObject7).mPAMessage = ((PAMessage)localObject1);
              ((MessageForPubAccount)localObject7).msgData = txp.a((PAMessage)localObject1);
            }
            if (i != 0)
            {
              localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getManager(52);
              if (paramMsg.msg_head.group_info.has())
              {
                long l2 = paramMsg.msg_head.group_info.group_code.get();
                localObject2 = ((TroopManager)localObject1).b(String.valueOf(l2));
                if (localObject2 != null)
                {
                  ((TroopInfo)localObject2).associatePubAccount = l1;
                  ((TroopManager)localObject1).b((TroopInfo)localObject2);
                  this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.a(20).notifyUI(79, true, new Object[] { Long.valueOf(l2) });
                }
              }
            }
            paramList1.add(localObject7);
            if (i != 0) {
              break;
            }
            f(paramList, paramList1, paramStringBuilder, paramMsg, parambepr);
            return;
            j = i;
          }
        }
        Object localObject5 = localObject1;
      }
    }
  }
  
  public void h(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr)
  {
    paramList = a(paramList, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), parambepr);
    paramMsg = paramList.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    if (paramList.jdField_a_of_type_JavaLangString != null)
    {
      paramStringBuilder = (ChatMessage)bbzh.a(-1049);
      paramStringBuilder.msg = paramList.jdField_a_of_type_JavaLangString;
      parambepr = (MessageForReplyText)paramStringBuilder;
    }
    try
    {
      parambepr.extLong |= 0x1;
      if (paramMsg.getSourceMsg() != null)
      {
        parambepr.setSourceMessageRecord(paramMsg.unPackSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app));
        if ((parambepr.getSourceMessage() != null) && (atvo.a(parambepr.getSourceMessage())))
        {
          str = parambepr.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
          ChatMessage localChatMessage = atvo.a((ChatMessage)parambepr.getSourceMessage());
          atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, parambepr.getSourceMessage());
          if ((!TextUtils.isEmpty(str)) && (localChatMessage != null))
          {
            int i = Integer.parseInt(str);
            if ((i == 1) || (i == 2))
            {
              QLog.i("DecodeMsg<QFile>", 1, "decode reply file msg, msg uniseq[" + localChatMessage.uniseq + "]");
              atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)parambepr.getSourceMessage());
            }
          }
        }
      }
      String str = bgmj.a(aopw.a(paramMsg));
      parambepr.mSourceMsgInfo = paramMsg;
      parambepr.saveExtInfoToExtStr("sens_msg_source_msg_info", str);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, "reply:" + parambepr + " sourceMsg=" + parambepr.getSourceMessage());
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
      paramStringBuilder.saveExtInfoToExtStr("sens_msg_ctrl_info", bgmj.a(paramList.jdField_a_of_type_ArrayOfByte));
    }
    paramList1.add(paramStringBuilder);
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "reply msgRand = " + bbzj.a(paramStringBuilder.msgUid) + ", msgUid = " + paramStringBuilder.msgUid);
    }
  }
  
  public void i(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bepr parambepr)
  {
    String str1 = null;
    int k = 0;
    Object localObject1 = paramList.iterator();
    int m = 0;
    int n = -1;
    int i1 = 0;
    im_msg_body.GeneralFlags localGeneralFlags = null;
    im_msg_body.Elem localElem;
    label72:
    int i;
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      localElem = (im_msg_body.Elem)((Iterator)localObject1).next();
      if (!localElem.general_flags.has()) {
        break label2076;
      }
      localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
      i = i1;
      if (!localElem.bless_msg.has()) {
        break label2069;
      }
      i = i1;
      if (localElem.bless_msg.uint32_msg_type.get() != 1) {
        break label2069;
      }
      i = 1;
      if (!localElem.bless_msg.uint32_ex_flag.has()) {
        break label2069;
      }
      j = localElem.bless_msg.uint32_ex_flag.get();
      i = 1;
      label139:
      if ((!localElem.elem_flags2.has()) || (!localElem.elem_flags2.uint32_msg_rpt_cnt.has())) {
        break label2066;
      }
      m = localElem.elem_flags2.uint32_msg_rpt_cnt.get();
      label177:
      if ((!localElem.text.has()) || (!localElem.text.str.has())) {
        break label2063;
      }
      str1 = localElem.text.str.get().toStringUtf8();
      if ((str1 != null) && (str1.startsWith("[")) && (str1.endsWith("]")))
      {
        str1 = bgmj.a(localElem.text.str.get().toByteArray());
        label264:
        n = k;
        if (localElem.text.has())
        {
          n = k;
          if (!localElem.text.bytes_pb_reserve.has()) {}
        }
      }
    }
    label2063:
    label2066:
    label2069:
    label2076:
    label2079:
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = new TextMsgExtPb.ResvAttr();
        ((TextMsgExtPb.ResvAttr)localObject3).mergeFrom(localElem.text.bytes_pb_reserve.get().toByteArray());
        if (!((TextMsgExtPb.ResvAttr)localObject3).text_analysis_result.has()) {
          break label2079;
        }
        n = ((TextMsgExtPb.ResvAttr)localObject3).text_analysis_result.get();
        k = n;
        n = k;
      }
      catch (Exception localException)
      {
        QLog.e("DecodeMsg", 1, "parse TextMsgExtPb.ResvAttr error, ", localException);
        n = k;
        continue;
      }
      k = n;
      n = j;
      i1 = i;
      break;
      str1 = "";
      break label264;
      localObject1 = null;
      Object localObject2 = new bbze();
      ArrayList localArrayList1 = ((bbze)localObject2).jdField_a_of_type_JavaUtilArrayList;
      ArrayList localArrayList2 = new ArrayList(2);
      StringBuilder localStringBuilder = a(null, paramList, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), parambepr, (bbze)localObject2, localArrayList2);
      localObject2 = localObject1;
      if (localArrayList1 != null)
      {
        localObject2 = localObject1;
        if (localArrayList1.size() == 2)
        {
          localObject2 = localObject1;
          if (localArrayList1.get(1) != null) {
            localObject2 = (byte[])localArrayList1.get(1);
          }
        }
      }
      if (localStringBuilder.length() == 0) {
        return;
      }
      long l2 = 0L;
      int i2 = 0;
      i = 0;
      j = 0;
      boolean bool3 = false;
      long l3 = 0L;
      paramList = null;
      long l4;
      long l5;
      if (localGeneralFlags != null)
      {
        l4 = l3;
        l5 = l2;
        if (localGeneralFlags.bytes_pb_reserve.has())
        {
          i = i2;
          l4 = l3;
          l5 = l2;
        }
      }
      for (;;)
      {
        long l1;
        String str2;
        boolean bool4;
        try
        {
          paramStringBuilder = new generalflags.ResvAttr();
          i = i2;
          l4 = l3;
          l5 = l2;
          paramStringBuilder.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
          l1 = l2;
          i = i2;
          l4 = l3;
          l5 = l2;
          if (paramStringBuilder.redbag_msg_sender_uin.has())
          {
            i = 1;
            j = 1;
            l4 = l3;
            l5 = l2;
            l1 = paramStringBuilder.redbag_msg_sender_uin.get();
          }
          l2 = l3;
          i = j;
          l4 = l3;
          l5 = l1;
          if (paramStringBuilder.want_gift_sender_uin.has())
          {
            i = j;
            l4 = l3;
            l5 = l1;
            l2 = paramStringBuilder.want_gift_sender_uin.get();
          }
          i = j;
          l4 = l2;
          l5 = l1;
          if (paramStringBuilder.bytes_oac_msg_extend.has())
          {
            i = j;
            l4 = l2;
            l5 = l1;
            paramList = paramStringBuilder.bytes_oac_msg_extend.get().toStringUtf8();
          }
          i = j;
          l3 = l1;
          j = i;
          l1 = l3;
          if (i == 0)
          {
            j = i;
            l1 = l3;
            if (localGeneralFlags.uint64_uin.has())
            {
              i = 1;
              l3 = localGeneralFlags.uint64_uin.get();
              j = i;
              l1 = l3;
              if (QLog.isColorLevel())
              {
                QLog.d("msgFold", 2, "from old version");
                l1 = l3;
                j = i;
              }
            }
          }
          if (j == 0) {
            break label2025;
          }
          if (localGeneralFlags.uint32_prp_fold.get() == 1)
          {
            bool2 = true;
            localObject1 = localGeneralFlags.bytes_rp_id.get().toStringUtf8();
            str2 = localGeneralFlags.bytes_rp_index.get().toStringUtf8();
            bool4 = aklj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            bool1 = bool3;
            if (j != 0)
            {
              bool1 = bool3;
              if (aklj.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app))
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label1698;
                }
                bool1 = true;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, redBagSender: %s, foldFlag: %s, redBagId: %s, index: %s, foldSwitch: %s, isValidFoldMsg: %s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool2), localObject1, str2, Boolean.valueOf(aklj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), Boolean.valueOf(bool1) }));
            }
            if (!String.valueOf(paramMsg.msg_head.from_uin.get()).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
              break label2001;
            }
            bool3 = false;
            localObject3 = localObject1;
            bool2 = bool1;
            paramStringBuilder = paramList;
            localObject1 = str2;
            paramList = (List<im_msg_body.Elem>)localObject3;
            bool1 = bool3;
            j = 0;
            i = j;
            if (localGeneralFlags != null) {
              if (localGeneralFlags.long_text_flag.get() != 2)
              {
                i = j;
                if (localGeneralFlags.long_text_flag.get() != 1) {}
              }
              else
              {
                j = 1;
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, longTextFlag: true");
                  i = j;
                }
              }
            }
            if (!bool2) {
              break label1725;
            }
            paramStringBuilder = new MessageForFoldMsg();
            ((MessageForFoldMsg)paramStringBuilder).init(bool1, paramList, (String)localObject1, l1, true);
            paramList = paramStringBuilder;
            paramList.msg = localStringBuilder.toString();
            if ((paramList instanceof MessageForText)) {
              bftx.a(paramList);
            }
            j = 0;
            i = j;
            if (paramMsg.msg_head.from_uin.has())
            {
              l1 = paramMsg.msg_head.from_uin.get();
              i = j;
              if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin(), Long.toString(l1))) {
                i = 1;
              }
            }
            if ((localObject2 != null) && (i == 0)) {
              paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", bgmj.a((byte[])localObject2));
            }
            if ((localGeneralFlags == null) || (!localGeneralFlags.babyq_guide_msg_cookie.has())) {}
          }
        }
        catch (Exception paramList)
        {
          QLog.e("msgFold", 1, "prase ResvAttr error, ", paramList);
        }
        try
        {
          paramStringBuilder = localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
          paramMsg = bgjw.a(paramStringBuilder);
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, guideMsgCookie: " + paramMsg + ",bytes: " + Arrays.toString(localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
          }
          paramList.saveExtInfoToExtStr("guide_msg_cookie", paramMsg);
          ((anhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(paramStringBuilder);
        }
        catch (Exception paramStringBuilder)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DecodeMsg", 2, "get text guideMsgCookie error!", paramStringBuilder);
          continue;
          bool1 = false;
          continue;
        }
        if (i1 != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems, isBlessMsg: true ,updateFlag: " + n);
          }
          paramList.isBlessMsg = true;
          if (n > -1)
          {
            if ((n & 0x1) != 1) {
              break label1966;
            }
            bool1 = true;
            paramList.needUpdateMsgTag = bool1;
          }
        }
        if (m > 0)
        {
          paramList.setRepeatCount(m);
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "MessageForText ====> repeatCount = " + paramList.getRepeatCount());
          }
        }
        j = 0;
        paramMsg = null;
        paramStringBuilder = paramMsg;
        i = j;
        if (localGeneralFlags != null)
        {
          paramStringBuilder = paramMsg;
          i = j;
          if (!localGeneralFlags.bytes_pb_reserve.has()) {}
        }
        try
        {
          parambepr = new generalflags.ResvAttr();
          parambepr.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
          paramStringBuilder = paramMsg;
          i = j;
          if (parambepr.bytes_kpl_info.has())
          {
            paramStringBuilder = paramMsg;
            i = j;
            if (parambepr.bytes_kpl_info.has())
            {
              i = 1;
              paramStringBuilder = parambepr.bytes_kpl_info.get().toStringUtf8();
            }
          }
        }
        catch (Exception paramStringBuilder)
        {
          label1698:
          label1725:
          if (!QLog.isColorLevel()) {
            break label1989;
          }
          label1966:
          QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
          label1989:
          paramStringBuilder.printStackTrace();
          i = 0;
          paramStringBuilder = null;
          continue;
        }
        if (i != 0)
        {
          paramList.saveExtInfoToExtStr("msg_ext_key", "Y");
          if (QLog.isColorLevel()) {
            QLog.d("KplMessage", 2, "resv a kpl text message !");
          }
          KplRoleInfo.handleKplFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStringBuilder);
        }
        if (!TextUtils.isEmpty(str1)) {
          paramList.saveExtInfoToExtStr("small_description", str1);
        }
        if ((paramList instanceof RecommendCommonMessage)) {
          paramList.saveExtInfoToExtStr("ark_text_analysis_flag", String.valueOf(k));
        }
        paramList1.add(paramList);
        return;
        paramList = null;
        l3 = l5;
        l2 = l4;
        continue;
        boolean bool2 = false;
        continue;
        boolean bool1 = bool3;
        if (!TextUtils.isEmpty(str2))
        {
          bool1 = bool3;
          if (bool4)
          {
            bool1 = true;
            continue;
            if (i != 0)
            {
              paramList = (ChatMessage)bbzh.a(-1051);
              paramList.saveExtInfoToExtStr("long_text_recv_state", "1");
              paramList.removeExtInfoToExtStr("long_text_msg_resid");
            }
            else if (l2 != 0L)
            {
              paramList = new MessageForWantGiftMsg();
              ((MessageForWantGiftMsg)paramList).wantGiftSenderUin = l2;
              ((MessageForWantGiftMsg)paramList).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, l2 + "");
              ((MessageForWantGiftMsg)paramList).msgtype = -2056;
            }
            else
            {
              paramList = (ChatMessage)bbzh.a(-1000);
              if ((parambepr != null) && (localArrayList2 != null)) {
                bfmd.a(parambepr.jdField_a_of_type_Int, localArrayList2, paramList);
              }
              if (paramStringBuilder != null) {
                paramList.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", paramStringBuilder);
              }
              if (localArrayList1.size() > 0)
              {
                paramStringBuilder = new ArrayList(localArrayList1.size());
                parambepr = localArrayList1.iterator();
                while (parambepr.hasNext())
                {
                  localObject1 = parambepr.next();
                  if ((localObject1 instanceof MessageForText.AtTroopMemberInfo)) {
                    paramStringBuilder.add((MessageForText.AtTroopMemberInfo)localObject1);
                  }
                }
                paramList.atInfoTempList = paramStringBuilder;
              }
              continue;
              label2001:
              bool3 = bool1;
              bool1 = bool2;
              paramStringBuilder = paramList;
              paramList = (List<im_msg_body.Elem>)localObject1;
              localObject1 = str2;
              bool2 = bool3;
              continue;
              label2025:
              paramStringBuilder = paramList;
              bool2 = false;
              localObject1 = null;
              paramList = null;
              bool1 = false;
              continue;
              localObject1 = null;
              paramList = null;
              l2 = 0L;
              l1 = 0L;
              bool2 = false;
              paramStringBuilder = null;
              bool1 = false;
            }
          }
        }
      }
      break label264;
      break label177;
      j = n;
      break label139;
      break label72;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzc
 * JD-Core Version:    0.7.0.1
 */