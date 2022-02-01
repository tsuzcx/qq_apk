package com.tencent.ark;

import android.view.View;

public abstract interface ArkViewImplement$InputCallback
{
  public abstract void onFocusChanged(View paramView, boolean paramBoolean);
  
  public abstract void onHideMenu(View paramView);
  
  public abstract void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewImplement.InputCallback
 * JD-Core Version:    0.7.0.1
 */