package com.huawei.hms.aaid.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PushPreferences
{
  public static final String TAG = "PushPreferences";
  public SharedPreferences a;
  
  public PushPreferences(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      Context localContext = paramContext;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localContext = paramContext.createDeviceProtectedStorageContext();
        SharedPreferences localSharedPreferences = localContext.getSharedPreferences("move_to_de_records", 0);
        if (!localSharedPreferences.getBoolean(paramString, false)) {
          if (!localContext.moveSharedPreferencesFrom(paramContext, paramString))
          {
            localContext = paramContext;
          }
          else
          {
            paramContext = localSharedPreferences.edit();
            paramContext.putBoolean(paramString, true);
            paramContext.apply();
          }
        }
      }
      this.a = b(localContext, paramString);
      if (this.a == null)
      {
        HMSLog.w("PushPreferences", "get new sharedPreferences failed,start to get from context. ");
        this.a = localContext.getSharedPreferences(paramString, 0);
      }
      return;
    }
    throw new NullPointerException("context is null!");
  }
  
  public final File a(Context paramContext, String paramString)
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      StringBuilder localStringBuilder;
      if (i >= 24)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getDataDir());
        localStringBuilder.append("/shared_prefs");
        paramContext = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".xml");
        paramContext = new File(paramContext, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getFilesDir().getParent());
        localStringBuilder.append("/shared_prefs");
        paramContext = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".xml");
        paramContext = new File(paramContext, localStringBuilder.toString());
      }
      boolean bool = paramContext.exists();
      if (!bool) {
        return null;
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("get failed error.");
      paramString.append(paramContext.getMessage());
      HMSLog.e("PushPreferences", paramString.toString());
    }
    return null;
  }
  
  public final SharedPreferences b(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramString = Class.forName("android.app.SharedPreferencesImpl").getDeclaredConstructor(new Class[] { File.class, Integer.TYPE });
      paramString.setAccessible(true);
      paramContext = (SharedPreferences)paramString.newInstance(new Object[] { paramContext, Integer.valueOf(0) });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("get SharedPreferences error.");
      paramString.append(paramContext.getMessage());
      HMSLog.e("PushPreferences", paramString.toString());
    }
    return null;
  }
  
  public boolean clear()
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.edit().clear().commit();
    }
    return false;
  }
  
  public boolean containsKey(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    return (localSharedPreferences != null) && (localSharedPreferences.contains(paramString));
  }
  
  public Map<String, ?> getAll()
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences != null) {
      return localSharedPreferences.getAll();
    }
    return new HashMap();
  }
  
  public boolean getBoolean(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean(paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int getInt(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    int i = 0;
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt(paramString, 0);
    }
    return i;
  }
  
  public long getLong(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    long l = 0L;
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString, 0L);
    }
    return l;
  }
  
  public String getString(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    String str = "";
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString(paramString, "");
    }
    return str;
  }
  
  public ContentValues read()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((SharedPreferences)localObject1).getAll();
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new ContentValues();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      String str = (String)((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      if ((localObject3 instanceof String)) {
        ((ContentValues)localObject1).put(str, String.valueOf(localObject3));
      } else if ((!(localObject3 instanceof Integer)) && (!(localObject3 instanceof Short)) && (!(localObject3 instanceof Byte)))
      {
        if ((localObject3 instanceof Long)) {
          ((ContentValues)localObject1).put(str, (Long)localObject3);
        } else if ((localObject3 instanceof Float)) {
          ((ContentValues)localObject1).put(str, (Float)localObject3);
        } else if ((localObject3 instanceof Double)) {
          ((ContentValues)localObject1).put(str, Float.valueOf((float)((Double)localObject3).doubleValue()));
        } else if ((localObject3 instanceof Boolean)) {
          ((ContentValues)localObject1).put(str, (Boolean)localObject3);
        }
      }
      else {
        ((ContentValues)localObject1).put(str, (Integer)localObject3);
      }
    }
    return localObject1;
  }
  
  public boolean removeKey(String paramString)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((SharedPreferences)localObject).contains(paramString)))
    {
      localObject = this.a.edit();
      if (localObject != null) {
        return ((SharedPreferences.Editor)localObject).remove(paramString).commit();
      }
    }
    return false;
  }
  
  public boolean removeKey(String[] paramArrayOfString)
  {
    Object localObject = this.a;
    int i = 0;
    if (localObject == null) {
      return false;
    }
    int j = paramArrayOfString.length;
    while (i < j)
    {
      localObject = paramArrayOfString[i];
      if (this.a.contains((String)localObject)) {
        this.a.edit().remove((String)localObject);
      }
      i += 1;
    }
    this.a.edit().commit();
    return true;
  }
  
  public boolean save(String paramString, Object paramObject)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if ((paramObject instanceof String)) {
      ((SharedPreferences.Editor)localObject).putString(paramString, String.valueOf(paramObject));
    } else if ((paramObject instanceof Integer)) {
      ((SharedPreferences.Editor)localObject).putInt(paramString, ((Integer)paramObject).intValue());
    } else if ((paramObject instanceof Short)) {
      ((SharedPreferences.Editor)localObject).putInt(paramString, ((Short)paramObject).shortValue());
    } else if ((paramObject instanceof Byte)) {
      ((SharedPreferences.Editor)localObject).putInt(paramString, ((Byte)paramObject).byteValue());
    } else if ((paramObject instanceof Long)) {
      ((SharedPreferences.Editor)localObject).putLong(paramString, ((Long)paramObject).longValue());
    } else if ((paramObject instanceof Float)) {
      ((SharedPreferences.Editor)localObject).putFloat(paramString, ((Float)paramObject).floatValue());
    } else if ((paramObject instanceof Double)) {
      ((SharedPreferences.Editor)localObject).putFloat(paramString, (float)((Double)paramObject).doubleValue());
    } else if ((paramObject instanceof Boolean)) {
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
    return ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void saveBoolean(String paramString, boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject != null) {
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, paramBoolean).commit();
    }
  }
  
  public void saveInt(String paramString, Integer paramInteger)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject != null) {
      ((SharedPreferences.Editor)localObject).putInt(paramString, paramInteger.intValue()).commit();
    }
  }
  
  public void saveLong(String paramString, Long paramLong)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject != null) {
      ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong.longValue()).commit();
    }
  }
  
  public void saveMap(Map<String, Object> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      save((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public boolean saveString(String paramString1, String paramString2)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject != null) {
      return ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2).commit();
    }
    return false;
  }
  
  public boolean write(ContentValues paramContentValues)
  {
    if (this.a != null)
    {
      if (paramContentValues == null) {
        return false;
      }
      boolean bool = true;
      paramContentValues = paramContentValues.valueSet().iterator();
      while (paramContentValues.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContentValues.next();
        if (!save((String)localEntry.getKey(), localEntry.getValue())) {
          bool = false;
        }
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.aaid.utils.PushPreferences
 * JD-Core Version:    0.7.0.1
 */