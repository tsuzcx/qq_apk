package com.tencent.beacon.core.d;

import android.content.Context;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.strategy.g;

public abstract class a
{
  protected final int a;
  protected final int b;
  protected Context c;
  protected String d;
  protected int e;
  protected String f;
  protected a.a g;
  
  public a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    this.c = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
    this.f = paramString;
  }
  
  public a(Context paramContext, int paramInt1, int paramInt2, String paramString, a.a parama)
  {
    this.c = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
    this.f = paramString;
    this.g = parama;
  }
  
  public void a()
  {
    d.i("[db] encode failed, clear db data", new Object[0]);
  }
  
  public abstract void a(boolean paramBoolean);
  
  public int b()
  {
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int c()
  {
    return this.a;
  }
  
  public String d()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String e()
  {
    return g.b(this.c).a(this.b);
  }
  
  public abstract RequestPackage f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.d.a
 * JD-Core Version:    0.7.0.1
 */