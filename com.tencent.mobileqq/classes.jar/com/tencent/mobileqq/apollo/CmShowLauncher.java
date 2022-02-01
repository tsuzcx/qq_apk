package com.tencent.mobileqq.apollo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.makeup.CmShowMakeupHybirdFragment;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.cmshow.AECMShowGuideFragment;
import dov.com.qq.im.ae.cmshow.AECMShowUtil;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import mqq.app.AppRuntime;

public class CmShowLauncher
{
  public static void a(Activity paramActivity)
  {
    if (!AECMShowUtil.b())
    {
      paramActivity.runOnUiThread(new CmShowLauncher.1(paramActivity));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10027);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("PeakConstants.ARG_FORCE_CAMERA", 1);
    boolean bool = AECameraPrefsUtil.a().a("sp_key_cmshow_first_guide_has_shown_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), false, 4);
    QLog.i("CmShowLauncher", 1, "launchCMCustomFaceCamera---hasShownGuide=" + bool);
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramActivity, localBundle, 100);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    AECMShowGuideFragment.a(paramActivity, localIntent, 100);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = QzoneConfig.getInstance().getConfig("CMShow", "CMShowMakeupPanelUrl", "https://open.cmshow.qq.com/ac/cmshow_h5/html/pages/dress_up.html");
    }
    StringBuilder localStringBuilder = new StringBuilder(str);
    long l1 = DeviceInfoUtil.j();
    long l2 = DeviceInfoUtil.i();
    float f2 = FontSettingManager.getFontLevel() / 16.0F;
    float f1 = 2.0F;
    if (f2 != 0.0F) {
      f1 = DeviceInfoUtil.a() / f2;
    }
    f2 = f1;
    if (f1 == 0.0F) {
      f2 = DeviceInfoUtil.a();
    }
    int i = (int)(ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) / f2);
    if (str.indexOf("?") == -1) {
      localStringBuilder.append("?");
    }
    for (;;)
    {
      localStringBuilder.append("screenWidth=").append((int)((float)l2 / f2)).append("&screenHeight=").append((int)((float)l1 / f2)).append("&statusBarHeight=").append(i).append("&screenDensity=").append(f2);
      if (str.indexOf("&_wv") < 0) {
        localStringBuilder.append("&_wv=").append(16777223L);
      }
      if (str.indexOf("&_wwv") < 0) {
        localStringBuilder.append("&_wwv=").append(8704L);
      }
      localStringBuilder.append("&webviewOpenType=1");
      paramString = paramIntent;
      if (paramIntent == null) {
        paramString = new Intent();
      }
      paramString.putExtra("url", localStringBuilder.toString());
      paramString.putExtra("hide_left_button", true);
      paramString.setClass(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      paramString.putExtra("fragment_class", CmShowMakeupHybirdFragment.class.getCanonicalName());
      if (!(paramContext instanceof Activity)) {
        break;
      }
      paramContext.startActivity(paramString);
      return;
      localStringBuilder.append("&");
    }
    paramString.addFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.CmShowLauncher
 * JD-Core Version:    0.7.0.1
 */