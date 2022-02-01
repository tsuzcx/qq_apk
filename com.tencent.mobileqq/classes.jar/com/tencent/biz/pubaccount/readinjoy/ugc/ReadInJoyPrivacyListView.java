package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;

public class ReadInJoyPrivacyListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyPrivacyListView.LoadMoreCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView$LoadMoreCallback;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  
  public ReadInJoyPrivacyListView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ReadInJoyPrivacyListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ReadInJoyPrivacyListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setDivider(getResources().getDrawable(2130849817));
    setDividerHeight(AIOUtils.a(0.5F, getResources()));
    setOnScrollListener(this);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560108, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373701));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373702));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A6A6A6"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, null, false);
    setFooterDividersEnabled(false);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = true;
    e();
    if ((this.b) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView$LoadMoreCallback != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView$LoadMoreCallback.b();
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718322);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_Boolean = false;
      QLog.d("ReadInJoyPrivacyListView", 2, "loadMoreFail");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718321);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ReadInJoyPrivacyListView.1(this));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      c();
    }
    this.jdField_a_of_type_Boolean = false;
    QLog.d("ReadInJoyPrivacyListView", 2, "loading complete " + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    for (;;)
    {
      ((BaseAdapter)((HeaderViewListAdapter)getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
      return;
      removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.b = false;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.b) && (!this.jdField_a_of_type_Boolean)) {
      d();
    }
  }
  
  public void setLoadMoreCallback(ReadInJoyPrivacyListView.LoadMoreCallback paramLoadMoreCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView$LoadMoreCallback = paramLoadMoreCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListView
 * JD-Core Version:    0.7.0.1
 */