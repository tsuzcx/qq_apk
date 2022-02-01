package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class MusicHorizontalSeekView
  extends View
  implements View.OnTouchListener
{
  protected static final int a;
  protected static final int[] a;
  protected static int b;
  protected static int[] b;
  protected static int c;
  float a;
  protected Paint a;
  protected Rect a;
  protected MusicHorizontalSeekView.SeekListener a;
  protected boolean a;
  protected Paint b;
  protected Paint c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 6, 8, 10, 12, 12, 10, 8, 6 };
    jdField_a_of_type_Int = jdField_a_of_type_ArrayOfInt.length;
    jdField_b_of_type_Int = 0;
    jdField_b_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
    jdField_c_of_type_Int = 0;
  }
  
  public MusicHorizontalSeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener = null;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.m = 0;
    this.n = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    this.jdField_b_of_type_AndroidGraphicsPaint = null;
    this.jdField_c_of_type_AndroidGraphicsPaint = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.m = ((int)DisplayUtils.a(paramContext, 2.0F));
    this.n = ((int)DisplayUtils.a(paramContext, 1.0F));
    jdField_b_of_type_Int = (int)DisplayUtils.a(paramContext, 10.0F);
    jdField_c_of_type_Int = (int)DisplayUtils.a(paramContext, 21.0F);
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
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131166522));
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131166524));
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.n);
    super.setOnTouchListener(this);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 30) {
      jdField_b_of_type_Int = paramInt2 / (paramInt1 + 16);
    }
  }
  
  public void a(int paramInt)
  {
    this.h = (paramInt * jdField_b_of_type_Int / 1000);
    setPlayedPosition(-1);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint)
  {
    float f1 = paramInt1;
    paramCanvas.drawLine(f1, paramInt2, f1, paramInt3, paramPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.n);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.n);
    int i2 = 0;
    int i1 = -1;
    while (i2 < this.e)
    {
      int i3 = this.j;
      int i6 = this.h;
      int i4 = i2 + 1;
      int i5 = i3 - i6 + jdField_b_of_type_Int * i4;
      if ((i5 > i3 + this.f) && (i6 == this.g)) {
        break;
      }
      if (i5 >= 0)
      {
        if (i5 > this.k) {
          break;
        }
        Paint localPaint2 = this.jdField_c_of_type_AndroidGraphicsPaint;
        i3 = i1;
        Paint localPaint1 = localPaint2;
        if (!this.jdField_a_of_type_Boolean)
        {
          i3 = i1;
          localPaint1 = localPaint2;
          if (i5 > this.jdField_a_of_type_AndroidGraphicsRect.left)
          {
            i3 = i1;
            localPaint1 = localPaint2;
            if (i5 < this.jdField_a_of_type_AndroidGraphicsRect.right)
            {
              i3 = i1;
              if (i1 == -1) {
                i3 = i2;
              }
              if ((i2 >= i3) && (i2 < this.i + i3)) {
                localPaint1 = this.jdField_b_of_type_AndroidGraphicsPaint;
              } else {
                localPaint1 = this.jdField_a_of_type_AndroidGraphicsPaint;
              }
            }
          }
        }
        i1 = jdField_b_of_type_ArrayOfInt[(i2 % jdField_a_of_type_Int)];
        i2 = (this.l - i1) / 2;
        a(paramCanvas, i5, i2, i2 + i1, localPaint1);
        i1 = i3;
      }
      i2 = i4;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      i1 = this.i;
      if (i1 < this.d)
      {
        if (i1 == -1)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.m);
          a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
          a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
          break label519;
        }
        this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.m);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.m);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
        break label519;
      }
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.m);
    a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
    a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
    label519:
    QLog.isColorLevel();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.k = super.getMeasuredWidth();
    this.l = (jdField_c_of_type_Int + super.getPaddingTop() + super.getPaddingBottom());
    setMeasuredDimension(this.k, this.l);
    this.j = ((this.k - this.f) / 2);
    paramInt2 = this.l;
    paramInt1 = jdField_c_of_type_Int;
    paramInt2 = (paramInt2 - paramInt1) / 2;
    int i1 = this.j;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(i1, paramInt2, this.d * jdField_b_of_type_Int + i1, paramInt1 + paramInt2);
    MusicHorizontalSeekView.SeekListener localSeekListener = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener;
    if (localSeekListener != null) {
      localSeekListener.a(this.j, this.f);
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
        float f1 = paramMotionEvent.getX();
        if (Math.abs(f1 - this.jdField_a_of_type_Float) < 2.0F) {
          return true;
        }
        this.jdField_a_of_type_Boolean = true;
        float f2 = this.h;
        float f3 = this.jdField_a_of_type_Float;
        this.h = ((int)(f2 + (f3 - f1) / 2.0F));
        if (f1 > f3)
        {
          if (this.h <= jdField_b_of_type_Int)
          {
            this.h = 0;
            super.invalidate();
            paramView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener;
            if (paramView != null) {
              paramView.b(this.g, this.f, this.h);
            }
            this.jdField_a_of_type_Float = f1;
            return false;
          }
        }
        else
        {
          i1 = this.h;
          int i2 = this.g;
          int i3 = this.f;
          if (i1 >= i2 - i3)
          {
            this.h = (i2 - i3);
            super.invalidate();
            paramView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener;
            if (paramView != null) {
              paramView.b(this.g, this.f, this.h);
            }
            this.jdField_a_of_type_Float = f1;
            return false;
          }
        }
        super.invalidate();
        paramView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener;
        if (paramView != null) {
          paramView.b(this.g, this.f, this.h);
        }
        this.jdField_a_of_type_Float = f1;
        return false;
      }
      this.jdField_a_of_type_Boolean = false;
      super.invalidate();
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener;
      if (paramView != null)
      {
        paramView.c(this.g, this.f, this.h);
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener;
      if (paramView != null) {
        paramView.a(this.g, this.f, this.h);
      }
    }
    return false;
  }
  
  public void setDurations(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    paramInt1 = jdField_b_of_type_Int;
    this.f = (this.d * paramInt1);
    this.g = (paramInt1 * this.e);
  }
  
  public void setOnSeekListener(MusicHorizontalSeekView.SeekListener paramSeekListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener = paramSeekListener;
  }
  
  public void setPlayedPosition(int paramInt)
  {
    this.i = paramInt;
    super.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView
 * JD-Core Version:    0.7.0.1
 */