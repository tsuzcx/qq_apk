package com.tencent.biz.richframework.part.block.base;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;

public class RFHookAdapterDataObserver
  extends RecyclerView.AdapterDataObserver
{
  private final RecyclerView.AdapterDataObserver a;
  private final RFHookAdapterDataObserver.HookDataObserverDelegate b;
  
  public RFHookAdapterDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver, RFHookAdapterDataObserver.HookDataObserverDelegate paramHookDataObserverDelegate)
  {
    this.a = paramAdapterDataObserver;
    this.b = paramHookDataObserverDelegate;
  }
  
  private boolean a(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    RFHookAdapterDataObserver.HookDataObserverDelegate localHookDataObserverDelegate = this.b;
    return (localHookDataObserverDelegate != null) && (localHookDataObserverDelegate.onInterceptDataObserver(paramAdapterDataObserver));
  }
  
  public void onChanged()
  {
    RecyclerView.AdapterDataObserver localAdapterDataObserver = this.a;
    if ((localAdapterDataObserver != null) && (!a(localAdapterDataObserver))) {
      this.a.onChanged();
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    RecyclerView.AdapterDataObserver localAdapterDataObserver = this.a;
    if ((localAdapterDataObserver != null) && (!a(localAdapterDataObserver))) {
      this.a.onItemRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    onItemRangeChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    RecyclerView.AdapterDataObserver localAdapterDataObserver = this.a;
    if ((localAdapterDataObserver != null) && (!a(localAdapterDataObserver))) {
      this.a.onItemRangeInserted(paramInt1, paramInt2);
    }
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    RecyclerView.AdapterDataObserver localAdapterDataObserver = this.a;
    if ((localAdapterDataObserver != null) && (!a(localAdapterDataObserver))) {
      this.a.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    RecyclerView.AdapterDataObserver localAdapterDataObserver = this.a;
    if ((localAdapterDataObserver != null) && (!a(localAdapterDataObserver))) {
      this.a.onItemRangeRemoved(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.RFHookAdapterDataObserver
 * JD-Core Version:    0.7.0.1
 */