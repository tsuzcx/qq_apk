package com.tencent.av.ui.effect.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import java.util.ArrayList;

public class QavEffectSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] v = { 16842901, 16842904 };
  protected LinearLayout a = null;
  protected ArrayList<View> b = new ArrayList(5);
  protected int c = -7829368;
  protected int d = -16777216;
  protected int e = Color.parseColor("#E62555");
  protected int f = 14;
  protected int g = 15;
  protected int h = 0;
  protected int i = -1;
  private LinearLayout.LayoutParams j = null;
  private int k = 0;
  private int l = 5;
  private int m = 52;
  private int n = 0;
  private int o = 4;
  private int p = -16776961;
  private int q = 0;
  private Paint r = null;
  private int s = 0;
  private int t = 0;
  private QavEffectSlidingTabView.IOnTabCheckListener u;
  private boolean w = false;
  private QavEffectSlidingTabView.Interceptor x;
  
  public QavEffectSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public QavEffectSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.j = new LinearLayout.LayoutParams(-1, -1);
    this.a = new LinearLayout(paramContext);
    this.a.setOrientation(0);
    this.a.setLayoutParams(this.j);
    addView(this.a);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.k = ((int)TypedValue.applyDimension(1, this.k, localDisplayMetrics));
    this.m = ((int)TypedValue.applyDimension(1, this.m, localDisplayMetrics));
    this.o = ((int)TypedValue.applyDimension(1, this.o, localDisplayMetrics));
    this.g = ((int)TypedValue.applyDimension(1, this.g, localDisplayMetrics));
    this.f = ((int)TypedValue.applyDimension(1, this.f, localDisplayMetrics));
    this.l = ((int)TypedValue.applyDimension(1, this.l, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, v).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QIMSlidingTabViewStyle);
    this.k = paramContext.getDimensionPixelSize(4, this.k);
    this.g = paramContext.getDimensionPixelSize(3, this.g);
    this.p = paramContext.getColor(0, this.p);
    this.o = paramContext.getDimensionPixelSize(1, this.o);
    this.c = paramContext.getColor(6, this.c);
    this.d = paramContext.getColor(5, this.d);
    this.f = paramContext.getDimensionPixelSize(7, this.f);
    this.l = paramContext.getDimensionPixelSize(2, this.l);
    paramContext.recycle();
    this.r = new Paint();
    this.r.setAntiAlias(true);
    this.r.setColor(this.p);
    this.r.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.t = ScreenUtil.dip2px(this.s);
  }
  
  private void b(int paramInt)
  {
    View localView = this.a.getChildAt(paramInt);
    if (localView != null)
    {
      paramInt = getScrollX();
      int i1 = this.g * 4;
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
  
  private void setTabChangeBackground(int paramInt)
  {
    int i2 = this.a.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = this.a.getChildAt(i1);
      Object localObject1 = localObject2;
      if ((localObject2 instanceof ViewGroup)) {
        localObject1 = ((ViewGroup)localObject2).getChildAt(0);
      }
      localObject2 = this.b;
      if ((localObject2 != null) && (i1 < ((ArrayList)localObject2).size()))
      {
        localObject2 = (View)this.b.get(i1);
        if (i1 == paramInt)
        {
          if ((localObject2 instanceof ImageView))
          {
            localObject1 = (Bundle)((View)localObject2).getTag();
            if (localObject1 != null) {
              ((ImageView)localObject2).setImageResource(((Bundle)localObject1).getInt("checked_image_bg_id", 2130848439));
            }
          }
          else if ((localObject2 instanceof RedDotTextView))
          {
            if (this.i == i1) {
              ((RedDotTextView)localObject1).setTextColor(this.e);
            } else {
              ((RedDotTextView)localObject1).setTextColor(this.d);
            }
            ((RedDotTextView)localObject1).a(false);
          }
          else if ((localObject2 instanceof TextView))
          {
            ((TextView)localObject1).setTextColor(this.d);
          }
        }
        else if ((localObject2 instanceof ImageView))
        {
          localObject1 = (Bundle)((View)localObject2).getTag();
          if (localObject1 != null) {
            ((ImageView)localObject2).setImageResource(((Bundle)localObject1).getInt("normal_image_bg_id", 2130848438));
          }
        }
        else if ((localObject2 instanceof RedDotTextView))
        {
          ((RedDotTextView)localObject1).setTextColor(this.c);
        }
        else if ((localObject2 instanceof TextView))
        {
          ((TextView)localObject1).setTextColor(this.c);
        }
      }
      i1 += 1;
    }
  }
  
  protected int a(int paramInt, View paramView)
  {
    if (paramInt < 0) {
      return -1;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    localLayoutParams.gravity = 16;
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.gravity = 1;
    paramView.setLayoutParams(localLayoutParams);
    paramView.setOnClickListener(new QavEffectSlidingTabView.1(this, paramInt));
    this.b.add(paramInt, paramView);
    localLinearLayout.addView(paramView);
    this.a.addView(localLinearLayout, paramInt);
    return 0;
  }
  
  @TargetApi(11)
  protected void a()
  {
    int i1 = this.q;
    int i2 = this.h;
    View localView1;
    Object localObject;
    if (i1 != i2)
    {
      View localView2 = this.a.getChildAt(i1);
      boolean bool = localView2 instanceof ViewGroup;
      localView1 = null;
      if (bool) {
        localObject = ((ViewGroup)localView2).getChildAt(0);
      } else {
        localObject = null;
      }
      View localView3 = this.a.getChildAt(this.h);
      if ((localView3 instanceof ViewGroup)) {
        localView1 = ((ViewGroup)localView3).getChildAt(0);
      }
      if ((localView2 != null) && (localView3 != null))
      {
        i2 = localView2.getLeft();
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = ((View)localObject).getLeft();
        }
        i2 += i1;
        int i3 = localView3.getLeft();
        if (localView1 == null) {
          i1 = 0;
        } else {
          i1 = localView1.getLeft();
        }
        i1 = i3 + i1;
        if ((i2 == 0) && (i1 == 0))
        {
          this.w = true;
          return;
        }
        this.w = false;
        localObject = ValueAnimator.ofInt(new int[] { i2, i1 });
        ((ValueAnimator)localObject).setDuration(100L);
        ((ValueAnimator)localObject).addUpdateListener(new QavEffectSlidingTabView.2(this));
        ((ValueAnimator)localObject).start();
      }
    }
    else
    {
      localView1 = this.a.getChildAt(i2);
      localObject = localView1;
      if ((localView1 instanceof ViewGroup)) {
        localObject = ((ViewGroup)localView1).getChildAt(0);
      }
      this.n = ((View)localObject).getLeft();
      invalidate();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.x;
    if (((localObject == null) || (!((QavEffectSlidingTabView.Interceptor)localObject).a(paramInt))) && (paramInt >= 0))
    {
      if (paramInt >= this.b.size()) {
        return;
      }
      this.h = paramInt;
      setTabChangeBackground(paramInt);
      b(paramInt);
      a();
      localObject = this.u;
      if (localObject != null) {
        ((QavEffectSlidingTabView.IOnTabCheckListener)localObject).onTabChecked(paramInt);
      }
      this.q = this.h;
    }
  }
  
  public void a(ArrayList<QavEffectSlidingTabView.TabIcon> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      this.b.clear();
      this.a.removeAllViews();
      int i1 = 0;
      int i2 = -1;
      while (i1 < paramArrayList.size())
      {
        RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
        localRedDotTextView.setText(((QavEffectSlidingTabView.TabIcon)paramArrayList.get(i1)).a);
        localRedDotTextView.setContentDescription(((QavEffectSlidingTabView.TabIcon)paramArrayList.get(i1)).a);
        localRedDotTextView.setGravity(17);
        localRedDotTextView.setSingleLine();
        localRedDotTextView.setTextSize(0, this.f);
        int i3 = this.g;
        localRedDotTextView.setPadding(i3, 0, i3, 0);
        localRedDotTextView.a(((QavEffectSlidingTabView.TabIcon)paramArrayList.get(i1)).b);
        if (((QavEffectSlidingTabView.TabIcon)paramArrayList.get(i1)).c) {
          i2 = i1;
        }
        a(i1, localRedDotTextView);
        i1 += 1;
      }
      this.i = i2;
      setTabChangeBackground(this.h);
      return;
    }
    this.a.removeAllViews();
  }
  
  public int getTabCount()
  {
    return this.b.size();
  }
  
  public ArrayList<View> getmTabItemList()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = getHeight();
    View localView = this.a.getChildAt(this.h);
    Object localObject = localView;
    if ((localView instanceof ViewGroup)) {
      localObject = ((ViewGroup)localView).getChildAt(0);
    }
    if (localObject != null)
    {
      if (this.w)
      {
        this.n = ((View)localObject).getLeft();
        b(this.h);
        this.w = false;
      }
      if ((this.h == 0) && (this.n < ((View)localObject).getLeft())) {
        this.n = ((View)localObject).getLeft();
      }
      if (this.i == this.h) {
        i1 = this.e;
      } else {
        i1 = this.p;
      }
      this.r.setColor(i1);
      int i1 = this.n;
      localObject = new RectF(this.l + i1, i2 - this.o, i1 + ((View)localObject).getWidth() - this.l, i2);
      i1 = this.t;
      paramCanvas.drawRoundRect((RectF)localObject, i1, i1, this.r);
    }
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.p = paramInt;
    this.r.setColor(this.p);
    invalidate();
  }
  
  public void setInterceptor(QavEffectSlidingTabView.Interceptor paramInterceptor)
  {
    this.x = paramInterceptor;
  }
  
  public void setTabCheckListener(QavEffectSlidingTabView.IOnTabCheckListener paramIOnTabCheckListener)
  {
    this.u = paramIOnTabCheckListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.QavEffectSlidingTabView
 * JD-Core Version:    0.7.0.1
 */