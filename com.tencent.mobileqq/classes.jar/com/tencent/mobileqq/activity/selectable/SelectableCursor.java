package com.tencent.mobileqq.activity.selectable;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;

public abstract interface SelectableCursor
{
  public abstract int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
  
  public abstract void a(SelectableDelegate paramSelectableDelegate);
  
  public abstract void b(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean d(int paramInt);
  
  @NonNull
  public abstract View e();
  
  public abstract void e(int paramInt);
  
  public abstract void f(@ColorInt int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.SelectableCursor
 * JD-Core Version:    0.7.0.1
 */