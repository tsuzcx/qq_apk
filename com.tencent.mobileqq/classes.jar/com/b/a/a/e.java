package com.b.a.a;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class e
{
  private final int a;
  private final Map<String, List<String>> b;
  private final int c;
  private final InputStream d;
  
  public e(int paramInt, Map<String, List<String>> paramMap)
  {
    this(paramInt, paramMap, -1, null);
  }
  
  public e(int paramInt1, Map<String, List<String>> paramMap, int paramInt2, InputStream paramInputStream)
  {
    this.a = paramInt1;
    this.b = paramMap;
    this.c = paramInt2;
    this.d = paramInputStream;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final Map<String, List<String>> b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final InputStream d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */