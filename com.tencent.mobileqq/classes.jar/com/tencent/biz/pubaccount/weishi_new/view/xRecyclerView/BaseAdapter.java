package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

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
    if (((this.a != null) && (paramInt == 0)) || (paramInt >= this.f.size() + f())) {
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
  
  public void b()
  {
    this.f.clear();
    notifyDataSetChanged();
  }
  
  public boolean b(List<M> paramList)
  {
    boolean bool = this.f.addAll(paramList);
    if (bool) {
      notifyItemRangeInserted(this.f.size() - paramList.size(), paramList.size());
    }
    return bool;
  }
  
  public List<M> c()
  {
    return this.f;
  }
  
  public int getItemCount()
  {
    return this.f.size() + e();
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
    if ((this.b != null) && (paramInt == this.f.size() + f())) {
      return 1025;
    }
    return a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.BaseAdapter
 * JD-Core Version:    0.7.0.1
 */