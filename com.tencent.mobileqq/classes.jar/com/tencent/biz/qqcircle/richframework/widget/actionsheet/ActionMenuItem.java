package com.tencent.biz.qqcircle.richframework.widget.actionsheet;

import java.util.HashMap;

public class ActionMenuItem
{
  public int a = 1;
  public int b;
  public String c;
  public int d;
  public int e;
  public HashMap<String, Object> f = new HashMap();
  
  public ActionMenuItem(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramString, paramInt2, paramInt3, 1);
  }
  
  public ActionMenuItem(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
    this.e = paramInt3;
    this.a = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionMenuItem
 * JD-Core Version:    0.7.0.1
 */