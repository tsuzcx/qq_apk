package com.tencent.av.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class EffectMaterialUtil
{
  public static String a(Context paramContext, String paramString)
  {
    return SharedPreUtils.a(paramContext).getString(paramString, "");
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = SharedPreUtils.a(paramContext).edit();
    paramContext.remove(paramString);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = SharedPreUtils.a(paramContext).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.EffectMaterialUtil
 * JD-Core Version:    0.7.0.1
 */