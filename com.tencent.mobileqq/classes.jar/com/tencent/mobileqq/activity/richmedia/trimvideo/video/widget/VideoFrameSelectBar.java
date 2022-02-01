package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.mobileqq.utils.ViewUtils;

public class VideoFrameSelectBar
  extends View
  implements FrameParent, FramesProcessor.OnMoveListener, RangeProcessor.OnRangeChangeListener
{
  private static final int c = ViewUtils.dip2px(13.0F);
  private RangeProcessor a;
  private FramesProcessor b;
  private float d;
  private float e;
  private int f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private boolean g;
  private boolean h;
  private boolean i;
  private float j;
  private float k;
  private int l = 3000;
  private float m = 0.0F;
  private float n = 0.0F;
  private float o = 0.0F;
  private Paint p = new Paint();
  private String q = "";
  private boolean r = false;
  private VideoFrameSelectBar.OnFramesClipChangeListener s;
  private float t;
  
  public VideoFrameSelectBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private float a(float paramFloat)
  {
    return paramFloat / this.k * this.l;
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    if (this.g)
    {
      this.a.a(paramMotionEvent);
      return;
    }
    if (this.h) {
      this.b.a(paramMotionEvent);
    }
  }
  
  private void h()
  {
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void i()
  {
    this.q = String.format("%.1f''", new Object[] { Float.valueOf(this.o / 1000.0F) });
    this.t = this.p.measureText(this.q);
    VideoFrameSelectBar.OnFramesClipChangeListener localOnFramesClipChangeListener = this.s;
    if (localOnFramesClipChangeListener != null) {
      localOnFramesClipChangeListener.a(this.o);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.n = a((int)(paramFloat1 - this.a.b()));
    this.o = a(paramFloat2 - paramFloat1);
    i();
    this.b.a((int)paramFloat1);
    this.b.b((int)paramFloat2);
    invalidate();
    VideoFrameSelectBar.OnFramesClipChangeListener localOnFramesClipChangeListener = this.s;
    if (localOnFramesClipChangeListener != null) {
      localOnFramesClipChangeListener.a((int)getSelectBeginTime(), (int)getSelectEndTime());
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.m = a(paramFloat1);
    i();
    Object localObject = this.a;
    if (localObject != null) {
      ((RangeProcessor)localObject).b(paramFloat2, paramFloat3);
    }
    localObject = this.s;
    if (localObject != null) {
      ((VideoFrameSelectBar.OnFramesClipChangeListener)localObject).a((int)getSelectBeginTime(), (int)getSelectEndTime());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    int i1;
    if (paramInt < 12000)
    {
      this.l = 2000;
      i1 = (int)Math.ceil(paramInt * 1.0F / 2000.0F);
    }
    else
    {
      this.l = (paramInt / 6);
      i1 = 6;
    }
    int i2 = getResources().getDisplayMetrics().widthPixels;
    float f1 = i2 * 0.925F / 6.0F;
    this.k = f1;
    this.j = f1;
    this.a = new RangeProcessor(this, this.k, this.j, i1, this.l, i2, paramInt);
    this.a.a(this);
    this.o = a(this.a.c());
    i();
    this.b = new FramesProcessor(this, paramString, paramInt, i1, this.k, this.j, i2, this.a.b(), this.l);
    this.b.a(this);
    this.p.setAntiAlias(true);
    this.r = true;
  }
  
  public boolean a()
  {
    return this.r;
  }
  
  void b()
  {
    this.i = true;
  }
  
  boolean c()
  {
    return this.i;
  }
  
  void d()
  {
    this.i = false;
  }
  
  public boolean e()
  {
    FramesProcessor localFramesProcessor = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFramesProcessor != null)
    {
      if (this.a == null) {
        return false;
      }
      if (!localFramesProcessor.b())
      {
        bool1 = bool2;
        if (!this.a.d()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void f()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((RangeProcessor)localObject).e();
    }
    localObject = this.b;
    if (localObject != null) {
      ((FramesProcessor)localObject).c();
    }
    this.r = false;
    this.m = 0.0F;
    this.n = 0.0F;
    this.o = 0.0F;
  }
  
  public void g()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((RangeProcessor)localObject).f();
    }
    localObject = this.b;
    if (localObject != null) {
      ((FramesProcessor)localObject).c();
    }
    this.q = "";
    this.r = false;
    this.m = 0.0F;
    this.n = 0.0F;
    this.o = 0.0F;
  }
  
  public float getFrameHeight()
  {
    return this.j;
  }
  
  public float getFrameWidth()
  {
    return this.k;
  }
  
  public float getSelectBeginTime()
  {
    return this.m + this.n;
  }
  
  public float getSelectEndTime()
  {
    return this.m + this.n + this.o;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return;
      }
      this.p.setTextSize(40.0F);
      this.p.setColor(-1);
      paramCanvas.translate(0.0F, c + 50);
      Object localObject = this.b;
      if (localObject != null) {
        ((FramesProcessor)localObject).a(paramCanvas);
      }
      localObject = this.a;
      if (localObject != null) {
        ((RangeProcessor)localObject).a(paramCanvas);
      }
      paramCanvas.translate(0.0F, -c - 50);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.a != null) && (this.b != null))
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), (int)(this.a.a() + 50.0F + c));
      return;
    }
    setMeasuredDimension(0, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = isEnabled();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (this.a != null)
    {
      if (this.b == null) {
        return false;
      }
      int i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 == 3)
            {
              if (c())
              {
                d();
                a(paramMotionEvent);
                setPressed(false);
              }
              invalidate();
            }
          }
          else if (c())
          {
            a(paramMotionEvent);
          }
          else if (Math.abs(paramMotionEvent.getX() - this.d) > this.f)
          {
            setPressed(true);
            invalidate();
            b();
            a(paramMotionEvent);
            h();
          }
        }
        else
        {
          if (c())
          {
            a(paramMotionEvent);
            d();
            setPressed(false);
          }
          else
          {
            b();
            a(paramMotionEvent);
            d();
          }
          invalidate();
        }
      }
      else
      {
        this.d = paramMotionEvent.getX();
        this.e = paramMotionEvent.getY();
        this.g = this.a.a(this.d, this.e - 50.0F);
        this.h = false;
        if ((!this.h) && (!this.g)) {
          return super.onTouchEvent(paramMotionEvent);
        }
        setPressed(true);
        invalidate();
        b();
        a(paramMotionEvent);
        h();
      }
      if (!this.h)
      {
        bool1 = bool2;
        if (!this.g) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void postInvalidate()
  {
    super.postInvalidate();
  }
  
  public void setOnFramesClipChangeListener(VideoFrameSelectBar.OnFramesClipChangeListener paramOnFramesClipChangeListener)
  {
    this.s = paramOnFramesClipChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */