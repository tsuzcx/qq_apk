package com.tencent.biz.pubaccount.readinjoy.comment;

import abvl;
import alud;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhtv;
import bhxm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import okz;
import oll;
import olm;
import oln;
import olo;

public class ReadInJoyCommentListView
  extends XListView
{
  protected int a;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  private okz jdField_a_of_type_Okz;
  private oln jdField_a_of_type_Oln = new oll(this);
  public olo a;
  public boolean a;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int c = 3;
  
  public ReadInJoyCommentListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    h();
  }
  
  public ReadInJoyCommentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    h();
  }
  
  public ReadInJoyCommentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    h();
  }
  
  private boolean a()
  {
    if (getAdapter() == null) {}
    while ((getFooterViewsCount() <= 0) || (getLastVisiblePosition() != getAdapter().getCount() - 1)) {
      return false;
    }
    return true;
  }
  
  private void h()
  {
    setOnScrollListener(this.jdField_a_of_type_Oln);
  }
  
  private void i()
  {
    if ((a()) && (this.jdField_a_of_type_Olo != null))
    {
      QLog.d("ReadInJoyCommentListView", 2, "loadingMore| hasMore " + this.jdField_a_of_type_Boolean);
      j();
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Olo.a(this);
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689557);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Olo != null)
    {
      QLog.d("ReadInJoyCommentListView", 2, "preLoadingMore | hasMore " + this.jdField_a_of_type_Boolean);
      j();
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Olo.a(this);
    }
  }
  
  private void l()
  {
    Object localObject = getAdapter();
    if ((localObject instanceof bhxm))
    {
      localObject = (bhxm)localObject;
      if ((((bhxm)localObject).getWrappedAdapter() instanceof BaseAdapter)) {
        ((BaseAdapter)((bhxm)localObject).getWrappedAdapter()).notifyDataSetChanged();
      }
    }
    while (!(localObject instanceof BaseAdapter)) {
      return;
    }
    ((BaseAdapter)localObject).notifyDataSetChanged();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559841, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372497));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372498));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A6A6A6"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, null, false);
    setFooterDividersEnabled(false);
  }
  
  public void a(bhtv parambhtv)
  {
    if (this.jdField_a_of_type_Oln != null) {
      this.jdField_a_of_type_Oln.b(parambhtv);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      abvl.a().a("list_comment_kandian", false);
      if ((paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.jdField_a_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentListView", 2, "on the bottom ");
        }
        if (this.jdField_a_of_type_Int == 1) {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyCommentListView", 2, "network request ing");
          }
        }
      }
      do
      {
        do
        {
          return;
          QLog.d("ReadInJoyCommentListView", 2, "loadmore comment by scroll");
          i();
          return;
        } while ((paramAbsListView.getCount() - paramAbsListView.getLastVisiblePosition() >= this.c) || (!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean));
        if (this.jdField_a_of_type_Int != 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyCommentListView", 2, "network request ing");
      return;
      QLog.d("ReadInJoyCommentListView", 2, "preLoadingmore comment");
      k();
      return;
    }
    abvl.a().a("list_comment_kandian");
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
      a();
    }
    QLog.d("ReadInJoyCommentListView", 2, "loadingMoreComplete | hasNextPage " + paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      b();
    }
    this.jdField_a_of_type_Int = 0;
    l();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentListView", 2, "loadMoreFail");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131713162));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new olm(this));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (getFooterViewsCount() > 0)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    QLog.d("ReadInJoyCommentListView", 2, "hideFooterView hasMoreData false");
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void e()
  {
    QLog.d("ReadInJoyCommentListView", 2, "resetState hasMoreData false");
    f();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    setEmptyView(null);
  }
  
  public void f()
  {
    QLog.d("ReadInJoyCommentListView", 2, "resetFooterView");
    if (getFooterViewsCount() <= 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, null, false);
      }
    }
    else {
      return;
    }
    a();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (getFooterViewsCount() > 0))
    {
      QLog.d("ReadInJoyCommentListView", 2, "hideLoadingFooter");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void setOnScrollListener(bhtv parambhtv)
  {
    if ((parambhtv instanceof oln)) {
      super.setOnScrollListener(this.jdField_a_of_type_Oln);
    }
    while (this.jdField_a_of_type_Oln == null) {
      return;
    }
    this.jdField_a_of_type_Oln.a(parambhtv);
  }
  
  public void setOnScrollOffsetYListener(okz paramokz)
  {
    this.jdField_a_of_type_Okz = paramokz;
  }
  
  public void setRefreshCallback(olo paramolo)
  {
    this.jdField_a_of_type_Olo = paramolo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView
 * JD-Core Version:    0.7.0.1
 */