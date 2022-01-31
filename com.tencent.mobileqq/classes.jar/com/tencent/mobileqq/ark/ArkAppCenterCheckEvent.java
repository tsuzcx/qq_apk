package com.tencent.mobileqq.ark;

import java.util.HashMap;

public class ArkAppCenterCheckEvent
{
  private static HashMap a = new HashMap();
  
  public static Object a(int paramInt, String paramString, Object paramObject1, Object paramObject2)
  {
    paramString = (ArkAppCenterCheckEvent.Callback)a.get(paramString);
    if (paramString != null) {
      paramObject2 = paramString.a(paramInt, paramObject1);
    }
    return paramObject2;
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {
      a.remove(paramString);
    }
  }
  
  public static void a(String paramString, ArkAppCenterCheckEvent.Callback paramCallback)
  {
    if (paramString != null) {
      a.put(paramString, paramCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenterCheckEvent
 * JD-Core Version:    0.7.0.1
 */