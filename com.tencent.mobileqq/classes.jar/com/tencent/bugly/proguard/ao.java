package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class ao
  extends k
  implements Cloneable
{
  private static ArrayList<an> b;
  public ArrayList<an> a = null;
  
  public final void a(i parami)
  {
    if (b == null)
    {
      b = new ArrayList();
      an localan = new an();
      b.add(localan);
    }
    this.a = ((ArrayList)parami.a(b, 0, true));
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.ao
 * JD-Core Version:    0.7.0.1
 */