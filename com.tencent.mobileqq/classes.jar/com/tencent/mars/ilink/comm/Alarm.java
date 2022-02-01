package com.tencent.mars.ilink.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mars.ilink.xlog.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class Alarm
  extends BroadcastReceiver
{
  private static final String KEXTRA_ID = "ID";
  private static final String KEXTRA_PID = "PID";
  private static final String TAG = "MicroMsg.Alarm";
  private static Alarm bc_alarm;
  private static TreeMap<Long, Alarm.AlarmRecord> gPendingAlarms = new TreeMap();
  private static WakerLock wakerlock;
  
  private static boolean cancelAlarmMgr(long paramLong, Context paramContext, PendingIntent paramPendingIntent)
  {
    if ((AlarmManager)paramContext.getSystemService("alarm") == null)
    {
      Log.e("MicroMsg.Alarm", "am == null");
      return false;
    }
    if (paramPendingIntent == null)
    {
      Log.e("MicroMsg.Alarm", "pendingIntent == null");
      return false;
    }
    AlarmHelper.cancel(paramContext, (int)paramLong, paramPendingIntent);
    return true;
  }
  
  private native void onAlarm(long paramLong);
  
  public static void resetAlarm(Context paramContext)
  {
    synchronized (gPendingAlarms)
    {
      Iterator localIterator = gPendingAlarms.values().iterator();
      while (localIterator.hasNext())
      {
        Alarm.AlarmRecord localAlarmRecord = (Alarm.AlarmRecord)localIterator.next();
        cancelAlarmMgr(localAlarmRecord.id, paramContext, localAlarmRecord.pendingIntent);
      }
      gPendingAlarms.clear();
      if (bc_alarm != null)
      {
        paramContext.unregisterReceiver(bc_alarm);
        bc_alarm = null;
      }
      return;
    }
    for (;;)
    {
      throw paramContext;
    }
  }
  
  private static PendingIntent setAlarmMgr(int paramInt, long paramLong1, long paramLong2, Context paramContext)
  {
    if ((AlarmManager)paramContext.getSystemService("alarm") == null)
    {
      Log.e("MicroMsg.Alarm", "am == null");
      return null;
    }
    Intent localIntent = new Intent();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ALARM_ACTION(");
    localStringBuilder.append(String.valueOf(Process.myPid()));
    localStringBuilder.append(")");
    localIntent.setAction(localStringBuilder.toString());
    localIntent.putExtra("ID", paramLong1);
    localIntent.putExtra("PID", Process.myPid());
    if (Build.VERSION.SDK_INT >= 19) {
      return AlarmHelper.setExact(paramContext, paramInt, 2, paramLong2, localIntent, 268435456);
    }
    return AlarmHelper.set(paramContext, paramInt, 2, paramLong2, localIntent, 268435456);
  }
  
  public static boolean start(int paramInt1, long paramLong, int paramInt2, Context paramContext)
  {
    long l2 = SystemClock.elapsedRealtime();
    if (paramInt2 < 0)
    {
      Log.e("MicroMsg.Alarm", "id:%d, after:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return false;
    }
    if (paramContext == null)
    {
      Log.e("MicroMsg.Alarm", "null==context, id:%d, after:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return false;
    }
    for (;;)
    {
      synchronized (gPendingAlarms)
      {
        if (wakerlock == null)
        {
          wakerlock = new WakerLock(paramContext);
          Log.i("MicroMsg.Alarm", "start new wakerlock");
        }
        if (bc_alarm == null)
        {
          bc_alarm = new Alarm();
          Alarm localAlarm = bc_alarm;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ALARM_ACTION(");
          localStringBuilder.append(String.valueOf(Process.myPid()));
          localStringBuilder.append(")");
          paramContext.registerReceiver(localAlarm, new IntentFilter(localStringBuilder.toString()));
        }
        if (gPendingAlarms.containsKey(Long.valueOf(paramLong)))
        {
          Log.e("MicroMsg.Alarm", "id exist=%d", new Object[] { Long.valueOf(paramLong) });
          return false;
          Object localObject;
          paramContext = setAlarmMgr(paramInt1, paramLong, localObject, paramContext);
          if (paramContext == null) {
            return false;
          }
          gPendingAlarms.put(Long.valueOf(paramLong), new Alarm.AlarmRecord(paramLong, localObject, paramContext));
          Log.i("MicroMsg.Alarm", "Alarm.start [id: %d, after: %d, size: %d]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(gPendingAlarms.size()) });
          return true;
        }
      }
      long l1 = l2;
      if (paramInt2 >= 0) {
        l1 = l2 + paramInt2;
      }
    }
  }
  
  public static boolean stop(long paramLong, Context paramContext)
  {
    Log.i("MicroMsg.Alarm", "Alarm.stop [id: %d]", new Object[] { Long.valueOf(paramLong) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.Alarm", "context==null");
      return false;
    }
    synchronized (gPendingAlarms)
    {
      if (wakerlock == null)
      {
        wakerlock = new WakerLock(paramContext);
        Log.i("MicroMsg.Alarm", "stop new wakerlock");
      }
      if (bc_alarm == null)
      {
        bc_alarm = new Alarm();
        localObject = new IntentFilter();
        paramContext.registerReceiver(bc_alarm, (IntentFilter)localObject);
        Log.i("MicroMsg.Alarm", "stop new Alarm");
      }
      Object localObject = (Alarm.AlarmRecord)gPendingAlarms.remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        cancelAlarmMgr(((Alarm.AlarmRecord)localObject).id, paramContext, ((Alarm.AlarmRecord)localObject).pendingIntent);
        return true;
      }
      return false;
    }
  }
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (??? != null)
    {
      if (paramIntent == null) {
        return;
      }
      long l = paramIntent.getLongExtra("ID", 0L);
      int i = paramIntent.getIntExtra("PID", 0);
      if (0L != l)
      {
        if (i == 0) {
          return;
        }
        if (i != Process.myPid())
        {
          Log.w("MicroMsg.Alarm", "onReceive id:%d, pid:%d, mypid:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(Process.myPid()) });
          return;
        }
        synchronized (gPendingAlarms)
        {
          paramIntent = (Alarm.AlarmRecord)gPendingAlarms.remove(Long.valueOf(l));
          if (paramIntent != null)
          {
            Log.i("MicroMsg.Alarm", "Alarm.onReceive [id: %d, delta miss time: %d, size: %d]", new Object[] { Long.valueOf(l), Long.valueOf(SystemClock.elapsedRealtime() - paramIntent.waitTime), Integer.valueOf(gPendingAlarms.size()) });
            if (wakerlock != null) {
              wakerlock.lock(200L);
            }
            onAlarm(l);
          }
          else
          {
            Log.e("MicroMsg.Alarm", "onReceive not found id:%d, pid:%d, gPendingAlarms.size:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(gPendingAlarms.size()) });
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.Alarm
 * JD-Core Version:    0.7.0.1
 */