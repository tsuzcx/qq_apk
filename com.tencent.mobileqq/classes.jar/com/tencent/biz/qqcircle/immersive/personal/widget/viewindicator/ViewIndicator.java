package com.tencent.biz.qqcircle.immersive.personal.widget.viewindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ViewIndicator
  extends LinearLayoutCompat
{
  private static final int a = Color.parseColor("#000000");
  private static final int b = Color.parseColor("#DC143C");
  private boolean A = false;
  private int c = 0;
  private boolean d;
  private boolean e;
  private int f;
  private float g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private final int p;
  private final int q;
  private final ArrayList<Integer> r = new ArrayList();
  private final int s;
  private float t = 0.0F;
  private float u = 0.0F;
  private Paint v;
  private Path w;
  private final Set<ViewIndicator.TextItemClickListener> x = new HashSet();
  private final Set<ViewPager> y = new HashSet();
  private final Set<ViewPager2> z = new HashSet();
  
  public ViewIndicator(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewIndicator(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setGravity(16);
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = localDisplayMetrics.widthPixels;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ft);
    this.f = paramContext.getInt(R.styleable.fJ, 4);
    this.n = (i1 / this.f);
    this.n = paramContext.getDimensionPixelSize(R.styleable.fC, this.n);
    this.h = paramContext.getDimensionPixelSize(R.styleable.fB, 0);
    this.g = paramContext.getDimensionPixelSize(R.styleable.fH, 14);
    this.i = paramContext.getInt(R.styleable.fI, 0);
    this.j = paramContext.getInt(R.styleable.fG, 17);
    this.d = paramContext.getBoolean(R.styleable.fF, true);
    this.k = paramContext.getInt(R.styleable.fD, a);
    this.l = paramContext.getInt(R.styleable.fE, b);
    this.m = paramContext.getInt(R.styleable.fz, 1);
    this.s = paramContext.getInt(R.styleable.fu, this.l);
    this.q = paramContext.getDimensionPixelSize(R.styleable.fx, 5);
    this.e = paramContext.getBoolean(R.styleable.fv, true);
    float f1 = paramContext.getFloat(R.styleable.fy, 1.0F);
    this.o = ((int)(this.n * f1));
    this.o = paramContext.getDimensionPixelSize(R.styleable.fA, this.o);
    this.p = paramContext.getDimensionPixelSize(R.styleable.fw, 4);
    paramContext.recycle();
    a();
    b();
    this.t = getPaddingLeft();
  }
  
  private void a()
  {
    this.v = new Paint();
    this.v.setAntiAlias(true);
    this.v.setColor(this.s);
    this.v.setStyle(Paint.Style.FILL);
    this.v.setTextSize(this.g);
    this.v.setPathEffect(new CornerPathEffect(3.0F));
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (paramInt >= getChildCount()) {
      return;
    }
    if (this.d)
    {
      ((ColorTrackTextView)getChildAt(paramInt)).a(paramFloat, true);
      if (paramInt < getChildCount() - 1) {
        ((ColorTrackTextView)getChildAt(paramInt + 1)).a(paramFloat, false);
      }
    }
    a(paramInt, Float.valueOf(paramFloat));
    postInvalidate();
  }
  
  private void a(int paramInt, Float paramFloat)
  {
    if (this.r.isEmpty()) {
      return;
    }
    int i1 = ((Integer)this.r.get(paramInt)).intValue();
    float f1 = i1;
    this.u = f1;
    paramInt += 1;
    if (paramInt < this.r.size())
    {
      paramInt = ((Integer)this.r.get(paramInt)).intValue();
      this.u = (f1 + paramFloat.floatValue() * (paramInt - i1));
    }
  }
  
  private void b()
  {
    this.w = new Path();
    RectF localRectF = new RectF(0.0F, 0.0F, this.o, this.p);
    Path localPath = this.w;
    int i1 = this.p;
    localPath.addRoundRect(localRectF, i1 / 2, i1 / 2, Path.Direction.CW);
  }
  
  private void setText(int paramInt)
  {
    this.c = paramInt;
    int i1 = 0;
    while (i1 < getChildCount())
    {
      Object localObject;
      if (this.d)
      {
        localObject = (ColorTrackTextView)getChildAt(i1);
        float f1;
        if (i1 == paramInt) {
          f1 = 1.0F;
        } else {
          f1 = -1.0F;
        }
        ((ColorTrackTextView)localObject).a(f1, false);
      }
      else
      {
        localObject = (TextView)getChildAt(i1);
        int i2;
        if (i1 == paramInt) {
          i2 = this.l;
        } else {
          i2 = this.k;
        }
        ((TextView)localObject).setTextColor(i2);
      }
      i1 += 1;
    }
    a(paramInt, 0.0F);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.r.size() > 1) && (this.m != 0) && (paramCanvas != null))
    {
      paramCanvas.save();
      paramCanvas.translate(this.t + this.u - this.o / 2, getHeight() - this.p - this.q);
      paramCanvas.drawPath(this.w, this.v);
      paramCanvas.restore();
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.r.clear();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < getChildCount(); paramInt2 = paramInt3)
    {
      paramInt3 = getChildAt(paramInt1).getMeasuredWidth() - this.h;
      if (paramInt1 == 0)
      {
        this.r.add(Integer.valueOf(paramInt3 / 2));
      }
      else
      {
        ArrayList localArrayList = this.r;
        localArrayList.add(Integer.valueOf(((Integer)localArrayList.get(paramInt1 - 1)).intValue() + paramInt2 / 2 + paramInt3 / 2 + this.h));
      }
      paramInt1 += 1;
    }
    setText(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.viewindicator.ViewIndicator
 * JD-Core Version:    0.7.0.1
 */