package com.tencent.luggage.wxa.fv;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import androidx.annotation.RecentlyNullable;
import com.tencent.luggage.wxa.qz.w;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/tdi/IlinkOpenIdentityStore;", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences$Editor;", "()V", "KEY_CURRENT_HOST_APPID", "", "KEY_HOST_ABI", "KEY_ILINK_UIN", "value", "currentHostAppID", "getCurrentHostAppID", "()Ljava/lang/String;", "setCurrentHostAppID", "(Ljava/lang/String;)V", "", "hostAbi", "getHostAbi", "()I", "setHostAbi", "(I)V", "apply", "", "clear", "kotlin.jvm.PlatformType", "commit", "", "contains", "p0", "edit", "get", "hostAppID", "getAll", "", "", "getBoolean", "p1", "getFloat", "", "getILinkUIN", "", "getInt", "getLong", "getString", "getStringSet", "", "", "putBoolean", "putFloat", "putInt", "putLong", "putString", "putStringSet", "registerOnSharedPreferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "remove", "set", "ilinkAppID", "setILinkUIN", "uin", "unregisterOnSharedPreferenceChangeListener", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class e
  implements SharedPreferences, SharedPreferences.Editor
{
  public static final e a = new e();
  @Nullable
  private static String b;
  private static int c;
  
  private e()
  {
    w localw = w.a("IlinkOpenIdentityStore.bin");
    Intrinsics.checkExpressionValueIsNotNull(localw, "MultiProcessMMKV.getMMKV…nkOpenIdentityStore.bin\")");
    this.d = localw;
    localw = w.a("IlinkOpenIdentityStore.bin");
    Intrinsics.checkExpressionValueIsNotNull(localw, "MultiProcessMMKV.getMMKV…nkOpenIdentityStore.bin\")");
    this.e = localw;
  }
  
  public final long a()
  {
    return getLong("__KEY_ILINK_UIN__", 0L);
  }
  
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostAppID");
    return getString(paramString, null);
  }
  
  public final void a(int paramInt)
  {
    c = paramInt;
    putInt("__KEY_HOST_ABI__", paramInt);
  }
  
  public final void a(long paramLong)
  {
    putLong("__KEY_ILINK_UIN__", paramLong);
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "hostAppID");
    Intrinsics.checkParameterIsNotNull(paramString2, "ilinkAppID");
    putString(paramString1, paramString2);
  }
  
  public void apply()
  {
    this.e.apply();
  }
  
  @Nullable
  public final String b()
  {
    b = getString("__KEY_CURRENT_HOST_APPID__", null);
    return b;
  }
  
  public final void b(@Nullable String paramString)
  {
    b = paramString;
    putString("__KEY_CURRENT_HOST_APPID__", paramString);
  }
  
  public final int c()
  {
    c = getInt("__KEY_HOST_ABI__", 0);
    return c;
  }
  
  public SharedPreferences.Editor clear()
  {
    return this.e.clear();
  }
  
  public boolean commit()
  {
    return this.e.commit();
  }
  
  public boolean contains(String paramString)
  {
    return this.d.contains(paramString);
  }
  
  public SharedPreferences.Editor edit()
  {
    return this.d.edit();
  }
  
  public Map<String, ?> getAll()
  {
    return this.d.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.d.getBoolean(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return this.d.getFloat(paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.d.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.d.getLong(paramString, paramLong);
  }
  
  @RecentlyNullable
  public String getString(String paramString1, @RecentlyNullable String paramString2)
  {
    return this.d.getString(paramString1, paramString2);
  }
  
  @RecentlyNullable
  public Set<String> getStringSet(String paramString, @RecentlyNullable Set<String> paramSet)
  {
    return this.d.getStringSet(paramString, paramSet);
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    return this.e.putBoolean(paramString, paramBoolean);
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    return this.e.putFloat(paramString, paramFloat);
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    return this.e.putInt(paramString, paramInt);
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    return this.e.putLong(paramString, paramLong);
  }
  
  public SharedPreferences.Editor putString(String paramString1, @RecentlyNullable String paramString2)
  {
    return this.e.putString(paramString1, paramString2);
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, @RecentlyNullable Set<String> paramSet)
  {
    return this.e.putStringSet(paramString, paramSet);
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.d.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    return this.e.remove(paramString);
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.d.unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.e
 * JD-Core Version:    0.7.0.1
 */