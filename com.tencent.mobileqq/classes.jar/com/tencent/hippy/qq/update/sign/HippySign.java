package com.tencent.hippy.qq.update.sign;

import java.util.Random;

public class HippySign
{
  public static boolean empty(String paramString)
  {
    return (paramString == null) || (paramString.trim().equals("")) || (paramString.trim().equals("null"));
  }
  
  public static String getSign(String paramString1, String paramString2)
  {
    boolean bool = empty(paramString2);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    long l = System.currentTimeMillis() / 1000L;
    int i = Math.abs(new Random().nextInt());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("a=");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("&t=");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("&r=");
    ((StringBuilder)localObject2).append(i);
    localObject2 = ((StringBuilder)localObject2).toString();
    paramString2 = hashHmac((String)localObject2, paramString2);
    paramString1 = localObject1;
    if (paramString2 != null)
    {
      paramString1 = new byte[paramString2.length + ((String)localObject2).getBytes().length];
      System.arraycopy(paramString2, 0, paramString1, 0, paramString2.length);
      System.arraycopy(((String)localObject2).getBytes(), 0, paramString1, paramString2.length, ((String)localObject2).getBytes().length);
      paramString1 = Base64Util.encode(paramString1);
    }
    return paramString1;
  }
  
  private static byte[] hashHmac(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = HMACSHA1.getSignature(paramString1, paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.sign.HippySign
 * JD-Core Version:    0.7.0.1
 */