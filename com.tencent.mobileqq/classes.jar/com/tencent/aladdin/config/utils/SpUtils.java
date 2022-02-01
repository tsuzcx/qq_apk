package com.tencent.aladdin.config.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aladdin.config.Aladdin;

public class SpUtils
{
  private static final String TAG = "SpUtils";
  private static SpUtils.IAladdinSpOperator aladdinSpOperator;
  @SuppressLint({"StaticFieldLeak"})
  private static Context sContext;
  
  private static SharedPreferences getAladdinSp(boolean paramBoolean)
  {
    String str = "aladdin_sp";
    if (paramBoolean)
    {
      str = Aladdin.getCurrentUserId();
      str = "aladdin_sp" + "_" + str;
    }
    if (sContext != null) {
      return sContext.getSharedPreferences(str, 0);
    }
    return null;
  }
  
  public static <T> T getSpValue(String paramString, T paramT, boolean paramBoolean)
  {
    if (aladdinSpOperator != null) {
      return aladdinSpOperator.getSpValue(paramString, paramT, paramBoolean);
    }
    if (sContext != null) {
      return getSpValueImp(paramString, paramT, paramBoolean);
    }
    Log.i("SpUtils", "[getSpValue] failed, need to init or register aladdin sp.");
    return paramT;
  }
  
  private static <T> T getSpValueImp(String paramString, T paramT, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getAladdinSp(paramBoolean);
    if (localSharedPreferences == null) {
      Log.e("SpUtils", "[getSpValueImp] sp is null.");
    }
    do
    {
      return paramT;
      if ((paramT instanceof String)) {
        return localSharedPreferences.getString(paramString, (String)paramT);
      }
      if ((paramT instanceof Integer)) {
        return Integer.valueOf(localSharedPreferences.getInt(paramString, ((Integer)paramT).intValue()));
      }
      if ((paramT instanceof Long)) {
        return Long.valueOf(localSharedPreferences.getLong(paramString, ((Long)paramT).longValue()));
      }
      if ((paramT instanceof Boolean)) {
        return Boolean.valueOf(localSharedPreferences.getBoolean(paramString, ((Boolean)paramT).booleanValue()));
      }
    } while (!(paramT instanceof Float));
    return Float.valueOf(localSharedPreferences.getFloat(paramString, ((Float)paramT).floatValue()));
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext == null)
    {
      Log.e("SpUtils", "[init] failed, context is null.");
      return;
    }
    sContext = paramContext.getApplicationContext();
    Log.i("SpUtils", "[init]");
  }
  
  public static void registerAladdinSharedPreferences(SpUtils.IAladdinSpOperator paramIAladdinSpOperator)
  {
    aladdinSpOperator = paramIAladdinSpOperator;
  }
  
  public static <T> void updateSpValue(String paramString, T paramT, boolean paramBoolean)
  {
    if (aladdinSpOperator != null)
    {
      aladdinSpOperator.updateSpValue(paramString, paramT, paramBoolean);
      return;
    }
    if (sContext != null)
    {
      updateSpValueImp(paramString, paramT, paramBoolean);
      return;
    }
    Log.i("SpUtils", "[updateSpValue] failed, need to init or register aladdin sp.");
  }
  
  private static <T> void updateSpValueImp(String paramString, T paramT, boolean paramBoolean)
  {
    Object localObject = getAladdinSp(paramBoolean);
    if (localObject == null)
    {
      Log.e("SpUtils", "[updateSpValueImp] sp is null.");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramT instanceof String)) {
      ((SharedPreferences.Editor)localObject).putString(paramString, (String)paramT);
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).apply();
      return;
      if ((paramT instanceof Integer))
      {
        ((SharedPreferences.Editor)localObject).putInt(paramString, ((Integer)paramT).intValue());
      }
      else if ((paramT instanceof Long))
      {
        ((SharedPreferences.Editor)localObject).putLong(paramString, ((Long)paramT).longValue());
      }
      else if ((paramT instanceof Float))
      {
        ((SharedPreferences.Editor)localObject).putFloat(paramString, ((Float)paramT).floatValue());
      }
      else
      {
        if (!(paramT instanceof Boolean)) {
          break;
        }
        ((SharedPreferences.Editor)localObject).putBoolean(paramString, ((Boolean)paramT).booleanValue());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[updateSpValueImp]: unsupported type ");
    if (paramT != null) {}
    for (paramString = paramT.getClass();; paramString = "null")
    {
      Log.d("SpUtils", paramString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.utils.SpUtils
 * JD-Core Version:    0.7.0.1
 */