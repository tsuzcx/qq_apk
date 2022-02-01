package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ZimuItemViewFilm
  extends ZimuItemView
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private long F;
  private Canvas G = new Canvas();
  private Bitmap H;
  private Bitmap I;
  Paint t = new Paint(2);
  Paint u = new Paint(1);
  IZimuItemView.FontPara v;
  Handler w = new ZimuItemViewFilm.myHander(this.a, this);
  boolean x = true;
  private int y;
  private int z;
  
  public ZimuItemViewFilm(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    this.C = ((int)paramContext.getResources().getDimension(2131298446));
    this.B = (this.j - this.C * 2);
    this.y = (this.j / 6);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    this.o.setStyle(Paint.Style.FILL_AND_STROKE);
    this.o.setColor(this.b.b);
    this.o.setStrokeWidth(this.b.c);
    float f1 = -this.o.getFontMetrics().ascent;
    String str = (String)this.l.b;
    float f2 = paramInt;
    paramCanvas.drawText(str, f2, f1, this.o);
    this.o.setStyle(Paint.Style.FILL_AND_STROKE);
    this.o.setColor(this.b.a);
    this.o.setStrokeWidth(0.0F);
    this.o.setFakeBoldText(false);
    paramCanvas.drawText((String)this.l.b, f2, f1, this.o);
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    Bitmap localBitmap = this.H;
    if (localBitmap != null)
    {
      if (!localBitmap.isRecycled())
      {
        paramCanvas.save();
        if (n()) {
          paramInt2 = -this.E;
        } else {
          paramInt2 = paramInt1 - super.h() >> 1;
        }
        paramCanvas.translate(paramInt2, 0.0F);
        paramCanvas.drawBitmap(this.H, 0.0F, 0.0F, this.t);
        paramCanvas.restore();
      }
      localBitmap = this.I;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        paramInt2 = this.H.getHeight();
        if (o()) {
          paramInt1 = -this.D;
        } else {
          paramInt1 = paramInt1 - u() >> 1;
        }
        paramCanvas.save();
        paramCanvas.translate(paramInt1, 0.0F);
        paramCanvas.drawBitmap(this.I, 0.0F, paramInt2, this.t);
        paramCanvas.restore();
      }
    }
  }
  
  private void c(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramInt2 = super.h();
    int i = super.i();
    a(paramCanvas, paramInt1 - paramInt2 >> 1);
    d(paramCanvas, paramInt1 - u() >> 1, i);
  }
  
  private void d(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.u.setStyle(Paint.Style.FILL_AND_STROKE);
    this.u.setColor(this.v.b);
    this.u.setStrokeWidth(this.v.c);
    Object localObject = this.u.getFontMetrics();
    float f1 = paramInt2 - ((Paint.FontMetrics)localObject).ascent;
    localObject = (String)this.l.c;
    float f2 = paramInt1;
    paramCanvas.drawText((String)localObject, f2, f1, this.u);
    this.u.setStyle(Paint.Style.FILL_AND_STROKE);
    this.u.setColor(this.v.a);
    this.u.setStrokeWidth(0.0F);
    this.u.setFakeBoldText(false);
    paramCanvas.drawText((String)this.l.c, f2, f1, this.u);
  }
  
  private void v()
  {
    if ((n()) || (o()))
    {
      int i = s();
      int j = super.h() - this.B;
      int k;
      if (n())
      {
        k = this.E;
        if (j > k)
        {
          this.E = (k + i);
          if (j < this.D) {
            this.D = j;
          }
        }
      }
      j = u() - this.B;
      if (o())
      {
        k = this.D;
        if (j > k)
        {
          this.D = (k + i);
          if (j < this.D) {
            this.D = j;
          }
        }
      }
    }
  }
  
  private void w()
  {
    if (!this.e)
    {
      this.x = false;
      b();
    }
  }
  
  public int a(long paramLong)
  {
    return 0;
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    int i;
    if ((!n()) && (!o())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      b(paramCanvas, paramInt1, paramInt2);
    } else {
      c(paramCanvas, paramInt1, paramInt2);
    }
    long l2 = System.currentTimeMillis();
    paramCanvas = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDraw film:|");
    localStringBuilder.append(l2 - l1);
    AVLog.printColorLog(paramCanvas, localStringBuilder.toString());
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    super.a(paramSentenceInfo);
    if (this.l != null) {
      paramSentenceInfo = this.l.c;
    } else {
      paramSentenceInfo = null;
    }
    paramSentenceInfo = (String)paramSentenceInfo;
    this.z = a(this.u, paramSentenceInfo);
    int i = h();
    this.h = ((this.j - i) / 2);
    if ((this.l != null) && (this.l.a()))
    {
      paramSentenceInfo = this.w.obtainMessage(0);
      this.w.sendMessageDelayed(paramSentenceInfo, 2000L);
    }
  }
  
  public boolean a()
  {
    return this.x;
  }
  
  void b(Typeface paramTypeface, int paramInt, IZimuItemView.FontPara paramFontPara)
  {
    if (paramTypeface != null) {
      this.u.setTypeface(paramTypeface);
    }
    this.v = paramFontPara;
    this.u.setTextSize(paramInt);
    if (this.l != null) {
      paramTypeface = this.l.c;
    } else {
      paramTypeface = null;
    }
    paramTypeface = (String)paramTypeface;
    this.z = a(this.u, paramTypeface);
    this.A = a(this.u);
  }
  
  public void c()
  {
    super.c();
    this.w.removeMessages(0);
  }
  
  public int h()
  {
    return Math.min(Math.max(super.h(), u()), this.B);
  }
  
  public int i()
  {
    return (int)this.n.getResources().getDimension(2131298444);
  }
  
  public Bitmap k()
  {
    v();
    if ((this.m != null) && (!this.m.isRecycled()))
    {
      a(this.q, h(), i());
    }
    else
    {
      if ((n()) || (o()))
      {
        q();
        r();
      }
      this.m = l();
    }
    return this.m;
  }
  
  void m()
  {
    super.m();
    Bitmap localBitmap = this.H;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.H = null;
    }
    localBitmap = this.I;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.I = null;
    }
  }
  
  boolean n()
  {
    return super.h() > this.B;
  }
  
  boolean o()
  {
    return u() > this.B;
  }
  
  boolean p()
  {
    return ((n()) && (super.h() - this.B > this.E)) || ((o()) && (u() - this.B > this.D));
  }
  
  Bitmap q()
  {
    try
    {
      this.H = Bitmap.createBitmap(super.h(), super.i(), Bitmap.Config.ARGB_8888);
      this.G.setBitmap(this.H);
      a(this.G, 0);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, localException.getMessage());
      }
    }
    return this.H;
  }
  
  Bitmap r()
  {
    if ((this.l != null) && (!TextUtils.isEmpty(this.l.c)))
    {
      try
      {
        this.I = Bitmap.createBitmap(u(), t(), Bitmap.Config.ARGB_8888);
        this.G.setBitmap(this.I);
        d(this.G, 0, 0);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.a, 2, localException.getMessage());
        }
      }
      return this.I;
    }
    return null;
  }
  
  int s()
  {
    long l2 = System.currentTimeMillis();
    long l3 = this.F;
    long l1 = 0L;
    if (l3 != 0L) {
      l1 = this.y * (l2 - l3) >> 10;
    }
    this.F = l2;
    return (int)l1;
  }
  
  int t()
  {
    if (this.A == 0) {
      this.A = a(this.u);
    }
    return this.A;
  }
  
  int u()
  {
    if (this.z == 0)
    {
      if (this.l != null) {
        localObject = this.l.c;
      } else {
        localObject = null;
      }
      Object localObject = (String)localObject;
      this.z = a(this.u, (String)localObject);
    }
    return this.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemViewFilm
 * JD-Core Version:    0.7.0.1
 */