package com.huawei.agconnect.core.a;

import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import java.util.HashMap;
import java.util.Map;

public class d
{
  private Map<Class<?>, Object> a = new HashMap();
  
  public void a(CustomAuthProvider paramCustomAuthProvider)
  {
    if (paramCustomAuthProvider == null)
    {
      this.a.remove(AuthProvider.class);
      return;
    }
    paramCustomAuthProvider = new c(this, paramCustomAuthProvider);
    this.a.put(AuthProvider.class, paramCustomAuthProvider);
  }
  
  public void a(CustomCredentialsProvider paramCustomCredentialsProvider)
  {
    if (paramCustomCredentialsProvider == null)
    {
      this.a.remove(CredentialsProvider.class);
      return;
    }
    paramCustomCredentialsProvider = new b(this, paramCustomCredentialsProvider);
    this.a.put(CredentialsProvider.class, paramCustomCredentialsProvider);
  }
  
  public boolean a(Class<?> paramClass)
  {
    return (this.a.containsKey(paramClass)) && (b(paramClass) != null);
  }
  
  public Object b(Class<?> paramClass)
  {
    return this.a.get(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.agconnect.core.a.d
 * JD-Core Version:    0.7.0.1
 */