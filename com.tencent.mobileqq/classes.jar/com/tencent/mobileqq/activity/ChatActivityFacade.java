package com.tencent.mobileqq.activity;

import AccostSvc.EventItem;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import NS_MOBILE_AIONewestFeed.Media_Data;
import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import NS_QQ_STORY_CLIENT.CLIENT.StGetUserNewestStoryRsp;
import NS_QQ_STORY_META.META.StStoryFeed;
import QQService.EVIPSPEC;
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
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
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
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.IMessageForApollo;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.app.VIPAioSendHandler;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.config.bean.ArkAIKeyWordConfBean;
import com.tencent.mobileqq.ark.config.config.DialogConfig;
import com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
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
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;
import com.tencent.mobileqq.managers.PasswdRedBagFoldManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.LongArkMsgManager;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileCardConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
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
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.graytips.api.IVasGrayTips;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
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
import java.util.ArrayList;
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
  public static long a = -1L;
  public static QQToast b = null;
  public static ActionSheet c = null;
  public static ChatMessage d = null;
  public static ActionSheet e = null;
  public static List<ChatMessage> f = null;
  private static ConcurrentHashMap<String, ChatActivityFacade.QZoneNewestFeedObserver> g = new ConcurrentHashMap();
  private static ChatActivityFacade.QZoneNewestAioStoryFeedObserver h = new ChatActivityFacade.QZoneNewestAioStoryFeedObserver();
  
  private static int a(BaseSessionInfo paramBaseSessionInfo, int paramInt, FriendsManager paramFriendsManager)
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
      if (paramFriendsManager.n(paramBaseSessionInfo.b)) {
        i = 0;
      }
    }
    return i;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    return a(paramQQAppInterface, paramBaseSessionInfo, paramString, paramInt1, paramBoolean, paramByte1, paramByte2, paramShort, paramInt2, paramArrayList, paramSendMsgParams, false);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString, int paramInt1, boolean paramBoolean1, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams, boolean paramBoolean2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" createMsgQueueAndSend start, currenttime:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(" sessionInfo.entrance:");
      ((StringBuilder)localObject1).append(paramBaseSessionInfo.s);
      QLog.d("SendMsgBtn", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString != null) {
      localObject1 = MessageUtils.a(paramString, true, paramArrayList);
    } else {
      localObject1 = "";
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(" createMsgQueueAndSend step 1  currenttime:");
      paramString.append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, paramString.toString());
    }
    paramInt1 = paramBaseSessionInfo.a;
    Object localObject2 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    int k = a(paramBaseSessionInfo, paramInt1, (FriendsManager)localObject2);
    Object localObject3;
    Object localObject4;
    if (paramSendMsgParams.u != 0L)
    {
      paramString = new MessageForWantGiftMsg();
      localObject2 = (MessageForWantGiftMsg)paramString;
      ((MessageForWantGiftMsg)localObject2).wantGiftSenderUin = paramSendMsgParams.u;
      localObject3 = MessageForWantGiftMsg.GIFT_SENDER_UIN;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramSendMsgParams.u);
      ((StringBuilder)localObject4).append("");
      ((MessageForWantGiftMsg)localObject2).saveExtInfoToExtStr((String)localObject3, ((StringBuilder)localObject4).toString());
      paramString.msgtype = -2056;
    }
    else if ((paramSendMsgParams.r != null) && (PasswdRedBagFoldManager.a(paramQQAppInterface)))
    {
      paramString = new MessageForFoldMsg();
      ((MessageForFoldMsg)paramString).init(false, paramSendMsgParams.r, paramSendMsgParams.s, paramSendMsgParams.p, true);
    }
    else if ((paramSendMsgParams.h == null) && (paramSendMsgParams.v) && (LongTextMsgManager.a(paramQQAppInterface)))
    {
      paramString = (ChatMessage)MessageRecordFactory.a(-1051);
    }
    else
    {
      int i;
      if (paramSendMsgParams.h != null) {
        i = -1049;
      } else {
        i = -1000;
      }
      paramString = (ChatMessage)MessageRecordFactory.a(i);
      localObject3 = ((FriendsManager)localObject2).d(paramQQAppInterface.getCurrentUin(), false);
      if (localObject3 != null)
      {
        localObject4 = (IFontManagerService)paramQQAppInterface.getRuntimeService(IFontManagerService.class, "");
        paramString.saveExtInfoToExtStr("vip_font_id", String.valueOf(FontManagerConstants.generateFontValue((ExtensionInfo)localObject3)));
        paramString.saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(((IFontManagerService)localObject4).getVariedStyleIndex(((ExtensionInfo)localObject3).uVipFont)));
        if (1 == ((ExtensionInfo)localObject3).magicFont) {
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
        } else {
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(((ExtensionInfo)localObject3).fontEffect));
        }
      }
      localObject2 = ((FriendsManager)localObject2).c(paramQQAppInterface.getCurrentAccountUin());
      if (localObject2 != null)
      {
        if (((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB))
        {
          if (((Friends)localObject2).getServiceType(EVIPSPEC.E_SP_BIGCLUB) == 1) {
            paramInt1 = 3;
          } else {
            paramInt1 = 1;
          }
          paramString.saveExtInfoToExtStr("bigClub_type", String.valueOf(paramInt1));
          paramString.saveExtInfoToExtStr("bigClub_level", String.valueOf(((Friends)localObject2).getServiceLevel(EVIPSPEC.E_SP_BIGCLUB)));
          paramString.saveExtInfoToExtStr("vip_card_id", String.valueOf(((Friends)localObject2).bigClubTemplateId));
          paramString.saveExtInfoToExtStr("vip_ext_card_id", String.valueOf(((Friends)localObject2).bigClubExtTemplateId));
        }
        if ((((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) || (((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)))
        {
          int j;
          if (((Friends)localObject2).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
          {
            paramInt1 = 256;
            if (((Friends)localObject2).getServiceType(EVIPSPEC.E_SP_SUPERVIP) == 1) {
              paramInt1 = 258;
            }
            j = ((Friends)localObject2).getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
          }
          else
          {
            if (((Friends)localObject2).getServiceType(EVIPSPEC.E_SP_QQVIP) == 1) {
              paramInt1 = 3;
            } else {
              paramInt1 = 1;
            }
            j = ((Friends)localObject2).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
          }
          paramString.saveExtInfoToExtStr("vip_type", String.valueOf(paramInt1));
          paramString.saveExtInfoToExtStr("vip_level", String.valueOf(j));
        }
        paramString.saveExtInfoToExtStr("game_card_id", String.valueOf(((Friends)localObject2).gameCardId));
        paramString.saveExtInfoToExtStr("vip_diy_font_id", String.valueOf(((Friends)localObject2).diyFontId));
      }
      if (paramArrayList != null) {
        AtTroopMemberSpan.a(k, paramArrayList, paramString);
      }
      if ((i == -1000) && (paramSendMsgParams.x)) {
        paramString.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(1));
      }
    }
    MessageRecordFactory.a(paramQQAppInterface, paramString, paramBaseSessionInfo.b, paramBaseSessionInfo.c, k);
    paramString.msg = ((String)localObject1);
    paramString.msgUid = MessageUtils.a(paramInt2);
    paramString.longMsgCount = paramByte1;
    paramString.longMsgIndex = paramByte2;
    paramString.longMsgId = paramShort;
    paramString.mAnimFlag = true;
    paramString.mNewAnimFlag = true;
    if (paramSendMsgParams.B != null)
    {
      paramString.saveExtInfoToExtStr("sticker_info", paramSendMsgParams.B.toJsonString());
      EmojiStickerManager.a(paramString, null);
      EmojiStickerManager.a().a(paramString);
    }
    if (paramSendMsgParams.y) {
      paramString.mRobotFlag = -1;
    }
    if (paramSendMsgParams.z != -1) {
      paramString.saveExtInfoToExtStr("robot_news_class_id", String.valueOf(paramSendMsgParams.z));
    }
    if ((paramString instanceof MessageForReplyText))
    {
      localObject1 = (MessageForReplyText)paramString;
      ((MessageForReplyText)localObject1).msgVia = paramBaseSessionInfo.s;
      ((MessageForReplyText)localObject1).isBarrageMsg = paramSendMsgParams.i;
      ((MessageForReplyText)localObject1).barrageTimeLocation = paramSendMsgParams.j;
      ((MessageForReplyText)localObject1).barrageSourceMsgType = paramSendMsgParams.k;
      if (((MessageForReplyText)localObject1).isBarrageMsg)
      {
        ((MessageForReplyText)localObject1).saveExtInfoToExtStr("barrage_time_location", String.valueOf(((MessageForReplyText)localObject1).barrageTimeLocation));
        ((MessageForReplyText)localObject1).saveExtInfoToExtStr("barrage_source_msg_type", String.valueOf(((MessageForReplyText)localObject1).barrageSourceMsgType));
      }
      if (paramArrayList != null) {
        ((MessageForReplyText)localObject1).atInfoList = paramArrayList;
      }
      try
      {
        paramArrayList = HexUtil.bytes2HexStr(MessagePkgUtils.a(paramSendMsgParams.h));
        ((MessageForReplyText)localObject1).mSourceMsgInfo = paramSendMsgParams.h;
        ((MessageForReplyText)localObject1).saveExtInfoToExtStr("sens_msg_source_msg_info", paramArrayList);
        ((MessageForReplyText)localObject1).extLong |= 0x1;
        if (((MessageForReplyText)localObject1).mSourceMsgInfo.getSourceMsg() != null) {
          ((MessageForReplyText)localObject1).setSourceMessageRecord(((MessageForReplyText)localObject1).mSourceMsgInfo.unPackSourceMsg(paramQQAppInterface));
        }
        if ((!android.text.TextUtils.isEmpty(paramSendMsgParams.l)) && (!android.text.TextUtils.isEmpty(paramSendMsgParams.m)))
        {
          ((MessageForReplyText)localObject1).saveExtInfoToExtStr("sens_reply_special_msg", paramSendMsgParams.l);
          ((MessageForReplyText)localObject1).saveExtInfoToExtStr("sens_reply_special_at_list", paramSendMsgParams.m);
        }
        if (paramSendMsgParams.n > 0) {
          ForwardOrderManager.a().a(paramString.uniseq, paramSendMsgParams.o, paramSendMsgParams.n);
        }
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Save sourceMsgInfo exception:");
          ((StringBuilder)localObject1).append(paramArrayList.getMessage());
          QLog.d("SendMsgBtn", 2, ((StringBuilder)localObject1).toString());
          break label1216;
        }
      }
    }
    else
    {
      localObject1 = (MessageForText)paramString;
      ((MessageForText)localObject1).msgVia = paramBaseSessionInfo.s;
      if (paramArrayList != null) {
        ((MessageForText)localObject1).atInfoList = paramArrayList;
      }
      ((MessageForText)localObject1).setSendMsgParams(paramSendMsgParams);
    }
    label1216:
    paramArrayList = "SendMsgBtn";
    if (paramString.istroop == 1) {
      AnonymousChatHelper.a().a(paramString);
    } else if (AnonymousChatHelper.a().j) {
      AnonymousChatHelper.a().j = false;
    }
    if (paramSendMsgParams.b) {
      DatingUtil.b(paramString);
    }
    if ((paramString.istroop != 1033) && (paramString.istroop != 1034))
    {
      if (paramBaseSessionInfo.x) {
        ConfessMsgUtil.a(paramQQAppInterface, paramString, paramBaseSessionInfo.b);
      } else if (paramBaseSessionInfo.y) {
        ConfessMsgUtil.b(paramQQAppInterface, paramString, paramBaseSessionInfo.b);
      }
    }
    else {
      ConfessMsgUtil.a(paramQQAppInterface, paramString, paramString.frienduin, paramString.istroop, paramBaseSessionInfo.v);
    }
    if (k == 10007) {
      RoleIdUtil.a(paramQQAppInterface, paramString, paramString.frienduin, paramString.istroop);
    }
    if (QLog.isColorLevel())
    {
      paramBaseSessionInfo = new StringBuilder();
      paramBaseSessionInfo.append(" createMsgQueueAndSend step 2 time = ");
      paramBaseSessionInfo.append(paramString.time);
      paramBaseSessionInfo.append(" senderUin = ");
      paramBaseSessionInfo.append(paramString.senderuin);
      paramBaseSessionInfo.append(" msgUid = ");
      paramBaseSessionInfo.append(paramString.msgUid);
      QLog.d(paramArrayList, 2, paramBaseSessionInfo.toString());
    }
    a(paramQQAppInterface, paramBoolean2, paramString, paramSendMsgParams);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(" createMsgQueueAndSend end, currenttime:");
      paramQQAppInterface.append(System.currentTimeMillis());
      QLog.d(paramArrayList, 2, paramQQAppInterface.toString());
    }
    return paramString.uniseq;
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList<String> paramArrayList)
  {
    paramArrayList = StructMsgHelper.a(paramArrayList);
    long l1;
    if (paramArrayList != null)
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      int i = MobileQQService.seq;
      MobileQQService.seq = i + 1;
      l1 = i;
      paramSessionInfo = MessageRecordFactory.c(paramQQAppInterface, str, paramSessionInfo.b, str, paramSessionInfo.a, l1, paramArrayList);
      long l2 = paramSessionInfo.uniseq;
      paramSessionInfo.msgUid = MessageUtils.a(paramInt);
      l1 = l2;
      if (!MessageHandlerUtils.a(paramQQAppInterface, paramSessionInfo, false))
      {
        paramQQAppInterface.getMessageFacade().a(paramSessionInfo);
        return l2;
      }
    }
    else
    {
      l1 = -1L;
    }
    return l1;
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
      ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramString3);
      paramQQAppInterface.getMessageFacade().a(paramString3, paramQQAppInterface.getCurrentAccountUin());
      return paramString3.uniseq;
    }
    return 0L;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    MessageForPic localMessageForPic = null;
    if (paramSessionInfo == null) {
      return null;
    }
    if (paramString != null)
    {
      localMessageForPic = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a);
      localMessageForPic.path = paramString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.serial();
    }
    return localMessageForPic;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" createMsgQueueAndSend start, currenttime:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(" sessionInfo.entrance:");
      ((StringBuilder)localObject1).append(paramSessionInfo.s);
      QLog.d("SendMsgBtn", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString != null) {
      localObject1 = MessageUtils.a(paramString, true, paramArrayList);
    } else {
      localObject1 = "";
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(" createMsgQueueAndSend step 1  currenttime:");
      paramString.append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, paramString.toString());
    }
    Object localObject2;
    Object localObject3;
    if (paramSendMsgParams.u != 0L)
    {
      paramString = new MessageForWantGiftMsg();
      localObject2 = (MessageForWantGiftMsg)paramString;
      ((MessageForWantGiftMsg)localObject2).wantGiftSenderUin = paramSendMsgParams.u;
      localObject3 = MessageForWantGiftMsg.GIFT_SENDER_UIN;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramSendMsgParams.u);
      localStringBuilder.append("");
      ((MessageForWantGiftMsg)localObject2).saveExtInfoToExtStr((String)localObject3, localStringBuilder.toString());
      paramString.msgtype = -2056;
    }
    else if ((paramSendMsgParams.r != null) && (PasswdRedBagFoldManager.a(paramQQAppInterface)))
    {
      paramString = new MessageForFoldMsg();
      ((MessageForFoldMsg)paramString).init(false, paramSendMsgParams.r, paramSendMsgParams.s, paramSendMsgParams.p, true);
    }
    else if ((paramSendMsgParams.h == null) && (paramSendMsgParams.v) && (LongTextMsgManager.a(paramQQAppInterface)))
    {
      paramString = (ChatMessage)MessageRecordFactory.a(-1051);
    }
    else
    {
      if (paramSendMsgParams.h != null) {
        paramInt1 = -1049;
      } else {
        paramInt1 = -1000;
      }
      paramString = (ChatMessage)MessageRecordFactory.a(paramInt1);
      localObject2 = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(paramQQAppInterface.getCurrentUin(), false);
      if (localObject2 != null)
      {
        localObject3 = (IFontManagerService)paramQQAppInterface.getRuntimeService(IFontManagerService.class, "");
        paramString.saveExtInfoToExtStr("vip_font_id", String.valueOf(FontManagerConstants.generateFontValue((ExtensionInfo)localObject2)));
        paramString.saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(((IFontManagerService)localObject3).getVariedStyleIndex(((ExtensionInfo)localObject2).uVipFont)));
        if (1 == ((ExtensionInfo)localObject2).magicFont) {
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
        } else {
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(((ExtensionInfo)localObject2).fontEffect));
        }
      }
      if (paramArrayList != null) {
        AtTroopMemberSpan.a(paramSessionInfo.a, paramArrayList, paramString);
      }
      if ((paramInt1 == -1000) && (paramSendMsgParams.x)) {
        paramString.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(1));
      }
    }
    MessageRecordFactory.a(paramQQAppInterface, paramString, paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a);
    paramString.msg = ((String)localObject1);
    paramString.msgUid = MessageUtils.a(paramInt2);
    paramString.longMsgCount = paramByte1;
    paramString.longMsgIndex = paramByte2;
    paramString.longMsgId = paramShort;
    paramString.mAnimFlag = true;
    paramString.mNewAnimFlag = true;
    if (paramSendMsgParams.y) {
      paramString.mRobotFlag = -1;
    }
    paramString.saveExtInfoToExtStr("robot_news_class_id", String.valueOf(paramSendMsgParams.z));
    if ((paramString instanceof MessageForReplyText))
    {
      paramQQAppInterface = (MessageForReplyText)paramString;
      paramQQAppInterface.msgVia = paramSessionInfo.s;
      if (paramArrayList != null) {
        paramQQAppInterface.atInfoList = paramArrayList;
      }
      try
      {
        paramQQAppInterface.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.a(paramSendMsgParams.h)));
        if ((!android.text.TextUtils.isEmpty(paramSendMsgParams.l)) && (!android.text.TextUtils.isEmpty(paramSendMsgParams.m)))
        {
          paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_msg", paramSendMsgParams.l);
          paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_at_list", paramSendMsgParams.m);
        }
        paramQQAppInterface.mSourceMsgInfo = paramSendMsgParams.h;
        paramQQAppInterface.extLong |= 0x1;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label752;
        }
      }
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("Save sourceMsgInfo exception:");
      paramSessionInfo.append(paramQQAppInterface.getMessage());
      QLog.d("SendMsgBtn", 2, paramSessionInfo.toString());
    }
    else
    {
      paramQQAppInterface = (MessageForText)paramString;
      paramQQAppInterface.msgVia = paramSessionInfo.s;
      if (paramArrayList != null) {
        paramQQAppInterface.atInfoList = paramArrayList;
      }
      paramQQAppInterface.setSendMsgParams(paramSendMsgParams);
    }
    label752:
    if (paramString.istroop == 1) {
      AnonymousChatHelper.a().a(paramString);
    } else if (AnonymousChatHelper.a().j) {
      AnonymousChatHelper.a().j = false;
    }
    if (paramSendMsgParams.b) {
      DatingUtil.b(paramString);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(" createMsgQueueAndSend step 2 time = ");
      paramQQAppInterface.append(paramString.time);
      paramQQAppInterface.append(" senderUin = ");
      paramQQAppInterface.append(paramString.senderuin);
      paramQQAppInterface.append(" msgUid = ");
      paramQQAppInterface.append(paramString.msgUid);
      QLog.d("SendMsgBtn", 2, paramQQAppInterface.toString());
    }
    return paramString;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" createTextMessage start, currenttime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, ((StringBuilder)localObject).toString());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    paramString = new ArrayList();
    Object localObject = new ArrayList();
    Random localRandom = new Random();
    ((ArrayList)localObject).add(str);
    paramString.add(paramArrayList);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append(" createTextMessage step 2, currenttime:");
      paramArrayList.append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, paramArrayList.toString());
    }
    int i = Math.abs(localRandom.nextInt());
    paramArrayList = (String)((ArrayList)localObject).get(0);
    if (paramString.size() > 0) {
      paramString = (ArrayList)paramString.get(0);
    } else {
      paramString = null;
    }
    if ((paramSessionInfo.a == 3000) || (paramSessionInfo.a == 1)) {
      i = Math.abs(localRandom.nextInt());
    }
    return a(paramQQAppInterface, paramSessionInfo, paramArrayList, -1000, false, (byte)((ArrayList)localObject).size(), (byte)0, (short)0, i, paramString, paramSendMsgParams);
  }
  
  public static MessageForPtt a(QQAppInterface paramQQAppInterface, String paramString, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2)
  {
    if ((!android.text.TextUtils.isEmpty(paramString)) && (paramBaseSessionInfo != null))
    {
      int i = paramBaseSessionInfo.a;
      MessageForPtt localMessageForPtt = MessageRecordFactory.e(paramQQAppInterface, paramBaseSessionInfo.b, paramBaseSessionInfo.c, i);
      localMessageForPtt.url = MessageForPtt.getMsgFilePath(paramInt2, paramString);
      localMessageForPtt.fileSize = paramInt1;
      localMessageForPtt.itemType = 2;
      if ((((ISttManagerApi)QRoute.api(ISttManagerApi.class)).isSttSession(i)) && (((ISttManagerApi)QRoute.api(ISttManagerApi.class)).getSttAbility(paramQQAppInterface))) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      localMessageForPtt.sttAbility = paramInt1;
      localMessageForPtt.voiceType = paramInt2;
      localMessageForPtt.longPttVipFlag = VipUtils.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
      AnonymousChatHelper.a().a(localMessageForPtt);
      if ((paramBaseSessionInfo.a != 1033) && ((paramBaseSessionInfo.a != 1034) || (paramBaseSessionInfo.v <= 0)))
      {
        if (paramBaseSessionInfo.x) {
          ConfessMsgUtil.a(paramQQAppInterface, localMessageForPtt, paramBaseSessionInfo.b);
        } else if (paramBaseSessionInfo.y) {
          ConfessMsgUtil.b(paramQQAppInterface, localMessageForPtt, paramBaseSessionInfo.b);
        }
      }
      else {
        ConfessMsgUtil.a(paramQQAppInterface, localMessageForPtt, paramBaseSessionInfo.b, paramBaseSessionInfo.a, paramBaseSessionInfo.v);
      }
      localMessageForPtt.serial();
      ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageForPtt);
      return localMessageForPtt;
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPtt paramMessageForPtt)
  {
    if ((paramSessionInfo != null) && (paramMessageForPtt != null))
    {
      paramSessionInfo = MessageRecordFactory.a(paramMessageForPtt);
      ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramSessionInfo);
      paramQQAppInterface.getMessageFacade().a(paramSessionInfo, paramQQAppInterface.getCurrentAccountUin());
      return paramSessionInfo;
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    paramString = a(paramQQAppInterface, paramString, paramSessionInfo, paramInt1, paramInt2);
    if (paramString != null)
    {
      paramString.msgVia = paramSessionInfo.s;
      paramQQAppInterface.getMessageFacade().a(paramString, paramQQAppInterface.getCurrentAccountUin());
      return paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "createPttMessage null");
    }
    return paramString;
  }
  
  public static AbsShareMsg a(Context paramContext, String paramString, List<ChatMessage> paramList, Map<String, String> paramMap, boolean paramBoolean)
  {
    Object localObject1 = null;
    paramString = (String)localObject1;
    if (paramList != null)
    {
      paramString = (String)localObject1;
      if (paramList.size() != 0)
      {
        if (paramMap == null) {
          return null;
        }
        ArrayList localArrayList = new ArrayList();
        int j;
        if (paramList.size() >= 4) {
          j = 4;
        } else {
          j = paramList.size();
        }
        String str = "";
        Object localObject2 = "";
        int k = 0;
        int i = 4;
        Object localObject3;
        while ((k < j) && (i > 0))
        {
          localObject3 = new StringBuilder();
          localObject4 = (ChatMessage)paramList.get(k);
          if (paramBoolean)
          {
            localObject1 = (String)paramMap.get(MsgProxyUtils.d((MessageRecord)localObject4));
            paramString = (String)localObject1;
            if (((ChatMessage)localObject4).istroop == 1) {
              paramString = com.tencent.mobileqq.text.TextUtils.removeColorNickCode((String)localObject1);
            }
          }
          else
          {
            paramString = new ArrayList(paramMap.values());
            if (!paramString.isEmpty()) {
              paramString = (String)paramString.get(0);
            } else {
              paramString = "";
            }
          }
          if ((!android.text.TextUtils.isEmpty(paramString)) && (paramString.trim().length() != 0))
          {
            localObject1 = paramString;
            if (paramString.length() > 12)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramString.substring(0, 11));
              ((StringBuilder)localObject1).append("...");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
          else
          {
            localObject1 = MultiMsgUtil.b(((ChatMessage)localObject4).senderuin);
          }
          if ((localObject4 instanceof MessageForPic)) {
            paramString = ((ChatMessage)localObject4).getSummaryMsg();
          }
          for (;;)
          {
            localObject2 = paramString;
            break;
            if ((localObject4 instanceof MessageForShortVideo))
            {
              if (((ChatMessage)localObject4).msgtype == -2071) {
                paramString = HardCodeUtil.a(2131899788);
              } else {
                paramString = HardCodeUtil.a(2131899797);
              }
            }
            else if ((localObject4 instanceof MessageForText))
            {
              paramString = (MessageForText)localObject4;
              if (paramString.sb != null) {
                localObject2 = paramString.sb.toString();
              } else {
                localObject2 = paramString.msg;
              }
              paramString = (String)localObject2;
              if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion((String)localObject2)) {
                paramString = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol((String)localObject2);
              }
            }
            else if ((localObject4 instanceof MessageForQQStoryComment))
            {
              paramString = ((MessageForQQStoryComment)localObject4).comment;
            }
            else if ((!(localObject4 instanceof MessageForMixedMsg)) && (!(localObject4 instanceof MessageForLongMsg)))
            {
              if ((localObject4 instanceof MessageForStructing))
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
              else if ((localObject4 instanceof MessageForFile))
              {
                paramString = (MessageForFile)localObject4;
                if (!paramString.hasFileName())
                {
                  localObject2 = FileManagerUtil.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString);
                  if ((((FileManagerEntity)localObject2).nFileType == 5) && (!android.text.TextUtils.isEmpty(((FileManagerEntity)localObject2).strApkPackageName))) {
                    paramString.fileName = ((FileManagerEntity)localObject2).strApkPackageName;
                  } else {
                    paramString.fileName = ((FileManagerEntity)localObject2).fileName;
                  }
                }
                paramString = paramString.getSummaryMsg();
              }
              else if ((localObject4 instanceof MessageForDLFile))
              {
                paramString = ((MessageForDLFile)localObject4).getSummaryMsg();
              }
              else if ((localObject4 instanceof MessageForTroopFile))
              {
                paramString = ((MessageForTroopFile)localObject4).getSummaryMsg();
              }
              else
              {
                if (!(localObject4 instanceof MessageForPtt)) {
                  break;
                }
                paramString = HardCodeUtil.a(2131899805);
              }
            }
            else
            {
              paramString = MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject4).toString();
            }
          }
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(":  ");
          ((StringBuilder)localObject3).append((String)localObject2);
          paramString = new boolean[1];
          localArrayList.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 3, 46, ((StringBuilder)localObject3).toString(), paramString).toString()));
          int m = i - 1;
          i = m;
          if (paramString[0] != 0) {
            i = m - 1;
          }
          k += 1;
        }
        paramString = paramContext.getString(2131887723);
        localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(35).a(HardCodeUtil.a(2131899804)).a(3).a("viewMultiMsg", "", null, null, null).a(paramString, null).a();
        Object localObject4 = new StructMsgItemLayout1();
        ChatMessage localChatMessage1 = (ChatMessage)paramList.get(0);
        if ((localChatMessage1.istroop != 1) && (localChatMessage1.istroop != 3000))
        {
          if (localChatMessage1.istroop == 0)
          {
            paramString = localChatMessage1.senderuin;
            if (android.text.TextUtils.equals(localChatMessage1.senderuin, localChatMessage1.selfuin)) {
              localObject1 = localChatMessage1.frienduin;
            } else {
              localObject1 = localChatMessage1.selfuin;
            }
            localObject3 = (String)paramMap.get(paramString);
            str = (String)paramMap.get(localObject1);
            paramString = "";
            i = 0;
            while (i < paramList.size())
            {
              ChatMessage localChatMessage2 = (ChatMessage)paramList.get(i);
              if (android.text.TextUtils.isEmpty(paramString))
              {
                paramString = localChatMessage2.senderuin;
              }
              else if (!android.text.TextUtils.equals(paramString, localChatMessage2.senderuin))
              {
                paramBoolean = false;
                break label1041;
              }
              i += 1;
            }
            paramBoolean = true;
            label1041:
            if (localObject3 != null)
            {
              paramString = (String)localObject3;
              if (((String)localObject3).trim().length() != 0) {}
            }
            else
            {
              QLog.d("MultiMsg_TAG", 2, "firstNick is null !!!");
              paramString = MultiMsgUtil.b(localChatMessage1.senderuin);
            }
            if (((str == null) || (str.trim().length() == 0)) && (!paramBoolean))
            {
              QLog.d("MultiMsg_TAG", 2, "!hasOnlyOneSender !!! empty nick for receiver");
              localObject1 = MultiMsgUtil.b((String)localObject1);
            }
            else
            {
              localObject1 = str;
            }
            if (QFileAssistantUtils.a(localChatMessage1.senderuin))
            {
              paramString = (String)paramMap.get(localChatMessage1.selfuin);
              paramBoolean = true;
            }
            paramMap = new Paint();
            paramMap.setTextSize(34.0F);
            paramContext = a(paramContext, paramString, (String)localObject1, 2, (int)(BaseChatItemLayout.f * 0.7F), 2048, paramMap, paramBoolean);
          }
          else
          {
            paramContext = str;
          }
        }
        else {
          paramContext = HardCodeUtil.a(2131899785);
        }
        paramString = paramContext;
        if (android.text.TextUtils.isEmpty(paramContext))
        {
          QLog.w("ChatActivityFacade", 1, "generateMultiMsgForwardStructMsg: titleStr is null");
          paramString = HardCodeUtil.a(2131899801);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG.Nest", 2, String.format("step.generateStructMsgContent:titleStr = %s,listSize = %d,firstMsg.istroop = %d", new Object[] { paramString, Integer.valueOf(paramList.size()), Integer.valueOf(localChatMessage1.istroop) }));
        }
        paramContext = new StructMsgItemTitle(paramString);
        paramContext.g("34");
        paramContext.h("12");
        paramContext.i("2");
        ((AbsStructMsgItem)localObject4).a(paramContext);
        paramContext = localArrayList.iterator();
        while (paramContext.hasNext())
        {
          paramString = (AbsStructMsgElement)paramContext.next();
          if ((paramString instanceof AbsStructMsgTextElement))
          {
            paramMap = (AbsStructMsgTextElement)paramString;
            paramMap.g("26");
            paramMap.f("#777777");
            paramMap.h("12");
            paramMap.i("4");
          }
          ((AbsStructMsgItem)localObject4).a(paramString);
        }
        ((AbsStructMsgItem)localObject4).a(new StructMsgItemHr());
        paramContext = new StructMsgItemSummary(String.format(HardCodeUtil.a(2131899782), new Object[] { Integer.valueOf(paramList.size()) }));
        paramContext.g("26");
        paramContext.f("#777777");
        ((AbsStructMsgItem)localObject4).a(paramContext);
        ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject4);
        ((AbsShareMsg)localObject2).mTSum = paramList.size();
        paramString = (String)localObject2;
        if (QLog.isColorLevel())
        {
          paramContext = StructMsgUtils.b(((AbsShareMsg)localObject2).getXmlBytes());
          paramString = new StringBuilder();
          paramString.append("generateStructMsgLength = ");
          if (paramContext == null) {
            i = 0;
          } else {
            i = paramContext.length;
          }
          paramString.append(i);
          QLog.d("MultiMsg_TAG", 2, paramString.toString());
          paramString = (String)localObject2;
        }
      }
    }
    return paramString;
  }
  
  public static StructMsgForGeneralShare a(Context paramContext, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord instanceof MessageForMixedMsg))
    {
      paramString = new StringBuilder();
      paramString.append(MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)paramMessageRecord));
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, 30, paramString.toString()).toString();
    }
    else
    {
      boolean bool = paramMessageRecord instanceof MessageForReplyText;
      int i = 50;
      String str;
      if (bool)
      {
        paramString = (MessageForReplyText)paramMessageRecord;
        if (paramString.sb != null) {
          paramString = paramString.sb.toString();
        } else {
          paramString = paramString.msg;
        }
        str = paramString;
        if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramString)) {
          str = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(paramString);
        }
        if (!AnonymousChatHelper.c(paramMessageRecord)) {
          i = 60;
        }
        paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, i, str).toString();
      }
      else
      {
        paramString = (MessageForLongTextMsg)paramMessageRecord;
        if (paramString.sb != null) {
          paramString = paramString.sb.toString();
        } else {
          paramString = paramString.msg;
        }
        str = paramString;
        if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramString)) {
          str = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(paramString);
        }
        if (!AnonymousChatHelper.c(paramMessageRecord)) {
          i = 60;
        }
        paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, i, str).toString();
      }
    }
    localArrayList.add(new StructMsgItemTitle(paramMessageRecord));
    paramString = paramMessageRecord;
    if (paramMessageRecord.length() > 30) {
      paramString = paramMessageRecord.substring(0, 30);
    }
    paramMessageRecord = paramContext.getString(2131887723);
    paramContext = (StructMsgForGeneralShare)new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(35).a(paramString).a(3).a("viewMultiMsg", "", null, null, null).a(paramMessageRecord, null).d(paramContext.getResources().getString(2131892024)).a();
    paramMessageRecord = new StructMsgItemLayout1(localArrayList);
    paramMessageRecord.a(new StructMsgItemHr());
    paramMessageRecord.a(new StructMsgItemSummary(HardCodeUtil.a(2131899784)));
    paramContext.addItem(paramMessageRecord);
    return paramContext;
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
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (i >= k) {
        break;
      }
      j = i + 1;
      float f1 = Layout.getDesiredWidth(paramCharSequence, 0, j, localTextPaint);
      if ((f1 > paramInt1) && (paramArrayOfBoolean != null) && (paramArrayOfBoolean.length > 0)) {
        paramArrayOfBoolean[0] = true;
      }
      if (f1 > paramInt2 * paramInt1)
      {
        j = i - 1;
        break;
      }
    }
    if ((j >= k) && (j <= paramInt3)) {
      return paramCharSequence;
    }
    if (j <= paramInt3) {
      paramInt3 = j;
    }
    paramContext = new StringBuilder();
    paramContext.append(paramCharSequence.subSequence(0, paramInt3).toString());
    paramContext.append("…");
    return paramContext.toString();
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("adjustTitleByNick() called with: firstNick = [");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], secondNick = [");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("]");
      QLog.d("ChatActivityFacade", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = android.text.TextUtils.isEmpty(paramString1);
    Object localObject = "";
    if (bool) {
      return "";
    }
    if (android.text.TextUtils.isEmpty(paramString2)) {
      paramString2 = (String)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131899790));
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131899783));
    localObject = ((StringBuilder)localObject).toString();
    if (paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899807));
      localObject = ((StringBuilder)localObject).toString();
    }
    TextView localTextView = new TextView(paramContext);
    localTextView.getPaint().set(paramPaint);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, -2));
    localTextView.setText((CharSequence)localObject);
    int i = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
    int j = View.MeasureSpec.makeMeasureSpec(paramInt3, -2147483648);
    localTextView.measure(i, j);
    if (localTextView.getLineCount() > paramInt1)
    {
      paramPaint = null;
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 <= paramString1.length()) {
          paramInt3 = paramInt2;
        } else {
          paramInt3 = paramString1.length();
        }
        localObject = paramString1.substring(0, paramInt3);
        if (paramInt2 <= paramString2.length()) {
          paramInt3 = paramInt2;
        } else {
          paramInt3 = paramString2.length();
        }
        String str = paramString2.substring(0, paramInt3);
        if (paramBoolean)
        {
          paramContext = new StringBuilder();
          paramContext.append((String)localObject);
          paramContext.append(HardCodeUtil.a(2131899810));
          paramContext = paramContext.toString();
        }
        else
        {
          paramContext = (Context)localObject;
          if (paramInt2 < paramString1.length())
          {
            paramContext = new StringBuilder();
            paramContext.append((String)localObject);
            paramContext.append("...");
            paramContext = paramContext.toString();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131899798));
          paramContext = ((StringBuilder)localObject).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append(str);
          localObject = ((StringBuilder)localObject).toString();
          paramContext = (Context)localObject;
          if (paramInt2 < paramString2.length())
          {
            paramContext = new StringBuilder();
            paramContext.append((String)localObject);
            paramContext.append("...");
            paramContext = paramContext.toString();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131899806));
          paramContext = ((StringBuilder)localObject).toString();
        }
        localTextView.setText(paramContext);
        localTextView.measure(i, j);
        paramInt3 = localTextView.getLineCount();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("adjustTitleByNick() called title=[");
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append("],lineCount=[");
          ((StringBuilder)localObject).append(paramInt3);
          ((StringBuilder)localObject).append("]");
          QLog.d("ChatActivityFacade", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt3 > paramInt1) {
          return paramPaint;
        }
        paramInt2 += 1;
        paramPaint = paramContext;
      }
    }
    return localObject;
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
        while (paramArrayList.hasNext())
        {
          localObject = (AtTroopMemberInfo)paramArrayList.next();
          ((AtTroopMemberInfo)localObject).startPos = ((short)(((AtTroopMemberInfo)localObject).startPos - j));
          if (((AtTroopMemberInfo)localObject).startPos < 0)
          {
            if (QLog.isColorLevel()) {
              QLog.e("SendMsgBtn", 2, " createTextMessageToshow error, at info starts with char 0");
            }
            return null;
          }
        }
      }
      localObject = paramString.substring(j);
    }
    return localObject;
  }
  
  public static String a(List<ChatMessage> paramList, Map<String, String> paramMap)
  {
    if ((paramList != null) && (paramList.size() != 0) && (paramMap != null))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      int j = paramList.size();
      int i = 4;
      if (j < 4) {
        i = paramList.size();
      }
      j = 0;
      while (j < i)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        Object localObject2 = (ChatMessage)paramList.get(j);
        Object localObject1 = (String)paramMap.get(MsgProxyUtils.d((MessageRecord)localObject2));
        if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = " ";
        }
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = HardCodeUtil.a(2131899808);
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append((String)localObject2);
          localStringBuilder1.append(localStringBuilder2.toString());
          localStringBuilder1.append("\r\n");
        }
        else if ((localObject2 instanceof MessageForShortVideo))
        {
          localObject2 = HardCodeUtil.a(2131899796);
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append((String)localObject2);
          localStringBuilder1.append(localStringBuilder2.toString());
          localStringBuilder1.append("\r\n");
        }
        else if ((localObject2 instanceof MessageForText))
        {
          localObject2 = (MessageForText)localObject2;
          if (((MessageForText)localObject2).sb != null) {
            localObject2 = ((MessageForText)localObject2).sb.toString();
          } else {
            localObject2 = ((MessageForText)localObject2).msg;
          }
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append((String)localObject2);
          localObject2 = localStringBuilder2.toString();
          localObject1 = localObject2;
          if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion((String)localObject2)) {
            localObject1 = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol((String)localObject2);
          }
          if (((String)localObject1).length() > 16)
          {
            localStringBuilder1.append(((String)localObject1).substring(0, 16));
            localStringBuilder1.append("...");
          }
          else
          {
            localStringBuilder1.append((String)localObject1);
          }
          localStringBuilder1.append("\r\n");
        }
        else if ((!(localObject2 instanceof MessageForMixedMsg)) && (!(localObject2 instanceof MessageForLongMsg)))
        {
          if ((localObject2 instanceof MessageForStructing))
          {
            localObject2 = ((ChatMessage)localObject2).getSummaryMsg();
            localStringBuilder2.append((String)localObject1);
            localStringBuilder2.append(": ");
            localStringBuilder2.append((String)localObject2);
            if (((String)localObject2).length() > 16)
            {
              localStringBuilder1.append(((String)localObject2).substring(0, 16));
              localStringBuilder1.append("...");
            }
            else
            {
              localStringBuilder1.append((String)localObject2);
            }
            localStringBuilder1.append("\r\n");
          }
        }
        else
        {
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append(MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject2));
          localObject1 = com.tencent.mobileqq.text.TextUtils.emoticonToText(localStringBuilder2.toString());
          if (((String)localObject1).length() > 16)
          {
            localStringBuilder1.append(((String)localObject1).substring(0, 16));
            localStringBuilder1.append("...");
          }
          else
          {
            localStringBuilder1.append((String)localObject1);
          }
          localStringBuilder1.append("\r\n");
        }
        j += 1;
      }
      return localStringBuilder1.toString();
    }
    return null;
  }
  
  public static JSONObject a(NewestFeedInfo paramNewestFeedInfo, boolean paramBoolean, int paramInt)
  {
    if (paramNewestFeedInfo == null) {
      return null;
    }
    Object localObject = HardCodeUtil.a(2131899803);
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
    Object localObject1 = HardCodeUtil.a(2131899803);
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
      }
      catch (InvalidProtocolBufferMicroException paramStFeed)
      {
        paramStFeed.printStackTrace();
      }
      ((JSONObject)localObject1).put("pushCount", paramStShare.pushList.totalClickCount.get());
      return localObject1;
    }
    catch (JSONException paramStFeed) {}
    return null;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "go to dismissActionSheet()!");
    }
    ActionSheet localActionSheet1 = c;
    if ((localActionSheet1 != null) && (localActionSheet1.isShowing())) {
      try
      {
        c.dismiss();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    c = null;
    ActionSheet localActionSheet2 = e;
    if ((localActionSheet2 != null) && (localActionSheet2.isShowing())) {
      try
      {
        e.dismiss();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    e = null;
  }
  
  private static void a(int paramInt, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).c(paramSessionInfo.b, paramSessionInfo.a, paramInt);
    x(paramQQAppInterface, paramSessionInfo);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Bundle paramBundle)
  {
    String str = SubString.a(paramString4, 45, "UTF-8", "...");
    paramString4 = SubString.a(paramString5, 90, "UTF-8", "...");
    if (!paramContext.getResources().getString(2131893857).equals(str))
    {
      paramString3 = new StringBuilder();
      paramString3.append(paramContext.getResources().getString(2131888235));
      paramString3.append(" ");
      paramString3.append(str);
      paramString3 = paramString3.toString();
    }
    else
    {
      paramString3 = paramContext.getResources().getString(2131888235);
    }
    paramString5 = new StringBuilder();
    paramString5.append("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=");
    paramString5.append(paramString1);
    paramString5.append("&lon=");
    paramString5.append(paramString2);
    paramString5.append("&title=");
    paramString5.append(str);
    paramString5.append("&loc=");
    paramString5.append(paramString4);
    paramString5.append("&dpid=");
    paramString5.append(paramString6);
    paramString5 = paramString5.toString();
    paramString3 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(32).a(paramString3).d("").a("plugin", "", paramString5, "", "").a();
    paramString6 = StructMsgElementFactory.a(2);
    paramString6.a("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", str, paramString4);
    paramString3.addItem(paramString6);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSessionInfo != null)
    {
      bool1 = bool2;
      if (paramSessionInfo.a == 1008)
      {
        bool1 = bool2;
        if ((paramContext instanceof BaseActivity))
        {
          paramContext = ((BaseActivity)paramContext).getChatFragment();
          bool1 = bool2;
          if (paramContext != null)
          {
            paramContext = paramContext.k();
            bool1 = bool2;
            if (paramContext != null)
            {
              bool1 = bool2;
              if (paramContext.ah != null)
              {
                bool1 = bool2;
                if ((paramContext instanceof PublicAccountChatPie)) {
                  bool1 = ((PublicAccountChatPie)paramContext).cG;
                }
              }
            }
          }
        }
      }
    }
    if ((paramSessionInfo != null) && ((paramSessionInfo.a == 1025) || (paramSessionInfo.a == 1024) || ((paramSessionInfo.a == 0) && (BmqqSegmentUtil.c(paramSessionInfo.b))) || (bool1)))
    {
      paramContext = MessageRecordFactory.a(-1000);
      long l = MessageCache.c();
      int i = paramSessionInfo.a;
      paramString3 = new StringBuilder();
      paramString3.append(ChatActivityConstants.a);
      paramString3.append("http://maps.google.com/maps?q=");
      paramString3.append(paramString1);
      paramString3.append(",");
      paramString3.append(paramString2);
      paramString3.append("&iwloc=A&hl=zh-CN (");
      paramString3.append(paramString4);
      paramString3.append(")");
      paramString1 = paramString3.toString();
      paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.b, paramQQAppInterface.getCurrentAccountUin(), paramString1, l, -1000, i, l);
      paramContext.issend = 1;
      paramQQAppInterface.getMessageFacade().a(paramContext, null);
      return;
    }
    if (paramSessionInfo != null)
    {
      if (paramBundle != null) {
        paramString3.forwardID = paramBundle.getInt("KEY_MSG_FORWARD_ID");
      }
      if (a(paramSessionInfo, paramString4, paramBundle))
      {
        a(paramString5, paramSessionInfo, paramString1, paramString2, str, paramString4, paramString3, paramString7, paramString8, paramString9);
        a(paramQQAppInterface, paramSessionInfo, paramString1, paramString2, str, paramString4, paramString3, paramString7, paramString8, paramString9);
        return;
      }
      a(paramString5, paramSessionInfo, paramString3);
      a(paramQQAppInterface, paramSessionInfo, paramString3);
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    b(paramQQAppInterface, paramChatMessage);
    if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity)))
    {
      Object localObject = (BaseActivity)paramContext;
      if ((((BaseActivity)localObject).getChatFragment() != null) && (((BaseActivity)localObject).getChatFragment().k() != null))
      {
        ((BaseActivity)localObject).getChatFragment().k().a(paramChatMessage);
        if ((paramChatMessage instanceof MessageForArkApp)) {
          ArkTipsManager.b().a(paramChatMessage.uniseq);
        }
        if (((StructLongMessageDownloadProcessor.isPALongMsg(paramChatMessage)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(paramChatMessage))) && ((paramChatMessage instanceof MessageForStructing))) {
          StructLongMessageDownloadProcessor.deleteTask(paramQQAppInterface, ((MessageForStructing)paramChatMessage).uniseq);
        }
        if ((paramChatMessage instanceof IMessageForApollo)) {
          ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).delMsgWithNoCheck(paramContext, paramQQAppInterface, paramChatMessage);
        }
        if ((paramChatMessage instanceof MessageForFile))
        {
          paramContext = FileManagerUtil.a(paramQQAppInterface, (MessageForFile)paramChatMessage);
          paramQQAppInterface.getFileManagerEngine().c(paramContext.nSessionId);
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
        }
        paramContext = paramChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isDebugVersion())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("del garyTips id[");
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append("],targetId[");
          ((StringBuilder)localObject).append(paramChatMessage.msgUid);
          ((StringBuilder)localObject).append("], hashCode:");
          ((StringBuilder)localObject).append(paramChatMessage.hashCode());
          QLog.i("AIOMessageSpreadManager", 1, ((StringBuilder)localObject).toString());
        }
        if (!android.text.TextUtils.isEmpty(paramContext)) {
          try
          {
            long l = Long.parseLong(paramContext);
            paramQQAppInterface.getMessageFacade().b(paramChatMessage.frienduin, paramChatMessage.istroop, l, true);
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
            QLog.e("ChatActivityFacade", 1, paramContext.toString());
          }
        }
        ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).d.b(paramChatMessage);
        return;
      }
    }
    ThreadManager.post(new ChatActivityFacade.16(paramQQAppInterface, paramChatMessage), 8, null, true);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    paramQQAppInterface = new ChatActivityFacade.18(paramContext, paramList, paramQQAppInterface);
    paramList = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramList.isActive();
    int i;
    if (((paramContext instanceof Activity)) && (bool))
    {
      Activity localActivity = (Activity)paramContext;
      i = 1;
      paramList.hideSoftInputFromWindow(localActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
      return;
    }
    paramQQAppInterface.run();
  }
  
  public static void a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    String str = paramSessionInfo.b;
    boolean bool = paramSessionInfo.b.equals(paramQQAppInterface.getCurrentAccountUin());
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A2CE", "0X800A2CE", 0, 0, ChatActivityUtils.c(paramSessionInfo.a), "", "", "");
    int i = 0;
    Object localObject;
    if (bool)
    {
      localObject = new AllInOne(paramQQAppInterface.getCurrentAccountUin(), 0);
    }
    else
    {
      if (paramSessionInfo.a == 1024) {
        CrmUtils.a(paramActivity, null, paramSessionInfo.b, true, -1, true, 2000);
      }
      for (;;)
      {
        localObject = null;
        i = 1;
        break label679;
        if (paramSessionInfo.a == 1001)
        {
          localObject = new AllInOne(str, 42);
          break label679;
        }
        if (paramSessionInfo.a == 10002)
        {
          localObject = new AllInOne(str, 86);
          break label679;
        }
        if (paramSessionInfo.a == 10004)
        {
          localObject = new AllInOne(str, 94);
          break label679;
        }
        if (paramSessionInfo.a == 0)
        {
          localObject = new AllInOne(str, 70);
          break label679;
        }
        if (paramSessionInfo.a == 1000)
        {
          localObject = new AllInOne(str, 22);
          break label679;
        }
        if (paramSessionInfo.a == 1020)
        {
          localObject = new AllInOne(str, 58);
          break label679;
        }
        if (paramSessionInfo.a == 1001)
        {
          localObject = new AllInOne(str, 42);
          break label679;
        }
        if (paramSessionInfo.a == 10002)
        {
          localObject = new AllInOne(str, 86);
          break label679;
        }
        if (paramSessionInfo.a == 1004)
        {
          localObject = new AllInOne(str, 47);
          ((AllInOne)localObject).discussUin = paramSessionInfo.c;
          break label679;
        }
        if (paramSessionInfo.a == 1005)
        {
          localObject = new AllInOne(str, 2);
          break label679;
        }
        if (paramSessionInfo.a == 1023)
        {
          localObject = new AllInOne(str, 74);
          break label679;
        }
        if (paramSessionInfo.a == 1006)
        {
          localObject = new AllInOne(str, 34);
          break label679;
        }
        if (paramSessionInfo.a == 1009)
        {
          localObject = new AllInOne(str, 57);
          break label679;
        }
        if (paramSessionInfo.a == 1021)
        {
          localObject = new AllInOne(str, 72);
          break label679;
        }
        if (paramSessionInfo.a == 1022)
        {
          localObject = new AllInOne(str, 27);
          break label679;
        }
        if (paramSessionInfo.a != 1025) {
          break;
        }
        localObject = new Intent(paramActivity, ChatSettingActivity.class);
        ((Intent)localObject).putExtra("uin", paramSessionInfo.b);
        ((Intent)localObject).putExtra("uinname", paramSessionInfo.e);
        ((Intent)localObject).putExtra("uintype", paramSessionInfo.a);
        paramActivity.startActivity((Intent)localObject);
      }
      if ((paramSessionInfo.a != 1044) && (paramSessionInfo.a != 1045))
      {
        if (paramSessionInfo.a == 10008) {
          localObject = new AllInOne(str, 115);
        } else if (paramSessionInfo.a == 10010) {
          localObject = new AllInOne(str, 117);
        } else {
          localObject = new AllInOne(str, 19);
        }
      }
      else {
        localObject = new AllInOne(str, 96);
      }
    }
    label679:
    if (i == 0)
    {
      if (android.text.TextUtils.isEmpty(((AllInOne)localObject).nickname)) {
        ((AllInOne)localObject).nickname = paramSessionInfo.e;
      }
      ((AllInOne)localObject).reportExtra = NewReportPlugin.a(paramSessionInfo);
      ((AllInOne)localObject).preWinUin = paramSessionInfo.b;
      ((AllInOne)localObject).preWinType = paramSessionInfo.a;
      if ((paramSessionInfo.a == 1000) || (paramSessionInfo.a == 1020)) {
        ((AllInOne)localObject).troopUin = paramSessionInfo.c;
      }
      ((AllInOne)localObject).lastActivity = 2;
      if (paramSessionInfo.a == 0) {
        ((AllInOne)localObject).profileEntryType = 1;
      } else {
        ((AllInOne)localObject).profileEntryType = 106;
      }
      if ((paramSessionInfo.a != 1001) && (paramSessionInfo.a != 1010) && (paramSessionInfo.a != 10002))
      {
        ProfileUtils.openProfileCard(paramActivity, (AllInOne)localObject);
        return;
      }
      Intent localIntent = new Intent(paramActivity, NearbyProfileCardConstants.class);
      if (paramSessionInfo.a == 1001)
      {
        ((AllInOne)localObject).profileEntryType = 10;
        localIntent.putExtra("frome_where", 21);
      }
      else if (paramSessionInfo.a == 1010)
      {
        ((AllInOne)localObject).profileEntryType = 11;
      }
      else if (paramSessionInfo.a == 10002)
      {
        localIntent.putExtra("frome_where", 22);
      }
      ((AllInOne)localObject).reportExtra = NewReportPlugin.a(paramSessionInfo);
      localIntent.putExtra("AllInOne", (Parcelable)localObject);
      if (Utils.a(paramQQAppInterface.getCurrentAccountUin(), str)) {
        localIntent.putExtra("param_mode", 2);
      } else {
        localIntent.putExtra("param_mode", 3);
      }
      paramActivity.startActivityForResult(localIntent, 9009);
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramBaseChatPie != null)
    {
      int j = 1;
      if (paramQQAppInterface == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramSessionInfo != null) {
        j = 0;
      }
      if ((j | i) != 0) {
        return;
      }
      FriendChatPie localFriendChatPie = null;
      if ((paramBaseChatPie instanceof FriendChatPie)) {
        localFriendChatPie = (FriendChatPie)paramBaseChatPie;
      }
      if (localFriendChatPie == null) {
        return;
      }
      paramBaseChatPie = AioVipDonateHelper.a();
      int i = paramSessionInfo.a;
      boolean bool1 = paramBaseChatPie.a(paramQQAppInterface);
      boolean bool2 = paramBaseChatPie.b(paramQQAppInterface);
      boolean bool3 = paramBaseChatPie.a(paramQQAppInterface, paramSessionInfo.b);
      if ((i == 0) && (bool1) && (bool2) && (bool3))
      {
        Object localObject1 = paramQQAppInterface.getApp().getSharedPreferences(AioVipDonateHelper.a, 0);
        if (!paramBoolean)
        {
          long l1 = paramBaseChatPie.c(paramQQAppInterface);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(AioVipDonateHelper.b);
          ((StringBuilder)localObject2).append(paramSessionInfo.b);
          long l2 = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L);
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 > l1))
          {
            localObject2 = (VIPAioSendHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIP_AIO_SEND_HANDLER);
            if (localObject2 != null)
            {
              paramBaseChatPie = new AIOSendReq();
              paramBaseChatPie.iSend = 0;
              paramBaseChatPie.sAid = "";
              paramBaseChatPie.sUin = paramQQAppInterface.getCurrentAccountUin();
              paramBaseChatPie.sFriendUin = paramSessionInfo.b;
              ((VIPAioSendHandler)localObject2).a(paramBaseChatPie);
              paramBaseChatPie = ((SharedPreferences)localObject1).edit();
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append(AioVipDonateHelper.b);
              paramQQAppInterface.append(paramSessionInfo.b);
              paramBaseChatPie.putLong(paramQQAppInterface.toString(), System.currentTimeMillis());
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
        localObject1 = paramBaseChatPie.e(paramQQAppInterface);
        if ((paramBaseChatPie.d(paramQQAppInterface)) && (!android.text.TextUtils.isEmpty((CharSequence)localObject1)))
        {
          if (!localFriendChatPie.bl) {
            return;
          }
          paramBaseChatPie.a(paramQQAppInterface, 0);
          FileManagerDataCenter.a(paramQQAppInterface, paramSessionInfo.b, paramSessionInfo.a, -4022);
          paramQQAppInterface.getFileManagerDataCenter().a(paramSessionInfo.b, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.a, -4022, (String)localObject1);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle)
  {
    boolean bool = true;
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (StreamDataManager.c(paramString2) >= 1))
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
      paramString2 = new StringBuilder();
      paramString2.append("uploadPtt,");
      if (paramBundle.mRec == null) {
        paramString1 = "mRec is null";
      } else {
        paramString1 = "mRec is not null";
      }
      paramString2.append(paramString1);
      QLog.i("PttShow", 2, paramString2.toString());
    }
    if ((paramBundle.mRec instanceof MessageForPtt))
    {
      paramString1 = (MessageForPtt)paramBundle.mRec;
      paramString1.voiceType = paramInt3;
      paramString1.voiceLength = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(paramInt2);
      paramString1.voiceChangeFlag = paramInt4;
      if (paramInt5 == 4) {
        paramBoolean1 = bool;
      } else {
        paramBoolean1 = false;
      }
      paramString1.sendFromvoiceChangePanelFlag = paramBoolean1;
    }
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, int paramInt6)
  {
    a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramLong1, paramBoolean1, paramInt2, paramInt3, paramBoolean2, paramInt4, paramInt5, paramBoolean3, paramLong2, paramBundle, paramArrayList, paramString3, paramBoolean4, null, paramInt6);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, MessageRecord paramMessageRecord, int paramInt6)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (StreamDataManager.c(paramString2) >= 1))
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
    if (paramMessageRecord != null) {
      paramBundle.mRec = paramMessageRecord;
    } else {
      paramBundle.mRec = paramQQAppInterface.getMessageFacade().a(paramString1, paramInt1, paramLong1);
    }
    paramBoolean1 = false;
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean4) && (paramBundle.mRec != null))
    {
      paramBundle.mRec.atInfoList = paramArrayList;
      paramBundle.mRec.mRobotFlag = 1;
      new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_msg_suc").a(new String[] { paramString1, String.valueOf(((AtTroopMemberInfo)paramArrayList.get(0)).uin) }).a();
    }
    if ((paramInt1 == 1026) && (QLog.isColorLevel()))
    {
      paramString2 = new StringBuilder();
      paramString2.append("uploadPtt,");
      if (paramBundle.mRec == null) {
        paramString1 = "mRec is null";
      } else {
        paramString1 = "mRec is not null";
      }
      paramString2.append(paramString1);
      QLog.i("PttShow", 2, paramString2.toString());
    }
    if ((paramBundle.mRec instanceof MessageForPtt))
    {
      paramString1 = (MessageForPtt)paramBundle.mRec;
      paramString1.voiceType = paramInt3;
      paramString1.voiceLength = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(paramInt2);
      paramString1.voiceChangeFlag = paramInt4;
      paramString1.mInputContent = paramString3;
      paramString1.autoToText = paramInt6;
      if (paramInt5 == 4) {
        paramBoolean1 = true;
      }
      paramString1.sendFromvoiceChangePanelFlag = paramBoolean1;
    }
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon)
  {
    a(paramQQAppInterface, paramContext, paramBaseSessionInfo, paramEmoticon, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon == null)
    {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
      QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
      return;
    }
    if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4)) && (!paramEmoticon.hasEncryptKey()))
    {
      Toast.makeText(paramContext, paramContext.getString(2131889112), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      paramQQAppInterface = paramEmoticon.epId;
      paramBaseSessionInfo = paramEmoticon.eId;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(NetworkUtil.getNetworkType(paramContext));
      localStringBuilder.append("");
      VasReportUtils.a("emotionType", "emotionActionSend", "2", paramQQAppInterface, paramBaseSessionInfo, localStringBuilder.toString(), "", "", "", "");
      paramBaseSessionInfo = new StringBuilder();
      paramBaseSessionInfo.append("sendEmosmMsg emoticon Encrypt Key is null.name:");
      paramQQAppInterface = paramEmoticon.name;
      paramContext = "~";
      if (paramQQAppInterface != null) {
        paramQQAppInterface = paramEmoticon.name;
      } else {
        paramQQAppInterface = "~";
      }
      paramBaseSessionInfo.append(paramQQAppInterface);
      paramBaseSessionInfo.append(", epid_eid:");
      if (paramEmoticon.epId != null) {
        paramQQAppInterface = paramEmoticon.epId;
      } else {
        paramQQAppInterface = "~";
      }
      paramBaseSessionInfo.append(paramQQAppInterface);
      paramBaseSessionInfo.append("_");
      paramQQAppInterface = paramContext;
      if (paramEmoticon.eId != null) {
        paramQQAppInterface = paramEmoticon.eId;
      }
      paramBaseSessionInfo.append(paramQQAppInterface);
      QLog.e("ChatActivityFacade", 1, paramBaseSessionInfo.toString());
      return;
    }
    ThreadManager.post(new ChatActivityFacade.20(paramQQAppInterface, paramEmoticon, paramContext, paramBaseSessionInfo, paramInt), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    ImageUtil.a(-1L, paramBaseSessionInfo.a, true, "image_send_prepare", "ChatActivity.sendIMEEXpression");
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      ChatActivityUtils.a(paramContext, 2131892635, 0);
      ImageUtil.a(-1L, paramBaseSessionInfo.a, true, "image_send_prepared_failed", "ChatActivity.sendIMEEXpression");
      return;
    }
    paramContext = new PicUploadInfo.Builder();
    paramContext.a(paramString);
    paramContext.d(paramInt);
    paramContext.d(paramBaseSessionInfo.b);
    paramContext.c(0);
    paramContext.e(paramBaseSessionInfo.c);
    paramContext.c(paramQQAppInterface.getCurrentAccountUin());
    paramContext.e(paramBaseSessionInfo.a);
    paramContext.l(paramBaseSessionInfo.v);
    PicReq localPicReq = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, paramInt);
    localPicReq.a(paramContext.k());
    ((IPicBus)QRoute.api(IPicBus.class)).launch(localPicReq);
    ThreadManager.post(new ChatActivityFacade.11(paramString, paramBaseSessionInfo, paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
  {
    a(paramQQAppInterface, paramContext, paramBaseSessionInfo, paramString1, false, false, paramBoolean, null, null, paramString2, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, StickerInfo paramStickerInfo)
  {
    a(paramQQAppInterface, paramContext, paramBaseSessionInfo, paramString1, paramBoolean1, paramBoolean2, false, paramString2, paramStickerInfo, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, StickerInfo paramStickerInfo, String paramString3, Bundle paramBundle)
  {
    if (paramString1 == null)
    {
      QLog.e("ChatActivityFacade", 1, "sendCustomEmotion url == null");
      if (paramBoolean1) {
        VasReportUtils.a("emotionType", "emotionActionSend", "5", "", "", "", "", "", "", "");
      }
      return;
    }
    ImageUtil.a(-1L, paramBaseSessionInfo.a, true, "image_send_prepare", "ChatActivity.sendCustomEmotion");
    if (!FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      ChatActivityUtils.a(paramContext, 2131892635, 0);
      if (paramBoolean1) {
        VasReportUtils.a("emotionType", "emotionActionSend", "6", "", "", "", "", "", "", "");
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("sendCustomEmotion file not exist or problme: URL = ");
      paramQQAppInterface.append(paramString1);
      QLog.e("ChatActivityFacade", 1, paramQQAppInterface.toString());
      return;
    }
    Object localObject1 = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject1).a(paramString1);
    ((PicUploadInfo.Builder)localObject1).d(1006);
    ((PicUploadInfo.Builder)localObject1).d(paramBaseSessionInfo.b);
    ((PicUploadInfo.Builder)localObject1).c(0);
    ((PicUploadInfo.Builder)localObject1).e(paramBaseSessionInfo.c);
    ((PicUploadInfo.Builder)localObject1).c(paramQQAppInterface.getCurrentAccountUin());
    ((PicUploadInfo.Builder)localObject1).e(paramBaseSessionInfo.a);
    ((PicUploadInfo.Builder)localObject1).l(paramBaseSessionInfo.v);
    Object localObject2 = (IPicBus)QRoute.api(IPicBus.class);
    int i = 2;
    localObject2 = ((IPicBus)localObject2).createPicReq(2, 1006);
    ((PicReq)localObject2).a(((PicUploadInfo.Builder)localObject1).k());
    PicMessageExtraData localPicMessageExtraData = new PicMessageExtraData();
    localObject1 = "";
    if (paramBoolean3)
    {
      localPicMessageExtraData.imageBizType = 8;
      if (paramBundle != null) {
        localPicMessageExtraData.mTemplateId = paramBundle.getString("widgetinfo", "");
      }
    }
    else
    {
      localPicMessageExtraData.imageBizType = 1;
      if (!paramBoolean2) {
        i = 0;
      }
      localPicMessageExtraData.customFaceType = i;
      paramBundle = (Bundle)localObject1;
      if (paramBoolean2) {
        paramBundle = paramString2;
      }
      localPicMessageExtraData.emojiPkgId = paramBundle;
      if (paramStickerInfo != null) {
        localPicMessageExtraData.stickerInfo = paramStickerInfo;
      }
    }
    if (!android.text.TextUtils.isEmpty(paramString3))
    {
      paramContext = new StringBuilder();
      paramContext.append("[");
      paramContext.append(paramString3);
      paramContext.append("]");
      localPicMessageExtraData.textSummary = paramContext.toString();
    }
    else if (paramBoolean3)
    {
      localPicMessageExtraData.textSummary = paramContext.getResources().getString(2131888230);
    }
    else
    {
      localPicMessageExtraData.textSummary = paramContext.getResources().getString(2131888229);
    }
    ((PicReq)localObject2).i = localPicMessageExtraData;
    ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject2);
    if (paramBoolean1) {
      ThreadManager.post(new ChatActivityFacade.12(paramString1, paramBaseSessionInfo, paramQQAppInterface), 5, null, false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (1024 == paramSessionInfo.a) {
      return;
    }
    int i = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getLocalSelfAddFriendSetting(paramQQAppInterface);
    Object localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("single way add allow insert ");
      ((StringBuilder)localObject1).append(paramSessionInfo.b);
      ((StringBuilder)localObject1).append(" settingValue:");
      ((StringBuilder)localObject1).append(i);
      QLog.d("ChatActivityFacade", 4, ((StringBuilder)localObject1).toString());
    }
    if ((i == 0) || (i == 3))
    {
      if (i == 0)
      {
        localObject1 = "single_way_friend_add_allow_list";
        i = -7006;
      }
      else
      {
        localObject1 = "single_way_friend_list";
        i = -2019;
      }
      if (!ChatActivityUtils.a(paramContext, paramSessionInfo, (String)localObject1))
      {
        Object localObject2 = paramQQAppInterface.getMessageFacade().h(paramSessionInfo.b, 0).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (((MessageRecord)((Iterator)localObject2).next()).msgtype == i)
          {
            bool = true;
            break label188;
          }
        }
        boolean bool = false;
        label188:
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("single way add allow insert ");
          ((StringBuilder)localObject2).append(paramSessionInfo.b);
          ((StringBuilder)localObject2).append(" hasInserted:");
          ((StringBuilder)localObject2).append(bool);
          QLog.d("ChatActivityFacade", 4, ((StringBuilder)localObject2).toString());
        }
        if (!bool)
        {
          ChatActivityUtils.b(paramContext, paramSessionInfo, (String)localObject1);
          paramContext = (MessageForGrayTips)MessageRecordFactory.a(i);
          long l = MessageCache.c() + 1L;
          paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.b, paramSessionInfo.b, "", l, i, paramSessionInfo.a, l);
          paramContext.setTextGravity(17);
          paramContext.isread = true;
          if (!MessageHandlerUtils.a(paramQQAppInterface, paramContext, false)) {
            paramQQAppInterface.getMessageFacade().a(paramContext, paramContext.selfuin);
          }
        }
      }
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
    MessageRecordFactory.a(paramQQAppInterface, paramContext, paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a);
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
      if (b == null)
      {
        b = QQToast.makeText(paramContext, 2131886567, 0);
        PokeItemAnimationManager.c().a(3);
        PokeItemAnimationManager.c().a(6);
        PokeItemAnimationManager.c().a(12);
        PokeItemAnimationManager.c().a(15);
        PokeItemAnimationManager.c().a(18);
        PokeItemAnimationManager.c().a(9);
      }
      if (!b.isShowing()) {
        b.show();
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
    paramContext.strength = PokeItemAnimationManager.c().a(paramQQAppInterface, paramSessionInfo.b, paramContext.interactType, paramInt3, -1);
    if ((paramInt3 == 3) || (paramInt3 == 4))
    {
      paramInt2 = paramContext.flag;
      if (paramInt3 == 3) {
        paramInt1 = 8;
      } else {
        paramInt1 = 16;
      }
      paramContext.flag = (paramInt2 | paramInt1);
      paramContext.isPlayed = true;
    }
    MessageRecordFactory.a(paramQQAppInterface, paramContext, paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a);
    paramContext.initMsg();
    if (QLog.isColorLevel())
    {
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("sendPokeMsg strength:");
      paramSessionInfo.append(paramContext.strength);
      paramSessionInfo.append(".");
      paramSessionInfo.append(paramContext);
      QLog.d("PokeMsg", 2, paramSessionInfo.toString());
    }
    paramQQAppInterface.getMessageFacade().a(paramContext, null);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("sendPokeMsg type:");
      paramQQAppInterface.append(paramContext.interactType);
      paramQQAppInterface.append(".");
      paramQQAppInterface.append(paramContext);
      QLog.d("PokeMsg", 2, paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt, -1, paramString1, paramString2, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.b, paramSessionInfo.a, paramLong);
    if ((paramContext != null) && (paramContext.isSendFromLocal())) {
      ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramContext.frienduin, paramContext.uniseq));
    }
    paramQQAppInterface.getMessageFacade().h(paramSessionInfo.b, paramSessionInfo.a, paramLong);
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
    if (paramForwardFileInfo.a > 0) {
      paramInt = paramForwardFileInfo.a;
    }
    paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.e(), paramForwardFileInfo.k(), paramForwardFileInfo.b(), Long.parseLong(paramSessionInfo.b), paramSessionInfo.a, paramForwardFileInfo.a(), paramForwardFileInfo.f(), paramInt);
    if (paramIntent.getBooleanExtra("not_forward", false))
    {
      paramIntent.removeExtra("not_forward");
      paramIntent.getExtras().remove("not_forward");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramBoolean, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    int i;
    if ((paramInt <= 0) && (paramForwardFileInfo != null)) {
      i = paramForwardFileInfo.a;
    } else {
      i = paramInt;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ChatActivityFacade", 1, "forwardForFile");
    }
    if (ForwardUtils.a(paramIntent, paramSessionInfo, paramString, paramQQAppInterface))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("handleForwardEditedPhoto = ");
        paramQQAppInterface.append(paramString);
        QLog.d("ChatActivityFacade", 2, paramQQAppInterface.toString());
      }
      return;
    }
    if ((paramForwardFileInfo != null) && (paramForwardFileInfo.c() == 10006) && (android.text.TextUtils.isEmpty(paramForwardFileInfo.d())))
    {
      a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramInt);
      return;
    }
    if ((!paramIntent.getBooleanExtra("isFromFavorites", false)) && (paramIntent.getBooleanExtra("isFromShare", false)))
    {
      if (paramIntent.getBooleanExtra("sendMultiple", false)) {
        return;
      }
      if (paramSessionInfo.a == 1)
      {
        paramQQAppInterface.getFileManagerEngine().a(paramString, paramSessionInfo.b, 0L, i);
        return;
      }
      paramQQAppInterface.getFileManagerEngine().a(paramString, paramSessionInfo.c, paramSessionInfo.b, paramSessionInfo.a, true, 0L, i);
      return;
    }
    if (!paramIntent.getBooleanExtra("not_forward", false)) {
      return;
    }
    paramString = null;
    if (paramForwardFileInfo != null) {
      paramString = paramQQAppInterface.getFileManagerDataCenter().b(paramForwardFileInfo.e());
    }
    String str = paramString;
    if (paramString == null)
    {
      paramString = QfavHelper.a(paramIntent.getExtras(), paramSessionInfo.b, paramSessionInfo.a);
      str = paramString;
      if (paramString != null)
      {
        paramForwardFileInfo.b(paramString.nSessionId);
        str = paramString;
      }
    }
    if ((str == null) && (QLog.isColorLevel()))
    {
      paramString = new StringBuilder();
      paramString.append("there has a Bug!,sissionId[");
      paramString.append(paramForwardFileInfo.e());
      paramString.append("]");
      QLog.e("ChatActivityFacade", 2, paramString.toString());
    }
    paramInt = paramForwardFileInfo.c();
    if (paramInt != 10006)
    {
      if (paramInt != 10013)
      {
        if (paramInt == 10008) {
          break label1249;
        }
        if (paramInt == 10009) {}
      }
      switch (paramInt)
      {
      default: 
        break;
      case 10003: 
        paramContext = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.e());
        paramQQAppInterface.getFileManagerEngine().b(paramContext, paramSessionInfo.c, paramSessionInfo.b, paramSessionInfo.a, i);
        break;
      case 10002: 
        if (paramSessionInfo.a == 1)
        {
          if (FileUtil.b(paramForwardFileInfo.d()))
          {
            paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.d(), paramSessionInfo.b);
          }
          else
          {
            paramForwardFileInfo.e();
            paramContext = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.e());
            if ((paramContext != null) && (paramContext.peerType == 3000))
            {
              paramSessionInfo = paramQQAppInterface.getFileManagerEngine().a(paramContext, paramSessionInfo.c, paramSessionInfo.b, paramContext.peerType, false);
              paramSessionInfo.selfUin = paramContext.peerUin;
              paramQQAppInterface.getFileManagerEngine().a(paramSessionInfo, 27, paramForwardFileInfo.f(), i);
            }
            else
            {
              paramQQAppInterface.getFileManagerEngine().a(3, paramForwardFileInfo.e(), paramSessionInfo.b, paramForwardFileInfo.f(), i);
            }
          }
        }
        else
        {
          paramString = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.e());
          if ((paramString != null) && (paramString.status == 16))
          {
            if (paramContext != null) {
              FileManagerUtil.l(paramContext.getResources().getString(2131889788));
            }
            return;
          }
          paramContext = paramQQAppInterface.getCurrentAccountUin();
          if ((paramSessionInfo.a == 1004) || (paramSessionInfo.a == 1000)) {
            paramContext = paramSessionInfo.c;
          }
          if ((paramString != null) && (paramString.peerType == 3000))
          {
            paramContext = paramQQAppInterface.getFileManagerEngine().a(paramString, paramContext, paramSessionInfo.b, paramSessionInfo.a, true, paramForwardFileInfo.f(), i);
            paramContext.selfUin = paramString.peerUin;
            if ((paramSessionInfo.a != 0) && (paramSessionInfo.a != 1006) && (paramSessionInfo.a != 1004) && (paramSessionInfo.a != 1000) && (paramSessionInfo.a != 1001) && (paramSessionInfo.a != 10002) && (paramSessionInfo.a != 1006))
            {
              if (paramSessionInfo.a == 3000)
              {
                paramContext.nOpType = 22;
                paramQQAppInterface.getFileManagerEngine().c(paramContext, 22);
              }
            }
            else
            {
              paramContext.nOpType = 21;
              paramQQAppInterface.getFileManagerEngine().c(paramContext, 21);
            }
            paramQQAppInterface.getFileManagerDataCenter().c(paramContext);
          }
          else
          {
            paramContext = paramQQAppInterface.getFileManagerEngine().a(paramString, paramContext, paramSessionInfo.b, paramSessionInfo.a, true, paramForwardFileInfo.f(), i);
            if (paramSessionInfo.a == 3000) {
              paramContext.nOpType = 28;
            }
            paramQQAppInterface.getFileManagerEngine().e(paramContext);
            paramQQAppInterface.getFileManagerDataCenter().c(paramContext);
          }
        }
        break;
      case 10001: 
      case 10004: 
        if (paramSessionInfo.a == 1)
        {
          if (FileUtil.b(paramForwardFileInfo.d()))
          {
            paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.d(), paramSessionInfo.b, 0L, i);
          }
          else
          {
            paramString = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.e());
            paramContext = paramQQAppInterface.getCurrentAccountUin();
            if ((paramSessionInfo.a == 1004) || (paramSessionInfo.a == 1000)) {
              paramContext = paramSessionInfo.c;
            }
            if ((paramString != null) && (paramString.peerType == 3000))
            {
              paramContext = paramQQAppInterface.getFileManagerEngine().a(paramString, paramContext, paramSessionInfo.b, paramString.peerType, false);
              paramContext.selfUin = paramString.peerUin;
              paramQQAppInterface.getFileManagerEngine().c(paramContext, 27);
            }
            else
            {
              paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.e(), paramSessionInfo.b, i);
            }
          }
        }
        else
        {
          paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.e(), paramSessionInfo.c, paramSessionInfo.b, paramSessionInfo.a, true, i);
          break;
          if (paramSessionInfo.a == 1)
          {
            paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.e(), paramSessionInfo.b);
          }
          else if (paramSessionInfo.a == 0)
          {
            paramQQAppInterface.getFileManagerEngine().b(paramForwardFileInfo.e(), paramSessionInfo.b);
          }
          else if (paramSessionInfo.a == 3000)
          {
            paramQQAppInterface.getFileManagerEngine().c(paramForwardFileInfo.e(), paramSessionInfo.b);
            break;
            paramQQAppInterface.getFileManagerEngine().a(str, paramSessionInfo.b, paramSessionInfo.a, i);
          }
        }
        break;
      }
    }
    label1249:
    if (paramSessionInfo.a == 1)
    {
      paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.d(), paramSessionInfo.b, paramForwardFileInfo.f(), i);
    }
    else
    {
      paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.d(), paramSessionInfo.c, paramSessionInfo.b, paramSessionInfo.a, true, paramForwardFileInfo.f(), i);
      if (str != null) {
        paramQQAppInterface.lastSuccessTime = str.lastSuccessTime;
      }
    }
    if ((!paramBoolean) && (paramIntent.getBooleanExtra("not_forward", false)))
    {
      paramIntent.removeExtra("not_forward");
      paramIntent.getExtras().remove("not_forward");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, long paramLong)
  {
    paramContext = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.b, paramSessionInfo.a, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.getMessageFacade().h(paramSessionInfo.b, paramSessionInfo.a, paramLong);
      paramContext = MessageRecordFactory.a(paramContext);
      paramQQAppInterface.getMessageFacade().a(paramContext, null, true);
      paramQQAppInterface = (IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
      if ((paramQQAppInterface != null) && (paramEmoticon != null))
      {
        paramContext = paramQQAppInterface.getKeywordsByEmoticon(paramEmoticon);
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
              paramQQAppInterface.addRecentEmotionToCache(localRecentEmotion);
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, StickerInfo paramStickerInfo)
  {
    if (paramEmoticon == null)
    {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
      QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
      return;
    }
    if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4)) && (!paramEmoticon.hasEncryptKey()))
    {
      Toast.makeText(paramContext, paramContext.getString(2131889112), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      paramQQAppInterface = paramEmoticon.epId;
      paramSessionInfo = paramEmoticon.eId;
      paramStickerInfo = new StringBuilder();
      paramStickerInfo.append(NetworkUtil.getNetworkType(paramContext));
      paramStickerInfo.append("");
      VasReportUtils.a("emotionType", "emotionActionSend", "2", paramQQAppInterface, paramSessionInfo, paramStickerInfo.toString(), "", "", "", "");
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("sendEmosmMsg emoticon Encrypt Key is null.name:");
      paramQQAppInterface = paramEmoticon.name;
      paramContext = "~";
      if (paramQQAppInterface != null) {
        paramQQAppInterface = paramEmoticon.name;
      } else {
        paramQQAppInterface = "~";
      }
      paramSessionInfo.append(paramQQAppInterface);
      paramSessionInfo.append(", epid_eid:");
      if (paramEmoticon.epId != null) {
        paramQQAppInterface = paramEmoticon.epId;
      } else {
        paramQQAppInterface = "~";
      }
      paramSessionInfo.append(paramQQAppInterface);
      paramSessionInfo.append("_");
      paramQQAppInterface = paramContext;
      if (paramEmoticon.eId != null) {
        paramQQAppInterface = paramEmoticon.eId;
      }
      paramSessionInfo.append(paramQQAppInterface);
      QLog.e("ChatActivityFacade", 1, paramSessionInfo.toString());
      return;
    }
    ThreadManager.post(new ChatActivityFacade.21(paramQQAppInterface, paramEmoticon, paramContext, paramSessionInfo, paramStickerInfo), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    localSendMsgParams.a = false;
    localSendMsgParams.b = true;
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, localSendMsgParams);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_bank", 4, "AIO---sendShowLoveMessage");
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80052A5", "0X80052A5", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131889169, 0);
      return;
    }
    paramSessionInfo = paramQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong);
    if (paramSessionInfo == null)
    {
      ChatActivityUtils.a(paramContext, 2131916242, 0);
      return;
    }
    ThreadManager.post(new ChatActivityFacade.23(paramSessionInfo, paramQQAppInterface, paramString, paramInt, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    if ((paramSessionInfo.a == 1) && (((TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramSessionInfo.b, true).b) && ((paramContext instanceof BaseActivity)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.makeText(paramQQAppInterface.getApp(), 2131895180, 0).show(paramContext.getTitleBarHeight());
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
    if (FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      ForwardSendPicUtil.a(paramQQAppInterface, paramString1, paramSessionInfo.b, paramSessionInfo.a, paramSessionInfo.c, false, paramContext, paramInt2);
      return;
    }
    long l1 = a(paramQQAppInterface, paramString1, paramSessionInfo.b, paramSessionInfo.a, paramString2, paramString3, paramLong, paramInt1);
    paramContext = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramString3, paramLong);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ChatActivity.handleForwardData forwardPic wait for download1,uniseq:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(",filePath:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",forwardImageOrgServerpath:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",forwardImageOrgItemId:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",processor:");
      ((StringBuilder)localObject).append(paramContext);
      QLog.d("streamptt", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramContext != null) && ((paramContext instanceof BaseTransProcessor)))
    {
      paramContext = (BaseTransProcessor)paramContext;
      long l2 = paramContext.getFileStatus();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ChatActivity.handleForwardData forwardPic wait for download2,msgId:");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(",filePath:");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(",get download process status:");
        ((StringBuilder)localObject).append(l2);
        QLog.d("streamptt", 2, ((StringBuilder)localObject).toString());
      }
      if ((l2 == 2000L) || (l2 == 2001L) || (l2 == 2002L))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramSessionInfo.b);
        ((StringBuilder)localObject).append(l1);
        localObject = ((StringBuilder)localObject).toString();
        ITransFileController localITransFileController = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
        IHttpCommunicatorListener localIHttpCommunicatorListener = localITransFileController.findProcessor(paramSessionInfo.b, l1);
        if ((localIHttpCommunicatorListener instanceof ForwardImageProcessor)) {
          ((ForwardImageProcessor)localIHttpCommunicatorListener).stopListening();
        }
        localITransFileController.addProcessor((String)localObject, new ForwardImageProcessor(l1, paramString4, paramQQAppInterface, paramSessionInfo.a, paramSessionInfo.b, paramString1, paramString2, paramString3, paramLong, paramInt1));
        paramContext.getFileMsg().forwardTaskKey = paramString4;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, paramArrayList, new ChatActivityFacade.SendMsgParams());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, List<String> paramList)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")) && (((JSONObject)localObject2).getString("uin").equals(UinMD5Cache.a(str))))
            {
              localObject2 = paramQQAppInterface.getMessageFacade().h(str, 0);
              ChatActivityUtils.a(paramContext, str, 0, "single_way_friend_list");
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
                if (localMessageRecord.msgtype == -2019) {
                  paramQQAppInterface.getMessageFacade().h(str, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
            i += 1;
          }
        }
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo)
  {
    try
    {
      Long.valueOf(paramBaseSessionInfo.b).longValue();
      long l = paramQQAppInterface.getMessageFacade().i(paramBaseSessionInfo.b, paramBaseSessionInfo.a);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("ChatActivityFacade,uin: %s, uinType: %d, id: %d", new Object[] { paramBaseSessionInfo.b, Integer.valueOf(paramBaseSessionInfo.a), Long.valueOf(l) }));
      }
      if (paramBaseSessionInfo.a == 1036) {
        return;
      }
      if (l != -1L)
      {
        if (l == paramBaseSessionInfo.h) {
          return;
        }
        paramBaseSessionInfo.h = l;
        String str = ProcessorDispatcher.a(paramBaseSessionInfo.a);
        paramQQAppInterface.getMsgHandler().a(str).a(paramBaseSessionInfo.b, paramBaseSessionInfo.a, l);
      }
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.sendReadConfirm_PB", 2, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageForAniSticker paramMessageForAniSticker, int paramInt)
  {
    if (paramMessageForAniSticker == null) {
      return;
    }
    MessageRecordFactory.a(paramQQAppInterface, paramMessageForAniSticker, paramBaseSessionInfo.b, paramBaseSessionInfo.c, paramBaseSessionInfo.a);
    paramMessageForAniSticker.mIsParsed = true;
    paramMessageForAniSticker.msg = paramMessageForAniSticker.text;
    paramMessageForAniSticker.msgVia = paramBaseSessionInfo.s;
    paramMessageForAniSticker.msgtype = -8018;
    paramMessageForAniSticker.msgData = paramMessageForAniSticker.serializeMsgData();
    if (paramMessageForAniSticker.istroop == 1) {
      AnonymousChatHelper.a().a(paramMessageForAniSticker);
    } else if (AnonymousChatHelper.a().j) {
      AnonymousChatHelper.a().j = false;
    }
    if (UinTypeUtil.e(paramBaseSessionInfo.a) == 1032) {
      ConfessMsgUtil.a(paramQQAppInterface, paramMessageForAniSticker, paramBaseSessionInfo.b, paramBaseSessionInfo.a, paramBaseSessionInfo.v);
    } else if (paramBaseSessionInfo.x) {
      ConfessMsgUtil.a(paramQQAppInterface, paramMessageForAniSticker, paramBaseSessionInfo.b);
    } else if (paramBaseSessionInfo.y) {
      ConfessMsgUtil.b(paramQQAppInterface, paramMessageForAniSticker, paramBaseSessionInfo.b);
    }
    if (QLog.isColorLevel())
    {
      paramBaseSessionInfo = new StringBuilder();
      paramBaseSessionInfo.append("ChatActivityFacade#sendAniSticker:");
      paramBaseSessionInfo.append(paramMessageForAniSticker.toString());
      QLog.d("MessageForAniSticker", 2, paramBaseSessionInfo.toString());
    }
    ForwardOrderManager.a().a(paramMessageForAniSticker.uniseq, 0L, paramInt);
    paramQQAppInterface.getMessageFacade().a(paramMessageForAniSticker, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (paramLong != -1L)
    {
      int i = paramBaseSessionInfo.a;
      Object localObject = paramQQAppInterface.getMessageFacade().a(paramBaseSessionInfo.b, i, paramLong);
      if ((localObject instanceof MessageForPtt))
      {
        localObject = (MessageForPtt)localObject;
        ((MessageForPtt)localObject).url = paramString;
        ((MessageForPtt)localObject).fileSize = paramInt;
        ((MessageForPtt)localObject).isread = false;
        ((MessageForPtt)localObject).itemType = 2;
        ((MessageForPtt)localObject).serial();
        paramQQAppInterface.getMessageFacade().a(paramBaseSessionInfo.b, i, paramLong, ((MessageForPtt)localObject).msgData);
        paramQQAppInterface.getMessageFacade().a(paramBaseSessionInfo.b, i, paramLong, "extStr", ((MessageForPtt)localObject).extStr);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.a != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.4(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo)
  {
    if (paramSystemAndEmojiEmoticonInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 1, "sendPopEmoMsg emoticonInfo is null");
      }
      return;
    }
    MessageForPokeEmo localMessageForPokeEmo = new MessageForPokeEmo();
    localMessageForPokeEmo.msgtype = -5018;
    localMessageForPokeEmo.isNeedPlayed = false;
    localMessageForPokeEmo.pokeemoId = 13;
    localMessageForPokeEmo.pokeemoPressCount = paramInt;
    localMessageForPokeEmo.emoIndex = QQSysFaceUtil.convertToServer(paramSystemAndEmojiEmoticonInfo.code);
    paramSystemAndEmojiEmoticonInfo = QQSysFaceUtil.getPrueFaceDescription(QQSysFaceUtil.getFaceDescription(paramSystemAndEmojiEmoticonInfo.code));
    localMessageForPokeEmo.summary = paramSystemAndEmojiEmoticonInfo;
    localMessageForPokeEmo.emoString = paramSystemAndEmojiEmoticonInfo;
    localMessageForPokeEmo.emoCompat = paramSystemAndEmojiEmoticonInfo;
    localMessageForPokeEmo.initMsg();
    MessageRecordFactory.a(paramQQAppInterface, localMessageForPokeEmo, paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a);
    paramQQAppInterface.getMessageFacade().a(localMessageForPokeEmo, null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, String.format(" sendPopEmoMsg.emoIndex = %d,count = %d,summary = %s", new Object[] { Integer.valueOf(localMessageForPokeEmo.emoIndex), Integer.valueOf(paramInt), paramSystemAndEmojiEmoticonInfo }));
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null))
    {
      if (paramSessionInfo == null) {
        return;
      }
      if (paramLong > NetConnInfoCenter.getServerTimeMillis())
      {
        QLog.e("ChatActivityFacade.QZoneFeeds", 2, String.format("帖子创建时间：%d,当前取得服务器时间：%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()) }));
        return;
      }
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story帖子创建时间：%d", new Object[] { Long.valueOf(paramLong) }));
      paramSessionInfo = j(paramQQAppInterface, paramSessionInfo, "key_last_story_feed_create_time_for_aio");
      paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramSessionInfo, paramLong).apply();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (localArrayList != null)
    {
      if (localArrayList.isEmpty()) {
        return;
      }
      if (android.text.TextUtils.isEmpty(paramSessionInfo.b)) {
        return;
      }
      try
      {
        int i = Integer.valueOf(paramIntent.getStringExtra("key_upload_client_key")).intValue();
        long l = a(paramQQAppInterface, paramSessionInfo, i, localArrayList);
        ((TroopQZoneUploadAlbumHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_QZONE_UPLOAD_ALBUM_PROGRESS_HANDLER)).a(i, paramSessionInfo.b, l);
        return;
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic, int paramInt)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (paramMessageForPic != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("uin", paramSessionInfo.b);
      localIntent.putExtra("troop_uin", paramSessionInfo.c);
      localIntent.putExtra("uintype", paramSessionInfo.a);
      localIntent.putExtra("FORWARD_UIN_TYPE", paramSessionInfo.a);
      localIntent.putExtra("SENDER_TROOP_UIN", paramSessionInfo.c);
      localIntent.putExtra("FORWARD_PEER_UIN", paramSessionInfo.b);
      localIntent.putExtra("FORWARD_SELF_UIN", paramQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("forward_image_width", paramMessageForPic.width);
      localIntent.putExtra("forward_image_height", paramMessageForPic.height);
      localIntent.putExtra("forward_file_size", paramMessageForPic.size);
      localIntent.putExtra("forward_image_type", paramMessageForPic.imageType);
      localIntent.putExtra("forward_filepath", paramMessageForPic.path);
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(paramMessageForPic.frienduin);
      paramQQAppInterface.append(paramMessageForPic.uniseq);
      paramQQAppInterface.append(paramMessageForPic.istroop);
      paramQQAppInterface = paramQQAppInterface.toString();
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
      paramQQAppInterface = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfo(1009, localIntent);
      paramSessionInfo = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(3, 1009);
      paramSessionInfo.a(paramQQAppInterface);
      paramSessionInfo.l = paramMessageForPic;
      paramSessionInfo.i = paramMessageForPic.picExtraData;
      paramMessageForPic.forwardId.put(paramSessionInfo, Integer.valueOf(paramInt));
      ((IPicBus)QRoute.api(IPicBus.class)).launch(paramSessionInfo);
      return;
    }
    QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramQQAppInterface != null) && (paramMessageForShortVideo != null))
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramSessionInfo.b);
      ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.c);
      ((Intent)localObject).putExtra("uintype", paramSessionInfo.a);
      ((Intent)localObject).putExtra("from_uin", SVUtils.a(paramMessageForShortVideo));
      ((Intent)localObject).putExtra("from_uin_type", paramMessageForShortVideo.istroop);
      ((Intent)localObject).putExtra("from_session_uin", paramMessageForShortVideo.frienduin);
      ((Intent)localObject).putExtra("from_busi_type", paramMessageForShortVideo.busiType);
      ((Intent)localObject).putExtra("file_send_size", paramMessageForShortVideo.videoFileSize);
      ((Intent)localObject).putExtra("file_send_duration", paramMessageForShortVideo.videoFileTime);
      ((Intent)localObject).putExtra("file_name", paramMessageForShortVideo.videoFileName);
      ((Intent)localObject).putExtra("file_format", paramMessageForShortVideo.videoFileFormat);
      paramSessionInfo = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
      boolean bool = QLog.isColorLevel();
      int i = 2;
      if (bool)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Forward menu clicked, videoPath=");
        localStringBuilder.append(paramSessionInfo);
        localStringBuilder.append(",videoPath = ");
        localStringBuilder.append(paramSessionInfo);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramMessageForShortVideo.toLogString());
        QLog.d("ChatActivityFacade", 2, localStringBuilder.toString());
      }
      ((Intent)localObject).putExtra("file_send_path", paramSessionInfo);
      ((Intent)localObject).putExtra("thumbfile_send_path", SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg"));
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
      int j = paramMessageForShortVideo.busiType;
      if (j != 1) {
        if (j == 2) {
          i = 3;
        } else {
          i = 0;
        }
      }
      ((Intent)localObject).putExtra("special_video_type", paramMessageForShortVideo.specialVideoType);
      if (paramMessageForShortVideo.checkIsHotVideo())
      {
        ((Intent)localObject).putExtra("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
        ((Intent)localObject).putExtra("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
        ((Intent)localObject).putExtra("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
        ((Intent)localObject).putExtra("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
      }
      ((Intent)localObject).putExtra("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
      ((Intent)localObject).putExtra("widgetinfo", paramMessageForShortVideo.templateId);
      ((Intent)localObject).putExtra("key_camera_material_name", paramMessageForShortVideo.templateName);
      paramSessionInfo = SVBusiUtil.a(3, i);
      localObject = ShortVideoBusiManager.b(i, localObject, paramSessionInfo);
      if (localObject != null)
      {
        ((ShortVideoForwardInfo)localObject).g = paramMessageForShortVideo.uniseq;
        ((ShortVideoForwardInfo)localObject).G = paramMessageForShortVideo.forwardID;
        paramSessionInfo.a((ShortVideoForwardInfo)localObject);
      }
      ShortVideoBusiManager.a(paramSessionInfo, paramQQAppInterface);
      return;
    }
    QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsShareMsg paramAbsShareMsg)
  {
    a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
    ArkAppDataReport.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 2, 0, 0L, 0L, 0L, "LocationShare", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsStructMsg paramAbsStructMsg)
  {
    int i = paramSessionInfo.a;
    if ((i != 1000) && (i != 1004) && (i != 1020)) {}
    for (String str1 = paramQQAppInterface.getCurrentAccountUin();; str1 = paramSessionInfo.c) {
      break;
    }
    String str2 = paramQQAppInterface.getCurrentAccountUin();
    String str3 = paramSessionInfo.b;
    i = paramSessionInfo.a;
    int j = MobileQQService.seq;
    MobileQQService.seq = j + 1;
    paramSessionInfo = MessageRecordFactory.c(paramQQAppInterface, str2, str3, str1, i, j, paramAbsStructMsg);
    ForwardOrderManager.a().a(paramSessionInfo.uniseq, paramAbsStructMsg.parentUniseq, paramAbsStructMsg.forwardID);
    paramQQAppInterface.getMessageFacade().a(paramSessionInfo, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3)
  {
    if (paramSessionInfo != null)
    {
      if (android.text.TextUtils.isEmpty(paramSessionInfo.b)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ChatActivityConstants.a);
      localStringBuilder.append("http://maps.google.com/maps?q=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("&iwloc=A&hl=zh-CN (");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(")");
      b(paramQQAppInterface, paramSessionInfo, localStringBuilder.toString());
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, AbsShareMsg paramAbsShareMsg, String paramString5, String paramString6, String paramString7)
  {
    paramString7 = new ArkAppMessage();
    paramString6 = (ArkAIKeyWordConfBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkAIKeyWordConfBean.class);
    if ((paramString6 != null) && (paramString6.c().a)) {}
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
        paramString6 = HardCodeUtil.a(2131899781);
        if ((android.text.TextUtils.isEmpty(paramString7.appDesc)) || (paramString7.appDesc.equals(paramString7.appName))) {
          paramString7.appDesc = paramString6;
        }
        i = paramSessionInfo.a;
        if ((i != 1000) && (i != 1004) && (i != 1020)) {
          paramString6 = paramQQAppInterface.getCurrentAccountUin();
        } else {
          paramString6 = paramSessionInfo.c;
        }
      }
      catch (Exception paramString1) {}
      String str1 = paramQQAppInterface.getCurrentAccountUin();
      String str2 = paramSessionInfo.b;
      int i = paramSessionInfo.a;
      int j = MobileQQService.seq;
      MobileQQService.seq = j + 1;
      paramString7.containStructMsg = MessageRecordFactory.c(paramQQAppInterface, str1, str2, paramString6, i, j, paramAbsShareMsg);
      paramString7.promptText = String.format(HardCodeUtil.a(2131899794), new Object[] { paramString7.appDesc });
      paramString7.from = 1;
      paramString7.metaList = a(paramString5, paramString3, paramString4, paramString1, paramString2);
      paramString1 = new JSONObject();
      paramString1.put("forward", 1);
      paramString1.put("autosize", 1);
      paramString1.put("type", "card");
      paramString7.config = paramString1.toString();
      a(paramQQAppInterface, paramSessionInfo, paramString7, paramAbsShareMsg.forwardID);
      paramString1 = new StringBuilder();
      paramString1.append("send ark msg is success and arkMsg.metaList=");
      paramString1.append(paramString7.metaList);
      ArkAppCenter.a("sendArkStructMap", paramString1.toString());
      paramString1 = paramString7.appView;
      try
      {
        ArkAppDataReport.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 1, 0, 0L, 0L, 0L, paramString1, "");
        return;
      }
      catch (Exception paramString1) {}
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("ChatActivityFacade send arkMapMessage parameter error: ");
        paramString2.append(paramString1.getMessage());
        QLog.i("ArkApp", 1, paramString2.toString());
      }
      ArkAppCenter.a("sendArkStructMap", "parameter error and send ark msg is failed then send struct msg");
      a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
      return;
      ArkAppCenter.a("sendArkStructMap", "sIsArkStructMap is false then send struct msg");
      a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramSessionInfo.a != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.2(paramSessionInfo, paramQQAppInterface, paramBoolean), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface.getMessageFacade().h(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func tryFetchEmosmKey, app:");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append(",e:");
      ((StringBuilder)localObject).append(paramEmoticon);
      QLog.d("ChatActivityFacade", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramQQAppInterface != null) && (paramEmoticon != null) && (!android.text.TextUtils.isEmpty(paramEmoticon.epId)) && (!android.text.TextUtils.isEmpty(paramEmoticon.eId)))
    {
      if (!android.text.TextUtils.isEmpty(paramEmoticon.encryptKey)) {
        return;
      }
      localObject = (IEmojiManagerService)paramQQAppInterface.getRuntimeService(IEmojiManagerService.class);
      ThreadManager.post(new ChatActivityFacade.19(paramEmoticon, (IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class), (IEmojiManagerService)localObject), 5, null, true);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    ((LongArkMsgManager)paramQQAppInterface.getManager(QQManagerFactory.LONG_ARK_MSG_MANAGER)).a(paramQQAppInterface, paramMessageForArkApp, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).f(Long.valueOf(paramString).longValue());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      label21:
      break label21;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("insertCommonHobbyIfNeeded uin is: ");
      paramQQAppInterface.append(paramString);
      QLog.i("ChatActivityFacade", 2, paramQQAppInterface.toString());
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
    boolean bool = true;
    if (paramString != null) {
      paramString = MessageUtils.a(paramString, true, null);
    } else {
      paramString = "";
    }
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l1 = i;
    i = Math.abs(new Random().nextInt());
    int j = (int)MessageCache.c();
    String str = paramQQAppInterface.getCurrentAccountUin();
    long l2 = MessageUtils.a(i);
    ChatMessage localChatMessage = (ChatMessage)MessageRecordFactory.a(-1000);
    localChatMessage.init(str, "", str, paramString, j, -1000, 0, l1);
    localChatMessage.isread = true;
    localChatMessage.msgUid = l2;
    localChatMessage.shmsgseq = MessageUtils.a(l1, 0);
    localChatMessage.issend = 1;
    if (paramArrayList.size() > 10) {
      bool = false;
    }
    localChatMessage.needUpdateMsgTag = bool;
    ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localChatMessage);
    ((MessageForText)localChatMessage).msgVia = 0;
    paramQQAppInterface.getMessageFacade().a(paramQQAppInterface, localChatMessage, paramArrayList, paramHongbaoParams);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, MessageRecord paramMessageRecord, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (paramSendMsgParams.w)
    {
      b(paramQQAppInterface, paramBoolean, paramMessageRecord);
      return;
    }
    ThreadManager.post(new ChatActivityFacade.13(paramQQAppInterface, paramBoolean, paramMessageRecord), 10, null, false);
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt)
  {
    if ((!AppSetting.o) && (paramInt == 0)) {
      return;
    }
    if (UinTypeUtil.e(paramInt) == 1032) {
      return;
    }
    paramQQCustomMenu.a(2131431695, paramContext.getString(2131887718), 2130839061);
  }
  
  private static void a(String paramString, SessionInfo paramSessionInfo, AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg = new StringBuilder();
    paramAbsShareMsg.append("sendStrcutReportLog， actionData:");
    paramAbsShareMsg.append(paramString);
    paramAbsShareMsg.append("\n");
    paramAbsShareMsg.append("sessionInfo type: ");
    paramAbsShareMsg.append(paramSessionInfo.a);
    paramAbsShareMsg.append("\n");
    QLog.d("LBS.ChatActivityFacade", 1, paramAbsShareMsg.toString());
  }
  
  private static void a(String paramString1, SessionInfo paramSessionInfo, String paramString2, String paramString3, String paramString4, String paramString5, AbsShareMsg paramAbsShareMsg, String paramString6, String paramString7, String paramString8)
  {
    paramAbsShareMsg = new StringBuilder();
    paramAbsShareMsg.append("sendArkStructMapLog， actionData:");
    paramAbsShareMsg.append(paramString1);
    paramAbsShareMsg.append("\n");
    paramAbsShareMsg.append("sessionInfo type: ");
    paramAbsShareMsg.append(paramSessionInfo.a);
    paramAbsShareMsg.append("\n");
    paramAbsShareMsg.append("forwardLat: ");
    paramAbsShareMsg.append(paramString2);
    paramAbsShareMsg.append("\n");
    paramAbsShareMsg.append("forwardLon: ");
    paramAbsShareMsg.append(paramString3);
    paramAbsShareMsg.append("\n");
    paramAbsShareMsg.append("title: ");
    paramAbsShareMsg.append(paramString4);
    paramAbsShareMsg.append("\n");
    paramAbsShareMsg.append("summary: ");
    paramAbsShareMsg.append(paramString5);
    paramAbsShareMsg.append("\n");
    paramAbsShareMsg.append("poiId: ");
    paramAbsShareMsg.append(paramString6);
    paramAbsShareMsg.append("\n");
    paramAbsShareMsg.append("latSpan: ");
    paramAbsShareMsg.append(paramString7);
    paramAbsShareMsg.append("\n");
    paramAbsShareMsg.append("lngSpan: ");
    paramAbsShareMsg.append(paramString8);
    paramAbsShareMsg.append("\n");
    QLog.d("LBS.ChatActivityFacade", 1, paramAbsShareMsg.toString());
  }
  
  public static void a(List<ChatMessage> paramList)
  {
    if ((d != null) && (paramList != null) && (paramList.size() > 0))
    {
      int j = 0;
      int i = j;
      if (((ChatMessage)paramList.get(0)).isLongMsg())
      {
        Iterator localIterator = paramList.iterator();
        ChatMessage localChatMessage;
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
          localChatMessage = (ChatMessage)localIterator.next();
        } while ((localChatMessage.shmsgseq != d.shmsgseq) || (localChatMessage.msgUid != d.msgUid));
        i = 1;
      }
      if ((i != 0) || (paramList.contains(d)))
      {
        paramList = c;
        if (paramList != null) {
          paramList.dismiss();
        }
      }
    }
  }
  
  private static boolean a(SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.a;
    if ((i != 0) && (i != 3000)) {
      return i == 1;
    }
    return true;
  }
  
  private static boolean a(SessionInfo paramSessionInfo, String paramString, Bundle paramBundle)
  {
    if ((!android.text.TextUtils.isEmpty(paramString)) && (!paramString.equals("Unknown Address")))
    {
      if (paramBundle != null)
      {
        if (paramBundle.getInt("isArk") == 0)
        {
          ArkAppCenter.a("sendArkStructMap", "isSendArkMsg, isArk=0 and sendStructMsg");
          return false;
        }
        if (a(paramSessionInfo))
        {
          ArkAppCenter.a("sendArkStructMap", "isSendArkMsg, session is allowed and sendArkMsg");
          return true;
        }
        ArkAppCenter.a("sendArkStructMap", "isSendArkMsg, session is not allowed and sendStructMsg");
        return false;
      }
      ArkAppCenter.a("sendArkStructMap", "isSendArkMsg, extra is empty and sendStructMsg");
      return false;
    }
    ArkAppCenter.a("sendArkStructMap", "isSendArkMsg,could not find location and sendStructMsg");
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForLongMsg paramMessageForLongMsg)
  {
    paramContext = paramMessageForLongMsg.longMsgFragmentList;
    if ((paramContext != null) && (!paramContext.isEmpty()))
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        paramMessageForLongMsg = (MessageRecord)paramContext.next();
        if (paramMessageForLongMsg.extraflag == 32768)
        {
          if (paramMessageForLongMsg.isSendFromLocal()) {
            ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForLongMsg.frienduin, paramMessageForLongMsg.uniseq));
          }
          paramQQAppInterface.getMessageFacade().h(paramSessionInfo.b, paramSessionInfo.a, paramMessageForLongMsg.uniseq);
          if (paramMessageForLongMsg.msgtype == -1000)
          {
            paramMessageForLongMsg = MessageRecordFactory.a(paramMessageForLongMsg);
            paramQQAppInterface.getMessageFacade().a(paramMessageForLongMsg, null, true);
          }
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    MessageForArkApp localMessageForArkApp = MessageRecordFactory.b(paramQQAppInterface, paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a, paramArkAppMessage);
    ForwardOrderManager.a().a(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramArkAppMessage.forwardID);
    if (localMessageForArkApp.istroop == 1) {
      AnonymousChatHelper.a().a(localMessageForArkApp);
    }
    localMessageForArkApp.saveExtInfoToExtStr(MessageConstants.e, "1");
    paramArkAppMessage = (IArkAsyncShareMsgService)paramQQAppInterface.getRuntimeService(IArkAsyncShareMsgService.class, "");
    if ((paramArkAppMessage != null) && (localMessageForArkApp.ark_app_message != null))
    {
      paramArkAppMessage = paramArkAppMessage.getAsyncShareMsgManager();
      if (paramArkAppMessage != null)
      {
        bool = paramArkAppMessage.a(paramQQAppInterface, localMessageForArkApp.ark_app_message.appName, paramSessionInfo, localMessageForArkApp);
        break label124;
      }
    }
    boolean bool = false;
    label124:
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, new Object[] { "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(bool) });
    }
    if (!bool) {
      paramQQAppInterface.getMessageFacade().a(localMessageForArkApp, null);
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage, int paramInt)
  {
    MessageForArkApp localMessageForArkApp = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a, paramArkAppMessage);
    int i = paramInt;
    if (paramInt == 0) {
      i = paramArkAppMessage.forwardID;
    }
    ForwardOrderManager.a().a(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, i);
    if (localMessageForArkApp.istroop == 1) {
      AnonymousChatHelper.a().a(localMessageForArkApp);
    }
    paramArkAppMessage = (IArkAsyncShareMsgService)paramQQAppInterface.getRuntimeService(IArkAsyncShareMsgService.class, "");
    if ((paramArkAppMessage != null) && (localMessageForArkApp.ark_app_message != null))
    {
      paramArkAppMessage = paramArkAppMessage.getAsyncShareMsgManager();
      if (paramArkAppMessage != null)
      {
        bool = paramArkAppMessage.a(paramQQAppInterface, localMessageForArkApp.ark_app_message.appName, paramSessionInfo, localMessageForArkApp);
        break label126;
      }
    }
    boolean bool = false;
    label126:
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, new Object[] { "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(bool) });
    }
    if (!bool) {
      paramQQAppInterface.getMessageFacade().a(localMessageForArkApp, null);
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkFlashChatMessage paramArkFlashChatMessage)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramArkFlashChatMessage, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkFlashChatMessage paramArkFlashChatMessage, int paramInt)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a, paramArkFlashChatMessage);
    int i = paramInt;
    if (paramInt == 0) {
      i = paramArkFlashChatMessage.forwardID;
    }
    ForwardOrderManager.a().a(paramSessionInfo.uniseq, paramArkFlashChatMessage.uniSeq, i);
    if (paramSessionInfo.istroop == 1) {
      AnonymousChatHelper.a().a(paramSessionInfo);
    }
    paramQQAppInterface.getMessageFacade().a(paramSessionInfo, null);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, MessageObserver paramMessageObserver)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramHiBoomMessage, paramMessageObserver, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, MessageObserver paramMessageObserver, int paramInt)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a, paramHiBoomMessage);
    ForwardOrderManager.a().a(paramSessionInfo.uniseq, 0L, paramInt);
    if (paramSessionInfo.istroop == 1) {
      AnonymousChatHelper.a().a(paramSessionInfo);
    }
    paramQQAppInterface.getMessageFacade().a(paramSessionInfo, paramMessageObserver);
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForPtt))) {
      return ((MessageForPtt)paramQQAppInterface).c2cViaOffline;
    }
    return false;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append(" sendMessage start currenttime:");
      paramContext.append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, paramContext.toString());
    }
    if ((paramString != null) && (paramString.length() != 0) && (paramSendMsgParams != null) && (paramBaseSessionInfo != null))
    {
      if (android.text.TextUtils.isEmpty(paramBaseSessionInfo.b)) {
        return null;
      }
      paramContext = a(paramQQAppInterface, paramBaseSessionInfo, paramString, paramArrayList, paramSendMsgParams);
      if ((paramSendMsgParams != null) && (paramSendMsgParams.C) && (paramBaseSessionInfo != null) && (paramBaseSessionInfo.a == 1))
      {
        paramString = (TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          long l = paramContext[i];
          paramString.a(paramBaseSessionInfo.b, l);
          i += 1;
        }
      }
      ThreadManager.post(new ChatActivityFacade.15(paramSendMsgParams, paramQQAppInterface, paramBaseSessionInfo), 8, null, true);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(" sendMessage end currenttime:");
        paramQQAppInterface.append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, paramQQAppInterface.toString());
      }
      return paramContext;
    }
    return null;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" createTextMessageToshow start, currenttime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramString, paramArrayList);
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramString = new ArrayList();
    Random localRandom = new Random();
    paramString.add(localObject);
    localArrayList.add(paramArrayList);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append(" createTextMessageToshow step 2, currenttime:");
      paramArrayList.append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, paramArrayList.toString());
    }
    int i = Math.abs(localRandom.nextInt());
    localObject = new long[paramString.size()];
    int j = 0;
    paramArrayList = paramString;
    paramString = (String)localObject;
    while (j < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(j);
      if (localArrayList.size() > j) {
        localObject = (ArrayList)localArrayList.get(j);
      } else {
        localObject = null;
      }
      if ((paramBaseSessionInfo.a == 3000) || (paramBaseSessionInfo.a == 1)) {
        i = Math.abs(localRandom.nextInt());
      }
      paramString[j] = a(paramQQAppInterface, paramBaseSessionInfo, str, -1000, false, (byte)paramArrayList.size(), (byte)j, 0, i, (ArrayList)localObject, paramSendMsgParams);
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(" createTextMessageToshow step 3, currenttime:");
      paramQQAppInterface.append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, paramQQAppInterface.toString());
    }
    return paramString;
  }
  
  public static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = new ChatActivityFacade.17(paramContext, paramChatMessage, paramQQAppInterface);
    paramChatMessage = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramChatMessage.isActive();
    int i;
    if (((paramContext instanceof Activity)) && (bool))
    {
      Activity localActivity = (Activity)paramContext;
      i = 1;
      paramChatMessage.hideSoftInputFromWindow(localActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
      return;
    }
    paramQQAppInterface.run();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, 1, -1, "", "", 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131889169, 0);
      return;
    }
    MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.b, paramSessionInfo.a, paramLong);
    if (localMessageRecord == null)
    {
      ChatActivityUtils.a(paramContext, 2131916242, 0);
      return;
    }
    paramQQAppInterface.getMessageFacade().h(paramSessionInfo.b, paramSessionInfo.a, paramLong);
    paramContext = MessageRecordFactory.a(localMessageRecord);
    paramQQAppInterface.getMessageFacade().a(paramContext, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, new ChatActivityFacade.SendMsgParams());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.a != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.5(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIONewestFeedRsp paramAIONewestFeedRsp, boolean paramBoolean)
  {
    if ((paramAIONewestFeedRsp != null) && (paramAIONewestFeedRsp.uOpuin == Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue()) && (paramAIONewestFeedRsp.uFeedInfos != null) && (!paramAIONewestFeedRsp.uFeedInfos.isEmpty()))
    {
      int i;
      if ((paramAIONewestFeedRsp.mapEx != null) && (paramAIONewestFeedRsp.mapEx.containsKey("iGender")))
      {
        String str1 = (String)paramAIONewestFeedRsp.mapEx.get("iGender");
        try
        {
          i = Integer.parseInt(str1);
        }
        catch (Exception localException)
        {
          QLog.e("ChatActivityFacade.QZoneFeeds", 1, "gender parse error:", localException);
        }
      }
      else
      {
        i = 1;
      }
      Object localObject = (NewestFeedInfo)paramAIONewestFeedRsp.uFeedInfos.get(0);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage feedInfo == null");
        }
        return;
      }
      paramAIONewestFeedRsp = new boolean[1];
      long[] arrayOfLong = new long[1];
      String str2 = String.valueOf(((NewestFeedInfo)localObject).uHostUin);
      if (FeedsManager.isShowStatus(str2))
      {
        arrayOfLong[0] = FeedsManager.getToken(str2);
        paramAIONewestFeedRsp[0] = 1;
        FeedsManager.hideStatus(str2);
      }
      localObject = a((NewestFeedInfo)localObject, paramBoolean, i);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "jsonOb == null");
        }
        return;
      }
      ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.7(paramQQAppInterface, paramSessionInfo, (JSONObject)localObject, paramBoolean, paramAIONewestFeedRsp, arrayOfLong));
      return;
    }
    if ((paramAIONewestFeedRsp != null) && (paramAIONewestFeedRsp.uOpFlag == 1L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "newestFeed.uOpFlag==1  需要清理本地缓存");
      }
      y(paramQQAppInterface, paramSessionInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage 没有拉去到feeds信息");
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, CLIENT.StGetUserNewestStoryRsp paramStGetUserNewestStoryRsp)
  {
    if (paramStGetUserNewestStoryRsp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, " rsp is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" hasNewStory:");
      localStringBuilder.append(paramStGetUserNewestStoryRsp.hasNewStory.get());
      QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, localStringBuilder.toString());
    }
    if (paramStGetUserNewestStoryRsp.hasNewStory.get() == 1)
    {
      if (!paramStGetUserNewestStoryRsp.vecStoryFeed.isEmpty())
      {
        paramStGetUserNewestStoryRsp = (META.StStoryFeed)paramStGetUserNewestStoryRsp.vecStoryFeed.get(0);
        if (paramStGetUserNewestStoryRsp == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "addQzoneStoryFeedMessage storyFeed == null");
          }
          return;
        }
        a(paramQQAppInterface, paramSessionInfo, paramStGetUserNewestStoryRsp.createTime.get());
        ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.9(paramQQAppInterface, paramSessionInfo, paramStGetUserNewestStoryRsp));
        return;
      }
      ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.10(paramQQAppInterface, paramSessionInfo));
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, FeedCloudRead.StGetC2CFeedRsp paramStGetC2CFeedRsp, boolean paramBoolean)
  {
    if ((paramStGetC2CFeedRsp != null) && (!paramStGetC2CFeedRsp.vecFeed.isEmpty()))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)paramStGetC2CFeedRsp.vecFeed.get().get(0);
      if (localStFeed == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QCircleFeeds", 2, "addQCircleFeedMessageV2 feed == null");
        }
        return;
      }
      paramStGetC2CFeedRsp = a(localStFeed, paramBoolean, paramStGetC2CFeedRsp.share);
      if (paramStGetC2CFeedRsp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QCircleFeeds", 2, "jsonOb == null");
        }
        return;
      }
      ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.8(paramQQAppInterface, paramSessionInfo, paramStGetC2CFeedRsp, paramBoolean));
      return;
    }
    QLog.i("ChatActivityFacade.QCircleFeeds", 2, "addQCircleFeedMessageV2 没有拉到feeds信息");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramSessionInfo, paramString, 1010, false, (byte)1, (byte)0, (short)0, Math.abs(new Random().nextInt()), null, new ChatActivityFacade.SendMsgParams());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (!QzoneConfig.isQQCircleShowAIOFeedEntrance())
    {
      QLog.e("ChatActivityFacade.QCircleFeeds", 2, "insertQCircleNewestFeedIfNeeded: QzoneConfig.isQQCircleShowLebaEntrance()==false");
      return;
    }
    if (paramSessionInfo.a != 0)
    {
      QLog.e("ChatActivityFacade.QCircleFeeds", 2, "insertQCircleNewestFeedIfNeeded failed: sessionInfo.curType == AppConstants.VALUE.UIN_TYPE_FRIEND");
      return;
    }
    ThreadManager.post(new ChatActivityFacade.3(paramQQAppInterface, paramSessionInfo, paramBoolean), 5, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForFile))
    {
      FileManagerEntity localFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
      if ((localFileManagerEntity == null) && (QLog.isColorLevel())) {
        QLog.w("ChatActivityFacade", 2, "why FileManagerEntity is null?! may be is old data!");
      }
      if (paramChatMessage.isSendFromLocal()) {
        ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramChatMessage.frienduin, paramChatMessage.uniseq));
      }
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.getCloudType() == 0) {
          paramQQAppInterface.getOnlineFileSessionCenter().c(localFileManagerEntity.nSessionId);
        } else {
          paramQQAppInterface.getFileManagerRSCenter().a(localFileManagerEntity.nSessionId);
        }
        paramQQAppInterface.getFileManagerDataCenter().f(localFileManagerEntity);
        if (localFileManagerEntity.getCloudType() == 0) {
          paramQQAppInterface.getOnlineFileSessionCenter().f(localFileManagerEntity.nSessionId);
        }
        paramQQAppInterface.getFileManagerEngine().c(localFileManagerEntity.nSessionId);
      }
    }
    else
    {
      if ((paramChatMessage instanceof MessageForDevShortVideo))
      {
        ((DeviceFileHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(0, ((MessageForDevShortVideo)paramChatMessage).fileSessionId, false);
        return;
      }
      if ((paramChatMessage instanceof MessageForDevPtt)) {
        ((DeviceFileHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(0, ((MessageForDevPtt)paramChatMessage).fileSessionId, false);
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean, MessageRecord paramMessageRecord)
  {
    if (paramBoolean) {}
    try
    {
      paramQQAppInterface.getMessageFacade().c(paramMessageRecord);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ChatActivityFacade", 1, "doSendMsg life circle:", paramQQAppInterface);
    }
    paramQQAppInterface.getMessageFacade().a(paramMessageRecord, null);
    return;
  }
  
  public static void b(List<ChatMessage> paramList)
  {
    if ((f != null) && (paramList != null) && (paramList.size() > 0) && (f.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage1 = (ChatMessage)paramList.next();
        if (f.contains(localChatMessage1))
        {
          f.remove(localChatMessage1);
        }
        else if (localChatMessage1.isLongMsg())
        {
          Iterator localIterator = f.iterator();
          while (localIterator.hasNext())
          {
            ChatMessage localChatMessage2 = (ChatMessage)localIterator.next();
            if ((localChatMessage2.shmsgseq == localChatMessage1.shmsgseq) && (localChatMessage2.msgUid == localChatMessage1.msgUid)) {
              localIterator.remove();
            }
          }
        }
      }
      if (f.size() == 0)
      {
        paramList = e;
        if (paramList != null) {
          paramList.dismiss();
        }
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramArkAppMessage, 0);
  }
  
  public static long[] b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" createTextMessageToshow start, currenttime:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = a(paramString, paramArrayList);
    if (localObject2 == null) {
      return null;
    }
    paramString = new ArrayList();
    Object localObject1 = new ArrayList();
    Random localRandom = new Random();
    ((ArrayList)localObject1).add(localObject2);
    paramString.add(paramArrayList);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append(" createTextMessageToshow step 2, currenttime:");
      paramArrayList.append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, paramArrayList.toString());
    }
    int i = Math.abs(localRandom.nextInt());
    paramArrayList = new long[((ArrayList)localObject1).size()];
    int j = 0;
    while (j < ((ArrayList)localObject1).size())
    {
      String str = (String)((ArrayList)localObject1).get(j);
      if (paramString.size() > j) {
        localObject2 = (ArrayList)paramString.get(j);
      } else {
        localObject2 = null;
      }
      if ((paramSessionInfo.a == 3000) || (paramSessionInfo.a == 1)) {
        i = Math.abs(localRandom.nextInt());
      }
      paramArrayList[j] = a(paramQQAppInterface, paramSessionInfo, str, -1000, false, (byte)((ArrayList)localObject1).size(), (byte)j, 0, i, (ArrayList)localObject2, paramSendMsgParams, true);
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(" createTextMessageToshow step 3, currenttime:");
      paramQQAppInterface.append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, paramQQAppInterface.toString());
    }
    return paramArrayList;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.a != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.6(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  @TargetApi(9)
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ChatActivityFacade", 1, "insertRenewalTailTipMsgIfNeeded app == null");
      return;
    }
    if (SimpleUIUtil.e()) {
      return;
    }
    int i = paramSessionInfo.a;
    if ((i == 0) || (i == 1) || (i == 3000))
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 4);
      if (!paramBoolean)
      {
        long l = localSharedPreferences.getLong("last_pull_individual_expire_info_time", 0L);
        if (System.currentTimeMillis() - l <= 86400000L) {
          return;
        }
        paramQQAppInterface = (IApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface.a(((IVasGrayTips)QRoute.api(IVasGrayTips.class)).transformFrom(i), paramSessionInfo.b);
          if (Build.VERSION.SDK_INT <= 8)
          {
            localSharedPreferences.edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).commit();
            return;
          }
          localSharedPreferences.edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).apply();
        }
      }
    }
  }
  
  @TargetApi(9)
  private static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      if (paramQQAppInterface == null) {
        return false;
      }
      Object localObject = ((IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramString);
      if (localObject != null)
      {
        if ((((EmoticonPackage)localObject).extraFlags & 0x1) <= 0) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isShowEmotionRewordTips epId = ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("ChatActivityFacade", 2, ((StringBuilder)localObject).toString());
        }
        localObject = paramQQAppInterface.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("originalEmotionCountSp_");
        localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
        paramQQAppInterface = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        int i = paramQQAppInterface.getInt(paramString, 0) + 1;
        paramQQAppInterface = paramQQAppInterface.edit();
        paramQQAppInterface.putInt(paramString, i);
        if (Build.VERSION.SDK_INT <= 8) {
          paramQQAppInterface.commit();
        } else {
          paramQQAppInterface.apply();
        }
        if (i == 21) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static long[] c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" sendMessage start currenttime:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (paramString.length() != 0) && (paramSessionInfo != null))
    {
      if (android.text.TextUtils.isEmpty(paramSessionInfo.b)) {
        return null;
      }
      paramString = b(paramQQAppInterface, paramSessionInfo, paramString, null, localSendMsgParams);
      ThreadManager.post(new ChatActivityFacade.14(localSendMsgParams, paramQQAppInterface, paramSessionInfo), 8, null, true);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(" sendMessage end currenttime:");
        paramQQAppInterface.append(System.currentTimeMillis());
        QLog.d("SendMsgBtn", 2, paramQQAppInterface.toString());
      }
      return paramString;
    }
    return null;
  }
  
  public static long d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)a(paramQQAppInterface, paramString, paramSessionInfo, -3, 0);
    if (localMessageForPtt != null)
    {
      long l = localMessageForPtt.uniseq;
      if (l != -1L)
      {
        int i = ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(localMessageForPtt);
        int j = RecordParams.a(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
        a(paramQQAppInterface, paramSessionInfo.a, paramSessionInfo.b, paramString, l, true, i * 1000, j, true, 0, 0, true, localMessageForPtt.vipSubBubbleId, localBundle);
      }
      return l;
    }
    return 0L;
  }
  
  public static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-4005);
    long l = MessageCache.c();
    localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.b, paramSessionInfo.b, BaseApplicationImpl.getContext().getString(2131891530), l, -4005, paramSessionInfo.a, l);
    localMessageRecord.isread = true;
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageRecord, false)) {
      paramQQAppInterface.getMessageFacade().a(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  public static MessageRecord e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (UinTypeUtil.b(paramSessionInfo.a))
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().h(paramSessionInfo.b, paramSessionInfo.a);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        int i = paramQQAppInterface.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
          if (!MessageRecordInfo.c(paramSessionInfo.issend)) {
            return paramSessionInfo;
          }
          i -= 1;
        }
      }
    }
    return null;
  }
  
  public static MessageRecord f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (UinTypeUtil.b(paramSessionInfo.a))
    {
      List localList = paramQQAppInterface.getMessageFacade().h(paramSessionInfo.b, paramSessionInfo.a);
      if ((localList != null) && (!localList.isEmpty()))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)localList.get(i);
          if (!MessageRecordInfo.c(paramSessionInfo.issend))
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
  
  private static long g(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null))
    {
      if (paramSessionInfo == null) {
        return 0L;
      }
      return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(j(paramQQAppInterface, paramSessionInfo, paramString), 0L);
    }
    return 0L;
  }
  
  public static void g(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject1 = new EventItem(18, null);
    ((EventItem)localObject1).eventType = 538052865;
    Object localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("utf-8");
    ((EventItem)localObject1).writeTo((JceOutputStream)localObject2);
    localObject1 = new String(((JceOutputStream)localObject2).toByteArray());
    localObject2 = paramQQAppInterface.getMsgHandler();
    paramSessionInfo = paramSessionInfo.b;
    paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    ((MessageHandler)localObject2).a(paramSessionInfo, (String)localObject1, (byte)18, paramQQAppInterface, i, -1L);
  }
  
  private static boolean g(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (paramSessionInfo == null) {
        return false;
      }
      if (QZoneHelper.hideAioFeeds())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "wns 下发配置 要隐藏aio feeds，所以也不发请求了");
        }
        return false;
      }
      if (paramBoolean) {
        return p(paramQQAppInterface, paramSessionInfo);
      }
      return true;
    }
    return false;
  }
  
  private static void h(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null))
    {
      if (paramSessionInfo == null) {
        return;
      }
      paramSessionInfo = j(paramQQAppInterface, paramSessionInfo, paramString);
      paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramSessionInfo, NetConnInfoCenter.getServerTimeMillis()).apply();
    }
  }
  
  private static boolean h(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (paramSessionInfo == null) {
        return false;
      }
      if (!QCircleConfigHelper.c(StudyModeManager.h()))
      {
        QLog.i("ChatActivityFacade.QCircleFeeds", 2, "isNeedInsertQCircleNewestFeeds==false: 非小世界灰度用户");
        return false;
      }
      if (QZoneHelper.hideAioQCircleFeeds())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QCircleFeeds", 2, "wns 下发配置 要隐藏aio qcircle feeds，所以也不发请求了");
        }
        return false;
      }
      if (paramBoolean) {
        return q(paramQQAppInterface, paramSessionInfo);
      }
      return true;
    }
    return false;
  }
  
  private static void i(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null))
    {
      if (paramSessionInfo == null) {
        return;
      }
      paramSessionInfo = j(paramQQAppInterface, paramSessionInfo, "key_request_troop_qcircle_msg_attache_data");
      paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putString(paramSessionInfo, paramString).apply();
    }
  }
  
  private static boolean i(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (paramSessionInfo == null) {
        return false;
      }
      if (QZoneHelper.disableAioStoryFeedReq()) {
        return false;
      }
      if (paramBoolean) {
        return r(paramQQAppInterface, paramSessionInfo);
      }
      return true;
    }
    return false;
  }
  
  private static String j(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    paramSessionInfo = paramSessionInfo.b;
    paramString = new StringBuilder(paramString);
    paramString.append("_");
    paramString.append(paramQQAppInterface);
    paramString.append("_");
    paramString.append(paramSessionInfo);
    return paramString.toString();
  }
  
  private static void n(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface != null)
    {
      if (paramSessionInfo == null) {
        return;
      }
      Object localObject1 = paramQQAppInterface.getMessageFacade();
      Object localObject2 = paramSessionInfo.b;
      int j = 0;
      int i = 0;
      localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, 0, new int[] { -2015 });
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof MessageForQzoneFeed)) && (((MessageForQzoneFeed)localObject2).isOldStructMsg))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ChatActivityFacade.QZoneFeeds", 2, "删除老结构的feeds");
            }
            paramQQAppInterface.getMessageFacade().a(((MessageRecord)localObject2).frienduin, 0, ((MessageRecord)localObject2).msgtype, ((MessageRecord)localObject2).uniseq);
            paramQQAppInterface.getMessageFacade().h(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq);
            i = 1;
          }
        }
      }
      if (j != 0) {
        t(paramQQAppInterface, paramSessionInfo);
      }
    }
  }
  
  private static boolean o(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (FeedsManager.isShowStatus(paramSessionInfo.b))
    {
      x(paramQQAppInterface, paramSessionInfo);
      t(paramQQAppInterface, paramSessionInfo);
      return true;
    }
    return false;
  }
  
  private static boolean p(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null))
    {
      if (paramSessionInfo == null) {
        return false;
      }
      long l1 = g(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_feeds_time");
      l1 = NetConnInfoCenter.getServerTimeMillis() - l1;
      long l2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "requestAIOFeedsDiv", 900000);
      if (l1 > l2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
      }
    }
    return false;
  }
  
  private static boolean q(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null))
    {
      if (paramSessionInfo == null) {
        return false;
      }
      long l1 = g(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_qcircle_feeds_time");
      l1 = NetConnInfoCenter.getServerTimeMillis() - l1;
      long l2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "requestAIOQCircleFeedsDiv", 900000);
      if (l1 > l2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QCircleFeeds", 2, String.format("与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QCircleFeeds", 2, String.format("与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
      }
    }
    return false;
  }
  
  private static boolean r(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null))
    {
      if (paramSessionInfo == null) {
        return false;
      }
      long l = g(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_story_feed_time");
      l = NetConnInfoCenter.getServerTimeMillis() - l;
      if (l > 900000L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l), Long.valueOf(900000L) }));
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l), Long.valueOf(900000L) }));
      }
    }
    return false;
  }
  
  private static String s(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null))
    {
      if (paramSessionInfo == null) {
        return "";
      }
      return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getString(j(paramQQAppInterface, paramSessionInfo, "key_request_troop_qcircle_msg_attache_data"), "");
    }
    return "";
  }
  
  private static void t(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null))
    {
      if (paramSessionInfo == null) {
        return;
      }
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0);
      paramQQAppInterface = j(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_feeds_time");
      localSharedPreferences.edit().remove(paramQQAppInterface).apply();
    }
  }
  
  private static long u(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null))
    {
      if (paramSessionInfo == null) {
        return 0L;
      }
      paramSessionInfo = j(paramQQAppInterface, paramSessionInfo, "key_last_story_feed_create_time_for_aio");
      return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(paramSessionInfo, 0L);
    }
    return 0L;
  }
  
  private static long v(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   start");
    }
    BeancurdMsg localBeancurdMsg = ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).b(paramSessionInfo.b, paramSessionInfo.a, 12);
    long l1;
    if (localBeancurdMsg != null)
    {
      try
      {
        l1 = new JSONObject(localBeancurdMsg.buffer).optLong("time", 0L);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ChatActivityFacade.QZoneFeeds", 1, "", localJSONException);
        l1 = 0L;
      }
    }
    else
    {
      Object localObject = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.b, 0, new int[] { -2015 });
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (MessageForQzoneFeed)((List)localObject).get(((List)localObject).size() - 1);
        if (localObject != null)
        {
          ((MessageForQzoneFeed)localObject).parse();
          l1 = ((MessageForQzoneFeed)localObject).feedTime;
          break label167;
        }
      }
      l1 = 0L;
      label167:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getLastFeedsPublishTimeV2   没有qzone历史豆腐块,sessionInfo.curFriendUin=");
        ((StringBuilder)localObject).append(paramSessionInfo.b);
        ((StringBuilder)localObject).append(",sessionInfo.curType=");
        ((StringBuilder)localObject).append(paramSessionInfo.a);
        ((StringBuilder)localObject).append(" busiID=");
        ((StringBuilder)localObject).append(2);
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, ((StringBuilder)localObject).toString());
      }
    }
    long l2 = l1;
    if (l1 == 0L) {
      l2 = w(paramQQAppInterface, paramSessionInfo);
    }
    return l2;
  }
  
  private static long w(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.b, 0, new int[] { -2015 });
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = (MessageRecord)paramQQAppInterface.get(0);
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForQzoneFeed)))
      {
        paramSessionInfo = (MessageForQzoneFeed)paramQQAppInterface;
        paramSessionInfo.parse();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("获取到最新空间feeds的：");
          localStringBuilder.append(String.valueOf(paramQQAppInterface));
          localStringBuilder.append("：feeds json:");
          localStringBuilder.append(paramSessionInfo.feedMsg);
          QLog.w("ChatActivityFacade.QZoneFeeds", 2, localStringBuilder.toString());
        }
        return paramSessionInfo.feedTime;
      }
      if (QLog.isColorLevel())
      {
        paramSessionInfo = new StringBuilder();
        paramSessionInfo.append("message record 有误:");
        paramSessionInfo.append(String.valueOf(paramQQAppInterface));
        QLog.w("ChatActivityFacade.QZoneFeeds", 2, paramSessionInfo.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("ChatActivityFacade.QZoneFeeds", 2, "message recode 为空，无法获取发布时间");
    }
    return 0L;
  }
  
  private static void x(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramSessionInfo = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.b, 0, new int[] { -2015 });
    if (paramSessionInfo != null)
    {
      paramSessionInfo = paramSessionInfo.iterator();
      while (paramSessionInfo.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramSessionInfo.next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.getMessageFacade().h(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          SharedPreUtils.a(paramQQAppInterface.getCurrentUin(), localMessageRecord.frienduin, 0L);
        }
      }
    }
  }
  
  private static void y(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    a(12, paramQQAppInterface, paramSessionInfo);
  }
  
  private static void z(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "hasNewFlag == 1,且storyFeeds.size =0 ,视为后台让客户端，需要清理本地缓存");
    ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).c(paramSessionInfo.b, paramSessionInfo.a, 7);
    Object localObject = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.b, 0, new int[] { -2074 });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.getMessageFacade().h(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
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