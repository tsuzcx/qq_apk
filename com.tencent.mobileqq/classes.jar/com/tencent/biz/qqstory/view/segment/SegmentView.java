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
  private SegmentManager a;
  private SegmentList b;
  protected Context l;
  protected boolean m = true;
  
  public SegmentView(Context paramContext)
  {
    this.l = paramContext;
  }
  
  public abstract int a();
  
  public abstract View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup);
  
  public abstract BaseViewHolder a(int paramInt, ViewGroup paramViewGroup);
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(SegmentManager paramSegmentManager, SegmentList paramSegmentList)
  {
    this.a = paramSegmentManager;
    this.b = paramSegmentList;
  }
  
  public void a_(BaseViewHolder paramBaseViewHolder) {}
  
  public abstract String b();
  
  public void b(int paramInt) {}
  
  public void b_(BaseViewHolder paramBaseViewHolder) {}
  
  public void br_() {}
  
  protected void bs_() {}
  
  public boolean bt_()
  {
    return true;
  }
  
  protected void bz_() {}
  
  public void c(BaseViewHolder paramBaseViewHolder) {}
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean != this.m) {
      this.m = paramBoolean;
    }
  }
  
  protected boolean d(boolean paramBoolean)
  {
    return false;
  }
  
  public final void e(boolean paramBoolean)
  {
    AssertUtils.mainThreadCheck();
    SegmentManager localSegmentManager = this.a;
    if (localSegmentManager != null)
    {
      localSegmentManager.a(b(), paramBoolean);
      this.a.notifyDataSetChanged();
    }
    InfoPrinter.b("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged ", Boolean.valueOf(paramBoolean) });
  }
  
  public boolean e(BaseViewHolder paramBaseViewHolder)
  {
    SegmentList localSegmentList = w();
    if (localSegmentList == null)
    {
      paramBaseViewHolder = new StringBuilder();
      paramBaseViewHolder.append("segment:");
      paramBaseViewHolder.append(b());
      paramBaseViewHolder.append(" have not attach to listView. It can not check isOnScreen.");
      AssertUtils.fail(paramBaseViewHolder.toString(), new Object[0]);
      return false;
    }
    if (paramBaseViewHolder == null) {
      return false;
    }
    int i = localSegmentList.getFirstVisiblePosition();
    int j = localSegmentList.getLastVisiblePosition();
    int k = paramBaseViewHolder.g;
    return (k >= i) && (k <= j);
  }
  
  protected int f()
  {
    return 1;
  }
  
  public BaseViewHolder f(int paramInt)
  {
    Object localObject = w();
    int i = 0;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("segment:");
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append(" have not attach to listView. It can not check isOnScreen.");
      AssertUtils.fail(((StringBuilder)localObject).toString(), new Object[0]);
      return null;
    }
    while (i < ((SegmentList)localObject).getChildCount())
    {
      BaseViewHolder localBaseViewHolder = (BaseViewHolder)((SegmentList)localObject).getChildAt(i).getTag();
      if ((localBaseViewHolder != null) && (localBaseViewHolder.e.equals(b())) && (localBaseViewHolder.f == paramInt)) {
        return localBaseViewHolder;
      }
      i += 1;
    }
    return null;
  }
  
  protected void g() {}
  
  public void g(int paramInt)
  {
    paramInt = this.a.a(this, paramInt);
    w().setSelection(paramInt);
  }
  
  protected int g_(int paramInt)
  {
    return 0;
  }
  
  protected void h() {}
  
  protected void i() {}
  
  public void o() {}
  
  public int s()
  {
    if (this.m) {
      return a();
    }
    return 0;
  }
  
  public boolean t()
  {
    return this.m;
  }
  
  protected void u()
  {
    SegmentManager localSegmentManager = this.a;
    if (localSegmentManager == null) {
      return;
    }
    localSegmentManager.notifyDataSetChanged();
  }
  
  protected boolean v()
  {
    SegmentList localSegmentList = this.b;
    if (localSegmentList == null) {
      return false;
    }
    localSegmentList.a(b());
    return true;
  }
  
  protected SegmentList w()
  {
    return this.b;
  }
  
  public String x()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentView
 * JD-Core Version:    0.7.0.1
 */