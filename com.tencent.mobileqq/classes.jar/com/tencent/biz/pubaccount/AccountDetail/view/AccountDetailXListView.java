package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public class AccountDetailXListView
  extends XListView
  implements AbsListView.OnScrollListener, Runnable
{
  protected float a;
  protected int a;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  private AccountDetailXListView.OnEndScrollListener a;
  public AccountDetailXListView.RefreshCallback a;
  public boolean a;
  protected float b;
  protected int b;
  protected boolean b;
  protected float c;
  protected int c;
  protected float d;
  protected int d;
  float jdField_e_of_type_Float = 0.0F;
  private int jdField_e_of_type_Int;
  private int f = 100;
  
  public AccountDetailXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AccountDetailXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Float = 0.0F;
    a(paramContext, paramAttributeSet);
  }
  
  public AccountDetailXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Float = 0.0F;
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setPadding(localRelativeLayout.getPaddingLeft(), 0, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), paramInt);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    c();
    this.jdField_c_of_type_Int = paramContext.getResources().getDisplayMetrics().heightPixels;
    setOnScrollListener(this);
  }
  
  private boolean a()
  {
    ListAdapter localListAdapter = getAdapter();
    boolean bool = false;
    if (localListAdapter == null) {
      return false;
    }
    if (getFooterViewsCount() <= 0) {
      return false;
    }
    if (getLastVisiblePosition() == getAdapter().getCount() - 1) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559979, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373273));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373274));
    addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, null, false);
    setFooterDividersEnabled(false);
  }
  
  private void d()
  {
    if ((a()) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView$RefreshCallback != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailXListView", 2, "loadingMore");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689532);
      a(0);
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView$RefreshCallback.startLoadMore(this);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView$RefreshCallback = null;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        c();
      }
      if (getFooterViewsCount() <= 0) {
        addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
    }
    else if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (getFooterViewsCount() > 0))
    {
      removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailXListView", 2, "loadMoreFail");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689531);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      a(0);
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadMoreComplete hasMoreData = ");
        localStringBuilder.append(paramBoolean);
        QLog.d("AccountDetailXListView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Int = 0;
      if (!paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689533);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.jdField_b_of_type_Int < 0))
    {
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localRelativeLayout != null)
      {
        this.jdField_b_of_type_Int = localRelativeLayout.getHeight();
        a(-this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.jdField_a_of_type_Boolean)) {
      d();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    this.jdField_b_of_type_Float = paramMotionEvent.getY();
    float f1;
    if (i == 0)
    {
      this.jdField_d_of_type_Int = ((int)paramMotionEvent.getY());
      f1 = this.jdField_b_of_type_Float;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Float = f1;
    }
    else if (i == 2)
    {
      this.jdField_d_of_type_Int = ((int)(paramMotionEvent.getY() - this.jdField_d_of_type_Int));
      if (Math.abs(this.jdField_b_of_type_Float - this.jdField_a_of_type_Float) < DisplayUtil.a(super.getContext(), 10.0F))
      {
        this.jdField_d_of_type_Int = ((int)paramMotionEvent.getY());
        f1 = this.jdField_b_of_type_Float;
        this.jdField_d_of_type_Float = (f1 - this.jdField_c_of_type_Float);
        this.jdField_c_of_type_Float = f1;
      }
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_e_of_type_Float = Math.abs(this.jdField_d_of_type_Float);
      this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
      this.jdField_d_of_type_Int = ((int)paramMotionEvent.getY());
      this.jdField_b_of_type_Boolean = false;
      f1 = this.jdField_b_of_type_Float;
      this.jdField_d_of_type_Float = (f1 - this.jdField_c_of_type_Float);
      this.jdField_c_of_type_Float = f1;
      this.jdField_e_of_type_Int = getScrollY();
      removeCallbacks(this);
      postDelayed(this, this.f);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void run()
  {
    int i = getScrollY();
    if (this.jdField_e_of_type_Int - i == 0)
    {
      AccountDetailXListView.OnEndScrollListener localOnEndScrollListener = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView$OnEndScrollListener;
      if (localOnEndScrollListener != null) {
        localOnEndScrollListener.a((int)this.jdField_e_of_type_Float);
      }
    }
    else
    {
      this.jdField_e_of_type_Int = getScrollY();
      postDelayed(this, this.f);
    }
  }
  
  public void setOnEndScrollListener(AccountDetailXListView.OnEndScrollListener paramOnEndScrollListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView$OnEndScrollListener = paramOnEndScrollListener;
  }
  
  public void setRefreshCallback(AccountDetailXListView.RefreshCallback paramRefreshCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView$RefreshCallback = paramRefreshCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView
 * JD-Core Version:    0.7.0.1
 */