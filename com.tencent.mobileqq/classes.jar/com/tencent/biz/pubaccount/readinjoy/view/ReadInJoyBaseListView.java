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
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.XListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;

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
  private ReadInJoyBaseListView.ScrollEventCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$ScrollEventCallback = null;
  private ArrayList<ListView.OnScrollChangeListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean a;
  protected int b;
  public boolean b;
  protected int c;
  protected boolean c;
  protected int d;
  private boolean d;
  
  public ReadInJoyBaseListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a(paramContext, paramAttributeSet);
  }
  
  private boolean a()
  {
    if (getAdapter() == null) {}
    while ((getFooterViewsCount() <= 0) || (getLastVisiblePosition() != getAdapter().getCount() - 1)) {
      return false;
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), 0, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), paramInt);
    }
  }
  
  private void c()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(62.0F, getResources())));
    TextView localTextView = new TextView(getContext());
    localTextView.setText(2131718262);
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
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560506, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373701));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373702));
    addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (paramInt == 4) {
          break;
        }
      } while ((!a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback == null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699731);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      b(0);
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback.b(this, paramInt);
      return;
      if (a())
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699731);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        b(0);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback == null);
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback.b(this, paramInt);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ReadInJoyXListView);
    this.jdField_d_of_type_Boolean = paramContext.getBoolean(0, false);
    paramContext.recycle();
    if (this.jdField_d_of_type_Boolean) {
      a();
    }
    if (ReadinjoyReportUtils.a(this.jdField_d_of_type_Int)) {
      c();
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
  
  public void a(ListView.OnScrollChangeListener paramOnScrollChangeListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramOnScrollChangeListener);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699730);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      b(-this.jdField_a_of_type_Int);
    }
    setFooterView(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseListView", 2, new Object[] { "loadingMoreComplete mCurrentStatus = ", Integer.valueOf(this.jdField_c_of_type_Int), ", hasMoreData = ", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$MultiScrollListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$MultiScrollListener.a();
    }
  }
  
  public void b(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$MultiScrollListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$MultiScrollListener.b(paramOnScrollListener);
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.jdField_a_of_type_Int < 0) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      b(-this.jdField_a_of_type_Int);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_Int < 0) && (this.jdField_c_of_type_Int != 1) && (paramInt1 >= paramInt3 - paramInt2 * 2) && ((!ReadinjoyReportUtils.a(this.jdField_d_of_type_Int)) || (!this.jdField_b_of_type_Boolean))) {
      a(2);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ListView.OnScrollChangeListener)localIterator.next()).onScrollChanged(this.mFirstPosition, getChildCount(), this.mItemCount);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1) {
      if (paramInt != 2) {
        break label25;
      }
    }
    label25:
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      return;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter != null) && ((paramListAdapter instanceof ReadInJoyBaseAdapter))) {
      ((ReadInJoyBaseAdapter)paramListAdapter).a(new ReadInJoyBaseListView.1(this));
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setCurrentStatus(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      if (ReadinjoyReportUtils.a(this.jdField_d_of_type_Int))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          c();
        }
        removeFooterView(this.jdField_a_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        a();
      }
      if (getFooterViewsCount() <= 0) {
        addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
    }
    do
    {
      return;
      if (ReadinjoyReportUtils.a(this.jdField_d_of_type_Int))
      {
        removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        if (this.jdField_a_of_type_AndroidViewView == null) {
          c();
        }
        if (getFooterViewsCount() <= 0) {
          addFooterView(this.jdField_a_of_type_AndroidViewView);
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        a();
      }
      if ((ReadInJoyHelper.m()) && ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 56)))
      {
        QLog.d("ReadInJoyBaseListView", 1, "independent kd recommend and video channel, keep footer view.");
        return;
      }
    } while (getFooterViewsCount() <= 0);
    removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void setNeedShowFootView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    a();
  }
  
  public void setNoMoreData(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (!this.jdField_b_of_type_Boolean) {
        break label74;
      }
      if (ReadinjoyReportUtils.a(this.jdField_d_of_type_Int))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          c();
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
        if (getFooterViewsCount() <= 0) {
          addFooterView(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
    label74:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView
 * JD-Core Version:    0.7.0.1
 */