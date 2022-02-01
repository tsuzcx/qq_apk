package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;

class OnShareClickListener$1
  implements View.OnAttachStateChangeListener
{
  OnShareClickListener$1(OnShareClickListener paramOnShareClickListener) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (OnShareClickListener.a(this.a) != null)
    {
      OnShareClickListener.a(this.a).b();
      OnShareClickListener.a(this.a, null);
    }
    if (OnShareClickListener.a(this.a) != null)
    {
      OnShareClickListener.a(this.a).a();
      OnShareClickListener.a(this.a, null);
    }
    if (OnShareClickListener.a(this.a) != null)
    {
      OnShareClickListener.a(this.a).a();
      OnShareClickListener.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnShareClickListener.1
 * JD-Core Version:    0.7.0.1
 */