package com.huawei.hms.update.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class a
{
  private String a;
  private int b;
  private String c;
  private int d;
  
  private void b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("com.huawei.hms.update.DOWNLOAD_RECORD" + paramString, 0).edit();
    paramContext.putString("mUri", this.a);
    paramContext.putInt("mSize", this.b);
    paramContext.putString("mHash", this.c);
    paramContext.putInt("mReceived", this.d);
    paramContext.commit();
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(Context paramContext, int paramInt, String paramString)
  {
    this.d = paramInt;
    b(paramContext, paramString);
  }
  
  public void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("com.huawei.hms.update.DOWNLOAD_RECORD" + paramString, 0);
    this.a = paramContext.getString("mUri", "");
    this.b = paramContext.getInt("mSize", 0);
    this.c = paramContext.getString("mHash", "");
    this.d = paramContext.getInt("mReceived", 0);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = 0;
  }
  
  int b()
  {
    return this.d;
  }
  
  public boolean b(String paramString1, int paramInt, String paramString2)
  {
    return (paramString1 != null) && (paramString2 != null) && (this.a != null) && (this.a.equals(paramString1)) && (this.b == paramInt) && (this.c != null) && (this.c.equals(paramString2)) && (this.d <= this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.a.a
 * JD-Core Version:    0.7.0.1
 */