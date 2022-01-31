package com.tencent.av.ui.funchat.filter;

import java.lang.ref.WeakReference;

public class EffectFilterPanel$MyScroolTextDispearRunnable
  implements Runnable
{
  WeakReference<EffectFilterPanel> a;
  
  EffectFilterPanel$MyScroolTextDispearRunnable(EffectFilterPanel paramEffectFilterPanel)
  {
    this.a = new WeakReference(paramEffectFilterPanel);
  }
  
  public void run()
  {
    EffectFilterPanel localEffectFilterPanel = (EffectFilterPanel)this.a.get();
    if (localEffectFilterPanel != null) {
      localEffectFilterPanel.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterPanel.MyScroolTextDispearRunnable
 * JD-Core Version:    0.7.0.1
 */