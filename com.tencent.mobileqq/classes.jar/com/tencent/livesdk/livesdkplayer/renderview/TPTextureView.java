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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Log.i("TPPlayer[TPTextureView]", "onAttachedToWindow");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Log.i("TPPlayer[TPTextureView]", "onDetachedFromWindow");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMeasure widthMeasureSpec: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" heightMeasureSpec:");
    localStringBuilder.append(paramInt2);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMeasure videoWidth: ");
    localStringBuilder.append(this.videoWidth);
    localStringBuilder.append(" videoHeight:");
    localStringBuilder.append(this.videoHeight);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMeasure type: ");
    localStringBuilder.append(this.type);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
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
          paramInt1 = k * j / m;
          f1 = f2;
          paramInt2 = j;
        }
        else
        {
          f1 = f2;
          paramInt1 = i;
          paramInt2 = j;
          if (k * j < i * m)
          {
            paramInt2 = m * i / k;
            f1 = f2;
            paramInt1 = i;
          }
        }
      }
      else if (paramInt1 == 1)
      {
        f1 = f2;
        paramInt1 = i;
        paramInt2 = j;
      }
      else if (paramInt1 == 6)
      {
        k = this.videoWidth;
        m = this.videoHeight;
        if (k * j > i * m)
        {
          paramInt2 = m * i / k;
          f1 = f2;
          paramInt1 = i;
        }
        else
        {
          f1 = f2;
          paramInt1 = i;
          paramInt2 = j;
          if (k * j < i * m)
          {
            paramInt1 = j * k / m;
            f1 = j;
            f1 /= k / m * f1;
            paramInt2 = j;
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
        i = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure radioWidth:");
      localStringBuilder.append(this.radioWidth);
      localStringBuilder.append(" radioHeight:");
      localStringBuilder.append(this.radioHeight);
      Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure degree:");
      localStringBuilder.append(this.degree);
      Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure vScale:");
      localStringBuilder.append(f1);
      Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMeasure setMeasuredDimension: ");
      f2 = paramInt1;
      localStringBuilder.append((int)(this.scale * f2 * f1));
      localStringBuilder.append("  ");
      float f3 = paramInt2;
      localStringBuilder.append((int)(this.scale * f3 * f1));
      Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
      float f4 = this.scale;
      setMeasuredDimension((int)(f2 * f4 * f1), (int)(f3 * f4 * f1));
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMeasure setMeasuredDimension: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramInt2);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
    super.onMeasure(paramInt1, paramInt2);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRadio num: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  den: ");
    localStringBuilder.append(paramInt2);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
  }
  
  public void setScaleParam(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.type = 0;
      this.scale = paramFloat;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setScaleParam scale: ");
    localStringBuilder.append(paramFloat);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
  }
  
  public void setVideoWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoWidthAndHeight width: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("  height: ");
    localStringBuilder.append(paramInt2);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
  }
  
  public void setViewCallBack(ITPViewBase.ViewCreateCallBack paramViewCreateCallBack)
  {
    this.viewCreateCallBack = paramViewCreateCallBack;
  }
  
  public void setXYAxis(int paramInt)
  {
    this.type = paramInt;
    this.scale = 1.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setXYAxis mXYAxis: ");
    localStringBuilder.append(paramInt);
    Log.i("TPPlayer[TPTextureView]", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPTextureView
 * JD-Core Version:    0.7.0.1
 */