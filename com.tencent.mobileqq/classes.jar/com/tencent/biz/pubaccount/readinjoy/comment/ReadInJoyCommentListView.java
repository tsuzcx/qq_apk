package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public class ReadInJoyCommentListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  protected int a;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  public ReadInJoyCommentListView.RefreshCallback a;
  public boolean a;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int c = 10;
  
  public ReadInJoyCommentListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public ReadInJoyCommentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public ReadInJoyCommentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  private boolean a()
  {
    if (getAdapter() == null) {}
    while ((getFooterViewsCount() <= 0) || (getLastVisiblePosition() != getAdapter().getCount() - 1)) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    setOnScrollListener(this);
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2130969525, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366826));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366827));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, null, false);
    setFooterDividersEnabled(false);
  }
  
  private void e()
  {
    if ((a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$RefreshCallback != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentListView", 2, "loadingMore");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438562);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$RefreshCallback.a(this);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$RefreshCallback != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentListView", 2, "preLoadingMore");
      }
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$RefreshCallback.a(this);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentListView", 2, "loadMoreFail");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("网络异常，加载失败");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((paramAbsListView.getLastVisiblePosition() != paramAbsListView.getCount() - 1) || (!this.jdField_a_of_type_Boolean)) {
        break label76;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentListView", 2, "on the bottom");
      }
      if ((this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) && (this.jdField_a_of_type_Int != 1)) {
        break label71;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentListView", 2, "network request ing");
      }
    }
    label71:
    label76:
    do
    {
      do
      {
        return;
        e();
        return;
      } while ((paramAbsListView.getCount() - paramAbsListView.getLastVisiblePosition() >= this.c) || (!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean));
      if ((this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) && (this.jdField_a_of_type_Int != 1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyCommentListView", 2, "network request ing");
    return;
    f();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > this.jdField_b_of_type_Int) {
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt1;
      return;
      if (paramInt1 < this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      d();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentListView", 2, "loading complete " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438876);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (getFooterViewsCount() > 0)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setRefreshCallback(ReadInJoyCommentListView.RefreshCallback paramRefreshCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$RefreshCallback = paramRefreshCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView
 * JD-Core Version:    0.7.0.1
 */