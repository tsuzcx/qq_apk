package com.tencent.ad.tangram.ark;

import android.support.annotation.Keep;
import android.view.View;

@Keep
public abstract interface AdArkAdapter$Callback
{
  public abstract void firstPaint(long paramLong);
  
  public abstract void loadSucc();
  
  public abstract void onFocusChanged(View paramView, boolean paramBoolean);
  
  public abstract void onGlobalLayout(View paramView);
  
  public abstract void onHideMenu(View paramView);
  
  public abstract void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.ark.AdArkAdapter.Callback
 * JD-Core Version:    0.7.0.1
 */