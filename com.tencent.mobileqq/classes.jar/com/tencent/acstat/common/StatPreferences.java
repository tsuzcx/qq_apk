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
  private static SharedPreferences a;
  private static StatLogger b = ;
  
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
    try
    {
      SharedPreferences localSharedPreferences = a;
      if (localSharedPreferences == null) {
        try
        {
          if ((StatConfig.getMTAPreferencesFileName() != null) && (StatConfig.getMTAPreferencesFileName().trim().length() != 0)) {}
          for (paramContext = paramContext.getSharedPreferences(StatConfig.getMTAPreferencesFileName(), 0);; paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext))
          {
            a = paramContext;
            break;
          }
          paramContext = a;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      return paramContext;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    return StatCommonHelper.getTagForConcurrentProcess(paramContext, localStringBuilder.toString());
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
    if ((paramContext != null) && (paramMap != null))
    {
      if (paramMap.size() == 0) {
        return;
      }
      Object localObject1 = b;
      Object localObject2 = new StringBuilder("putObjectList size:");
      ((StringBuilder)localObject2).append(paramMap.size());
      ((StatLogger)localObject1).i(((StringBuilder)localObject2).toString());
      localObject1 = getInstance(paramContext).edit();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject3 = (Map.Entry)paramMap.next();
        localObject2 = getStorageKey(paramContext, (String)((Map.Entry)localObject3).getKey());
        localObject3 = ((Map.Entry)localObject3).getValue();
        try
        {
          boolean bool = localObject3 instanceof String;
          StatLogger localStatLogger;
          StringBuilder localStringBuilder;
          if (bool)
          {
            localStatLogger = b;
            localStringBuilder = new StringBuilder("putObjectList putString:");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(",");
            localStringBuilder.append(localObject3);
            localStatLogger.i(localStringBuilder.toString());
            ((SharedPreferences.Editor)localObject1).putString((String)localObject2, (String)localObject3);
          }
          else if ((localObject3 instanceof Long))
          {
            localStatLogger = b;
            localStringBuilder = new StringBuilder("putObjectList putLong:");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(",");
            localStringBuilder.append(localObject3);
            localStatLogger.i(localStringBuilder.toString());
            ((SharedPreferences.Editor)localObject1).putLong((String)localObject2, ((Long)localObject3).longValue());
          }
          else if ((localObject3 instanceof Boolean))
          {
            localStatLogger = b;
            localStringBuilder = new StringBuilder("putObjectList putBoolean:");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(",");
            localStringBuilder.append(localObject3);
            localStatLogger.i(localStringBuilder.toString());
            ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject2, ((Boolean)localObject3).booleanValue());
          }
          else if ((localObject3 instanceof Integer))
          {
            localStatLogger = b;
            localStringBuilder = new StringBuilder("putObjectList putInt:");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(",");
            localStringBuilder.append(localObject3);
            localStatLogger.i(localStringBuilder.toString());
            ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, ((Integer)localObject3).intValue());
          }
          else if ((localObject3 instanceof Float))
          {
            localStatLogger = b;
            localStringBuilder = new StringBuilder("putObjectList putFloat:");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(",");
            localStringBuilder.append(localObject3);
            localStatLogger.i(localStringBuilder.toString());
            ((SharedPreferences.Editor)localObject1).putFloat((String)localObject2, ((Float)localObject3).floatValue());
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      ((SharedPreferences.Editor)localObject1).commit();
    }
  }
  
  public static void putString(Context paramContext, String paramString1, String paramString2)
  {
    String str = getString(paramContext, paramString1, null);
    if ((paramString2 == null) && (str == null)) {
      return;
    }
    if ((paramString2 != null) && (str != null) && (paramString2.equals(str))) {
      return;
    }
    paramString1 = getStorageKey(paramContext, paramString1);
    paramContext = getInstance(paramContext).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.common.StatPreferences
 * JD-Core Version:    0.7.0.1
 */