package com.tencent.mobileqq.apollo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.cmsshow.api.IAECMSShow;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.drawer.PushDrawerStrategy;
import com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class CmShowLauncher
{
  private static long a;
  
  public static void a(Activity paramActivity)
  {
    if (!((IAECMSShow)QRoute.api(IAECMSShow.class)).isAEResReady())
    {
      paramActivity.runOnUiThread(new CmShowLauncher.1(paramActivity));
      return;
    }
    if (!((IAECMSShow)QRoute.api(IAECMSShow.class)).supportAceEngine())
    {
      paramActivity.runOnUiThread(new CmShowLauncher.2(paramActivity));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10027);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("PeakConstants.ARG_FORCE_CAMERA", 1);
    Object localObject = (IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_cmshow_first_guide_has_shown_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    boolean bool = ((IAECameraPrefsUtil)localObject).getBoolean(localStringBuilder.toString(), false, 4);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchCMCustomFaceCamera---hasShownGuide=");
    ((StringBuilder)localObject).append(bool);
    QLog.i("CmShowLauncher", 1, ((StringBuilder)localObject).toString());
    if (bool)
    {
      ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).launchForResult(paramActivity, localBundle, 100);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtras(localBundle);
    ((IAECMSShow)QRoute.api(IAECMSShow.class)).jumpToMeForResult(paramActivity, (Intent)localObject, 100);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject;
    if (paramAppInterface == null)
    {
      localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        localObject = ((BaseApplicationImpl)localObject).getRuntime();
        if ((localObject != null) && ((localObject instanceof AppInterface)))
        {
          paramAppInterface = (AppInterface)localObject;
        }
        else if ((localObject instanceof ToolAppRuntime))
        {
          localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
          if ((localObject instanceof AppInterface)) {
            paramAppInterface = (AppInterface)localObject;
          }
        }
      }
    }
    if (!ApolloHardWareTester.a(paramContext))
    {
      paramIntent = new Intent(paramContext, QQBrowserActivity.class);
      paramIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.a(paramContext, ApolloConstant.u, -1L, paramIntent, false, -1);
      QLog.d("[cmshow]CmShowLauncher", 1, "openApolloStore !isHardwareSupport, return");
      return;
    }
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if ((1 == localApolloManagerServiceImpl.getWhiteListStatus()) && (ApolloUtilImpl.isApolloUser(paramAppInterface)))
    {
      if (paramIntent == null) {
        localObject = new Intent();
      } else {
        localObject = paramIntent;
      }
      boolean bool = localApolloManagerServiceImpl.is3dAvailable();
      if ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains("tab=3d")) && (!bool)) {
        paramIntent = ApolloConstant.I;
      } else {
        paramIntent = paramString2;
      }
      paramString2 = paramIntent;
      if (!TextUtils.isEmpty(ApolloConstant.I))
      {
        paramString2 = paramIntent;
        if (ApolloConstant.I.equals(paramIntent))
        {
          paramString2 = paramIntent;
          if (bool) {
            paramString2 = ApolloConstant.Q;
          }
        }
      }
      if (((Intent)localObject).getIntExtra("key_box_type", 0) == 3)
      {
        paramIntent = ApolloConstant.D;
        paramString1 = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.a(paramContext, paramIntent, -1L, paramString1, false, -1);
        QLog.d("[cmshow]CmShowLauncher", 1, "openApolloStore boxType == ApolloPandora.BOX_TYPE_BEAN, return");
        return;
      }
      ((Intent)localObject).putExtra("extra_key_nickname", paramAppInterface.getCurrentNickname());
      if (!TextUtils.isEmpty(paramString1)) {
        ((Intent)localObject).putExtra("extra_key_adtag", paramString1);
      }
      ((Intent)localObject).putExtra("extra_key_click_time", System.currentTimeMillis());
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      paramIntent = new StringBuilder();
      paramIntent.append("apollo_client, clickTime:");
      paramIntent.append(TimeFormatterUtils.a(System.currentTimeMillis(), "dd-MMM-yyyy HH:mm:ss:SSS"));
      paramIntent.append(",url:");
      paramIntent.append(paramString2);
      QLog.d("[cmshow]CmShowLauncher", 2, paramIntent.toString());
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString2.replace("_bid=2423&", "");
        paramIntent = paramString1;
        if (PushDrawerStrategy.e)
        {
          if (!TextUtils.isEmpty(PushDrawerStrategy.h))
          {
            paramIntent = URLUtil.a(paramString1, "wording", PushDrawerStrategy.h);
          }
          else
          {
            paramIntent = paramString1;
            if (!TextUtils.isEmpty(PushDrawerStrategy.f)) {
              paramIntent = URLUtil.a(paramString1, "wording", PushDrawerStrategy.f);
            }
          }
          paramString1 = paramIntent;
          if (!TextUtils.isEmpty(PushDrawerStrategy.i)) {
            paramString1 = URLUtil.a(paramIntent, "bubble_id", PushDrawerStrategy.i);
          }
          paramIntent = paramString1;
          if (!TextUtils.isEmpty(PushDrawerStrategy.g)) {
            paramIntent = URLUtil.a(paramString1, "tip_url", PushDrawerStrategy.g);
          }
        }
        paramString1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).checkWrapApolloUrl(paramIntent);
        if (localApolloManagerServiceImpl.mIsNewStoreUser) {
          paramIntent = "1";
        } else {
          paramIntent = "0";
        }
        paramString1 = URLUtil.a(paramString1, "is_new_store_user", paramIntent);
        if (bool) {
          paramIntent = "1";
        } else {
          paramIntent = "0";
        }
        paramIntent = URLUtil.a(paramString1, "is_3d_available", paramIntent);
        if (((Intent)localObject).getBooleanExtra("extra_key_open_box", false))
        {
          if (a()) {
            ((Intent)localObject).putExtra("extra_key_open_box", false);
          }
          paramIntent = URLUtil.a(paramIntent, "boxReady", "1");
        }
        else
        {
          paramIntent = URLUtil.a(paramIntent, "boxReady", "0");
        }
        ((Intent)localObject).putExtra("url", paramIntent);
        ((Intent)localObject).putExtra("url", paramIntent);
      }
      else
      {
        if (!TextUtils.isEmpty(ApolloConstant.H)) {
          paramIntent = ApolloConstant.H;
        } else {
          paramIntent = ApolloConstant.w;
        }
        paramIntent = paramIntent.replace("_bid=2423&", "");
        paramString1 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).checkWrapApolloUrl(paramIntent);
        if (localApolloManagerServiceImpl.mIsNewStoreUser) {
          paramIntent = "1";
        } else {
          paramIntent = "0";
        }
        paramString1 = URLUtil.a(paramString1, "is_new_store_user", paramIntent);
        if (bool) {
          paramIntent = "1";
        } else {
          paramIntent = "0";
        }
        paramIntent = URLUtil.a(paramString1, "is_3d_available", paramIntent);
        if (((Intent)localObject).getBooleanExtra("extra_key_open_box", false))
        {
          if (a()) {
            ((Intent)localObject).putExtra("extra_key_open_box", false);
          }
          paramIntent = URLUtil.a(paramIntent, "boxReady", "1");
        }
        else
        {
          paramIntent = URLUtil.a(paramIntent, "boxReady", "0");
        }
        ((Intent)localObject).putExtra("url", paramIntent);
        ((Intent)localObject).putExtra("url", paramIntent);
      }
      bool = paramContext instanceof Activity;
      if (!bool) {
        ((Intent)localObject).addFlags(268435456);
      }
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_lmx");
      paramString1 = new StringBuilder();
      paramString1.append("openApolloStore startActivity ");
      paramString1.append(paramIntent);
      QLog.d("[cmshow]CmShowLauncher", 1, paramString1.toString());
      if ((!paramIntent.contains("webviewCheckType=1")) && (!paramIntent.contains("webviewCheckType=2")))
      {
        ((Intent)localObject).setClass(paramContext, ApolloStoreActivity.class);
        QLog.d("[cmshow]CmShowLauncher", 2, "apollo_client, ApolloStoreActivity");
      }
      else
      {
        ((Intent)localObject).setClass(paramContext, ApolloStoreActivity.class);
        QLog.d("[cmshow]CmShowLauncher", 2, "apollo_client, ApolloStoreActivity");
      }
      if ((bool) && (paramInt > 0))
      {
        ((Activity)paramContext).startActivityForResult((Intent)localObject, paramInt);
        return;
      }
      paramContext.startActivity((Intent)localObject);
      return;
    }
    paramIntent = new Intent(paramContext, QQBrowserActivity.class);
    paramIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    paramString1 = new StringBuilder();
    paramString1.append(ApolloConstant.v);
    paramString1.append("0");
    VasWebviewUtil.a(paramContext, paramString1.toString(), -1L, paramIntent, false, -1);
    QLog.d("[cmshow]CmShowLauncher", 1, "openApolloStore !getWhiteListStatus || !isApolloUser, return");
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - a < 5000L) {
      return;
    }
    a = l1;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = CmShowWnsUtils.ab();
    }
    StringBuilder localStringBuilder = new StringBuilder(str);
    float f2 = FontSettingManager.getFontLevel() / 16.0F;
    float f1 = 2.0F;
    if (f2 != 0.0F) {
      f1 = DeviceInfoUtil.A() / f2;
    }
    f2 = f1;
    if (f1 == 0.0F) {
      f2 = DeviceInfoUtil.A();
    }
    int i = (int)(ImmersiveUtils.getStatusBarHeight(paramContext) / f2);
    if (str.indexOf("?") == -1) {
      localStringBuilder.append("?");
    } else {
      localStringBuilder.append("&");
    }
    l1 = DeviceInfoUtil.E();
    long l2 = DeviceInfoUtil.D();
    localStringBuilder.append("screenWidth=");
    localStringBuilder.append((int)((float)l2 / f2));
    localStringBuilder.append("&screenHeight=");
    localStringBuilder.append((int)((float)l1 / f2));
    localStringBuilder.append("&statusBarHeight=");
    localStringBuilder.append(i);
    localStringBuilder.append("&screenDensity=");
    localStringBuilder.append(f2);
    if (str.indexOf("&_wv") < 0)
    {
      localStringBuilder.append("&_wv=");
      localStringBuilder.append(16777223L);
    }
    if (str.indexOf("&_wwv") < 0)
    {
      localStringBuilder.append("&_wwv=");
      localStringBuilder.append(8704L);
    }
    localStringBuilder.append("&webviewOpenType=1");
    paramString = paramIntent;
    if (paramIntent == null) {
      paramString = new Intent();
    }
    paramString.putExtra("url", localStringBuilder.toString());
    paramString.putExtra("hide_left_button", true);
    paramString.setClass(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    paramString.putExtra("fragment_class", CmShowMakeupFragment.class.getCanonicalName());
    if ((paramContext instanceof Activity))
    {
      paramContext.startActivity(paramString);
      return;
    }
    paramString.addFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface != null) && (paramContext != null))
    {
      IApolloUtil localIApolloUtil = (IApolloUtil)QRoute.api(IApolloUtil.class);
      String str = localIApolloUtil.getStoreTabUrl(paramString1, true);
      if (!TextUtils.isEmpty(str))
      {
        paramString2 = new Intent();
        if ("interact".equals(paramString1))
        {
          paramString1 = new StringBuilder();
          paramString1.append("&tab=interactive&suin=");
          paramString1.append(paramQQAppInterface.getCurrentAccountUin());
          paramString2.putExtra("extra_key_url_append", paramString1.toString());
        }
        localIApolloUtil.openApolloStore(paramContext, paramString2, paramString3, str, null);
        return;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString2);
        paramQQAppInterface.putExtra("startOpenPageTime", System.currentTimeMillis());
        paramContext.startActivity(paramQQAppInterface);
        return;
      }
      QLog.w("[cmshow]CmShowLauncher", 1, "openStoreByTabScheme params is error");
      return;
    }
    QLog.e("[cmshow]CmShowLauncher", 1, "openStoreByTabScheme context is null");
  }
  
  private static boolean a()
  {
    if (ApolloConfigUtils.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]CmShowLauncher", 2, "queryApolloSwitchSet sSwitchSet = null");
      }
      return false;
    }
    if (ApolloConfigUtils.b.has("autoOpenBox"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]CmShowLauncher", 2, new Object[] { "openBoxByH5 autoOpenBox:", Integer.valueOf(ApolloConfigUtils.b.optInt("autoOpenBox")) });
      }
      if (ApolloConfigUtils.b.optInt("autoOpenBox") == 0) {
        return true;
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("[cmshow]CmShowLauncher", 2, "openBoxByH5 not autoOpenBox");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.CmShowLauncher
 * JD-Core Version:    0.7.0.1
 */