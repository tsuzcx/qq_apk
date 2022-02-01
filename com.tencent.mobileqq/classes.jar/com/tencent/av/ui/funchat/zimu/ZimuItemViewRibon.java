package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import com.tencent.av.AVLog;
import com.tencent.av.business.handler.SentenceInfo;
import java.lang.ref.WeakReference;
import java.util.Random;

public class ZimuItemViewRibon
  extends ZimuItemViewMotion
{
  Random t = new Random();
  private int[] u;
  private int v = 0;
  
  public ZimuItemViewRibon(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    paramInt2 = paramInt1 / 4;
    double d = paramInt1;
    Double.isNaN(d);
    int i = (int)(d / 3.8D);
    Double.isNaN(d);
    int j = (int)(d / 3.6D);
    Double.isNaN(d);
    int k = (int)(d / 3.4D);
    Double.isNaN(d);
    int m = (int)(d / 3.2D);
    paramInt1 /= 3;
    Double.isNaN(d);
    int n = (int)(d / 2.8D);
    Double.isNaN(d);
    this.u = new int[] { paramInt2, i, j, k, m, paramInt1, n, (int)(d / 2.6D) };
    paramInt1 = this.t.nextInt(8);
    this.v = this.u[paramInt1];
  }
  
  protected int a(int paramInt)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSPEED: ");
    localStringBuilder.append(this.v);
    AVLog.printColorLog(str, localStringBuilder.toString());
    return this.v;
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.o.setStyle(Paint.Style.FILL_AND_STROKE);
    this.o.setColor(this.b.b);
    this.o.setFakeBoldText(true);
    this.o.setStrokeWidth(this.b.c);
    float f1 = -this.o.getFontMetrics().ascent;
    paramCanvas.drawText((String)this.l.b, 0.0F, f1, this.o);
    this.o.setStyle(Paint.Style.FILL_AND_STROKE);
    this.o.setColor(this.b.a);
    this.o.setFakeBoldText(false);
    this.o.setStrokeWidth(0.0F);
    float f2 = this.b.c / 6.0F;
    paramCanvas.drawText((String)this.l.b, 0.0F + f2, f1 - f2, this.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemViewRibon
 * JD-Core Version:    0.7.0.1
 */