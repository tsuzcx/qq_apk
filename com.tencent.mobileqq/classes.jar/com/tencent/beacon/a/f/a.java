package com.tencent.beacon.a.f;

import android.content.Context;
import com.tencent.beacon.a.e.a.a;
import com.tencent.beacon.event.UserAction;

public abstract class a
{
  protected final int a;
  protected final int b;
  protected Context c;
  protected String d;
  protected int e;
  
  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
  }
  
  public static com.tencent.beacon.a.d.a.b a(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = com.tencent.beacon.a.a.a(paramInt, com.tencent.beacon.a.c.b.a(UserAction.mContext), paramArrayOfByte, 2, 3);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.a.g.a.c("[event] encode request package error:%s", new Object[] { paramArrayOfByte.toString() });
      com.tencent.beacon.a.g.a.a(paramArrayOfByte);
    }
    return null;
  }
  
  public abstract com.tencent.beacon.a.d.a.b a();
  
  public void b()
  {
    com.tencent.beacon.a.g.a.c("[db] encode failed, clear db data", new Object[0]);
  }
  
  public abstract void b(boolean paramBoolean);
  
  public final int c()
  {
    return this.a;
  }
  
  public final String d()
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
  
  public final String e()
  {
    try
    {
      if (this.b == 0) {
        return com.tencent.beacon.a.e.b.j(this.c).k().b();
      }
      String str = com.tencent.beacon.a.e.b.j(this.c).k().b(this.b).b();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.c("[strategy] get strategy error:%s", new Object[] { localThrowable.toString() });
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return null;
  }
  
  public final int f()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.f.a
 * JD-Core Version:    0.7.0.1
 */