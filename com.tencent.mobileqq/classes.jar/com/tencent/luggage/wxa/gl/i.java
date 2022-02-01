package com.tencent.luggage.wxa.gl;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;

public class i
{
  public static String a(String paramString, boolean paramBoolean)
  {
    try
    {
      String str = k.c(paramString, paramBoolean);
      if (str != null)
      {
        o.d("MicroMsg.VFSFileOpEx", "exportExternalPath:%s to realPath:%s", new Object[] { paramString, str });
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      o.a("MicroMsg.VFSFileOpEx", localThrowable, "exportExternalPath failed", new Object[0]);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gl.i
 * JD-Core Version:    0.7.0.1
 */