package com.tencent.mobileqq.activity;

import AccostSvc.EventItem;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import NS_MOBILE_AIONewestFeed.Media_Data;
import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import NS_QQ_STORY_CLIENT.CLIENT.StGetUserNewestStoryRsp;
import NS_QQ_STORY_META.META.StStoryFeed;
import VIP.AIOSendReq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import com.etrump.mixlayout.FontManager;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinMD5Cache;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.AIOConfigData;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.app.VIPAioSendHandler;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.business.qvip.QVipDiyTemplateConfig;
import com.tencent.mobileqq.config.business.qvip.QVipDiyTemplateProcessor;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQCircleFeed.MediaData;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.LongArkMsgManager;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgHelper;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudRead.StGetC2CFeedRsp;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.AtTroopMemberInfo;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class ChatActivityFacade
{
  public static long a;
  private static ChatActivityFacade.QZoneNewestAioStoryFeedObserver jdField_a_of_type_ComTencentMobileqqActivityChatActivityFacade$QZoneNewestAioStoryFeedObserver;
  public static ChatMessage a;
  public static QQToast a;
  public static ActionSheet a;
  public static List<ChatMessage> a;
  private static ConcurrentHashMap<String, ChatActivityFacade.QZoneNewestFeedObserver> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static ActionSheet b;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ComTencentMobileqqActivityChatActivityFacade$QZoneNewestAioStoryFeedObserver = new ChatActivityFacade.QZoneNewestAioStoryFeedObserver();
    jdField_a_of_type_ComTencentMobileqqWidgetQQToast = null;
    jdField_a_of_type_ComTencentWidgetActionSheet = null;
    jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    b = null;
    jdField_a_of_type_JavaUtilList = null;
  }
  
  private static int a(SessionInfo paramSessionInfo, int paramInt, FriendsManager paramFriendsManager)
  {
    int i;
    if ((paramInt != 1000) && (paramInt != 1004) && (paramInt != 1006) && (paramInt != 1023) && (paramInt != 1022))
    {
      i = paramInt;
      if (paramInt != 10010) {}
    }
    else
    {
      i = paramInt;
      if (paramFriendsManager.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        i = 0;
      }
    }
    return i;
  }
  
  private static int a(SessionInfo paramSessionInfo, String paramString)
  {
    if ((!QVipDiyTemplateProcessor.c().jdField_b_of_type_Boolean) && ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)))
    {
      paramString = Utils.a(paramString);
      int j = paramString[0];
      int i = j;
      if (paramSessionInfo.jdField_a_of_type_Int == 1) {
        i = j + paramString[1] * 2;
      }
      return i;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {
      return Utils.a(paramString)[0];
    }
    return paramString.getBytes("utf-8").length;
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList<String> paramArrayList)
  {
    long l1 = -1L;
    paramArrayList = StructMsgHelper.a(paramArrayList);
    if (paramArrayList != null)
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      int i = MobileQQService.seq;
      MobileQQService.seq = i + 1;
      l1 = i;
      paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l1, paramArrayList);
      long l2 = paramSessionInfo.uniseq;
      paramSessionInfo.msgUid = MessageUtils.a(paramInt);
      l1 = l2;
      if (!MessageHandlerUtils.a(paramQQAppInterface, paramSessionInfo, false))
      {
        paramQQAppInterface.getMessageFacade().a(paramSessionInfo);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)a(paramQQAppInterface, paramString, paramSessionInfo, -3, 0);
    long l1 = 0L;
    if (localMessageForPtt != null)
    {
      long l2 = localMessageForPtt.uniseq;
      l1 = l2;
      if (l2 != -1L)
      {
        int i = QQRecorder.a(localMessageForPtt);
        int j = RecordParams.a(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
        a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString, l2, true, i * 1000, j, true, 0, 0, true, localMessageForPtt.vipSubBubbleId, localBundle);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramString, paramInt1, paramBoolean, paramByte1, paramByte2, paramShort, paramInt2, paramArrayList, paramSendMsgParams, false);
  }
  
  /* Error */
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean1, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +42 -> 45
    //   6: ldc 189
    //   8: iconst_2
    //   9: new 191	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   16: ldc 194
    //   18: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   24: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 209
    //   29: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: getfield 211	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   36: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_2
    //   46: ifnull +1422 -> 1468
    //   49: aload_2
    //   50: iconst_1
    //   51: aload 9
    //   53: invokestatic 223	com/tencent/mobileqq/service/message/MessageUtils:a	(Ljava/lang/String;ZLjava/util/ArrayList;)Ljava/lang/String;
    //   56: astore 15
    //   58: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +30 -> 91
    //   64: ldc 189
    //   66: iconst_2
    //   67: new 191	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   74: ldc 225
    //   76: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   82: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_1
    //   92: getfield 71	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   95: istore_3
    //   96: aload_0
    //   97: getstatic 230	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   100: invokevirtual 234	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   103: checkcast 53	com/tencent/mobileqq/app/FriendsManager
    //   106: astore 16
    //   108: aload_1
    //   109: iload_3
    //   110: aload 16
    //   112: invokestatic 236	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;ILcom/tencent/mobileqq/app/FriendsManager;)I
    //   115: istore 14
    //   117: aload 10
    //   119: getfield 241	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_e_of_type_Long	J
    //   122: lconst_0
    //   123: lcmp
    //   124: ifeq +664 -> 788
    //   127: new 243	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   130: dup
    //   131: invokespecial 244	com/tencent/mobileqq/data/MessageForWantGiftMsg:<init>	()V
    //   134: astore_2
    //   135: aload_2
    //   136: checkcast 243	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   139: aload 10
    //   141: getfield 241	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_e_of_type_Long	J
    //   144: putfield 247	com/tencent/mobileqq/data/MessageForWantGiftMsg:wantGiftSenderUin	J
    //   147: aload_2
    //   148: checkcast 243	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   151: getstatic 250	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   154: new 191	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   161: aload 10
    //   163: getfield 241	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_e_of_type_Long	J
    //   166: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: ldc 252
    //   171: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokevirtual 256	com/tencent/mobileqq/data/MessageForWantGiftMsg:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_2
    //   181: sipush -2056
    //   184: putfield 261	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   187: aload_0
    //   188: aload_2
    //   189: aload_1
    //   190: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   193: aload_1
    //   194: getfield 263	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   197: iload 14
    //   199: invokestatic 266	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;I)V
    //   202: aload_2
    //   203: aload 15
    //   205: putfield 269	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   208: aload_2
    //   209: iload 8
    //   211: invokestatic 120	com/tencent/mobileqq/service/message/MessageUtils:a	(I)J
    //   214: putfield 270	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   217: aload_2
    //   218: iload 5
    //   220: putfield 273	com/tencent/mobileqq/data/ChatMessage:longMsgCount	I
    //   223: aload_2
    //   224: iload 6
    //   226: putfield 276	com/tencent/mobileqq/data/ChatMessage:longMsgIndex	I
    //   229: aload_2
    //   230: iload 7
    //   232: putfield 279	com/tencent/mobileqq/data/ChatMessage:longMsgId	I
    //   235: aload_2
    //   236: iconst_1
    //   237: putfield 282	com/tencent/mobileqq/data/ChatMessage:mAnimFlag	Z
    //   240: aload_2
    //   241: iconst_1
    //   242: putfield 285	com/tencent/mobileqq/data/ChatMessage:mNewAnimFlag	Z
    //   245: aload 10
    //   247: getfield 288	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo	Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;
    //   250: ifnull +30 -> 280
    //   253: aload_2
    //   254: ldc_w 290
    //   257: aload 10
    //   259: getfield 288	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo	Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;
    //   262: invokevirtual 295	com/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo:toJsonString	()Ljava/lang/String;
    //   265: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_2
    //   269: aconst_null
    //   270: invokestatic 301	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;)V
    //   273: invokestatic 304	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiStickerManager;
    //   276: aload_2
    //   277: invokevirtual 305	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   280: aload 10
    //   282: getfield 308	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:i	Z
    //   285: ifeq +8 -> 293
    //   288: aload_2
    //   289: iconst_m1
    //   290: putfield 311	com/tencent/mobileqq/data/ChatMessage:mRobotFlag	I
    //   293: aload 10
    //   295: getfield 314	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_g_of_type_Int	I
    //   298: iconst_m1
    //   299: if_icmpeq +18 -> 317
    //   302: aload_2
    //   303: ldc_w 316
    //   306: aload 10
    //   308: getfield 314	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_g_of_type_Int	I
    //   311: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   314: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_2
    //   318: instanceof 322
    //   321: ifeq +979 -> 1300
    //   324: aload_2
    //   325: checkcast 322	com/tencent/mobileqq/data/MessageForReplyText
    //   328: astore 15
    //   330: aload 15
    //   332: aload_1
    //   333: getfield 211	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   336: putfield 325	com/tencent/mobileqq/data/MessageForReplyText:msgVia	I
    //   339: aload 15
    //   341: aload 10
    //   343: getfield 327	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_d_of_type_Boolean	Z
    //   346: putfield 330	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   349: aload 15
    //   351: aload 10
    //   353: getfield 332	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_b_of_type_Long	J
    //   356: putfield 335	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   359: aload 15
    //   361: aload 10
    //   363: getfield 337	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_d_of_type_Int	I
    //   366: putfield 340	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   369: aload 15
    //   371: getfield 330	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   374: ifeq +35 -> 409
    //   377: aload 15
    //   379: ldc_w 342
    //   382: aload 15
    //   384: getfield 335	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   387: invokestatic 345	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   390: invokevirtual 346	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload 15
    //   395: ldc_w 348
    //   398: aload 15
    //   400: getfield 340	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   403: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   406: invokevirtual 346	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: aload 9
    //   411: ifnull +10 -> 421
    //   414: aload 15
    //   416: aload 9
    //   418: putfield 352	com/tencent/mobileqq/data/MessageForReplyText:atInfoList	Ljava/util/ArrayList;
    //   421: aload 10
    //   423: getfield 355	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   426: invokestatic 360	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   429: invokestatic 366	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   432: astore 9
    //   434: aload 15
    //   436: aload 10
    //   438: getfield 355	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   441: putfield 369	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   444: aload 15
    //   446: ldc_w 371
    //   449: aload 9
    //   451: invokevirtual 346	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload 15
    //   456: aload 15
    //   458: getfield 374	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   461: iconst_1
    //   462: ior
    //   463: putfield 374	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   466: aload 15
    //   468: getfield 369	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   471: invokevirtual 380	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:getSourceMsg	()[B
    //   474: ifnull +17 -> 491
    //   477: aload 15
    //   479: aload 15
    //   481: getfield 369	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   484: aload_0
    //   485: invokevirtual 384	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:unPackSourceMsg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   488: invokevirtual 387	com/tencent/mobileqq/data/MessageForReplyText:setSourceMessageRecord	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   491: aload 10
    //   493: getfield 388	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   496: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   499: ifne +40 -> 539
    //   502: aload 10
    //   504: getfield 395	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   507: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   510: ifne +29 -> 539
    //   513: aload 15
    //   515: ldc_w 397
    //   518: aload 10
    //   520: getfield 388	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   523: invokevirtual 346	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload 15
    //   528: ldc_w 399
    //   531: aload 10
    //   533: getfield 395	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   536: invokevirtual 346	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: aload 10
    //   541: getfield 401	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_e_of_type_Int	I
    //   544: ifle +23 -> 567
    //   547: invokestatic 406	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	()Lcom/tencent/mobileqq/activity/aio/forward/ForwardOrderManager;
    //   550: aload_2
    //   551: getfield 407	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   554: aload 10
    //   556: getfield 409	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_c_of_type_Long	J
    //   559: aload 10
    //   561: getfield 401	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_e_of_type_Int	I
    //   564: invokevirtual 412	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	(JJI)V
    //   567: aload_2
    //   568: getfield 415	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   571: iconst_1
    //   572: if_icmpne +765 -> 1337
    //   575: invokestatic 420	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   578: aload_2
    //   579: invokevirtual 421	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   582: aload 10
    //   584: getfield 422	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_b_of_type_Boolean	Z
    //   587: ifeq +7 -> 594
    //   590: aload_2
    //   591: invokestatic 425	com/tencent/mobileqq/dating/DatingUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   594: aload_2
    //   595: getfield 415	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   598: sipush 1033
    //   601: if_icmpeq +13 -> 614
    //   604: aload_2
    //   605: getfield 415	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   608: sipush 1034
    //   611: if_icmpne +745 -> 1356
    //   614: aload_0
    //   615: aload_2
    //   616: aload_2
    //   617: getfield 428	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   620: aload_2
    //   621: getfield 415	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   624: aload_1
    //   625: getfield 429	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_e_of_type_Int	I
    //   628: invokestatic 434	com/tencent/mobileqq/confess/ConfessMsgUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;II)V
    //   631: iload 14
    //   633: sipush 10007
    //   636: if_icmpne +16 -> 652
    //   639: aload_0
    //   640: aload_2
    //   641: aload_2
    //   642: getfield 428	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   645: aload_2
    //   646: getfield 415	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   649: invokestatic 439	com/tencent/mobileqq/gamecenter/message/TinyMsgCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;Ljava/lang/String;I)V
    //   652: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   655: ifeq +58 -> 713
    //   658: ldc 189
    //   660: iconst_2
    //   661: new 191	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   668: ldc_w 441
    //   671: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload_2
    //   675: getfield 444	com/tencent/mobileqq/data/ChatMessage:time	J
    //   678: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   681: ldc_w 446
    //   684: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload_2
    //   688: getfield 449	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   691: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: ldc_w 451
    //   697: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload_2
    //   701: getfield 270	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   704: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   707: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   713: aload 10
    //   715: getfield 454	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:f	Z
    //   718: istore 4
    //   720: aload 10
    //   722: getfield 456	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_g_of_type_Boolean	Z
    //   725: ifeq +712 -> 1437
    //   728: iload 4
    //   730: ifeq +664 -> 1394
    //   733: aload_0
    //   734: getstatic 459	com/tencent/mobileqq/app/QQManagerFactory:LONG_TEXT_MSG_MANAGER	I
    //   737: invokevirtual 234	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   740: checkcast 461	com/tencent/mobileqq/multimsg/LongTextMsgManager
    //   743: aload_0
    //   744: aload_2
    //   745: iconst_0
    //   746: invokevirtual 464	com/tencent/mobileqq/multimsg/LongTextMsgManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   749: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +31 -> 783
    //   755: ldc 189
    //   757: iconst_2
    //   758: new 191	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 466
    //   768: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   774: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   777: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: aload_2
    //   784: getfield 407	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   787: lreturn
    //   788: aload 10
    //   790: getfield 468	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   793: ifnull +45 -> 838
    //   796: aload_0
    //   797: invokestatic 473	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   800: ifeq +38 -> 838
    //   803: new 475	com/tencent/mobileqq/data/MessageForFoldMsg
    //   806: dup
    //   807: invokespecial 476	com/tencent/mobileqq/data/MessageForFoldMsg:<init>	()V
    //   810: astore_2
    //   811: aload_2
    //   812: checkcast 475	com/tencent/mobileqq/data/MessageForFoldMsg
    //   815: iconst_0
    //   816: aload 10
    //   818: getfield 468	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   821: aload 10
    //   823: getfield 478	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   826: aload 10
    //   828: getfield 480	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_d_of_type_Long	J
    //   831: iconst_1
    //   832: invokevirtual 484	com/tencent/mobileqq/data/MessageForFoldMsg:init	(ZLjava/lang/String;Ljava/lang/String;JZ)V
    //   835: goto -648 -> 187
    //   838: aload 10
    //   840: getfield 355	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   843: ifnonnull +31 -> 874
    //   846: aload 10
    //   848: getfield 454	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:f	Z
    //   851: ifeq +23 -> 874
    //   854: aload_0
    //   855: invokestatic 485	com/tencent/mobileqq/multimsg/LongTextMsgManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   858: ifeq +16 -> 874
    //   861: sipush -1051
    //   864: invokestatic 488	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   867: checkcast 258	com/tencent/mobileqq/data/ChatMessage
    //   870: astore_2
    //   871: goto -684 -> 187
    //   874: aload 10
    //   876: getfield 355	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   879: ifnull +581 -> 1460
    //   882: sipush -1049
    //   885: istore 12
    //   887: iload 12
    //   889: invokestatic 488	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   892: checkcast 258	com/tencent/mobileqq/data/ChatMessage
    //   895: astore_2
    //   896: aload 16
    //   898: aload_0
    //   899: invokevirtual 491	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   902: iconst_0
    //   903: invokevirtual 494	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   906: astore 17
    //   908: aload 17
    //   910: ifnull +56 -> 966
    //   913: aload_2
    //   914: ldc_w 496
    //   917: aload 17
    //   919: invokestatic 501	com/etrump/mixlayout/FontManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)I
    //   922: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   925: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   928: aload_2
    //   929: ldc_w 503
    //   932: aload 17
    //   934: getfield 508	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   937: invokestatic 511	com/etrump/mixlayout/FontManager:c	(J)I
    //   940: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   943: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   946: iconst_1
    //   947: aload 17
    //   949: getfield 514	com/tencent/mobileqq/data/ExtensionInfo:magicFont	I
    //   952: if_icmpne +260 -> 1212
    //   955: aload_2
    //   956: ldc_w 516
    //   959: iconst_0
    //   960: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   963: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   966: aload 16
    //   968: aload_0
    //   969: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   972: invokevirtual 519	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   975: astore 16
    //   977: aload 16
    //   979: ifnull +190 -> 1169
    //   982: aload 16
    //   984: getstatic 525	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   987: invokevirtual 531	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   990: ifeq +78 -> 1068
    //   993: iconst_1
    //   994: istore_3
    //   995: aload 16
    //   997: getstatic 525	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   1000: invokevirtual 535	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1003: iconst_1
    //   1004: if_icmpne +5 -> 1009
    //   1007: iconst_3
    //   1008: istore_3
    //   1009: aload_2
    //   1010: ldc_w 537
    //   1013: iload_3
    //   1014: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1017: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1020: aload_2
    //   1021: ldc_w 539
    //   1024: aload 16
    //   1026: getstatic 525	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   1029: invokevirtual 542	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1032: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1035: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1038: aload_2
    //   1039: ldc_w 544
    //   1042: aload 16
    //   1044: getfield 547	com/tencent/mobileqq/data/Friends:bigClubTemplateId	I
    //   1047: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1050: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1053: aload_2
    //   1054: ldc_w 549
    //   1057: aload 16
    //   1059: getfield 552	com/tencent/mobileqq/data/Friends:bigClubExtTemplateId	I
    //   1062: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1065: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1068: aload 16
    //   1070: getstatic 555	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1073: invokevirtual 531	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1076: ifne +14 -> 1090
    //   1079: aload 16
    //   1081: getstatic 558	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1084: invokevirtual 531	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1087: ifeq +67 -> 1154
    //   1090: aload 16
    //   1092: getstatic 558	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1095: invokevirtual 531	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1098: ifeq +132 -> 1230
    //   1101: sipush 256
    //   1104: istore_3
    //   1105: aload 16
    //   1107: getstatic 558	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1110: invokevirtual 535	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1113: iconst_1
    //   1114: if_icmpne +7 -> 1121
    //   1117: sipush 258
    //   1120: istore_3
    //   1121: aload 16
    //   1123: getstatic 558	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1126: invokevirtual 542	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1129: istore 13
    //   1131: aload_2
    //   1132: ldc_w 560
    //   1135: iload_3
    //   1136: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1139: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1142: aload_2
    //   1143: ldc_w 562
    //   1146: iload 13
    //   1148: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1151: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1154: aload_2
    //   1155: ldc_w 564
    //   1158: aload 16
    //   1160: getfield 567	com/tencent/mobileqq/data/Friends:diyFontId	I
    //   1163: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1166: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1169: aload 9
    //   1171: ifnull +11 -> 1182
    //   1174: iload 14
    //   1176: aload 9
    //   1178: aload_2
    //   1179: invokestatic 572	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(ILjava/util/ArrayList;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1182: iload 12
    //   1184: sipush -1000
    //   1187: if_icmpne +22 -> 1209
    //   1190: aload 10
    //   1192: getfield 575	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:h	Z
    //   1195: ifeq +14 -> 1209
    //   1198: aload_2
    //   1199: ldc_w 577
    //   1202: iconst_1
    //   1203: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1206: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1209: goto -1022 -> 187
    //   1212: aload_2
    //   1213: ldc_w 516
    //   1216: aload 17
    //   1218: getfield 580	com/tencent/mobileqq/data/ExtensionInfo:fontEffect	I
    //   1221: invokestatic 320	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1224: invokevirtual 296	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1227: goto -261 -> 966
    //   1230: iconst_1
    //   1231: istore_3
    //   1232: aload 16
    //   1234: getstatic 555	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1237: invokevirtual 535	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1240: iconst_1
    //   1241: if_icmpne +5 -> 1246
    //   1244: iconst_3
    //   1245: istore_3
    //   1246: aload 16
    //   1248: getstatic 555	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1251: invokevirtual 542	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1254: istore 13
    //   1256: goto -125 -> 1131
    //   1259: astore 9
    //   1261: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1264: ifeq -697 -> 567
    //   1267: ldc 189
    //   1269: iconst_2
    //   1270: new 191	java/lang/StringBuilder
    //   1273: dup
    //   1274: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   1277: ldc_w 582
    //   1280: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: aload 9
    //   1285: invokevirtual 585	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1288: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1294: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1297: goto -730 -> 567
    //   1300: aload_2
    //   1301: checkcast 587	com/tencent/mobileqq/data/MessageForText
    //   1304: astore 15
    //   1306: aload 15
    //   1308: aload_1
    //   1309: getfield 211	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   1312: putfield 588	com/tencent/mobileqq/data/MessageForText:msgVia	I
    //   1315: aload 9
    //   1317: ifnull +10 -> 1327
    //   1320: aload 15
    //   1322: aload 9
    //   1324: putfield 589	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   1327: aload 15
    //   1329: aload 10
    //   1331: invokevirtual 593	com/tencent/mobileqq/data/MessageForText:setSendMsgParams	(Lcom/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams;)V
    //   1334: goto -767 -> 567
    //   1337: invokestatic 420	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   1340: getfield 595	com/tencent/biz/anonymous/AnonymousChatHelper:jdField_a_of_type_Boolean	Z
    //   1343: ifeq -761 -> 582
    //   1346: invokestatic 420	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   1349: iconst_0
    //   1350: putfield 595	com/tencent/biz/anonymous/AnonymousChatHelper:jdField_a_of_type_Boolean	Z
    //   1353: goto -771 -> 582
    //   1356: aload_1
    //   1357: getfield 598	com/tencent/mobileqq/activity/aio/SessionInfo:j	Z
    //   1360: ifeq +15 -> 1375
    //   1363: aload_0
    //   1364: aload_2
    //   1365: aload_1
    //   1366: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1369: invokestatic 601	com/tencent/mobileqq/confess/ConfessMsgUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1372: goto -741 -> 631
    //   1375: aload_1
    //   1376: getfield 604	com/tencent/mobileqq/activity/aio/SessionInfo:k	Z
    //   1379: ifeq -748 -> 631
    //   1382: aload_0
    //   1383: aload_2
    //   1384: aload_1
    //   1385: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1388: invokestatic 606	com/tencent/mobileqq/confess/ConfessMsgUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1391: goto -760 -> 631
    //   1394: iload 11
    //   1396: ifeq +29 -> 1425
    //   1399: aload_0
    //   1400: invokevirtual 132	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1403: aload_2
    //   1404: invokevirtual 608	com/tencent/imcore/message/QQMessageFacade:c	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   1407: goto -658 -> 749
    //   1410: astore_0
    //   1411: ldc_w 610
    //   1414: iconst_1
    //   1415: ldc_w 612
    //   1418: aload_0
    //   1419: invokestatic 615	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1422: goto -673 -> 749
    //   1425: aload_0
    //   1426: invokevirtual 132	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1429: aload_2
    //   1430: aconst_null
    //   1431: invokevirtual 618	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/app/MessageObserver;)V
    //   1434: goto -685 -> 749
    //   1437: new 620	com/tencent/mobileqq/activity/ChatActivityFacade$13
    //   1440: dup
    //   1441: iload 4
    //   1443: aload_0
    //   1444: aload_2
    //   1445: iload 11
    //   1447: invokespecial 623	com/tencent/mobileqq/activity/ChatActivityFacade$13:<init>	(ZLcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;Z)V
    //   1450: bipush 10
    //   1452: aconst_null
    //   1453: iconst_0
    //   1454: invokestatic 629	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1457: goto -708 -> 749
    //   1460: sipush -1000
    //   1463: istore 12
    //   1465: goto -578 -> 887
    //   1468: ldc 252
    //   1470: astore 15
    //   1472: goto -1414 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1475	0	paramQQAppInterface	QQAppInterface
    //   0	1475	1	paramSessionInfo	SessionInfo
    //   0	1475	2	paramString	String
    //   0	1475	3	paramInt1	int
    //   0	1475	4	paramBoolean1	boolean
    //   0	1475	5	paramByte1	byte
    //   0	1475	6	paramByte2	byte
    //   0	1475	7	paramShort	short
    //   0	1475	8	paramInt2	int
    //   0	1475	9	paramArrayList	ArrayList<AtTroopMemberInfo>
    //   0	1475	10	paramSendMsgParams	ChatActivityFacade.SendMsgParams
    //   0	1475	11	paramBoolean2	boolean
    //   885	579	12	i	int
    //   1129	126	13	j	int
    //   115	1060	14	k	int
    //   56	1415	15	localObject1	Object
    //   106	1141	16	localObject2	Object
    //   906	311	17	localExtensionInfo	ExtensionInfo
    // Exception table:
    //   from	to	target	type
    //   421	491	1259	java/lang/Exception
    //   491	539	1259	java/lang/Exception
    //   539	567	1259	java/lang/Exception
    //   733	749	1410	java/lang/Exception
    //   1399	1407	1410	java/lang/Exception
    //   1425	1434	1410	java/lang/Exception
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    if (paramString1 != null)
    {
      paramString1 = TransfileUtile.makeTransFileProtocolDataForForwardImage(paramString1, paramString3, paramString4, paramLong, paramInt2);
      paramString3 = MessageRecordFactory.a(-20000);
      paramString3.selfuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.frienduin = paramString2;
      paramString3.senderuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.msg = paramString1;
      paramString3.msgtype = -20000;
      paramString3.isread = true;
      paramString3.issend = 1;
      paramString3.istroop = paramInt1;
      ((SVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramString3);
      paramQQAppInterface.getMessageFacade().a(paramString3, paramQQAppInterface.getCurrentAccountUin());
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
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
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
      if (paramSendMsgParams.jdField_e_of_type_Long != 0L)
      {
        paramString = new MessageForWantGiftMsg();
        ((MessageForWantGiftMsg)paramString).wantGiftSenderUin = paramSendMsgParams.jdField_e_of_type_Long;
        ((MessageForWantGiftMsg)paramString).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, paramSendMsgParams.jdField_e_of_type_Long + "");
        paramString.msgtype = -2056;
      }
      for (;;)
      {
        MessageRecordFactory.a(paramQQAppInterface, paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
        paramString.msg = str;
        paramString.msgUid = MessageUtils.a(paramInt2);
        paramString.longMsgCount = paramByte1;
        paramString.longMsgIndex = paramByte2;
        paramString.longMsgId = paramShort;
        paramString.mAnimFlag = true;
        paramString.mNewAnimFlag = true;
        if (paramSendMsgParams.i) {
          paramString.mRobotFlag = -1;
        }
        paramString.saveExtInfoToExtStr("robot_news_class_id", String.valueOf(paramSendMsgParams.jdField_g_of_type_Int));
        if (!(paramString instanceof MessageForReplyText)) {
          break label738;
        }
        paramQQAppInterface = (MessageForReplyText)paramString;
        paramQQAppInterface.msgVia = paramSessionInfo.c;
        if (paramArrayList != null) {
          paramQQAppInterface.atInfoList = paramArrayList;
        }
        try
        {
          paramQQAppInterface.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.a(paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo)));
          if ((!android.text.TextUtils.isEmpty(paramSendMsgParams.jdField_a_of_type_JavaLangString)) && (!android.text.TextUtils.isEmpty(paramSendMsgParams.jdField_b_of_type_JavaLangString)))
          {
            paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_msg", paramSendMsgParams.jdField_a_of_type_JavaLangString);
            paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_at_list", paramSendMsgParams.jdField_b_of_type_JavaLangString);
          }
          paramQQAppInterface.mSourceMsgInfo = paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
          paramQQAppInterface.extLong |= 0x1;
        }
        catch (Exception paramQQAppInterface)
        {
          for (;;)
          {
            label363:
            if (QLog.isColorLevel()) {
              QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramQQAppInterface.getMessage());
            }
          }
        }
        if (paramString.istroop != 1) {
          break label771;
        }
        AnonymousChatHelper.a().a(paramString);
        label378:
        if (paramSendMsgParams.jdField_b_of_type_Boolean) {
          DatingUtil.a(paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 2 time = " + paramString.time + " senderUin = " + paramString.senderuin + " msgUid = " + paramString.msgUid);
        }
        return paramString;
        if ((paramSendMsgParams.jdField_c_of_type_JavaLangString != null) && (PasswdRedBagManager.a(paramQQAppInterface)))
        {
          paramString = new MessageForFoldMsg();
          ((MessageForFoldMsg)paramString).init(false, paramSendMsgParams.jdField_c_of_type_JavaLangString, paramSendMsgParams.jdField_d_of_type_JavaLangString, paramSendMsgParams.jdField_d_of_type_Long, true);
        }
        else
        {
          if ((paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) || (!paramSendMsgParams.f) || (!LongTextMsgManager.a(paramQQAppInterface))) {
            break;
          }
          paramString = (ChatMessage)MessageRecordFactory.a(-1051);
        }
      }
      if (paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) {}
      for (paramInt1 = -1049;; paramInt1 = -1000)
      {
        paramString = (ChatMessage)MessageRecordFactory.a(paramInt1);
        ExtensionInfo localExtensionInfo = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramQQAppInterface.getCurrentUin(), false);
        if (localExtensionInfo != null)
        {
          paramString.saveExtInfoToExtStr("vip_font_id", String.valueOf(FontManager.a(localExtensionInfo)));
          paramString.saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(FontManager.c(localExtensionInfo.uVipFont)));
          if (1 != localExtensionInfo.magicFont) {
            break label681;
          }
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
        }
        for (;;)
        {
          if (paramArrayList != null) {
            AtTroopMemberSpan.a(paramSessionInfo.jdField_a_of_type_Int, paramArrayList, paramString);
          }
          if ((paramInt1 == -1000) && (paramSendMsgParams.h)) {
            paramString.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(1));
          }
          break;
          label681:
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(localExtensionInfo.fontEffect));
        }
        label738:
        paramQQAppInterface = (MessageForText)paramString;
        paramQQAppInterface.msgVia = paramSessionInfo.c;
        if (paramArrayList != null) {
          paramQQAppInterface.atInfoList = paramArrayList;
        }
        paramQQAppInterface.setSendMsgParams(paramSendMsgParams);
        break label363;
        label771:
        if (!AnonymousChatHelper.a().jdField_a_of_type_Boolean) {
          break label378;
        }
        AnonymousChatHelper.a().jdField_a_of_type_Boolean = false;
        break label378;
      }
    }
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessage start, currenttime:" + System.currentTimeMillis());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    paramString = new ArrayList();
    boolean bool = false;
    short s = 0;
    Random localRandom = new Random();
    for (;;)
    {
      try
      {
        Object localObject;
        if (a(paramSendMsgParams, false))
        {
          localObject = b(str, paramArrayList, paramSendMsgParams, paramString);
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject;
          if (!QLog.isColorLevel()) {
            break label553;
          }
          QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + paramString.size() + " mSourceMsgInfo:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject;
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessage step 2, currenttime:" + System.currentTimeMillis());
          }
          int i = Math.abs(localRandom.nextInt());
          localObject = (String)paramArrayList.get(0);
          if (paramString.size() > 0)
          {
            paramString = (ArrayList)paramString.get(0);
            if ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
              i = Math.abs(localRandom.nextInt());
            }
            return a(paramQQAppInterface, paramSessionInfo, (String)localObject, -1000, bool, (byte)paramArrayList.size(), (byte)0, s, i, paramString, paramSendMsgParams);
          }
        }
        else
        {
          if (a(paramQQAppInterface, paramSessionInfo, str, paramSendMsgParams))
          {
            localObject = a(str, paramArrayList, paramSendMsgParams, paramString);
            paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject;
            if (!QLog.isColorLevel()) {
              break label553;
            }
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + paramString.size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject;
            continue;
          }
          localObject = BusinessUtils.a(str, 560, 20, paramArrayList, paramString);
          if (((ArrayList)localObject).size() <= 1) {
            break label556;
          }
          bool = true;
          AIOConfigData localAIOConfigData = AIOConfigManager.a;
          if (((localAIOConfigData == null) || (localAIOConfigData.jdField_g_of_type_Int == 0)) && (bool))
          {
            paramString = new ArrayList();
            paramArrayList = a(str, paramArrayList, paramSendMsgParams, paramString);
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + paramString.size() + " partArray.size() = " + ((ArrayList)localObject).size() + " isDivide = " + bool + " currenttime:" + System.currentTimeMillis());
          }
          s = a(paramQQAppInterface, paramSessionInfo, bool, (short)0, localRandom);
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject;
          continue;
        }
        paramString = null;
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
      continue;
      label553:
      continue;
      label556:
      bool = false;
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
          break label187;
        }
        paramInt1 = 1;
        ((MessageForPtt)localObject1).sttAbility = paramInt1;
        ((MessageForPtt)localObject1).voiceType = paramInt2;
        ((MessageForPtt)localObject1).longPttVipFlag = VipUtils.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        AnonymousChatHelper.a().a((MessageRecord)localObject1);
        if ((paramSessionInfo.jdField_a_of_type_Int != 1033) && ((paramSessionInfo.jdField_a_of_type_Int != 1034) || (paramSessionInfo.jdField_e_of_type_Int <= 0))) {
          break label192;
        }
        ConfessMsgUtil.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_e_of_type_Int);
      }
    }
    for (;;)
    {
      ((MessageForPtt)localObject1).serial();
      ((SVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a((MessageRecord)localObject1);
      return localObject1;
      label187:
      paramInt1 = 0;
      break;
      label192:
      if (paramSessionInfo.j) {
        ConfessMsgUtil.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString);
      } else if (paramSessionInfo.k) {
        ConfessMsgUtil.b(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (UinTypeUtil.b(paramSessionInfo.jdField_a_of_type_Int))
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        int i = paramQQAppInterface.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
          if (!MessageRecordInfo.b(paramSessionInfo.issend)) {
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
        ((SVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a((MessageRecord)localObject1);
        paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
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
      paramQQAppInterface.getMessageFacade().a(paramString, paramQQAppInterface.getCurrentAccountUin());
    }
    while (!QLog.isColorLevel()) {
      return paramString;
    }
    QLog.d("ChatActivityFacade", 2, "createPttMessage null");
    return paramString;
  }
  
  public static AbsShareMsg a(Context paramContext, String paramString, List<ChatMessage> paramList, Map<String, String> paramMap, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramMap == null)) {
      return null;
    }
    Object localObject2 = "";
    ArrayList localArrayList = new ArrayList();
    int j;
    int k;
    int i;
    label51:
    Object localObject3;
    Object localObject4;
    Object localObject1;
    if (paramList.size() >= 4)
    {
      j = 4;
      k = 0;
      i = 4;
      if ((k >= j) || (i <= 0)) {
        break label780;
      }
      localObject3 = new StringBuilder();
      localObject4 = (ChatMessage)paramList.get(k);
      localObject1 = "";
      if (!paramBoolean) {
        break label314;
      }
      localObject1 = (String)paramMap.get(MsgProxyUtils.a((MessageRecord)localObject4));
      paramString = (String)localObject1;
      if (((ChatMessage)localObject4).istroop == 1) {
        paramString = com.tencent.mobileqq.text.TextUtils.removeColorNickCode((String)localObject1);
      }
      label128:
      if ((android.text.TextUtils.isEmpty(paramString)) || (paramString.trim().length() == 0)) {
        break label371;
      }
      if (paramString.length() <= 12) {
        break label365;
      }
      localObject1 = paramString.substring(0, 11) + "...";
      label182:
      if (!(localObject4 instanceof MessageForPic)) {
        break label384;
      }
      paramString = ((ChatMessage)localObject4).getSummaryMsg();
    }
    for (;;)
    {
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(":  ");
      ((StringBuilder)localObject3).append(paramString);
      localObject1 = new boolean[1];
      localArrayList.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 3, 46, ((StringBuilder)localObject3).toString(), (boolean[])localObject1).toString()));
      int m = i - 1;
      i = m;
      if (localObject1[0] != 0) {
        i = m - 1;
      }
      k += 1;
      localObject2 = paramString;
      break label51;
      j = paramList.size();
      break;
      label314:
      Object localObject5 = new ArrayList(paramMap.values());
      paramString = (String)localObject1;
      if (localObject5 == null) {
        break label128;
      }
      paramString = (String)localObject1;
      if (((List)localObject5).isEmpty()) {
        break label128;
      }
      paramString = (String)((List)localObject5).get(0);
      break label128;
      label365:
      localObject1 = paramString;
      break label182;
      label371:
      localObject1 = MultiMsgUtil.a(((ChatMessage)localObject4).senderuin);
      break label182;
      label384:
      if ((localObject4 instanceof MessageForShortVideo))
      {
        if (((ChatMessage)localObject4).msgtype == -2071) {
          paramString = HardCodeUtil.a(2131701630);
        } else {
          paramString = HardCodeUtil.a(2131701639);
        }
      }
      else
      {
        if ((localObject4 instanceof MessageForText))
        {
          paramString = (MessageForText)localObject4;
          if (paramString.sb != null) {}
          for (paramString = paramString.sb.toString();; paramString = paramString.msg)
          {
            localObject2 = paramString;
            if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramString)) {
              localObject2 = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(paramString);
            }
            paramString = (String)localObject2;
            break;
          }
        }
        if ((localObject4 instanceof MessageForQQStoryComment))
        {
          paramString = ((MessageForQQStoryComment)localObject4).comment;
        }
        else if (((localObject4 instanceof MessageForMixedMsg)) || ((localObject4 instanceof MessageForLongMsg)))
        {
          paramString = MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject4).toString();
        }
        else if ((localObject4 instanceof MessageForStructing))
        {
          paramString = ((ChatMessage)localObject4).getSummaryMsg();
        }
        else if ((localObject4 instanceof MessageForArkApp))
        {
          paramString = ((MessageForArkApp)localObject4).getSummery();
        }
        else if ((localObject4 instanceof MessageForArkBabyqReply))
        {
          paramString = ((MessageForArkBabyqReply)localObject4).getSummery();
        }
        else if ((localObject4 instanceof MessageForArkFlashChat))
        {
          paramString = ((MessageForArkFlashChat)localObject4).getSummery();
        }
        else if ((localObject4 instanceof MessageForReplyText))
        {
          paramString = (MessageForReplyText)localObject4;
          paramString.parse();
          paramString = paramString.getSummaryMsg();
        }
        else
        {
          if ((localObject4 instanceof MessageForFile))
          {
            paramString = (MessageForFile)localObject4;
            if (!paramString.hasFileName())
            {
              localObject2 = FileManagerUtil.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString);
              if ((((FileManagerEntity)localObject2).nFileType != 5) || (android.text.TextUtils.isEmpty(((FileManagerEntity)localObject2).strApkPackageName))) {
                break label710;
              }
            }
            label710:
            for (paramString.fileName = ((FileManagerEntity)localObject2).strApkPackageName;; paramString.fileName = ((FileManagerEntity)localObject2).fileName)
            {
              paramString = paramString.getSummaryMsg();
              break;
            }
          }
          if ((localObject4 instanceof MessageForDLFile))
          {
            paramString = ((MessageForDLFile)localObject4).getSummaryMsg();
          }
          else if ((localObject4 instanceof MessageForTroopFile))
          {
            paramString = ((MessageForTroopFile)localObject4).getSummaryMsg();
          }
          else if ((localObject4 instanceof MessageForPtt))
          {
            paramString = HardCodeUtil.a(2131701647);
            continue;
            label780:
            paramString = paramContext.getString(2131690865);
            localObject4 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(35).a(HardCodeUtil.a(2131701646)).a(3).a("viewMultiMsg", "", null, null, null).a(paramString, null).a();
            localObject5 = new StructMsgItemLayout1();
            ChatMessage localChatMessage1 = (ChatMessage)paramList.get(0);
            if ((localChatMessage1.istroop == 1) || (localChatMessage1.istroop == 3000)) {
              paramContext = HardCodeUtil.a(2131701627);
            }
            for (;;)
            {
              paramString = paramContext;
              if (android.text.TextUtils.isEmpty(paramContext))
              {
                QLog.w("ChatActivityFacade", 1, "generateMultiMsgForwardStructMsg: titleStr is null");
                paramString = HardCodeUtil.a(2131701643);
              }
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG.Nest", 2, String.format("step.generateStructMsgContent:titleStr = %s,listSize = %d,firstMsg.istroop = %d", new Object[] { paramString, Integer.valueOf(paramList.size()), Integer.valueOf(localChatMessage1.istroop) }));
              }
              paramContext = new StructMsgItemTitle(paramString);
              paramContext.f("34");
              paramContext.g("12");
              paramContext.h("2");
              ((AbsStructMsgItem)localObject5).a(paramContext);
              paramContext = localArrayList.iterator();
              label1110:
              label1144:
              ChatMessage localChatMessage2;
              for (;;)
              {
                if (paramContext.hasNext())
                {
                  paramString = (AbsStructMsgElement)paramContext.next();
                  if ((paramString instanceof AbsStructMsgTextElement))
                  {
                    paramMap = (AbsStructMsgTextElement)paramString;
                    paramMap.f("26");
                    paramMap.e("#777777");
                    paramMap.g("12");
                    paramMap.h("4");
                  }
                  ((AbsStructMsgItem)localObject5).a(paramString);
                  continue;
                  if (localChatMessage1.istroop != 0) {
                    break label1524;
                  }
                  paramString = localChatMessage1.senderuin;
                  if (android.text.TextUtils.equals(localChatMessage1.senderuin, localChatMessage1.selfuin))
                  {
                    localObject1 = localChatMessage1.frienduin;
                    localObject3 = (String)paramMap.get(paramString);
                    localObject2 = (String)paramMap.get(localObject1);
                    boolean bool = true;
                    paramString = "";
                    i = 0;
                    paramBoolean = bool;
                    if (i >= paramList.size()) {
                      break label1219;
                    }
                    localChatMessage2 = (ChatMessage)paramList.get(i);
                    if (!android.text.TextUtils.isEmpty(paramString)) {
                      break label1204;
                    }
                    paramString = localChatMessage2.senderuin;
                  }
                }
              }
              for (;;)
              {
                i += 1;
                break label1144;
                localObject1 = localChatMessage1.selfuin;
                break label1110;
                label1204:
                if (!android.text.TextUtils.equals(paramString, localChatMessage2.senderuin))
                {
                  paramBoolean = false;
                  label1219:
                  if (localObject3 != null)
                  {
                    paramString = (String)localObject3;
                    if (((String)localObject3).trim().length() != 0) {}
                  }
                  else
                  {
                    QLog.d("MultiMsg_TAG", 2, "firstNick is null !!!");
                    paramString = MultiMsgUtil.a(localChatMessage1.senderuin);
                  }
                  if (((localObject2 == null) || (((String)localObject2).trim().length() == 0)) && (!paramBoolean)) {
                    QLog.d("MultiMsg_TAG", 2, "!hasOnlyOneSender !!! empty nick for receiver");
                  }
                  for (localObject1 = MultiMsgUtil.a((String)localObject1);; localObject1 = localObject2)
                  {
                    if (QFileAssistantUtils.a(localChatMessage1.senderuin))
                    {
                      paramBoolean = true;
                      paramString = (String)paramMap.get(localChatMessage1.selfuin);
                    }
                    for (;;)
                    {
                      paramMap = new Paint();
                      paramMap.setTextSize(34.0F);
                      paramContext = a(paramContext, paramString, (String)localObject1, 2, (int)(BaseChatItemLayout.f * 0.7F), 2048, paramMap, paramBoolean);
                      break;
                      ((AbsStructMsgItem)localObject5).a(new StructMsgItemHr());
                      paramContext = new StructMsgItemSummary(String.format(HardCodeUtil.a(2131701624), new Object[] { Integer.valueOf(paramList.size()) }));
                      paramContext.f("26");
                      paramContext.e("#777777");
                      ((AbsStructMsgItem)localObject5).a(paramContext);
                      ((AbsShareMsg)localObject4).addItem((AbsStructMsgElement)localObject5);
                      ((AbsShareMsg)localObject4).mTSum = paramList.size();
                      if (QLog.isColorLevel())
                      {
                        paramContext = StructMsgUtils.b(((AbsShareMsg)localObject4).getXmlBytes());
                        paramString = new StringBuilder().append("generateStructMsgLength = ");
                        if (paramContext != null) {
                          break label1504;
                        }
                      }
                      label1504:
                      for (i = 0;; i = paramContext.length)
                      {
                        QLog.d("MultiMsg_TAG", 2, i);
                        return localObject4;
                      }
                    }
                  }
                }
              }
              label1524:
              paramContext = "";
            }
          }
          else
          {
            paramString = (String)localObject2;
          }
        }
      }
    }
  }
  
  public static StructMsgForGeneralShare a(Context paramContext, MessageRecord paramMessageRecord, String paramString)
  {
    int i = 50;
    if (paramMessageRecord == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord instanceof MessageForMixedMsg))
    {
      paramString = new StringBuilder();
      paramString.append(MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)paramMessageRecord));
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, 30, paramString.toString()).toString();
      localArrayList.add(new StructMsgItemTitle(paramMessageRecord));
      paramString = paramMessageRecord;
      if (paramMessageRecord.length() > 30) {
        paramString = paramMessageRecord.substring(0, 30);
      }
      paramMessageRecord = paramContext.getString(2131690865);
      paramContext = (StructMsgForGeneralShare)new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(35).a(paramString).a(3).a("viewMultiMsg", "", null, null, null).a(paramMessageRecord, null).d(paramContext.getResources().getString(2131694385)).a();
      paramMessageRecord = new StructMsgItemLayout1(localArrayList);
      paramMessageRecord.a(new StructMsgItemHr());
      paramMessageRecord.a(new StructMsgItemSummary(HardCodeUtil.a(2131701626)));
      paramContext.addItem(paramMessageRecord);
      return paramContext;
    }
    label247:
    String str;
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      paramString = (MessageForReplyText)paramMessageRecord;
      if (paramString.sb != null)
      {
        paramString = paramString.sb.toString();
        str = paramString;
        if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramString)) {
          str = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(paramString);
        }
        if (!AnonymousChatHelper.a(paramMessageRecord)) {
          break label389;
        }
      }
    }
    for (;;)
    {
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, i, str).toString();
      break;
      paramString = paramString.msg;
      break label247;
      paramString = (MessageForLongTextMsg)paramMessageRecord;
      if (paramString.sb != null)
      {
        paramString = paramString.sb.toString();
        label326:
        str = paramString;
        if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramString)) {
          str = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(paramString);
        }
        if (!AnonymousChatHelper.a(paramMessageRecord)) {
          break label383;
        }
      }
      for (;;)
      {
        paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, i, str).toString();
        break;
        paramString = paramString.msg;
        break label326;
        label383:
        i = 60;
      }
      label389:
      i = 60;
    }
  }
  
  private static CharSequence a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramContext, paramInt1, paramInt2, paramInt3, paramCharSequence, null);
  }
  
  private static CharSequence a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence, boolean[] paramArrayOfBoolean)
  {
    paramContext = paramContext.getResources();
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = paramContext.getDisplayMetrics().density;
    int k = paramCharSequence.length();
    int i = 0;
    int j = i;
    if (i < k)
    {
      float f = Layout.getDesiredWidth(paramCharSequence, 0, i + 1, localTextPaint);
      if ((f > paramInt1) && (paramArrayOfBoolean != null) && (paramArrayOfBoolean.length > 0)) {
        paramArrayOfBoolean[0] = true;
      }
      if (f > paramInt1 * paramInt2) {
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
        break label171;
      }
    }
    for (;;)
    {
      paramContext = paramCharSequence.subSequence(0, paramInt3).toString() + "…";
      return paramContext;
      i += 1;
      break;
      label171:
      paramInt3 = j;
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "adjustTitleByNick() called with: firstNick = [" + paramString1 + "], secondNick = [" + paramString2 + "]");
    }
    String str = "";
    if (android.text.TextUtils.isEmpty(paramString1))
    {
      paramContext = str;
      return paramContext;
    }
    str = paramString2;
    if (android.text.TextUtils.isEmpty(paramString2)) {
      str = "";
    }
    paramString2 = paramString1 + HardCodeUtil.a(2131701632) + str + HardCodeUtil.a(2131701625);
    if (paramBoolean) {
      paramString2 = paramString1 + HardCodeUtil.a(2131701649);
    }
    TextView localTextView = new TextView(paramContext);
    localTextView.getPaint().set(paramPaint);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, -2));
    localTextView.setText(paramString2);
    int i = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
    int j = View.MeasureSpec.makeMeasureSpec(paramInt3, -2147483648);
    localTextView.measure(i, j);
    if (localTextView.getLineCount() > paramInt1)
    {
      paramContext = null;
      paramInt2 = 0;
      label231:
      if (paramInt2 <= paramString1.length())
      {
        paramInt3 = paramInt2;
        label244:
        paramString2 = paramString1.substring(0, paramInt3);
        if (paramInt2 > str.length()) {
          break label403;
        }
      }
      label403:
      for (paramInt3 = paramInt2;; paramInt3 = str.length())
      {
        paramPaint = str.substring(0, paramInt3);
        if (!paramBoolean) {
          break label413;
        }
        paramString2 = paramString2 + HardCodeUtil.a(2131701652);
        localTextView.setText(paramString2);
        localTextView.measure(i, j);
        paramInt3 = localTextView.getLineCount();
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityFacade", 2, "adjustTitleByNick() called title=[" + paramString2 + "],lineCount=[" + paramInt3 + "]");
        }
        if (paramInt3 > paramInt1) {
          break;
        }
        paramInt2 += 1;
        paramContext = paramString2;
        break label231;
        paramInt3 = paramString1.length();
        break label244;
      }
      label413:
      if (paramInt2 < paramString1.length()) {
        paramString2 = paramString2 + "...";
      }
      for (;;)
      {
        paramString2 = paramString2 + HardCodeUtil.a(2131701640);
        paramPaint = paramString2 + paramPaint;
        paramString2 = paramPaint;
        if (paramInt2 < str.length()) {
          paramString2 = paramPaint + "...";
        }
        paramString2 = paramString2 + HardCodeUtil.a(2131701648);
        break;
      }
    }
    return paramString2;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
    return paramString + "_" + paramQQAppInterface + "_" + paramSessionInfo;
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
  
  public static String a(String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
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
          localObject = (AtTroopMemberInfo)paramArrayList.next();
          ((AtTroopMemberInfo)localObject).startPos = ((short)(((AtTroopMemberInfo)localObject).startPos - j));
        } while (((AtTroopMemberInfo)localObject).startPos >= 0);
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
  
  public static String a(List<ChatMessage> paramList, Map<String, String> paramMap)
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
        break label583;
      }
      localStringBuilder2 = new StringBuilder();
      localObject2 = (ChatMessage)paramList.get(j);
      localObject1 = (String)paramMap.get(MsgProxyUtils.a((MessageRecord)localObject2));
      if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        break label589;
      }
    }
    for (;;)
    {
      if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = HardCodeUtil.a(2131701650);
        localStringBuilder2.append((String)localObject1);
        localStringBuilder2.append(": ");
        localStringBuilder2.append((String)localObject2);
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append("\r\n");
      }
      label234:
      label372:
      do
      {
        for (;;)
        {
          j += 1;
          break label42;
          i = paramList.size();
          break;
          if (!(localObject2 instanceof MessageForShortVideo)) {
            break label234;
          }
          localObject2 = HardCodeUtil.a(2131701638);
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append((String)localObject2);
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
            if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion((String)localObject2)) {
              localObject1 = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol((String)localObject2);
            }
            if (((String)localObject1).length() <= 16) {
              break label372;
            }
            localStringBuilder1.append(((String)localObject1).substring(0, 16)).append("...");
          }
          for (;;)
          {
            localStringBuilder1.append("\r\n");
            break;
            localObject2 = ((MessageForText)localObject2).msg;
            break label269;
            localStringBuilder1.append((String)localObject1);
          }
        }
        if (((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForLongMsg)))
        {
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append(MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject2));
          localObject1 = com.tencent.mobileqq.text.TextUtils.emoticonToText(localStringBuilder2.toString());
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
      label269:
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
      label583:
      return localStringBuilder1.toString();
      label589:
      localObject1 = " ";
    }
  }
  
  @NonNull
  private static ArrayList<String> a(String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams, ArrayList<ArrayList<AtTroopMemberInfo>> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramArrayList1.add(paramArrayList);
    paramSendMsgParams.f = true;
    return localArrayList;
  }
  
  public static JSONObject a(NewestFeedInfo paramNewestFeedInfo, boolean paramBoolean, int paramInt)
  {
    if (paramNewestFeedInfo == null) {
      return null;
    }
    Object localObject = HardCodeUtil.a(2131701645);
    paramNewestFeedInfo.strTitle = paramNewestFeedInfo.strTitle.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", (String)localObject);
    paramNewestFeedInfo.strSummary = paramNewestFeedInfo.strSummary.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", (String)localObject);
    paramNewestFeedInfo.strContent = paramNewestFeedInfo.strContent.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", (String)localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appid", paramNewestFeedInfo.uAppid);
      ((JSONObject)localObject).put("title", paramNewestFeedInfo.strTitle);
      ((JSONObject)localObject).put("actionUrl", paramNewestFeedInfo.strJmpUrl);
      ((JSONObject)localObject).put("content", paramNewestFeedInfo.strContent);
      ((JSONObject)localObject).put("coverImageUrl", paramNewestFeedInfo.strImgUrl);
      ((JSONObject)localObject).put("fromuin", paramNewestFeedInfo.uHostUin);
      ((JSONObject)localObject).put("imageCount", paramNewestFeedInfo.uImgCount);
      ((JSONObject)localObject).put("lbsinfo", paramNewestFeedInfo.strLBSInfo);
      ((JSONObject)localObject).put("summery", paramNewestFeedInfo.strSummary);
      ((JSONObject)localObject).put("time", paramNewestFeedInfo.uTime);
      ((JSONObject)localObject).put("version", 2);
      ((JSONObject)localObject).put("likeNums", paramNewestFeedInfo.uLikeNum);
      ((JSONObject)localObject).put("commentNums", paramNewestFeedInfo.uCommentNum);
      ((JSONObject)localObject).put("isFirstMsgWithNewFriend", paramBoolean);
      ((JSONObject)localObject).put("iGender", paramInt);
      if ((paramNewestFeedInfo.mapEx != null) && (!paramNewestFeedInfo.mapEx.isEmpty())) {
        ((JSONObject)localObject).put("mapExt", new JSONObject(paramNewestFeedInfo.mapEx).toString());
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
        ((JSONObject)localObject).put("mediaDatas", localJSONArray.toString());
      }
      return localObject;
    }
    catch (JSONException paramNewestFeedInfo) {}
    return null;
  }
  
  public static JSONObject a(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean, FeedCloudMeta.StShare paramStShare)
  {
    if (paramStFeed == null) {
      return null;
    }
    Object localObject1 = HardCodeUtil.a(2131701645);
    paramStFeed.title.set(paramStFeed.title.get().replaceAll("\\[em\\]e\\d+\\[/em\\]", (String)localObject1));
    paramStFeed.content.set(paramStFeed.content.get().replaceAll("\\[em\\]e\\d+\\[/em\\]", (String)localObject1));
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("feedid", paramStFeed.id.get());
      ((JSONObject)localObject1).put("fromuin", paramStFeed.poster.id.get());
      ((JSONObject)localObject1).put("title", paramStFeed.title.get());
      ((JSONObject)localObject1).put("content", paramStFeed.content.get());
      ((JSONObject)localObject1).put("coverImageUrl", paramStFeed.cover.picUrl.get());
      ((JSONObject)localObject1).put("imageCount", paramStFeed.images.size());
      ((JSONObject)localObject1).put("likeCount", paramStFeed.likeInfo.count.get());
      ((JSONObject)localObject1).put("videoCount", paramStFeed.video.vecVideoUrl.get().size());
      ((JSONObject)localObject1).put("lbsinfo", paramStFeed.poiInfo.get());
      ((JSONObject)localObject1).put("time", paramStFeed.createTime.get());
      ((JSONObject)localObject1).put("type", paramStFeed.type.get());
      if (paramStShare != null) {
        ((JSONObject)localObject1).put("contentJumpUrl", paramStShare.url.get());
      }
      ((JSONObject)localObject1).put("version", 2);
      ((JSONObject)localObject1).put("isFirstMsgWithNewFriend", paramBoolean);
      paramStShare = new JSONArray();
      if (paramStFeed.type.get() == 2)
      {
        localObject2 = paramStFeed.images.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)((Iterator)localObject2).next();
          MessageForQCircleFeed.MediaData localMediaData = new MessageForQCircleFeed.MediaData();
          localMediaData.mediaUrl = localStImage.picUrl.get();
          localMediaData.type = 2;
          paramStShare.put(localMediaData.toJson());
        }
      }
      Object localObject2 = new MessageForQCircleFeed.MediaData();
      ((MessageForQCircleFeed.MediaData)localObject2).mediaUrl = paramStFeed.video.playUrl.get();
      ((MessageForQCircleFeed.MediaData)localObject2).type = 3;
      paramStShare.put(((MessageForQCircleFeed.MediaData)localObject2).toJson());
      ((JSONObject)localObject1).put("mediaDatas", paramStShare.toString());
      paramStShare = new QQCircleFeedBase.StFeedBusiReqData();
      try
      {
        paramStShare.mergeFrom(paramStFeed.busiData.get().toByteArray());
        ((JSONObject)localObject1).put("pushCount", paramStShare.pushList.totalClickCount.get());
        return localObject1;
      }
      catch (InvalidProtocolBufferMicroException paramStFeed)
      {
        for (;;)
        {
          paramStFeed.printStackTrace();
        }
      }
      return null;
    }
    catch (JSONException paramStFeed) {}
  }
  
  private static short a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, short paramShort, Random paramRandom)
  {
    if (paramBoolean)
    {
      int i = MobileQQService.seq;
      MobileQQService.seq = i + 1;
      paramShort = (short)(byte)i;
      i = 0;
      for (;;)
      {
        short s = paramShort;
        if (paramQQAppInterface.getMsgCache().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int, paramShort))
        {
          if (i > 10) {
            s = (short)(byte)paramQQAppInterface.getMsgCache().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int);
          }
        }
        else
        {
          paramQQAppInterface.getMsgCache().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int, s);
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
  
  private static void a(int paramInt, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramInt);
    k(paramQQAppInterface, paramSessionInfo);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Bundle paramBundle)
  {
    paramString4 = SubString.a(paramString4, 45, "UTF-8", "...");
    paramString5 = SubString.a(paramString5, 90, "UTF-8", "...");
    if (!paramContext.getResources().getString(2131696077).equals(paramString4))
    {
      paramString3 = paramContext.getResources().getString(2131691364) + " " + paramString4;
      paramString6 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString1 + "&lon=" + paramString2 + "&title=" + paramString4 + "&loc=" + paramString5 + "&dpid=" + paramString6;
      paramString3 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(32).a(paramString3).d("").a("plugin", "", paramString6, "", "").a();
      paramString6 = StructMsgElementFactory.a(2);
      paramString6.a("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
      paramString3.addItem(paramString6);
      if ((paramSessionInfo == null) || (paramSessionInfo.jdField_a_of_type_Int != 1008) || (!(paramContext instanceof FragmentActivity))) {
        break label521;
      }
      paramContext = ((FragmentActivity)paramContext).getChatFragment();
      if (paramContext == null) {
        break label521;
      }
      paramContext = paramContext.a();
      if ((paramContext == null) || (paramContext.a == null) || (!(paramContext instanceof PublicAccountChatPie))) {
        break label521;
      }
    }
    label521:
    for (boolean bool = ((PublicAccountChatPie)paramContext).am;; bool = false)
    {
      if ((paramSessionInfo != null) && ((paramSessionInfo.jdField_a_of_type_Int == 1025) || (paramSessionInfo.jdField_a_of_type_Int == 1024) || ((paramSessionInfo.jdField_a_of_type_Int == 0) && (BmqqSegmentUtil.b(paramSessionInfo.jdField_a_of_type_JavaLangString))) || (bool)))
      {
        paramContext = MessageRecordFactory.a(-1000);
        l = MessageCache.a();
        i = paramSessionInfo.jdField_a_of_type_Int;
        paramString1 = ChatActivityConstants.jdField_a_of_type_JavaLangString + "http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString5 + ")";
        paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramString1, l, -1000, i, l);
        paramContext.issend = 1;
        paramQQAppInterface.getMessageFacade().a(paramContext, null);
      }
      while (paramSessionInfo == null)
      {
        long l;
        int i;
        return;
        paramString3 = paramContext.getResources().getString(2131691364);
        break;
      }
      if (paramBundle != null) {
        paramString3.forwardID = paramBundle.getInt("KEY_MSG_FORWARD_ID");
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
    b(paramQQAppInterface, paramChatMessage);
    if ((((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) && (((FragmentActivity)paramContext).getChatFragment() != null) && (((FragmentActivity)paramContext).getChatFragment().a() != null))
    {
      ((FragmentActivity)paramContext).getChatFragment().a().a(paramChatMessage);
      if ((paramChatMessage instanceof MessageForArkApp)) {
        ArkTipsManager.a().a(paramChatMessage.uniseq);
      }
      if (((StructLongMessageDownloadProcessor.isPALongMsg(paramChatMessage)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(paramChatMessage))) && ((paramChatMessage instanceof MessageForStructing))) {
        StructLongMessageDownloadProcessor.deleteTask(paramQQAppInterface, ((MessageForStructing)paramChatMessage).uniseq);
      }
      if ((paramChatMessage instanceof MessageForApollo))
      {
        MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
        if (localMessageForApollo != null)
        {
          ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopTaskByMsg(localMessageForApollo.uniseq, paramQQAppInterface, "del_msg");
          if ((localMessageForApollo.mApolloMessage != null) && ((paramContext instanceof FragmentActivity)))
          {
            paramContext = ((FragmentActivity)paramContext).getChatFragment().a();
            if ((paramContext != null) && (paramContext.a != null)) {
              VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "del_success", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramContext.a.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
            }
          }
        }
      }
      if ((paramChatMessage instanceof MessageForFile))
      {
        paramContext = FileManagerUtil.a(paramQQAppInterface, (MessageForFile)paramChatMessage);
        paramQQAppInterface.getFileManagerEngine().b(paramContext.nSessionId);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
      }
      paramContext = paramChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
      if (QLog.isDebugVersion()) {
        QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramContext + "],targetId[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      }
      if (android.text.TextUtils.isEmpty(paramContext)) {}
    }
    try
    {
      long l = Long.parseLong(paramContext);
      paramQQAppInterface.getMessageFacade().b(paramChatMessage.frienduin, paramChatMessage.istroop, l, true);
      ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramChatMessage);
      return;
      ThreadManager.post(new ChatActivityFacade.16(paramQQAppInterface, paramChatMessage), 8, null, true);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        QLog.e("ChatActivityFacade", 1, paramContext.toString());
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    paramQQAppInterface = new ChatActivityFacade.18(paramContext, paramList, paramQQAppInterface);
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
  
  public static void a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    boolean bool = paramSessionInfo.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getCurrentAccountUin());
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A2CE", "0X800A2CE", 0, 0, ChatActivityUtils.b(paramSessionInfo.jdField_a_of_type_Int), "", "", "");
    Object localObject;
    int i;
    label171:
    Intent localIntent;
    if (bool)
    {
      localObject = new ProfileActivity.AllInOne(paramQQAppInterface.getCurrentAccountUin(), 0);
      i = 0;
      if (i == 0)
      {
        if (android.text.TextUtils.isEmpty(((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString)) {
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = paramSessionInfo.jdField_d_of_type_JavaLangString;
        }
        ((ProfileActivity.AllInOne)localObject).a = NewReportPlugin.a(paramSessionInfo);
        ((ProfileActivity.AllInOne)localObject).f = paramSessionInfo.jdField_a_of_type_JavaLangString;
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
        if ((paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1020)) {
          ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = paramSessionInfo.jdField_b_of_type_JavaLangString;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_g_of_type_Int = 2;
        if (paramSessionInfo.jdField_a_of_type_Int != 0) {
          break label951;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 1;
        if ((paramSessionInfo.jdField_a_of_type_Int != 1001) && (paramSessionInfo.jdField_a_of_type_Int != 1010) && (paramSessionInfo.jdField_a_of_type_Int != 10002)) {
          break label1018;
        }
        localIntent = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
        if (paramSessionInfo.jdField_a_of_type_Int != 1001) {
          break label961;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 10;
        localIntent.putExtra("frome_where", 21);
        label242:
        ((ProfileActivity.AllInOne)localObject).a = NewReportPlugin.a(paramSessionInfo);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!Utils.a(paramQQAppInterface.getCurrentAccountUin(), str)) {
          break label1005;
        }
        localIntent.putExtra("param_mode", 2);
      }
    }
    for (;;)
    {
      paramActivity.startActivityForResult(localIntent, 9009);
      return;
      if (paramSessionInfo.jdField_a_of_type_Int == 1024)
      {
        CrmUtils.a(paramActivity, null, paramSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
        i = 1;
        localObject = null;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1001)
      {
        localObject = new ProfileActivity.AllInOne(str, 42);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 10002)
      {
        localObject = new ProfileActivity.AllInOne(str, 86);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 10004)
      {
        localObject = new ProfileActivity.AllInOne(str, 94);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 0)
      {
        localObject = new ProfileActivity.AllInOne(str, 70);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1000)
      {
        localObject = new ProfileActivity.AllInOne(str, 22);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1020)
      {
        localObject = new ProfileActivity.AllInOne(str, 58);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1001)
      {
        localObject = new ProfileActivity.AllInOne(str, 42);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 10002)
      {
        localObject = new ProfileActivity.AllInOne(str, 86);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1004)
      {
        localObject = new ProfileActivity.AllInOne(str, 47);
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_JavaLangString = paramSessionInfo.jdField_b_of_type_JavaLangString;
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1005)
      {
        localObject = new ProfileActivity.AllInOne(str, 2);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1023)
      {
        localObject = new ProfileActivity.AllInOne(str, 74);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1006)
      {
        localObject = new ProfileActivity.AllInOne(str, 34);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1009)
      {
        localObject = new ProfileActivity.AllInOne(str, 57);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1021)
      {
        localObject = new ProfileActivity.AllInOne(str, 72);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1022)
      {
        localObject = new ProfileActivity.AllInOne(str, 27);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1025)
      {
        localObject = new Intent(paramActivity, ChatSettingActivity.class);
        ((Intent)localObject).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("uinname", paramSessionInfo.jdField_d_of_type_JavaLangString);
        ((Intent)localObject).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
        paramActivity.startActivity((Intent)localObject);
        i = 1;
        localObject = null;
        break;
      }
      if ((paramSessionInfo.jdField_a_of_type_Int == 1037) || (paramSessionInfo.jdField_a_of_type_Int == 1044) || (paramSessionInfo.jdField_a_of_type_Int == 1045))
      {
        localObject = new ProfileActivity.AllInOne(str, 96);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 10008)
      {
        localObject = new ProfileActivity.AllInOne(str, 115);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 10010)
      {
        localObject = new ProfileActivity.AllInOne(str, 117);
        i = 0;
        break;
      }
      localObject = new ProfileActivity.AllInOne(str, 19);
      i = 0;
      break;
      label951:
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 106;
      break label171;
      label961:
      if (paramSessionInfo.jdField_a_of_type_Int == 1010)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 11;
        break label242;
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 10002) {
        break label242;
      }
      localIntent.putExtra("frome_where", 22);
      break label242;
      label1005:
      localIntent.putExtra("param_mode", 3);
    }
    label1018:
    if (LimitChatUtil.a(paramSessionInfo))
    {
      i = 0;
      if (paramSessionInfo.c == 20) {
        i = 1;
      }
      ProfileActivity.a(paramActivity, (ProfileActivity.AllInOne)localObject, i, 3);
      return;
    }
    ProfileActivity.b(paramActivity, (ProfileActivity.AllInOne)localObject);
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
    label396:
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
          break label396;
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
          if ((!localAioVipDonateHelper.c(paramQQAppInterface)) || (android.text.TextUtils.isEmpty((CharSequence)localObject)) || (!paramBaseChatPie.N)) {
            break;
          }
          localAioVipDonateHelper.a(paramQQAppInterface, 0);
          FileManagerDataCenter.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -4022);
          paramQQAppInterface.getFileManagerDataCenter().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_Int, -4022, (String)localObject);
          return;
          localVIPAioSendHandler = (VIPAioSendHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIP_AIO_SEND_HANDLER);
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
    paramBundle.mSelfUin = paramQQAppInterface.getAccount();
    paramBundle.mPeerUin = paramString1;
    paramBundle.mUinType = paramInt1;
    paramBundle.mFileType = 2;
    paramBundle.mUniseq = paramLong1;
    paramBundle.mIsUp = true;
    paramBundle.mLocalPath = paramString2;
    paramBundle.mBusiType = 1002;
    paramBundle.mPttCompressFinish = paramBoolean3;
    paramBundle.mPttUploadPanel = paramInt5;
    paramBundle.mRec = paramQQAppInterface.getMessageFacade().a(paramString1, paramInt1, paramLong1);
    if ((paramInt1 == 1026) && (QLog.isColorLevel()))
    {
      paramString2 = new StringBuilder().append("uploadPtt,");
      if (paramBundle.mRec == null)
      {
        paramString1 = "mRec is null";
        QLog.i("PttShow", 2, paramString1);
      }
    }
    else if ((paramBundle.mRec instanceof MessageForPtt))
    {
      paramString1 = (MessageForPtt)paramBundle.mRec;
      paramString1.voiceType = paramInt3;
      paramString1.voiceLength = QQRecorder.a(paramInt2);
      paramString1.voiceChangeFlag = paramInt4;
      if (paramInt5 != 4) {
        break label276;
      }
    }
    label276:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramString1.sendFromvoiceChangePanelFlag = paramBoolean1;
      ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramBundle);
      return;
      paramString1 = "mRec is not null";
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, int paramInt6)
  {
    a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramLong1, paramBoolean1, paramInt2, paramInt3, paramBoolean2, paramInt4, paramInt5, paramBoolean3, paramLong2, paramBundle, paramArrayList, paramString3, paramBoolean4, null, paramInt6);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, MessageRecord paramMessageRecord, int paramInt6)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (StreamDataManager.a(paramString2) >= 1))
    {
      StreamDataManager.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new TransferRequest();
    paramBundle.mSelfUin = paramQQAppInterface.getAccount();
    paramBundle.mPeerUin = paramString1;
    paramBundle.mUinType = paramInt1;
    paramBundle.mFileType = 2;
    paramBundle.mUniseq = paramLong1;
    paramBundle.mIsUp = true;
    paramBundle.mLocalPath = paramString2;
    paramBundle.mBusiType = 1002;
    paramBundle.mPttCompressFinish = paramBoolean3;
    paramBundle.mPttUploadPanel = paramInt5;
    if (paramMessageRecord != null)
    {
      paramBundle.mRec = paramMessageRecord;
      if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean4) && (paramBundle.mRec != null))
      {
        paramBundle.mRec.atInfoList = paramArrayList;
        paramBundle.mRec.mRobotFlag = 1;
        new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_msg_suc").a(new String[] { paramString1, String.valueOf(((AtTroopMemberInfo)paramArrayList.get(0)).uin) }).a();
      }
      if ((paramInt1 == 1026) && (QLog.isColorLevel()))
      {
        paramString2 = new StringBuilder().append("uploadPtt,");
        if (paramBundle.mRec != null) {
          break label405;
        }
        paramString1 = "mRec is null";
        label283:
        QLog.i("PttShow", 2, paramString1);
      }
      if ((paramBundle.mRec instanceof MessageForPtt))
      {
        paramString1 = (MessageForPtt)paramBundle.mRec;
        paramString1.voiceType = paramInt3;
        paramString1.voiceLength = QQRecorder.a(paramInt2);
        paramString1.voiceChangeFlag = paramInt4;
        paramString1.mInputContent = paramString3;
        paramString1.autoToText = paramInt6;
        if (paramInt5 != 4) {
          break label412;
        }
      }
    }
    label405:
    label412:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramString1.sendFromvoiceChangePanelFlag = paramBoolean1;
      ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramBundle);
      return;
      paramBundle.mRec = paramQQAppInterface.getMessageFacade().a(paramString1, paramInt1, paramLong1);
      break;
      paramString1 = "mRec is not null";
      break label283;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (1024 == paramSessionInfo.jdField_a_of_type_Int) {}
    int i;
    do
    {
      return;
      i = ((CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityFacade", 4, "single way add allow insert " + paramSessionInfo.jdField_a_of_type_JavaLangString + " settingValue:" + i);
      }
    } while ((i != 0) && (i != 3));
    String str;
    if (i == 0)
    {
      i = -7006;
      str = "single_way_friend_add_allow_list";
      label93:
      if (ChatActivityUtils.a(paramContext, paramSessionInfo, str)) {
        break label297;
      }
      Iterator localIterator = paramQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, 0).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((MessageRecord)localIterator.next()).msgtype != i);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityFacade", 4, "single way add allow insert " + paramSessionInfo.jdField_a_of_type_JavaLangString + " hasInserted:" + bool);
      }
      if (bool) {
        break;
      }
      ChatActivityUtils.b(paramContext, paramSessionInfo, str);
      paramContext = (MessageForGrayTips)MessageRecordFactory.a(i);
      long l = MessageCache.a() + 1L;
      paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, "", l, i, paramSessionInfo.jdField_a_of_type_Int, l);
      paramContext.setTextGravity(17);
      paramContext.isread = true;
      if (MessageHandlerUtils.a(paramQQAppInterface, paramContext, false)) {
        break;
      }
      paramQQAppInterface.getMessageFacade().a(paramContext, paramContext.selfuin);
      return;
      i = -2019;
      str = "single_way_friend_list";
      break label93;
      label297:
      break;
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
    paramQQAppInterface.getMessageFacade().a(paramContext, null);
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
        jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(paramContext, 2131690011, 0);
        PokeItemAnimationManager.a().a(3);
        PokeItemAnimationManager.a().a(6);
        PokeItemAnimationManager.a().a(12);
        PokeItemAnimationManager.a().a(15);
        PokeItemAnimationManager.a().a(18);
        PokeItemAnimationManager.a().a(9);
      }
      if (!jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d()) {
        jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
      }
      return;
    }
    paramContext = new MessageForPoke();
    paramContext.msgtype = -5012;
    paramContext.isPlayed = false;
    paramContext.interactType = paramInt1;
    paramContext.subId = paramInt2;
    paramContext.name = paramString1;
    paramContext.minVersion = paramString2;
    paramContext.strength = PokeItemAnimationManager.a().a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramContext.interactType, paramInt3, -1);
    if ((paramInt3 == 3) || (paramInt3 == 4))
    {
      paramInt2 = paramContext.flag;
      if (paramInt3 != 3) {
        break label317;
      }
    }
    label317:
    for (paramInt1 = 8;; paramInt1 = 16)
    {
      paramContext.flag = (paramInt1 | paramInt2);
      paramContext.isPlayed = true;
      MessageRecordFactory.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      paramContext.initMsg();
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "sendPokeMsg strength:" + paramContext.strength + "." + paramContext);
      }
      paramQQAppInterface.getMessageFacade().a(paramContext, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PokeMsg", 2, "sendPokeMsg type:" + paramContext.interactType + "." + paramContext);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt, -1, paramString1, paramString2, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if ((paramContext != null) && (paramContext.isSendFromLocal())) {
      ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramContext.frienduin, paramContext.uniseq));
    }
    paramQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(paramContext);
    paramQQAppInterface.getMessageFacade().a(paramContext, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, int paramInt)
  {
    boolean bool1 = paramIntent.getBooleanExtra("not_forward", false);
    boolean bool2 = paramIntent.getBooleanExtra("support_multi_forward", false);
    if ((!bool1) && (!bool2)) {
      return;
    }
    if (paramForwardFileInfo.jdField_a_of_type_Int <= 0) {}
    for (;;)
    {
      paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.b(), paramForwardFileInfo.e(), paramForwardFileInfo.a(), Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), paramSessionInfo.jdField_a_of_type_Int, paramForwardFileInfo.a(), paramForwardFileInfo.c(), paramInt);
      if (!paramIntent.getBooleanExtra("not_forward", false)) {
        break;
      }
      paramIntent.removeExtra("not_forward");
      paramIntent.getExtras().remove("not_forward");
      return;
      paramInt = paramForwardFileInfo.jdField_a_of_type_Int;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramBoolean, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    if ((paramInt <= 0) && (paramForwardFileInfo != null)) {}
    for (int i = paramForwardFileInfo.jdField_a_of_type_Int;; i = paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatActivityFacade", 1, "forwardForFile");
      }
      if (ForwardUtils.a(paramIntent, paramSessionInfo, paramString, paramQQAppInterface)) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityFacade", 2, "handleForwardEditedPhoto = " + paramString);
        }
      }
      label1332:
      for (;;)
      {
        return;
        if ((paramForwardFileInfo != null) && (paramForwardFileInfo.b() == 10006) && (android.text.TextUtils.isEmpty(paramForwardFileInfo.a())))
        {
          a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramInt);
          return;
        }
        if ((!paramIntent.getBooleanExtra("isFromFavorites", false)) && (paramIntent.getBooleanExtra("isFromShare", false)))
        {
          if (!paramIntent.getBooleanExtra("sendMultiple", false))
          {
            if (paramSessionInfo.jdField_a_of_type_Int == 1)
            {
              paramQQAppInterface.getFileManagerEngine().a(paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, 0L, i);
              return;
            }
            paramQQAppInterface.getFileManagerEngine().a(paramString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, 0L, i);
          }
        }
        else if (paramIntent.getBooleanExtra("not_forward", false))
        {
          paramString = null;
          if (paramForwardFileInfo != null) {
            paramString = paramQQAppInterface.getFileManagerDataCenter().b(paramForwardFileInfo.b());
          }
          String str = paramString;
          if (paramString == null)
          {
            paramString = QfavHelper.a(paramIntent.getExtras(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
            str = paramString;
            if (paramString != null)
            {
              paramForwardFileInfo.b(paramString.nSessionId);
              str = paramString;
            }
          }
          if ((str == null) && (QLog.isColorLevel())) {
            QLog.e("ChatActivityFacade", 2, "there has a Bug!,sissionId[" + paramForwardFileInfo.b() + "]");
          }
          switch (paramForwardFileInfo.b())
          {
          }
          for (;;)
          {
            if ((paramBoolean) || (!paramIntent.getBooleanExtra("not_forward", false))) {
              break label1332;
            }
            paramIntent.removeExtra("not_forward");
            paramIntent.getExtras().remove("not_forward");
            return;
            if (paramSessionInfo.jdField_a_of_type_Int == 1)
            {
              paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramForwardFileInfo.c(), i);
            }
            else
            {
              paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, paramForwardFileInfo.c(), i);
              if (str != null)
              {
                paramQQAppInterface.lastSuccessTime = str.lastSuccessTime;
                continue;
                if (paramSessionInfo.jdField_a_of_type_Int == 1)
                {
                  paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                }
                else if (paramSessionInfo.jdField_a_of_type_Int == 0)
                {
                  paramQQAppInterface.getFileManagerEngine().b(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                }
                else if (paramSessionInfo.jdField_a_of_type_Int == 3000)
                {
                  paramQQAppInterface.getFileManagerEngine().c(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                  continue;
                  if (paramSessionInfo.jdField_a_of_type_Int == 1)
                  {
                    if (FileUtil.b(paramForwardFileInfo.a()))
                    {
                      paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                    }
                    else
                    {
                      paramForwardFileInfo.b();
                      paramContext = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.b());
                      if ((paramContext != null) && (paramContext.peerType == 3000))
                      {
                        paramSessionInfo = paramQQAppInterface.getFileManagerEngine().a(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramContext.peerType, false);
                        paramSessionInfo.selfUin = paramContext.peerUin;
                        paramQQAppInterface.getFileManagerEngine().a(paramSessionInfo, 27, paramForwardFileInfo.c(), i);
                      }
                      else
                      {
                        paramQQAppInterface.getFileManagerEngine().a(3, paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramForwardFileInfo.c(), i);
                      }
                    }
                  }
                  else
                  {
                    paramString = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.b());
                    if ((paramString != null) && (paramString.status == 16))
                    {
                      if (paramContext == null) {
                        break;
                      }
                      FileManagerUtil.c(paramContext.getResources().getString(2131692760));
                      return;
                    }
                    paramContext = paramQQAppInterface.getCurrentAccountUin();
                    if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
                      paramContext = paramSessionInfo.jdField_b_of_type_JavaLangString;
                    }
                    if ((paramString != null) && (paramString.peerType == 3000))
                    {
                      paramContext = paramQQAppInterface.getFileManagerEngine().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, paramForwardFileInfo.c(), i);
                      paramContext.selfUin = paramString.peerUin;
                      if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1006) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 10002) || (paramSessionInfo.jdField_a_of_type_Int == 1006))
                      {
                        paramContext.nOpType = 21;
                        paramQQAppInterface.getFileManagerEngine().a(paramContext, 21);
                      }
                      for (;;)
                      {
                        paramQQAppInterface.getFileManagerDataCenter().c(paramContext);
                        break;
                        if (paramSessionInfo.jdField_a_of_type_Int == 3000)
                        {
                          paramContext.nOpType = 22;
                          paramQQAppInterface.getFileManagerEngine().a(paramContext, 22);
                        }
                      }
                    }
                    paramContext = paramQQAppInterface.getFileManagerEngine().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, paramForwardFileInfo.c(), i);
                    if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
                      paramContext.nOpType = 28;
                    }
                    paramQQAppInterface.getFileManagerEngine().a(paramContext);
                    paramQQAppInterface.getFileManagerDataCenter().c(paramContext);
                    continue;
                    paramContext = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.b());
                    paramQQAppInterface.getFileManagerEngine().b(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, i);
                    continue;
                    if (paramSessionInfo.jdField_a_of_type_Int == 1)
                    {
                      if (FileUtil.b(paramForwardFileInfo.a()))
                      {
                        paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, 0L, i);
                      }
                      else
                      {
                        paramString = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.b());
                        paramContext = paramQQAppInterface.getCurrentAccountUin();
                        if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
                          paramContext = paramSessionInfo.jdField_b_of_type_JavaLangString;
                        }
                        if ((paramString != null) && (paramString.peerType == 3000))
                        {
                          paramContext = paramQQAppInterface.getFileManagerEngine().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString.peerType, false);
                          paramContext.selfUin = paramString.peerUin;
                          paramQQAppInterface.getFileManagerEngine().a(paramContext, 27);
                        }
                        else
                        {
                          paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString, i);
                        }
                      }
                    }
                    else
                    {
                      paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, i);
                      continue;
                      paramQQAppInterface.getFileManagerEngine().a(str, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, i);
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
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, com.tencent.mobileqq.apollo.api.model.ApolloInfo paramApolloInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +50 -> 51
    //   4: aload_3
    //   5: ifnull +46 -> 51
    //   8: aload_3
    //   9: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   12: ifnull +39 -> 51
    //   15: aload_3
    //   16: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   19: getfield 2551	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionName	Ljava/lang/String;
    //   22: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +26 -> 51
    //   28: aload_3
    //   29: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   32: getfield 2554	com/tencent/mobileqq/apollo/api/model/ApolloActionData:personNum	I
    //   35: ifle +17 -> 52
    //   38: aload_3
    //   39: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   42: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   45: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +4 -> 52
    //   51: return
    //   52: iconst_0
    //   53: istore 5
    //   55: iconst_0
    //   56: istore 4
    //   58: aload_0
    //   59: getstatic 230	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   62: invokevirtual 234	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   65: checkcast 53	com/tencent/mobileqq/app/FriendsManager
    //   68: astore 7
    //   70: aload_0
    //   71: ldc_w 2557
    //   74: ldc_w 2559
    //   77: invokevirtual 2562	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   80: checkcast 2557	com/tencent/mobileqq/apollo/api/IApolloManagerService
    //   83: astore 10
    //   85: aload_0
    //   86: getstatic 2565	com/tencent/mobileqq/app/BusinessHandlerFactory:APOLLO_EXTENSION_HANDLER	Ljava/lang/String;
    //   89: invokevirtual 660	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   92: checkcast 2567	com/tencent/mobileqq/apollo/api/handler/IApolloExtensionHandler
    //   95: astore_1
    //   96: aload_2
    //   97: getfield 71	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   100: iconst_1
    //   101: if_icmpne +64 -> 165
    //   104: aload_3
    //   105: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   108: getfield 2554	com/tencent/mobileqq/apollo/api/model/ApolloActionData:personNum	I
    //   111: ifle +54 -> 165
    //   114: aload_3
    //   115: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   118: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   121: aload_0
    //   122: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   125: invokevirtual 1649	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifne +37 -> 165
    //   131: aload 10
    //   133: aload_3
    //   134: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   137: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   140: invokeinterface 2571 2 0
    //   145: astore 8
    //   147: aload 8
    //   149: ifnonnull +914 -> 1063
    //   152: aload_1
    //   153: aload_3
    //   154: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   157: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   160: invokeinterface 2573 2 0
    //   165: aload_3
    //   166: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   169: getfield 2576	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionId	I
    //   172: invokestatic 2579	com/tencent/mobileqq/apollo/api/model/ApolloActionData:isAction3DModel	(I)Z
    //   175: istore 6
    //   177: ldc_w 610
    //   180: iconst_1
    //   181: iconst_4
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: ldc_w 2581
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: aload_3
    //   194: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   197: getfield 2576	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionId	I
    //   200: invokestatic 1040	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   203: aastore
    //   204: dup
    //   205: iconst_2
    //   206: ldc_w 2583
    //   209: aastore
    //   210: dup
    //   211: iconst_3
    //   212: iload 6
    //   214: invokestatic 2588	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   217: aastore
    //   218: invokestatic 2591	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   221: new 1795	com/tencent/mobileqq/apollo/api/model/ApolloMessage
    //   224: dup
    //   225: invokespecial 2592	com/tencent/mobileqq/apollo/api/model/ApolloMessage:<init>	()V
    //   228: astore 9
    //   230: iload 6
    //   232: ifeq +1038 -> 1270
    //   235: aload_3
    //   236: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   239: getfield 2554	com/tencent/mobileqq/apollo/api/model/ApolloActionData:personNum	I
    //   242: ifle +966 -> 1208
    //   245: aload 9
    //   247: sipush 1454
    //   250: putfield 1797	com/tencent/mobileqq/apollo/api/model/ApolloMessage:id	I
    //   253: new 2594	com/tencent/mobileqq/apollo/api/model/Apollo3DMessage
    //   256: dup
    //   257: invokespecial 2595	com/tencent/mobileqq/apollo/api/model/Apollo3DMessage:<init>	()V
    //   260: astore 7
    //   262: aload 7
    //   264: aload_3
    //   265: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   268: getfield 2576	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionId	I
    //   271: putfield 2598	com/tencent/mobileqq/apollo/api/model/Apollo3DMessage:actionID_3D	I
    //   274: aload 7
    //   276: aload_3
    //   277: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   280: getfield 2601	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionType	I
    //   283: putfield 2604	com/tencent/mobileqq/apollo/api/model/Apollo3DMessage:actionType_3D	I
    //   286: aload 7
    //   288: aload_3
    //   289: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   292: getfield 2551	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionName	Ljava/lang/String;
    //   295: putfield 2607	com/tencent/mobileqq/apollo/api/model/Apollo3DMessage:actionName_3D	Ljava/lang/String;
    //   298: aload_0
    //   299: ldc_w 2609
    //   302: ldc_w 2559
    //   305: invokevirtual 2562	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   308: checkcast 2609	com/tencent/mobileqq/apollo/api/data/IApolloDaoManagerService
    //   311: aload 9
    //   313: getfield 1797	com/tencent/mobileqq/apollo/api/model/ApolloMessage:id	I
    //   316: invokeinterface 2613 2 0
    //   321: astore_1
    //   322: aload_1
    //   323: ifnull +923 -> 1246
    //   326: aload_1
    //   327: getfield 2551	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionName	Ljava/lang/String;
    //   330: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   333: ifne +913 -> 1246
    //   336: aload 9
    //   338: aload_1
    //   339: getfield 2551	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionName	Ljava/lang/String;
    //   342: ldc_w 1641
    //   345: invokevirtual 84	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   348: putfield 2616	com/tencent/mobileqq/apollo/api/model/ApolloMessage:name	[B
    //   351: sipush 1024
    //   354: istore 4
    //   356: aload_3
    //   357: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   360: getfield 2619	com/tencent/mobileqq/apollo/api/model/ApolloActionData:atNickName	Ljava/lang/String;
    //   363: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   366: ifne +36 -> 402
    //   369: aload_2
    //   370: getfield 71	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   373: iconst_1
    //   374: if_icmpeq +13 -> 387
    //   377: aload_2
    //   378: getfield 71	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   381: sipush 3000
    //   384: if_icmpne +18 -> 402
    //   387: aload 9
    //   389: aload_3
    //   390: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   393: getfield 2619	com/tencent/mobileqq/apollo/api/model/ApolloActionData:atNickName	Ljava/lang/String;
    //   396: invokevirtual 2621	java/lang/String:getBytes	()[B
    //   399: putfield 2624	com/tencent/mobileqq/apollo/api/model/ApolloMessage:text	[B
    //   402: aload 10
    //   404: aload_0
    //   405: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   408: invokeinterface 2571 2 0
    //   413: astore 8
    //   415: aload 9
    //   417: aload 8
    //   419: getfield 2629	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloServerTS	J
    //   422: invokestatic 2631	com/tencent/mobileqq/util/Utils:a	(J)I
    //   425: i2l
    //   426: putfield 2634	com/tencent/mobileqq/apollo/api/model/ApolloMessage:sender_ts	J
    //   429: aload 9
    //   431: aload 8
    //   433: getfield 2637	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloStatus	I
    //   436: putfield 2640	com/tencent/mobileqq/apollo/api/model/ApolloMessage:sender_status	I
    //   439: iload 6
    //   441: ifeq +18 -> 459
    //   444: aload 7
    //   446: ifnull +13 -> 459
    //   449: aload 7
    //   451: aload 8
    //   453: getfield 2643	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:cmshow3dFlag	I
    //   456: putfield 2646	com/tencent/mobileqq/apollo/api/model/Apollo3DMessage:senderStatus_3D	I
    //   459: iload 4
    //   461: iconst_1
    //   462: ior
    //   463: bipush 8
    //   465: ior
    //   466: bipush 32
    //   468: ior
    //   469: istore 4
    //   471: aload_3
    //   472: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   475: getfield 2554	com/tencent/mobileqq/apollo/api/model/ApolloActionData:personNum	I
    //   478: ifle +979 -> 1457
    //   481: aload 9
    //   483: aload_3
    //   484: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   487: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   490: invokestatic 2649	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   493: invokevirtual 2652	java/lang/Long:longValue	()J
    //   496: putfield 2655	com/tencent/mobileqq/apollo/api/model/ApolloMessage:peer_uin	J
    //   499: aload 10
    //   501: aload_3
    //   502: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   505: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   508: invokeinterface 2571 2 0
    //   513: astore 8
    //   515: aload 9
    //   517: aload 8
    //   519: getfield 2629	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloServerTS	J
    //   522: invokestatic 2631	com/tencent/mobileqq/util/Utils:a	(J)I
    //   525: i2l
    //   526: putfield 2658	com/tencent/mobileqq/apollo/api/model/ApolloMessage:peer_ts	J
    //   529: aload 9
    //   531: aload 8
    //   533: getfield 2637	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloStatus	I
    //   536: putfield 2661	com/tencent/mobileqq/apollo/api/model/ApolloMessage:peer_status	I
    //   539: iload 6
    //   541: ifeq +18 -> 559
    //   544: aload 7
    //   546: ifnull +13 -> 559
    //   549: aload 7
    //   551: aload 8
    //   553: getfield 2643	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:cmshow3dFlag	I
    //   556: putfield 2664	com/tencent/mobileqq/apollo/api/model/Apollo3DMessage:peerStatus_3D	I
    //   559: iload 4
    //   561: iconst_4
    //   562: ior
    //   563: iconst_2
    //   564: ior
    //   565: bipush 16
    //   567: ior
    //   568: bipush 64
    //   570: ior
    //   571: istore 5
    //   573: iload 5
    //   575: istore 4
    //   577: iload 6
    //   579: ifeq +11 -> 590
    //   582: iload 5
    //   584: sipush 2048
    //   587: ior
    //   588: istore 4
    //   590: aload_3
    //   591: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   594: getfield 2554	com/tencent/mobileqq/apollo/api/model/ApolloActionData:personNum	I
    //   597: ifne +32 -> 629
    //   600: aload_2
    //   601: getfield 71	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   604: iconst_1
    //   605: invokestatic 2669	com/tencent/mobileqq/apollo/api/aio/CmShowAioMatcher:a	(II)Z
    //   608: ifeq +21 -> 629
    //   611: aload 9
    //   613: aload_3
    //   614: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   617: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   620: invokestatic 2649	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   623: invokevirtual 2652	java/lang/Long:longValue	()J
    //   626: putfield 2655	com/tencent/mobileqq/apollo/api/model/ApolloMessage:peer_uin	J
    //   629: iload 4
    //   631: istore 5
    //   633: aload_3
    //   634: getfield 2672	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mTextType	I
    //   637: iconst_1
    //   638: if_icmpne +11 -> 649
    //   641: iload 4
    //   643: sipush 128
    //   646: ior
    //   647: istore 5
    //   649: aload 9
    //   651: iload 5
    //   653: putfield 2673	com/tencent/mobileqq/apollo/api/model/ApolloMessage:flag	I
    //   656: aconst_null
    //   657: astore 8
    //   659: new 700	java/util/ArrayList
    //   662: dup
    //   663: invokespecial 701	java/util/ArrayList:<init>	()V
    //   666: pop
    //   667: iconst_0
    //   668: ifne +12 -> 680
    //   671: new 1267	org/json/JSONObject
    //   674: dup
    //   675: invokespecial 1268	org/json/JSONObject:<init>	()V
    //   678: astore 8
    //   680: iload 6
    //   682: ifeq +626 -> 1308
    //   685: aload 7
    //   687: ifnull +621 -> 1308
    //   690: aload_1
    //   691: ifnull +617 -> 1308
    //   694: aload 8
    //   696: ldc_w 2674
    //   699: aload_1
    //   700: getfield 2601	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionType	I
    //   703: invokevirtual 1396	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   706: pop
    //   707: aload_3
    //   708: getfield 2677	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAudioId	I
    //   711: ifle +30 -> 741
    //   714: aload 8
    //   716: ldc_w 2679
    //   719: aload_3
    //   720: getfield 2677	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAudioId	I
    //   723: invokevirtual 1396	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   726: pop
    //   727: aload 8
    //   729: ldc_w 2681
    //   732: aload_3
    //   733: getfield 2684	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAudioStartTime	F
    //   736: f2d
    //   737: invokevirtual 2687	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   740: pop
    //   741: aload_3
    //   742: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   745: getfield 2690	com/tencent/mobileqq/apollo/api/model/ApolloActionData:inputText	Ljava/lang/String;
    //   748: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   751: ifne +589 -> 1340
    //   754: aload 8
    //   756: ldc_w 2691
    //   759: aload_3
    //   760: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   763: getfield 2690	com/tencent/mobileqq/apollo/api/model/ApolloActionData:inputText	Ljava/lang/String;
    //   766: invokevirtual 1274	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   769: pop
    //   770: aload 7
    //   772: ifnull +23 -> 795
    //   775: aload 7
    //   777: invokevirtual 2695	com/tencent/mobileqq/apollo/api/model/Apollo3DMessage:getMessageJSONObject	()Lorg/json/JSONObject;
    //   780: astore_1
    //   781: aload_1
    //   782: ifnull +13 -> 795
    //   785: aload 8
    //   787: ldc_w 2697
    //   790: aload_1
    //   791: invokevirtual 1274	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   794: pop
    //   795: aload_3
    //   796: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   799: ifnull +25 -> 824
    //   802: aload_3
    //   803: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   806: getfield 2700	com/tencent/mobileqq/apollo/api/model/ApolloActionData:isForPlayerAction	I
    //   809: iconst_1
    //   810: if_icmpne +14 -> 824
    //   813: aload 8
    //   815: ldc_w 2702
    //   818: bipush 10
    //   820: invokevirtual 1396	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   823: pop
    //   824: aload 8
    //   826: ifnull +13 -> 839
    //   829: aload 9
    //   831: aload 8
    //   833: invokevirtual 1289	org/json/JSONObject:toString	()Ljava/lang/String;
    //   836: putfield 2705	com/tencent/mobileqq/apollo/api/model/ApolloMessage:extStr	Ljava/lang/String;
    //   839: aload_0
    //   840: aload_2
    //   841: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   844: aload_2
    //   845: getfield 263	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   848: aload_2
    //   849: getfield 71	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   852: aload 9
    //   854: invokestatic 2708	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/apollo/api/model/ApolloMessage;)Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;
    //   857: astore_1
    //   858: aload_1
    //   859: aload_3
    //   860: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   863: getfield 2690	com/tencent/mobileqq/apollo/api/model/ApolloActionData:inputText	Ljava/lang/String;
    //   866: putfield 2709	com/tencent/mobileqq/apollo/api/model/MessageForApollo:inputText	Ljava/lang/String;
    //   869: aload_1
    //   870: aload_3
    //   871: getfield 2677	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAudioId	I
    //   874: putfield 2712	com/tencent/mobileqq/apollo/api/model/MessageForApollo:audioId	I
    //   877: aload_1
    //   878: aload_3
    //   879: getfield 2684	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAudioStartTime	F
    //   882: putfield 2714	com/tencent/mobileqq/apollo/api/model/MessageForApollo:audioStartTime	F
    //   885: aload_1
    //   886: aload_3
    //   887: getfield 2717	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mPlayOriginalAudio	I
    //   890: putfield 2720	com/tencent/mobileqq/apollo/api/model/MessageForApollo:isPlayDefaultAudio	I
    //   893: aload_1
    //   894: aload_3
    //   895: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   898: getfield 2601	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionType	I
    //   901: putfield 2721	com/tencent/mobileqq/apollo/api/model/MessageForApollo:actionType	I
    //   904: aload_1
    //   905: aload 7
    //   907: putfield 2724	com/tencent/mobileqq/apollo/api/model/MessageForApollo:mApollo3DMessage	Lcom/tencent/mobileqq/apollo/api/model/Apollo3DMessage;
    //   910: aload_1
    //   911: getfield 2709	com/tencent/mobileqq/apollo/api/model/MessageForApollo:inputText	Ljava/lang/String;
    //   914: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   917: ifeq +11 -> 928
    //   920: aload_1
    //   921: aload_3
    //   922: getfield 2727	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mActionText	Ljava/lang/String;
    //   925: putfield 2709	com/tencent/mobileqq/apollo/api/model/MessageForApollo:inputText	Ljava/lang/String;
    //   928: aload_1
    //   929: aload_3
    //   930: getfield 2730	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mSendSrc	I
    //   933: putfield 2731	com/tencent/mobileqq/apollo/api/model/MessageForApollo:mSendSrc	I
    //   936: aload_1
    //   937: aload_3
    //   938: getfield 2734	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mPackageId	I
    //   941: putfield 2737	com/tencent/mobileqq/apollo/api/model/MessageForApollo:curUsedIdType	I
    //   944: aload_3
    //   945: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   948: ifnull +20 -> 968
    //   951: aload_3
    //   952: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   955: getfield 2700	com/tencent/mobileqq/apollo/api/model/ApolloActionData:isForPlayerAction	I
    //   958: iconst_1
    //   959: if_icmpne +9 -> 968
    //   962: aload_1
    //   963: bipush 10
    //   965: putfield 2740	com/tencent/mobileqq/apollo/api/model/MessageForApollo:msgType	I
    //   968: aload_0
    //   969: ldc_w 2742
    //   972: ldc_w 2559
    //   975: invokevirtual 2562	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   978: checkcast 2742	com/tencent/mobileqq/apollo/api/ISpriteScriptManager
    //   981: astore_2
    //   982: aload_3
    //   983: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   986: getfield 2601	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionType	I
    //   989: istore 4
    //   991: getstatic 2746	com/tencent/mobileqq/apollo/api/ISpriteScriptManager:BusinessId	Lcom/tencent/mobileqq/apollo/api/ISpriteScriptManager$BusinessId;
    //   994: astore 7
    //   996: iload 4
    //   998: ifeq +387 -> 1385
    //   1001: aload_2
    //   1002: ifnull +383 -> 1385
    //   1005: ldc_w 2748
    //   1008: invokestatic 1771	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1011: checkcast 2748	com/tencent/mobileqq/apollo/api/script/ISpriteUtil
    //   1014: aload_0
    //   1015: invokeinterface 2752 2 0
    //   1020: ifnonnull +346 -> 1366
    //   1023: aload_0
    //   1024: invokevirtual 132	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1027: aload_1
    //   1028: aconst_null
    //   1029: invokevirtual 618	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/app/MessageObserver;)V
    //   1032: ldc_w 610
    //   1035: iconst_2
    //   1036: new 191	java/lang/StringBuilder
    //   1039: dup
    //   1040: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   1043: ldc_w 2754
    //   1046: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: aload_3
    //   1050: invokevirtual 2755	com/tencent/mobileqq/apollo/api/model/ApolloInfo:toString	()Ljava/lang/String;
    //   1053: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1059: invokestatic 1846	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1062: return
    //   1063: aload 7
    //   1065: aload_3
    //   1066: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   1069: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   1072: invokevirtual 56	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   1075: ifne +35 -> 1110
    //   1078: invokestatic 2760	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   1081: aload 8
    //   1083: getfield 2763	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloUpdateTime	J
    //   1086: lsub
    //   1087: ldc2_w 2764
    //   1090: lcmp
    //   1091: iflt +19 -> 1110
    //   1094: aload_1
    //   1095: aload_3
    //   1096: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   1099: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   1102: invokeinterface 2573 2 0
    //   1107: goto -942 -> 165
    //   1110: aload 7
    //   1112: aload_3
    //   1113: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   1116: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   1119: invokevirtual 56	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   1122: ifeq +29 -> 1151
    //   1125: aload 8
    //   1127: getfield 2763	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloUpdateTime	J
    //   1130: lconst_0
    //   1131: lcmp
    //   1132: ifne +19 -> 1151
    //   1135: aload_1
    //   1136: aload_3
    //   1137: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   1140: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   1143: invokeinterface 2573 2 0
    //   1148: goto -983 -> 165
    //   1151: aload 8
    //   1153: getfield 2629	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloServerTS	J
    //   1156: aload 8
    //   1158: getfield 2768	com/tencent/mobileqq/apollo/api/model/ApolloBaseInfo:apolloLocalTS	J
    //   1161: lcmp
    //   1162: ifeq -997 -> 165
    //   1165: new 700	java/util/ArrayList
    //   1168: dup
    //   1169: iconst_1
    //   1170: invokespecial 2769	java/util/ArrayList:<init>	(I)V
    //   1173: astore 7
    //   1175: aload 7
    //   1177: aload_3
    //   1178: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   1181: getfield 2555	com/tencent/mobileqq/apollo/api/model/ApolloActionData:peerUin	Ljava/lang/String;
    //   1184: invokestatic 1852	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1187: invokestatic 2772	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1190: invokevirtual 1324	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1193: pop
    //   1194: aload_1
    //   1195: aload 7
    //   1197: ldc_w 2774
    //   1200: invokeinterface 2777 3 0
    //   1205: goto -1040 -> 165
    //   1208: aload 9
    //   1210: sipush 1450
    //   1213: putfield 1797	com/tencent/mobileqq/apollo/api/model/ApolloMessage:id	I
    //   1216: goto -963 -> 253
    //   1219: astore 8
    //   1221: sipush 1024
    //   1224: istore 4
    //   1226: aconst_null
    //   1227: astore_1
    //   1228: aconst_null
    //   1229: astore 7
    //   1231: ldc_w 610
    //   1234: iconst_1
    //   1235: ldc_w 2779
    //   1238: aload 8
    //   1240: invokestatic 615	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1243: goto -887 -> 356
    //   1246: aload 9
    //   1248: ldc_w 2781
    //   1251: invokevirtual 2621	java/lang/String:getBytes	()[B
    //   1254: putfield 2616	com/tencent/mobileqq/apollo/api/model/ApolloMessage:name	[B
    //   1257: goto -906 -> 351
    //   1260: astore 8
    //   1262: sipush 1024
    //   1265: istore 4
    //   1267: goto -36 -> 1231
    //   1270: aload 9
    //   1272: aload_3
    //   1273: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   1276: getfield 2576	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionId	I
    //   1279: putfield 1797	com/tencent/mobileqq/apollo/api/model/ApolloMessage:id	I
    //   1282: aload 9
    //   1284: aload_3
    //   1285: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   1288: getfield 2551	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionName	Ljava/lang/String;
    //   1291: ldc_w 1641
    //   1294: invokevirtual 84	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1297: putfield 2616	com/tencent/mobileqq/apollo/api/model/ApolloMessage:name	[B
    //   1300: aconst_null
    //   1301: astore 7
    //   1303: aconst_null
    //   1304: astore_1
    //   1305: goto -949 -> 356
    //   1308: aload 8
    //   1310: ldc_w 2674
    //   1313: aload_3
    //   1314: getfield 2546	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mAction	Lcom/tencent/mobileqq/apollo/api/model/ApolloActionData;
    //   1317: getfield 2601	com/tencent/mobileqq/apollo/api/model/ApolloActionData:actionType	I
    //   1320: invokevirtual 1396	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1323: pop
    //   1324: goto -617 -> 707
    //   1327: astore_0
    //   1328: ldc_w 610
    //   1331: iconst_1
    //   1332: ldc_w 2783
    //   1335: aload_0
    //   1336: invokestatic 615	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1339: return
    //   1340: aload_3
    //   1341: getfield 2727	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mActionText	Ljava/lang/String;
    //   1344: invokestatic 394	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1347: ifne -577 -> 770
    //   1350: aload 8
    //   1352: ldc_w 2691
    //   1355: aload_3
    //   1356: getfield 2727	com/tencent/mobileqq/apollo/api/model/ApolloInfo:mActionText	Ljava/lang/String;
    //   1359: invokevirtual 1274	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1362: pop
    //   1363: goto -593 -> 770
    //   1366: aload_2
    //   1367: invokeinterface 2787 1 0
    //   1372: astore_0
    //   1373: aload_0
    //   1374: ifnull -1323 -> 51
    //   1377: aload_0
    //   1378: aload_1
    //   1379: invokeinterface 2792 2 0
    //   1384: return
    //   1385: aload_0
    //   1386: invokevirtual 132	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1389: aload_1
    //   1390: aconst_null
    //   1391: invokevirtual 618	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/app/MessageObserver;)V
    //   1394: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1397: ifeq -1346 -> 51
    //   1400: ldc_w 610
    //   1403: iconst_2
    //   1404: new 191	java/lang/StringBuilder
    //   1407: dup
    //   1408: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   1411: ldc_w 2794
    //   1414: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: aload_3
    //   1418: invokevirtual 2755	com/tencent/mobileqq/apollo/api/model/ApolloInfo:toString	()Ljava/lang/String;
    //   1421: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1427: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1430: return
    //   1431: astore 8
    //   1433: aconst_null
    //   1434: astore_1
    //   1435: sipush 1024
    //   1438: istore 4
    //   1440: goto -209 -> 1231
    //   1443: astore 8
    //   1445: aconst_null
    //   1446: astore 7
    //   1448: aconst_null
    //   1449: astore_1
    //   1450: iload 5
    //   1452: istore 4
    //   1454: goto -223 -> 1231
    //   1457: goto -867 -> 590
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1460	0	paramQQAppInterface	QQAppInterface
    //   0	1460	1	paramContext	Context
    //   0	1460	2	paramSessionInfo	SessionInfo
    //   0	1460	3	paramApolloInfo	com.tencent.mobileqq.apollo.api.model.ApolloInfo
    //   56	1397	4	i	int
    //   53	1398	5	j	int
    //   175	506	6	bool	boolean
    //   68	1379	7	localObject1	Object
    //   145	1012	8	localObject2	Object
    //   1219	20	8	localException1	Exception
    //   1260	91	8	localException2	Exception
    //   1431	1	8	localException3	Exception
    //   1443	1	8	localException4	Exception
    //   228	1055	9	localApolloMessage	ApolloMessage
    //   83	417	10	localIApolloManagerService	com.tencent.mobileqq.apollo.api.IApolloManagerService
    // Exception table:
    //   from	to	target	type
    //   235	253	1219	java/lang/Exception
    //   253	262	1219	java/lang/Exception
    //   1208	1216	1219	java/lang/Exception
    //   326	351	1260	java/lang/Exception
    //   1246	1257	1260	java/lang/Exception
    //   671	680	1327	java/lang/Throwable
    //   694	707	1327	java/lang/Throwable
    //   707	741	1327	java/lang/Throwable
    //   741	770	1327	java/lang/Throwable
    //   775	781	1327	java/lang/Throwable
    //   785	795	1327	java/lang/Throwable
    //   795	824	1327	java/lang/Throwable
    //   1308	1324	1327	java/lang/Throwable
    //   1340	1363	1327	java/lang/Throwable
    //   262	322	1431	java/lang/Exception
    //   1270	1300	1443	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon == null)
    {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
      QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
      return;
    }
    if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4)) && (!paramEmoticon.hasEncryptKey()))
    {
      Toast.makeText(paramContext, paramContext.getString(2131692205), 0).show();
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
    ThreadManager.post(new ChatActivityFacade.20(paramQQAppInterface, paramEmoticon, paramContext, paramSessionInfo, paramInt), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, long paramLong)
  {
    paramContext = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      paramContext = MessageRecordFactory.a(paramContext);
      paramQQAppInterface.getMessageFacade().a(paramContext, null, true);
      paramQQAppInterface = (EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
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
      Toast.makeText(paramContext, paramContext.getString(2131692205), 0).show();
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
    ThreadManager.post(new ChatActivityFacade.21(paramQQAppInterface, paramEmoticon, paramContext, paramSessionInfo, paramStickerInfo), 5, null, false);
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
      ChatActivityUtils.a(paramContext, 2131694919, 0);
      ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "ChatActivity.sendIMEEXpression");
      return;
    }
    paramContext = new PicUploadInfo.Builder();
    paramContext.a(paramString);
    paramContext.d(paramInt);
    paramContext.d(paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramContext.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
    paramContext.e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    paramContext.c(paramQQAppInterface.getCurrentAccountUin());
    paramContext.e(paramSessionInfo.jdField_a_of_type_Int);
    paramContext.l(paramSessionInfo.jdField_e_of_type_Int);
    PicReq localPicReq = PicBusiManager.a(2, paramInt);
    localPicReq.a(paramContext.a());
    PicBusiManager.a(localPicReq);
    ThreadManager.post(new ChatActivityFacade.11(paramString, paramSessionInfo, paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131692257, 0);
      return;
    }
    paramSessionInfo = paramQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong);
    if (paramSessionInfo == null)
    {
      ChatActivityUtils.a(paramContext, 2131719023, 0);
      return;
    }
    ThreadManager.post(new ChatActivityFacade.23(paramSessionInfo, paramQQAppInterface, paramString, paramInt, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) && ((paramContext instanceof BaseActivity)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), 2131697388, 0).b(paramContext.getTitleBarHeight());
      return;
    }
    ThreadManager.post(new ChatActivityFacade.22(paramQQAppInterface, paramSessionInfo, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, paramString2, paramString3, paramLong, paramInt, paramString4, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2)
  {
    if (FileUtils.b(paramString1)) {
      ForwardSendPicUtil.a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_JavaLangString, false, paramContext, paramInt2);
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        l1 = a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramString2, paramString3, paramLong, paramInt1);
        paramContext = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download1,uniseq:" + l1 + ",filePath:" + paramString1 + ",forwardImageOrgServerpath:" + paramString2 + ",forwardImageOrgItemId:" + paramLong + ",processor:" + paramContext);
        }
      } while ((paramContext == null) || (!(paramContext instanceof BaseTransProcessor)));
      paramContext = (BaseTransProcessor)paramContext;
      l2 = paramContext.getFileStatus();
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download2,msgId:" + l1 + ",filePath:" + paramString1 + ",get download process status:" + l2);
      }
    } while ((l2 != 2000L) && (l2 != 2001L) && (l2 != 2002L));
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString + l1;
    ITransFileController localITransFileController = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
    IHttpCommunicatorListener localIHttpCommunicatorListener = localITransFileController.findProcessor(paramSessionInfo.jdField_a_of_type_JavaLangString, l1);
    if ((localIHttpCommunicatorListener instanceof ForwardImageProcessor)) {
      ((ForwardImageProcessor)localIHttpCommunicatorListener).stopListening();
    }
    localITransFileController.addProcessor(str, new ForwardImageProcessor(l1, paramString4, paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, paramString3, paramLong, paramInt1));
    paramContext.getFileMsg().forwardTaskKey = paramString4;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, paramArrayList, new ChatActivityFacade.SendMsgParams());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, false, false, paramBoolean, null, null, paramString2, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, paramBoolean1, paramBoolean2, false, paramString2, paramStickerInfo, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, EmojiStickerManager.StickerInfo paramStickerInfo, String paramString3, Bundle paramBundle)
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
      ChatActivityUtils.a(paramContext, 2131694919, 0);
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
    ((PicUploadInfo.Builder)localObject).c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
    ((PicUploadInfo.Builder)localObject).e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).c(paramQQAppInterface.getCurrentAccountUin());
    ((PicUploadInfo.Builder)localObject).e(paramSessionInfo.jdField_a_of_type_Int);
    ((PicUploadInfo.Builder)localObject).l(paramSessionInfo.jdField_e_of_type_Int);
    PicReq localPicReq = PicBusiManager.a(2, 1006);
    localPicReq.a(((PicUploadInfo.Builder)localObject).a());
    localObject = new PicMessageExtraData();
    if (paramBoolean3)
    {
      ((PicMessageExtraData)localObject).imageBizType = 8;
      if (paramBundle != null) {
        ((PicMessageExtraData)localObject).mTemplateId = paramBundle.getString("widgetinfo", "");
      }
      if (android.text.TextUtils.isEmpty(paramString3)) {
        break label410;
      }
      ((PicMessageExtraData)localObject).textSummary = ("[" + paramString3 + "]");
    }
    for (;;)
    {
      localPicReq.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData = ((PicMessageExtraData)localObject);
      PicBusiManager.a(localPicReq);
      if (!paramBoolean1) {
        break;
      }
      ThreadManager.post(new ChatActivityFacade.12(paramString1, paramSessionInfo, paramQQAppInterface), 5, null, false);
      return;
      ((PicMessageExtraData)localObject).imageBizType = 1;
      int i;
      if (paramBoolean2)
      {
        i = 2;
        label363:
        ((PicMessageExtraData)localObject).customFaceType = i;
        if (!paramBoolean2) {
          break label403;
        }
      }
      for (;;)
      {
        ((PicMessageExtraData)localObject).emojiPkgId = paramString2;
        if (paramStickerInfo == null) {
          break;
        }
        ((PicMessageExtraData)localObject).stickerInfo = paramStickerInfo;
        break;
        i = 0;
        break label363;
        label403:
        paramString2 = "";
      }
      label410:
      if (paramBoolean3) {
        ((PicMessageExtraData)localObject).textSummary = paramContext.getResources().getString(2131691359);
      } else {
        ((PicMessageExtraData)localObject).textSummary = paramContext.getResources().getString(2131691358);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, List<String> paramList)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          String str = (String)paramList.next();
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            continue;
          }
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")) && (((JSONObject)localObject2).getString("uin").equals(UinMD5Cache.a(str))))
          {
            localObject2 = paramQQAppInterface.getMessageFacade().b(str, 0);
            ChatActivityUtils.a(paramContext, str, 0, "single_way_friend_list");
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
              if (localMessageRecord.msgtype != -2019) {
                continue;
              }
              paramQQAppInterface.getMessageFacade().b(str, localMessageRecord.istroop, localMessageRecord.uniseq);
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l;
    do
    {
      try
      {
        Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
        l = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("ChatActivityFacade,uin: %s, uinType: %d, id: %d", new Object[] { paramSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(paramSessionInfo.jdField_a_of_type_Int), Long.valueOf(l) }));
        }
        if (paramSessionInfo.jdField_a_of_type_Int == 1036) {
          return;
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.msg.sendReadConfirm_PB", 2, paramQQAppInterface, new Object[0]);
        return;
      }
    } while ((l == -1L) || (l == paramSessionInfo.jdField_a_of_type_Long));
    paramSessionInfo.jdField_a_of_type_Long = l;
    String str = ProcessorDispatcher.a(paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.getMsgHandler().a(str).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, l);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    if (paramLong > NetConnInfoCenter.getServerTimeMillis())
    {
      QLog.e("ChatActivityFacade.QZoneFeeds", 2, String.format("帖子创建时间：%d,当前取得服务器时间：%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()) }));
      return;
    }
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story帖子创建时间：%d", new Object[] { Long.valueOf(paramLong) }));
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, "key_last_story_feed_create_time_for_aio");
    paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramSessionInfo, paramLong).apply();
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
      ((TroopQZoneUploadAlbumHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_QZONE_UPLOAD_ALBUM_PROGRESS_HANDLER)).a(i, paramSessionInfo.jdField_a_of_type_JavaLangString, l);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramMessageForPic == null))
    {
      QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("FORWARD_UIN_TYPE", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("SENDER_TROOP_UIN", paramSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("FORWARD_PEER_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("FORWARD_SELF_UIN", paramQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("forward_image_width", paramMessageForPic.width);
    localIntent.putExtra("forward_image_height", paramMessageForPic.height);
    localIntent.putExtra("forward_file_size", paramMessageForPic.size);
    localIntent.putExtra("forward_image_type", paramMessageForPic.imageType);
    localIntent.putExtra("forward_filepath", paramMessageForPic.path);
    paramQQAppInterface = paramMessageForPic.frienduin + paramMessageForPic.uniseq + paramMessageForPic.istroop;
    localIntent.putExtra("BUSI_TYPE", 1009);
    localIntent.putExtra("forward_download_image_task_key", paramQQAppInterface);
    localIntent.putExtra("forward_download_image_org_uin", paramMessageForPic.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramMessageForPic.istroop);
    localIntent.putExtra("forward_download_image_server_path", paramMessageForPic.uuid);
    localIntent.putExtra("forward_download_image_item_id", paramMessageForPic.uniseq);
    localIntent.putExtra("forward_photo_isSend", paramMessageForPic.issend);
    localIntent.putExtra("forward_photo_md5", paramMessageForPic.md5);
    localIntent.putExtra("forward_photo_group_fileid", paramMessageForPic.groupFileID);
    localIntent.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", paramMessageForPic.fileSizeFlag);
    paramQQAppInterface = PicBusiManager.a(1009, localIntent);
    paramSessionInfo = PicBusiManager.a(3, 1009);
    paramSessionInfo.a(paramQQAppInterface);
    paramSessionInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    paramSessionInfo.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData = paramMessageForPic.picExtraData;
    paramMessageForPic.forwardId.put(paramSessionInfo, Integer.valueOf(paramInt));
    PicBusiManager.a(paramSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 2;
    if ((paramQQAppInterface == null) || (paramMessageForShortVideo == null))
    {
      QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("from_uin", ShortVideoUtils.getFromUinForForward(paramMessageForShortVideo));
    ((Intent)localObject).putExtra("from_uin_type", paramMessageForShortVideo.istroop);
    ((Intent)localObject).putExtra("from_session_uin", paramMessageForShortVideo.frienduin);
    ((Intent)localObject).putExtra("from_busi_type", paramMessageForShortVideo.busiType);
    ((Intent)localObject).putExtra("file_send_size", paramMessageForShortVideo.videoFileSize);
    ((Intent)localObject).putExtra("file_send_duration", paramMessageForShortVideo.videoFileTime);
    ((Intent)localObject).putExtra("file_name", paramMessageForShortVideo.videoFileName);
    ((Intent)localObject).putExtra("file_format", paramMessageForShortVideo.videoFileFormat);
    String str = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "Forward menu clicked, videoPath=" + str + ",videoPath = " + str + ", " + paramMessageForShortVideo.toLogString());
    }
    ((Intent)localObject).putExtra("file_send_path", str);
    ((Intent)localObject).putExtra("thumbfile_send_path", ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg"));
    ((Intent)localObject).putExtra("file_shortvideo_md5", paramMessageForShortVideo.md5);
    if (!android.text.TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {
      ((Intent)localObject).putExtra("file_shortvideo_local_md5", paramMessageForShortVideo.mLocalMd5);
    }
    ((Intent)localObject).putExtra("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    ((Intent)localObject).putExtra("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    ((Intent)localObject).putExtra("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    ((Intent)localObject).putExtra("file_source", paramMessageForShortVideo.fileSource);
    ((Intent)localObject).putExtra("file_uuid", paramMessageForShortVideo.uuid);
    ((Intent)localObject).putExtra("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    ((Intent)localObject).putExtra("support_progressive", paramMessageForShortVideo.supportProgressive);
    ((Intent)localObject).putExtra("file_width", paramMessageForShortVideo.fileWidth);
    ((Intent)localObject).putExtra("file_height", paramMessageForShortVideo.fileHeight);
    ((Intent)localObject).putExtra("from_msg_uniseq", paramMessageForShortVideo.uniseq);
    int i = paramMessageForShortVideo.busiType;
    if (i == 1)
    {
      i = 2;
      ((Intent)localObject).putExtra("special_video_type", paramMessageForShortVideo.specialVideoType);
      if (paramMessageForShortVideo.CheckIsHotVideo())
      {
        ((Intent)localObject).putExtra("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
        ((Intent)localObject).putExtra("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
        ((Intent)localObject).putExtra("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
        ((Intent)localObject).putExtra("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
      }
      ((Intent)localObject).putExtra("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
      ((Intent)localObject).putExtra("widgetinfo", paramMessageForShortVideo.templateId);
      ((Intent)localObject).putExtra("key_camera_material_name", paramMessageForShortVideo.templateName);
      if ((paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) && (paramMessageForShortVideo.senderuin.equals(paramQQAppInterface.getAccount())))
      {
        ((Intent)localObject).putExtra("param_key_redbag_video_id", paramMessageForShortVideo.shortVideoId);
        ((Intent)localObject).putExtra("param_key_redbag_type", paramMessageForShortVideo.redBagType);
        if (paramSessionInfo.jdField_a_of_type_Int != 1) {
          break label696;
        }
        j = 1;
      }
    }
    for (;;)
    {
      FlowCameraMqqAction.a("", "0X80088E4", String.valueOf(j));
      paramSessionInfo = ShortVideoBusiManager.a(3, i);
      localObject = ShortVideoBusiManager.a(i, localObject, paramSessionInfo);
      if (localObject != null)
      {
        ((ShortVideoForwardInfo)localObject).jdField_a_of_type_Long = paramMessageForShortVideo.uniseq;
        ((ShortVideoForwardInfo)localObject).p = paramMessageForShortVideo.forwardID;
        paramSessionInfo.a((ShortVideoForwardInfo)localObject);
      }
      ShortVideoBusiManager.a(paramSessionInfo, paramQQAppInterface);
      return;
      if (i == 2)
      {
        i = 3;
        break;
      }
      i = 0;
      break;
      label696:
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
      int j = MobileQQService.seq;
      MobileQQService.seq = j + 1;
      paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str2, str3, str1, i, j, paramAbsStructMsg);
      ForwardOrderManager.a().a(paramSessionInfo.uniseq, paramAbsStructMsg.parentUniseq, paramAbsStructMsg.forwardID);
      paramQQAppInterface.getMessageFacade().a(paramSessionInfo, null);
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
      Object localObject = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, i, paramLong);
      if ((localObject instanceof MessageForPtt))
      {
        localObject = (MessageForPtt)localObject;
        ((MessageForPtt)localObject).url = paramString;
        ((MessageForPtt)localObject).fileSize = paramInt;
        ((MessageForPtt)localObject).isread = false;
        ((MessageForPtt)localObject).itemType = 2;
        ((MessageForPtt)localObject).serial();
        paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, i, paramLong, ((MessageForPtt)localObject).msgData);
        paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, i, paramLong, "extStr", ((MessageForPtt)localObject).extStr);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3)
  {
    if ((paramSessionInfo == null) || (android.text.TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    a(paramQQAppInterface, paramSessionInfo, ChatActivityConstants.jdField_a_of_type_JavaLangString + "http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString3 + ")");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, AbsShareMsg paramAbsShareMsg, String paramString5, String paramString6, String paramString7)
  {
    paramString7 = new ArkAppMessage();
    if (ArkAiAppCenter.e) {}
    for (;;)
    {
      try
      {
        paramString7.appMinVersion = "1.0.0.101";
        paramString7.appName = "com.tencent.map";
        paramString7.appView = "LocationShare";
        paramString6 = ArkAppCacheMgr.getApplicationFromManifest(paramString7.appName, paramString7.appMinVersion);
        if (paramString6 != null)
        {
          paramString7.appDesc = ((String)paramString6.get("desc"));
          paramString7.appMinVersion = ((String)paramString6.get("version"));
        }
        paramString6 = HardCodeUtil.a(2131701623);
        if ((android.text.TextUtils.isEmpty(paramString7.appDesc)) || (paramString7.appDesc.equals(paramString7.appName))) {
          paramString7.appDesc = paramString6;
        }
        switch (paramSessionInfo.jdField_a_of_type_Int)
        {
        case 1000: 
          paramString6 = paramQQAppInterface.getCurrentAccountUin();
          String str1 = paramQQAppInterface.getCurrentAccountUin();
          String str2 = paramSessionInfo.jdField_a_of_type_JavaLangString;
          int i = paramSessionInfo.jdField_a_of_type_Int;
          int j = MobileQQService.seq;
          MobileQQService.seq = j + 1;
          paramString7.containStructMsg = MessageRecordFactory.a(paramQQAppInterface, str1, str2, paramString6, i, j, paramAbsShareMsg);
          paramString7.promptText = String.format(HardCodeUtil.a(2131701636), new Object[] { paramString7.appDesc });
          paramString7.from = 1;
          paramString7.metaList = a(paramString5, paramString3, paramString4, paramString1, paramString2);
          paramString1 = new JSONObject();
          paramString1.put("forward", 1);
          paramString1.put("autosize", 1);
          paramString1.put("type", "card");
          paramString7.config = paramString1.toString();
          a(paramQQAppInterface, paramSessionInfo, paramString7, paramAbsShareMsg.forwardID);
          ArkAppCenter.c("sendArkStructMap", "send ark msg is success and arkMsg.metaList=" + paramString7.metaList);
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
        ArkAppCenter.c("sendArkStructMap", "parameter error and send ark msg is failed then send struct msg");
        a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
        return;
      }
      paramString6 = paramSessionInfo.jdField_b_of_type_JavaLangString;
      continue;
      ArkAppCenter.c("sendArkStructMap", "sIsArkStructMap is false then send struct msg");
      a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.2(paramSessionInfo, paramQQAppInterface, paramBoolean), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface.getMessageFacade().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramChatMessage.frienduin, paramChatMessage.uniseq));
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
    EmojiManager localEmojiManager = (EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    ThreadManager.post(new ChatActivityFacade.19(paramEmoticon, (EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER), localEmojiManager), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    ((LongArkMsgManager)paramQQAppInterface.getManager(QQManagerFactory.LONG_ARK_MSG_MANAGER)).a(paramQQAppInterface, paramMessageForArkApp, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).c(Long.valueOf(paramString).longValue());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ChatActivityFacade", 2, "insertCommonHobbyIfNeeded uin is: " + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString, paramMessageForPtt, paramBoolean1, paramInt1, paramInt2, paramBoolean2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, DownCallBack paramDownCallBack)
  {
    paramString = new ChatActivityFacade.1(paramMessageForPtt, paramQQAppInterface, paramString, paramBoolean2, paramDownCallBack, paramInt1, paramInt2);
    if (paramBoolean1)
    {
      paramString.run();
      return;
    }
    paramQQAppInterface.execute(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams)
  {
    String str = "";
    if (paramString != null) {
      str = MessageUtils.a(paramString, true, null);
    }
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
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
    if (paramArrayList.size() <= 10) {}
    for (boolean bool = true;; bool = false)
    {
      localChatMessage.needUpdateMsgTag = bool;
      ((SVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localChatMessage);
      ((MessageForText)localChatMessage).msgVia = 0;
      paramQQAppInterface.getMessageFacade().a(paramQQAppInterface, localChatMessage, paramArrayList, paramHongbaoParams);
      return;
    }
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt)
  {
    if ((!AppSetting.j) && (paramInt == 0)) {}
    while (UinTypeUtil.a(paramInt) == 1032) {
      return;
    }
    paramQQCustomMenu.a(2131365636, paramContext.getString(2131690860), 2130839054);
  }
  
  public static void a(List<ChatMessage> paramList)
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
  
  private static boolean a(ChatActivityFacade.SendMsgParams paramSendMsgParams, boolean paramBoolean)
  {
    if (paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
    {
      byte[] arrayOfByte = paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.getSourceMsg();
      if ((arrayOfByte == null) || (arrayOfByte.length < 560)) {
        break label34;
      }
      paramSendMsgParams.f = true;
    }
    label34:
    do
    {
      return false;
      if ((paramBoolean) && (paramSendMsgParams.f)) {
        return true;
      }
    } while ((paramBoolean) || (paramSendMsgParams.f));
    return true;
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
          ArkAppCenter.c("sendArkStructMap", "isSendArkMsg, isArk=0 and sendStructMsg");
          return false;
        }
        if (a(paramSessionInfo))
        {
          ArkAppCenter.c("sendArkStructMap", "isSendArkMsg, session is allowed and sendArkMsg");
          return true;
        }
        ArkAppCenter.c("sendArkStructMap", "isSendArkMsg, session is not allowed and sendStructMsg");
        return false;
      }
      ArkAppCenter.c("sendArkStructMap", "isSendArkMsg, extra is empty and sendStructMsg");
      return false;
    }
    ArkAppCenter.c("sendArkStructMap", "isSendArkMsg,could not find location and sendStructMsg");
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
          ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForLongMsg.frienduin, paramMessageForLongMsg.uniseq));
        }
        paramQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramMessageForLongMsg.uniseq);
        if (paramMessageForLongMsg.msgtype == -1000)
        {
          paramMessageForLongMsg = MessageRecordFactory.a(paramMessageForLongMsg);
          paramQQAppInterface.getMessageFacade().a(paramMessageForLongMsg, null, true);
        }
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    MessageForArkApp localMessageForArkApp = MessageRecordFactory.b(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    ForwardOrderManager.a().a(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramArkAppMessage.forwardID);
    if (localMessageForArkApp.istroop == 1) {
      AnonymousChatHelper.a().a(localMessageForArkApp);
    }
    localMessageForArkApp.saveExtInfoToExtStr(MessageConstants.jdField_e_of_type_JavaLangString, "1");
    paramArkAppMessage = (ArkAppCenter)paramQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
    if ((paramArkAppMessage != null) && (localMessageForArkApp.ark_app_message != null))
    {
      paramArkAppMessage = paramArkAppMessage.a();
      if (paramArkAppMessage == null) {}
    }
    for (boolean bool = paramArkAppMessage.a(paramQQAppInterface, localMessageForArkApp.ark_app_message.appName, paramSessionInfo, localMessageForArkApp);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, new Object[] { "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(bool) });
      }
      if (!bool) {
        paramQQAppInterface.getMessageFacade().a(localMessageForArkApp, null);
      }
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage, int paramInt)
  {
    MessageForArkApp localMessageForArkApp = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    if (paramInt == 0)
    {
      paramInt = paramArkAppMessage.forwardID;
      ForwardOrderManager.a().a(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramInt);
      if (localMessageForArkApp.istroop == 1) {
        AnonymousChatHelper.a().a(localMessageForArkApp);
      }
      paramArkAppMessage = (ArkAppCenter)paramQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      if ((paramArkAppMessage == null) || (localMessageForArkApp.ark_app_message == null)) {
        break label162;
      }
      paramArkAppMessage = paramArkAppMessage.a();
      if (paramArkAppMessage == null) {
        break label162;
      }
    }
    label162:
    for (boolean bool = paramArkAppMessage.a(paramQQAppInterface, localMessageForArkApp.ark_app_message.appName, paramSessionInfo, localMessageForArkApp);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, new Object[] { "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(bool) });
      }
      if (!bool) {
        paramQQAppInterface.getMessageFacade().a(localMessageForArkApp, null);
      }
      return true;
      break;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkFlashChatMessage paramArkFlashChatMessage)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramArkFlashChatMessage, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkFlashChatMessage paramArkFlashChatMessage, int paramInt)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkFlashChatMessage);
    if (paramInt == 0) {
      paramInt = paramArkFlashChatMessage.forwardID;
    }
    for (;;)
    {
      ForwardOrderManager.a().a(paramSessionInfo.uniseq, paramArkFlashChatMessage.uniSeq, paramInt);
      if (paramSessionInfo.istroop == 1) {
        AnonymousChatHelper.a().a(paramSessionInfo);
      }
      paramQQAppInterface.getMessageFacade().a(paramSessionInfo, null);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, MessageObserver paramMessageObserver)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramHiBoomMessage, paramMessageObserver, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, MessageObserver paramMessageObserver, int paramInt)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramHiBoomMessage);
    ForwardOrderManager.a().a(paramSessionInfo.uniseq, 0L, paramInt);
    if (paramSessionInfo.istroop == 1) {
      AnonymousChatHelper.a().a(paramSessionInfo);
    }
    paramQQAppInterface.getMessageFacade().a(paramSessionInfo, paramMessageObserver);
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    return (LongTextMsgManager.a(paramQQAppInterface)) && (LongTextMsgManager.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) && ((a(paramSessionInfo, paramString) > 560) || (a(paramSendMsgParams, true)));
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForPtt))) {
      return ((MessageForPtt)paramQQAppInterface).c2cViaOffline;
    }
    return false;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramSendMsgParams == null) || (paramSessionInfo == null) || (android.text.TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      return null;
    }
    paramContext = a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList, paramSendMsgParams);
    if ((paramSendMsgParams != null) && (paramSendMsgParams.k) && (paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Int == 1))
    {
      paramString = (TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        long l = paramContext[i];
        paramString.a(paramSessionInfo.jdField_a_of_type_JavaLangString, l);
        i += 1;
      }
    }
    ThreadManager.post(new ChatActivityFacade.15(paramSendMsgParams, paramQQAppInterface, paramSessionInfo), 8, null, true);
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    }
    return paramContext;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramSessionInfo == null) || (android.text.TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramString = b(paramQQAppInterface, paramSessionInfo, paramString, null, localSendMsgParams);
      ThreadManager.post(new ChatActivityFacade.14(localSendMsgParams, paramQQAppInterface, paramSessionInfo), 8, null, true);
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramString;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow start, currenttime:" + System.currentTimeMillis());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    localObject3 = new ArrayList();
    boolean bool4 = false;
    boolean bool3 = false;
    short s2 = 0;
    Random localRandom = new Random();
    for (;;)
    {
      try
      {
        if (a(paramSendMsgParams, false))
        {
          localObject2 = b(str, paramArrayList, paramSendMsgParams, (ArrayList)localObject3);
          s1 = s2;
          bool1 = bool3;
          paramString = (String)localObject2;
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject3;
          bool2 = bool4;
          localObject1 = localObject2;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            bool2 = bool4;
            localObject1 = localObject2;
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + ((ArrayList)localObject3).size() + " mSourceMsgInfo:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject3;
            paramString = (String)localObject2;
            bool1 = bool3;
            s1 = s2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 2, currenttime:" + System.currentTimeMillis());
          }
          int j = Math.abs(localRandom.nextInt());
          localObject2 = new long[paramString.size()];
          i = 0;
          if (i >= paramString.size()) {
            continue;
          }
          localObject3 = (String)paramString.get(i);
          if (paramArrayList.size() <= i) {
            continue;
          }
          localObject1 = (ArrayList)paramArrayList.get(i);
          if ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
            j = Math.abs(localRandom.nextInt());
          }
          localObject2[i] = a(paramQQAppInterface, paramSessionInfo, (String)localObject3, -1000, bool1, (byte)paramString.size(), (byte)i, s1, j, (ArrayList)localObject1, paramSendMsgParams);
          i += 1;
          continue;
          if (!a(paramQQAppInterface, paramSessionInfo, str, paramSendMsgParams)) {
            continue;
          }
          localObject2 = a(str, paramArrayList, paramSendMsgParams, (ArrayList)localObject3);
          s1 = s2;
          bool1 = bool3;
          paramString = (String)localObject2;
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject3;
          bool2 = bool4;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          bool2 = bool4;
          localObject1 = localObject2;
          QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + ((ArrayList)localObject3).size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
          s1 = s2;
          bool1 = bool3;
          paramString = (String)localObject2;
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject3;
          continue;
          paramArrayList.printStackTrace();
        }
        catch (UnsupportedEncodingException paramArrayList)
        {
          bool1 = bool2;
          localObject2 = localObject3;
          paramString = (String)localObject1;
        }
      }
      catch (UnsupportedEncodingException paramArrayList)
      {
        short s1;
        boolean bool2;
        Object localObject1;
        paramString = null;
        boolean bool1 = false;
        Object localObject2 = localObject3;
        continue;
        continue;
        int i = 1;
        continue;
      }
      s1 = 0;
      paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject2;
      continue;
      paramString = BusinessUtils.a(str, 560, 20, paramArrayList, (ArrayList)localObject3);
      bool2 = bool4;
      localObject1 = paramString;
      if (paramString.size() > 1)
      {
        bool1 = true;
        bool2 = bool1;
        localObject1 = paramString;
        if (paramSessionInfo.jdField_a_of_type_Int == 1024) {
          continue;
        }
        bool2 = bool1;
        localObject1 = paramString;
        if (paramSessionInfo.jdField_a_of_type_Int != 1025) {
          continue;
        }
        continue;
        bool2 = bool1;
        localObject1 = paramString;
        localObject2 = AIOConfigManager.a;
        if (localObject2 != null)
        {
          bool2 = bool1;
          localObject1 = paramString;
          if (((AIOConfigData)localObject2).jdField_g_of_type_Int != 0) {
            continue;
          }
        }
        if ((!bool1) || (i != 0)) {
          continue;
        }
        bool2 = bool1;
        localObject1 = paramString;
        localObject2 = new ArrayList();
      }
      try
      {
        paramArrayList = a(str, paramArrayList, paramSendMsgParams, (ArrayList)localObject2);
        paramString = paramArrayList;
        paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject2;
        s1 = s2;
      }
      catch (UnsupportedEncodingException paramArrayList) {}
      bool1 = false;
      continue;
      i = 0;
      continue;
      bool2 = bool1;
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        bool2 = bool1;
        localObject1 = paramString;
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + ((ArrayList)localObject3).size() + " partArray.size() = " + paramString.size() + " isDivide = " + bool1 + " currenttime:" + System.currentTimeMillis());
      }
      bool2 = bool1;
      localObject1 = paramString;
      s1 = a(paramQQAppInterface, paramSessionInfo, bool1, (short)0, localRandom);
      paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject3;
      continue;
      localObject1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 3, currenttime:" + System.currentTimeMillis());
    }
    return localObject2;
  }
  
  private static long b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return 0L;
    }
    return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(a(paramQQAppInterface, paramSessionInfo, paramString), 0L);
  }
  
  public static MessageRecord b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (UinTypeUtil.b(paramSessionInfo.jdField_a_of_type_Int))
    {
      List localList = paramQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((localList != null) && (!localList.isEmpty()))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)localList.get(i);
          if (!MessageRecordInfo.b(paramSessionInfo.issend))
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
  
  private static String b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return "";
    }
    return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getString(a(paramQQAppInterface, paramSessionInfo, "key_request_troop_qcircle_msg_attache_data"), "");
  }
  
  private static ArrayList<String> b(String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams, ArrayList<ArrayList<AtTroopMemberInfo>> paramArrayList1)
  {
    paramSendMsgParams = new ArrayList();
    paramSendMsgParams.add(paramString);
    paramArrayList1.add(paramArrayList);
    return paramSendMsgParams;
  }
  
  public static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = new ChatActivityFacade.17(paramContext, paramChatMessage, paramQQAppInterface);
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
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, 1, -1, "", "", 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131692257, 0);
      return;
    }
    MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (localMessageRecord == null)
    {
      ChatActivityUtils.a(paramContext, 2131719023, 0);
      return;
    }
    paramQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(localMessageRecord);
    paramQQAppInterface.getMessageFacade().a(paramContext, null, true);
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
    ThreadManager.post(new ChatActivityFacade.4(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIONewestFeedRsp paramAIONewestFeedRsp, boolean paramBoolean)
  {
    if ((paramAIONewestFeedRsp == null) || (paramAIONewestFeedRsp.uOpuin != Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue()) || (paramAIONewestFeedRsp.uFeedInfos == null) || (paramAIONewestFeedRsp.uFeedInfos.isEmpty())) {
      if ((paramAIONewestFeedRsp != null) && (paramAIONewestFeedRsp.uOpFlag == 1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "newestFeed.uOpFlag==1  需要清理本地缓存");
        }
        l(paramQQAppInterface, paramSessionInfo);
      }
    }
    Object localObject;
    label192:
    long[] arrayOfLong;
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage 没有拉去到feeds信息");
      return;
      String str1;
      if ((paramAIONewestFeedRsp.mapEx != null) && (paramAIONewestFeedRsp.mapEx.containsKey("iGender"))) {
        str1 = (String)paramAIONewestFeedRsp.mapEx.get("iGender");
      }
      int i;
      for (;;)
      {
        try
        {
          i = Integer.parseInt(str1);
          localObject = (NewestFeedInfo)paramAIONewestFeedRsp.uFeedInfos.get(0);
          if (localObject != null) {
            break label192;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage feedInfo == null");
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ChatActivityFacade.QZoneFeeds", 1, "gender parse error:", localException);
        }
        i = 1;
      }
      paramAIONewestFeedRsp = new boolean[1];
      arrayOfLong = new long[1];
      String str2 = String.valueOf(((NewestFeedInfo)localObject).uHostUin);
      if (FeedsManager.isShowStatus(str2))
      {
        arrayOfLong[0] = FeedsManager.getToken(str2);
        paramAIONewestFeedRsp[0] = 1;
        FeedsManager.hideStatus(str2);
      }
      localObject = a((NewestFeedInfo)localObject, paramBoolean, i);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, "jsonOb == null");
    return;
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.7(paramQQAppInterface, paramSessionInfo, (JSONObject)localObject, paramBoolean, paramAIONewestFeedRsp, arrayOfLong));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, CLIENT.StGetUserNewestStoryRsp paramStGetUserNewestStoryRsp)
  {
    if (paramStGetUserNewestStoryRsp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, " rsp is null");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, " hasNewStory:" + paramStGetUserNewestStoryRsp.hasNewStory.get());
        }
      } while (paramStGetUserNewestStoryRsp.hasNewStory.get() != 1);
      if (paramStGetUserNewestStoryRsp.vecStoryFeed.isEmpty()) {
        break label144;
      }
      paramStGetUserNewestStoryRsp = (META.StStoryFeed)paramStGetUserNewestStoryRsp.vecStoryFeed.get(0);
      if (paramStGetUserNewestStoryRsp != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "addQzoneStoryFeedMessage storyFeed == null");
    return;
    a(paramQQAppInterface, paramSessionInfo, paramStGetUserNewestStoryRsp.createTime.get());
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.9(paramQQAppInterface, paramSessionInfo, paramStGetUserNewestStoryRsp));
    return;
    label144:
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.10(paramQQAppInterface, paramSessionInfo));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, FeedCloudRead.StGetC2CFeedRsp paramStGetC2CFeedRsp, boolean paramBoolean)
  {
    if ((paramStGetC2CFeedRsp == null) || (paramStGetC2CFeedRsp.vecFeed.isEmpty())) {
      QLog.i("ChatActivityFacade.QCircleFeeds", 2, "addQCircleFeedMessageV2 没有拉到feeds信息");
    }
    do
    {
      FeedCloudMeta.StFeed localStFeed;
      do
      {
        return;
        localStFeed = (FeedCloudMeta.StFeed)paramStGetC2CFeedRsp.vecFeed.get().get(0);
        if (localStFeed != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ChatActivityFacade.QCircleFeeds", 2, "addQCircleFeedMessageV2 feed == null");
      return;
      paramStGetC2CFeedRsp = a(localStFeed, paramBoolean, paramStGetC2CFeedRsp.share);
      if (paramStGetC2CFeedRsp != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QCircleFeeds", 2, "jsonOb == null");
    return;
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.8(paramQQAppInterface, paramSessionInfo, paramStGetC2CFeedRsp, paramBoolean));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (!QzoneConfig.isQQCircleShowAIOFeedEntrance())
    {
      QLog.e("ChatActivityFacade.QCircleFeeds", 2, "insertQCircleNewestFeedIfNeeded: QzoneConfig.isQQCircleShowLebaEntrance()==false");
      return;
    }
    if (paramSessionInfo.jdField_a_of_type_Int != 0)
    {
      QLog.e("ChatActivityFacade.QCircleFeeds", 2, "insertQCircleNewestFeedIfNeeded failed: sessionInfo.curType == AppConstants.VALUE.UIN_TYPE_FRIEND");
      return;
    }
    ThreadManager.post(new ChatActivityFacade.3(paramQQAppInterface, paramSessionInfo, paramBoolean), 5, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
      if ((localFileManagerEntity == null) && (QLog.isColorLevel())) {
        QLog.w("ChatActivityFacade", 2, "why FileManagerEntity is null?! may be is old data!");
      }
      if (paramChatMessage.isSendFromLocal()) {
        ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramChatMessage.frienduin, paramChatMessage.uniseq));
      }
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.getCloudType() != 0) {
          break label143;
        }
        paramQQAppInterface.getOnlineFileSessionCenter().a(localFileManagerEntity.nSessionId);
        paramQQAppInterface.getFileManagerDataCenter().b(localFileManagerEntity);
        if (localFileManagerEntity.getCloudType() == 0) {
          paramQQAppInterface.getOnlineFileSessionCenter().d(localFileManagerEntity.nSessionId);
        }
        paramQQAppInterface.getFileManagerEngine().b(localFileManagerEntity.nSessionId);
      }
    }
    label143:
    do
    {
      return;
      paramQQAppInterface.getFileManagerRSCenter().a(localFileManagerEntity.nSessionId);
      break;
      if ((paramChatMessage instanceof MessageForDevShortVideo))
      {
        ((DeviceFileHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(0, ((MessageForDevShortVideo)paramChatMessage).fileSessionId, false);
        return;
      }
    } while (!(paramChatMessage instanceof MessageForDevPtt));
    ((DeviceFileHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(0, ((MessageForDevPtt)paramChatMessage).fileSessionId, false);
  }
  
  public static void b(List<ChatMessage> paramList)
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
  
  private static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (FeedsManager.isShowStatus(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      k(paramQQAppInterface, paramSessionInfo);
      j(paramQQAppInterface, paramSessionInfo);
      return true;
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramArkAppMessage, 0);
  }
  
  @TargetApi(9)
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return false;
    }
    EmoticonPackage localEmoticonPackage = ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramString);
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
  
  public static long[] b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow start, currenttime:" + System.currentTimeMillis());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    localObject3 = new ArrayList();
    boolean bool4 = false;
    boolean bool3 = false;
    short s2 = 0;
    Random localRandom = new Random();
    for (;;)
    {
      try
      {
        if (a(paramSendMsgParams, false))
        {
          localObject2 = b(str, paramArrayList, paramSendMsgParams, (ArrayList)localObject3);
          s1 = s2;
          bool1 = bool3;
          paramString = (String)localObject2;
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject3;
          bool2 = bool4;
          localObject1 = localObject2;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            bool2 = bool4;
            localObject1 = localObject2;
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + ((ArrayList)localObject3).size() + " mSourceMsgInfo:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject3;
            paramString = (String)localObject2;
            bool1 = bool3;
            s1 = s2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 2, currenttime:" + System.currentTimeMillis());
          }
          int j = Math.abs(localRandom.nextInt());
          localObject2 = new long[paramString.size()];
          int i = 0;
          if (i >= paramString.size()) {
            continue;
          }
          localObject3 = (String)paramString.get(i);
          if (paramArrayList.size() <= i) {
            continue;
          }
          localObject1 = (ArrayList)paramArrayList.get(i);
          if ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
            j = Math.abs(localRandom.nextInt());
          }
          localObject2[i] = a(paramQQAppInterface, paramSessionInfo, (String)localObject3, -1000, bool1, (byte)paramString.size(), (byte)i, s1, j, (ArrayList)localObject1, paramSendMsgParams, true);
          i += 1;
          continue;
          if (!a(paramQQAppInterface, paramSessionInfo, str, paramSendMsgParams)) {
            continue;
          }
          localObject2 = a(str, paramArrayList, paramSendMsgParams, (ArrayList)localObject3);
          s1 = s2;
          bool1 = bool3;
          paramString = (String)localObject2;
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject3;
          bool2 = bool4;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          bool2 = bool4;
          localObject1 = localObject2;
          QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + ((ArrayList)localObject3).size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
          s1 = s2;
          bool1 = bool3;
          paramString = (String)localObject2;
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject3;
          continue;
          paramArrayList.printStackTrace();
        }
        catch (UnsupportedEncodingException paramArrayList)
        {
          bool1 = bool2;
          localObject2 = localObject3;
          paramString = (String)localObject1;
        }
      }
      catch (UnsupportedEncodingException paramArrayList)
      {
        short s1;
        boolean bool2;
        Object localObject1;
        paramString = null;
        boolean bool1 = false;
        Object localObject2 = localObject3;
        continue;
        continue;
      }
      s1 = 0;
      paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject2;
      continue;
      paramString = BusinessUtils.a(str, 560, 20, paramArrayList, (ArrayList)localObject3);
      bool2 = bool4;
      localObject1 = paramString;
      if (paramString.size() > 1)
      {
        bool1 = true;
        bool2 = bool1;
        localObject1 = paramString;
        localObject2 = AIOConfigManager.a;
        if (localObject2 != null)
        {
          bool2 = bool1;
          localObject1 = paramString;
          if (((AIOConfigData)localObject2).jdField_g_of_type_Int != 0) {
            continue;
          }
        }
        if (!bool1) {
          continue;
        }
        bool2 = bool1;
        localObject1 = paramString;
        localObject2 = new ArrayList();
      }
      try
      {
        paramArrayList = a(str, paramArrayList, paramSendMsgParams, (ArrayList)localObject2);
        paramString = paramArrayList;
        paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject2;
        s1 = s2;
      }
      catch (UnsupportedEncodingException paramArrayList) {}
      bool1 = false;
      continue;
      bool2 = bool1;
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        bool2 = bool1;
        localObject1 = paramString;
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + ((ArrayList)localObject3).size() + " partArray.size() = " + paramString.size() + " isDivide = " + bool1 + " currenttime:" + System.currentTimeMillis());
      }
      bool2 = bool1;
      localObject1 = paramString;
      s1 = a(paramQQAppInterface, paramSessionInfo, bool1, (short)0, localRandom);
      paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject3;
      continue;
      localObject1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 3, currenttime:" + System.currentTimeMillis());
    }
    return localObject2;
  }
  
  private static long c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return 0L;
    }
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, "key_last_story_feed_create_time_for_aio");
    return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(paramSessionInfo, 0L);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      paramContext = MessageRecordFactory.a(paramContext);
      paramQQAppInterface.getMessageFacade().a(paramContext, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ChatActivityFacade", 2, "resendApolloMessage : mr is null.");
  }
  
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.5(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  @TargetApi(9)
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
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
      } while ((i != 0) && (i != 1) && (i != 3000) && (i != 1001) && (i != 10002) && (i != 10004) && (i != 1006) && (i != 1004) && (i != 1000) && (i != 10010) && (i != 3));
      localObject1 = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 4);
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
      FileManagerDataCenter.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -4020);
      paramQQAppInterface.getFileManagerDataCenter().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_Int, -4020, (String)localObject2);
      VasWebviewUtil.reportCommercialDrainage(paramSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_show", "", 1, 0, 0, "", String.valueOf(i), "");
      return;
      localObject2 = (IApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      if (localObject2 == null) {
        break;
      }
      ((IApolloExtensionHandler)localObject2).a(1);
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
  
  private static boolean c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
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
      l1 = b(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_feeds_time");
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
  
  private static long d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   start");
    }
    BeancurdMsg localBeancurdMsg = ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, 12);
    long l1;
    if (localBeancurdMsg != null) {
      try
      {
        l1 = new JSONObject(localBeancurdMsg.buffer).optLong("time", 0L);
        l2 = l1;
        if (l1 == 0L) {
          l2 = e(paramQQAppInterface, paramSessionInfo);
        }
        return l2;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ChatActivityFacade.QZoneFeeds", 1, "", localJSONException);
          l1 = 0L;
        }
      }
    }
    Object localObject = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MessageForQzoneFeed)((List)localObject).get(((List)localObject).size() - 1);
      if (localObject != null) {
        ((MessageForQzoneFeed)localObject).parse();
      }
    }
    for (long l2 = ((MessageForQzoneFeed)localObject).feedTime;; l2 = 0L)
    {
      l1 = l2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   没有qzone历史豆腐块,sessionInfo.curFriendUin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + ",sessionInfo.curType=" + paramSessionInfo.jdField_a_of_type_Int + " busiID=" + 2);
      l1 = l2;
      break;
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.6(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  private static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, paramString);
    paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramSessionInfo, NetConnInfoCenter.getServerTimeMillis()).apply();
  }
  
  private static boolean d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
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
      l1 = b(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_qcircle_feeds_time");
      l1 = NetConnInfoCenter.getServerTimeMillis() - l1;
      l2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "requestAIOQCircleFeedsDiv", 900000);
      if (l1 <= l2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QCircleFeeds", 2, String.format("与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    return true;
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QCircleFeeds", 2, String.format("与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    }
    return false;
  }
  
  private static boolean d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    do
    {
      return false;
      if (!QZoneHelper.hideAioFeeds()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, "wns 下发配置 要隐藏aio feeds，所以也不发请求了");
    return false;
    if (paramBoolean) {
      return c(paramQQAppInterface, paramSessionInfo);
    }
    return true;
  }
  
  private static long e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
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
  
  public static void e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-4005);
    long l = MessageCache.a();
    localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getContext().getString(2131693950), l, -4005, paramSessionInfo.jdField_a_of_type_Int, l);
    localMessageRecord.isread = true;
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageRecord, false)) {
      paramQQAppInterface.getMessageFacade().a(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  private static void e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, "key_request_troop_qcircle_msg_attache_data");
    paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putString(paramSessionInfo, paramString).apply();
  }
  
  private static boolean e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      bool = false;
    }
    long l;
    do
    {
      return bool;
      l = b(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_story_feed_time");
      l = NetConnInfoCenter.getServerTimeMillis() - l;
      if (l <= 900000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l), Long.valueOf(900000L) }));
    return true;
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l), Long.valueOf(900000L) }));
    }
    return false;
  }
  
  private static boolean e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    do
    {
      return false;
      if (!QzoneConfig.isQQCircleShowLebaEntrance(StudyModeManager.a()))
      {
        QLog.i("ChatActivityFacade.QCircleFeeds", 2, "isNeedInsertQCircleNewestFeeds==false: 非小世界灰度用户");
        return false;
      }
      if (!QZoneHelper.hideAioQCircleFeeds()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QCircleFeeds", 2, "wns 下发配置 要隐藏aio qcircle feeds，所以也不发请求了");
    return false;
    if (paramBoolean) {
      return d(paramQQAppInterface, paramSessionInfo);
    }
    return true;
  }
  
  public static void f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject1 = new EventItem(18, null);
    ((EventItem)localObject1).eventType = 538052865;
    Object localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("utf-8");
    ((EventItem)localObject1).writeTo((JceOutputStream)localObject2);
    localObject1 = new String(((JceOutputStream)localObject2).toByteArray());
    localObject2 = paramQQAppInterface.getMsgHandler();
    paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    ((MessageHandler)localObject2).a(paramSessionInfo, (String)localObject1, (byte)18, paramQQAppInterface, i, -1L);
  }
  
  private static boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    while (QZoneHelper.disableAioStoryFeedReq()) {
      return false;
    }
    if (paramBoolean) {
      return e(paramQQAppInterface, paramSessionInfo);
    }
    return true;
  }
  
  private static void i(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {
      return;
    }
    Object localObject = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
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
      paramQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      paramQQAppInterface.getMessageFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
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
      j(paramQQAppInterface, paramSessionInfo);
      return;
    }
  }
  
  private static void j(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0);
    paramQQAppInterface = a(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_feeds_time");
    localSharedPreferences.edit().remove(paramQQAppInterface).apply();
  }
  
  private static void k(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramSessionInfo = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
    if (paramSessionInfo != null)
    {
      paramSessionInfo = paramSessionInfo.iterator();
      while (paramSessionInfo.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramSessionInfo.next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.getMessageFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          SharedPreUtils.a(paramQQAppInterface.getCurrentUin(), localMessageRecord.frienduin, 0L);
        }
      }
    }
  }
  
  private static void l(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    a(12, paramQQAppInterface, paramSessionInfo);
  }
  
  private static void m(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "hasNewFlag == 1,且storyFeeds.size =0 ,视为后台让客户端，需要清理本地缓存");
    ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, 7);
    Object localObject = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2074 });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.getMessageFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
    a(paramQQAppInterface, paramSessionInfo, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade
 * JD-Core Version:    0.7.0.1
 */