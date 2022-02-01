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
      paramContext = new File(paramContext.getFilesDir().getParent() + File.separator + "shared_prefs").listFiles();
      if (paramContext == null) {
        return;
      }
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramContext[i];
        if (localObject.getName().startsWith("Tencent_MapSDK_SUB_CONFIG")) {
          localObject.delete();
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
    if (b != null) {
      b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ge
 * JD-Core Version:    0.7.0.1
 */