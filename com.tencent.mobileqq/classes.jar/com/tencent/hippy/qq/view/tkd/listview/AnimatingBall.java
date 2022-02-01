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
  public static final int BALL_MARGIN_H = ImmersiveUtils.a(12.0F);
  public static final int BALL_MARING_V = ImmersiveUtils.a(18.0F);
  public static final int BALL_SIZE = ImmersiveUtils.a(3.0F);
  public static final int CONTENT_HEIGHT = ImmersiveUtils.a(36.0F);
  static final int INITIAL_Y = -ImmersiveUtils.a(40.0F);
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
    this.mInitialY = (INITIAL_Y + (3 - paramInt) * ImmersiveUtils.a(8.0F));
    this.mOffsetY = this.mInitialY;
    int i = Math.abs(TARGET_Y);
    if (paramInt == 0) {}
    for (this.mStartAnimationY = 0;; this.mStartAnimationY = ((CONTENT_HEIGHT - i) / 2 * (paramInt - 1) + i))
    {
      this.mEndAnimationY = (i + (CONTENT_HEIGHT - i) / 2 * paramInt);
      Log.d("AnimatingBall", "index=" + paramInt + ",mStart=" + this.mStartAnimationY + ",mEnd=" + this.mEndAnimationY);
      return;
    }
  }
  
  public void animateRefresh()
  {
    this.mRefreshing = true;
    this.mRefreshStartTime = System.currentTimeMillis();
    this.mCb.postInvalidate();
  }
  
  void calculateTransforms(long paramLong)
  {
    if (this.mRefreshStartTime == -1L) {}
    label519:
    for (;;)
    {
      return;
      int m = this.mAlphaValues.length;
      int k = this.mScaleValues.length;
      int j = 0;
      int i = 1;
      for (float f2 = 0.0F; (j < m) && (i < m); f2 = f1 + f2)
      {
        f1 = Math.abs(this.mAlphaValues[j] - this.mAlphaValues[i]);
        j += 1;
        i += 1;
      }
      j = 0;
      i = 1;
      for (float f1 = 0.0F; (j < k) && (i < k); f1 = f3 + f1)
      {
        f3 = Math.abs(this.mScaleValues[j] - this.mScaleValues[i]);
        j += 1;
        i += 1;
      }
      float f3 = 0.0F;
      long l = this.mRefreshStartDelay;
      if (this.mAlphaDuration != 0L) {
        f3 = (float)((paramLong - (this.mRefreshStartTime + l)) % this.mAlphaDuration) / (float)this.mAlphaDuration;
      }
      if ((f3 >= 0.0F) && (f3 < 1.0F))
      {
        f2 = this.mAlphaInterpolator.getInterpolation(f3) * f2;
        i = 0;
        j = 1;
        if ((i < m) && (j < m))
        {
          f3 = Math.abs(this.mAlphaValues[i] - this.mAlphaValues[j]);
          if (f2 > f3) {
            break label473;
          }
          if (this.mAlphaValues[i] <= this.mAlphaValues[j]) {
            break label467;
          }
          j = -1;
          label292:
          f3 = this.mAlphaValues[i];
          setAlpha(j * f2 + f3);
        }
      }
      f2 = 0.0F;
      if (this.mScaleDuration != 0L) {
        f2 = (float)((paramLong - (this.mRefreshStartTime + l)) % this.mScaleDuration) / (float)this.mScaleDuration;
      }
      if ((f2 >= 0.0F) && (f2 < 1.0F))
      {
        f1 = this.mScaleInterpolator.getInterpolation(f2) * f1;
        i = 0;
        j = 1;
        for (;;)
        {
          if ((i >= k) || (j >= k)) {
            break label519;
          }
          f2 = Math.abs(this.mScaleValues[i] - this.mScaleValues[j]);
          if (f1 <= f2)
          {
            if (this.mScaleValues[i] > this.mScaleValues[j]) {}
            for (j = -1;; j = 1)
            {
              f2 = this.mScaleValues[i];
              setScale(j * f1 + f2);
              return;
              label467:
              j = 1;
              break label292;
              label473:
              f2 -= f3;
              i += 1;
              j += 1;
              break;
            }
          }
          f1 -= f2;
          i += 1;
          j += 1;
        }
      }
    }
  }
  
  public void draw(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    float f2;
    if (paramInt2 != 2147483647)
    {
      i = 1;
      if (i == 0) {
        onScroll(paramInt1);
      }
      calculateTransforms(System.currentTimeMillis());
      paramCanvas.save();
      this.sPaint.setColor(this.mBallColor);
      f2 = this.mOffsetX + paramInt3;
      if (i != 0) {
        break label120;
      }
    }
    label120:
    for (float f1 = this.mOffsetY - paramInt1;; f1 = paramInt2)
    {
      paramCanvas.drawCircle(f2, f1, this.mBallSize, this.sPaint);
      paramCanvas.restore();
      if ((this.mRefreshing) && (this.mRefreshStartTime != -1L)) {
        this.mCb.postInvalidate();
      }
      return;
      i = 0;
      break;
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
    if ((-paramInt > this.mStartAnimationY) && (-paramInt < this.mEndAnimationY))
    {
      float f1 = (-paramInt - this.mStartAnimationY) / (this.mEndAnimationY - this.mStartAnimationY);
      float f2 = this.mInitialY;
      this.mOffsetY = (f1 * (TARGET_Y - this.mInitialY) + f2);
      return;
    }
    if (-paramInt <= this.mStartAnimationY)
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
    this.mBallSize = (BALL_SIZE * paramFloat);
  }
  
  public void setTargetY(int paramInt1, int paramInt2)
  {
    TARGET_Y = paramInt1;
    paramInt1 = Math.abs(TARGET_Y);
    if (paramInt2 == 0) {}
    for (this.mStartAnimationY = 0;; this.mStartAnimationY = ((CONTENT_HEIGHT - paramInt1) / 2 * (paramInt2 - 1) + paramInt1))
    {
      this.mEndAnimationY = (paramInt1 + (CONTENT_HEIGHT - paramInt1) / 2 * paramInt2);
      Log.d("AnimatingBall", "index=" + paramInt2 + ",mStart=" + this.mStartAnimationY + ",mEnd=" + this.mEndAnimationY);
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.AnimatingBall
 * JD-Core Version:    0.7.0.1
 */