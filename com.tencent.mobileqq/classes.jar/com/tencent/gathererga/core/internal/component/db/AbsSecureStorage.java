package com.tencent.gathererga.core.internal.component.db;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.gathererga.core.internal.util.GLog;
import com.tencent.gathererga.core.internal.util.Md5Util;
import com.tencent.gathererga.core.internal.util.SimpleCrypto;
import java.util.WeakHashMap;

public abstract class AbsSecureStorage
  implements Storage
{
  protected String a;
  private WeakHashMap<String, String> b = new WeakHashMap();
  
  private String b(String paramString)
  {
    if (paramString != null)
    {
      c();
      try
      {
        String str = SimpleCrypto.a(this.a, paramString);
        return str;
      }
      catch (Throwable localThrowable)
      {
        GLog.a(localThrowable);
      }
    }
    return paramString;
  }
  
  private String c(String paramString)
  {
    if (paramString != null) {
      try
      {
        c();
        String str = SimpleCrypto.b(this.a, paramString);
        return str;
      }
      catch (Throwable localThrowable)
      {
        GLog.a(localThrowable);
      }
    }
    return paramString;
  }
  
  private void c()
  {
    try
    {
      if (this.a == null)
      {
        this.a = Md5Util.a(b());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mEncryptKey : ");
        localStringBuilder.append(this.a);
        GLog.b(localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected abstract SharedPreferences a();
  
  public final String a(String paramString)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((WeakHashMap)localObject).containsKey(paramString))) {
      return (String)this.b.get(paramString);
    }
    localObject = b(paramString);
    localObject = a().getString((String)localObject, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = c((String)localObject);
    this.b.put(paramString, localObject);
    return localObject;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject = b(paramString1);
    String str = b(paramString2);
    a().edit().putString((String)localObject, str).commit();
    localObject = this.b;
    if (localObject == null) {
      return;
    }
    ((WeakHashMap)localObject).put(paramString1, paramString2);
  }
  
  protected abstract String b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.component.db.AbsSecureStorage
 * JD-Core Version:    0.7.0.1
 */