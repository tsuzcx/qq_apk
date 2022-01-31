package com.tencent.biz.qqstory.view.segment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.utils.AssertUtils;

public abstract class SegmentView
{
  public Context a;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private SegmentManager jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager;
  public boolean a;
  
  public SegmentView(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void J_() {}
  
  public abstract int a();
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public abstract View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup);
  
  public BaseViewHolder a(int paramInt)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null)
    {
      AssertUtils.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
      return null;
    }
    int i = 0;
    if (i < localSegmentList.getChildCount())
    {
      BaseViewHolder localBaseViewHolder = (BaseViewHolder)localSegmentList.getChildAt(i).getTag();
      if (localBaseViewHolder == null) {}
      while ((!localBaseViewHolder.a.equals(a())) || (localBaseViewHolder.b != paramInt))
      {
        i += 1;
        break;
      }
      return localBaseViewHolder;
    }
    return null;
  }
  
  public abstract BaseViewHolder a(int paramInt, ViewGroup paramViewGroup);
  
  public SegmentList a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  }
  
  public abstract String a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(SegmentManager paramSegmentManager, SegmentList paramSegmentList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager = paramSegmentManager;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void a_(BaseViewHolder paramBaseViewHolder) {}
  
  @Deprecated
  public void a_(Object paramObject) {}
  
  public boolean a_(boolean paramBoolean)
  {
    return false;
  }
  
  public String b()
  {
    return "";
  }
  
  public void b() {}
  
  public void b_(BaseViewHolder paramBaseViewHolder) {}
  
  public void c() {}
  
  public void c(BaseViewHolder paramBaseViewHolder) {}
  
  public final void c(boolean paramBoolean)
  {
    
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.a(a(), paramBoolean);
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
  
  public void d() {}
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.a(a());
    return true;
  }
  
  public int d_()
  {
    return 1;
  }
  
  public void e() {}
  
  public void e_(int paramInt) {}
  
  public void f_(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public void g() {}
  
  public void k() {}
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentView
 * JD-Core Version:    0.7.0.1
 */