package com.tencent.mobileqq.ar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.List;

public class DrawView2
  extends View
{
  public static float a = 1.0F;
  public static float b = 1.0F;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  HandlerThread g;
  Handler h;
  List<DrawView2.FaceData> i;
  private Paint j = new Paint();
  private Paint k = new Paint();
  
  public DrawView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.j.setARGB(255, 0, 255, 0);
    this.j.setStrokeWidth(10.0F);
    this.j.setStyle(Paint.Style.STROKE);
    this.k.setStrokeWidth(10.0F);
    this.k.setTextSize(30.0F);
    this.k.setColor(-65536);
    setWillNotDraw(false);
    this.g = new HandlerThread("DrawViewThread");
    this.g.start();
    this.h = new Handler(this.g.getLooper());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.i;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.i.iterator();
      while (((Iterator)localObject).hasNext())
      {
        DrawView2.FaceData localFaceData = (DrawView2.FaceData)((Iterator)localObject).next();
        paramCanvas.save();
        int m = 0;
        while (m < 90)
        {
          float f1 = a;
          float f2 = 0.0F;
          float[] arrayOfFloat;
          int n;
          int i1;
          float f3;
          if (f1 != 1.0F)
          {
            arrayOfFloat = localFaceData.a;
            n = m * 2;
            f1 = arrayOfFloat[n];
            i1 = c;
            f2 = i1 / 2;
            int i2 = e;
            f3 = i2 / 2 / (i1 / 2 / a);
            f2 = i2 / 2 + (f1 - f2) * f3;
            f1 = localFaceData.a[(n + 1)] * f / d;
          }
          else if (b != 1.0F)
          {
            arrayOfFloat = localFaceData.a;
            n = m * 2;
            f2 = arrayOfFloat[n] * e / c;
            f1 = localFaceData.a[(n + 1)];
            n = d;
            f3 = n / 2;
            i1 = f;
            f1 = (f1 - f3) * (i1 / 2 / (n / 2 / b)) + i1 / 2;
          }
          else
          {
            f1 = 0.0F;
          }
          paramCanvas.drawPoint(f2, f1, this.j);
          if ((!TextUtils.isEmpty(localFaceData.d)) && (m == 87)) {
            paramCanvas.drawText(localFaceData.d, f2, f1, this.k);
          }
          m += 1;
        }
        paramCanvas.restore();
      }
    }
  }
  
  public void setFaceData(List<DrawView2.FaceData> paramList)
  {
    this.i = paramList;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.DrawView2
 * JD-Core Version:    0.7.0.1
 */