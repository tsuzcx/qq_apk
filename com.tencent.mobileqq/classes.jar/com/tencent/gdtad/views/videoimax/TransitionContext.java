package com.tencent.gdtad.views.videoimax;

import acqy;
import acuk;
import acul;
import acum;
import aevv;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import anhk;
import bgey;
import bhgg;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;

public class TransitionContext
{
  private static boolean c;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private final AdVideoSpliceAdapter.Params jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params;
  private GdtVideoImaxEnterImageView jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public TransitionContext(AdVideoSpliceAdapter.Params paramParams)
  {
    this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params = paramParams;
    try
    {
      a(((Activity)paramParams.activity.get()).getApplication());
      return;
    }
    catch (Throwable paramParams)
    {
      QLog.e("TransitionContext", 1, "", paramParams);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    acqy.a("TransitionContext", "enterAnimation() called with: l = [" + paramInt1 + "], t = [" + paramInt2 + "], width = [" + paramInt3 + "], height = [" + paramInt4 + "]");
    Object localObject1 = (Activity)this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.activity.get();
    Object localObject2 = ((Activity)localObject1).getWindow();
    a((Window)localObject2);
    localObject2 = (FrameLayout)((Window)localObject2).getDecorView();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView = new GdtVideoImaxEnterImageView((Context)localObject1);
    Object localObject3 = new ViewGroup.MarginLayoutParams(-1, -1);
    Rect localRect = new Rect();
    paramInt3 = paramInt1 + paramInt3;
    paramInt4 = paramInt2 + paramInt4;
    int i = ((FrameLayout)localObject2).getWidth();
    int j = ((FrameLayout)localObject2).getHeight();
    acqy.a("TransitionContext", "enterAnimation() destinationClipBottom = [" + j + "]");
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView.setClipBoundsCompact(localRect);
    localObject3 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Activity)localObject1).getResources().getDrawable(2130850664);
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Activity)localObject1).getResources().getDrawable(2130850664);
    localObject1 = URLDrawable.getDrawable(((GdtAd)GdtAd.class.cast(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.ad)).info.display_info.basic_info.img.get(), (URLDrawable.URLDrawableOptions)localObject3);
    ((URLDrawable)localObject1).setDecodeHandler(bgey.n);
    ((URLDrawable)localObject1).setTag(new int[] { 50 });
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView.setImageDrawable((Drawable)localObject1);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ((FrameLayout)localObject2).addView(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxEnterImageView);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new acuk(this, paramInt1, paramInt2, paramInt3, i, j, paramInt4, localRect));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new acul(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private static void a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (c) {
          return;
        }
        if (paramContext == null) {
          break;
        }
        URLDrawable.DEBUG = false;
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          localFile = new File(bhgg.a(anhk.ba));
          URLDrawable.init(paramContext, new acum(paramContext, new File(localFile, "diskcache")));
          c = true;
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        QZLog.e("TransitionContext", "UrlDrawable init exception.", paramContext);
        return;
      }
      File localFile = paramContext.getCacheDir();
    }
  }
  
  private void a(Window paramWindow)
  {
    paramWindow.setFlags(1024, 1024);
    paramWindow = (ViewGroup)paramWindow.getDecorView();
    this.jdField_a_of_type_Int = paramWindow.getSystemUiVisibility();
    paramWindow.setSystemUiVisibility(7942);
  }
  
  private void a(ImageView paramImageView)
  {
    acqy.a("TransitionContext", "finishEnterAnimator() called with: maskView = [" + paramImageView + "]");
    ViewGroup localViewGroup = (ViewGroup)paramImageView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramImageView);
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    b(((Activity)this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.activity.get()).getWindow());
  }
  
  private void b(Window paramWindow)
  {
    paramWindow.clearFlags(1024);
    ((ViewGroup)paramWindow.getDecorView()).setSystemUiVisibility(this.jdField_a_of_type_Int);
  }
  
  private void c()
  {
    acqy.a("TransitionContext", "sendAnimationEnd() called");
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null) {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(1, null);
    }
  }
  
  private void d()
  {
    acqy.a("TransitionContext", "startImaxActivity() called");
    Intent localIntent = new Intent();
    GdtImaxData localGdtImaxData = new GdtImaxData();
    GdtAd localGdtAd = (GdtAd)GdtAd.class.cast(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.ad);
    localGdtImaxData.setAd(localGdtAd);
    localGdtImaxData.setVideoSplicePageStyle(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.videoSplicePageStyle);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    String str2 = this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.videoUrl2;
    String str1 = str2;
    if (localGdtAd != null)
    {
      str1 = str2;
      if (localGdtAd.getCreativeSize() == 585) {
        str1 = localGdtAd.getVideoUrl();
      }
    }
    localGdtVideoData.setUrl(str1);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setDirectPlay(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setVideoDefaultBackgroundColor(0);
    localGdtVideoData.setForceNotShowControllerView(true);
    localGdtVideoData.setCoverUrl(localGdtAd.info.display_info.basic_info.img.get());
    localGdtVideoData.setNeedReport(false);
    localGdtVideoData.setPlayScene(8);
    localGdtImaxData.setVideoData(localGdtVideoData);
    localGdtImaxData.setWebUrl(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.webUrl);
    localIntent.putExtra("data", localGdtImaxData);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("callback", new TransitionContext.MyResultReceiver(new Handler(Looper.getMainLooper()), this));
    aevv.a((Activity)this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.activity.get(), localIntent, PublicTransFragmentActivityForTool.class, GdtVideoImaxFragment.class, 1);
  }
  
  public void a()
  {
    acqy.a("TransitionContext", "onAnimationEnd() called");
    this.b = true;
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
  }
  
  public void b()
  {
    acqy.a("TransitionContext", "start() called");
    a(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.mediaViewLocationRect.left, this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.mediaViewLocationRect.top, this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.mediaViewLocationRect.width(), this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter$Params.mediaViewLocationRect.height());
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.TransitionContext
 * JD-Core Version:    0.7.0.1
 */