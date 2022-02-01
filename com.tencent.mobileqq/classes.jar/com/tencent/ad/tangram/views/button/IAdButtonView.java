package com.tencent.ad.tangram.views.button;

import android.support.annotation.Keep;
import android.view.View;
import java.lang.ref.WeakReference;

@Keep
public abstract interface IAdButtonView
{
  public abstract View getButtonView();
  
  public abstract void registerListener(WeakReference<IAdButtonView.a> paramWeakReference);
  
  public abstract void update(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.IAdButtonView
 * JD-Core Version:    0.7.0.1
 */