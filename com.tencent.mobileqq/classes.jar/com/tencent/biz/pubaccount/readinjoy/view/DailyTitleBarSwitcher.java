package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveUtils;

public class DailyTitleBarSwitcher
  extends FrameLayout
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new DailyTitleBarSwitcher.1(this);
  private DailyTitleBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar;
  private final AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new DailyTitleBarSwitcher.2(this);
  private boolean jdField_a_of_type_Boolean = false;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private DailyTitleBar jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar;
  
  public DailyTitleBarSwitcher(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public DailyTitleBarSwitcher(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DailyTitleBarSwitcher(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (getChildCount() >= 2)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar = ((DailyTitleBar)getChildAt(0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar = ((DailyTitleBar)getChildAt(1));
      a(0.0F);
      ImmersiveUtils.setStatusTextColor(false, ((Activity)getContext()).getWindow());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setAlpha(paramFloat);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setAlpha(1.0F - paramFloat);
      if (paramFloat <= 0.0F) {
        break label58;
      }
      ImmersiveUtils.setStatusTextColor(true, ((Activity)getContext()).getWindow());
    }
    for (;;)
    {
      b();
      return;
      label58:
      ImmersiveUtils.setStatusTextColor(false, ((Activity)getContext()).getWindow());
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_AndroidViewView$OnClickListener == null) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.getAlpha() < 0.1F)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnTitleClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnTitleClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnTitleClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnTitleClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public AbsListView.OnScrollListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public void setBackgroundViewTitle(String paramString, float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setTitleText(paramString);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setTitleTextSize(paramFloat);
    }
  }
  
  public void setOnLeftButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnLeftButtonClickListener(paramOnClickListener);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnLeftButtonClickListener(paramOnClickListener);
    }
  }
  
  public void setOnRightButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnRightButtonClickListener(paramOnClickListener);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnRightButtonClickListener(paramOnClickListener);
    }
  }
  
  public void setOnTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnTitleClickListener(paramOnClickListener);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnTitleClickListener(paramOnClickListener);
    }
  }
  
  public void setOnTitleClickWeatherListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar != null))
    {
      this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnTitleClickListener(paramOnClickListener);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnTitleClickListener(paramOnClickListener);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnTitleClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBar.setOnTitleClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher
 * JD-Core Version:    0.7.0.1
 */