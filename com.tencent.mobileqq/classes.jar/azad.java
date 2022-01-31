import IMMsgBodyPack.SlaveMasterMsg;
import OnlinePushPack.MsgInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.hd_video_2.CmdS2CInviteReqBody;
import com.tencent.av.hd_video_2.InviteTempSessionData;
import com.tencent.av.hd_video_2.MsgBody;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Bomb;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.hiboom.hiboom_type.Hiboom_Type;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.MsgBody;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.message.MessageProtoCodec.2;
import com.tencent.mobileqq.service.message.MessageProtoCodec.3;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.ThreeDBaseInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.Set;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.PttRec;
import mqq.app.AccountNotMatchException;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import msf.msgcomm.msg_comm.PluginInfo;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.AuthTmp;
import msf.msgsvc.msg_svc.BsnsTmp;
import msf.msgsvc.msg_svc.BusinessWPATmp;
import msf.msgsvc.msg_svc.C2C;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.Dis;
import msf.msgsvc.msg_svc.DisTmp;
import msf.msgsvc.msg_svc.Grp;
import msf.msgsvc.msg_svc.GrpTmp;
import msf.msgsvc.msg_svc.NearByAssistantTmp;
import msf.msgsvc.msg_svc.NearByDatingTmp;
import msf.msgsvc.msg_svc.PbDeleteMsgReq;
import msf.msgsvc.msg_svc.PbDeleteMsgReq.MsgItem;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PubGroupTmp;
import msf.msgsvc.msg_svc.PublicPlat;
import msf.msgsvc.msg_svc.QQQueryBusinessTmp;
import msf.msgsvc.msg_svc.RichStatusTmp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import msf.msgsvc.msg_svc.TransMsg;
import msf.msgsvc.msg_svc.WPATmp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.cs.head.ContentHead;
import tencent.im.cs.head.Head;
import tencent.im.cs.head.MsgHead;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.source_msg.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype11;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype2;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype20;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype23;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatEnter;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatExit;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype33;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.FunFace;
import tencent.im.msg.im_msg_body.FunFace.Bomb;
import tencent.im.msg.im_msg_body.FunFace.Turntable;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SecretFileMsg;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TmpPtt;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msgrevoke.msgrevoke_userdef.UinTypeUserDef;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.MsgInfo;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x104.submsgtype0x104.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6b.SubMsgType0x6b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.PushLostDevFound;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.QimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VideoInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VipInfoNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MemorialDayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneMemorialDayInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.AddFriendSource;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PersonMayKnow;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PushPeopleMayKnowV2;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.DealInviteInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.InviteInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.UninviteInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe8.submsgtype0xe8.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.FailNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.ProgressNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class azad
{
  private static HashMap<String, Long> a = new HashMap();
  
  public static int a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    case 7: 
    case 9: 
    case 13: 
    case 20: 
    default: 
      return paramQQAppInterface.a().a().a(paramInt).a();
    case 1: 
      return 0;
    case 3: 
      return 1000;
    case 6: 
      return 1005;
    case 8: 
      return 1008;
    case 10: 
      return 1006;
    case 5: 
      return 1004;
    case 11: 
      return 1009;
    case 12: 
      return 1001;
    case 23: 
      return 10002;
    case 25: 
      return 1033;
    case 26: 
      return 1034;
    case 24: 
      return 10004;
    case 4: 
      return 3000;
    case 2: 
      return 1;
    case 14: 
      return 1020;
    case 16: 
      return 1021;
    case 17: 
      return 1022;
    case 18: 
      return 1023;
    case 15: 
      return 1024;
    case 19: 
      return 1010;
    case 21: 
      return 1026;
    case 22: 
      return 7400;
    case 28: 
      return 1037;
    case 27: 
      return 1036;
    case 29: 
      return 1044;
    case 30: 
      return 1045;
    case 31: 
      return 10007;
    }
    return 10008;
  }
  
  public static int a(msg_comm.Msg paramMsg)
  {
    int i;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      im_msg_body.Elem localElem;
      do
      {
        if (!paramMsg.hasNext()) {
          break;
        }
        localElem = (im_msg_body.Elem)paramMsg.next();
      } while ((!localElem.general_flags.has()) || (!((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_diy_text_id.has()));
      j = ((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_diy_text_id.get();
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_BubbleDiyTextID->" + j);
    return j;
    return 0;
  }
  
  public static int a(im_msg_body.RichText paramRichText, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int k = 0;
    if (k < str.length())
    {
      paramString = null;
      if (paramArrayList == null) {
        break label1167;
      }
      label45:
      if (i >= paramArrayList.size()) {
        break label1162;
      }
      paramString = (MessageForText.AtTroopMemberInfo)paramArrayList.get(i);
      if ((paramString == null) || (!paramString.isValid())) {}
    }
    label1157:
    label1162:
    label1167:
    for (;;)
    {
      int m;
      Object localObject1;
      if ((paramString != null) && (paramString.startPos <= k))
      {
        m = j;
        if (localStringBuilder.length() > 0)
        {
          a(paramRichText, localStringBuilder.toString());
          localStringBuilder.delete(0, localStringBuilder.length());
          m = j + 1;
        }
        localObject1 = a(paramRichText, str.substring(paramString.startPos, paramString.startPos + paramString.textLen));
        short s = paramString.startPos;
        paramString.startPos = 0;
        a(paramString, (im_msg_body.Elem)localObject1);
        paramString.startPos = s;
        localStringBuilder.delete(0, localStringBuilder.length());
        j = m + 1;
        m = paramString.textLen;
        i += 1;
        k += m - 1;
        k += 1;
        break;
        i += 1;
        break label45;
      }
      int n;
      label536:
      label548:
      Object localObject2;
      int[] arrayOfInt;
      if ((str.charAt(k) == '\024') && (k + 1 < str.length()))
      {
        n = j;
        if (localStringBuilder.length() > 0)
        {
          a(paramRichText, localStringBuilder.toString());
          localStringBuilder.delete(0, localStringBuilder.length());
          n = j + 1;
        }
        m = str.charAt(k + 1);
        j = m;
        if (m == 250) {
          j = 10;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "localeCode value:" + j + ",max len:" + azah.a.length);
        }
        if (apsp.c(j))
        {
          m = apsp.a(j);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "---faceIndex:" + m);
          }
          if (m >= 260)
          {
            paramString = new hummer_commelem.MsgElemInfo_servtype33();
            paramString.uint32_index.set(m);
            localObject1 = apsp.a(j);
            paramString.bytes_text.set(ByteStringMicro.copyFromUtf8((String)localObject1));
            paramString.bytes_compat.set(ByteStringMicro.copyFromUtf8((String)localObject1));
            localObject1 = new im_msg_body.CommonElem();
            ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(33);
            ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(1);
            ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
            paramString = new im_msg_body.Elem();
            paramString.common_elem.set((MessageMicro)localObject1);
            paramRichText.elems.add(paramString);
            j = n + 1;
            m = k + 1;
          }
        }
        do
        {
          k = m;
          break;
          paramString = new im_msg_body.Face();
          paramString.index.set(m);
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).face.set(paramString);
          paramRichText.elems.add((MessageMicro)localObject1);
          break label536;
          m = k;
          j = n;
        } while (k + 4 >= str.length());
        localObject2 = new char[4];
        localObject2[3] = str.charAt(k + 1);
        localObject2[2] = str.charAt(k + 2);
        localObject2[1] = str.charAt(k + 3);
        localObject2[0] = str.charAt(k + 4);
        j = 0;
        if (j < 4)
        {
          if (localObject2[j] == 'ú') {
            localObject2[j] = 10;
          }
          for (;;)
          {
            j += 1;
            break;
            if (localObject2[j] == 'þ') {
              localObject2[j] = 13;
            }
          }
        }
        arrayOfInt = apmq.a((char[])localObject2);
        paramString = BaseApplicationImpl.getContext();
        if (Build.VERSION.SDK_INT > 10) {
          j = 4;
        }
      }
      for (paramString = paramString.getSharedPreferences("Last_Login", j).getString("uin", "");; paramString = null) {
        for (;;)
        {
          try
          {
            paramString = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
            localObject1 = bamp.jdField_c_of_type_JavaLangString;
            if (paramString == null) {
              break label1151;
            }
            paramString = (aufn)paramString.getManager(14);
            if (paramString == null) {
              break label1157;
            }
            paramString = paramString.a(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));
            if (paramString == null) {
              break label1151;
            }
            paramString = paramString.character;
            j = arrayOfInt[0];
            m = arrayOfInt[1];
            localObject1 = new im_msg_body.SmallEmoji();
            ((im_msg_body.SmallEmoji)localObject1).packIdSum.set((j << 16) + m);
            if (localObject2[3] == 'ÿ')
            {
              ((im_msg_body.SmallEmoji)localObject1).imageType.set(1);
              localObject2 = new im_msg_body.Elem();
              ((im_msg_body.Elem)localObject2).small_emoji.set((MessageMicro)localObject1);
              paramRichText.elems.add((MessageMicro)localObject2);
              localObject1 = new im_msg_body.Text();
              ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(paramString));
              paramString = new im_msg_body.Elem();
              paramString.text.set((MessageMicro)localObject1);
              paramRichText.elems.add(paramString);
              j = n + 1 + 1;
              m = k + 4;
              break label548;
              j = 0;
            }
          }
          catch (AccountNotMatchException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "[AccountNotMatchException]," + paramString.getMessage());
            }
            paramString = null;
            continue;
            if (localObject2[3] != 'ǿ') {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "send apng epid = " + arrayOfInt[0] + " eid = " + arrayOfInt[1]);
            }
            ((im_msg_body.SmallEmoji)localObject1).imageType.set(2);
            continue;
          }
          localStringBuilder.append(str.charAt(k));
          break;
          i = j;
          if (localStringBuilder.length() > 0)
          {
            a(paramRichText, localStringBuilder.toString());
            i = j + 1;
          }
          return i;
          label1151:
          paramString = (String)localObject1;
        }
      }
      paramString = null;
    }
  }
  
  public static long a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_GroupSys");
    }
    long l2;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_GroupSys return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
      l2 = 0L;
      return l2;
    }
    Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
    byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {}
    for (long l1 = bdqa.a(arrayOfByte, 0);; l1 = 0L)
    {
      Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (localObject != null)
      {
        localObject = ((msg_comm.MsgHead)localObject).group_name.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.sysnick", 2, "TroopCode:" + l1 + "TroopName:" + (String)localObject);
        }
        paramMessageHandler.c("" + l1, (String)localObject);
      }
      l2 = l1;
      if (paramBoolean1) {
        break;
      }
      l2 = l1;
      if (paramBoolean2) {
        break;
      }
      l2 = l1;
      if (paramBoolean3) {
        break;
      }
      paramMessageHandler.a().a(i, arrayOfByte, l3, ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), (msg_comm.MsgHead)paramMsg.msg_head.get());
      return l1;
    }
  }
  
  public static long a(msg_comm.Msg paramMsg)
  {
    long l1 = -1L;
    long l2 = l1;
    if (paramMsg.msg_body.has())
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    label70:
    Object localObject;
    if (paramMsg.hasNext())
    {
      localObject = (im_msg_body.Elem)paramMsg.next();
      if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.Elem)localObject).elem_flags2.uint32_custom_font.has())) {
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_custom_font.get() & 0xFFFFFFFF;
      }
    }
    for (;;)
    {
      break label70;
      if (((im_msg_body.Elem)localObject).secret_file.has())
      {
        localObject = ((im_msg_body.Elem)localObject).secret_file;
        if ((((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) && (((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_custom_font.has()))
        {
          l1 = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_custom_font.get() & 0xFFFFFFFF;
          continue;
          l2 = l1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_VipFontID: fontid = " + l1);
          return l1;
        }
      }
    }
  }
  
  public static Pair<Long, Long> a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, String paramString1, String paramString2)
  {
    long l2 = -1L;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return new Pair(Long.valueOf(0L), Long.valueOf(0L));
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    long l1 = -1L;
    Object localObject;
    if (paramMsg.hasNext())
    {
      localObject = (im_msg_body.Elem)paramMsg.next();
      if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.has())) {
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
      }
    }
    for (;;)
    {
      break;
      if (((im_msg_body.Elem)localObject).secret_file.has())
      {
        localObject = ((im_msg_body.Elem)localObject).secret_file;
        if ((((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) && (((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_color_text_id.has()))
        {
          l1 = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
          continue;
          if (l1 == 4294967295L) {
            l2 = paramMessageHandler.app.a().a(paramString1, paramString2);
          }
          return new Pair(Long.valueOf(l1), Long.valueOf(l2));
        }
      }
    }
  }
  
  public static ayzt a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, int paramInt)
  {
    im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
    Long localLong1 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
    Long localLong2 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    Object localObject = localLong1.toString();
    String str = paramMessageHandler.app.getCurrentAccountUin();
    if (i == 129)
    {
      paramMsg = (msg_comm.Msg)localObject;
      if (((String)localObject).equals(String.valueOf(localLong2)))
      {
        paramMsg = (msg_comm.Msg)localObject;
        if (((String)localObject).equals(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile recv  a 0x81 that is from self.");
          }
          return null;
        }
      }
    }
    else
    {
      if (!str.equals(String.valueOf(localLong1))) {
        break label238;
      }
      paramMsg = String.valueOf(localLong2);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return null;
      label238:
      paramMsg = String.valueOf(localLong1);
      break;
      if (str.equalsIgnoreCase(String.valueOf(localLong1)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.it is from self!!!");
        }
        return null;
      }
      if (paramBoolean2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "recv roam online msg, return null!");
        }
        return null;
      }
      localObject = paramMessageHandler.app.a().a(localMsgBody.msg_content.get().toByteArray());
      if (localObject != null)
      {
        if (!paramMessageHandler.app.a().a((arcf)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.");
          }
          return null;
        }
        if (!((arcf)localObject).jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81. requset is no mulitend olfile.");
          }
          return null;
        }
        paramMessageHandler.app.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (arcf)localObject, paramLong2, paramInt);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x81 failed.");
        }
        return null;
        localObject = paramMessageHandler.app.a().a(localMsgBody.msg_content.get().toByteArray());
        if (localObject != null)
        {
          if (!paramMessageHandler.app.a().a((arcf)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x83  is error.");
            }
            return null;
          }
          paramMessageHandler.app.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (arcf)localObject, paramLong2, paramInt);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x83 failed.");
          }
          return null;
          localObject = paramMessageHandler.app.a().b(localMsgBody.msg_content.get().toByteArray());
          if (localObject == null) {
            break label640;
          }
          if (!paramMessageHandler.app.a().a((arcf)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x85  is error.");
            }
            return null;
          }
          paramMessageHandler.app.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (arcf)localObject, paramLong2, paramInt);
        }
      }
    }
    label640:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x85 failed.");
    }
    return null;
  }
  
  public static azaj a(msg_comm.Msg paramMsg, QQAppInterface paramQQAppInterface)
  {
    azaj localazaj = new azaj();
    int i = -1;
    msg_comm.C2CTmpMsgHead localC2CTmpMsgHead = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
    int j;
    int k;
    if (!localC2CTmpMsgHead.c2c_type.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "It doesn't has a c2cType.");
      }
      localazaj.jdField_b_of_type_Int = localC2CTmpMsgHead.direction_flag.get();
      j = localC2CTmpMsgHead.c2c_type.get();
      k = localC2CTmpMsgHead.service_type.get();
      switch (k)
      {
      default: 
        label312:
        localazaj.jdField_a_of_type_Int = i;
        localazaj.jdField_a_of_type_Long = -1L;
        localazaj.jdField_b_of_type_Long = -1L;
        switch (k)
        {
        }
        break;
      }
    }
    for (;;)
    {
      paramQQAppInterface = (abub)paramQQAppInterface.a().a().a(k);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramMsg, localazaj);
      }
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder("<---getC2CMsgPkgTempInfo: dump info:");
        paramMsg.append(" c2cType:").append(j).append(" serviceType:").append(k).append("direction_flag:").append(localazaj.jdField_b_of_type_Int).append(" info:").append(localazaj.toString());
        QLog.d("Q.msg.MessageHandler", 2, paramMsg.toString());
      }
      return localazaj;
      if ((localC2CTmpMsgHead.service_type.has()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("Q.msg.MessageHandler", 2, "Invalid service type, the pb data has no service type.");
      break;
      i = 1000;
      break label312;
      i = 1004;
      break label312;
      i = 1024;
      if ((!nbp.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.from_uin.get()))) && (!nbp.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.to_uin.get())))) {
        break label312;
      }
      i = 1025;
      break label312;
      i = 1005;
      break label312;
      i = 1008;
      break label312;
      i = 1006;
      break label312;
      i = 1009;
      break label312;
      i = 1001;
      break label312;
      i = 1020;
      break label312;
      i = 1021;
      break label312;
      i = 1022;
      break label312;
      i = 1023;
      break label312;
      i = 1010;
      break label312;
      i = 7400;
      break label312;
      i = 10002;
      break label312;
      i = 10004;
      break label312;
      i = 1036;
      break label312;
      i = 1032;
      break label312;
      i = 1037;
      break label312;
      i = 1038;
      break label312;
      i = 1044;
      break label312;
      i = 10007;
      break label312;
      i = 10008;
      break label312;
      i = 1045;
      break label312;
      localazaj.jdField_a_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localazaj.jdField_b_of_type_Long = localC2CTmpMsgHead.group_uin.get();
      continue;
      localazaj.jdField_a_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localazaj.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      continue;
      localazaj.jdField_a_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localazaj.jdField_b_of_type_Long = localC2CTmpMsgHead.group_uin.get();
    }
  }
  
  public static MessageRecord a(MessageHandler paramMessageHandler, byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    SubMsgType0xcb.MsgBody localMsgBody = new SubMsgType0xcb.MsgBody();
    for (;;)
    {
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (MessageForNearbyLiveTip)azaf.a(-2053);
        if (localMsgBody.uint32_anchor_status.get() == 1)
        {
          bool = true;
          paramArrayOfByte.isLiving = bool;
          paramArrayOfByte.jumpingUrl = localMsgBody.bytes_jump_schema.get().toStringUtf8();
          paramArrayOfByte.msg = localMsgBody.bytes_live_wording.get().toStringUtf8();
          paramArrayOfByte.headUrl = localMsgBody.bytes_anchor_head_url.get().toStringUtf8();
          paramArrayOfByte.nickName = localMsgBody.bytes_anchor_nickname.get().toStringUtf8();
          paramArrayOfByte.liveEndWording = localMsgBody.bytes_live_end_wording.get().toStringUtf8();
          paramArrayOfByte.c2cMsgWording = localMsgBody.bytes_c2c_msg_wording.get().toStringUtf8();
          paramArrayOfByte.startLiveWordingType = localMsgBody.uint32_live_wording_type.get();
          paramArrayOfByte.endLiveWordingType = localMsgBody.uint32_end_wording_type.get();
          long l1 = paramMsg.msg_head.from_uin.get();
          int i = paramMsg.msg_head.msg_seq.get();
          long l2 = paramMsg.msg_head.msg_uid.get();
          int j = paramMsg.msg_head.msg_type.get();
          paramArrayOfByte.time = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
          paramArrayOfByte.msgseq = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
          paramArrayOfByte.shmsgseq = i;
          paramArrayOfByte.msgUid = l2;
          paramArrayOfByte.selfuin = paramMessageHandler.app.getCurrentAccountUin();
          paramArrayOfByte.istroop = 1001;
          paramArrayOfByte.senderuin = String.valueOf(alof.l + l1);
          paramArrayOfByte.frienduin = String.valueOf(alof.l + l1);
          paramArrayOfByte.getBytes();
          a(paramMessageHandler, l1, i, l2, j);
          if (QLog.isColorLevel())
          {
            paramMessageHandler = new StringBuilder();
            paramMessageHandler.append("status=").append(paramArrayOfByte.isLiving).append("jumpingUrl=").append(paramArrayOfByte.jumpingUrl).append("liveWording=").append(paramArrayOfByte.msg).append("headUrl").append(paramArrayOfByte.headUrl).append("nickName").append(paramArrayOfByte.nickName).append("startLiveWordingType=").append(localMsgBody.uint32_live_wording_type.get()).append("endLiveWordingType=").append(localMsgBody.uint32_end_wording_type.get());
            QLog.i("Q.msg.MessageHandler", 2, paramMessageHandler.toString());
          }
          azqs.b(null, "dc00899", "grp_lbs", "", "msg_box", "view_live_message", 0, 0, "", "", "", "");
          return paramArrayOfByte;
        }
      }
      catch (InvalidProtocolBufferMicroException paramMessageHandler)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "decodeNearbyLiveTipMsg decode failed" + paramMessageHandler.toString());
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static MessageRecord a(List<MessageRecord> paramList, byte[] paramArrayOfByte, bbpd parambbpd)
  {
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    JSONObject localJSONObject = new JSONObject();
    paramList = paramList.iterator();
    int i = 0;
    int k = 0;
    while (paramList.hasNext())
    {
      Object localObject1 = (MessageRecord)paramList.next();
      MixedMsg.Elem localElem = new MixedMsg.Elem();
      int j;
      if (((MessageRecord)localObject1).msgtype == -1000)
      {
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).msg))
        {
          localElem.textMsg.set(((MessageRecord)localObject1).msg);
          j = i;
        }
      }
      else {
        for (;;)
        {
          Object localObject2;
          try
          {
            if (((MessageRecord)localObject1).atInfoList != null)
            {
              j = i;
              if (((MessageRecord)localObject1).atInfoList.size() > 0)
              {
                localObject2 = new JSONArray();
                localObject1 = ((MessageRecord)localObject1).atInfoList.iterator();
                j = 0;
                if (((Iterator)localObject1).hasNext())
                {
                  ((JSONArray)localObject2).put(j, ((MessageForText.AtTroopMemberInfo)((Iterator)localObject1).next()).toJsonObject());
                  j += 1;
                  continue;
                }
                localJSONObject.put("" + k, localObject2);
                j = 1;
              }
            }
            i = j;
          }
          catch (JSONException localJSONException)
          {
            QLog.e("Q.msg.MessageHandler", 1, "disc mixMsg create atInfos error:", localJSONException);
            continue;
          }
          localMsg.elems.get().add(localElem);
          k += 1;
          break;
          if (localJSONException.msgtype == -2000)
          {
            localObject2 = new RichMsg.PicRec();
            try
            {
              RichMsg.PicRec localPicRec = (RichMsg.PicRec)((RichMsg.PicRec)localObject2).mergeFrom(localJSONException.msgData);
              localElem.picMsg.set(localPicRec);
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              for (;;)
              {
                QLog.e("Q.msg.MessageHandler", 1, "mergeMixedMsgContent", localInvalidProtocolBufferMicroException);
              }
            }
          }
          else if (localInvalidProtocolBufferMicroException.msgtype == -1049)
          {
            try
            {
              MessageForReplyText localMessageForReplyText = (MessageForReplyText)localInvalidProtocolBufferMicroException;
              localObject2 = amrf.a(localMessageForReplyText.mSourceMsgInfo);
              localElem.sourceMsgInfo.set(bdhe.a((byte[])localObject2));
              if (!TextUtils.isEmpty(localMessageForReplyText.msg)) {
                localElem.textMsg.set(localMessageForReplyText.msg);
              }
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
              }
            }
          }
        }
      }
    }
    paramList = (MessageForMixedMsg)azaf.a(-1035);
    paramList.msgtype = -1035;
    paramList.msgData = localMsg.toByteArray();
    if ((parambbpd != null) && (parambbpd.jdField_a_of_type_Int == 3000)) {
      paramList.frienduin = parambbpd.jdField_a_of_type_JavaLangString;
    }
    if (i != 0) {
      bciq.a(parambbpd.jdField_a_of_type_Int, localJSONObject.toString(), paramList);
    }
    if (paramArrayOfByte != null) {
      paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", bdhe.a(paramArrayOfByte));
    }
    paramList.parse();
    return paramList;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 1 < paramString.length()))
      {
        int k = paramString.charAt(i + 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "localeCode value:" + k + ",max len:" + azah.a.length);
        }
        j = i;
        if (apsp.c(k))
        {
          j = apsp.a(k);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "---faceIndex:" + j);
          }
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append((char)(j / 128 + 65));
          localStringBuilder.append((char)(j % 128 + 65));
        }
      }
      for (int j = i + 1;; j = i)
      {
        i = j + 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, azak paramazak, long paramLong, int paramInt2)
  {
    if (paramazak == null) {
      paramQQAppInterface = null;
    }
    label334:
    do
    {
      return paramQQAppInterface;
      int j = (short)(int)paramLong;
      int k = 0xFFFF & j;
      long l;
      msg_svc.RoutingHead localRoutingHead;
      if ((paramInt1 == 9) || (paramInt1 == 13))
      {
        l = 0x0 | paramazak.jdField_a_of_type_ArrayOfByte.length << 16 | 0xA6;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><S>--->createPbSendMsgReq: routingType:" + paramInt1 + ",toUin:" + paramString + ",msgUid:" + l + ",msgSeq:" + paramLong + ",uint32Seq:" + k + ",shortSeq:" + j + ",randomNum:" + paramInt2 + ",msgContext:" + paramazak);
        }
        paramQQAppInterface = paramQQAppInterface.a();
        localRoutingHead = new msg_svc.RoutingHead();
        int i = 0;
        switch (paramInt1)
        {
        default: 
          paramInt1 = i;
        }
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label334;
        }
        return null;
        l = 0x0 | paramInt2;
        break;
        localObject = new msg_svc.TransMsg();
        ((msg_svc.TransMsg)localObject).c2c_cmd.set(paramazak.jdField_a_of_type_Int);
        ((msg_svc.TransMsg)localObject).to_uin.set(Long.valueOf(paramString).longValue());
        localRoutingHead.trans_msg.set((MessageMicro)localObject);
        paramInt1 = 1;
        continue;
        localObject = new msg_svc.Trans0x211();
        ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramazak.jdField_a_of_type_Int);
        paramString = paramString.replace("+", "");
        ((msg_svc.Trans0x211)localObject).to_uin.set(mto.a(paramString));
        localRoutingHead.trans_0x211.set((MessageMicro)localObject);
        paramInt1 = 1;
      }
      Object localObject = new msg_comm.ContentHead();
      ((msg_comm.ContentHead)localObject).pkg_num.set(1);
      ((msg_comm.ContentHead)localObject).div_seq.set(j);
      ((msg_comm.ContentHead)localObject).pkg_index.set(0);
      im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
      localMsgBody.msg_content.set(ByteStringMicro.copyFrom(paramazak.jdField_a_of_type_ArrayOfByte));
      paramString = new msg_svc.PbSendMsgReq();
      paramString.routing_head.set(localRoutingHead);
      paramString.content_head.set((MessageMicro)localObject);
      paramString.msg_body.set(localMsgBody);
      paramString.msg_seq.set(k);
      paramString.msg_rand.set(paramInt2);
      paramazak = paramQQAppInterface.a();
      paramQQAppInterface = paramString;
    } while (paramazak == null);
    paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramazak));
    return paramString;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    int i = b(paramMessageRecord.istroop, paramQQAppInterface);
    if ((i == 9) || (i == 13)) {}
    int j;
    int k;
    ayzl localayzl;
    msg_svc.RoutingHead localRoutingHead;
    do
    {
      return null;
      long l = paramMessageRecord.msgUid;
      j = (short)(int)paramMessageRecord.msgseq;
      k = azah.a(l);
      localayzl = paramQQAppInterface.a();
      localRoutingHead = new msg_svc.RoutingHead();
    } while (!a(paramQQAppInterface, paramMessageRecord, localRoutingHead));
    paramQQAppInterface = new msg_comm.ContentHead();
    paramQQAppInterface.pkg_num.set(paramMessageRecord.longMsgCount);
    paramQQAppInterface.div_seq.set(paramMessageRecord.longMsgId);
    paramQQAppInterface.pkg_index.set(paramMessageRecord.longMsgIndex);
    paramMessageRecord = new im_msg_body.MsgBody();
    paramMessageRecord.rich_text.set(paramRichText);
    paramRichText = new msg_svc.PbSendMsgReq();
    paramRichText.routing_head.set(localRoutingHead);
    paramRichText.content_head.set(paramQQAppInterface);
    paramRichText.msg_body.set(paramMessageRecord);
    paramRichText.msg_seq.set(j & 0xFFFF);
    paramRichText.msg_rand.set(k);
    if ((i != 2) && (i != 4) && (i != 21))
    {
      paramQQAppInterface = localayzl.a();
      if (paramQQAppInterface != null) {
        paramRichText.sync_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
    }
    paramRichText.msg_via.set(paramInt);
    return paramRichText;
  }
  
  private static im_msg_body.Elem a(im_msg_body.RichText paramRichText, String paramString)
  {
    im_msg_body.Text localText = new im_msg_body.Text();
    localText.str.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new im_msg_body.Elem();
    paramString.text.set(localText);
    paramRichText.elems.add(paramString);
    return paramString;
  }
  
  public static im_msg_body.RichText a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForRichText))) {
      return ((MessageForRichText)paramChatMessage).richText;
    }
    return null;
  }
  
  public static im_msg_body.RichText a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramChatMessage == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return localObject1;
      localObject1 = localObject2;
      if (!(paramChatMessage instanceof MessageForArkApp)) {
        continue;
      }
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      localObject1 = localObject2;
      if (paramChatMessage == null) {
        continue;
      }
      localObject1 = localObject2;
      if (paramChatMessage.ark_app_message == null) {
        continue;
      }
      Object localObject3 = paramChatMessage.ark_app_message.toPbData();
      localObject1 = localObject2;
      if (localObject3 == null) {
        continue;
      }
      localObject1 = localObject2;
      if (localObject3.length == 0) {
        continue;
      }
      byte[] arrayOfByte = azwm.b((byte[])localObject3);
      localObject1 = localObject2;
      if (arrayOfByte == null) {
        continue;
      }
      localObject1 = localObject2;
      if (arrayOfByte.length == 0) {
        continue;
      }
      localObject3 = new ByteArrayOutputStream();
      try
      {
        ((ByteArrayOutputStream)localObject3).write(1);
        ((ByteArrayOutputStream)localObject3).write(arrayOfByte);
        if ((!TextUtils.isEmpty(paramChatMessage.resIDForLongMsg)) && (!paramBoolean))
        {
          localObject1 = new im_msg_body.RichText();
          localObject2 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject2).general_flags.long_text_flag.set(1);
          ((im_msg_body.Elem)localObject2).general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramChatMessage.resIDForLongMsg));
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
          return localObject1;
        }
        if (paramChatMessage.ark_app_message.containStructMsg != null)
        {
          paramChatMessage = a((MessageForStructing)paramChatMessage.ark_app_message.containStructMsg);
          localObject1 = new im_msg_body.LightAppElem();
          ((im_msg_body.LightAppElem)localObject1).bytes_data.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject3).toByteArray()));
          localObject2 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject2).light_app.set((MessageMicro)localObject1);
          localObject1 = paramChatMessage;
          if (paramChatMessage == null) {
            continue;
          }
          paramChatMessage.elems.add((MessageMicro)localObject2);
          return paramChatMessage;
        }
        localObject2 = new im_msg_body.RichText();
        if (!TextUtils.isEmpty(paramChatMessage.ark_app_message.compatibleText)) {
          localObject1 = paramChatMessage.ark_app_message.compatibleText;
        }
        for (;;)
        {
          paramChatMessage = (ChatMessage)localObject2;
          if (localObject1 == null) {
            break;
          }
          paramChatMessage = (ChatMessage)localObject2;
          if (((String)localObject1).length() <= 0) {
            break;
          }
          paramChatMessage = new im_msg_body.Text();
          paramChatMessage.str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set(paramChatMessage);
          ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
          paramChatMessage = (ChatMessage)localObject2;
          break;
          paramChatMessage = paramChatMessage.getSummery();
          if ((paramChatMessage == null) || (paramChatMessage.length() == 0)) {
            localObject1 = BaseApplication.getContext().getString(2131693912);
          } else {
            localObject1 = String.format(BaseApplication.getContext().getString(2131693913), new Object[] { paramChatMessage });
          }
        }
        return null;
      }
      catch (Exception paramChatMessage) {}
    }
  }
  
  public static im_msg_body.RichText a(FunnyFaceMessage paramFunnyFaceMessage)
  {
    im_msg_body.FunFace localFunFace = new im_msg_body.FunFace();
    Object localObject;
    if (paramFunnyFaceMessage.faceId == 1)
    {
      localObject = new im_msg_body.FunFace.Turntable();
      Iterator localIterator = paramFunnyFaceMessage.turntable.uinList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((im_msg_body.FunFace.Turntable)localObject).rpt_uint64_uin_list.add(Long.valueOf(str));
      }
      ((im_msg_body.FunFace.Turntable)localObject).uint64_hit_uin.set(Long.valueOf(paramFunnyFaceMessage.turntable.hitUin).longValue());
      localFunFace.msg_turntable.set((MessageMicro)localObject);
    }
    for (;;)
    {
      paramFunnyFaceMessage = new im_msg_body.RichText();
      localObject = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject).fun_face.set(localFunFace);
      paramFunnyFaceMessage.elems.add((MessageMicro)localObject);
      return paramFunnyFaceMessage;
      if (paramFunnyFaceMessage.faceId == 2)
      {
        localObject = new im_msg_body.FunFace.Bomb();
        ((im_msg_body.FunFace.Bomb)localObject).bool_burst.set(paramFunnyFaceMessage.bomb.isBurst);
        localFunFace.msg_bomb.set((MessageMicro)localObject);
      }
    }
  }
  
  public static im_msg_body.RichText a(MarkFaceMessage paramMarkFaceMessage, String paramString, boolean paramBoolean)
  {
    Object localObject = new im_msg_body.MarketFace();
    if (paramMarkFaceMessage.sbufID != null) {
      ((im_msg_body.MarketFace)localObject).bytes_face_id.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbufID));
    }
    if ((paramBoolean) && (paramString != null)) {
      ((im_msg_body.MarketFace)localObject).bytes_face_name.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    if (paramMarkFaceMessage.sbfKey != null) {
      ((im_msg_body.MarketFace)localObject).bytes_key.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbfKey));
    }
    ((im_msg_body.MarketFace)localObject).uint32_face_info.set(paramMarkFaceMessage.cFaceInfo);
    ((im_msg_body.MarketFace)localObject).uint32_item_type.set(paramMarkFaceMessage.dwMSGItemType);
    ((im_msg_body.MarketFace)localObject).uint32_sub_type.set(paramMarkFaceMessage.cSubType);
    ((im_msg_body.MarketFace)localObject).uint32_tab_id.set(paramMarkFaceMessage.dwTabID);
    ((im_msg_body.MarketFace)localObject).uint32_media_type.set(paramMarkFaceMessage.mediaType);
    ((im_msg_body.MarketFace)localObject).uint32_image_width.set(paramMarkFaceMessage.imageWidth);
    ((im_msg_body.MarketFace)localObject).uint32_image_height.set(paramMarkFaceMessage.imageHeight);
    if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_mobileparam.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.mobileparam));
    }
    if ((paramMarkFaceMessage.resvAttr != null) && (paramMarkFaceMessage.resvAttr.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_pb_reserve.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.resvAttr));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "encodeMarketFace : mf epid = " + ((im_msg_body.MarketFace)localObject).uint32_tab_id.get() + " csubtype = " + ((im_msg_body.MarketFace)localObject).uint32_sub_type.get() + ";mediaType = " + ((im_msg_body.MarketFace)localObject).uint32_media_type.get());
    }
    paramMarkFaceMessage = new im_msg_body.Text();
    if (paramString != null) {
      paramMarkFaceMessage.str.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    paramString = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    localElem.market_face.set((MessageMicro)localObject);
    paramString.elems.add(localElem);
    localObject = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject).text.set(paramMarkFaceMessage);
    paramString.elems.add((MessageMicro)localObject);
    return paramString;
  }
  
  public static im_msg_body.RichText a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {
      return null;
    }
    return b(paramMessageForApollo);
  }
  
  public static im_msg_body.RichText a(MessageForFunnyFace paramMessageForFunnyFace)
  {
    if ((paramMessageForFunnyFace == null) || (paramMessageForFunnyFace.mFunnyFaceMessage == null)) {
      return null;
    }
    return a(paramMessageForFunnyFace.mFunnyFaceMessage);
  }
  
  public static im_msg_body.RichText a(MessageForLongTextMsg paramMessageForLongTextMsg, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramMessageForLongTextMsg == null) {
      localObject1 = localObject2;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (!paramBoolean) {
            break;
          }
          localObject1 = localObject2;
        } while (paramMessageForLongTextMsg.structingMsg == null);
        localObject3 = paramMessageForLongTextMsg.structingMsg.getXmlBytes();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject1).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject3));
      ((im_msg_body.RichMsg)localObject1).uint32_service_id.set(paramMessageForLongTextMsg.structingMsg.mMsgServiceID);
      localObject2 = new im_msg_body.RichText();
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).rich_msg.set((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject3);
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(paramMessageForLongTextMsg.structingMsg.mCompatibleText));
    Object localObject1 = new im_msg_body.Elem();
    Object localObject3 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFrom(paramMessageForLongTextMsg.structingMsg.mCompatibleText.getBytes()));
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
    ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
    return localObject2;
    paramMessageForLongTextMsg = a(paramMessageForLongTextMsg.msg, paramMessageForLongTextMsg.atInfoList);
    localObject1 = new im_msg_body.GeneralFlags();
    ((im_msg_body.GeneralFlags)localObject1).long_text_flag.set(2);
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).general_flags.set((MessageMicro)localObject1);
    paramMessageForLongTextMsg.elems.add((MessageMicro)localObject2);
    return paramMessageForLongTextMsg;
  }
  
  public static im_msg_body.RichText a(MessageForMarketFace paramMessageForMarketFace)
  {
    if ((paramMessageForMarketFace == null) || (paramMessageForMarketFace.mMarkFaceMessage == null)) {
      return null;
    }
    if (TextUtils.isEmpty(paramMessageForMarketFace.mMarkFaceMessage.faceName)) {}
    for (String str = alud.a(2131707043);; str = "[" + paramMessageForMarketFace.mMarkFaceMessage.faceName + "]")
    {
      boolean bool = true;
      if (paramMessageForMarketFace.istroop == 3000) {
        bool = false;
      }
      return a(paramMessageForMarketFace.mMarkFaceMessage, str, bool);
    }
  }
  
  public static im_msg_body.RichText a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    if (paramMessageForMixedMsg == null) {
      return null;
    }
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    int k = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    if (i < k)
    {
      Object localObject = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      int j;
      if ((localObject instanceof MessageForText))
      {
        localObject = a((MessageForText)localObject);
        if (localObject == null) {
          return null;
        }
        j = 0;
        while (j < ((im_msg_body.RichText)localObject).elems.size())
        {
          localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(j));
          j += 1;
        }
      }
      if ((localObject instanceof MessageForRichText))
      {
        localObject = ((MessageForPic)localObject).richText;
        if (localObject == null) {
          return null;
        }
        localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(0));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof MessageForReplyText))
        {
          localObject = a((MessageForReplyText)localObject);
          if (localObject != null)
          {
            j = 0;
            while (j < ((im_msg_body.RichText)localObject).elems.size())
            {
              localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(j));
              j += 1;
            }
          }
        }
      }
    }
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForQQStoryComment paramMessageForQQStoryComment)
  {
    return a(paramMessageForQQStoryComment.msg, null);
  }
  
  public static im_msg_body.RichText a(MessageForReplyText paramMessageForReplyText)
  {
    localObject2 = paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_source_msg_info");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      String str = bdhe.a(amrf.a(paramMessageForReplyText.mSourceMsgInfo));
      localObject1 = str;
      localObject2 = str;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = str;
        paramMessageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", str);
        localObject1 = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, QLog.getStackTraceString(localException));
          localObject1 = localObject2;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.", 2, "getSourceMsgInfo data = " + localObject1 + ", mSourceMsgInfo = " + paramMessageForReplyText.mSourceMsgInfo);
    }
    return a(paramMessageForReplyText);
  }
  
  public static im_msg_body.RichText a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if ((paramMessageForShakeWindow == null) || (paramMessageForShakeWindow.mShakeWindowMsg == null)) {
      return null;
    }
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.ShakeWindow localShakeWindow = new im_msg_body.ShakeWindow();
    localShakeWindow.uint32_type.set(paramMessageForShakeWindow.mShakeWindowMsg.mType);
    paramMessageForShakeWindow = new im_msg_body.Elem();
    paramMessageForShakeWindow.shake_window.set(localShakeWindow);
    localRichText.elems.add(paramMessageForShakeWindow);
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {
      localObject1 = null;
    }
    Object localObject2;
    label344:
    do
    {
      return localObject1;
      if (paramMessageForStructing.richText != null) {
        return paramMessageForStructing.richText;
      }
      localObject2 = paramMessageForStructing.structingMsg.getXmlBytes();
      if (localObject2 == null) {
        return null;
      }
      if ((paramMessageForStructing.structingMsg.mMsgServiceID != 83) && (paramMessageForStructing.structingMsg.mMsgServiceID != 108) && (paramMessageForStructing.structingMsg.mMsgServiceID != 114) && (paramMessageForStructing.structingMsg.mMsgServiceID != 116) && (paramMessageForStructing.structingMsg.mMsgServiceID != 151))
      {
        localObject1 = localObject2;
        if (paramMessageForStructing.structingMsg.mMsgServiceID != 156) {}
      }
      else
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
        {
          localObject2 = paramMessageForStructing.structingMsg.mMsgActionData;
          paramMessageForStructing.structingMsg.mMsgActionData = a(paramMessageForStructing.structingMsg.mMsgActionData);
          localObject1 = paramMessageForStructing.structingMsg.getXmlBytes();
          paramMessageForStructing.structingMsg.mMsgActionData = ((String)localObject2);
        }
      }
      localObject3 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject3).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
      ((im_msg_body.RichMsg)localObject3).uint32_service_id.set(paramMessageForStructing.structingMsg.mMsgServiceID);
      if ((paramMessageForStructing.structingMsg instanceof AbsShareMsg))
      {
        localObject1 = ((AbsShareMsg)paramMessageForStructing.structingMsg).getStructMsgItemLists();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label344;
            }
            localObject2 = (azus)((Iterator)localObject1).next();
            if ((localObject2 instanceof azut))
            {
              localObject2 = ((azut)localObject2).a;
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                if (((Iterator)localObject2).hasNext())
                {
                  azus localazus = (azus)((Iterator)localObject2).next();
                  if (!(localazus instanceof azzv)) {
                    break;
                  }
                  if (((azzv)localazus).a()) {
                    ((im_msg_body.RichMsg)localObject3).uint32_flags.set(4);
                  } else {
                    ((im_msg_body.RichMsg)localObject3).uint32_flags.set(2);
                  }
                }
              }
            }
          }
        }
      }
      localObject2 = new im_msg_body.RichText();
      localObject1 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject3);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      if (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText)) {
        paramMessageForStructing.structingMsg.mCompatibleText = paramMessageForStructing.structingMsg.mMsgUrl;
      }
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText));
    Object localObject1 = new im_msg_body.Elem();
    Object localObject3 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFrom(paramMessageForStructing.structingMsg.mCompatibleText.getBytes()));
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
    ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
    return localObject2;
  }
  
  public static im_msg_body.RichText a(MessageForText paramMessageForText)
  {
    return a(paramMessageForText.msg, paramMessageForText.atInfoList);
  }
  
  public static im_msg_body.RichText a(MessageForTroopStory paramMessageForTroopStory)
  {
    Object localObject2 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(16);
    Object localObject1 = new hummer_commelem.MsgElemInfo_servtype16();
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).uid.set(paramMessageForTroopStory.uid);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).unionID.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.unionId));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).storyID.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.storyId));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).md5.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.md5));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).thumbUrl.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.thumbUrl));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).doodleUrl.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.doodleUrl));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).videoWidth.set(paramMessageForTroopStory.videoWidth);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).videoHeight.set(paramMessageForTroopStory.videoHeight);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceName.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceName));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceActionType.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceActionType));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceActionData.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceActionData));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).ctr_version.set(paramMessageForTroopStory.ctrVersion);
    ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype16)localObject1).toByteArray()));
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject2);
    localObject2 = paramMessageForTroopStory.compatibleText;
    paramMessageForTroopStory = new im_msg_body.Text();
    paramMessageForTroopStory.str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set(paramMessageForTroopStory);
    paramMessageForTroopStory = new im_msg_body.RichText();
    paramMessageForTroopStory.elems.add((MessageMicro)localObject1);
    paramMessageForTroopStory.elems.add((MessageMicro)localObject2);
    return paramMessageForTroopStory;
  }
  
  public static im_msg_body.RichText a(MessageRecord paramMessageRecord)
  {
    Object localObject3 = null;
    Object localObject4 = paramMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info");
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    if (paramMessageRecord.msg == null)
    {
      localObject1 = "";
      localArrayList = paramMessageRecord.atInfoList;
      localObject2 = paramMessageRecord.getExtInfoFromExtStr("sens_reply_special_msg");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("sens_reply_special_at_list");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(paramMessageRecord))) {
        break label548;
      }
      localArrayList = MessageForText.getTroopMemberInfoFromExtrJson(paramMessageRecord);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        try
        {
          localSourceMsgInfo = (MessageForReplyText.SourceMsgInfo)amrf.a(bdhe.a((String)localObject4));
          if (localSourceMsgInfo == null) {
            break label543;
          }
          localObject4 = new im_msg_body.SourceMsg();
          ((im_msg_body.SourceMsg)localObject4).uint32_orig_seqs.add(Integer.valueOf((int)localSourceMsgInfo.mSourceMsgSeq));
          paramMessageRecord = a(localSourceMsgInfo.mSourceMsgText, null);
          ((im_msg_body.SourceMsg)localObject4).elems.set(paramMessageRecord.elems.get());
          if (localSourceMsgInfo.getSourceMsg() != null) {
            ((im_msg_body.SourceMsg)localObject4).bytes_src_msg.set(ByteStringMicro.copyFrom(localSourceMsgInfo.getSourceMsg()));
          }
          if (!TextUtils.isEmpty(localSourceMsgInfo.mAnonymousNickName))
          {
            paramMessageRecord = new im_msg_body.AnonymousGroupMsg();
            paramMessageRecord.str_anon_nick.set(ByteStringMicro.copyFromUtf8(localSourceMsgInfo.mAnonymousNickName));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).anon_group_msg.set(paramMessageRecord);
            ((im_msg_body.SourceMsg)localObject4).elems.add((MessageMicro)localObject1);
          }
          if (!TextUtils.isEmpty(localSourceMsgInfo.mSourceMsgTroopName)) {
            ((im_msg_body.SourceMsg)localObject4).bytes_troop_name.set(ByteStringMicro.copyFromUtf8(localSourceMsgInfo.mSourceMsgTroopName));
          }
          ((im_msg_body.SourceMsg)localObject4).uint64_sender_uin.set(localSourceMsgInfo.mSourceMsgSenderUin);
          ((im_msg_body.SourceMsg)localObject4).uint64_to_uin.set(localSourceMsgInfo.mSourceMsgToUin);
          ((im_msg_body.SourceMsg)localObject4).uint32_time.set(localSourceMsgInfo.mSourceMsgTime);
          ((im_msg_body.SourceMsg)localObject4).uint32_flag.set(localSourceMsgInfo.mSourceSummaryFlag);
          ((im_msg_body.SourceMsg)localObject4).uint32_type.set(localSourceMsgInfo.mType);
          if (localSourceMsgInfo.mRichMsg != null) {
            ((im_msg_body.SourceMsg)localObject4).bytes_richMsg.set(ByteStringMicro.copyFromUtf8(localSourceMsgInfo.mRichMsg));
          }
          if (localSourceMsgInfo.oriMsgType == 0) {
            break label538;
          }
          paramMessageRecord = new source_msg.ResvAttr();
          paramMessageRecord.uint32_ori_msgtype.set(localSourceMsgInfo.oriMsgType);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            MessageForReplyText.SourceMsgInfo localSourceMsgInfo;
            paramMessageRecord = localObject3;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.", 2, "getSourceMsgInfo exception:" + localException1.getMessage());
            }
            continue;
            localMessageRecord = paramMessageRecord;
            continue;
            paramMessageRecord = null;
          }
        }
        if (localSourceMsgInfo.origUid != 0L)
        {
          localObject1 = paramMessageRecord;
          if (paramMessageRecord == null) {
            localObject1 = new source_msg.ResvAttr();
          }
          ((source_msg.ResvAttr)localObject1).uint64_orig_uids.add(Long.valueOf(localSourceMsgInfo.origUid));
          if (localObject1 != null) {
            ((im_msg_body.SourceMsg)localObject4).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((source_msg.ResvAttr)localObject1).toByteArray()));
          }
        }
      }
      MessageRecord localMessageRecord;
      label538:
      label543:
      for (paramMessageRecord = new im_msg_body.RichText();; paramMessageRecord = null)
      {
        try
        {
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).src_msg.set((MessageMicro)localObject4);
          paramMessageRecord.elems.add((MessageMicro)localObject1);
          a(paramMessageRecord, (String)localObject2, localArrayList);
          localObject1 = paramMessageRecord;
          if (paramMessageRecord == null) {
            localObject1 = a((String)localObject2, localArrayList);
          }
          return localObject1;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localObject1 = paramMessageRecord.msg;
        break;
      }
      label548:
      localObject2 = localMessageRecord;
    }
  }
  
  public static im_msg_body.RichText a(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    im_msg_body.RichText localRichText2 = new im_msg_body.RichText();
    im_msg_body.RichText localRichText1 = localRichText2;
    if (a(localRichText2, paramString, paramArrayList) <= 0) {
      localRichText1 = null;
    }
    return localRichText1;
  }
  
  private static void a(long paramLong1, long paramLong2, int paramInt)
  {
    lfc locallfc = lfc.a();
    locallfc.a(0L, paramLong1, paramLong2);
    locallfc.a(paramInt, 2, paramLong2);
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramMessageHandler.app.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramMessageHandler.app.getCurrentAccountUin());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramMessageHandler.app.sendToService(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong1 = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
          paramLong1 = paramLong2;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramMessageHandler.app.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramMessageHandler.app.getCurrentAccountUin());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        localMsgItem.sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramMessageHandler.app.sendToService(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong1 = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
          paramLong1 = paramLong2;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    int i;
    long l1;
    int j;
    Object localObject7;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject2;
    label1915:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            msg_comm.MsgType0x210 localMsgType0x210 = new msg_comm.MsgType0x210();
            try
            {
              localMsgType0x210 = (msg_comm.MsgType0x210)localMsgType0x210.mergeFrom(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray());
              if (localMsgType0x210 == null)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 is null.");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : failed.", localException1);
                }
                localObject1 = null;
              }
              if ((!((msg_comm.MsgType0x210)localObject1).sub_msg_type.has()) || (!((msg_comm.MsgType0x210)localObject1).msg_content.has()))
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 require more info: hasType:" + ((msg_comm.MsgType0x210)localObject1).sub_msg_type.has() + ",hasMsgContent:" + ((msg_comm.MsgType0x210)localObject1).msg_content.has());
                }
              }
              else
              {
                i = ((msg_comm.MsgType0x210)localObject1).sub_msg_type.get();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 type:" + i);
                }
                switch (i)
                {
                }
              }
            }
          }
          return;
          a(paramMessageHandler, paramMsg, paramBoolean1);
          return;
          ((amcl)paramMessageHandler.app.a(18)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          a(paramMessageHandler, (msg_comm.MsgType0x210)localObject1);
          return;
          ((baam)paramMessageHandler.app.getManager(17)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          return;
          ((PublicAccountHandler)paramMessageHandler.app.a(11)).a(i, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopgetnews..troop.notification_center", 2, "decodeC2CMsgPkg_MsgType0x210, receive troop news push");
          }
          ((amdu)paramMessageHandler.app.a(20)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
          }
          Object localObject1 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          a(paramMessageHandler.app, (byte[])localObject1);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "processMsg0x210Sub0xb1");
          }
          localObject1 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          a(paramMessageHandler.app, (byte[])localObject1, false);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : subtype 0x51");
          }
          paramMessageHandler.a((msg_comm.MsgType0x210)localObject1, paramMsg);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : subtype 0x66");
          }
          paramLong = paramMsg.msg_head.from_uin.get();
          i = paramMsg.msg_head.msg_seq.get();
          l1 = paramMsg.msg_head.msg_uid.get();
          j = paramMsg.msg_head.msg_type.get();
          a(paramMessageHandler, paramLong, i, l1, j);
          paramMessageHandler = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          aivm.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramMessageHandler, paramLong, i, l1, j);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Push_PCActive_Notice_Decode", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
          }
          localObject7 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          localObject1 = null;
          localObject4 = null;
          localObject5 = null;
          try
          {
            localObject6 = new SubMsgType0x6b.MsgBody();
            ((SubMsgType0x6b.MsgBody)localObject6).mergeFrom((byte[])localObject7);
            paramLong = ((SubMsgType0x6b.MsgBody)localObject6).uint64_to_uin.get();
            if (!SettingCloneUtil.readValue(BaseApplicationImpl.getApplication(), Long.toString(paramLong), null, "qqsetting_pcactive_key", false))
            {
              if (((SubMsgType0x6b.MsgBody)localObject6).bytes_tips_content.has()) {
                localObject1 = new String(((SubMsgType0x6b.MsgBody)localObject6).bytes_tips_content.get().toByteArray(), "utf-8");
              }
              if (((SubMsgType0x6b.MsgBody)localObject6).bytes_yes_text.has()) {
                localObject4 = new String(((SubMsgType0x6b.MsgBody)localObject6).bytes_yes_text.get().toByteArray(), "utf-8");
              }
              if (((SubMsgType0x6b.MsgBody)localObject6).bytes_no_text.has()) {
                localObject5 = new String(((SubMsgType0x6b.MsgBody)localObject6).bytes_no_text.get().toByteArray(), "utf-8");
              }
              BaseApplicationImpl.getApplication().setPCActiveNotice(Long.toString(paramLong), (String)localObject1, (String)localObject5, (String)localObject4);
              localObject6 = new Intent("mqq.intent.action.PCACTIVE_TIPS");
              ((Intent)localObject6).putExtra("uin", Long.toString(paramLong));
              ((Intent)localObject6).putExtra("Message", (String)localObject1);
              ((Intent)localObject6).putExtra("lButton", (String)localObject5);
              ((Intent)localObject6).putExtra("rButton", (String)localObject4);
              if (NotifyPCActiveActivity.a == null) {
                BaseApplicationImpl.getApplication().startActivity((Intent)localObject6);
              }
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Push_PCActive_Notice_Decode", 2, "failed to get msg0x210.SubMsgType0x6b");
              }
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Push_PCActive_Notice_Decode", 2, "failed to parse msg0x210.SubMsgType0x6b");
              }
            }
          }
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush recv msg0x210.Submsgtype0x6f");
          }
          if (localUnsupportedEncodingException.msg_content != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content is null");
        return;
        localObject2 = localUnsupportedEncodingException.msg_content.get().toByteArray();
        if (localObject2 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content.toByteArray is null");
      return;
      try
      {
        localObject4 = new SubMsgType0x6f.MsgBody();
        ((SubMsgType0x6f.MsgBody)localObject4).mergeFrom((byte[])localObject2);
        localObject2 = (SubMsgType0x6f.ForwardBody)((SubMsgType0x6f.MsgBody)localObject4).rpt_msg_mod_infos.get().get(0);
        i = -1;
        if (((SubMsgType0x6f.ForwardBody)localObject2).uint32_op_type.has()) {
          i = ((SubMsgType0x6f.ForwardBody)localObject2).uint32_op_type.get();
        }
        if ((i != 2001) || (!((SubMsgType0x6f.ForwardBody)localObject2).msg_mcard_notification_like.has())) {
          break;
        }
        localObject4 = (SubMsgType0x6f.MCardNotificationLike)((SubMsgType0x6f.ForwardBody)localObject2).msg_mcard_notification_like.get();
        localObject2 = "";
        paramLong = 0L;
        j = 0;
        i = 0;
        if (((SubMsgType0x6f.MCardNotificationLike)localObject4).str_wording.has()) {
          localObject2 = ((SubMsgType0x6f.MCardNotificationLike)localObject4).str_wording.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject4).uint32_counter_new.has()) {
          i = ((SubMsgType0x6f.MCardNotificationLike)localObject4).uint32_counter_new.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject4).uint64_from_uin.has()) {
          paramLong = ((SubMsgType0x6f.MCardNotificationLike)localObject4).uint64_from_uin.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject4).uint32_counter_total.has()) {
          j = ((SubMsgType0x6f.MCardNotificationLike)localObject4).uint32_counter_total.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("msg0x210.SubMsgType0x6f", 2, "card_notification_like : wording: " + (String)localObject2 + " totalCount: " + j + " newCount: " + i + " fromUin: " + paramLong);
        }
        localObject2 = (aphz)paramMessageHandler.app.getManager(71);
        if (localObject2 != null) {
          ((aphz)localObject2).a().a((SubMsgType0x6f.MCardNotificationLike)localObject4);
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception paramMessageHandler) {}
    } while (!QLog.isColorLevel());
    QLog.d("TurnBrand", 2, "failed to get msg0x210.SubMsgType0x6f", paramMessageHandler);
    return;
    if ((i == 2002) && (((SubMsgType0x6f.ForwardBody)localObject2).msg_vip_info_notify.has()))
    {
      localObject4 = (SubMsgType0x6f.VipInfoNotify)((SubMsgType0x6f.ForwardBody)localObject2).msg_vip_info_notify.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "vip info notify: " + localObject4.toString());
      }
      paramLong = 0L;
      i = 0;
      if (((SubMsgType0x6f.VipInfoNotify)localObject4).uint64_uin.has()) {
        paramLong = ((SubMsgType0x6f.VipInfoNotify)localObject4).uint64_uin.get();
      }
      localObject2 = Long.toString(paramLong);
      if (((SubMsgType0x6f.VipInfoNotify)localObject4).uint32_vip_identify.has()) {
        i = ((SubMsgType0x6f.VipInfoNotify)localObject4).uint32_vip_identify.get();
      }
      if (!((SubMsgType0x6f.VipInfoNotify)localObject4).uint32_vip_level.has()) {
        break label8019;
      }
      j = ((SubMsgType0x6f.VipInfoNotify)localObject4).uint32_vip_level.get();
      label2120:
      if (!QLog.isColorLevel()) {
        break label8025;
      }
      QLog.d("Q.msg.MessageHandler", 2, "UIN " + (String)localObject2 + " vip info changed.");
      break label8025;
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "need pull vip info from svr. vipIdentiy=" + i + "; vipLevel=" + j);
          }
          localObject4 = ((TicketManager)paramMessageHandler.app.getManager(2)).getSkey((String)localObject2);
          ((amfs)paramMessageHandler.app.a(27)).a((String)localObject4, (String)localObject2);
          break label1915;
          if ((i == 2003) && (((SubMsgType0x6f.ForwardBody)localObject2).msg_push_lost_dev_found.has()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QFindBLE", 2, "offlinePush receive ...");
            }
            localObject2 = (SubMsgType0x6f.PushLostDevFound)((SubMsgType0x6f.ForwardBody)localObject2).msg_push_lost_dev_found.get();
            localObject4 = new Bundle();
            if (((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_msg_type.has()) {
              ((Bundle)localObject4).putInt("msgtype", ((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_msg_type.get());
            }
            if (((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_dev_time.has()) {
              ((Bundle)localObject4).putInt("devtime", ((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_dev_time.get());
            }
            if (((SubMsgType0x6f.PushLostDevFound)localObject2).uint64_din.has()) {
              ((Bundle)localObject4).putLong("din", ((SubMsgType0x6f.PushLostDevFound)localObject2).uint64_din.get());
            }
            ((ztp)paramMessageHandler.app.a(51)).a(111, (Bundle)localObject4);
            break label1915;
          }
          if ((i != 2011) || (!((SubMsgType0x6f.ForwardBody)localObject2).msg_mod_qim_friend_to_qq.has())) {
            break label1915;
          }
          localObject2 = (SubMsgType0x6f.QimFriendNotifyToQQ)((SubMsgType0x6f.ForwardBody)localObject2).msg_mod_qim_friend_to_qq.get();
          i = -1;
          if (((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).uint32_notify_type.has()) {
            i = ((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).uint32_notify_type.get();
          }
          if (QLog.isColorLevel()) {
            QLog.d("QIMNewNotifyPush_offLine", 2, "receive msg_add_notify_to_qq... " + i);
          }
          if (i == 1)
          {
            if (!((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).msg_add_notify_to_qq.has()) {
              break label1915;
            }
            localObject2 = ((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).msg_add_notify_to_qq;
            localObject4 = new QIMFollwerAdd();
            ((QIMFollwerAdd)localObject4).uin = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint64_uin.get();
            ((QIMFollwerAdd)localObject4).gender = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint32_gender.get();
            ((QIMFollwerAdd)localObject4).careSCount = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint64_cares_count.get();
            ((QIMFollwerAdd)localObject4).totalNum = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint64_storys_total_num.get();
            ((QIMFollwerAdd)localObject4).smartRemark = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).bytes_smart_remark.get().toStringUtf8();
            ((QIMFollwerAdd)localObject4).opType = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint32_op_type.get();
            ((QIMFollwerAdd)localObject4).fansCount = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint64_fans_count.get();
            ((QIMFollwerAdd)localObject4).longNick = RichStatus.parseStatus(((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).bytes_longnick.get().toByteArray()).getPlainText();
            ((QIMFollwerAdd)localObject4).upTime = ayzl.a();
            ((QIMFollwerAdd)localObject4).source = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).bytes_src_wording.get().toStringUtf8();
            ((alxr)paramMessageHandler.app.getManager(34)).b((QIMFollwerAdd)localObject4);
            break label1915;
          }
          if ((i == 2) || (i != 3) || (!((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).msg_add_not_login_frd_notify_to_qq.has())) {
            break label1915;
          }
          localObject2 = (SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).msg_add_not_login_frd_notify_to_qq.get();
          localObject4 = new QIMNotifyAddFriend();
          ((QIMNotifyAddFriend)localObject4).uin = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).uint64_uin.get();
          ((QIMNotifyAddFriend)localObject4).qqUin = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).uint64_qq_uin.get();
          ((QIMNotifyAddFriend)localObject4).nickName = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).bytes_nick.get().toStringUtf8();
          ((QIMNotifyAddFriend)localObject4).gender = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).uint32_gender.get();
          ((QIMNotifyAddFriend)localObject4).age = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).uint32_age.get();
          ((QIMNotifyAddFriend)localObject4).coverStory = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).bytes_coverstory.get().toStringUtf8();
          ((QIMNotifyAddFriend)localObject4).storyTotalNum = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).uint64_storys_total_num.get();
          ((QIMNotifyAddFriend)localObject4).wording = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).bytes_wording.get().toStringUtf8();
          i = 0;
          while (i < ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).rpt_msg_video_info.size())
          {
            localObject5 = (SubMsgType0x6f.VideoInfo)((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).rpt_msg_video_info.get(i);
            localObject6 = new QIMNotifyAddFriend.VideoInfo();
            ((QIMNotifyAddFriend.VideoInfo)localObject6).coverUrl = ((SubMsgType0x6f.VideoInfo)localObject5).bytes_video_cover_url.get().toStringUtf8();
            ((QIMNotifyAddFriend.VideoInfo)localObject6).videoVid = ((SubMsgType0x6f.VideoInfo)localObject5).bytes_vid.get().toStringUtf8();
            ((QIMNotifyAddFriend)localObject4).videoInfos.add(localObject6);
            i += 1;
          }
          ((QIMNotifyAddFriend)localObject4).pushTime = ayzl.a();
          if (QLog.isColorLevel()) {
            QLog.d("QIMNewNotifyPush_offLine", 2, "receive data= " + ((QIMNotifyAddFriend)localObject4).toString());
          }
          ((alzu)paramMessageHandler.app.getManager(257)).a((QIMNotifyAddFriend)localObject4);
          break label1915;
          if (QLog.isColorLevel()) {
            QLog.d("TurnBrand", 2, "decode recv msg0x210.Submsgtype0x6e");
          }
          localObject2 = (ambh)paramMessageHandler.app.getManager(22);
          if (localObject2 != null) {
            ((ambh)localObject2).a();
          }
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 group recmd msg");
          }
          localObject4 = new submsgtype0x67.MsgBody();
          try
          {
            ((submsgtype0x67.MsgBody)localObject4).mergeFrom(((msg_comm.MsgType0x210)localObject2).msg_content.get().toByteArray());
            if (((submsgtype0x67.MsgBody)localObject4).rpt_msg_grpinfo.has())
            {
              localObject2 = ((submsgtype0x67.MsgBody)localObject4).rpt_msg_grpinfo.get();
              localObject4 = (alvm)paramMessageHandler.app.a(3);
              if (localObject4 != null) {
                ((alvm)localObject4).a((List)localObject2);
              }
            }
            a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 mergeFrom exception: " + localException2.toString());
              }
            }
          }
          ((alzy)paramMessageHandler.app.a(47)).a(true);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          paramLong = paramMsg.msg_head.to_uin.get();
          l1 = paramMsg.msg_head.from_uin.get();
          j = paramMsg.msg_head.msg_seq.get();
          long l2 = paramMsg.msg_head.msg_uid.get();
          k = paramMsg.msg_head.msg_type.get();
          if (a(paramMessageHandler.app, localException2.msg_content.get().toByteArray(), l1, paramLong, j, k, i)) {
            paramMessageHandler.a().a("handleActivateFriendsPush2", true, 1, true, false);
          }
          a(paramMessageHandler, l1, j, l2, k);
          return;
          paramMsg.msg_head.from_uin.get();
          i = paramMsg.msg_head.msg_seq.get();
          paramMsg.msg_head.msg_uid.get();
          j = paramMsg.msg_head.msg_type.get();
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.MessageHandler", 4, "decodeC2CMsgPkg_MsgType0x210 receive 0x7c push message, seq = " + i + ", submsgtype:" + j);
          }
          paramMsg = new submsgtype0x7c.MsgBody();
          try
          {
            paramMsg.mergeFrom(localException2.msg_content.get().toByteArray());
            paramLong = paramMsg.uint64_uin.get();
            if (!paramMessageHandler.app.getCurrentAccountUin().equals(String.valueOf(paramLong))) {
              break;
            }
            ((ayxx)paramMessageHandler.app.getManager(94)).a(paramMsg, 1);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.msg.MessageHandler", 2, "parse 0x7c push msg error", paramMessageHandler);
        return;
        try
        {
          localObject4 = new SubMsgType0x87.MsgBody();
          ((SubMsgType0x87.MsgBody)localObject4).mergeFrom(localException2.msg_content.get().toByteArray());
          if (((SubMsgType0x87.MsgBody)localObject4).rpt_msg_msg_notify.has()) {
            ahle.a(paramMessageHandler.app, (SubMsgType0x87.MsgBody)localObject4);
          }
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.MessageHandler", 2, "offline push parse 0x210 subtype 0x87 msg error", localException3);
            }
          }
        }
        if (paramBoolean2) {
          break;
        }
        paramMsg = new Submsgtype0x8a.ReqBody();
        try
        {
          paramMsg.mergeFrom(localException3.msg_content.get().toByteArray());
          a(paramMessageHandler.app, paramMsg, 0L, false);
          return;
        }
        catch (Exception paramMessageHandler) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b offline msg, prase reqBody error");
        return;
        localObject4 = new SubMsgType0x9b.MsgBody();
        try
        {
          ((SubMsgType0x9b.MsgBody)localObject4).mergeFrom(localException3.msg_content.get().toByteArray());
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
        }
        catch (InvalidProtocolBufferMicroException paramMessageHandler)
        {
          paramMessageHandler.printStackTrace();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xaa receive 0xaa push message");
        }
        localObject4 = new SubMsgType0xaa.MsgBody();
        try
        {
          ((SubMsgType0xaa.MsgBody)localObject4).mergeFrom(localException3.msg_content.get().toByteArray());
          ((aspf)paramMessageHandler.app.getManager(156)).a((SubMsgType0xaa.MsgBody)localObject4, true);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xaa, prase msgBody error");
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xae receive 0xae push message");
        }
        localObject4 = new SubMsgType0xae.MsgBody();
        try
        {
          ((SubMsgType0xae.MsgBody)localObject4).mergeFrom(localException4.msg_content.get().toByteArray());
          if ((((SubMsgType0xae.MsgBody)localObject4).uint32_type.has()) && (((SubMsgType0xae.MsgBody)localObject4).uint32_type.get() == 2))
          {
            paramLong = ((SubMsgType0xae.MsgBody)localObject4).msg_persons_may_know.fixed32_timestamp.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "handlePushRecommend receive push time=" + paramLong);
            }
            localObject4 = ((SubMsgType0xae.MsgBody)localObject4).msg_persons_may_know.rpt_msg_friend_list.get();
            if ((localObject4 != null) && (((List)localObject4).size() > 0))
            {
              ArrayList localArrayList = new ArrayList(((List)localObject4).size());
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = (SubMsgType0xae.PersonMayKnow)((Iterator)localObject4).next();
                localObject6 = new PushRecommend();
                if (((SubMsgType0xae.PersonMayKnow)localObject5).uint64_uin.has()) {
                  ((PushRecommend)localObject6).uin = Long.toString(((SubMsgType0xae.PersonMayKnow)localObject5).uint64_uin.get());
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_name.has()) {
                  ((PushRecommend)localObject6).nick = new String(((SubMsgType0xae.PersonMayKnow)localObject5).bytes_name.get().toByteArray());
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).uint32_age.has()) {
                  ((PushRecommend)localObject6).age = ((short)((SubMsgType0xae.PersonMayKnow)localObject5).uint32_age.get());
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).uint32_sex.has()) {
                  ((PushRecommend)localObject6).gender = ((short)((SubMsgType0xae.PersonMayKnow)localObject5).uint32_sex.get());
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_main_reason.has()) {
                  ((PushRecommend)localObject6).recommendReason = new String(((SubMsgType0xae.PersonMayKnow)localObject5).bytes_main_reason.get().toByteArray());
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_alghrithm.has()) {
                  ((PushRecommend)localObject6).algBuffer = ((SubMsgType0xae.PersonMayKnow)localObject5).bytes_alghrithm.get().toByteArray();
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_soure_reason.has()) {
                  ((PushRecommend)localObject6).sourceReason = new String(((SubMsgType0xae.PersonMayKnow)localObject5).bytes_soure_reason.get().toByteArray());
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).uint32_source.has()) {
                  ((PushRecommend)localObject6).fromSource = ((SubMsgType0xae.PersonMayKnow)localObject5).uint32_source.get();
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).msg_android_source.has())
                {
                  localObject7 = (SubMsgType0xae.AddFriendSource)((SubMsgType0xae.PersonMayKnow)localObject5).msg_android_source.get();
                  if (localObject7 != null)
                  {
                    if (((SubMsgType0xae.AddFriendSource)localObject7).uint32_source.has()) {
                      ((PushRecommend)localObject6).sourceId = ((SubMsgType0xae.AddFriendSource)localObject7).uint32_source.get();
                    }
                    if (((SubMsgType0xae.AddFriendSource)localObject7).uint32_sub_source.has()) {
                      ((PushRecommend)localObject6).subSourceId = ((SubMsgType0xae.AddFriendSource)localObject7).uint32_sub_source.get();
                    }
                  }
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_msg.has()) {
                  ((PushRecommend)localObject6).wzryVerifyStr = new String(((SubMsgType0xae.PersonMayKnow)localObject5).bytes_msg.get().toByteArray());
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).uint32_game_source.has()) {
                  ((PushRecommend)localObject6).wzrySourceId = ((SubMsgType0xae.PersonMayKnow)localObject5).uint32_game_source.get();
                }
                if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_role_name.has()) {
                  ((PushRecommend)localObject6).wzryGameNick = new String(((SubMsgType0xae.PersonMayKnow)localObject5).bytes_role_name.get().toByteArray());
                }
                ((PushRecommend)localObject6).timestamp = paramLong;
                localArrayList.add(localObject6);
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label4682;
          }
        }
        catch (Exception localException5)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "recv 0x210_0xae, prase msgBody error");
          }
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
        }
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xb3 receive 0xaa push message");
        label4682:
        paramMsg = ((abtl)paramMessageHandler.a("businessbase_processor")).a(localException5.msg_content.get().toByteArray());
        if (TextUtils.isEmpty(paramMsg)) {
          break;
        }
        paramBoolean1 = ((alto)paramMessageHandler.app.getManager(51)).b(paramMsg);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xb3 isFriend=" + paramBoolean1 + ", uin=" + paramMsg);
        }
        if (paramBoolean1) {
          break;
        }
        QLog.d("Q.msg.MessageHandler", 1, "handleMsgType0x210SubMsgType0xb3 not friend, getDetail");
        ((FriendListHandler)paramMessageHandler.app.a(1)).a(paramMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xc5 receive 0xc5 push message");
        }
        ((abtl)paramMessageHandler.a("businessbase_processor")).a(localException5.msg_content.get().toByteArray(), paramMsg.msg_head.msg_time.get());
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xee receive 0xee push message");
        }
        ((abtl)paramMessageHandler.a("businessbase_processor")).b(localException5.msg_content.get().toByteArray(), paramMsg.msg_head.msg_time.get());
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
        localObject4 = (abtl)paramMessageHandler.a("businessbase_processor");
        localObject5 = new MsgInfo();
        ((MsgInfo)localObject5).lFromUin = paramMsg.msg_head.from_uin.get();
        ((MsgInfo)localObject5).shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
        ((MsgInfo)localObject5).uMsgTime = paramMsg.msg_head.msg_time.get();
        ((MsgInfo)localObject5).uRealMsgTime = paramMsg.msg_head.msg_time.get();
        ((MsgInfo)localObject5).lMsgUid = paramMsg.msg_head.msg_uid.get();
        ((MsgInfo)localObject5).shMsgType = ((short)paramMsg.msg_head.msg_type.get());
        ((abtl)localObject4).a(localException5.msg_content.get().toByteArray(), 2, (MsgInfo)localObject5);
        a(paramMessageHandler, ((MsgInfo)localObject5).lFromUin, ((MsgInfo)localObject5).shMsgSeq, ((MsgInfo)localObject5).lMsgUid, ((MsgInfo)localObject5).shMsgType);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210_0x102 offline ");
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
        localObject4 = (abtl)paramMessageHandler.a("businessbase_processor");
        localObject5 = new MsgInfo();
        ((MsgInfo)localObject5).lFromUin = paramMsg.msg_head.from_uin.get();
        ((MsgInfo)localObject5).shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
        ((MsgInfo)localObject5).uMsgTime = paramMsg.msg_head.msg_time.get();
        ((MsgInfo)localObject5).uRealMsgTime = paramMsg.msg_head.msg_time.get();
        ((MsgInfo)localObject5).lMsgUid = paramMsg.msg_head.msg_uid.get();
        ((MsgInfo)localObject5).shMsgType = ((short)paramMsg.msg_head.msg_type.get());
        ((abtl)localObject4).a(localException5.msg_content.get().toByteArray(), 2);
        a(paramMessageHandler, ((MsgInfo)localObject5).lFromUin, ((MsgInfo)localObject5).shMsgSeq, ((MsgInfo)localObject5).lMsgUid, ((MsgInfo)localObject5).shMsgType);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7  push message");
        }
        paramLong = paramMsg.msg_head.from_uin.get();
        i = paramMsg.msg_head.msg_seq.get();
        l1 = paramMsg.msg_head.msg_uid.get();
        j = paramMsg.msg_head.msg_type.get();
        int k = paramMsg.msg_head.msg_time.get();
        paramMsg = new amlj(paramLong, i, l1, j, k, false);
        ((abtl)paramMessageHandler.a("businessbase_processor")).a(localException5.msg_content.get().toByteArray(), paramMsg);
        a(paramMessageHandler, paramLong, i, l1, j);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby.tag_nearby_live_tip", 4, "decodeC2CMsgPkg_MsgType0x210 receive 0xcb push message");
        }
        localObject3 = a(paramMessageHandler, localException5.msg_content.get().toByteArray(), paramMsg);
        if ((localObject3 == null) || (alww.a(paramMessageHandler.app, (MessageRecord)localObject3, true)) || (((MessageRecord)localObject3).msgtype != -2053)) {
          break;
        }
        paramMsg = (MessageForNearbyLiveTip)localObject3;
        if ((MessageForNearbyLiveTip.isHuayangTip(paramMsg.jumpingUrl)) && (!MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramMsg.jumpingUrl)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.nearby.tag_nearby_live_tip", 2, "decodeC2CMsgPkg_MsgType0x210 discard a not support huayang tips message, jumpUrl=" + paramMsg.jumpingUrl);
          return;
        }
        if (paramMsg.isLiving)
        {
          paramMessageHandler.app.a().a((MessageRecord)localObject3, paramMessageHandler.app.getCurrentAccountUin());
          return;
        }
        localObject4 = paramMessageHandler.app.a().a(paramMsg.frienduin, paramMsg.istroop);
        if (localObject4 != null)
        {
          paramMessageHandler.app.a().a(paramMsg.frienduin, paramMsg.istroop, ((MessageRecord)localObject4).uniseq, paramMsg.msgData);
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).add(paramMsg);
          paramMessageHandler.app.a().e((List)localObject3);
          return;
        }
        paramMessageHandler.app.a().a((MessageRecord)localObject3, paramMessageHandler.app.getCurrentAccountUin());
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xfe push message");
        }
        paramLong = paramMsg.msg_head.from_uin.get();
        i = paramMsg.msg_head.msg_seq.get();
        l1 = paramMsg.msg_head.msg_uid.get();
        j = paramMsg.msg_head.msg_type.get();
        ((MsgBoxInterFollowManager)paramMessageHandler.app.getManager(202)).decode0xfeInteractAndFollowMsg(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
        a(paramMessageHandler, paramLong, i, l1, j);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xd7 push message");
        }
        paramLong = paramMsg.msg_head.from_uin.get();
        i = paramMsg.msg_head.msg_seq.get();
        l1 = paramMsg.msg_head.msg_uid.get();
        j = paramMsg.msg_head.msg_type.get();
        ((MsgBoxInterFollowManager)paramMessageHandler.app.getManager(202)).decode0xd7InteractAndFollowMsg(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
        a(paramMessageHandler, paramLong, i, l1, j);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xdc push message");
        }
        localObject4 = (aknx)paramMessageHandler.app.getManager(153);
        if (localObject4 != null) {
          ((aknx)localObject4).a(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
        QLog.d("ApolloPushManager", 1, "recv action push message 0x210_0xe8, [C2C.offline]");
        try
        {
          paramMsg = new submsgtype0xe8.MsgBody();
          paramMsg.mergeFrom(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
          if (!paramMsg.msg_item.has()) {
            break;
          }
          paramMsg = (apollo_push_msgInfo.STPushMsgElem)paramMsg.msg_item.get();
          if (paramMessageHandler.app == null) {
            break;
          }
          paramMessageHandler = (akos)paramMessageHandler.app.getManager(227);
          paramMessageHandler.a(0, paramMsg);
          paramMessageHandler.c(paramMsg);
          paramMessageHandler.b(paramMsg);
          return;
        }
        catch (Exception paramMessageHandler)
        {
          paramMessageHandler.printStackTrace();
          QLog.e("ApolloPushManager", 1, "[msg0x210.uSubMsgType == 0xe8], errInfo->" + paramMessageHandler.getMessage());
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: AIO Feed offline messageRecord: 0xf4");
      }
      paramLong = paramMsg.msg_head.from_uin.get();
      paramMsg = ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray();
      paramMessageHandler = (uls)paramMessageHandler.app.getManager(253);
      paramMessageHandler.a(paramMessageHandler.a(paramMsg, String.valueOf(paramLong)));
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0xfb");
      }
      try
      {
        localObject4 = new NowPushMsgList.MsgBody();
        ((NowPushMsgList.MsgBody)localObject4).mergeFrom(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
        localObject3 = ((NowPushMsgList.MsgBody)localObject4).rpt_now_push_msg.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (NowPushMsgList.NowPushMsg)((Iterator)localObject3).next();
          if (paramMessageHandler.app != null) {
            ((avuz)paramMessageHandler.app.getManager(266)).b((NowPushMsgList.NowPushMsg)localObject4);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 0xfb " + ((NowPushMsgList.NowPushMsg)localObject4).uint32_switch.get() + "  uint32_task_id " + ((NowPushMsgList.NowPushMsg)localObject4).uint32_task_id.get() + "  uint32_type " + ((NowPushMsgList.NowPushMsg)localObject4).uint32_type.get() + "  uint64_start_time " + ((NowPushMsgList.NowPushMsg)localObject4).uint64_start_time.get() + "  uint64_end_time " + ((NowPushMsgList.NowPushMsg)localObject4).uint64_end_time.get() + " app=" + paramMessageHandler.app);
          }
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      }
      catch (Exception paramMessageHandler)
      {
        QLog.e("Q.msg.MessageHandler", 1, "[msg0x210.uSubMsgType == 0xfb], errInfo->" + paramMessageHandler.getMessage());
        return;
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x111");
      }
      try
      {
        localObject3 = ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray();
        alwd.a(paramMessageHandler.app, (byte[])localObject3);
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception paramMessageHandler)
      {
        QLog.e("Q.msg.MessageHandler", 1, "[msg0x210.uSubMsgType == 0x111], errInfo->" + paramMessageHandler.getMessage());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x11e");
      }
      try
      {
        localObject3 = ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray();
        localObject4 = (FriendListHandler)paramMessageHandler.app.a(1);
        if (localObject4 != null) {
          ((FriendListHandler)localObject4).a((byte[])localObject3);
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception paramMessageHandler)
      {
        QLog.e("Q.msg.MessageHandler", 1, "[msg0x210.uSubMsgType == 0x11e], errInfo->" + paramMessageHandler.getMessage());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked, info: 0x11f");
      }
      Object localObject3 = ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray();
      atmp.a(paramMessageHandler.app, (byte[])localObject3, paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), true);
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "offline push decodeC2CMsgPkg_MsgType0x127 invoked, info: 0x127");
      }
      localObject3 = ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray();
      localObject4 = ((baph)paramMessageHandler.app.getManager(339)).a(4);
      if (localObject4 != null) {
        ((baps)localObject4).a(paramMessageHandler.app, (byte[])localObject3, paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), true);
      }
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x100");
      }
      if (paramMessageHandler.app == null) {
        break;
      }
      localObject3 = aphv.a(paramMessageHandler.app, ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray(), paramMsg);
      paramMessageHandler.app.a().a((MessageRecord)localObject3, paramMessageHandler.app.getCurrentAccountUin());
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0x104  push message");
      }
      try
      {
        paramLong = paramMsg.msg_head.from_uin.get();
        i = paramMsg.msg_head.msg_seq.get();
        l1 = paramMsg.msg_head.msg_uid.get();
        j = paramMsg.msg_head.msg_type.get();
        paramMsg = new submsgtype0x104.MsgBody();
        paramMsg.mergeFrom(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
        paramMessageHandler.app.a().a().a(paramMsg);
        a(paramMessageHandler, paramLong, i, l1, j);
        return;
      }
      catch (Exception paramMessageHandler) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.msg.MessageHandler", 2, "onLinePush receive 0x210_0x104 wrong:" + paramMessageHandler.toString());
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x108");
      }
      if (paramMessageHandler.app == null) {
        break;
      }
      localObject3 = apiz.a(paramMessageHandler.app, ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray(), paramMsg);
      paramMessageHandler.app.a().a((MessageRecord)localObject3, paramMessageHandler.app.getCurrentAccountUin());
      a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, "submsgtype0x116 decodeC2CMsgPkg_MsgType0x210 receive 0x116 push message");
      return;
      localObject3 = ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "troopFormLog offLinePush receive submsgtype0x119 decodeC2CMsgPkg_MsgType0x210 receive 0x119 push message");
      }
      try
      {
        localObject4 = new SubMsgType0x119.MsgBody();
        ((SubMsgType0x119.MsgBody)localObject4).mergeFrom((byte[])localObject3);
        if (!baic.a(paramMsg.msg_head.msg_seq.get()))
        {
          baic.a(paramMessageHandler.app, (SubMsgType0x119.MsgBody)localObject4);
          QLog.d("Q.msg.MessageHandler", 1, "troopFormLog isPushMessageDuplicated ");
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception paramMessageHandler)
      {
        QLog.e("Q.msg.MessageHandler", 1, "troopFormLog offLinePush receive submsgtype0x119 decodeC2CMsgPkg_MsgType0x210 receive 0x119 push message, errInfo->" + paramMessageHandler.getMessage());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleC2COfflinePushMsgGrayTip subType = " + i);
      }
      localObject3 = ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray();
      localObject4 = new MsgInfo();
      ((MsgInfo)localObject4).lFromUin = paramMsg.msg_head.from_uin.get();
      ((MsgInfo)localObject4).shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
      ((MsgInfo)localObject4).uMsgTime = paramMsg.msg_head.msg_time.get();
      ((MsgInfo)localObject4).uRealMsgTime = paramMsg.msg_head.msg_time.get();
      ((MsgInfo)localObject4).lMsgUid = paramMsg.msg_head.msg_uid.get();
      ((MsgInfo)localObject4).shMsgType = ((short)paramMsg.msg_head.msg_type.get());
      paramMessageHandler = paramMessageHandler.app;
      if (i == 290) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        aspz.a(paramMessageHandler, (byte[])localObject3, (MsgInfo)localObject4, paramBoolean1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "extendfriend limitchat offLinePush receive submsgtype0x128 decodeC2CMsgPkg_MsgType0x210 receive 0x128 push message");
      }
      try
      {
        localObject4 = new submsgtype0x128.MsgBody();
        ((submsgtype0x128.MsgBody)localObject4).mergeFrom(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
        ((aqbe)paramMessageHandler.app.a(127)).a((submsgtype0x128.MsgBody)localObject4);
        QLog.d("Q.msg.MessageHandlerExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception paramMessageHandler)
      {
        QLog.e("Q.msg.MessageHandler", 1, "troopFormLog offLinePush receive submsgtype match chat0x128 decodeC2CMsgPkg_MsgType0x210 receive 0x128 push message, errInfo->" + paramMessageHandler.getMessage());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "offline push decodeC2CMsgPkg_MsgType0x210 invoked. info: 0x133");
      }
      try
      {
        localObject3 = ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray();
        localObject4 = (ahjp)paramMessageHandler.app.a(169);
        if (localObject4 != null) {
          ((ahjp)localObject4).a((byte[])localObject3);
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception paramMessageHandler)
      {
        QLog.e("Q.msg.MessageHandler", 1, "[msg0x210.uSubMsgType == 0x133], errInfo->" + paramMessageHandler.getMessage());
        return;
      }
      label8019:
      j = 0;
      break label2120;
      label8025:
      if (i == 0) {
        if (j == 0) {
          break label1915;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, SlaveMasterMsg paramSlaveMasterMsg)
  {
    Object localObject1 = new SubMsgType0x4.MsgBody();
    try
    {
      localObject2 = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject1).mergeFrom(paramSlaveMasterMsg.vOrigMsg);
      if (!((SubMsgType0x4.MsgBody)localObject2).msg_not_online_file.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
      return;
    }
    im_msg_body.NotOnlineFile localNotOnlineFile = (im_msg_body.NotOnlineFile)((SubMsgType0x4.MsgBody)localObject2).msg_not_online_file.get();
    localObject1 = null;
    if (((SubMsgType0x4.MsgBody)localObject2).file_image_info.has()) {
      localObject1 = (hummer_resv_21.FileImgInfo)((SubMsgType0x4.MsgBody)localObject2).file_image_info.get();
    }
    Object localObject2 = new ArrayList();
    msg_comm.Msg localMsg = new msg_comm.Msg();
    localMsg.msg_head.msg_uid.set(paramMsgInfo.lMsgUid);
    localMsg.msg_head.msg_time.set(paramMsgInfo.uRealMsgTime);
    localMsg.msg_head.from_uin.set(paramSlaveMasterMsg.lFromUin);
    localMsg.msg_head.msg_seq.set((int)paramSlaveMasterMsg.uSeq);
    paramMessageHandler.app.a().a(paramMessageHandler, (List)localObject2, localMsg, localNotOnlineFile, String.valueOf(paramSlaveMasterMsg.lToUin), true, false, -100L, -1, (hummer_resv_21.FileImgInfo)localObject1);
  }
  
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, int paramInt1, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("<---decodeC2CMsgPkg_OfflineFile : ");
    localStringBuilder.append(" c2cCmd:").append(paramInt1).append(";friendUin:").append(paramLong1).append(";isReaded:").append(paramBoolean1).append(";isPullRoam:").append(paramBoolean2).append(";isSelfSender:").append(paramBoolean3).append(";\n");
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OfflineFile return null:hasBody:" + paramMsg.msg_body.has() + "hasRichT:" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has());
      }
    }
    label899:
    label1114:
    for (;;)
    {
      return;
      Object localObject1 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      Object localObject2 = (im_msg_body.NotOnlineFile)((im_msg_body.RichText)localObject1).not_online_file.get();
      if (!((im_msg_body.RichText)localObject1).not_online_file.has())
      {
        localStringBuilder.append("hasNotOnlineFile:").append(((im_msg_body.RichText)localObject1).not_online_file.has()).append(";hasUUID:").append(((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.has());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
        }
      }
      else if ((paramInt1 == 169) || (paramInt1 == 243))
      {
        if (!paramBoolean4)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant>offlineFile come: c2cCmd[" + paramInt1 + "]");
          }
          paramMessageHandler.app.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject2, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2, paramInt2, null);
        }
      }
      else
      {
        paramMsg = null;
        String str = new String(((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8() + l1);
        localObject1 = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8();
        localStringBuilder.append("     NotOnLineFile info : serverPath:").append((String)localObject1).append(";fileKey :").append(str).append(";");
        if (!paramMessageHandler.a().a(str))
        {
          str = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.get().toStringUtf8();
          localStringBuilder.append("strFileName:").append(str).append(";");
          paramLong1 = ((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.get();
          if ((paramInt1 == 241) || (azah.a(str, paramInt1)))
          {
            paramMessageHandler = new RichMsg.PicRec();
            paramMessageHandler.localPath.set((String)localObject1);
            paramMessageHandler.size.set(paramLong1);
            paramMessageHandler.type.set(1);
            paramMessageHandler.isRead.set(false);
            paramMessageHandler.uuid.set((String)localObject1);
            paramMessageHandler.serverStorageSource.set("ftn");
            paramMessageHandler.version.set(5);
            paramMessageHandler.isReport.set(0);
            paramMsg = (MessageForPic)azaf.a(-2000);
            paramMsg.msgtype = -2000;
            paramMsg.msgData = paramMessageHandler.toByteArray();
            paramMsg.parse();
            paramList.add(paramMsg);
            paramMsg = null;
            localStringBuilder.append("protocolStr:").append(paramMsg).append(";");
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label1114;
          }
          QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
          return;
          if ((paramInt1 != 242) && (!azah.b(str, paramInt1))) {
            break;
          }
          if ((str != null) && (!str.equals("")))
          {
            if (!str.contains("_")) {}
            for (paramMsg = str.substring(0, str.length() - 4);; paramMsg = str.substring(str.lastIndexOf("_") + 1, str.length() - 4))
            {
              paramMsg = l2 + paramMsg;
              localStringBuilder.append("c2cCmd:0xf2;key:").append(paramMsg).append(";");
              if (paramBoolean4) {
                break label899;
              }
              if (!azuj.e(paramMsg)) {
                break;
              }
              localStringBuilder.append("DuplicateKey:").append(paramMsg).append(";");
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
              }
              azuj.d(paramMsg);
              return;
            }
            azuj.c(paramMsg);
          }
          for (;;)
          {
            paramMsg = bays.a((String)localObject1, paramLong1, 2, false, (String)localObject1, null, "ftn");
            localObject2 = new RichMsg.PttRec();
            ((RichMsg.PttRec)localObject2).localPath.set((String)localObject1);
            ((RichMsg.PttRec)localObject2).size.set(paramLong1);
            ((RichMsg.PttRec)localObject2).type.set(2);
            ((RichMsg.PttRec)localObject2).uuid.set((String)localObject1);
            ((RichMsg.PttRec)localObject2).isRead.set(false);
            ((RichMsg.PttRec)localObject2).serverStorageSource.set("ftn");
            ((RichMsg.PttRec)localObject2).isReport.set(0);
            ((RichMsg.PttRec)localObject2).version.set(5);
            paramLong1 = System.currentTimeMillis() / 1000L;
            ((RichMsg.PttRec)localObject2).msgRecTime.set(paramLong1);
            ((RichMsg.PttRec)localObject2).msgTime.set(l1);
            localObject1 = (MessageForPtt)azaf.a(-2002);
            ((MessageForPtt)localObject1).msgtype = -2002;
            ((MessageForPtt)localObject1).msgData = ((RichMsg.PttRec)localObject2).toByteArray();
            ((MessageForPtt)localObject1).parse();
            paramList.add(localObject1);
            bavt.a(paramMessageHandler.app, 1, false, 4);
            break;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "offline ptt no filename");
            }
          }
          localStringBuilder.append("rcv a repeated offline file push msg");
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg)
  {
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    im_msg_body.RichText localRichText;
    Object localObject6;
    do
    {
      return;
      localRichText = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      localObject6 = (im_msg_body.Ptt)localRichText.ptt.get();
      if ((localRichText.ptt.has()) && (((im_msg_body.Ptt)localObject6).uint32_file_type.has()) && ((((im_msg_body.Ptt)localObject6).uint32_file_type.get() == 4) || (((im_msg_body.Ptt)localObject6).uint32_file_type.get() == 6)) && (((im_msg_body.Ptt)localObject6).bytes_file_uuid.has())) {
        break;
      }
    } while (!QLog.isColorLevel());
    paramMessageHandler = new StringBuilder("<---decodeC2CMsgPkg_PTT return null:");
    if (localObject6 == null) {
      paramMessageHandler.append(" ptt is null.");
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandler", 2, paramMessageHandler.toString());
      return;
      paramMessageHandler.append(" HasileType:").append(((im_msg_body.Ptt)localObject6).uint32_file_type.has()).append(" fileType:").append(((im_msg_body.Ptt)localObject6).uint32_file_type.get()).append(" hasUUID:").append(((im_msg_body.Ptt)localObject6).bytes_file_uuid.has());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : decodeC2CMsgPkg_PTT. fileType : " + ((im_msg_body.Ptt)localObject6).uint32_file_type.get());
    }
    int i4;
    long l1;
    Object localObject2;
    Object localObject7;
    Object localObject1;
    int k;
    label360:
    int i2;
    int i5;
    int i6;
    Object localObject4;
    long l2;
    if (baam.a(paramMessageHandler.app))
    {
      i4 = 1;
      l1 = -1L;
      localObject2 = "";
      if (!((im_msg_body.Ptt)localObject6).bytes_reserve.has()) {
        break label1988;
      }
      localObject7 = ((im_msg_body.Ptt)localObject6).bytes_reserve.get().toByteArray();
      if ((localObject7 == null) || (localObject7.length <= 1)) {
        break label1988;
      }
      i = localObject7[0];
      localObject1 = "";
      k = 0;
      j = 0;
      i = 0;
      n = 0;
      m = 0;
      i1 = 1;
      if (i1 >= localObject7.length - 1) {
        break label865;
      }
      i2 = localObject7[i1];
      i1 += 1;
      i5 = bdqa.a((byte[])localObject7, i1);
      i6 = i1 + 2;
      if (i2 != 3) {
        break label514;
      }
      localObject4 = new byte[i5];
      bdqa.a((byte[])localObject4, 0, (byte[])localObject7, i6, i5);
      l2 = bdqa.a((byte[])localObject4, 0);
      if (l2 > 0L) {
        l1 = l2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : TimeStamp in d0 :" + l1);
      }
      localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
    }
    label486:
    Object localObject5;
    label514:
    Object localObject8;
    Object localObject3;
    for (;;)
    {
      i1 = i6 + i5;
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break label360;
      i4 = 0;
      break;
      if (i2 == 9)
      {
        localObject4 = new byte[i5];
        bdqa.a((byte[])localObject4, 0, (byte[])localObject7, i6, i5);
        n = bdml.b(bdeu.a(bdqa.a((byte[])localObject4, 0)));
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else if (i2 == 8)
      {
        localObject4 = new byte[i5];
        bdqa.a((byte[])localObject4, 0, (byte[])localObject7, i6, i5);
        m = (int)bdqa.a((byte[])localObject4, 0);
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
      }
      else
      {
        if (i2 != 10) {
          break label1973;
        }
        localObject5 = new byte[i5];
        bdqa.a((byte[])localObject5, 0, (byte[])localObject7, i6, i5);
        localObject8 = new ptt_reserve.ReserveStruct();
        localObject4 = localObject2;
        int i3 = k;
        i2 = j;
        i1 = i;
        try
        {
          ((ptt_reserve.ReserveStruct)localObject8).mergeFrom((byte[])localObject5);
          localObject4 = localObject2;
          i3 = k;
          i2 = j;
          i1 = i;
          i = ((ptt_reserve.ReserveStruct)localObject8).uint32_change_voice.get();
          localObject4 = localObject2;
          i3 = k;
          i2 = j;
          i1 = i;
          j = ((ptt_reserve.ReserveStruct)localObject8).uint32_redpack_type.get();
          localObject4 = localObject2;
          i3 = k;
          i2 = j;
          i1 = i;
          k = ((ptt_reserve.ReserveStruct)localObject8).uint32_autototext_voice.get();
          localObject4 = localObject2;
          i3 = k;
          i2 = j;
          i1 = i;
          localObject5 = ((ptt_reserve.ReserveStruct)localObject8).bytes_voice_text_abs.get().toStringUtf8();
          localObject2 = localObject1;
          localObject4 = localObject5;
          i3 = k;
          i2 = j;
          i1 = i;
          if (((ptt_reserve.ReserveStruct)localObject8).bytes_redpack_score_id.has())
          {
            localObject4 = localObject5;
            i3 = k;
            i2 = j;
            i1 = i;
            localObject2 = ((ptt_reserve.ReserveStruct)localObject8).bytes_redpack_score_id.get().toStringUtf8();
          }
          localObject1 = localObject5;
        }
        catch (Exception localException1)
        {
          localObject3 = localObject1;
          localObject1 = localObject4;
          k = i3;
          j = i2;
          i = i1;
        }
      }
    }
    label865:
    int i1 = j;
    int j = n;
    int n = m;
    int m = j;
    j = i;
    int i = i1;
    for (;;)
    {
      if (((im_msg_body.Ptt)localObject6).bytes_down_para.has())
      {
        localObject4 = ((im_msg_body.Ptt)localObject6).bytes_down_para.get();
        if (localObject4 == null) {}
      }
      for (localObject4 = ((ByteStringMicro)localObject4).toStringUtf8();; localObject4 = "") {
        for (;;)
        {
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            i1 = 1;
            azqs.b(paramMessageHandler.app, "CliOper", "", "", "0X80060E4", "0X80060E4", i1, 0, "", "", "", "8.3.5");
            localObject7 = ((im_msg_body.Ptt)localObject6).bytes_file_uuid.get().toStringUtf8();
            localObject5 = ((im_msg_body.Ptt)localObject6).bytes_file_name.get().toStringUtf8();
            localObject8 = bdhe.a(((im_msg_body.Ptt)localObject6).bytes_file_md5.get().toByteArray());
          }
          try
          {
            if (!((String)localObject5).contains("_"))
            {
              localObject5 = ((String)localObject5).substring(0, ((String)localObject5).length() - 4);
              localObject5 = l3 + "_" + (String)localObject5;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_PTT isPttSuffix offfile key：" + (String)localObject5 + " fileUuid:" + (String)localObject7);
              }
              localObject5 = new RichMsg.PttRec();
              ((RichMsg.PttRec)localObject5).localPath.set((String)localObject7);
              ((RichMsg.PttRec)localObject5).size.set(((im_msg_body.Ptt)localObject6).uint32_file_size.get());
              ((RichMsg.PttRec)localObject5).type.set(2);
              ((RichMsg.PttRec)localObject5).uuid.set((String)localObject7);
              ((RichMsg.PttRec)localObject5).isRead.set(false);
              ((RichMsg.PttRec)localObject5).serverStorageSource.set("pttcenter");
              ((RichMsg.PttRec)localObject5).isReport.set(0);
              ((RichMsg.PttRec)localObject5).version.set(5);
              ((RichMsg.PttRec)localObject5).pttFlag.set(i4);
              ((RichMsg.PttRec)localObject5).autototext_voice.set(k);
              ((RichMsg.PttRec)localObject5).sttText.set((String)localObject3);
              l2 = System.currentTimeMillis() / 1000L;
              long l4 = paramMsg.msg_head.msg_time.get();
              ((RichMsg.PttRec)localObject5).msgRecTime.set(l2);
              ((RichMsg.PttRec)localObject5).msgTime.set(l4);
              ((RichMsg.PttRec)localObject5).voiceType.set(n);
              ((RichMsg.PttRec)localObject5).voiceLength.set(m);
              ((RichMsg.PttRec)localObject5).voiceChangeFlag.set(j);
              ((RichMsg.PttRec)localObject5).redpack_type.set(i);
              if (!TextUtils.isEmpty((CharSequence)localObject8)) {
                ((RichMsg.PttRec)localObject5).md5.set((String)localObject8);
              }
              if (QLog.isColorLevel()) {
                QLog.d("RecordParams", 2, "<---decodeC2CMsgPkg_PTT voiceType：" + n + " voiceLengh:" + m);
              }
              i = azah.a(paramMessageHandler.app, String.valueOf(l3));
              ((RichMsg.PttRec)localObject5).longPttVipFlag.set(i);
              ((RichMsg.PttRec)localObject5).directUrl.set((String)localObject4);
              localObject4 = azaf.a(-2002);
              ((MessageRecord)localObject4).msgtype = -2002;
              ((MessageRecord)localObject4).msgData = ((RichMsg.PttRec)localObject5).toByteArray();
              ((MessageRecord)localObject4).time = l1;
              localObject5 = (MessageForPtt)localObject4;
              localObject6 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
              if (QLog.isColorLevel())
              {
                localObject7 = new StringBuilder().append("<---decodePBMsgElems: elems: ");
                if (localObject6 != null) {
                  break label1765;
                }
                localObject3 = null;
                QLog.d("Q.msg.MessageHandler", 2, localObject3);
              }
              if ((localObject6 == null) || (((List)localObject6).size() <= 0)) {
                break;
              }
              localObject3 = ((List)localObject6).iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject7 = (im_msg_body.Elem)((Iterator)localObject3).next();
              } while ((!((im_msg_body.Elem)localObject7).general_flags.has()) || (!((im_msg_body.Elem)localObject7).general_flags.bytes_pb_reserve.has()));
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              try
              {
                localObject6 = new generalflags.ResvAttr();
                ((generalflags.ResvAttr)localObject6).mergeFrom(((im_msg_body.Elem)localObject7).general_flags.bytes_pb_reserve.get().toByteArray());
                if (((generalflags.ResvAttr)localObject6).bytes_pb_ptt_waveform.has())
                {
                  localObject7 = new ptt_waveform.PttWaveform();
                  ((ptt_waveform.PttWaveform)localObject7).mergeFrom(((generalflags.ResvAttr)localObject6).bytes_pb_ptt_waveform.get().toByteArray());
                  ((MessageForPtt)localObject5).waveformArray = bdjf.a((ptt_waveform.PttWaveform)localObject7);
                  if (QLog.isColorLevel())
                  {
                    localObject6 = new StringBuilder();
                    localObject7 = ((MessageForPtt)localObject5).waveformArray;
                    j = localObject7.length;
                    i = 0;
                    if (i < j)
                    {
                      ((StringBuilder)localObject6).append(localObject7[i]);
                      ((StringBuilder)localObject6).append(";");
                      i += 1;
                      continue;
                      i1 = 2;
                      break;
                      localObject5 = ((String)localObject5).substring(((String)localObject5).lastIndexOf("_") + 1, ((String)localObject5).length() - 4);
                      continue;
                      localException2 = localException2;
                      localException2.printStackTrace();
                      continue;
                      label1765:
                      localObject3 = Integer.valueOf(((List)localObject6).size());
                      continue;
                    }
                    QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_PTT, waveformArray = " + ((StringBuilder)localObject6).toString());
                  }
                }
              }
              catch (Throwable localThrowable) {}
            }
            if ((localException2.waveformArray == null) || (localException2.waveformArray.length == 0)) {
              localException2.buileDefaultWaveform();
            }
            localException2.parse();
            paramList.add(localObject4);
            if (localRichText.elems.has())
            {
              paramList = localRichText.elems.get().iterator();
              while (paramList.hasNext())
              {
                localObject3 = (im_msg_body.Elem)paramList.next();
                if ((((im_msg_body.Elem)localObject3).common_elem.has()) && (21 == ((im_msg_body.Elem)localObject3).common_elem.uint32_service_type.get()))
                {
                  ArrayList localArrayList = new ArrayList();
                  localArrayList.add(localObject4);
                  aoiy.a(paramMsg, (im_msg_body.Elem)localObject3, localArrayList, paramMessageHandler.app);
                }
              }
            }
            ajfi.b((String)localObject1, (MessageRecord)localObject4);
            return;
          }
        }
      }
      label1973:
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
      break label486;
      label1988:
      localObject3 = "";
      localObject1 = "";
      k = 0;
      i = 0;
      j = 0;
      m = 0;
      n = 0;
      l1 = -1L;
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    msg_comm.AppShareInfo localAppShareInfo = (msg_comm.AppShareInfo)paramMsg.appshare_info.get();
    long l1;
    Object localObject1;
    Object localObject2;
    if (paramMsg.appshare_info.has())
    {
      l1 = localAppShareInfo.appshare_id.get() & 0xFFFFFFFF;
      localObject1 = (msg_comm.PluginInfo)localAppShareInfo.appshare_resource.get();
      if ((!localAppShareInfo.appshare_resource.has()) || (localObject1 == null) || (paramBoolean)) {
        break label1890;
      }
      localObject1 = bdff.a((msg_comm.PluginInfo)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared appShareID:" + ((AppShareID)localObject1).toString());
      }
      localObject2 = (AppShareID)paramMessageHandler.a().a(AppShareID.class, "strPkgName=?", new String[] { ((AppShareID)localObject1).strPkgName });
      if (localObject2 == null)
      {
        paramMessageHandler.a().a((awge)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Persist DB appid = " + ((AppShareID)localObject1).strPkgName);
        }
        paramMessageHandler.app.a().a(((AppShareID)localObject1).strPkgName, (AppShareID)localObject1);
      }
    }
    label301:
    label569:
    label1878:
    label1887:
    label1890:
    for (int i = 1;; i = 0)
    {
      Object localObject3;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))
      {
        localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
        paramMsg = null;
        localObject2 = BaseApplication.getContext().getString(2131719930);
        Iterator localIterator = ((List)localObject1).iterator();
        paramBoolean = false;
        localObject3 = null;
        bool1 = false;
        if (localIterator.hasNext())
        {
          localObject1 = (im_msg_body.Elem)localIterator.next();
          bool2 = ((im_msg_body.Elem)localObject1).text.has();
          bool3 = ((im_msg_body.Elem)localObject1).not_online_image.has();
          if (!bool3) {
            break label1887;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        if (bool2) {
          bool1 = true;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared hasText:" + bool2 + ",hasNotOnlineImage:" + bool3);
          }
          int j;
          Object localObject4;
          if (bool3)
          {
            localObject1 = (im_msg_body.NotOnlineImage)((im_msg_body.Elem)localObject1).not_online_image.get();
            j = ((im_msg_body.NotOnlineImage)localObject1).file_len.get();
            if (!((im_msg_body.NotOnlineImage)localObject1).download_path.has()) {
              break label1878;
            }
            localObject4 = ((im_msg_body.NotOnlineImage)localObject1).download_path.get().toStringUtf8();
            localObject1 = localObject4;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: serverPath:" + (String)localObject4);
            }
          }
          for (localObject1 = localObject4;; localObject1 = null)
          {
            if (localObject1 != null)
            {
              localObject3 = new RichMsg.PicRec();
              localObject4 = ((RichMsg.PicRec)localObject3).localPath;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                ((PBStringField)localObject4).set((String)localObject2);
                ((RichMsg.PicRec)localObject3).size.set(j);
                ((RichMsg.PicRec)localObject3).type.set(1);
                localObject4 = ((RichMsg.PicRec)localObject3).uuid;
                if (localObject1 == null) {
                  break label773;
                }
                localObject2 = localObject1;
                ((PBStringField)localObject4).set((String)localObject2);
                localObject2 = bays.a((String)localObject1, j, 1, false, (String)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2);
                }
              }
            }
            for (localObject1 = localObject3;; localObject1 = localObject3)
            {
              localObject3 = localObject1;
              for (;;)
              {
                break label301;
                if ((((AppShareID)localObject1).uiNewVer != ((AppShareID)localObject2).uiNewVer) || (Math.abs(((AppShareID)localObject2).updateTime - ((AppShareID)localObject1).updateTime) > 86400000L))
                {
                  paramMessageHandler.a().b((awge)localObject2);
                  paramMessageHandler.a().a((awge)localObject1);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Update DB appid = " + ((AppShareID)localObject1).strPkgName);
                  break;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Not need update DB appid = " + ((AppShareID)localObject1).strPkgName);
                break;
                localObject2 = "";
                break label526;
                localObject2 = "";
                break label569;
                if (bool2)
                {
                  localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject1).text.get();
                  paramMsg = ((im_msg_body.Text)localObject1).str.get().toStringUtf8();
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared actionUrl:" + paramMsg + ",hasLink:" + ((im_msg_body.Text)localObject1).link.has() + ",str:" + ((im_msg_body.Text)localObject1).str.has() + ",strC:" + ((im_msg_body.Text)localObject1).str.get().toStringUtf8());
                    QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared : bytes:" + ((im_msg_body.Text)localObject1).str.get().size() + ",cont:" + ((im_msg_body.Text)localObject1).str.get() + ",content:" + Arrays.toString(((im_msg_body.Text)localObject1).str.get().toByteArray()));
                  }
                }
                else if (((im_msg_body.Elem)localObject1).custom_face.has())
                {
                  Object localObject6 = (im_msg_body.CustomFace)((im_msg_body.Elem)localObject1).custom_face.get();
                  localObject1 = ((im_msg_body.CustomFace)localObject6).str_file_path.get();
                  localObject2 = ((im_msg_body.CustomFace)localObject6).str_shortcut.get();
                  localObject3 = ((im_msg_body.CustomFace)localObject6).str_big_url.get();
                  localObject4 = ((im_msg_body.CustomFace)localObject6).str_orig_url.get();
                  String str = ((im_msg_body.CustomFace)localObject6).str_thumb_url.get();
                  ((im_msg_body.CustomFace)localObject6).str_400_url.get();
                  long l2 = ((im_msg_body.CustomFace)localObject6).uint32_file_id.get();
                  long l3 = ((im_msg_body.CustomFace)localObject6).uint32_file_type.get();
                  long l4 = ((im_msg_body.CustomFace)localObject6).uint32_server_ip.get();
                  long l5 = ((im_msg_body.CustomFace)localObject6).uint32_server_port.get();
                  long l6 = ((im_msg_body.CustomFace)localObject6).uint32_useful.get();
                  Object localObject7 = ((im_msg_body.CustomFace)localObject6).bytes_md5.get().toByteArray();
                  Object localObject5 = ((im_msg_body.CustomFace)localObject6).bytes_signature.get().toByteArray();
                  ((im_msg_body.CustomFace)localObject6).bytes_buffer.get().toByteArray();
                  localObject6 = ((im_msg_body.CustomFace)localObject6).bytes_flag.get().toByteArray();
                  localObject7 = bdhe.a((byte[])localObject7);
                  localObject5 = bdhe.a((byte[])localObject5);
                  localObject6 = bdhe.a((byte[])localObject6);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgElems: decode CustomFace, dump customFace info: filePath:" + (String)localObject1 + ", shortCut:" + (String)localObject2 + ", fileID:" + (l2 & 0xFFFFFFFF) + ", fileType:" + (l3 & 0xFFFFFFFF) + ", serverIP:" + (l4 & 0xFFFFFFFF) + ", serverPort" + (l5 & 0xFFFFFFFF) + ", useful" + (l6 & 0xFFFFFFFF) + ",md5:" + (String)localObject7 + ",signature:" + (String)localObject5 + ",flag:" + (String)localObject6 + ",downURLBig:" + (String)localObject3 + ",downURLOri:" + (String)localObject4 + ",downURLThum:" + str);
                  }
                  localObject1 = "http://quntu.3g.qq.com/cgi/svr/chatimg/get?pic=" + (String)localObject1 + "&gid=" + paramLong1 + "&time=" + paramLong2 + "&msfid=" + paramMessageHandler.app.getCurrentAccountUin();
                  localObject3 = new RichMsg.PicRec();
                  localObject4 = ((RichMsg.PicRec)localObject3).localPath;
                  if (localObject1 != null)
                  {
                    localObject2 = localObject1;
                    ((PBStringField)localObject4).set((String)localObject2);
                    ((RichMsg.PicRec)localObject3).size.set(0L);
                    ((RichMsg.PicRec)localObject3).type.set(1);
                    localObject4 = ((RichMsg.PicRec)localObject3).uuid;
                    if (localObject1 == null) {
                      break label1528;
                    }
                  }
                  label1528:
                  for (localObject2 = localObject1;; localObject2 = "")
                  {
                    ((PBStringField)localObject4).set((String)localObject2);
                    localObject2 = bays.a((String)localObject1, 0L, 1, false, (String)localObject1);
                    paramBoolean = true;
                    break;
                    localObject2 = "";
                    break label1455;
                  }
                  if ((paramBoolean) && (!bool1))
                  {
                    paramMsg = (MessageForPic)azaf.a(-2000);
                    paramMsg.msgtype = -2000;
                    paramMsg.msgData = ((RichMsg.PicRec)localObject3).toByteArray();
                    paramMsg.msg = ((String)localObject2);
                    paramMsg.parse();
                    paramList.add(paramMsg);
                  }
                  for (;;)
                  {
                    if (i == 0) {
                      paramMessageHandler.a(Long.valueOf(l1));
                    }
                    do
                    {
                      return;
                      if ((!paramBoolean) && (bool1))
                      {
                        paramMessageHandler = (MessageForText)azaf.a(-1000);
                        paramMessageHandler.msgtype = -1000;
                        paramMessageHandler.msg = paramMsg;
                        paramList.add(paramMessageHandler);
                        return;
                      }
                    } while (paramMsg == null);
                    localObject1 = paramMsg.trim();
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: hasPicCnt:" + paramBoolean + ",hasTextCnt:" + bool1);
                    }
                    paramMessageHandler.d(String.valueOf(bdff.b(l1)));
                    paramMsg = bdex.a(localAppShareInfo.appshare_cookie.get().toByteArray());
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2 + ",opType:" + paramMsg.jdField_b_of_type_Int);
                    }
                    localObject1 = bdex.a((String)localObject2, (String)localObject1, l1, paramMsg.jdField_a_of_type_JavaLangString);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared : content:" + (String)localObject2 + ",encodeMsg:" + (String)localObject1);
                    }
                    localObject2 = azaf.a(paramMsg.jdField_b_of_type_Int);
                    ((MessageRecord)localObject2).msgtype = paramMsg.jdField_b_of_type_Int;
                    ((MessageRecord)localObject2).msg = ((String)localObject1);
                    paramList.add(localObject2);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has())) {}
    do
    {
      return;
      if (paramMsg.content_head.has()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMessagePackage: msg doesn't has the contentHead.");
    return;
    Object localObject = (msg_comm.ContentHead)paramMsg.content_head.get();
    if ((((msg_comm.ContentHead)localObject).auto_reply.has()) && (((msg_comm.ContentHead)localObject).auto_reply.get() == 1)) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("<---decodeC2CMsgPkg_Buddy:elems size:").append(((List)localObject).size()).append(" isAutoReply:").append(paramBoolean2);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      if (!paramBoolean2) {
        break label308;
      }
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      paramMessageHandler = BaseApplication.getContext().getString(2131690361);
      paramMsg = new azaa().a((List)localObject);
      if (TextUtils.isEmpty(paramMsg)) {
        break;
      }
      paramMessageHandler = paramMessageHandler + " " + paramMsg;
      paramMsg = azaf.a(-10000);
      paramMsg.msgtype = -10000;
      paramMsg.msg = paramMessageHandler;
      paramList.add(paramMsg);
      return;
    }
    label308:
    a(paramMessageHandler, paramList, paramMsg, true, paramBoolean1, null);
  }
  
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211");
    }
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    int i;
    label461:
    label477:
    label634:
    long l1;
    label527:
    label572:
    label751:
    do
    {
      Object localObject2;
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject2 = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
              i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "]");
              }
              switch (i)
              {
              case 5: 
              case 6: 
              case 10: 
              case 11: 
              case 12: 
              case 14: 
              case 15: 
              case 16: 
              default: 
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "] is not implemented");
                return;
              }
            }
            catch (Exception paramMessageHandler) {}
            if (QLog.isColorLevel())
            {
              QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", paramMessageHandler);
              return;
              paramList = new SubMsgType0x3.MsgBody();
              int j;
              for (;;)
              {
                try
                {
                  paramList.mergeFrom((byte[])localObject2);
                  if (!paramList.msg_fail_notify.has()) {
                    break label572;
                  }
                  i = 0;
                  paramList = (SubMsgType0x3.FailNotify)paramList.msg_fail_notify.get();
                  if (!paramList.uint32_sessionid.has()) {
                    break label461;
                  }
                  j = paramList.uint32_sessionid.get();
                  if (!paramList.uint32_retCode.has()) {
                    break label477;
                  }
                  paramInt = paramList.uint32_retCode.get();
                  if (!paramList.bytes_reason.has()) {
                    break label527;
                  }
                  paramList = new String(paramList.bytes_reason.get().toStringUtf8());
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : FailNotify sessionId[" + j + "], retCode[" + paramInt + "], reason[" + paramList + "]");
                  }
                  paramMessageHandler.app.a().a(String.valueOf(paramLong1), j, paramInt, paramList);
                  return;
                }
                catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x3] failed", paramMessageHandler);
                return;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failNotify has not sessionId");
                return;
                paramInt = i;
                if (QLog.isColorLevel())
                {
                  QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], failNotify has not RetCode");
                  paramInt = i;
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], failNotify has not reason");
                  }
                  paramList = "";
                }
              }
              if (paramList.msg_progress_notify.has())
              {
                i = 0;
                paramList = (SubMsgType0x3.ProgressNotify)paramList.msg_progress_notify.get();
                if (paramList.uint32_sessionid.has())
                {
                  j = paramList.uint32_sessionid.get();
                  if (!paramList.uint32_progress.has()) {
                    break label751;
                  }
                  paramInt = paramList.uint32_progress.get();
                  if (!paramList.uint32_average_speed.has()) {
                    break label801;
                  }
                }
                for (i = paramList.uint32_average_speed.get();; i = 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify sessionId[" + j + "], progress[" + paramInt + "], speed[" + i + "]");
                  }
                  paramMessageHandler.app.a().a(String.valueOf(paramLong1), j, paramInt, i);
                  return;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has not sessionId");
                  return;
                  paramInt = i;
                  if (!QLog.isColorLevel()) {
                    break label634;
                  }
                  QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], progressNotify has not Progress");
                  paramInt = i;
                  break label634;
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], progressNotify has not AverageSpeed");
                  }
                }
              }
              if (QLog.isColorLevel())
              {
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has neither failNotify not progressNotify");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant>offlineFile come: cmd[0x211, 0x4]");
                }
                localObject1 = new SubMsgType0x4.MsgBody();
                SubMsgType0x4.MsgBody localMsgBody;
                try
                {
                  localMsgBody = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject1).mergeFrom((byte[])localObject2);
                  if (localMsgBody.msg_not_online_file.has()) {
                    break label943;
                  }
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
                  return;
                }
                catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                if (QLog.isColorLevel())
                {
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
                  return;
                  localObject2 = (im_msg_body.NotOnlineFile)localMsgBody.msg_not_online_file.get();
                  localObject1 = null;
                  if (localMsgBody.file_image_info.has()) {
                    localObject1 = (hummer_resv_21.FileImgInfo)localMsgBody.file_image_info.get();
                  }
                  if (paramBoolean4)
                  {
                    paramMessageHandler = new MessageRecord();
                    paramLong2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
                    l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
                    paramMessageHandler.msg = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.get().toStringUtf8();
                    paramMessageHandler.senderuin = Long.toString(l1);
                    paramMessageHandler.msgtype = -2005;
                    paramMessageHandler.frienduin = Long.toString(paramLong1);
                    paramMessageHandler.time = paramLong2;
                    if (localObject1 != null)
                    {
                      paramMessageHandler.saveExtInfoToExtStr("file_pic_width", String.valueOf(((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.get()));
                      paramMessageHandler.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.get()));
                      QLog.i("Q.msg.MessageHandler", 1, "Insert ThumbSize toMsg height[" + ((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.get() + "], width[" + ((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.get() + "]");
                    }
                    paramList.add(paramMessageHandler);
                    return;
                  }
                  paramMessageHandler.app.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject2, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2, paramInt, (hummer_resv_21.FileImgInfo)localObject1);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<dataline> message come: cmd[0x211, 0x7]");
                  }
                  paramList = new SubMsgType0x7.MsgBody();
                  try
                  {
                    paramList = (SubMsgType0x7.MsgBody)paramList.mergeFrom((byte[])localObject2);
                    if (!paramBoolean4)
                    {
                      ((alqo)paramMessageHandler.app.a(8)).a(paramMsg, paramList);
                      return;
                    }
                  }
                  catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                }
              }
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("Q.msg.MessageHandler", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x7] failed", paramMessageHandler);
        return;
        paramLong1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        paramInt = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        paramLong2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        paramList = null;
        if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has()) {
          localObject1 = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).toByteArray();
        }
        try
        {
          paramMsg = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).sig.get().toByteArray();
          paramList = (List<MessageRecord>)localObject1;
          if (paramMsg != null)
          {
            arbs.a(String.valueOf(paramLong1), paramMsg);
            paramList = (List<MessageRecord>)localObject1;
          }
        }
        catch (Exception paramList)
        {
          for (;;)
          {
            long l2;
            paramList = (List<MessageRecord>)localObject1;
          }
        }
        paramMessageHandler.app.a().a(paramLong1, paramInt, paramLong2, l1, paramList, (byte[])localObject2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<dataline printer> message come: cmd[0x211, 0x9]");
        }
        paramList = new C2CType0x211_SubC2CType0x9.MsgBody();
        try
        {
          paramList = (C2CType0x211_SubC2CType0x9.MsgBody)paramList.mergeFrom((byte[])localObject2);
          ((alqo)paramMessageHandler.app.a(8)).a(paramMsg, paramList);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.MessageHandler", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x9] failed", paramMessageHandler);
      return;
      paramLong1 = paramMsg.msg_head.from_uin.get();
      paramLong2 = paramMsg.msg_head.to_uin.get();
      paramInt = paramMsg.msg_head.msg_seq.get();
      l1 = paramMsg.msg_head.msg_uid.get();
      i = paramMsg.msg_head.msg_type.get();
      l2 = paramMsg.msg_head.msg_time.get();
      ((ztp)paramMessageHandler.app.a(51)).a(paramLong1, paramLong2, paramInt, l1, i, "im_push.msg_push", (byte[])localObject2);
    } while (!QLog.isColorLevel());
    label801:
    label943:
    QLog.d("Q.msg.MessageHandler", 2, "device msg push, receive 0x11,0xd msg, fromuin2:" + paramLong1 + ",touin:" + paramLong2 + ", msg seq:" + paramInt + ",msg_uid:" + l1 + ",msg_time:" + l2 + ",msgtype:" + i);
  }
  
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, azaj paramazaj, ayzj paramayzj)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int j;
    if ((((msg_comm.MsgHead)localObject1).msg_type.get() == 529) && (((msg_comm.MsgHead)localObject1).c2c_cmd.get() == 6))
    {
      j = 1;
      if ((((msg_comm.MsgHead)localObject1).c2c_tmp_msg_head.has()) && (paramMsg.msg_body.has()) && ((j != 0) || (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))) {
        break label94;
      }
    }
    for (;;)
    {
      return;
      j = 0;
      break;
      label94:
      Object localObject4 = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localObject1).c2c_tmp_msg_head.get();
      int i = ((msg_comm.C2CTmpMsgHead)localObject4).c2c_type.get();
      int k = ((msg_comm.C2CTmpMsgHead)localObject4).service_type.get();
      if ((!paramayzj.d) && (paramazaj.jdField_a_of_type_Int == 1006))
      {
        localObject1 = ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get();
        if ((!((msg_comm.C2CTmpMsgHead)localObject4).from_phone.has()) || (localObject1 == null) || (((String)localObject1).equals("+0")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Temp2 : contact fromPhoneNum error : " + ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get());
          }
        }
        else {
          bdgc.a(paramMessageHandler.app, ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get(), paramayzj.e + "");
        }
      }
      else
      {
        localObject3 = null;
        localObject1 = localObject3;
        if (!paramayzj.d)
        {
          localObject1 = localObject3;
          if (((msg_comm.C2CTmpMsgHead)localObject4).sig.has())
          {
            localObject1 = ((msg_comm.C2CTmpMsgHead)localObject4).sig.get().toByteArray();
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.msg.MessageHandler", 4, "tempHead.sig.get()----> sig:" + bdhe.a((byte[])localObject1) + ",length:" + localObject1.length);
            }
          }
        }
        if (localObject1 != null) {}
        switch (paramazaj.jdField_a_of_type_Int)
        {
        default: 
          localObject3 = (abty)paramMessageHandler.app.a().a().a(paramazaj.jdField_a_of_type_Int);
          if (localObject3 != null) {
            ((abty)localObject3).a(paramayzj, (byte[])localObject1);
          }
          label588:
          k = 0;
          i = k;
          if (paramMsg.content_head.has())
          {
            i = k;
            if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.has()) {
              if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.get() != 1) {
                break label1439;
              }
            }
          }
          break;
        }
        label1439:
        for (i = 1;; i = 0)
        {
          localObject1 = null;
          if (j == 0) {
            localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
          }
          if (i == 0) {
            break label1445;
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramMessageHandler = (im_msg_body.Text)((im_msg_body.Elem)((List)localObject1).get(0)).text.get();
          if (paramayzj.jdField_b_of_type_Boolean) {
            break;
          }
          paramMessageHandler = BaseApplication.getContext().getString(2131690361) + " " + paramMessageHandler.str.get().toStringUtf8();
          paramMsg = azaf.a(-10000);
          paramMsg.msgtype = -10000;
          paramMsg.msg = paramMessageHandler;
          paramList.add(paramMsg);
          return;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          bdqa.a((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.a().a(String.valueOf(paramayzj.e), (byte[])localObject3);
          break label588;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          bdqa.a((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.a().b(String.valueOf(paramayzj.e), (byte[])localObject3);
          break label588;
          paramMessageHandler.app.a().c(String.valueOf(paramayzj.e), (byte[])localObject1);
          break label588;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          bdqa.a((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.a().e(String.valueOf(paramayzj.e), (byte[])localObject3);
          break label588;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          bdqa.a((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.a().f(String.valueOf(paramayzj.e), (byte[])localObject3);
          break label588;
          paramMessageHandler.app.a().g(String.valueOf(paramayzj.e), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().h(String.valueOf(paramayzj.e), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().i(String.valueOf(paramayzj.e), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().j(String.valueOf(paramayzj.e), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().m(String.valueOf(paramayzj.e), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().o(String.valueOf(paramayzj.e), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().l(String.valueOf(paramayzj.e), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().k(String.valueOf(paramayzj.e), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().a(String.valueOf(paramayzj.e), String.valueOf(paramayzj.jdField_a_of_type_Long), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().b(String.valueOf(paramayzj.e), String.valueOf(paramayzj.jdField_a_of_type_Long), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().c(String.valueOf(paramayzj.e), String.valueOf(paramayzj.jdField_a_of_type_Long), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().a(String.valueOf(paramayzj.e), String.valueOf(paramayzj.jdField_a_of_type_Long), (byte[])localObject1, false);
          break label588;
          if (!paramayzj.i) {
            break label588;
          }
          paramMessageHandler.app.a().d(String.valueOf(paramayzj.e), String.valueOf(paramayzj.jdField_a_of_type_Long), (byte[])localObject1);
          break label588;
          paramMessageHandler.app.a().e(String.valueOf(paramayzj.e), String.valueOf(paramayzj.jdField_a_of_type_Long), (byte[])localObject1);
          break label588;
        }
        label1445:
        if (paramazaj != null) {
          if ((((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get() == 529) && (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get() == 6))
          {
            paramayzj = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
            localObject1 = new im_msg_body.TmpPtt();
            try
            {
              paramayzj = (im_msg_body.TmpPtt)((im_msg_body.TmpPtt)localObject1).mergeFrom(paramayzj);
              int m;
              int n;
              if ((paramayzj != null) && (paramayzj.uint32_file_type.has()) && (paramayzj.uint32_file_type.get() == 4) && (paramayzj.bytes_file_uuid.has()))
              {
                localObject1 = paramayzj.bytes_file_uuid.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Temp2 : ptt uuid:" + (String)localObject1);
                }
                localObject4 = new RichMsg.PttRec();
                ((RichMsg.PttRec)localObject4).localPath.set(paramayzj.bytes_file_uuid.get().toStringUtf8());
                ((RichMsg.PttRec)localObject4).size.set(paramayzj.uint32_file_size.get());
                ((RichMsg.PttRec)localObject4).type.set(2);
                ((RichMsg.PttRec)localObject4).uuid.set((String)localObject1);
                ((RichMsg.PttRec)localObject4).isRead.set(false);
                ((RichMsg.PttRec)localObject4).serverStorageSource.set("pttcenter");
                ((RichMsg.PttRec)localObject4).isReport.set(0);
                ((RichMsg.PttRec)localObject4).version.set(5);
                ((RichMsg.PttRec)localObject4).pttFlag.set(0);
                i = 0;
                k = i;
                if (paramayzj.uint32_user_type.has())
                {
                  j = paramayzj.uint32_user_type.get();
                  if (j != 1)
                  {
                    k = i;
                    if (j != 2) {}
                  }
                  else
                  {
                    k = j;
                  }
                }
                m = 0;
                i = 0;
                n = 0;
                j = 0;
                localObject3 = "";
                localObject1 = localObject3;
                if (paramayzj.bytes_pb_reserve.has())
                {
                  localObject1 = new ptt_reserve.ReserveStruct();
                  j = n;
                  i = m;
                }
              }
              try
              {
                ((ptt_reserve.ReserveStruct)localObject1).mergeFrom(paramayzj.bytes_pb_reserve.get().toByteArray());
                j = n;
                i = m;
                m = ((ptt_reserve.ReserveStruct)localObject1).uint32_change_voice.get();
                j = n;
                i = m;
                n = ((ptt_reserve.ReserveStruct)localObject1).uint32_autototext_voice.get();
                j = n;
                i = m;
                localObject1 = ((ptt_reserve.ReserveStruct)localObject1).bytes_voice_text_abs.get().toStringUtf8();
                i = m;
                j = n;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  long l1;
                  long l2;
                  Object localObject2 = localObject3;
                }
              }
              ((RichMsg.PttRec)localObject4).longPttVipFlag.set(k);
              l1 = System.currentTimeMillis() / 1000L;
              l2 = paramMsg.msg_head.msg_time.get();
              ((RichMsg.PttRec)localObject4).msgRecTime.set(l1);
              ((RichMsg.PttRec)localObject4).msgTime.set(l2);
              ((RichMsg.PttRec)localObject4).voiceChangeFlag.set(i);
              ((RichMsg.PttRec)localObject4).busiType.set(paramayzj.uint32_busi_type.get());
              ((RichMsg.PttRec)localObject4).autototext_voice.set(j);
              ((RichMsg.PttRec)localObject4).sttText.set((String)localObject1);
              localObject1 = azaf.a(-2002);
              ((MessageRecord)localObject1).msgtype = -2002;
              ((MessageRecord)localObject1).msgData = ((RichMsg.PttRec)localObject4).toByteArray();
              ((MessageForPtt)localObject1).parse();
              if ((paramayzj.uint64_msg_id.has()) && (paramayzj.uint64_msg_id.get() != 0L)) {
                ((MessageRecord)localObject1).saveExtInfoToExtStr("pa_msgId", paramayzj.uint64_msg_id.get() + "");
              }
              aoiy.a(paramMsg, (MessageRecord)localObject1, paramMessageHandler.app);
              bgac.a(paramazaj, paramMsg, (MessageRecord)localObject1);
              paramList.add(localObject1);
              return;
            }
            catch (InvalidProtocolBufferMicroException paramayzj)
            {
              for (;;)
              {
                paramayzj.printStackTrace();
                paramayzj = null;
              }
            }
          }
        }
      }
    }
    localObject1 = new bbpd();
    ((bbpd)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(paramayzj.e);
    a(paramMessageHandler, paramList, paramMsg, true, paramayzj.jdField_b_of_type_Boolean, (bbpd)localObject1, paramazaj, paramayzj);
  }
  
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, bbpd parambbpd)
  {
    a(paramMessageHandler, paramList, paramMsg, paramBoolean1, paramBoolean2, parambbpd, null, null);
  }
  
  public static void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, bbpd parambbpd, azaj paramazaj, ayzj paramayzj)
  {
    List localList = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("<---decodePBMsgElems: elems: ");
      if (localList != null) {
        break label88;
      }
    }
    label88:
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(localList.size()))
    {
      QLog.d("Q.msg.MessageHandler", 2, localObject1);
      if ((localList != null) && (localList.size() > 0)) {
        break;
      }
      return;
    }
    localObject1 = new StringBuilder("<---decodePBMsgElems:");
    Object localObject2 = ayzz.a(localList);
    int i = ayzz.a((ArrayList)localObject2);
    if (QLog.isColorLevel()) {
      ((StringBuilder)localObject1).append("decodeElemType:").append(i).append(" ElemStrs:").append(((ArrayList)localObject2).toString()).append("\n");
    }
    azaa localazaa = new azaa();
    if (QLog.isColorLevel()) {
      QLog.d("flash", 2, "decodePBMsgElems decodeElemType=" + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (paramList.isEmpty()) {
        localazaa.g(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      }
      if (paramList.isEmpty()) {
        localazaa.i(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      }
      localazaa.a(localList, paramList);
      if (ayzz.a((ArrayList)localObject2)) {
        localazaa.a((ArrayList)localObject2, localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd, paramazaj, paramayzj);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
      return;
      localazaa.a(localList, paramList, (StringBuilder)localObject1, paramBoolean2);
      continue;
      localazaa.a(localList, paramList, (StringBuilder)localObject1, paramMsg);
      continue;
      localazaa.b(localList, paramList, (StringBuilder)localObject1, paramBoolean1);
      continue;
      localazaa.a(localList, paramList, (StringBuilder)localObject1, paramMsg);
      continue;
      localazaa.d(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      continue;
      localazaa.b(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      continue;
      localazaa.c(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      continue;
      localazaa.e(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      continue;
      localazaa.c(localList, paramList, (StringBuilder)localObject1);
      continue;
      localazaa.a(localList, paramList, (StringBuilder)localObject1);
      continue;
      localazaa.d(localList, paramList, (StringBuilder)localObject1);
      continue;
      localazaa.h(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      continue;
      localazaa.b(localList, paramList, (StringBuilder)localObject1, paramMsg);
      continue;
      localazaa.f(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      continue;
      localazaa.h(localList, paramList, (StringBuilder)localObject1);
      continue;
      localazaa.i(localList, paramList, (StringBuilder)localObject1);
      continue;
      localazaa.g(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      continue;
      localazaa.a(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd, paramBoolean1);
      continue;
      localazaa.a(paramMessageHandler, localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd, paramBoolean1);
      continue;
      localazaa.a(paramMessageHandler, localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      continue;
      localazaa.i(localList, paramList, (StringBuilder)localObject1, paramMsg, parambbpd);
      continue;
      localazaa.a(localList, paramList, (StringBuilder)localObject1, paramMsg, paramBoolean1);
      continue;
      localazaa.b(localList, paramList, (StringBuilder)localObject1, paramMsg, paramBoolean1);
      continue;
      localazaa.e(localList, paramList, (StringBuilder)localObject1);
      continue;
      localazaa.f(localList, paramList, (StringBuilder)localObject1);
      continue;
      if (paramBoolean1)
      {
        if (paramMessageHandler.app.getLongAccountUin() == paramMsg.msg_head.to_uin.get()) {}
        for (paramMessageHandler = paramMsg.msg_head.from_uin.get() + "";; paramMessageHandler = paramMsg.msg_head.to_uin.get() + "")
        {
          localazaa.a(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageHandler);
          break;
        }
      }
      if (parambbpd != null) {}
      for (paramMessageHandler = parambbpd.jdField_a_of_type_JavaLangString;; paramMessageHandler = paramMsg.msg_head.to_uin.get() + "") {
        break;
      }
      localazaa.g(localList, paramList, (StringBuilder)localObject1);
      continue;
      localazaa.c(localList, paramList, (StringBuilder)localObject1, paramMsg);
      continue;
      aojt.a(localList, paramList, (StringBuilder)localObject1, paramMsg);
      continue;
      localazaa.j(localList, paramList, (StringBuilder)localObject1);
      continue;
      localazaa.b(localList, paramList, (StringBuilder)localObject1);
      continue;
      atud.a(paramMessageHandler.app, localList, paramList, (StringBuilder)localObject1, paramMsg, paramBoolean1, parambbpd);
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, ayzj paramayzj)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_SharpVideo return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      }
    }
    long l1;
    long l4;
    long l2;
    Object localObject;
    long l5;
    byte[] arrayOfByte2;
    int i;
    int j;
    boolean bool;
    do
    {
      long l3;
      do
      {
        byte[] arrayOfByte1;
        do
        {
          do
          {
            return;
            l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
            l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
            l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
            l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
            ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
            localObject = l4 + "-" + l3;
            if (QLog.isColorLevel()) {
              QLog.d("shanezhaiSHARP", 2, "<---decodeC2CMsgPkg_SharpVideo :  key:" + (String)localObject);
            }
            if (!paramMessageHandler.app.a().a(l2, (String)localObject)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("shanezhaiSHARP", 2, "msg has been pulled");
          return;
          l3 = ayzl.a();
          l4 = Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
          arrayOfByte1 = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          l5 = l3 - l1;
          arrayOfByte2 = new byte[4];
          byte[] arrayOfByte3 = new byte[4];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 4);
          System.arraycopy(arrayOfByte1, 4, arrayOfByte3, 0, 4);
          i = lfx.a(arrayOfByte2, 4);
          j = arrayOfByte1.length - 8 - i;
        } while (j < 0);
        arrayOfByte2 = new byte[j];
        System.arraycopy(arrayOfByte1, i + 8, arrayOfByte2, 0, j);
        bool = lnp.a(arrayOfByte2);
        if (((paramayzj.jdField_a_of_type_Boolean) || (paramayzj.f)) && ((paramayzj.jdField_a_of_type_Long == paramayzj.jdField_b_of_type_Long) && ((paramayzj.jdField_a_of_type_Long != paramayzj.jdField_b_of_type_Long) || (bool)))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_SharpVideo return null:,isReaded:" + paramayzj.jdField_a_of_type_Boolean + "syncOther:" + paramayzj.f + ",isSharpRequest" + bool);
      return;
      if (bool)
      {
        paramMessageHandler.app.a().a(l2, (String)localObject, l3);
        a(l4, l2, 215);
      }
      if ((lnz.c()) && (lnz.d())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("shanezhaiSHARP", 2, "Discard video message cause device not support");
      }
    } while (!bool);
    a(l4, l2, 212);
    return;
    if (l5 >= 60L)
    {
      int k;
      int i1;
      int i2;
      int m;
      if (bool)
      {
        paramayzj = String.valueOf(l2);
        localObject = new hd_video_2.MsgBody();
        k = -1;
        i1 = 0;
        i2 = 0;
        i = 0;
        j = i2;
        m = k;
      }
      int n;
      for (;;)
      {
        try
        {
          ((hd_video_2.MsgBody)localObject).mergeFrom(arrayOfByte2);
          j = i2;
          m = k;
          n = ((hd_video_2.MsgBody)localObject).msg_invite_body.uint32_new_business_flag.get();
          j = i2;
          m = n;
          if (!((hd_video_2.MsgBody)localObject).msg_invite_body.msg_temp_session.has()) {
            continue;
          }
          k = i1;
          j = i2;
          m = n;
          if (((hd_video_2.MsgBody)localObject).msg_invite_body.msg_temp_session.uint32_relationship_type.has())
          {
            j = i2;
            m = n;
            i1 = VideoController.a(((hd_video_2.MsgBody)localObject).msg_invite_body.msg_temp_session.uint32_relationship_type.get(), false, 1);
            if (i1 != -1) {
              i = i1;
            }
            k = i;
            j = i;
            m = n;
            if (QLog.isColorLevel())
            {
              j = i;
              m = n;
              QLog.d("shanezhaiSHARP", 2, "uinType" + i + " translateType:" + i1);
              k = i;
            }
          }
          i = k;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i = j;
          n = m;
          continue;
        }
        if (-1 != n) {
          break label963;
        }
        VideoMsgTools.a(paramMessageHandler.app, 0, 6, true, paramayzj, String.valueOf(l4), false, null, false, new Object[] { paramMsg });
        a(l4, l2, 208);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("shanezhaiSHARP", 2, "Discard video message because of time out " + l5 + " s");
        return;
        k = i1;
        j = i2;
        m = n;
        if (QLog.isColorLevel())
        {
          j = i2;
          m = n;
          QLog.d("shanezhaiSHARP", 2, "msg_temp_session not include");
          k = i1;
        }
      }
      label963:
      if (n == 0) {}
      for (bool = true;; bool = false)
      {
        VideoMsgTools.a(paramMessageHandler.app, i, 6, bool, paramayzj, String.valueOf(l2), false, null, false, new Object[] { paramMsg });
        break;
      }
    }
    if (bool) {
      a(l4, l2, 211);
    }
    if (QLog.isColorLevel()) {
      QLog.d("shanezhaiSHARP", 2, "===========handleSharpVideoMessageResp 1234========");
    }
    paramMessageHandler.a(l4, arrayOfByte2, l2, (int)l1, bool);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList)
  {
    im_msg_body.Ptt localPtt = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
    String str2 = localPtt.bytes_file_name.get().toStringUtf8();
    Object localObject3 = "";
    Object localObject1 = null;
    int m;
    int i4;
    int j;
    boolean bool;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    Object localObject2;
    int n;
    label205:
    int i;
    long l1;
    if (str2.endsWith(".amr"))
    {
      if (!baam.a(paramMessageHandler.app)) {
        break label1235;
      }
      m = 1;
      i4 = f(paramMsg);
      j = localPtt.uint32_file_type.get();
      bool = localPtt.bool_valid.get();
      l2 = localPtt.uint64_src_uin.get();
      l3 = localPtt.uint32_file_size.get();
      l4 = localPtt.uint32_file_id.get() & 0xFFFFFFFF;
      l5 = localPtt.uint32_server_ip.get();
      l6 = localPtt.uint32_server_port.get();
      localObject2 = localPtt.bytes_file_uuid.get().toByteArray();
      localObject1 = localPtt.bytes_file_md5.get().toByteArray();
      if (!localPtt.uint32_format.has()) {
        break label1241;
      }
      n = localPtt.uint32_format.get();
      if (!localPtt.uint32_time.has()) {
        break label1247;
      }
      i = localPtt.uint32_time.get();
      l1 = bdml.b(i);
      if (!localPtt.bytes_down_para.has()) {
        break label2536;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPD", 2, "receive ptt msg , bytes_down_para has ! " + localPtt.bytes_down_para.get());
      }
      localObject5 = localPtt.bytes_down_para.get();
      if (localObject5 == null) {
        break label2536;
      }
    }
    label1235:
    label1241:
    label1247:
    label2536:
    for (Object localObject5 = ((ByteStringMicro)localObject5).toStringUtf8();; localObject5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPD", 2, "receive ptt msg , url : " + (String)localObject5 + " srcuin " + l2 + "filename" + str2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---decodeGrpDisMsgPkg_PTT voiceType：" + n + " voiceLengh:" + l1);
      }
      localObject2 = bdhe.a((byte[])localObject2);
      Object localObject6 = bdhe.a((byte[])localObject1);
      if (localPtt.bytes_group_file_key.has()) {}
      MessageRecord localMessageRecord;
      for (localObject1 = localPtt.bytes_group_file_key.get().toByteArray();; localMessageRecord = null) {
        try
        {
          localObject1 = new String((byte[])localObject1, "utf-8");
          if (localObject6 == null)
          {
            localObject6 = "";
            if (QLog.isColorLevel())
            {
              localObject7 = new StringBuilder("<---decodeSinglePbMsg_GroupDis:");
              ((StringBuilder)localObject7).append(" pttType:").append(j).append(" isValid:").append(bool).append(" srcUin:").append(l2).append(" fileSize:").append(l3 & 0xFFFFFFFF).append(" fileID").append(l4).append(" serverIP:").append(l5 & 0xFFFFFFFF).append(" serverPort:").append(l6 & 0xFFFFFFFF).append(" fileName:").append(str2).append(" uuidStr:").append((String)localObject2).append(" md5Str:").append((String)localObject6).append(" GrpFileKey:").append((String)localObject1);
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject7).toString());
            }
            i1 = 0;
            int i2 = 0;
            int i3 = 0;
            String str1 = "";
            if (localPtt.bytes_pb_reserve.has())
            {
              ptt_reserve.ReserveStruct localReserveStruct = new ptt_reserve.ReserveStruct();
              k = i3;
              j = i2;
              i = i1;
              localObject2 = localObject3;
              try
              {
                localReserveStruct.mergeFrom(localPtt.bytes_pb_reserve.get().toByteArray());
                k = i3;
                j = i2;
                i = i1;
                localObject2 = localObject3;
                i1 = localReserveStruct.uint32_change_voice.get();
                k = i3;
                j = i2;
                i = i1;
                localObject2 = localObject3;
                i2 = localReserveStruct.uint32_redpack_type.get();
                k = i3;
                j = i2;
                i = i1;
                localObject2 = localObject3;
                i3 = localReserveStruct.uint32_autototext_voice.get();
                k = i3;
                j = i2;
                i = i1;
                localObject2 = localObject3;
                localObject7 = localReserveStruct.bytes_voice_text_abs.get().toStringUtf8();
                localObject3 = str1;
                k = i3;
                j = i2;
                i = i1;
                localObject2 = localObject7;
                if (localReserveStruct.bytes_redpack_score_id.has())
                {
                  k = i3;
                  j = i2;
                  i = i1;
                  localObject2 = localObject7;
                  localObject3 = localReserveStruct.bytes_redpack_score_id.get().toStringUtf8();
                }
                localObject2 = localObject3;
                i = i3;
                j = i2;
                k = i1;
                localObject3 = localObject7;
              }
              catch (Exception localException)
              {
                do
                {
                  for (;;)
                  {
                    localObject7 = "";
                    i1 = i;
                    localObject4 = localObject2;
                    localObject2 = localObject7;
                    i = k;
                    k = i1;
                  }
                  localObject5 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
                  localObject4 = new StringBuilder();
                  if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                ((StringBuilder)localObject4).append("elems:null || elems.size() <= 0");
                QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject4).toString());
                return;
                if (!QLog.isColorLevel()) {
                  break label1396;
                }
                ((StringBuilder)localObject4).append("elemsSize").append(((List)localObject5).size()).append("\n");
                i = 0;
              }
              bays.a(str2, 0L, 2, false, str2);
              localObject7 = new RichMsg.PttRec();
              ((RichMsg.PttRec)localObject7).localPath.set(str2);
              ((RichMsg.PttRec)localObject7).size.set(localPtt.uint32_file_size.get());
              ((RichMsg.PttRec)localObject7).type.set(2);
              ((RichMsg.PttRec)localObject7).uuid.set(str2);
              ((RichMsg.PttRec)localObject7).isRead.set(false);
              ((RichMsg.PttRec)localObject7).md5.set((String)localObject6);
              ((RichMsg.PttRec)localObject7).isReport.set(0);
              ((RichMsg.PttRec)localObject7).version.set(5);
              ((RichMsg.PttRec)localObject7).groupFileID.set(l4);
              ((RichMsg.PttRec)localObject7).pttFlag.set(m);
              ((RichMsg.PttRec)localObject7).longPttVipFlag.set(i4);
              if (localObject1 != null) {
                ((RichMsg.PttRec)localObject7).group_file_key.set((String)localObject1);
              }
              l2 = System.currentTimeMillis() / 1000L;
              l3 = paramMsg.msg_head.msg_time.get();
              ((RichMsg.PttRec)localObject7).msgRecTime.set(l2);
              ((RichMsg.PttRec)localObject7).msgTime.set(l3);
              ((RichMsg.PttRec)localObject7).voiceType.set(n);
              ((RichMsg.PttRec)localObject7).voiceLength.set(bdeu.a(l1));
              ((RichMsg.PttRec)localObject7).voiceChangeFlag.set(k);
              ((RichMsg.PttRec)localObject7).directUrl.set((String)localObject5);
              ((RichMsg.PttRec)localObject7).redpack_type.set(j);
              ((RichMsg.PttRec)localObject7).autototext_voice.set(i);
              ((RichMsg.PttRec)localObject7).sttText.set((String)localObject3);
              localObject1 = azaf.a(-2002);
              ((MessageRecord)localObject1).msgtype = -2002;
              ((MessageRecord)localObject1).msgData = ((RichMsg.PttRec)localObject7).toByteArray();
              ((MessageForPtt)localObject1).parse();
              paramList.add(localObject1);
              localObject3 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
              new azaa().a((List)localObject3, paramList);
              ajfi.b((String)localObject2, (MessageRecord)localObject1);
              if (localObject1 == null)
              {
                return;
                m = 0;
                break;
                n = 0;
                break label205;
                i = 0;
              }
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            Object localObject7;
            int i1;
            int k;
            localMessageRecord = null;
            continue;
            Object localObject4;
            for (;;)
            {
              label1396:
              if (i >= ((List)localObject5).size()) {
                break label2082;
              }
              localObject6 = (im_msg_body.Elem)((List)localObject5).get(i);
              if (((im_msg_body.Elem)localObject6).near_by_msg.has())
              {
                if (QLog.isColorLevel()) {
                  ((StringBuilder)localObject4).append("elemType: near_by_msg;");
                }
                paramList = ((im_msg_body.Elem)localObject6).near_by_msg;
                if ((paramList.uint32_identify_type.has()) && (paramList.uint32_identify_type.get() == 1))
                {
                  localMessageRecord.saveExtInfoToExtStr("identify_flag", "true");
                  if (QLog.isColorLevel()) {
                    ((StringBuilder)localObject4).append("has identify;");
                  }
                }
              }
              for (;;)
              {
                if ((!((im_msg_body.Elem)localObject6).general_flags.has()) || (!((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.has())) {
                  break label2067;
                }
                paramList = new generalflags.ResvAttr();
                try
                {
                  paramList.mergeFrom(((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.get().toByteArray());
                  if (paramList.uint32_holiday_flag.has())
                  {
                    j = paramList.uint32_holiday_flag.get();
                    if (j == 1) {
                      localMessageRecord.saveExtInfoToExtStr(ayzs.jdField_c_of_type_JavaLangString, String.valueOf(j));
                    }
                    if (QLog.isColorLevel()) {
                      QLog.i("Q.msg.MessageHandler", 2, "decodeGrpDisMsgPkg_PTT uint32_holiday_flag = " + j);
                    }
                  }
                  bool = paramList.bytes_pb_ptt_waveform.has();
                  if (!bool) {}
                }
                catch (Exception paramList)
                {
                  for (;;)
                  {
                    label2036:
                    paramList.printStackTrace();
                  }
                }
                try
                {
                  localObject2 = new ptt_waveform.PttWaveform();
                  ((ptt_waveform.PttWaveform)localObject2).mergeFrom(paramList.bytes_pb_ptt_waveform.get().toByteArray());
                  ((MessageForPtt)localMessageRecord).waveformArray = bdjf.a((ptt_waveform.PttWaveform)localObject2);
                  if (QLog.isColorLevel())
                  {
                    paramList = new StringBuilder();
                    localObject2 = ((MessageForPtt)localMessageRecord).waveformArray;
                    k = localObject2.length;
                    j = 0;
                    for (;;)
                    {
                      if (j < k)
                      {
                        paramList.append(localObject2[j]);
                        paramList.append(";");
                        j += 1;
                        continue;
                        if (((im_msg_body.Elem)localObject6).pub_group.has())
                        {
                          paramList = (im_msg_body.PubGroup)((im_msg_body.Elem)localObject6).pub_group.get();
                          if (paramList == null) {
                            break;
                          }
                          j = paramList.uint32_gender.get();
                          localObject2 = paramList.bytes_nickname.get().toStringUtf8();
                          localMessageRecord.saveExtInfoToExtStr("hotchat_gender", String.valueOf(j));
                          paramList = (List<MessageRecord>)localObject2;
                          if (localObject2 == null) {
                            paramList = "";
                          }
                          localMessageRecord.saveExtInfoToExtStr("hotchat_nick", paramList);
                          if (!QLog.isColorLevel()) {
                            break;
                          }
                          ((StringBuilder)localObject4).append("has pub_group;");
                          break;
                        }
                        if ((((im_msg_body.Elem)localObject6).general_flags.has()) && (((im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject6).general_flags.get()).uint32_olympic_torch.has()))
                        {
                          j = ((im_msg_body.Elem)localObject6).general_flags.uint32_olympic_torch.get();
                          if (QLog.isColorLevel()) {
                            ((StringBuilder)localObject4).append("has olympicTorch:").append(j).append(";");
                          }
                          if (j <= 0) {
                            break;
                          }
                          localMessageRecord.saveExtInfoToExtStr("olympic_torch_flg", j + "");
                          break;
                        }
                        if ((!((im_msg_body.Elem)localObject6).common_elem.has()) || (13 != ((im_msg_body.Elem)localObject6).common_elem.uint32_service_type.get())) {
                          break;
                        }
                        if (QLog.isColorLevel()) {
                          ((StringBuilder)localObject4).append("decodeGrpDisMsgPkg_PTT decode hummer_commelem == UpdateStrangerAvatar");
                        }
                        new azaa().a((List)localObject5, paramMsg, (StringBuilder)localObject4);
                        break;
                      }
                    }
                    QLog.d("Q.msg.MessageHandler", 2, "decodeGrpDisMsgPkg_PTT, waveformArray = " + paramList.toString());
                  }
                }
                catch (Throwable paramList)
                {
                  break label2036;
                }
              }
              if ((((MessageForPtt)localMessageRecord).waveformArray == null) || (((MessageForPtt)localMessageRecord).waveformArray.length == 0)) {
                ((MessageForPtt)localMessageRecord).buileDefaultWaveform();
              }
              i += 1;
            }
            i = 0;
            for (;;)
            {
              if (i < ((List)localObject5).size())
              {
                paramList = (im_msg_body.Elem)((List)localObject5).get(i);
                if (paramList.general_flags.bytes_pb_reserve.has()) {
                  localObject2 = new generalflags.ResvAttr();
                }
                try
                {
                  ((generalflags.ResvAttr)localObject2).mergeFrom(paramList.general_flags.bytes_pb_reserve.get().toByteArray());
                  if (((generalflags.ResvAttr)localObject2).uint32_robot_msg_flag.has())
                  {
                    j = ((generalflags.ResvAttr)localObject2).uint32_robot_msg_flag.get();
                    localMessageRecord.mRobotFlag = j;
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "handleGeneralSettingFlags uint32_robot_msg_flag = " + j);
                    }
                  }
                  i += 1;
                }
                catch (InvalidProtocolBufferMicroException paramList)
                {
                  for (;;)
                  {
                    paramList.printStackTrace();
                  }
                }
              }
            }
            bool = ((bcpg)paramMessageHandler.app.getManager(203)).a(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
            if ((localMessageRecord.mRobotFlag == 1) || (localMessageRecord.mRobotFlag == 2) || (bool))
            {
              localObject2 = ((List)localObject5).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                paramList = (im_msg_body.Elem)((Iterator)localObject2).next();
                if (paramList.text.has())
                {
                  paramList = (im_msg_body.Text)paramList.text.get();
                  if (paramList.attr_6_buf.has())
                  {
                    paramList = paramList.attr_6_buf.get();
                    if (paramList != null) {}
                    for (paramList = paramList.toByteArray();; paramList = null)
                    {
                      if ((paramList == null) || (paramList.length == 0)) {
                        break label2466;
                      }
                      k = bdqa.a(paramList, 0);
                      j = 2;
                      i = 0;
                      for (;;)
                      {
                        if ((i >= k) || (j >= 2048)) {
                          break label2461;
                        }
                        localObject5 = new MessageForText.AtTroopMemberInfo();
                        if (!((MessageForText.AtTroopMemberInfo)localObject5).readFrom(paramList, j)) {
                          break;
                        }
                        j += ((MessageForText.AtTroopMemberInfo)localObject5).length();
                        i = (short)(i + 1);
                        if (localMessageRecord.atInfoList == null) {
                          localMessageRecord.atInfoList = new ArrayList();
                        }
                        localMessageRecord.atInfoList.add(localObject5);
                      }
                      break;
                    }
                  }
                }
              }
              ((MessageForPtt)localMessageRecord).parse();
            }
            aoiy.a(paramMsg, localMessageRecord, paramMessageHandler.app);
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject4).toString());
              return;
              localObject2 = "";
              i = 0;
              j = 0;
              k = 0;
              localObject4 = "";
            }
          }
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Dataline");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Dataline: return isReaded4DataLine:" + paramBoolean);
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new MessageProtoCodec.2(paramMessageHandler, paramMsg));
      return;
    }
    ((alqo)paramMessageHandler.app.a(8)).a(paramMsg);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("AVMsg", 2, "decodeC2CMsgPkg_MultiVideo, msg[" + l + "]");
    }
    paramMessageHandler.app.a().a(arrayOfByte, paramMsg);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_AddFriend return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
    }
    String str;
    do
    {
      do
      {
        return;
        long l1 = Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
        long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
        if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
          paramMessageHandler.a().a(l1, l2, s, -1006 - (s - 187), paramMsg, paramInt);
        }
        localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      } while (localObject == null);
      paramMsg = "" + ((msg_comm.MsgHead)localObject).auth_uin.get();
      str = ((msg_comm.MsgHead)localObject).auth_nick.get();
      Object localObject = ((msg_comm.MsgHead)localObject).auth_remark.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.sysnick", 2, "FriendSys auUin:" + paramMsg + "aunick:" + str + "auRemark:" + (String)localObject);
      }
      if ((!TextUtils.isEmpty(paramMsg)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.sysremark", 2, "FriendSys saveremark");
        }
        paramMessageHandler.b(paramMsg, (String)localObject);
      }
    } while ((TextUtils.isEmpty(paramMsg)) || (TextUtils.isEmpty(str)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler.sysnick", 2, "FriendSys savenick");
    }
    paramMessageHandler.a(paramMsg, str);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    paramMessageHandler = paramMsgType0x210.msg_content.get().toByteArray();
    paramMsgType0x210 = new Submsgtype0x35.MsgBody();
    try
    {
      int i = ((Submsgtype0x35.MsgBody)paramMsgType0x210.mergeFrom(paramMessageHandler)).uint32_bubble_timestamp.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 bubble push timestamp=" + i);
      }
      return;
    }
    catch (Exception paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x35.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Submsgtype0x8a.ReqBody paramReqBody, long paramLong, boolean paramBoolean)
  {
    int i = 0;
    long l = 0L;
    Object localObject1 = (ArrayList)paramReqBody.msg_info.get();
    Object localObject2 = new msgrevoke_userdef.UinTypeUserDef();
    Object localObject3;
    try
    {
      ((msgrevoke_userdef.UinTypeUserDef)localObject2).mergeFrom(paramReqBody.bytes_reserved.get().toByteArray());
      int j = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint32_from_uin_type.get();
      if (j == 1)
      {
        i = 1000;
        l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
      }
      for (;;)
      {
        localObject2 = new ArrayList();
        paramReqBody = ((ArrayList)localObject1).iterator();
        while (paramReqBody.hasNext())
        {
          localObject1 = (Submsgtype0x8a.MsgInfo)paramReqBody.next();
          localObject3 = new RevokeMsgInfo();
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_Int = i;
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_JavaLangString = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject1).uint64_from_uin.get());
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject1).uint64_to_uin.get());
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_JavaLangString = String.valueOf(l);
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_Long = ((short)((Submsgtype0x8a.MsgInfo)localObject1).uint32_msg_seq.get());
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_Long = ((Submsgtype0x8a.MsgInfo)localObject1).uint64_msg_uid.get();
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_Long = ((Submsgtype0x8a.MsgInfo)localObject1).uint64_msg_time.get();
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_div_seq.get();
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_pkg_num.get();
          ((RevokeMsgInfo)localObject3).d = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_pkg_index.get();
          ((ArrayList)localObject2).add(localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg," + ((RevokeMsgInfo)localObject3).toString());
          }
        }
        if (j == 2)
        {
          i = 1004;
          l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg, prase uintypeUserdef error");
      }
    }
    label784:
    for (;;)
    {
      if (!paramBoolean)
      {
        paramQQAppInterface.a().a((ArrayList)localObject2, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b subaccount msg");
      }
      if (!((ArrayList)localObject2).isEmpty())
      {
        String str1 = Long.toString(paramLong);
        String str2 = paramQQAppInterface.getCurrentAccountUin();
        badd localbadd = (badd)paramQQAppInterface.getManager(61);
        if (localbadd != null)
        {
          List localList = localbadd.a(str1);
          paramReqBody = null;
          localObject1 = null;
          Iterator localIterator1 = ((ArrayList)localObject2).iterator();
          if (localIterator1.hasNext())
          {
            localObject2 = (RevokeMsgInfo)localIterator1.next();
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext())
            {
              localObject3 = (SubAccountMessage)localIterator2.next();
              if ((((RevokeMsgInfo)localObject2).jdField_a_of_type_Long == ((SubAccountMessage)localObject3).shmsgseq) && (((RevokeMsgInfo)localObject2).jdField_b_of_type_Long == ((SubAccountMessage)localObject3).msgUid))
              {
                localObject1 = localObject3;
                paramReqBody = (Submsgtype0x8a.ReqBody)localObject2;
              }
            }
          }
          for (;;)
          {
            break;
            if (paramReqBody == null) {
              break label784;
            }
            localObject2 = alud.a(2131707049);
            localObject3 = (SubAccountMessage)((SubAccountMessage)localObject1).deepCopyByReflect();
            ((SubAccountMessage)localObject3).msg = ((String)localObject2).concat(BaseApplicationImpl.getApplication().getString(2131694588));
            ((SubAccountMessage)localObject3).unreadNum = Math.max(0, ((SubAccountMessage)localObject1).unreadNum - 1);
            ((SubAccountMessage)localObject3).time = paramReqBody.jdField_c_of_type_Long;
            ((SubAccountMessage)localObject3).needNotify = paramQQAppInterface.isBackground_Pause;
            ((SubAccountMessage)localObject3).mTimeString = bdns.a(((SubAccountMessage)localObject3).time * 1000L, true, bacu.jdField_a_of_type_JavaLangString);
            ((SubAccountMessage)localObject3).mEmoRecentMsg = new bamp(((SubAccountMessage)localObject3).msg, 0);
            if (localbadd != null) {
              localbadd.b((SubAccountMessage)localObject3);
            }
            bacu.a(paramQQAppInterface, str1, 6);
            paramReqBody = ((SubAccountMessage)localObject3).convertToMessageRecord();
            paramReqBody.istroop = 7000;
            paramReqBody.frienduin = str1;
            paramQQAppInterface.a().d(paramReqBody.frienduin, paramReqBody.istroop, -1);
            if (localbadd != null) {
              localbadd.c(str1);
            }
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(paramReqBody);
            paramQQAppInterface.a().a((ArrayList)localObject1, str2, false, false, true);
            paramQQAppInterface.D();
            paramReqBody = new bade();
            paramReqBody.jdField_b_of_type_JavaLangString = str2;
            paramReqBody.jdField_c_of_type_JavaLangString = str1;
            paramReqBody.jdField_c_of_type_Boolean = true;
            paramReqBody.d = true;
            paramReqBody.jdField_a_of_type_Int = 0;
            paramQQAppInterface.a().a().a(8003, true, paramReqBody);
            return;
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject = new Submsgtype0x4e.MsgBody();
    for (;;)
    {
      int i;
      long l1;
      long l2;
      long l3;
      String str;
      int j;
      try
      {
        paramArrayOfByte = (Submsgtype0x4e.MsgBody)((Submsgtype0x4e.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        i = paramArrayOfByte.uint32_appid.get();
        l1 = paramArrayOfByte.uint64_group_id.get();
        l2 = paramArrayOfByte.uint64_group_code.get();
        if (paramArrayOfByte.msg_group_bulletin.has())
        {
          l3 = (int)ayzl.a();
          localObject = paramArrayOfByte.msg_group_bulletin.rpt_msg_content.get();
          new ArrayList();
          paramArrayOfByte = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          Submsgtype0x4e.GroupBulletin.Content localContent = (Submsgtype0x4e.GroupBulletin.Content)((Iterator)localObject).next();
          l3 = localContent.uint64_uin.get();
          str = localContent.bytes_feedid.get().toStringUtf8();
          j = localContent.uint32_time.get();
          if (bcpa.b(str))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopNotificationHelper", 2, "notice is loading");
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x4e.");
        }
      }
      if ((TroopNotificationCache)paramArrayOfByte.a(TroopNotificationCache.class, "troopUin=? and feedsId=?", new String[] { String.valueOf(l2), str }) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "notice has exist!");
        }
      }
      else {
        bcpa.a(paramQQAppInterface, i, l1, l2, l3, str, j, "OidbSvc.0x852_35", (short)23, false, false);
      }
    }
    paramArrayOfByte.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    submsgtype0xb1.MsgBody localMsgBody = new submsgtype0xb1.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      long l1 = 2000L;
      if (!paramBoolean) {
        l1 = 10000L;
      }
      ThreadManager.getUIHandler().postDelayed(new MessageProtoCodec.3(paramQQAppInterface, localMsgBody, paramBoolean), l1);
      long l2;
      if (localMsgBody.deal_info.has())
      {
        l1 = localMsgBody.deal_info.uint64_group_code.get();
        l2 = localMsgBody.deal_info.uint64_uin.get();
        paramArrayOfByte = localMsgBody.deal_info.str_id.get();
        int i = localMsgBody.deal_info.uint32_deal_result.get();
        if (paramQQAppInterface.getCurrentAccountUin().equals(l2 + ""))
        {
          Intent localIntent = new Intent("tencent.video.q2v.close_invite_msg_box_by_invite_id");
          localIntent.putExtra("groupId", l1);
          localIntent.putExtra("inviteId", paramArrayOfByte);
          paramQQAppInterface.getApp().sendBroadcast(localIntent);
        }
        if (i == 0) {
          paramQQAppInterface.a().a(l1, l2, paramArrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "recv 0x210_0xb1, msgBody.deal_info.has()==》troopUin：" + l1 + ", memUin:" + l2 + ", invitedId:" + paramArrayOfByte + ", dealResult:" + i);
        }
      }
      if (localMsgBody.univite_info.has())
      {
        l1 = localMsgBody.univite_info.uint64_group_code.get();
        l2 = localMsgBody.univite_info.uint64_uin.get();
        paramArrayOfByte = localMsgBody.univite_info.str_id.get();
        paramQQAppInterface.a().b(l1, l2, paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "recv 0x210_0xb1, msgBody.univite_info.has()==》troopUin：" + l1 + ", memUin:" + l2 + ", invitedId:" + paramArrayOfByte + ", dealResult:" + paramArrayOfByte);
        }
        if (!paramBoolean) {
          a.put(paramArrayOfByte, Long.valueOf(System.currentTimeMillis() / 1000L));
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.MessageHandler", 2, "recv 0x210_0xb1, prase msgBody error");
    }
  }
  
  private static void a(MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, im_msg_body.Elem paramElem)
  {
    if (paramAtTroopMemberInfo != null)
    {
      byte[] arrayOfByte = new byte[13];
      bdqa.a(arrayOfByte, 0, (short)1);
      paramAtTroopMemberInfo.writeTo(arrayOfByte, 2);
      paramElem.text.attr_6_buf.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.RoutingHead paramRoutingHead)
  {
    if (paramRoutingHead == null) {
      return false;
    }
    int i = b(paramMessageRecord.istroop, paramQQAppInterface);
    Object localObject1 = paramQQAppInterface.a();
    Object localObject2;
    switch (i)
    {
    case 7: 
    case 9: 
    case 13: 
    default: 
      return paramQQAppInterface.a().a().a(i).a(paramRoutingHead, paramMessageRecord, paramQQAppInterface);
    case 1: 
      paramQQAppInterface = new msg_svc.C2C();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.c2c.set(paramQQAppInterface);
      return true;
    case 21: 
      paramQQAppInterface = new msg_svc.Grp();
      paramQQAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.grp.set(paramQQAppInterface);
      return true;
    case 2: 
      paramQQAppInterface = new msg_svc.Grp();
      paramQQAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.grp.set(paramQQAppInterface);
      return true;
    case 3: 
      if ((!TextUtils.isEmpty(paramMessageRecord.senderuin)) && (Long.valueOf(paramMessageRecord.senderuin).longValue() != 0L) && (!TextUtils.equals(paramMessageRecord.senderuin, paramMessageRecord.selfuin)) && (TextUtils.equals(paramMessageRecord.senderuin, paramMessageRecord.frienduin))) {}
      paramQQAppInterface = new msg_svc.GrpTmp();
      if (TextUtils.isEmpty(paramMessageRecord.senderuin))
      {
        paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.selfuin).longValue());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "createSendRichTextMsgReq, senderuin error, senderuin: " + paramMessageRecord.senderuin + " frienduin: " + paramMessageRecord.frienduin + " msgtype: " + paramMessageRecord.msgtype);
        }
      }
      for (;;)
      {
        paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        paramRoutingHead.grp_tmp.set(paramQQAppInterface);
        return true;
        paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      }
    case 4: 
      paramQQAppInterface = new msg_svc.Dis();
      paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.dis.set(paramQQAppInterface);
      return true;
    case 5: 
      paramQQAppInterface = new msg_svc.DisTmp();
      paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.dis_tmp.set(paramQQAppInterface);
      return true;
    case 6: 
      paramQQAppInterface = ((ayzl)localObject1).b(paramMessageRecord.frienduin);
      localObject1 = new msg_svc.WPATmp();
      ((msg_svc.WPATmp)localObject1).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        paramMessageRecord = new byte[paramQQAppInterface.length - 2];
        bdqa.a(paramMessageRecord, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "wpa------>" + bdhe.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        ((msg_svc.WPATmp)localObject1).sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.wpa_tmp.set((MessageMicro)localObject1);
      return true;
    case 18: 
      paramQQAppInterface = ((ayzl)localObject1).c(paramMessageRecord.frienduin);
      localObject1 = new msg_svc.QQQueryBusinessTmp();
      ((msg_svc.QQQueryBusinessTmp)localObject1).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        paramMessageRecord = new byte[paramQQAppInterface.length - 2];
        bdqa.a(paramMessageRecord, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "wpa------>" + bdhe.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        ((msg_svc.QQQueryBusinessTmp)localObject1).sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.qq_querybusiness_tmp.set((MessageMicro)localObject1);
      return true;
    case 15: 
      localObject2 = ((ayzl)localObject1).d(paramMessageRecord.frienduin);
      paramQQAppInterface = new msg_svc.BusinessWPATmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "conversation------>sig:" + bdhe.a((byte[])localObject2) + ",length:" + localObject2.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      for (;;)
      {
        paramRoutingHead.business_wpa_tmp.set(paramQQAppInterface);
        return true;
        paramMessageRecord = ((ayzl)localObject1).e(paramMessageRecord.frienduin);
        if (paramMessageRecord != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "conversation------>sigt:" + bdhe.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
          }
          paramQQAppInterface.sigt.set(ByteStringMicro.copyFrom(paramMessageRecord));
        }
      }
    case 10: 
      paramQQAppInterface = new msg_svc.AddressListTmp();
      paramQQAppInterface.from_phone.set(paramMessageRecord.senderuin);
      paramQQAppInterface.to_phone.set(paramMessageRecord.frienduin);
      paramMessageRecord = ((ayzl)localObject1).f(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sameState------>" + bdhe.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.address_list.set(paramQQAppInterface);
      return true;
    case 8: 
      paramQQAppInterface = ((ayzl)localObject1).a(paramMessageRecord.frienduin);
      localObject1 = new msg_svc.PublicPlat();
      ((msg_svc.PublicPlat)localObject1).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        paramMessageRecord = new byte[paramQQAppInterface.length - 2];
        bdqa.a(paramMessageRecord, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        ((msg_svc.PublicPlat)localObject1).sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.public_plat.set((MessageMicro)localObject1);
      return true;
    case 11: 
      paramQQAppInterface = new msg_svc.RichStatusTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((ayzl)localObject1).j(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sameState------>" + bdhe.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.rich_status_tmp.set(paramQQAppInterface);
      return true;
    case 12: 
      localObject2 = new msg_svc.AccostTmp();
      ((msg_svc.AccostTmp)localObject2).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1001);
      ((msg_svc.AccostTmp)localObject2).reply.set(paramQQAppInterface.hasReply);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "LBSFriend------>reply=" + paramQQAppInterface.hasReply);
      }
      paramQQAppInterface = ((ayzl)localObject1).m(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "发送附近人临时会消息 有keyLBSFriend------>" + bdhe.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.AccostTmp)localObject2).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      paramRoutingHead.accost_tmp.set((MessageMicro)localObject2);
      return true;
    case 23: 
      localObject2 = new msg_svc.CommTmp();
      ((msg_svc.CommTmp)localObject2).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      ((msg_svc.CommTmp)localObject2).c2c_type.set(1);
      ((msg_svc.CommTmp)localObject2).svr_type.set(149);
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1001);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "TribeTmp------>reply=" + paramQQAppInterface.hasReply);
      }
      paramQQAppInterface = ((ayzl)localObject1).k(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "发送兴趣部落临时会消息 有key------>" + bdhe.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.CommTmp)localObject2).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      paramRoutingHead.comm_tmp.set((MessageMicro)localObject2);
      return true;
    case 24: 
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(153);
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      paramMessageRecord = ((ayzl)localObject1).l(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "movieTicket------>" + bdhe.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      return true;
    case 14: 
      paramQQAppInterface = new msg_svc.PubGroupTmp();
      paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.pub_group_tmp.set(paramQQAppInterface);
      return true;
    case 16: 
      paramQQAppInterface = new msg_svc.BsnsTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((ayzl)localObject1).g(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "circleGroup------>" + bdhe.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.bsns_tmp.set(paramQQAppInterface);
      return true;
    case 17: 
      paramQQAppInterface = new msg_svc.AuthTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((ayzl)localObject1).i(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "friendValidation------>" + bdhe.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.auth_tmp.set(paramQQAppInterface);
      return true;
    case 19: 
      localObject2 = new msg_svc.NearByDatingTmp();
      ((msg_svc.NearByDatingTmp)localObject2).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1010);
      ((msg_svc.NearByDatingTmp)localObject2).reply.set(paramQQAppInterface.hasReply);
      paramQQAppInterface = ((ayzl)localObject1).p(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("nearby_dating", 4, "发送附近人约会临时会话消息 有keyNearbyDating------>" + bdhe.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.NearByDatingTmp)localObject2).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      paramRoutingHead.nearby_dating_tmp.set((MessageMicro)localObject2);
      return true;
    case 20: 
      paramQQAppInterface = new msg_svc.NearByAssistantTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((ayzl)localObject1).o(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("nearby_assistant", 4, "发送附近人助手临时会话消息 有NearbyAssistantKey------>" + bdhe.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.nearby_assistant_tmp.set(paramQQAppInterface);
      return true;
    case 22: 
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(144);
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((ayzl)localObject1).n(paramMessageRecord.frienduin);
      if (paramMessageRecord != null) {
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      return true;
    case 25: 
    case 26: 
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(156);
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((ayzl)localObject1).a(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
      if (paramMessageRecord != null) {
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      return true;
    case 28: 
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(159);
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((ayzl)localObject1).b(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
      if (paramMessageRecord != null) {
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      return true;
    case 27: 
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(160);
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      return true;
    case 29: 
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(163);
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((ayzl)localObject1).c(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
      if (paramMessageRecord != null) {
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      return true;
    case 30: 
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(166);
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((ayzl)localObject1).a(paramMessageRecord.frienduin, paramMessageRecord.selfuin, false);
      if (paramMessageRecord != null) {
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      return true;
    case 31: 
      localObject2 = new msg_svc.CommTmp();
      ((msg_svc.CommTmp)localObject2).c2c_type.set(1);
      ((msg_svc.CommTmp)localObject2).svr_type.set(164);
      localObject1 = ((ayzl)localObject1).d(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
      if (localObject1 != null) {
        ((msg_svc.CommTmp)localObject2).sig.set(ByteStringMicro.copyFrom((byte[])localObject1));
      }
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin);
      ((msg_svc.CommTmp)localObject2).to_uin.set(Long.parseLong(paramQQAppInterface));
      paramRoutingHead.comm_tmp.set((MessageMicro)localObject2);
      return true;
    }
    paramQQAppInterface = new msg_svc.CommTmp();
    paramQQAppInterface.c2c_type.set(1);
    paramQQAppInterface.svr_type.set(165);
    localObject1 = ((ayzl)localObject1).e(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
    if (localObject1 != null) {
      paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject1));
    }
    paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.comm_tmp.set(paramQQAppInterface);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = paramQQAppInterface.a().b(alof.ad, 0);
    Object localObject1 = new SubMsgType0x76.MsgBody();
    int j;
    int i;
    try
    {
      ((SubMsgType0x76.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      j = ((SubMsgType0x76.MsgBody)localObject1).uint32_msg_type.get();
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder().append("receive push, msg type = ").append(j).append(", local msg count = ");
        if (localObject2 != null)
        {
          i = ((List)localObject2).size();
          QLog.d("ActivateFriends.Processor", 2, i);
        }
      }
      else
      {
        if (localObject2 == null) {
          break label254;
        }
        paramArrayOfByte = ((List)localObject2).iterator();
        for (;;)
        {
          label113:
          if (paramArrayOfByte.hasNext())
          {
            localObject2 = (MessageRecord)paramArrayOfByte.next();
            if ((localObject2 instanceof MessageForActivateFriends))
            {
              localObject2 = (MessageForActivateFriends)localObject2;
              if ((((MessageForActivateFriends)localObject2).getMsgBody() != null) && (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() != j)) {
                continue;
              }
              paramQQAppInterface.a().b(alof.ad, 0, ((MessageForActivateFriends)localObject2).uniseq);
              continue;
              return false;
            }
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends", 2, "parse push got error.", paramQQAppInterface);
      }
    }
    label254:
    amga localamga;
    label405:
    do
    {
      i = -1;
      break;
      if (!QLog.isColorLevel()) {
        break label113;
      }
      QLog.e("ActivateFriends.Processor", 2, "local data is error." + localObject2);
      break label113;
      paramArrayOfByte = azaf.a(-5003);
      paramArrayOfByte.selfuin = paramQQAppInterface.getCurrentAccountUin();
      paramArrayOfByte.frienduin = alof.ad;
      paramArrayOfByte.istroop = 9002;
      paramArrayOfByte.senderuin = "";
      localObject2 = (alto)paramQQAppInterface.getManager(51);
      localamga = (amga)paramQQAppInterface.getManager(85);
      if (j != 1) {
        break label584;
      }
      if (((SubMsgType0x76.MsgBody)localObject1).msg_geographic_notify.rpt_msg_one_friend.get().size() <= 0) {
        break label565;
      }
      localObject2 = (MessageForActivateFriends)paramArrayOfByte;
      ((MessageForActivateFriends)localObject2).msg = amga.a(paramQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
      ((MessageForActivateFriends)localObject2).msgBody = ((SubMsgType0x76.MsgBody)localObject1);
      ((MessageForActivateFriends)localObject2).msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
      break label883;
      azqs.b(paramQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject2, localamga.jdField_a_of_type_Int, 0, "", "", "", "");
    } while (paramArrayOfByte == null);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends", 2, "activiate_friends|rec msg  fromUin:" + paramLong1 + " toUin:" + paramLong2 + " seq:" + paramInt1);
    }
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_from_uin", String.valueOf(paramLong1));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_to_uin", String.valueOf(paramLong2));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_seq", String.valueOf(paramInt1));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_type", String.valueOf(paramInt2));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_sub_type", String.valueOf(paramInt3));
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(paramArrayOfByte);
    paramQQAppInterface.a().a((ArrayList)localObject1, paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.isBackground_Stop);
    localamga.a(j);
    return true;
    label565:
    if (QLog.isColorLevel())
    {
      QLog.d("ActivateFriends", 2, "Geo friend list size = 0");
      break label920;
      label584:
      MessageForActivateFriends localMessageForActivateFriends;
      if (j == 2)
      {
        localObject2 = ((SubMsgType0x76.MsgBody)localObject1).msg_birthday_notify.rpt_msg_one_friend.get();
        if (((List)localObject2).size() > 0)
        {
          localMessageForActivateFriends = (MessageForActivateFriends)paramArrayOfByte;
          localMessageForActivateFriends.msgBody = ((SubMsgType0x76.MsgBody)localObject1);
          localMessageForActivateFriends.msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
          localMessageForActivateFriends.msg = amga.a(paramQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
          localObject1 = new HashSet();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Set)localObject1).add(String.valueOf(((SubMsgType0x76.OneBirthdayFriend)((Iterator)localObject2).next()).uint64_uin.get()));
          }
        }
        if (!QLog.isColorLevel()) {
          break label925;
        }
        QLog.d("ActivateFriends", 2, "Birth friend list size = 0");
        break label925;
        paramQQAppInterface.a().a((Set)localObject1);
      }
      else
      {
        if (j != 3) {
          break label935;
        }
        localObject2 = ((SubMsgType0x76.MsgBody)localObject1).msg_memorialday_notify.rpt_anniversary_info.get();
        if (((List)localObject2).size() > 0)
        {
          localObject2 = (SubMsgType0x76.OneMemorialDayInfo)((List)localObject2).get(0);
          localMessageForActivateFriends = (MessageForActivateFriends)paramArrayOfByte;
          localMessageForActivateFriends.msgBody = ((SubMsgType0x76.MsgBody)localObject1);
          localMessageForActivateFriends.msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
          localMessageForActivateFriends.msg = amga.a(paramQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
          azqs.b(paramQQAppInterface, "dc00898", "", "", "0X8007AD4", "0X8007AD4", (int)((SubMsgType0x76.OneMemorialDayInfo)localObject2).uint32_type.get(), 0, "", "", "", "");
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label930;
          }
          QLog.d("ActivateFriends", 2, "Memorial friend list size = 0");
          break label930;
        }
      }
    }
    label650:
    label920:
    label925:
    label930:
    label935:
    label940:
    label946:
    for (;;)
    {
      localObject2 = "0X8004E04";
      break;
      label883:
      if ((j == 1) || (j == 2)) {
        if (j != 1) {
          break label940;
        }
      }
      for (localObject1 = "0X8004E03";; localObject1 = "0X8004E04")
      {
        if (j != 1) {
          break label946;
        }
        localObject2 = "0X8004E03";
        break;
        paramArrayOfByte = null;
        break label883;
        paramArrayOfByte = null;
        break label650;
        paramArrayOfByte = null;
        break label883;
        paramArrayOfByte = null;
        break label883;
        break label405;
      }
    }
  }
  
  public static int b(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return paramQQAppInterface.a().a().a(paramInt);
    case 0: 
      return 1;
    case 1000: 
      return 3;
    case 10004: 
      return 24;
    case 1005: 
      return 6;
    case 1008: 
      return 8;
    case 1006: 
      return 10;
    case 1004: 
      return 5;
    case 1009: 
      return 11;
    case 3000: 
      return 4;
    case 1: 
      return 2;
    case 1001: 
      return 12;
    case 10002: 
      return 23;
    case 1033: 
      return 25;
    case 1034: 
      return 26;
    case 1020: 
      return 14;
    case 1021: 
      return 16;
    case 1022: 
      return 17;
    case 1023: 
      return 18;
    case 1024: 
    case 1025: 
      return 15;
    case 1010: 
      return 19;
    case 7400: 
      return 22;
    case 1026: 
      return 21;
    case 1037: 
      return 28;
    case 1036: 
      return 27;
    case 1044: 
      return 29;
    case 1045: 
      return 30;
    case 10007: 
      return 31;
    }
    return 32;
  }
  
  public static int b(msg_comm.Msg paramMsg)
  {
    int j;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramMsg = (im_msg_body.Elem)((Iterator)localObject).next();
      } while ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).bytes_pb_reserve.has()));
      localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramMsg.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!((generalflags.ResvAttr)localObject).uint32_req_font_effect_id.has()) {
          break label205;
        }
        i = ((generalflags.ResvAttr)localObject).uint32_req_font_effect_id.get();
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_FontEffectID->" + i);
            return i;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
    paramMsg.printStackTrace();
    return i;
    label205:
    return 0;
  }
  
  public static im_msg_body.RichText b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLimitChatConfirm)))
    {
      Object localObject1 = (MessageForLimitChatConfirm)paramChatMessage;
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(24);
      paramChatMessage = new im_msg_body.Elem();
      hummer_commelem.MsgElemInfo_servtype24 localMsgElemInfo_servtype24 = new hummer_commelem.MsgElemInfo_servtype24();
      if (((MessageForLimitChatConfirm)localObject1).bEnterMsg)
      {
        localMsgElemInfo_servtype24.limit_chat_enter.bytes_match_nick.set(ByteStringMicro.copyFromUtf8(((MessageForLimitChatConfirm)localObject1).SenderNickName));
        localMsgElemInfo_servtype24.limit_chat_enter.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(((MessageForLimitChatConfirm)localObject1).tipsWording));
        localMsgElemInfo_servtype24.limit_chat_enter.uint32_left_chat_time.set(((MessageForLimitChatConfirm)localObject1).leftChatTime);
        localMsgElemInfo_servtype24.limit_chat_enter.uint32_c2c_expired_time.set(((MessageForLimitChatConfirm)localObject1).c2cExpiredTime);
        localMsgElemInfo_servtype24.limit_chat_enter.uint32_match_expired_time.set(((MessageForLimitChatConfirm)localObject1).matchExpiredTime);
        localMsgElemInfo_servtype24.limit_chat_enter.uint64_match_ts.set(((MessageForLimitChatConfirm)localObject1).timeStamp);
        localMsgElemInfo_servtype24.limit_chat_enter.uint64_ready_ts.set(((MessageForLimitChatConfirm)localObject1).readyTs);
        localMsgElemInfo_servtype24.limit_chat_enter.setHasFlag(true);
        if (!((MessageForLimitChatConfirm)localObject1).bEnterMsg) {
          break label352;
        }
      }
      label352:
      for (int i = 1;; i = 2)
      {
        ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(i, true);
        ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype24.toByteArray()), true);
        paramChatMessage.common_elem.set((MessageMicro)localObject2, true);
        localObject1 = new im_msg_body.Elem();
        localObject2 = new im_msg_body.Text();
        ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(alud.a(2131707046)));
        ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
        ((im_msg_body.Elem)localObject1).text.setHasFlag(true);
        localObject2 = new im_msg_body.RichText();
        ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
        ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
        if (QLog.isColorLevel()) {
          QLog.d("LimitChat", 2, "getSendLimitChatConfirmMsgBody");
        }
        return localObject2;
        localMsgElemInfo_servtype24.limit_chat_exit.uint32_exit_method.set(((MessageForLimitChatConfirm)localObject1).leaveChatType);
        localMsgElemInfo_servtype24.limit_chat_exit.uint64_match_ts.set(((MessageForLimitChatConfirm)localObject1).timeStamp);
        localMsgElemInfo_servtype24.limit_chat_exit.setHasFlag(true);
        break;
      }
    }
    return null;
  }
  
  public static im_msg_body.RichText b(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null)
    {
      paramChatMessage = null;
      return paramChatMessage;
    }
    if (!(paramChatMessage instanceof MessageForArkApp)) {
      return null;
    }
    Object localObject1 = (MessageForArkApp)paramChatMessage;
    if ((localObject1 == null) || (((MessageForArkApp)localObject1).ark_app_message == null)) {
      return null;
    }
    Object localObject2 = ((MessageForArkApp)localObject1).ark_app_message.toPbData();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      return null;
    }
    localObject2 = azwm.b((byte[])localObject2);
    if ((localObject2 == null) || (localObject2.length == 0)) {
      return null;
    }
    Object localObject3 = new ByteArrayOutputStream();
    try
    {
      ((ByteArrayOutputStream)localObject3).write(1);
      ((ByteArrayOutputStream)localObject3).write((byte[])localObject2);
      if ((!TextUtils.isEmpty(((MessageForArkApp)localObject1).resIDForLongMsg)) && (!paramBoolean))
      {
        paramChatMessage = new im_msg_body.RichText();
        localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).general_flags.long_text_flag.set(1);
        ((im_msg_body.Elem)localObject2).general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(((MessageForArkApp)localObject1).resIDForLongMsg));
        paramChatMessage.elems.add((MessageMicro)localObject2);
        return paramChatMessage;
      }
    }
    catch (Exception paramChatMessage)
    {
      return null;
    }
    Object localObject4;
    if (((MessageForArkApp)localObject1).ark_app_message.containStructMsg != null)
    {
      localObject1 = a((MessageForStructing)((MessageForArkApp)localObject1).ark_app_message.containStructMsg);
      localObject4 = new hummer_commelem.MsgElemInfo_servtype20();
      ((hummer_commelem.MsgElemInfo_servtype20)localObject4).bytes_data.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject3).toByteArray()));
      localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(20);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype20)localObject4).toByteArray()));
      localObject3 = ((im_msg_body.CommonElem)localObject2).uint32_business_type;
      if (!"1".equals(paramChatMessage.getExtInfoFromExtStr(ayzs.e))) {
        break label469;
      }
    }
    label469:
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject3).set(i);
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject2);
      paramChatMessage = (ChatMessage)localObject1;
      if (localObject1 == null) {
        break;
      }
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
      return localObject1;
      localObject2 = new im_msg_body.RichText();
      if (((MessageForArkApp)localObject1).ark_app_message.compatibleText != null) {
        localObject1 = ((MessageForArkApp)localObject1).ark_app_message.compatibleText;
      }
      for (;;)
      {
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject4 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject4).str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject4);
          ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
        }
        localObject1 = localObject2;
        break;
        localObject1 = ((MessageForArkApp)localObject1).getSummery();
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          localObject1 = BaseApplication.getContext().getString(2131693912);
        } else {
          localObject1 = String.format(BaseApplication.getContext().getString(2131693913), new Object[] { localObject1 });
        }
      }
    }
  }
  
  public static im_msg_body.RichText b(MessageForApollo paramMessageForApollo)
  {
    im_msg_body.ApolloActMsg localApolloActMsg = new im_msg_body.ApolloActMsg();
    ApolloMessage localApolloMessage = paramMessageForApollo.mApolloMessage;
    localApolloActMsg.uint32_action_id.set(localApolloMessage.id);
    localApolloActMsg.uint32_flag.set(localApolloMessage.flag);
    localApolloActMsg.uint32_peer_uin.set(bdeu.a(localApolloMessage.peer_uin));
    localApolloActMsg.uint32_sender_ts.set(bdeu.a(localApolloMessage.sender_ts));
    localApolloActMsg.uint32_peer_ts.set(bdeu.a(localApolloMessage.peer_ts));
    localApolloActMsg.int32_sender_status.set(localApolloMessage.sender_status);
    localApolloActMsg.int32_peer_status.set(localApolloMessage.peer_status);
    Object localObject1 = new ApolloMsgExtend.AuthReserve();
    ((ApolloMsgExtend.AuthReserve)localObject1).diy_voice_id.set(paramMessageForApollo.audioId);
    ((ApolloMsgExtend.AuthReserve)localObject1).diy_voice_begin_ts.set((paramMessageForApollo.audioStartTime * 1000.0F));
    ((ApolloMsgExtend.AuthReserve)localObject1).game_id.set(paramMessageForApollo.gameId);
    ((ApolloMsgExtend.AuthReserve)localObject1).sub_type.set(paramMessageForApollo.msgType);
    ((ApolloMsgExtend.AuthReserve)localObject1).room_id.set(paramMessageForApollo.roomId);
    if (!TextUtils.isEmpty(paramMessageForApollo.gameName)) {
      ((ApolloMsgExtend.AuthReserve)localObject1).game_name.set(ByteStringMicro.copyFrom(paramMessageForApollo.gameName.getBytes()));
    }
    if (!TextUtils.isEmpty(paramMessageForApollo.gameExtendJson)) {
      ((ApolloMsgExtend.AuthReserve)localObject1).game_share_ark_json.set(ByteStringMicro.copyFrom(paramMessageForApollo.gameExtendJson.getBytes()));
    }
    ((ApolloMsgExtend.AuthReserve)localObject1).action_type.set(paramMessageForApollo.actionType);
    if (!TextUtils.isEmpty(paramMessageForApollo.extendJson)) {
      ((ApolloMsgExtend.AuthReserve)localObject1).extend_json.set(ByteStringMicro.copyFrom(paramMessageForApollo.extendJson.getBytes()));
    }
    if (paramMessageForApollo.mApollo3DMessage != null)
    {
      localObject2 = paramMessageForApollo.mApollo3DMessage;
      ApolloMsgExtend.ThreeDBaseInfo localThreeDBaseInfo = new ApolloMsgExtend.ThreeDBaseInfo();
      localThreeDBaseInfo.uint32_action_id.set(((Apollo3DMessage)localObject2).actionID_3D);
      localThreeDBaseInfo.action_type.set(((Apollo3DMessage)localObject2).actionType_3D);
      localThreeDBaseInfo.bytes_action_name.set(ByteStringMicro.copyFrom(((Apollo3DMessage)localObject2).actionName_3D.getBytes()));
      localThreeDBaseInfo.int32_sender_status.set(((Apollo3DMessage)localObject2).senderStatus_3D);
      localThreeDBaseInfo.int32_peer_status.set(((Apollo3DMessage)localObject2).peerStatus_3D);
      ((ApolloMsgExtend.AuthReserve)localObject1).act3d.set(localThreeDBaseInfo);
    }
    localObject1 = ((ApolloMsgExtend.AuthReserve)localObject1).toByteArray();
    if ((localObject1 != null) && (localObject1.length > 0)) {
      localApolloActMsg.bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject1));
    }
    if (localApolloMessage.name != null) {
      localApolloActMsg.bytes_action_name.set(ByteStringMicro.copyFrom(localApolloMessage.name));
    }
    if (localApolloMessage.text != null) {
      localApolloActMsg.bytes_action_text.set(ByteStringMicro.copyFrom(localApolloMessage.text));
    }
    if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
      localApolloActMsg.input_text.set(ByteStringMicro.copyFrom(paramMessageForApollo.inputText.getBytes()));
    }
    Object localObject2 = new im_msg_body.Text();
    localObject1 = alud.a(2131707047);
    paramMessageForApollo = (MessageForApollo)localObject1;
    if (localApolloMessage.name != null) {
      paramMessageForApollo = (String)localObject1 + new String(localApolloMessage.name);
    }
    ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(paramMessageForApollo));
    paramMessageForApollo = new im_msg_body.RichText();
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).apollo_msg.set(localApolloActMsg);
    paramMessageForApollo.elems.add((MessageMicro)localObject1);
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
    paramMessageForApollo.elems.add((MessageMicro)localObject1);
    return paramMessageForApollo;
  }
  
  public static void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, ayzj paramayzj)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_QCall return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      }
    }
    do
    {
      for (;;)
      {
        return;
        long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
        Object localObject1 = l4 + "-" + l3;
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall :  key:" + (String)localObject1);
        }
        if (paramMessageHandler.app.a().a(l2, (String)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("decodeC2CMsgPkg_QCall", 2, "msg has been pulled");
          }
        }
        else
        {
          l3 = ayzl.a();
          l4 = Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
          paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          localObject1 = new byte[4];
          Object localObject2 = new byte[4];
          System.arraycopy(paramMsg, 0, localObject1, 0, 4);
          System.arraycopy(paramMsg, 4, localObject2, 0, 4);
          int i = lfx.a((byte[])localObject1, 4);
          int j = lfx.a((byte[])localObject2, 4);
          if ((i <= 0) || (j <= 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("decodeC2CMsgPkg_QCall", 2, "invalid head length:" + i + " or body length:" + j);
            }
          }
          else
          {
            localObject1 = null;
            try
            {
              localObject2 = new head.Head();
              byte[] arrayOfByte = new byte[i];
              System.arraycopy(paramMsg, 8, arrayOfByte, 0, i);
              ((head.Head)localObject2).mergeFrom(arrayOfByte);
              int k = ((head.Head)localObject2).msg_msg_head.msg_content_head.uint32_type.get();
              int m = ((head.Head)localObject2).msg_msg_head.msg_content_head.uint32_subtype.get();
              if ((k == 562) && (m == 17))
              {
                localObject2 = new im_msg_body.MsgBody();
                arrayOfByte = new byte[j];
                System.arraycopy(paramMsg, i + 8, arrayOfByte, 0, j);
                ((im_msg_body.MsgBody)localObject2).mergeFrom(arrayOfByte);
                paramMsg = ((im_msg_body.MsgBody)localObject2).msg_content.get().toByteArray();
                if (paramMsg == null)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("decodeC2CMsgPkg_QCall", 2, "msg sharp content null, return;");
                }
              }
              else
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("decodeC2CMsgPkg_QCall", 2, "error msgType:" + k + ", or subType:" + m);
                return;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                paramMsg = (msg_comm.Msg)localObject1;
                if (QLog.isColorLevel())
                {
                  QLog.d("decodeC2CMsgPkg_QCall", 2, "error when process qcall offline msg", localException);
                  paramMsg = (msg_comm.Msg)localObject1;
                }
              }
              boolean bool = lnp.a(paramMsg);
              if (((!paramayzj.jdField_a_of_type_Boolean) && (!paramayzj.f)) || ((paramayzj.jdField_a_of_type_Long != paramayzj.jdField_b_of_type_Long) || ((paramayzj.jdField_a_of_type_Long == paramayzj.jdField_b_of_type_Long) && (!bool))))
              {
                if (QLog.isColorLevel()) {
                  QLog.e("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall return null:,isReaded:" + paramayzj.jdField_a_of_type_Boolean + "syncOther:" + paramayzj.f + ",isSharpRequest" + bool);
                }
              }
              else
              {
                mto.a(l2);
                mto.a(l4);
                try
                {
                  new maf(BaseApplicationImpl.getContext()).a(new azae(paramMsg, l3 - l1, paramMessageHandler, l4, l2, l1, bool));
                  return;
                }
                catch (Exception paramMessageHandler) {}
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("decodeC2CMsgPkg_QCall", 2, "exception when process qcall offline msg", paramMessageHandler);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, submsgtype0xb1.InviteInfo paramInviteInfo, boolean paramBoolean)
  {
    submsgtype0xb1.InviteInfo localInviteInfo;
    long l1;
    if (paramInviteInfo.has())
    {
      localInviteInfo = (submsgtype0xb1.InviteInfo)paramInviteInfo.get();
      l1 = System.currentTimeMillis() / 1000L;
      if (l1 - localInviteInfo.uint32_expire_time.get() <= 900L) {
        break label110;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "邀请过期了=》troopUin:" + localInviteInfo.uint64_group_code.get() + "|uint32_expire_time:" + localInviteInfo.uint32_expire_time.get() + ", currentTime:" + l1);
      }
    }
    label110:
    Object localObject;
    do
    {
      do
      {
        long l2;
        do
        {
          return;
          if ((paramBoolean) || (!a.containsKey(localInviteInfo.str_id.get()))) {
            break;
          }
          l2 = ((Long)a.get(localInviteInfo.str_id.get())).longValue();
          if (l1 - l2 >= 10L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "离线-上线的时候收到邀请的前10s内先收到了取消的邀请=》troopUin:" + localInviteInfo.uint64_group_code.get() + "|receiveUnInviteTime:" + l2 + ", currentTime:" + l1);
        return;
        paramBoolean = paramQQAppInterface.a().c(localInviteInfo.uint64_group_code.get());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "msgBody.invite_info.has()==》troopUin:" + localInviteInfo.uint64_group_code.get() + "|uint32_expire_time:" + localInviteInfo.uint32_expire_time.get() + ", currentTime:" + l1 + ", hasGroupVideo:" + paramBoolean);
        }
        localObject = (TroopManager)paramQQAppInterface.getManager(52);
      } while ((!paramBoolean) || (((TroopManager)localObject).d(localInviteInfo.uint64_group_code.get() + "", localInviteInfo.uint64_uin.get() + "")));
      paramBoolean = false;
      if (paramQQAppInterface.a().b() > 0L) {
        paramBoolean = true;
      }
      if (((TroopManager)localObject).b() != 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "只允许同时存在两个邀请框");
    return;
    if (((TroopManager)localObject).b() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "hasGroupInviting");
      }
      paramInviteInfo = new Intent(paramQQAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
      paramInviteInfo.putExtra("uinType", 1);
      paramInviteInfo.putExtra("peerUin", String.valueOf(localInviteInfo.uint64_uin.get()));
    }
    for (;;)
    {
      ((TroopManager)localObject).c(String.valueOf(localInviteInfo.uint64_group_code.get()), String.valueOf(localInviteInfo.uint64_uin.get()));
      if (((KeyguardManager)paramQQAppInterface.getApp().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("tencent.video.v2q.ReceiveRequest");
        ((Intent)localObject).putExtra("revVideoRequest", true);
        ((Intent)localObject).setPackage(paramQQAppInterface.getApp().getPackageName());
        paramQQAppInterface.getApp().sendBroadcast((Intent)localObject);
      }
      paramInviteInfo.addFlags(268435456);
      paramInviteInfo.putExtra("relationType", 1);
      paramInviteInfo.putExtra("discussId", localInviteInfo.uint64_group_code.get());
      paramInviteInfo.putExtra("friendUin", localInviteInfo.uint64_uin.get());
      paramInviteInfo.putExtra("inviteId", localInviteInfo.str_id.get());
      paramInviteInfo.putExtra("hasGVideoJoined", paramBoolean);
      paramInviteInfo.putExtra("memberType", mwu.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), localInviteInfo.uint64_group_code.get() + ""));
      paramQQAppInterface.getApp().startActivity(paramInviteInfo);
      return;
      paramInviteInfo = new Intent(paramQQAppInterface.getApp().getApplicationContext(), GaInviteDialogActivity.class);
    }
  }
  
  public static int c(msg_comm.Msg paramMsg)
  {
    int j;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramMsg = (im_msg_body.Elem)((Iterator)localObject).next();
      } while ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).bytes_pb_reserve.has()));
      localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramMsg.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!((generalflags.ResvAttr)localObject).uint32_pendant_diy_id.has()) {
          break label205;
        }
        i = ((generalflags.ResvAttr)localObject).uint32_pendant_diy_id.get();
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_PendantDiyID->" + i);
            return i;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
    paramMsg.printStackTrace();
    return i;
    label205:
    return 0;
  }
  
  public static im_msg_body.RichText c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
          } while (!(paramChatMessage instanceof MessageForArkFlashChat));
          paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
        } while ((paramChatMessage == null) || (paramChatMessage.ark_app_message == null));
        localObject1 = paramChatMessage.ark_app_message.toPbData();
      } while ((localObject1 == null) || (localObject1.length == 0));
      localObject2 = azwm.b((byte[])localObject1);
    } while ((localObject2 == null) || (localObject2.length == 0));
    Object localObject1 = new ByteArrayOutputStream();
    try
    {
      ((ByteArrayOutputStream)localObject1).write(1);
      ((ByteArrayOutputStream)localObject1).write((byte[])localObject2);
      localObject2 = new hummer_commelem.MsgElemInfo_servtype14();
      ((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject1).toByteArray()));
      ((hummer_commelem.MsgElemInfo_servtype14)localObject2).uint32_id.set(paramChatMessage.ark_app_message.appResId);
      localObject1 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(0);
      ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(14);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype14)localObject2).toByteArray()));
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).common_elem.set((MessageMicro)localObject1);
      paramChatMessage = a(azah.a(paramChatMessage.getSummery(), true, null), null);
      paramChatMessage.elems.add((MessageMicro)localObject2);
      return paramChatMessage;
    }
    catch (Exception paramChatMessage) {}
    return null;
  }
  
  public static im_msg_body.RichText c(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    int i = 1;
    if (paramChatMessage == null) {
      return null;
    }
    if (!(paramChatMessage instanceof MessageForArkBabyqReply)) {
      return null;
    }
    Object localObject1 = (MessageForArkBabyqReply)paramChatMessage;
    paramChatMessage = ((MessageForArkBabyqReply)localObject1).toPbData();
    if ((paramChatMessage == null) || (paramChatMessage.length == 0)) {
      return null;
    }
    paramChatMessage = azwm.b(paramChatMessage);
    if ((paramChatMessage == null) || (paramChatMessage.length == 0)) {
      return null;
    }
    Object localObject2 = new ByteArrayOutputStream();
    try
    {
      ((ByteArrayOutputStream)localObject2).write(1);
      ((ByteArrayOutputStream)localObject2).write(paramChatMessage);
      paramChatMessage = new im_msg_body.RichText();
      if ((!TextUtils.isEmpty(((MessageForArkBabyqReply)localObject1).resIDForLongMsg)) && (!paramBoolean))
      {
        localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).general_flags.long_text_flag.set(1);
        ((im_msg_body.Elem)localObject2).general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(((MessageForArkBabyqReply)localObject1).resIDForLongMsg));
        paramChatMessage.elems.add((MessageMicro)localObject2);
        return paramChatMessage;
      }
    }
    catch (Exception paramChatMessage)
    {
      return null;
    }
    Object localObject3 = new hummer_commelem.MsgElemInfo_servtype19();
    ((hummer_commelem.MsgElemInfo_servtype19)localObject3).bytes_data.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject2).toByteArray()));
    localObject2 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(19);
    ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype19)localObject3).toByteArray()));
    localObject3 = ((im_msg_body.CommonElem)localObject2).uint32_business_type;
    if (((MessageForArkBabyqReply)localObject1).showAsBabyq) {}
    for (;;)
    {
      ((PBUInt32Field)localObject3).set(i);
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject2);
      paramChatMessage.elems.add((MessageMicro)localObject3);
      localObject2 = ((MessageForArkBabyqReply)localObject1).babyqReplyText;
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break;
      }
      localObject1 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).text.set((MessageMicro)localObject1);
      paramChatMessage.elems.add((MessageMicro)localObject2);
      break;
      i = 2;
    }
  }
  
  public static void c(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, ayzj paramayzj)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) || (paramayzj.jdField_a_of_type_Boolean) || (paramayzj.f)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Video return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramayzj.jdField_a_of_type_Boolean + "syncOther:" + paramayzj.f);
      }
    }
    long l1;
    long l2;
    long l3;
    Object localObject;
    label511:
    do
    {
      int i;
      HashMap localHashMap;
      do
      {
        do
        {
          long l4;
          do
          {
            do
            {
              return;
              l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
              l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
              long l5 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
              l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
              long l6 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
              l3 = Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
              localObject = l2 + "-" + l6 + "-" + l5 + "-" + l4;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Video :  key:" + (String)localObject);
              }
              localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
              l4 = ayzl.a() - l1;
              i = lnp.a((byte[])localObject);
              if ((lnz.c()) && (lnz.d())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("svenxu", 2, "Discard video message cause device not support");
            return;
            if (l4 < 60L) {
              break;
            }
          } while ((i == 1) && (!QLog.isColorLevel()));
          QLog.d("svenxu", 2, "Discard video message because of time out " + l4 + " s");
          return;
          localHashMap = (HashMap)paramayzj.a(1000);
          paramayzj = (HashSet)paramayzj.a(1001);
          if (i != 1) {
            break label511;
          }
          if (lnz.c()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("shanezhaiSHARP", 2, "discard video push message because the sdk is lower");
        return;
      } while (localHashMap == null);
      localHashMap.put(Long.valueOf(l2), paramMsg);
      return;
      if (i != 3) {
        break;
      }
    } while (!lnz.c());
    if (paramayzj != null) {
      paramayzj.add(Long.valueOf(l2));
    }
    paramMessageHandler.a(l3, (byte[])localObject, l2, (int)l1);
    return;
    paramMessageHandler.a(l3, (byte[])localObject, l2, (int)l1);
  }
  
  public static int d(msg_comm.Msg paramMsg)
  {
    int j;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramMsg = (im_msg_body.Elem)((Iterator)localObject).next();
      } while ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).bytes_pb_reserve.has()));
      localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramMsg.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!((generalflags.ResvAttr)localObject).uint32_face_id.has()) {
          break label210;
        }
        i = ((generalflags.ResvAttr)localObject).uint32_face_id.get();
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_FaceID->" + i);
            return i;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
    QLog.e("Q.msg.MessageHandler", 1, "", paramMsg);
    return i;
    label210:
    return 0;
  }
  
  public static im_msg_body.RichText d(ChatMessage paramChatMessage)
  {
    Object localObject1 = null;
    if (!(paramChatMessage instanceof MessageForHiBoom)) {
      paramChatMessage = (ChatMessage)localObject1;
    }
    do
    {
      do
      {
        return paramChatMessage;
        localObject2 = (MessageForHiBoom)paramChatMessage;
        paramChatMessage = (ChatMessage)localObject1;
      } while (((MessageForHiBoom)localObject2).mHiBoomMessage == null);
      paramChatMessage = new hummer_commelem.MsgElemInfo_servtype14();
      paramChatMessage.uint32_id.set(((MessageForHiBoom)localObject2).mHiBoomMessage.id);
      localObject1 = new hiboom_type.Hiboom_Type();
      ((hiboom_type.Hiboom_Type)localObject1).uint32_hiboom_type.set(((MessageForHiBoom)localObject2).mHiBoomMessage.type);
      paramChatMessage.reserve_Info.set(ByteStringMicro.copyFrom(((hiboom_type.Hiboom_Type)localObject1).toByteArray()));
      localObject1 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(1);
      ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(14);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(paramChatMessage.toByteArray()));
      paramChatMessage = new im_msg_body.Elem();
      paramChatMessage.common_elem.set((MessageMicro)localObject1);
      localObject1 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject1).elems.add(paramChatMessage);
      localObject2 = ((MessageForHiBoom)localObject2).mHiBoomMessage.text;
      paramChatMessage = (ChatMessage)localObject1;
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    paramChatMessage = new im_msg_body.Text();
    paramChatMessage.str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    Object localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set(paramChatMessage);
    ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    return localObject1;
  }
  
  public static int e(msg_comm.Msg paramMsg)
  {
    int i;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      im_msg_body.Elem localElem;
      do
      {
        if (!paramMsg.hasNext()) {
          break;
        }
        localElem = (im_msg_body.Elem)paramMsg.next();
      } while ((!localElem.general_flags.has()) || (!((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_sub_id.has()));
      j = ((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_sub_id.get();
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_SubBubbleID->" + j);
    return j;
    return 0;
  }
  
  public static im_msg_body.RichText e(ChatMessage paramChatMessage)
  {
    Object localObject1 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(2);
    if ((paramChatMessage instanceof MessageForPoke))
    {
      localObject2 = new hummer_commelem.MsgElemInfo_servtype2();
      paramChatMessage = (MessageForPoke)paramChatMessage;
      int i = paramChatMessage.interactType;
      int j = paramChatMessage.doubleHitState;
      int k = paramChatMessage.strength;
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_type.set(i);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_double_hit.set(j);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_vaspoke_id.set(paramChatMessage.subId);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).bytes_vaspoke_name.set(ByteStringMicro.copyFromUtf8(paramChatMessage.name));
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).bytes_vaspoke_minver.set(ByteStringMicro.copyFromUtf8(paramChatMessage.minVersion));
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_strength.set(k);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_flag.set(paramChatMessage.flag);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype2)localObject2).toByteArray()));
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(i);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "getSendPokeMsgBody type:" + i + " ,doubleHitState:" + j);
      }
    }
    paramChatMessage = new im_msg_body.Elem();
    paramChatMessage.common_elem.set((MessageMicro)localObject1);
    Object localObject2 = alud.a(2131707045);
    localObject1 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set((MessageMicro)localObject1);
    localObject1 = new im_msg_body.RichText();
    ((im_msg_body.RichText)localObject1).elems.add(paramChatMessage);
    ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
    }
    return localObject1;
  }
  
  public static int f(msg_comm.Msg paramMsg)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return 0;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    while (paramMsg.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramMsg.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.has()))
      {
        int i = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.get();
        if (i == 1) {
          return 1;
        }
        if (i == 2) {
          return 2;
        }
      }
    }
    return 0;
  }
  
  public static im_msg_body.RichText f(ChatMessage paramChatMessage)
  {
    Object localObject3 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject3).uint32_service_type.set(23);
    Object localObject2 = alud.a(2131707050);
    Object localObject1 = "";
    hummer_commelem.MsgElemInfo_servtype23 localMsgElemInfo_servtype23;
    int i;
    int j;
    PBBytesField localPBBytesField;
    if ((paramChatMessage instanceof MessageForPokeEmo))
    {
      localMsgElemInfo_servtype23 = new hummer_commelem.MsgElemInfo_servtype23();
      paramChatMessage = (MessageForPokeEmo)paramChatMessage;
      i = paramChatMessage.pokeemoId;
      j = paramChatMessage.pokeemoPressCount;
      paramChatMessage = paramChatMessage.summary;
      localObject2 = String.format("[%s]x%d", new Object[] { paramChatMessage, Integer.valueOf(j) });
      localMsgElemInfo_servtype23.uint32_face_type.set(i);
      localMsgElemInfo_servtype23.uint32_face_bubble_count.set(j);
      localPBBytesField = localMsgElemInfo_servtype23.bytes_face_summary;
      if (paramChatMessage != null) {
        break label356;
      }
    }
    label356:
    for (localObject1 = "";; localObject1 = paramChatMessage)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      ((im_msg_body.CommonElem)localObject3).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype23.toByteArray()));
      ((im_msg_body.CommonElem)localObject3).uint32_business_type.set(i);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "getSendPokeEmoMsgBody pokeemoId:" + i + " ,pokeemoPressCount:" + j);
      }
      localObject1 = localObject2;
      localObject2 = paramChatMessage;
      paramChatMessage = new im_msg_body.Elem();
      paramChatMessage.common_elem.set((MessageMicro)localObject3);
      localObject3 = String.format("[%s]请使用最新版手机QQ体验新功能。", new Object[] { localObject2 });
      localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      localObject1 = new TextMsgExtPb.ResvAttr();
      ((TextMsgExtPb.ResvAttr)localObject1).wording.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      ((im_msg_body.Text)localObject2).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((TextMsgExtPb.ResvAttr)localObject1).toByteArray()));
      localObject1 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
      }
      return localObject2;
    }
  }
  
  public static im_msg_body.RichText g(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForScribble)))
    {
      Object localObject1 = (MessageForScribble)paramChatMessage;
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(11);
      paramChatMessage = new im_msg_body.Elem();
      hummer_commelem.MsgElemInfo_servtype11 localMsgElemInfo_servtype11 = new hummer_commelem.MsgElemInfo_servtype11();
      localMsgElemInfo_servtype11.bytes_Doodle_url.set(ByteStringMicro.copyFromUtf8(((MessageForScribble)localObject1).combineFileUrl));
      localMsgElemInfo_servtype11.bytes_Doodle_md5.set(ByteStringMicro.copyFromUtf8(((MessageForScribble)localObject1).combineFileMd5));
      localMsgElemInfo_servtype11.uint32_doodleData_offset.set(((MessageForScribble)localObject1).offSet);
      localMsgElemInfo_servtype11.uint32_doodle_gif_id.set(((MessageForScribble)localObject1).gifId);
      ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(1);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype11.toByteArray()));
      paramChatMessage.common_elem.set((MessageMicro)localObject2);
      localObject1 = new im_msg_body.Elem();
      localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(alud.a(2131707042)));
      ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
      ((im_msg_body.Elem)localObject1).text.setHasFlag(true);
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
      if (QLog.isColorLevel()) {
        QLog.d("pap", 2, "getSendPapScribeMsgBody");
      }
      return localObject2;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azad
 * JD-Core Version:    0.7.0.1
 */