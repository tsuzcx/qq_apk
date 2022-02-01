package com.tencent.biz.pubaccount.weishi_new.view.bottomnav;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$NavigationBarDataObserver;", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$AdapterDataObserver;", "(Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar;)V", "fillData", "", "onChanged", "position", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBottomNavigationBar$NavigationBarDataObserver
  extends WSBottomNavigationBar.AdapterDataObserver
{
  public void a()
  {
    WSBottomNavigationBar.a(this.a).removeAllViews();
    WSBottomNavigationBar.b(this.a).clear();
    WSBottomNavigationBar.BarAdapter localBarAdapter = WSBottomNavigationBar.c(this.a);
    int j = localBarAdapter.a();
    int i = 0;
    while (i < j)
    {
      int k = localBarAdapter.a(i);
      WSBottomNavigationBar.BarHolder localBarHolder = localBarAdapter.c((ViewGroup)this.a, k);
      localBarAdapter.b(localBarHolder, i);
      WSBottomNavigationBar.a(this.a, localBarHolder);
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    WSBottomNavigationBar.BarHolder localBarHolder = (WSBottomNavigationBar.BarHolder)WSBottomNavigationBar.b(this.a).get(paramInt);
    WSBottomNavigationBar.c(this.a).b(localBarHolder, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.bottomnav.WSBottomNavigationBar.NavigationBarDataObserver
 * JD-Core Version:    0.7.0.1
 */