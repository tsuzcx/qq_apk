package com.tencent.av.ui.funchat.zimu;

public class IZimuItemView$FontPara
{
  public int a;
  public int b;
  public float c;
  
  IZimuItemView$FontPara(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.IZimuItemView.FontPara
 * JD-Core Version:    0.7.0.1
 */