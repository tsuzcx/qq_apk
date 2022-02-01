package com.tencent.luggage.wxa.qz;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.util.ArrayMap;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.qr.a;
import com.tencent.mmkv.MMKV;
import java.util.Map;
import java.util.Set;

public class w
  implements SharedPreferences, SharedPreferences.Editor
{
  private static ArrayMap<String, w> c;
  private MMKV a;
  private String b;
  
  static
  {
    f.a("mmkv", MMKV.class.getClassLoader());
    MMKV.a(r.a());
    c = new ArrayMap();
    MMKV.a(new w.1());
  }
  
  private w(String paramString, MMKV paramMMKV)
  {
    this.a = paramMMKV;
    this.b = paramString;
  }
  
  public static w a()
  {
    return a("MULTIPROCESSMMKV_SINGLE_DEFAULT", 1, MMKV.a());
  }
  
  public static w a(String paramString)
  {
    return a(paramString, 2, null);
  }
  
  public static w a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, null);
  }
  
  private static w a(String paramString, int paramInt, MMKV paramMMKV)
  {
    return b(paramString, paramInt, paramMMKV);
  }
  
  public static w a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt, MMKV.a(paramString1, paramInt, paramString2));
  }
  
  public static w a(String paramString1, String paramString2)
  {
    return b(paramString1, 2, paramString2);
  }
  
  private static void a(long paramLong, String paramString)
  {
    if (paramLong <= 5242880L) {
      a.a.a(941L, 10L, 1L, true);
    } else if (paramLong <= 10485760L) {
      a.a.a(941L, 11L, 1L, true);
    } else if (paramLong <= 104857600L) {
      a.a.a(941L, 12L, 1L, true);
    } else {
      a.a.a(941L, 13L, 1L, true);
    }
    a.a.a(18378, new Object[] { paramString, Long.valueOf(paramLong) });
  }
  
  private boolean a(String paramString, Object paramObject)
  {
    return (!af.c(paramString)) && (paramObject != null) && (!af.c(g()));
  }
  
  public static w b()
  {
    return a("MULTIPROCESSMMKV_SINGLE_DEFAULT", 1, MMKV.a(2, null));
  }
  
  public static w b(String paramString)
  {
    return a(paramString, 1, null);
  }
  
  private static w b(String paramString, int paramInt, MMKV paramMMKV)
  {
    try
    {
      w localw = (w)c.get(paramString);
      if (localw == null)
      {
        if (paramMMKV == null) {
          paramMMKV = new w(paramString, MMKV.a(paramString, paramInt));
        } else {
          paramMMKV = new w(paramString, paramMMKV);
        }
        long l = paramMMKV.c();
        if (l > 1048576L)
        {
          o.b("MicroMsg.MultiProcessMMKV", "MMKV file is too big, name : %s, size : %d, please contact with leafjia", new Object[] { paramString, Long.valueOf(l) });
          a(l, paramString);
          if (l > 5242880L)
          {
            a.a.a(941L, 100L, 1L, true);
            o.d("MicroMsg.MultiProcessMMKV", "start to trim, before size : %d", new Object[] { Long.valueOf(l) });
            paramMMKV.e();
            o.d("MicroMsg.MultiProcessMMKV", "trim is over, after size : %d", new Object[] { Long.valueOf(paramMMKV.c()) });
          }
        }
        c.put(paramString, paramMMKV);
        return paramMMKV;
      }
      return localw;
    }
    finally {}
  }
  
  private static w b(String paramString1, int paramInt, String paramString2)
  {
    return new w(paramString1, MMKV.a(paramString1, paramInt, paramString2));
  }
  
  private String g()
  {
    return this.b;
  }
  
  private static void h()
  {
    f.a("mmkv", MMKV.class.getClassLoader());
  }
  
  public long a(String paramString, long paramLong)
  {
    return this.a.b(paramString, paramLong);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (!a(paramString, Boolean.valueOf(paramBoolean))) {
      return false;
    }
    try
    {
      boolean bool = this.a.a(paramString, paramBoolean);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label26:
      break label26;
    }
    h();
    return this.a.a(paramString, paramBoolean);
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte)
  {
    if (!a(paramString, paramArrayOfByte)) {
      return false;
    }
    return this.a.a(paramString, paramArrayOfByte);
  }
  
  public void apply() {}
  
  public boolean b(String paramString1, String paramString2)
  {
    if (!a(paramString1, paramString2)) {
      return false;
    }
    return this.a.a(paramString1, paramString2);
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    return this.a.b(paramString, paramBoolean);
  }
  
  public long c()
  {
    return this.a.d();
  }
  
  public String c(String paramString)
  {
    try
    {
      String str = this.a.a(paramString);
      return str;
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    h();
    return this.a.a(paramString);
  }
  
  public String c(String paramString1, String paramString2)
  {
    return this.a.b(paramString1, paramString2);
  }
  
  public SharedPreferences.Editor clear()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.a.clear();
      return localEditor;
    }
    catch (Throwable localThrowable)
    {
      label10:
      break label10;
    }
    h();
    return this.a.clear();
  }
  
  public boolean commit()
  {
    return true;
  }
  
  public boolean contains(String paramString)
  {
    try
    {
      boolean bool = this.a.contains(paramString);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    h();
    return this.a.contains(paramString);
  }
  
  public void d()
  {
    try
    {
      this.a.clearAll();
      return;
    }
    catch (Throwable localThrowable)
    {
      label8:
      break label8;
    }
    h();
    this.a.clearAll();
  }
  
  public byte[] d(String paramString)
  {
    return this.a.b(paramString);
  }
  
  public void e()
  {
    this.a.trim();
  }
  
  public boolean e(String paramString)
  {
    return this.a.c(paramString);
  }
  
  public SharedPreferences.Editor edit()
  {
    return this;
  }
  
  public void f(String paramString)
  {
    this.a.d(paramString);
  }
  
  public String[] f()
  {
    try
    {
      String[] arrayOfString = this.a.allKeys();
      return arrayOfString;
    }
    catch (Throwable localThrowable)
    {
      label10:
      break label10;
    }
    h();
    return this.a.allKeys();
  }
  
  public Map<String, ?> getAll()
  {
    return this.a.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = this.a.getBoolean(paramString, paramBoolean);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label12:
      break label12;
    }
    h();
    return this.a.getBoolean(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    try
    {
      float f = this.a.getFloat(paramString, paramFloat);
      return f;
    }
    catch (Throwable localThrowable)
    {
      label12:
      break label12;
    }
    h();
    return this.a.getFloat(paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    try
    {
      int i = this.a.getInt(paramString, paramInt);
      return i;
    }
    catch (Throwable localThrowable)
    {
      label12:
      break label12;
    }
    h();
    return this.a.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    try
    {
      long l = this.a.getLong(paramString, paramLong);
      return l;
    }
    catch (Throwable localThrowable)
    {
      label14:
      break label14;
    }
    h();
    return this.a.getLong(paramString, paramLong);
  }
  
  @Nullable
  public String getString(String paramString1, @Nullable String paramString2)
  {
    try
    {
      String str = this.a.getString(paramString1, paramString2);
      return str;
    }
    catch (Throwable localThrowable)
    {
      label12:
      break label12;
    }
    h();
    return this.a.getString(paramString1, paramString2);
  }
  
  @Nullable
  public Set<String> getStringSet(String paramString, @Nullable Set<String> paramSet)
  {
    try
    {
      Set localSet = this.a.getStringSet(paramString, paramSet);
      return localSet;
    }
    catch (Throwable localThrowable)
    {
      label12:
      break label12;
    }
    h();
    return this.a.getStringSet(paramString, paramSet);
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    if (!a(paramString, Boolean.valueOf(paramBoolean))) {
      return edit();
    }
    try
    {
      SharedPreferences.Editor localEditor = this.a.putBoolean(paramString, paramBoolean);
      return localEditor;
    }
    catch (Throwable localThrowable)
    {
      label29:
      break label29;
    }
    h();
    return this.a.putBoolean(paramString, paramBoolean);
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    if (!a(paramString, Float.valueOf(paramFloat))) {
      return edit();
    }
    try
    {
      SharedPreferences.Editor localEditor = this.a.putFloat(paramString, paramFloat);
      return localEditor;
    }
    catch (Throwable localThrowable)
    {
      label29:
      break label29;
    }
    h();
    return this.a.putFloat(paramString, paramFloat);
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    if (!a(paramString, Integer.valueOf(paramInt))) {
      return edit();
    }
    try
    {
      SharedPreferences.Editor localEditor = this.a.putInt(paramString, paramInt);
      return localEditor;
    }
    catch (Throwable localThrowable)
    {
      label29:
      break label29;
    }
    h();
    return this.a.putInt(paramString, paramInt);
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    if (!a(paramString, Long.valueOf(paramLong))) {
      return edit();
    }
    try
    {
      SharedPreferences.Editor localEditor = this.a.putLong(paramString, paramLong);
      return localEditor;
    }
    catch (Throwable localThrowable)
    {
      label31:
      break label31;
    }
    h();
    return this.a.putLong(paramString, paramLong);
  }
  
  public SharedPreferences.Editor putString(String paramString1, @Nullable String paramString2)
  {
    if (!a(paramString1, paramString2)) {
      return edit();
    }
    try
    {
      SharedPreferences.Editor localEditor = this.a.putString(paramString1, paramString2);
      return localEditor;
    }
    catch (Throwable localThrowable)
    {
      label26:
      break label26;
    }
    h();
    return this.a.putString(paramString1, paramString2);
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, @Nullable Set<String> paramSet)
  {
    if (!a(paramString, paramSet)) {
      return edit();
    }
    try
    {
      SharedPreferences.Editor localEditor = this.a.putStringSet(paramString, paramSet);
      return localEditor;
    }
    catch (Throwable localThrowable)
    {
      label26:
      break label26;
    }
    h();
    return this.a.putStringSet(paramString, paramSet);
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public SharedPreferences.Editor remove(String paramString)
  {
    try
    {
      localEditor = this.a.remove(paramString);
    }
    catch (Throwable localThrowable)
    {
      SharedPreferences.Editor localEditor;
      label12:
      break label12;
    }
    h();
    localEditor = this.a.remove(paramString);
    return localEditor.remove(paramString);
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.w
 * JD-Core Version:    0.7.0.1
 */