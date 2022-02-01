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
  private static final String TAG = "QQLiveDrawable";
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
    if (paramResources != null) {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    } else {
      this.mTargetDensity = paramQQLiveState.mTargetDensity;
    }
    computeImageSize();
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
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      return this.mQQLiveState.mVideo.getCurrentPosition();
    }
    return 0L;
  }
  
  public long getCurrentPostion()
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
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
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null) && (this.mQQLiveState.mVideo.mParams != null)) {
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
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      return this.mQQLiveState.mVideo.getPlayState();
    }
    return 7;
  }
  
  public boolean isPaused()
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
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
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.onDetachedFromWindow();
    }
  }
  
  public void pause()
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.pause();
    }
  }
  
  public void recyleAndKeepPostion()
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.recyleAndKeepPostion();
    }
  }
  
  public void recyleAndNotKeepPosition()
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.recyleAndNotKeepPosition();
    }
  }
  
  public void recyleFor2Background()
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.recyleFor2Background();
    }
  }
  
  public void release()
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.release();
    }
  }
  
  public void replay()
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.replay();
    }
  }
  
  public void resume()
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.resume();
    }
  }
  
  public void resumeFromPosi(int paramInt)
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.resumeFromPosi(paramInt);
    }
  }
  
  public void seek(int paramInt)
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
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
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null) && (this.mQQLiveState.mVideo.mParams != null)) {
      this.mQQLiveState.mVideo.mParams.mMute = paramBoolean;
    }
  }
  
  public void setOnDownloadListener(QQLiveDrawable.OnDownloadListener paramOnDownloadListener)
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.setOnDownloadListener(paramOnDownloadListener);
    }
  }
  
  public void setOnLoopBackListener(QQLiveDrawable.OnLoopBackListener paramOnLoopBackListener)
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.setOnLoopBackListener(paramOnLoopBackListener);
    }
  }
  
  public void setOnStateListener(QQLiveDrawable.OnStateListener paramOnStateListener)
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.setOnStateListener(paramOnStateListener);
    }
  }
  
  public void setParams(QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams)
  {
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
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
    QQLiveDrawable.QQLiveState localQQLiveState = this.mQQLiveState;
    if ((localQQLiveState != null) && (localQQLiveState.mVideo != null)) {
      this.mQQLiveState.mVideo.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.QQLiveDrawable
 * JD-Core Version:    0.7.0.1
 */