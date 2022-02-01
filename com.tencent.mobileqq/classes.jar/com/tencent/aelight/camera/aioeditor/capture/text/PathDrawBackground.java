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
  private static final double c = Math.abs(Math.tan(Math.toRadians(10.0D)));
  private Path b = new Path();
  private float d;
  private float e;
  
  public PathDrawBackground(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.setColor(paramInt1);
    this.d = (paramInt2 + ScreenUtil.dip2px(4.0F));
    this.e = paramInt3;
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
      this.b.reset();
      int i = 0;
      RectF localRectF2 = ((PerLineModel)paramArrayList.get(0)).c;
      RectF localRectF1 = ((PerLineModel)paramArrayList.get(paramArrayList.size() - 1)).c;
      float f4 = localRectF2.width() / ((PerLineModel)paramArrayList.get(0)).e.length();
      Path localPath = this.b;
      float f1 = localRectF1.right;
      float f5 = paramInt1;
      float f2 = this.d;
      float f3 = localRectF1.bottom;
      float f6 = paramInt2;
      localPath.moveTo(f1 + f5 + f2, f3 + f6 + this.e);
      this.b.lineTo(localRectF1.left + f5 - this.d, localRectF1.bottom + f6 + this.e);
      this.b.lineTo(localRectF2.left + f5 - this.d, localRectF2.top + f6 - this.e);
      this.b.lineTo(localRectF2.right + f5 + this.d, localRectF2.top + f6 - this.e);
      double d1;
      double d2;
      double d3;
      double d4;
      if (paramArrayList.size() == 1)
      {
        d1 = c;
        d2 = ((PerLineModel)paramArrayList.get(0)).c.height();
        Double.isNaN(d2);
        paramArrayList = this.b;
        d3 = localRectF1.right;
        Double.isNaN(d3);
        d4 = paramInt1;
        Double.isNaN(d4);
        paramArrayList.lineTo((float)(d3 - d1 * d2 + d4) + this.d, localRectF1.bottom + f6 + this.e);
      }
      else
      {
        f1 = -1.0F;
        f2 = -1.0F;
        paramInt1 = i;
        while (paramInt1 < paramArrayList.size())
        {
          localRectF1 = ((PerLineModel)paramArrayList.get(paramInt1)).c;
          if ((f1 != -1.0F) && (f2 != -1.0F))
          {
            paramInt2 = paramArrayList.size();
            i = paramInt1 + 1;
            if (paramInt2 == i)
            {
              if (f2 == localRectF1.top)
              {
                this.b.lineTo(localRectF1.right + f5 + this.d, localRectF1.top + f6);
                d1 = localRectF1.right;
                d2 = c;
                d3 = localRectF1.height();
                Double.isNaN(d3);
                Double.isNaN(d1);
                f1 = a((float)(d1 - d2 * d3));
                f2 = localRectF1.bottom;
                f3 = this.e;
              }
              else
              {
                f1 = a(f1 - 0.75F * f4 + this.d);
                f3 = localRectF1.height();
                this.b.lineTo(f1 + f5, f2 + f3 * 0.1F + f6);
                d1 = f1;
                d2 = localRectF1.height() * 0.9F;
                d3 = c;
                Double.isNaN(d2);
                Double.isNaN(d1);
                f1 = a((float)(d1 - d2 * d3));
                f2 = localRectF1.bottom;
                f3 = this.e;
              }
              f2 += f3;
              this.b.lineTo(f1 + f5, f2 + f6);
            }
            else
            {
              localRectF2 = ((PerLineModel)paramArrayList.get(i)).c;
              if (f2 == localRectF1.top)
              {
                f2 = localRectF1.right;
                f3 = this.d;
                f1 = localRectF1.top;
                this.b.lineTo(f2 + f3 + f5, f1 + f6);
              }
              else
              {
                f3 = a(f1 - 0.75F * f4 + this.d);
                f1 = f2 + localRectF1.height() * 0.1F;
                this.b.lineTo(f3 + f5, f1 + f6);
              }
              if (a(localRectF1.width(), localRectF2.width(), f4))
              {
                f1 = localRectF1.bottom - f1 + localRectF2.height() * 0.1F;
                f2 = localRectF1.top + f1;
                d1 = localRectF1.right;
                d2 = c;
                d3 = f1;
                Double.isNaN(d3);
                Double.isNaN(d1);
                f1 = a((float)(d1 - d2 * d3) + this.d);
              }
              else
              {
                d1 = localRectF1.right;
                d2 = c;
                d3 = localRectF1.height();
                Double.isNaN(d3);
                Double.isNaN(d1);
                f1 = a((float)(d1 - d2 * d3) + this.d);
                f2 = localRectF2.top;
              }
              this.b.lineTo(f1 + f5, f2 + f6);
            }
          }
          else
          {
            localRectF2 = ((PerLineModel)paramArrayList.get(paramInt1 + 1)).c;
            if (a(localRectF1.width(), localRectF2.width(), f4))
            {
              f1 = localRectF1.height() + localRectF2.height() * 0.1F;
              f2 = localRectF1.top + f1;
              d1 = localRectF1.right;
              d2 = c;
              d3 = f1;
              Double.isNaN(d3);
              Double.isNaN(d1);
              d4 = this.d;
              Double.isNaN(d4);
              f1 = a((float)(d1 - d2 * d3 + d4));
            }
            else
            {
              d1 = localRectF1.right;
              d2 = c;
              d3 = localRectF1.height();
              Double.isNaN(d3);
              Double.isNaN(d1);
              d4 = this.d;
              Double.isNaN(d4);
              f1 = a((float)(d1 - d2 * d3 + d4));
              f2 = localRectF2.top;
            }
            this.b.lineTo(f1 + f5, f2 + f6);
          }
          paramInt1 += 1;
        }
      }
      paramCanvas.drawPath(this.b, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.PathDrawBackground
 * JD-Core Version:    0.7.0.1
 */