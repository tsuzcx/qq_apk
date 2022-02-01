package com.tencent.map.sdk.a;

import com.tencent.lbssearch.common.gson.annotations.Since;
import com.tencent.lbssearch.common.gson.annotations.Until;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ej
  implements ef, Cloneable
{
  public static final ej a = new ej();
  public double b = -1.0D;
  public int c = 136;
  public boolean d = true;
  public boolean e;
  public List<dj> f = Collections.emptyList();
  public List<dj> g = Collections.emptyList();
  
  private ej a()
  {
    try
    {
      ej localej = (ej)super.clone();
      return localej;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  private boolean a(Since paramSince)
  {
    return (paramSince == null) || (paramSince.value() <= this.b);
  }
  
  private boolean a(Until paramUntil)
  {
    return (paramUntil == null) || (paramUntil.value() > this.b);
  }
  
  public static boolean a(Class<?> paramClass)
  {
    return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
  }
  
  public static boolean b(Class<?> paramClass)
  {
    return (paramClass.isMemberClass()) && (!c(paramClass));
  }
  
  private static boolean c(Class<?> paramClass)
  {
    return (paramClass.getModifiers() & 0x8) != 0;
  }
  
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    Class localClass = paramfd.a;
    boolean bool1 = a(localClass, true);
    boolean bool2 = a(localClass, false);
    if ((!bool1) && (!bool2)) {
      return null;
    }
    return new ej.1(this, bool2, bool1, paramdn, paramfd);
  }
  
  public final boolean a(Since paramSince, Until paramUntil)
  {
    return (a(paramSince)) && (a(paramUntil));
  }
  
  public final boolean a(Class<?> paramClass, boolean paramBoolean)
  {
    if ((this.b != -1.0D) && (!a((Since)paramClass.getAnnotation(Since.class), (Until)paramClass.getAnnotation(Until.class)))) {
      return true;
    }
    if ((!this.d) && (b(paramClass))) {
      return true;
    }
    if (a(paramClass)) {
      return true;
    }
    if (paramBoolean) {}
    for (paramClass = this.f;; paramClass = this.g)
    {
      paramClass = paramClass.iterator();
      do
      {
        if (!paramClass.hasNext()) {
          break;
        }
      } while (!((dj)paramClass.next()).b());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ej
 * JD-Core Version:    0.7.0.1
 */