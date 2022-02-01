package com.tencent.livesdk.livesdkplayer.renderview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;

public class TPTextureView
  extends TextureView
  implements ITPViewBase
{
  private static final String TAG = "TPPlayer[TPTextureView]";
  private int degree = 0;
  private int radioHeight = 0;
  private int radioWidth = 0;
  private float scale = 1.0F;
  private TextureView.SurfaceTextureListener textureListener = new TPTextureView.1(this);
  private int type = 0;
  private int videoHeight;
  private int videoWidth;
  private ITPViewBase.ViewCreateCallBack viewCreateCallBack;
  
  public TPTextureView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public TPTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public TPTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    setOpaque(false);
    setAlpha(0.0F);
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    setSurfaceTextureListener(this.textureListener);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Log.i("TPPlayer[TPTextureView]", "onAttachedToWindow");
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Log.i("TPPlayer[TPTextureView]", "onDetachedFromWindow");
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    float f;
    if ((this.videoWidth > 0) && (this.videoHeight > 0))
    {
      i = getDefaultSize(getWidth(), paramInt1);
      j = getDefaultSize(getHeight(), paramInt2);
      if (this.type == 2) {
        if (this.videoWidth * j > this.videoHeight * i)
        {
          paramInt2 = this.videoWidth * j / this.videoHeight;
          f = 1.0F;
          paramInt1 = j;
        }
      }
    }
    for (;;)
    {
      setMeasuredDimension((int)(paramInt2 * this.scale * f), (int)(f * (paramInt1 * this.scale)));
      return;
      if (this.videoWidth * j < this.videoHeight * i)
      {
        paramInt1 = this.videoHeight * i / this.videoWidth;
        f = 1.0F;
        paramInt2 = i;
        continue;
        if (this.type == 1)
        {
          f = 1.0F;
          paramInt1 = j;
          paramInt2 = i;
          continue;
        }
        if (this.type == 6)
        {
          if (this.videoWidth * j > this.videoHeight * i)
          {
            paramInt1 = this.videoHeight * i / this.videoWidth;
            f = 1.0F;
            paramInt2 = i;
            continue;
          }
          if (this.videoWidth * j < this.videoHeight * i)
          {
            paramInt2 = this.videoWidth * j / this.videoHeight;
            f = j / (this.videoWidth / this.videoHeight * j);
            paramInt1 = j;
          }
        }
        else
        {
          paramInt2 = this.videoWidth;
          paramInt1 = paramInt2;
          if (this.radioWidth != 0)
          {
            paramInt1 = paramInt2;
            if (this.radioHeight != 0) {
              paramInt1 = (int)(this.videoWidth * this.radioWidth / this.radioHeight);
            }
          }
          if (paramInt1 * j > this.videoHeight * i)
          {
            paramInt1 = this.videoHeight * i / paramInt1;
            paramInt2 = i;
          }
          for (;;)
          {
            if (((this.degree == 90) || (this.degree == 270)) && (paramInt1 > 0) && (paramInt2 > 0))
            {
              if (i / paramInt1 < j / paramInt2)
              {
                f = i / paramInt1;
                break;
                if (paramInt1 * j >= this.videoHeight * i) {
                  break label431;
                }
                paramInt2 = paramInt1 * j / this.videoHeight;
                paramInt1 = j;
                continue;
              }
              f = j / paramInt2;
              break;
              super.onMeasure(paramInt1, paramInt2);
              return;
            }
            f = 1.0F;
            break;
            label431:
            paramInt1 = j;
            paramInt2 = i;
          }
        }
      }
      f = 1.0F;
      paramInt1 = j;
      paramInt2 = i;
    }
  }
  
  public boolean setDegree(int paramInt)
  {
    setRotation(paramInt);
    this.degree = paramInt;
    return true;
  }
  
  public void setOpaqueInfo(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setOpaque(true);
      setAlpha(1.0F);
      return;
    }
    setOpaque(false);
    setAlpha(0.0F);
  }
  
  public void setRadio(int paramInt1, int paramInt2)
  {
    this.radioHeight = paramInt2;
    this.radioWidth = paramInt1;
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
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPTextureView
 * JD-Core Version:    0.7.0.1
 */