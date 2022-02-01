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
  protected AtomicBoolean a = new AtomicBoolean(false);
  protected SharedPreferences b;
  
  private void a(@Nullable String paramString1, @Nullable Object paramObject, @Nullable String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" expected ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" but value was ");
    if (paramObject == null) {
      paramString1 = "null";
    } else {
      paramString1 = paramObject.getClass().getName();
    }
    localStringBuilder.append(paramString1);
    SLog.d("ConfigManager", localStringBuilder.toString());
  }
  
  private void c()
  {
    if (this.a.get()) {
      return;
    }
    throw new IllegalStateException("have not attachContext");
  }
  
  public <V> V a(@NonNull String paramString, @NonNull V paramV)
  {
    c();
    Object localObject;
    if (paramV.getClass() == Integer.class)
    {
      localObject = Integer.valueOf(this.b.getInt(paramString, ((Integer)paramV).intValue()));
    }
    else if (paramV.getClass() == Long.class)
    {
      localObject = Long.valueOf(this.b.getLong(paramString, ((Long)paramV).longValue()));
    }
    else if (paramV.getClass() == String.class)
    {
      localObject = this.b.getString(paramString, (String)paramV);
    }
    else
    {
      if (paramV.getClass() != Boolean.class) {
        break label168;
      }
      localObject = Boolean.valueOf(this.b.getBoolean(paramString, ((Boolean)paramV).booleanValue()));
    }
    SLog.b("ConfigManager", "get value : K : %s, V : %s", paramString, localObject);
    if ((localObject != null) && (localObject.getClass() == paramV.getClass())) {
      return localObject;
    }
    a(paramString, localObject, paramV.getClass().getName());
    return paramV;
    label168:
    paramString = new StringBuilder();
    paramString.append("defValue class is not support : ");
    paramString.append(paramV.getClass());
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public void a()
  {
    SLog.b("ConfigManager", "onInit");
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null)
    {
      if (this.a.compareAndSet(false, true))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("attachContext, ");
        localStringBuilder.append(paramContext);
        SLog.b("ConfigManager", localStringBuilder.toString());
        this.b = paramContext.getSharedPreferences("qqstory_config", 4);
        return;
      }
      SLog.d("ConfigManager", "attachContext duplicate");
      return;
    }
    throw new IllegalArgumentException("Context should not be null");
  }
  
  public void b()
  {
    SLog.b("ConfigManager", "onDestroy");
  }
  
  public <V> void b(String paramString, V paramV)
  {
    c();
    boolean bool;
    if (paramV.getClass() == Integer.class)
    {
      bool = this.b.edit().putInt(paramString, ((Integer)paramV).intValue()).commit();
    }
    else if (paramV.getClass() == Long.class)
    {
      bool = this.b.edit().putLong(paramString, ((Long)paramV).longValue()).commit();
    }
    else if (paramV.getClass() == String.class)
    {
      bool = this.b.edit().putString(paramString, (String)paramV).commit();
    }
    else
    {
      if (paramV.getClass() != Boolean.class) {
        break label192;
      }
      bool = this.b.edit().putBoolean(paramString, ((Boolean)paramV).booleanValue()).commit();
    }
    if (!bool)
    {
      SLog.e("ConfigManager", "set value error : K:%s, V:%s .", new Object[] { paramString, paramV });
      return;
    }
    SLog.b("ConfigManager", "set value success :  K:%s, V:%s .", paramString, paramV);
    return;
    label192:
    paramString = new StringBuilder();
    paramString.append("value class is not support : ");
    paramString.append(paramV.getClass());
    throw new IllegalArgumentException(paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.ConfigManager
 * JD-Core Version:    0.7.0.1
 */