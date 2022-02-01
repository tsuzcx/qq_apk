package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ZimuItemViewPacMan
  extends ZimuItemViewMotion
{
  private Paint A = new Paint();
  private ZimuItemViewPacMan.PacManPara B;
  private Bitmap C = null;
  private Canvas D = new Canvas();
  Rect t = new Rect(0, 0, 0, 0);
  Rect u = new Rect(0, 0, 0, 0);
  int v = 10;
  int w = 8;
  int x = 4;
  private final int[] y;
  private long z = 0L;
  
  public ZimuItemViewPacMan(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat, ZimuItemViewPacMan.PacManPara paramPacManPara)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    this.A.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.o.setTextAlign(Paint.Align.CENTER);
    this.y = new int[] { paramInt1 / 6, paramInt1 / 5 };
    this.B = paramPacManPara;
    n();
  }
  
  private boolean p()
  {
    return this.h < this.j / 2;
  }
  
  private Bitmap q()
  {
    try
    {
      String str = (String)this.l.b;
      int k = str.length();
      this.C = Bitmap.createBitmap(this.B.c * k + (k - 1) * this.w, this.B.c, Bitmap.Config.ARGB_8888);
      this.D.setBitmap(this.C);
      float f2 = this.B.c / 2;
      Object localObject = this.o.getFontMetrics();
      float f3 = (((Paint.FontMetrics)localObject).ascent + ((Paint.FontMetrics)localObject).descent) / 2.0F;
      float f4 = this.x / 2;
      float f1 = f2;
      int j;
      for (int i = 0; i < k; i = j)
      {
        this.o.setAntiAlias(false);
        this.o.setStyle(Paint.Style.FILL);
        this.o.setColor(-1);
        this.D.drawCircle(f1, f2, f2, this.o);
        this.o.setAntiAlias(true);
        this.o.setStyle(Paint.Style.STROKE);
        this.o.setColor(-16777216);
        this.o.setStrokeWidth(this.x);
        this.D.drawCircle(f1, f2, f2 - f4, this.o);
        this.o.setStrokeWidth(0.0F);
        this.o.setStyle(Paint.Style.FILL);
        localObject = this.D;
        j = i + 1;
        ((Canvas)localObject).drawText(str, i, j, f1, f2 - f3, this.o);
        i = this.B.c;
        int m = this.w;
        f1 += i + m;
      }
      return this.C;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, localException.getMessage());
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, localOutOfMemoryError.getMessage());
      }
    }
  }
  
  protected int a(int paramInt)
  {
    if (paramInt < 8) {
      return this.y[0];
    }
    return this.y[1];
  }
  
  protected int a(Paint paramPaint)
  {
    this.g = this.B.b;
    this.u.right = this.g;
    this.u.bottom = this.g;
    return this.g;
  }
  
  protected int a(Paint paramPaint, String paramString)
  {
    int i;
    if (this.l != null) {
      i = this.l.b.length();
    } else {
      i = 0;
    }
    return this.B.b + this.v + this.B.c * i + (i - 1) * this.w;
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    paramCanvas.drawPaint(this.A);
    paramCanvas.save();
    paramCanvas.clipRect(this.B.b / 2, 0, paramInt1, paramInt2);
    float f2 = this.B.b + this.v;
    float f1 = f2;
    if (p())
    {
      f1 = f2 - this.p * 100.0F;
      f1 += this.h * 2 * (f2 - f1) / this.j;
    }
    paramCanvas.drawBitmap(this.C, f1, (this.B.b - this.B.c) / 2, this.o);
    paramCanvas.restore();
    Bitmap localBitmap = this.B.a[((int)((l - this.z) / 200L % this.B.a.length))];
    this.t.right = localBitmap.getWidth();
    this.t.bottom = localBitmap.getHeight();
    paramCanvas.drawBitmap(localBitmap, this.t, this.u, this.o);
  }
  
  public void a(ZimuItemViewPacMan.PacManPara paramPacManPara)
  {
    this.B = paramPacManPara;
  }
  
  public Bitmap k()
  {
    if ((this.m != null) && (!this.m.isRecycled()))
    {
      a(this.q, h(), i());
    }
    else
    {
      q();
      this.m = l();
    }
    return this.m;
  }
  
  void m()
  {
    super.m();
    Bitmap localBitmap = this.C;
    if (localBitmap != null)
    {
      if (!localBitmap.isRecycled()) {
        this.C.recycle();
      }
      this.C = null;
    }
  }
  
  void n()
  {
    float f = this.p * 0.48F;
    this.v = ((int)(this.v * f));
    this.w = ((int)(this.w * f));
    this.x = ((int)(this.x * f));
  }
  
  int o()
  {
    return this.B.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemViewPacMan
 * JD-Core Version:    0.7.0.1
 */