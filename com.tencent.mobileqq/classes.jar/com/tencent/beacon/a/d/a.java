package com.tencent.beacon.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.beacon.a.b.d;
import com.tencent.beacon.a.c.b;
import com.tencent.beacon.base.util.e;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class a
  implements SharedPreferences
{
  private static volatile a a;
  private boolean b;
  private g c;
  private a.a d;
  private SharedPreferences e;
  
  public static a a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a();
        }
      }
      finally {}
    }
    return a;
  }
  
  private <T> Object a(@NonNull String paramString, T paramT)
  {
    if (!this.b) {
      return paramT;
    }
    Object localObject1 = this.c.a(paramString, paramT);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1 != paramT) {}
    }
    else
    {
      localObject2 = com.tencent.beacon.a.c.c.d().c();
      if (this.e == null) {
        this.e = ((Context)localObject2).getSharedPreferences("DENGTA_META", 0);
      }
      if ((paramT instanceof Boolean)) {
        localObject1 = Boolean.valueOf(this.e.getBoolean(paramString, ((Boolean)paramT).booleanValue()));
      } else if ((paramT instanceof String)) {
        localObject1 = this.e.getString(paramString, (String)paramT);
      } else if ((paramT instanceof Integer)) {
        localObject1 = Integer.valueOf(this.e.getInt(paramString, ((Integer)paramT).intValue()));
      } else if ((paramT instanceof Long)) {
        localObject1 = Long.valueOf(this.e.getLong(paramString, ((Long)paramT).longValue()));
      } else if ((paramT instanceof Float)) {
        localObject1 = Float.valueOf(this.e.getFloat(paramString, ((Float)paramT).floatValue()));
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1 != paramT)
        {
          this.c.b(paramString, localObject1);
          localObject2 = localObject1;
        }
      }
    }
    if (localObject2 == null) {
      return paramT;
    }
    return localObject2;
  }
  
  public void a(Context paramContext)
  {
    try
    {
      boolean bool = this.b;
      if ((!bool) && (paramContext != null))
      {
        try
        {
          String str = b.c(paramContext);
          Object localObject = paramContext.getPackageName();
          str = str.replace((CharSequence)localObject, "");
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("prop_");
          ((StringBuilder)localObject).append(str);
          this.c = g.a(paramContext, ((StringBuilder)localObject).toString());
          this.d = new a.a(this.c);
          this.b = true;
        }
        catch (IOException paramContext)
        {
          com.tencent.beacon.base.util.c.a(paramContext);
          d.b().a("504", "[properties] PropertiesFile create error!", paramContext);
          this.b = false;
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public boolean contains(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public a.a edit()
  {
    if (!this.b)
    {
      e.a("BeaconProperties has not init!");
      a(com.tencent.beacon.a.c.c.d().c());
    }
    return this.d;
  }
  
  public Map<String, ?> getAll()
  {
    return this.c.b();
  }
  
  public boolean getBoolean(@NonNull String paramString, boolean paramBoolean)
  {
    paramString = a(paramString, Boolean.valueOf(paramBoolean));
    if ((paramString instanceof Boolean)) {
      paramBoolean = ((Boolean)paramString).booleanValue();
    }
    return paramBoolean;
  }
  
  public float getFloat(@NonNull String paramString, float paramFloat)
  {
    paramString = a(paramString, Float.valueOf(paramFloat));
    if ((paramString instanceof Number)) {
      paramFloat = ((Number)paramString).floatValue();
    }
    return paramFloat;
  }
  
  public int getInt(@NonNull String paramString, int paramInt)
  {
    paramString = a(paramString, Integer.valueOf(paramInt));
    if ((paramString instanceof Number)) {
      paramInt = ((Number)paramString).intValue();
    }
    return paramInt;
  }
  
  public long getLong(@NonNull String paramString, long paramLong)
  {
    paramString = a(paramString, Long.valueOf(paramLong));
    if ((paramString instanceof Number)) {
      paramLong = ((Number)paramString).longValue();
    }
    return paramLong;
  }
  
  public String getString(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    if ((paramString1 instanceof String)) {
      paramString2 = (String)paramString1;
    }
    return paramString2;
  }
  
  public Set<String> getStringSet(@NonNull String paramString, @Nullable Set<String> paramSet)
  {
    if (!this.b) {
      return paramSet;
    }
    return this.c.a(paramString, paramSet);
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.d.a
 * JD-Core Version:    0.7.0.1
 */