package com.tencent.biz.qqstory.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConfigManager
  implements IManager
{
  protected SharedPreferences a;
  protected AtomicBoolean a;
  
  public ConfigManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(@Nullable String paramString1, @Nullable Object paramObject, @Nullable String paramString2)
  {
    paramString2 = new StringBuilder().append("key=").append(paramString1).append(" expected ").append(paramString2).append(" but value was ");
    if (paramObject == null) {}
    for (paramString1 = "null";; paramString1 = paramObject.getClass().getName())
    {
      SLog.d("ConfigManager", paramString1);
      return;
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IllegalStateException("have not attachContext");
    }
  }
  
  public Object a(@NonNull String paramString, @NonNull Object paramObject)
  {
    c();
    Object localObject;
    if (paramObject.getClass() == Integer.class) {
      localObject = Integer.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, ((Integer)paramObject).intValue()));
    }
    for (;;)
    {
      SLog.b("ConfigManager", "get value : K : %s, V : %s", paramString, localObject);
      if ((localObject == null) || (localObject.getClass() != paramObject.getClass())) {
        break label183;
      }
      return localObject;
      if (paramObject.getClass() == Long.class)
      {
        localObject = Long.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramString, ((Long)paramObject).longValue()));
      }
      else if (paramObject.getClass() == String.class)
      {
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, (String)paramObject);
      }
      else
      {
        if (paramObject.getClass() != Boolean.class) {
          break;
        }
        localObject = Boolean.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue()));
      }
    }
    throw new IllegalArgumentException("defValue class is not support : " + paramObject.getClass());
    label183:
    a(paramString, localObject, paramObject.getClass().getName());
    return paramObject;
  }
  
  public void a()
  {
    SLog.b("ConfigManager", "onInit");
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      SLog.b("ConfigManager", "attachContext, " + paramContext);
      this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("qqstory_config", 4);
      return;
    }
    SLog.d("ConfigManager", "attachContext duplicate");
  }
  
  public void a(String paramString, Object paramObject)
  {
    c();
    boolean bool;
    if (paramObject.getClass() == Integer.class) {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, ((Integer)paramObject).intValue()).commit();
    }
    while (!bool)
    {
      SLog.e("ConfigManager", "set value error : K:%s, V:%s .", new Object[] { paramString, paramObject });
      return;
      if (paramObject.getClass() == Long.class) {
        bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong(paramString, ((Long)paramObject).longValue()).commit();
      } else if (paramObject.getClass() == String.class) {
        bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString, (String)paramObject).commit();
      } else if (paramObject.getClass() == Boolean.class) {
        bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(paramString, ((Boolean)paramObject).booleanValue()).commit();
      } else {
        throw new IllegalArgumentException("value class is not support : " + paramObject.getClass());
      }
    }
    SLog.b("ConfigManager", "set value success :  K:%s, V:%s .", paramString, paramObject);
  }
  
  public void b()
  {
    SLog.b("ConfigManager", "onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.ConfigManager
 * JD-Core Version:    0.7.0.1
 */