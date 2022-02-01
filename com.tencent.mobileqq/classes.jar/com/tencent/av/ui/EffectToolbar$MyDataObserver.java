package com.tencent.av.ui;

import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class EffectToolbar$MyDataObserver
  implements Observer
{
  private WeakReference<EffectToolbar> a;
  
  EffectToolbar$MyDataObserver(EffectToolbar paramEffectToolbar)
  {
    this.a = new WeakReference(paramEffectToolbar);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    EffectToolbar localEffectToolbar = (EffectToolbar)this.a.get();
    if (localEffectToolbar == null) {
      return;
    }
    EffectToolbar.access$300(localEffectToolbar, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar.MyDataObserver
 * JD-Core Version:    0.7.0.1
 */