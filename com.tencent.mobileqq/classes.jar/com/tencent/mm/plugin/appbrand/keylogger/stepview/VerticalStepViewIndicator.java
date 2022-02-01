package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;

public class VerticalStepViewIndicator
  extends View
{
  private final String a = getClass().getSimpleName();
  private int b = (int)TypedValue.applyDimension(1, 40.0F, getResources().getDisplayMetrics());
  private float c;
  private float d;
  private Drawable e;
  private Drawable f;
  private Drawable g;
  private Drawable h;
  private float i;
  private float j;
  private float k;
  private List<c> l = new ArrayList();
  private float m;
  private List<Float> n;
  private Paint o;
  private Paint p;
  private int q = ContextCompat.getColor(getContext(), 2131168414);
  private int r = -1;
  private PathEffect s;
  private int t;
  private Path u;
  private VerticalStepViewIndicator.a v;
  private Rect w;
  private int x;
  private boolean y;
  
  public VerticalStepViewIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.u = new Path();
    this.s = new DashPathEffect(new float[] { 8.0F, 8.0F, 8.0F, 8.0F }, 1.0F);
    this.n = new ArrayList();
    this.o = new Paint();
    this.p = new Paint();
    this.o.setAntiAlias(true);
    this.o.setColor(this.q);
    this.o.setStyle(Paint.Style.STROKE);
    this.o.setStrokeWidth(2.0F);
    this.p.setAntiAlias(true);
    this.p.setColor(this.r);
    this.p.setStyle(Paint.Style.STROKE);
    this.p.setStrokeWidth(2.0F);
    this.o.setPathEffect(this.s);
    this.p.setStyle(Paint.Style.FILL);
    int i1 = this.b;
    this.c = (i1 * 0.05F);
    this.d = (i1 * 0.28F);
    this.m = (i1 * 0.85F);
    this.e = ContextCompat.getDrawable(getContext(), 2130852652);
    this.f = ContextCompat.getDrawable(getContext(), 2130852649);
    this.g = ContextCompat.getDrawable(getContext(), 2130852653);
    this.h = ContextCompat.getDrawable(getContext(), 2130852651);
    this.y = true;
  }
  
  public List<Float> getCircleCenterPointPositionList()
  {
    return this.n;
  }
  
  public float getCircleRadius()
  {
    return this.d;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Log.i(this.a, "onDraw");
    Object localObject = this.v;
    if (localObject != null) {
      ((VerticalStepViewIndicator.a)localObject).a();
    }
    this.o.setColor(this.q);
    this.p.setColor(this.r);
    int i3 = 0;
    int i2;
    float f1;
    float f2;
    float f3;
    for (int i1 = 0;; i1 = i2)
    {
      i2 = i3;
      if (i1 >= this.n.size() - 1) {
        break;
      }
      f1 = ((Float)this.n.get(i1)).floatValue();
      localObject = this.n;
      i2 = i1 + 1;
      f2 = ((Float)((List)localObject).get(i2)).floatValue();
      if (i1 < this.t)
      {
        float f4;
        if (this.y)
        {
          f3 = this.j;
          f4 = this.d;
          paramCanvas.drawRect(f3, f2 + f4 - 10.0F, this.k, f1 - f4 + 10.0F, this.p);
        }
        else
        {
          f3 = this.j;
          f4 = this.d;
          paramCanvas.drawRect(f3, f1 + f4 - 10.0F, this.k, f2 - f4 + 10.0F, this.p);
        }
      }
      else if (this.y)
      {
        this.u.moveTo(this.i, f2 + this.d);
        this.u.lineTo(this.i, f1 - this.d);
        paramCanvas.drawPath(this.u, this.o);
      }
      else
      {
        this.u.moveTo(this.i, f1 + this.d);
        this.u.lineTo(this.i, f2 - this.d);
        paramCanvas.drawPath(this.u, this.o);
      }
    }
    while (i2 < this.n.size())
    {
      f1 = ((Float)this.n.get(i2)).floatValue();
      f2 = this.i;
      f3 = this.d;
      this.w = new Rect((int)(f2 - f3), (int)(f1 - f3), (int)(f2 + f3), (int)(f1 + f3));
      i1 = ((c)this.l.get(i2)).b();
      if (i1 == 0)
      {
        this.e.setBounds(this.w);
        this.e.draw(paramCanvas);
      }
      else if (i1 == 2)
      {
        this.f.setBounds(this.w);
        this.f.draw(paramCanvas);
      }
      else if (i1 == -2)
      {
        this.g.setBounds(this.w);
        this.g.draw(paramCanvas);
      }
      else
      {
        this.h.setBounds(this.w);
        this.h.draw(paramCanvas);
      }
      i2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Log.i(this.a, "onMeasure");
    int i1 = this.b;
    this.x = 0;
    paramInt2 = this.l.size();
    if (paramInt2 > 0) {
      this.x = ((int)(getPaddingTop() + getPaddingBottom() + this.d * 2.0F * paramInt2 + (paramInt2 - 1) * this.m));
    }
    paramInt2 = i1;
    if (View.MeasureSpec.getMode(paramInt1) != 0) {
      paramInt2 = Math.min(i1, View.MeasureSpec.getSize(paramInt1));
    }
    setMeasuredDimension(paramInt2, this.x);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i(this.a, "onSizeChanged");
    this.i = (getWidth() / 2);
    float f1 = this.i;
    float f2 = this.c;
    this.j = (f1 - f2 / 2.0F);
    this.k = (f1 + f2 / 2.0F);
    paramInt1 = 0;
    while (paramInt1 < this.l.size())
    {
      if (this.y)
      {
        localObject = this.n;
        f1 = this.x;
        f2 = this.d;
        float f3 = paramInt1;
        ((List)localObject).add(Float.valueOf(f1 - (f2 + f3 * f2 * 2.0F + f3 * this.m)));
      }
      else
      {
        localObject = this.n;
        f1 = this.d;
        f2 = paramInt1;
        ((List)localObject).add(Float.valueOf(f1 + f2 * f1 * 2.0F + f2 * this.m));
      }
      paramInt1 += 1;
    }
    Object localObject = this.v;
    if (localObject != null) {
      ((VerticalStepViewIndicator.a)localObject).a();
    }
  }
  
  public void setAttentionIcon(Drawable paramDrawable)
  {
    this.f = paramDrawable;
  }
  
  public void setComplectingPosition(int paramInt)
  {
    this.t = paramInt;
    requestLayout();
  }
  
  public void setCompleteIcon(Drawable paramDrawable)
  {
    this.e = paramDrawable;
  }
  
  public void setCompletedLineColor(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setDefaultIcon(Drawable paramDrawable)
  {
    this.g = paramDrawable;
  }
  
  public void setIndicatorLinePaddingProportion(float paramFloat)
  {
    this.m = (paramFloat * this.b);
  }
  
  public void setOnDrawListener(VerticalStepViewIndicator.a parama)
  {
    this.v = parama;
  }
  
  public void setSteps(List<c> paramList)
  {
    if (paramList == null)
    {
      this.l = new ArrayList();
      return;
    }
    this.l = paramList;
    requestLayout();
  }
  
  public void setUnCompletedLineColor(int paramInt)
  {
    this.q = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator
 * JD-Core Version:    0.7.0.1
 */