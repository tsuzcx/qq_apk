package com.tencent.magicbrush.handler.glfont;

public enum j$a
{
  int e;
  
  private j$a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public static a a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      return d;
    }
    if (paramBoolean1) {
      return c;
    }
    if (paramBoolean2) {
      return b;
    }
    return a;
  }
  
  public boolean a()
  {
    return (this == c) || (this == d);
  }
  
  public boolean b()
  {
    return (this == b) || (this == d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.j.a
 * JD-Core Version:    0.7.0.1
 */