package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class QimMusicSeekView
  extends View
  implements View.OnTouchListener
{
  protected static final int a;
  protected static final int[] a;
  protected static int b;
  protected static int[] b;
  protected static int c;
  protected static int d;
  float a;
  protected Paint a;
  protected Rect a;
  protected QimMusicSeekView.SeekListener a;
  protected boolean a;
  protected Paint b;
  protected Paint c;
  protected Paint d;
  protected int e;
  protected Paint e;
  protected int f = 0;
  protected int g = 0;
  protected int h = 0;
  protected int i = 0;
  protected int j = 0;
  protected int k = 0;
  protected int l = 0;
  protected int m = 0;
  protected int n = 0;
  protected int o = 0;
  protected int p = 0;
  protected int q = 0;
  protected int r = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 18, 14, 9, 12, 14, 18 };
    jdField_a_of_type_Int = jdField_a_of_type_ArrayOfInt.length;
    jdField_b_of_type_Int = 0;
    jdField_b_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
  }
  
  public QimMusicSeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView$SeekListener = null;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_b_of_type_AndroidGraphicsPaint = null;
    this.jdField_c_of_type_AndroidGraphicsPaint = null;
    this.jdField_d_of_type_AndroidGraphicsPaint = null;
    this.jdField_e_of_type_AndroidGraphicsPaint = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.p = ((int)DisplayUtils.a(paramContext, 8.0F));
    this.n = ((int)DisplayUtils.a(paramContext, 2.0F));
    this.o = ((int)DisplayUtils.a(paramContext, 2.0F));
    this.r = ((int)DisplayUtils.a(paramContext, 3.0F));
    jdField_b_of_type_Int = (int)DisplayUtils.a(paramContext, 4.0F);
    jdField_d_of_type_Int = (int)DisplayUtils.a(paramContext, 50.0F);
    jdField_c_of_type_Int = (int)DisplayUtils.a(paramContext, 36.0F);
    int i1 = 0;
    while (i1 < jdField_a_of_type_Int)
    {
      jdField_b_of_type_ArrayOfInt[i1] = ((int)DisplayUtils.a(paramContext, jdField_a_of_type_ArrayOfInt[i1]));
      i1 += 1;
    }
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131165535));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131166325));
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131167401));
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131165434));
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_e_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    super.setOnTouchListener(this);
  }
  
  public void a(int paramInt)
  {
    this.i = ((int)(paramInt / 1000 * (jdField_b_of_type_Int + this.n) * 2.5F));
    setPlayedPosition(-1);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, Paint paramPaint)
  {
    RectF localRectF = new RectF();
    localRectF.left = paramInt1;
    localRectF.top = paramInt2;
    localRectF.bottom = paramInt4;
    localRectF.right = paramInt3;
    paramCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, paramPaint);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    Rect localRect = new Rect();
    localRect.left = paramInt1;
    localRect.top = paramInt2;
    localRect.bottom = paramInt4;
    localRect.right = paramInt3;
    paramCanvas.drawRect(localRect, paramPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.q);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.q);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int i2 = 0;
    int i5;
    int i6;
    int i4;
    int i7;
    Paint localPaint;
    for (int i1 = 0; i1 < this.f; i1 = i3)
    {
      i5 = this.k;
      i6 = this.i;
      i3 = i1 + 1;
      i4 = i5 - i6 + jdField_b_of_type_Int * i3 + this.n * i1;
      i7 = this.g;
      if ((i4 > i5 + i7) && (i6 == this.h - i7)) {
        break;
      }
      if (i4 >= 0)
      {
        if (i4 > this.l) {
          break;
        }
        localPaint = this.jdField_c_of_type_AndroidGraphicsPaint;
        if ((this.jdField_a_of_type_Boolean) || (i4 <= this.jdField_a_of_type_AndroidGraphicsRect.left - this.n) || (i4 >= this.jdField_a_of_type_AndroidGraphicsRect.right))
        {
          i1 = jdField_b_of_type_ArrayOfInt[(i1 % jdField_a_of_type_Int)];
          i5 = (this.m - i1) / 2;
          a(paramCanvas, i4, i5, i4 + this.n, i5 + i1, 5.0F, localPaint);
        }
      }
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left - this.p, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right + this.p, this.jdField_a_of_type_AndroidGraphicsRect.bottom, 10.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_d_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top + this.o, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.o, this.jdField_d_of_type_AndroidGraphicsPaint);
    this.jdField_d_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.q);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.q);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int i3 = -1;
    i1 = i2;
    for (i2 = i3; i1 < this.f; i2 = i3)
    {
      i3 = this.k;
      i4 = this.i;
      i6 = i1 + 1;
      i5 = i3 - i4 + jdField_b_of_type_Int * i6 + this.n * i1;
      i7 = this.g;
      if ((i5 > i3 + i7) && (i4 == this.h - i7)) {
        return;
      }
      if (i5 < 0)
      {
        i3 = i2;
      }
      else
      {
        if (i5 > this.l) {
          return;
        }
        if ((!this.jdField_a_of_type_Boolean) && (i5 > this.jdField_a_of_type_AndroidGraphicsRect.left - this.n) && (i5 < this.jdField_a_of_type_AndroidGraphicsRect.right))
        {
          i4 = this.n + i5;
          if ((i5 < this.jdField_a_of_type_AndroidGraphicsRect.left) && (this.n + i5 > this.jdField_a_of_type_AndroidGraphicsRect.left))
          {
            i3 = this.jdField_a_of_type_AndroidGraphicsRect.left;
            i4 = this.n;
            i4 += i5;
          }
          else
          {
            i3 = i5;
          }
          if ((i5 < this.jdField_a_of_type_AndroidGraphicsRect.right) && (this.n + i5 > this.jdField_a_of_type_AndroidGraphicsRect.right))
          {
            i4 = this.jdField_a_of_type_AndroidGraphicsRect.right;
            i3 = i5;
          }
          if (i2 == -1) {
            i2 = i1;
          }
          if ((i1 >= i2) && (i1 < this.j + i2)) {
            localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
          } else {
            localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
          }
          i1 = jdField_b_of_type_ArrayOfInt[(i1 % jdField_a_of_type_Int)];
          i5 = (this.m - i1) / 2;
          a(paramCanvas, i3, i5, i4, i5 + i1, 5.0F, localPaint);
        }
        else
        {
          i3 = i2;
          if (!this.jdField_a_of_type_Boolean) {
            break label867;
          }
          i3 = i2;
          if (i5 <= this.jdField_a_of_type_AndroidGraphicsRect.left - this.n) {
            break label867;
          }
          i3 = i2;
          if (i5 >= this.jdField_a_of_type_AndroidGraphicsRect.right) {
            break label867;
          }
          if (i2 == -1) {
            i2 = i1;
          }
          localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
          i1 = jdField_b_of_type_ArrayOfInt[(i1 % jdField_a_of_type_Int)];
          i3 = (this.m - i1) / 2;
          a(paramCanvas, i5, i3, i5 + this.n, i3 + i1, 5.0F, localPaint);
        }
        i3 = i2;
      }
      label867:
      i1 = i6;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.l = super.getMeasuredWidth();
    this.m = (jdField_d_of_type_Int + super.getPaddingTop() + super.getPaddingBottom());
    setMeasuredDimension(this.l, this.m);
    paramInt2 = this.l;
    paramInt1 = this.g;
    this.k = ((paramInt2 - paramInt1) / 2);
    int i1 = this.m;
    paramInt2 = jdField_d_of_type_Int;
    i1 = (i1 - paramInt2) / 2;
    int i2 = this.k;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i2, i1, paramInt1 + i2, paramInt2 + i1);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView$SeekListener;
    if (localObject != null) {
      ((QimMusicSeekView.SeekListener)localObject).a(this.k, this.g);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeasure() mViewWidth: ");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append(", mViewHeight = ");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(", mVideoViewOffsetX = ");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append(", mMusicMaxWidth = ");
      ((StringBuilder)localObject).append(this.h);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return false;
        }
        this.jdField_a_of_type_Boolean = true;
        float f1 = paramMotionEvent.getX();
        if (Math.abs(f1 - this.jdField_a_of_type_Float) < 3.0F) {
          return true;
        }
        float f2 = (this.jdField_a_of_type_Float - f1) / (jdField_b_of_type_Int + this.n);
        i1 = Math.round(Math.abs(f2));
        if ((f2 > 0.0F) && (i1 >= 1)) {
          this.i += (jdField_b_of_type_Int + this.n) * i1;
        } else if ((f2 < 0.0F) && (i1 >= 1)) {
          this.i -= (jdField_b_of_type_Int + this.n) * i1;
        }
        if (i1 == 0) {
          return true;
        }
        if (this.i <= 0) {
          this.i = 0;
        }
        i1 = this.i;
        int i2 = this.h;
        int i3 = this.g;
        if (i1 >= i2 - i3) {
          this.i = (i2 - i3);
        }
        super.invalidate();
        paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView$SeekListener;
        if (paramView != null) {
          paramView.b(this.h, this.g, this.i);
        }
        this.jdField_a_of_type_Float = f1;
        return false;
      }
      this.jdField_a_of_type_Boolean = false;
      super.invalidate();
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView$SeekListener;
      if (paramView != null)
      {
        paramView.c(this.h, this.g, this.i);
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView$SeekListener;
      if (paramView != null) {
        paramView.a(this.h, this.g, this.i);
      }
    }
    return false;
  }
  
  public void setDurations(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = ((int)(paramInt1 * 2.5F));
    this.f = ((int)(paramInt2 * 2.5F));
    paramInt1 = jdField_b_of_type_Int;
    int i1 = this.jdField_e_of_type_Int;
    paramInt2 = this.n;
    this.g = (paramInt1 * i1 + (i1 - 1) * paramInt2);
    i1 = this.f;
    this.h = (paramInt1 * i1 + (i1 - 1) * paramInt2);
  }
  
  public void setOnSeekListener(QimMusicSeekView.SeekListener paramSeekListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView$SeekListener = paramSeekListener;
  }
  
  public void setPlayedPosition(int paramInt)
  {
    this.j = paramInt;
    super.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QimMusicSeekView
 * JD-Core Version:    0.7.0.1
 */