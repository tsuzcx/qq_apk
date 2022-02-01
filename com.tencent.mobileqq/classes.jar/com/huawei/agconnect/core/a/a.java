package com.huawei.agconnect.core.a;

import android.content.Context;
import com.huawei.agconnect.AGConnectInstance;

public class a
  extends AGConnectInstance
{
  private final Context a;
  private final c b;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new c(new b(paramContext).a());
  }
  
  public Context getContext()
  {
    return this.a;
  }
  
  public <T> T getService(Class<? super T> paramClass)
  {
    return this.b.a(this, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.core.a.a
 * JD-Core Version:    0.7.0.1
 */