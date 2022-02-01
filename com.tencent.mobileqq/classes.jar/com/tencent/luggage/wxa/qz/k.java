package com.tencent.luggage.wxa.qz;

import android.content.Intent;

public class k
{
  public static String a(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      paramIntent = paramIntent.getStringExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      o.b("MicroMsg.IntentUtil", "getStringExtra exception:%s", new Object[] { paramIntent.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.k
 * JD-Core Version:    0.7.0.1
 */