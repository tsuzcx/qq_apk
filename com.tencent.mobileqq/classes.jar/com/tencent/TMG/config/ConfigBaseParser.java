package com.tencent.TMG.config;

import android.text.TextUtils;

public class ConfigBaseParser
{
  public static final String DEFAULT_VALUE = "unknown";
  protected String mData = null;
  
  public ConfigBaseParser() {}
  
  public ConfigBaseParser(String paramString)
  {
    this.mData = paramString;
  }
  
  public native String findConfigValue(String paramString1, String paramString2, String paramString3);
  
  public native String getConfig();
  
  protected int getIntValue(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    paramString = getIntValues(paramString);
    if ((paramString != null) && (paramString.length > 0)) {
      return paramString[0];
    }
    return paramInt;
  }
  
  protected int[] getIntValues(String paramString)
  {
    if (TextUtils.isEmpty(this.mData)) {
      this.mData = getConfig();
    }
    paramString = findConfigValue(this.mData, paramString, "unknown");
    if (paramString != null)
    {
      if (paramString.equalsIgnoreCase("unknown")) {
        return null;
      }
      paramString = paramString.split(",");
      if (paramString == null) {
        return null;
      }
      int j = paramString.length;
      int[] arrayOfInt = new int[j];
      int i = 0;
      while (i < j)
      {
        try
        {
          arrayOfInt[i] = Integer.parseInt(paramString[i].trim());
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          arrayOfInt[i] = 0;
        }
        i += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  protected String getStringValue(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    paramString1 = getStringValues(paramString1);
    if ((paramString1 != null) && (paramString1.length > 0)) {
      return paramString1[0];
    }
    return paramString2;
  }
  
  protected String[] getStringValues(String paramString)
  {
    if (TextUtils.isEmpty(this.mData)) {
      this.mData = getConfig();
    }
    paramString = findConfigValue(this.mData, paramString, "unknown");
    if ((paramString != null) && (!paramString.equalsIgnoreCase("unknown"))) {
      return paramString.trim().split(",");
    }
    return null;
  }
  
  public void setConfig(String paramString)
  {
    this.mData = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.config.ConfigBaseParser
 * JD-Core Version:    0.7.0.1
 */