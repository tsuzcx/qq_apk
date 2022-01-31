package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.util.DisplayUtil;

public class RangeSelectBar
  extends View
{
  public static int a;
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RangeSelectBar.RangeChangeListener jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar$RangeChangeListener;
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
  private int m = Color.parseColor("#298be7");
  
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
    this.l = DisplayUtil.a(getContext(), ScrollFrameSelectBar.jdField_a_of_type_Int);
    this.g = UIUtils.a(getContext());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.m);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(1226998);
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.h - this.l, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.i, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.h, 0.0F, this.i, jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.h, this.d - jdField_a_of_type_Int, this.i, this.d, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(0.0F, 0.0F, this.h - this.l, this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.i + this.l, 0.0F, this.jdField_b_of_type_Int, this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
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
      SLog.a("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_DOWN x=%s,y=%s,mstart=%s,end=%s", Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.h), Integer.valueOf(this.i));
      if ((f1 > this.h - this.l / 2 - 30) && (f1 < this.h - this.l / 2 + 30))
      {
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
      if ((f1 > this.i + this.l / 2 - 30) && (f1 < this.i + this.l / 2 + 30))
      {
        this.jdField_b_of_type_Boolean = true;
        return true;
      }
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "没有触摸到");
      continue;
      paramMotionEvent.getX();
      f1 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_Boolean) {
        if (this.i - (int)paramMotionEvent.getX() < this.f)
        {
          SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex不能再截取小于1s的视频");
          this.h = (this.i - this.f);
          invalidate();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar$RangeChangeListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar$RangeChangeListener.a();
        }
        return true;
        if (paramMotionEvent.getX() <= this.j)
        {
          SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "向左边边滑动");
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
              SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "mEndIndex不能再截取小于1s的视频");
              this.i = (this.h + this.f);
              invalidate();
            }
            else if (paramMotionEvent.getX() >= this.k)
            {
              this.i = this.k;
              SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "向右边边滑动");
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
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_UP");
      if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar$RangeChangeListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar$RangeChangeListener.a(this.h - 20, this.i - 20);
        }
        return true;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      continue;
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_CANCEL");
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
  
  public void setFrameSize(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = ((int)(paramInt2 / (paramInt3 / 1000.0F)));
    Bitmap localBitmap1 = UIUtils.a(getContext().getResources(), 2130845151, this.l / 2, paramInt1 / 2);
    Bitmap localBitmap2 = UIUtils.a(getContext().getResources(), 2130845153, this.l / 2, paramInt1 / 2);
    ColorDrawable localColorDrawable = new ColorDrawable(this.m);
    localColorDrawable.setBounds(0, 0, this.l, paramInt1);
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.l, paramInt1, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localColorDrawable.draw(localCanvas);
    if (localBitmap1 != null) {
      localCanvas.drawBitmap(localBitmap1, (this.l - localBitmap1.getWidth()) / 2, (paramInt1 - localBitmap1.getHeight()) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.l, paramInt1, Bitmap.Config.RGB_565);
    localCanvas.setBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    localColorDrawable.draw(localCanvas);
    if (localBitmap2 != null) {
      localCanvas.drawBitmap(localBitmap2, (this.l - localBitmap2.getWidth()) / 2, (paramInt1 - localBitmap2.getHeight()) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.h = this.l;
    this.i = ((int)(this.l + Math.ceil(paramFloat) * paramInt2));
    this.jdField_a_of_type_Float = (this.l + paramInt2 * paramFloat);
    this.j = this.h;
    this.k = this.i;
  }
  
  public void setRangeChangeListener(RangeSelectBar.RangeChangeListener paramRangeChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar$RangeChangeListener = paramRangeChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.RangeSelectBar
 * JD-Core Version:    0.7.0.1
 */