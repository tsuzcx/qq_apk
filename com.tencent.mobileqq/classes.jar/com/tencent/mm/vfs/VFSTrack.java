package com.tencent.mm.vfs;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class VFSTrack
{
  public static final String CONFIGURE_PUBLISH = "configure_publish";
  public static final String CONSTRUCTOR_TIME = "constructor_time";
  public static final String INIT_HANDTHREAD = "init_handle_thread";
  public static final String INIT_TIME = "init_time";
  public static final String LOAD_BUNDLE = "load_bundle";
  public static final String MIGRATE_CONFIGUE_TIME_1 = "migrate_configure_time_bundle";
  public static final String MIGRATE_CONFIGUE_TIME_2 = "migrate_configure_time_update";
  private static final String TAG = "VFSTrack_Time";
  private static boolean TRACE = true;
  private static ConcurrentHashMap<String, Long> sLogs = new ConcurrentHashMap(new HashMap(6));
  
  public static void debugger(boolean paramBoolean)
  {
    TRACE = paramBoolean;
  }
  
  public static void track(String paramString1, String paramString2)
  {
    if (TRACE)
    {
      long l = SystemClock.elapsedRealtime();
      if (paramString1 != null)
      {
        Long localLong = (Long)sLogs.remove(paramString1);
        if (localLong != null)
        {
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString1);
            localStringBuilder.append(", cost=");
            localStringBuilder.append(l - localLong.longValue());
            QLog.i("VFSTrack_Time", 2, localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString1);
            localStringBuilder.append(", cost=");
            localStringBuilder.append(l - localLong.longValue());
            Log.i("VFSTrack_Time", localStringBuilder.toString());
          }
        }
      }
      if (paramString2 != null) {
        sLogs.put(paramString2, Long.valueOf(l));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSTrack
 * JD-Core Version:    0.7.0.1
 */