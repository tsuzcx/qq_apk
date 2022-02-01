package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.c;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class a
{
  public static InetAddress[] a()
  {
    try
    {
      Object localObject1 = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
      ArrayList localArrayList = new ArrayList(5);
      for (;;)
      {
        String str = ((LineNumberReader)localObject1).readLine();
        if (str == null) {
          break;
        }
        int i = str.indexOf("]: [");
        if (i != -1)
        {
          Object localObject2 = str.substring(1, i);
          str = str.substring(i + 4, str.length() - 1);
          if ((((String)localObject2).endsWith(".dns")) || (((String)localObject2).endsWith(".dns1")) || (((String)localObject2).endsWith(".dns2")) || (((String)localObject2).endsWith(".dns3")) || (((String)localObject2).endsWith(".dns4")))
          {
            localObject2 = InetAddress.getByName(str);
            if (localObject2 != null)
            {
              str = ((InetAddress)localObject2).getHostAddress();
              if ((str != null) && (str.length() != 0)) {
                localArrayList.add(localObject2);
              }
            }
          }
        }
      }
      if (localArrayList.size() > 0)
      {
        localObject1 = (InetAddress[])localArrayList.toArray(new InetAddress[localArrayList.size()]);
        return localObject1;
      }
    }
    catch (IOException localIOException)
    {
      Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", localIOException);
    }
    return null;
  }
  
  public static InetAddress[] b()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
        ArrayList localArrayList = new ArrayList(5);
        String[] arrayOfString = new String[4];
        arrayOfString[0] = "net.dns1";
        arrayOfString[1] = "net.dns2";
        arrayOfString[2] = "net.dns3";
        arrayOfString[3] = "net.dns4";
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          Object localObject2 = (String)((Method)localObject1).invoke(null, new Object[] { arrayOfString[i] });
          if ((localObject2 == null) || (((String)localObject2).length() == 0)) {
            break label214;
          }
          localObject2 = InetAddress.getByName((String)localObject2);
          if (localObject2 == null) {
            break label214;
          }
          String str = ((InetAddress)localObject2).getHostAddress();
          if ((str == null) || (str.length() == 0) || (localArrayList.contains(localObject2))) {
            break label214;
          }
          localArrayList.add(localObject2);
          break label214;
        }
        if (localArrayList.size() > 0)
        {
          localObject1 = (InetAddress[])localArrayList.toArray(new InetAddress[localArrayList.size()]);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", localException);
      }
      return null;
      label214:
      i += 1;
    }
  }
  
  public static c c()
  {
    return new a.1();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.a.a.a
 * JD-Core Version:    0.7.0.1
 */