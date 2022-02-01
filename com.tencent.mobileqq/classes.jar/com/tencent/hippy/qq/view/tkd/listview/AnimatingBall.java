package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.widget.immersive.ImmersiveUtils;

public class AnimatingBall
  implements HippyTKDRefreshAnimation
{
  public static final int BALL_COUNT = 3;
  public static final int BALL_MARGIN_H = ImmersiveUtils.dpToPx(12.0F);
  public static final int BALL_MARING_V = ImmersiveUtils.dpToPx(18.0F);
  public static final int BALL_SIZE = ImmersiveUtils.dpToPx(3.0F);
  public static final int CONTENT_HEIGHT = ImmersiveUtils.dpToPx(36.0F);
  static final int INITIAL_Y = -ImmersiveUtils.dpToPx(40.0F);
  static final int MSG_END = 0;
  static final int MSG_START = 0;
  static final String TAG = "AnimatingBall";
  static int TARGET_Y = -BALL_MARING_V;
  float mAlpha;
  long mAlphaDuration;
  Interpolator mAlphaInterpolator;
  float[] mAlphaValues;
  int mBallColor;
  int mBallIndex = 0;
  int mBallInitialColor;
  float mBallSize;
  HippyTKDInvalidateCallback mCb;
  int mEndAnimationY = 0;
  float mInitialY;
  int mOffsetX;
  float mOffsetY;
  Handler mRefreshHandler;
  int mRefreshStartDelay = 0;
  long mRefreshStartTime = -1L;
  boolean mRefreshing = false;
  float mScale;
  long mScaleDuration;
  Interpolator mScaleInterpolator;
  float[] mScaleValues;
  int mStartAnimationY;
  Paint sPaint;
  
  public AnimatingBall(HippyTKDInvalidateCallback paramHippyTKDInvalidateCallback, int paramInt)
  {
    this.mCb = paramHippyTKDInvalidateCallback;
    this.mBallIndex = paramInt;
    this.mOffsetX = (BALL_SIZE + BALL_MARGIN_H * paramInt);
    if (this.sPaint == null)
    {
      this.sPaint = new Paint();
      this.sPaint.setAntiAlias(true);
      this.sPaint.setDither(true);
    }
    reset();
    this.mRefreshHandler = new AnimatingBall.1(this);
    this.mAlphaInterpolator = new LinearInterpolator();
    this.mScaleInterpolator = new CurvedInterpolator(2);
    this.mAlphaDuration = 800L;
    this.mScaleDuration = 800L;
    this.mAlphaValues = new float[] { 0.2F, 1.0F, 0.2F };
    this.mScaleValues = new float[] { 1.0F, 1.8F, 1.0F };
    this.mRefreshStartDelay = (paramInt * 240);
    this.mInitialY = (INITIAL_Y + (3 - paramInt) * ImmersiveUtils.dpToPx(8.0F));
    this.mOffsetY = this.mInitialY;
    int i = Math.abs(TARGET_Y);
    if (paramInt == 0) {
      this.mStartAnimationY = 0;
    } else {
      this.mStartAnimationY = ((CONTENT_HEIGHT - i) / 2 * (paramInt - 1) + i);
    }
    this.mEndAnimationY = (i + (CONTENT_HEIGHT - i) / 2 * paramInt);
    paramHippyTKDInvalidateCallback = new StringBuilder();
    paramHippyTKDInvalidateCallback.append("index=");
    paramHippyTKDInvalidateCallback.append(paramInt);
    paramHippyTKDInvalidateCallback.append(",mStart=");
    paramHippyTKDInvalidateCallback.append(this.mStartAnimationY);
    paramHippyTKDInvalidateCallback.append(",mEnd=");
    paramHippyTKDInvalidateCallback.append(this.mEndAnimationY);
    Log.d("AnimatingBall", paramHippyTKDInvalidateCallback.toString());
  }
  
  public void animateRefresh()
  {
    this.mRefreshing = true;
    this.mRefreshStartTime = System.currentTimeMillis();
    this.mCb.postInvalidate();
  }
  
  void calculateTransforms(long paramLong)
  {
    if (this.mRefreshStartTime == -1L) {
      return;
    }
    int n = this.mAlphaValues.length;
    int m = this.mScaleValues.length;
    int k = 1;
    int j = 0;
    int i = 1;
    float f2 = 0.0F;
    float[] arrayOfFloat;
    while ((j < n) && (i < n))
    {
      arrayOfFloat = this.mAlphaValues;
      f2 += Math.abs(arrayOfFloat[j] - arrayOfFloat[i]);
      j += 1;
      i += 1;
    }
    j = 0;
    i = 1;
    float f1 = 0.0F;
    while ((j < m) && (i < m))
    {
      arrayOfFloat = this.mScaleValues;
      f1 += Math.abs(arrayOfFloat[j] - arrayOfFloat[i]);
      j += 1;
      i += 1;
    }
    long l1 = this.mRefreshStartDelay;
    long l2 = this.mAlphaDuration;
    float f3;
    if (l2 != 0L) {
      f3 = (float)((paramLong - (this.mRefreshStartTime + l1)) % l2) / (float)l2;
    } else {
      f3 = 0.0F;
    }
    if ((f3 >= 0.0F) && (f3 < 1.0F))
    {
      f2 = this.mAlphaInterpolator.getInterpolation(f3) * f2;
      i = 0;
      j = 1;
      while ((i < n) && (j < n))
      {
        arrayOfFloat = this.mAlphaValues;
        f3 = Math.abs(arrayOfFloat[i] - arrayOfFloat[j]);
        if (f2 <= f3)
        {
          arrayOfFloat = this.mAlphaValues;
          if (arrayOfFloat[i] > arrayOfFloat[j]) {
            j = -1;
          } else {
            j = 1;
          }
          setAlpha(this.mAlphaValues[i] + j * f2);
          break;
        }
        f2 -= f3;
        i += 1;
        j += 1;
      }
    }
    l2 = this.mScaleDuration;
    if (l2 != 0L) {
      f2 = (float)((paramLong - (this.mRefreshStartTime + l1)) % l2) / (float)l2;
    } else {
      f2 = 0.0F;
    }
    if ((f2 >= 0.0F) && (f2 < 1.0F))
    {
      f1 = this.mScaleInterpolator.getInterpolation(f2) * f1;
      i = 0;
      j = 1;
      while ((i < m) && (j < m))
      {
        arrayOfFloat = this.mScaleValues;
        f2 = Math.abs(arrayOfFloat[i] - arrayOfFloat[j]);
        if (f1 <= f2)
        {
          arrayOfFloat = this.mScaleValues;
          if (arrayOfFloat[i] > arrayOfFloat[j]) {
            k = -1;
          }
          setScale(this.mScaleValues[i] + k * f1);
          return;
        }
        f1 -= f2;
        i += 1;
        j += 1;
      }
    }
  }
  
  public void draw(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt2 != 2147483647) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      onScroll(paramInt1);
    }
    calculateTransforms(System.currentTimeMillis());
    paramCanvas.save();
    this.sPaint.setColor(this.mBallColor);
    float f2 = paramInt3 + this.mOffsetX;
    float f1;
    if (i == 0) {
      f1 = this.mOffsetY - paramInt1;
    } else {
      f1 = paramInt2;
    }
    paramCanvas.drawCircle(f2, f1, this.mBallSize, this.sPaint);
    paramCanvas.restore();
    if ((this.mRefreshing) && (this.mRefreshStartTime != -1L)) {
      this.mCb.postInvalidate();
    }
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getOffsetY()
  {
    return this.mOffsetY;
  }
  
  public float getScale()
  {
    return this.mScale;
  }
  
  public void onScroll(int paramInt)
  {
    paramInt = -paramInt;
    int i = this.mStartAnimationY;
    if (paramInt > i)
    {
      int j = this.mEndAnimationY;
      if (paramInt < j)
      {
        float f1 = (paramInt - i) / (j - i);
        float f2 = this.mInitialY;
        this.mOffsetY = (f2 + (TARGET_Y - f2) * f1);
        return;
      }
    }
    if (paramInt <= this.mStartAnimationY)
    {
      this.mOffsetY = this.mInitialY;
      return;
    }
    this.mOffsetY = TARGET_Y;
  }
  
  public void onSkinChange() {}
  
  public void reset()
  {
    setOffsetY(INITIAL_Y);
    setAlpha(1.0F);
    setScale(1.0F);
  }
  
  public void setAlpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
    this.mBallColor = Color.argb((int)(Color.alpha(this.mBallInitialColor) * paramFloat), Color.red(this.mBallInitialColor), Color.green(this.mBallInitialColor), Color.blue(this.mBallInitialColor));
  }
  
  public void setInitialColor(int paramInt)
  {
    this.mBallInitialColor = paramInt;
    reset();
  }
  
  public void setInvalidateCallback(HippyTKDInvalidateCallback paramHippyTKDInvalidateCallback)
  {
    this.mCb = paramHippyTKDInvalidateCallback;
  }
  
  public void setOffsetY(float paramFloat)
  {
    this.mOffsetY = paramFloat;
  }
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
    this.mBallSize = (paramFloat * BALL_SIZE);
  }
  
  public void setTargetY(int paramInt1, int paramInt2)
  {
    TARGET_Y = paramInt1;
    paramInt1 = Math.abs(TARGET_Y);
    if (paramInt2 == 0) {
      this.mStartAnimationY = 0;
    } else {
      this.mStartAnimationY = ((CONTENT_HEIGHT - paramInt1) / 2 * (paramInt2 - 1) + paramInt1);
    }
    this.mEndAnimationY = (paramInt1 + (CONTENT_HEIGHT - paramInt1) / 2 * paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",mStart=");
    localStringBuilder.append(this.mStartAnimationY);
    localStringBuilder.append(",mEnd=");
    localStringBuilder.append(this.mEndAnimationY);
    Log.d("AnimatingBall", localStringBuilder.toString());
  }
  
  public void stopAllAnimators()
  {
    setAlpha(1.0F);
    setScale(1.0F);
    this.mRefreshing = false;
    this.mRefreshStartTime = -1L;
    this.mCb.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.AnimatingBall
 * JD-Core Version:    0.7.0.1
 */