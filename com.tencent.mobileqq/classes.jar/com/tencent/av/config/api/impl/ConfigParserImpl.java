package com.tencent.av.config.api.impl;

import android.text.TextUtils;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.avcore.util.AVCoreLog;

public class ConfigParserImpl
  implements IConfigParser
{
  public static final String DEFAULT_VALUE = "unknown";
  private static final String TAG = "ConfigParserImpl";
  protected String mData = null;
  
  private String findConfigValue(String paramString)
  {
    try
    {
      GraphicRenderMgr.getInstance().findConfigValue(this.mData, paramString, "unknown");
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
      AVCoreLog.e("ConfigParserImpl", "findConfigValue", paramString);
    }
    return null;
  }
  
  public String getData()
  {
    return this.mData;
  }
  
  public int getIntValue(String paramString, int paramInt)
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
  
  public int[] getIntValues(String paramString)
  {
    paramString = findConfigValue(paramString);
    if ((paramString != null) && (!paramString.equalsIgnoreCase("unknown")))
    {
      paramString = paramString.split(",");
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
          label60:
          break label60;
        }
        arrayOfInt[i] = 0;
        i += 1;
      }
      return arrayOfInt;
    }
    else
    {
      return null;
    }
  }
  
  public String getStringValue(String paramString1, String paramString2)
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
  
  public String[] getStringValues(String paramString)
  {
    paramString = findConfigValue(paramString);
    if ((paramString != null) && (!paramString.equalsIgnoreCase("unknown"))) {
      return paramString.trim().split(",");
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return TextUtils.isEmpty(this.mData);
  }
  
  public void setData(String paramString)
  {
    this.mData = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.api.impl.ConfigParserImpl
 * JD-Core Version:    0.7.0.1
 */