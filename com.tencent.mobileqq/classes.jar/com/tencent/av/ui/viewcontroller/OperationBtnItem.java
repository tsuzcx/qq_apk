package com.tencent.av.ui.viewcontroller;

import android.text.TextUtils;

public class OperationBtnItem
{
  public int a = -1;
  public boolean b = false;
  private int c = 0;
  private String d = "";
  private int e = 0;
  private String f = null;
  private boolean g = true;
  private boolean h = true;
  private boolean i = false;
  
  public OperationBtnItem(int paramInt1, String paramString, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramString;
    this.e = paramInt2;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.d)) {
      this.b = true;
    }
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public int b()
  {
    return OperationMenuViewFactory.a(this.c);
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return this.i;
  }
  
  public boolean h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.viewcontroller.OperationBtnItem
 * JD-Core Version:    0.7.0.1
 */