package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.d.m;
import com.tencent.beacon.core.e.c;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.info.g;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.event.UserAction;

public class i
{
  public static RequestPackage a(Context paramContext, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    d.a("[event] origin events byte size: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramContext = m.a(paramInt, g.b(paramContext), paramArrayOfByte, 2, 3, paramString);
      if (paramContext != null) {
        paramContext.reserved = c.a(UserAction.getAdditionalInfo(paramString));
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      d.i("[event] encode request package error:%s", new Object[] { paramContext.toString() });
      d.a(paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.i
 * JD-Core Version:    0.7.0.1
 */