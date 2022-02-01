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
    int i = paramInt1;
    int j = 0;
    while (i < m)
    {
      int k;
      if (paramCharSequence.charAt(i) < '') {
        k = 1;
      } else {
        k = 2;
      }
      j += k;
      if (j > paramInt2)
      {
        paramInt2 = i;
        if (i > 0)
        {
          paramInt2 = i;
          if (Character.isHighSurrogate(paramCharSequence.charAt(i - 1))) {
            paramInt2 = i - 1;
          }
        }
        return paramCharSequence.subSequence(paramInt1, paramInt2);
      }
      i += 1;
    }
    return paramCharSequence;
  }
  
  public static boolean containLetter(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("[a-zA-z]").matcher(paramString).find();
  }
  
  public static CharSequence filterEnter(CharSequence paramCharSequence)
  {
    int j = TextUtils.indexOf(paramCharSequence, '\n');
    int k = TextUtils.indexOf(paramCharSequence, '\r');
    if (j != -1)
    {
      i = j;
      if (k == -1) {
        break label41;
      }
      if (j < k)
      {
        i = j;
        break label41;
      }
    }
    int i = k;
    label41:
    if (i != -1)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramCharSequence.subSequence(0, i));
      i += 1;
      for (;;)
      {
        k = TextUtils.indexOf(paramCharSequence, '\n', i);
        int m = TextUtils.indexOf(paramCharSequence, '\r', i);
        if (k != -1)
        {
          j = k;
          if (m == -1) {
            break label120;
          }
          if (k < m)
          {
            j = k;
            break label120;
          }
        }
        j = m;
        label120:
        if (j == -1)
        {
          localArrayList.add(paramCharSequence.subSequence(i, paramCharSequence.length()));
          return TextUtils.concat((CharSequence[])localArrayList.toArray(new CharSequence[localArrayList.size()]));
        }
        localArrayList.add(paramCharSequence.subSequence(i, j));
        i = j + 1;
      }
    }
    return paramCharSequence;
  }
  
  public static int getLength(CharSequence paramCharSequence)
  {
    int i = 0;
    if (paramCharSequence == null) {
      return 0;
    }
    int k = paramCharSequence.length();
    int j = 0;
    while (i < k)
    {
      paramCharSequence.charAt(i);
      j += 1;
      i += 1;
    }
    return j;
  }
  
  public static int getLengthChEn(CharSequence paramCharSequence)
  {
    int i = 0;
    if (paramCharSequence == null) {
      return 0;
    }
    int m = paramCharSequence.length();
    int j = 0;
    while (i < m)
    {
      int k;
      if (paramCharSequence.charAt(i) < '') {
        k = 1;
      } else {
        k = 2;
      }
      j += k;
      i += 1;
    }
    return j;
  }
  
  public static CharSequence trim(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      int i = 0;
      int k = paramCharSequence.length() - 1;
      int j;
      for (;;)
      {
        j = k;
        if (i > k) {
          break;
        }
        j = paramCharSequence.charAt(i);
        if ((j != 32) && (j != 12288))
        {
          j = k;
          break;
        }
        i += 1;
      }
      while (i < j)
      {
        k = paramCharSequence.charAt(j);
        if ((k != 32) && (k != 12288)) {
          break;
        }
        j -= 1;
      }
      if (i > j) {
        return "";
      }
      if ((i == 0) && (j == paramCharSequence.length() - 1)) {
        return paramCharSequence;
      }
      return paramCharSequence.subSequence(i, j + 1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.EditorUtil
 * JD-Core Version:    0.7.0.1
 */