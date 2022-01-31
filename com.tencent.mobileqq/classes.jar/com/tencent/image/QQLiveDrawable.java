package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.view.Gravity;

public class QQLiveDrawable
  extends Drawable
{
  private static final String TAG = QQLiveDrawable.class.getSimpleName();
  public static final String URL_PROTOCOL = "qqlive";
  private boolean mApplyGravity;
  private final Rect mDstRect = new Rect();
  public QQLiveDrawable.QQLiveState mQQLiveState;
  private int mTargetDensity = 160;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public QQLiveDrawable(QQLiveDrawable.QQLiveState paramQQLiveState, Resources paramResources)
  {
    this.mQQLiveState = paramQQLiveState;
    this.mQQLiveState.mVideo.attachDrawable(this);
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = paramQQLiveState.mTargetDensity)
    {
      computeImageSize();
      return;
    }
  }
  
  public QQLiveDrawable(QQLiveImage paramQQLiveImage, Resources paramResources)
  {
    this(new QQLiveDrawable.QQLiveState(paramQQLiveImage), paramResources);
    this.mQQLiveState.mTargetDensity = this.mTargetDensity;
  }
  
  public QQLiveDrawable(String paramString, Resources paramResources)
  {
    this(new QQLiveImage(paramString, null), paramResources);
  }
  
  private void computeImageSize()
  {
    this.mVideoWidth = this.mQQLiveState.mVideo.getScaledWidth(this.mTargetDensity);
    this.mVideoHeight = this.mQQLiveState.mVideo.getScaledHeight(this.mTargetDensity);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mApplyGravity)
    {
      Gravity.apply(this.mQQLiveState.mGravity, this.mVideoWidth, this.mVideoHeight, getBounds(), this.mDstRect);
      this.mApplyGravity = false;
    }
    copyBounds(this.mDstRect);
    this.mQQLiveState.mVideo.draw(paramCanvas, this.mDstRect, this.mQQLiveState.mPaint);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mQQLiveState;
  }
  
  public long getCurrentPosition()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      return this.mQQLiveState.mVideo.getCurrentPosition();
    }
    return 0L;
  }
  
  public long getCurrentPostion()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      return this.mQQLiveState.mVideo.getCurrentPosition();
    }
    return -1L;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mVideoHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mVideoWidth;
  }
  
  public long getMsgUniseq()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null) && (this.mQQLiveState.mVideo.mParams != null)) {
      return this.mQQLiveState.mVideo.mParams.msgUniseq;
    }
    return 0L;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public int getPlayState()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      return this.mQQLiveState.mVideo.getPlayState();
    }
    return 7;
  }
  
  public boolean isPaused()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      return this.mQQLiveState.mVideo.isPaused();
    }
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyGravity = true;
  }
  
  public void onDetachedFromWindow()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.onDetachedFromWindow();
    }
  }
  
  public void pause()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.pause();
    }
  }
  
  public void recyleAndKeepPostion()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.recyleAndKeepPostion();
    }
  }
  
  public void recyleAndNotKeepPosition()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.recyleAndNotKeepPosition();
    }
  }
  
  public void recyleFor2Background()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.recyleFor2Background();
    }
  }
  
  public void release()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.release();
    }
  }
  
  public void replay()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.replay();
    }
  }
  
  public void resume()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.resume();
    }
  }
  
  public void resumeFromPosi(int paramInt)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.resumeFromPosi(paramInt);
    }
  }
  
  public void seek(int paramInt)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.seek(paramInt);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.mQQLiveState.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mQQLiveState.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setGravity(int paramInt)
  {
    this.mQQLiveState.mGravity = paramInt;
    this.mApplyGravity = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null) && (this.mQQLiveState.mVideo.mParams != null)) {
      this.mQQLiveState.mVideo.mParams.mMute = paramBoolean;
    }
  }
  
  public void setOnDownloadListener(QQLiveDrawable.OnDownloadListener paramOnDownloadListener)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.setOnDownloadListener(paramOnDownloadListener);
    }
  }
  
  public void setOnLoopBackListener(QQLiveDrawable.OnLoopBackListener paramOnLoopBackListener)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.setOnLoopBackListener(paramOnLoopBackListener);
    }
  }
  
  public void setOnStateListener(QQLiveDrawable.OnStateListener paramOnStateListener)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.setOnStateListener(paramOnStateListener);
    }
  }
  
  public void setParams(QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams)
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.mParams = paramQQLiveDrawableParams;
    }
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeImageSize();
      invalidateSelf();
    }
  }
  
  public void startVideo()
  {
    if ((this.mQQLiveState != null) && (this.mQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveDrawable
 * JD-Core Version:    0.7.0.1
 */