package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.content.Context;

public abstract interface IBean
{
  public abstract void appendData(Object paramObject);
  
  public abstract void click(int paramInt, boolean paramBoolean);
  
  public abstract void doEvent(int paramInt1, int paramInt2, Object paramObject);
  
  public abstract void init(Context paramContext, ViewBase paramViewBase);
  
  public abstract void setData(Object paramObject);
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBean
 * JD-Core Version:    0.7.0.1
 */