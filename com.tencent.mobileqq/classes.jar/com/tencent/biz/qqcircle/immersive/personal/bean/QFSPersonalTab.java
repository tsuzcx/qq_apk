package com.tencent.biz.qqcircle.immersive.personal.bean;

public class QFSPersonalTab
{
  private String a;
  private int b;
  private int c;
  private boolean d;
  
  public QFSPersonalTab(String paramString, int paramInt1, int paramInt2)
  {
    this(paramString, paramInt1, paramInt2, false);
  }
  
  public QFSPersonalTab(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public String d()
  {
    if (this.d) {
      return this.a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalTab
 * JD-Core Version:    0.7.0.1
 */