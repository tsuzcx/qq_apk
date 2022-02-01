package com.tencent.gamecenter.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;

public class ScreenshotManager
{
  public static final String a;
  public static final String b;
  private ImageView c;
  private Bitmap d;
  private boolean e = GameCenterSpUtils.b("gamecenter_shot_switch");
  private boolean f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tencent/MobileQQ/gamecenter");
    localStringBuilder.append(File.separator);
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("gamecenter_screenshot");
    b = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static Bitmap a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_4444);
    paramView.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  public static ScreenshotManager a()
  {
    return ScreenshotManager.ScreenshotInstance.a();
  }
  
  private void a(Context paramContext, String paramString, ScreenshotManager.ShotCallback paramShotCallback)
  {
    paramContext = new StringBuilder();
    paramContext.append(b);
    paramContext.append(paramString);
    if (FileUtil.d(paramContext.toString())) {
      ThreadManagerV2.executeOnFileThread(new ScreenshotManager.1(this, paramString, paramShotCallback));
    }
  }
  
  public void a(WebView paramWebView)
  {
    if (!a(null)) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ScreenshotManager.3(this, paramWebView));
  }
  
  public void a(WebView paramWebView, ScreenshotManager.ShotCallback paramShotCallback)
  {
    if (!a(paramShotCallback)) {
      return;
    }
    this.f = true;
    ImageView localImageView = this.c;
    if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenshotManager", 2, "removeShotMask call");
      }
    }
    try
    {
      ((ViewGroup)paramWebView.getParent()).removeView(this.c);
      this.c.setVisibility(4);
      paramShotCallback.a(0, "removeShotMask succ");
      return;
    }
    catch (Throwable paramWebView)
    {
      label79:
      break label79;
    }
    paramShotCallback.a(-400, "removeShotMask fail");
    return;
    paramShotCallback.a(0, "removeShotMask no visible");
  }
  
  public void a(WebView paramWebView, String paramString, ScreenshotManager.ShotCallback paramShotCallback)
  {
    if (!a(paramShotCallback)) {
      return;
    }
    this.d = a(paramWebView);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("screenShot view.w =");
    localStringBuilder.append(paramWebView.getWidth());
    localStringBuilder.append(" view.h=");
    localStringBuilder.append(paramWebView.getHeight());
    localStringBuilder.append(" mask.w = ");
    localStringBuilder.append(this.d.getWidth());
    localStringBuilder.append(" mask.h=");
    localStringBuilder.append(this.d.getHeight());
    QLog.i("ScreenshotManager", 1, localStringBuilder.toString());
    if (this.c == null)
    {
      this.c = new ImageView(paramWebView.getContext());
      this.c.setScaleType(ImageView.ScaleType.FIT_XY);
    }
    this.c.setImageBitmap(this.d);
    ThreadManagerV2.executeOnSubThread(new ScreenshotManager.2(this, paramString, paramShotCallback));
  }
  
  public void a(String paramString, ScreenshotManager.ShotCallback paramShotCallback)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("switch", GameCenterSpUtils.b("gamecenter_shot_switch"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramString);
      localJSONObject.put("fileExist", FileUtil.d(localStringBuilder.toString()));
      paramShotCallback.a(0, localJSONObject.toString());
      return;
    }
    catch (Exception paramString)
    {
      label72:
      break label72;
    }
    paramShotCallback.a(-700, "queryShotInfo error");
  }
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap != null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(b);
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        FileUtils.b(a);
        paramString = new FileOutputStream(new File(paramString));
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
        paramString.flush();
        paramString.close();
        return true;
      }
      catch (Exception paramBitmap)
      {
        paramString = new StringBuilder();
        paramString.append("screenShot saveBitmap error=");
        paramString.append(paramBitmap.toString());
        QLog.e("ScreenshotManager", 1, paramString.toString());
      }
    }
    return false;
  }
  
  public boolean a(ScreenshotManager.ShotCallback paramShotCallback)
  {
    if (!GameCenterSpUtils.b("gamecenter_shot_switch"))
    {
      if (paramShotCallback != null) {
        paramShotCallback.a(-1, "shot switch is false");
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    try
    {
      if (this.c.getParent() != null)
      {
        ((ViewGroup)this.c.getParent()).removeView(this.c);
        this.c.setVisibility(4);
        QLog.i("ScreenshotManager", 1, "forceRemoveMask call");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("forceRemoveMask e=");
      localStringBuilder.append(localThrowable.toString());
      QLog.e("ScreenshotManager", 1, localStringBuilder.toString());
    }
  }
  
  public void b(ScreenshotManager.ShotCallback paramShotCallback)
  {
    if (FileUtil.e(a))
    {
      paramShotCallback.a(0, "delShotFile succ");
      return;
    }
    paramShotCallback.a(-500, "delShotFile fail");
  }
  
  public void b(WebView paramWebView, String paramString, ScreenshotManager.ShotCallback paramShotCallback)
  {
    if (!a(paramShotCallback)) {
      return;
    }
    if (this.d == null)
    {
      paramShotCallback.a(-300, "preloadMask not init");
      a(paramWebView.getContext(), paramString, paramShotCallback);
      QLog.e("ScreenshotManager", 1, "preloadMask not init");
      return;
    }
    this.c = new ImageView(paramWebView.getContext());
    this.c.setScaleType(ImageView.ScaleType.FIT_XY);
    this.c.setImageBitmap(this.d);
    this.f = false;
    try
    {
      b();
      paramString = new FrameLayout.LayoutParams(this.d.getWidth(), this.d.getHeight());
      ((ViewGroup)paramWebView.getParent()).addView(this.c, paramString);
      this.c.setVisibility(0);
      paramShotCallback.a(0, "succ");
      return;
    }
    catch (Throwable paramWebView)
    {
      paramString = new StringBuilder();
      paramString.append("addShot error =");
      paramString.append(paramWebView.toString());
      QLog.e("ScreenshotManager", 1, paramString.toString());
      paramShotCallback.a(-301, "add view error");
    }
  }
  
  public void c()
  {
    this.c = null;
  }
  
  public void c(ScreenshotManager.ShotCallback paramShotCallback)
  {
    QLog.i("ScreenshotManager", 1, "closeShot");
    if (GameCenterSpUtils.a("gamecenter_shot_switch", false))
    {
      this.e = false;
      paramShotCallback.a(0, "closeShot succ");
      return;
    }
    paramShotCallback.a(-600, "closeShot fail");
  }
  
  public void d(ScreenshotManager.ShotCallback paramShotCallback)
  {
    QLog.i("ScreenshotManager", 1, "open");
    if (GameCenterSpUtils.a("gamecenter_shot_switch", true))
    {
      this.e = true;
      paramShotCallback.a(0, "openShot succ");
      return;
    }
    paramShotCallback.a(-600, "openShot fail");
  }
  
  public boolean d()
  {
    ImageView localImageView = this.c;
    return (localImageView != null) && (localImageView.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager
 * JD-Core Version:    0.7.0.1
 */