package com.tencent.av.config;

import android.text.TextUtils;
import com.tencent.av.opengl.GraphicRenderMgr;

public final class ConfigBaseParser
{
  protected String a;
  
  public ConfigBaseParser(String paramString)
  {
    this.a = paramString;
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = GraphicRenderMgr.getInstance().findConfigValue(this.a, paramString, "unknown");
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public int a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      paramString = a(paramString);
    } while ((paramString == null) || (paramString.length <= 0));
    return paramString[0];
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return paramString2;
      paramString1 = a(paramString1);
    } while ((paramString1 == null) || (paramString1.length <= 0));
    return paramString1[0];
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(this.a);
  }
  
  public int[] a(String paramString)
  {
    int[] arrayOfInt = null;
    Object localObject = a(paramString);
    paramString = arrayOfInt;
    if (localObject != null)
    {
      if (!((String)localObject).equalsIgnoreCase("unknown")) {
        break label33;
      }
      paramString = arrayOfInt;
    }
    label33:
    do
    {
      return paramString;
      localObject = ((String)localObject).split(",");
      paramString = arrayOfInt;
    } while (localObject == null);
    int j = localObject.length;
    arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      paramString = arrayOfInt;
      if (i >= j) {
        break;
      }
      try
      {
        arrayOfInt[i] = Integer.parseInt(localObject[i].trim());
        i += 1;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          arrayOfInt[i] = 0;
        }
      }
    }
  }
  
  public String[] a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (paramString.equalsIgnoreCase("unknown"))) {
      return null;
    }
    return paramString.trim().split(",");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigBaseParser
 * JD-Core Version:    0.7.0.1
 */