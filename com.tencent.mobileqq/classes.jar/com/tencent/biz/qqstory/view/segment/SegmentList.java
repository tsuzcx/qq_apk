package com.tencent.biz.qqstory.view.segment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import blih;
import blij;
import com.tencent.biz.qqstory.base.QQStoryIllegalException;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import nny;
import yoq;
import yuk;
import znw;
import zsm;
import zsn;
import zso;
import zsp;
import zsq;
import zss;
import zsu;
import zsv;
import zti;
import ztk;
import zto;

public abstract class SegmentList
  extends QQStoryPullToRefreshListView
  implements blij, zsu
{
  public static int c;
  public static int d = 1;
  public static int e = 2;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private blih jdField_a_of_type_Blih;
  private blij jdField_a_of_type_Blij;
  private String jdField_a_of_type_JavaLangString;
  public zss a;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "default";
  private zti jdField_b_of_type_Zti;
  protected boolean b;
  private boolean c;
  
  public SegmentList(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public SegmentList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public SegmentList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_Boolean) {
        return false;
      }
      setAdapter(this.jdField_a_of_type_Zss);
      f();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Zss = new zss(this, this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new zsm(this));
    super.setRecyclerListener(this);
    super.setDragEnable(true);
    super.setSwipListListener(new zsn(this));
    super.setRightIconMenuListener(new zso(this));
  }
  
  public <T extends zsv> T a(String paramString)
  {
    return this.jdField_a_of_type_Zss.a(paramString);
  }
  
  public zti a(@NonNull String paramString)
  {
    znw.a(paramString);
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_b_of_type_Zti;
    }
    return null;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    yoq.c("SwipListView", new Object[] { "allRequestCompletedAndSuccess ", Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 1: 
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
        super.postDelayed(new SegmentList.6(this), 800L);
      }
      b(true, jdField_c_of_type_Int);
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      g();
      this.jdField_b_of_type_Boolean = true;
    }
    a(true, jdField_c_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    yoq.c("SwipListView", new Object[] { "allRequestCompletedButOccurError ", Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    case 2: 
    default: 
      return;
    case 1: 
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
        super.postDelayed(new SegmentList.7(this), 800L);
      }
      b(false, paramInt2);
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      g();
      this.jdField_b_of_type_Boolean = true;
    }
    a(false, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Zss.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Zss.a(paramString);
  }
  
  public void a(@NonNull zsv paramzsv)
  {
    this.jdField_a_of_type_Zss.a(paramzsv);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (!nny.a(getContext().getApplicationContext()))
    {
      a(1, d);
      return true;
    }
    this.jdField_a_of_type_Zto.a();
    return true;
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_Zss.a(paramView);
    if (this.jdField_a_of_type_Blij != null) {
      this.jdField_a_of_type_Blij.b(paramView);
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt) {}
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void f()
  {
    h();
  }
  
  public void g() {}
  
  public void h()
  {
    this.jdField_a_of_type_Zss.a(true);
  }
  
  public void j()
  {
    setPullToRefreshListener(new zsp(this));
    a();
    this.jdField_a_of_type_Zss.a();
    Bosses.get().postJob(new zsq(this, "SwipListView"));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Zss.c();
  }
  
  public void l()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Zss.d();
  }
  
  public void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      this.jdField_a_of_type_Zss.e();
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Zss.a();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      yuk.e("SwipListView", localIllegalStateException.toString() + " ##info: mItemCount=" + this.mItemCount + "mAdapter.getCount()=" + this.jdField_a_of_type_Zss.getCount() + " .last segmentSimpleInfo=" + this.jdField_b_of_type_JavaLangString + " ,and current segmentSimpleInfo=" + this.jdField_a_of_type_Zss.a());
      if (!this.jdField_c_of_type_Boolean) {
        throw localIllegalStateException;
      }
      if (this.mItemCount == this.jdField_a_of_type_Zss.getCount()) {
        throw localIllegalStateException;
      }
      throw new QQStoryIllegalException(localIllegalStateException.toString() + " ##info: mItemCount=" + this.mItemCount + "mAdapter.getCount()=" + this.jdField_a_of_type_Zss.getCount() + " .last segmentSimpleInfo=" + this.jdField_b_of_type_JavaLangString + " ,and current segmentSimpleInfo=" + this.jdField_a_of_type_Zss.a());
    }
  }
  
  public void n()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.jdField_b_of_type_Zti = new zti(localLoadMoreLayout, getContext().getApplicationContext());
    this.jdField_b_of_type_Zti.a(true, false);
    super.addFooterView(localLoadMoreLayout);
    super.setOnScrollListener(this);
  }
  
  public void o()
  {
    this.jdField_a_of_type_Zss.b();
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
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_b_of_type_Zti.a());
    this.jdField_b_of_type_Zti.b(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Blih != null) {
      this.jdField_a_of_type_Blih.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_Zss.notifyDataSetChanged();
  }
  
  public void q()
  {
    if (this.jdField_c_of_type_Boolean) {
      super.setAdapter(this.jdField_a_of_type_Zss);
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    this.jdField_a_of_type_Zss.a(paramInt);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof zss))
    {
      super.setAdapter(paramListAdapter);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    throw new QQStoryIllegalException("SegmentList do not necessary call setAdapter()");
  }
  
  public void setLoadMoreComplete(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    znw.a(paramString);
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_Zti.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setOnLoadMoreListener(@NonNull String paramString, ztk paramztk)
  {
    this.jdField_b_of_type_Zti.a(paramztk);
    this.jdField_a_of_type_JavaLangString = paramString;
    znw.a(paramString);
  }
  
  public void setOnScrollListener(blih paramblih)
  {
    this.jdField_a_of_type_Blih = paramblih;
  }
  
  public void setRecyclerListener(blij paramblij)
  {
    this.jdField_a_of_type_Blij = paramblij;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentList
 * JD-Core Version:    0.7.0.1
 */