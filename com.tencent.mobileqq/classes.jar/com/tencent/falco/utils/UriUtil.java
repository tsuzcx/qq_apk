package com.tencent.falco.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class UriUtil
{
  public static String getSpecifiedLevelDomain(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    Object localObject = str;
    if (!bool)
    {
      localObject = str;
      if (paramInt <= 0) {}
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = Uri.parse(paramString);
        localObject = str;
        if (!paramString.isHierarchical()) {
          break label150;
        }
        paramString = paramString.getHost();
        localObject = str;
        if (paramString == null) {
          break label150;
        }
        paramString = paramString.split("\\.");
        localObject = str;
        if (paramString.length <= 0) {
          break label150;
        }
        i = Math.max(0, paramString.length - (paramInt + 1));
        localObject = new StringBuilder(256);
        ((StringBuilder)localObject).append(paramString[i]);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        localObject = str;
      }
      if (i < paramString.length)
      {
        ((StringBuilder)localObject).append('.');
        ((StringBuilder)localObject).append(paramString[i]);
      }
      else
      {
        localObject = ((StringBuilder)localObject).toString();
        label150:
        paramString = new StringBuilder();
        paramString.append("domain=");
        paramString.append((String)localObject);
        paramString.append(",level=");
        paramString.append(paramInt);
        Log.i("BasicUtils", paramString.toString());
        return localObject;
      }
      i += 1;
    }
  }
  
  public static String getTopLevelDomainInLowerCase(String paramString)
  {
    return getSpecifiedLevelDomain(paramString, 1).toLowerCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.UriUtil
 * JD-Core Version:    0.7.0.1
 */