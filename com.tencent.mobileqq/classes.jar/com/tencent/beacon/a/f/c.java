package com.tencent.beacon.a.f;

import android.content.Context;
import com.tencent.beacon.event.UserAction;

public final class c
  extends a
{
  public c(Context paramContext)
  {
    super(paramContext, 0, 100);
  }
  
  public final com.tencent.beacon.a.d.a.b a()
  {
    Object localObject = com.tencent.beacon.a.c.b.a(UserAction.mContext);
    byte[] arrayOfByte = "".getBytes();
    try
    {
      localObject = com.tencent.beacon.a.a.a(c(), (com.tencent.beacon.a.c.b)localObject, arrayOfByte, -1, -1);
      if (localObject != null) {
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.a(localThrowable);
      com.tencent.beacon.a.g.a.d("[event] encode empty package failed", new Object[0]);
    }
    return null;
  }
  
  public final void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.f.c
 * JD-Core Version:    0.7.0.1
 */