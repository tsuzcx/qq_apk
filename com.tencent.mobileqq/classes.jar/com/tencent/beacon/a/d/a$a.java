package com.tencent.beacon.a.d;

import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import java.util.Set;

public class a$a
  implements SharedPreferences.Editor
{
  private g a;
  
  a$a(g paramg)
  {
    this.a = paramg;
  }
  
  public void apply() {}
  
  public SharedPreferences.Editor clear()
  {
    this.a.a();
    return this;
  }
  
  public boolean commit()
  {
    return true;
  }
  
  public SharedPreferences.Editor putBoolean(@NonNull String paramString, boolean paramBoolean)
  {
    this.a.b(paramString, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public SharedPreferences.Editor putFloat(@NonNull String paramString, float paramFloat)
  {
    this.a.b(paramString, Float.valueOf(paramFloat));
    return this;
  }
  
  public SharedPreferences.Editor putInt(@NonNull String paramString, int paramInt)
  {
    this.a.b(paramString, Integer.valueOf(paramInt));
    return this;
  }
  
  public SharedPreferences.Editor putLong(@NonNull String paramString, long paramLong)
  {
    this.a.b(paramString, Long.valueOf(paramLong));
    return this;
  }
  
  public SharedPreferences.Editor putString(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.a.b(paramString1, paramString2);
    return this;
  }
  
  public SharedPreferences.Editor putStringSet(@NonNull String paramString, @NonNull Set<String> paramSet)
  {
    this.a.b(paramString, paramSet);
    return this;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    this.a.b(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */