package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import mic;

public abstract class ReadInJoyBaseListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  protected int a;
  private View jdField_a_of_type_AndroidViewView;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  ReadInJoyBaseListView.MultiScrollListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$MultiScrollListener = new ReadInJoyBaseListView.MultiScrollListener();
  private ReadInJoyBaseListView.OnDrawCompleteListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$OnDrawCompleteListener;
  protected ReadInJoyBaseListView.RefreshCallback a;
  private ReadInJoyBaseListView.ScrollEventCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$ScrollEventCallback;
  protected boolean a;
  protected int b;
  public boolean b;
  public int c;
  private boolean c;
  public int d;
  
  public ReadInJoyBaseListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), 0, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), paramInt);
    }
  }
  
  private boolean a()
  {
    if (getAdapter() == null) {}
    while ((getFooterViewsCount() <= 0) || (getLastVisiblePosition() != getAdapter().getCount() - 1)) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(62.0F, getResources())));
    TextView localTextView = new TextView(getContext());
    localTextView.setText(2131438928);
    localTextView.setTextColor(-4473925);
    localTextView.setTextSize(14.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(0, 12, 0, 12);
    localTextView.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(localTextView);
    this.jdField_a_of_type_AndroidViewView = localRelativeLayout;
  }
  
  private void b(int paramInt)
  {
    if (paramInt != 4) {
      if ((a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback != null))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131432083);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        a(0);
        this.jdField_c_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback.a(this, paramInt);
      }
    }
    do
    {
      return;
      if (a())
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131432083);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        a(0);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback == null);
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback.a(this, paramInt);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2130969690, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366826));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366827));
    addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$MultiScrollListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$MultiScrollListener.a();
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ReadInJoyXListView);
    this.jdField_c_of_type_Boolean = paramContext.getBoolean(1, false);
    paramContext.recycle();
    if (this.jdField_c_of_type_Boolean) {
      c();
    }
    if (this.d == 70) {
      b();
    }
    super.setOnScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$MultiScrollListener);
    a(this);
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$MultiScrollListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$MultiScrollListener.a(paramOnScrollListener);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_Int < 0) && (this.jdField_c_of_type_Int != 1) && (paramInt1 >= paramInt3 - paramInt2 * 2) && ((this.d != 70) || (!this.jdField_b_of_type_Boolean))) {
      b(2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseListView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean);
    }
    this.jdField_c_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131432084);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      a(-this.jdField_a_of_type_Int);
    }
    setFooterView(paramBoolean);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$OnDrawCompleteListener != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$OnDrawCompleteListener.a(this);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$ScrollEventCallback != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$ScrollEventCallback.a();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.jdField_a_of_type_Int < 0) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      a(-this.jdField_a_of_type_Int);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter != null) && ((paramListAdapter instanceof ReadInJoyBaseAdapter))) {
      ((ReadInJoyBaseAdapter)paramListAdapter).a(new mic(this));
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      if (this.d == 70)
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          b();
        }
        removeFooterView(this.jdField_a_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        c();
      }
      if (getFooterViewsCount() <= 0) {
        addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
    }
    do
    {
      return;
      if (this.d == 70)
      {
        removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        if (this.jdField_a_of_type_AndroidViewView == null) {
          b();
        }
        if (getFooterViewsCount() <= 0) {
          addFooterView(this.jdField_a_of_type_AndroidViewView);
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        c();
      }
    } while (getFooterViewsCount() <= 0);
    removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void setNeedShowFootView(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    c();
  }
  
  public void setNoMoreData(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (!this.jdField_b_of_type_Boolean) {
        break label72;
      }
      if (this.d == 70)
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          b();
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
        if (getFooterViewsCount() <= 0) {
          addFooterView(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
    label72:
    while (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    removeFooterView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void setOnDrawCompleteListener(ReadInJoyBaseListView.OnDrawCompleteListener paramOnDrawCompleteListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$OnDrawCompleteListener = paramOnDrawCompleteListener;
  }
  
  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    throw new RuntimeException("use addScrollListener  or removeScrollListener，better call addScrollListener in ReadInJoyBaseAdapter.onAddScrollListeners for control the call sequence");
  }
  
  public void setRefreshCallback(ReadInJoyBaseListView.RefreshCallback paramRefreshCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback = paramRefreshCallback;
  }
  
  public void setScrollEventCallback(ReadInJoyBaseListView.ScrollEventCallback paramScrollEventCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$ScrollEventCallback = paramScrollEventCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView
 * JD-Core Version:    0.7.0.1
 */