package com.tencent.beacon.core.c;

import android.content.Context;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.event.UserAction;

public final class c
  extends a
{
  public c(Context paramContext, String paramString)
  {
    super(paramContext, 0, 100, paramString);
  }
  
  public final RequestPackage a()
  {
    Object localObject = com.tencent.beacon.core.b.b.a(UserAction.mContext);
    byte[] arrayOfByte = "".getBytes();
    try
    {
      localObject = a(c(), (com.tencent.beacon.core.b.b)localObject, arrayOfByte, -1, -1, this.f);
      if (localObject != null) {
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.core.d.b.a(localThrowable);
      com.tencent.beacon.core.d.b.d("[event] encode empty package failed", new Object[0]);
    }
    return null;
  }
  
  public final void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.c.c
 * JD-Core Version:    0.7.0.1
 */