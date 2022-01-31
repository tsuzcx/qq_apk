package com.tencent.biz.qqstory.view.widget;

import abqw;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import bdee;
import bhpo;
import bhuy;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import xrt;
import xrx;
import xrz;

public class QQStoryPullToRefreshListView
  extends SwipListView
  implements bhpo, bhuy
{
  private int jdField_a_of_type_Int = -1;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private bhpo jdField_a_of_type_Bhpo;
  private String jdField_a_of_type_JavaLangString;
  public xrt a;
  private xrx jdField_a_of_type_Xrx = new xrx(this);
  protected xrz a;
  public PullRefreshHeader b;
  
  public QQStoryPullToRefreshListView(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    a();
  }
  
  public QQStoryPullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QQStoryPullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    r();
    super.setOnScrollListener(this);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.b.c(0L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    if (paramBoolean) {
      this.b.a(0);
    }
    for (;;)
    {
      postDelayed(new QQStoryPullToRefreshListView.1(this), 800L);
      return;
      this.b.a(1);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.b.a(0L);
    if (!bdee.g(getContext().getApplicationContext())) {
      a(false);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Xrz.a();
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.b.b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    this.b.a(0L);
  }
  
  protected void n()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.jdField_a_of_type_Xrt = new xrt(localLoadMoreLayout, getContext().getApplicationContext());
    super.addFooterView(localLoadMoreLayout);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.jdField_a_of_type_Int) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_a_of_type_Xrt.a());
    this.jdField_a_of_type_Xrt.b(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    View.OnTouchListener localOnTouchListener = this.jdField_a_of_type_AndroidViewView$OnTouchListener;
    if (localOnTouchListener != null) {
      localOnTouchListener.onTouch(this, paramMotionEvent);
    }
    return bool;
  }
  
  protected void r()
  {
    n();
    s();
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramInt == 0) {
        abqw.a().a(this.jdField_a_of_type_JavaLangString, false);
      }
    }
    else {
      return;
    }
    abqw.a().a(this.jdField_a_of_type_JavaLangString);
  }
  
  protected void s()
  {
    this.b = ((PullRefreshHeader)LayoutInflater.from(super.getContext()).inflate(2131561534, this, false));
    this.b.setTextColor(-1, -1, -1, -1, -1);
    this.b.setHeaderBgDrawable(getResources().getDrawable(2130839219));
    super.setOverScrollHeight(super.getResources().getDimensionPixelSize(2131298665));
    super.setOverScrollHeader(this.b);
    super.setOverScrollListener(this.jdField_a_of_type_Xrx);
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setOnScrollListener(bhpo parambhpo)
  {
    this.jdField_a_of_type_Bhpo = parambhpo;
  }
  
  public void setOnTouchExtraListener(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
  }
  
  public void setPullToRefreshListener(xrz paramxrz)
  {
    this.jdField_a_of_type_Xrz = paramxrz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView
 * JD-Core Version:    0.7.0.1
 */