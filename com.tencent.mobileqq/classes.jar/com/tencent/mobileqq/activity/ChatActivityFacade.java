package com.tencent.mobileqq.activity;

import AccostSvc.EventItem;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import NS_MOBILE_AIONewestFeed.Media_Data;
import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import VIP.AIOSendReq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.etrump.mixlayout.FontManager;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.util.SubString;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.app.VIPAioSendHandler;
import com.tencent.mobileqq.app.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgHelper;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rup;
import rur;
import rus;
import ruv;
import rux;
import ruy;
import rva;
import rvc;
import rvd;
import rve;
import rvf;
import rvg;
import rvh;
import rvi;
import rvj;
import rvk;
import rvl;
import rvm;

public class ChatActivityFacade
{
  public static long a;
  public static ChatMessage a;
  public static QQToast a;
  public static ActionSheet a;
  public static List a;
  private static rvm a;
  public static ActionSheet b;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_Rvm = new rvm();
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList paramArrayList)
  {
    paramArrayList = StructMsgHelper.a(paramArrayList);
    String str = paramQQAppInterface.getCurrentAccountUin();
    int i = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = i + 1;
    long l = i;
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l, paramArrayList);
    paramSessionInfo.msgUid = MessageUtils.a(paramInt);
    if (!MessageHandlerUtils.a(paramQQAppInterface, paramSessionInfo, false)) {
      paramQQAppInterface.a().b(paramSessionInfo, paramSessionInfo.selfuin);
    }
    return paramSessionInfo.uniseq;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)a(paramQQAppInterface, paramString, paramSessionInfo, -3, 0);
    long l = 0L;
    if (localMessageForPtt != null) {
      l = localMessageForPtt.uniseq;
    }
    if (l != -1L)
    {
      int i = QQRecorder.a(localMessageForPtt);
      int j = RecordParams.a(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
      a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString, l, true, i * 1000, j, true, 0, 0, true, localMessageForPtt.vipSubBubbleId, localBundle);
    }
    return l;
  }
  
  /* Error */
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    // Byte code:
    //   0: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +42 -> 45
    //   6: ldc 134
    //   8: iconst_2
    //   9: new 136	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   16: ldc 139
    //   18: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   24: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 154
    //   29: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: getfield 157	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   36: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_2
    //   46: ifnull +1084 -> 1130
    //   49: aload_2
    //   50: iconst_1
    //   51: aload 9
    //   53: invokestatic 169	com/tencent/mobileqq/service/message/MessageUtils:a	(Ljava/lang/String;ZLjava/util/ArrayList;)Ljava/lang/String;
    //   56: astore 11
    //   58: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +30 -> 91
    //   64: ldc 134
    //   66: iconst_2
    //   67: new 136	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   74: ldc 171
    //   76: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   82: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload 10
    //   93: getfield 175	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:c	J
    //   96: lconst_0
    //   97: lcmp
    //   98: ifeq +573 -> 671
    //   101: new 177	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   104: dup
    //   105: invokespecial 178	com/tencent/mobileqq/data/MessageForWantGiftMsg:<init>	()V
    //   108: astore_2
    //   109: aload_2
    //   110: checkcast 177	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   113: aload 10
    //   115: getfield 175	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:c	J
    //   118: putfield 181	com/tencent/mobileqq/data/MessageForWantGiftMsg:wantGiftSenderUin	J
    //   121: aload_2
    //   122: checkcast 177	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   125: getstatic 184	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   128: new 136	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   135: aload 10
    //   137: getfield 175	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:c	J
    //   140: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   143: ldc 186
    //   145: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 190	com/tencent/mobileqq/data/MessageForWantGiftMsg:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_2
    //   155: sipush -2056
    //   158: putfield 195	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   161: aload_0
    //   162: aload_2
    //   163: aload_1
    //   164: getfield 53	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   167: aload_1
    //   168: getfield 197	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   171: aload_1
    //   172: getfield 54	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   175: invokestatic 200	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;I)V
    //   178: aload_2
    //   179: aload 11
    //   181: putfield 203	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   184: aload_2
    //   185: iload 8
    //   187: invokestatic 64	com/tencent/mobileqq/service/message/MessageUtils:a	(I)J
    //   190: putfield 204	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   193: aload_2
    //   194: iload 5
    //   196: putfield 207	com/tencent/mobileqq/data/ChatMessage:longMsgCount	I
    //   199: aload_2
    //   200: iload 6
    //   202: putfield 210	com/tencent/mobileqq/data/ChatMessage:longMsgIndex	I
    //   205: aload_2
    //   206: iload 7
    //   208: putfield 213	com/tencent/mobileqq/data/ChatMessage:longMsgId	I
    //   211: aload_2
    //   212: iconst_1
    //   213: putfield 217	com/tencent/mobileqq/data/ChatMessage:mAnimFlag	Z
    //   216: aload_2
    //   217: getfield 203	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   220: astore 11
    //   222: aload 11
    //   224: ldc 219
    //   226: invokevirtual 224	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   229: istore_3
    //   230: iload_3
    //   231: iconst_m1
    //   232: if_icmpeq +80 -> 312
    //   235: iload_3
    //   236: ldc 219
    //   238: invokevirtual 228	java/lang/String:length	()I
    //   241: iadd
    //   242: istore_3
    //   243: aload 11
    //   245: ldc 230
    //   247: invokevirtual 224	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   250: istore 5
    //   252: aload_2
    //   253: ldc 232
    //   255: aload 11
    //   257: iload_3
    //   258: iload 5
    //   260: invokevirtual 236	java/lang/String:substring	(II)Ljava/lang/String;
    //   263: invokevirtual 237	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_2
    //   267: new 136	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   274: aload 11
    //   276: iconst_0
    //   277: iload_3
    //   278: ldc 219
    //   280: invokevirtual 228	java/lang/String:length	()I
    //   283: isub
    //   284: invokevirtual 236	java/lang/String:substring	(II)Ljava/lang/String;
    //   287: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 11
    //   292: iload 5
    //   294: ldc 230
    //   296: invokevirtual 228	java/lang/String:length	()I
    //   299: iadd
    //   300: invokevirtual 240	java/lang/String:substring	(I)Ljava/lang/String;
    //   303: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: putfield 203	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   312: aload_2
    //   313: ldc 232
    //   315: invokevirtual 244	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   318: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   321: ifne +15 -> 336
    //   324: aload_2
    //   325: aconst_null
    //   326: invokestatic 255	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;)V
    //   329: invokestatic 258	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiStickerManager;
    //   332: aload_2
    //   333: invokevirtual 261	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   336: aload 10
    //   338: getfield 264	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:g	Z
    //   341: ifeq +8 -> 349
    //   344: aload_2
    //   345: iconst_m1
    //   346: putfield 267	com/tencent/mobileqq/data/ChatMessage:mRobotFlag	I
    //   349: aload 10
    //   351: getfield 270	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_e_of_type_Int	I
    //   354: iconst_m1
    //   355: if_icmpeq +18 -> 373
    //   358: aload_2
    //   359: ldc_w 272
    //   362: aload 10
    //   364: getfield 270	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_e_of_type_Int	I
    //   367: invokestatic 275	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   370: invokevirtual 237	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload_2
    //   374: instanceof 277
    //   377: ifeq +623 -> 1000
    //   380: aload_2
    //   381: checkcast 277	com/tencent/mobileqq/data/MessageForReplyText
    //   384: astore 11
    //   386: aload 11
    //   388: aload_1
    //   389: getfield 157	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   392: putfield 280	com/tencent/mobileqq/data/MessageForReplyText:msgVia	I
    //   395: aload 9
    //   397: ifnull +10 -> 407
    //   400: aload 11
    //   402: aload 9
    //   404: putfield 284	com/tencent/mobileqq/data/MessageForReplyText:atInfoList	Ljava/util/ArrayList;
    //   407: aload 11
    //   409: ldc_w 286
    //   412: aload 10
    //   414: getfield 289	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   417: invokestatic 294	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   420: invokestatic 299	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   423: invokevirtual 300	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: aload 11
    //   428: aload 10
    //   430: getfield 289	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   433: putfield 303	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   436: aload 11
    //   438: aload 11
    //   440: getfield 306	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   443: iconst_1
    //   444: ior
    //   445: putfield 306	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   448: aload_2
    //   449: getfield 309	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   452: iconst_1
    //   453: if_icmpne +584 -> 1037
    //   456: invokestatic 314	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   459: aload_2
    //   460: invokevirtual 315	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   463: iload 4
    //   465: ifne +21 -> 486
    //   468: aload_2
    //   469: getfield 309	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   472: invokestatic 320	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:a	(I)Z
    //   475: ifeq +11 -> 486
    //   478: invokestatic 323	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:a	()Lcom/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper;
    //   481: aload_2
    //   482: invokevirtual 326	com/tencent/mobileqq/activity/qwallet/goldmsg/GoldMsgChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   485: pop
    //   486: aload 10
    //   488: getfield 328	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_b_of_type_Boolean	Z
    //   491: ifeq +7 -> 498
    //   494: aload_2
    //   495: invokestatic 331	com/tencent/mobileqq/dating/DatingUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   498: aload_2
    //   499: getfield 309	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   502: sipush 1033
    //   505: if_icmpeq +13 -> 518
    //   508: aload_2
    //   509: getfield 309	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   512: sipush 1034
    //   515: if_icmpne +541 -> 1056
    //   518: aload_0
    //   519: aload_2
    //   520: aload_2
    //   521: getfield 334	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   524: aload_2
    //   525: getfield 309	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   528: aload_1
    //   529: getfield 335	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_e_of_type_Int	I
    //   532: invokestatic 340	com/tencent/mobileqq/confess/ConfessMsgUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;II)V
    //   535: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq +58 -> 596
    //   541: ldc 134
    //   543: iconst_2
    //   544: new 136	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 342
    //   554: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_2
    //   558: getfield 345	com/tencent/mobileqq/data/ChatMessage:time	J
    //   561: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   564: ldc_w 347
    //   567: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload_2
    //   571: getfield 350	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   574: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc_w 352
    //   580: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload_2
    //   584: getfield 204	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   587: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   590: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   596: aload 10
    //   598: getfield 354	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_e_of_type_Boolean	Z
    //   601: istore 4
    //   603: aload 10
    //   605: getfield 357	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:f	Z
    //   608: ifeq +494 -> 1102
    //   611: iload 4
    //   613: ifeq +462 -> 1075
    //   616: aload_0
    //   617: sipush 165
    //   620: invokevirtual 361	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   623: checkcast 363	com/tencent/mobileqq/multimsg/LongTextMsgManager
    //   626: aload_0
    //   627: aload_2
    //   628: iconst_0
    //   629: invokevirtual 366	com/tencent/mobileqq/multimsg/LongTextMsgManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   632: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +31 -> 666
    //   638: ldc 134
    //   640: iconst_2
    //   641: new 136	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   648: ldc_w 368
    //   651: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   657: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   660: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: aload_2
    //   667: getfield 369	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   670: lreturn
    //   671: aload 10
    //   673: getfield 370	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   676: ifnull +45 -> 721
    //   679: aload_0
    //   680: invokestatic 375	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   683: ifeq +38 -> 721
    //   686: new 377	com/tencent/mobileqq/data/MessageForFoldMsg
    //   689: dup
    //   690: invokespecial 378	com/tencent/mobileqq/data/MessageForFoldMsg:<init>	()V
    //   693: astore_2
    //   694: aload_2
    //   695: checkcast 377	com/tencent/mobileqq/data/MessageForFoldMsg
    //   698: iconst_0
    //   699: aload 10
    //   701: getfield 370	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   704: aload 10
    //   706: getfield 379	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   709: aload 10
    //   711: getfield 381	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_b_of_type_Long	J
    //   714: iconst_1
    //   715: invokevirtual 385	com/tencent/mobileqq/data/MessageForFoldMsg:init	(ZLjava/lang/String;Ljava/lang/String;JZ)V
    //   718: goto -557 -> 161
    //   721: aload 10
    //   723: getfield 354	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_e_of_type_Boolean	Z
    //   726: ifeq +23 -> 749
    //   729: aload_0
    //   730: invokestatic 386	com/tencent/mobileqq/multimsg/LongTextMsgManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   733: ifeq +16 -> 749
    //   736: sipush -1051
    //   739: invokestatic 389	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   742: checkcast 192	com/tencent/mobileqq/data/ChatMessage
    //   745: astore_2
    //   746: goto -585 -> 161
    //   749: aload 10
    //   751: getfield 289	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   754: ifnull +369 -> 1123
    //   757: sipush -1049
    //   760: istore_3
    //   761: iload_3
    //   762: invokestatic 389	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   765: checkcast 192	com/tencent/mobileqq/data/ChatMessage
    //   768: astore_2
    //   769: aload_0
    //   770: bipush 50
    //   772: invokevirtual 361	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   775: checkcast 391	com/tencent/mobileqq/app/FriendsManager
    //   778: aload_0
    //   779: invokevirtual 393	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   782: iconst_0
    //   783: invokevirtual 396	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   786: astore 12
    //   788: aload 12
    //   790: ifnull +38 -> 828
    //   793: aload_2
    //   794: ldc_w 398
    //   797: aload 12
    //   799: invokestatic 403	com/etrump/mixlayout/FontManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)I
    //   802: invokestatic 275	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   805: invokevirtual 237	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   808: iconst_1
    //   809: aload 12
    //   811: getfield 408	com/tencent/mobileqq/data/ExtensionInfo:magicFont	I
    //   814: if_icmpne +127 -> 941
    //   817: aload_2
    //   818: ldc_w 410
    //   821: iconst_0
    //   822: invokestatic 275	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   825: invokevirtual 237	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   828: iload_3
    //   829: sipush -1000
    //   832: if_icmpne +18 -> 850
    //   835: aload 9
    //   837: ifnull +13 -> 850
    //   840: aload_1
    //   841: getfield 54	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   844: aload 9
    //   846: aload_2
    //   847: invokestatic 415	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(ILjava/util/ArrayList;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   850: iload_3
    //   851: sipush -1000
    //   854: if_icmpne +39 -> 893
    //   857: aload 11
    //   859: ldc_w 417
    //   862: invokevirtual 421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   865: ifeq +28 -> 893
    //   868: aload 10
    //   870: getfield 424	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:h	Z
    //   873: ifne +20 -> 893
    //   876: aload_1
    //   877: invokestatic 429	com/tencent/mobileqq/ark/ArkRecommendController:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)Z
    //   880: ifeq +13 -> 893
    //   883: aload_2
    //   884: getstatic 433	com/tencent/mobileqq/service/message/MessageConstants:d	Ljava/lang/String;
    //   887: ldc_w 435
    //   890: invokevirtual 237	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   893: aload_0
    //   894: sipush 273
    //   897: invokevirtual 361	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   900: checkcast 437	com/tencent/mobileqq/lovelanguage/LoveLanguageManager
    //   903: astore 12
    //   905: iload_3
    //   906: sipush -1000
    //   909: if_icmpne +29 -> 938
    //   912: aload 12
    //   914: invokevirtual 439	com/tencent/mobileqq/lovelanguage/LoveLanguageManager:a	()Z
    //   917: ifeq +21 -> 938
    //   920: aload 10
    //   922: getfield 442	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:i	Z
    //   925: ifeq +13 -> 938
    //   928: aload_2
    //   929: getstatic 445	com/tencent/mobileqq/service/message/MessageConstants:m	Ljava/lang/String;
    //   932: ldc_w 435
    //   935: invokevirtual 237	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   938: goto -777 -> 161
    //   941: aload_2
    //   942: ldc_w 410
    //   945: aload 12
    //   947: getfield 448	com/tencent/mobileqq/data/ExtensionInfo:fontEffect	I
    //   950: invokestatic 275	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   953: invokevirtual 237	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   956: goto -128 -> 828
    //   959: astore 9
    //   961: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   964: ifeq -516 -> 448
    //   967: ldc 134
    //   969: iconst_2
    //   970: new 136	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   977: ldc_w 450
    //   980: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload 9
    //   985: invokevirtual 453	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   988: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: goto -549 -> 448
    //   1000: aload_2
    //   1001: checkcast 455	com/tencent/mobileqq/data/MessageForText
    //   1004: astore 11
    //   1006: aload 11
    //   1008: aload_1
    //   1009: getfield 157	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   1012: putfield 456	com/tencent/mobileqq/data/MessageForText:msgVia	I
    //   1015: aload 9
    //   1017: ifnull +10 -> 1027
    //   1020: aload 11
    //   1022: aload 9
    //   1024: putfield 457	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   1027: aload 11
    //   1029: aload 10
    //   1031: invokevirtual 461	com/tencent/mobileqq/data/MessageForText:setSendMsgParams	(Lcom/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams;)V
    //   1034: goto -586 -> 448
    //   1037: invokestatic 314	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   1040: getfield 463	com/tencent/biz/anonymous/AnonymousChatHelper:jdField_a_of_type_Boolean	Z
    //   1043: ifeq -580 -> 463
    //   1046: invokestatic 314	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   1049: iconst_0
    //   1050: putfield 463	com/tencent/biz/anonymous/AnonymousChatHelper:jdField_a_of_type_Boolean	Z
    //   1053: goto -590 -> 463
    //   1056: aload_1
    //   1057: getfield 466	com/tencent/mobileqq/activity/aio/SessionInfo:j	Z
    //   1060: ifeq -525 -> 535
    //   1063: aload_0
    //   1064: aload_2
    //   1065: aload_1
    //   1066: getfield 53	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1069: invokestatic 469	com/tencent/mobileqq/confess/ConfessMsgUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1072: goto -537 -> 535
    //   1075: aload_0
    //   1076: invokevirtual 77	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1079: aload_2
    //   1080: aconst_null
    //   1081: invokevirtual 472	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/app/MessageObserver;)V
    //   1084: goto -452 -> 632
    //   1087: astore_0
    //   1088: ldc_w 474
    //   1091: iconst_1
    //   1092: ldc_w 476
    //   1095: aload_0
    //   1096: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1099: goto -467 -> 632
    //   1102: new 481	ruq
    //   1105: dup
    //   1106: iload 4
    //   1108: aload_0
    //   1109: aload_2
    //   1110: invokespecial 484	ruq:<init>	(ZLcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1113: bipush 10
    //   1115: aconst_null
    //   1116: iconst_0
    //   1117: invokestatic 490	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1120: goto -488 -> 632
    //   1123: sipush -1000
    //   1126: istore_3
    //   1127: goto -366 -> 761
    //   1130: ldc 186
    //   1132: astore 11
    //   1134: goto -1076 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1137	0	paramQQAppInterface	QQAppInterface
    //   0	1137	1	paramSessionInfo	SessionInfo
    //   0	1137	2	paramString	String
    //   0	1137	3	paramInt1	int
    //   0	1137	4	paramBoolean	boolean
    //   0	1137	5	paramByte1	byte
    //   0	1137	6	paramByte2	byte
    //   0	1137	7	paramShort	short
    //   0	1137	8	paramInt2	int
    //   0	1137	9	paramArrayList	ArrayList
    //   0	1137	10	paramSendMsgParams	ChatActivityFacade.SendMsgParams
    //   56	1077	11	localObject1	Object
    //   786	160	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   407	448	959	java/lang/Exception
    //   616	632	1087	java/lang/Exception
    //   1075	1084	1087	java/lang/Exception
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    if (paramString1 != null)
    {
      paramString1 = TransfileUtile.a(paramString1, paramString3, paramString4, paramLong, paramInt2);
      paramString3 = MessageRecordFactory.a(-20000);
      paramString3.selfuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.frienduin = paramString2;
      paramString3.senderuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.msg = paramString1;
      paramString3.msgtype = -20000;
      paramString3.isread = true;
      paramString3.issend = 1;
      paramString3.istroop = paramInt1;
      ((SVIPHandler)paramQQAppInterface.a(13)).a(paramString3);
      paramQQAppInterface.a().a(paramString3, paramQQAppInterface.getCurrentAccountUin());
      return paramString3.uniseq;
    }
    return 0L;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if (paramSessionInfo == null) {}
    while (paramString == null) {
      return null;
    }
    paramQQAppInterface = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.path = paramString;
    paramQQAppInterface.size = 0L;
    paramQQAppInterface.type = 1;
    paramQQAppInterface.isRead = true;
    paramQQAppInterface.serial();
    return paramQQAppInterface;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend start, currenttime:" + System.currentTimeMillis() + " sessionInfo.entrance:" + paramSessionInfo.c);
    }
    if (paramString != null) {}
    for (String str = MessageUtils.a(paramString, true, paramArrayList);; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 1  currenttime:" + System.currentTimeMillis());
      }
      if (paramSendMsgParams.c != 0L)
      {
        paramString = new MessageForWantGiftMsg();
        ((MessageForWantGiftMsg)paramString).wantGiftSenderUin = paramSendMsgParams.c;
        ((MessageForWantGiftMsg)paramString).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, paramSendMsgParams.c + "");
        paramString.msgtype = -2056;
        MessageRecordFactory.a(paramQQAppInterface, paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
        paramString.msg = str;
        paramString.msgUid = MessageUtils.a(paramInt2);
        paramString.longMsgCount = paramByte1;
        paramString.longMsgIndex = paramByte2;
        paramString.longMsgId = paramShort;
        paramString.mAnimFlag = true;
        if (paramSendMsgParams.g) {
          paramString.mRobotFlag = -1;
        }
        paramString.saveExtInfoToExtStr("robot_news_class_id", String.valueOf(paramSendMsgParams.jdField_e_of_type_Int));
        if (!(paramString instanceof MessageForReplyText)) {
          break label684;
        }
        paramQQAppInterface = (MessageForReplyText)paramString;
        paramQQAppInterface.msgVia = paramSessionInfo.c;
        if (paramArrayList != null) {
          paramQQAppInterface.atInfoList = paramArrayList;
        }
      }
      for (;;)
      {
        try
        {
          paramQQAppInterface.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.a(MessagePkgUtils.a(paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo)));
          paramQQAppInterface.mSourceMsgInfo = paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
          paramQQAppInterface.extLong |= 0x1;
          if (paramString.istroop != 1) {
            break label717;
          }
          AnonymousChatHelper.a().a(paramString);
          if (paramSendMsgParams.jdField_b_of_type_Boolean) {
            DatingUtil.a(paramString);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 2 time = " + paramString.time + " senderUin = " + paramString.senderuin + " msgUid = " + paramString.msgUid);
          }
          return paramString;
          if ((paramSendMsgParams.jdField_a_of_type_JavaLangString != null) && (PasswdRedBagManager.a(paramQQAppInterface)))
          {
            paramString = new MessageForFoldMsg();
            ((MessageForFoldMsg)paramString).init(false, paramSendMsgParams.jdField_a_of_type_JavaLangString, paramSendMsgParams.jdField_b_of_type_JavaLangString, paramSendMsgParams.jdField_b_of_type_Long, true);
            break;
          }
          if ((paramSendMsgParams.jdField_e_of_type_Boolean) && (LongTextMsgManager.a(paramQQAppInterface)))
          {
            paramString = (ChatMessage)MessageRecordFactory.a(-1051);
            break;
          }
          if (paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo == null) {
            break label736;
          }
          paramInt1 = -1049;
          paramString = (ChatMessage)MessageRecordFactory.a(paramInt1);
          ExtensionInfo localExtensionInfo = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramQQAppInterface.c(), false);
          if (localExtensionInfo != null)
          {
            paramString.saveExtInfoToExtStr("vip_font_id", String.valueOf(FontManager.a(localExtensionInfo)));
            if (1 == localExtensionInfo.magicFont) {
              paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
            }
          }
          else
          {
            if ((paramInt1 == -1000) && (paramArrayList != null)) {
              AtTroopMemberSpan.a(paramSessionInfo.jdField_a_of_type_Int, paramArrayList, paramString);
            }
            if ((paramInt1 == -1000) && (str.startsWith("@babyQ")) && (!paramSendMsgParams.h) && (ArkRecommendController.a(paramSessionInfo))) {
              paramString.saveExtInfoToExtStr(MessageConstants.d, "1");
            }
            break;
          }
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(localExtensionInfo.fontEffect));
          continue;
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramQQAppInterface.getMessage());
          continue;
        }
        label684:
        paramQQAppInterface = (MessageForText)paramString;
        paramQQAppInterface.msgVia = paramSessionInfo.c;
        if (paramArrayList != null) {
          paramQQAppInterface.atInfoList = paramArrayList;
        }
        paramQQAppInterface.setSendMsgParams(paramSendMsgParams);
        continue;
        label717:
        if (AnonymousChatHelper.a().jdField_a_of_type_Boolean)
        {
          AnonymousChatHelper.a().jdField_a_of_type_Boolean = false;
          continue;
          label736:
          paramInt1 = -1000;
        }
      }
    }
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessage start, currenttime:" + System.currentTimeMillis());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool = false;
    short s = 0;
    Random localRandom = new Random();
    label417:
    for (;;)
    {
      try
      {
        if (a(paramQQAppInterface, paramSessionInfo, str, paramSendMsgParams))
        {
          paramString = a(str, paramArrayList, paramSendMsgParams, localArrayList);
          if (!QLog.isColorLevel()) {
            break label417;
          }
          QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessage step 2, currenttime:" + System.currentTimeMillis());
          }
          int i = Math.abs(localRandom.nextInt());
          str = (String)paramString.get(0);
          if (localArrayList.size() > 0)
          {
            paramArrayList = (ArrayList)localArrayList.get(0);
            if ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
              i = Math.abs(localRandom.nextInt());
            }
            return a(paramQQAppInterface, paramSessionInfo, str, -1000, bool, (byte)paramString.size(), (byte)0, s, i, paramArrayList, paramSendMsgParams);
          }
        }
        else
        {
          paramString = Utils.a(str, 560, 20, paramArrayList, localArrayList);
          if (paramString.size() > 1)
          {
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " partArray.size() = " + paramString.size() + " isDivide = " + bool + " currenttime:" + System.currentTimeMillis());
            }
            s = a(paramQQAppInterface, paramSessionInfo, bool, (short)0, localRandom);
            continue;
          }
          bool = false;
          continue;
        }
        paramArrayList = null;
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
    }
  }
  
  public static MessageForPtt a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (paramSessionInfo != null)
      {
        int i = paramSessionInfo.jdField_a_of_type_Int;
        localObject1 = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, i);
        ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(paramInt2, paramString);
        ((MessageForPtt)localObject1).fileSize = paramInt1;
        ((MessageForPtt)localObject1).itemType = 2;
        if ((!SttManager.a(i)) || (!SttManager.a(paramQQAppInterface))) {
          break label203;
        }
        paramInt1 = 1;
        ((MessageForPtt)localObject1).sttAbility = paramInt1;
        ((MessageForPtt)localObject1).voiceType = paramInt2;
        ((MessageForPtt)localObject1).longPttVipFlag = MessageUtils.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        AnonymousChatHelper.a().a((MessageRecord)localObject1);
        if (GoldMsgChatHelper.a(i)) {
          GoldMsgChatHelper.a().a((MessageRecord)localObject1);
        }
        if ((paramSessionInfo.jdField_a_of_type_Int != 1033) && ((paramSessionInfo.jdField_a_of_type_Int != 1034) || (paramSessionInfo.jdField_e_of_type_Int <= 0))) {
          break label208;
        }
        ConfessMsgUtil.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_e_of_type_Int);
      }
    }
    for (;;)
    {
      ((MessageForPtt)localObject1).serial();
      ((SVIPHandler)paramQQAppInterface.a(13)).a((MessageRecord)localObject1);
      return localObject1;
      label203:
      paramInt1 = 0;
      break;
      label208:
      if (paramSessionInfo.j) {
        ConfessMsgUtil.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (MsgProxyUtils.c(paramSessionInfo.jdField_a_of_type_Int))
    {
      paramQQAppInterface = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        int i = paramQQAppInterface.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
          if (!MsgUtils.b(paramSessionInfo.issend)) {
            return paramSessionInfo;
          }
          i -= 1;
        }
      }
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSessionInfo != null)
    {
      localObject1 = localObject2;
      if (paramMessageForPtt != null)
      {
        localObject1 = MessageRecordFactory.a(paramMessageForPtt);
        ((SVIPHandler)paramQQAppInterface.a(13)).a((MessageRecord)localObject1);
        paramQQAppInterface.a().a((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
      }
    }
    return localObject1;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    paramString = a(paramQQAppInterface, paramString, paramSessionInfo, paramInt1, paramInt2);
    if (paramString != null)
    {
      paramString.msgVia = paramSessionInfo.c;
      paramQQAppInterface.a().a(paramString, paramQQAppInterface.getCurrentAccountUin());
    }
    while (!QLog.isColorLevel()) {
      return paramString;
    }
    QLog.d("ChatActivityFacade", 2, "createPttMessage null");
    return paramString;
  }
  
  public static AbsShareMsg a(Context paramContext, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder;
    if ((paramMessageRecord instanceof MessageForMixedMsg))
    {
      localStringBuilder = new StringBuilder();
      if (android.text.TextUtils.isEmpty(paramString)) {
        break label361;
      }
      str = paramString;
      if (paramString.length() <= 12) {}
    }
    label361:
    for (String str = paramString.substring(0, 11) + "...";; str = "  ")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(":  ");
      localStringBuilder.append(MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)paramMessageRecord));
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.jdField_e_of_type_Int * 0.8F), 2, 30, localStringBuilder.toString()).toString();
      localArrayList.add(new StructMsgItemTitle(paramMessageRecord));
      paramString = paramMessageRecord;
      if (paramMessageRecord.length() > 30) {
        paramString = paramMessageRecord.substring(0, 30);
      }
      paramMessageRecord = paramContext.getString(2131433649);
      paramContext = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(35).a(paramString).a(3).a("viewMultiMsg", "", null, null, null).a(paramMessageRecord, null).b(paramContext.getResources().getString(2131433767)).a();
      paramMessageRecord = new StructMsgItemLayout1(localArrayList);
      paramMessageRecord.a(new StructMsgItemHr());
      paramMessageRecord.a(new StructMsgItemSummary("点击查看完整消息"));
      paramContext.addItem(paramMessageRecord);
      return paramContext;
      paramString = (MessageForLongTextMsg)paramMessageRecord;
      if (paramString.sb != null) {}
      for (paramString = paramString.sb.toString();; paramString = paramString.msg)
      {
        str = paramString;
        if (com.tencent.mobileqq.text.TextUtils.a(paramString)) {
          str = com.tencent.mobileqq.text.TextUtils.c(paramString);
        }
        int i = 60;
        if (AnonymousChatHelper.a(paramMessageRecord)) {
          i = 50;
        }
        paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.jdField_e_of_type_Int * 0.8F), 2, i, str).toString();
        break;
      }
    }
  }
  
  public static AbsShareMsg a(Context paramContext, String paramString, List paramList, Map paramMap, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramMap == null)) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    int i;
    int j;
    label44:
    String str1;
    StringBuilder localStringBuilder;
    ChatMessage localChatMessage;
    String str2;
    if (paramList.size() >= 3)
    {
      i = 3;
      j = 0;
      if (j >= i) {
        break label901;
      }
      str1 = "  ";
      localStringBuilder = new StringBuilder();
      localChatMessage = (ChatMessage)paramList.get(j);
      str2 = "";
      if (!paramBoolean) {
        break label220;
      }
      paramString = (String)paramMap.get(MsgProxyUtils.c(localChatMessage));
      label102:
      if (!android.text.TextUtils.isEmpty(paramString))
      {
        if (paramString.length() <= 12) {
          break label271;
        }
        str1 = paramString.substring(0, 11) + "...";
      }
      label146:
      if (!(localChatMessage instanceof MessageForPic)) {
        break label277;
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(":  ");
      localStringBuilder.append("[图片]");
      localArrayList1.add(new StructMsgItemTitle(localStringBuilder.toString()));
    }
    for (;;)
    {
      j += 1;
      break label44;
      i = paramList.size();
      break;
      label220:
      ArrayList localArrayList2 = new ArrayList(paramMap.values());
      paramString = str2;
      if (localArrayList2 == null) {
        break label102;
      }
      paramString = str2;
      if (localArrayList2.isEmpty()) {
        break label102;
      }
      paramString = (String)localArrayList2.get(0);
      break label102;
      label271:
      str1 = paramString;
      break label146;
      label277:
      if ((localChatMessage instanceof MessageForShortVideo))
      {
        localStringBuilder.append(str1);
        localStringBuilder.append(":  ");
        localStringBuilder.append("[视频]");
        localArrayList1.add(new StructMsgItemTitle(localStringBuilder.toString()));
      }
      else
      {
        if ((localChatMessage instanceof MessageForText))
        {
          paramString = (MessageForText)localChatMessage;
          if (paramString.sb != null) {}
          for (str2 = paramString.sb.toString();; str2 = paramString.msg)
          {
            paramString = str2;
            if (com.tencent.mobileqq.text.TextUtils.a(str2)) {
              paramString = com.tencent.mobileqq.text.TextUtils.c(str2);
            }
            str2 = paramString;
            if (LoveLanguageManager.b(paramString)) {
              str2 = LoveLanguageManager.b(paramString);
            }
            localStringBuilder.append(str1);
            localStringBuilder.append(":  ");
            localStringBuilder.append(str2);
            localArrayList1.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.jdField_e_of_type_Int * 0.8F), 2, 30, localStringBuilder.toString()).toString()));
            break;
          }
        }
        if ((localChatMessage instanceof MessageForQQStoryComment))
        {
          paramString = (MessageForQQStoryComment)localChatMessage;
          localStringBuilder.append(str1);
          localStringBuilder.append(":  ");
          localStringBuilder.append(paramString.comment);
          localArrayList1.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.jdField_e_of_type_Int * 0.8F), 2, 30, localStringBuilder.toString()).toString()));
        }
        if (((localChatMessage instanceof MessageForMixedMsg)) || ((localChatMessage instanceof MessageForLongMsg)))
        {
          localStringBuilder.append(str1);
          localStringBuilder.append(":  ");
          localStringBuilder.append(MessageForMixedMsg.getTextFromMixedMsg(localChatMessage));
          localArrayList1.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.jdField_e_of_type_Int * 0.8F), 2, 30, localStringBuilder.toString()).toString()));
        }
        else if ((localChatMessage instanceof MessageForStructing))
        {
          paramString = localChatMessage.getSummaryMsg();
          localStringBuilder.append(str1);
          localStringBuilder.append(":  ");
          localStringBuilder.append(paramString);
          localArrayList1.add(new StructMsgItemTitle(localStringBuilder.toString()));
        }
        else if ((localChatMessage instanceof MessageForArkApp))
        {
          paramString = ((MessageForArkApp)localChatMessage).getSummery();
          localStringBuilder.append(str1);
          localStringBuilder.append(":  ");
          localStringBuilder.append(paramString);
          localArrayList1.add(new StructMsgItemTitle(localStringBuilder.toString()));
        }
        else if ((localChatMessage instanceof MessageForArkBabyqReply))
        {
          paramString = ((MessageForArkBabyqReply)localChatMessage).getSummery();
          localStringBuilder.append("babyQ");
          localStringBuilder.append(":  ");
          localStringBuilder.append(paramString);
          localArrayList1.add(new StructMsgItemTitle(localStringBuilder.toString()));
        }
        else if ((localChatMessage instanceof MessageForArkFlashChat))
        {
          paramString = ((MessageForArkFlashChat)localChatMessage).getSummery();
          localStringBuilder.append(str1);
          localStringBuilder.append(":  ");
          localStringBuilder.append(paramString);
          localArrayList1.add(new StructMsgItemTitle(localStringBuilder.toString()));
        }
      }
    }
    label901:
    paramString = paramContext.getString(2131433649);
    paramContext = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(35).a("[转发多条消息]").a(3).a("viewMultiMsg", "", null, null, null).a(paramString, null).b(paramContext.getResources().getString(2131433767)).a();
    paramString = new StructMsgItemLayout1(localArrayList1);
    paramString.a(new StructMsgItemHr());
    paramString.a(new StructMsgItemSummary(String.format("查看%s条转发消息", new Object[] { Integer.valueOf(paramList.size()) })));
    paramContext.addItem(paramString);
    return paramContext;
  }
  
  private static CharSequence a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramContext = paramContext.getResources();
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = paramContext.getDisplayMetrics().density;
    int k = paramCharSequence.length();
    int i = 0;
    int j = i;
    if (i < k)
    {
      if (Layout.getDesiredWidth(paramCharSequence, 0, i + 1, localTextPaint) > paramInt1 * paramInt2) {
        j = i - 1;
      }
    }
    else if (j >= k)
    {
      paramContext = paramCharSequence;
      if (j <= paramInt3) {}
    }
    else
    {
      if (j <= paramInt3) {
        break label143;
      }
    }
    for (;;)
    {
      paramContext = paramCharSequence.subSequence(0, paramInt3).toString() + "…";
      return paramContext;
      i += 1;
      break;
      label143:
      paramInt3 = j;
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = paramQQAppInterface.c();
    paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
    return "key_last_req_aio_feeds_time" + "_" + paramQQAppInterface + "_" + paramSessionInfo;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("id", paramString1);
    localJSONObject2.put("name", paramString2);
    localJSONObject2.put("address", paramString3);
    localJSONObject2.put("lat", paramString4);
    localJSONObject2.put("lng", paramString5);
    localJSONObject2.put("from", "plusPanel");
    localJSONObject1.put("Location.Search", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  private static String a(String paramString, ArrayList paramArrayList)
  {
    int i = 0;
    int j = 0;
    while ((i < paramString.length()) && (paramString.codePointAt(i) == 0))
    {
      j += 1;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow, at info starts with char 0");
      }
      i += 1;
    }
    Object localObject = paramString;
    if (j > 0)
    {
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
          localObject = (MessageForText.AtTroopMemberInfo)paramArrayList.next();
          ((MessageForText.AtTroopMemberInfo)localObject).startPos = ((short)(((MessageForText.AtTroopMemberInfo)localObject).startPos - j));
        } while (((MessageForText.AtTroopMemberInfo)localObject).startPos >= 0);
        if (QLog.isColorLevel()) {
          QLog.e("SendMsgBtn", 2, " createTextMessageToshow error, at info starts with char 0");
        }
        localObject = null;
      }
    }
    else {
      return localObject;
    }
    return paramString.substring(j);
  }
  
  public static String a(List paramList, Map paramMap)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramMap == null)) {
      return null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i;
    int j;
    label42:
    StringBuilder localStringBuilder2;
    Object localObject2;
    Object localObject1;
    if (paramList.size() >= 4)
    {
      i = 4;
      j = 0;
      if (j >= i) {
        break label588;
      }
      localStringBuilder2 = new StringBuilder();
      localObject2 = (ChatMessage)paramList.get(j);
      localObject1 = (String)paramMap.get(MsgProxyUtils.c((MessageRecord)localObject2));
      if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        break label594;
      }
    }
    for (;;)
    {
      if ((localObject2 instanceof MessageForPic))
      {
        localStringBuilder2.append((String)localObject1);
        localStringBuilder2.append(": ");
        localStringBuilder2.append("[图片]");
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append("\r\n");
      }
      label220:
      label255:
      do
      {
        for (;;)
        {
          j += 1;
          break label42;
          i = paramList.size();
          break;
          if (!(localObject2 instanceof MessageForShortVideo)) {
            break label220;
          }
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append("[视频]");
          localStringBuilder1.append(localStringBuilder2.toString());
          localStringBuilder1.append("\r\n");
        }
        if ((localObject2 instanceof MessageForText))
        {
          localObject2 = (MessageForText)localObject2;
          if (((MessageForText)localObject2).sb != null)
          {
            localObject2 = ((MessageForText)localObject2).sb.toString();
            localStringBuilder2.append((String)localObject1);
            localStringBuilder2.append(": ");
            localStringBuilder2.append((String)localObject2);
            localObject2 = localStringBuilder2.toString();
            localObject1 = localObject2;
            if (com.tencent.mobileqq.text.TextUtils.a((String)localObject2)) {
              localObject1 = com.tencent.mobileqq.text.TextUtils.c((String)localObject2);
            }
            localObject2 = localObject1;
            if (LoveLanguageManager.b((String)localObject1)) {
              localObject2 = LoveLanguageManager.b((String)localObject1);
            }
            if (((String)localObject2).length() <= 16) {
              break label377;
            }
            localStringBuilder1.append(((String)localObject2).substring(0, 16)).append("...");
          }
          for (;;)
          {
            localStringBuilder1.append("\r\n");
            break;
            localObject2 = ((MessageForText)localObject2).msg;
            break label255;
            localStringBuilder1.append((String)localObject2);
          }
        }
        if (((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForLongMsg)))
        {
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append(MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject2));
          localObject1 = com.tencent.mobileqq.text.TextUtils.a(localStringBuilder2.toString());
          if (((String)localObject1).length() > 16) {
            localStringBuilder1.append(((String)localObject1).substring(0, 16)).append("...");
          }
          for (;;)
          {
            localStringBuilder1.append("\r\n");
            break;
            localStringBuilder1.append((String)localObject1);
          }
        }
      } while (!(localObject2 instanceof MessageForStructing));
      label377:
      localObject2 = ((ChatMessage)localObject2).getSummaryMsg();
      localStringBuilder2.append((String)localObject1);
      localStringBuilder2.append(": ");
      localStringBuilder2.append((String)localObject2);
      if (((String)localObject2).length() > 16) {
        localStringBuilder1.append(((String)localObject2).substring(0, 16)).append("...");
      }
      for (;;)
      {
        localStringBuilder1.append("\r\n");
        break;
        localStringBuilder1.append((String)localObject2);
      }
      label588:
      return localStringBuilder1.toString();
      label594:
      localObject1 = " ";
    }
  }
  
  @NonNull
  private static ArrayList a(String paramString, ArrayList paramArrayList1, ChatActivityFacade.SendMsgParams paramSendMsgParams, ArrayList paramArrayList2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramArrayList2.add(paramArrayList1);
    paramSendMsgParams.jdField_e_of_type_Boolean = true;
    return localArrayList;
  }
  
  public static JSONObject a(NewestFeedInfo paramNewestFeedInfo)
  {
    if (paramNewestFeedInfo == null) {
      return null;
    }
    paramNewestFeedInfo.strTitle = paramNewestFeedInfo.strTitle.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "[表情]");
    paramNewestFeedInfo.strSummary = paramNewestFeedInfo.strSummary.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "[表情]");
    paramNewestFeedInfo.strContent = paramNewestFeedInfo.strContent.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "[表情]");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramNewestFeedInfo.uAppid);
      localJSONObject.put("title", paramNewestFeedInfo.strTitle);
      localJSONObject.put("actionUrl", paramNewestFeedInfo.strJmpUrl);
      localJSONObject.put("content", paramNewestFeedInfo.strContent);
      localJSONObject.put("coverImageUrl", paramNewestFeedInfo.strImgUrl);
      localJSONObject.put("fromuin", paramNewestFeedInfo.uHostUin);
      localJSONObject.put("imageCount", paramNewestFeedInfo.uImgCount);
      localJSONObject.put("lbsinfo", paramNewestFeedInfo.strLBSInfo);
      localJSONObject.put("summery", paramNewestFeedInfo.strSummary);
      localJSONObject.put("time", paramNewestFeedInfo.uTime);
      localJSONObject.put("version", 1);
      localJSONObject.put("likeNums", paramNewestFeedInfo.uLikeNum);
      localJSONObject.put("commentNums", paramNewestFeedInfo.uCommentNum);
      if ((paramNewestFeedInfo.mapEx != null) && (!paramNewestFeedInfo.mapEx.isEmpty())) {
        localJSONObject.put("mapExt", new JSONObject(paramNewestFeedInfo.mapEx).toString());
      }
      if ((paramNewestFeedInfo.mediaData != null) && (paramNewestFeedInfo.mediaData.size() > 0))
      {
        JSONArray localJSONArray = new JSONArray();
        paramNewestFeedInfo = paramNewestFeedInfo.mediaData.iterator();
        while (paramNewestFeedInfo.hasNext())
        {
          Media_Data localMedia_Data = (Media_Data)paramNewestFeedInfo.next();
          MessageForQzoneFeed.MediaData localMediaData = new MessageForQzoneFeed.MediaData();
          localMediaData.uType = localMedia_Data.uType;
          localMediaData.strImgUrl = localMedia_Data.strImgUrl;
          localMediaData.extendInfo = localMedia_Data.extendInfo;
          localJSONArray.put(localMediaData.toJson());
        }
        localJSONObject.put("mediaDatas", localJSONArray.toString());
      }
      return localJSONObject;
    }
    catch (JSONException paramNewestFeedInfo) {}
    return null;
  }
  
  private static short a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, short paramShort, Random paramRandom)
  {
    if (paramBoolean)
    {
      int i = MobileQQService.jdField_a_of_type_Int;
      MobileQQService.jdField_a_of_type_Int = i + 1;
      paramShort = (short)(byte)i;
      i = 0;
      for (;;)
      {
        short s = paramShort;
        if (paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int, paramShort))
        {
          if (i > 10) {
            s = (short)(byte)paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int);
          }
        }
        else
        {
          paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int, s);
          return s;
        }
        paramShort = (short)(byte)Math.abs(paramRandom.nextInt());
        i += 1;
      }
    }
    return paramShort;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "go to dismissActionSheet()!");
    }
    if ((jdField_a_of_type_ComTencentWidgetActionSheet != null) && (jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {}
    try
    {
      jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      jdField_a_of_type_ComTencentWidgetActionSheet = null;
      if ((b == null) || (!b.isShowing())) {}
    }
    catch (Exception localException1)
    {
      try
      {
        b.dismiss();
        b = null;
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Bundle paramBundle)
  {
    paramString4 = SubString.a(paramString4, 45, "UTF-8", "...");
    paramString5 = SubString.a(paramString5, 90, "UTF-8", "...");
    if (!paramContext.getResources().getString(2131430559).equals(paramString4))
    {
      paramString3 = paramContext.getResources().getString(2131435571) + " " + paramString4;
      paramString6 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString1 + "&lon=" + paramString2 + "&title=" + paramString4 + "&loc=" + paramString5 + "&dpid=" + paramString6;
      paramString3 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(32).a(paramString3).b("").a("plugin", "", paramString6, "", "").a();
      paramString6 = StructMsgElementFactory.a(2);
      paramString6.a("http://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
      paramString3.addItem(paramString6);
      if ((paramSessionInfo == null) || (paramSessionInfo.jdField_a_of_type_Int != 1008) || (!(paramContext instanceof FragmentActivity))) {
        break label497;
      }
      paramContext = ((FragmentActivity)paramContext).getChatFragment();
      if (paramContext == null) {
        break label497;
      }
      paramContext = paramContext.a();
      if ((paramContext == null) || (paramContext.a == null) || (!(paramContext instanceof PublicAccountChatPie))) {
        break label497;
      }
    }
    label497:
    for (boolean bool = ((PublicAccountChatPie)paramContext).an;; bool = false)
    {
      if ((paramSessionInfo != null) && ((paramSessionInfo.jdField_a_of_type_Int == 1025) || (paramSessionInfo.jdField_a_of_type_Int == 1024) || ((paramSessionInfo.jdField_a_of_type_Int == 0) && (BmqqSegmentUtil.b(paramSessionInfo.jdField_a_of_type_JavaLangString))) || (bool)))
      {
        paramContext = MessageRecordFactory.a(-1000);
        l = MessageCache.a();
        i = paramSessionInfo.jdField_a_of_type_Int;
        paramString1 = "我在这里，点击查看：http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString5 + ")";
        paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramString1, l, -1000, i, l);
        paramContext.issend = 1;
        paramQQAppInterface.a().a(paramContext, null);
      }
      while (paramSessionInfo == null)
      {
        long l;
        int i;
        return;
        paramString3 = paramContext.getResources().getString(2131435571);
        break;
      }
      if (a(paramSessionInfo, paramString5, paramBundle))
      {
        a(paramQQAppInterface, paramSessionInfo, paramString1, paramString2, paramString4, paramString5, paramString3, paramString7, paramString8, paramString9);
        return;
      }
      a(paramQQAppInterface, paramSessionInfo, paramString3);
      return;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = new rus(paramContext, paramChatMessage, paramQQAppInterface);
    paramChatMessage = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramChatMessage.isActive();
    if (((paramContext instanceof Activity)) && (bool)) {
      paramChatMessage.hideSoftInputFromWindow(((Activity)paramContext).getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
        return;
      }
      paramQQAppInterface.run();
      return;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, List paramList)
  {
    paramQQAppInterface = new ruv(paramContext, paramList, paramQQAppInterface);
    paramList = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramList.isActive();
    if (((paramContext instanceof Activity)) && (bool)) {
      paramList.hideSoftInputFromWindow(((Activity)paramContext).getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
        return;
      }
      paramQQAppInterface.run();
      return;
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (paramBaseChatPie != null)
    {
      if (paramQQAppInterface != null) {
        break label27;
      }
      i = 1;
      if (paramSessionInfo != null) {
        break label33;
      }
      label18:
      if ((j | i) == 0) {
        break label39;
      }
    }
    label395:
    for (;;)
    {
      return;
      label27:
      i = 0;
      break;
      label33:
      j = 0;
      break label18;
      label39:
      if ((paramBaseChatPie instanceof FriendChatPie)) {}
      for (paramBaseChatPie = (FriendChatPie)paramBaseChatPie;; paramBaseChatPie = null)
      {
        if (paramBaseChatPie == null) {
          break label395;
        }
        AioVipDonateHelper localAioVipDonateHelper = AioVipDonateHelper.a();
        i = paramSessionInfo.jdField_a_of_type_Int;
        boolean bool1 = localAioVipDonateHelper.a(paramQQAppInterface);
        boolean bool2 = localAioVipDonateHelper.b(paramQQAppInterface);
        boolean bool3 = localAioVipDonateHelper.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
        if ((i != 0) || (!bool1) || (!bool2) || (!bool3)) {
          break;
        }
        Object localObject = paramQQAppInterface.getApp().getSharedPreferences(AioVipDonateHelper.jdField_a_of_type_JavaLangString, 0);
        if (!paramBoolean)
        {
          long l1 = localAioVipDonateHelper.a(paramQQAppInterface);
          long l2 = ((SharedPreferences)localObject).getLong(AioVipDonateHelper.jdField_b_of_type_JavaLangString + paramSessionInfo.jdField_a_of_type_JavaLangString, 0L);
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 > l1)) {
            break label271;
          }
        }
        label271:
        VIPAioSendHandler localVIPAioSendHandler;
        do
        {
          localObject = localAioVipDonateHelper.a(paramQQAppInterface);
          if ((!localAioVipDonateHelper.c(paramQQAppInterface)) || (android.text.TextUtils.isEmpty((CharSequence)localObject)) || (!paramBaseChatPie.O)) {
            break;
          }
          localAioVipDonateHelper.a(paramQQAppInterface, 0);
          MsgProxyUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -4022);
          paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_Int, -4022, (String)localObject);
          return;
          localVIPAioSendHandler = (VIPAioSendHandler)paramQQAppInterface.a(86);
        } while (localVIPAioSendHandler == null);
        paramBaseChatPie = new AIOSendReq();
        paramBaseChatPie.iSend = 0;
        paramBaseChatPie.sAid = "";
        paramBaseChatPie.sUin = paramQQAppInterface.getCurrentAccountUin();
        paramBaseChatPie.sFriendUin = paramSessionInfo.jdField_a_of_type_JavaLangString;
        localVIPAioSendHandler.a(paramBaseChatPie);
        paramBaseChatPie = ((SharedPreferences)localObject).edit();
        paramBaseChatPie.putLong(AioVipDonateHelper.jdField_b_of_type_JavaLangString + paramSessionInfo.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
        if (Build.VERSION.SDK_INT <= 8)
        {
          paramBaseChatPie.commit();
          return;
        }
        paramBaseChatPie.apply();
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (StreamDataManager.a(paramString2) >= 1))
    {
      StreamDataManager.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new TransferRequest();
    paramBundle.jdField_b_of_type_JavaLangString = paramQQAppInterface.getAccount();
    paramBundle.c = paramString1;
    paramBundle.jdField_a_of_type_Int = paramInt1;
    paramBundle.jdField_b_of_type_Int = 2;
    paramBundle.jdField_a_of_type_Long = paramLong1;
    paramBundle.jdField_a_of_type_Boolean = true;
    paramBundle.i = paramString2;
    paramBundle.jdField_e_of_type_Int = 1002;
    paramBundle.l = paramBoolean3;
    paramBundle.n = paramInt5;
    paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().a(paramString1, paramInt1, paramLong1);
    if ((paramInt1 == 1026) && (QLog.isColorLevel()))
    {
      paramString2 = new StringBuilder().append("uploadPtt,");
      if (paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        break label254;
      }
    }
    label254:
    for (paramString1 = "mRec is null";; paramString1 = "mRec is not null")
    {
      QLog.i("PttShow", 2, paramString1);
      if ((paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt)))
      {
        paramString1 = (MessageForPtt)paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        paramString1.voiceType = paramInt3;
        paramString1.voiceLength = QQRecorder.a(paramInt2);
        paramString1.voiceChangeFlag = paramInt4;
      }
      paramQQAppInterface.a().a(paramBundle);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList paramArrayList, String paramString3, boolean paramBoolean4)
  {
    a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramLong1, paramBoolean1, paramInt2, paramInt3, paramBoolean2, paramInt4, paramInt5, paramBoolean3, paramLong2, paramBundle, paramArrayList, paramString3, paramBoolean4, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList paramArrayList, String paramString3, boolean paramBoolean4, MessageRecord paramMessageRecord)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (StreamDataManager.a(paramString2) >= 1))
    {
      StreamDataManager.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new TransferRequest();
    paramBundle.jdField_b_of_type_JavaLangString = paramQQAppInterface.getAccount();
    paramBundle.c = paramString1;
    paramBundle.jdField_a_of_type_Int = paramInt1;
    paramBundle.jdField_b_of_type_Int = 2;
    paramBundle.jdField_a_of_type_Long = paramLong1;
    paramBundle.jdField_a_of_type_Boolean = true;
    paramBundle.i = paramString2;
    paramBundle.jdField_e_of_type_Int = 1002;
    paramBundle.l = paramBoolean3;
    paramBundle.n = paramInt5;
    if (paramMessageRecord != null)
    {
      paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean4))
      {
        paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.atInfoList = paramArrayList;
        paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mRobotFlag = 1;
        new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_msg_suc").a(new String[] { paramString1, String.valueOf(((MessageForText.AtTroopMemberInfo)paramArrayList.get(0)).uin) }).a();
      }
      if ((paramInt1 == 1026) && (QLog.isColorLevel()))
      {
        paramString2 = new StringBuilder().append("uploadPtt,");
        if (paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
          break label376;
        }
      }
    }
    label376:
    for (paramString1 = "mRec is null";; paramString1 = "mRec is not null")
    {
      QLog.i("PttShow", 2, paramString1);
      if ((paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt)))
      {
        paramString1 = (MessageForPtt)paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        paramString1.voiceType = paramInt3;
        paramString1.voiceLength = QQRecorder.a(paramInt2);
        paramString1.voiceChangeFlag = paramInt4;
        paramString1.mInputContent = paramString3;
      }
      paramQQAppInterface.a().a(paramBundle);
      return;
      paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().a(paramString1, paramInt1, paramLong1);
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    int i = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramSessionInfo = MessageRecordFactory.a(str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l);
    paramQQAppInterface.a().a(paramSessionInfo, null);
    if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) {
      ((FragmentActivity)paramContext).getChatFragment().a().a(paramSessionInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "create new shake message,shmsgseq is:" + paramSessionInfo.shmsgseq + ",msgUid is:" + paramSessionInfo.msgUid + ",time is:" + System.currentTimeMillis());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    paramContext = new MessageForPokeEmo();
    paramContext.msgtype = -5018;
    paramContext.isNeedPlayed = false;
    paramContext.pokeemoId = paramInt1;
    paramContext.pokeemoPressCount = paramInt2;
    paramContext.summary = PEPanelHelper.a(paramInt1);
    paramContext.initMsg();
    MessageRecordFactory.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.a().a(paramContext, null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, String.format(" sendPokeEmoMsg.pokeemoID = %d,count = %d,summary = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2, paramString1, paramString2, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    if (!PokeItemHelper.a(paramQQAppInterface, paramSessionInfo))
    {
      if (jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null)
      {
        jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(paramContext, 2131438448, 0);
        PokeItemAnimationManager.a().a(3);
        PokeItemAnimationManager.a().a(6);
        PokeItemAnimationManager.a().a(12);
        PokeItemAnimationManager.a().a(15);
        PokeItemAnimationManager.a().a(18);
        PokeItemAnimationManager.a().a(9);
      }
      if (!jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()) {
        jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
      }
    }
    do
    {
      return;
      paramContext = new MessageForPoke();
      paramContext.msgtype = -5012;
      paramContext.isPlayed = false;
      paramContext.interactType = paramInt1;
      paramContext.subId = paramInt2;
      paramContext.name = paramString1;
      paramContext.minVersion = paramString2;
      paramContext.strength = PokeItemAnimationManager.a().a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramContext.interactType, paramInt3, -1);
      MessageRecordFactory.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      paramContext.initMsg();
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "sendPokeMsg strength:" + paramContext.strength + "." + paramContext);
      }
      paramQQAppInterface.a().a(paramContext, null);
    } while (!QLog.isColorLevel());
    QLog.d("PokeMsg", 2, "sendPokeMsg type:" + paramContext.interactType + "." + paramContext);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt, -1, paramString1, paramString2, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if ((paramContext != null) && (paramContext.isSendFromLocal())) {
      paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramContext.frienduin, paramContext.uniseq));
    }
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(paramContext);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo)
  {
    if (!paramIntent.getBooleanExtra("not_forward", false)) {}
    do
    {
      return;
      paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramForwardFileInfo.e(), paramForwardFileInfo.a(), Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), paramSessionInfo.jdField_a_of_type_Int, paramForwardFileInfo.a());
    } while (!paramIntent.getBooleanExtra("not_forward", false));
    paramIntent.removeExtra("not_forward");
    paramIntent.getExtras().remove("not_forward");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ChatActivityFacade", 1, "forwardForFile");
    }
    if ((paramForwardFileInfo != null) && (paramForwardFileInfo.b() == 10006) && (android.text.TextUtils.isEmpty(paramForwardFileInfo.a()))) {
      a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo);
    }
    for (;;)
    {
      return;
      if (paramIntent.getBooleanExtra("isFromShare", false))
      {
        if (!paramIntent.getBooleanExtra("sendMultiple", false))
        {
          if (paramSessionInfo.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface.a().a(paramString, paramSessionInfo.jdField_a_of_type_JavaLangString);
            return;
          }
          paramQQAppInterface.a().a(paramString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
        }
      }
      else if (paramIntent.getBooleanExtra("not_forward", false))
      {
        paramString = paramQQAppInterface.a().b(paramForwardFileInfo.b());
        if ((paramString == null) && (QLog.isColorLevel())) {
          QLog.e("ChatActivityFacade", 2, "there has a Bug!,sissionId[" + paramForwardFileInfo.b() + "]");
        }
        switch (paramForwardFileInfo.b())
        {
        }
        while ((!paramBoolean) && (paramIntent.getBooleanExtra("not_forward", false)))
        {
          paramIntent.removeExtra("not_forward");
          paramIntent.getExtras().remove("not_forward");
          return;
          if (paramSessionInfo.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
          }
          else
          {
            paramQQAppInterface = paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
            if (paramString != null)
            {
              paramQQAppInterface.lastSuccessTime = paramString.lastSuccessTime;
              continue;
              if (paramSessionInfo.jdField_a_of_type_Int == 1)
              {
                paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                continue;
                if (paramSessionInfo.jdField_a_of_type_Int == 1)
                {
                  if (FileUtil.b(paramForwardFileInfo.a()))
                  {
                    paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                  }
                  else
                  {
                    paramForwardFileInfo.b();
                    paramContext = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                    if ((paramContext != null) && (paramContext.peerType == 3000))
                    {
                      paramSessionInfo = paramQQAppInterface.a().a(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramContext.peerType, false);
                      paramSessionInfo.selfUin = paramContext.peerUin;
                      paramQQAppInterface.a().a(paramSessionInfo, 27);
                    }
                    else
                    {
                      paramQQAppInterface.a().b(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                    }
                  }
                }
                else
                {
                  paramString = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                  if ((paramString != null) && (paramString.status == 16))
                  {
                    FileManagerUtil.a(paramContext.getResources().getString(2131428188));
                    return;
                  }
                  paramContext = paramQQAppInterface.getCurrentAccountUin();
                  if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
                    paramContext = paramSessionInfo.jdField_b_of_type_JavaLangString;
                  }
                  if ((paramString != null) && (paramString.peerType == 3000))
                  {
                    paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
                    paramContext.selfUin = paramString.peerUin;
                    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1006) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 10002) || (paramSessionInfo.jdField_a_of_type_Int == 1006))
                    {
                      paramContext.nOpType = 21;
                      paramQQAppInterface.a().a(paramContext, 21);
                    }
                    for (;;)
                    {
                      paramQQAppInterface.a().c(paramContext);
                      break;
                      if (paramSessionInfo.jdField_a_of_type_Int == 3000)
                      {
                        paramContext.nOpType = 22;
                        paramQQAppInterface.a().a(paramContext, 22);
                      }
                    }
                  }
                  paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
                  if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
                    paramContext.nOpType = 28;
                  }
                  paramQQAppInterface.a().a(paramContext);
                  paramQQAppInterface.a().c(paramContext);
                  continue;
                  paramContext = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                  paramQQAppInterface.a().b(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
                  continue;
                  if (paramSessionInfo.jdField_a_of_type_Int == 1)
                  {
                    if (FileUtil.b(paramForwardFileInfo.a()))
                    {
                      paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                    }
                    else
                    {
                      paramString = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                      paramContext = paramQQAppInterface.getCurrentAccountUin();
                      if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
                        paramContext = paramSessionInfo.jdField_b_of_type_JavaLangString;
                      }
                      if ((paramString != null) && (paramString.peerType == 3000))
                      {
                        paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString.peerType, false);
                        paramContext.selfUin = paramString.peerUin;
                        paramQQAppInterface.a().a(paramContext, 27);
                      }
                      else
                      {
                        paramQQAppInterface.a().b(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                      }
                    }
                  }
                  else {
                    paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ApolloInfo paramApolloInfo)
  {
    if ((paramQQAppInterface == null) || (paramApolloInfo == null) || (paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) || (android.text.TextUtils.isEmpty(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionName)) || ((paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum > 0) && (android.text.TextUtils.isEmpty(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin)))) {
      return;
    }
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(50);
    ApolloManager localApolloManager = (ApolloManager)paramQQAppInterface.getManager(152);
    paramContext = (VasExtensionHandler)paramQQAppInterface.a(71);
    ApolloBaseInfo localApolloBaseInfo;
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum > 0) && (!paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin.equals(paramQQAppInterface.getCurrentAccountUin())))
    {
      localApolloBaseInfo = localApolloManager.b(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin);
      if (localApolloBaseInfo == null) {
        paramContext.b(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin);
      }
    }
    else
    {
      label150:
      localObject = new ApolloMessage();
      ((ApolloMessage)localObject).id = paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
      if ((!android.text.TextUtils.isEmpty(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName)) && ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))) {
        ((ApolloMessage)localObject).text = paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName.getBytes();
      }
      new ArrayList();
    }
    for (;;)
    {
      try
      {
        ((ApolloMessage)localObject).name = paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionName.getBytes("UTF-8");
        if (0 != 0) {
          break label814;
        }
        paramContext = new JSONObject();
        paramContext.put("actionType", paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionType);
        if (paramApolloInfo.jdField_e_of_type_Int > 0)
        {
          paramContext.put("audioID", paramApolloInfo.jdField_e_of_type_Int);
          paramContext.put("audioStartTime", paramApolloInfo.jdField_a_of_type_Float);
        }
        if (!android.text.TextUtils.isEmpty(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText))
        {
          paramContext.put("inputText", paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText);
          if (paramContext != null) {
            ((ApolloMessage)localObject).extStr = paramContext.toString();
          }
          paramContext = localApolloManager.b(paramQQAppInterface.getCurrentAccountUin());
          ((ApolloMessage)localObject).sender_ts = Utils.a(paramContext.apolloServerTS);
          ((ApolloMessage)localObject).sender_status = paramContext.apolloStatus;
          int i = 41;
          if (paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum > 0)
          {
            ((ApolloMessage)localObject).peer_uin = Long.valueOf(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin).longValue();
            paramContext = localApolloManager.b(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin);
            ((ApolloMessage)localObject).peer_ts = Utils.a(paramContext.apolloServerTS);
            ((ApolloMessage)localObject).peer_status = paramContext.apolloStatus;
            i = 127;
          }
          int j = i;
          if (paramApolloInfo.d == 1) {
            j = i | 0x80;
          }
          ((ApolloMessage)localObject).flag = j;
          paramContext = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, (ApolloMessage)localObject);
          paramContext.inputText = paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText;
          paramContext.audioId = paramApolloInfo.jdField_e_of_type_Int;
          paramContext.audioStartTime = paramApolloInfo.jdField_a_of_type_Float;
          paramContext.isPlayDefaultAudio = paramApolloInfo.f;
          paramContext.actionType = paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionType;
          if (android.text.TextUtils.isEmpty(paramContext.inputText)) {
            paramContext.inputText = paramApolloInfo.jdField_b_of_type_JavaLangString;
          }
          paramSessionInfo = SpriteUtil.a(paramQQAppInterface);
          if ((paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionType == 0) || (paramSessionInfo == null)) {
            break label768;
          }
          paramQQAppInterface = paramSessionInfo.a();
          if (paramQQAppInterface == null) {
            break;
          }
          paramQQAppInterface.a(paramContext);
          return;
          if ((!((FriendsManager)localObject).b(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin)) && (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime > 600L))
          {
            paramContext.b(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin);
            break label150;
          }
          if ((((FriendsManager)localObject).b(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin)) && (localApolloBaseInfo.apolloUpdateTime == 0L))
          {
            paramContext.b(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin);
            break label150;
          }
          if (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS) {
            break label150;
          }
          localObject = new ArrayList(1);
          ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin)));
          paramContext.a((ArrayList)localObject, "TROOP_AIO");
          break label150;
        }
        if (android.text.TextUtils.isEmpty(paramApolloInfo.jdField_b_of_type_JavaLangString)) {
          continue;
        }
        paramContext.put("inputText", paramApolloInfo.jdField_b_of_type_JavaLangString);
        continue;
        paramQQAppInterface.a().a(paramContext, null);
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.d("ChatActivityFacade", 2, paramQQAppInterface, new Object[0]);
        return;
      }
      label768:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatActivityFacade", 2, "send apollo message msg: " + paramApolloInfo.toString());
      return;
      label814:
      paramContext = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    if (paramEmoticon == null)
    {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
      QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
      return;
    }
    if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4)) && (!paramEmoticon.hasEncryptKey()))
    {
      Toast.makeText(paramContext, paramContext.getString(2131436084), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      VasReportUtils.a("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(paramContext) + "", "", "", "", "");
      paramContext = new StringBuilder().append("sendEmosmMsg emoticon Encrypt Key is null.name:");
      if (paramEmoticon.name != null)
      {
        paramQQAppInterface = paramEmoticon.name;
        paramContext = paramContext.append(paramQQAppInterface).append(", epid_eid:");
        if (paramEmoticon.epId == null) {
          break label223;
        }
        paramQQAppInterface = paramEmoticon.epId;
        label176:
        paramContext = paramContext.append(paramQQAppInterface).append("_");
        if (paramEmoticon.eId == null) {
          break label230;
        }
      }
      label223:
      label230:
      for (paramQQAppInterface = paramEmoticon.eId;; paramQQAppInterface = "~")
      {
        QLog.e("ChatActivityFacade", 1, paramQQAppInterface);
        return;
        paramQQAppInterface = "~";
        break;
        paramQQAppInterface = "~";
        break label176;
      }
    }
    ThreadManager.post(new ruy(paramQQAppInterface, paramEmoticon, paramContext, paramSessionInfo), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      paramContext = MessageRecordFactory.a(paramContext);
      paramQQAppInterface.a().a(paramContext, null, true);
      paramQQAppInterface = (EmoticonManager)paramQQAppInterface.getManager(13);
      if ((paramQQAppInterface != null) && (paramEmoticon != null))
      {
        paramContext = paramQQAppInterface.a(paramEmoticon);
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            paramSessionInfo = (String)paramContext.next();
            if (!android.text.TextUtils.isEmpty(paramSessionInfo))
            {
              RecentEmotion localRecentEmotion = new RecentEmotion();
              localRecentEmotion.epId = paramEmoticon.epId;
              localRecentEmotion.eId = paramEmoticon.eId;
              localRecentEmotion.keyword = paramSessionInfo.toLowerCase();
              localRecentEmotion.exposeNum = 0;
              paramQQAppInterface.a(localRecentEmotion);
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ChatActivityFacade", 2, "reSendEmosmMessage : mr is null.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (paramEmoticon == null)
    {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
      QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
      return;
    }
    if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4)) && (!paramEmoticon.hasEncryptKey()))
    {
      Toast.makeText(paramContext, paramContext.getString(2131436084), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      VasReportUtils.a("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(paramContext) + "", "", "", "", "");
      paramContext = new StringBuilder().append("sendEmosmMsg emoticon Encrypt Key is null.name:");
      if (paramEmoticon.name != null)
      {
        paramQQAppInterface = paramEmoticon.name;
        paramContext = paramContext.append(paramQQAppInterface).append(", epid_eid:");
        if (paramEmoticon.epId == null) {
          break label223;
        }
        paramQQAppInterface = paramEmoticon.epId;
        label176:
        paramContext = paramContext.append(paramQQAppInterface).append("_");
        if (paramEmoticon.eId == null) {
          break label230;
        }
      }
      label223:
      label230:
      for (paramQQAppInterface = paramEmoticon.eId;; paramQQAppInterface = "~")
      {
        QLog.e("ChatActivityFacade", 1, paramQQAppInterface);
        return;
        paramQQAppInterface = "~";
        break;
        paramQQAppInterface = "~";
        break label176;
      }
    }
    ThreadManager.post(new rva(paramQQAppInterface, paramEmoticon, paramContext, paramSessionInfo, paramStickerInfo), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    localSendMsgParams.jdField_a_of_type_Boolean = false;
    localSendMsgParams.jdField_b_of_type_Boolean = true;
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, localSendMsgParams);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_bank", 4, "AIO---sendShowLoveMessage");
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80052A5", "0X80052A5", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.sendIMEEXpression");
    if (!FileUtils.b(paramString))
    {
      ChatActivityUtils.a(paramContext, 2131434531, 0);
      ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "ChatActivity.sendIMEEXpression");
      return;
    }
    paramContext = new PicUploadInfo.Builder();
    paramContext.a(paramString);
    paramContext.d(paramInt);
    paramContext.d(paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramContext.c(TranDbRecord.PicDbRecord.d);
    paramContext.e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    paramContext.c(paramQQAppInterface.getCurrentAccountUin());
    paramContext.e(paramSessionInfo.jdField_a_of_type_Int);
    paramContext.l(paramSessionInfo.jdField_e_of_type_Int);
    PicReq localPicReq = PicBusiManager.a(2, paramInt);
    localPicReq.a(paramContext.a());
    PicBusiManager.a(localPicReq, paramQQAppInterface);
    ThreadManager.post(new rvk(paramString, paramSessionInfo, paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131433009, 0);
      return;
    }
    paramSessionInfo = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if (paramSessionInfo == null)
    {
      ChatActivityUtils.a(paramContext, 2131434464, 0);
      return;
    }
    ThreadManager.post(new rvd(paramSessionInfo, paramQQAppInterface, paramString, paramInt, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)paramQQAppInterface.getManager(47)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) && ((paramContext instanceof BaseActivity)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), 2131430273, 0).b(paramContext.getTitleBarHeight());
      return;
    }
    ThreadManager.post(new rvc(paramQQAppInterface, paramSessionInfo, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4)
  {
    if (FileUtils.b(paramString1)) {
      ForwardSendPicUtil.a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_JavaLangString, false, paramContext);
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        l1 = a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramString2, paramString3, paramLong, paramInt);
        paramContext = paramQQAppInterface.a().a(paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download1,uniseq:" + l1 + ",filePath:" + paramString1 + ",forwardImageOrgServerpath:" + paramString2 + ",forwardImageOrgItemId:" + paramLong + ",processor:" + paramContext);
        }
      } while ((paramContext == null) || (!(paramContext instanceof BaseTransProcessor)));
      paramContext = (BaseTransProcessor)paramContext;
      l2 = paramContext.c();
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download2,msgId:" + l1 + ",filePath:" + paramString1 + ",get download process status:" + l2);
      }
    } while ((l2 != 2000L) && (l2 != 2001L) && (l2 != 2002L));
    paramQQAppInterface.a().a(l1, paramString4, paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, paramString3, paramLong, paramInt);
    paramContext.a().r = paramString4;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, paramArrayList, new ChatActivityFacade.SendMsgParams());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (paramString1 == null)
    {
      QLog.e("ChatActivityFacade", 1, "sendCustomEmotion url == null");
      if (paramBoolean1) {
        VasReportUtils.a("emotionType", "emotionActionSend", "5", "", "", "", "", "", "", "");
      }
      return;
    }
    ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.sendCustomEmotion");
    if (!FileUtils.b(paramString1))
    {
      ChatActivityUtils.a(paramContext, 2131434531, 0);
      if (paramBoolean1) {
        VasReportUtils.a("emotionType", "emotionActionSend", "6", "", "", "", "", "", "", "");
      }
      QLog.e("ChatActivityFacade", 1, "sendCustomEmotion file not exist or problme: URL = " + paramString1);
      return;
    }
    Object localObject = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject).a(paramString1);
    ((PicUploadInfo.Builder)localObject).d(1006);
    ((PicUploadInfo.Builder)localObject).d(paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).c(TranDbRecord.PicDbRecord.d);
    ((PicUploadInfo.Builder)localObject).e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).c(paramQQAppInterface.getCurrentAccountUin());
    ((PicUploadInfo.Builder)localObject).e(paramSessionInfo.jdField_a_of_type_Int);
    ((PicUploadInfo.Builder)localObject).l(paramSessionInfo.jdField_e_of_type_Int);
    paramContext = PicBusiManager.a(2, 1006);
    paramContext.a(((PicUploadInfo.Builder)localObject).a());
    localObject = new PicMessageExtraData();
    ((PicMessageExtraData)localObject).imageBizType = 1;
    int i;
    if (paramBoolean2)
    {
      i = 2;
      label254:
      ((PicMessageExtraData)localObject).customFaceType = i;
      if (!paramBoolean2) {
        break label324;
      }
    }
    for (;;)
    {
      ((PicMessageExtraData)localObject).emojiPkgId = paramString2;
      if (paramStickerInfo != null) {
        ((PicMessageExtraData)localObject).stickerInfo = paramStickerInfo;
      }
      paramContext.a = ((PicMessageExtraData)localObject);
      PicBusiManager.a(paramContext, paramQQAppInterface);
      if (!paramBoolean1) {
        break;
      }
      ThreadManager.post(new rvl(paramString1, paramSessionInfo, paramQQAppInterface), 5, null, false);
      return;
      i = 0;
      break label254;
      label324:
      paramString2 = "";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, List paramList)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        String str = (String)paramList.next();
        int i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")) && (((JSONObject)localObject2).getString("uin").equals(MsgProxyUtils.a(str))))
          {
            localObject2 = paramQQAppInterface.a().b(str, 0);
            ChatActivityUtils.a(paramContext, str, 0);
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
              if (localMessageRecord.msgtype != -2019) {
                continue;
              }
              paramQQAppInterface.a().b(str, localMessageRecord.istroop, localMessageRecord.uniseq);
              continue;
            }
          }
          i += 1;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l2;
    Object localObject1;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq;
    label186:
    do
    {
      try
      {
        l1 = Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
        l2 = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("ChatActivityFacade,uin: %s, uinType: %d, id: %d", new Object[] { paramSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(paramSessionInfo.jdField_a_of_type_Int), Long.valueOf(l2) }));
        }
        if ((l2 == -1L) || (l2 == paramSessionInfo.jdField_a_of_type_Long)) {
          return;
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.msg.sendReadConfirm_PB", 2, paramQQAppInterface, new Object[0]);
        return;
      }
      paramSessionInfo.jdField_a_of_type_Long = l2;
      localObject1 = "c2c_processor";
      localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      if (paramSessionInfo.jdField_a_of_type_Int == 1)
      {
        paramSessionInfo = "troop_processor";
        localObject1 = new msg_svc.PbGroupReadedReportReq();
        ((msg_svc.PbGroupReadedReportReq)localObject1).group_code.set(l1);
        ((msg_svc.PbGroupReadedReportReq)localObject1).last_read_seq.set(l2);
        localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject1);
      }
      for (;;)
      {
        paramQQAppInterface.a().a(paramSessionInfo).a(localPbMsgReadedReportReq);
        return;
        if (paramSessionInfo.jdField_a_of_type_Int == 1026)
        {
          paramSessionInfo = "hctopic_processor";
          localObject1 = new msg_svc.PbGroupReadedReportReq();
          ((msg_svc.PbGroupReadedReportReq)localObject1).group_code.set(l1);
          ((msg_svc.PbGroupReadedReportReq)localObject1).last_read_seq.set(l2);
          localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject1);
        }
        else
        {
          if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
            break;
          }
          paramSessionInfo = "disc_processor";
          localObject1 = new msg_svc.PbDiscussReadedReportReq();
          ((msg_svc.PbDiscussReadedReportReq)localObject1).conf_uin.set(l1);
          ((msg_svc.PbDiscussReadedReportReq)localObject1).last_read_seq.set(l2);
          localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject1);
        }
      }
    } while ((!MsgProxyUtils.c(paramSessionInfo.jdField_a_of_type_Int)) || (l2 == 0L));
    if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
      if (paramSessionInfo.f == null) {
        break label538;
      }
    }
    label538:
    for (long l1 = Long.valueOf(paramSessionInfo.f).longValue(); l1 != -1L; l1 = -1L)
    {
      Object localObject2 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).peer_uin.set(l1);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).last_read_time.set((int)l2);
      if (paramSessionInfo.jdField_a_of_type_Int == 1024)
      {
        paramSessionInfo = paramQQAppInterface.a().d(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramSessionInfo != null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.sendReadConfirm_PB", 4, "Readcomfirmed------->Sig:" + HexUtil.a(paramSessionInfo) + ",length:" + paramSessionInfo.length);
          }
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).crm_sig.set(ByteStringMicro.copyFrom(paramSessionInfo));
        }
      }
      paramSessionInfo = new msg_svc.PbC2CReadedReportReq();
      paramSessionInfo.pair_info.add((MessageMicro)localObject2);
      localObject2 = paramQQAppInterface.a().a().a();
      if (localObject2 != null) {
        paramSessionInfo.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localPbMsgReadedReportReq.c2c_read_report.set(paramSessionInfo);
      paramSessionInfo = (SessionInfo)localObject1;
      break label186;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (paramIntent == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    } while ((localArrayList == null) || (localArrayList.isEmpty()) || (android.text.TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString)));
    try
    {
      int i = Integer.valueOf(paramIntent.getStringExtra("key_upload_client_key")).intValue();
      long l = a(paramQQAppInterface, paramSessionInfo, i, localArrayList);
      ((TroopQZoneUploadAlbumHandler)paramQQAppInterface.a(28)).a(i, paramSessionInfo.jdField_a_of_type_JavaLangString, l);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.post(new rve(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramMessageForPic == null))
    {
      QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("FORWARD_UIN_TYPE", paramSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("SENDER_TROOP_UIN", paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject).putExtra("FORWARD_PEER_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("FORWARD_SELF_UIN", paramQQAppInterface.getCurrentAccountUin());
    ((Intent)localObject).putExtra("forward_image_width", paramMessageForPic.width);
    ((Intent)localObject).putExtra("forward_image_height", paramMessageForPic.height);
    ((Intent)localObject).putExtra("forward_file_size", paramMessageForPic.size);
    ((Intent)localObject).putExtra("forward_image_type", paramMessageForPic.imageType);
    ((Intent)localObject).putExtra("forward_filepath", paramMessageForPic.path);
    paramSessionInfo = paramMessageForPic.frienduin + paramMessageForPic.uniseq + paramMessageForPic.istroop;
    ((Intent)localObject).putExtra("BUSI_TYPE", 1009);
    ((Intent)localObject).putExtra("forward_download_image_task_key", paramSessionInfo);
    ((Intent)localObject).putExtra("forward_download_image_org_uin", paramMessageForPic.frienduin);
    ((Intent)localObject).putExtra("forward_download_image_org_uin_type", paramMessageForPic.istroop);
    ((Intent)localObject).putExtra("forward_download_image_server_path", paramMessageForPic.uuid);
    ((Intent)localObject).putExtra("forward_download_image_item_id", paramMessageForPic.uniseq);
    ((Intent)localObject).putExtra("forward_photo_isSend", paramMessageForPic.issend);
    ((Intent)localObject).putExtra("forward_photo_md5", paramMessageForPic.md5);
    ((Intent)localObject).putExtra("forward_photo_group_fileid", paramMessageForPic.groupFileID);
    ((Intent)localObject).putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", paramMessageForPic.fileSizeFlag);
    paramSessionInfo = PicBusiManager.a(1009, (Intent)localObject);
    localObject = PicBusiManager.a(3, 1009);
    ((PicReq)localObject).a(paramSessionInfo);
    ((PicReq)localObject).a = paramMessageForPic.picExtraData;
    PicBusiManager.a((PicReq)localObject, paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 2;
    if ((paramQQAppInterface == null) || (paramMessageForShortVideo == null))
    {
      QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("from_uin", ShortVideoUtils.b(paramMessageForShortVideo));
    localIntent.putExtra("from_uin_type", paramMessageForShortVideo.istroop);
    localIntent.putExtra("from_session_uin", paramMessageForShortVideo.frienduin);
    localIntent.putExtra("from_busi_type", paramMessageForShortVideo.busiType);
    localIntent.putExtra("file_send_size", paramMessageForShortVideo.videoFileSize);
    localIntent.putExtra("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localIntent.putExtra("file_name", paramMessageForShortVideo.videoFileName);
    localIntent.putExtra("file_format", paramMessageForShortVideo.videoFileFormat);
    String str = ShortVideoUtils.a(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "Forward menu clicked, videoPath=" + str + ",videoPath = " + str + ", " + paramMessageForShortVideo.toLogString());
    }
    localIntent.putExtra("file_send_path", str);
    localIntent.putExtra("file_shortvideo_md5", paramMessageForShortVideo.md5);
    if (!android.text.TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {
      localIntent.putExtra("file_shortvideo_local_md5", paramMessageForShortVideo.mLocalMd5);
    }
    localIntent.putExtra("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localIntent.putExtra("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localIntent.putExtra("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localIntent.putExtra("file_source", paramMessageForShortVideo.fileSource);
    localIntent.putExtra("file_uuid", paramMessageForShortVideo.uuid);
    localIntent.putExtra("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localIntent.putExtra("support_progressive", paramMessageForShortVideo.supportProgressive);
    localIntent.putExtra("file_width", paramMessageForShortVideo.fileWidth);
    localIntent.putExtra("file_height", paramMessageForShortVideo.fileHeight);
    int i = paramMessageForShortVideo.busiType;
    if (i == 1)
    {
      i = 2;
      localIntent.putExtra("special_video_type", paramMessageForShortVideo.specialVideoType);
      if (paramMessageForShortVideo.CheckIsHotVideo())
      {
        localIntent.putExtra("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
        localIntent.putExtra("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
        localIntent.putExtra("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
        localIntent.putExtra("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
      }
      localIntent.putExtra("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
      if ((paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) && (paramMessageForShortVideo.senderuin.equals(paramQQAppInterface.getAccount())))
      {
        localIntent.putExtra("param_key_redbag_video_id", paramMessageForShortVideo.shortVideoId);
        localIntent.putExtra("param_key_redbag_type", paramMessageForShortVideo.redBagType);
        if (paramSessionInfo.jdField_a_of_type_Int != 1) {
          break label611;
        }
        j = 1;
      }
    }
    for (;;)
    {
      FlowCameraMqqAction.a("", "0X80088E4", String.valueOf(j));
      paramSessionInfo = ShortVideoBusiManager.a(3, i);
      paramSessionInfo.a(ShortVideoBusiManager.a(i, localIntent, paramSessionInfo));
      ShortVideoBusiManager.a(paramSessionInfo, paramQQAppInterface);
      return;
      if (i == 2)
      {
        i = 3;
        break;
      }
      i = 0;
      break;
      label611:
      if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
        j = 3;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsShareMsg paramAbsShareMsg)
  {
    a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
    ArkAppDataReport.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 2, 0, 0L, 0L, 0L, "LocationShare", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsStructMsg paramAbsStructMsg)
  {
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    }
    for (String str1 = paramQQAppInterface.getCurrentAccountUin();; str1 = paramSessionInfo.jdField_b_of_type_JavaLangString)
    {
      String str2 = paramQQAppInterface.getCurrentAccountUin();
      String str3 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      int i = paramSessionInfo.jdField_a_of_type_Int;
      int j = MobileQQService.jdField_a_of_type_Int;
      MobileQQService.jdField_a_of_type_Int = j + 1;
      paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str2, str3, str1, i, j, paramAbsStructMsg);
      paramQQAppInterface.a().a(paramSessionInfo, null);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramSessionInfo, paramString, 1010, false, (byte)1, (byte)0, (short)0, Math.abs(new Random().nextInt()), null, new ChatActivityFacade.SendMsgParams());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (paramLong != -1L)
    {
      int i = paramSessionInfo.jdField_a_of_type_Int;
      Object localObject = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, i, paramLong);
      if ((localObject instanceof MessageForPtt))
      {
        localObject = (MessageForPtt)localObject;
        ((MessageForPtt)localObject).url = paramString;
        ((MessageForPtt)localObject).fileSize = paramInt;
        ((MessageForPtt)localObject).isread = false;
        ((MessageForPtt)localObject).itemType = 2;
        ((MessageForPtt)localObject).serial();
        paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, i, paramLong, ((MessageForPtt)localObject).msgData);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3)
  {
    if ((paramSessionInfo == null) || (android.text.TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    a(paramQQAppInterface, paramSessionInfo, "我在这里，点击查看：http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString3 + ")");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, AbsShareMsg paramAbsShareMsg, String paramString5, String paramString6, String paramString7)
  {
    paramString7 = new ArkAppMessage();
    if (ArkAiAppCenter.k) {}
    for (;;)
    {
      try
      {
        paramString7.appMinVersion = "1.0.0.101";
        paramString7.appName = "com.tencent.map";
        paramString7.appView = "LocationShare";
        paramString6 = ArkAppCenter.a(paramString7.appName, paramString7.appMinVersion);
        if (paramString6 != null)
        {
          paramString7.appDesc = ((String)paramString6.get("desc"));
          paramString7.appMinVersion = ((String)paramString6.get("version"));
        }
        if ((android.text.TextUtils.isEmpty(paramString7.appDesc)) || (paramString7.appDesc.equals(paramString7.appName))) {
          paramString7.appDesc = "地图";
        }
        switch (paramSessionInfo.jdField_a_of_type_Int)
        {
        case 1000: 
          paramString6 = paramQQAppInterface.getCurrentAccountUin();
          String str1 = paramQQAppInterface.getCurrentAccountUin();
          String str2 = paramSessionInfo.jdField_a_of_type_JavaLangString;
          int i = paramSessionInfo.jdField_a_of_type_Int;
          int j = MobileQQService.jdField_a_of_type_Int;
          MobileQQService.jdField_a_of_type_Int = j + 1;
          paramString7.containStructMsg = MessageRecordFactory.a(paramQQAppInterface, str1, str2, paramString6, i, j, paramAbsShareMsg);
          paramString7.promptText = String.format("[应用]%s", new Object[] { paramString7.appDesc });
          paramString7.from = 1;
          paramString7.metaList = a(paramString5, paramString3, paramString4, paramString1, paramString2);
          paramString1 = new JSONObject();
          paramString1.put("forward", 1);
          paramString1.put("autosize", 1);
          paramString1.put("type", "card");
          paramString7.config = paramString1.toString();
          b(paramQQAppInterface, paramSessionInfo, paramString7);
          ArkAppCenter.b("sendArkStructMap", "send ark msg is success and arkMsg.metaList=" + paramString7.metaList);
          ArkAppDataReport.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 1, 0, 0L, 0L, 0L, paramString7.appView, "");
          return;
        }
      }
      catch (Exception paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArkApp", 1, "ChatActivityFacade send arkMapMessage parameter error: " + paramString1.getMessage());
        ArkAppCenter.b("sendArkStructMap", "parameter error and send ark msg is failed then send struct msg");
        a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
        return;
      }
      paramString6 = paramSessionInfo.jdField_b_of_type_JavaLangString;
      continue;
      ArkAppCenter.b("sendArkStructMap", "sIsArkStructMap is false then send struct msg");
      a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
      return;
    }
  }
  
  @TargetApi(9)
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ChatActivityFacade", 1, "insertRenewalTailTipMsgIfNeeded app == null");
    }
    int i;
    do
    {
      do
      {
        return;
        i = paramSessionInfo.jdField_a_of_type_Int;
      } while ((i != 0) && (i != 1) && (i != 3000) && (i != 1001) && (i != 10002) && (i != 10004) && (i != 1006) && (i != 1004) && (i != 1000) && (i != 3));
      localObject1 = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (!paramBoolean)
      {
        long l = ((SharedPreferences)localObject1).getLong("last_pull_individual_expire_info_time", 0L);
        if (System.currentTimeMillis() - l > 86400000L) {
          break;
        }
      }
      i = ((SharedPreferences)localObject1).getInt("renewal_tail_tip_exit", 0);
    } while (i == 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("renewal_tail_tip", "");
    Object localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putInt("renewal_tail_tip_exit", 0);
    if (Build.VERSION.SDK_INT <= 8) {
      ((SharedPreferences.Editor)localObject1).commit();
    }
    for (;;)
    {
      MsgProxyUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -4020);
      paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_Int, -4020, (String)localObject2);
      VasWebviewUtil.reportCommercialDrainage(paramSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_show", "", 1, 0, 0, "", String.valueOf(i), "");
      return;
      localObject2 = (VasExtensionHandler)paramQQAppInterface.a(71);
      if (localObject2 == null) {
        break;
      }
      ((VasExtensionHandler)localObject2).a(1);
      if (Build.VERSION.SDK_INT <= 8)
      {
        ((SharedPreferences)localObject1).edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).commit();
        return;
      }
      ((SharedPreferences)localObject1).edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).apply();
      return;
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "func tryFetchEmosmKey, app:" + paramQQAppInterface + ",e:" + paramEmoticon);
    }
    if ((paramQQAppInterface == null) || (paramEmoticon == null) || (android.text.TextUtils.isEmpty(paramEmoticon.epId)) || (android.text.TextUtils.isEmpty(paramEmoticon.eId)) || (!android.text.TextUtils.isEmpty(paramEmoticon.encryptKey))) {
      return;
    }
    EmojiManager localEmojiManager = (EmojiManager)paramQQAppInterface.getManager(42);
    ThreadManager.post(new rux(paramEmoticon, (EmoticonManager)paramQQAppInterface.getManager(13), localEmojiManager), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString, paramMessageForPtt, paramBoolean1, paramInt1, paramInt2, paramBoolean2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, DownCallBack paramDownCallBack)
  {
    paramString = new rup(paramMessageForPtt, paramQQAppInterface, paramString, paramBoolean2, paramDownCallBack, paramInt1, paramInt2);
    if (paramBoolean1)
    {
      paramString.run();
      return;
    }
    paramQQAppInterface.a(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList)
  {
    paramQQAppInterface.a().a().a(paramString, paramArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams)
  {
    String str = "";
    if (paramString != null) {
      str = MessageUtils.a(paramString, true, null);
    }
    int i = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = i + 1;
    long l1 = i;
    i = Math.abs(new Random().nextInt());
    int j = (int)MessageCache.a();
    paramString = paramQQAppInterface.getCurrentAccountUin();
    long l2 = MessageUtils.a(i);
    ChatMessage localChatMessage = (ChatMessage)MessageRecordFactory.a(-1000);
    localChatMessage.init(paramString, "", paramString, str, j, -1000, 0, l1);
    localChatMessage.isread = true;
    localChatMessage.msgUid = l2;
    localChatMessage.shmsgseq = MessageUtils.a(l1, 0);
    localChatMessage.issend = 1;
    if (paramArrayList.size() < 10) {}
    for (boolean bool = true;; bool = false)
    {
      localChatMessage.needUpdateMsgTag = bool;
      ((SVIPHandler)paramQQAppInterface.a(13)).a(localChatMessage);
      ((MessageForText)localChatMessage).msgVia = 0;
      paramQQAppInterface.a().a(paramQQAppInterface, localChatMessage, paramArrayList, paramHongbaoParams);
      return;
    }
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt)
  {
    if ((!AppSetting.h) && (paramInt == 0)) {}
    while (MsgProxyUtils.a(paramInt) == 1032) {
      return;
    }
    paramQQCustomMenu.a(2131375567, paramContext.getString(2131433638), 2130838309);
  }
  
  public static void a(List paramList)
  {
    if ((jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (!((ChatMessage)paramList.get(0)).isLongMsg()) {
        break label120;
      }
      Iterator localIterator = paramList.iterator();
      ChatMessage localChatMessage;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)localIterator.next();
      } while ((localChatMessage.shmsgseq != jdField_a_of_type_ComTencentMobileqqDataChatMessage.shmsgseq) || (localChatMessage.msgUid != jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgUid));
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if (((i != 0) || (paramList.contains(jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && (jdField_a_of_type_ComTencentWidgetActionSheet != null)) {
        jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
    }
  }
  
  private static boolean a(SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.jdField_a_of_type_Int;
    return (i == 0) || (i == 3000) || (i == 1);
  }
  
  private static boolean a(SessionInfo paramSessionInfo, String paramString, Bundle paramBundle)
  {
    if ((!android.text.TextUtils.isEmpty(paramString)) && (!paramString.equals("Unknown Address")))
    {
      if (paramBundle != null)
      {
        if (paramBundle.getInt("isArk") == 0)
        {
          ArkAppCenter.b("sendArkStructMap", "isSendArkMsg, isArk=0 and sendStructMsg");
          return false;
        }
        if (a(paramSessionInfo))
        {
          ArkAppCenter.b("sendArkStructMap", "isSendArkMsg, session is allowed and sendArkMsg");
          return true;
        }
        ArkAppCenter.b("sendArkStructMap", "isSendArkMsg, session is not allowed and sendStructMsg");
        return false;
      }
      ArkAppCenter.b("sendArkStructMap", "isSendArkMsg, extra is empty and sendStructMsg");
      return false;
    }
    ArkAppCenter.b("sendArkStructMap", "isSendArkMsg,could not find location and sendStructMsg");
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForLongMsg paramMessageForLongMsg)
  {
    paramContext = paramMessageForLongMsg.longMsgFragmentList;
    if ((paramContext == null) || (paramContext.isEmpty())) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramMessageForLongMsg = (MessageRecord)paramContext.next();
      if (paramMessageForLongMsg.extraflag == 32768)
      {
        if (paramMessageForLongMsg.isSendFromLocal()) {
          paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramMessageForLongMsg.frienduin, paramMessageForLongMsg.uniseq));
        }
        paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramMessageForLongMsg.uniseq);
        if (paramMessageForLongMsg.msgtype == -1000)
        {
          paramMessageForLongMsg = MessageRecordFactory.a(paramMessageForLongMsg);
          paramQQAppInterface.a().a(paramMessageForLongMsg, null, true);
        }
      }
    }
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      bool = false;
    }
    long l1;
    long l2;
    do
    {
      return bool;
      l1 = c(paramQQAppInterface, paramSessionInfo);
      l1 = NetConnInfoCenter.getServerTimeMillis() - l1;
      l2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "requestAIOFeedsDiv", 900000);
      if (l1 <= l2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    return true;
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = MessageRecordFactory.b(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    if (paramSessionInfo.istroop == 1) {
      AnonymousChatHelper.a().a(paramSessionInfo);
    }
    paramSessionInfo.saveExtInfoToExtStr(MessageConstants.e, "1");
    paramQQAppInterface.a().a(paramSessionInfo, null);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkFlashChatMessage paramArkFlashChatMessage)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkFlashChatMessage);
    if (paramSessionInfo.istroop == 1) {
      AnonymousChatHelper.a().a(paramSessionInfo);
    }
    paramQQAppInterface.a().a(paramSessionInfo, null);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, MessageObserver paramMessageObserver)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramHiBoomMessage);
    if (paramSessionInfo.istroop == 1) {
      AnonymousChatHelper.a().a(paramSessionInfo);
    }
    paramQQAppInterface.a().a(paramSessionInfo, paramMessageObserver);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForArkBabyqReply paramMessageForArkBabyqReply, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramMessageForArkBabyqReply, paramBoolean1, paramBoolean2);
    if (paramSessionInfo.msgData.length > 1120) {
      return a(paramQQAppInterface, paramSessionInfo, true);
    }
    paramQQAppInterface.a().a(paramSessionInfo, null);
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    return (LongTextMsgManager.a(paramQQAppInterface)) && (paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo == null) && (MsgProxyUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) && (paramString.getBytes("utf-8").length > 560);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    if (paramMessageForArkApp.istroop == 1) {
      AnonymousChatHelper.a().a(paramMessageForArkApp);
    }
    if (paramBoolean) {
      paramQQAppInterface.a().b(paramMessageForArkApp, paramQQAppInterface.getCurrentAccountUin());
    }
    paramMessageForArkApp.mPendantAnimatable = true;
    Object localObject = paramQQAppInterface.a().a().a(paramMessageForArkApp);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
      }
      paramMessageForArkApp.extraflag = 32768;
      paramQQAppInterface.a().a(paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq);
      localObject = paramMessageForArkApp.frienduin;
      int i = paramMessageForArkApp.istroop;
      long l = paramMessageForArkApp.uniseq;
      ((MessageHandler)paramQQAppInterface.a(0)).a(MessageHandler.c(paramMessageForArkApp.istroop), false, new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return true;
    }
    paramBoolean = ((LongTextMsgManager)paramQQAppInterface.getManager(165)).a(paramQQAppInterface, (byte[])localObject, paramQQAppInterface.getCurrentAccountUin(), paramMessageForArkApp.frienduin, paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq, 1035, new rvi(paramMessageForArkApp, paramQQAppInterface));
    if (paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
      }
      LongTextMsgManager.a(paramQQAppInterface, paramMessageForArkApp);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForArkBabyqReply paramMessageForArkBabyqReply, boolean paramBoolean)
  {
    if (paramMessageForArkBabyqReply == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "step1: sendArkBabyQReplyLongMessage saveMessage start currenttime:" + System.currentTimeMillis());
    }
    paramMessageForArkBabyqReply.mPendantAnimatable = true;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (paramBoolean) {
      paramQQAppInterface.a().b(paramMessageForArkBabyqReply, str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "step2: sendArkBabyQReplyLongMessage saveMessage end and pack longTextMsg start currenttime:" + System.currentTimeMillis());
    }
    byte[] arrayOfByte = paramQQAppInterface.a().a().a(paramMessageForArkBabyqReply);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "step2: sendArkBabyQReplyLongMessage pack failed! packData is null.............................");
      }
      paramMessageForArkBabyqReply.extraflag = 32768;
      paramQQAppInterface.a().a(paramMessageForArkBabyqReply.frienduin, paramMessageForArkBabyqReply.istroop, paramMessageForArkBabyqReply.uniseq);
      str = paramMessageForArkBabyqReply.frienduin;
      int i = paramMessageForArkBabyqReply.istroop;
      long l = paramMessageForArkBabyqReply.uniseq;
      ((MessageHandler)paramQQAppInterface.a(0)).a(MessageHandler.c(paramMessageForArkBabyqReply.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return true;
    }
    ((LongTextMsgManager)paramQQAppInterface.getManager(165)).a(paramQQAppInterface, arrayOfByte, str, paramMessageForArkBabyqReply.frienduin, paramMessageForArkBabyqReply.frienduin, paramMessageForArkBabyqReply.istroop, paramMessageForArkBabyqReply.uniseq, 1035, new rvj(paramMessageForArkBabyqReply, paramQQAppInterface));
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForPtt))) {
      return ((MessageForPtt)paramQQAppInterface).c2cViaOffline;
    }
    return false;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramSendMsgParams == null) || (paramSessionInfo == null) || (android.text.TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramContext = a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList, paramSendMsgParams);
      ThreadManager.post(new rur(paramSendMsgParams, paramQQAppInterface, paramSessionInfo), 8, null, true);
      paramQQAppInterface = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramContext;
  }
  
  /* Error */
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    // Byte code:
    //   0: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 134
    //   8: iconst_2
    //   9: new 136	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 2982
    //   19: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   25: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_2
    //   35: aload_3
    //   36: invokestatic 545	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Ljava/lang/String;Ljava/util/ArrayList;)Ljava/lang/String;
    //   39: astore 16
    //   41: aload 16
    //   43: ifnonnull +5 -> 48
    //   46: aconst_null
    //   47: areturn
    //   48: new 547	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 548	java/util/ArrayList:<init>	()V
    //   55: astore 14
    //   57: iconst_0
    //   58: istore 12
    //   60: iconst_0
    //   61: istore 11
    //   63: iconst_0
    //   64: istore 6
    //   66: new 550	java/util/Random
    //   69: dup
    //   70: invokespecial 551	java/util/Random:<init>	()V
    //   73: astore 15
    //   75: aload_0
    //   76: aload_1
    //   77: aload 16
    //   79: aload 4
    //   81: invokestatic 554	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;Lcom/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams;)Z
    //   84: ifeq +282 -> 366
    //   87: aload 16
    //   89: aload_3
    //   90: aload 4
    //   92: aload 14
    //   94: invokestatic 557	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   97: astore_3
    //   98: iload 6
    //   100: istore 5
    //   102: iload 11
    //   104: istore 9
    //   106: aload_3
    //   107: astore 13
    //   109: iload 12
    //   111: istore 10
    //   113: aload_3
    //   114: astore_2
    //   115: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +80 -> 198
    //   121: iload 12
    //   123: istore 10
    //   125: aload_3
    //   126: astore_2
    //   127: ldc 134
    //   129: iconst_2
    //   130: new 136	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 2984
    //   140: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 14
    //   145: invokevirtual 561	java/util/ArrayList:size	()I
    //   148: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: ldc_w 563
    //   154: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 16
    //   159: ldc_w 565
    //   162: invokevirtual 569	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   165: arraylength
    //   166: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: ldc_w 571
    //   172: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   178: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   181: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_3
    //   188: astore 13
    //   190: iload 11
    //   192: istore 9
    //   194: iload 6
    //   196: istore 5
    //   198: aload 13
    //   200: astore_2
    //   201: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +31 -> 235
    //   207: ldc 134
    //   209: iconst_2
    //   210: new 136	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 2986
    //   220: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   226: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   229: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload 15
    //   237: invokevirtual 576	java/util/Random:nextInt	()I
    //   240: invokestatic 582	java/lang/Math:abs	(I)I
    //   243: istore 8
    //   245: aload_2
    //   246: invokevirtual 561	java/util/ArrayList:size	()I
    //   249: newarray long
    //   251: astore 13
    //   253: iconst_0
    //   254: istore 7
    //   256: iload 7
    //   258: aload_2
    //   259: invokevirtual 561	java/util/ArrayList:size	()I
    //   262: if_icmpge +274 -> 536
    //   265: aload_2
    //   266: iload 7
    //   268: invokevirtual 586	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   271: checkcast 221	java/lang/String
    //   274: astore 16
    //   276: aload 14
    //   278: invokevirtual 561	java/util/ArrayList:size	()I
    //   281: iload 7
    //   283: if_icmple +248 -> 531
    //   286: aload 14
    //   288: iload 7
    //   290: invokevirtual 586	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   293: checkcast 547	java/util/ArrayList
    //   296: astore_3
    //   297: aload_1
    //   298: getfield 54	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   301: sipush 3000
    //   304: if_icmpeq +11 -> 315
    //   307: aload_1
    //   308: getfield 54	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   311: iconst_1
    //   312: if_icmpne +13 -> 325
    //   315: aload 15
    //   317: invokevirtual 576	java/util/Random:nextInt	()I
    //   320: invokestatic 582	java/lang/Math:abs	(I)I
    //   323: istore 8
    //   325: aload 13
    //   327: iload 7
    //   329: aload_0
    //   330: aload_1
    //   331: aload 16
    //   333: sipush -1000
    //   336: iload 9
    //   338: aload_2
    //   339: invokevirtual 561	java/util/ArrayList:size	()I
    //   342: i2b
    //   343: iload 7
    //   345: i2b
    //   346: iload 5
    //   348: iload 8
    //   350: aload_3
    //   351: aload 4
    //   353: invokestatic 2630	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;IZBBSILjava/util/ArrayList;Lcom/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams;)J
    //   356: lastore
    //   357: iload 7
    //   359: iconst_1
    //   360: iadd
    //   361: istore 7
    //   363: goto -107 -> 256
    //   366: aload 16
    //   368: sipush 560
    //   371: bipush 20
    //   373: aload_3
    //   374: aload 14
    //   376: invokestatic 593	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;IILjava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   379: astore 13
    //   381: iload 12
    //   383: istore 10
    //   385: aload 13
    //   387: astore_2
    //   388: aload 13
    //   390: invokevirtual 561	java/util/ArrayList:size	()I
    //   393: iconst_1
    //   394: if_icmple +115 -> 509
    //   397: iconst_1
    //   398: istore 9
    //   400: iload 9
    //   402: istore 10
    //   404: aload 13
    //   406: astore_2
    //   407: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +77 -> 487
    //   413: iload 9
    //   415: istore 10
    //   417: aload 13
    //   419: astore_2
    //   420: ldc 134
    //   422: iconst_2
    //   423: new 136	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   430: ldc_w 2984
    //   433: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 14
    //   438: invokevirtual 561	java/util/ArrayList:size	()I
    //   441: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc_w 595
    //   447: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 13
    //   452: invokevirtual 561	java/util/ArrayList:size	()I
    //   455: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc_w 597
    //   461: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: iload 9
    //   466: invokevirtual 600	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   469: ldc_w 571
    //   472: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   478: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: iload 9
    //   489: istore 10
    //   491: aload 13
    //   493: astore_2
    //   494: aload_0
    //   495: aload_1
    //   496: iload 9
    //   498: iconst_0
    //   499: aload 15
    //   501: invokestatic 603	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/activity/aio/SessionInfo;ZSLjava/util/Random;)S
    //   504: istore 5
    //   506: goto -308 -> 198
    //   509: iconst_0
    //   510: istore 9
    //   512: goto -112 -> 400
    //   515: astore_3
    //   516: iconst_0
    //   517: istore 9
    //   519: aconst_null
    //   520: astore_2
    //   521: aload_3
    //   522: invokevirtual 606	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   525: iconst_0
    //   526: istore 5
    //   528: goto -327 -> 201
    //   531: aconst_null
    //   532: astore_3
    //   533: goto -236 -> 297
    //   536: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +31 -> 570
    //   542: ldc 134
    //   544: iconst_2
    //   545: new 136	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   552: ldc_w 2988
    //   555: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   561: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   564: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 13
    //   572: areturn
    //   573: astore_3
    //   574: iload 10
    //   576: istore 9
    //   578: goto -57 -> 521
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	paramQQAppInterface	QQAppInterface
    //   0	581	1	paramSessionInfo	SessionInfo
    //   0	581	2	paramString	String
    //   0	581	3	paramArrayList	ArrayList
    //   0	581	4	paramSendMsgParams	ChatActivityFacade.SendMsgParams
    //   100	427	5	s1	short
    //   64	131	6	s2	short
    //   254	108	7	i	int
    //   243	106	8	j	int
    //   104	473	9	bool1	boolean
    //   111	464	10	bool2	boolean
    //   61	130	11	bool3	boolean
    //   58	324	12	bool4	boolean
    //   107	464	13	localObject	Object
    //   55	382	14	localArrayList	ArrayList
    //   73	427	15	localRandom	Random
    //   39	328	16	str	String
    // Exception table:
    //   from	to	target	type
    //   75	98	515	java/io/UnsupportedEncodingException
    //   366	381	515	java/io/UnsupportedEncodingException
    //   115	121	573	java/io/UnsupportedEncodingException
    //   127	187	573	java/io/UnsupportedEncodingException
    //   388	397	573	java/io/UnsupportedEncodingException
    //   407	413	573	java/io/UnsupportedEncodingException
    //   420	487	573	java/io/UnsupportedEncodingException
    //   494	506	573	java/io/UnsupportedEncodingException
  }
  
  private static long b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 0)
    {
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.richTime;
      }
    }
    return 0L;
  }
  
  public static MessageRecord b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (MsgProxyUtils.c(paramSessionInfo.jdField_a_of_type_Int))
    {
      List localList = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((localList != null) && (!localList.isEmpty()))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)localList.get(i);
          if (!MsgUtils.b(paramSessionInfo.issend))
          {
            paramQQAppInterface = paramSessionInfo;
            if (paramSessionInfo.msgtype != -1034) {
              return paramQQAppInterface;
            }
          }
          i -= 1;
        }
      }
    }
    paramQQAppInterface = null;
    return paramQQAppInterface;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, 1, -1, "", "", 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt, -1, paramString1, paramString2, 2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131433009, 0);
      return;
    }
    MessageRecord localMessageRecord = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (localMessageRecord == null)
    {
      ChatActivityUtils.a(paramContext, 2131434464, 0);
      return;
    }
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(localMessageRecord);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, new ChatActivityFacade.SendMsgParams());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.post(new rvf(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIONewestFeedRsp paramAIONewestFeedRsp)
  {
    if ((paramAIONewestFeedRsp == null) || (paramAIONewestFeedRsp.uOpuin != Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue()) || (paramAIONewestFeedRsp.uFeedInfos == null) || (paramAIONewestFeedRsp.uFeedInfos.isEmpty())) {
      if ((paramAIONewestFeedRsp != null) && (paramAIONewestFeedRsp.uOpFlag == 1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "newestFeed.uOpFlag==1  需要清理本地缓存");
        }
        paramSessionInfo = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
        if (paramSessionInfo != null) {
          paramSessionInfo = paramSessionInfo.iterator();
        }
      }
      else
      {
        while (paramSessionInfo.hasNext())
        {
          paramAIONewestFeedRsp = (MessageRecord)paramSessionInfo.next();
          if (paramAIONewestFeedRsp != null)
          {
            paramQQAppInterface.a().a(paramAIONewestFeedRsp.frienduin, 0, paramAIONewestFeedRsp.msgtype, paramAIONewestFeedRsp.uniseq);
            paramQQAppInterface.a().b(paramAIONewestFeedRsp.frienduin, paramAIONewestFeedRsp.istroop, paramAIONewestFeedRsp.uniseq);
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage 没有拉去到feeds信息");
            }
          }
        }
      }
    }
    do
    {
      do
      {
        return;
        paramAIONewestFeedRsp = (NewestFeedInfo)paramAIONewestFeedRsp.uFeedInfos.get(0);
        if (paramAIONewestFeedRsp != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage feedInfo == null");
      return;
      localObject = a(paramAIONewestFeedRsp);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, "jsonOb == null");
    return;
    Object localObject = ((JSONObject)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage feedMsg:" + (String)localObject);
    }
    long l1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "aioFeedsAndSingnatureLeastIntervalTime", 60L);
    long l2 = b(paramQQAppInterface, paramSessionInfo);
    if (Math.abs(l2 - paramAIONewestFeedRsp.uTime) < l1)
    {
      QLog.i("ChatActivityFacade.QZoneFeeds", 1, "latestSignTime:" + l2 + ",feedInfo.uTime:" + paramAIONewestFeedRsp.uTime + ",interval time < " + l1 + ",don't show qzone feed message");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new rvh(paramQQAppInterface, paramSessionInfo, paramAIONewestFeedRsp, (String)localObject));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localFileManagerEntity = paramQQAppInterface.a().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
      if ((localFileManagerEntity == null) && (QLog.isColorLevel())) {
        QLog.w("ChatActivityFacade", 2, "why FileManagerEntity is null?! may be is old data!");
      }
      if (paramChatMessage.isSendFromLocal()) {
        paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
      }
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.getCloudType() != 0) {
          break label139;
        }
        paramQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        paramQQAppInterface.a().b(localFileManagerEntity);
        if (localFileManagerEntity.getCloudType() == 0) {
          paramQQAppInterface.a().d(localFileManagerEntity.nSessionId);
        }
        paramQQAppInterface.a().b(localFileManagerEntity.nSessionId);
      }
    }
    label139:
    do
    {
      return;
      paramQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      break;
      if ((paramChatMessage instanceof MessageForDevShortVideo))
      {
        ((DeviceFileHandler)paramQQAppInterface.a(50)).a(0, ((MessageForDevShortVideo)paramChatMessage).fileSessionId, false);
        return;
      }
    } while (!(paramChatMessage instanceof MessageForDevPtt));
    ((DeviceFileHandler)paramQQAppInterface.a(50)).a(0, ((MessageForDevPtt)paramChatMessage).fileSessionId, false);
  }
  
  public static void b(List paramList)
  {
    if ((jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (paramList.size() > 0) && (jdField_a_of_type_JavaUtilList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage1 = (ChatMessage)paramList.next();
        if (jdField_a_of_type_JavaUtilList.contains(localChatMessage1))
        {
          jdField_a_of_type_JavaUtilList.remove(localChatMessage1);
        }
        else if (localChatMessage1.isLongMsg())
        {
          Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            ChatMessage localChatMessage2 = (ChatMessage)localIterator.next();
            if ((localChatMessage2.shmsgseq == localChatMessage1.shmsgseq) && (localChatMessage2.msgUid == localChatMessage1.msgUid)) {
              localIterator.remove();
            }
          }
        }
      }
      if ((jdField_a_of_type_JavaUtilList.size() == 0) && (b != null)) {
        b.dismiss();
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    if (paramSessionInfo.istroop == 1) {
      AnonymousChatHelper.a().a(paramSessionInfo);
    }
    paramQQAppInterface.a().a(paramSessionInfo, null);
    return true;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    do
    {
      return false;
      if (!QZoneHelper.j()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, "wns 下发配置 要隐藏aio feeds，所以也不发请求了");
    return false;
    if (paramBoolean) {
      return a(paramQQAppInterface, paramSessionInfo);
    }
    return true;
  }
  
  @TargetApi(9)
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return false;
    }
    EmoticonPackage localEmoticonPackage = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramString);
    if ((localEmoticonPackage == null) || ((localEmoticonPackage.extraFlags & 0x1) <= 0)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "isShowEmotionRewordTips epId = " + paramString);
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("originalEmotionCountSp_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    int i = paramQQAppInterface.getInt(paramString, 0) + 1;
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putInt(paramString, i);
    if (Build.VERSION.SDK_INT <= 8) {
      paramQQAppInterface.commit();
    }
    while (i == 21)
    {
      return true;
      paramQQAppInterface.apply();
    }
    return false;
  }
  
  private static long c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return 0L;
    }
    return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(a(paramQQAppInterface, paramSessionInfo), 0L);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      paramContext = MessageRecordFactory.a(paramContext);
      paramQQAppInterface.a().a(paramContext, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ChatActivityFacade", 2, "resendApolloMessage : mr is null.");
  }
  
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {}
    do
    {
      return;
      try
      {
        ((MessageHandler)paramQQAppInterface.a(0)).c(Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue());
        return;
      }
      catch (Exception paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade", 2, "insertCommonHobbyIfNeeded uin is: " + paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private static long d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = (MessageRecord)paramQQAppInterface.get(0);
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForQzoneFeed)))
      {
        paramSessionInfo = (MessageForQzoneFeed)paramQQAppInterface;
        paramSessionInfo.parse();
        if (QLog.isColorLevel()) {
          QLog.w("ChatActivityFacade.QZoneFeeds", 2, "获取到最新空间feeds的：" + String.valueOf(paramQQAppInterface) + "：feeds json:" + paramSessionInfo.feedMsg);
        }
        return paramSessionInfo.feedTime;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ChatActivityFacade.QZoneFeeds", 2, "message record 有误:" + String.valueOf(paramQQAppInterface));
      }
    }
    for (;;)
    {
      return 0L;
      if (QLog.isColorLevel()) {
        QLog.w("ChatActivityFacade.QZoneFeeds", 2, "message recode 为空，无法获取发布时间");
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.post(new rvg(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-4005);
    long l = MessageCache.a();
    localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getContext().getString(2131433723), l, -4005, paramSessionInfo.jdField_a_of_type_Int, l);
    localMessageRecord.isread = true;
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageRecord, false)) {
      paramQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject1 = new EventItem(18, null);
    ((EventItem)localObject1).eventType = 538052865;
    Object localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("utf-8");
    ((EventItem)localObject1).writeTo((JceOutputStream)localObject2);
    localObject1 = new String(((JceOutputStream)localObject2).toByteArray());
    localObject2 = paramQQAppInterface.a();
    paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
    int i = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = i + 1;
    ((MessageHandler)localObject2).a(paramSessionInfo, (String)localObject1, (byte)18, paramQQAppInterface, i, -1L);
  }
  
  private static void i(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {
      return;
    }
    Object localObject = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
    label48:
    int j;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label165;
      }
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForQzoneFeed)) || (!((MessageForQzoneFeed)localMessageRecord).isOldStructMsg)) {
        break label175;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "删除老结构的feeds");
      }
      paramQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      paramQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
      i = 1;
    }
    label165:
    label175:
    for (;;)
    {
      break label48;
      j = 0;
      if (j == 0) {
        break;
      }
      k(paramQQAppInterface, paramSessionInfo);
      return;
    }
  }
  
  private static void j(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo);
    paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramSessionInfo, NetConnInfoCenter.getServerTimeMillis()).apply();
  }
  
  private static void k(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0);
    paramQQAppInterface = a(paramQQAppInterface, paramSessionInfo);
    localSharedPreferences.edit().remove(paramQQAppInterface).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade
 * JD-Core Version:    0.7.0.1
 */