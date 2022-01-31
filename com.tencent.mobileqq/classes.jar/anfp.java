import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ModuleCallbackWrapper;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.ark.open.security.ArkBaseUrlChecker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatFragment;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class anfp
{
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.indexOf("com.tencent.", 0) == -1) {
      return 1L;
    }
    return 0L;
  }
  
  protected static Intent a(Context paramContext, String paramString1, boolean paramBoolean, long paramLong, MessageForArkApp paramMessageForArkApp, String paramString2, int paramInt, String paramString3, String paramString4)
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
        break label820;
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
          boolean bool2 = anjs.a();
          if ((!bool1) || (bool2)) {
            break label827;
          }
          paramBoolean = true;
          label262:
          localIntent.putExtra("h5_ark_url_web_checker_enable", paramBoolean);
          localIntent.putExtra("h5_ark_url_web_sender_uin", afdt.c);
          if (bool2) {
            localIntent.putExtra("puin", afdt.c);
          }
          QLog.d("ArkApp", 1, new Object[] { "ArkSafe.UrlCheck.launchQQBrowser,appname=", paramString3, ", enableCheck=", Boolean.valueOf(paramBoolean), ", appEnableCheck=", Boolean.valueOf(bool1), ", isPublicAccount=", Boolean.valueOf(bool2), ", senderUin=", afdt.c, ", mUrlChecker=", paramString1.toString() });
          anmg.a().a(new anfr());
        }
      }
    }
    paramString1 = aoho.b(186).a();
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
          break label837;
        }
        localIntent.putExtra("forward_appId_ark_from_sdk", paramString1.appId);
        localIntent.putExtra("struct_share_key_source_name", paramString1.mSourceName);
        localIntent.putExtra("struct_share_key_source_action_data", paramString1.mSourceActionData);
        localIntent.putExtra("struct_share_key_source_a_action_data", paramString1.mSource_A_ActionData);
        localIntent.putExtra("struct_share_key_source_url", paramString1.mSourceUrl);
        anjv.a(a(), paramString1.appName, "AIOArkSdkCardClick", 1, 0, 0L, 0L, 0L, paramString1.appView, "");
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
      label820:
      paramString1 = "";
      break;
      label827:
      paramBoolean = false;
      break label262;
      paramString1 = null;
      break label480;
      label837:
      if (paramString1.from == 1) {
        anjv.a(a(), paramString1.appName, "AIOArkMapCardClick ", 1, 0, 0L, 0L, 0L, paramString1.appView, "");
      }
    }
  }
  
  public static SessionInfo a()
  {
    SessionInfo localSessionInfo = null;
    Object localObject1 = localSessionInfo;
    Object localObject2;
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localObject2 = (FragmentActivity)BaseActivity.sTopActivity;
      localObject1 = (ChatFragment)((FragmentActivity)localObject2).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject1 == null) {
        break label93;
      }
      localObject1 = ((ChatFragment)localObject1).a();
      if (localObject1 == null) {
        break label160;
      }
      localSessionInfo = ((BaseChatPie)localObject1).a();
      localObject1 = localSessionInfo;
      if (QLog.isColorLevel())
      {
        QLog.d("ArkApp", 2, new Object[] { "multiAio.getTopChatSessionInfo form baseChatPie=", a(localSessionInfo) });
        localObject1 = localSessionInfo;
      }
    }
    for (;;)
    {
      return localObject1;
      label93:
      localObject1 = localSessionInfo;
      if ((localObject2 instanceof MiniChatActivity))
      {
        localObject2 = ((MiniChatActivity)localObject2).a();
        localObject1 = localSessionInfo;
        if ((localObject2 instanceof MiniChatFragment))
        {
          localSessionInfo = ((MiniChatFragment)localObject2).a();
          localObject1 = localSessionInfo;
          if (QLog.isColorLevel())
          {
            QLog.d("ArkApp", 2, new Object[] { "multiAio.getTopChatSessionInfo form miniChatPie=", a(localSessionInfo) });
            return localSessionInfo;
            label160:
            localObject1 = null;
          }
        }
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
      return ((aubm)localQQAppInterface.getManager(11)).a().nationCode;
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
      localObject = ((aubm)((QQAppInterface)localObject).getManager(11)).a();
      String str = ((RespondQueryQQBindingStat)localObject).mobileNo;
      if (paramBoolean) {
        return str;
      }
      return ((RespondQueryQQBindingStat)localObject).nationCode + " " + str;
    }
    return "";
  }
  
  protected static void a(Context paramContext, String paramString)
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
  
  public static void a(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    Object localObject1 = paramApplication.GetSpecific("appName");
    paramApplication.GetSpecific("appPath");
    if ((localObject1 != null) && (((String)localObject1).indexOf("com.tencent.", 0) == -1)) {}
    for (long l = 1L;; l = 0L)
    {
      Object localObject2 = a();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null))
      {
        localObject1 = (ArkAppCenter)((QQAppInterface)localObject2).getManager(121);
        if (localObject1 == null) {}
      }
      for (localObject1 = ((ArkAppCenter)localObject1).a();; localObject1 = null)
      {
        localObject2 = new ArrayList();
        ((List)localObject2).add(new anfv(paramApplication, l));
        ((List)localObject2).add(new andw(paramApplication, l));
        if (1 == BaseApplicationImpl.sProcessId)
        {
          ((List)localObject2).add(new aneq(paramApplication, l));
          ((List)localObject2).add(new anhb(paramApplication, l));
        }
        if (l == 0L) {
          ((List)localObject2).add(new angk(paramApplication, l));
        }
        paramApplication = ((List)localObject2).iterator();
        while (paramApplication.hasNext())
        {
          localObject2 = (anft)paramApplication.next();
          if (localObject1 != null) {
            ((anft)localObject2).a((List)anhp.a.get(((anft)localObject2).GetTypeName()));
          }
          paramModuleRegister.RegCallbackWrapper((ark.ModuleCallbackWrapper)localObject2);
        }
        return;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, anfs paramanfs)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (a() != null)) {
      ArkAppMgr.getInstance().getAppPathByNameTimeout(3000L, paramString1, paramString2, "0.0.0.1", null, new anfq(paramString1, paramString3, paramanfs));
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
        break label847;
      }
      localObject3 = ((FragmentActivity)localObject1).getChatFragment().a();
      if ((!(localObject3 instanceof agot)) || (!"biz_src_ads".equals("biz_src_jc_ark"))) {
        break label847;
      }
      localObject1 = syb.b(((BaseChatPie)localObject3).a.jdField_a_of_type_JavaLangString);
      QLog.d("ArkApp", 1, "ArkSafe.OpenUrl set hsSourceID for " + ((BaseChatPie)localObject3).a.jdField_a_of_type_JavaLangString + ", input " + "biz_src_jc_ark" + ", output " + (String)localObject1);
    }
    for (;;)
    {
      if (angr.a(paramString1, null, null, paramInt, paramString2))
      {
        anjv.a(null, paramString2, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        Log.d("ark.OpenUrl ", paramString1);
        anjv.a(null, paramString2, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
        return true;
      }
      int j;
      int i;
      label256:
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
            break label463;
          }
          paramInt = 1;
          bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString2);
          bool3 = anjs.a();
          if ((!bool2) || (bool3)) {
            break label468;
          }
          bool1 = true;
          label283:
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.appname=", paramString2, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
          }
          if (paramInt != 0) {
            break label844;
          }
          i = 1;
          if (bool1) {
            break label844;
          }
          QLog.e("ArkApp", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.http appName=", paramString2, ",url=", ndq.b(paramString1, new String[0]), ", isValid set=true" });
          paramInt = 1;
          i = 2;
        }
      }
      label538:
      label795:
      label841:
      label844:
      for (;;)
      {
        annd.b(paramString2, paramString1, j, i, afdt.c);
        if (paramInt == 0)
        {
          QLog.d("ArkApp", 1, new Object[] { "ArkSafe.OpenUrl check url invalid!, url=", ndq.b(paramString1, new String[0]), ", app=", paramString2 });
          return false;
          label463:
          paramInt = 0;
          break label256;
          label468:
          bool1 = false;
          break label283;
        }
        localObject3 = (FragmentActivity)localObject2;
        if (((FragmentActivity)localObject3).getChatFragment() != null)
        {
          localObject3 = ((FragmentActivity)localObject3).getChatFragment().a();
          if (!(localObject3 instanceof agot)) {
            break label538;
          }
          ((agot)localObject3).a.b();
        }
        for (;;)
        {
          a((Context)localObject2, paramString1, true, 0L, null, "biz_src_jc_ark", 0, paramString2, (String)localObject1);
          break;
          anjv.a(null, paramString2, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        }
        if (paramInt != 0) {
          break;
        }
        localObject1 = bdds.a(a(), (Context)localObject2, paramString1);
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
            break label790;
          }
          paramInt = 1;
          label613:
          bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString2);
          bool3 = anjs.a();
          if ((!bool2) || (bool3)) {
            break label795;
          }
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.JumpAction=", paramString2, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
          }
          if (paramInt != 0) {
            break label841;
          }
          i = 1;
          if (bool1) {
            break label841;
          }
          QLog.e("ArkApp", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.jump appName=", paramString2, ",url=", ndq.b(paramString1, new String[0]), ", isValid set=true" });
          paramInt = 1;
          i = 2;
        }
        for (;;)
        {
          annd.b(paramString2, paramString1, j, i, afdt.c);
          if (paramInt != 0)
          {
            ((bddb)localObject1).c();
            break;
            paramInt = 0;
            break label613;
            bool1 = false;
            break label640;
          }
          QLog.e("ArkApp", 1, new Object[] { "ArkSafe.OpenUrl check url invalid, url=", ndq.b(paramString1, new String[0]), ", app=", paramString2 });
          break;
        }
      }
      label640:
      label790:
      label847:
      localObject1 = null;
    }
  }
  
  public static boolean a(String paramString1, long paramLong, ark.Application paramApplication, String paramString2)
  {
    boolean bool;
    if (paramLong == 0L) {
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        QLog.i("ArkApp", 1, String.format("ModuleCheckPermission.denied:Name:%s,Permission:%s.", new Object[] { paramString1, paramString2 }));
      }
      return bool;
      if ((paramApplication != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        bool = paramApplication.CheckPermissions(paramString2);
      } else {
        bool = false;
      }
    }
  }
  
  private static int b(ark.VariantWrapper[] paramArrayOfVariantWrapper, long paramLong)
  {
    int i = 2;
    int k = 0;
    if (paramLong >= 2L)
    {
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1];
      String[] arrayOfString;
      int j;
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.GetType() == 5) && (paramArrayOfVariantWrapper.GetString() != null))
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.GetString().toLowerCase();
        arrayOfString = new String[8];
        arrayOfString[0] = "d";
        arrayOfString[1] = "debug";
        arrayOfString[2] = "i";
        arrayOfString[3] = "info";
        arrayOfString[4] = "e";
        arrayOfString[5] = "error";
        arrayOfString[6] = "w";
        arrayOfString[7] = "warning";
        if (!arrayOfString[0].equals(paramArrayOfVariantWrapper))
        {
          j = i;
          if (!arrayOfString[1].equals(paramArrayOfVariantWrapper)) {}
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label212;
          }
          j = 0;
          k = 1;
        }
      }
      for (;;)
      {
        int m = i;
        if (k == 0)
        {
          m = i;
          if (j == 0) {
            m = 1;
          }
        }
        return m;
        do
        {
          j += 1;
          if (j >= arrayOfString.length) {
            break;
          }
        } while (!arrayOfString[j].equals(paramArrayOfVariantWrapper));
        j = 1;
        i = 1;
        continue;
        return 1;
        i = 4;
        j = 0;
        continue;
        label212:
        i = 4;
        j = 0;
        k = 1;
      }
    }
    return 4;
  }
  
  private static String b(ark.VariantWrapper[] paramArrayOfVariantWrapper)
  {
    if (paramArrayOfVariantWrapper.length >= 3)
    {
      if ((paramArrayOfVariantWrapper[2].IsArray()) || (paramArrayOfVariantWrapper[2].IsTable())) {
        return paramArrayOfVariantWrapper[2].GetTableAsJsonString();
      }
      return "";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfp
 * JD-Core Version:    0.7.0.1
 */