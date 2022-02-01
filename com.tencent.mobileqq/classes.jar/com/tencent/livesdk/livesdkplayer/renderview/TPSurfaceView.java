package com.tencent.livesdk.livesdkplayer.renderview;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.livesdk.livesdkplayer.utils.NotchUtil;
import com.tencent.livesdk.livesdkplayer.utils.UIUtil;

public class TPSurfaceView
  extends SurfaceView
  implements ITPViewBase
{
  private static final String TAG = "TPPlayer[TPSurfaceView.java]";
  private int degree = 0;
  private int radioHeight = 0;
  private int radioWidth = 0;
  private float scale = 1.0F;
  private SurfaceHolder.Callback surfaceCallback = new TPSurfaceView.1(this);
  private int type = 0;
  private int videoHeight;
  private int videoWidth;
  private ITPViewBase.ViewCreateCallBack viewCreateCallBack;
  
  public TPSurfaceView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public TPSurfaceView(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    if (paramBoolean1) {
      setZOrderOnTop(paramBoolean1);
    }
    if (paramBoolean2) {
      setZOrderMediaOverlay(paramBoolean2);
    }
    initView();
  }
  
  private void initView()
  {
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    this.scale = 1.0F;
    this.type = 0;
    setZOrderOnTop(true);
    setZOrderMediaOverlay(true);
    getHolder().setFormat(-2);
    getHolder().addCallback(this.surfaceCallback);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j;
    float f;
    if ((this.videoWidth > 0) && (this.videoHeight > 0))
    {
      j = getDefaultSize(getWidth(), paramInt1);
      paramInt1 = getDefaultSize(getHeight(), paramInt2);
      if (this.type == 2) {
        if (this.videoWidth * paramInt1 > this.videoHeight * j)
        {
          paramInt2 = this.videoWidth * paramInt1 / this.videoHeight;
          f = 1.0F;
        }
      }
    }
    for (;;)
    {
      int i = paramInt1;
      if ((getContext() instanceof Activity))
      {
        i = paramInt1;
        if (UIUtil.isNavigationBarShow((Activity)getContext(), NotchUtil.hasNotch(getContext()))) {
          i = paramInt1 - UIUtil.getNavigationBarHeight(getContext());
        }
      }
      setMeasuredDimension((int)(paramInt2 * this.scale * f), (int)(f * (i * this.scale)));
      return;
      if (this.videoWidth * paramInt1 < this.videoHeight * j)
      {
        paramInt1 = this.videoHeight * j / this.videoWidth;
        f = 1.0F;
        paramInt2 = j;
        continue;
        if (this.type == 1)
        {
          f = 1.0F;
          paramInt2 = j;
          continue;
        }
        if (this.type == 6)
        {
          if (this.videoWidth * paramInt1 > this.videoHeight * j)
          {
            paramInt1 = this.videoHeight * j / this.videoWidth;
            f = 1.0F;
            paramInt2 = j;
            continue;
          }
          if (this.videoWidth * paramInt1 < this.videoHeight * j)
          {
            paramInt2 = this.videoWidth * paramInt1 / this.videoHeight;
            f = paramInt1 / (this.videoWidth / this.videoHeight * paramInt1);
          }
        }
        else
        {
          i = this.videoWidth;
          paramInt2 = i;
          if (this.radioWidth != 0)
          {
            paramInt2 = i;
            if (this.radioHeight != 0) {
              paramInt2 = (int)(this.videoWidth * this.radioWidth / this.radioHeight);
            }
          }
          if (paramInt2 * paramInt1 > this.videoHeight * j)
          {
            paramInt2 = this.videoHeight * j / paramInt2;
            i = j;
          }
          for (;;)
          {
            if (((this.degree == 90) || (this.degree == 270)) && (paramInt2 > 0) && (i > 0))
            {
              if (j / paramInt2 < paramInt1 / i)
              {
                f = j / paramInt2;
                paramInt1 = paramInt2;
                paramInt2 = i;
                break;
                if (paramInt2 * paramInt1 >= this.videoHeight * j) {
                  break label478;
                }
                i = paramInt2 * paramInt1 / this.videoHeight;
                paramInt2 = paramInt1;
                continue;
              }
              f = paramInt1 / i;
              paramInt1 = paramInt2;
              paramInt2 = i;
              break;
              super.onMeasure(paramInt1, paramInt2);
              return;
            }
            f = 1.0F;
            paramInt1 = paramInt2;
            paramInt2 = i;
            break;
            label478:
            paramInt2 = paramInt1;
            i = j;
          }
        }
      }
      f = 1.0F;
      paramInt2 = j;
    }
  }
  
  public boolean setDegree(int paramInt)
  {
    setRotation(paramInt);
    this.degree = paramInt;
    return true;
  }
  
  public void setOpaqueInfo(boolean paramBoolean) {}
  
  public void setRadio(int paramInt1, int paramInt2)
  {
    this.radioWidth = paramInt1;
    this.radioHeight = paramInt2;
  }
  
  public void setScaleParam(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.type = 0;
      this.scale = paramFloat;
    }
  }
  
  public void setVideoWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
  }
  
  public void setViewCallBack(ITPViewBase.ViewCreateCallBack paramViewCreateCallBack)
  {
    this.viewCreateCallBack = paramViewCreateCallBack;
  }
  
  public void setXYAxis(int paramInt)
  {
    this.type = paramInt;
    this.scale = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPSurfaceView
 * JD-Core Version:    0.7.0.1
 */