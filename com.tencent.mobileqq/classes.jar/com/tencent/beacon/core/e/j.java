package com.tencent.beacon.core.e;

import java.util.ArrayList;
import java.util.List;

public class j
{
  public static String a(String paramString)
  {
    return paramString.trim().replace(" ", "").replace("\t", "").replace("&", "").replace(":", "").replace("=", "").replace(";", "");
  }
  
  public static void a(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] == null) {
        paramArrayOfString[i] = "";
      }
      i += 1;
    }
  }
  
  public static String b(String paramString)
  {
    int m = 0;
    if (c(paramString)) {
      return "";
    }
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramString = paramString.toCharArray();
    int n = paramString.length;
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= n) {
        break;
      }
      char c = paramString[j];
      if (c == ']')
      {
        if (!localArrayList.contains(localStringBuilder2.toString())) {
          localArrayList.add(localStringBuilder2.toString());
        }
        localStringBuilder2.delete(0, localStringBuilder2.length());
        i = 0;
      }
      if (i != 0) {
        localStringBuilder2.append(c);
      }
      if (c == '[') {
        i = 1;
      }
      j += 1;
    }
    if (k < localArrayList.size())
    {
      paramString = (String)localArrayList.get(k);
      if (paramString.length() != 20) {}
      for (;;)
      {
        k += 1;
        break;
        localStringBuilder1.append(paramString);
        if (k + 1 != localArrayList.size()) {
          localStringBuilder1.append(",");
        }
      }
    }
    return localStringBuilder1.toString();
  }
  
  public static boolean c(String paramString)
  {
    return (paramString == null) || (paramString.equals(""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.e.j
 * JD-Core Version:    0.7.0.1
 */