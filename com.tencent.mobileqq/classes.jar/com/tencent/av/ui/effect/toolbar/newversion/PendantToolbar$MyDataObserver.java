package com.tencent.av.ui.effect.toolbar.newversion;

import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class PendantToolbar$MyDataObserver
  implements Observer
{
  private final WeakReference<PendantToolbar> a;
  
  PendantToolbar$MyDataObserver(PendantToolbar paramPendantToolbar)
  {
    this.a = new WeakReference(paramPendantToolbar);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    PendantToolbar localPendantToolbar = (PendantToolbar)this.a.get();
    if (localPendantToolbar == null) {
      return;
    }
    PendantToolbar.access$100(localPendantToolbar, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.PendantToolbar.MyDataObserver
 * JD-Core Version:    0.7.0.1
 */