package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import bcwh;
import wsv;
import xkt;
import xod;

public class RangeSelectBar
  extends View
{
  public static int a;
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private xkt jdField_a_of_type_Xkt;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m = Color.rgb(32, 170, 239);
  
  static
  {
    jdField_a_of_type_Int = 4;
  }
  
  public RangeSelectBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RangeSelectBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RangeSelectBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.l = bcwh.a(getContext(), ScrollFrameSelectBar.jdField_a_of_type_Int);
    this.g = xod.a(getContext());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.m);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(80);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  public int a()
  {
    return this.h;
  }
  
  public int b()
  {
    return this.i;
  }
  
  public int c()
  {
    return this.l;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.h > this.l * 2) {
      paramCanvas.drawRect(this.l, 0.0F, this.h, this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    if (this.i < this.k - this.l) {
      paramCanvas.drawRect(this.i, 0.0F, this.k, this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.h - this.l, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.i, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.h, 0.0F, this.i, jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.h, this.d - jdField_a_of_type_Int, this.i, this.d, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = View.MeasureSpec.getSize(paramInt1);
    this.c = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.jdField_b_of_type_Float = f1;
      wsv.a("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_DOWN x=%s,y=%s,mstart=%s,end=%s", Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.h), Integer.valueOf(this.i));
      if ((f1 > this.h - this.l / 2 - 40) && (f1 < this.h - this.l / 2 + 40))
      {
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
      if ((f1 > this.i + this.l / 2 - 40) && (f1 < this.i + this.l / 2 + 40))
      {
        this.jdField_b_of_type_Boolean = true;
        return true;
      }
      wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "没有触摸到");
      continue;
      paramMotionEvent.getX();
      f1 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_Boolean) {
        if (this.i - (int)paramMotionEvent.getX() < this.f)
        {
          wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex不能再截取小于1s的视频");
          this.h = (this.i - this.f);
          invalidate();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Xkt != null) {
          this.jdField_a_of_type_Xkt.a();
        }
        return true;
        if (paramMotionEvent.getX() <= this.j)
        {
          wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "向左边边滑动");
          this.h = this.j;
          invalidate();
        }
        else
        {
          this.h = ((int)paramMotionEvent.getX());
          invalidate();
          continue;
          if (this.jdField_b_of_type_Boolean) {
            if ((int)paramMotionEvent.getX() - this.h < this.f)
            {
              wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "mEndIndex不能再截取小于1s的视频");
              this.i = (this.h + this.f);
              invalidate();
            }
            else if (paramMotionEvent.getX() >= this.k)
            {
              this.i = this.k;
              wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "向右边边滑动");
              invalidate();
            }
            else
            {
              this.i = ((int)paramMotionEvent.getX());
              invalidate();
            }
          }
        }
      }
      wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_UP");
      if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_Xkt != null) {
          this.jdField_a_of_type_Xkt.a(this.h - 20, this.i - 20);
        }
        return true;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      continue;
      wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_CANCEL");
      if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        return true;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void setEndIndex(int paramInt)
  {
    if (paramInt - this.h < this.f)
    {
      wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "mEndIndex不能再截取小于1s的视频");
      this.i = (this.h + this.f);
      return;
    }
    if (paramInt >= this.k)
    {
      this.i = this.k;
      wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "向右边边滑动");
      return;
    }
    this.i = paramInt;
  }
  
  public void setFrameSize(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    if (this.l <= 0) {}
    for (int n = 100;; n = this.l)
    {
      this.l = n;
      this.d = paramInt1;
      this.e = paramInt2;
      this.f = ((int)(paramInt2 / (paramInt3 / paramFloat2)));
      Bitmap localBitmap1 = xod.a(getContext().getResources(), 2130848591, this.l / 2, paramInt1 / 2);
      Bitmap localBitmap2 = xod.a(getContext().getResources(), 2130848593, this.l / 2, paramInt1 / 2);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(this.m);
      localGradientDrawable.setCornerRadii(new float[] { 5.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 5.0F });
      localGradientDrawable.setStroke(bcwh.a(getContext(), 3.0F), this.m);
      localGradientDrawable.setBounds(0, 0, this.l, paramInt1);
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.l, paramInt1, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localGradientDrawable.draw(localCanvas);
      if (localBitmap1 != null) {
        localCanvas.drawBitmap(localBitmap1, (this.l - localBitmap1.getWidth()) / 2, (paramInt1 - localBitmap1.getHeight()) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.l, paramInt1, Bitmap.Config.ARGB_8888);
      localCanvas.setBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
      localGradientDrawable.setCornerRadii(new float[] { 0.0F, 0.0F, 5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F });
      localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localGradientDrawable.draw(localCanvas);
      if (localBitmap2 != null) {
        localCanvas.drawBitmap(localBitmap2, (this.l - localBitmap2.getWidth()) / 2, (paramInt1 - localBitmap2.getHeight()) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.h = this.l;
      this.i = ((int)(this.l + Math.ceil(paramFloat1) * paramInt2));
      this.jdField_a_of_type_Float = (this.l + paramInt2 * paramFloat1);
      this.j = this.h;
      this.k = this.i;
      return;
    }
  }
  
  public void setRangeChangeListener(xkt paramxkt)
  {
    this.jdField_a_of_type_Xkt = paramxkt;
  }
  
  public void setStartIndex(int paramInt)
  {
    if (this.i - paramInt < this.f)
    {
      wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex不能再截取小于1s的视频");
      this.h = (this.i - this.f);
      return;
    }
    if (paramInt <= this.j)
    {
      wsv.b("Q.qqstory.frameWidget.RangeSelectBar", "向左边边滑动");
      this.h = this.j;
      return;
    }
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.RangeSelectBar
 * JD-Core Version:    0.7.0.1
 */