package com.tencent.mobileqq.app.automator;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.api.IPublicAccountCheck;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderStepAsync;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabServerInitStep;
import com.tencent.mobileqq.apollo.utils.ApolloClassFactoryApi;
import com.tencent.mobileqq.app.automator.step.ActiveAccount;
import com.tencent.mobileqq.app.automator.step.ActivityDAUReport;
import com.tencent.mobileqq.app.automator.step.AfterSyncMsg;
import com.tencent.mobileqq.app.automator.step.AppNewsAlert;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.app.automator.step.CheckAuthCode;
import com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo;
import com.tencent.mobileqq.app.automator.step.CheckHotSpotNode;
import com.tencent.mobileqq.app.automator.step.CheckMsgCount;
import com.tencent.mobileqq.app.automator.step.CheckQZoneOatFile;
import com.tencent.mobileqq.app.automator.step.CheckSafeCenterConfig;
import com.tencent.mobileqq.app.automator.step.CleanCache;
import com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs;
import com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep;
import com.tencent.mobileqq.app.automator.step.GetCheckUpdate;
import com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus;
import com.tencent.mobileqq.app.automator.step.GetCommonUsedSystemEmojiStep;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.app.automator.step.GetDiscussionInfo;
import com.tencent.mobileqq.app.automator.step.GetDonateFriends;
import com.tencent.mobileqq.app.automator.step.GetEmosmList;
import com.tencent.mobileqq.app.automator.step.GetEmoticonWhenNoFile;
import com.tencent.mobileqq.app.automator.step.GetFunCallData;
import com.tencent.mobileqq.app.automator.step.GetGeneralSettings;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListMessageStep;
import com.tencent.mobileqq.app.automator.step.GetLocalRedtouchStep;
import com.tencent.mobileqq.app.automator.step.GetNumRedStep;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeeds;
import com.tencent.mobileqq.app.automator.step.GetQZonePhotoGuideCheck;
import com.tencent.mobileqq.app.automator.step.GetRecommendEmotionStep;
import com.tencent.mobileqq.app.automator.step.GetRedpointStep;
import com.tencent.mobileqq.app.automator.step.GetSecMsgConfigs;
import com.tencent.mobileqq.app.automator.step.GetSecMsgNewSeq;
import com.tencent.mobileqq.app.automator.step.GetSelfInfo;
import com.tencent.mobileqq.app.automator.step.GetSelfPendantId;
import com.tencent.mobileqq.app.automator.step.GetSig;
import com.tencent.mobileqq.app.automator.step.GetSplashConfig;
import com.tencent.mobileqq.app.automator.step.GetSubAccount;
import com.tencent.mobileqq.app.automator.step.GetSubAccountSpecialCare;
import com.tencent.mobileqq.app.automator.step.GetTbsSwitchInfo;
import com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg;
import com.tencent.mobileqq.app.automator.step.GetTroopConfig;
import com.tencent.mobileqq.app.automator.step.GetTroopRedPointInfoStep;
import com.tencent.mobileqq.app.automator.step.GetWebViewAuthorize;
import com.tencent.mobileqq.app.automator.step.LimitChatSettingStep;
import com.tencent.mobileqq.app.automator.step.LoginWelcomeRequest;
import com.tencent.mobileqq.app.automator.step.MonitorSocketDownload;
import com.tencent.mobileqq.app.automator.step.NotifyQZoneServer;
import com.tencent.mobileqq.app.automator.step.PPCLoginAuth;
import com.tencent.mobileqq.app.automator.step.QAVStep;
import com.tencent.mobileqq.app.automator.step.QQComicStep;
import com.tencent.mobileqq.app.automator.step.QQUpdateVersion;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.automator.step.RegisterPush;
import com.tencent.mobileqq.app.automator.step.ReportClientInfo;
import com.tencent.mobileqq.app.automator.step.ReportLoginInfo;
import com.tencent.mobileqq.app.automator.step.SendThemeAuth;
import com.tencent.mobileqq.app.automator.step.SetLogOn;
import com.tencent.mobileqq.app.automator.step.SignatureScan;
import com.tencent.mobileqq.app.automator.step.StartQSecLogic;
import com.tencent.mobileqq.app.automator.step.StartSecurityScan;
import com.tencent.mobileqq.app.automator.step.StartSecurityUpdate;
import com.tencent.mobileqq.app.automator.step.StartSmartDevice;
import com.tencent.mobileqq.app.automator.step.StartTxVerifyApk;
import com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount;
import com.tencent.mobileqq.app.automator.step.TimiGameLoginResumeStep;
import com.tencent.mobileqq.app.automator.step.TroopEnterEffectsStep;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.mobileqq.app.automator.step.UpdateIcon;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.mobileqq.app.automator.step.VideoConfigUpdate;
import com.tencent.mobileqq.app.automator.step.VipCheckGift;
import com.tencent.mobileqq.app.automator.step.VipRequestMessageRoamPassword;
import com.tencent.mobileqq.app.automator.step.WeiyunCheckAlbum;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.kandian.biz.common.api.IKanDianClassProvider;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.FeatureSwitchStep;
import com.tencent.mobileqq.startup.step.MetricSdkInit;
import com.tencent.mobileqq.startup.step.QQShopStep;
import com.tencent.mobileqq.startup.step.TABSDKInit;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vashealth.StepServiceAsync;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import java.util.Set;

public class StepFactory
{
  public static final int[] a = { 6, 12, 24, 168 };
  public static final String[] b = { "{,101}", "{94}", "{56,64,36,52,66,68,62,76,75,83,90,31}", "{}" };
  public static SparseArray<Class<? extends AsyncStep>> c = new SparseArray(125);
  public static final String d;
  public static final String e;
  private static final String f;
  
  static
  {
    c.append(2, ActiveAccount.class);
    c.append(3, UpdateFriend.class);
    c.append(7, UpdateFriend.class);
    c.append(8, UpdateFriend.class);
    c.append(4, UpdateTroop.class);
    c.append(9, UpdateTroop.class);
    c.append(5, UpdateDiscuss.class);
    c.append(6, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountCheck.class));
    c.append(10, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountCheck.class));
    c.append(12, RegisterPush.class);
    c.append(13, RegisterPush.class);
    c.append(17, RegisterProxy.class);
    c.append(18, RegisterProxy.class);
    c.append(19, RegisterProxy.class);
    c.append(20, GetGeneralSettings.class);
    c.append(21, GetTroopAssisMsg.class);
    c.append(14, InitBeforeSyncMsg.class);
    c.append(15, InitBeforeSyncMsg.class);
    c.append(16, InitBeforeSyncMsg.class);
    c.append(11, GetSubAccount.class);
    c.append(22, AfterSyncMsg.class);
    c.append(23, AfterSyncMsg.class);
    c.append(24, AfterSyncMsg.class);
    c.append(26, GetEmoticonWhenNoFile.class);
    c.append(25, QAVStep.class);
    c.append(27, GetSelfPendantId.class);
    c.append(28, StartSecurityScan.class);
    c.append(29, GetEmosmList.class);
    c.append(30, GetSelfInfo.class);
    c.append(31, EcShopFirstRunMsgConfigs.class);
    c.append(32, GetSecMsgConfigs.class);
    c.append(33, GetSecMsgNewSeq.class);
    c.append(34, CheckFriendsLastLoginInfo.class);
    c.append(35, GetSig.class);
    c.append(33, GetSecMsgNewSeq.class);
    c.append(34, CheckFriendsLastLoginInfo.class);
    c.append(35, GetSig.class);
    c.append(36, StartSecurityUpdate.class);
    c.append(39, GetWebViewAuthorize.class);
    c.append(40, GetDiscussionInfo.class);
    c.append(41, SetLogOn.class);
    c.append(42, GetQZoneFeedCount.class);
    c.append(43, CheckQZoneOatFile.class);
    c.append(44, GetConfig.class);
    c.append(45, GetCheckUpdate.class);
    c.append(46, GetCheckUpdate.class);
    c.append(47, GetSplashConfig.class);
    c.append(72, GetFunCallData.class);
    c.append(48, SendThemeAuth.class);
    c.append(50, GetTbsSwitchInfo.class);
    c.append(91, CheckAuthCode.class);
    c.append(52, CleanCache.class);
    c.append(53, CheckMsgCount.class);
    c.append(75, TimerCheckMsgCount.class);
    c.append(55, GetClubContentUpdateStatus.class);
    c.append(107, ApolloClassFactoryApi.a());
    c.append(56, VideoConfigUpdate.class);
    c.append(57, TimerChecker.class);
    c.append(105, AutomatorFinish.class);
    c.append(54, SignatureScan.class);
    c.append(58, ((IHotChatApi)QRoute.api(IHotChatApi.class)).getGetJoinedHotChatListStepClass());
    c.append(59, ((IHotChatApi)QRoute.api(IHotChatApi.class)).getGetJoinedHotChatListStepClass());
    c.append(60, GetJoinedHotChatListMessageStep.class);
    c.append(61, GetTroopRedPointInfoStep.class);
    c.append(65, UpdateIcon.class);
    c.append(63, VipCheckGift.class);
    c.append(64, VipRequestMessageRoamPassword.class);
    c.append(66, ReportDevice.class);
    c.append(67, StartSmartDevice.class);
    c.append(68, WeiyunCheckAlbum.class);
    c.append(69, ChatBackgroundAuth.class);
    c.append(70, GetRecommendEmotionStep.class);
    c.append(73, PPCLoginAuth.class);
    c.append(71, GetNumRedStep.class);
    c.append(74, QQUpdateVersion.class);
    c.append(76, MonitorSocketDownload.class);
    c.append(77, GetQZoneFeeds.class);
    c.append(78, GetBigEmoticonStep.class);
    c.append(80, StepServiceAsync.class);
    c.append(81, GetQZonePhotoGuideCheck.class);
    c.append(83, ActivityDAUReport.class);
    c.append(84, CheckHotSpotNode.class);
    c.append(85, LoginWelcomeRequest.class);
    c.append(86, QQComicStep.class);
    c.append(87, GetDonateFriends.class);
    c.append(88, GetRedpointStep.class);
    c.append(89, GetRedpointStep.class);
    c.append(90, ((IKanDianClassProvider)QRoute.api(IKanDianClassProvider.class)).getReadInJoyDAUReportClass());
    c.append(92, GetLocalRedtouchStep.class);
    c.append(93, GetCommonUsedSystemEmojiStep.class);
    c.append(94, DailyReport.class);
    c.append(95, GetSubAccountSpecialCare.class);
    c.append(96, GetSubAccountSpecialCare.class);
    c.append(99, NotifyQZoneServer.class);
    c.append(37, ReportClientInfo.class);
    c.append(38, StartTxVerifyApk.class);
    c.append(97, CheckSafeCenterConfig.class);
    c.append(98, CheckSafeCenterConfig.class);
    c.append(100, GameCenterCheck.class);
    c.append(101, AppNewsAlert.class);
    c.append(102, StartQSecLogic.class);
    c.append(103, GetTroopConfig.class);
    c.append(104, TroopEnterEffectsStep.class);
    c.append(108, MiniMsgTabServerInitStep.class);
    c.append(109, QQReminderStepAsync.class);
    c.append(110, ReportLoginInfo.class);
    c.append(111, CameraCategoryMaterialStep.class);
    c.append(112, LimitChatSettingStep.class);
    c.append(113, DtSdkInitStep.class);
    c.append(114, MetricSdkInit.class);
    c.append(115, TABSDKInit.class);
    c.append(116, QQShopStep.class);
    c.append(118, ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildRegisterProxyClass());
    c.append(117, FeatureSwitchStep.class);
    c.append(119, TimiGameLoginResumeStep.class);
    c.append(120, TimiGameLoginResumeStep.class);
    f = new InitCacheHelper().a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{85,");
    localStringBuilder.append(f);
    localStringBuilder.append(",");
    localStringBuilder.append("[");
    localStringBuilder.append(11);
    localStringBuilder.append(",");
    localStringBuilder.append(12);
    localStringBuilder.append(",");
    localStringBuilder.append(14);
    localStringBuilder.append("]");
    localStringBuilder.append(",");
    localStringBuilder.append(17);
    localStringBuilder.append(",");
    localStringBuilder.append(118);
    localStringBuilder.append(",");
    localStringBuilder.append(20);
    localStringBuilder.append(",");
    localStringBuilder.append(21);
    localStringBuilder.append(",");
    localStringBuilder.append(59);
    localStringBuilder.append(",");
    localStringBuilder.append(60);
    localStringBuilder.append(",");
    localStringBuilder.append(22);
    localStringBuilder.append(",");
    localStringBuilder.append(113);
    localStringBuilder.append(",");
    localStringBuilder.append(115);
    localStringBuilder.append(",");
    localStringBuilder.append(117);
    localStringBuilder.append(",");
    localStringBuilder.append(119);
    localStringBuilder.append(",");
    localStringBuilder.append(108);
    localStringBuilder.append(",");
    localStringBuilder.append(44);
    localStringBuilder.append(",");
    localStringBuilder.append(45);
    localStringBuilder.append(",");
    localStringBuilder.append("[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112,116]");
    localStringBuilder.append(",");
    localStringBuilder.append(57);
    localStringBuilder.append(",");
    localStringBuilder.append(114);
    localStringBuilder.append(",");
    localStringBuilder.append(95);
    localStringBuilder.append(",");
    localStringBuilder.append(105);
    localStringBuilder.append("}");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append(f);
    localStringBuilder.append(",");
    localStringBuilder.append(44);
    localStringBuilder.append(",");
    localStringBuilder.append(45);
    localStringBuilder.append(",");
    localStringBuilder.append("[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112,116]");
    localStringBuilder.append(",");
    localStringBuilder.append(57);
    localStringBuilder.append("}");
    e = localStringBuilder.toString();
    DeviceOptSwitch.s.add(Integer.valueOf(85));
    DeviceOptSwitch.s.add(Integer.valueOf(4));
    DeviceOptSwitch.s.add(Integer.valueOf(3));
    DeviceOptSwitch.s.add(Integer.valueOf(5));
    DeviceOptSwitch.s.add(Integer.valueOf(6));
    DeviceOptSwitch.s.add(Integer.valueOf(11));
    DeviceOptSwitch.s.add(Integer.valueOf(12));
    DeviceOptSwitch.s.add(Integer.valueOf(14));
    DeviceOptSwitch.s.add(Integer.valueOf(17));
    DeviceOptSwitch.s.add(Integer.valueOf(20));
    DeviceOptSwitch.s.add(Integer.valueOf(21));
    DeviceOptSwitch.s.add(Integer.valueOf(59));
    DeviceOptSwitch.s.add(Integer.valueOf(60));
  }
  
  public static int a(LinearGroup paramLinearGroup, boolean paramBoolean)
  {
    if (d.equals(paramLinearGroup.mName))
    {
      if (paramLinearGroup.d > 4) {
        return 1;
      }
      return 0;
    }
    if (paramBoolean) {
      return 1;
    }
    return 0;
  }
  
  public static AsyncStep a(Automator paramAutomator, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (!TextUtils.isEmpty(str))
    {
      paramString = null;
      int i = -1;
      if (str.startsWith("{"))
      {
        paramString = new LinearGroup();
        paramString.c = str;
      }
      else if (str.startsWith("["))
      {
        paramString = new ParallGroup();
        paramString.c = str;
      }
      else
      {
        i = Integer.parseInt(str);
        Object localObject = (Class)c.get(i);
        if (localObject != null) {
          try
          {
            localObject = (AsyncStep)((Class)localObject).newInstance();
            paramString = (String)localObject;
          }
          catch (Exception localException)
          {
            QLog.e("QQInitHandler", 1, localException, new Object[0]);
          }
        } else {
          paramString = new AsyncStep();
        }
      }
      paramString.mAutomator = paramAutomator;
      paramString.mStepId = i;
      if (i >= 0)
      {
        paramString.mName = paramString.getClass().getSimpleName();
        return paramString;
      }
      paramString.mName = str;
      return paramString;
    }
    paramAutomator = new StringBuilder();
    paramAutomator.append("createStepGroup: ");
    paramAutomator.append(str);
    throw new RuntimeException(paramAutomator.toString());
  }
  
  public static boolean a(LinearGroup paramLinearGroup)
  {
    boolean bool4 = d.equals(paramLinearGroup.mName);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (bool4)
    {
      if (paramLinearGroup.d >= 3) {
        bool1 = true;
      }
      return bool1;
    }
    if ("{[13,16],19,118,21,58,60,89,23,46,33,120,61,42,92,96,97,99}".equals(paramLinearGroup.mName))
    {
      bool1 = bool2;
      if (paramLinearGroup.d >= 1) {
        bool1 = true;
      }
      return bool1;
    }
    if ("{15,18,118,21,58,60,24}".equals(paramLinearGroup.mName)) {
      return true;
    }
    if ("{[11,12,14],17,118,20,21,22108}".equals(paramLinearGroup.mName))
    {
      bool1 = bool3;
      if (paramLinearGroup.d >= 2) {
        bool1 = true;
      }
      return bool1;
    }
    return true;
  }
  
  public static boolean b(LinearGroup paramLinearGroup)
  {
    boolean bool2 = d.equals(paramLinearGroup.mName);
    boolean bool1 = true;
    if (bool2)
    {
      if (paramLinearGroup.d > 5) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean c(LinearGroup paramLinearGroup)
  {
    boolean bool5 = d.equals(paramLinearGroup.mName);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (bool5)
    {
      if (paramLinearGroup.d > 4) {
        bool1 = true;
      }
      return bool1;
    }
    if ("{[13,16],19,118,21,58,60,89,23,46,33,120,61,42,92,96,97,99}".equals(paramLinearGroup.mName))
    {
      bool1 = bool2;
      if (paramLinearGroup.d > 2) {
        bool1 = true;
      }
      return bool1;
    }
    if ("{15,18,118,21,58,60,24}".equals(paramLinearGroup.mName))
    {
      bool1 = bool3;
      if (paramLinearGroup.d > 2) {
        bool1 = true;
      }
      return bool1;
    }
    if ("{[11,12,14],17,118,20,21,22108}".equals(paramLinearGroup.mName))
    {
      bool1 = bool4;
      if (paramLinearGroup.d > 2) {
        bool1 = true;
      }
      return bool1;
    }
    return true;
  }
  
  public static boolean d(LinearGroup paramLinearGroup)
  {
    boolean bool5 = d.equals(paramLinearGroup.mName);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (bool5)
    {
      if (paramLinearGroup.d > 5) {
        bool1 = true;
      }
      return bool1;
    }
    if ("{[13,16],19,118,21,58,60,89,23,46,33,120,61,42,92,96,97,99}".equals(paramLinearGroup.mName))
    {
      bool1 = bool2;
      if (paramLinearGroup.d > 3) {
        bool1 = true;
      }
      return bool1;
    }
    if ("{15,18,118,21,58,60,24}".equals(paramLinearGroup.mName))
    {
      bool1 = bool3;
      if (paramLinearGroup.d > 3) {
        bool1 = true;
      }
      return bool1;
    }
    if ("{[11,12,14],17,118,20,21,22108}".equals(paramLinearGroup.mName))
    {
      bool1 = bool4;
      if (paramLinearGroup.d > 3) {
        bool1 = true;
      }
      return bool1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.StepFactory
 * JD-Core Version:    0.7.0.1
 */