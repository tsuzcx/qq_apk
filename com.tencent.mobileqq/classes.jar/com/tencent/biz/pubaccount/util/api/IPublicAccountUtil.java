package com.tencent.biz.pubaccount.util.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseVideoArticleInfo;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

@QAPI(process={"all"})
public abstract interface IPublicAccountUtil
  extends QRouteApi
{
  public static final int MSG_RECENT_CLICK_ONCE = 200;
  public static final String NEED_FINISH = "need_finish";
  public static final int PB_PROTOCOL_VERSION = 1;
  public static final int PUBLIC_ACCOUNT_OPEN_PROFILE_SOURCE_AIO = 1;
  public static final int PUBLIC_ACCOUNT_OPEN_PROFILE_SOURCE_AIO_BUBBLE = 2;
  public static final int PUBLIC_ACCOUNT_OPEN_PROFILE_SOURCE_BMQQ_PROFILE = 3;
  public static final int PUBLIC_ACCOUNT_OPEN_PROFILE_SOURCE_ECSHOP = 4;
  public static final int PUBLIC_ACCOUNT_TYPE_BMQQ = -6;
  public static final int PUBLIC_ACCOUNT_TYPE_CERTIFIED = -10;
  public static final int PUBLIC_ACCOUNT_TYPE_EQQ = -7;
  public static final int PUBLIC_ACCOUNT_TYPE_INTEREST = -2;
  public static final int PUBLIC_ACCOUNT_TYPE_MEDIA = -3;
  public static final int PUBLIC_ACCOUNT_TYPE_OM = -8;
  public static final int PUBLIC_ACCOUNT_TYPE_OTHER_SUBSCRIPT = -4;
  public static final int PUBLIC_ACCOUNT_TYPE_SCHOOL = -9;
  public static final int PUBLIC_ACCOUNT_TYPE_SERVICE = -11;
  public static final int PUBLIC_ACCOUNT_TYPE_SHOP = -5;
  public static final int PUBLIC_ACCOUNT_TYPE_UNKNOW = -1;
  public static final String TAG = "PublicAccountUtil";
  public static final String TAG_FROM_READINJOY = "is_come_from_readinjoy";
  public static final String UIN_FOR_HEALTH = "3026775809";
  public static final String UIN_FOR_SHOP = "3046055438";
  public static final String UIN_FOR_WALLET = "2711679534";
  public static final String VIDEO_REALTIME_REPORT_AID = "VIDEO_REALTIME_REPORT_AID";
  public static final String VIDEO_REALTIME_REPORT_RCODE = "VIDEO_REALTIME_REPORT_RCODE";
  public static final String VIDEO_REALTIME_REPORT_RTYPE = "VIDEO_REALTIME_REPORT_RTYPE";
  public static final String VIDEO_REALTIME_REPORT_URL = "https://c.mp.qq.com/post/pageview/report?ftype=5&ctype=1&aid=%s&vid=%s&rtype=%d&rowkey=%s";
  public static final String VIDEO_REALTIME_REPORT_VID = "VIDEO_REALTIME_REPORT_VID";
  
  public abstract String addSkinParams(String paramString);
  
  public abstract boolean articleReport(String paramString1, int paramInt, String paramString2);
  
  public abstract int caculateMsgTabRedPntExcludeSelf(String paramString);
  
  public abstract void checkGotoProfileOrShowAcntNotCoherentDlg(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams);
  
  public abstract void cleanPublicAccountObserver();
  
  public abstract String constructAttributeL();
  
  public abstract boolean convert0xcf8ToMobileMP(byte[] paramArrayOfByte, oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse1);
  
  public abstract void createFakeStructingMsgWithFields(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract String createStructMsgBriefFromArticleInfo(ArticleInfo paramArticleInfo, ReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack);
  
  public abstract String createStructingMsgBrief(QQAppInterface paramQQAppInterface, BaseArticleInfo paramBaseArticleInfo);
  
  public abstract String createStructingMsgBrief(QQAppInterface paramQQAppInterface, BaseVideoArticleInfo paramBaseVideoArticleInfo);
  
  public abstract String createStructingMsgBriefPrefix(QQAppInterface paramQQAppInterface, BaseArticleInfo paramBaseArticleInfo);
  
  public abstract String createStructingMsgBriefSuffix(BaseArticleInfo paramBaseArticleInfo);
  
  public abstract void deletePubAccountMsg(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, long paramLong, boolean paramBoolean);
  
  public abstract void doVideoPlayRealtimeReport(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void enterTimTeam(Context paramContext, QQAppInterface paramQQAppInterface);
  
  public abstract void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver);
  
  public abstract void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, int paramInt);
  
  public abstract void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean);
  
  public abstract void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean, int paramInt);
  
  public abstract void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public abstract int getAccountType(int paramInt);
  
  public abstract int getAccountType(AppInterface paramAppInterface, String paramString);
  
  public abstract long getAccountType2(long paramLong);
  
  public abstract PaConfigAttr.PaConfigInfo getMessageHistoryInfo(AccountDetail paramAccountDetail);
  
  public abstract Integer getMessageSetting(AccountDetail paramAccountDetail);
  
  public abstract String getNickName(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract int getPubAccountRecentUserPosInMessageList(String paramString);
  
  public abstract NewIntent getPublicAccountDetailRequest(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, String paramString);
  
  public abstract String getSourceId(String paramString);
  
  public abstract int getUinType(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract String getVersionInfo();
  
  public abstract void gotoProfile(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt);
  
  public abstract void gotoProfileForResult(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract boolean isComeFromReadInJoy();
  
  public abstract boolean isDeleteOldKandian(QQAppInterface paramQQAppInterface);
  
  public abstract boolean isFollowUin(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean isInterestAccount(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract boolean isInterestAccountOrUnSupportMsgType(QQAppInterface paramQQAppInterface, String paramString, int paramInt);
  
  public abstract boolean isKandianHost(String paramString);
  
  public abstract boolean isKandianNeedAddSkinParamsUrl(String paramString);
  
  public abstract boolean isKandianUrl(String paramString);
  
  public abstract boolean isMediaAndOtherSubscript(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract boolean isMsgTabStoryNodeListVisible();
  
  public abstract boolean isPublicAccountUrl(String paramString);
  
  public abstract boolean isQWalletPubAccount(SessionInfo paramSessionInfo);
  
  public abstract boolean isQZoneWithReadInJoyUrl(String paramString);
  
  public abstract boolean isShopOrServiceAccount(AccountDetail paramAccountDetail);
  
  public abstract boolean isSubscript(int paramInt, long paramLong);
  
  public abstract void modifyIntentForSpecificBrowserIfNeeded(Intent paramIntent, String paramString);
  
  public abstract void modifyIntentForSpecificBrowserIfNeeded(MessageRecord paramMessageRecord, Intent paramIntent, String paramString);
  
  public abstract void newKanDianOidbReport(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, int paramInt);
  
  public abstract void onPublicAccountArkMsgClick(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage);
  
  public abstract void onRecentConversationPublicAccountFolderClick(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData);
  
  public abstract void openPublicAccountProfile(Intent paramIntent, Context paramContext, String paramString);
  
  public abstract JSONObject parseString2Json(String paramString);
  
  public abstract String pickOutFreakingPhoneNumber(AccountDetail paramAccountDetail);
  
  public abstract AccountDetail queryAccountDetail(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract void removeLbsUin(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract void reportForPublicAccountExposure(String paramString);
  
  public abstract void reportPAShareButtonEvent(String paramString);
  
  public abstract void reportPAShareItemEvent(int paramInt1, String paramString, int paramInt2);
  
  public abstract void reportPAShareItemEvent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void reportPushEffectEvent(int paramInt, List<oidb_cmd0x80a.AttributeList> paramList);
  
  public abstract void reportPushEffectEventForTaskManager(int paramInt1, int paramInt2, List<oidb_cmd0x80a.AttributeList> paramList);
  
  public abstract void resetDeleteOldKandian();
  
  public abstract void sendDetailInfoRequest(AppInterface paramAppInterface, Context paramContext, String paramString);
  
  public abstract void setComeFromReadInJoy(boolean paramBoolean);
  
  public abstract void setLSAccountDetailRequestHandler(Handler paramHandler);
  
  public abstract void setMessageSetting(AccountDetail paramAccountDetail, int paramInt);
  
  public abstract boolean shouldPreloadWebProcess(String paramString);
  
  public abstract boolean shouldUseWebviewSwitchFunction();
  
  public abstract boolean showPubAccUin(QQAppInterface paramQQAppInterface);
  
  public abstract void unfollowUin(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, PublicAccountObserver paramPublicAccountObserver);
  
  public abstract void unfollowUin(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean1, PublicAccountObserver paramPublicAccountObserver, boolean paramBoolean2);
  
  public abstract void updateDeleteOldKandian(QQAppInterface paramQQAppInterface, boolean paramBoolean);
  
  public abstract void videoPlayRealtimeReport(String paramString1, String paramString2, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
 * JD-Core Version:    0.7.0.1
 */