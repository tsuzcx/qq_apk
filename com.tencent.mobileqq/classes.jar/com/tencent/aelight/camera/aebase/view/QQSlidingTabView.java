package com.tencent.aelight.camera.aebase.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import java.util.ArrayList;

public class QQSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] v = { 16842901, 16842904 };
  private LinearLayout.LayoutParams a = null;
  private LinearLayout b = null;
  private ArrayList<View> c = new ArrayList(5);
  private int d = -7829368;
  private int e = -16777216;
  private int f = 14;
  private int g = 0;
  private int h = 15;
  private int i = 5;
  private int j = 52;
  private int k = 0;
  private int l = 4;
  private int m = -16776961;
  private int n = 1;
  private int o = -3355444;
  private int p = 0;
  private int q = 0;
  private Paint r = null;
  private int s = 0;
  private int t = 0;
  private QQSlidingTabView.IOnTabCheckListener u;
  private boolean w = false;
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  private void a()
  {
    int i1 = this.q;
    int i2 = this.p;
    if (i1 != i2)
    {
      Object localObject = this.b.getChildAt(i1);
      View localView = this.b.getChildAt(this.p);
      if ((localObject != null) && (localView != null))
      {
        i1 = ((View)localObject).getLeft();
        i2 = localView.getLeft();
        if ((i1 == 0) && (i2 == 0))
        {
          this.w = true;
          return;
        }
        this.w = false;
        localObject = ValueAnimator.ofInt(new int[] { i1, i2 });
        ((ValueAnimator)localObject).setDuration(100L);
        ((ValueAnimator)localObject).addUpdateListener(new QQSlidingTabView.2(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      this.k = this.b.getChildAt(i2).getLeft();
      invalidate();
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = new LinearLayout.LayoutParams(-2, -1);
    this.b = new LinearLayout(paramContext);
    this.b.setOrientation(0);
    this.b.setLayoutParams(this.a);
    addView(this.b);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.g = ((int)TypedValue.applyDimension(1, this.g, localDisplayMetrics));
    this.j = ((int)TypedValue.applyDimension(1, this.j, localDisplayMetrics));
    this.l = ((int)TypedValue.applyDimension(1, this.l, localDisplayMetrics));
    this.n = ((int)TypedValue.applyDimension(1, this.n, localDisplayMetrics));
    this.h = ((int)TypedValue.applyDimension(1, this.h, localDisplayMetrics));
    this.f = ((int)TypedValue.applyDimension(1, this.f, localDisplayMetrics));
    this.i = ((int)TypedValue.applyDimension(1, this.i, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, v).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QIMSlidingTabViewStyle);
    this.g = paramContext.getDimensionPixelSize(4, this.g);
    this.h = paramContext.getDimensionPixelSize(3, this.h);
    this.m = paramContext.getColor(0, this.m);
    this.l = paramContext.getDimensionPixelSize(1, this.l);
    this.d = paramContext.getColor(6, this.d);
    this.e = paramContext.getColor(5, this.e);
    this.o = paramContext.getColor(8, this.o);
    this.n = paramContext.getDimensionPixelSize(9, this.n);
    this.f = paramContext.getDimensionPixelSize(7, this.f);
    this.i = paramContext.getDimensionPixelSize(2, this.i);
    paramContext.recycle();
    this.r = new Paint();
    this.r.setAntiAlias(true);
    this.r.setColor(this.m);
    this.r.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.t = ScreenUtil.dip2px(this.s);
  }
  
  private void b(int paramInt)
  {
    View localView = this.b.getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getScrollX();
      int i1 = this.h * 4;
      int i2 = localView.getRight() - paramInt - getWidth() + i1;
      if (i2 > 0)
      {
        smoothScrollBy(i2, 0);
        return;
      }
      paramInt = localView.getLeft() - paramInt - i1;
      if (paramInt < 0) {
        smoothScrollBy(paramInt, 0);
      }
    }
  }
  
  private void setTabChangeBackgroud(int paramInt)
  {
    int i2 = this.b.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = this.b.getChildAt(i1);
      Object localObject1 = this.c;
      if ((localObject1 != null) && (i1 < ((ArrayList)localObject1).size()))
      {
        localObject1 = (View)this.c.get(i1);
        if (i1 == paramInt)
        {
          if ((localObject1 instanceof ImageView))
          {
            localObject2 = (Bundle)((View)localObject1).getTag();
            if (localObject2 != null) {
              ((ImageView)localObject1).setImageResource(((Bundle)localObject2).getInt("checked_image_bg_id", 2130848439));
            }
          }
          else if ((localObject1 instanceof RedDotTextView))
          {
            localObject1 = (RedDotTextView)localObject2;
            ((RedDotTextView)localObject1).setTextColor(this.e);
            ((RedDotTextView)localObject1).a(false);
          }
          else if ((localObject1 instanceof TextView))
          {
            ((TextView)localObject2).setTextColor(this.e);
          }
        }
        else if ((localObject1 instanceof ImageView))
        {
          localObject2 = (Bundle)((View)localObject1).getTag();
          if (localObject2 != null) {
            ((ImageView)localObject1).setImageResource(((Bundle)localObject2).getInt("normal_image_bg_id", 2130848438));
          }
        }
        else if ((localObject1 instanceof RedDotTextView))
        {
          ((RedDotTextView)localObject2).setTextColor(this.d);
        }
        else if ((localObject1 instanceof TextView))
        {
          ((TextView)localObject2).setTextColor(this.d);
        }
      }
      i1 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.c.size()) {
        return;
      }
      this.p = paramInt;
      setTabChangeBackgroud(paramInt);
      b(paramInt);
      a();
      QQSlidingTabView.IOnTabCheckListener localIOnTabCheckListener = this.u;
      if (localIOnTabCheckListener != null) {
        localIOnTabCheckListener.a(paramInt);
      }
      this.q = this.p;
    }
  }
  
  public int getTabCount()
  {
    return this.c.size();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getHeight();
    Object localObject = this.b.getChildAt(this.p);
    if (localObject != null)
    {
      if (this.w)
      {
        this.k = ((View)localObject).getLeft();
        b(this.p);
        this.w = false;
      }
      if ((this.p == 0) && (this.k < ((View)localObject).getLeft())) {
        this.k = ((View)localObject).getLeft();
      }
      int i2 = this.k;
      localObject = new RectF(this.i + i2, i1 - this.l, i2 + ((View)localObject).getWidth() - this.i, i1);
      i1 = this.t;
      paramCanvas.drawRoundRect((RectF)localObject, i1, i1, this.r);
    }
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.m = paramInt;
    this.r.setColor(this.m);
    invalidate();
  }
  
  public void setTabCheckListener(QQSlidingTabView.IOnTabCheckListener paramIOnTabCheckListener)
  {
    this.u = paramIOnTabCheckListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QQSlidingTabView
 * JD-Core Version:    0.7.0.1
 */