package com.tencent.biz.pubaccount.weishi_new.view.bottomnav;

import android.database.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$AdapterDataObservable;", "Landroid/database/Observable;", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$AdapterDataObserver;", "()V", "fillData", "", "notifyChanged", "position", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBottomNavigationBar$AdapterDataObservable
  extends Observable<WSBottomNavigationBar.AdapterDataObserver>
{
  public final void a()
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((WSBottomNavigationBar.AdapterDataObserver)localIterator.next()).a();
    }
  }
  
  public final void a(int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((WSBottomNavigationBar.AdapterDataObserver)localIterator.next()).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.bottomnav.WSBottomNavigationBar.AdapterDataObservable
 * JD-Core Version:    0.7.0.1
 */