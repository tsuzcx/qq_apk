import SecurityAccountServer.RespondQueryQQBindingStat;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class apxt
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
        break label817;
      }
      paramString1 = paramMessageForArkApp.ark_app_message.appView;
      paramString1 = ArkAppMgr.getInstance().getAppPathByNameFromLocal(paramString3, paramString1, null, false);
      if (!TextUtils.isEmpty(paramString1))
      {
        localIntent.putExtra("h5_ark_app_path", paramString1);
        paramString1 = ArkAppCacheMgr.getApplicationDesc(paramString3);
        if (!TextUtils.isEmpty(paramString1)) {
          localIntent.putExtra("h5_ark_app_des", paramString1);
        }
      }
      if ((paramMessageForArkApp != null) && (paramMessageForArkApp.ark_app_message != null) && (paramMessageForArkApp.buildTypeAndTitle().isSdkShare)) {
        localIntent.putExtra("h5_ark_is_from_share", true);
      }
      localIntent.putExtra("h5_ark_app_name", paramString3);
      paramString1 = ArkAppConfigMgr.getInstance().getUrlChecker(paramString3);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getAppNavigationChecker();
        if (paramString1 != null)
        {
          localIntent.putExtra("h5_ark_url_web_checker", paramString1);
          boolean bool1 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString3);
          boolean bool2 = aqbx.a();
          if ((!bool1) || (bool2)) {
            break label823;
          }
          paramBoolean = true;
          label262:
          localIntent.putExtra("h5_ark_url_web_checker_enable", paramBoolean);
          localIntent.putExtra("h5_ark_url_web_sender_uin", agyw.c);
          if (bool2) {
            localIntent.putExtra("puin", agyw.c);
          }
          QLog.d("ArkApp.ArkCommonUtil", 1, new Object[] { "ArkSafe.UrlCheck.launchQQBrowser,appname=", paramString3, ", enableCheck=", Boolean.valueOf(paramBoolean), ", appEnableCheck=", Boolean.valueOf(bool1), ", isPublicAccount=", Boolean.valueOf(bool2), ", senderUin=", agyw.c, ", mUrlChecker=", paramString1.toString() });
          aqel.a().a(new apxu());
        }
      }
    }
    paramString1 = arca.b(186).a();
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("h5_ark_check_config", paramString1);
    }
    paramString1 = a();
    paramString2 = a(true);
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("h5_ark_nation_code", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("h5_ark_phone_number", paramString2);
    }
    if (paramMessageForArkApp != null)
    {
      paramString1 = paramMessageForArkApp.ark_app_message;
      label480:
      if (paramString1 != null)
      {
        localIntent.putExtra("forward_ark_app_direct", false);
        localIntent.putExtra("forward_ark_app_name", paramString1.appName);
        localIntent.putExtra("forward_ark_app_view", paramString1.appView);
        paramString3 = paramString1.metaList;
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          paramString2 = "{}";
        }
        localIntent.putExtra("forward_ark_app_meta", paramString2);
        localIntent.putExtra("forward_ark_app_config", paramString1.config);
        localIntent.putExtra("forward_ark_from_h5", true);
        if (TextUtils.isEmpty(paramString1.appId)) {
          break label833;
        }
        localIntent.putExtra("forward_appId_ark_from_sdk", paramString1.appId);
        localIntent.putExtra("struct_share_key_source_name", paramString1.mSourceName);
        localIntent.putExtra("struct_share_key_source_action_data", paramString1.mSourceActionData);
        localIntent.putExtra("struct_share_key_source_a_action_data", paramString1.mSource_A_ActionData);
        localIntent.putExtra("struct_share_key_source_url", paramString1.mSourceUrl);
        aqca.a(a(), paramString1.appName, "AIOArkSdkCardClick", 1, 0, 0L, 0L, 0L, paramString1.appView, "");
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
      if (paramContext != null) {
        paramContext.startActivity(localIntent);
      }
      return localIntent;
      label817:
      paramString1 = "";
      break;
      label823:
      paramBoolean = false;
      break label262;
      paramString1 = null;
      break label480;
      label833:
      if (paramString1.from == 1) {
        aqca.a(a(), paramString1.appName, "AIOArkMapCardClick ", 1, 0, 0L, 0L, 0L, paramString1.appView, "");
      }
    }
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
      return ((axfr)localQQAppInterface.getManager(11)).a().nationCode;
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
      localObject = ((axfr)((QQAppInterface)localObject).getManager(11)).a();
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
        break label841;
      }
      localObject3 = ((FragmentActivity)localObject1).getChatFragment().a();
      if ((!(localObject3 instanceof ainh)) || (!"biz_src_ads".equals("biz_src_jc_ark"))) {
        break label841;
      }
      localObject1 = tzq.b(((BaseChatPie)localObject3).a.jdField_a_of_type_JavaLangString);
      QLog.d("ArkApp.ArkCommonUtil", 1, "ArkSafe.OpenUrl set hsSourceID for " + ((BaseChatPie)localObject3).a.jdField_a_of_type_JavaLangString + ", input " + "biz_src_jc_ark" + ", output " + (String)localObject1);
    }
    for (;;)
    {
      if (apxc.a(paramString1, null, null, paramInt, paramString2))
      {
        aqca.a(null, paramString2, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        Log.d("ark.OpenUrl ", paramString1);
        aqca.a(null, paramString2, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
        return true;
      }
      int j;
      int i;
      label252:
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
            break label459;
          }
          paramInt = 1;
          bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString2);
          bool3 = aqbx.a();
          if ((!bool2) || (bool3)) {
            break label464;
          }
          bool1 = true;
          label279:
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkCommonUtil", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.appname=", paramString2, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
          }
          if (paramInt != 0) {
            break label838;
          }
          i = 1;
          if (bool1) {
            break label838;
          }
          QLog.e("ArkApp.ArkCommonUtil", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.http appName=", paramString2, ",url=", noe.b(paramString1, new String[0]), ", isValid set=true" });
          paramInt = 1;
          i = 2;
        }
      }
      label534:
      label835:
      label838:
      for (;;)
      {
        aqfh.b(paramString2, paramString1, j, i, agyw.c);
        if (paramInt == 0)
        {
          QLog.d("ArkApp.ArkCommonUtil", 1, new Object[] { "ArkSafe.OpenUrl check url invalid!, url=", noe.b(paramString1, new String[0]), ", app=", paramString2 });
          return false;
          label459:
          paramInt = 0;
          break label252;
          label464:
          bool1 = false;
          break label279;
        }
        localObject3 = (FragmentActivity)localObject2;
        if (((FragmentActivity)localObject3).getChatFragment() != null)
        {
          localObject3 = ((FragmentActivity)localObject3).getChatFragment().a();
          if (!(localObject3 instanceof ainh)) {
            break label534;
          }
          ((ainh)localObject3).a.b();
        }
        for (;;)
        {
          a((Context)localObject2, paramString1, true, 0L, null, "biz_src_jc_ark", 0, paramString2, (String)localObject1);
          break;
          aqca.a(null, paramString2, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        }
        if (paramInt != 0) {
          break;
        }
        localObject1 = bhni.a(a(), (Context)localObject2, paramString1);
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
            break label784;
          }
          paramInt = 1;
          label607:
          bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString2);
          bool3 = aqbx.a();
          if ((!bool2) || (bool3)) {
            break label789;
          }
          bool1 = true;
          label634:
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkCommonUtil", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.JumpAction=", paramString2, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
          }
          if (paramInt != 0) {
            break label835;
          }
          i = 1;
          if (bool1) {
            break label835;
          }
          QLog.e("ArkApp.ArkCommonUtil", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.jump appName=", paramString2, ",url=", noe.b(paramString1, new String[0]), ", isValid set=true" });
          paramInt = 1;
          i = 2;
        }
        for (;;)
        {
          aqfh.b(paramString2, paramString1, j, i, agyw.c);
          if (paramInt != 0)
          {
            ((bhmr)localObject1).a();
            break;
            paramInt = 0;
            break label607;
            bool1 = false;
            break label634;
          }
          QLog.e("ArkApp.ArkCommonUtil", 1, new Object[] { "ArkSafe.OpenUrl check url invalid, url=", noe.b(paramString1, new String[0]), ", app=", paramString2 });
          break;
        }
      }
      label784:
      label789:
      label841:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxt
 * JD-Core Version:    0.7.0.1
 */