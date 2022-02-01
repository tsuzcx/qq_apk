package com.tencent.acstat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.acstat.StatConfig;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StatPreferences
{
  private static SharedPreferences a = null;
  private static StatLogger b = StatCommonHelper.getLogger();
  
  public static boolean contains(Context paramContext, String paramString)
  {
    paramString = getStorageKey(paramContext, paramString);
    return getInstance(paramContext).contains(paramString);
  }
  
  public static Map<String, ?> getAll(Context paramContext)
  {
    return getInstance(paramContext).getAll();
  }
  
  public static boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = getStorageKey(paramContext, paramString);
    return getInstance(paramContext).getBoolean(paramString, paramBoolean);
  }
  
  public static float getFloat(Context paramContext, String paramString, float paramFloat)
  {
    paramString = getStorageKey(paramContext, paramString);
    return getInstance(paramContext).getFloat(paramString, paramFloat);
  }
  
  public static SharedPreferences getInstance(Context paramContext)
  {
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = a;
        if (localSharedPreferences == null) {}
        try
        {
          if ((StatConfig.getMTAPreferencesFileName() != null) && (StatConfig.getMTAPreferencesFileName().trim().length() != 0)) {
            continue;
          }
          a = PreferenceManager.getDefaultSharedPreferences(paramContext);
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          continue;
        }
        paramContext = a;
        return paramContext;
      }
      finally {}
      a = paramContext.getSharedPreferences(StatConfig.getMTAPreferencesFileName(), 0);
    }
  }
  
  public static int getInt(Context paramContext, String paramString, int paramInt)
  {
    paramString = getStorageKey(paramContext, paramString);
    return getInstance(paramContext).getInt(paramString, paramInt);
  }
  
  public static long getLong(Context paramContext, String paramString, long paramLong)
  {
    paramString = getStorageKey(paramContext, paramString);
    return getInstance(paramContext).getLong(paramString, paramLong);
  }
  
  public static String getStorageKey(Context paramContext, String paramString)
  {
    return StatCommonHelper.getTagForConcurrentProcess(paramContext, paramString);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = getStorageKey(paramContext, paramString1);
    return getInstance(paramContext).getString(paramString1, paramString2);
  }
  
  public static void putBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = getStorageKey(paramContext, paramString);
    paramContext = getInstance(paramContext).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void putFloat(Context paramContext, String paramString, float paramFloat)
  {
    paramString = getStorageKey(paramContext, paramString);
    paramContext = getInstance(paramContext).edit();
    paramContext.putFloat(paramString, paramFloat);
    paramContext.commit();
  }
  
  public static void putInt(Context paramContext, String paramString, int paramInt)
  {
    if (getInt(paramContext, paramString, 2147483647) == paramInt) {
      return;
    }
    paramString = getStorageKey(paramContext, paramString);
    paramContext = getInstance(paramContext).edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void putLong(Context paramContext, String paramString, long paramLong)
  {
    if (getLong(paramContext, paramString, 9223372036854775807L) == paramLong) {
      return;
    }
    paramString = getStorageKey(paramContext, paramString);
    paramContext = getInstance(paramContext).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.commit();
  }
  
  public static void putObjectList(Context paramContext, Map<String, Object> paramMap)
  {
    if ((paramContext == null) || (paramMap == null) || (paramMap.size() == 0)) {
      return;
    }
    b.i("putObjectList size:" + paramMap.size());
    SharedPreferences.Editor localEditor = getInstance(paramContext).edit();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = getStorageKey(paramContext, (String)((Map.Entry)localObject).getKey());
      localObject = ((Map.Entry)localObject).getValue();
      try
      {
        if (!(localObject instanceof String)) {
          break label175;
        }
        b.i("putObjectList putString:" + str + "," + localObject);
        localEditor.putString(str, (String)localObject);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      label175:
      if ((localObject instanceof Long))
      {
        b.i("putObjectList putLong:" + localException + "," + localObject);
        localEditor.putLong(localException, ((Long)localObject).longValue());
      }
      else if ((localObject instanceof Boolean))
      {
        b.i("putObjectList putBoolean:" + localException + "," + localObject);
        localEditor.putBoolean(localException, ((Boolean)localObject).booleanValue());
      }
      else if ((localObject instanceof Integer))
      {
        b.i("putObjectList putInt:" + localException + "," + localObject);
        localEditor.putInt(localException, ((Integer)localObject).intValue());
      }
      else if ((localObject instanceof Float))
      {
        b.i("putObjectList putFloat:" + localException + "," + localObject);
        localEditor.putFloat(localException, ((Float)localObject).floatValue());
      }
    }
    localEditor.commit();
  }
  
  public static void putString(Context paramContext, String paramString1, String paramString2)
  {
    String str = getString(paramContext, paramString1, null);
    if ((paramString2 == null) && (str == null)) {}
    while ((paramString2 != null) && (str != null) && (paramString2.equals(str))) {
      return;
    }
    paramString1 = getStorageKey(paramContext, paramString1);
    paramContext = getInstance(paramContext).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.acstat.common.StatPreferences
 * JD-Core Version:    0.7.0.1
 */