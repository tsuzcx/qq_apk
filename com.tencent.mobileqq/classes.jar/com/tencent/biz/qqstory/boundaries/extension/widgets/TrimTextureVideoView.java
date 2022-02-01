package com.tencent.biz.qqstory.boundaries.extension.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;

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
    return Math.max(1.0F / TakeVideoUtils.a(getResources()), Math.min(paramInt2, paramInt1) * 1.0F / Math.max(paramInt2, paramInt1));
  }
  
  private Matrix a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Matrix localMatrix = new Matrix();
    float f1 = paramInt1;
    float f2 = paramInt3;
    float f3 = f1 / f2;
    float f4 = paramInt2;
    float f5 = paramInt4;
    float f6 = f4 / f5;
    localMatrix.preTranslate((paramInt1 - paramInt3) / 2.0F, (paramInt2 - paramInt4) / 2.0F);
    localMatrix.preScale(f2 / f1, f5 / f4);
    if (f3 >= f6)
    {
      localMatrix.postScale(f6, f6, paramInt1 / 2, paramInt2 / 2);
      return localMatrix;
    }
    localMatrix.postScale(f3, f3, paramInt1 / 2, paramInt2 / 2);
    return localMatrix;
  }
  
  @TargetApi(14)
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((this.k) && (MediaPlayer.b())) {
      i = paramInt1 + 0;
    } else {
      i = 0;
    }
    int j = paramInt1 % 180;
    float f;
    if ((j > 0) && (paramInt2 < paramInt3))
    {
      setRotation(i + 90);
      f = a(paramInt2, paramInt3);
      setScaleX(f);
      setScaleY(f);
      SLog.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return true;
    }
    Object localObject;
    if ((j == 0) && (paramInt2 > paramInt3))
    {
      localObject = getResources().getDisplayMetrics();
      i = ((DisplayMetrics)localObject).widthPixels;
      j = ((DisplayMetrics)localObject).heightPixels;
      localObject = this.jdField_a_of_type_AndroidGraphicsMatrix;
      if (localObject == null) {
        this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
      } else {
        ((Matrix)localObject).reset();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidGraphicsMatrix = a(i, j, paramInt2, paramInt3);
      setTransform(this.jdField_a_of_type_AndroidGraphicsMatrix);
      SLog.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate but need scale!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return false;
    }
    if (i != 0)
    {
      setRotation(i);
      f = a(paramInt2, paramInt3);
      setScaleX(f);
      setScaleY(f);
      SLog.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), need rotate! but return false", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return false;
    }
    if (paramInt2 == paramInt3)
    {
      localObject = getResources().getDisplayMetrics();
      i = ((DisplayMetrics)localObject).widthPixels;
      j = ((DisplayMetrics)localObject).heightPixels;
      localObject = this.jdField_a_of_type_AndroidGraphicsMatrix;
      if (localObject == null) {
        this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
      } else {
        ((Matrix)localObject).reset();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidGraphicsMatrix = a(i, j, paramInt2, paramInt3);
      setTransform(this.jdField_a_of_type_AndroidGraphicsMatrix);
      SLog.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate but need scale!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return false;
    }
    SLog.a(this.jdField_a_of_type_JavaLangString, "adjustRotation([rotation]%d, [width]%d, [height]%d), no need rotate!", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.getDefaultSize(this.d, paramInt1);
    int j = com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.getDefaultSize(this.e, paramInt2);
    if ((this.d > 0) && (this.e > 0))
    {
      int m = View.MeasureSpec.getMode(paramInt1);
      int k = View.MeasureSpec.getSize(paramInt1);
      int n = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      if ((m == 1073741824) && (n == 1073741824))
      {
        if (this.d * i < this.e * k) {
          if (!this.g) {}
        }
        for (paramInt1 = this.d * i / this.e;; paramInt1 = this.d * i / this.e)
        {
          paramInt2 = i;
          break label418;
          paramInt1 = this.e * k / this.d;
          i = k;
          break label414;
          if ((this.d * i <= this.e * k) || (!this.jdField_a_of_type_Boolean)) {
            break;
          }
          if (this.g)
          {
            paramInt1 = this.e * k / this.d;
            i = k;
            break label414;
          }
        }
        paramInt1 = k;
        paramInt2 = i;
        if (this.jdField_a_of_type_Boolean) {
          break label418;
        }
        super.setMeasuredDimension(k, i);
        paramInt1 = k;
        paramInt2 = i;
        break label418;
      }
      if (m == 1073741824)
      {
        paramInt2 = this.e * k / this.d;
        if ((n == -2147483648) && (paramInt2 > i))
        {
          paramInt1 = k;
          paramInt2 = i;
          break label418;
        }
        paramInt1 = k;
        break label418;
      }
      if (n == 1073741824)
      {
        j = this.d * i / this.e;
        paramInt1 = j;
        paramInt2 = i;
        if (m == -2147483648)
        {
          paramInt1 = j;
          paramInt2 = i;
          if (j > k)
          {
            paramInt1 = k;
            paramInt2 = i;
            break label418;
          }
        }
      }
      do
      {
        do
        {
          break;
          j = this.d;
          paramInt1 = this.e;
          if ((n == -2147483648) && (paramInt1 > i)) {
            j = this.d * i / this.e;
          } else {
            i = paramInt1;
          }
          paramInt1 = j;
          paramInt2 = i;
        } while (m != -2147483648);
        paramInt1 = j;
        paramInt2 = i;
      } while (j <= k);
      paramInt1 = this.e * k / this.d;
      i = k;
    }
    else
    {
      paramInt1 = j;
    }
    label414:
    paramInt2 = paramInt1;
    paramInt1 = i;
    label418:
    super.setMeasuredDimension(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView
 * JD-Core Version:    0.7.0.1
 */