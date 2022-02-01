package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout.LayoutParams;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.Tab;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class WSTabLayout
  extends TabLayoutCompat
{
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  private Animator.AnimatorListener jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = null;
  private ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = null;
  private WSTabLayout.TabAnimListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout$TabAnimListener;
  private ArrayList<WSTabInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private Animator.AnimatorListener jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = null;
  private ValueAnimator jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = null;
  private boolean jdField_b_of_type_Boolean = false;
  private int j = -1;
  
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
    e();
  }
  
  private void a(WSTabLayout.TabContentClickListener paramTabContentClickListener)
  {
    int i = 0;
    for (;;)
    {
      TabLayoutCompat.Tab localTab;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localTab = a();
        if (localTab != null) {
          break label37;
        }
        if (QLog.isColorLevel()) {
          QLog.e("WSTabLayout", 2, "createTab newTab: null");
        }
      }
      return;
      label37:
      localTab.a(2131560147);
      WSTabItemViewHolder localWSTabItemViewHolder = new WSTabItemViewHolder(localTab.a());
      localWSTabItemViewHolder.a(localTab);
      localTab.a(localWSTabItemViewHolder);
      localWSTabItemViewHolder.a((WSTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i));
      localWSTabItemViewHolder.a(paramTabContentClickListener);
      d(localTab);
      i += 1;
    }
  }
  
  private void e()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  private void f()
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
  
  private void g()
  {
    this.j = (((LinearLayout.LayoutParams)getLayoutParams()).topMargin + getHeight());
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void h()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (this.j <= 0) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new WSTabLayout.1(this, localLayoutParams));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new WSTabLayout.2(this);
    }
    if ((this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void i()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)getLayoutParams();
    localLayoutParams.topMargin = (-this.j);
    setLayoutParams(localLayoutParams);
  }
  
  private void j()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (this.j <= 0) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)getLayoutParams();
    if (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(200L);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new WSTabLayout.3(this, localLayoutParams));
      this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new WSTabLayout.4(this);
    }
    if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  public void a(List<WSTabInfo> paramList, WSTabLayout.TabContentClickListener paramTabContentClickListener)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("WSTabLayout", 2, "createTab infos: null");
      }
      WSLog.a("WSTabLayout", "initData list: null");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    a();
    f();
    a(paramTabContentClickListener);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramBoolean)
    {
      j();
      return;
    }
    i();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (!this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) && (((LinearLayout.LayoutParams)getLayoutParams()).topMargin != 0))
      {
        WSLog.f("WSTabLayout", "showTabLayout catch a display exception");
        d();
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    h();
  }
  
  public void d()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)getLayoutParams();
    localLayoutParams.topMargin = 0;
    setLayoutParams(localLayoutParams);
  }
  
  public void setTabAnimListener(WSTabLayout.TabAnimListener paramTabAnimListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout$TabAnimListener = paramTabAnimListener;
  }
  
  public void setTabItemSelect(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = a(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (WSTabItemViewHolder)((TabLayoutCompat.Tab)localObject).a();
        if (localObject != null) {
          if (i == paramInt1) {
            ((WSTabItemViewHolder)localObject).a(paramInt2);
          } else {
            ((WSTabItemViewHolder)localObject).a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout
 * JD-Core Version:    0.7.0.1
 */