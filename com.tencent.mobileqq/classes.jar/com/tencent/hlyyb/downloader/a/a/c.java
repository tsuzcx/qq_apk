package com.tencent.hlyyb.downloader.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private List<b> a = new ArrayList();
  
  public final int a()
  {
    return this.a.size();
  }
  
  public final void a(b paramb)
  {
    Iterator localIterator = this.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((b)localIterator.next()).equals(paramb));
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.a.add(paramb);
      }
      return;
    }
  }
  
  public final b b()
  {
    if (this.a.size() == 0) {
      return null;
    }
    return (b)this.a.get(0);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("bytes=");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localStringBuilder.append(localb.a);
      localStringBuilder.append("-");
      if (localb.b != -1L) {
        localStringBuilder.append(localb.b);
      }
      localStringBuilder.append(",");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.a.a.c
 * JD-Core Version:    0.7.0.1
 */