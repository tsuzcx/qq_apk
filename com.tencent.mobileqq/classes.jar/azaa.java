import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ark.open.ArkUtil;
import com.tencent.biz.bmqq.protocol.Crm.CrmCCNotify;
import com.tencent.biz.bmqq.protocol.Crm.GrayMsg;
import com.tencent.biz.bmqq.protocol.Crm.QidianGroupMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
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
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.hiboom.hiboom_type.Hiboom_Type;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder.1;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder.2;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.ThreeDBaseInfo;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.VideoFile;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ActivityGiftInfo;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.InteractGift;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg.ResvAttr;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.source_msg.ResvAttr;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.AnimationImageShow;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype11;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype15;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype2;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype20;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype23;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatEnter;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatExit;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype27;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype33;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype5;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype8;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.ArkAppElem;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CrmElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.DeliverGiftMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.GroupPubAccountInfo;
import tencent.im.msg.im_msg_body.LifeOnlineAccount;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MarketTrans;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.OnlineImage;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.msg.im_msg_body.QQWalletMsg;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TipsInfo;
import tencent.im.msg.im_msg_body.TransElem;
import tencent.im.msg.im_msg_body.VideoFile;
import tencent.im.msg.obj_msg.MsgContentInfo;
import tencent.im.msg.obj_msg.MsgContentInfo.MsgFile;
import tencent.im.msg.obj_msg.ObjMsg;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.oidb.oidb_0xdea.PassThrough;

public class azaa
{
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  
  public static MessageForQQWalletMsg a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      if (paramString1 != null)
      {
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)azaf.a(-2025);
        localMessageForQQWalletMsg.msgtype = -2025;
        localMessageForQQWalletMsg.messageType = paramString1.getInt("msgType");
        localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = a(paramString1, paramString2);
        if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
          return null;
        }
        localMessageForQQWalletMsg.msg = localMessageForQQWalletMsg.getMsgSummary();
        localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
        return localMessageForQQWalletMsg;
      }
    }
    catch (Exception paramString1)
    {
      return null;
    }
    return null;
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
          break label423;
        }
        MessageForVIPDonate localMessageForVIPDonate = (MessageForVIPDonate)azaf.a(-2047);
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
          localMessageForVIPDonate.msgData = amrf.a(localVIPDonateMsg);
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
    paramString = swh.a(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public static QQWalletRedPacketMsg a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      try
      {
        im_msg_body.QQWalletAioBody localQQWalletAioBody = new im_msg_body.QQWalletAioBody();
        localQQWalletAioBody.sint32_channelid.set(paramJSONObject.getInt("channelid"));
        localQQWalletAioBody.sint32_templateid.set(paramJSONObject.getInt("templateid"));
        localQQWalletAioBody.uint32_resend.set(paramJSONObject.getInt("resend"));
        localQQWalletAioBody.sint32_redtype.set(paramJSONObject.getInt("redtype"));
        localQQWalletAioBody.sint32_envelopeid.set(-1);
        paramString = new QQWalletRedPacketMsg(localQQWalletAioBody, paramString);
        paramString.redPacketId = paramJSONObject.getString("billno");
        paramString.authkey = paramJSONObject.getString("authkey");
        if (paramString.redPacketId.equals("")) {
          return null;
        }
        paramString.elem = a(paramJSONObject);
        paramJSONObject = paramString.elem;
        if (paramJSONObject != null) {
          return paramString;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return null;
  }
  
  public static QQWalletTransferMsgElem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        QQWalletTransferMsgElem localQQWalletTransferMsgElem = new QQWalletTransferMsgElem();
        paramJSONObject = paramJSONObject.getJSONObject("receiver");
        if (paramJSONObject == null) {
          return null;
        }
        localQQWalletTransferMsgElem.nativeAndroid = paramJSONObject.getString("nativeAndroid");
        if (!localQQWalletTransferMsgElem.nativeAndroid.equals(""))
        {
          localQQWalletTransferMsgElem.background = paramJSONObject.getInt("background");
          localQQWalletTransferMsgElem.icon = paramJSONObject.getInt("icon");
          localQQWalletTransferMsgElem.title = paramJSONObject.getString("title");
          localQQWalletTransferMsgElem.subTitle = paramJSONObject.getString("subtitle");
          localQQWalletTransferMsgElem.content = paramJSONObject.getString("content");
          localQQWalletTransferMsgElem.linkUrl = paramJSONObject.getString("linkurl");
          localQQWalletTransferMsgElem.blackStripe = paramJSONObject.getString("blackstripe");
          localQQWalletTransferMsgElem.notice = paramJSONObject.getString("notice");
          localQQWalletTransferMsgElem.titleColor = paramJSONObject.getInt("titleColor");
          localQQWalletTransferMsgElem.subtitleColor = paramJSONObject.getInt("subtitleColor");
          localQQWalletTransferMsgElem.actionsPriority = paramJSONObject.getString("actionsPriority");
          localQQWalletTransferMsgElem.jumpUrl = paramJSONObject.getString("jumpUrl");
          localQQWalletTransferMsgElem.iconUrl = paramJSONObject.getString("iconurl");
          localQQWalletTransferMsgElem.contentColor = -1;
          localQQWalletTransferMsgElem.contentBgColor = -1;
          localQQWalletTransferMsgElem.aioImageLeft = "";
          localQQWalletTransferMsgElem.aioImageRight = "";
          localQQWalletTransferMsgElem.cftImage = "";
          return localQQWalletTransferMsgElem;
        }
      }
      catch (Exception paramJSONObject) {}
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
  
  protected static Boolean a(im_msg_body.Elem paramElem)
  {
    boolean bool = true;
    if ((paramElem.text.has()) || (paramElem.face.has()) || (paramElem.small_emoji.has()) || (paramElem.online_image.has()) || (paramElem.bankcode_ctrl_info.has())) {
      return Boolean.valueOf(true);
    }
    if (paramElem.common_elem.has())
    {
      if (33 == paramElem.common_elem.uint32_service_type.get()) {}
      for (;;)
      {
        return Boolean.valueOf(bool);
        bool = false;
      }
    }
    return Boolean.valueOf(false);
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
        j = apsp.b(j);
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
            str = azah.a(paramList, false);
            localObject = paramList;
            if (str.length() > 0)
            {
              localObject = (MessageForText)azaf.a(-1000);
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
  
  private void a(im_msg_body.Elem paramElem, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, azaj paramazaj)
  {
    Object localObject = (im_msg_body.CrmElem)paramElem.crm_elem.get();
    if (localObject != null)
    {
      i = ((im_msg_body.CrmElem)localObject).uint32_qidian_flag.get();
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("has uint32_qidian_flag:").append(i).append(";");
      }
      if (i == 1)
      {
        if (!paramList.isEmpty()) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("crmelem_qidian_flag", i + "");
        }
        paramStringBuilder = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin();
        paramElem = String.valueOf(paramMsg.msg_head.from_uin.get());
        if (!paramStringBuilder.equals(paramElem))
        {
          paramStringBuilder = (bfyh)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getManager(165);
          if (!paramStringBuilder.a.containsKey(paramElem)) {
            paramStringBuilder.a(new BmqqAccountType(paramElem, 1));
          }
        }
        if ((paramazaj != null) && (paramazaj.jdField_a_of_type_Int == 1024)) {
          paramazaj.jdField_a_of_type_Int = 1025;
        }
      }
      if (((im_msg_body.CrmElem)localObject).crm_buf.has()) {
        paramElem = new Crm.CrmCCNotify();
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramElem.mergeFrom(((im_msg_body.CrmElem)localObject).crm_buf.get().toByteArray());
        int i = paramElem.crm_flag.get();
        int j;
        long l1;
        long l2;
        if ((i == 8) && (paramElem.qidian_group_msg.has()))
        {
          paramStringBuilder = (Crm.QidianGroupMsg)paramElem.qidian_group_msg.get();
          j = paramStringBuilder.uint32_group_task_id.get();
          int k = paramStringBuilder.uint32_group_msg_type.get();
          l1 = paramStringBuilder.uint64_kfuin.get();
          int m = paramStringBuilder.uint32_show_tip.get();
          paramStringBuilder = paramStringBuilder.str_tip_text.get();
          if (!paramList.isEmpty())
          {
            localObject = (MessageRecord)paramList.get(0);
            if (localObject != null)
            {
              ((MessageRecord)localObject).mQidianTaskId = j;
              ((MessageRecord)localObject).mQidianMasterUin = l1;
              ((MessageRecord)localObject).mIsShowQidianTips = m;
              ((MessageRecord)localObject).mQidianTipText = paramStringBuilder;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, String.format("received qidian bulk message taskId: %d, msgType: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }));
          }
          l1 = paramMsg.msg_head.from_uin.get();
          k = paramMsg.msg_head.msg_seq.get();
          l2 = paramMsg.msg_head.msg_uid.get();
          m = paramMsg.msg_head.msg_type.get();
          azad.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l1, k, l2, m);
          if (j != 0)
          {
            paramStringBuilder = (bfzp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
            localObject = new JSONObject();
            ((JSONObject)localObject).put("action", "receive");
            ((JSONObject)localObject).put("fromUin", String.valueOf(paramMsg.msg_head.from_uin.get()));
            ((JSONObject)localObject).put("toUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((JSONObject)localObject).put("taskID", String.valueOf(j));
            ((JSONObject)localObject).put("clickURL", "");
            ((JSONObject)localObject).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
            paramStringBuilder.a(((JSONObject)localObject).toString(), String.valueOf(paramMsg.msg_head.from_uin.get()), "", 10009, 0);
          }
        }
        if ((i == 11) && (paramElem.msg_gray_msg.has()))
        {
          localObject = (Crm.GrayMsg)paramElem.msg_gray_msg.get();
          i = ((Crm.GrayMsg)localObject).uint32_type.get();
          paramStringBuilder = ((Crm.GrayMsg)localObject).str_text.get();
          l1 = ((Crm.GrayMsg)localObject).uint64_from_uin.get();
          j = paramMsg.msg_head.msg_seq.get();
          l2 = paramMsg.msg_head.msg_uid.get();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(l2);
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, String.format("received qidian gray msg type: %d, tips: %s, fromUin: %d", new Object[] { Integer.valueOf(i), paramStringBuilder, Long.valueOf(l1) }));
          }
          bgac.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), paramStringBuilder, 1024, ((StringBuilder)localObject).toString());
        }
        if (paramElem.str_check_id.has()) {
          bgac.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, paramMsg, paramazaj, paramElem);
        }
        if ((paramazaj != null) && (paramazaj.jdField_a_of_type_Int == 1024) && (paramElem.str_ext_nick_name.has()))
        {
          paramElem = paramElem.str_ext_nick_name.get();
          if (!paramList.isEmpty())
          {
            paramList = (MessageRecord)paramList.get(0);
            if (paramList != null) {
              paramList.saveExtInfoToExtStr("qidian_ext_nick_name", paramElem);
            }
          }
        }
        return;
      }
      catch (Exception paramElem)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("DecodeMsg", 2, "receive ccNotify but throw exception " + paramElem.getMessage());
        return;
      }
    }
    paramStringBuilder.append("has crmElem, but crmElem is null");
  }
  
  private void a(im_msg_body.Elem paramElem, im_msg_body.NotOnlineImage paramNotOnlineImage, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    BaseApplication.getContext().getString(2131695015);
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
                      paramMsg = bdhe.a((byte[])localObject2);
                    }
                  }
                }
                Object localObject2 = bays.a(paramElem, j, 1, false, paramElem, paramMsg, "picplatform", str1, str2, str3, str4, i5, 0);
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
                paramElem = (MessageForPic)azaf.a(-2000);
                if (bool) {
                  alse.a(paramElem, false);
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
                azri.a(BaseApplication.getContext()).a(paramNotOnlineImage, "actMessageEvent", false, 0L, 0L, paramElem, "");
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
  
  public azab a(List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder, long paramLong, bbpd parambbpd)
  {
    azab localazab = new azab(this);
    localazab.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = a(paramList, paramStringBuilder);
    azac localazac = new azac();
    ArrayList localArrayList = localazac.jdField_a_of_type_JavaUtilArrayList;
    StringBuilder localStringBuilder = a(null, paramList, paramStringBuilder, paramLong, parambbpd, localazac, null);
    if ((localArrayList != null) && (localArrayList.size() == 2)) {
      if (localArrayList.get(0) != null)
      {
        paramList = (MessageForText.AtTroopMemberInfo)localArrayList.get(0);
        paramStringBuilder = paramList;
        if (localArrayList.get(1) != null) {
          localazab.jdField_a_of_type_ArrayOfByte = ((byte[])localArrayList.get(1));
        }
      }
    }
    for (paramStringBuilder = paramList;; paramStringBuilder = null)
    {
      if ((localStringBuilder.length() > 0) && (localazab.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null))
      {
        localazab.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        if ((TextUtils.isEmpty(localazab.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName)) && (paramStringBuilder != null) && (!TextUtils.isEmpty(localazab.jdField_a_of_type_JavaLangString)) && (localazab.jdField_a_of_type_JavaLangString.length() >= paramStringBuilder.textLen + paramStringBuilder.startPos))
        {
          localazab.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo = paramStringBuilder;
          paramList = localazab.jdField_a_of_type_JavaLangString;
          localazab.jdField_a_of_type_JavaLangString = "";
          if (paramStringBuilder.startPos > 0) {
            localazab.jdField_a_of_type_JavaLangString = paramList.substring(0, paramStringBuilder.startPos);
          }
          localazab.jdField_a_of_type_JavaLangString += paramList.substring(paramStringBuilder.startPos + paramStringBuilder.textLen);
          localazab.b = paramList.substring(paramStringBuilder.startPos, paramStringBuilder.startPos + paramStringBuilder.textLen);
          if ((paramStringBuilder.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin())) && (localazac.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo == null)) {
            parambbpd.jdField_a_of_type_Bbpe.a = -1L;
          }
        }
      }
      return localazab;
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
            paramStringBuilder.msgData = amrf.a(paramElem);
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
        paramStringBuilder = (MessageForMarketFace)azaf.a(-2007);
        paramStringBuilder.msgtype = -2007;
        paramStringBuilder.msg = "it is marketface";
        paramStringBuilder.mMarkFaceMessage = paramElem;
        if ((paramElem.mobileparam != null) && (paramElem.mobileparam.length > 0)) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, "CliOper", "", "", "MbJieshou", "MbXiaoxi", 0, 0, "", "", "", "");
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
      paramStringBuilder = (MessageForDeliverGiftTips)azaf.a(-2035);
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
      paramString1 = (bcpt)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getManager(81);
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
          bcpt.a(paramStringBuilder, paramStringBuilder.grayTipsEntity.highlightItems);
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
        paramDeliverGiftMsg = Pattern.compile(alud.a(2131707041));
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
      paramStringBuilder = (MessageForTroopGift)azaf.a(-2038);
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
          localStringBuilder1.append(azah.a(((im_msg_body.Text)localObject).str.get().toStringUtf8(), false));
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
            m = apsp.b(((im_msg_body.Face)((im_msg_body.Elem)localObject).face.get()).index.get());
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
            char[] arrayOfChar = apmq.a(i, m);
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
      int i = apsp.b(((hummer_commelem.MsgElemInfo_servtype33)localObject).uint32_index.get());
      localObject = str;
      if (i >= 0) {
        localObject = apsp.b(i);
      }
      return localObject;
    }
    catch (InvalidProtocolBufferMicroException paramCommonElem)
    {
      paramCommonElem.printStackTrace();
    }
    return "";
  }
  
  public StringBuilder a(StringBuilder paramStringBuilder1, List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder2, long paramLong, bbpd parambbpd, azac paramazac, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    azac localazac = paramazac;
    if (paramazac == null) {
      localazac = new azac();
    }
    Object localObject2 = null;
    Object localObject1 = localazac.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo;
    paramazac = null;
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
      localStringBuilder.append(azah.a(((im_msg_body.Text)localObject1).str.get().toStringUtf8(), false));
    }
    label219:
    int k;
    int j;
    label274:
    label373:
    MessageForText.AtTroopMemberInfo localAtTroopMemberInfo;
    if (((im_msg_body.Text)localObject1).attr_6_buf.has())
    {
      localObject1 = ((im_msg_body.Text)localObject1).attr_6_buf.get();
      if (localObject1 != null)
      {
        localObject2 = ((ByteStringMicro)localObject1).toByteArray();
        if ((parambbpd != null) && ((parambbpd.jdField_a_of_type_Int == 3000) || (parambbpd.jdField_a_of_type_Int == 1)) && (paramArrayList != null) && (localObject2 != null) && (localObject2.length != 0))
        {
          n = bdqa.a((byte[])localObject2, 0);
          k = 2;
          j = 0;
          if ((j < n) && (k < 2048))
          {
            localObject1 = new MessageForText.AtTroopMemberInfo();
            if (((MessageForText.AtTroopMemberInfo)localObject1).readFrom((byte[])localObject2, k)) {
              break label467;
            }
          }
        }
        if ((parambbpd == null) || ((!parambbpd.jdField_a_of_type_Bbpe.a(paramLong)) && (!parambbpd.f.a(paramLong)) && (paramList != null)) || (localObject2 == null) || (localObject2.length == 0)) {
          break label1406;
        }
        int n = bdqa.a((byte[])localObject2, 0);
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
          break label509;
        }
        localObject1 = paramList;
        paramList = paramStringBuilder1;
        paramStringBuilder1 = (StringBuilder)localObject1;
      }
    }
    for (;;)
    {
      localObject1 = paramazac;
      paramazac = paramList;
      paramList = paramStringBuilder1;
      paramStringBuilder1 = (StringBuilder)localObject1;
      label448:
      localObject1 = paramazac;
      paramazac = paramStringBuilder1;
      paramStringBuilder1 = (StringBuilder)localObject1;
      break;
      localObject2 = null;
      break label219;
      label467:
      k += ((MessageForText.AtTroopMemberInfo)localObject1).length();
      ((MessageForText.AtTroopMemberInfo)localObject1).startPos = ((short)(((MessageForText.AtTroopMemberInfo)localObject1).startPos + m));
      j = (short)(j + 1);
      paramArrayList.add(localObject1);
      break label274;
      label509:
      k += localAtTroopMemberInfo.length();
      localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + m));
      j = (short)(j + 1);
      if (localAtTroopMemberInfo.isIncludingAll()) {
        parambbpd.f.a = paramLong;
      }
      if ((localAtTroopMemberInfo.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin())) && (parambbpd.jdField_a_of_type_Bbpe != null))
      {
        parambbpd.jdField_a_of_type_Bbpe.a = paramLong;
        if ((localAtTroopMemberInfo != paramStringBuilder1) && (paramList == null) && (paramStringBuilder1.isIncludingMe(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin()))) {
          paramList = localAtTroopMemberInfo;
        }
      }
      for (;;)
      {
        localObject1 = paramStringBuilder1;
        break label373;
        label630:
        if (((im_msg_body.Elem)localObject1).face.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:Face;\n");
          }
          if (!((im_msg_body.Face)((im_msg_body.Elem)localObject1).face.get()).index.has()) {
            break label1255;
          }
          j = apsp.b(((im_msg_body.Face)((im_msg_body.Elem)localObject1).face.get()).index.get());
          if (j >= 0)
          {
            localStringBuilder.append('\024');
            localStringBuilder.append((char)j);
          }
          localObject1 = paramStringBuilder1;
          paramStringBuilder1 = paramazac;
          paramazac = (azac)localObject1;
          break label448;
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
          localObject2 = apmq.a(i, j);
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
          paramStringBuilder1 = paramazac;
          paramazac = (azac)localObject1;
          break label448;
        }
        if (((im_msg_body.Elem)localObject1).online_image.has())
        {
          if (QLog.isColorLevel()) {
            paramStringBuilder2.append("elemType:OnlineImage;\n");
          }
          localStringBuilder.append(BaseApplication.getContext().getString(2131695015));
          localObject1 = paramStringBuilder1;
          paramStringBuilder1 = paramazac;
          paramazac = (azac)localObject1;
          break label448;
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
          paramazac = paramStringBuilder1;
          paramStringBuilder1 = (StringBuilder)localObject1;
          break label448;
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
        paramStringBuilder1 = paramazac;
        paramazac = (azac)localObject1;
        break label448;
        label1268:
        localazac.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo = paramList;
        paramList = localazac.jdField_a_of_type_JavaUtilArrayList;
        if ((paramList != null) && ((paramStringBuilder1 != null) || (paramazac != null)))
        {
          if (!paramList.isEmpty()) {
            break label1316;
          }
          paramList.add(paramStringBuilder1);
          paramList.add(paramazac);
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
          paramList.add(paramazac);
          return localStringBuilder;
          paramStringBuilder1 = paramList.get(0);
          break;
          label1385:
          paramazac = paramList.get(1);
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
  
  public void a(MessageHandler paramMessageHandler, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd)
  {
    paramList = a(paramList, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), parambbpd);
    paramMsg = paramList.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    if (paramList.jdField_a_of_type_JavaLangString != null)
    {
      paramStringBuilder = (ChatMessage)azaf.a(-1049);
      paramStringBuilder.msg = paramList.jdField_a_of_type_JavaLangString;
      parambbpd = (MessageForReplyText)paramStringBuilder;
    }
    try
    {
      parambbpd.extLong |= 0x1;
      if (paramMsg.getSourceMsg() != null)
      {
        parambbpd.setSourceMessageRecord(paramMsg.unPackSourceMsg(paramMessageHandler.app));
        if ((parambbpd.getSourceMessage() != null) && (arrr.a(parambbpd.getSourceMessage())))
        {
          paramMessageHandler = parambbpd.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
          ChatMessage localChatMessage = arrr.a((ChatMessage)parambbpd.getSourceMessage());
          arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, parambbpd.getSourceMessage());
          if ((!TextUtils.isEmpty(paramMessageHandler)) && (localChatMessage != null))
          {
            int i = Integer.parseInt(paramMessageHandler);
            if ((i == 1) || (i == 2))
            {
              QLog.i("DecodeMsg<QFile>", 1, "decode reply file msg, msg uniseq[" + localChatMessage.uniseq + "]");
              arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)parambbpd.getSourceMessage());
            }
          }
        }
      }
      paramMessageHandler = bdhe.a(amrf.a(paramMsg));
      parambbpd.mSourceMsgInfo = paramMsg;
      parambbpd.saveExtInfoToExtStr("sens_msg_source_msg_info", paramMessageHandler);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, "reply:" + parambbpd + " sourceMsg=" + parambbpd.getSourceMessage());
      }
    }
    catch (Exception paramMessageHandler)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramMessageHandler.getMessage());
        }
      }
    }
    if (paramList.jdField_a_of_type_ArrayOfByte != null) {
      paramStringBuilder.saveExtInfoToExtStr("sens_msg_ctrl_info", bdhe.a(paramList.jdField_a_of_type_ArrayOfByte));
    }
    paramList1.add(paramStringBuilder);
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "reply msgRand = " + azah.a(paramStringBuilder.msgUid) + ", msgUid = " + paramStringBuilder.msgUid);
    }
  }
  
  public void a(MessageHandler paramMessageHandler, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder("");
    ChatMessage localChatMessage = null;
    int i = 0;
    azac localazac = new azac();
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
            localMessageForText = (MessageForText)azaf.a(-1000);
            localMessageForText.msgtype = -1000;
            localMessageForText.msg = ((StringBuilder)localObject1).toString();
            localMessageForText.atInfoList = ((ArrayList)localObject2);
            localObject3 = new ArrayList(2);
            localArrayList.add(localMessageForText);
            ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          }
          a(localElem, null, localArrayList, paramStringBuilder, paramMsg, paramBoolean, parambbpd);
        }
        for (localObject2 = localObject3;; localObject2 = localObject3)
        {
          break;
          if (!localElem.not_online_image.has()) {
            break label304;
          }
          localObject3 = localObject2;
          if (((StringBuilder)localObject1).length() > 0)
          {
            localMessageForText = (MessageForText)azaf.a(-1000);
            localMessageForText.msgtype = -1000;
            localMessageForText.msg = ((StringBuilder)localObject1).toString();
            localMessageForText.atInfoList = ((ArrayList)localObject2);
            localObject3 = new ArrayList(2);
            localArrayList.add(localMessageForText);
            ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
          }
          a(localElem, null, localArrayList, paramStringBuilder, paramMsg);
        }
        label304:
        if (a(localElem).booleanValue())
        {
          if (i != 0)
          {
            i = 0;
            continue;
          }
          if (!localElem.small_emoji.has()) {
            break label2038;
          }
          i = 1;
        }
      }
    }
    label1567:
    label1592:
    label1982:
    label1990:
    label2038:
    for (;;)
    {
      localObject3 = new ArrayList();
      ((List)localObject3).add(localElem);
      localObject1 = a((StringBuilder)localObject1, (List)localObject3, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), parambbpd, localazac, (ArrayList)localObject2);
      break;
      if (localElem.general_flags.has())
      {
        localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
        break;
        if (((StringBuilder)localObject1).length() > 0)
        {
          localObject3 = (MessageForText)azaf.a(-1000);
          ((MessageForText)localObject3).msgtype = -1000;
          ((MessageForText)localObject3).msg = ((StringBuilder)localObject1).toString();
          ((MessageForText)localObject3).atInfoList = ((ArrayList)localObject2);
          if (parambbpd != null) {
            bciq.a(parambbpd.jdField_a_of_type_Int, (ArrayList)localObject2, (ChatMessage)localObject3);
          }
          localArrayList.add(localObject3);
          ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
        }
        localObject2 = localazac.jdField_a_of_type_JavaUtilArrayList;
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
          paramList = a(paramList, paramStringBuilder);
          if (paramList != null) {
            paramStringBuilder = (MessageForReplyText)azaf.a(-1049);
          }
          try
          {
            paramStringBuilder.extLong |= 0x1;
            paramStringBuilder.mSourceMsgInfo = paramList;
            if (paramList.getSourceMsg() != null)
            {
              paramStringBuilder.setSourceMessageRecord(paramList.unPackSourceMsg(paramMessageHandler.app));
              if ((paramStringBuilder.getSourceMessage() != null) && (arrr.a(paramStringBuilder.getSourceMessage())))
              {
                localObject3 = paramStringBuilder.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                localChatMessage = arrr.a((ChatMessage)paramStringBuilder.getSourceMessage());
                arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, paramStringBuilder.getSourceMessage());
                if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (localChatMessage != null))
                {
                  i = Integer.parseInt((String)localObject3);
                  if ((i == 1) || (i == 2))
                  {
                    QLog.i("DecodeMsg<QFile>", 1, "decode mix inner reply file msg, msg uniseq[" + localChatMessage.uniseq + "]");
                    arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)paramStringBuilder.getSourceMessage());
                  }
                }
              }
            }
            paramStringBuilder.saveExtInfoToExtStr("sens_msg_source_msg_info", bdhe.a(amrf.a(paramList)));
          }
          catch (Exception paramList)
          {
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramList.getMessage());
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
            if (localObject2 != null)
            {
              if (localArrayList.size() <= 0) {
                break label1592;
              }
              localObject3 = (MessageRecord)localArrayList.get(0);
              if (!(localObject3 instanceof MessageForText)) {
                break label1567;
              }
              paramList = (MessageForReplyText)azaf.a(-1049);
              MessageRecord.copyMessageRecordBaseField(paramList, (MessageRecord)localObject3);
              MessageRecord.copyMessageRecordStatusField(paramList, (MessageRecord)localObject3);
              paramList.atInfoList = paramStringBuilder.atInfoList;
              paramList.msg = ((MessageRecord)localObject3).msg;
              paramList.mSourceMsgInfo = paramStringBuilder.mSourceMsgInfo;
              paramList.msgtype = -1049;
              if ((!TextUtils.isEmpty(paramList.msg)) && (paramList.msg.length() >= ((MessageForText.AtTroopMemberInfo)localObject2).textLen + ((MessageForText.AtTroopMemberInfo)localObject2).startPos))
              {
                paramStringBuilder = paramList.msg;
                paramList.msg = "";
                if (((MessageForText.AtTroopMemberInfo)localObject2).startPos > 0) {
                  paramList.msg = paramStringBuilder.substring(0, ((MessageForText.AtTroopMemberInfo)localObject2).startPos);
                }
                paramList.msg += paramStringBuilder.substring(((MessageForText.AtTroopMemberInfo)localObject2).startPos + ((MessageForText.AtTroopMemberInfo)localObject2).textLen);
                if ((((MessageForText.AtTroopMemberInfo)localObject2).isIncludingMe(paramMessageHandler.app.getLongAccountUin())) && (localazac.jdField_a_of_type_ComTencentMobileqqDataMessageForText$AtTroopMemberInfo == null)) {
                  parambbpd.jdField_a_of_type_Bbpe.a = -1L;
                }
              }
              localArrayList.remove(0);
              localArrayList.add(0, paramList);
              paramList = null;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "sb.length == 0");
          }
          if (paramList != null) {
            localArrayList.add(0, paramList);
          }
          if ((localGeneralFlags != null) && (localGeneralFlags.babyq_guide_msg_cookie.has())) {}
          try
          {
            if (localArrayList.size() > 0)
            {
              paramList = (MessageRecord)localArrayList.get(0);
              paramStringBuilder = localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
              localObject3 = bdeu.a(paramStringBuilder);
              if (QLog.isColorLevel()) {
                QLog.d("DecodeMsg", 2, "decodePBMsgElems_Pic, guideMsgCookie: " + (String)localObject3 + " ,byte: " + Arrays.toString(localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
              }
              paramList.saveExtInfoToExtStr("guide_msg_cookie", (String)localObject3);
              ((alok)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(paramStringBuilder);
            }
          }
          catch (Exception paramList)
          {
            for (;;)
            {
              int j;
              long l;
              int k;
              int m;
              if (QLog.isColorLevel())
              {
                QLog.d("DecodeMsg", 2, "get pic msg guideMsgCookie error!", paramList);
                continue;
                if (paramStringBuilder.msgtype == -2000)
                {
                  j += 1;
                  continue;
                  label1656:
                  continue;
                  if (j != 0)
                  {
                    paramList = new ArrayList();
                    paramStringBuilder = localArrayList.iterator();
                    while (paramStringBuilder.hasNext())
                    {
                      paramMsg = (MessageRecord)paramStringBuilder.next();
                      if ((paramMsg.msgtype != -1000) && (paramMsg.msgtype != -1049) && (paramMsg.msgtype != -2000))
                      {
                        if (paramList.size() > 0) {
                          if (k == 0) {
                            break label1837;
                          }
                        }
                        for (paramMessageHandler = null;; paramMessageHandler = (MessageHandler)localObject1)
                        {
                          paramList1.add(azad.a(paramList, paramMessageHandler, parambbpd));
                          paramList.clear();
                          paramList1.add(paramMsg);
                          break;
                        }
                      }
                      paramList.add(paramMsg);
                    }
                    if (paramList.size() > 0)
                    {
                      if (k != 0) {
                        localObject1 = null;
                      }
                      paramMessageHandler = azad.a(paramList, (byte[])localObject1, parambbpd);
                      paramList1.add(paramMessageHandler);
                      ((MessageForMixedMsg)paramMessageHandler).mAtInfo = ((MessageForText.AtTroopMemberInfo)localObject2);
                      paramList.clear();
                    }
                  }
                  for (;;)
                  {
                    return;
                    if (localObject1 == null)
                    {
                      paramList1.addAll(localArrayList);
                      return;
                    }
                    paramMessageHandler = localArrayList.iterator();
                    while (paramMessageHandler.hasNext())
                    {
                      paramList = (MessageRecord)paramMessageHandler.next();
                      if (((paramList instanceof MessageForText)) && (k == 0)) {
                        paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", bdhe.a((byte[])localObject1));
                      }
                      paramList1.add(paramList);
                    }
                  }
                  i = 0;
                  paramMessageHandler = null;
                  continue;
                  k = 0;
                }
                else
                {
                  continue;
                  j = 0;
                }
              }
            }
          }
          if (localArrayList.size() > 1)
          {
            paramList = localArrayList.iterator();
            j = 0;
            i = 0;
            if (paramList.hasNext())
            {
              paramStringBuilder = (MessageRecord)paramList.next();
              if (((paramStringBuilder.msgtype == -1000) || (paramStringBuilder.msgtype == -1049)) && (i == 0))
              {
                i = 1;
                j += 1;
                if (j < 2) {
                  break label1656;
                }
                j = 1;
                if (!paramMsg.msg_head.from_uin.has()) {
                  break label1990;
                }
                l = paramMsg.msg_head.from_uin.get();
                if (!TextUtils.equals(paramMessageHandler.app.getCurrentAccountUin(), Long.toString(l))) {
                  break label1990;
                }
                k = 1;
                m = 0;
                paramList = null;
                if ((localGeneralFlags == null) || (!localGeneralFlags.bytes_pb_reserve.has())) {
                  break label1982;
                }
              }
              try
              {
                paramStringBuilder = new generalflags.ResvAttr();
                paramStringBuilder.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
                paramMessageHandler = paramList;
                i = m;
                if (paramStringBuilder.bytes_kpl_info.has())
                {
                  paramMessageHandler = paramList;
                  i = m;
                  if (paramStringBuilder.bytes_kpl_info.has())
                  {
                    i = 1;
                    paramMessageHandler = paramStringBuilder.bytes_kpl_info.get().toStringUtf8();
                  }
                }
              }
              catch (Exception paramMessageHandler)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
                  }
                  paramMessageHandler.printStackTrace();
                  i = 0;
                  paramMessageHandler = null;
                }
                if (!QLog.isColorLevel()) {
                  break label1704;
                }
                QLog.d("KplMessage", 2, "resv a kpl pic message !");
                KplRoleInfo.handleKplFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageHandler);
              }
              if (i != 0)
              {
                paramList = localArrayList.iterator();
                while (paramList.hasNext()) {
                  ((MessageRecord)paramList.next()).saveExtInfoToExtStr("msg_ext_key", "Y");
                }
              }
            }
          }
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
          localObject1 = null;
          break;
          localObject1 = null;
          localObject2 = localChatMessage;
        }
      }
      break;
    }
  }
  
  public void a(ArrayList<String> paramArrayList, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd, azaj paramazaj, ayzj paramayzj)
  {
    if (paramArrayList.contains("lifeOnline")) {
      a(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
    }
    if (paramArrayList.contains("updateAvatar")) {
      a(paramList, paramMsg, paramStringBuilder);
    }
    paramArrayList = paramList.iterator();
    int i;
    long l;
    int n;
    int m;
    if (paramArrayList.hasNext())
    {
      paramList = (im_msg_body.Elem)paramArrayList.next();
      if ((paramList.near_by_msg.has()) && (paramList.near_by_msg.uint32_identify_type.has()) && (paramList.near_by_msg.uint32_identify_type.get() == 1))
      {
        if (!paramList1.isEmpty()) {
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("identify_flag", "true");
        }
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType: near_by_msg has identify;\n");
        }
      }
      if ((paramList.general_flags.has()) && (((im_msg_body.GeneralFlags)paramList.general_flags.get()).uint32_olympic_torch.has()))
      {
        i = paramList.general_flags.uint32_olympic_torch.get();
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("has olympicTorch:").append(i).append(";");
        }
        if ((i > 0) && (!paramList1.isEmpty())) {
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("olympic_torch_flg", i + "");
        }
      }
      if (paramList.crm_elem.has()) {
        a(paramList, paramList1, paramStringBuilder, paramMsg, paramazaj);
      }
      if (paramList.general_flags.has())
      {
        if (paramList.general_flags.uint64_pendant_id.has())
        {
          l = paramList.general_flags.uint64_pendant_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "vip_pendant_id = " + l);
          }
          if ((l >= 0L) && (!paramList1.isEmpty())) {
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("vip_pendant_id", String.valueOf(l));
          }
        }
        k = 0;
        n = 0;
        m = 0;
        if (paramList.general_flags.bytes_pb_reserve.has())
        {
          parambbpd = new generalflags.ResvAttr();
          j = n;
        }
      }
      try
      {
        parambbpd.mergeFrom(paramList.general_flags.bytes_pb_reserve.get().toByteArray());
        j = n;
        if (parambbpd.float_sticker_x.has())
        {
          j = n;
          localObject1 = new EmojiStickerManager.StickerInfo();
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).x = parambbpd.float_sticker_x.get();
          j = n;
          if (!parambbpd.float_sticker_y.has()) {
            break label2591;
          }
          j = n;
          f = parambbpd.float_sticker_y.get();
          label519:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).y = f;
          j = n;
          if (!parambbpd.float_sticker_width.has()) {
            break label2597;
          }
          j = n;
          f = parambbpd.float_sticker_width.get();
          label559:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).width = f;
          j = n;
          if (!parambbpd.float_sticker_height.has()) {
            break label2603;
          }
          j = n;
          f = parambbpd.float_sticker_height.get();
          label599:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).height = f;
          j = n;
          if (!parambbpd.uint32_sticker_rotate.has()) {
            break label2609;
          }
          j = n;
          i = parambbpd.uint32_sticker_rotate.get();
          label639:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).rotate = i;
          j = n;
          if (!parambbpd.uint64_sticker_host_msgseq.has()) {
            break label2615;
          }
          j = n;
          l = parambbpd.uint64_sticker_host_msgseq.get();
          label679:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).hostMsgSeq = l;
          j = n;
          if (!parambbpd.uint64_sticker_host_msguid.has()) {
            break label2621;
          }
          j = n;
          l = parambbpd.uint64_sticker_host_msguid.get();
          label719:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).hostMsgUid = l;
          j = n;
          if (!parambbpd.uint64_sticker_host_time.has()) {
            break label2627;
          }
          j = n;
          l = parambbpd.uint64_sticker_host_time.get();
          label759:
          j = n;
          ((EmojiStickerManager.StickerInfo)localObject1).hostMsgTime = l;
          j = n;
          if (QLog.isColorLevel())
          {
            j = n;
            QLog.d("DecodeMsg", 2, "decodeC2CMsgPkg_EmojSticker->" + ((EmojiStickerManager.StickerInfo)localObject1).toString());
          }
          j = n;
          if (!paramList1.isEmpty())
          {
            j = n;
            localObject2 = (MessageRecord)paramList1.get(0);
            if (localObject2 != null)
            {
              j = n;
              ((MessageRecord)localObject2).saveExtInfoToExtStr("sticker_info", ((EmojiStickerManager.StickerInfo)localObject1).toJsonString());
              j = n;
              EmojiStickerManager.a((MessageRecord)localObject2, (EmojiStickerManager.StickerInfo)localObject1);
              j = n;
              ((MessageRecord)localObject2).saveExtInfoToExtStr("message_is_sticker", "true");
            }
          }
        }
        j = n;
        if (!parambbpd.uint32_mobile_custom_font.has()) {
          break label2633;
        }
        j = n;
        l = parambbpd.uint32_mobile_custom_font.get() & 0xFFFFFFFF;
        j = n;
        if (!paramList1.isEmpty())
        {
          j = n;
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
        }
        j = n;
        if (!QLog.isColorLevel()) {
          break label2750;
        }
        j = n;
        QLog.d("DecodeMsg", 2, "vip_font_id = " + l + " fontId = " + fx.a(l) + " type = " + fx.b(l));
      }
      catch (InvalidProtocolBufferMicroException parambbpd)
      {
        for (;;)
        {
          Object localObject1;
          float f;
          Object localObject2;
          label1035:
          parambbpd.printStackTrace();
          k = j;
          continue;
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("VasFont", 2, "diy_font_timestamp not in message");
          }
        }
      }
      j = i;
      if (parambbpd.uint64_subfont_id.has())
      {
        j = i;
        l = parambbpd.uint64_subfont_id.get();
        j = i;
        if (!paramList1.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(l));
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags: subFontId=" + l);
        }
      }
      j = i;
      if (parambbpd.uint32_diy_font_timestamp.has())
      {
        j = i;
        l = parambbpd.uint32_diy_font_timestamp.get();
        j = i;
        if (!paramList1.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("diy_timestamp", String.valueOf(l));
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("VasFont", 2, "diy_font_timestamp = " + l);
        }
        j = i;
        if (parambbpd.uint32_tail_key.has())
        {
          j = i;
          if (2 == parambbpd.uint32_tail_key.get())
          {
            j = i;
            if (parambbpd.uint32_show_tail_flag.has())
            {
              j = i;
              if (1 != parambbpd.uint32_show_tail_flag.get())
              {
                j = i;
                parambbpd.uint32_tail_key.clear();
                j = i;
                if (QLog.isColorLevel())
                {
                  j = i;
                  QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_show_tail_flag != 1, uint32_tail_key been cleaned ");
                }
              }
            }
          }
        }
        j = i;
        if (parambbpd.uint32_tail_key.has())
        {
          j = i;
          k = parambbpd.uint32_tail_key.get();
          j = i;
          if (!paramList1.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("app_tail_id", String.valueOf(k));
          }
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_tail_key = " + k);
          }
        }
        j = i;
        if (parambbpd.uint32_bot_message_class_id.has())
        {
          j = i;
          k = parambbpd.uint32_bot_message_class_id.get();
          j = i;
          if (!paramList1.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("robot_news_class_id", String.valueOf(k));
          }
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_bot_message_class_id = " + k);
          }
        }
        j = i;
        if (parambbpd.uint32_holiday_flag.has())
        {
          j = i;
          k = parambbpd.uint32_holiday_flag.get();
          if (k == 1)
          {
            j = i;
            if (!paramList1.isEmpty())
            {
              j = i;
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr(ayzs.c, String.valueOf(k));
            }
          }
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags uint32_holiday_flag = " + k);
          }
        }
        j = i;
        localObject1 = new StringBuilder("<---decodeMiniProgramPBMsgElems:");
        j = i;
        if (parambbpd.uint32_service_msg_type.has())
        {
          j = i;
          k = parambbpd.uint32_service_msg_type.get();
          j = i;
          if (!paramList1.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr(ayzs.w, String.valueOf(k));
          }
          j = i;
          ((StringBuilder)localObject1).append("---uint32_service_msg_type = ").append(k).append("---");
        }
        j = i;
        if (parambbpd.uint32_service_msg_remind_type.has())
        {
          j = i;
          k = parambbpd.uint32_service_msg_remind_type.get();
          j = i;
          if (!paramList1.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr(ayzs.x, String.valueOf(k));
          }
          j = i;
          ((StringBuilder)localObject1).append("---uint32_service_msg_remind_type = ").append(k).append("---");
        }
        j = i;
        if (parambbpd.bytes_service_msg_name.has())
        {
          j = i;
          localObject2 = parambbpd.bytes_service_msg_name.get().toStringUtf8();
          j = i;
          if (!paramList1.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr(ayzs.y, (String)localObject2);
          }
          j = i;
          ((StringBuilder)localObject1).append("---bytes_service_msg_name = ").append((String)localObject2).append("---");
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("DecodeMsg", 2, new Object[] { localObject1 });
        }
        j = i;
      }
    }
    try
    {
      if (parambbpd.uint32_msg_info_flag.has())
      {
        j = i;
        k = parambbpd.uint32_msg_info_flag.get();
        j = i;
        if (!paramList1.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(k));
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.i("DecodeMsg", 2, "handleGeneralSettingFlags: invoked.  flag: " + k);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label2106:
      break label2106;
    }
    int k = i;
    int j = i;
    if (parambbpd.uint32_comment_flag.has())
    {
      k = i;
      j = i;
      if (parambbpd.uint64_comment_location.has())
      {
        k = i;
        j = i;
        if (!paramList1.isEmpty())
        {
          j = i;
          if (parambbpd.uint32_comment_flag.get() != 1) {
            break label2756;
          }
        }
      }
    }
    label2591:
    label2597:
    label2603:
    label2609:
    label2615:
    label2621:
    label2627:
    label2756:
    for (boolean bool = true;; bool = false)
    {
      j = i;
      l = parambbpd.uint64_comment_location.get();
      j = i;
      localObject1 = (MessageRecord)paramList1.get(0);
      j = i;
      if ((localObject1 instanceof MessageForReplyText))
      {
        j = i;
        localObject1 = (MessageForReplyText)localObject1;
        j = i;
        ((MessageForReplyText)localObject1).isBarrageMsg = bool;
        j = i;
        ((MessageForReplyText)localObject1).barrageTimeLocation = l;
        j = i;
        if (((MessageForReplyText)localObject1).isBarrageMsg)
        {
          j = i;
          ((MessageForReplyText)localObject1).saveExtInfoToExtStr("barrage_time_location", String.valueOf(((MessageForReplyText)localObject1).barrageTimeLocation));
          j = i;
        }
      }
      try
      {
        localObject2 = new oidb_0xdea.PassThrough();
        j = i;
        ((oidb_0xdea.PassThrough)localObject2).mergeFrom(parambbpd.bytes_pass_through.get().toByteArray());
        j = i;
        ((MessageForReplyText)localObject1).barrageSourceMsgType = ((oidb_0xdea.PassThrough)localObject2).entrance.get();
      }
      catch (Exception parambbpd)
      {
        for (;;)
        {
          j = i;
          QLog.i("DecodeMsg", 1, "handleGeneralSettingFlags fail, " + parambbpd);
        }
      }
      k = i;
      j = i;
      if (QLog.isColorLevel())
      {
        j = i;
        QLog.d("DecodeMsg", 2, new Object[] { "receive replay msg, isBarrageMsg: ", Boolean.valueOf(bool), " timeLocation:", Long.valueOf(l) });
        k = i;
      }
      if (k == 0)
      {
        l = azad.a(paramMsg);
        if (l >= 0L)
        {
          if (!paramList1.isEmpty()) {
            ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
          }
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "old vip_font_id = " + l + " fontId = " + fx.a(l) + " type = " + fx.b(l));
          }
        }
      }
      if ((paramList.common_elem.has()) && (21 == paramList.common_elem.uint32_service_type.get())) {
        aoiy.a(paramMsg, paramList, paramList1, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app);
      }
      if ((!paramList.common_elem.has()) || (34 != paramList.common_elem.uint32_service_type.get())) {
        break;
      }
      asnd.a(paramMsg, paramList, paramList1, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramayzj);
      break;
      f = 0.0F;
      break label519;
      f = 0.0F;
      break label559;
      f = 0.0F;
      break label599;
      i = 0;
      break label639;
      l = 0L;
      break label679;
      l = 0L;
      break label719;
      l = 0L;
      break label759;
      label2633:
      i = m;
      j = n;
      if (!QLog.isColorLevel()) {
        break label1035;
      }
      j = n;
      QLog.d("DecodeMsg", 2, "handleGeneralSettingFlags vip_font not has");
      i = m;
      break label1035;
      return;
      i = 1;
      break label1035;
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if ((localElem.general_flags.has()) && (localElem.general_flags.bytes_pb_reserve.has()))
      {
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        try
        {
          localResvAttr.mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
          if (localResvAttr.uint32_tail_key.has())
          {
            int i = localResvAttr.uint32_tail_key.get();
            if (2 == i) {
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("app_qim_tail_id", String.valueOf(i));
            }
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    Object localObject1 = null;
    Object localObject3 = paramList.iterator();
    int j = 0;
    Object localObject2 = null;
    int i = -1;
    paramList = (List<im_msg_body.Elem>)localObject1;
    localObject1 = localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (im_msg_body.Elem)((Iterator)localObject3).next();
      if (!((im_msg_body.Elem)localObject2).video_file.has()) {
        break label1362;
      }
      localObject1 = (im_msg_body.VideoFile)((im_msg_body.Elem)localObject2).video_file.get();
    }
    label1315:
    label1346:
    label1362:
    for (;;)
    {
      int k = j;
      if (((im_msg_body.Elem)localObject2).bless_msg.has())
      {
        k = j;
        if (((im_msg_body.Elem)localObject2).bless_msg.uint32_msg_type.get() == 1)
        {
          k = 1;
          if (((im_msg_body.Elem)localObject2).bless_msg.uint32_ex_flag.has()) {
            i = ((im_msg_body.Elem)localObject2).bless_msg.uint32_ex_flag.get();
          }
        }
      }
      for (j = 1;; j = k)
      {
        if (((im_msg_body.Elem)localObject2).general_flags.has()) {
          paramList = (im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject2).general_flags.get();
        }
        for (;;)
        {
          break;
          if (localObject1 == null) {}
          for (;;)
          {
            return;
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("elemType:video_file;\n");
            }
            localObject2 = new RichMsg.VideoFile();
            ((RichMsg.VideoFile)localObject2).setHasFlag(true);
            ((RichMsg.VideoFile)localObject2).bytes_file_name.set(((im_msg_body.VideoFile)localObject1).bytes_file_name.get());
            ((RichMsg.VideoFile)localObject2).bytes_file_md5.set(((im_msg_body.VideoFile)localObject1).bytes_file_md5.get());
            ((RichMsg.VideoFile)localObject2).bytes_file_uuid.set(((im_msg_body.VideoFile)localObject1).bytes_file_uuid.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_format.set(((im_msg_body.VideoFile)localObject1).uint32_file_format.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_size.set(((im_msg_body.VideoFile)localObject1).uint32_file_size.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_time.set(((im_msg_body.VideoFile)localObject1).uint32_file_time.get());
            ((RichMsg.VideoFile)localObject2).uint32_thumb_width.set(((im_msg_body.VideoFile)localObject1).uint32_thumb_width.get());
            ((RichMsg.VideoFile)localObject2).uint32_thumb_height.set(((im_msg_body.VideoFile)localObject1).uint32_thumb_height.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_status.set(2008);
            ((RichMsg.VideoFile)localObject2).uint32_file_progress.set(0);
            ((RichMsg.VideoFile)localObject2).bytes_thumb_file_md5.set(((im_msg_body.VideoFile)localObject1).bytes_thumb_file_md5.get());
            ((RichMsg.VideoFile)localObject2).bytes_source.set(((im_msg_body.VideoFile)localObject1).bytes_source.get());
            ((RichMsg.VideoFile)localObject2).uint32_thumb_file_size.set(((im_msg_body.VideoFile)localObject1).uint32_thumb_file_size.get());
            ((RichMsg.VideoFile)localObject2).uint32_busi_type.set(((im_msg_body.VideoFile)localObject1).uint32_busi_type.get());
            ((RichMsg.VideoFile)localObject2).uin32_from_chat_type.set(((im_msg_body.VideoFile)localObject1).uint32_from_chat_type.get());
            ((RichMsg.VideoFile)localObject2).uin32_to_chat_type.set(((im_msg_body.VideoFile)localObject1).uint32_to_chat_type.get());
            ((RichMsg.VideoFile)localObject2).bool_support_progressive.set(((im_msg_body.VideoFile)localObject1).bool_support_progressive.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_width.set(((im_msg_body.VideoFile)localObject1).uint32_file_width.get());
            ((RichMsg.VideoFile)localObject2).uint32_file_height.set(((im_msg_body.VideoFile)localObject1).uint32_file_height.get());
            ((RichMsg.VideoFile)localObject2).uint32_sub_busi_type.set(((im_msg_body.VideoFile)localObject1).uint32_sub_busi_type.get());
            ((RichMsg.VideoFile)localObject2).uint32_video_attr.set(((im_msg_body.VideoFile)localObject1).uint32_video_attr.get());
            if (((im_msg_body.VideoFile)localObject1).bytes_pb_reserve.has()) {
              localObject3 = new videoFile.ResvAttr();
            }
            try
            {
              ((videoFile.ResvAttr)localObject3).mergeFrom(((im_msg_body.VideoFile)localObject1).bytes_pb_reserve.get().toByteArray());
              ((RichMsg.VideoFile)localObject2).bytes_hotvideo_icon.set(((videoFile.ResvAttr)localObject3).bytes_hotvideo_icon.get());
              ((RichMsg.VideoFile)localObject2).bytes_hotvideo_icon_sub.set(((videoFile.ResvAttr)localObject3).bytes_hotvideo_icon_sub.get());
              ((RichMsg.VideoFile)localObject2).bytes_hotvideo_title.set(((videoFile.ResvAttr)localObject3).bytes_hotvideo_title.get());
              ((RichMsg.VideoFile)localObject2).bytes_hotvideo_url.set(((videoFile.ResvAttr)localObject3).bytes_hotvideo_url.get());
              ((RichMsg.VideoFile)localObject2).uint32_special_video_type.set(((videoFile.ResvAttr)localObject3).uint32_special_video_type.get());
              ((RichMsg.VideoFile)localObject2).uint32_msg_tail_type.set(((videoFile.ResvAttr)localObject3).uint32_msg_tail_type.get());
              ((RichMsg.VideoFile)localObject2).uint32_long_video_kandian_type.set(((videoFile.ResvAttr)localObject3).uint32_long_video_kandian_type.get());
              if (((videoFile.ResvAttr)localObject3).bytes_camera_templateid.has()) {
                ((RichMsg.VideoFile)localObject2).bytes_camera_video_templateid.set(((videoFile.ResvAttr)localObject3).bytes_camera_templateid.get());
              }
              if (((videoFile.ResvAttr)localObject3).bytes_camera_templateName.has()) {
                ((RichMsg.VideoFile)localObject2).bytes_camera_video_templatename.set(((videoFile.ResvAttr)localObject3).bytes_camera_templateName.get());
              }
              if ((paramList != null) && (paramList.bytes_pb_reserve.has())) {
                localObject1 = new generalflags.ResvAttr();
              }
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              try
              {
                do
                {
                  ((generalflags.ResvAttr)localObject1).mergeFrom(paramList.bytes_pb_reserve.get().toByteArray());
                  ((RichMsg.VideoFile)localObject2).uint32_red_envelope_type.set(((generalflags.ResvAttr)localObject1).uint32_red_envelope_type.get());
                  ((RichMsg.VideoFile)localObject2).bytes_shortVideoId.set(((generalflags.ResvAttr)localObject1).bytes_shortVideoId.get());
                  localObject1 = (MessageForShortVideo)azaf.a(-2022);
                  ((MessageForShortVideo)localObject1).msgtype = -2022;
                  ((MessageForShortVideo)localObject1).msgData = ((RichMsg.VideoFile)localObject2).toByteArray();
                  if (((RichMsg.VideoFile)localObject2).uint32_busi_type.get() != 2) {
                    break label1315;
                  }
                  ((MessageForShortVideo)localObject1).msg = azdf.b;
                  if ((paramList != null) && (paramList.babyq_guide_msg_cookie.has())) {}
                  try
                  {
                    babyq_cookie.BabyQCookie localBabyQCookie = new babyq_cookie.BabyQCookie();
                    localObject3 = paramList.babyq_guide_msg_cookie.get().toByteArray();
                    localBabyQCookie = (babyq_cookie.BabyQCookie)localBabyQCookie.mergeFrom((byte[])localObject3);
                    if ((localBabyQCookie.uint32_need_not_report.has()) && (localBabyQCookie.uint32_need_not_report.get() == 0))
                    {
                      String str = bdeu.a((byte[])localObject3);
                      if (QLog.isColorLevel()) {
                        QLog.d("DecodeMsg", 2, "decodePBMsgElems_VideoFile, guideMsgCookie: " + str + ",bytes: " + Arrays.toString(paramList.babyq_guide_msg_cookie.get().toByteArray()));
                      }
                      ((MessageForShortVideo)localObject1).saveExtInfoToExtStr("guide_msg_cookie", str);
                    }
                    if (localBabyQCookie.uint32_video_type.has())
                    {
                      k = localBabyQCookie.uint32_video_type.get();
                      if (QLog.isColorLevel()) {
                        QLog.d("DecodeMsg", 2, "decodePBMsgElems_VideoFile, video_type: " + k);
                      }
                      ((MessageForShortVideo)localObject1).saveExtInfoToExtStr("guide_video_type", String.valueOf(k));
                    }
                    ((alok)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a((byte[])localObject3);
                  }
                  catch (Exception paramList)
                  {
                    for (;;)
                    {
                      boolean bool;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("DecodeMsg", 2, "get video guideMsgCookie error!", paramList);
                        continue;
                        bool = false;
                      }
                    }
                  }
                  ((MessageForShortVideo)localObject1).parse();
                  if (((MessageForShortVideo)localObject1).redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("DecodeMsg", 2, "VideoRedbag, decodePBMsgElems_VideoFile");
                    }
                    azjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
                    if (VideoRedbagData.queryRewardStat(((MessageForShortVideo)localObject1).shortVideoId))
                    {
                      ((MessageForShortVideo)localObject1).redBagStat = 1;
                      ((RichMsg.VideoFile)localObject2).red_envelope_pay_stat.set(1);
                    }
                  }
                  paramList1.add(localObject1);
                  if (j != 0)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("DecodeMsg", 2, "decodePBMsgElems, isBlessMsg: true ,updateFlag: " + i);
                    }
                    ((MessageForShortVideo)localObject1).isBlessMsg = true;
                    if (i > -1)
                    {
                      if ((i & 0x1) != 1) {
                        break label1346;
                      }
                      bool = true;
                      ((MessageForShortVideo)localObject1).needUpdateMsgTag = bool;
                    }
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  paramStringBuilder.append("ShortVideo.msg: ").append(((MessageForShortVideo)localObject1).toString() + "\n" + ((MessageForShortVideo)localObject1).toLogString()).append("\n");
                  return;
                  localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
                } while (!QLog.isColorLevel());
                QLog.d("DecodeMsg", 2, "ShortVideo doParse error!", localInvalidProtocolBufferMicroException);
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel())
                  {
                    QLog.d("DecodeMsg", 2, "ShortVideo doParse generalFlag error!", localException);
                    continue;
                    localException.msg = azdf.jdField_a_of_type_JavaLangString;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    do
    {
      paramList = (List<im_msg_body.Elem>)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)localIterator.next();
    } while (!paramList.group_file.has());
    paramList = (im_msg_body.GroupFile)paramList.group_file.get();
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:GroupFile;\n");
      }
      long l1 = 0L;
      paramStringBuilder = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (paramStringBuilder.discuss_info.has()) {
        l1 = ((msg_comm.DiscussInfo)paramStringBuilder.discuss_info.get()).discuss_uin.get();
      }
      long l4 = paramStringBuilder.from_uin.get();
      long l6 = paramStringBuilder.msg_time.get();
      long l7 = paramStringBuilder.msg_seq.get();
      long l5 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getLongAccountUin();
      if (alww.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, 3000, String.valueOf(l1), String.valueOf(l4), l6, l7)) {
        continue;
      }
      paramStringBuilder = "";
      try
      {
        localObject = new String(paramList.bytes_filename.get().toByteArray(), "UTF-8");
        paramStringBuilder = (StringBuilder)localObject;
        long l3 = 0L;
        l2 = l3;
        if (paramMsg.msg_body.has())
        {
          paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
          l2 = l3;
          if (paramMsg.rich_text.attr.has()) {
            l2 = azah.a(((im_msg_body.Attr)paramMsg.rich_text.attr.get()).random.get());
          }
        }
        paramMsg = (MessageForFile)azaf.a(-2005);
        paramMsg.msgtype = -2005;
        k = 0;
        m = 0;
        j = m;
        i = k;
        if (paramList.bytes_pb_reserve.has()) {
          localObject = new hummer_resv_21.ResvAttr();
        }
      }
      catch (UnsupportedEncodingException localInvalidProtocolBufferMicroException)
      {
        try
        {
          long l2;
          int k;
          int m;
          ((hummer_resv_21.ResvAttr)localObject).mergeFrom(paramList.bytes_pb_reserve.get().toByteArray());
          int j = m;
          int i = k;
          if (((hummer_resv_21.ResvAttr)localObject).file_image_info.has())
          {
            i = ((hummer_resv_21.ResvAttr)localObject).file_image_info.uint32_file_height.get();
            j = ((hummer_resv_21.ResvAttr)localObject).file_image_info.uint32_file_width.get();
            paramMsg.saveExtInfoToExtStr("file_pic_width", String.valueOf(j));
            paramMsg.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(i));
          }
          paramMsg.uniseq = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.a().a(paramMsg.uniseq, l1, l4, l7, l2, l6, paramList, j, i);
          l1 = paramList.uint64_file_size.get();
          if (l4 == l5)
          {
            bool = true;
            paramMsg.msg = bays.a(paramStringBuilder, l1, 0, bool);
            paramMsg.doParse();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          try
          {
            for (;;)
            {
              paramMsg.fileName = arrr.a(new String(paramList.bytes_filename.get().toByteArray(), "UTF-8"));
              paramList1.add(paramMsg);
              ((bajc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(272)).a(paramMsg);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DecodeMsg", 2, "GroupDiscFile.msg: " + paramList.bytes_filename.get() + ";");
              return;
              localUnsupportedEncodingException = localUnsupportedEncodingException;
              localUnsupportedEncodingException.printStackTrace();
              continue;
              localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
            boolean bool = false;
          }
          catch (UnsupportedEncodingException paramStringBuilder)
          {
            for (;;)
            {
              paramStringBuilder.printStackTrace();
              QLog.e("DecodeMsg", 1, "internalDiscOfflineFile: Exception is " + paramStringBuilder.toString());
            }
          }
        }
      }
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd)
  {
    paramStringBuilder = paramList.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramStringBuilder.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramStringBuilder.next();
    } while (!localElem.life_online.has());
    for (;;)
    {
      if (localElem == null) {
        return;
      }
      long l1;
      label111:
      long l2;
      label139:
      long l3;
      label166:
      long l4;
      label193:
      int j;
      int i3;
      int i4;
      Object localObject3;
      String str;
      label268:
      boolean bool;
      label303:
      int m;
      label342:
      int n;
      label381:
      int i1;
      label420:
      int i5;
      int i6;
      int i;
      label506:
      int k;
      label545:
      label584:
      label613:
      Object localObject1;
      label643:
      label673:
      Object localObject2;
      int i2;
      if ((localElem.life_online.has()) && (localElem.life_online.uint32_ack.has()) && (localElem.life_online.uint32_ack.get() == 1))
      {
        if (localElem.life_online.uint64_unique_id.has())
        {
          l1 = localElem.life_online.uint64_unique_id.get();
          if (!localElem.life_online.uint32_op.has()) {
            break label1315;
          }
          l2 = localElem.life_online.uint32_op.get();
          if (!paramMsg.msg_head.from_uin.has()) {
            break label1321;
          }
          l3 = paramMsg.msg_head.from_uin.get();
          if (!paramMsg.msg_head.to_uin.has()) {
            break label1327;
          }
          l4 = paramMsg.msg_head.to_uin.get();
          nrc.a().a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, l1, l2, l3, l4, 1, null);
        }
      }
      else
      {
        j = 0;
        i3 = 0;
        i4 = 0;
        parambbpd = "";
        localObject3 = "";
        str = "";
        if (!localElem.life_online.uint64_unique_id.has()) {
          break label1333;
        }
        l1 = localElem.life_online.uint64_unique_id.get();
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1345;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 1L) != 1L) {
          break label1339;
        }
        bool = true;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1357;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x4) != 4L) {
          break label1351;
        }
        m = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1369;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x40) != 64L) {
          break label1363;
        }
        n = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1381;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x800) != 2048L) {
          break label1375;
        }
        i1 = 1;
        i5 = (int)((localElem.life_online.uint64_bitmap.get() & 0x180) >> 7);
        i6 = (int)((localElem.life_online.uint64_bitmap.get() & 0x600) >> 9);
        if (m == 0) {
          break label1443;
        }
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1393;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x8) != 8L) {
          break label1387;
        }
        i = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1405;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x10) != 16L) {
          break label1399;
        }
        j = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1417;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x20) != 32L) {
          break label1411;
        }
        k = 1;
        if (!localElem.life_online.gdt_imp_data.has()) {
          break label1423;
        }
        paramStringBuilder = localElem.life_online.gdt_imp_data.get().toStringUtf8();
        if (!localElem.life_online.gdt_cli_data.has()) {
          break label1429;
        }
        parambbpd = localElem.life_online.gdt_cli_data.get().toStringUtf8();
        if (!localElem.life_online.view_id.has()) {
          break label1436;
        }
        localObject1 = localElem.life_online.view_id.get().toStringUtf8();
        localObject2 = paramStringBuilder;
        if (paramStringBuilder.length() > 100) {
          localObject2 = paramStringBuilder.substring(0, 100);
        }
        if (parambbpd.length() <= 100) {
          break label1714;
        }
        paramStringBuilder = parambbpd.substring(0, 100);
        i2 = j;
      }
      for (;;)
      {
        label717:
        if (localElem.life_online.uint64_bitmap.has()) {
          if ((localElem.life_online.uint64_bitmap.get() & 0x1000) == 4096L)
          {
            j = 1;
            label756:
            if (((j != 0) || ((paramMsg.msg_head.from_uin.has()) && (paramMsg.msg_head.from_uin.get() == 1579646438L))) && (!paramList1.isEmpty())) {
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("kandian_replace_subscribe_msg", "1");
            }
            if (i1 != 0)
            {
              if (!paramList1.isEmpty()) {
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("recent_list_advertisement_message", "1");
              }
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("isRecentAd, uint64_bitmap value is: ");
                if (!localElem.life_online.uint64_bitmap.has()) {
                  break label1576;
                }
                parambbpd = Long.valueOf(localElem.life_online.uint64_bitmap.get());
                QLog.d("DecodeMsg", 2, parambbpd);
              }
              ThreadManager.getSubThreadHandler().postDelayed(new MessagePBElemDecoder.1(this), 1000L);
            }
            if (!paramList1.isEmpty())
            {
              parambbpd = (MessageRecord)paramList1.get(0);
              parambbpd.extLong |= 0x1;
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_msgHasRead", "false");
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_msgId", String.valueOf(l1));
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_should_report", String.valueOf(bool));
              if (m != 0)
              {
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("isAdMsg", "1");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("ad_msgHasRead", "false");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_msgClick", paramStringBuilder);
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_msgImp", (String)localObject2);
                parambbpd = (MessageRecord)paramList1.get(0);
                if (i == 0) {
                  break label1584;
                }
                paramStringBuilder = "1";
                label1132:
                parambbpd.saveExtInfoToExtStr("gdt_singleAd", paramStringBuilder);
                parambbpd = (MessageRecord)paramList1.get(0);
                if (i2 == 0) {
                  break label1591;
                }
                paramStringBuilder = "1";
                parambbpd.saveExtInfoToExtStr("gdt_mulAd", paramStringBuilder);
                parambbpd = (MessageRecord)paramList1.get(0);
                if (k == 0) {
                  break label1598;
                }
                paramStringBuilder = "1";
                parambbpd.saveExtInfoToExtStr("gdt_followAd", paramStringBuilder);
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("is_AdArrive_Msg", "1");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_view_id", (String)localObject1);
              }
            }
            if ((n == 0) || (paramList1.isEmpty())) {
              break label1659;
            }
            paramList = paramList.iterator();
            i = 0;
            label1262:
            if (!paramList.hasNext()) {
              break label1605;
            }
            paramStringBuilder = (im_msg_body.Elem)paramList.next();
            if (!paramStringBuilder.pub_acc_info.uint32_is_inter_num.has()) {
              break label1711;
            }
            i = paramStringBuilder.pub_acc_info.uint32_is_inter_num.get();
          }
        }
        label905:
        label1162:
        label1192:
        label1321:
        label1327:
        label1711:
        for (;;)
        {
          break label1262;
          l1 = 0L;
          break label111;
          l2 = 0L;
          break label139;
          l3 = 0L;
          break label166;
          l4 = 0L;
          break label193;
          label1333:
          l1 = 0L;
          break label268;
          label1339:
          bool = false;
          break label303;
          label1345:
          bool = false;
          break label303;
          label1351:
          m = 0;
          break label342;
          label1357:
          m = 0;
          break label342;
          label1363:
          n = 0;
          break label381;
          label1369:
          n = 0;
          break label381;
          label1375:
          i1 = 0;
          break label420;
          label1381:
          i1 = 0;
          break label420;
          label1387:
          i = 0;
          break label506;
          label1393:
          i = 0;
          break label506;
          label1399:
          j = 0;
          break label545;
          label1405:
          j = 0;
          break label545;
          k = 0;
          break label584;
          k = 0;
          break label584;
          paramStringBuilder = "";
          break label613;
          parambbpd = "";
          break label643;
          localObject1 = "";
          break label673;
          i2 = i3;
          k = i4;
          localObject2 = localObject3;
          paramStringBuilder = parambbpd;
          localObject1 = str;
          i = j;
          if (!QLog.isColorLevel()) {
            break label717;
          }
          localObject1 = new StringBuilder().append("isAdArriveMsg is false, uint64_bitmap value is: ");
          if (localElem.life_online.uint64_bitmap.has()) {}
          for (paramStringBuilder = Long.valueOf(localElem.life_online.uint64_bitmap.get());; paramStringBuilder = "null")
          {
            QLog.d("DecodeMsg", 2, paramStringBuilder);
            i2 = i3;
            k = i4;
            localObject2 = localObject3;
            paramStringBuilder = parambbpd;
            localObject1 = str;
            i = j;
            break;
          }
          j = 0;
          break label756;
          j = 0;
          break label756;
          parambbpd = "null";
          break label905;
          label1584:
          paramStringBuilder = "0";
          break label1132;
          label1591:
          paramStringBuilder = "0";
          break label1162;
          label1598:
          paramStringBuilder = "0";
          break label1192;
          label1605:
          paramList = (MessageRecord)paramList1.get(0);
          paramList.saveExtInfoToExtStr("welcome_msg", "true");
          if ((i != 2) && (((paramList instanceof MessageForText)) || ((paramList instanceof MessageForLongMsg)))) {
            ThreadManager.executeOnSubThread(new MessagePBElemDecoder.2(this, paramMsg));
          }
          label1659:
          if (paramList1.isEmpty()) {
            break;
          }
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("public_account_msg_unread_flag", String.valueOf(i5));
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("public_account_msg_extra_info_type", String.valueOf(i6));
          return;
        }
        label1315:
        label1576:
        label1714:
        i2 = j;
        label1411:
        label1417:
        label1423:
        label1429:
        label1436:
        label1443:
        paramStringBuilder = parambbpd;
      }
      localElem = null;
    }
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd, boolean paramBoolean)
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
          a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localArrayList, paramList1, paramStringBuilder, paramMsg, parambbpd, paramBoolean);
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
              ((MessageRecord)paramList1.get(paramList1.size() - 1)).msgData = amrf.a(paramList);
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
      a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localArrayList, paramList1, paramStringBuilder, paramMsg, parambbpd, paramBoolean);
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
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    Object localObject = paramList.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)((Iterator)localObject).next();
    } while (!paramList.shake_window.has());
    for (;;)
    {
      if (paramList == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:ShakeWindow;\n");
      }
      paramList = (im_msg_body.ShakeWindow)paramList.shake_window.get();
      localObject = (MessageForShakeWindow)azaf.a(-2020);
      ((MessageForShakeWindow)localObject).msgtype = -2020;
      ((MessageForShakeWindow)localObject).msg = "[Shake Window]";
      ShakeWindowMsg localShakeWindowMsg = new ShakeWindowMsg();
      localShakeWindowMsg.mType = paramList.uint32_type.get();
      localShakeWindowMsg.mReserve = paramList.uint32_reserve.get();
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        localShakeWindowMsg.onlineFlag = i;
        localShakeWindowMsg.shake = true;
        ((MessageForShakeWindow)localObject).msgData = localShakeWindowMsg.getBytes();
        if (((MessageForShakeWindow)localObject).msgData != null) {
          break label189;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        paramStringBuilder.append("c2cMsgContent.data:null;\n");
        return;
      }
      label189:
      paramList1.add(localObject);
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
            paramList = (amqv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(199);
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
  
  public void a(im_msg_body.Elem paramElem, im_msg_body.CustomFace paramCustomFace, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean, bbpd parambbpd)
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
          localStringBuilder.append(BaseApplication.getContext().getString(2131695015));
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
          azri.a(BaseApplication.getContext()).a(paramCustomFace, "actMessageEvent", false, 0L, 0L, paramElem, "");
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElems_CustomFace isC2C");
          }
          return;
        }
        if ((localStringBuilder.length() > 0) && (!bool1) && (!bool2))
        {
          localObject1 = (MessageForText)azaf.a(-1000);
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
        localObject2 = bdhe.a((byte[])localObject2);
        bdhe.a((byte[])localObject1);
        bdhe.a((byte[])localObject3);
        int i3 = paramCustomFace.uint32_origin.get();
        localObject3 = baye.a(paramElem, 0L, 1, false, paramElem, (String)localObject2, "picplatform", str3, str4, str1, str2, i3, 0);
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
                paramElem = (MessageForPic)azaf.a(-5015);
                paramElem.msgtype = -5015;
                ((MessageForTroopEffectPic)paramElem).effectId = ((CustomFaceExtPb.AnimationImageShow)paramStringBuilder.msg_image_show.get()).int32_effect_id.get();
                paramElem.frienduin = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.group_code.get());
                paramElem.istroop = 1;
                paramCustomFace = (bcka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
                if (paramCustomFace != null) {
                  paramCustomFace.a((bcko)paramElem, false);
                }
                i = 1;
                if (i == 0)
                {
                  paramElem = (MessageForPic)azaf.a(-2000);
                  paramElem.msgtype = -2000;
                }
                if (bool1) {
                  alul.a(paramElem, false);
                }
                if (bool2) {
                  alse.a(paramElem, false);
                }
                if (parambbpd != null) {
                  paramElem.istroop = parambbpd.jdField_a_of_type_Int;
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
        if (localObject3 == null) {
          break;
        }
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
  
  public boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, String paramString)
  {
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    String str1 = null;
    paramList = null;
    im_msg_body.Elem localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.pub_group.has()) {
        break label264;
      }
      str1 = localElem.pub_group.bytes_nickname.get().toStringUtf8();
    }
    label264:
    for (;;)
    {
      Object localObject2 = localObject1;
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
        break;
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
          paramList.frienduin = paramString;
          paramList.isFromNearby = true;
          paramList1 = (bcka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
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
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DecodeMsg", 2, "lightvideo msg decode failed");
      }
      return;
    }
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<im_msg_body.Elem>)localObject;
    label43:
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (im_msg_body.Elem)localIterator.next();
    } while ((!((im_msg_body.Elem)localObject).common_elem.has()) || (((im_msg_body.Elem)localObject).common_elem.uint32_service_type.get() != 27) || (!((im_msg_body.Elem)localObject).common_elem.bytes_pb_elem.has()));
    label639:
    for (;;)
    {
      try
      {
        hummer_commelem.MsgElemInfo_servtype27 localMsgElemInfo_servtype27 = new hummer_commelem.MsgElemInfo_servtype27();
        localMsgElemInfo_servtype27.mergeFrom(((im_msg_body.Elem)localObject).common_elem.bytes_pb_elem.get().toByteArray());
        if ((localMsgElemInfo_servtype27 == null) || (!localMsgElemInfo_servtype27.video_file.has())) {
          break label639;
        }
        localObject = (im_msg_body.VideoFile)localMsgElemInfo_servtype27.video_file.get();
        paramList = (List<im_msg_body.Elem>)localObject;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      break label43;
      if (paramList == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("DecodeMsg", 2, "lightvideo msg decode failed, videoFile is null");
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:light_video;\n");
      }
      RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
      localVideoFile.setHasFlag(true);
      localVideoFile.bytes_file_name.set(paramList.bytes_file_name.get());
      localVideoFile.bytes_file_md5.set(paramList.bytes_file_md5.get());
      localVideoFile.bytes_file_uuid.set(paramList.bytes_file_uuid.get());
      localVideoFile.uint32_file_format.set(paramList.uint32_file_format.get());
      localVideoFile.uint32_file_size.set(paramList.uint32_file_size.get());
      localVideoFile.uint32_file_time.set(paramList.uint32_file_time.get());
      localVideoFile.uint32_thumb_width.set(paramList.uint32_thumb_width.get());
      localVideoFile.uint32_thumb_height.set(paramList.uint32_thumb_height.get());
      localVideoFile.uint32_file_status.set(2008);
      localVideoFile.uint32_file_progress.set(0);
      localVideoFile.bytes_thumb_file_md5.set(paramList.bytes_thumb_file_md5.get());
      localVideoFile.bytes_source.set(paramList.bytes_source.get());
      localVideoFile.uint32_thumb_file_size.set(paramList.uint32_thumb_file_size.get());
      localVideoFile.uint32_busi_type.set(paramList.uint32_busi_type.get());
      localVideoFile.uin32_from_chat_type.set(paramList.uint32_from_chat_type.get());
      localVideoFile.uin32_to_chat_type.set(paramList.uint32_to_chat_type.get());
      localVideoFile.bool_support_progressive.set(paramList.bool_support_progressive.get());
      localVideoFile.uint32_file_width.set(paramList.uint32_file_width.get());
      localVideoFile.uint32_file_height.set(paramList.uint32_file_height.get());
      localVideoFile.uint32_sub_busi_type.set(paramList.uint32_sub_busi_type.get());
      localVideoFile.uint32_video_attr.set(paramList.uint32_video_attr.get());
      paramList = (MessageForLightVideo)azaf.a(-2071);
      paramList.msgtype = -2071;
      paramList.msgData = localVideoFile.toByteArray();
      paramList.msg = BaseApplication.getContext().getString(2131691348);
      paramList.parse();
      paramList1.add(paramList);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramStringBuilder.append("LightVideo.msg: ").append(paramList.toString() + "\n" + paramList.toLogString()).append("\n");
      return;
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
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
        break label1529;
      }
      localObject1 = (im_msg_body.GeneralFlags)localElem.general_flags.get();
    }
    label444:
    label449:
    label627:
    label1529:
    for (;;)
    {
      break;
      if (localObject2 == null) {}
      int i;
      int j;
      StringBuilder localStringBuilder;
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
              paramList = BaseApplication.getContext().getString(2131695015);
              paramStringBuilder = (MessageForText)azaf.a(-1000);
              paramStringBuilder.msgtype = -1000;
              paramStringBuilder.msg = paramList;
              paramList1.add(paramStringBuilder);
              return;
            }
          } while (localObject3[0] != 1);
          i = bdqa.a((byte[])localObject3, 1);
          j = localObject3[3];
          localObject2 = new byte[i - 1];
          bdqa.a((byte[])localObject2, 0, (byte[])localObject3, 4, i - 1);
          paramStringBuilder = (StringBuilder)localObject2;
          if (j == 1) {
            paramStringBuilder = a((byte[])localObject2);
          }
          if (paramStringBuilder == null) {
            break label1521;
          }
          try
          {
            if (paramStringBuilder.length <= 0) {
              break label1521;
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
            break label1310;
          }
          if (!paramMsg.msg_head.from_uin.has()) {
            break;
          }
          l = paramMsg.msg_head.from_uin.get();
        } while (afwq.a(l + ""));
      } while (paramStringBuilder == null);
      paramMsg = (MessageForPubAccount)azaf.a(-3006);
      paramMsg.msgtype = -3006;
      paramMsg.msg = paramList.toString();
      paramMsg.mPAMessage = paramStringBuilder;
      for (;;)
      {
        for (;;)
        {
          try
          {
            paramMsg.msgData = swh.a(paramStringBuilder);
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
            int i1 = bdqa.a(localStringBuilder, i + 1);
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
              bdqa.a(paramList, 0, localStringBuilder, i + 3, i1);
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
          break;
          paramStringBuilder = new TroopFileData();
          paramStringBuilder.fileUrl = new String(((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_file_path.get().toByteArray());
          paramStringBuilder.bisID = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.uint32_bus_id.get();
          paramStringBuilder.fileName = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.str_file_name.get();
          paramStringBuilder.lfileSize = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.uint64_file_size.get();
          paramStringBuilder.lastTime = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.int64_dead_time.get();
          paramStringBuilder.sha1 = new String(((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_file_sha1.get().toByteArray());
          paramStringBuilder.uuid = UUID.nameUUIDFromBytes(paramStringBuilder.fileUrl.getBytes()).toString();
          if (((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_ext.has()) {
            localObject1 = ((obj_msg.MsgContentInfo)paramList.msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
          }
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            paramStringBuilder.width = ((JSONObject)localObject1).optInt("width");
            paramStringBuilder.height = ((JSONObject)localObject1).optInt("height");
            paramStringBuilder.duration = ((JSONObject)localObject1).optInt("duration");
            paramStringBuilder.dspFileName = new String(paramList.bytes_title.get().toByteArray());
            paramStringBuilder.dspFileName = arrr.a(paramStringBuilder.dspFileName);
            paramStringBuilder.dspFileSize = new String(((ByteStringMicro)paramList.rpt_bytes_abstact.get(0)).toByteArray());
            bcmo.a(paramMsg.msg_head.group_info.group_code.get()).a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramStringBuilder.fileUrl, paramStringBuilder);
            localObject1 = new StringBuilder("decodePBMshElems==>").append(paramStringBuilder.toString());
            paramList = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, paramMsg.msg_head.group_info.group_code.get()).a(paramStringBuilder.fileUrl);
            if (paramList != null)
            {
              paramList = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.a().a(paramList.e);
              if (paramList != null) {
                paramList.lastTime = paramStringBuilder.lastTime;
              }
              localObject2 = (MessageForTroopFile)azaf.a(-2017);
              ((MessageForTroopFile)localObject2).msgtype = -2017;
              ((MessageForTroopFile)localObject2).msg = alud.a(2131707044);
            }
          }
          catch (Exception localException1)
          {
            try
            {
              ((MessageForTroopFile)localObject2).msgData = amrf.a(paramStringBuilder);
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
              localException1 = localException1;
              localException1.printStackTrace();
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
        paramList = "";
        paramStringBuilder = null;
      }
    }
  }
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd)
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
            g(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
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
        localObject2 = azwm.a((byte[])localObject2, -1);
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
            localObject3 = (MessageForArkFlashChat)azaf.a(-5013);
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
          g(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
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
            if (assg.a(j))
            {
              paramStringBuilder = new HiBoomMessage();
              paramStringBuilder.id = i;
              paramStringBuilder.text = ((String)localObject3);
              paramStringBuilder.type = j;
              paramList = (MessageForHiBoom)azaf.a(-5014);
              paramList.mHiBoomMessage = paramStringBuilder;
              paramList.msgtype = -5014;
              paramList.msg = ((String)localObject3);
              try
              {
                paramList.msgData = amrf.a(paramStringBuilder);
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
  
  public void b(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    int i = 0;
    if (i < paramList.size()) {
      if (!((im_msg_body.Elem)paramList.get(i)).apollo_msg.has()) {}
    }
    for (im_msg_body.ApolloActMsg localApolloActMsg = (im_msg_body.ApolloActMsg)((im_msg_body.Elem)paramList.get(i)).apollo_msg.get();; localApolloActMsg = null)
    {
      if (localApolloActMsg == null) {}
      do
      {
        return;
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("elemType:Apollo...\n");
        }
      } while (localApolloActMsg == null);
      for (;;)
      {
        int i5;
        float f2;
        int i3;
        int i4;
        int i7;
        long l1;
        int i6;
        ApolloMsgExtend.ThreeDBaseInfo localThreeDBaseInfo;
        List localList;
        Apollo3DMessage localApollo3DMessage;
        ApolloMsgExtend.AuthReserve localAuthReserve;
        long l4;
        try
        {
          ApolloMessage localApolloMessage = new ApolloMessage();
          localApolloMessage.id = localApolloActMsg.uint32_action_id.get();
          localApolloMessage.name = localApolloActMsg.bytes_action_name.get().toByteArray();
          if ((!paramBoolean) && (localApolloActMsg.bytes_action_text.has())) {
            localApolloMessage.text = localApolloActMsg.bytes_action_text.get().toByteArray();
          }
          i5 = -1;
          f2 = 0.0F;
          long l5 = 0L;
          i3 = -1;
          i4 = 0;
          i = 0;
          i7 = 0;
          l1 = 0L;
          ArrayList localArrayList = new ArrayList();
          Object localObject5 = null;
          paramStringBuilder = null;
          j = 0;
          i6 = 0;
          localObject1 = null;
          localThreeDBaseInfo = null;
          Iterator localIterator = null;
          localList = null;
          localApollo3DMessage = new Apollo3DMessage();
          localAuthReserve = new ApolloMsgExtend.AuthReserve();
          localObject4 = localIterator;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = localObject5;
          n = i7;
          l2 = l1;
          m = i4;
          k = i3;
          l3 = l5;
          f1 = f2;
          i2 = i5;
          try
          {
            localAuthReserve.mergeFrom(localApolloActMsg.bytes_pb_reserve.get().toByteArray());
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            i5 = localAuthReserve.diy_voice_id.get();
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            f2 = (float)localAuthReserve.diy_voice_begin_ts.get();
            f1 = 1000.0F;
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            i2 = i5;
            f2 /= 1000.0F;
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            i3 = localAuthReserve.sub_type.get();
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            i4 = localAuthReserve.game_id.get();
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l1;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            l4 = localAuthReserve.room_id.get();
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            localAuthReserve.img_type.get();
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.game_text.has())
            {
              localObject4 = localIterator;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = localObject5;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l5;
              f1 = f2;
              i2 = i5;
              if (localAuthReserve.game_text.get() != null)
              {
                localObject4 = localIterator;
                localObject3 = localThreeDBaseInfo;
                i1 = i6;
                localObject2 = localObject5;
                n = i7;
                l2 = l4;
                m = i4;
                k = i3;
                l3 = l5;
                f1 = f2;
                i2 = i5;
                new String(localAuthReserve.game_text.get().toByteArray());
              }
            }
            paramList = paramStringBuilder;
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = localObject5;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.game_name.has())
            {
              paramList = paramStringBuilder;
              localObject4 = localIterator;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = localObject5;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l5;
              f1 = f2;
              i2 = i5;
              if (localAuthReserve.game_name.get() != null)
              {
                localObject4 = localIterator;
                localObject3 = localThreeDBaseInfo;
                i1 = i6;
                localObject2 = localObject5;
                n = i7;
                l2 = l4;
                m = i4;
                k = i3;
                l3 = l5;
                f1 = f2;
                i2 = i5;
                paramList = new String(localAuthReserve.game_name.get().toByteArray());
              }
            }
            paramStringBuilder = localList;
            localObject4 = localIterator;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.game_share_ark_json.has())
            {
              paramStringBuilder = localList;
              localObject4 = localIterator;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = paramList;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l5;
              f1 = f2;
              i2 = i5;
              if (localAuthReserve.game_share_ark_json.get() != null)
              {
                localObject4 = localIterator;
                localObject3 = localThreeDBaseInfo;
                i1 = i6;
                localObject2 = paramList;
                n = i7;
                l2 = l4;
                m = i4;
                k = i3;
                l3 = l5;
                f1 = f2;
                i2 = i5;
                paramStringBuilder = new String(localAuthReserve.game_share_ark_json.get().toByteArray());
              }
            }
            l1 = l5;
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l5;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.sign_ts.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = paramList;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l5;
              f1 = f2;
              i2 = i5;
              l1 = localAuthReserve.sign_ts.get();
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.action_ver.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = paramList;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l1;
              f1 = f2;
              i2 = i5;
              l5 = localAuthReserve.action_ver.get();
              if (l5 != 0L)
              {
                localObject4 = paramStringBuilder;
                localObject3 = localThreeDBaseInfo;
                i1 = i6;
                localObject2 = paramList;
                n = i7;
                l2 = l4;
                m = i4;
                k = i3;
                l3 = l1;
                f1 = f2;
                i2 = i5;
                if (l5 > ApolloUtil.a(1))
                {
                  localObject4 = paramStringBuilder;
                  localObject3 = localThreeDBaseInfo;
                  i1 = i6;
                  localObject2 = paramList;
                  n = i7;
                  l2 = l4;
                  m = i4;
                  k = i3;
                  l3 = l1;
                  f1 = f2;
                  i2 = i5;
                  amqn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
                }
              }
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (localAuthReserve.slave_action_id.has())
            {
              localObject4 = paramStringBuilder;
              localObject3 = localThreeDBaseInfo;
              i1 = i6;
              localObject2 = paramList;
              n = i7;
              l2 = l4;
              m = i4;
              k = i3;
              l3 = l1;
              f1 = f2;
              i2 = i5;
              localAuthReserve.slave_action_id.get();
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (!localAuthReserve.slave_uin_list.has()) {
              break label2527;
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localList = localAuthReserve.slave_uin_list.get();
            if (localList == null) {
              break label2527;
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localIterator = localList.iterator();
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            if (!localIterator.hasNext()) {
              break label2405;
            }
            localObject4 = paramStringBuilder;
            localObject3 = localThreeDBaseInfo;
            i1 = i6;
            localObject2 = paramList;
            n = i7;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localArrayList.add(Long.valueOf(bdeu.a(((Integer)localIterator.next()).intValue())));
            continue;
            localObject3 = new JSONObject();
          }
          catch (InvalidProtocolBufferMicroException paramList)
          {
            paramList.printStackTrace();
            paramList = (List<im_msg_body.Elem>)localObject4;
            paramStringBuilder = (StringBuilder)localObject3;
            localObject1 = localObject2;
            i = m;
            j = k;
            l1 = l3;
          }
          if (!localApolloActMsg.input_text.has()) {
            break label3553;
          }
          localObject2 = new String(localApolloActMsg.input_text.get().toByteArray());
          ((JSONObject)localObject3).put("inputText", localObject2);
          if (i2 > 0)
          {
            ((JSONObject)localObject3).put("audioID", i2);
            ((JSONObject)localObject3).put("audioStartTime", f1);
          }
          if (ApolloGameUtil.a(j))
          {
            ((JSONObject)localObject3).put("gameId", i);
            ((JSONObject)localObject3).put("gameMode", n);
            ((JSONObject)localObject3).put("roomid", l2);
            ((JSONObject)localObject3).put("msgTyep", j);
            ((JSONObject)localObject3).put("gameName", localObject1);
            ((JSONObject)localObject3).put("gameExtendJson", paramList);
          }
          if (!TextUtils.isEmpty(paramStringBuilder)) {
            ((JSONObject)localObject3).put("extendJson", paramStringBuilder);
          }
          ((JSONObject)localObject3).put("actionType", i1);
          localObject4 = localApollo3DMessage.getMessageJSONObject();
          if (localObject4 != null) {
            ((JSONObject)localObject3).put("mApollo3DMessage", localObject4);
          }
          localApolloMessage.extStr = ((JSONObject)localObject3).toString();
          localApolloMessage.flag = localApolloActMsg.uint32_flag.get();
          localApolloMessage.peer_uin = bdeu.a(localApolloActMsg.uint32_peer_uin.get());
          localApolloMessage.sender_ts = bdeu.a(localApolloActMsg.uint32_sender_ts.get());
          localApolloMessage.peer_ts = bdeu.a(localApolloActMsg.uint32_peer_ts.get());
          localApolloMessage.sender_status = localApolloActMsg.int32_sender_status.get();
          localApolloMessage.peer_status = localApolloActMsg.int32_peer_status.get();
          localObject3 = (MessageForApollo)azaf.a(-2039);
          ((MessageForApollo)localObject3).msgtype = -2039;
          ((MessageForApollo)localObject3).mApolloMessage = localApolloMessage;
          ((MessageForApollo)localObject3).msgData = amrf.a(localApolloMessage);
          ((MessageForApollo)localObject3).inputText = ((String)localObject2);
          ((MessageForApollo)localObject3).audioId = i2;
          ((MessageForApollo)localObject3).audioStartTime = f1;
          ((MessageForApollo)localObject3).msgType = j;
          ((MessageForApollo)localObject3).gameId = i;
          ((MessageForApollo)localObject3).mGameMode = n;
          ((MessageForApollo)localObject3).roomId = l2;
          ((MessageForApollo)localObject3).signTs = l1;
          ((MessageForApollo)localObject3).gameName = ((String)localObject1);
          ((MessageForApollo)localObject3).actionType = i1;
          ((MessageForApollo)localObject3).extendJson = paramStringBuilder;
          ((MessageForApollo)localObject3).gameExtendJson = paramList;
          ((MessageForApollo)localObject3).gameStatus = ApolloUtil.a(((MessageForApollo)localObject3).extendJson, "gameStatus");
          ((MessageForApollo)localObject3).mApollo3DMessage = localApollo3DMessage;
          paramList1.add(localObject3);
          return;
        }
        catch (Throwable paramList) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("DecodeMsg", 2, "decode apollo msg failed", paramList);
        return;
        label2405:
        Object localObject4 = paramStringBuilder;
        Object localObject3 = localThreeDBaseInfo;
        int i1 = i6;
        Object localObject2 = paramList;
        int n = i7;
        long l2 = l4;
        int m = i4;
        int k = i3;
        long l3 = l1;
        float f1 = f2;
        int i2 = i5;
        if (QLog.isColorLevel())
        {
          localObject4 = paramStringBuilder;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i7;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          QLog.d("DecodeMsg", 2, "slave size:" + localList.size());
        }
        label2527:
        localObject4 = paramStringBuilder;
        localObject3 = localThreeDBaseInfo;
        i1 = i6;
        localObject2 = paramList;
        n = i7;
        l2 = l4;
        m = i4;
        k = i3;
        l3 = l1;
        f1 = f2;
        i2 = i5;
        if (localAuthReserve.game_mode.has())
        {
          localObject4 = paramStringBuilder;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i7;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          i = localAuthReserve.game_mode.get();
        }
        localObject4 = paramStringBuilder;
        localObject3 = localThreeDBaseInfo;
        i1 = i6;
        localObject2 = paramList;
        n = i;
        l2 = l4;
        m = i4;
        k = i3;
        l3 = l1;
        f1 = f2;
        i2 = i5;
        if (localAuthReserve.extend_json.has())
        {
          localObject4 = paramStringBuilder;
          localObject3 = localThreeDBaseInfo;
          i1 = i6;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          localObject1 = new String(localAuthReserve.extend_json.get().toByteArray());
        }
        localObject4 = paramStringBuilder;
        localObject3 = localObject1;
        i1 = i6;
        localObject2 = paramList;
        n = i;
        l2 = l4;
        m = i4;
        k = i3;
        l3 = l1;
        f1 = f2;
        i2 = i5;
        if (localAuthReserve.action_type.has())
        {
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = i6;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          j = localAuthReserve.action_type.get();
        }
        localObject4 = paramStringBuilder;
        localObject3 = localObject1;
        i1 = j;
        localObject2 = paramList;
        n = i;
        l2 = l4;
        m = i4;
        k = i3;
        l3 = l1;
        f1 = f2;
        i2 = i5;
        if (localAuthReserve.act3d.has())
        {
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          localThreeDBaseInfo = (ApolloMsgExtend.ThreeDBaseInfo)localAuthReserve.act3d.get();
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localThreeDBaseInfo.uint32_action_id.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localApollo3DMessage.actionID_3D = localThreeDBaseInfo.uint32_action_id.get();
          }
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localThreeDBaseInfo.action_type.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localApollo3DMessage.actionType_3D = localThreeDBaseInfo.action_type.get();
          }
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localThreeDBaseInfo.bytes_action_name.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localApollo3DMessage.actionName_3D = new String(localThreeDBaseInfo.bytes_action_name.get().toByteArray());
          }
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localThreeDBaseInfo.int32_sender_status.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localApollo3DMessage.senderStatus_3D = localThreeDBaseInfo.int32_sender_status.get();
          }
          localObject4 = paramStringBuilder;
          localObject3 = localObject1;
          i1 = j;
          localObject2 = paramList;
          n = i;
          l2 = l4;
          m = i4;
          k = i3;
          l3 = l1;
          f1 = f2;
          i2 = i5;
          if (localThreeDBaseInfo.int32_peer_status.has())
          {
            localObject4 = paramStringBuilder;
            localObject3 = localObject1;
            i1 = j;
            localObject2 = paramList;
            n = i;
            l2 = l4;
            m = i4;
            k = i3;
            l3 = l1;
            f1 = f2;
            i2 = i5;
            localApollo3DMessage.peerStatus_3D = localThreeDBaseInfo.int32_peer_status.get();
          }
        }
        localObject2 = paramList;
        f1 = f2;
        paramList = paramStringBuilder;
        paramStringBuilder = (StringBuilder)localObject1;
        i1 = j;
        Object localObject1 = localObject2;
        l2 = l4;
        n = i;
        i = i4;
        int j = i3;
        i2 = i5;
        continue;
        label3553:
        localObject2 = null;
      }
    }
  }
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
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
      localObject1 = azvd.a(((im_msg_body.MarketTrans)localObject1).bytes_xml.get().toByteArray(), i);
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
      paramList = (MessageForStructing)azaf.a(-2011);
      paramList.msgtype = -2011;
      paramList.msg = "MarketTrans";
      paramList.structingMsg = ((AbsStructMsg)localObject1);
      paramList.msgData = paramList.structingMsg.getBytes();
      paramList1.add(paramList);
      return;
    }
  }
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramMsg = (im_msg_body.Elem)paramList.next();
    } while (!paramMsg.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)paramMsg.common_elem.get();; paramList = null)
    {
      if (paramList == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("decodePBMsgElems_ScribbleMsg;\n");
      }
      paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype11();
      try
      {
        paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
        paramList = (MessageForScribble)azaf.a(-7001);
        paramList.msgtype = -7001;
        if (paramStringBuilder.bytes_Doodle_md5.has()) {
          paramList.combineFileMd5 = new String(paramStringBuilder.bytes_Doodle_md5.get().toByteArray());
        }
        if (paramStringBuilder.bytes_Doodle_url.has()) {
          paramList.combineFileUrl = new String(paramStringBuilder.bytes_Doodle_url.get().toByteArray());
        }
        if (paramStringBuilder.uint32_doodleData_offset.has()) {
          paramList.offSet = paramStringBuilder.uint32_doodleData_offset.get();
        }
        if (paramStringBuilder.uint32_doodle_gif_id.has()) {
          paramList.gifId = paramStringBuilder.uint32_doodle_gif_id.get();
        }
        if (QLog.isColorLevel()) {
          QLog.i("DecodeMsgscribble msg", 1, " decodePBMsgElems_ScribbleMsg " + paramList.combineFileMd5 + " " + paramList.combineFileUrl);
        }
        paramList.prewrite();
        paramList1.add(paramList);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramList)
      {
        paramList.printStackTrace();
        QLog.e("DecodeMsgscribble msg", 1, paramList, new Object[0]);
        return;
      }
    }
  }
  
  public void c(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd)
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
      localObject2 = azwm.a((byte[])localObject2, -1);
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
          localObject3 = (MessageForArkBabyqReply)azaf.a(-5016);
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
        g(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
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
  
  public void d(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
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
      localMessageForIncompatibleGrayTips = (MessageForIncompatibleGrayTips)azaf.a(-5002);
      if (localMessageForIncompatibleGrayTips.parseTextXML(paramList.text.get()).booleanValue())
      {
        paramList1.add(localMessageForIncompatibleGrayTips);
        return;
      }
    } while (!QLog.isColorLevel());
    paramStringBuilder.append("TipsInfo parse failed;\n");
  }
  
  public void d(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject5 = paramList.iterator();
    Object localObject4 = null;
    im_msg_body.Elem localElem;
    if (((Iterator)localObject5).hasNext())
    {
      localElem = (im_msg_body.Elem)((Iterator)localObject5).next();
      if (!localElem.ark_app.has()) {
        break label730;
      }
      localObject2 = (im_msg_body.ArkAppElem)localElem.ark_app.get();
    }
    label730:
    for (;;)
    {
      if (localElem.light_app.has()) {
        localObject4 = (im_msg_body.LightAppElem)localElem.light_app.get();
      }
      for (;;)
      {
        if (localElem.general_flags.has()) {
          localObject1 = (im_msg_body.GeneralFlags)localElem.general_flags.get();
        }
        for (;;)
        {
          break;
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:ArkApp/LightApp;\n");
          }
          if (!ArkUtil.isDeviceSupportArkMsg())
          {
            QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isDeviceSupportArkMsg is false, ignore msg.");
            if (a(paramList).booleanValue()) {
              g(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
            }
          }
          do
          {
            return;
            paramList = (MessageForText)azaf.a(-1000);
            paramList.msgtype = -1000;
            paramList.msg = BaseApplication.getContext().getString(2131693914);
            paramList1.add(paramList);
            return;
            if (ArkAppCenter.b())
            {
              QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isPANonShow is true, ignore msg.");
              return;
            }
            localObject5 = null;
            if (localObject2 != null)
            {
              if (!((im_msg_body.ArkAppElem)localObject2).bytes_data.has())
              {
                QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data not exist.");
                return;
              }
              localObject2 = ((im_msg_body.ArkAppElem)localObject2).bytes_data.get().toByteArray();
            }
            while ((localObject2 == null) || (localObject2.length <= 0))
            {
              QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data is empty.");
              return;
              localObject2 = localObject5;
              if (localObject4 != null)
              {
                if (!((im_msg_body.LightAppElem)localObject4).bytes_data.has())
                {
                  QLog.i("ArkApp", 1, "decode msg, light_app.bytes_data not exist.");
                  return;
                }
                localObject2 = ((im_msg_body.LightAppElem)localObject4).bytes_data.get().toByteArray();
              }
            }
            localObject4 = null;
            localObject2 = azwm.a((byte[])localObject2, -1);
            if ((localObject2 != null) && (localObject2.length > 0)) {}
            Object localObject3;
            for (;;)
            {
              try
              {
                localObject2 = new String((byte[])localObject2, "UTF-8");
                if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                  break;
                }
                QLog.i("ArkApp", 1, "decode msg, ark data is empty.");
                return;
              }
              catch (Exception localException)
              {
                QLog.i("ArkApp", 1, "decode msg, raw data cannot convert to string.");
                localObject3 = localObject4;
                continue;
              }
              QLog.i("ArkApp", 1, "decode msg, raw data is empty.");
              localObject3 = localObject4;
            }
            localObject5 = a(paramList, paramList1, false);
            localObject4 = (MessageForArkApp)azaf.a(-5008);
            ((MessageForArkApp)localObject4).msgtype = -5008;
            if (localObject5 != null) {
              ((MessageForArkApp)localObject4).compatibleMsg = ((String)localObject5);
            }
            if ((localObject1 != null) && (((im_msg_body.GeneralFlags)localObject1).bytes_pb_reserve.has())) {}
            try
            {
              localObject5 = new generalflags.ResvAttr();
              ((generalflags.ResvAttr)localObject5).mergeFrom(((im_msg_body.GeneralFlags)localObject1).bytes_pb_reserve.get().toByteArray());
              if (((generalflags.ResvAttr)localObject5).bytes_oac_msg_extend.has()) {
                ((MessageForArkApp)localObject4).saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", ((generalflags.ResvAttr)localObject5).bytes_oac_msg_extend.get().toStringUtf8());
              }
              if (((generalflags.ResvAttr)localObject5).uint32_service_msg_type.has())
              {
                localObject1 = new JSONObject(localObject3).optString("appid");
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  ((MessageForArkApp)localObject4).saveExtInfoToExtStr("appid", (String)localObject1);
                }
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                QLog.e("DecodeMsg", 2, "decodePBMsgElems_ArkApp() parse generalflags error! " + QLog.getStackTraceString(localThrowable));
              }
              QLog.i("ArkApp", 1, "decode msg, ark message is not valid..");
              int i = 0;
              continue;
            }
            localObject1 = new ArkAppMessage();
            ((ArkAppMessage)localObject1).fromAppXml(localObject3);
            ((MessageForArkApp)localObject4).msgData = ((ArkAppMessage)localObject1).toBytes();
            ((MessageForArkApp)localObject4).parse();
            if ((TextUtils.isEmpty(((MessageForArkApp)localObject4).ark_app_message.appName)) || (TextUtils.isEmpty(((MessageForArkApp)localObject4).ark_app_message.appView))) {
              break;
            }
            paramList1.add(localObject4);
            i = 1;
          } while (i != 0);
          g(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
          return;
        }
      }
    }
  }
  
  public void e(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
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
        paramList = (MessageForQQStoryComment)azaf.a(-2052);
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
  
  public void e(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd)
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
        localObject3 = azwm.a((byte[])localObject3, -1);
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
            localObject3 = (MessageForArkApp)azaf.a(-5017);
            ((MessageForArkApp)localObject3).msgtype = -5017;
            if (((im_msg_body.CommonElem)localObject1).uint32_business_type.get() == 1) {
              ((MessageForArkApp)localObject3).saveExtInfoToExtStr(ayzs.e, "1");
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
          g(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
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
  
  public void f(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
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
          paramList = (MessageForQQStoryComment)azaf.a(-2052);
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
  
  public void f(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd)
  {
    Object localObject1 = paramList.iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
    } while (!((im_msg_body.Elem)localObject2).qqwallet_msg.has());
    for (localObject1 = (im_msg_body.QQWalletMsg)((im_msg_body.Elem)localObject2).qqwallet_msg.get();; localObject1 = null)
    {
      if (localObject1 == null) {}
      int k;
      int n;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:QQWalletMsg;\n");
          }
        } while (!((im_msg_body.QQWalletMsg)localObject1).aio_body.has());
        k = 0;
        n = ((im_msg_body.QQWalletMsg)localObject1).aio_body.sint32_msgtype.get();
        if (QLog.isColorLevel()) {
          QLog.i("DecodeMsg", 2, "--msgType: " + n);
        }
      } while (n > 3000);
      int j;
      label154:
      MessageForQQWalletMsg localMessageForQQWalletMsg;
      boolean bool;
      label273:
      Object localObject3;
      if (n > 2000)
      {
        j = k;
        if (j != 0) {
          break label1690;
        }
        localMessageForQQWalletMsg = (MessageForQQWalletMsg)azaf.a(-2025);
        localMessageForQQWalletMsg.msgtype = -2025;
        localMessageForQQWalletMsg.messageType = n;
        if (!((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject1).aio_body.get()).sint32_redtype.has()) {
          break label1207;
        }
        localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg(((im_msg_body.QQWalletMsg)localObject1).aio_body, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin());
        if ((localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null) && ((n == 4) || (n == 5)))
        {
          if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.msgFrom != 1) {
            break label1017;
          }
          bool = true;
          localMessageForQQWalletMsg.isBlessMsg = bool;
          if (QLog.isColorLevel()) {
            QLog.d("BlessManagerHB", 2, "decode msgFrom=" + localMessageForQQWalletMsg.mQQWalletRedPacketMsg.msgFrom);
          }
        }
        if ((n == 7) || (n == 8))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_grap_uin.get().iterator();
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            } while (!((String)localObject2).equals(String.valueOf((Long)((Iterator)localObject3).next())));
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        for (;;)
        {
          if ((i != 0) && (parambbpd != null) && (parambbpd.c != null))
          {
            parambbpd.c.a(paramMsg.msg_head.msg_seq.get(), localMessageForQQWalletMsg.msgseq);
            localMessageForQQWalletMsg.mMessageInfo = parambbpd;
          }
          label563:
          label583:
          Object localObject4;
          if ((n == 6) || (n == 13) || (n == 15) || (n == 18) || (n == 19) || (n == 21) || (n == 22) || (n == 23) || (n == 24))
          {
            i = paramMsg.msg_head.msg_type.get();
            if ((i != 82) && (i != 43)) {
              break label1023;
            }
            j = 1;
            l = paramMsg.msg_head.group_info.group_code.get();
            i = 0;
            if ((n != 13) && (n != 15)) {
              break label1124;
            }
            i = 1;
            String str = "";
            localObject3 = str;
            if (i == 4)
            {
              localObject3 = "";
              localObject2 = localObject3;
              if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
              {
                localObject2 = localObject3;
                if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
                  localObject2 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title;
                }
              }
              localObject3 = "";
              localObject4 = localObject3;
              if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
              {
                localObject4 = localObject3;
                if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
                  localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.lastPinyin;
                }
              }
              localObject3 = str;
              if (!bdnn.a((String)localObject2))
              {
                localObject3 = str;
                if (!bdnn.a((String)localObject4)) {
                  localObject3 = (String)localObject2 + "_" + (String)localObject4;
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("DecodeMsg", 2, "--subChannel: " + localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.subChannel);
            }
            localObject2 = (aiul)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getManager(125);
            if (localObject2 != null) {
              localObject4 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject4).put("key_sub_channel", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.subChannel);
            ((aiul)localObject2).a((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject1).aio_body.get(), j, l, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_time.get(), i, (String)localObject3, ((JSONObject)localObject4).toString());
            label882:
            localMessageForQQWalletMsg.msg = localMessageForQQWalletMsg.getMsgSummary();
            localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
            localMessageForQQWalletMsg.onDecodeFinish(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsg);
            if ((localMessageForQQWalletMsg != null) && (!localMessageForQQWalletMsg.isMsgEmpty())) {
              break label1556;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            paramStringBuilder.append("c2cMsgContent.QQWalletTransferMsg:null or mqt:isMsgEmpty;\n");
            return;
            j = k;
            if (n > 1000) {
              break label154;
            }
            int m = 0;
            localObject2 = MessageForQQWalletMsg.mMsgType;
            int i1 = localObject2.length;
            j = 0;
            for (;;)
            {
              i = m;
              if (j < i1)
              {
                if (localObject2[j] == n) {
                  i = 1;
                }
              }
              else
              {
                j = k;
                if (i != 0) {
                  break;
                }
                j = 1;
                break;
              }
              j += 1;
            }
            label1017:
            bool = false;
            break label273;
            label1023:
            if ((i == 83) || (i == 42))
            {
              j = 2;
              l = paramMsg.msg_head.discuss_info.discuss_uin.get();
              break label563;
            }
            j = 3;
            if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin().equals(String.valueOf(paramMsg.msg_head.to_uin.get()))) {}
            for (l = paramMsg.msg_head.from_uin.get();; l = paramMsg.msg_head.to_uin.get()) {
              break;
            }
            label1124:
            if (n == 18)
            {
              i = 2;
              break label583;
            }
            if (n == 19)
            {
              i = 3;
              break label583;
            }
            if ((n == 21) || (n == 24))
            {
              i = 4;
              break label583;
            }
            if (n == 22)
            {
              i = 5;
              break label583;
            }
            if (n != 23) {
              break label583;
            }
            i = 6;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
        label1207:
        localMessageForQQWalletMsg.mQQWalletRedPacketMsg = null;
        localMessageForQQWalletMsg.mQQWalletTransferMsg = new QQWalletTransferMsg(((im_msg_body.QQWalletMsg)localObject1).aio_body, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin());
        long l = 0L;
        if (((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_senduin.has()) {
          l = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_senduin.get();
        }
        for (localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin();; localObject2 = "")
        {
          if ((n == 10) && (localMessageForQQWalletMsg.mQQWalletTransferMsg.elem != null) && (!TextUtils.isEmpty(localMessageForQQWalletMsg.mQQWalletTransferMsg.elem.nativeAndroid)))
          {
            localObject3 = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem.nativeAndroid.split("\\?");
            if (localObject3.length > 1) {}
            for (localObject3 = localMessageForQQWalletMsg.parseUrlParams(localObject3[1]);; localObject3 = new HashMap())
            {
              aivg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)((HashMap)localObject3).get("tokenid"), ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint64_senduin.get());
              if ((l == 0L) || (TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).compareTo("" + l) == 0)) {
                break;
              }
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.payaio.buyershow", 0, 0, "", "", "", "");
              break;
            }
          }
          if ((n != 9) || (l == 0L) || (TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).compareTo("" + l) == 0)) {
            break label882;
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershow", 0, 0, "", "", "", "");
          break label882;
          label1556:
          if (((im_msg_body.QQWalletMsg)localObject1).aio_body.uint32_msg_priority.has()) {}
          for (i = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint32_msg_priority.get(); i >= 3; i = 10)
          {
            paramList1.add(localMessageForQQWalletMsg);
            return;
          }
          if (i >= 2)
          {
            g(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
            if (!paramList1.isEmpty()) {
              break;
            }
            paramList1.add(localMessageForQQWalletMsg);
            return;
          }
          if (i < 1) {
            break;
          }
          g(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
          if (paramList1.isEmpty())
          {
            i(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
            return;
          }
          paramList1.add(localMessageForQQWalletMsg);
          return;
          label1690:
          i(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
          return;
        }
      }
    }
  }
  
  public void g(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
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
          paramStringBuilder = (MessageForTroopStory)azaf.a(-2057);
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
  
  public void g(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DecodeMsg", 2, "begin decodePBMsgElems_RichMsg");
    }
    Object localObject5 = null;
    Object localObject7 = paramList.iterator();
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject6;
    if (((Iterator)localObject7).hasNext())
    {
      localObject6 = (im_msg_body.Elem)((Iterator)localObject7).next();
      if (!((im_msg_body.Elem)localObject6).rich_msg.has()) {
        break label4730;
      }
    }
    label285:
    label1334:
    label2283:
    Object localObject2;
    label917:
    label2069:
    label2331:
    label3818:
    label4730:
    for (Object localObject1 = (im_msg_body.RichMsg)((im_msg_body.Elem)localObject6).rich_msg.get();; localObject2 = localObject3)
    {
      if (((im_msg_body.Elem)localObject6).general_flags.has()) {}
      for (localObject3 = (im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject6).general_flags.get();; localObject3 = localObject4)
      {
        if (((im_msg_body.Elem)localObject6).text.has()) {}
        for (localObject4 = (im_msg_body.Text)((im_msg_body.Elem)localObject6).text.get();; localObject4 = localObject5)
        {
          localObject6 = localObject3;
          localObject3 = localObject1;
          localObject5 = localObject4;
          localObject4 = localObject6;
          break;
          if (localObject3 == null)
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
          if (localObject4 != null)
          {
            k = i;
            if (((im_msg_body.GeneralFlags)localObject4).long_text_flag.get() == 1)
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
          if (((im_msg_body.RichMsg)localObject3).bytes_template_1.has()) {}
          for (localObject1 = ((im_msg_body.RichMsg)localObject3).bytes_template_1.get().toByteArray();; localObject2 = null)
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
              localObject3 = ((im_msg_body.RichMsg)localObject3).bytes_msg_resid.get();
              if (localObject3 == null) {
                break label4703;
              }
            }
            for (localObject7 = ((ByteStringMicro)localObject3).toStringUtf8();; localObject7 = "")
            {
              Object localObject8;
              if (!bdnn.a((String)localObject7))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("DecodeMsg", 2, new Object[] { "decodePBMsgElems_RichMsg longMsgResId=", localObject7 });
                }
                localObject3 = "";
                localObject8 = paramList.iterator();
                do
                {
                  localObject6 = localObject3;
                  if (!((Iterator)localObject8).hasNext()) {
                    break;
                  }
                  localObject6 = (im_msg_body.Elem)((Iterator)localObject8).next();
                } while (!((im_msg_body.Elem)localObject6).pub_acc_info.has());
                if (((im_msg_body.Elem)localObject6).pub_acc_info.string_long_msg_url.get() != null) {
                  localObject3 = ((im_msg_body.Elem)localObject6).pub_acc_info.string_long_msg_url.get();
                }
                localObject8 = ((im_msg_body.Elem)localObject6).pub_acc_info.bytes_download_key.get();
                localObject6 = localObject3;
                if (localObject8 == null) {
                  break label4696;
                }
                localObject8 = StructLongMessageDownloadProcessor.a(((ByteStringMicro)localObject8).toByteArray());
                localObject6 = localObject3;
              }
              for (localObject3 = localObject8;; localObject3 = "")
              {
                if ((!bdnn.a((String)localObject6)) && (!bdnn.a((String)localObject3)) && (!bdnn.a((String)localObject7)))
                {
                  localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_url", (String)localObject6);
                  localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_download_key", (String)localObject3);
                  localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", (String)localObject7);
                }
                for (boolean bool = true;; bool = false) {
                  for (;;)
                  {
                    localObject3 = azad.a(paramMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    if ((((azaj)localObject3).jdField_a_of_type_Int == 1008) && (QLog.isColorLevel()))
                    {
                      localObject6 = new StringBuilder().append("msgId=").append(localMessageForStructing.uniseq).append(", serviceType(Pa-129,140,142):").append(((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).service_type.get()).append(", xmlContentLength:");
                      if (localObject1 == null)
                      {
                        i = 0;
                        QLog.d("PaOldLongMsg", 2, i + ", longMsgResId:" + (String)localObject7 + ", isPaNewLongMsg:" + bool);
                      }
                    }
                    else if ((localObject4 == null) || (!((im_msg_body.GeneralFlags)localObject4).babyq_guide_msg_cookie.has())) {}
                    try
                    {
                      localObject6 = ((im_msg_body.GeneralFlags)localObject4).babyq_guide_msg_cookie.get().toByteArray();
                      localObject8 = bdeu.a((byte[])localObject6);
                      if (QLog.isColorLevel()) {
                        QLog.d("DecodeMsg", 2, "decodePBMsgElems_RichMsg, guideMsgCookie: " + (String)localObject8 + " ,byte: " + Arrays.toString(((im_msg_body.GeneralFlags)localObject4).babyq_guide_msg_cookie.get().toByteArray()));
                      }
                      localMessageForStructing.saveExtInfoToExtStr("guide_msg_cookie", (String)localObject8);
                      ((alok)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a((byte[])localObject6);
                      if (bool)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("DecodeMsg", 2, "begin getEmptyGeneralStructMsg");
                        }
                        localMessageForStructing.structingMsg = ((StructMsgForGeneralShare)azvd.a());
                        if (localMessageForStructing.structingMsg == null) {
                          break label2283;
                        }
                        if (!(localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
                          break label1416;
                        }
                        localObject3 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mWarningTips;
                        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                          localMessageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", (String)localObject3);
                        }
                        if (((StructMsgForGeneralShare)localMessageForStructing.structingMsg).isPayMessage()) {
                          localMessageForStructing.saveExtInfoToExtStr("pa_pay_message", "1");
                        }
                        localObject3 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mPARedPacket;
                        if (TextUtils.isEmpty((CharSequence)localObject3)) {
                          break label1334;
                        }
                        localObject3 = a((String)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getCurrentAccountUin());
                        if (localObject3 == null) {
                          break label1334;
                        }
                        paramList1.add(localObject3);
                        return;
                        l1 = 0L;
                        break label285;
                        i = localObject1.length;
                      }
                    }
                    catch (Exception localException2)
                    {
                      for (;;)
                      {
                        if (QLog.isColorLevel())
                        {
                          QLog.d("DecodeMsg", 2, "get richmsg guideMsgCookie error!", localException2);
                          continue;
                          if ((localObject1 == null) || (localObject1.length == 0))
                          {
                            if ((((azaj)localObject3).jdField_a_of_type_Int == 1008) && (!TextUtils.isEmpty((CharSequence)localObject7)))
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d("PaOldLongMsg", 2, "msgId=" + localMessageForStructing.uniseq + ", begin getEmptyGeneralStructMsg for PA oldLongMsg!");
                              }
                              localMessageForStructing.structingMsg = ((StructMsgForGeneralShare)azvd.a());
                              localMessageForStructing.saveExtInfoToExtStr("pub_old_long_msg", "1");
                              localMessageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", (String)localObject7);
                              localMessageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
                            }
                          }
                          else
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("DecodeMsg", 2, new Object[] { "begin getStructMsgFromXmlBuff: type=", Integer.valueOf(m), ", code=", Long.valueOf(l2) });
                            }
                            localObject3 = bdom.a((byte[])localObject1, (im_msg_body.GeneralFlags)localObject4, -1);
                            if (localObject3 != null) {
                              i = 0;
                            }
                            for (;;)
                            {
                              localMessageForStructing.structingMsg = azvd.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, m, l2, (byte[])localObject3, i);
                              localObject1 = localObject3;
                              if (!QLog.isColorLevel()) {
                                break label917;
                              }
                              QLog.d("StructMsg", 2, "StructMsg = " + localMessageForStructing.structingMsg);
                              localObject1 = localObject3;
                              break label917;
                              if (localMessageForStructing.structingMsg.mMsgServiceID == 74)
                              {
                                localObject3 = ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mVipDonateStr;
                                if (!TextUtils.isEmpty((CharSequence)localObject3))
                                {
                                  bool = false;
                                  if (String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                                    bool = true;
                                  }
                                  localObject3 = a((String)localObject3, bool);
                                  if (localObject3 != null)
                                  {
                                    paramList1.add(localObject3);
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
                              }
                              localObject3 = paramList.iterator();
                              while (((Iterator)localObject3).hasNext())
                              {
                                im_msg_body.Elem localElem2 = (im_msg_body.Elem)((Iterator)localObject3).next();
                                if ((localElem2.life_online.has()) && (((im_msg_body.LifeOnlineAccount)localElem2.life_online.get()).uint32_report.has()) && (((im_msg_body.LifeOnlineAccount)localElem2.life_online.get()).uint32_report.get() == 1) && (((im_msg_body.LifeOnlineAccount)localElem2.life_online.get()).uint64_unique_id.has())) {
                                  localMessageForStructing.structingMsg.msgId = ((im_msg_body.LifeOnlineAccount)localElem2.life_online.get()).uint64_unique_id.get();
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
                                paramList = (MessageForTroopFee)azaf.a(-2036);
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
                                  QLog.d(alxn.class.getSimpleName(), 2, "Received flower message");
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
                                    break label4671;
                                  }
                                }
                              }
                              for (l2 = ((msg_comm.GroupInfo)localObject1).group_code.get();; l2 = 0L)
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.i(alxn.class.getSimpleName(), 2, "decodePBMsgElems, groupCode:" + l2);
                                }
                                l3 = l1;
                                if (l2 <= 0L)
                                {
                                  if (!paramMsg.msg_head.from_uin.has()) {
                                    break label2325;
                                  }
                                  l1 = paramMsg.msg_head.from_uin.get();
                                  if (!paramMsg.msg_head.to_uin.has()) {
                                    break label2331;
                                  }
                                  l2 = paramMsg.msg_head.to_uin.get();
                                  paramList1.add(((alxn)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.getManager(124)).a(Long.toString(l1), Long.toString(l2), localMessageForStructing.istroop, localMessageForStructing.structingMsg));
                                  l3 = l1;
                                }
                                do
                                {
                                  for (;;)
                                  {
                                    if (((2171946401L == l3) || (2173223560L == l3) || (2062433139L == l3) || (3434959637L == l3)) && ((localMessageForStructing.structingMsg instanceof AbsShareMsg)))
                                    {
                                      if (2171946401L == l3) {
                                        syb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing, 11);
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
                                      break label4169;
                                    }
                                    if (QLog.isColorLevel()) {
                                      paramStringBuilder.append("c2cMsgContent.data:null;\n");
                                    }
                                    i(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
                                    return;
                                    l1 = 0L;
                                    break;
                                    l2 = 0L;
                                    break label2069;
                                    if ((localMessageForStructing.structingMsg.mMsgServiceID == 80) && ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
                                    {
                                      if (ulu.i())
                                      {
                                        paramList = (MessageForQQStory)azaf.a(-2051);
                                        paramList.msgtype = -2051;
                                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject5 != null) && (((im_msg_body.Text)localObject5).str.has())) {
                                          paramStringBuilder.mCompatibleText = ((im_msg_body.Text)localObject5).str.get().toStringUtf8();
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
                                      if (localObject5 != null)
                                      {
                                        ((im_msg_body.Text)localObject5).str.set(ByteStringMicro.copyFromUtf8(ulu.a()));
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
                                        paramList = (MessageForTribeShortVideo)azaf.a(-7002);
                                        paramList.msgtype = -7002;
                                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject5 != null) && (((im_msg_body.Text)localObject5).str.has())) {
                                          paramStringBuilder.mCompatibleText = ((im_msg_body.Text)localObject5).str.get().toStringUtf8();
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
                                        paramList = (MessageForTroopPobing)azaf.a(-2059);
                                        paramList.msgtype = -2059;
                                        paramStringBuilder = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                        if ((TextUtils.isEmpty(paramStringBuilder.mCompatibleText)) && (localObject5 != null) && (((im_msg_body.Text)localObject5).str.has())) {
                                          paramStringBuilder.mCompatibleText = ((im_msg_body.Text)localObject5).str.get().toStringUtf8();
                                        }
                                        if ((localObject4 != null) && (((im_msg_body.GeneralFlags)localObject4).bytes_pb_reserve.has())) {}
                                        try
                                        {
                                          paramMsg = new generalflags.ResvAttr();
                                          paramMsg.mergeFrom(((im_msg_body.GeneralFlags)localObject4).bytes_pb_reserve.get().toByteArray());
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
                                          new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_obj").a(new String[] { l2 + "" }).a();
                                          new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_welcome").a(new String[] { l2 + "", "", "" + bcpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2)) }).a();
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
                                        paramList = (MessageForTroopSign)azaf.a(-2054);
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
                                      if (localMessageForStructing.structingMsg.mMsgServiceID != 43)
                                      {
                                        if (((localMessageForStructing.structingMsg.mMsgServiceID == 83) || (localMessageForStructing.structingMsg.mMsgServiceID == 108) || (localMessageForStructing.structingMsg.mMsgServiceID == 114) || (localMessageForStructing.structingMsg.mMsgServiceID == 116)) && (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgActionData)))
                                        {
                                          localObject3 = "";
                                          localObject1 = localObject3;
                                          if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgUrl)) {
                                            localObject1 = Uri.parse(localMessageForStructing.structingMsg.mMsgUrl);
                                          }
                                          try
                                          {
                                            localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
                                            localObject3 = localObject1;
                                          }
                                          catch (Exception localException1)
                                          {
                                            for (;;)
                                            {
                                              localException1.printStackTrace();
                                            }
                                          }
                                          localObject1 = localObject3;
                                          if (localObject3 == null) {
                                            localObject1 = "";
                                          }
                                          nrt.a(null, "", "0X8007238", "0X8007238", 0, 0, (String)localObject1, "", "", "");
                                          nrt.a("0X8007238", "", (String)localObject1, "", "", "");
                                          localMessageForStructing.structingMsg.mMsgActionData = a(localMessageForStructing.structingMsg.mMsgActionData);
                                          l3 = l1;
                                          continue;
                                        }
                                        if (((localMessageForStructing.structingMsg.mMsgServiceID == 5) || (localMessageForStructing.structingMsg.mMsgServiceID == 137)) && ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare)))
                                        {
                                          localObject3 = paramList.iterator();
                                          do
                                          {
                                            for (;;)
                                            {
                                              l3 = l1;
                                              if (!((Iterator)localObject3).hasNext()) {
                                                break;
                                              }
                                              im_msg_body.Elem localElem1 = (im_msg_body.Elem)((Iterator)localObject3).next();
                                              if (!localElem1.not_online_image.has()) {
                                                break label3818;
                                              }
                                              localObject5 = (im_msg_body.NotOnlineImage)localElem1.not_online_image.get();
                                              localObject3 = (StructMsgForImageShare)localMessageForStructing.structingMsg;
                                              ((StructMsgForImageShare)localObject3).thumbHeight = ((im_msg_body.NotOnlineImage)localObject5).uint32_thumb_height.get();
                                              ((StructMsgForImageShare)localObject3).thumbWidth = ((im_msg_body.NotOnlineImage)localObject5).uint32_thumb_width.get();
                                              ((StructMsgForImageShare)localObject3).width = ((im_msg_body.NotOnlineImage)localObject5).pic_width.get();
                                              ((StructMsgForImageShare)localObject3).height = ((im_msg_body.NotOnlineImage)localObject5).pic_height.get();
                                              ((StructMsgForImageShare)localObject3).thumbUrl = ((im_msg_body.NotOnlineImage)localObject5).str_thumb_url.get();
                                              ((StructMsgForImageShare)localObject3).bigUrl = ((im_msg_body.NotOnlineImage)localObject5).str_big_url.get();
                                              ((StructMsgForImageShare)localObject3).rawUrl = ((im_msg_body.NotOnlineImage)localObject5).str_orig_url.get();
                                              l3 = l1;
                                              if (!localElem1.not_online_image.bytes_pb_reserve.has()) {
                                                break;
                                              }
                                              try
                                              {
                                                localObject5 = new NotOnlineImageExtPb.ResvAttr();
                                                ((NotOnlineImageExtPb.ResvAttr)localObject5).mergeFrom(localElem1.not_online_image.bytes_pb_reserve.get().toByteArray());
                                                ((StructMsgForImageShare)localObject3).mImageBizType = ((NotOnlineImageExtPb.ResvAttr)localObject5).uint32_image_biz_type.get();
                                                l3 = l1;
                                              }
                                              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
                                              {
                                                localInvalidProtocolBufferMicroException1.printStackTrace();
                                                l3 = l1;
                                              }
                                            }
                                            break;
                                          } while (!localInvalidProtocolBufferMicroException1.custom_face.has());
                                          localObject5 = (im_msg_body.CustomFace)localInvalidProtocolBufferMicroException1.custom_face.get();
                                          localObject3 = (StructMsgForImageShare)localMessageForStructing.structingMsg;
                                          ((StructMsgForImageShare)localObject3).thumbHeight = ((im_msg_body.CustomFace)localObject5).uint32_thumb_height.get();
                                          ((StructMsgForImageShare)localObject3).thumbWidth = ((im_msg_body.CustomFace)localObject5).uint32_thumb_width.get();
                                          ((StructMsgForImageShare)localObject3).width = ((im_msg_body.CustomFace)localObject5).uint32_width.get();
                                          ((StructMsgForImageShare)localObject3).height = ((im_msg_body.CustomFace)localObject5).uint32_height.get();
                                          ((StructMsgForImageShare)localObject3).rawUrl = ((im_msg_body.CustomFace)localObject5).str_orig_url.get();
                                          ((StructMsgForImageShare)localObject3).thumbUrl = ((im_msg_body.CustomFace)localObject5).str_thumb_url.get();
                                          ((StructMsgForImageShare)localObject3).bigUrl = ((im_msg_body.CustomFace)localObject5).str_big_url.get();
                                          ((StructMsgForImageShare)localObject3).rawUrl = ((im_msg_body.CustomFace)localObject5).str_orig_url.get();
                                          l3 = l1;
                                          if (localInvalidProtocolBufferMicroException1.custom_face.bytes_pb_reserve.has()) {
                                            try
                                            {
                                              localObject5 = new CustomFaceExtPb.ResvAttr();
                                              ((CustomFaceExtPb.ResvAttr)localObject5).mergeFrom(localInvalidProtocolBufferMicroException1.custom_face.bytes_pb_reserve.get().toByteArray());
                                              ((StructMsgForImageShare)localObject3).mImageBizType = ((CustomFaceExtPb.ResvAttr)localObject5).uint32_image_biz_type.get();
                                              l3 = l1;
                                            }
                                            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
                                            {
                                              localInvalidProtocolBufferMicroException2.printStackTrace();
                                              l3 = l1;
                                            }
                                          }
                                        }
                                        else
                                        {
                                          if (localMessageForStructing.structingMsg.mMsgServiceID != 106) {
                                            break label4109;
                                          }
                                          l3 = l1;
                                          if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
                                          {
                                            localObject2 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
                                            localObject3 = ((StructMsgForGeneralShare)localObject2).animResId;
                                            bcih.a().a((String)localObject3, null);
                                            bcih.a().a(((StructMsgForGeneralShare)localObject2).atMembers);
                                            l3 = l1;
                                          }
                                        }
                                      }
                                    }
                                  }
                                  l3 = l1;
                                } while (localMessageForStructing.structingMsg.mMsgServiceID != 126);
                                paramList = MessageForStarLeague.decodeMsgFromXmlBuff(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app, m, l2, (byte[])localObject2, -1);
                                paramList.msgData = paramList.getBytes();
                                paramList.msg = paramList.getSummaryMsg();
                                paramList1.add(paramList);
                                return;
                                j = 0;
                                m = 0;
                                paramStringBuilder = null;
                                paramMsg = null;
                                paramList = paramStringBuilder;
                                i = j;
                                if (localObject4 != null)
                                {
                                  paramList = paramStringBuilder;
                                  i = j;
                                  if (!((im_msg_body.GeneralFlags)localObject4).bytes_pb_reserve.has()) {}
                                }
                                try
                                {
                                  parambbpd = new generalflags.ResvAttr();
                                  parambbpd.mergeFrom(((im_msg_body.GeneralFlags)localObject4).bytes_pb_reserve.get().toByteArray());
                                  paramStringBuilder = paramMsg;
                                  j = m;
                                  if (parambbpd.bytes_kpl_info.has())
                                  {
                                    paramStringBuilder = paramMsg;
                                    j = m;
                                    if (parambbpd.bytes_kpl_info.has())
                                    {
                                      j = 1;
                                      paramStringBuilder = parambbpd.bytes_kpl_info.get().toStringUtf8();
                                    }
                                  }
                                  paramList = paramStringBuilder;
                                  i = j;
                                  if (parambbpd.bytes_oac_msg_extend.has())
                                  {
                                    localMessageForStructing.saveExtInfoToExtStr("report_key_bytes_oac_msg_extend", parambbpd.bytes_oac_msg_extend.get().toStringUtf8());
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
                                      paramList = (ChatMessage)azaf.a(-1051);
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
                                            paramMsg = (azus)paramStringBuilder.next();
                                            if ((paramMsg instanceof azut))
                                            {
                                              paramMsg = ((azut)paramMsg).jdField_a_of_type_JavaUtilArrayList;
                                              if (paramMsg != null)
                                              {
                                                paramMsg = paramMsg.iterator();
                                                if (paramMsg.hasNext())
                                                {
                                                  parambbpd = (azus)paramMsg.next();
                                                  if (!(parambbpd instanceof StructMsgItemTitle)) {
                                                    break;
                                                  }
                                                  paramList.msg = ((StructMsgItemTitle)parambbpd).b();
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
                              localObject3 = localObject2;
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
  
  public void h(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeMsg;\n");
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
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeMsg null commomElem!");
        }
        return;
      }
      paramStringBuilder = new MessageForPoke();
      paramStringBuilder.msgtype = -5012;
      if (paramList.uint32_business_type.has()) {
        paramStringBuilder.interactType = paramList.uint32_business_type.get();
      }
      hummer_commelem.MsgElemInfo_servtype2 localMsgElemInfo_servtype2;
      if (paramList.bytes_pb_elem.has()) {
        localMsgElemInfo_servtype2 = new hummer_commelem.MsgElemInfo_servtype2();
      }
      for (;;)
      {
        try
        {
          localMsgElemInfo_servtype2.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          paramStringBuilder.msg = localMsgElemInfo_servtype2.bytes_poke_summary.get().toStringUtf8();
          paramStringBuilder.doubleHitState = localMsgElemInfo_servtype2.uint32_double_hit.get();
          if (!localMsgElemInfo_servtype2.uint32_vaspoke_id.has()) {
            continue;
          }
          i = localMsgElemInfo_servtype2.uint32_vaspoke_id.get();
          paramStringBuilder.subId = i;
          if (!localMsgElemInfo_servtype2.bytes_vaspoke_name.has()) {
            continue;
          }
          paramList = localMsgElemInfo_servtype2.bytes_vaspoke_name.get().toStringUtf8();
          paramStringBuilder.name = paramList;
          if (!localMsgElemInfo_servtype2.bytes_vaspoke_minver.has()) {
            continue;
          }
          paramList = localMsgElemInfo_servtype2.bytes_vaspoke_minver.get().toStringUtf8();
          paramStringBuilder.minVersion = paramList;
          paramStringBuilder.strength = localMsgElemInfo_servtype2.uint32_poke_strength.get();
          if (!localMsgElemInfo_servtype2.uint32_poke_flag.has()) {
            continue;
          }
          i = localMsgElemInfo_servtype2.uint32_poke_flag.get();
          paramStringBuilder.flag = i;
          if (paramStringBuilder.interactType == 126) {
            VasWebviewUtil.reportCommercialDrainage("", "poke", "receive", "", 0, 0, 0, "", String.valueOf(paramStringBuilder.subId), "none", "", "", "", "", 0, 0, 0, 0);
          }
        }
        catch (Exception paramList)
        {
          int i;
          QLog.d("PokeMsg", 1, "decodePBMsgElems_PokeMsg exception!", paramList);
          continue;
        }
        paramList1.add(paramStringBuilder);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PokeMsg", 2, "decodePbElems, common_elem type 2, interactType:" + paramStringBuilder.interactType + " ,doubleHitState:" + paramStringBuilder.doubleHitState);
        return;
        i = -1;
        continue;
        paramList = alud.a(2131707048);
        continue;
        paramList = "";
        continue;
        i = 0;
      }
    }
  }
  
  public void h(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd)
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
      localObject7 = (MessageForPubAccount)azaf.a(-3006);
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
          ((MessageForPubAccount)localObject7).msgData = swh.a((PAMessage)localObject3);
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
            i = bdqa.a((byte[])localObject3, 1);
            j = localObject3[3];
            localObject6 = new byte[i - 1];
            bdqa.a((byte[])localObject6, 0, (byte[])localObject3, 4, i - 1);
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
              ((MessageForPubAccount)localObject7).msgData = swh.a((PAMessage)localObject1);
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
            g(paramList, paramList1, paramStringBuilder, paramMsg, parambbpd);
            return;
            j = i;
          }
        }
        Object localObject5 = localObject1;
      }
    }
  }
  
  public void i(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeMsg;\n");
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
          QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeMsg null commomElem!");
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
  
  public void i(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bbpd parambbpd)
  {
    String str = null;
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
        break label1945;
      }
      localGeneralFlags = (im_msg_body.GeneralFlags)localElem.general_flags.get();
      i = i1;
      if (!localElem.bless_msg.has()) {
        break label1938;
      }
      i = i1;
      if (localElem.bless_msg.uint32_msg_type.get() != 1) {
        break label1938;
      }
      i = 1;
      if (!localElem.bless_msg.uint32_ex_flag.has()) {
        break label1938;
      }
      j = localElem.bless_msg.uint32_ex_flag.get();
      i = 1;
      label139:
      if ((!localElem.elem_flags2.has()) || (!localElem.elem_flags2.uint32_msg_rpt_cnt.has())) {
        break label1935;
      }
      m = localElem.elem_flags2.uint32_msg_rpt_cnt.get();
      label177:
      if ((!localElem.text.has()) || (!localElem.text.str.has())) {
        break label1932;
      }
      str = localElem.text.str.get().toStringUtf8();
      if ((str != null) && (str.startsWith("[")) && (str.endsWith("]")))
      {
        str = bdhe.a(localElem.text.str.get().toByteArray());
        label264:
        n = k;
        if (localElem.text.has())
        {
          n = k;
          if (!localElem.text.bytes_pb_reserve.has()) {}
        }
      }
    }
    label1932:
    label1935:
    label1938:
    label1945:
    label1948:
    for (;;)
    {
      try
      {
        localObject3 = new TextMsgExtPb.ResvAttr();
        ((TextMsgExtPb.ResvAttr)localObject3).mergeFrom(localElem.text.bytes_pb_reserve.get().toByteArray());
        if (!((TextMsgExtPb.ResvAttr)localObject3).text_analysis_result.has()) {
          break label1948;
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
      str = "";
      break label264;
      Object localObject2 = null;
      localObject1 = new azac();
      ArrayList localArrayList1 = ((azac)localObject1).jdField_a_of_type_JavaUtilArrayList;
      ArrayList localArrayList2 = new ArrayList(2);
      Object localObject3 = a(null, paramList, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), parambbpd, (azac)localObject1, localArrayList2);
      localObject1 = localObject2;
      if (localArrayList1 != null)
      {
        localObject1 = localObject2;
        if (localArrayList1.size() == 2)
        {
          localObject1 = localObject2;
          if (localArrayList1.get(1) != null) {
            localObject1 = (byte[])localArrayList1.get(1);
          }
        }
      }
      if (((StringBuilder)localObject3).length() == 0) {
        return;
      }
      long l3 = 0L;
      int i2 = 0;
      i = 0;
      j = 0;
      long l4 = 0L;
      long l2;
      if (localGeneralFlags != null)
      {
        l2 = l3;
        if (localGeneralFlags.bytes_pb_reserve.has())
        {
          i = i2;
          l2 = l3;
        }
      }
      label1844:
      for (;;)
      {
        long l1;
        boolean bool1;
        boolean bool3;
        try
        {
          paramList = new generalflags.ResvAttr();
          i = i2;
          l2 = l3;
          paramList.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
          l1 = l3;
          i = i2;
          l2 = l3;
          if (paramList.redbag_msg_sender_uin.has())
          {
            i = 1;
            j = 1;
            l2 = l3;
            l1 = paramList.redbag_msg_sender_uin.get();
          }
          l3 = l4;
          i = j;
          l2 = l1;
          if (paramList.want_gift_sender_uin.has())
          {
            i = j;
            l2 = l1;
            l3 = paramList.want_gift_sender_uin.get();
          }
          l2 = l3;
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
            break label1900;
          }
          if (localGeneralFlags.uint32_prp_fold.get() == 1)
          {
            bool2 = true;
            paramList = localGeneralFlags.bytes_rp_id.get().toStringUtf8();
            paramStringBuilder = localGeneralFlags.bytes_rp_index.get().toStringUtf8();
            bool1 = aiul.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if ((j == 0) || (!aiul.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app))) {
              break label1894;
            }
            if (TextUtils.isEmpty(paramList)) {
              break label1597;
            }
            bool1 = true;
            if (QLog.isColorLevel()) {
              QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, redBagSender: %s, foldFlag: %s, redBagId: %s, index: %s, foldSwitch: %s, isValidFoldMsg: %s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool2), paramList, paramStringBuilder, Boolean.valueOf(aiul.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), Boolean.valueOf(bool1) }));
            }
            if (!String.valueOf(paramMsg.msg_head.from_uin.get()).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
              break label1879;
            }
            bool3 = false;
            bool2 = bool1;
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
              break label1615;
            }
            parambbpd = new MessageForFoldMsg();
            ((MessageForFoldMsg)parambbpd).init(bool1, paramList, paramStringBuilder, l1, true);
            paramList = parambbpd;
            paramList.msg = ((StringBuilder)localObject3).toString();
            if ((paramList instanceof MessageForText)) {
              bcpg.a(paramList);
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
            if ((localObject1 != null) && (i == 0)) {
              paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", bdhe.a((byte[])localObject1));
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
          paramMsg = bdeu.a(paramStringBuilder);
          if (QLog.isColorLevel()) {
            QLog.d("DecodeMsg", 2, "decodePBMsgElems_Text, guideMsgCookie: " + paramMsg + ",bytes: " + Arrays.toString(localGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
          }
          paramList.saveExtInfoToExtStr("guide_msg_cookie", paramMsg);
          ((alok)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(paramStringBuilder);
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
              break label1844;
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
          parambbpd = new generalflags.ResvAttr();
          parambbpd.mergeFrom(localGeneralFlags.bytes_pb_reserve.get().toByteArray());
          paramStringBuilder = paramMsg;
          i = j;
          if (parambbpd.bytes_kpl_info.has())
          {
            paramStringBuilder = paramMsg;
            i = j;
            if (parambbpd.bytes_kpl_info.has())
            {
              i = 1;
              paramStringBuilder = parambbpd.bytes_kpl_info.get().toStringUtf8();
            }
          }
        }
        catch (Exception paramStringBuilder)
        {
          if (!QLog.isColorLevel()) {
            break label1867;
          }
          QLog.d("KplMessage", 2, "parse proto catch exception about kpl");
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
        if (!TextUtils.isEmpty(str)) {
          paramList.saveExtInfoToExtStr("small_description", str);
        }
        if ((paramList instanceof RecommendCommonMessage)) {
          paramList.saveExtInfoToExtStr("ark_text_analysis_flag", String.valueOf(k));
        }
        paramList1.add(paramList);
        return;
        l3 = l2;
        l2 = 0L;
        continue;
        boolean bool2 = false;
        continue;
        label1597:
        if ((!TextUtils.isEmpty(paramStringBuilder)) && (bool1))
        {
          bool1 = true;
          continue;
          label1615:
          if (i != 0)
          {
            paramList = (ChatMessage)azaf.a(-1051);
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
            paramList = (ChatMessage)azaf.a(-1000);
            if ((parambbpd != null) && (localArrayList2 != null)) {
              bciq.a(parambbpd.jdField_a_of_type_Int, localArrayList2, paramList);
            }
            if (localArrayList1.size() > 0)
            {
              paramStringBuilder = new ArrayList(localArrayList1.size());
              parambbpd = localArrayList1.iterator();
              while (parambbpd.hasNext())
              {
                localObject2 = parambbpd.next();
                if ((localObject2 instanceof MessageForText.AtTroopMemberInfo)) {
                  paramStringBuilder.add((MessageForText.AtTroopMemberInfo)localObject2);
                }
              }
              paramList.atInfoTempList = paramStringBuilder;
            }
            continue;
            label1879:
            bool3 = bool1;
            bool1 = bool2;
            bool2 = bool3;
          }
        }
        else
        {
          label1867:
          label1894:
          bool1 = false;
          continue;
          label1900:
          paramStringBuilder = null;
          bool1 = false;
          bool2 = false;
          paramList = null;
          continue;
          paramStringBuilder = null;
          l1 = 0L;
          l2 = 0L;
          bool2 = false;
          bool1 = false;
          paramList = null;
        }
      }
      break label264;
      break label177;
      j = n;
      break label139;
      break label72;
    }
  }
  
  public void j(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    MessageForLimitChatConfirm localMessageForLimitChatConfirm = null;
    Iterator localIterator = paramList.iterator();
    do
    {
      paramList = localMessageForLimitChatConfirm;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)localIterator.next();
    } while (!paramList.common_elem.has());
    paramList = (im_msg_body.CommonElem)paramList.common_elem.get();
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("decodePBMsgElems_LimitChatConfirmMsg;\n");
    }
    paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype24();
    for (;;)
    {
      try
      {
        paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
        localMessageForLimitChatConfirm = (MessageForLimitChatConfirm)azaf.a(-7005);
        localMessageForLimitChatConfirm.msgtype = -7005;
        if (paramList.uint32_business_type.has())
        {
          i = paramList.uint32_business_type.get();
          if (i != 1) {
            break label383;
          }
          if (!paramStringBuilder.limit_chat_enter.has()) {
            break label370;
          }
          localMessageForLimitChatConfirm.SenderNickName = paramStringBuilder.limit_chat_enter.bytes_match_nick.get().toStringUtf8();
          localMessageForLimitChatConfirm.tipsWording = paramStringBuilder.limit_chat_enter.bytes_tips_wording.get().toStringUtf8();
          localMessageForLimitChatConfirm.leftChatTime = paramStringBuilder.limit_chat_enter.uint32_left_chat_time.get();
          localMessageForLimitChatConfirm.c2cExpiredTime = paramStringBuilder.limit_chat_enter.uint32_c2c_expired_time.get();
          localMessageForLimitChatConfirm.matchExpiredTime = paramStringBuilder.limit_chat_enter.uint32_match_expired_time.get();
          localMessageForLimitChatConfirm.timeStamp = paramStringBuilder.limit_chat_enter.uint64_match_ts.get();
          localMessageForLimitChatConfirm.readyTs = paramStringBuilder.limit_chat_enter.uint64_ready_ts.get();
          localMessageForLimitChatConfirm.bEnterMsg = true;
          if (QLog.isColorLevel()) {
            QLog.i("DecodeMsgLimitChatConfirm msg", 1, " decodePBMsgElems_LimitChatConfirmMsg type" + i + " " + localMessageForLimitChatConfirm.matchExpiredTime + " " + localMessageForLimitChatConfirm.frienduin);
          }
          localMessageForLimitChatConfirm.prewrite();
          paramList1.add(localMessageForLimitChatConfirm);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramList)
      {
        paramList.printStackTrace();
        QLog.e("DecodeMsgscribble msg", 1, paramList, new Object[0]);
        return;
      }
      int i = 1;
      continue;
      label370:
      QLog.e("DecodeMsgExtendFriendLimitChatLimitChatConfirm msg", 1, " !!!limitChatElem  limit_chat_enter is null ");
      continue;
      label383:
      if (paramStringBuilder.limit_chat_exit.has())
      {
        localMessageForLimitChatConfirm.bEnterMsg = false;
        localMessageForLimitChatConfirm.leaveChatType = paramStringBuilder.limit_chat_exit.uint32_exit_method.get();
        localMessageForLimitChatConfirm.timeStamp = paramStringBuilder.limit_chat_exit.uint64_match_ts.get();
      }
      else
      {
        QLog.e("DecodeMsgLimitChatConfirm msg", 1, " limitChatElem  limit_chat_exit is null ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azaa
 * JD-Core Version:    0.7.0.1
 */