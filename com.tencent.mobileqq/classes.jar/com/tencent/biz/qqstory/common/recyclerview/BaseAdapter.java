package com.tencent.biz.qqstory.common.recyclerview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<M, VH extends BaseViewHolder<M>>
  extends HeaderAndFooterAdapter<M, VH>
{
  private List<M> f = new ArrayList();
  
  public BaseAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract int a(int paramInt);
  
  public int a(M paramM)
  {
    int i = this.f.indexOf(paramM);
    if (i < 0) {
      return i;
    }
    this.f.set(i, paramM);
    if (this.a == null)
    {
      notifyItemChanged(i);
      return i;
    }
    notifyItemChanged(i + 1);
    return i;
  }
  
  public void a()
  {
    this.f.clear();
    notifyDataSetChanged();
  }
  
  public void a(M paramM, int paramInt)
  {
    int i = this.f.indexOf(paramM);
    if (i != -1) {
      this.f.remove(i);
    }
    this.f.add(paramInt, paramM);
    if (i != -1)
    {
      if (this.a == null)
      {
        notifyItemMoved(i, paramInt);
        notifyItemChanged(paramInt);
        return;
      }
      paramInt += 1;
      notifyItemMoved(i + 1, paramInt);
      notifyItemChanged(paramInt);
      return;
    }
    if (this.a == null)
    {
      notifyItemInserted(paramInt);
      return;
    }
    notifyItemInserted(paramInt + 1);
  }
  
  public boolean a(List<M> paramList)
  {
    boolean bool = this.f.isEmpty();
    this.f.clear();
    bool = this.f.addAll(paramList) | bool ^ true;
    if (bool) {
      notifyDataSetChanged();
    }
    return bool;
  }
  
  public M b(int paramInt)
  {
    if (((this.a != null) && (paramInt == 0)) || (paramInt >= this.f.size() + d())) {
      return null;
    }
    List localList;
    if (this.a == null)
    {
      localList = this.f;
    }
    else
    {
      localList = this.f;
      paramInt -= 1;
    }
    return localList.get(paramInt);
  }
  
  public List<M> b()
  {
    return this.f;
  }
  
  public void b(M paramM)
  {
    int i = this.f.indexOf(paramM);
    if (i < 0) {
      return;
    }
    this.f.remove(i);
    if (this.a == null)
    {
      notifyItemRemoved(i);
      return;
    }
    notifyItemRemoved(i + 1);
  }
  
  public boolean b(List<M> paramList)
  {
    boolean bool = this.f.addAll(paramList);
    if (bool) {
      notifyDataSetChanged();
    }
    return bool;
  }
  
  public int getItemCount()
  {
    return this.f.size() + c();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((this.a != null) && (paramInt == 0)) {
      return 1024;
    }
    if ((this.b != null) && (paramInt == this.f.size() + d())) {
      return 1025;
    }
    return a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.common.recyclerview.BaseAdapter
 * JD-Core Version:    0.7.0.1
 */