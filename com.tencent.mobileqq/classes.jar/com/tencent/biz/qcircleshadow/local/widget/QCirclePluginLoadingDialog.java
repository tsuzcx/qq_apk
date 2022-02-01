package com.tencent.biz.qcircleshadow.local.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QCirclePluginLoadingDialog
  extends ReportDialog
{
  private static RFWMultiDownloadHelper g = new RFWMultiDownloadHelper();
  private final LayoutInflater a;
  private View b;
  private ImageView c;
  private Drawable d;
  private QQAnimationDrawable e;
  private Handler f;
  private final AnimationDrawableFactory.CreateResultListener h = new QCirclePluginLoadingDialog.1(this);
  
  static
  {
    g.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip", QCircleDownloadConfig.a()));
    g.start();
  }
  
  public QCirclePluginLoadingDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131953412);
    this.a = LayoutInflater.from(paramContext);
    this.b = this.a.inflate(2131626904, null);
    this.c = ((ImageView)this.b.findViewById(2131441729));
    this.d = paramContext.getResources().getDrawable(2130845242);
  }
  
  private Handler b()
  {
    if (this.f == null) {
      this.f = new Handler(Looper.getMainLooper());
    }
    return this.f;
  }
  
  private void c()
  {
    QQAnimationDrawable localQQAnimationDrawable = this.e;
    if (localQQAnimationDrawable != null)
    {
      ImageView localImageView = this.c;
      if (localImageView == null) {
        return;
      }
      localImageView.setImageDrawable(localQQAnimationDrawable);
      this.e.start();
    }
  }
  
  private void d()
  {
    e();
    ImageView localImageView = this.c;
    if (localImageView != null) {
      localImageView.setImageDrawable(this.d);
    }
  }
  
  private void e()
  {
    QQAnimationDrawable localQQAnimationDrawable = this.e;
    if (localQQAnimationDrawable == null) {
      return;
    }
    if (localQQAnimationDrawable.isRunning()) {
      this.e.stop();
    }
  }
  
  public void a()
  {
    if (this.e == null)
    {
      if (RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).isFileDownLoaded("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip"))
      {
        AnimationDrawableCreateOption.Builder localBuilder = new AnimationDrawableCreateOption.Builder("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip");
        localBuilder.b(67);
        localBuilder.a(2147483647L);
        localBuilder.a(true);
        localBuilder.b(true);
        AnimationDrawableFactory.a().a(hashCode(), localBuilder.a(), this.h);
      }
      else
      {
        d();
      }
    }
    else {
      c();
    }
    show();
  }
  
  public void dismiss()
  {
    super.dismiss();
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.b);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle.getDecorView().setSystemUiVisibility(1280);
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(0);
    }
    else
    {
      getWindow().addFlags(67108864);
    }
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.gravity = 17;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.widget.QCirclePluginLoadingDialog
 * JD-Core Version:    0.7.0.1
 */