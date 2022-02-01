package com.tencent.luggage.wxa.ot;

import com.tencent.luggage.wxa.qz.o;

class f
{
  public static String a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      int j = paramVarArgs.length;
      int i = 0;
      if (j == 1) {
        return String.valueOf(paramVarArgs[0]);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      j = paramVarArgs.length - 1;
      while (i < j)
      {
        localStringBuilder.append(String.valueOf(paramVarArgs[i]).replace(',', ' '));
        localStringBuilder.append(',');
        i += 1;
      }
      localStringBuilder.append(String.valueOf(paramVarArgs[j]));
      return localStringBuilder.toString();
    }
    o.c("Luggage.KVReportStringUtils", "vals is null, use '' as value");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ot.f
 * JD-Core Version:    0.7.0.1
 */