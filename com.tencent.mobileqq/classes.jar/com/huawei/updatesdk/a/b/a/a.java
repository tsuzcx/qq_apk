package com.huawei.updatesdk.a.b.a;

import android.content.Context;
import android.net.ConnectivityManager;
import java.io.File;

public class a
{
  private static final Object a = new Object();
  private static a b = null;
  private Context c;
  private ConnectivityManager d = null;
  
  public a(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
  }
  
  public static a a()
  {
    synchronized (a)
    {
      a locala = b;
      return locala;
    }
  }
  
  public static void a(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null) {
        b = new a(paramContext);
      }
      return;
    }
  }
  
  public Context b()
  {
    return this.c;
  }
  
  public String c()
  {
    if ((this.c == null) || (this.c.getFilesDir() == null)) {
      return "";
    }
    return this.c.getFilesDir().getAbsolutePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */