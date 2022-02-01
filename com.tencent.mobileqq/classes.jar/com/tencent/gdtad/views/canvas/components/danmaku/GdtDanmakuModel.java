package com.tencent.gdtad.views.canvas.components.danmaku;

import java.util.Random;

class GdtDanmakuModel
{
  private String[] a;
  private Random b = new Random();
  private int c = 0;
  
  public GdtDanmakuModel a(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
    return this;
  }
  
  public boolean a()
  {
    String[] arrayOfString = this.a;
    return (arrayOfString == null) || (arrayOfString.length == 0);
  }
  
  public final String b()
  {
    String[] arrayOfString = this.a;
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      int i = this.c;
      this.c = (i + 1);
      String str = arrayOfString[i];
      i = this.c;
      if (i == arrayOfString.length) {
        this.c = (i % arrayOfString.length);
      }
      return str;
    }
    return "";
  }
  
  public void c()
  {
    this.c = 0;
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuModel
 * JD-Core Version:    0.7.0.1
 */