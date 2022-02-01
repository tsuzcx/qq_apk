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
import com.tencent.mobileqq.apollo.drawer.PushDrawerStatus;
import com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
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
import common.config.service.QzoneConfig;
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
      VasWebviewUtil.a(paramContext, ApolloConstant.m, -1L, paramIntent, false, -1);
      QLog.d("[cmshow]CmShowLauncher", 1, "openApolloStore !isHardwareSupport, return");
      return;
    }
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (1 == localApolloManagerServiceImpl.getWhiteListStatus())
    {
      boolean bool = paramAppInterface instanceof QQAppInterface;
      if ((!bool) || (ApolloUtilImpl.isApolloUser((QQAppInterface)paramAppInterface)))
      {
        if (paramIntent == null) {
          localObject = new Intent();
        } else {
          localObject = paramIntent;
        }
        int i;
        if ((bool) && (localApolloManagerServiceImpl.is3dAvailable())) {
          i = 1;
        } else {
          i = 0;
        }
        if ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains("tab=3d")) && (i == 0)) {
          paramIntent = ApolloConstant.A;
        } else {
          paramIntent = paramString2;
        }
        paramString2 = paramIntent;
        if (!TextUtils.isEmpty(ApolloConstant.A))
        {
          paramString2 = paramIntent;
          if (ApolloConstant.A.equals(paramIntent))
          {
            paramString2 = paramIntent;
            if (i != 0) {
              paramString2 = ApolloConstant.I;
            }
          }
        }
        if (((Intent)localObject).getIntExtra("key_box_type", 0) == 3)
        {
          paramIntent = ApolloConstant.v;
          paramString1 = new Intent(paramContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.a(paramContext, paramIntent, -1L, paramString1, false, -1);
          QLog.d("[cmshow]CmShowLauncher", 1, "openApolloStore boxType == ApolloPandora.BOX_TYPE_BEAN, return");
          return;
        }
        if (paramAppInterface != null) {
          paramIntent = paramAppInterface.getCurrentNickname();
        } else {
          paramIntent = "";
        }
        ((Intent)localObject).putExtra("extra_key_nickname", paramIntent);
        if (!TextUtils.isEmpty(paramString1)) {
          ((Intent)localObject).putExtra("extra_key_adtag", paramString1);
        }
        ((Intent)localObject).putExtra("extra_key_click_time", System.currentTimeMillis());
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("apollo_client, clickTime:");
          paramIntent.append(TimeFormatterUtils.a(System.currentTimeMillis(), "dd-MMM-yyyy HH:mm:ss:SSS"));
          paramIntent.append(",url:");
          paramIntent.append(paramString2);
          QLog.d("[cmshow]CmShowLauncher", 2, paramIntent.toString());
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = paramString2.replace("_bid=2423&", "");
          paramIntent = paramString1;
          if (PushDrawerStatus.jdField_d_of_type_Boolean)
          {
            if (!TextUtils.isEmpty(PushDrawerStatus.c))
            {
              paramIntent = URLUtil.a(paramString1, "wording", PushDrawerStatus.c);
            }
            else
            {
              paramIntent = paramString1;
              if (!TextUtils.isEmpty(PushDrawerStatus.a)) {
                paramIntent = URLUtil.a(paramString1, "wording", PushDrawerStatus.a);
              }
            }
            paramString1 = paramIntent;
            if (!TextUtils.isEmpty(PushDrawerStatus.jdField_d_of_type_JavaLangString)) {
              paramString1 = URLUtil.a(paramIntent, "bubble_id", PushDrawerStatus.jdField_d_of_type_JavaLangString);
            }
            paramIntent = paramString1;
            if (!TextUtils.isEmpty(PushDrawerStatus.b)) {
              paramIntent = URLUtil.a(paramString1, "tip_url", PushDrawerStatus.b);
            }
          }
          paramString1 = paramIntent;
          if (localApolloManagerServiceImpl != null)
          {
            if (localApolloManagerServiceImpl.mIsNewStoreUser) {
              paramString1 = "1";
            } else {
              paramString1 = "0";
            }
            paramString1 = URLUtil.a(paramIntent, "is_new_store_user", paramString1);
            if (i != 0) {
              paramIntent = "1";
            } else {
              paramIntent = "0";
            }
            paramString1 = URLUtil.a(paramString1, "is_3d_available", paramIntent);
          }
          if (((Intent)localObject).getBooleanExtra("extra_key_open_box", false))
          {
            if (a()) {
              ((Intent)localObject).putExtra("extra_key_open_box", false);
            }
            paramIntent = URLUtil.a(paramString1, "boxReady", "1");
          }
          else
          {
            paramIntent = URLUtil.a(paramString1, "boxReady", "0");
          }
          ((Intent)localObject).putExtra("url", paramIntent);
          ((Intent)localObject).putExtra("url", paramIntent);
        }
        else
        {
          if (!TextUtils.isEmpty(ApolloConstant.z)) {
            paramIntent = ApolloConstant.z;
          } else {
            paramIntent = ApolloConstant.o;
          }
          paramString1 = paramIntent.replace("_bid=2423&", "");
          paramIntent = paramString1;
          if (localApolloManagerServiceImpl != null)
          {
            if (localApolloManagerServiceImpl.mIsNewStoreUser) {
              paramIntent = "1";
            } else {
              paramIntent = "0";
            }
            paramString1 = URLUtil.a(paramString1, "is_new_store_user", paramIntent);
            if (i != 0) {
              paramIntent = "1";
            } else {
              paramIntent = "0";
            }
            paramIntent = URLUtil.a(paramString1, "is_3d_available", paramIntent);
          }
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
        if ((!paramIntent.contains("webviewCheckType=1")) && (!paramIntent.contains("webviewCheckType=2")))
        {
          ((Intent)localObject).setClass(paramContext, ApolloStoreActivity.class);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]CmShowLauncher", 2, "apollo_client, ApolloStoreActivity");
          }
        }
        else
        {
          ((Intent)localObject).setClass(paramContext, ApolloStoreActivity.class);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]CmShowLauncher", 2, "apollo_client, ApolloStoreActivity");
          }
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
        if ((bool) && (paramInt > 0))
        {
          ((Activity)paramContext).startActivityForResult((Intent)localObject, paramInt);
          return;
        }
        paramContext.startActivity((Intent)localObject);
        return;
      }
    }
    paramIntent = new Intent(paramContext, QQBrowserActivity.class);
    paramIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    paramString1 = new StringBuilder();
    paramString1.append(ApolloConstant.n);
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
      str = QzoneConfig.getInstance().getConfig("CMShow", "CMShowMakeupPanelUrl", "https://open.cmshow.qq.com/ac/cmshow_h5/html/pages/dress_up.html");
    }
    StringBuilder localStringBuilder = new StringBuilder(str);
    float f2 = FontSettingManager.getFontLevel() / 16.0F;
    float f1 = 2.0F;
    if (f2 != 0.0F) {
      f1 = DeviceInfoUtil.a() / f2;
    }
    f2 = f1;
    if (f1 == 0.0F) {
      f2 = DeviceInfoUtil.a();
    }
    int i = (int)(ImmersiveUtils.getStatusBarHeight(paramContext) / f2);
    if (str.indexOf("?") == -1) {
      localStringBuilder.append("?");
    } else {
      localStringBuilder.append("&");
    }
    l1 = DeviceInfoUtil.j();
    long l2 = DeviceInfoUtil.i();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.CmShowLauncher
 * JD-Core Version:    0.7.0.1
 */