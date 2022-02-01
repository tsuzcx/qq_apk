package com.huawei.agconnect.core.a;

import android.content.Context;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;

public class a
  extends AGConnectInstance
{
  private final Context a;
  private final g b;
  private d c;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new g(new f(paramContext).a());
    this.c = new d();
  }
  
  public void a(CustomAuthProvider paramCustomAuthProvider)
  {
    this.c.a(paramCustomAuthProvider);
  }
  
  public void a(CustomCredentialsProvider paramCustomCredentialsProvider)
  {
    this.c.a(paramCustomCredentialsProvider);
  }
  
  public Context getContext()
  {
    return this.a;
  }
  
  public <T> T getService(Class<? super T> paramClass)
  {
    if (this.c.a(paramClass)) {
      return this.c.b(paramClass);
    }
    return this.b.a(this, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.core.a.a
 * JD-Core Version:    0.7.0.1
 */