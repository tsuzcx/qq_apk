package com.tencent.biz.pubaccount.readinjoy.capture;

import android.content.Context;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.activity.CaptureSoDownloadActivity;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.readinjoy.ReadInJoyHelper;
import lko;
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
    localBundle.putInt("key_ability_flag", 3);
    localBundle.putInt("key_max_duration", ReadInJoyHelper.g(BaseApplicationImpl.getApplication().getRuntime()));
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
  
  private static void a(Context paramContext)
  {
    DialogUtil.a(paramContext, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131433030, new lko()).show();
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (!VideoEnvironment.b(a()))
    {
      a(paramContext);
      return;
    }
    boolean bool1 = VideoEnvironment.e(a());
    boolean bool2 = CaptureUtil.a();
    if ((!bool1) && (!NetworkUtil.g(paramContext)))
    {
      QQToast.a(paramContext, 2131432992, 0).a();
      return;
    }
    a();
    if (bool2)
    {
      if (bool1)
      {
        CameraCaptureActivity.a(paramContext, ReadInJoyEffectsCameraCaptureFragment.class.getName(), a(paramBundle));
        return;
      }
      CaptureSoDownloadActivity.a(paramContext, ReadInJoyEffectsCameraCaptureFragment.class.getName(), a(paramBundle));
      return;
    }
    a(paramContext);
  }
  
  public static void a(WebViewPlugin paramWebViewPlugin, Context paramContext, Bundle paramBundle, byte paramByte)
  {
    if (b())
    {
      a(paramContext);
      return;
    }
    paramWebViewPlugin.startActivityForResult(CameraCaptureActivity.a(paramContext, ReadInJoyEffectsCameraCaptureFragment.class.getName(), a(paramBundle)), paramByte);
  }
  
  private static boolean a()
  {
    return PtvFilterSoLoad.a(a(), BaseApplicationImpl.getContext());
  }
  
  private static boolean b()
  {
    return !CaptureUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCaptureLauncher
 * JD-Core Version:    0.7.0.1
 */