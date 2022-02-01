package com.tencent.luggage.wxa.qz;

import com.tencent.luggage.wxa.rt.i;
import java.io.IOException;

public class e
{
  public static boolean a(String paramString)
  {
    try
    {
      if (new i(paramString).u())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".nomedia");
        paramString = new i(localStringBuilder.toString());
        boolean bool = paramString.j();
        if (!bool) {
          try
          {
            paramString.v();
          }
          catch (IOException paramString)
          {
            o.a("MicroMsg.FilePathGenerator", paramString, "", new Object[0]);
          }
        }
      }
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.e
 * JD-Core Version:    0.7.0.1
 */