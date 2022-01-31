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
import begh;
import begj;
import com.tencent.biz.qqstory.base.QQStoryIllegalException;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import mpq;
import ulq;
import urk;
import vkw;
import vpm;
import vpn;
import vpo;
import vpp;
import vpq;
import vps;
import vpu;
import vpv;
import vqi;
import vqk;
import vqo;

public abstract class SegmentList
  extends QQStoryPullToRefreshListView
  implements begj, vpu
{
  public static int c;
  public static int d = 1;
  public static int e = 2;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private begh jdField_a_of_type_Begh;
  private begj jdField_a_of_type_Begj;
  private String jdField_a_of_type_JavaLangString;
  public vps a;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "default";
  private vqi jdField_b_of_type_Vqi;
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
      setAdapter(this.jdField_a_of_type_Vps);
      f();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Vps = new vps(this, this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new vpm(this));
    super.setRecyclerListener(this);
    super.setDragEnable(true);
    super.setSwipListListener(new vpn(this));
    super.setRightIconMenuListener(new vpo(this));
  }
  
  public <T extends vpv> T a(String paramString)
  {
    return this.jdField_a_of_type_Vps.a(paramString);
  }
  
  public vqi a(@NonNull String paramString)
  {
    vkw.a(paramString);
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_b_of_type_Vqi;
    }
    return null;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    ulq.c("SwipListView", new Object[] { "allRequestCompletedAndSuccess ", Integer.valueOf(paramInt) });
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
    ulq.c("SwipListView", new Object[] { "allRequestCompletedButOccurError ", Integer.valueOf(paramInt1) });
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
    this.jdField_a_of_type_Vps.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(@NonNull String paramString)
  {
    this.jdField_a_of_type_Vps.a(paramString);
  }
  
  public void a(@NonNull vpv paramvpv)
  {
    this.jdField_a_of_type_Vps.a(paramvpv);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (!mpq.a(getContext().getApplicationContext()))
    {
      a(1, d);
      return true;
    }
    this.jdField_a_of_type_Vqo.a();
    return true;
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_Vps.a(paramView);
    if (this.jdField_a_of_type_Begj != null) {
      this.jdField_a_of_type_Begj.b(paramView);
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
    this.jdField_a_of_type_Vps.a(true);
  }
  
  public void j()
  {
    setPullToRefreshListener(new vpp(this));
    a();
    this.jdField_a_of_type_Vps.a();
    Bosses.get().postJob(new vpq(this, "SwipListView"));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Vps.c();
  }
  
  public void l()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Vps.d();
  }
  
  public void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      this.jdField_a_of_type_Vps.e();
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Vps.a();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      urk.e("SwipListView", localIllegalStateException.toString() + " ##info: mItemCount=" + this.mItemCount + "mAdapter.getCount()=" + this.jdField_a_of_type_Vps.getCount() + " .last segmentSimpleInfo=" + this.jdField_b_of_type_JavaLangString + " ,and current segmentSimpleInfo=" + this.jdField_a_of_type_Vps.a());
      if (!this.jdField_c_of_type_Boolean) {
        throw localIllegalStateException;
      }
      if (this.mItemCount == this.jdField_a_of_type_Vps.getCount()) {
        throw localIllegalStateException;
      }
      throw new QQStoryIllegalException(localIllegalStateException.toString() + " ##info: mItemCount=" + this.mItemCount + "mAdapter.getCount()=" + this.jdField_a_of_type_Vps.getCount() + " .last segmentSimpleInfo=" + this.jdField_b_of_type_JavaLangString + " ,and current segmentSimpleInfo=" + this.jdField_a_of_type_Vps.a());
    }
  }
  
  public void n()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.jdField_b_of_type_Vqi = new vqi(localLoadMoreLayout, getContext().getApplicationContext());
    this.jdField_b_of_type_Vqi.a(true, false);
    super.addFooterView(localLoadMoreLayout);
    super.setOnScrollListener(this);
  }
  
  public void o()
  {
    this.jdField_a_of_type_Vps.b();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Begh != null) {
      this.jdField_a_of_type_Begh.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.jdField_a_of_type_Int) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_b_of_type_Vqi.a());
    this.jdField_b_of_type_Vqi.b(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Begh != null) {
      this.jdField_a_of_type_Begh.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_Vps.notifyDataSetChanged();
  }
  
  public void q()
  {
    if (this.jdField_c_of_type_Boolean) {
      super.setAdapter(this.jdField_a_of_type_Vps);
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    this.jdField_a_of_type_Vps.a(paramInt);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof vps))
    {
      super.setAdapter(paramListAdapter);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    throw new QQStoryIllegalException("SegmentList do not necessary call setAdapter()");
  }
  
  public void setLoadMoreComplete(@NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    vkw.a(paramString);
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_b_of_type_Vqi.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setOnLoadMoreListener(@NonNull String paramString, vqk paramvqk)
  {
    this.jdField_b_of_type_Vqi.a(paramvqk);
    this.jdField_a_of_type_JavaLangString = paramString;
    vkw.a(paramString);
  }
  
  public void setOnScrollListener(begh parambegh)
  {
    this.jdField_a_of_type_Begh = parambegh;
  }
  
  public void setRecyclerListener(begj parambegj)
  {
    this.jdField_a_of_type_Begj = parambegj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentList
 * JD-Core Version:    0.7.0.1
 */