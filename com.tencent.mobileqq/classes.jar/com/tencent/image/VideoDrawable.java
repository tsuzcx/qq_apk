package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.view.Gravity;
import java.io.File;

public class VideoDrawable
  extends Drawable
{
  private static final String TAG = VideoDrawable.class.getSimpleName();
  private boolean mApplyGravity;
  private final Rect mDstRect = new Rect();
  private OnPlayerOneFrameListener mFrameDrawListener = null;
  public boolean mPlayVideoFrame = true;
  private int mTargetDensity = 160;
  private int mVideoHeight;
  private VideoState mVideoState;
  private int mVideoWidth;
  
  public VideoDrawable(AbstractVideoImage paramAbstractVideoImage, Resources paramResources)
  {
    this(new VideoState(paramAbstractVideoImage), paramResources);
    this.mVideoState.mTargetDensity = this.mTargetDensity;
  }
  
  public VideoDrawable(VideoState paramVideoState, Resources paramResources)
  {
    this.mVideoState = paramVideoState;
    this.mVideoState.mVideo.attachDrawable(this);
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = paramVideoState.mTargetDensity)
    {
      computeImageSize();
      return;
    }
  }
  
  public VideoDrawable(File paramFile, Resources paramResources, boolean paramBoolean)
  {
    this(new NativeVideoImage(paramFile, paramBoolean), paramResources);
  }
  
  private void computeImageSize()
  {
    this.mVideoWidth = this.mVideoState.mVideo.getScaledWidth(this.mTargetDensity);
    this.mVideoHeight = this.mVideoState.mVideo.getScaledHeight(this.mTargetDensity);
  }
  
  public static boolean isVideo(File paramFile)
  {
    paramFile = paramFile.getAbsolutePath();
    int i = paramFile.lastIndexOf('.');
    paramFile = paramFile.substring(i + 1);
    return (i > 0) && ((paramFile.equals("mp4")) || (paramFile.equals("vf")));
  }
  
  public void disableGlobalPause()
  {
    if ((this.mVideoState.mVideo != null) && ((this.mVideoState.mVideo instanceof NativeVideoImage))) {
      ((NativeVideoImage)this.mVideoState.mVideo).disableGlobalPause();
    }
  }
  
  public void disableRequireAudioFocus()
  {
    if ((this.mVideoState.mVideo != null) && ((this.mVideoState.mVideo instanceof NativeVideoImage))) {
      ((NativeVideoImage)this.mVideoState.mVideo).mRequireAudioFocus = false;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mApplyGravity)
    {
      Gravity.apply(this.mVideoState.mGravity, this.mVideoWidth, this.mVideoHeight, getBounds(), this.mDstRect);
      this.mApplyGravity = false;
    }
    if (this.mFrameDrawListener != null) {
      this.mFrameDrawListener.oneFrameDrawed();
    }
    copyBounds(this.mDstRect);
    this.mVideoState.mVideo.draw(paramCanvas, this.mDstRect, this.mVideoState.mPaint, this.mPlayVideoFrame);
  }
  
  public void enableGlobalPause()
  {
    if ((this.mVideoState.mVideo != null) && ((this.mVideoState.mVideo instanceof NativeVideoImage))) {
      ((NativeVideoImage)this.mVideoState.mVideo).mSupportGlobalPause = true;
    }
  }
  
  public void enableRequireAudioFocus()
  {
    if ((this.mVideoState.mVideo != null) && ((this.mVideoState.mVideo instanceof NativeVideoImage))) {
      ((NativeVideoImage)this.mVideoState.mVideo).mRequireAudioFocus = true;
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mVideoState;
  }
  
  public Bitmap getCurrentBitmap()
  {
    if ((this.mVideoState.mVideo != null) && ((this.mVideoState.mVideo instanceof NativeVideoImage))) {
      return ((NativeVideoImage)this.mVideoState.mVideo).mCurFrameBitmap;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mVideoHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mVideoWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isAudioPlaying()
  {
    return this.mVideoState.mVideo.isAudioPlaying();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyGravity = true;
  }
  
  public void removeOnPlayRepeatListener(OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    if ((this.mVideoState != null) && (this.mVideoState.mVideo != null)) {
      this.mVideoState.mVideo.removeOnPlayRepeatListener(paramOnPlayRepeatListener);
    }
  }
  
  public void resetAndPlayAudioCircle()
  {
    this.mVideoState.mVideo.resetAndPlayAudioCircle();
  }
  
  public void resetAndPlayAudioOnce()
  {
    this.mVideoState.mVideo.resetAndPlayAudioOnce();
  }
  
  public void resetPlay()
  {
    if ((this.mVideoState.mVideo != null) && ((this.mVideoState.mVideo instanceof NativeVideoImage))) {
      ((NativeVideoImage)this.mVideoState.mVideo).mResetFlag = true;
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.mVideoState.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mVideoState.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mVideoState.mPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mVideoState.mPaint.setFilterBitmap(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    this.mVideoState.mGravity = paramInt;
    this.mApplyGravity = true;
  }
  
  public void setOnAudioPlayOnceListener(OnAudioPlayOnceListener paramOnAudioPlayOnceListener)
  {
    if ((this.mVideoState != null) && (this.mVideoState.mVideo != null)) {
      this.mVideoState.mVideo.setOnAudioPlayOnceListener(paramOnAudioPlayOnceListener);
    }
  }
  
  public void setOnPlayRepeatListener(OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    if ((this.mVideoState != null) && (this.mVideoState.mVideo != null)) {
      this.mVideoState.mVideo.setOnPlayRepeatListener(paramOnPlayRepeatListener);
    }
  }
  
  public void setOnPlayerOneFrameListener(OnPlayerOneFrameListener paramOnPlayerOneFrameListener)
  {
    this.mFrameDrawListener = paramOnPlayerOneFrameListener;
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
  
  public void stopAudio()
  {
    this.mVideoState.mVideo.stopPlayAudio();
  }
  
  public static abstract interface OnAudioPlayOnceListener
  {
    public abstract void onFinish();
  }
  
  public static abstract interface OnPlayRepeatListener
  {
    public abstract void onPlayRepeat(int paramInt);
  }
  
  public static abstract interface OnPlayerOneFrameListener
  {
    public abstract void oneFrameDrawed();
  }
  
  public static class VideoDrawableParams
  {
    public String mAfPath;
    public int mDecodeType = 0;
    public boolean mEnableAntiAlias = false;
    public boolean mEnableFilter = false;
    public boolean mPlayAudioFrame = false;
    public boolean mPlayVideoFrame = true;
    public int mRequestedFPS = -1;
    public int mTotalTime;
    public String mVfPath;
    public int mVideoFrames;
    public int mVideoRoundCorner;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(" mVideoRoundCorner: " + this.mVideoRoundCorner);
      localStringBuilder.append(" mPlayVideoFrame: " + this.mPlayVideoFrame);
      localStringBuilder.append(" mPlayAudioFrame: " + this.mPlayAudioFrame);
      localStringBuilder.append(" mEnableAntiAlias: " + this.mEnableAntiAlias);
      localStringBuilder.append(" mEnableFilter: " + this.mEnableFilter);
      localStringBuilder.append(" mRequestedFPS: " + this.mRequestedFPS);
      localStringBuilder.append(" mDecodeType: " + this.mDecodeType);
      localStringBuilder.append(" mVfPath: " + this.mVfPath);
      localStringBuilder.append(" mAfPath: " + this.mAfPath);
      localStringBuilder.append(" mTotalTime: " + this.mTotalTime);
      localStringBuilder.append(" mVideoFrames: " + this.mVideoFrames);
      localStringBuilder.append("] ");
      return localStringBuilder.toString();
    }
  }
  
  static class VideoState
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    int mGravity = 119;
    Paint mPaint = new Paint();
    int mTargetDensity = 160;
    AbstractVideoImage mVideo;
    
    public VideoState(AbstractVideoImage paramAbstractVideoImage)
    {
      this.mVideo = paramAbstractVideoImage;
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new VideoDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new VideoDrawable(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.VideoDrawable
 * JD-Core Version:    0.7.0.1
 */