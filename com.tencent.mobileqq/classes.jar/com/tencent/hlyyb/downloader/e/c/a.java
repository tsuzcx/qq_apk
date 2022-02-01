package com.tencent.hlyyb.downloader.e.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private List<b> a = new ArrayList();
  
  public final String a()
  {
    synchronized (this.a)
    {
      if (this.a.size() == 0) {
        return "";
      }
      Object localObject1 = new StringBuilder();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject1).append(((b)localIterator.next()).a());
        ((StringBuilder)localObject1).append(";");
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final void a(b paramb)
  {
    synchronized (this.a)
    {
      if (this.a.size() < 20) {
        this.a.add(paramb);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.c.a
 * JD-Core Version:    0.7.0.1
 */