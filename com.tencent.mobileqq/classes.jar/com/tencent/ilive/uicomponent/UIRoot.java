package com.tencent.ilive.uicomponent;

import android.view.View;
import androidx.lifecycle.Lifecycle;

public abstract interface UIRoot
  extends PageLifeCycle
{
  public abstract void bindPageLifeCycle(Lifecycle paramLifecycle);
  
  public abstract UIView getView();
  
  public abstract UIViewModel getViewModel();
  
  public abstract void onChangeLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onCreate(View paramView);
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.UIRoot
 * JD-Core Version:    0.7.0.1
 */