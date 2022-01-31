package com.tencent.map.sdk.a;

import java.util.Collections;
import java.util.List;

public final class jw
{
  public int a;
  public int b;
  public List<ju> c;
  private final String d = "_night";
  
  public jw(int paramInt1, int paramInt2, List<ju> paramList)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramList;
    Collections.sort(paramList, new jw.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jw
 * JD-Core Version:    0.7.0.1
 */