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
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.videoWidth > 0) && (this.videoHeight > 0))
    {
      int i = getDefaultSize(getWidth(), paramInt1);
      int j = getDefaultSize(getHeight(), paramInt2);
      float f2 = 1.0F;
      paramInt1 = this.type;
      int k;
      int m;
      float f1;
      if (paramInt1 == 2)
      {
        k = this.videoWidth;
        m = this.videoHeight;
        if (k * j > i * m)
        {
          paramInt2 = k * j / m;
          f1 = f2;
          paramInt1 = j;
        }
        else
        {
          f1 = f2;
          paramInt2 = i;
          paramInt1 = j;
          if (k * j < i * m)
          {
            paramInt1 = m * i / k;
            f1 = f2;
            paramInt2 = i;
          }
        }
      }
      else if (paramInt1 == 1)
      {
        f1 = f2;
        paramInt2 = i;
        paramInt1 = j;
      }
      else if (paramInt1 == 6)
      {
        k = this.videoWidth;
        m = this.videoHeight;
        if (k * j > i * m)
        {
          paramInt1 = m * i / k;
          f1 = f2;
          paramInt2 = i;
        }
        else
        {
          f1 = f2;
          paramInt2 = i;
          paramInt1 = j;
          if (k * j < i * m)
          {
            paramInt2 = j * k / m;
            f1 = j;
            f1 /= k / m * f1;
            paramInt1 = j;
          }
        }
      }
      else
      {
        paramInt2 = this.videoWidth;
        k = this.radioWidth;
        paramInt1 = paramInt2;
        if (k != 0)
        {
          m = this.radioHeight;
          paramInt1 = paramInt2;
          if (m != 0) {
            paramInt1 = (int)(paramInt2 * k / m);
          }
        }
        paramInt2 = paramInt1 * j;
        k = this.videoHeight;
        if (paramInt2 > i * k)
        {
          paramInt1 = k * i / paramInt1;
          paramInt2 = i;
        }
        else
        {
          if (paramInt2 < i * k) {
            paramInt2 /= k;
          } else {
            paramInt2 = i;
          }
          paramInt1 = j;
        }
        k = this.degree;
        if (k != 90)
        {
          f1 = f2;
          if (k != 270) {}
        }
        else
        {
          f1 = f2;
          if (paramInt1 > 0)
          {
            f1 = f2;
            if (paramInt2 > 0)
            {
              if (i / paramInt1 < j / paramInt2)
              {
                f1 = i;
                f2 = paramInt1;
              }
              else
              {
                f1 = j;
                f2 = paramInt2;
              }
              f1 /= f2;
            }
          }
        }
      }
      i = paramInt1;
      if ((getContext() instanceof Activity))
      {
        i = paramInt1;
        if (UIUtil.isNavigationBarShow((Activity)getContext(), NotchUtil.hasNotch(getContext()))) {
          i = paramInt1 - UIUtil.getNavigationBarHeight(getContext());
        }
      }
      f2 = paramInt2;
      float f3 = this.scale;
      setMeasuredDimension((int)(f2 * f3 * f1), (int)(i * f3 * f1));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPSurfaceView
 * JD-Core Version:    0.7.0.1
 */