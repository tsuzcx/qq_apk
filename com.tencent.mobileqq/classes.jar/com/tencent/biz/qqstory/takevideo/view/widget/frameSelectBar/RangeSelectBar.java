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
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private float j;
  private int k;
  private int l;
  private Paint m;
  private Paint n;
  private boolean o = false;
  private boolean p = false;
  private int q;
  private Bitmap r;
  private Bitmap s;
  private RangeSelectBar.RangeChangeListener t;
  private int u = Color.rgb(32, 170, 239);
  private float v;
  
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
    this.q = DisplayUtil.a(getContext(), ScrollFrameSelectBar.a);
    this.g = UIUtils.b(getContext());
    this.m = new Paint(1);
    this.m.setColor(this.u);
    this.m.setStyle(Paint.Style.FILL);
    this.n = new Paint();
    this.n.setColor(-16777216);
    this.n.setAlpha(80);
    this.n.setStyle(Paint.Style.FILL);
  }
  
  public float getEndFloat()
  {
    return this.j;
  }
  
  public int getEndIndex()
  {
    return this.i;
  }
  
  public int getPadding()
  {
    return this.q;
  }
  
  public int getStartIndex()
  {
    return this.h;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = this.h;
    int i2 = this.q;
    if (i1 > i2 * 2) {
      paramCanvas.drawRect(i2, 0.0F, i1, this.d, this.n);
    }
    i1 = this.i;
    i2 = this.l;
    if (i1 < i2 - this.q) {
      paramCanvas.drawRect(i1, 0.0F, i2, this.d, this.n);
    }
    paramCanvas.drawBitmap(this.r, this.h - this.q, 0.0F, this.m);
    paramCanvas.drawBitmap(this.s, this.i, 0.0F, this.m);
    paramCanvas.drawRect(this.h, 0.0F, this.i, a, this.m);
    float f1 = this.h;
    i1 = this.d;
    paramCanvas.drawRect(f1, i1 - a, this.i, i1, this.m);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.b = View.MeasureSpec.getSize(paramInt1);
    this.c = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
          SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_CANCEL");
          if ((!this.o) && (!this.p))
          {
            this.o = false;
            this.p = false;
            return false;
          }
          this.o = false;
          this.p = false;
          return true;
        }
        paramMotionEvent.getX();
        f1 = this.v;
        if (this.o)
        {
          if (this.i - (int)paramMotionEvent.getX() < this.f)
          {
            SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex不能再截取小于1s的视频");
            this.h = (this.i - this.f);
            invalidate();
          }
          else if (paramMotionEvent.getX() <= this.k)
          {
            SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "向左边边滑动");
            this.h = this.k;
            invalidate();
          }
          else
          {
            this.h = ((int)paramMotionEvent.getX());
            invalidate();
          }
        }
        else if (this.p) {
          if ((int)paramMotionEvent.getX() - this.h < this.f)
          {
            SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "mEndIndex不能再截取小于1s的视频");
            this.i = (this.h + this.f);
            invalidate();
          }
          else
          {
            f1 = paramMotionEvent.getX();
            i1 = this.l;
            if (f1 >= i1)
            {
              this.i = i1;
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
        paramMotionEvent = this.t;
        if (paramMotionEvent != null) {
          paramMotionEvent.b();
        }
        return true;
      }
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_UP");
      if ((!this.o) && (!this.p))
      {
        this.o = false;
        this.p = false;
        return false;
      }
      this.o = false;
      this.p = false;
      paramMotionEvent = this.t;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(this.h - 20, this.i - 20);
      }
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.v = f1;
    SLog.a("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_DOWN x=%s,y=%s,mstart=%s,end=%s", Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.h), Integer.valueOf(this.i));
    i1 = this.h;
    int i2 = this.q;
    if ((f1 > i1 - i2 / 2 - 40) && (f1 < i1 - i2 / 2 + 40))
    {
      this.o = true;
      return true;
    }
    i1 = this.i;
    i2 = this.q;
    if ((f1 > i2 / 2 + i1 - 40) && (f1 < i1 + i2 / 2 + 40))
    {
      this.p = true;
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
    int i1 = this.l;
    if (paramInt >= i1)
    {
      this.i = i1;
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "向右边边滑动");
      return;
    }
    this.i = paramInt;
  }
  
  public void setFrameSize(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    int i2 = this.q;
    int i1 = i2;
    if (i2 <= 0) {
      i1 = 100;
    }
    this.q = i1;
    this.d = paramInt1;
    this.e = paramInt2;
    float f1 = paramInt2;
    this.f = ((int)(f1 / (paramInt3 / paramFloat2)));
    Object localObject = getContext().getResources();
    paramInt3 = this.q / 2;
    i1 = paramInt1 / 2;
    localObject = UIUtils.a((Resources)localObject, 2130851112, paramInt3, i1);
    Bitmap localBitmap = UIUtils.a(getContext().getResources(), 2130851114, this.q / 2, i1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.u);
    localGradientDrawable.setCornerRadii(new float[] { 5.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 5.0F });
    localGradientDrawable.setStroke(DisplayUtil.a(getContext(), 3.0F), this.u);
    localGradientDrawable.setBounds(0, 0, this.q, paramInt1);
    this.r = Bitmap.createBitmap(this.q, paramInt1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(this.r);
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    localGradientDrawable.draw(localCanvas);
    if (localObject != null) {
      localCanvas.drawBitmap((Bitmap)localObject, (this.q - ((Bitmap)localObject).getWidth()) / 2, (paramInt1 - ((Bitmap)localObject).getHeight()) / 2, this.m);
    }
    this.s = Bitmap.createBitmap(this.q, paramInt1, Bitmap.Config.ARGB_8888);
    localCanvas.setBitmap(this.s);
    localGradientDrawable.setCornerRadii(new float[] { 0.0F, 0.0F, 5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F });
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    localGradientDrawable.draw(localCanvas);
    if (localBitmap != null) {
      localCanvas.drawBitmap(localBitmap, (this.q - localBitmap.getWidth()) / 2, (paramInt1 - localBitmap.getHeight()) / 2, this.m);
    }
    paramInt1 = this.q;
    this.h = paramInt1;
    double d1 = paramInt1;
    double d2 = Math.ceil(paramFloat1);
    double d3 = paramInt2;
    Double.isNaN(d3);
    Double.isNaN(d1);
    this.i = ((int)(d1 + d2 * d3));
    this.j = (this.q + paramFloat1 * f1);
    this.k = this.h;
    this.l = this.i;
  }
  
  public void setRangeChangeListener(RangeSelectBar.RangeChangeListener paramRangeChangeListener)
  {
    this.t = paramRangeChangeListener;
  }
  
  public void setStartIndex(int paramInt)
  {
    if (this.i - paramInt < this.f)
    {
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex不能再截取小于1s的视频");
      this.h = (this.i - this.f);
      return;
    }
    if (paramInt <= this.k)
    {
      SLog.b("Q.qqstory.frameWidget.RangeSelectBar", "向左边边滑动");
      this.h = this.k;
      return;
    }
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.RangeSelectBar
 * JD-Core Version:    0.7.0.1
 */