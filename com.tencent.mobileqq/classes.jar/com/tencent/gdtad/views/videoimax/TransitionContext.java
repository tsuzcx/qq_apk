package com.tencent.gdtad.views.videoimax;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pic.URLDrawableDepWrapInit;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;

public class TransitionContext
{
  private static boolean h = false;
  private final AdVideoSpliceAdapter.Params a;
  private ValueAnimator b;
  private int c;
  private GdtVideoImaxEnterImageView d;
  private boolean e;
  private boolean f;
  private ResultReceiver g;
  
  public TransitionContext(AdVideoSpliceAdapter.Params paramParams)
  {
    this.a = paramParams;
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("enterAnimation() called with: l = [");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("], t = [");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append("], width = [");
    ((StringBuilder)localObject1).append(paramInt3);
    ((StringBuilder)localObject1).append("], height = [");
    ((StringBuilder)localObject1).append(paramInt4);
    ((StringBuilder)localObject1).append("]");
    GdtLog.a("TransitionContext", ((StringBuilder)localObject1).toString());
    localObject1 = (Activity)this.a.activity.get();
    Object localObject2 = ((Activity)localObject1).getWindow();
    a((Window)localObject2);
    localObject2 = (FrameLayout)((Window)localObject2).getDecorView();
    this.d = new GdtVideoImaxEnterImageView((Context)localObject1);
    Object localObject3 = new ViewGroup.MarginLayoutParams(-1, -1);
    Rect localRect = new Rect();
    paramInt3 = paramInt1 + paramInt3;
    paramInt4 = paramInt2 + paramInt4;
    int i = ((FrameLayout)localObject2).getWidth();
    int j = ((FrameLayout)localObject2).getHeight();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterAnimation() destinationClipBottom = [");
    localStringBuilder.append(j);
    localStringBuilder.append("]");
    GdtLog.a("TransitionContext", localStringBuilder.toString());
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d.setClipBoundsCompact(localRect);
    localObject3 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Activity)localObject1).getResources().getDrawable(2130853309);
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Activity)localObject1).getResources().getDrawable(2130853309);
    localObject1 = URLDrawable.getDrawable(((GdtAd)GdtAd.class.cast(this.a.ad)).info.display_info.basic_info.img.get(), (URLDrawable.URLDrawableOptions)localObject3);
    ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.n);
    ((URLDrawable)localObject1).setTag(new int[] { 50 });
    this.d.setImageDrawable((Drawable)localObject1);
    this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ((FrameLayout)localObject2).addView(this.d);
    this.b = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.b.setDuration(500L);
    this.b.setInterpolator(new AccelerateInterpolator());
    this.b.addUpdateListener(new TransitionContext.1(this, paramInt1, paramInt2, paramInt3, i, j, paramInt4, localRect));
    this.b.addListener(new TransitionContext.2(this));
    this.b.start();
  }
  
  private static void a(Context paramContext)
  {
    do
    {
      try
      {
        if (!h) {
          continue;
        }
        return;
      }
      catch (Throwable paramContext)
      {
        File localFile;
        paramContext.printStackTrace();
        QZLog.e("TransitionContext", "UrlDrawable init exception.", paramContext);
        return;
      }
      URLDrawable.DEBUG = false;
      if ("mounted".equals(Environment.getExternalStorageState())) {
        localFile = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
      } else {
        localFile = paramContext.getCacheDir();
      }
      localFile = new File(localFile, "diskcache");
      URLDrawable.init(URLDrawableDepWrapInit.a(), new TransitionContext.URLDrawableFactory(paramContext, localFile));
      h = true;
      return;
    } while (paramContext != null);
  }
  
  private void a(Window paramWindow)
  {
    paramWindow.setFlags(1024, 1024);
    paramWindow = (ViewGroup)paramWindow.getDecorView();
    this.c = paramWindow.getSystemUiVisibility();
    paramWindow.setSystemUiVisibility(7942);
  }
  
  private void a(ImageView paramImageView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("finishEnterAnimator() called with: maskView = [");
    ((StringBuilder)localObject).append(paramImageView);
    ((StringBuilder)localObject).append("]");
    GdtLog.a("TransitionContext", ((StringBuilder)localObject).toString());
    localObject = (ViewGroup)paramImageView.getParent();
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(paramImageView);
    }
    paramImageView = this.b;
    if ((paramImageView != null) && (paramImageView.isRunning()))
    {
      this.b.cancel();
      this.b = null;
    }
    b(((Activity)this.a.activity.get()).getWindow());
  }
  
  private void b(Window paramWindow)
  {
    paramWindow.clearFlags(1024);
    ((ViewGroup)paramWindow.getDecorView()).setSystemUiVisibility(this.c);
  }
  
  private void c()
  {
    GdtLog.a("TransitionContext", "sendAnimationEnd() called");
    ResultReceiver localResultReceiver = this.g;
    if (localResultReceiver != null) {
      localResultReceiver.send(1, new Bundle());
    }
  }
  
  private void d()
  {
    GdtLog.a("TransitionContext", "startImaxActivity() called");
    Intent localIntent = new Intent();
    GdtImaxData localGdtImaxData = new GdtImaxData();
    GdtAd localGdtAd = (GdtAd)GdtAd.class.cast(this.a.ad);
    localGdtImaxData.setAd(localGdtAd);
    localGdtImaxData.setVideoSplicePageStyle(this.a.videoSplicePageStyle);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    String str2 = this.a.videoUrl2;
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
    if (localGdtAd != null) {
      localGdtVideoData.setCoverUrl(localGdtAd.info.display_info.basic_info.img.get());
    }
    localGdtVideoData.setNeedReport(false);
    localGdtVideoData.setPlayScene(8);
    localGdtImaxData.setVideoData(localGdtVideoData);
    localGdtImaxData.setWebUrl(this.a.webUrl);
    localIntent.putExtra("data", localGdtImaxData);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("callback", new TransitionContext.MyResultReceiver(new Handler(Looper.getMainLooper()), this));
    PublicFragmentActivity.Launcher.a((Activity)this.a.activity.get(), localIntent, PublicTransFragmentActivityForTool.class, GdtVideoImaxFragment.class, 1);
  }
  
  public void a()
  {
    GdtLog.a("TransitionContext", "onAnimationEnd() called");
    this.f = true;
    if (this.e) {
      c();
    }
  }
  
  public void b()
  {
    GdtLog.a("TransitionContext", "start() called");
    a(this.a.mediaViewLocationRect.left, this.a.mediaViewLocationRect.top, this.a.mediaViewLocationRect.width(), this.a.mediaViewLocationRect.height());
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.TransitionContext
 * JD-Core Version:    0.7.0.1
 */