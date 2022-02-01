package com.tencent.beacon.base.util;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

public class d
{
  private static boolean a;
  
  public static boolean a()
  {
    Object localObject = e();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        c.a(str, new Object[0]);
        if (str.contains("not found")) {
          return false;
        }
      }
      c.a("[core] sufile}", new Object[0]);
      return true;
    }
    c.a("[core] no response}", new Object[0]);
    return false;
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = new File("/system/app/Superuser.apk").exists();
      if (bool)
      {
        c.a("[core] super_apk", new Object[0]);
        return true;
      }
    }
    catch (Exception localException)
    {
      c.a(localException);
    }
    return false;
  }
  
  public static boolean c()
  {
    String str = Build.TAGS;
    if ((str != null) && (str.contains("test-keys")))
    {
      c.a("[core] test-keys", new Object[0]);
      return true;
    }
    return false;
  }
  
  public static boolean d()
  {
    boolean bool1 = a;
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    bool1 = bool2;
    if (!c())
    {
      bool1 = bool2;
      if (!b()) {
        if (a()) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    a = bool1;
    return bool1;
  }
  
  private static ArrayList<String> e()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = Runtime.getRuntime();
      localObject1 = ((Runtime)localObject1).exec(new String[] { "/system/bin/sh", "-c", "type su" });
      Object localObject2 = new BufferedReader(new InputStreamReader(((Process)localObject1).getInputStream(), Charset.forName("UTF-8")));
      for (;;)
      {
        String str = ((BufferedReader)localObject2).readLine();
        if (str == null) {
          break;
        }
        localArrayList.add(str);
      }
      localObject1 = new BufferedReader(new InputStreamReader(((Process)localObject1).getErrorStream(), Charset.forName("UTF-8")));
      for (;;)
      {
        localObject2 = ((BufferedReader)localObject1).readLine();
        if (localObject2 == null) {
          break;
        }
        localArrayList.add(localObject2);
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.util.d
 * JD-Core Version:    0.7.0.1
 */