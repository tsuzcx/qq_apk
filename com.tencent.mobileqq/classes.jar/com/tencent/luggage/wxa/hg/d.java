package com.tencent.luggage.wxa.hg;

import com.tencent.luggage.wxa.hz.a;
import com.tencent.luggage.wxa.qz.o;
import java.io.File;

public class d
{
  public static boolean a()
  {
    try
    {
      boolean bool = new File(a.c()).canWrite();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("summer isSDCardAvail 1 e: ");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append(" SDCARD_ROOT: ");
      localStringBuilder.append(a.c());
      o.a("MicroMsg.CUtil", localException, localStringBuilder.toString(), new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hg.d
 * JD-Core Version:    0.7.0.1
 */