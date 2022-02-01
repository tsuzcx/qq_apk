package com.tencent.map.sdk.a;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ge
  extends gc
{
  private static Map<String, gc> b = new HashMap();
  
  private ge(Context paramContext, String paramString)
  {
    this.a = paramContext.getSharedPreferences("Tencent_MapSDK_SUB_CONFIG_".concat(String.valueOf(paramString)), 0);
  }
  
  public static gc a(Context paramContext, String paramString)
  {
    if (nl.a(paramString)) {
      return gf.a(paramContext);
    }
    if (b.get(paramString) == null) {
      try
      {
        if (b.get(paramString) == null)
        {
          paramContext = new ge(paramContext, paramString);
          b.put(paramString, paramContext);
          return paramContext;
        }
      }
      finally {}
    }
    return (gc)b.get(paramString);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir().getParent());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("shared_prefs");
      paramContext = new File(localStringBuilder.toString()).listFiles();
      if (paramContext == null) {
        return;
      }
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder = paramContext[i];
        if (localStringBuilder.getName().startsWith("Tencent_MapSDK_SUB_CONFIG")) {
          localStringBuilder.delete();
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void c()
  {
    Map localMap = b;
    if (localMap != null) {
      localMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ge
 * JD-Core Version:    0.7.0.1
 */