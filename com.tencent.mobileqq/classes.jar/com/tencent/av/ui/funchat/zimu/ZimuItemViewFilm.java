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
  private long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new ZimuItemViewFilm.myHander(this.jdField_a_of_type_JavaLangString, this);
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas = new Canvas();
  Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint(2);
  IZimuItemView.FontPara jdField_b_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara;
  boolean jdField_b_of_type_Boolean = true;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  
  public ZimuItemViewFilm(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    this.n = ((int)paramContext.getResources().getDimension(2131297785));
    this.m = (this.g - this.n * 2);
    this.j = (this.g / 6);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara.b);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara.jdField_a_of_type_Float);
    float f = -this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent;
    paramCanvas.drawText((String)this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.a, paramInt, f, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
    paramCanvas.drawText((String)this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.a, paramInt, f, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        paramCanvas.save();
        if (!d()) {
          break label138;
        }
        paramInt2 = -this.p;
        paramCanvas.translate(paramInt2, 0.0F);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
        paramCanvas.restore();
      }
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        paramInt2 = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
        if (!e()) {
          break label150;
        }
      }
    }
    label138:
    label150:
    for (paramInt1 = -this.o;; paramInt1 = paramInt1 - g() >> 1)
    {
      paramCanvas.save();
      paramCanvas.translate(paramInt1, 0.0F);
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, 0.0F, paramInt2, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
      return;
      paramInt2 = paramInt1 - super.c() >> 1;
      break;
    }
  }
  
  private void c(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramInt2 = super.c();
    int i = super.d();
    a(paramCanvas, paramInt1 - paramInt2 >> 1);
    d(paramCanvas, paramInt1 - g() >> 1, i);
  }
  
  private void d(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara.b);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara.jdField_a_of_type_Float);
    Paint.FontMetrics localFontMetrics = this.jdField_c_of_type_AndroidGraphicsPaint.getFontMetrics();
    float f = paramInt2 - localFontMetrics.ascent;
    paramCanvas.drawText((String)this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.b, paramInt1, f, this.jdField_c_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara.jdField_a_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
    paramCanvas.drawText((String)this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.b, paramInt1, f, this.jdField_c_of_type_AndroidGraphicsPaint);
  }
  
  private void e()
  {
    if ((d()) || (e()))
    {
      int i = e();
      int i1 = super.c() - this.m;
      if ((d()) && (i1 > this.p))
      {
        this.p += i;
        if (i1 < this.o) {
          this.o = i1;
        }
      }
      i1 = g() - this.m;
      if ((e()) && (i1 > this.o))
      {
        this.o = (i + this.o);
        if (i1 < this.o) {
          this.o = i1;
        }
      }
    }
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      a();
    }
  }
  
  public int a(long paramLong)
  {
    return 0;
  }
  
  public Bitmap a()
  {
    e();
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      if ((d()) || (e()))
      {
        c();
        d();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = b();
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, c(), d());
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    int i;
    if ((d()) || (e()))
    {
      i = 1;
      if (i == 0) {
        break label76;
      }
      b(paramCanvas, paramInt1, paramInt2);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      AVLog.printColorLog(this.jdField_a_of_type_JavaLangString, "onDraw film:|" + (l2 - l1));
      return;
      i = 0;
      break;
      label76:
      c(paramCanvas, paramInt1, paramInt2);
    }
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    super.a(paramSentenceInfo);
    if (this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo != null) {}
    for (paramSentenceInfo = this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.b;; paramSentenceInfo = null)
    {
      paramSentenceInfo = (String)paramSentenceInfo;
      this.k = a(this.jdField_c_of_type_AndroidGraphicsPaint, paramSentenceInfo);
      int i = c();
      this.e = ((this.g - i) / 2);
      if ((this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo != null) && (this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.a()))
      {
        paramSentenceInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramSentenceInfo, 2000L);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  void b(Typeface paramTypeface, int paramInt, IZimuItemView.FontPara paramFontPara)
  {
    if (paramTypeface != null) {
      this.jdField_c_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
    this.jdField_b_of_type_ComTencentAvUiFunchatZimuIZimuItemView$FontPara = paramFontPara;
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(paramInt);
    if (this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo != null) {}
    for (paramTypeface = this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.b;; paramTypeface = null)
    {
      paramTypeface = (String)paramTypeface;
      this.k = a(this.jdField_c_of_type_AndroidGraphicsPaint, paramTypeface);
      this.l = a(this.jdField_c_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public int c()
  {
    return Math.min(Math.max(super.c(), g()), this.m);
  }
  
  Bitmap c()
  {
    try
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(super.c(), super.d(), Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
      a(this.jdField_b_of_type_AndroidGraphicsCanvas, 0);
      return this.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, localException.getMessage());
        }
      }
    }
  }
  
  public int d()
  {
    return (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131297783);
  }
  
  Bitmap d()
  {
    if ((this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.b))) {
      return null;
    }
    try
    {
      this.jdField_c_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(g(), f(), Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap);
      d(this.jdField_b_of_type_AndroidGraphicsCanvas, 0, 0);
      return this.jdField_c_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, localException.getMessage());
        }
      }
    }
  }
  
  void d()
  {
    super.d();
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  boolean d()
  {
    return super.c() > this.m;
  }
  
  int e()
  {
    long l1 = 0L;
    long l2 = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long != 0L) {
      l1 = (l2 - this.jdField_a_of_type_Long) * this.j >> 10;
    }
    this.jdField_a_of_type_Long = l2;
    return (int)l1;
  }
  
  boolean e()
  {
    return g() > this.m;
  }
  
  int f()
  {
    if (this.l == 0) {
      this.l = a(this.jdField_c_of_type_AndroidGraphicsPaint);
    }
    return this.l;
  }
  
  boolean f()
  {
    return ((d()) && (super.c() - this.m > this.p)) || ((e()) && (g() - this.m > this.o));
  }
  
  int g()
  {
    if (this.k == 0) {
      if (this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo == null) {
        break label48;
      }
    }
    label48:
    for (Object localObject = this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.b;; localObject = null)
    {
      localObject = (String)localObject;
      this.k = a(this.jdField_c_of_type_AndroidGraphicsPaint, (String)localObject);
      return this.k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemViewFilm
 * JD-Core Version:    0.7.0.1
 */