package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout.LayoutParams;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
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
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = null;
  private final ArrayList<WSTabInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private ValueAnimator b = null;
  
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
    c();
  }
  
  private float a(Integer paramInteger)
  {
    return paramInteger.intValue() * 1.0F / 10000.0F;
  }
  
  private long a(int paramInt)
  {
    return (Math.abs(paramInt) / WeishiUIUtil.n * 200.0F);
  }
  
  @NotNull
  private Animator.AnimatorListener a()
  {
    return new WSTabLayout.2(this);
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 10000 });
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new WSTabLayout.1(this, paramInt, paramLayoutParams));
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(a());
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(a(paramInt));
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
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
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      TabLayoutCompat.Tab localTab = a();
      if (localTab == null)
      {
        WSLog.d("WSTabLayoutLog", "[WSTabLayout.java][initData] createTab newTab: null!");
        return;
      }
      localTab.a(2131560029);
      WSTabItemViewHolder localWSTabItemViewHolder = new WSTabItemViewHolder(localTab.a());
      localWSTabItemViewHolder.a(localTab);
      localTab.a(localWSTabItemViewHolder);
      localWSTabItemViewHolder.a((WSTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i));
      localWSTabItemViewHolder.a(paramTabContentClickListener);
      d(localTab);
      i += 1;
    }
  }
  
  private long b(int paramInt)
  {
    return (Math.abs(WeishiUIUtil.n + paramInt) / WeishiUIUtil.n * 200.0F);
  }
  
  @NotNull
  private Animator.AnimatorListener b()
  {
    return new WSTabLayout.4(this);
  }
  
  private void b(LinearLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    this.b = ValueAnimator.ofInt(new int[] { 0, 10000 });
    this.b.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.b.addUpdateListener(new WSTabLayout.3(this, paramInt, paramLayoutParams));
    this.b.addListener(b());
    this.b.setDuration(b(paramInt));
    this.b.start();
  }
  
  private void b(ValueAnimator paramValueAnimator, int paramInt, LinearLayout.LayoutParams paramLayoutParams)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f = a((Integer)paramValueAnimator);
      int i = (int)(paramInt - (WeishiUIUtil.n + paramInt) * f);
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
  
  private void c()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 5)
    {
      setTabMode(1);
      setTabGravity(0);
      return;
    }
    setTabMode(0);
    setTabGravity(1);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = true;
    setTabLayoutParams(0);
  }
  
  private void f()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)getLayoutParams();
    int i = localLayoutParams.topMargin;
    if (i == 0)
    {
      WSLog.d("WSTabLayoutLog", "[WSTabLayout.java][doShowTabLayoutAnim] currentTopMargin:0, doNothing!!");
      return;
    }
    g();
    a(localLayoutParams, i);
  }
  
  private void g()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = false;
    setTabLayoutParams(-WeishiUIUtil.n);
  }
  
  private void i()
  {
    Object localObject = (LinearLayout.LayoutParams)getLayoutParams();
    int i = ((LinearLayout.LayoutParams)localObject).topMargin;
    if (i == -WeishiUIUtil.n)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSTabLayout.java][doHideTabLayoutAnim] currentTopMargin:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", doNothing!!");
      WSLog.d("WSTabLayoutLog", ((StringBuilder)localObject).toString());
      return;
    }
    j();
    b((LinearLayout.LayoutParams)localObject, i);
  }
  
  private void j()
  {
    ValueAnimator localValueAnimator = this.b;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.b.removeAllListeners();
      this.b.cancel();
    }
  }
  
  public void a(List<WSTabInfo> paramList, WSTabLayout.TabContentClickListener paramTabContentClickListener)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      a();
      d();
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
      f();
      return;
    }
    e();
  }
  
  public void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSTabLayout.java][hideTabLayout] isStartAnim:");
    localStringBuilder.append(paramBoolean);
    WSLog.e("WSTabLayoutLog", localStringBuilder.toString());
    if (paramBoolean)
    {
      i();
      return;
    }
    h();
  }
  
  public void setTabItemSelect(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = a(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout
 * JD-Core Version:    0.7.0.1
 */