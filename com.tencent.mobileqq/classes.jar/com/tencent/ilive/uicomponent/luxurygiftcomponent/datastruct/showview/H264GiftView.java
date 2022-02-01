package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.falco.base.libapi.imageloader.DisplayImageOptions;
import com.tencent.falco.base.libapi.imageloader.DisplayImageOptions.Builder;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.lottie.LottieGiftInfo;
import com.tencent.falco.base.libapi.lottie.LottieViewInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.PlayTimeMonitor;
import com.tencent.ilivesdk.playview.view.PlayView;
import com.tencent.ilivesdk.playview.view.VideoPLayListener;

public class H264GiftView
  extends FrameLayout
{
  private static final String TAG = "H264GiftShowView|GiftAnimation";
  private boolean containerShow = true;
  private ImageView fakeImageView = new ImageView(getContext());
  VideoPLayListener iVideoPLay = new H264GiftView.1(this);
  private LuxuryGiftData luxuryGiftData;
  private IGiftAnimation mAnimationListener;
  private LottieGiftInfo mCurrentLottieGiftInfo = new LottieGiftInfo();
  private IH264PlayL mH264PlayListener = null;
  private boolean mIsWorking = false;
  public LottieViewInterface mLottieView;
  private LuxuryGiftAdapter mLuxuryGiftAdapter;
  private PlayView mPlayView;
  private PopupWindow mPopupWindow;
  private boolean mShowLottieAnimation = true;
  Runnable runnable = new H264GiftView.2(this);
  
  public H264GiftView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public H264GiftView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public H264GiftView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public H264GiftView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mLuxuryGiftAdapter = paramLuxuryGiftAdapter;
    init(paramContext);
  }
  
  public H264GiftView(Context paramContext, AttributeSet paramAttributeSet, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    super(paramContext, paramAttributeSet);
    this.mLuxuryGiftAdapter = paramLuxuryGiftAdapter;
    init(paramContext);
  }
  
  public H264GiftView(Context paramContext, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    super(paramContext);
    this.mLuxuryGiftAdapter = paramLuxuryGiftAdapter;
    init(paramContext);
  }
  
  private DisplayImageOptions getDisplayImageOptions(int paramInt)
  {
    return new DisplayImageOptions.Builder().showImageForEmptyUri(paramInt).showImageOnFail(paramInt).cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).build();
  }
  
  private void init(Context paramContext)
  {
    this.mPlayView = new PlayView(paramContext);
    this.mPlayView.initDecodeType(AVCDecoder.isSupportAVCCodec(this.mLuxuryGiftAdapter));
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    addView(this.mPlayView, localLayoutParams);
    this.mPlayView.setPlayListener(this.iVideoPLay);
    this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", " h264 init", new Object[0]);
    this.mLottieView = this.mLuxuryGiftAdapter.getLuxuryGiftLottieView(paramContext);
    if (this.mLottieView == null) {
      this.mLottieView = new LottieView(paramContext, this.mLuxuryGiftAdapter);
    }
    this.mPopupWindow = new PopupWindow(this.mLottieView.getView(), -2, -2, false);
    this.mPopupWindow.setTouchable(false);
    this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap)null));
  }
  
  private void playInternal(LuxuryGiftInfo paramLuxuryGiftInfo, Bitmap paramBitmap)
  {
    LogInterface localLogInterface = this.mLuxuryGiftAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" playInternal headBitmap is null? ");
    boolean bool;
    if (paramBitmap == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
    this.mLottieView.setConfig(paramLuxuryGiftInfo.lottiePlayConfigFilePath, paramLuxuryGiftInfo.lottieConfigFilePath, this.mCurrentLottieGiftInfo, paramBitmap, new H264GiftView.5(this, paramLuxuryGiftInfo));
  }
  
  private void reportTime()
  {
    LuxuryGiftData localLuxuryGiftData = this.luxuryGiftData;
    if (localLuxuryGiftData != null)
    {
      localLuxuryGiftData.playTimeMonitor.loadToPlayTime = System.currentTimeMillis();
      if (this.luxuryGiftData.consumerUin == this.mLuxuryGiftAdapter.getAccountUin())
      {
        long l = this.luxuryGiftData.playTimeMonitor.waitInQueueTime;
        l = this.luxuryGiftData.playTimeMonitor.sendTimeStamp;
        l = this.luxuryGiftData.playTimeMonitor.waitForDownloadTime;
        l = this.luxuryGiftData.playTimeMonitor.waitInQueueTime;
        l = this.luxuryGiftData.playTimeMonitor.loadToPlayTime;
        l = this.luxuryGiftData.playTimeMonitor.waitForDownloadTime;
      }
    }
  }
  
  public boolean isAnimViewReady()
  {
    return true;
  }
  
  public boolean isWorking()
  {
    return this.mIsWorking;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", "onAttachedToWindow", new Object[0]);
  }
  
  public void onDestory()
  {
    this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", "onDestroy", new Object[0]);
    Object localObject = this.mLottieView;
    if (localObject != null)
    {
      ((LottieViewInterface)localObject).cancelLoaderTask();
      this.mLottieView.clearAnimation();
      this.mLottieView.setVisibility(8);
    }
    this.mIsWorking = false;
    localObject = this.mPlayView;
    if (localObject != null) {
      ((PlayView)localObject).stop();
    }
    this.mAnimationListener = null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", "onDetachedFromWindow", new Object[0]);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    paramInt1 = UIUtil.getContentViewHeight(getContext());
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 < paramInt2) {
      paramInt1 = paramInt2;
    }
    setMeasuredDimension(i, paramInt1);
  }
  
  public void play(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    boolean bool = true;
    if ((paramLuxuryGiftInfo != null) && (!TextUtils.isEmpty(paramLuxuryGiftInfo.mediaFilePath)))
    {
      localLogInterface = this.mLuxuryGiftAdapter.getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("containerShow= ");
      localStringBuilder.append(this.containerShow);
      localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
      this.mIsWorking = true;
      if (!this.mShowLottieAnimation)
      {
        ThreadCenter.postDefaultUITask(new H264GiftView.3(this, paramLuxuryGiftInfo));
        return;
      }
      this.mLuxuryGiftAdapter.getImageLoaderInterface().displayImage(this.mCurrentLottieGiftInfo.jdField_b_of_type_JavaLangString, this.fakeImageView, getDisplayImageOptions(2130840463), new H264GiftView.4(this, paramLuxuryGiftInfo));
      return;
    }
    LogInterface localLogInterface = this.mLuxuryGiftAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" h264GiftShowView giftInfo==");
    if (paramLuxuryGiftInfo != null) {
      bool = false;
    }
    localStringBuilder.append(bool);
    localLogInterface.e("H264GiftShowView|GiftAnimation", localStringBuilder.toString(), new Object[0]);
  }
  
  public void setAnimationListener(IGiftAnimation paramIGiftAnimation)
  {
    this.mAnimationListener = paramIGiftAnimation;
  }
  
  public void setBroadCastEvent(LuxuryGiftData paramLuxuryGiftData)
  {
    this.luxuryGiftData = paramLuxuryGiftData;
  }
  
  public void setLottieGiftInfo(LottieGiftInfo paramLottieGiftInfo)
  {
    if (paramLottieGiftInfo == null) {
      return;
    }
    this.mCurrentLottieGiftInfo.jdField_a_of_type_JavaLangString = paramLottieGiftInfo.jdField_a_of_type_JavaLangString;
    this.mCurrentLottieGiftInfo.jdField_b_of_type_JavaLangString = paramLottieGiftInfo.jdField_b_of_type_JavaLangString;
    this.mCurrentLottieGiftInfo.c = paramLottieGiftInfo.c;
    this.mCurrentLottieGiftInfo.d = paramLottieGiftInfo.d;
    this.mCurrentLottieGiftInfo.e = paramLottieGiftInfo.e;
    this.mCurrentLottieGiftInfo.f = paramLottieGiftInfo.f;
    this.mCurrentLottieGiftInfo.g = paramLottieGiftInfo.g;
    this.mCurrentLottieGiftInfo.jdField_a_of_type_Long = paramLottieGiftInfo.jdField_a_of_type_Long;
    this.mCurrentLottieGiftInfo.h = paramLottieGiftInfo.h;
    this.mCurrentLottieGiftInfo.jdField_b_of_type_Long = paramLottieGiftInfo.jdField_b_of_type_Long;
  }
  
  public void setPlayListener(IH264PlayL paramIH264PlayL)
  {
    this.mH264PlayListener = paramIH264PlayL;
  }
  
  public void setShowLottieAnimation(boolean paramBoolean)
  {
    this.mShowLottieAnimation = paramBoolean;
  }
  
  public void showCtrls(boolean paramBoolean)
  {
    Object localObject1 = this.mLuxuryGiftAdapter.getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("h264=");
    ((StringBuilder)localObject2).append(paramBoolean);
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = 0;
    ((LogInterface)localObject1).e("H264GiftShowView|GiftAnimation", (String)localObject2, new Object[0]);
    this.containerShow = paramBoolean;
    if (this.mLottieView.isAnimating())
    {
      localObject1 = this.mLottieView;
      if (!paramBoolean) {
        i = 4;
      }
      ((LottieViewInterface)localObject1).setVisibility(i);
    }
    this.mPlayView.setContentVisible(paramBoolean);
  }
  
  public void stop()
  {
    this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", "stop", new Object[0]);
    if (isWorking()) {
      this.mPlayView.stop();
    }
    if (this.mPopupWindow != null)
    {
      this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", " dismiss dialog", new Object[0]);
      this.mPopupWindow.dismiss();
    }
    IGiftAnimation localIGiftAnimation = this.mAnimationListener;
    if (localIGiftAnimation != null) {
      localIGiftAnimation.animationCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.H264GiftView
 * JD-Core Version:    0.7.0.1
 */