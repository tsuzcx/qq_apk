package com.huawei.hms.framework.network.grs.d;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
{
  private static final String a = "b";
  private static final Pattern b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
  
  public static String a(String paramString)
  {
    return a(paramString, "SHA-256");
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.getBytes("UTF-8");
    }
    catch (UnsupportedEncodingException paramString1)
    {
      label21:
      label35:
      break label35;
    }
    try
    {
      paramString1 = a(MessageDigest.getInstance(paramString2).digest(paramString1));
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      break label21;
    }
    paramString1 = a;
    for (paramString2 = "encrypt NoSuchAlgorithmException";; paramString2 = "encrypt UnsupportedEncodingException")
    {
      Logger.w(paramString1, paramString2);
      return null;
      paramString1 = a;
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i = paramString.length();
    int j = 1;
    if (i == 1) {
      return "*";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    i = 0;
    while (i < paramString.length())
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString.charAt(i));
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      int k = j;
      Object localObject2 = localObject1;
      if (b.matcher((CharSequence)localObject1).matches())
      {
        if (j % 2 == 0) {
          localObject1 = "*";
        }
        k = j + 1;
        localObject2 = localObject1;
      }
      localStringBuffer.append(localObject2);
      i += 1;
      j = k;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.d.b
 * JD-Core Version:    0.7.0.1
 */