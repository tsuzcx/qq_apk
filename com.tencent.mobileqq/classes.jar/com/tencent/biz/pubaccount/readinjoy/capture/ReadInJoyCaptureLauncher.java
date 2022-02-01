package com.tencent.biz.pubaccount.readinjoy.capture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.readinjoy.ReadInJoyHelper;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.QIMWebEffectCameraCaptureUnit;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import dov.com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppRuntime;

public class ReadInJoyCaptureLauncher
{
  private static Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10013);
    localBundle.putInt("entrance_type", 106);
    localBundle.putInt("extra.busi_type", 12);
    localBundle.putInt("edit_video_way", 10);
    localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
    localBundle.putInt("key_camera_photo_edit_type", 1);
    localBundle.putInt("key_camera_video_edit_type", 5);
    localBundle.putInt("ability_flag", 3);
    localBundle.putInt("key_max_duration", ReadInJoyHelper.f(BaseApplicationImpl.getApplication().getRuntime()));
    return localBundle;
  }
  
  private static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new AndroidRuntimeException("mobile qq main process only");
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, byte paramByte)
  {
    if (paramActivity == null) {
      return;
    }
    if (a().isVideoChatting())
    {
      QQToast.a(paramActivity, 0, 2131719379, 0).a();
      return;
    }
    boolean bool = ShortVideoGuideUtil.e(a());
    if (!CaptureUtil.a())
    {
      b(paramActivity);
      return;
    }
    if ((!bool) && (!NetworkUtil.g(paramActivity)))
    {
      QQToast.a(paramActivity, 2131718627, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramActivity, a(paramBundle), paramByte);
      return;
    }
    Intent localIntent = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
    localIntent.putExtras(a(paramBundle));
    localIntent.putExtra("pendingIntentClass", AEPituCameraUnit.class.getName());
    localIntent.putExtra("pendingIntentRequest", paramByte);
    localIntent.putExtra("pendingIntentAllWait", true);
    CaptureQmcfSoDownloadActivity.a(paramActivity, QIMWebEffectCameraCaptureUnit.class.getName(), localIntent.getExtras(), paramByte);
  }
  
  public static void a(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10017);
    localBundle.putInt("entrance_type", 106);
    localBundle.putInt("extra.busi_type", 8);
    localBundle.putInt("edit_video_way", 10);
    localBundle.putInt("ability_flag", 2);
    localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
    localBundle.putInt("key_camera_photo_edit_type", 1);
    localBundle.putInt("key_camera_video_edit_type", 5);
    localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    localBundle.putInt("capture_intent_mode", 0);
    if (a().isVideoChatting())
    {
      QQToast.a(paramContext, 0, 2131719379, 0).a();
      return;
    }
    boolean bool = ShortVideoGuideUtil.e(a());
    if (!CaptureUtil.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!NetworkUtil.g(paramContext)))
    {
      QQToast.a(paramContext, 2131718627, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramContext, localBundle);
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, AEPituCameraUnit.class.getName(), localBundle, true);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (a().isVideoChatting())
    {
      QQToast.a(paramContext, 0, 2131719379, 0).a();
      return;
    }
    boolean bool = ShortVideoGuideUtil.e(a());
    if (!CaptureUtil.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!NetworkUtil.g(paramContext)))
    {
      QQToast.a(paramContext, 2131718627, 0).a();
      return;
    }
    a();
    if (bool)
    {
      QIMCameraCaptureActivity.a(paramContext, a(paramBundle));
      return;
    }
    CaptureQmcfSoDownloadActivity.a(paramContext, AEPituCameraUnit.class.getName(), a(paramBundle), true);
  }
  
  public static void a(IPublicAccountH5AbilityPlugin paramIPublicAccountH5AbilityPlugin, Context paramContext, Bundle paramBundle, byte paramByte)
  {
    boolean bool = ShortVideoGuideUtil.e(paramIPublicAccountH5AbilityPlugin.getRuntime().a());
    if (!CaptureUtil.a())
    {
      b(paramContext);
      return;
    }
    if ((!bool) && (!NetworkUtil.g(paramContext)))
    {
      QQToast.a(paramContext, 2131718627, 0).a();
      return;
    }
    paramIPublicAccountH5AbilityPlugin.downloadShortVideoFilterSo();
    if (bool)
    {
      paramContext = QIMCameraCaptureActivity.a(paramContext, a(paramBundle));
      paramIPublicAccountH5AbilityPlugin.getWebViewPlugin().startActivityForResult(paramContext, paramByte);
      return;
    }
    paramContext = new Intent(paramContext, CaptureQmcfSoDownloadActivity.class);
    paramContext.putExtras(a(paramBundle));
    paramContext.putExtra("pendingIntentClass", AEPituCameraUnit.class.getName());
    paramContext.putExtra("pendingIntentRequest", paramByte);
    paramContext.putExtra("pendingIntentAllWait", true);
    paramIPublicAccountH5AbilityPlugin.getWebViewPlugin().startActivityForResult(paramContext, paramByte);
  }
  
  private static boolean a()
  {
    return PtvFilterSoLoad.a(a(), BaseApplicationImpl.getContext());
  }
  
  private static void b(Context paramContext)
  {
    DialogUtil.a(paramContext, 230).setMessage(HardCodeUtil.a(2131712723)).setPositiveButton(2131694615, new ReadInJoyCaptureLauncher.1()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCaptureLauncher
 * JD-Core Version:    0.7.0.1
 */