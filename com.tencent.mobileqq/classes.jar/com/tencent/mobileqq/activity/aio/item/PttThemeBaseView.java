package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class PttThemeBaseView
  extends View
{
  protected int a;
  protected Canvas a;
  protected Paint a;
  protected PorterDuffXfermode a;
  protected RectF a;
  protected Xfermode a;
  protected boolean a;
  protected int b;
  protected Canvas b;
  protected RectF b;
  protected int c;
  protected Bitmap c;
  protected int d;
  protected Bitmap d;
  protected int e = 1;
  protected int f = 0;
  protected int g = -1;
  protected int h = -1;
  protected int i = 8;
  
  public PttThemeBaseView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public PttThemeBaseView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public PttThemeBaseView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    int j;
    int k;
    Bitmap localBitmap;
    do
    {
      do
      {
        return paramBitmap;
        j = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
      } while ((j == paramInt1) && (k == paramInt2));
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      paramBitmap = localBitmap;
    } while (!QLog.isColorLevel());
    QLog.d("PttBaseView", 2, "initBitmap change width =" + paramInt1 + " height=" + paramInt2 + " oldBitmapWidth =" + j + " oldBitmpHeight=" + k);
    return localBitmap;
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    int j = this.jdField_b_of_type_AndroidGraphicsCanvas.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
    a(this.jdField_b_of_type_AndroidGraphicsCanvas);
    b(this.jdField_b_of_type_AndroidGraphicsCanvas);
    this.jdField_b_of_type_AndroidGraphicsCanvas.restoreToCount(j);
  }
  
  public void a()
  {
    if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
    }
    if ((this.jdField_d_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_d_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_d_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_d_of_type_AndroidGraphicsBitmap = null;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.e);
    this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    this.i = AIOUtils.a(paramInt, getContext().getResources());
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  protected abstract boolean a();
  
  protected void b()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsCanvas == null) || (this.jdField_c_of_type_AndroidGraphicsBitmap == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void b(Canvas paramCanvas)
  {
    if (this.f != 0)
    {
      b();
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidGraphicsRectF == null) || (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    if (a())
    {
      if (this.jdField_a_of_type_Boolean)
      {
        c();
        this.jdField_a_of_type_Boolean = false;
      }
      paramCanvas.save();
      paramCanvas.drawBitmap(this.jdField_d_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel()) {
      QLog.d("PttBaseView", 2, "onLayout changed=" + paramBoolean + " left=" + paramInt1 + " top=" + paramInt2 + " right=" + paramInt3 + " bottom=" + paramInt4);
    }
    if (paramBoolean)
    {
      this.g = ((getMeasuredWidth() - getPaddingRight() + getPaddingLeft()) / 2);
      this.h = ((getMeasuredHeight() + getPaddingTop() - getPaddingBottom()) / 2);
      if (this.g < 0) {
        this.g = 0;
      }
      if (this.h < 0) {
        this.h = 0;
      }
      this.jdField_a_of_type_Int = (this.g - this.i);
      this.jdField_c_of_type_Int = (this.g + this.i);
      this.jdField_b_of_type_Int = (this.h - this.i);
      this.jdField_d_of_type_Int = (this.h + this.i);
      this.jdField_c_of_type_AndroidGraphicsBitmap = a(this.jdField_c_of_type_AndroidGraphicsBitmap, getMeasuredWidth(), getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_c_of_type_AndroidGraphicsBitmap);
      this.jdField_d_of_type_AndroidGraphicsBitmap = a(this.jdField_d_of_type_AndroidGraphicsBitmap, getMeasuredWidth(), getMeasuredHeight());
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_d_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void setThemeColor(int paramInt)
  {
    if (this.f != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttBaseView", 2, "setThemeColor " + Integer.toHexString(this.f));
      }
      this.f = paramInt;
      this.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttThemeBaseView
 * JD-Core Version:    0.7.0.1
 */