package com.tencent.biz.pubaccount.weishi_new.view.bottomnav;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$BarAdapter;", "VH", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$BarHolder;", "", "()V", "mObservable", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$AdapterDataObservable;", "bindBarHolder", "", "barHolder", "position", "", "(Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$BarHolder;I)V", "createBarHolder", "parent", "Landroid/view/ViewGroup;", "barType", "(Landroid/view/ViewGroup;I)Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$BarHolder;", "fillData", "getBarCount", "getBarType", "notifyDataSetChanged", "onBindBarHolder", "onCreateBarHolder", "registerAdapterDataObserver", "observer", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$AdapterDataObserver;", "unregisterAdapterDataObserver", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract class WSBottomNavigationBar$BarAdapter<VH extends WSBottomNavigationBar.BarHolder>
{
  private final WSBottomNavigationBar.AdapterDataObservable a = new WSBottomNavigationBar.AdapterDataObservable();
  
  public abstract int a();
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public void a(@Nullable WSBottomNavigationBar.AdapterDataObserver paramAdapterDataObserver)
  {
    this.a.registerObserver(paramAdapterDataObserver);
  }
  
  public abstract void a(@NotNull VH paramVH, int paramInt);
  
  @NotNull
  public abstract VH b(@NotNull ViewGroup paramViewGroup, int paramInt);
  
  public void b()
  {
    this.a.unregisterAll();
  }
  
  public final void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public final void b(@NotNull VH paramVH, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramVH, "barHolder");
    paramVH.b(paramInt);
    a(paramVH, paramInt);
  }
  
  @NotNull
  public final VH c(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = b(paramViewGroup, paramInt);
    paramViewGroup.a(paramInt);
    return paramViewGroup;
  }
  
  public final void c()
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.bottomnav.WSBottomNavigationBar.BarAdapter
 * JD-Core Version:    0.7.0.1
 */