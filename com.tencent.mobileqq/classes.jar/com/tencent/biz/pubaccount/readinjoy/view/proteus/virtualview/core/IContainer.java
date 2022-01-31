package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.view.View;

public abstract interface IContainer
{
  public abstract void attachViews();
  
  public abstract void destroy();
  
  public abstract View getHolderView();
  
  public abstract int getType();
  
  public abstract ViewBase getVirtualView();
  
  public abstract void setVirtualView(ViewBase paramViewBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
 * JD-Core Version:    0.7.0.1
 */