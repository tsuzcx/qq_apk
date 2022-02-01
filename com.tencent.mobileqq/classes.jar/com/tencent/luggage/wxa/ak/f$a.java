package com.tencent.luggage.wxa.ak;

import java.util.Arrays;

final class f$a
{
  private static final String[] e = new String[0];
  public final String a;
  public final int b;
  public final String c;
  public final String[] d;
  
  private f$a(String paramString1, int paramInt, String paramString2, String[] paramArrayOfString)
  {
    this.b = paramInt;
    this.a = paramString1;
    this.c = paramString2;
    this.d = paramArrayOfString;
  }
  
  public static a a()
  {
    return new a("", 0, "", new String[0]);
  }
  
  public static a a(String paramString, int paramInt)
  {
    Object localObject = paramString.trim();
    if (((String)localObject).isEmpty()) {
      return null;
    }
    int i = ((String)localObject).indexOf(" ");
    if (i == -1)
    {
      paramString = "";
    }
    else
    {
      paramString = ((String)localObject).substring(i).trim();
      localObject = ((String)localObject).substring(0, i);
    }
    localObject = ((String)localObject).split("\\.");
    String str = localObject[0];
    if (localObject.length > 1) {
      localObject = (String[])Arrays.copyOfRange((Object[])localObject, 1, localObject.length);
    } else {
      localObject = e;
    }
    return new a(str, paramInt, paramString, (String[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ak.f.a
 * JD-Core Version:    0.7.0.1
 */