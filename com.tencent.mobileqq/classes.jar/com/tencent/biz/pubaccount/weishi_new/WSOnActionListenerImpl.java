package com.tencent.biz.pubaccount.weishi_new;

import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout.OnActionListener;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;

public class WSOnActionListenerImpl
  implements WSFeedsLinearLayout.OnActionListener
{
  private int jdField_a_of_type_Int;
  private final WSRecommendFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment;
  private final WSTabLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  
  public WSOnActionListenerImpl(WSRecommendFragment paramWSRecommendFragment, WSTabLayout paramWSTabLayout)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment = paramWSRecommendFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout = paramWSTabLayout;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.a() == 1;
  }
  
  private void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSOnActionListenerImpl.java][actionUp] moveState:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", mScrollingTopMargin:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    WSLog.e("WSOnActionListenerImpl", localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.b(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.a(false);
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.a(true);
    }
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.getLayoutParams();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Int = ((LinearLayout.LayoutParams)localObject).topMargin;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.a(false);
      WSLog.b("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveDown] switchMoveDown!! ViewPager Cannot Scroll!!");
    }
    int i = ((LinearLayout.LayoutParams)localObject).topMargin;
    if (i == 0)
    {
      WSLog.g("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveDown] currentTopMargin:0, doNothing!!");
      return;
    }
    this.jdField_b_of_type_Int = Math.min(-paramInt + this.jdField_a_of_type_Int, 0);
    ((LinearLayout.LayoutParams)localObject).topMargin = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSOnActionListenerImpl.java][handleActionMoveDown] topMargin:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(", currentTopMargin:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", dy:");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.e("WSOnActionListenerImpl", ((StringBuilder)localObject).toString());
  }
  
  private void e(int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.getLayoutParams();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = ((LinearLayout.LayoutParams)localObject).topMargin;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment.a(false);
      WSLog.b("WSOnActionListenerImpl", "[WSOnActionListenerImpl.java][handleActionMoveUp] switchMoveUp!! ViewPager Cannot Scroll!!");
    }
    int j = WeishiUIUtil.n;
    int i = ((LinearLayout.LayoutParams)localObject).topMargin;
    j = -j;
    if (i == j)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSOnActionListenerImpl.java][handleActionMoveUp] currentTopMargin:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", doNothing!!");
      WSLog.g("WSOnActionListenerImpl", ((StringBuilder)localObject).toString());
      return;
    }
    this.jdField_b_of_type_Int = Math.max(-paramInt + this.jdField_a_of_type_Int, j);
    ((LinearLayout.LayoutParams)localObject).topMargin = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSOnActionListenerImpl.java][handleActionMoveUp] topMargin:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(", currentTopMargin:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", dy:");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.e("WSOnActionListenerImpl", ((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt)
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSOnActionListenerImpl.java][actionMoveUp] viewPager is dragging!! dy:");
      localStringBuilder.append(paramInt);
      WSLog.g("WSOnActionListenerImpl", localStringBuilder.toString());
      return;
    }
    e(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSOnActionListenerImpl.java][actionUp] viewPager is dragging!! dy:");
      localStringBuilder.append(paramInt2);
      WSLog.g("WSOnActionListenerImpl", localStringBuilder.toString());
      return;
    }
    c(paramInt1);
  }
  
  public void b(int paramInt)
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSOnActionListenerImpl.java][actionMoveDown] viewPager is dragging!! dy:");
      localStringBuilder.append(paramInt);
      WSLog.g("WSOnActionListenerImpl", localStringBuilder.toString());
      return;
    }
    d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSOnActionListenerImpl
 * JD-Core Version:    0.7.0.1
 */