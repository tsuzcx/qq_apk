package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.util.DisplayUtil;

public class RangeSelectBar
  extends View
{
  public static int a = 4;
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RangeSelectBar.RangeChangeListener jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar$RangeChangeListener;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean = false;
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
    int n = this.h;
    int i1 = this.l;
    if (n > i1 * 2) {
      paramCanvas.drawRect(i1, 0.0F, n, this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    n = this.i;
    i1 = this.k;
    if (n < i1 - this.l) {
      paramCanvas.drawRect(n, 0.0F, i1, this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.h - this.l, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.i, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.h, 0.0F, this.i, jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    float f1 = this.h;
    n = this.d;
    paramCanvas.drawRect(f1, n - jdField_a_of_type_Int, this.i, n, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = View.MeasureSpec.getSize(paramInt1);
    this.c = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction();
    if (n != 0)
    {
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3) {
            return false;
          }
          SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_CANCEL");
          if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
          {
            this.jdField_a_of_type_Boolean = false;
            this.jdField_b_of_type_Boolean = false;
            return false;
          }
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_Boolean = false;
          return true;
        }
        paramMotionEvent.getX();
        f1 = this.jdField_b_of_type_Float;
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.i - (int)paramMotionEvent.getX() < this.f)
          {
            SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex不能再截取小于1s的视频");
            this.h = (this.i - this.f);
            invalidate();
          }
          else if (paramMotionEvent.getX() <= this.j)
          {
            SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "向左边边滑动");
            this.h = this.j;
            invalidate();
          }
          else
          {
            this.h = ((int)paramMotionEvent.getX());
            invalidate();
          }
        }
        else if (this.jdField_b_of_type_Boolean) {
          if ((int)paramMotionEvent.getX() - this.h < this.f)
          {
            SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "mEndIndex不能再截取小于1s的视频");
            this.i = (this.h + this.f);
            invalidate();
          }
          else
          {
            f1 = paramMotionEvent.getX();
            n = this.k;
            if (f1 >= n)
            {
              this.i = n;
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
        paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar$RangeChangeListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.b();
        }
        return true;
      }
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_UP");
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        return false;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar$RangeChangeListener;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(this.h - 20, this.i - 20);
      }
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.jdField_b_of_type_Float = f1;
    SLog.a("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_DOWN x=%s,y=%s,mstart=%s,end=%s", Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.h), Integer.valueOf(this.i));
    n = this.h;
    int i1 = this.l;
    if ((f1 > n - i1 / 2 - 40) && (f1 < n - i1 / 2 + 40))
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    n = this.i;
    i1 = this.l;
    if ((f1 > i1 / 2 + n - 40) && (f1 < n + i1 / 2 + 40))
    {
      this.jdField_b_of_type_Boolean = true;
      return true;
    }
    SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "没有触摸到");
    return false;
  }
  
  public void setEndIndex(int paramInt)
  {
    if (paramInt - this.h < this.f)
    {
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "mEndIndex不能再截取小于1s的视频");
      this.i = (this.h + this.f);
      return;
    }
    int n = this.k;
    if (paramInt >= n)
    {
      this.i = n;
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "向右边边滑动");
      return;
    }
    this.i = paramInt;
  }
  
  public void setFrameSize(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    int i1 = this.l;
    int n = i1;
    if (i1 <= 0) {
      n = 100;
    }
    this.l = n;
    this.d = paramInt1;
    this.e = paramInt2;
    float f1 = paramInt2;
    this.f = ((int)(f1 / (paramInt3 / paramFloat2)));
    Object localObject = getContext().getResources();
    paramInt3 = this.l / 2;
    n = paramInt1 / 2;
    localObject = UIUtils.a((Resources)localObject, 2130849428, paramInt3, n);
    Bitmap localBitmap = UIUtils.a(getContext().getResources(), 2130849430, this.l / 2, n);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.m);
    localGradientDrawable.setCornerRadii(new float[] { 5.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 5.0F });
    localGradientDrawable.setStroke(DisplayUtil.a(getContext(), 3.0F), this.m);
    localGradientDrawable.setBounds(0, 0, this.l, paramInt1);
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.l, paramInt1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    localGradientDrawable.draw(localCanvas);
    if (localObject != null) {
      localCanvas.drawBitmap((Bitmap)localObject, (this.l - ((Bitmap)localObject).getWidth()) / 2, (paramInt1 - ((Bitmap)localObject).getHeight()) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.l, paramInt1, Bitmap.Config.ARGB_8888);
    localCanvas.setBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    localGradientDrawable.setCornerRadii(new float[] { 0.0F, 0.0F, 5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F });
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    localGradientDrawable.draw(localCanvas);
    if (localBitmap != null) {
      localCanvas.drawBitmap(localBitmap, (this.l - localBitmap.getWidth()) / 2, (paramInt1 - localBitmap.getHeight()) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    paramInt1 = this.l;
    this.h = paramInt1;
    double d1 = paramInt1;
    double d2 = Math.ceil(paramFloat1);
    double d3 = paramInt2;
    Double.isNaN(d3);
    Double.isNaN(d1);
    this.i = ((int)(d1 + d2 * d3));
    this.jdField_a_of_type_Float = (this.l + paramFloat1 * f1);
    this.j = this.h;
    this.k = this.i;
  }
  
  public void setRangeChangeListener(RangeSelectBar.RangeChangeListener paramRangeChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar$RangeChangeListener = paramRangeChangeListener;
  }
  
  public void setStartIndex(int paramInt)
  {
    if (this.i - paramInt < this.f)
    {
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex不能再截取小于1s的视频");
      this.h = (this.i - this.f);
      return;
    }
    if (paramInt <= this.j)
    {
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "向左边边滑动");
      this.h = this.j;
      return;
    }
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.RangeSelectBar
 * JD-Core Version:    0.7.0.1
 */