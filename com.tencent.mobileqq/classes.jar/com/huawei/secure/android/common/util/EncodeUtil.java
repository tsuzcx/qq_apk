package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public class EncodeUtil
{
  private static final String TAG = EncodeUtil.class.getSimpleName();
  private static final char[] f = { 44, 46, 95 };
  private static final String[] g = new String[256];
  
  static
  {
    char c = '\000';
    if (c < 'ÿ')
    {
      if (((c < '0') || (c > '9')) && ((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z'))) {
        g[c] = b(c).intern();
      }
      for (;;)
      {
        c = (char)(c + '\001');
        break;
        g[c] = null;
      }
    }
  }
  
  private static Character a(a parama)
  {
    int j = 0;
    int i = 0;
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
    StringBuilder localStringBuilder;
    Character localCharacter2;
    char c;
    if (Character.toLowerCase(localCharacter1.charValue()) == 'x')
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
      try
      {
        i = Integer.parseInt(localStringBuilder.toString(), 16);
        if (!Character.isValidCodePoint(i)) {
          break label511;
        }
        c = (char)i;
        return Character.valueOf(c);
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        parama.reset();
        return null;
      }
    }
    else if (Character.toLowerCase(localNumberFormatException1.charValue()) == 'u')
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
      try
      {
        i = Integer.parseInt(localStringBuilder.toString(), 16);
        if (!Character.isValidCodePoint(i)) {
          break label511;
        }
        c = (char)i;
        return Character.valueOf(c);
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        parama.reset();
        return null;
      }
    }
    else if (a.c(localNumberFormatException2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localNumberFormatException2);
      localCharacter2 = parama.b();
      if (!a.c(localCharacter2)) {
        parama.a(localCharacter2);
      }
      for (;;)
      {
        try
        {
          i = Integer.parseInt(localStringBuilder.toString(), 8);
          if (!Character.isValidCodePoint(i)) {
            break;
          }
          c = (char)i;
          return Character.valueOf(c);
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          parama.reset();
          return null;
        }
        localStringBuilder.append(localCharacter2);
        localCharacter2 = parama.b();
        if (!a.c(localCharacter2)) {
          parama.a(localCharacter2);
        } else {
          localStringBuilder.append(localCharacter2);
        }
      }
    }
    label511:
    return localNumberFormatException3;
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
    if (a(paramCharacter.charValue(), paramArrayOfChar)) {
      return "" + paramCharacter;
    }
    if (a(paramCharacter.charValue()) == null) {
      return "" + paramCharacter;
    }
    paramArrayOfChar = Integer.toHexString(paramCharacter.charValue());
    if (paramCharacter.charValue() < 'Ā') {
      return "\\x" + "00".substring(paramArrayOfChar.length()) + paramArrayOfChar.toUpperCase(Locale.ENGLISH);
    }
    return "\\u" + "0000".substring(paramArrayOfChar.length()) + paramArrayOfChar.toUpperCase(Locale.ENGLISH);
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
    boolean bool2 = false;
    int j = paramArrayOfChar.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramChar == paramArrayOfChar[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
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
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        paramString = new a(paramString);
        if (!paramString.hasNext()) {
          break;
        }
        Character localCharacter = a(paramString);
        if (localCharacter != null) {
          localStringBuilder.append(localCharacter);
        } else {
          localStringBuilder.append(paramString.b());
        }
      }
      catch (Exception paramString)
      {
        Log.e(TAG, "decode js: " + paramString.getMessage());
        return "";
      }
    }
    paramString = localStringBuilder.toString();
    return paramString;
  }
  
  public static String encodeForJavaScript(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = a(f, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e(TAG, "encode js: " + paramString.getMessage());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.EncodeUtil
 * JD-Core Version:    0.7.0.1
 */