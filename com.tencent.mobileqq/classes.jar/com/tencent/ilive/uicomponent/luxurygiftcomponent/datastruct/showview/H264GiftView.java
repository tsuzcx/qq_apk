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
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LottieViewInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.PlayTimeMonitor;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.showview.LottieGiftInfo;
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
    this.mLottieView = this.mLuxuryGiftAdapter.createLottieView(paramContext, this.mLuxuryGiftAdapter);
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
    StringBuilder localStringBuilder = new StringBuilder().append(" playInternal headBitmap is null? ");
    if (paramBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      localLogInterface.e("H264GiftShowView|GiftAnimation", bool, new Object[0]);
      this.mLottieView.setConfig(paramLuxuryGiftInfo.lottiePlayConfigFilePath, paramLuxuryGiftInfo.lottieConfigFilePath, this.mCurrentLottieGiftInfo, paramBitmap, new H264GiftView.5(this, paramLuxuryGiftInfo));
      return;
    }
  }
  
  private void reportTime()
  {
    if (this.luxuryGiftData != null)
    {
      this.luxuryGiftData.playTimeMonitor.loadToPlayTime = System.currentTimeMillis();
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
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", "onAttachedToWindow", new Object[0]);
  }
  
  public void onDestory()
  {
    this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", "onDestroy", new Object[0]);
    if (this.mLottieView != null)
    {
      this.mLottieView.cancelLoaderTask();
      this.mLottieView.clearAnimation();
      this.mLottieView.setVisibility(8);
    }
    this.mIsWorking = false;
    if (this.mPlayView != null) {
      this.mPlayView.stop();
    }
    this.mAnimationListener = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", "onDetachedFromWindow", new Object[0]);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    paramInt1 = UIUtil.getContentViewHeight(getContext());
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 < paramInt2) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      setMeasuredDimension(i, paramInt1);
      return;
    }
  }
  
  public void play(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    boolean bool = true;
    if ((paramLuxuryGiftInfo == null) || (TextUtils.isEmpty(paramLuxuryGiftInfo.mediaFilePath)))
    {
      LogInterface localLogInterface = this.mLuxuryGiftAdapter.getLogger();
      StringBuilder localStringBuilder = new StringBuilder().append(" h264GiftShowView giftInfo==");
      if (paramLuxuryGiftInfo == null) {}
      for (;;)
      {
        localLogInterface.e("H264GiftShowView|GiftAnimation", bool, new Object[0]);
        return;
        bool = false;
      }
    }
    this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", "containerShow= " + this.containerShow, new Object[0]);
    this.mIsWorking = true;
    if (!this.mShowLottieAnimation)
    {
      ThreadCenter.postDefaultUITask(new H264GiftView.3(this, paramLuxuryGiftInfo));
      return;
    }
    this.mLuxuryGiftAdapter.getImageLoaderInterface().displayImage(this.mCurrentLottieGiftInfo.senderHeadUrl, this.fakeImageView, getDisplayImageOptions(2130840592), new H264GiftView.4(this, paramLuxuryGiftInfo));
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
    this.mCurrentLottieGiftInfo.senderName = paramLottieGiftInfo.senderName;
    this.mCurrentLottieGiftInfo.senderHeadUrl = paramLottieGiftInfo.senderHeadUrl;
    this.mCurrentLottieGiftInfo.effectId = paramLottieGiftInfo.effectId;
    this.mCurrentLottieGiftInfo.giftName = paramLottieGiftInfo.giftName;
    this.mCurrentLottieGiftInfo.effectNum = paramLottieGiftInfo.effectNum;
    this.mCurrentLottieGiftInfo.comment = paramLottieGiftInfo.comment;
    this.mCurrentLottieGiftInfo.anchorName = paramLottieGiftInfo.anchorName;
    this.mCurrentLottieGiftInfo.anchorUin = paramLottieGiftInfo.anchorUin;
    this.mCurrentLottieGiftInfo.linkMicComment = paramLottieGiftInfo.linkMicComment;
    this.mCurrentLottieGiftInfo.mCurAnchorUin = paramLottieGiftInfo.mCurAnchorUin;
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
    int i = 0;
    this.mLuxuryGiftAdapter.getLogger().e("H264GiftShowView|GiftAnimation", "h264=" + paramBoolean, new Object[0]);
    this.containerShow = paramBoolean;
    LottieViewInterface localLottieViewInterface;
    if (this.mLottieView.isAnimating())
    {
      localLottieViewInterface = this.mLottieView;
      if (!paramBoolean) {
        break label84;
      }
    }
    for (;;)
    {
      localLottieViewInterface.setVisibility(i);
      this.mPlayView.setContentVisible(paramBoolean);
      return;
      label84:
      i = 4;
    }
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
    if (this.mAnimationListener != null) {
      this.mAnimationListener.animationCancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.H264GiftView
 * JD-Core Version:    0.7.0.1
 */