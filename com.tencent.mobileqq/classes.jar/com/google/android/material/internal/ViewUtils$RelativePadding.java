package com.google.android.material.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

public class ViewUtils$RelativePadding
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public ViewUtils$RelativePadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public ViewUtils$RelativePadding(@NonNull RelativePadding paramRelativePadding)
  {
    this.a = paramRelativePadding.a;
    this.b = paramRelativePadding.b;
    this.c = paramRelativePadding.c;
    this.d = paramRelativePadding.d;
  }
  
  public void a(View paramView)
  {
    ViewCompat.setPaddingRelative(paramView, this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ViewUtils.RelativePadding
 * JD-Core Version:    0.7.0.1
 */