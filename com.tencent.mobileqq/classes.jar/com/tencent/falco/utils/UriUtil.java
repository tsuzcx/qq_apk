package com.tencent.falco.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class UriUtil
{
  public static String getSpecifiedLevelDomain(String paramString, int paramInt)
  {
    str = "";
    localObject = str;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = str;
      if (paramInt <= 0) {}
    }
    try
    {
      paramString = Uri.parse(paramString);
      localObject = str;
      if (paramString.isHierarchical())
      {
        paramString = paramString.getHost();
        localObject = str;
        if (paramString != null)
        {
          paramString = paramString.split("\\.");
          localObject = str;
          if (paramString.length > 0)
          {
            int i = Math.max(0, paramString.length - (paramInt + 1));
            localObject = new StringBuilder(256);
            ((StringBuilder)localObject).append(paramString[i]);
            i += 1;
            while (i < paramString.length)
            {
              ((StringBuilder)localObject).append('.').append(paramString[i]);
              i += 1;
            }
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        localObject = str;
      }
    }
    Log.i("BasicUtils", "domain=" + (String)localObject + ",level=" + paramInt);
    return localObject;
  }
  
  public static String getTopLevelDomainInLowerCase(String paramString)
  {
    return getSpecifiedLevelDomain(paramString, 1).toLowerCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.UriUtil
 * JD-Core Version:    0.7.0.1
 */