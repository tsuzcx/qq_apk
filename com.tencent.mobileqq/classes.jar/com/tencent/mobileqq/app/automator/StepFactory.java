package com.tencent.mobileqq.app.automator;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUReport;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderStepAsync;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabServerInitStep;
import com.tencent.mobileqq.apollo.GetApolloContentUpdateStatus;
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
import com.tencent.mobileqq.app.automator.step.CheckPublicAccount;
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
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep;
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
import com.tencent.mobileqq.app.automator.step.TroopEnterEffectsStep;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.mobileqq.app.automator.step.UpdateIcon;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.mobileqq.app.automator.step.VideoConfigUpdate;
import com.tencent.mobileqq.app.automator.step.VipCheckGift;
import com.tencent.mobileqq.app.automator.step.VipRequestMessageRoamPassword;
import com.tencent.mobileqq.app.automator.step.WeiyunCheckAlbum;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.MetricSdkInit;
import com.tencent.mobileqq.startup.step.TABSDKInit;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vashealth.StepServiceAsync;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import java.util.Set;

public class StepFactory
{
  public static SparseArray<Class<? extends AsyncStep>> a;
  public static final int[] a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 6, 12, 24, 168 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "{,101}", "{94}", "{56,64,36,52,66,68,62,76,75,83,90,31}", "{}" };
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(120);
    jdField_a_of_type_AndroidUtilSparseArray.append(2, ActiveAccount.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(3, UpdateFriend.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(7, UpdateFriend.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(8, UpdateFriend.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(4, UpdateTroop.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(9, UpdateTroop.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(5, UpdateDiscuss.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(6, CheckPublicAccount.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(10, CheckPublicAccount.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(12, RegisterPush.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(13, RegisterPush.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(17, RegisterProxy.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(18, RegisterProxy.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(19, RegisterProxy.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(20, GetGeneralSettings.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(21, GetTroopAssisMsg.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(14, InitBeforeSyncMsg.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(15, InitBeforeSyncMsg.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(16, InitBeforeSyncMsg.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(11, GetSubAccount.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(22, AfterSyncMsg.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(23, AfterSyncMsg.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(24, AfterSyncMsg.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(26, GetEmoticonWhenNoFile.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(25, QAVStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(27, GetSelfPendantId.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(28, StartSecurityScan.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(29, GetEmosmList.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(30, GetSelfInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(31, EcShopFirstRunMsgConfigs.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(32, GetSecMsgConfigs.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(33, GetSecMsgNewSeq.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(34, CheckFriendsLastLoginInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(35, GetSig.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(33, GetSecMsgNewSeq.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(34, CheckFriendsLastLoginInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(35, GetSig.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(36, StartSecurityUpdate.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(39, GetWebViewAuthorize.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(40, GetDiscussionInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(41, SetLogOn.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(42, GetQZoneFeedCount.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(43, CheckQZoneOatFile.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(44, GetConfig.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(45, GetCheckUpdate.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(46, GetCheckUpdate.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(47, GetSplashConfig.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(72, GetFunCallData.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(48, SendThemeAuth.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(50, GetTbsSwitchInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(91, CheckAuthCode.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(52, CleanCache.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(53, CheckMsgCount.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(75, TimerCheckMsgCount.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(55, GetClubContentUpdateStatus.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(107, GetApolloContentUpdateStatus.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(56, VideoConfigUpdate.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(57, TimerChecker.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(105, AutomatorFinish.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(54, SignatureScan.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(58, GetJoinedHotChatListStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(59, GetJoinedHotChatListStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(60, GetJoinedHotChatListMessageStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(61, GetTroopRedPointInfoStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(65, UpdateIcon.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(63, VipCheckGift.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(64, VipRequestMessageRoamPassword.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(66, ReportDevice.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(67, StartSmartDevice.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(68, WeiyunCheckAlbum.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(69, ChatBackgroundAuth.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(70, GetRecommendEmotionStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(73, PPCLoginAuth.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(71, GetNumRedStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(74, QQUpdateVersion.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(76, MonitorSocketDownload.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(77, GetQZoneFeeds.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(78, GetBigEmoticonStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(80, StepServiceAsync.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(81, GetQZonePhotoGuideCheck.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(83, ActivityDAUReport.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(84, CheckHotSpotNode.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(85, LoginWelcomeRequest.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(86, QQComicStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(87, GetDonateFriends.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(88, GetRedpointStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(89, GetRedpointStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(90, ReadInJoyDAUReport.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(92, GetLocalRedtouchStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(93, GetCommonUsedSystemEmojiStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(94, DailyReport.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(95, GetSubAccountSpecialCare.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(96, GetSubAccountSpecialCare.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(99, NotifyQZoneServer.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(37, ReportClientInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(38, StartTxVerifyApk.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(97, CheckSafeCenterConfig.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(98, CheckSafeCenterConfig.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(100, GameCenterCheck.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(101, AppNewsAlert.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(102, StartQSecLogic.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(103, GetTroopConfig.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(104, TroopEnterEffectsStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(108, MiniMsgTabServerInitStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(109, QQReminderStepAsync.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(110, ReportLoginInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(111, CameraCategoryMaterialStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(112, LimitChatSettingStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(113, DtSdkInitStep.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(114, MetricSdkInit.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(115, TABSDKInit.class);
    DeviceOptSwitch.b.add(Integer.valueOf(85));
    DeviceOptSwitch.b.add(Integer.valueOf(4));
    DeviceOptSwitch.b.add(Integer.valueOf(3));
    DeviceOptSwitch.b.add(Integer.valueOf(5));
    DeviceOptSwitch.b.add(Integer.valueOf(6));
    DeviceOptSwitch.b.add(Integer.valueOf(11));
    DeviceOptSwitch.b.add(Integer.valueOf(12));
    DeviceOptSwitch.b.add(Integer.valueOf(14));
    DeviceOptSwitch.b.add(Integer.valueOf(17));
    DeviceOptSwitch.b.add(Integer.valueOf(20));
    DeviceOptSwitch.b.add(Integer.valueOf(21));
    DeviceOptSwitch.b.add(Integer.valueOf(59));
    DeviceOptSwitch.b.add(Integer.valueOf(60));
  }
  
  public static int a(LinearGroup paramLinearGroup, boolean paramBoolean)
  {
    if ("{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,113,108,44,45,115,114,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
      if (paramLinearGroup.e <= 4) {}
    }
    while (paramBoolean)
    {
      return 1;
      return 0;
    }
    return 0;
  }
  
  public static AsyncStep a(Automator paramAutomator, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (TextUtils.isEmpty(str)) {
      throw new RuntimeException("createStepGroup: " + str);
    }
    int i = -1;
    if (str.startsWith("{"))
    {
      paramString = new LinearGroup();
      paramString.b = str;
    }
    for (;;)
    {
      paramString.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator = paramAutomator;
      paramString.b = i;
      if (i < 0) {
        break;
      }
      paramString.jdField_a_of_type_JavaLangString = paramString.getClass().getSimpleName();
      return paramString;
      if (str.startsWith("["))
      {
        paramString = new ParallGroup();
        paramString.b = str;
      }
      else
      {
        i = Integer.parseInt(str);
        paramString = (Class)jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (paramString != null) {
          try
          {
            paramString = (AsyncStep)paramString.newInstance();
          }
          catch (Exception paramString)
          {
            QLog.e("QQInitHandler", 1, paramString, new Object[0]);
            paramString = null;
          }
        } else {
          paramString = new AsyncStep();
        }
      }
    }
    paramString.jdField_a_of_type_JavaLangString = str;
    return paramString;
  }
  
  public static boolean a(LinearGroup paramLinearGroup)
  {
    if ("{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,113,108,44,45,115,114,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
      if (paramLinearGroup.e < 3) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (!"{[13,16],19,21,58,60,89,23,46,33,61,42,92,96,97,99}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (paramLinearGroup.e >= 1);
      return false;
    } while (("{15,18,21,58,60,24}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) || (!"{[11,12,14],17,20,21,22108,}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) || (paramLinearGroup.e >= 2));
    return false;
  }
  
  public static boolean b(LinearGroup paramLinearGroup)
  {
    return (!"{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,113,108,44,45,115,114,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) || (paramLinearGroup.e > 5);
  }
  
  public static boolean c(LinearGroup paramLinearGroup)
  {
    if ("{85,{4,3,5,6},[11,12,14],17,20,21,59,60,22,113,108,44,45,115,114,[100,65,25,10,26,27,28,29,30,32,34,35,39,40,41,42,43,47,48,50,55,107,69,93,70,71,72,73,{91},53,54,61,104,63,77,81,67,80,74,36,37,38,87,88,78,82,84,98,86,102,103,109,110,111,112],57,95,105}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
      if (paramLinearGroup.e <= 4) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (!"{[13,16],19,21,58,60,89,23,46,33,61,42,92,96,97,99}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (paramLinearGroup.e > 2);
        return false;
        if (!"{15,18,21,58,60,24}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (paramLinearGroup.e > 2);
      return false;
    } while ((!"{[11,12,14],17,20,21,22108,}".equals(paramLinearGroup.jdField_a_of_type_JavaLangString)) || (paramLinearGroup.e > 2));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.StepFactory
 * JD-Core Version:    0.7.0.1
 */