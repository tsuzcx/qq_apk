package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public class EncodeUtil
{
  private static final String TAG = "EncodeUtil";
  private static final char[] f = { 44, 46, 45 };
  private static final String[] g = new String[256];
  
  static
  {
    for (char c = '\000'; c < 'ÿ'; c = (char)(c + '\001')) {
      if (((c >= '0') && (c <= '9')) || ((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z'))) {
        g[c] = null;
      } else {
        g[c] = b(c).intern();
      }
    }
  }
  
  private static Character a(a parama)
  {
    parama.f();
    Character localCharacter1 = parama.b();
    if (localCharacter1 == null)
    {
      parama.reset();
      return null;
    }
    if (localCharacter1.charValue() != '\\')
    {
      parama.reset();
      return null;
    }
    localCharacter1 = parama.b();
    if (localCharacter1 == null)
    {
      parama.reset();
      return null;
    }
    if (localCharacter1.charValue() == 'b') {
      return Character.valueOf('\b');
    }
    if (localCharacter1.charValue() == 't') {
      return Character.valueOf('\t');
    }
    if (localCharacter1.charValue() == 'n') {
      return Character.valueOf('\n');
    }
    if (localCharacter1.charValue() == 'v') {
      return Character.valueOf('\013');
    }
    if (localCharacter1.charValue() == 'f') {
      return Character.valueOf('\f');
    }
    if (localCharacter1.charValue() == 'r') {
      return Character.valueOf('\r');
    }
    if (localCharacter1.charValue() == '"') {
      return Character.valueOf('"');
    }
    if (localCharacter1.charValue() == '\'') {
      return Character.valueOf('\'');
    }
    if (localCharacter1.charValue() == '\\') {
      return Character.valueOf('\\');
    }
    int k = Character.toLowerCase(localCharacter1.charValue());
    int j = 0;
    int i = 0;
    StringBuilder localStringBuilder;
    Character localCharacter2;
    if (k == 120)
    {
      localStringBuilder = new StringBuilder();
      while (i < 2)
      {
        localCharacter2 = parama.c();
        if (localCharacter2 != null)
        {
          localStringBuilder.append(localCharacter2);
          i += 1;
        }
        else
        {
          parama.reset();
          return null;
        }
      }
    }
    try
    {
      i = Integer.parseInt(localStringBuilder.toString(), 16);
      if (!Character.isValidCodePoint(i)) {
        break label509;
      }
      c = (char)i;
      return Character.valueOf(c);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      char c;
      label291:
      break label291;
    }
    parama.reset();
    return null;
    if (Character.toLowerCase(localCharacter1.charValue()) == 'u')
    {
      localStringBuilder = new StringBuilder();
      i = j;
      while (i < 4)
      {
        localCharacter2 = parama.c();
        if (localCharacter2 != null)
        {
          localStringBuilder.append(localCharacter2);
          i += 1;
        }
        else
        {
          parama.reset();
          return null;
        }
      }
    }
    try
    {
      i = Integer.parseInt(localStringBuilder.toString(), 16);
      if (!Character.isValidCodePoint(i)) {
        break label509;
      }
      c = (char)i;
      return Character.valueOf(c);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      label384:
      break label384;
    }
    parama.reset();
    return null;
    if (a.c(localCharacter1))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localCharacter1);
      localCharacter2 = parama.b();
      if (!a.c(localCharacter2))
      {
        parama.a(localCharacter2);
      }
      else
      {
        localStringBuilder.append(localCharacter2);
        localCharacter2 = parama.b();
        if (!a.c(localCharacter2)) {
          parama.a(localCharacter2);
        } else {
          localStringBuilder.append(localCharacter2);
        }
      }
    }
    try
    {
      i = Integer.parseInt(localStringBuilder.toString(), 8);
      if (!Character.isValidCodePoint(i)) {
        break label509;
      }
      c = (char)i;
      return Character.valueOf(c);
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      label503:
      break label503;
    }
    parama.reset();
    return null;
    label509:
    return localCharacter1;
  }
  
  private static String a(char paramChar)
  {
    if (paramChar < 'ÿ') {
      return g[paramChar];
    }
    return b(paramChar);
  }
  
  private static String a(char[] paramArrayOfChar, Character paramCharacter)
  {
    if (a(paramCharacter.charValue(), paramArrayOfChar))
    {
      paramArrayOfChar = new StringBuilder();
      paramArrayOfChar.append("");
      paramArrayOfChar.append(paramCharacter);
      return paramArrayOfChar.toString();
    }
    if (a(paramCharacter.charValue()) == null)
    {
      paramArrayOfChar = new StringBuilder();
      paramArrayOfChar.append("");
      paramArrayOfChar.append(paramCharacter);
      return paramArrayOfChar.toString();
    }
    paramArrayOfChar = Integer.toHexString(paramCharacter.charValue());
    if (paramCharacter.charValue() < 'Ā')
    {
      paramCharacter = new StringBuilder();
      paramCharacter.append("\\x");
      paramCharacter.append("00".substring(paramArrayOfChar.length()));
      paramCharacter.append(paramArrayOfChar.toUpperCase(Locale.ENGLISH));
      return paramCharacter.toString();
    }
    paramCharacter = new StringBuilder();
    paramCharacter.append("\\u");
    paramCharacter.append("0000".substring(paramArrayOfChar.length()));
    paramCharacter.append(paramArrayOfChar.toUpperCase(Locale.ENGLISH));
    return paramCharacter.toString();
  }
  
  private static String a(char[] paramArrayOfChar, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      localStringBuilder.append(a(paramArrayOfChar, Character.valueOf(paramString.charAt(i))));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static boolean a(char paramChar, char[] paramArrayOfChar)
  {
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      if (paramChar == paramArrayOfChar[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static String b(char paramChar)
  {
    return Integer.toHexString(paramChar);
  }
  
  public static String decodeForJavaScript(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      localObject1 = new StringBuilder();
      paramString = new a(paramString);
      while (paramString.hasNext())
      {
        localObject2 = a(paramString);
        if (localObject2 != null) {
          ((StringBuilder)localObject1).append(localObject2);
        } else {
          ((StringBuilder)localObject1).append(paramString.b());
        }
      }
      paramString = ((StringBuilder)localObject1).toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      Object localObject1 = TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decode js: ");
      ((StringBuilder)localObject2).append(paramString.getMessage());
      Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    return "";
  }
  
  public static String encodeForJavaScript(String paramString)
  {
    return encodeForJavaScript(paramString, f);
  }
  
  public static String encodeForJavaScript(String paramString, char[] paramArrayOfChar)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = a(paramArrayOfChar, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramArrayOfChar = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("encode js: ");
      localStringBuilder.append(paramString.getMessage());
      Log.e(paramArrayOfChar, localStringBuilder.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.EncodeUtil
 * JD-Core Version:    0.7.0.1
 */