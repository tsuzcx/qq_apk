package com.tencent.biz.qqstory.view.widget;

import adlb;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import bhnv;
import blih;
import blnt;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import zti;
import ztm;
import zto;

public class QQStoryPullToRefreshListView
  extends SwipListView
  implements blih, blnt
{
  private int jdField_a_of_type_Int = -1;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private blih jdField_a_of_type_Blih;
  private String jdField_a_of_type_JavaLangString;
  public zti a;
  private ztm jdField_a_of_type_Ztm = new ztm(this);
  protected zto a;
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
    if (!bhnv.g(getContext().getApplicationContext())) {
      a(false);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Zto.a();
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
    this.jdField_a_of_type_Zti = new zti(localLoadMoreLayout, getContext().getApplicationContext());
    super.addFooterView(localLoadMoreLayout);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Blih != null) {
      this.jdField_a_of_type_Blih.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.jdField_a_of_type_Int) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_a_of_type_Zti.a());
    this.jdField_a_of_type_Zti.b(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Blih != null) {
      this.jdField_a_of_type_Blih.onScrollStateChanged(paramAbsListView, paramInt);
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
        adlb.a().a(this.jdField_a_of_type_JavaLangString, false);
      }
    }
    else {
      return;
    }
    adlb.a().a(this.jdField_a_of_type_JavaLangString);
  }
  
  protected void s()
  {
    this.b = ((PullRefreshHeader)LayoutInflater.from(super.getContext()).inflate(2131561828, this, false));
    this.b.setTextColor(-1, -1, -1, -1, -1);
    this.b.setHeaderBgDrawable(getResources().getDrawable(2130839405));
    super.setOverScrollHeight(super.getResources().getDimensionPixelSize(2131298761));
    super.setOverScrollHeader(this.b);
    super.setOverScrollListener(this.jdField_a_of_type_Ztm);
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setOnScrollListener(blih paramblih)
  {
    this.jdField_a_of_type_Blih = paramblih;
  }
  
  public void setOnTouchExtraListener(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
  }
  
  public void setPullToRefreshListener(zto paramzto)
  {
    this.jdField_a_of_type_Zto = paramzto;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView
 * JD-Core Version:    0.7.0.1
 */