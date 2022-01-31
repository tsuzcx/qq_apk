package com.tencent.beacon.core;

import android.content.Context;
import com.tencent.beacon.core.d.b;
import java.io.File;

public class BeaconIdJNI
{
  public static String a(Context paramContext, int paramInt)
  {
    int j = 0;
    if (paramInt < 23) {}
    for (;;)
    {
      String[] arrayOfString;
      try
      {
        b.d("[beaconId] API < 23 can not get beaconId", new Object[0]);
        paramContext = "";
        return paramContext;
      }
      finally {}
      try
      {
        a(paramContext);
        arrayOfString = c();
        paramContext = arrayOfString;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        try
        {
          a(paramContext);
          paramContext = c();
        }
        catch (Throwable paramContext)
        {
          b.d("[beaconId] libBeacon.so load failed!", new Object[0]);
          paramContext = null;
        }
        continue;
      }
      catch (Throwable paramContext)
      {
        b.d("[beaconId] libBeacon.so load failed!", new Object[0]);
        paramContext = null;
        continue;
      }
      if (paramContext != null) {
        break label321;
      }
      paramContext = "";
    }
    for (;;)
    {
      int i = j;
      if (paramInt < paramContext.length)
      {
        if (paramContext[paramInt] == null) {
          paramContext[paramInt] = "";
        }
      }
      else
      {
        while (i < paramContext.length)
        {
          paramContext[i] = paramContext[i].trim().replace(" ", "").replace("\t", "").replace("&", "").replace(":", "").replace("=", "").replace(";", "");
          i += 1;
        }
        paramContext = new StringBuilder("k1:").append(paramContext[0]).append(";k2:").append(paramContext[1]).append(";k3:").append(paramContext[2]).append(";k4:").append(paramContext[3]).append(";k5:").append(paramContext[4]).append(";k6:").append(paramContext[5]).append(";k7:").append(paramContext[6]).append(";k8:").append(paramContext[7]).append(";k9:").append(paramContext[8]).append(";k10:1");
        b.b("[BeaconId] %s", new Object[] { paramContext.toString() });
        paramContext = paramContext.toString();
        break;
        label321:
        paramInt = 0;
        continue;
      }
      paramInt += 1;
    }
  }
  
  private static void a(Context paramContext)
  {
    String str = paramContext.getFilesDir().getAbsolutePath() + File.separator + "beacon/comp/libQimei.so";
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "beacon/comp/libBeacon.so";
    if (new File(str).exists())
    {
      System.load(str);
      return;
    }
    if (new File(paramContext).exists())
    {
      System.load(paramContext);
      return;
    }
    try
    {
      System.loadLibrary("Qimei");
      return;
    }
    catch (Throwable paramContext)
    {
      b.d("[beaconId] no libQimei.so!", new Object[0]);
      System.loadLibrary("Beacon");
    }
  }
  
  public static native String[] c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.BeaconIdJNI
 * JD-Core Version:    0.7.0.1
 */