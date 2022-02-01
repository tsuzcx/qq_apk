package com.tencent.mm.opensdk.utils;

public final class c$a
{
  public static Object a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      break;
    }
    try
    {
      return Double.valueOf(paramString);
    }
    catch (Exception localException)
    {
      Object localObject;
      break label78;
    }
    return Float.valueOf(paramString);
    return Boolean.valueOf(paramString);
    return Long.valueOf(paramString);
    return Integer.valueOf(paramString);
    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
    break label106;
    label78:
    paramString = new StringBuilder("resolveObj exception:");
    paramString.append(localObject.getMessage());
    Log.e("MicroMsg.SDK.PluginProvider.Resolver", paramString.toString());
    label106:
    return null;
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.c.a
 * JD-Core Version:    0.7.0.1
 */