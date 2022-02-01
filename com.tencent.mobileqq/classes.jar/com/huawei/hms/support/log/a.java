package com.huawei.hms.support.log;

import android.content.Context;
import android.util.Log;

public class a
{
  private static final b a = new com.huawei.hms.support.log.a.a();
  private int b = 4;
  private String c;
  
  private c b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    paramString1 = new c(8, this.c, paramInt, paramString1);
    paramString1.a(paramString2);
    paramString1.a(paramThrowable);
    return paramString1;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (a(paramInt))
    {
      Object localObject = b(paramInt, paramString1, paramString2, null);
      localObject = ((c)localObject).a() + ((c)localObject).b();
      a.a((String)localObject, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(paramInt))
    {
      Object localObject = b(paramInt, paramString1, paramString2, paramThrowable);
      localObject = ((c)localObject).a() + ((c)localObject).b();
      a.a((String)localObject, paramInt, paramString1, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
    }
  }
  
  public void a(Context paramContext, int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
    a.a(paramContext, "HMSCore");
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = b(4, paramString1, paramString2, null);
    localObject = ((c)localObject).a() + '\n' + ((c)localObject).b();
    a.a((String)localObject, 4, paramString1, paramString2);
  }
  
  public boolean a(int paramInt)
  {
    return paramInt >= this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.log.a
 * JD-Core Version:    0.7.0.1
 */