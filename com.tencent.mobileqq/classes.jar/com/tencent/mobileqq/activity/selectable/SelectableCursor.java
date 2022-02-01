package com.tencent.mobileqq.activity.selectable;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;

public abstract interface SelectableCursor
{
  public abstract int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
  
  @NonNull
  public abstract View a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(SelectableDelegate paramSelectableDelegate);
  
  public abstract boolean a(int paramInt);
  
  public abstract void b(@ColorInt int paramInt);
  
  public abstract void b(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.SelectableCursor
 * JD-Core Version:    0.7.0.1
 */