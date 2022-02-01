package com.tencent.av.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class EffectMaterialUtil
{
  public static String a(Context paramContext, String paramString)
  {
    return SharedPreUtils.B(paramContext).getString(paramString, "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = SharedPreUtils.B(paramContext).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.apply();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = SharedPreUtils.B(paramContext).edit();
    paramContext.remove(paramString);
    paramContext.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.EffectMaterialUtil
 * JD-Core Version:    0.7.0.1
 */