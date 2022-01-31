package com.tencent.biz.qqstory.boundaries.extension.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import bjzx;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import ved;

public class TrimTextureVideoView
  extends com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView
{
  protected Matrix a;
  protected boolean a;
  
  public TrimTextureVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public TrimTextureVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public TrimTextureVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private float a(int paramInt1, int paramInt2)
  {
    return Math.max(1.0F / bjzx.a(getResources()), Math.min(paramInt2, paramInt1) * 1.0F / Math.max(paramInt2, paramInt1));
  }
  
  private Matrix a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Matrix localMatrix = new Matrix();
    float f1 = paramInt1 / paramInt3;
    float f2 = paramInt2 / paramInt4;
    localMatrix.preTranslate((paramInt1 - paramInt3) / 2.0F, (paramInt2 - paramInt4) / 2.0F);
    localMatrix.preScale(paramInt3 / paramInt1, paramInt4 / paramInt2);
    if (f1 >= f2)
    {
      localMatrix.postScale(f2, f2, paramInt1 / 2, paramInt2 / 2);
      return localMatrix;
    }
    localMatrix.postScale(f1, f1, paramInt1 / 2, paramInt2 / 2);
    return localMatrix;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @TargetApi(14)
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.k) && (MediaPlayer.b())) {}
    for (int i = 0 + paramInt1;; i = 0)
    {
      float f;
      if ((paramInt1 % 180 > 0) && (paramInt2 < paramInt3))
      {
        setRotation(i + 90);
        f = a(paramInt2, paramInt3);
        setScaleX(f);
        setScaleY(f);
        ved.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
        return true;
      }
      DisplayMetrics localDisplayMetrics;
      int j;
      if ((paramInt1 % 180 == 0) && (paramInt2 > paramInt3))
      {
        localDisplayMetrics = getResources().getDisplayMetrics();
        i = localDisplayMetrics.widthPixels;
        j = localDisplayMetrics.heightPixels;
        if (this.jdField_a_of_type_AndroidGraphicsMatrix == null) {
          this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidGraphicsMatrix = a(i, j, paramInt2, paramInt3);
          setTransform(this.jdField_a_of_type_AndroidGraphicsMatrix);
          ved.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate but need scale!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
          return false;
          this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        }
      }
      if (i != 0)
      {
        setRotation(i);
        f = a(paramInt2, paramInt3);
        setScaleX(f);
        setScaleY(f);
        ved.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate! but return false", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
        return false;
      }
      if (paramInt2 == paramInt3)
      {
        localDisplayMetrics = getResources().getDisplayMetrics();
        i = localDisplayMetrics.widthPixels;
        j = localDisplayMetrics.heightPixels;
        if (this.jdField_a_of_type_AndroidGraphicsMatrix == null) {
          this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidGraphicsMatrix = a(i, j, paramInt2, paramInt3);
          setTransform(this.jdField_a_of_type_AndroidGraphicsMatrix);
          ved.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate but need scale!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
          return false;
          this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        }
      }
      ved.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return false;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int k = com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.getDefaultSize(this.d, paramInt1);
    int m = com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.getDefaultSize(this.e, paramInt2);
    int j = m;
    int i = k;
    int n;
    if (this.d > 0)
    {
      j = m;
      i = k;
      if (this.e > 0)
      {
        m = View.MeasureSpec.getMode(paramInt1);
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        n = View.MeasureSpec.getMode(paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if ((m != 1073741824) || (n != 1073741824)) {
          break label239;
        }
        if (this.d * paramInt2 >= this.e * paramInt1) {
          break label153;
        }
        if (!this.g) {
          break label135;
        }
        i = this.d * paramInt2 / this.e;
        j = paramInt2;
      }
    }
    for (;;)
    {
      super.setMeasuredDimension(i, j);
      return;
      label135:
      j = this.e * paramInt1 / this.d;
      i = paramInt1;
      continue;
      label153:
      if ((this.d * paramInt2 > this.e * paramInt1) && (this.jdField_a_of_type_Boolean))
      {
        if (this.g)
        {
          j = this.e * paramInt1 / this.d;
          i = paramInt1;
        }
        else
        {
          i = this.d * paramInt2 / this.e;
          j = paramInt2;
        }
      }
      else if (!this.jdField_a_of_type_Boolean)
      {
        super.setMeasuredDimension(paramInt1, paramInt2);
        j = paramInt2;
        i = paramInt1;
        continue;
        label239:
        if (m == 1073741824)
        {
          j = this.e * paramInt1 / this.d;
          if ((n == -2147483648) && (j > paramInt2))
          {
            j = paramInt2;
            i = paramInt1;
          }
        }
        else
        {
          if (n == 1073741824)
          {
            k = this.d * paramInt2 / this.e;
            j = paramInt2;
            i = k;
            if (m != -2147483648) {
              continue;
            }
            j = paramInt2;
            i = k;
            if (k <= paramInt1) {
              continue;
            }
            j = paramInt2;
            i = paramInt1;
            continue;
          }
          k = this.d;
          i = this.e;
          if ((n == -2147483648) && (i > paramInt2)) {
            k = this.d * paramInt2 / this.e;
          }
          for (;;)
          {
            j = paramInt2;
            i = k;
            if (m != -2147483648) {
              break;
            }
            j = paramInt2;
            i = k;
            if (k <= paramInt1) {
              break;
            }
            j = this.e * paramInt1 / this.d;
            i = paramInt1;
            break;
            paramInt2 = i;
          }
        }
        i = paramInt1;
      }
      else
      {
        j = paramInt2;
        i = paramInt1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView
 * JD-Core Version:    0.7.0.1
 */