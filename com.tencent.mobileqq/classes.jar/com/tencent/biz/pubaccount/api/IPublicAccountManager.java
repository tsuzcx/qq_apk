package com.tencent.biz.pubaccount.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

@QAPI(process={"all"})
public abstract interface IPublicAccountManager
  extends QRouteApi
{
  public static final String CMD_GET_RECVMSG_STATE = "ConfigSvc.getRecvMsgState";
  public static final String CMD_SET_RECVMSG_STATE = "ConfigSvc.setRecvMsgState";
  public static final String MENU_CACHE_TIME = "menuCacheTime";
  public static final String MENU_EVENT_SHAREPRE = "menuEventSharePre";
  public static final int MENU_TYPE_3x5 = 0;
  public static final int MENU_TYPE_ICON = 1;
  public static final int MENU_TYPE_TEXT = 2;
  public static final int MENU_UPDATE_NEXTTIME = 2;
  public static final int MENU_UPDATE_NOW = 1;
  public static final String MENU_UPDATE_TYPE = "update_type";
  public static final String PA_ACTION_LOCATION_RESULT = "com.tencent.biz.pubaccount.locationResultAction";
  public static final String PA_ACTION_PIC_RESULT = "com.tencent.biz.pubaccount.picResultAction";
  public static final String PA_ACTION_SCAN_RESULT = "com.tencent.biz.pubaccount.scanResultAction";
  public static final String PA_DATA_LOCATION_LATITUDE = "latitude";
  public static final String PA_DATA_LOCATION_LONGITUDE = "longitude";
  public static final String PA_DATA_LOCATION_NAME = "name";
  public static final String PA_DATA_PIC_RESULT = "com.tencent.biz.pubaccount.picResultData";
  public static final String PA_DATA_PIC_RESULT_FILEMD5S = "com.tencent.biz.pubaccount.picResult_md5s";
  public static final String PA_DATA_SCAN_RESULT = "com.tencent.biz.pubaccount.scanResultData";
  public static final String PA_DATA_SCAN_RESULT_TYPE = "com.tencent.biz.pubaccount.scanResultType";
  public static final String PA_PERMISSION_BROADCAST = "com.tencent.msg.permission.pushnotify";
  public static final String SSO_COMMAND_ACCOUNT_DETAIL_DYNAMIC_LIST = "pull_account_detail_dynamic_list";
  public static final String SSO_COMMAND_GET_ACCOUNT_MENU = "get_account_menu";
  public static final String SSO_COMMAND_GET_ACCOUNT_MENU_NEW = "CertifiedAccountSvc.certified_account_read.GetAccountMenu";
  public static final String SSO_COMMAND_GET_DETAIL_INFO = "get_detail_info";
  public static final String SSO_COMMAND_GET_FOLLOW = "follow";
  public static final String SSO_COMMAND_GET_FOLLOW_LIST = "get_follow_list";
  public static final String SSO_COMMAND_GET_FOLLOW_LIST_NEW = "CertifiedAccountSvc.certified_account_read.GetFollowList";
  public static final String SSO_COMMAND_GET_GUIDE_FRIENDS = "getGuideFriends";
  public static final String SSO_COMMAND_GET_RECOMMEND_LIST = "get_business_recommend";
  public static final String SSO_COMMAND_GET_RECV_MSG = "set_recv_msg";
  public static final String SSO_COMMAND_GET_SHARE_LBS = "set_share_lbs";
  public static final String SSO_COMMAND_GET_SHARE_LIST = "get_share_list";
  public static final String SSO_COMMAND_GET_TO_PUBLIC = "share_to_public";
  public static final String SSO_COMMAND_GET_UNFOLLOW = "unfollow";
  public static final String SSO_COMMAND_PREFIX = "PubAccountSvc";
  public static final String SSO_COMMAND_PRE_SEND_MSG_INFO = "send_pre_message_status";
  public static final String SSO_COMMAND_PULL_AIO_HISTORY_MSG = "pull_aio_history_msg";
  public static final String SSO_COMMAND_SEC_MSG_CONFIGS = "secmsg.configs";
  public static final String SSO_COMMAND_SEND_GET_SUBSCRIBE = "get_message_configuration";
  public static final String SSO_COMMAND_SEND_MENU_EVENT = "send_menu_evt";
  public static final String SSO_COMMAND_SEND_MENU_EVENT_NEW = "CertifiedAccountSvc.certified_account_write.SendMenuEvent";
  public static final String SSO_COMMAND_SEND_MSG_RECEIPT = "send_msg_receipt";
  public static final String SSO_COMMAND_SEND_PAY_INFO = "send_pay_info";
  public static final String SSO_COMMAND_SEND_REFUSE_CMD = "set_refuse_follow";
  public static final String SSO_COMMAND_SEND_SET_SUBSCRIBE = "set_message_configuration";
  public static final String SSO_COMMAND_SET_PUBLIC_FLAG = "set_function_flag";
  public static final String TAG = "PublicAccountManager";
  
  public abstract void addPublicAccountToRu(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract void clearBroadcastReceiver(Context paramContext);
  
  public abstract void clearOldPublicAccountData(String paramString);
  
  public abstract mobileqq_mp.ButtonInfo getButtonInfoByMenuId(QQAppInterface paramQQAppInterface, String paramString, int paramInt);
  
  public abstract String getCurrentUin();
  
  public abstract NewIntent getMenuSetting(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver, boolean paramBoolean);
  
  public abstract long getMsgID(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract int getPublicAccountAioClass(String paramString, AppInterface paramAppInterface);
  
  public abstract List<mobileqq_mp.ButtonInfo> getPublicAccountMenuButtonList(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract int getPublicAccountMenuType(String paramString);
  
  public abstract void handleButtonEvent(String paramString1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2, int paramInt1, BusinessObserver paramBusinessObserver, MqqHandler paramMqqHandler, int paramInt2, SessionInfo paramSessionInfo);
  
  public abstract void handleUrlEvent(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3);
  
  public abstract boolean hasPreloadWebProcessor();
  
  public abstract void init(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, IPublicAccountManager.InitDoneObserver paramInitDoneObserver);
  
  public abstract boolean preloadWebProcess(QQAppInterface paramQQAppInterface);
  
  public abstract NewIntent refuseFollowAccount(String paramString, int paramInt, boolean paramBoolean, Context paramContext, AppInterface paramAppInterface, IPublicAccountManager.refuseAcceptDone paramrefuseAcceptDone);
  
  public abstract void refuseFollowAccountCancelCallback(NewIntent paramNewIntent);
  
  public abstract void removeMsgID(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract void reportRecentList(QQAppInterface paramQQAppInterface);
  
  public abstract void requestQidiKefu(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, BusinessObserver paramBusinessObserver);
  
  public abstract void savePublicAccountMenuSetting(QQAppInterface paramQQAppInterface, String paramString, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse);
  
  public abstract void sendMenuEventequest(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2, BusinessObserver paramBusinessObserver);
  
  public abstract void sendMenuEventequest(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2, BusinessObserver paramBusinessObserver, int paramInt1, long paramLong, int paramInt2);
  
  public abstract NewIntent sendMsgArriveReceipt(Context paramContext, AppInterface paramAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, List<Long> paramList);
  
  public abstract void setHasPreloadWebProcessor(boolean paramBoolean);
  
  public abstract void setMsgID(QQAppInterface paramQQAppInterface, String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountManager
 * JD-Core Version:    0.7.0.1
 */