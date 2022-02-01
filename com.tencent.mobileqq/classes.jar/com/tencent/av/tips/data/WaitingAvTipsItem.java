package com.tencent.av.tips.data;

public class WaitingAvTipsItem
  extends AvTipsItemBase
{
  boolean g = false;
  boolean h = false;
  
  public WaitingAvTipsItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, boolean paramBoolean)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
    this.g = paramBoolean;
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public boolean i()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.data.WaitingAvTipsItem
 * JD-Core Version:    0.7.0.1
 */