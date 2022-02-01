package com.tencent.mobileqq.ark.API;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.ark.open.security.ArkBaseUrlChecker;
import com.tencent.av.wtogether.util.WTEntranceHelper;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.mobileqq.ark.security.ArkSecurityReporter;
import com.tencent.mobileqq.config.business.ArkConfBean;
import com.tencent.mobileqq.config.business.ArkConfProcessor;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ArkCommonUtil
{
  public static Intent a(Context paramContext, String paramString1, boolean paramBoolean, long paramLong, MessageForArkApp paramMessageForArkApp, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
    localIntent.putExtra("param_force_internal_browser", paramBoolean);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("injectrecommend", false);
    localIntent.putExtra("browserType", paramInt);
    ArkAppCenter.a(localIntent, paramString2);
    if (!TextUtils.isEmpty(paramString4)) {
      localIntent.putExtra("big_brother_ref_source_key", paramString4);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null)) {
        break label907;
      }
      paramString2 = paramMessageForArkApp.ark_app_message.appView;
      paramString2 = ArkAppMgr.getInstance().getAppPathByNameFromLocal(paramString3, paramString2, null, false);
      if (!TextUtils.isEmpty(paramString2))
      {
        localIntent.putExtra("h5_ark_app_path", paramString2);
        paramString2 = ArkAppCacheMgr.getApplicationDesc(paramString3);
        if (!TextUtils.isEmpty(paramString2)) {
          localIntent.putExtra("h5_ark_app_des", paramString2);
        }
      }
      if ((paramMessageForArkApp != null) && (paramMessageForArkApp.ark_app_message != null) && (paramMessageForArkApp.buildTypeAndTitle().isSdkShare)) {
        localIntent.putExtra("h5_ark_is_from_share", true);
      }
      localIntent.putExtra("h5_ark_app_name", paramString3);
      paramString2 = ArkAppConfigMgr.getInstance().getUrlChecker(paramString3);
      if (paramString2 != null)
      {
        paramString2 = paramString2.getAppNavigationChecker();
        if (paramString2 != null)
        {
          localIntent.putExtra("h5_ark_url_web_checker", paramString2);
          boolean bool1 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString3);
          boolean bool2 = ArkAppCenterUtil.a();
          if ((!bool1) || (bool2)) {
            break label915;
          }
          paramBoolean = true;
          label276:
          localIntent.putExtra("h5_ark_url_web_checker_enable", paramBoolean);
          localIntent.putExtra("h5_ark_url_web_sender_uin", ArkAppContainer.c);
          if (bool2) {
            localIntent.putExtra("puin", ArkAppContainer.c);
          }
          QLog.d("ArkApp.ArkCommonUtil", 1, new Object[] { "ArkSafe.UrlCheck.launchQQBrowser,appname=", paramString3, ", enableCheck=", Boolean.valueOf(paramBoolean), ", appEnableCheck=", Boolean.valueOf(bool1), ", isPublicAccount=", Boolean.valueOf(bool2), ", senderUin=", ArkAppContainer.c, ", mUrlChecker=", paramString2.toString() });
          ChooseImageIPCModule.a().a(new ArkCommonUtil.1());
        }
      }
    }
    paramString2 = ArkConfProcessor.b(186).a();
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("h5_ark_check_config", paramString2);
    }
    paramString2 = a();
    paramString3 = a(true);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("h5_ark_nation_code", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localIntent.putExtra("h5_ark_phone_number", paramString3);
    }
    if (paramMessageForArkApp != null)
    {
      paramString2 = paramMessageForArkApp.ark_app_message;
      label502:
      if (paramString2 != null)
      {
        localIntent.putExtra("forward_ark_app_direct", false);
        localIntent.putExtra("forward_ark_app_name", paramString2.appName);
        localIntent.putExtra("forward_ark_app_view", paramString2.appView);
        localIntent.putExtra("forward_ark_app_desc", paramString2.appDesc);
        localIntent.putExtra("forward_ark_app_prompt", paramString2.promptText);
        paramString4 = paramString2.metaList;
        paramString3 = paramString4;
        if (TextUtils.isEmpty(paramString4)) {
          paramString3 = "{}";
        }
        localIntent.putExtra("forward_ark_app_meta", paramString3);
        localIntent.putExtra("forward_ark_app_config", paramString2.config);
        localIntent.putExtra("forward_ark_from_h5", true);
        if (TextUtils.isEmpty(paramString2.appId)) {
          break label926;
        }
        localIntent.putExtra("forward_appId_ark_from_sdk", paramString2.appId);
        localIntent.putExtra("struct_share_key_source_name", paramString2.mSourceName);
        localIntent.putExtra("struct_share_key_source_action_data", paramString2.mSourceActionData);
        localIntent.putExtra("struct_share_key_source_a_action_data", paramString2.mSource_A_ActionData);
        localIntent.putExtra("struct_share_key_source_url", paramString2.mSourceUrl);
        ArkAppDataReport.a(a(), paramString2.appName, "AIOArkSdkCardClick", 1, 0, 0L, 0L, 0L, paramString2.appView, "");
      }
    }
    for (;;)
    {
      if (paramMessageForArkApp.istroop == 0) {
        localIntent.putExtra("friend_uin", paramMessageForArkApp.frienduin);
      }
      if (paramMessageForArkApp.istroop == 1) {
        localIntent.putExtra("groupUin", paramMessageForArkApp.frienduin);
      }
      if (paramMessageForArkApp.istroop == 3000) {
        localIntent.putExtra("dicussgroup_uin", paramMessageForArkApp.frienduin);
      }
      localIntent.putExtra("friendUin", paramMessageForArkApp.senderuin);
      localIntent.putExtra("uinType", paramMessageForArkApp.istroop);
      localIntent.putExtra("is_send", paramMessageForArkApp.isSend());
      localIntent.putExtra("fromAio", true);
      localIntent.putExtra("appShareID", paramLong);
      localIntent.putExtra("forward_ark_app_direct", true);
      if (paramContext != null)
      {
        if ((paramString1 == null) || (!paramString1.contains("https://film.qq.com/h5/qq-together/detail.html")) || (!paramString1.contains("aioId"))) {
          break label965;
        }
        WTEntranceHelper.a((Activity)paramContext, paramString1);
      }
      return localIntent;
      label907:
      paramString2 = "";
      break;
      label915:
      paramBoolean = false;
      break label276;
      paramString2 = null;
      break label502;
      label926:
      if (paramString2.from == 1) {
        ArkAppDataReport.a(a(), paramString2.appName, "AIOArkMapCardClick ", 1, 0, 0L, 0L, 0L, paramString2.appView, "");
      }
    }
    label965:
    paramContext.startActivity(localIntent);
    return localIntent;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      return ((PhoneContactManager)localQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a().nationCode;
    }
    return "";
  }
  
  public static String a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("sessionInfo=[");
      localStringBuilder.append("curType:").append(paramSessionInfo.jdField_a_of_type_Int);
      localStringBuilder.append(", curFriendUin:").append(paramSessionInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", troopUin:").append(paramSessionInfo.b);
      localStringBuilder.append(", curFriendNick").append(paramSessionInfo.d);
      return localStringBuilder.toString();
    }
    return "sessionInfo=null";
  }
  
  public static String a(boolean paramBoolean)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((PhoneContactManager)((QQAppInterface)localObject).getManager(QQManagerFactory.CONTACT_MANAGER)).a();
      String str = ((RespondQueryQQBindingStat)localObject).mobileNo;
      if (paramBoolean) {
        return str;
      }
      return ((RespondQueryQQBindingStat)localObject).nationCode + " " + str;
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("file_send_path", paramString);
    localBundle.putInt("video_play_caller", 1);
    localBundle.putBoolean("video_title_bar_hide", true);
    paramString = new Intent(paramContext, ShortVideoPlayActivity.class);
    paramString.putExtras(localBundle);
    if (paramContext != null) {
      paramContext.startActivity(paramString);
    }
  }
  
  public static boolean a(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject2 = BaseActivity.sTopActivity;
    Object localObject1;
    Object localObject3;
    if (((localObject2 instanceof FragmentActivity)) && (!TextUtils.isEmpty(paramString1)))
    {
      localObject1 = (FragmentActivity)localObject2;
      if (((FragmentActivity)localObject1).getChatFragment() == null) {
        break label866;
      }
      localObject3 = ((FragmentActivity)localObject1).getChatFragment().a();
      if ((!(localObject3 instanceof PublicAccountChatPie)) || (!"biz_src_ads".equals("biz_src_jc_ark"))) {
        break label866;
      }
      localObject1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(((BaseChatPie)localObject3).a.jdField_a_of_type_JavaLangString);
      QLog.d("ArkApp.ArkCommonUtil", 1, "ArkSafe.OpenUrl set hsSourceID for " + ((BaseChatPie)localObject3).a.jdField_a_of_type_JavaLangString + ", input " + "biz_src_jc_ark" + ", output " + (String)localObject1);
    }
    for (;;)
    {
      if (ArkAppSchemeCenter.a(paramString1, "", new JSONObject(), paramInt, paramString2))
      {
        ArkAppDataReport.a(null, paramString2, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        Log.d("ark.OpenUrl ", paramString1);
        ArkAppDataReport.a(null, paramString2, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
        return true;
      }
      int j;
      int i;
      label275:
      boolean bool2;
      boolean bool3;
      boolean bool1;
      if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
      {
        localObject3 = ArkAppConfigMgr.getInstance().getUrlChecker(paramString2);
        paramInt = 1;
        if (localObject3 != null)
        {
          j = ((ArkAppUrlChecker)localObject3).checkUrlIsValidByAppNavigationList(paramString1);
          i = 0;
          if (j != 0) {
            break label482;
          }
          paramInt = 1;
          bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString2);
          bool3 = ArkAppCenterUtil.a();
          if ((!bool2) || (bool3)) {
            break label487;
          }
          bool1 = true;
          label302:
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkCommonUtil", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.appname=", paramString2, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
          }
          if (paramInt != 0) {
            break label863;
          }
          i = 1;
          if (bool1) {
            break label863;
          }
          QLog.e("ArkApp.ArkCommonUtil", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.http appName=", paramString2, ",url=", Util.b(paramString1, new String[0]), ", isValid set=true" });
          paramInt = 1;
          i = 2;
        }
      }
      label557:
      label814:
      label860:
      label863:
      for (;;)
      {
        ArkSecurityReporter.b(paramString2, paramString1, j, i, ArkAppContainer.c);
        if (paramInt == 0)
        {
          QLog.d("ArkApp.ArkCommonUtil", 1, new Object[] { "ArkSafe.OpenUrl check url invalid!, url=", Util.b(paramString1, new String[0]), ", app=", paramString2 });
          return false;
          label482:
          paramInt = 0;
          break label275;
          label487:
          bool1 = false;
          break label302;
        }
        localObject3 = (FragmentActivity)localObject2;
        if (((FragmentActivity)localObject3).getChatFragment() != null)
        {
          localObject3 = ((FragmentActivity)localObject3).getChatFragment().a();
          if (!(localObject3 instanceof PublicAccountChatPie)) {
            break label557;
          }
          ((PublicAccountChatPie)localObject3).a.b();
        }
        for (;;)
        {
          a((Context)localObject2, paramString1, true, 0L, null, "biz_src_jc_ark", 0, paramString2, (String)localObject1);
          break;
          ArkAppDataReport.a(null, paramString2, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        }
        if (paramInt != 0) {
          break;
        }
        localObject1 = JumpParser.a(a(), (Context)localObject2, paramString1);
        if (localObject1 == null) {
          break;
        }
        localObject2 = ArkAppConfigMgr.getInstance().getUrlChecker(paramString2);
        paramInt = 1;
        if (localObject2 != null)
        {
          j = ((ArkAppUrlChecker)localObject2).checkUrlIsValidByAppNavigationList(paramString1);
          i = 0;
          if (j != 0) {
            break label809;
          }
          paramInt = 1;
          label632:
          bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString2);
          bool3 = ArkAppCenterUtil.a();
          if ((!bool2) || (bool3)) {
            break label814;
          }
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkCommonUtil", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.JumpAction=", paramString2, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
          }
          if (paramInt != 0) {
            break label860;
          }
          i = 1;
          if (bool1) {
            break label860;
          }
          QLog.e("ArkApp.ArkCommonUtil", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.jump appName=", paramString2, ",url=", Util.b(paramString1, new String[0]), ", isValid set=true" });
          paramInt = 1;
          i = 2;
        }
        for (;;)
        {
          ArkSecurityReporter.b(paramString2, paramString1, j, i, ArkAppContainer.c);
          if (paramInt != 0)
          {
            ((JumpAction)localObject1).a();
            break;
            paramInt = 0;
            break label632;
            bool1 = false;
            break label659;
          }
          QLog.e("ArkApp.ArkCommonUtil", 1, new Object[] { "ArkSafe.OpenUrl check url invalid, url=", Util.b(paramString1, new String[0]), ", app=", paramString2 });
          break;
        }
      }
      label659:
      label809:
      label866:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkCommonUtil
 * JD-Core Version:    0.7.0.1
 */