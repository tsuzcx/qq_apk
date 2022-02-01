package com.tencent.biz.pubaccount.util.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

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
  
  public abstract void cleanPublicAccountObserver();
  
  public abstract String constructAttributeL();
  
  public abstract void createFakeStructingMsgWithFields(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract String createStructingMsgBrief(AppInterface paramAppInterface, Object paramObject);
  
  public abstract void deletePubAccountMsg(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt, long paramLong, boolean paramBoolean);
  
  public abstract void doVideoPlayRealtimeReport(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void enterTimTeam(Context paramContext, AppInterface paramAppInterface);
  
  public abstract void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, IPublicAccountObserver paramIPublicAccountObserver);
  
  public abstract void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, IPublicAccountObserver paramIPublicAccountObserver, int paramInt);
  
  public abstract void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, IPublicAccountObserver paramIPublicAccountObserver, boolean paramBoolean);
  
  public abstract void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, IPublicAccountObserver paramIPublicAccountObserver, boolean paramBoolean, int paramInt);
  
  public abstract void followUin(AppInterface paramAppInterface, Context paramContext, String paramString, IPublicAccountObserver paramIPublicAccountObserver, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public abstract int getAccountType(int paramInt);
  
  public abstract int getAccountType(AppInterface paramAppInterface, String paramString);
  
  public abstract int getAccountType(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract long getAccountType2(long paramLong);
  
  public abstract String getNickName(AppInterface paramAppInterface, String paramString);
  
  public abstract int getPubAccountRecentUserPosInMessageList(String paramString);
  
  public abstract NewIntent getPublicAccountDetailRequest(AppInterface paramAppInterface, Context paramContext, MqqHandler paramMqqHandler, String paramString);
  
  public abstract String getSourceId(String paramString);
  
  public abstract int getUinType(AppInterface paramAppInterface, String paramString);
  
  public abstract String getVersionInfo();
  
  public abstract void gotoProfile(Intent paramIntent, AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt);
  
  public abstract void gotoProfileForResult(Intent paramIntent, AppInterface paramAppInterface, Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract boolean isComeFromReadInJoy();
  
  public abstract boolean isDeleteOldKandian(AppInterface paramAppInterface);
  
  public abstract boolean isFollowUin(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean isInterestAccount(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean isInterestAccountOrUnSupportMsgType(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract boolean isKandianHost(String paramString);
  
  public abstract boolean isKandianNeedAddSkinParamsUrl(String paramString);
  
  public abstract boolean isKandianUrl(String paramString);
  
  public abstract boolean isMediaAndOtherSubscript(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean isMsgTabStoryNodeListVisible();
  
  public abstract boolean isPublicAccountUrl(String paramString);
  
  public abstract boolean isQWalletPubAccount(Object paramObject);
  
  public abstract boolean isQZoneWithReadInJoyUrl(String paramString);
  
  public abstract boolean isSubscript(int paramInt, long paramLong);
  
  public abstract void modifyIntentForSpecificBrowserIfNeeded(Intent paramIntent, String paramString);
  
  public abstract void modifyIntentForSpecificBrowserIfNeeded(MessageRecord paramMessageRecord, Intent paramIntent, String paramString);
  
  public abstract void onPublicAccountArkMsgClick(AppInterface paramAppInterface, ChatMessage paramChatMessage);
  
  public abstract void onRecentConversationPublicAccountFolderClick(AppInterface paramAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData);
  
  public abstract void openPublicAccountProfile(Intent paramIntent, Context paramContext, String paramString);
  
  public abstract JSONObject parseString2Json(String paramString);
  
  public abstract IPublicAccountDetail queryAccountDetail(AppInterface paramAppInterface, String paramString);
  
  public abstract void removeLbsUin(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportForPublicAccountExposure(String paramString);
  
  public abstract void reportPAShareButtonEvent(String paramString);
  
  public abstract void reportPAShareItemEvent(int paramInt1, String paramString, int paramInt2);
  
  public abstract void reportPAShareItemEvent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void resetDeleteOldKandian();
  
  public abstract void sendDetailInfoRequest(AppInterface paramAppInterface, Context paramContext, String paramString);
  
  public abstract void setComeFromReadInJoy(boolean paramBoolean);
  
  public abstract void setLSAccountDetailRequestHandler(Handler paramHandler);
  
  public abstract boolean shouldPreloadWebProcess(String paramString);
  
  public abstract boolean shouldUseWebviewSwitchFunction();
  
  public abstract boolean showPubAccUin(AppInterface paramAppInterface);
  
  public abstract void unfollowUin(AppInterface paramAppInterface, Context paramContext, String paramString, boolean paramBoolean, IPublicAccountObserver paramIPublicAccountObserver);
  
  public abstract void unfollowUin(AppInterface paramAppInterface, Context paramContext, String paramString, boolean paramBoolean1, IPublicAccountObserver paramIPublicAccountObserver, boolean paramBoolean2);
  
  public abstract void updateDeleteOldKandian(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract void videoPlayRealtimeReport(String paramString1, String paramString2, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
 * JD-Core Version:    0.7.0.1
 */