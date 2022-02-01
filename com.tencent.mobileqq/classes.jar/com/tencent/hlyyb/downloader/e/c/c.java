package com.tencent.hlyyb.downloader.e.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public boolean a;
  public long b;
  public long c;
  public int d = 0;
  private List<d> e = new ArrayList();
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((d)localIterator.next());
      localStringBuilder.append(";");
    }
    return localStringBuilder.toString();
  }
  
  public final void a(d paramd)
  {
    if (this.e.size() < 20) {
      this.e.add(paramd);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (this.a) {}
    for (int i = 0;; i = 1)
    {
      localStringBuilder1.append(i).append(",");
      localStringBuilder1.append(this.b).append(",");
      localStringBuilder1.append(this.c).append(",");
      localStringBuilder1.append(this.d).append(";");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.c.c
 * JD-Core Version:    0.7.0.1
 */