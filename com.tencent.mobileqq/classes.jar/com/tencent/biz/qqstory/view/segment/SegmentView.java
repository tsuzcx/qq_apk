package com.tencent.biz.qqstory.view.segment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.utils.AssertUtils;

public abstract class SegmentView<T>
{
  protected Context a;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private SegmentManager jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager;
  protected boolean a;
  
  public SegmentView(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  protected void M_() {}
  
  public void P_() {}
  
  protected void R_() {}
  
  public abstract int a();
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public abstract View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup);
  
  public BaseViewHolder a(int paramInt)
  {
    Object localObject = a();
    int i = 0;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("segment:");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" have not attach to listView. It can not check isOnScreen.");
      AssertUtils.fail(((StringBuilder)localObject).toString(), new Object[0]);
      return null;
    }
    while (i < ((SegmentList)localObject).getChildCount())
    {
      BaseViewHolder localBaseViewHolder = (BaseViewHolder)((SegmentList)localObject).getChildAt(i).getTag();
      if ((localBaseViewHolder != null) && (localBaseViewHolder.a.equals(a())) && (localBaseViewHolder.b == paramInt)) {
        return localBaseViewHolder;
      }
      i += 1;
    }
    return null;
  }
  
  public abstract BaseViewHolder a(int paramInt, ViewGroup paramViewGroup);
  
  protected SegmentList a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  }
  
  public abstract String a();
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(SegmentManager paramSegmentManager, SegmentList paramSegmentList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager = paramSegmentManager;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(BaseViewHolder paramBaseViewHolder)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null)
    {
      paramBaseViewHolder = new StringBuilder();
      paramBaseViewHolder.append("segment:");
      paramBaseViewHolder.append(a());
      paramBaseViewHolder.append(" have not attach to listView. It can not check isOnScreen.");
      AssertUtils.fail(paramBaseViewHolder.toString(), new Object[0]);
      return false;
    }
    if (paramBaseViewHolder == null) {
      return false;
    }
    int i = localSegmentList.getFirstVisiblePosition();
    int j = localSegmentList.getLastVisiblePosition();
    int k = paramBaseViewHolder.c;
    return (k >= i) && (k <= j);
  }
  
  public void a_(BaseViewHolder paramBaseViewHolder) {}
  
  public void a_(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    return false;
  }
  
  public String b()
  {
    return "";
  }
  
  protected void b() {}
  
  public void b_(BaseViewHolder paramBaseViewHolder) {}
  
  protected void c() {}
  
  public void c(BaseViewHolder paramBaseViewHolder) {}
  
  public final void c(boolean paramBoolean)
  {
    AssertUtils.mainThreadCheck();
    SegmentManager localSegmentManager = this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager;
    if (localSegmentManager != null)
    {
      localSegmentManager.a(a(), paramBoolean);
      this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.notifyDataSetChanged();
    }
    InfoPrinter.b("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged ", Boolean.valueOf(paramBoolean) });
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return a();
    }
    return 0;
  }
  
  protected void d() {}
  
  public void d(int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(this, paramInt);
    a().setSelection(paramInt);
  }
  
  protected boolean d()
  {
    SegmentList localSegmentList = this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
    if (localSegmentList == null) {
      return false;
    }
    localSegmentList.a(a());
    return true;
  }
  
  protected int d_()
  {
    return 1;
  }
  
  public void f_(int paramInt) {}
  
  public void k() {}
  
  protected void m()
  {
    SegmentManager localSegmentManager = this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager;
    if (localSegmentManager == null) {
      return;
    }
    localSegmentManager.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentView
 * JD-Core Version:    0.7.0.1
 */