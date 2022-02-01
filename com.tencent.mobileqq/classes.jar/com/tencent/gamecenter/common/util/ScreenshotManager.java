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
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean = GameCenterSpUtils.a("gamecenter_shot_switch");
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath("Tencent/MobileQQ/gamecenter" + File.separator);
    jdField_b_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(jdField_a_of_type_JavaLangString + "gamecenter_screenshot");
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
    if (FileUtil.a(jdField_b_of_type_JavaLangString + paramString)) {
      ThreadManagerV2.executeOnFileThread(new ScreenshotManager.1(this, paramString, paramShotCallback));
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null)
      {
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        QLog.i("ScreenshotManager", 1, "forceRemoveMask call");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ScreenshotManager", 1, "forceRemoveMask e=" + localThrowable.toString());
    }
  }
  
  public void a(ScreenshotManager.ShotCallback paramShotCallback)
  {
    if (FileUtil.c(jdField_a_of_type_JavaLangString))
    {
      paramShotCallback.a(0, "delShotFile succ");
      return;
    }
    paramShotCallback.a(-500, "delShotFile fail");
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
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0))
    {
      paramShotCallback.a(0, "removeShotMask no visible");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScreenshotManager", 2, "removeShotMask call");
    }
    try
    {
      ((ViewGroup)paramWebView.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramShotCallback.a(0, "removeShotMask succ");
      return;
    }
    catch (Throwable paramWebView)
    {
      paramShotCallback.a(-400, "removeShotMask fail");
    }
  }
  
  public void a(WebView paramWebView, String paramString, ScreenshotManager.ShotCallback paramShotCallback)
  {
    if (!a(paramShotCallback)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramWebView);
    QLog.i("ScreenshotManager", 1, "screenShot view.w =" + paramWebView.getWidth() + " view.h=" + paramWebView.getHeight() + " mask.w = " + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + " mask.h=" + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramWebView.getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    ThreadManagerV2.executeOnSubThread(new ScreenshotManager.2(this, paramString, paramShotCallback));
  }
  
  public void a(String paramString, ScreenshotManager.ShotCallback paramShotCallback)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("switch", GameCenterSpUtils.a("gamecenter_shot_switch"));
      localJSONObject.put("fileExist", FileUtil.a(jdField_a_of_type_JavaLangString + paramString));
      paramShotCallback.a(0, localJSONObject.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramShotCallback.a(-700, "queryShotInfo error");
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0);
  }
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap != null) {
      try
      {
        paramString = jdField_b_of_type_JavaLangString + paramString;
        FileUtils.a(jdField_a_of_type_JavaLangString);
        paramString = new FileOutputStream(new File(paramString));
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
        paramString.flush();
        paramString.close();
        return true;
      }
      catch (Exception paramBitmap)
      {
        QLog.e("ScreenshotManager", 1, "screenShot saveBitmap error=" + paramBitmap.toString());
        return false;
      }
    }
    return false;
  }
  
  public boolean a(ScreenshotManager.ShotCallback paramShotCallback)
  {
    if (!GameCenterSpUtils.a("gamecenter_shot_switch"))
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
    this.jdField_a_of_type_AndroidWidgetImageView = null;
  }
  
  public void b(ScreenshotManager.ShotCallback paramShotCallback)
  {
    QLog.i("ScreenshotManager", 1, "closeShot");
    if (GameCenterSpUtils.a("gamecenter_shot_switch", false))
    {
      this.jdField_a_of_type_Boolean = false;
      paramShotCallback.a(0, "closeShot succ");
      return;
    }
    paramShotCallback.a(-600, "closeShot fail");
  }
  
  public void b(WebView paramWebView, String paramString, ScreenshotManager.ShotCallback paramShotCallback)
  {
    if (!a(paramShotCallback)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      paramShotCallback.a(-300, "preloadMask not init");
      a(paramWebView.getContext(), paramString, paramShotCallback);
      QLog.e("ScreenshotManager", 1, "preloadMask not init");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramWebView.getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_b_of_type_Boolean = false;
    try
    {
      a();
      paramString = new FrameLayout.LayoutParams(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      ((ViewGroup)paramWebView.getParent()).addView(this.jdField_a_of_type_AndroidWidgetImageView, paramString);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramShotCallback.a(0, "succ");
      return;
    }
    catch (Throwable paramWebView)
    {
      QLog.e("ScreenshotManager", 1, "addShot error =" + paramWebView.toString());
      paramShotCallback.a(-301, "add view error");
    }
  }
  
  public void c(ScreenshotManager.ShotCallback paramShotCallback)
  {
    QLog.i("ScreenshotManager", 1, "open");
    if (GameCenterSpUtils.a("gamecenter_shot_switch", true))
    {
      this.jdField_a_of_type_Boolean = true;
      paramShotCallback.a(0, "openShot succ");
      return;
    }
    paramShotCallback.a(-600, "openShot fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager
 * JD-Core Version:    0.7.0.1
 */