package com.qwallet.temp;

import Wallet.AcsMsg;
import Wallet.PfaFriendRqt;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadModule;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;

@QAPI(process={"all"})
public abstract interface IQWalletTemp
  extends QRouteApi
{
  public abstract void AIOPanelUtiles$panelReport(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt);
  
  public abstract String ActivateFriendsManag$PREF_ACTIVATE_FRIENDS();
  
  public abstract ChatMessage ArkAioContainerWrapper$getMessageByMID(String paramString);
  
  public abstract String AtTroopMemberSpan$createAtSpannableString(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, ArrayList<AtTroopMemberInfo> paramArrayList);
  
  public abstract boolean BaseChatItemLayout$CheckBoxVisible();
  
  public abstract String BridgeHelper$getConfig(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract HashMap<String, String> BridgeHelper$mConfigContents(Context paramContext, String paramString);
  
  public abstract String BusinessHandlerFactory$QWALLET_HANDLER();
  
  public abstract void ChatActivityFacade$sendMessage(AppRuntime paramAppRuntime, Context paramContext, Object paramObject, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList);
  
  public abstract boolean ChatActivityUtil$isTempConv(BaseSessionInfo paramBaseSessionInfo);
  
  public abstract IBaseChatPieProxy ChatFragment$getCurPie(QBaseActivity paramQBaseActivity);
  
  public abstract String Const$CJ_2021_AVGAME_PRELOAD_MODULE_NAME();
  
  public abstract String Const$REDPACKET_2021_PRELOAD_MODULE_NAME();
  
  public abstract String ContactUtils$getBuddyNickName(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean);
  
  public abstract String ContactUtils$getMemberDisplaynameByIstroop(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, String paramString1, String paramString2);
  
  public abstract Dialog DialogUtils$createNewUpgradeYYBInstalledDialog(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2);
  
  public abstract QQCustomDialog DialogUtils$showQQCustomDialogWtihInputAndChoose(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean);
  
  public abstract String DiscussionManager$getDiscussMemberName(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2);
  
  public abstract int DiscussionManager$getDiscussionMemberNum(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract void GameShareConfProcessor$reset();
  
  public abstract boolean GesturePWDUtils$getJumpLock(Context paramContext, String paramString);
  
  public abstract void HtmlOffline$checkUpByBusinessId(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, AsyncBackTemp paramAsyncBackTemp);
  
  public abstract boolean IPluginManager$isPlugininstalled(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void IPluginManager$launchPluginService(Context paramContext, Intent paramIntent, Bundle paramBundle);
  
  public abstract void IPluginManager$openActivityForResult(Context paramContext, Intent paramIntent, Dialog paramDialog);
  
  public abstract int MessageForQQWalletMsg$getIsHideTitleDefault(MessageRecord paramMessageRecord);
  
  public abstract String MessageForQQWalletMsg$icon_name(RedPacketInfo paramRedPacketInfo);
  
  public abstract void MessagePBElemDecoder$decodePBMsgElems_RichMsg(Object paramObject, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo);
  
  public abstract void MessagePBElemDecoder$decodePBMsgElems_Text(Object paramObject, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo);
  
  public abstract MessageRecord MessageRecordFactory$createMsgRecordByMsgType(int paramInt);
  
  public abstract void OpenApiManager$onPayMsgRsp(int paramInt, String paramString1, String paramString2);
  
  public abstract void PasswdRedBagFoldManager$updateRedBagMapCache(AppInterface paramAppInterface, boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract Bundle PayBridgeActivity$newPay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle);
  
  public abstract int PeakConstants$SendSizeSpec$SPEC_NOMAL();
  
  public abstract long ProcessInfoUtil$getProcessRunningTime();
  
  public abstract String QAlbumConstants$PHOTO_PATHS();
  
  public abstract String QAlbumConstants$SINGLE_PHOTO_PATH();
  
  public abstract void QBaseActivity$addObserver(QBaseActivity paramQBaseActivity, FriendListObserverTemp paramFriendListObserverTemp);
  
  public abstract void QBaseActivity$removeObserver(QBaseActivity paramQBaseActivity, FriendListObserverTemp paramFriendListObserverTemp);
  
  public abstract void QQAppInterface$getMessageFacade$addAndSendMessage(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, BaseMessageObserver paramBaseMessageObserver);
  
  public abstract void QQCustomDialogWtihInputAndChoose$show(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener);
  
  public abstract String QQNotifyHelper$getKey(AcsMsg paramAcsMsg);
  
  public abstract boolean QQUtils$isScreenLocked(Context paramContext);
  
  public abstract Map<MessageForQQWalletMsg, Long> QQWalletMsgItemBuilder$mlastReportMap();
  
  public abstract int QWalletAuthHandler$TYPE_GET_RECENT_LIST();
  
  public abstract void QWalletAuthHandler$sendGetRecentList(BaseQQAppInterface paramBaseQQAppInterface, PfaFriendRqt paramPfaFriendRqt);
  
  public abstract void QWalletPicDownloader$reportDeviceCantPlayBackground(String paramString);
  
  public abstract int ReportConstant$Res(String paramString);
  
  public abstract void SendHbActivity$startForwardActivity(Context paramContext, Intent paramIntent);
  
  public abstract void SpringHbMonitorReporter$reportResPreload(IPreloadModule paramIPreloadModule, int paramInt1, String paramString, int paramInt2);
  
  public abstract void SpringHbMonitorReporter$reportResRealTimeDownload(int paramInt1, String paramString, int paramInt2);
  
  public abstract long StorageManager$getFreeSpace(String paramString);
  
  public abstract TroopMemberInfo TroopManager$getTroopMember(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract void TroopTipsMsgMgr$insertTroopTipsIntoMessageList(AppInterface paramAppInterface, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public abstract View UIViewUtils$getViewByPosition(View paramView, ChatMessage paramChatMessage);
  
  public abstract void clickAIOHongBaoRedPoint(View paramView, int paramInt);
  
  public abstract IBaseChatPieProxy createBaseChatPie(Object paramObject);
  
  public abstract Animation createRotate3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean);
  
  public abstract String getAppInfoFromHistory();
  
  public abstract Class<?> getChatActivityClass();
  
  public abstract View getChatXListViewFromChatFragment(QBaseActivity paramQBaseActivity);
  
  public abstract String getGroupNicknameByType(AppInterface paramAppInterface, int paramInt, String paramString);
  
  public abstract Class<? extends Activity> getQQLSUnlockActivityClazz();
  
  public abstract BusinessObserver getQWalletAuthObserver(Handler paramHandler);
  
  public abstract String getQWalletPluginId();
  
  public abstract void getSkey(BaseQQAppInterface paramBaseQQAppInterface, IQWalletTemp.ITempString paramITempString);
  
  public abstract boolean isSplashNotExist();
  
  public abstract void launchVfcPlugin(QBaseActivity paramQBaseActivity, BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, String paramString3);
  
  public abstract IGrammarNativeTemp newGrammarNativeTemp();
  
  public abstract IAppNotifyCallback newQWalletArkNotifyTemp(IQWalletTemp.ICallBack paramICallBack);
  
  public abstract void openCamera(Activity paramActivity, Bundle paramBundle, int paramInt);
  
  public abstract void showAIOHongBaoRedPoint(View paramView, int paramInt);
  
  public abstract void startRedPacketEmojiFragment(Context paramContext, IBaseChatPieProxy paramIBaseChatPieProxy, MessageForQQWalletMsg paramMessageForQQWalletMsg);
  
  public abstract void startSendPhotoActivity(Context paramContext, Intent paramIntent);
  
  public abstract void tryUpdateMiniApp(AppRuntime paramAppRuntime, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.IQWalletTemp
 * JD-Core Version:    0.7.0.1
 */