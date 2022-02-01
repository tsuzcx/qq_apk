package com.tencent.biz.pubaccount.readinjoy.ugc;

import agej;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import blih;
import blmb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import rbn;
import rbo;

public class ReadInJoyPrivacyListView
  extends XListView
  implements blih
{
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private rbo jdField_a_of_type_Rbo;
  private boolean jdField_a_of_type_Boolean;
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
    setDivider(getResources().getDrawable(2130849429));
    setDividerHeight(agej.a(0.5F, getResources()));
    setOnScrollListener(this);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559983, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373211));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373212));
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
    if ((this.b) && (this.jdField_a_of_type_Rbo != null)) {
      this.jdField_a_of_type_Rbo.b();
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717220);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717219);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new rbn(this));
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
      ((BaseAdapter)((blmb)getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
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
  
  public void setLoadMoreCallback(rbo paramrbo)
  {
    this.jdField_a_of_type_Rbo = paramrbo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListView
 * JD-Core Version:    0.7.0.1
 */