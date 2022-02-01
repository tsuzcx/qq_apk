package com.tencent.av.tips.data;

import android.graphics.drawable.Drawable;

public class NormalAvTipsItem
  extends AvTipsItemBase
{
  protected String m = null;
  protected int n = 0;
  protected Drawable o;
  
  public NormalAvTipsItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
  }
  
  public NormalAvTipsItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString1);
    this.m = paramString2;
    this.n = paramInt5;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.o = paramDrawable;
  }
  
  public void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  public Drawable n()
  {
    return this.o;
  }
  
  public String o()
  {
    return this.m;
  }
  
  public int p()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.data.NormalAvTipsItem
 * JD-Core Version:    0.7.0.1
 */