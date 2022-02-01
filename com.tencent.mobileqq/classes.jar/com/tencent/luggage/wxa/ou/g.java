package com.tencent.luggage.wxa.ou;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public final class g
{
  public static String a(String paramString)
  {
    if (af.c(paramString)) {
      return "";
    }
    try
    {
      String str = af.b(k.a(paramString));
      return str;
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.AppBrand.ReportUtil", "safeEncode, given %s, e %s", new Object[] { paramString, localException });
    }
    return "";
  }
  
  public static Object[] a(Object... paramVarArgs)
  {
    int j = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      Object[] arrayOfObject = new Object[paramVarArgs.length];
      int k = paramVarArgs.length;
      int i = 0;
      while (j < k)
      {
        Object localObject2 = paramVarArgs[j];
        Object localObject1;
        if (localObject2 == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = localObject2;
          if ((localObject2 instanceof String))
          {
            String str = (String)localObject2;
            localObject1 = localObject2;
            if (str.contains(",")) {
              localObject1 = a(str);
            }
          }
        }
        arrayOfObject[i] = String.valueOf(localObject1);
        j += 1;
        i += 1;
      }
      return arrayOfObject;
    }
    return new Object[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.g
 * JD-Core Version:    0.7.0.1
 */