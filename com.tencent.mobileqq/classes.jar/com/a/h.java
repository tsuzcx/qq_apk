package com.a;

import java.util.ArrayList;
import java.util.List;

public final class h
  implements Cloneable
{
  private List a = new ArrayList(16);
  
  public final void a(g[] paramArrayOfg)
  {
    this.a.clear();
    if (paramArrayOfg == null) {
      return;
    }
    int i = 0;
    while (i < paramArrayOfg.length)
    {
      this.a.add(paramArrayOfg[i]);
      i += 1;
    }
  }
  
  public final g[] a()
  {
    List localList = this.a;
    return (g[])localList.toArray(new g[localList.size()]);
  }
  
  public final Object clone()
  {
    h localh = (h)super.clone();
    localh.a = new ArrayList(this.a);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.a.h
 * JD-Core Version:    0.7.0.1
 */