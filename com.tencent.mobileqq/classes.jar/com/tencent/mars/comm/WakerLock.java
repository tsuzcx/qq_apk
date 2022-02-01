package com.tencent.mars.comm;

import android.content.Context;
import android.os.PowerManager.WakeLock;
import androidx.annotation.Keep;

@Keep
public class WakerLock
{
  private static final String TAG = "MicroMsg.WakerLock";
  private static long lastChecktime;
  private static Boolean shouldLock;
  private WakerLock.IAutoUnlockCallback autoUnlockCallback = null;
  private Context context;
  private String mCreatePosStackLine = null;
  private Runnable mReleaser = new WakerLock.1(this);
  private PowerManager.WakeLock wakeLock = null;
  
  public WakerLock(Context paramContext, String paramString) {}
  
  public WakerLock(Context paramContext, String paramString, WakerLock.IAutoUnlockCallback paramIAutoUnlockCallback)
  {
    this(paramContext, paramString);
    this.autoUnlockCallback = paramIAutoUnlockCallback;
  }
  
  private String getCallerStack()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if (!localStackTraceElement.getClassName().contains(WakerLock.class.getName())) {
        return localStackTraceElement.toString();
      }
      i += 1;
    }
    return "<native>";
  }
  
  protected void finalize() {}
  
  public String getCreatePosStackLine()
  {
    return this.mCreatePosStackLine;
  }
  
  public int innerWakeLockHashCode()
  {
    return this.wakeLock.hashCode();
  }
  
  public boolean isLocking()
  {
    try
    {
      boolean bool = this.wakeLock.isHeld();
      return bool;
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    return false;
  }
  
  public void lock()
  {
    lock(getCallerStack());
  }
  
  public void lock(long paramLong)
  {
    lock(paramLong, getCallerStack());
  }
  
  public void lock(long paramLong, String paramString) {}
  
  public void lock(String paramString)
  {
    lock(-1L, paramString);
  }
  
  public void unLock() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.comm.WakerLock
 * JD-Core Version:    0.7.0.1
 */