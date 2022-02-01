package com.tencent.av.ui.funchat.filter;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class EffectFilterTextPager$MyHandler
  extends Handler
{
  WeakReference<EffectFilterTextPager> a;
  
  public EffectFilterTextPager$MyHandler(EffectFilterTextPager paramEffectFilterTextPager)
  {
    this.a = new WeakReference(paramEffectFilterTextPager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    EffectFilterTextPager localEffectFilterTextPager = (EffectFilterTextPager)this.a.get();
    if (localEffectFilterTextPager == null) {
      return;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      localEffectFilterTextPager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager.MyHandler
 * JD-Core Version:    0.7.0.1
 */