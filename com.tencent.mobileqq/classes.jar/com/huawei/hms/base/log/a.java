package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

public class a
{
  public static final b c = new d();
  public int a = 4;
  public String b;
  
  public final c a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    paramString1 = new c(8, this.b, paramInt, paramString1);
    paramString1.a(paramString2);
    paramString1.a(paramThrowable);
    return paramString1;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (a(paramInt))
    {
      Object localObject = a(paramInt, paramString1, paramString2, null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((c)localObject).c());
      localStringBuilder.append(((c)localObject).a());
      localObject = localStringBuilder.toString();
      c.a((String)localObject, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(Context paramContext, int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
    c.a(paramContext, "HMSCore");
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = a(4, paramString1, paramString2, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((c)localObject).c());
    localStringBuilder.append('\n');
    localStringBuilder.append(((c)localObject).a());
    localObject = localStringBuilder.toString();
    c.a((String)localObject, 4, paramString1, paramString2);
  }
  
  public boolean a(int paramInt)
  {
    return paramInt >= this.a;
  }
  
  public void b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(paramInt))
    {
      Object localObject1 = a(paramInt, paramString1, paramString2, paramThrowable);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((c)localObject1).c());
      ((StringBuilder)localObject2).append(((c)localObject1).a());
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append('\n');
      localStringBuilder.append(Log.getStackTraceString(paramThrowable));
      ((b)localObject2).a((String)localObject1, paramInt, paramString1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.base.log.a
 * JD-Core Version:    0.7.0.1
 */