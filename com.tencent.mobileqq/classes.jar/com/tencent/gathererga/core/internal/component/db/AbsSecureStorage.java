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
  private WeakHashMap<String, String> a;
  
  public AbsSecureStorage()
  {
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  private void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_JavaLangString = Md5Util.a(a());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mEncryptKey : ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
  
  private String b(String paramString)
  {
    if (paramString != null)
    {
      a();
      try
      {
        String str = SimpleCrypto.a(this.jdField_a_of_type_JavaLangString, paramString);
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
        a();
        String str = SimpleCrypto.b(this.jdField_a_of_type_JavaLangString, paramString);
        return str;
      }
      catch (Throwable localThrowable)
      {
        GLog.a(localThrowable);
      }
    }
    return paramString;
  }
  
  protected abstract SharedPreferences a();
  
  protected abstract String a();
  
  public final String a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilWeakHashMap;
    if ((localObject != null) && (((WeakHashMap)localObject).containsKey(paramString))) {
      return (String)this.jdField_a_of_type_JavaUtilWeakHashMap.get(paramString);
    }
    localObject = b(paramString);
    localObject = a().getString((String)localObject, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = c((String)localObject);
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramString, localObject);
    return localObject;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject = b(paramString1);
    String str = b(paramString2);
    a().edit().putString((String)localObject, str).commit();
    localObject = this.jdField_a_of_type_JavaUtilWeakHashMap;
    if (localObject == null) {
      return;
    }
    ((WeakHashMap)localObject).put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.component.db.AbsSecureStorage
 * JD-Core Version:    0.7.0.1
 */