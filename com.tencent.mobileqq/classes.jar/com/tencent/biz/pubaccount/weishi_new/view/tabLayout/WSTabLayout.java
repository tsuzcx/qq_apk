package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.biz.pubaccount.weishi_new.impl.R.styleable;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class WSTabLayout
  extends TabLayoutCompat
{
  private final Interpolator n = new LinearInterpolator();
  private ValueAnimator o = null;
  private ValueAnimator p = null;
  private final ArrayList<WSTabInfo> q = new ArrayList();
  private boolean r = true;
  private LinearLayout s;
  private int t;
  private int u;
  private Paint v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public WSTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WSTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WSTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private float a(Integer paramInteger)
  {
    return paramInteger.intValue() * 1.0F / 10000.0F;
  }
  
  private long a(int paramInt)
  {
    return (Math.abs(paramInt) / WeishiUIUtil.p * 200.0F);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.t) || (paramInt2 != this.u))
    {
      this.t = paramInt1;
      this.u = paramInt2;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = this.t;
    if (i >= 0)
    {
      int j = this.u;
      if (j <= i) {
        return;
      }
      int k = (int)((j - i - this.w) / 2.0F);
      i += k;
      j = getHeight() - this.x - this.y;
      k = this.u - k;
      int m = getHeight() - this.y;
      if (Build.VERSION.SDK_INT >= 21)
      {
        float f = this.x / 2.0F;
        paramCanvas.drawRoundRect(i, j, k, m, f, f, this.v);
        return;
      }
      paramCanvas.drawRect(i, j, k, m, this.v);
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    b(paramAttributeSet);
    this.s = ((LinearLayout)getChildAt(0));
    setSelectedTabIndicatorHeight(0);
    d();
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    this.o = ValueAnimator.ofInt(new int[] { 0, 10000 });
    this.o.setInterpolator(this.n);
    this.o.addUpdateListener(new WSTabLayout.1(this, paramInt, paramLayoutParams));
    this.o.addListener(getShowTabAnimListener());
    this.o.setDuration(a(paramInt));
    this.o.start();
  }
  
  private void a(ValueAnimator paramValueAnimator, int paramInt, LinearLayout.LayoutParams paramLayoutParams)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f = a((Integer)paramValueAnimator);
      int i = (int)(paramInt * (1.0F - f));
      paramLayoutParams.topMargin = i;
      setLayoutParams(paramLayoutParams);
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("[WSTabLayout.java][doShowTabLayoutAnim] onAnimationUpdate currentTopMargin:");
      paramValueAnimator.append(paramInt);
      paramValueAnimator.append(", animatorPercent:");
      paramValueAnimator.append(f);
      paramValueAnimator.append(", offset:");
      paramValueAnimator.append(i);
      WSLog.b("WSTabLayoutLog", paramValueAnimator.toString());
    }
  }
  
  private void a(WSTabLayout.TabContentClickListener paramTabContentClickListener)
  {
    int i = 0;
    while (i < this.q.size())
    {
      TabLayoutCompat.Tab localTab = a();
      if (localTab == null)
      {
        WSLog.d("WSTabLayoutLog", "[WSTabLayout.java][initData] createTab newTab: null!");
        return;
      }
      localTab.a(2131626072);
      WSTabItemViewHolder localWSTabItemViewHolder = new WSTabItemViewHolder(localTab.b());
      localWSTabItemViewHolder.a(localTab);
      localTab.a(localWSTabItemViewHolder);
      localWSTabItemViewHolder.a((WSTabInfo)this.q.get(i));
      localWSTabItemViewHolder.a(paramTabContentClickListener);
      d(localTab);
      i += 1;
    }
  }
  
  private void b(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.a);
    this.w = ((int)paramAttributeSet.getDimension(3, 0.0F));
    this.x = ((int)paramAttributeSet.getDimension(2, 0.0F));
    this.y = ((int)paramAttributeSet.getDimension(1, 0.0F));
    this.z = paramAttributeSet.getColor(0, 0);
    paramAttributeSet.recycle();
  }
  
  private void b(LinearLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    this.p = ValueAnimator.ofInt(new int[] { 0, 10000 });
    this.p.setInterpolator(this.n);
    this.p.addUpdateListener(new WSTabLayout.3(this, paramInt, paramLayoutParams));
    this.p.addListener(getHideTabAnimListener());
    this.p.setDuration(d(paramInt));
    this.p.start();
  }
  
  private void b(ValueAnimator paramValueAnimator, int paramInt, LinearLayout.LayoutParams paramLayoutParams)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f = a((Integer)paramValueAnimator);
      int i = (int)(paramInt - (WeishiUIUtil.p + paramInt) * f);
      paramLayoutParams.topMargin = i;
      setLayoutParams(paramLayoutParams);
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("[WSTabLayout.java][doHideTabLayoutAnim] onAnimationUpdate currentTopMargin:");
      paramValueAnimator.append(paramInt);
      paramValueAnimator.append(", animatorPercent:");
      paramValueAnimator.append(f);
      paramValueAnimator.append(", offset:");
      paramValueAnimator.append(i);
      WSLog.b("WSTabLayoutLog", paramValueAnimator.toString());
    }
  }
  
  private long d(int paramInt)
  {
    return (Math.abs(WeishiUIUtil.p + paramInt) / WeishiUIUtil.p * 200.0F);
  }
  
  private void d()
  {
    this.v = new Paint();
    this.v.setColor(this.z);
    this.v.setAntiAlias(true);
  }
  
  private void e()
  {
    if (this.q.size() <= 5)
    {
      setTabMode(1);
      setTabGravity(0);
      return;
    }
    setTabMode(0);
    setTabGravity(1);
  }
  
  private void f()
  {
    this.r = true;
    setTabLayoutParams(0);
  }
  
  private void g()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)getLayoutParams();
    int i = localLayoutParams.topMargin;
    if (i == 0)
    {
      WSLog.d("WSTabLayoutLog", "[WSTabLayout.java][doShowTabLayoutAnim] currentTopMargin:0, doNothing!!");
      return;
    }
    h();
    a(localLayoutParams, i);
  }
  
  @NotNull
  private Animator.AnimatorListener getHideTabAnimListener()
  {
    return new WSTabLayout.4(this);
  }
  
  @NotNull
  private Animator.AnimatorListener getShowTabAnimListener()
  {
    return new WSTabLayout.2(this);
  }
  
  private void h()
  {
    ValueAnimator localValueAnimator = this.o;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.o.cancel();
      this.o.removeAllListeners();
    }
  }
  
  private void i()
  {
    this.r = false;
    setTabLayoutParams(-WeishiUIUtil.p);
  }
  
  private void j()
  {
    Object localObject = (LinearLayout.LayoutParams)getLayoutParams();
    int i = ((LinearLayout.LayoutParams)localObject).topMargin;
    if (i == -WeishiUIUtil.p)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSTabLayout.java][doHideTabLayoutAnim] currentTopMargin:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", doNothing!!");
      WSLog.d("WSTabLayoutLog", ((StringBuilder)localObject).toString());
      return;
    }
    k();
    b((LinearLayout.LayoutParams)localObject, i);
  }
  
  private void k()
  {
    ValueAnimator localValueAnimator = this.p;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.p.removeAllListeners();
      this.p.cancel();
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    View localView = this.s.getChildAt(paramInt);
    int i;
    int j;
    if ((localView != null) && (localView.getWidth() > 0))
    {
      int m = localView.getLeft();
      int k = localView.getRight();
      i = k;
      j = m;
      if (paramFloat > 0.0F)
      {
        i = k;
        j = m;
        if (paramInt < this.s.getChildCount() - 1)
        {
          localView = this.s.getChildAt(paramInt + 1);
          float f1 = localView.getLeft();
          float f2 = 1.0F - paramFloat;
          j = (int)(f1 * paramFloat + m * f2);
          i = (int)(paramFloat * localView.getRight() + f2 * k);
        }
      }
    }
    else
    {
      j = -1;
      i = -1;
    }
    a(j, i);
  }
  
  public void a(List<WSTabInfo> paramList, WSTabLayout.TabContentClickListener paramTabContentClickListener)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.q.clear();
      this.q.addAll(paramList);
      b();
      e();
      a(paramTabContentClickListener);
      return;
    }
    WSLog.d("WSTabLayoutLog", "[WSTabLayout.java][initData] initData list: null");
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSTabLayout.java][showTabLayout] isStartAnim:");
    localStringBuilder.append(paramBoolean);
    WSLog.e("WSTabLayoutLog", localStringBuilder.toString());
    if (paramBoolean)
    {
      g();
      return;
    }
    f();
  }
  
  public void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSTabLayout.java][hideTabLayout] isStartAnim:");
    localStringBuilder.append(paramBoolean);
    WSLog.e("WSTabLayoutLog", localStringBuilder.toString());
    if (paramBoolean)
    {
      j();
      return;
    }
    i();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    a(paramCanvas);
  }
  
  public void setTabItemSelect(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.q.size())
    {
      Object localObject = b(i);
      if (localObject != null)
      {
        localObject = (WSTabItemViewHolder)((TabLayoutCompat.Tab)localObject).a();
        if (localObject != null) {
          if (i == paramInt1) {
            ((WSTabItemViewHolder)localObject).a(paramInt2);
          } else {
            ((WSTabItemViewHolder)localObject).a();
          }
        }
      }
      i += 1;
    }
  }
  
  public void setTabLayoutParams(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout
 * JD-Core Version:    0.7.0.1
 */