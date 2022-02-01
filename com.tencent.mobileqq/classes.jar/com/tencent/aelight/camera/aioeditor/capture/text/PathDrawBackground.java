package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;

public class PathDrawBackground
  extends BaseBackgroundDrawer
{
  private static final double jdField_a_of_type_Double = Math.abs(Math.tan(Math.toRadians(10.0D)));
  private float jdField_a_of_type_Float;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private float b;
  
  public PathDrawBackground(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_a_of_type_Float = (paramInt2 + ScreenUtil.dip2px(4.0F));
    this.b = paramInt3;
  }
  
  private float a(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    return f;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 - paramFloat2 >= paramFloat3 * 0.15F;
  }
  
  public void a(Canvas paramCanvas, RectF paramRectF, int paramInt1, int paramInt2) {}
  
  public void a(Canvas paramCanvas, ArrayList<PerLineModel> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramCanvas != null)
    {
      if (paramArrayList == null) {
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      int i = 0;
      RectF localRectF2 = ((PerLineModel)paramArrayList.get(0)).jdField_a_of_type_AndroidGraphicsRectF;
      RectF localRectF1 = ((PerLineModel)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_AndroidGraphicsRectF;
      float f4 = localRectF2.width() / ((PerLineModel)paramArrayList.get(0)).jdField_a_of_type_JavaLangString.length();
      Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      float f1 = localRectF1.right;
      float f5 = paramInt1;
      float f2 = this.jdField_a_of_type_Float;
      float f3 = localRectF1.bottom;
      float f6 = paramInt2;
      localPath.moveTo(f1 + f5 + f2, f3 + f6 + this.b);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localRectF1.left + f5 - this.jdField_a_of_type_Float, localRectF1.bottom + f6 + this.b);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localRectF2.left + f5 - this.jdField_a_of_type_Float, localRectF2.top + f6 - this.b);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localRectF2.right + f5 + this.jdField_a_of_type_Float, localRectF2.top + f6 - this.b);
      double d1;
      double d2;
      double d3;
      double d4;
      if (paramArrayList.size() == 1)
      {
        d1 = jdField_a_of_type_Double;
        d2 = ((PerLineModel)paramArrayList.get(0)).jdField_a_of_type_AndroidGraphicsRectF.height();
        Double.isNaN(d2);
        paramArrayList = this.jdField_a_of_type_AndroidGraphicsPath;
        d3 = localRectF1.right;
        Double.isNaN(d3);
        d4 = paramInt1;
        Double.isNaN(d4);
        paramArrayList.lineTo((float)(d3 - d1 * d2 + d4) + this.jdField_a_of_type_Float, localRectF1.bottom + f6 + this.b);
      }
      else
      {
        f1 = -1.0F;
        f2 = -1.0F;
        paramInt1 = i;
        while (paramInt1 < paramArrayList.size())
        {
          localRectF1 = ((PerLineModel)paramArrayList.get(paramInt1)).jdField_a_of_type_AndroidGraphicsRectF;
          if ((f1 != -1.0F) && (f2 != -1.0F))
          {
            paramInt2 = paramArrayList.size();
            i = paramInt1 + 1;
            if (paramInt2 == i)
            {
              if (f2 == localRectF1.top)
              {
                this.jdField_a_of_type_AndroidGraphicsPath.lineTo(localRectF1.right + f5 + this.jdField_a_of_type_Float, localRectF1.top + f6);
                d1 = localRectF1.right;
                d2 = jdField_a_of_type_Double;
                d3 = localRectF1.height();
                Double.isNaN(d3);
                Double.isNaN(d1);
                f1 = a((float)(d1 - d2 * d3));
                f2 = localRectF1.bottom;
                f3 = this.b;
              }
              else
              {
                f1 = a(f1 - 0.75F * f4 + this.jdField_a_of_type_Float);
                f3 = localRectF1.height();
                this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + f5, f2 + f3 * 0.1F + f6);
                d1 = f1;
                d2 = localRectF1.height() * 0.9F;
                d3 = jdField_a_of_type_Double;
                Double.isNaN(d2);
                Double.isNaN(d1);
                f1 = a((float)(d1 - d2 * d3));
                f2 = localRectF1.bottom;
                f3 = this.b;
              }
              f2 += f3;
              this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + f5, f2 + f6);
            }
            else
            {
              localRectF2 = ((PerLineModel)paramArrayList.get(i)).jdField_a_of_type_AndroidGraphicsRectF;
              if (f2 == localRectF1.top)
              {
                f2 = localRectF1.right;
                f3 = this.jdField_a_of_type_Float;
                f1 = localRectF1.top;
                this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f2 + f3 + f5, f1 + f6);
              }
              else
              {
                f3 = a(f1 - 0.75F * f4 + this.jdField_a_of_type_Float);
                f1 = f2 + localRectF1.height() * 0.1F;
                this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f3 + f5, f1 + f6);
              }
              if (a(localRectF1.width(), localRectF2.width(), f4))
              {
                f1 = localRectF1.bottom - f1 + localRectF2.height() * 0.1F;
                f2 = localRectF1.top + f1;
                d1 = localRectF1.right;
                d2 = jdField_a_of_type_Double;
                d3 = f1;
                Double.isNaN(d3);
                Double.isNaN(d1);
                f1 = a((float)(d1 - d2 * d3) + this.jdField_a_of_type_Float);
              }
              else
              {
                d1 = localRectF1.right;
                d2 = jdField_a_of_type_Double;
                d3 = localRectF1.height();
                Double.isNaN(d3);
                Double.isNaN(d1);
                f1 = a((float)(d1 - d2 * d3) + this.jdField_a_of_type_Float);
                f2 = localRectF2.top;
              }
              this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + f5, f2 + f6);
            }
          }
          else
          {
            localRectF2 = ((PerLineModel)paramArrayList.get(paramInt1 + 1)).jdField_a_of_type_AndroidGraphicsRectF;
            if (a(localRectF1.width(), localRectF2.width(), f4))
            {
              f1 = localRectF1.height() + localRectF2.height() * 0.1F;
              f2 = localRectF1.top + f1;
              d1 = localRectF1.right;
              d2 = jdField_a_of_type_Double;
              d3 = f1;
              Double.isNaN(d3);
              Double.isNaN(d1);
              d4 = this.jdField_a_of_type_Float;
              Double.isNaN(d4);
              f1 = a((float)(d1 - d2 * d3 + d4));
            }
            else
            {
              d1 = localRectF1.right;
              d2 = jdField_a_of_type_Double;
              d3 = localRectF1.height();
              Double.isNaN(d3);
              Double.isNaN(d1);
              d4 = this.jdField_a_of_type_Float;
              Double.isNaN(d4);
              f1 = a((float)(d1 - d2 * d3 + d4));
              f2 = localRectF2.top;
            }
            this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + f5, f2 + f6);
          }
          paramInt1 += 1;
        }
      }
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.PathDrawBackground
 * JD-Core Version:    0.7.0.1
 */