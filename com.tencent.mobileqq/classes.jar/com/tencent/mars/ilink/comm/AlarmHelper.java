package com.tencent.mars.ilink.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mars.ilink.xlog.Log;

public class AlarmHelper
{
  private static final String TAG = "MicroMsg.AlarmHelper";
  
  public static void cancel(Context paramContext, int paramInt, PendingIntent paramPendingIntent)
  {
    String str;
    if (paramPendingIntent != null) {
      str = paramPendingIntent.toString();
    } else {
      str = "null";
    }
    Log.d("MicroMsg.AlarmHelper", "cancel(requestCode:%s operation:%s)", new Object[] { Integer.valueOf(paramInt), str });
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    paramContext.cancel(paramPendingIntent);
  }
  
  public static void cancel(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    if (paramIntent != null) {
      localObject = paramIntent;
    } else {
      localObject = "null";
    }
    Log.d("MicroMsg.AlarmHelper", "cancel(requestCode:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt1), localObject, Integer.valueOf(paramInt2) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    ((AlarmManager)localObject).cancel(getPendingIntent(paramContext, paramInt1, paramIntent, paramInt2));
  }
  
  public static void cancel(Context paramContext, PendingIntent paramPendingIntent)
  {
    String str;
    if (paramPendingIntent != null) {
      str = paramPendingIntent.toString();
    } else {
      str = "null";
    }
    Log.d("MicroMsg.AlarmHelper", "cancel(operation:%s)", new Object[] { str });
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel: context == null");
      return;
    }
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel: am == null");
      return;
    }
    paramContext.cancel(paramPendingIntent);
  }
  
  public static PendingIntent getPendingIntent(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    Object localObject;
    if (paramIntent != null) {
      localObject = paramIntent;
    } else {
      localObject = "null";
    }
    Log.d("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt1), localObject, Integer.valueOf(paramInt2) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    return PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt2);
  }
  
  private static boolean isRequestCodeValid(int paramInt)
  {
    return (paramInt >= 100) && (paramInt <= 119);
  }
  
  public static PendingIntent set(Context paramContext, int paramInt1, int paramInt2, long paramLong, Intent paramIntent, int paramInt3)
  {
    if (paramIntent != null) {
      localObject = paramIntent;
    } else {
      localObject = "null";
    }
    Log.d("MicroMsg.AlarmHelper", "set(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject, Integer.valueOf(paramInt3) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    Object localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt3);
    ((AlarmManager)localObject).set(paramInt2, paramLong, paramContext);
    return paramContext;
  }
  
  public static PendingIntent setExact(Context paramContext, int paramInt1, int paramInt2, long paramLong, Intent paramIntent, int paramInt3)
  {
    if (paramIntent != null) {
      localObject = paramIntent;
    } else {
      localObject = "null";
    }
    Log.d("MicroMsg.AlarmHelper", "setExact(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject, Integer.valueOf(paramInt3) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    Object localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt3);
    ((AlarmManager)localObject).set(paramInt2, paramLong, paramContext);
    return paramContext;
  }
  
  public static PendingIntent setRepeating(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Intent paramIntent, int paramInt3)
  {
    if (paramIntent != null) {
      localObject = paramIntent;
    } else {
      localObject = "null";
    }
    Log.d("MicroMsg.AlarmHelper", "setRepeating(type:%s requestCode:%s triggerAtMillis:%s intervalMillis:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), localObject, Integer.valueOf(paramInt3) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    Object localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt3);
    ((AlarmManager)localObject).set(paramInt2, paramLong1, paramContext);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.AlarmHelper
 * JD-Core Version:    0.7.0.1
 */