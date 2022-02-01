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
  private long jdField_a_of_type_Long = 0L;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private ZimuItemViewPacMan.PacManPara jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap = null;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas = new Canvas();
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  int j = 10;
  int k = 8;
  int l = 4;
  
  public ZimuItemViewPacMan(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat, ZimuItemViewPacMan.PacManPara paramPacManPara)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_ArrayOfInt = new int[] { paramInt1 / 6, paramInt1 / 5 };
    this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara = paramPacManPara;
    e();
  }
  
  private Bitmap c()
  {
    try
    {
      String str = (String)this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.a;
      int n = str.length();
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.b * n + (n - 1) * this.k, this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.b, Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
      float f2 = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.b / 2;
      Object localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
      float f3 = (((Paint.FontMetrics)localObject).ascent + ((Paint.FontMetrics)localObject).descent) / 2.0F;
      float f4 = this.l / 2;
      float f1 = f2;
      int m;
      for (int i = 0; i < n; i = m)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(false);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawCircle(f1, f2, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.l);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawCircle(f1, f2, f2 - f4, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        localObject = this.jdField_b_of_type_AndroidGraphicsCanvas;
        m = i + 1;
        ((Canvas)localObject).drawText(str, i, m, f1, f2 - f3, this.jdField_a_of_type_AndroidGraphicsPaint);
        i = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.b;
        int i1 = this.k;
        f1 += i + i1;
      }
      return this.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, localException.getMessage());
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError.getMessage());
      }
    }
  }
  
  private boolean d()
  {
    return this.e < this.g / 2;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt < 8) {
      return this.jdField_a_of_type_ArrayOfInt[0];
    }
    return this.jdField_a_of_type_ArrayOfInt[1];
  }
  
  protected int a(Paint paramPaint)
  {
    this.d = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.jdField_a_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRect.right = this.d;
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = this.d;
    return this.d;
  }
  
  protected int a(Paint paramPaint, String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo != null) {
      i = this.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.a.length();
    } else {
      i = 0;
    }
    return this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.jdField_a_of_type_Int + this.j + this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.b * i + (i - 1) * this.k;
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      a(this.jdField_a_of_type_AndroidGraphicsCanvas, c(), d());
    }
    else
    {
      c();
      this.jdField_a_of_type_AndroidGraphicsBitmap = b();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    paramCanvas.drawPaint(this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.save();
    paramCanvas.clipRect(this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.jdField_a_of_type_Int / 2, 0, paramInt1, paramInt2);
    float f2 = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.jdField_a_of_type_Int + this.j;
    float f1 = f2;
    if (d())
    {
      f1 = f2 - this.jdField_a_of_type_Float * 100.0F;
      f1 += this.e * 2 * (f2 - f1) / this.g;
    }
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, f1, (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.b) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[((int)((l1 - this.jdField_a_of_type_Long) / 200L % this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length))];
    this.jdField_a_of_type_AndroidGraphicsRect.right = localBitmap.getWidth();
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = localBitmap.getHeight();
    paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(ZimuItemViewPacMan.PacManPara paramPacManPara)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara = paramPacManPara;
  }
  
  void d()
  {
    super.d();
    Bitmap localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      if (!localBitmap.isRecycled()) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  int e()
  {
    return this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuItemViewPacMan$PacManPara.c;
  }
  
  void e()
  {
    float f = this.jdField_a_of_type_Float * 0.48F;
    this.j = ((int)(this.j * f));
    this.k = ((int)(this.k * f));
    this.l = ((int)(this.l * f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuItemViewPacMan
 * JD-Core Version:    0.7.0.1
 */