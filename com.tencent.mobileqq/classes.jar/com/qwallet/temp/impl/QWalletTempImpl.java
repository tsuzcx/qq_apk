package com.qwallet.temp.impl;

import Wallet.AcsMsg;
import Wallet.PfaFriendRqt;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.qwallet.temp.AsyncBackTemp;
import com.qwallet.temp.FriendListObserverTemp;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IGrammarNativeTemp;
import com.qwallet.temp.IQWalletTemp;
import com.qwallet.temp.IQWalletTemp.ICallBack;
import com.qwallet.temp.IQWalletTemp.ITempString;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyHelper;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.api.UIViewUtils;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.managers.PasswdRedBagFoldManager;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.openapi.sdk.QQResult.QQStringResult;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketEmojiFragment;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.IPreloadModule;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.startup.step.ProcessInfoUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.Rotate3dAnimation;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import cooperation.thirdpay.VfcPluginProxyActivity;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import msf.msgcomm.msg_comm.Msg;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.Elem;

public class QWalletTempImpl
  implements IQWalletTemp
{
  private static final String TAG = "QWalletTempImpl";
  private FriendListObserver mFriendListObserver;
  
  private static void addLoadingDialogInfo(Context paramContext, Bundle paramBundle, IPluginManager.PluginParams paramPluginParams)
  {
    if (!(paramContext instanceof Activity)) {
      return;
    }
    paramContext = (Activity)paramContext;
    if (isForePay(paramBundle))
    {
      paramBundle = paramBundle.getBundle("extra_ext_data");
      int i = 1;
      if ((paramBundle == null) || (paramBundle.getInt("extra_ext_data_type", 0) != 1)) {
        i = 0;
      }
      if ((i == 0) && (!QWalletHelperDelegate.isQWalletProcessExist(paramContext)))
      {
        paramBundle = new QWalletPayProgressDialog(paramContext);
        paramBundle.show();
        paramPluginParams.jdField_a_of_type_AndroidAppDialog = paramBundle;
        paramPluginParams.jdField_b_of_type_Boolean = false;
        paramPluginParams.d = 10000;
        paramPluginParams.g = null;
        new SplashDialogWrapper(paramContext, paramPluginParams.jdField_a_of_type_AndroidAppDialog, paramPluginParams.e, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_b_of_type_Boolean, paramPluginParams.d).show();
      }
    }
  }
  
  private static boolean isForePay(Bundle paramBundle)
  {
    return paramBundle.getInt("launch_type", 0) == 0;
  }
  
  private boolean isShowHongBaoRedPoint(String paramString, int paramInt)
  {
    int j = 7;
    int i;
    try
    {
      i = new JSONObject(paramString).optInt("aioType", 7);
      j = i;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    if (((j & 0x1) == 1) && (paramInt == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    int k;
    if (((j & 0x2) == 2) && (paramInt == 1)) {
      k = 1;
    } else {
      k = 0;
    }
    if (((j & 0x4) == 4) && (paramInt == 3000)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((i == 0) && (k == 0)) {
      return paramInt != 0;
    }
    return true;
  }
  
  private static void launchPayPluginAct(IPluginManager.PluginParams paramPluginParams, Intent paramIntent, Context paramContext)
  {
    Intent localIntent = new Intent();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      localIntent.putExtras(paramIntent.getExtras());
    }
    paramPluginParams.f = "com.qwallet.activity.QvipPayBridgeActivity";
    paramPluginParams.jdField_a_of_type_JavaLangClass = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletProxyActivityClass();
    paramPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    paramPluginParams.c = 3001;
    IPluginManager.a((Activity)paramContext, paramPluginParams);
  }
  
  public void AIOPanelUtiles$panelReport(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    AIOPanelUtiles.a(paramBaseQQAppInterface, paramString, paramInt);
  }
  
  public String ActivateFriendsManag$PREF_ACTIVATE_FRIENDS()
  {
    return "pref_act_frd";
  }
  
  public ChatMessage ArkAioContainerWrapper$getMessageByMID(String paramString)
  {
    return ArkAioContainerWrapper.a(paramString);
  }
  
  public String AtTroopMemberSpan$createAtSpannableString(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return AtTroopMemberSpan.a(AtTroopMemberSpan.a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2, paramString4), paramArrayList);
  }
  
  public boolean BaseChatItemLayout$CheckBoxVisible()
  {
    return BaseChatItemLayout.a;
  }
  
  public String BridgeHelper$getConfig(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = BridgeHelper.a(paramBaseQQAppInterface.getApp(), paramBaseQQAppInterface.getCurrentAccountUin());
    if (paramBaseQQAppInterface == null) {
      return null;
    }
    return paramBaseQQAppInterface.a(paramString);
  }
  
  public HashMap<String, String> BridgeHelper$mConfigContents(Context paramContext, String paramString)
  {
    paramContext = BridgeHelper.a(paramContext, paramString);
    if (paramContext == null) {
      return null;
    }
    return paramContext.a();
  }
  
  public String BusinessHandlerFactory$QWALLET_HANDLER()
  {
    return BusinessHandlerFactory.QWALLET_HANDLER;
  }
  
  public void ChatActivityFacade$sendMessage(AppRuntime paramAppRuntime, Context paramContext, Object paramObject, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    if (((paramAppRuntime instanceof QQAppInterface)) && ((paramObject instanceof SessionInfo))) {
      ChatActivityFacade.a((QQAppInterface)paramAppRuntime, paramContext, (SessionInfo)paramObject, paramString, paramArrayList);
    }
  }
  
  public boolean ChatActivityUtil$isTempConv(BaseSessionInfo paramBaseSessionInfo)
  {
    return ChatActivityUtils.a(paramBaseSessionInfo.jdField_a_of_type_Int);
  }
  
  public IBaseChatPieProxy ChatFragment$getCurPie(QBaseActivity paramQBaseActivity)
  {
    paramQBaseActivity = (QBaseFragment)paramQBaseActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity = ((ChatFragment)paramQBaseActivity).a();
      if (paramQBaseActivity != null) {
        return createBaseChatPie(paramQBaseActivity);
      }
    }
    return null;
  }
  
  public String Const$CJ_2021_AVGAME_PRELOAD_MODULE_NAME()
  {
    return "2021_cjavgame";
  }
  
  public String Const$REDPACKET_2021_PRELOAD_MODULE_NAME()
  {
    return "2021_shuayishua";
  }
  
  public String ContactUtils$getBuddyNickName(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    return ContactUtils.b(paramAppRuntime, paramString, paramBoolean);
  }
  
  public String ContactUtils$getMemberDisplaynameByIstroop(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    return ContactUtils.a(paramBaseQQAppInterface, paramInt, paramString1, paramString2);
  }
  
  public Dialog DialogUtils$createNewUpgradeYYBInstalledDialog(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return DialogUtils.a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramString4, paramOnClickListener2);
  }
  
  public QQCustomDialog DialogUtils$showQQCustomDialogWtihInputAndChoose(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    if ((paramContext instanceof Activity))
    {
      paramString4 = (Activity)paramContext;
      if (((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).isSelectMemberActivityInstance(paramString4)) {
        return DialogUtils.a(paramContext, paramString1, paramString2, paramString3, ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getTopayTips(paramString4), null, paramOnClickListener1, paramOnClickListener2, paramInt, paramBoolean);
      }
    }
    return null;
  }
  
  public String DiscussionManager$getDiscussMemberName(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2)
  {
    return ((DiscussionManager)paramBaseQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString1, paramString2).getDiscussionMemberName();
  }
  
  public int DiscussionManager$getDiscussionMemberNum(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ((DiscussionManager)paramBaseQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
  }
  
  public void GameShareConfProcessor$reset() {}
  
  public boolean GesturePWDUtils$getJumpLock(Context paramContext, String paramString)
  {
    return GesturePWDUtils.getJumpLock(paramContext, paramString);
  }
  
  public void HtmlOffline$checkUpByBusinessId(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, AsyncBackTemp paramAsyncBackTemp)
  {
    HtmlOffline.b(paramString, paramAppRuntime, paramBoolean, new QWalletTempImpl.2(this, paramAsyncBackTemp));
  }
  
  public boolean IPluginManager$isPlugininstalled(BaseQQAppInterface paramBaseQQAppInterface)
  {
    try
    {
      boolean bool = ((IPluginManager)paramBaseQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN)).isPlugininstalled("qwallet_plugin.apk");
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("getPayCode ");
      paramBaseQQAppInterface.append(bool);
      QLog.d("Q.qwallet.pay", 1, paramBaseQQAppInterface.toString());
      return bool;
    }
    catch (Throwable paramBaseQQAppInterface)
    {
      QLog.d("Q.qwallet.pay", 1, "getPayCode ", paramBaseQQAppInterface);
    }
    return false;
  }
  
  public void IPluginManager$launchPluginService(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    String str = paramBundle.getString("preload_from");
    if (!TextUtils.isEmpty(str)) {
      localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession(str, "com.tencent.mobileqq:tool", "qwallet_plugin.apk");
    }
    localPluginParams.jdField_b_of_type_JavaLangString = "qwallet_plugin.apk";
    localPluginParams.e = "Wallet";
    localPluginParams.jdField_a_of_type_JavaLangString = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin();
    localPluginParams.f = "com.qwallet.service.QWalletPluginService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = null;
    addLoadingDialogInfo(paramContext, paramBundle, localPluginParams);
    boolean bool = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).isLaunchPayPluginAct(paramBundle, paramContext);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("isLaunchPayPluginAct =");
      paramBundle.append(bool);
      QLog.i("Q.qwallet.pay.QWalletPayBridge", 2, paramBundle.toString());
    }
    if (bool)
    {
      launchPayPluginAct(localPluginParams, paramIntent, paramContext);
      return;
    }
    IPluginManager.c(paramContext, localPluginParams);
  }
  
  public void IPluginManager$openActivityForResult(Context paramContext, Intent paramIntent, Dialog paramDialog)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "qwallet_plugin.apk";
    localPluginParams.e = "QWallet";
    localPluginParams.jdField_a_of_type_JavaLangString = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin();
    localPluginParams.f = "com.qwallet.activity.QWalletHomeActivity";
    localPluginParams.jdField_a_of_type_JavaLangClass = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletProxyActivityClass();
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.c = -1;
    localPluginParams.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localPluginParams.jdField_b_of_type_Boolean = false;
    localPluginParams.d = 10000;
    localPluginParams.g = null;
    IPluginManager.a(paramContext, localPluginParams);
  }
  
  public int MessageForQQWalletMsg$getIsHideTitleDefault(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForQQWalletMsg)) {
      return ((MessageForQQWalletMsg)paramMessageRecord).getIsHideTitleDefault();
    }
    return 0;
  }
  
  public String MessageForQQWalletMsg$icon_name(RedPacketInfo paramRedPacketInfo)
  {
    if ((paramRedPacketInfo.a instanceof MessageForQQWalletMsg))
    {
      paramRedPacketInfo = (MessageForQQWalletMsg)paramRedPacketInfo.a;
      if (paramRedPacketInfo.messageType == 6) {
        return "icon_txt";
      }
      if (paramRedPacketInfo.messageType == 14) {
        return "icon_video";
      }
      if ((paramRedPacketInfo.messageType != 13) && (paramRedPacketInfo.messageType != 15))
      {
        if (paramRedPacketInfo.messageType == 18) {
          return "icon_ksong";
        }
        if (paramRedPacketInfo.messageType == 19) {
          return "icon_emoji";
        }
        if ((paramRedPacketInfo.messageType != 22) && (paramRedPacketInfo.messageType != 26))
        {
          if ((paramRedPacketInfo.messageType == 7) || (paramRedPacketInfo.messageType == 8) || (paramRedPacketInfo.messageType == 11) || (paramRedPacketInfo.messageType == 12) || (paramRedPacketInfo.messageType == 23)) {
            return "icon_sp";
          }
        }
        else {
          return "icon_draw";
        }
      }
      else
      {
        return "icon_voice";
      }
    }
    return null;
  }
  
  public void MessagePBElemDecoder$decodePBMsgElems_RichMsg(Object paramObject, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    if ((paramObject instanceof MessagePBElemDecoder)) {
      ((MessagePBElemDecoder)paramObject).i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    }
  }
  
  public void MessagePBElemDecoder$decodePBMsgElems_Text(Object paramObject, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    if ((paramObject instanceof MessagePBElemDecoder)) {
      ((MessagePBElemDecoder)paramObject).h(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    }
  }
  
  public MessageRecord MessageRecordFactory$createMsgRecordByMsgType(int paramInt)
  {
    return MessageRecordFactory.a(paramInt);
  }
  
  public void OpenApiManager$onPayMsgRsp(int paramInt, String paramString1, String paramString2)
  {
    int i;
    if ("ResultCode.RESULT_OK".equals(paramString1)) {
      i = 0;
    } else {
      i = -1000;
    }
    paramString1 = new QQResult.QQStringResult(paramInt, i, paramString2);
    OpenApiManager.getInstance().onPayMsgRsp(paramString1);
  }
  
  public void PasswdRedBagFoldManager$updateRedBagMapCache(AppInterface paramAppInterface, boolean paramBoolean, String paramString1, String paramString2)
  {
    ((PasswdRedBagFoldManager)paramAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER)).a(paramBoolean, paramString1, paramString2);
  }
  
  public Bundle PayBridgeActivity$newPay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    return PayBridgeActivity.newPay(paramAppInterface, paramActivity, paramResultReceiver, paramInt, paramBundle);
  }
  
  public int PeakConstants$SendSizeSpec$SPEC_NOMAL()
  {
    return 0;
  }
  
  public long ProcessInfoUtil$getProcessRunningTime()
  {
    return ProcessInfoUtil.a("com.tencent.mobileqq:tool");
  }
  
  public String QAlbumConstants$PHOTO_PATHS()
  {
    return "PhotoConst.PHOTO_PATHS";
  }
  
  public String QAlbumConstants$SINGLE_PHOTO_PATH()
  {
    return "PhotoConst.SINGLE_PHOTO_PATH";
  }
  
  public void QBaseActivity$addObserver(QBaseActivity paramQBaseActivity, FriendListObserverTemp paramFriendListObserverTemp)
  {
    paramQBaseActivity = paramQBaseActivity.getAppRuntime();
    if ((paramQBaseActivity instanceof AppInterface))
    {
      this.mFriendListObserver = new QWalletTempImpl.3(this, paramFriendListObserverTemp);
      ((AppInterface)paramQBaseActivity).addObserver(this.mFriendListObserver);
    }
  }
  
  public void QBaseActivity$removeObserver(QBaseActivity paramQBaseActivity, FriendListObserverTemp paramFriendListObserverTemp)
  {
    paramQBaseActivity = paramQBaseActivity.getAppRuntime();
    if ((paramQBaseActivity instanceof AppInterface))
    {
      ((AppInterface)paramQBaseActivity).removeObserver(this.mFriendListObserver);
      this.mFriendListObserver = null;
    }
  }
  
  public void QQAppInterface$getMessageFacade$addAndSendMessage(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, BaseMessageObserver paramBaseMessageObserver)
  {
    if (((paramAppRuntime instanceof QQAppInterface)) && ((paramBaseMessageObserver instanceof MessageObserver))) {
      ((QQAppInterface)paramAppRuntime).getMessageFacade().a(paramMessageRecord, (MessageObserver)paramBaseMessageObserver);
    }
  }
  
  public void QQCustomDialogWtihInputAndChoose$show(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    Bundle localBundle = paramActivity.getIntent().getExtras();
    paramActivity = DialogUtils.a(paramActivity, paramString, localBundle.getString("choose_friend_content"), localBundle.getString("choose_friend_subcontent"), ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getTopayTips(paramActivity), null, paramOnClickListener, paramOnClickListener, 36, false);
    ReportController.b(QWalletTools.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.windowshow", 0, 0, "", "", "", "");
    paramActivity = paramActivity.getTitleTextView();
    if (paramActivity != null)
    {
      paramActivity.setSingleLine(false);
      paramActivity.setMaxLines(2);
      paramActivity.setEllipsize(TextUtils.TruncateAt.END);
      paramActivity.setGravity(3);
    }
  }
  
  public String QQNotifyHelper$getKey(AcsMsg paramAcsMsg)
  {
    return QQNotifyHelper.a(paramAcsMsg);
  }
  
  public boolean QQUtils$isScreenLocked(Context paramContext)
  {
    return QQUtils.a(paramContext);
  }
  
  public Map<MessageForQQWalletMsg, Long> QQWalletMsgItemBuilder$mlastReportMap()
  {
    return QQWalletMsgItemBuilder.a;
  }
  
  public int QWalletAuthHandler$TYPE_GET_RECENT_LIST()
  {
    return 5;
  }
  
  public void QWalletAuthHandler$sendGetRecentList(BaseQQAppInterface paramBaseQQAppInterface, PfaFriendRqt paramPfaFriendRqt)
  {
    ((QWalletAuthHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).a(paramPfaFriendRqt);
  }
  
  public void QWalletPicDownloader$reportDeviceCantPlayBackground(String paramString)
  {
    ChatBackgroundManager.a(paramString);
  }
  
  public int ReportConstant$Res(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1553871847)
    {
      if (i != -509700974)
      {
        if ((i == 668698653) && (paramString.equals("RESULT_RES_PRELOAD_FAIL_MD5_CHECK")))
        {
          i = 0;
          break label76;
        }
      }
      else if (paramString.equals("RESULT_RES_PRELOAD_FAIL_DOWNLOAD"))
      {
        i = 2;
        break label76;
      }
    }
    else if (paramString.equals("RESULT_RES_PRELOAD_SUCC"))
    {
      i = 1;
      break label76;
    }
    i = -1;
    label76:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          new IllegalArgumentException("constName is illegal！");
          return -1;
        }
        return 1;
      }
      return 0;
    }
    return 2;
  }
  
  public void SendHbActivity$startForwardActivity(Context paramContext, Intent paramIntent)
  {
    ForwardBaseOption.a(paramContext, paramIntent);
  }
  
  public void SpringHbMonitorReporter$reportResPreload(IPreloadModule paramIPreloadModule, int paramInt1, String paramString, int paramInt2)
  {
    SpringHbMonitorReporter.a(paramIPreloadModule, paramInt1, paramString, paramInt2);
  }
  
  public void SpringHbMonitorReporter$reportResRealTimeDownload(int paramInt1, String paramString, int paramInt2)
  {
    SpringHbMonitorReporter.a(paramInt1, paramString, paramInt2);
  }
  
  public long StorageManager$getFreeSpace(String paramString)
  {
    return StorageManager.a(paramString);
  }
  
  public TroopMemberInfo TroopManager$getTroopMember(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return ((TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1, paramString2);
  }
  
  public void TroopTipsMsgMgr$insertTroopTipsIntoMessageList(AppInterface paramAppInterface, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    ((TroopTipsMsgMgr)paramAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER)).a(paramString1, paramString2, paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public View UIViewUtils$getViewByPosition(View paramView, ChatMessage paramChatMessage)
  {
    return UIViewUtils.a(paramChatMessage, (ChatXListView)paramView);
  }
  
  public void clickAIOHongBaoRedPoint(View paramView, int paramInt)
  {
    Object localObject = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface();
    if (localObject != null)
    {
      localObject = (IQWalletRedService)((BaseQQAppInterface)localObject).getRuntimeService(IQWalletRedService.class);
      IQWalletRedService.ShowInfo localShowInfo = ((IQWalletRedService)localObject).getShowInfo("2001");
      if ((localShowInfo.a) && (isShowHongBaoRedPoint(localShowInfo.jdField_b_of_type_JavaLangString, paramInt)))
      {
        if ((paramView instanceof RedDotImageView)) {
          ((RedDotImageView)paramView).a(false);
        }
        ((IQWalletRedService)localObject).doClick("2001");
      }
    }
  }
  
  public IBaseChatPieProxy createBaseChatPie(Object paramObject)
  {
    return new BaseChatPieProxy((BaseChatPie)paramObject);
  }
  
  public Animation createRotate3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    return new Rotate3dAnimation(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramBoolean);
  }
  
  public String getAppInfoFromHistory()
  {
    try
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if ((localBaseApplicationImpl != null) && (localBaseApplicationImpl.appActivities != null))
      {
        int i = localBaseApplicationImpl.appActivities.size() - 1;
        while (i >= 0)
        {
          Object localObject = (WeakReference)localBaseApplicationImpl.appActivities.get(i);
          if (localObject != null)
          {
            localObject = (AppActivity)((WeakReference)localObject).get();
            if ((localObject != null) && ((localObject instanceof QQBrowserActivity)))
            {
              localObject = (QQBrowserActivity)localObject;
              localObject = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInfoFromHistory(((QQBrowserActivity)localObject).getHostWebView());
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = URLDecoder.decode((String)localObject, "UTF-8");
                  return localObject;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  localUnsupportedEncodingException.printStackTrace();
                }
              }
            }
          }
          i -= 1;
        }
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public Class<?> getChatActivityClass()
  {
    return ChatActivity.class;
  }
  
  public View getChatXListViewFromChatFragment(QBaseActivity paramQBaseActivity)
  {
    if ((paramQBaseActivity instanceof BaseActivity))
    {
      paramQBaseActivity = (BaseActivity)paramQBaseActivity;
      if (paramQBaseActivity.getChatFragment() != null)
      {
        paramQBaseActivity = paramQBaseActivity.getChatFragment();
        if (paramQBaseActivity.a != null) {
          return paramQBaseActivity.a.a;
        }
      }
    }
    return null;
  }
  
  public String getGroupNicknameByType(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    if ((!(paramAppInterface instanceof QQAppInterface)) || (paramInt == 0)) {}
    try
    {
      return new TroopManager((QQAppInterface)paramAppInterface).c(paramString).troopname;
    }
    catch (Exception paramAppInterface)
    {
      label56:
      break label56;
    }
    if (paramInt == 1)
    {
      paramAppInterface = new DiscussionManager((QQAppInterface)paramAppInterface).a(paramString).discussionName;
      return paramAppInterface;
      paramAppInterface.printStackTrace();
    }
    return "";
  }
  
  public Class<? extends Activity> getQQLSUnlockActivityClazz()
  {
    return QQLSUnlockActivity.class;
  }
  
  public BusinessObserver getQWalletAuthObserver(Handler paramHandler)
  {
    return new QWalletAuthObserver(paramHandler);
  }
  
  public String getQWalletPluginId()
  {
    return "qwallet_plugin.apk";
  }
  
  public void getSkey(BaseQQAppInterface paramBaseQQAppInterface, IQWalletTemp.ITempString paramITempString)
  {
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface = ((TicketManager)paramBaseQQAppInterface.getManager(2)).getSkey(paramBaseQQAppInterface.getCurrentAccountUin(), 16L, new QWalletTempImpl.5(this, paramITempString));
      if ((paramBaseQQAppInterface != null) && (paramBaseQQAppInterface._sig != null) && (paramBaseQQAppInterface._sig.length != 0)) {
        paramITempString.a(0, new String(paramBaseQQAppInterface._sig));
      }
    }
  }
  
  public boolean isSplashNotExist()
  {
    return (SplashActivity.sWeakInstance == null) || (SplashActivity.sWeakInstance.get() == null);
  }
  
  public void launchVfcPlugin(QBaseActivity paramQBaseActivity, BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("userQqResources", -1);
    localIntent.putExtra("useSkinEngine", true);
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("params_remote_connect_at_launch", false);
    localIntent.putExtra("from_type", 1);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localIntent.putExtra("openid", str);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("imei", paramString1);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("vfcAccountFlag", paramString1);
    localIntent.addFlags(67108864);
    paramString1 = new IPluginManager.PluginParams(1);
    paramString1.jdField_b_of_type_JavaLangString = "vfc_plugin.apk";
    paramString1.e = PluginInfo.o;
    paramString1.jdField_a_of_type_AndroidAppDialog = null;
    paramString1.jdField_a_of_type_JavaLangString = paramBaseQQAppInterface.getCurrentAccountUin();
    paramString1.jdField_a_of_type_AndroidContentIntent = localIntent;
    paramString1.f = "com.vfuchongcontrol.qq.activity.MainActivity";
    paramString1.jdField_a_of_type_JavaLangClass = VfcPluginProxyActivity.class;
    paramString1.c = -1;
    paramString1.d = 15000;
    paramString1.jdField_b_of_type_Boolean = true;
    paramString1.g = null;
    IPluginManager.a(paramQBaseActivity, paramString1);
  }
  
  public IGrammarNativeTemp newGrammarNativeTemp()
  {
    return new GrammarNativeTemp();
  }
  
  public IAppNotifyCallback newQWalletArkNotifyTemp(IQWalletTemp.ICallBack paramICallBack)
  {
    return new QWalletArkNotifyTempImpl(paramICallBack);
  }
  
  public void openCamera(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      if ((paramActivity != null) && (!paramActivity.isFinishing())) {
        StoryPublishLauncher.a().a(paramActivity, paramBundle, paramInt);
      }
    }
    else {
      QQToast.a(paramActivity, "请使用高于4.3.0及以上的安卓版本体验哦~", 1).a();
    }
  }
  
  public void showAIOHongBaoRedPoint(View paramView, int paramInt)
  {
    BaseQQAppInterface localBaseQQAppInterface = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface();
    if ((paramView instanceof RedDotImageView))
    {
      if (localBaseQQAppInterface == null) {
        return;
      }
      paramView = (RedDotImageView)paramView;
      paramView.a(false);
      ThreadManager.executeOnSubThread(new QWalletTempImpl.4(this, new WeakReference(localBaseQQAppInterface), new WeakReference(paramView), localBaseQQAppInterface, paramInt));
    }
  }
  
  public void startRedPacketEmojiFragment(Context paramContext, IBaseChatPieProxy paramIBaseChatPieProxy, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if (paramIBaseChatPieProxy != null)
    {
      if (paramMessageForQQWalletMsg == null) {
        return;
      }
      Intent localIntent = new Intent();
      SessionInfo localSessionInfo = (SessionInfo)paramIBaseChatPieProxy.a();
      localIntent.putExtra("session", localSessionInfo);
      localIntent.putExtra("uniseq", paramMessageForQQWalletMsg.uniseq);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("fromHBList", paramMessageForQQWalletMsg.fromHBList);
      localIntent.putExtra("redPacketId", paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramMessageForQQWalletMsg = null;
      if (localSessionInfo != null) {
        paramMessageForQQWalletMsg = new SessionWrap(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.d, localSessionInfo.jdField_a_of_type_Int, localSessionInfo.jdField_b_of_type_JavaLangString);
      }
      localIntent.putExtra("KEY_CAMERA_BUNDLE", StoryPublishLauncher.a(paramMessageForQQWalletMsg, paramIBaseChatPieProxy.a().getClass().getName(), 10000, 100));
      QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicTransFragmentActivity.class, RedPacketEmojiFragment.class);
    }
  }
  
  public void startSendPhotoActivity(Context paramContext, Intent paramIntent)
  {
    paramIntent.setComponent(new ComponentName(paramContext, SendPhotoActivity.class));
    paramContext.startActivity(paramIntent);
  }
  
  public void tryUpdateMiniApp(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    LaunchParam localLaunchParam = (LaunchParam)paramBundle.getSerializable("mini_launch_param");
    int i = paramBundle.getInt("version");
    paramBundle = new QWalletTempImpl.1(this, (ResultReceiver)paramBundle.getParcelable("receiver"));
    ((ApkgConfigManager)paramAppRuntime.getManager(QQManagerFactory.APKG_CONFIG_MANAGER)).tryUpdate(localLaunchParam, i, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletTempImpl
 * JD-Core Version:    0.7.0.1
 */