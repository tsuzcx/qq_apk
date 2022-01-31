package com.tencent.beacon.a.g;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
{
  private static b b = null;
  private boolean a = false;
  
  protected b()
  {
    String str = Build.TAGS;
    if ((str != null) && (str.contains("test-keys"))) {}
    for (;;)
    {
      if ((i == 0) && (!c()) && (!d())) {
        this.a = false;
      }
      return;
      i = 0;
    }
  }
  
  public static b a()
  {
    try
    {
      if (b == null) {
        b = new b();
      }
      b localb = b;
      return localb;
    }
    finally {}
  }
  
  private static boolean c()
  {
    try
    {
      boolean bool = new File("/system/app/Superuser.apk").exists();
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean d()
  {
    Object localObject = e();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((String)((Iterator)localObject).next()).contains("not found")) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private static ArrayList<String> e()
  {
    ArrayList localArrayList = new ArrayList();
    String str;
    Object localObject;
    try
    {
      Process localProcess = Runtime.getRuntime().exec(new String[] { "/system/bin/sh", "-c", "type su" });
      localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      for (;;)
      {
        str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localArrayList.add(str);
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      a.a(localThrowable);
      localObject = null;
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(((Process)localObject).getErrorStream()));
    for (;;)
    {
      str = localBufferedReader.readLine();
      localObject = localArrayList;
      if (str == null) {
        break;
      }
      localArrayList.add(str);
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.g.b
 * JD-Core Version:    0.7.0.1
 */