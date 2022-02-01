package com.tencent.luggage.wxa.jj;

public enum o
{
  private static final o.a a = new o.a(null);
  private static final o.a b = new o.a(null);
  
  public static int a(String paramString)
  {
    int i = a.a(paramString);
    if (i <= 0)
    {
      Object localObject = null;
      try
      {
        s locals = u.a().b(paramString, new String[] { "dynamicInfo" });
        localObject = locals;
      }
      catch (Exception localException)
      {
        com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
      }
      if (localObject == null) {
        i = -1;
      } else {
        i = localObject.d().a.a;
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppServiceSettingsResolver", "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject != null) {
        i = localObject.d().a.a;
      } else {
        i = 5;
      }
      a(paramString, i);
    }
    return i * 1048576;
  }
  
  public static void a(String paramString, int paramInt)
  {
    a.a(paramString, paramInt);
  }
  
  public static int b(String paramString)
  {
    int i = b.a(paramString);
    if (i <= 0)
    {
      Object localObject = null;
      try
      {
        s locals = u.a().b(paramString, new String[] { "dynamicInfo" });
        localObject = locals;
      }
      catch (Exception localException)
      {
        com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
      }
      if (localObject == null) {
        i = -1;
      } else {
        i = localObject.d().a.b;
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppServiceSettingsResolver", "readAppOpendataLocalStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject != null) {
        i = localObject.d().a.b;
      } else {
        i = 5;
      }
      b(paramString, i);
    }
    return i * 1048576;
  }
  
  public static void b(String paramString, int paramInt)
  {
    b.a(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.o
 * JD-Core Version:    0.7.0.1
 */