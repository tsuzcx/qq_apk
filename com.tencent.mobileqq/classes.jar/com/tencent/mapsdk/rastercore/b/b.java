package com.tencent.mapsdk.rastercore.b;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private int a;
  private int b;
  private List<a> c;
  
  public b(int paramInt1, int paramInt2, List<a> paramList)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramList;
    Collections.sort(paramList, new Comparator() {});
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final String[] a(c paramc)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a(paramc)) {
        return new String[] { locala.b(), locala.c() };
      }
    }
    return null;
  }
  
  public final int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.b.b
 * JD-Core Version:    0.7.0.1
 */