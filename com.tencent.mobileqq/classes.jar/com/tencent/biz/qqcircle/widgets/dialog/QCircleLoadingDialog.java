package com.tencent.biz.qqcircle.widgets.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption.Builder;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QCircleLoadingDialog
  extends ReportDialog
{
  private static RFWMultiDownloadHelper f = new RFWMultiDownloadHelper();
  private final LayoutInflater a;
  private View b;
  private ImageView c;
  private Drawable d;
  private QQAnimationDrawable e;
  private final AnimationDrawableFactory.CreateResultListener g = new QCircleLoadingDialog.1(this);
  
  static
  {
    f.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip", QCirclePluginConfig.e()));
    f.start();
  }
  
  public QCircleLoadingDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131953412);
    this.a = LayoutInflater.from(paramContext);
    this.b = this.a.inflate(2131626868, null);
    this.c = ((ImageView)this.b.findViewById(2131441729));
    this.d = paramContext.getResources().getDrawable(2130845174);
  }
  
  private void b()
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
  
  private void c()
  {
    d();
    ImageView localImageView = this.c;
    if (localImageView != null) {
      localImageView.setImageDrawable(this.d);
    }
  }
  
  private void d()
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
      if (RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).isFileDownLoaded("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip"))
      {
        AnimationDrawableCreateOption.Builder localBuilder = new AnimationDrawableCreateOption.Builder("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip");
        localBuilder.b(67);
        localBuilder.a(2147483647L);
        localBuilder.a(true);
        localBuilder.b(true);
        AnimationDrawableFactory.a().a(hashCode(), localBuilder.a(), this.g);
      }
      else
      {
        c();
      }
    }
    else {
      b();
    }
    show();
  }
  
  public void dismiss()
  {
    super.dismiss();
    d();
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
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog
 * JD-Core Version:    0.7.0.1
 */