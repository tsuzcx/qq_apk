package com.tencent.falco.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditorUtil
{
  public static CharSequence clip(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int m = paramCharSequence.length();
    int j = 0;
    int i = paramInt1;
    for (;;)
    {
      CharSequence localCharSequence = paramCharSequence;
      if (i < m) {
        if (paramCharSequence.charAt(i) >= '') {
          break label91;
        }
      }
      label91:
      for (int k = 1;; k = 2)
      {
        j = k + j;
        if (j <= paramInt2) {
          break;
        }
        paramInt2 = i;
        if (i > 0)
        {
          paramInt2 = i;
          if (Character.isHighSurrogate(paramCharSequence.charAt(i - 1))) {
            paramInt2 = i - 1;
          }
        }
        localCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
        return localCharSequence;
      }
      i += 1;
    }
  }
  
  public static boolean containLetter(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!Pattern.compile("[a-zA-z]").matcher(paramString).find()) {
      return false;
    }
    return true;
  }
  
  public static CharSequence filterEnter(CharSequence paramCharSequence)
  {
    int j = TextUtils.indexOf(paramCharSequence, '\n');
    int k = TextUtils.indexOf(paramCharSequence, '\r');
    int i;
    Object localObject;
    if (j == -1)
    {
      i = k;
      localObject = paramCharSequence;
      if (i != -1)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramCharSequence.subSequence(0, i));
        i += 1;
      }
    }
    for (;;)
    {
      k = TextUtils.indexOf(paramCharSequence, '\n', i);
      int m = TextUtils.indexOf(paramCharSequence, '\r', i);
      if (k == -1) {
        j = m;
      }
      for (;;)
      {
        if (j != -1) {
          break label166;
        }
        ((ArrayList)localObject).add(paramCharSequence.subSequence(i, paramCharSequence.length()));
        localObject = TextUtils.concat((CharSequence[])((ArrayList)localObject).toArray(new CharSequence[((ArrayList)localObject).size()]));
        return localObject;
        if (k != -1)
        {
          i = k;
          if (j >= k) {
            break;
          }
        }
        i = j;
        break;
        if (m != -1)
        {
          j = m;
          if (k >= m) {}
        }
        else
        {
          j = k;
        }
      }
      label166:
      ((ArrayList)localObject).add(paramCharSequence.subSequence(i, j));
      i = j + 1;
    }
  }
  
  public static int getLength(CharSequence paramCharSequence)
  {
    int i = 0;
    int k = 0;
    if (paramCharSequence == null) {
      return k;
    }
    int m = paramCharSequence.length();
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      paramCharSequence.charAt(j);
      j += 1;
      i += 1;
    }
  }
  
  public static int getLengthChEn(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0;
    }
    int m = paramCharSequence.length();
    int i = 0;
    int j = 0;
    if (i < m)
    {
      if (paramCharSequence.charAt(i) < '') {}
      for (int k = 1;; k = 2)
      {
        j += k;
        i += 1;
        break;
      }
    }
    return j;
  }
  
  public static CharSequence trim(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      int i = 0;
      int k = paramCharSequence.length() - 1;
      int j = k;
      label45:
      Object localObject;
      if (i <= k)
      {
        j = paramCharSequence.charAt(i);
        if ((j != 32) && (j != 12288)) {
          j = k;
        }
      }
      else
      {
        if (i < j)
        {
          k = paramCharSequence.charAt(j);
          if ((k == 32) || (k == 12288)) {
            break label90;
          }
        }
        if (i <= j) {
          break label97;
        }
        localObject = "";
      }
      label90:
      label97:
      do
      {
        return localObject;
        i += 1;
        break;
        j -= 1;
        break label45;
        if (i != 0) {
          break label116;
        }
        localObject = paramCharSequence;
      } while (j == paramCharSequence.length() - 1);
      label116:
      return paramCharSequence.subSequence(i, j + 1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.EditorUtil
 * JD-Core Version:    0.7.0.1
 */