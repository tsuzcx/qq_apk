package com.tencent.luggage.wxa.gl;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import java.io.InputStream;
import java.io.OutputStream;

public class a
{
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream != null)
    {
      if (paramOutputStream == null) {
        return 0L;
      }
      try
      {
        byte[] arrayOfByte = new byte[4096];
        int i;
        for (long l = 0L;; l += i)
        {
          i = paramInputStream.read(arrayOfByte);
          if (i == -1) {
            return l;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        return 0L;
      }
      catch (Exception paramInputStream)
      {
        o.c("MicroMsg.FileOperation", "copyStream error: %s", new Object[] { paramInputStream.getMessage() });
      }
    }
  }
  
  public static void a(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      i locali = new i(str);
      if ((!locali.j()) && ((!locali.u()) || (!locali.n()))) {
        o.b("MicroMsg.FileOperation", "batchMkDirs mkdir error. %s", new Object[] { str });
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gl.a
 * JD-Core Version:    0.7.0.1
 */