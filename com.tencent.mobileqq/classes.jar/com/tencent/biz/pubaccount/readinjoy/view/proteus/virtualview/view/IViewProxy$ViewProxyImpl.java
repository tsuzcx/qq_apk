package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view;

import android.view.View;
import java.lang.ref.WeakReference;

public class IViewProxy$ViewProxyImpl
  implements IViewProxy
{
  private final WeakReference<View> a;
  
  public IViewProxy$ViewProxyImpl(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  public void a()
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.IViewProxy.ViewProxyImpl
 * JD-Core Version:    0.7.0.1
 */