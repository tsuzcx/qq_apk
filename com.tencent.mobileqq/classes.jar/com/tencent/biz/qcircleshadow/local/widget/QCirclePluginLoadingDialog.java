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
  private static RFWMultiDownloadHelper jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWMultiDownloadHelper = new RFWMultiDownloadHelper();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final AnimationDrawableFactory.CreateResultListener jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateResultListener = new QCirclePluginLoadingDialog.1(this);
  private QQAnimationDrawable jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable;
  
  static
  {
    jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWMultiDownloadHelper.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip", QCircleDownloadConfig.a()));
    jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWMultiDownloadHelper.start();
  }
  
  public QCirclePluginLoadingDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755912);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560844, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374356));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844230);
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable);
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable.start();
  }
  
  private void c()
  {
    d();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable == null) {}
    while (!this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable.isRunning()) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable.stop();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableQQAnimationDrawable == null) {
      if (RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).isFileDownLoaded("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip"))
      {
        AnimationDrawableCreateOption.Builder localBuilder = new AnimationDrawableCreateOption.Builder("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip");
        localBuilder.a(67);
        localBuilder.a(2147483647L);
        localBuilder.a(true);
        localBuilder.b(true);
        AnimationDrawableFactory.a().a(hashCode(), localBuilder.a(), this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateResultListener);
      }
    }
    for (;;)
    {
      show();
      return;
      c();
      continue;
      b();
    }
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
    paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle.getDecorView().setSystemUiVisibility(1280);
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(0);
    }
    for (;;)
    {
      WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.gravity = 17;
      paramBundle.setAttributes(localLayoutParams);
      setCanceledOnTouchOutside(false);
      return;
      getWindow().addFlags(67108864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.widget.QCirclePluginLoadingDialog
 * JD-Core Version:    0.7.0.1
 */