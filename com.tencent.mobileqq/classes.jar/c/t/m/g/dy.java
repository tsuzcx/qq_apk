package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public final class dy
{
  public final float a;
  public final float b;
  public final float c;
  public final long d;
  
  public dy(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramLong;
  }
  
  public static SharedPreferences a(String paramString)
  {
    String str = dp.a().getPackageName();
    int i = 0;
    if ("com.tencent.mobileqq".equals(str)) {
      i = 4;
    }
    return dp.a().getSharedPreferences(paramString, i);
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    if ((paramObject instanceof String)) {
      paramSharedPreferences.putString(paramString, (String)paramObject);
    }
    while (Build.VERSION.SDK_INT >= 9)
    {
      paramSharedPreferences.apply();
      return;
      if ((paramObject instanceof Integer)) {
        paramSharedPreferences.putInt(paramString, ((Integer)paramObject).intValue());
      } else if ((paramObject instanceof Boolean)) {
        paramSharedPreferences.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      } else if ((paramObject instanceof Float)) {
        paramSharedPreferences.putFloat(paramString, ((Float)paramObject).floatValue());
      } else if ((paramObject instanceof Long)) {
        paramSharedPreferences.putLong(paramString, ((Long)paramObject).longValue());
      } else {
        paramSharedPreferences.putString(paramString, paramObject.toString());
      }
    }
    paramSharedPreferences.commit();
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject)
  {
    a(a(paramString1), paramString2, paramObject);
  }
  
  public static Object b(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return paramSharedPreferences.getString(paramString, (String)paramObject);
    }
    if ((paramObject instanceof Integer)) {
      return Integer.valueOf(paramSharedPreferences.getInt(paramString, ((Integer)paramObject).intValue()));
    }
    if ((paramObject instanceof Boolean)) {
      return Boolean.valueOf(paramSharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue()));
    }
    if ((paramObject instanceof Float)) {
      return Float.valueOf(paramSharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue()));
    }
    if ((paramObject instanceof Long)) {
      return Long.valueOf(paramSharedPreferences.getLong(paramString, ((Long)paramObject).longValue()));
    }
    return null;
  }
  
  public static Object b(String paramString1, String paramString2, Object paramObject)
  {
    return b(a(paramString1), paramString2, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.dy
 * JD-Core Version:    0.7.0.1
 */