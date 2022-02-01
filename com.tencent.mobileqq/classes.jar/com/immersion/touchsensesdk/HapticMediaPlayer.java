package com.immersion.touchsensesdk;

import android.content.Context;
import android.util.Log;

public class HapticMediaPlayer
{
  private static final String TAG = HapticMediaPlayer.class.getSimpleName();
  private static boolean sSDKHealthState = true;
  private ConnectionProxy mConnectionProxy;
  private long mNativeInstance = 0L;
  
  private HapticMediaPlayer(long paramLong)
  {
    this.mNativeInstance = paramLong;
  }
  
  private int _nAddResource(long paramLong, String paramString, int paramInt)
  {
    try
    {
      paramInt = nAddResource(paramLong, paramString, paramInt);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      updateSDKHealthState(paramString);
    }
    return -15;
  }
  
  private static long _nCreate(Context paramContext, String paramString1, String paramString2, String paramString3, IConnectionProxy paramIConnectionProxy)
  {
    try
    {
      long l = nCreate(paramContext, paramString1, paramString2, paramString3, paramIConnectionProxy);
      return l;
    }
    catch (Throwable paramContext)
    {
      updateSDKHealthState(paramContext);
    }
    return 0L;
  }
  
  private int _nDispose(long paramLong)
  {
    try
    {
      int i = nDispose(paramLong);
      return i;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nGetEffectInfo(long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = nGetEffectInfo(paramLong, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nGetPlayerInfo(long paramLong, int paramInt)
  {
    try
    {
      paramInt = nGetPlayerInfo(paramLong, paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nMute(long paramLong, int paramInt)
  {
    try
    {
      paramInt = nMute(paramLong, paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nPause(long paramLong, int paramInt)
  {
    try
    {
      paramInt = nPause(paramLong, paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nPlay(long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = nPlay(paramLong, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nRemoveResource(long paramLong, int paramInt)
  {
    try
    {
      paramInt = nRemoveResource(paramLong, paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nResume(long paramLong, int paramInt)
  {
    try
    {
      paramInt = nResume(paramLong, paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nSeek(long paramLong1, int paramInt, long paramLong2)
  {
    try
    {
      paramInt = nSeek(paramLong1, paramInt, paramLong2);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nStop(long paramLong, int paramInt)
  {
    try
    {
      paramInt = nStop(paramLong, paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nUnmute(long paramLong, int paramInt)
  {
    try
    {
      paramInt = nUnmute(paramLong, paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  private int _nUpdate(long paramLong1, int paramInt, long paramLong2)
  {
    try
    {
      paramInt = nUpdate(paramLong1, paramInt, paramLong2);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      updateSDKHealthState(localThrowable);
    }
    return -15;
  }
  
  public static HapticMediaPlayer create(Context paramContext, String paramString1, String paramString2, String paramString3, AsyncConnectionProxy paramAsyncConnectionProxy)
  {
    for (;;)
    {
      try
      {
        if (!sSDKHealthState)
        {
          Log.e(TAG, "TouchSense SDK has previously encountered a fatal error is now inoperative! Haptics will not be played.");
          paramContext = null;
          return paramContext;
        }
        if (paramAsyncConnectionProxy != null)
        {
          paramAsyncConnectionProxy = (ConnectionProxy)paramAsyncConnectionProxy.getConnectionProxy();
          long l = _nCreate(paramContext, paramString1, paramString2, paramString3, paramAsyncConnectionProxy);
          if (l == 0L)
          {
            paramContext = null;
            continue;
          }
          paramString1 = new HapticMediaPlayer(l);
          paramString1.mConnectionProxy = paramAsyncConnectionProxy;
          paramContext = paramString1;
          if (paramString1.versionCheck()) {
            continue;
          }
          throw new IllegalStateException("HapticMediaPlayer could not be initialized. Version mismatch between TouchSenseSDK.jar and libTouchSenseSDK.so. Make sure the two libraries are compatible.");
        }
      }
      finally {}
      paramAsyncConnectionProxy = null;
    }
  }
  
  private native int nAddResource(long paramLong, String paramString, int paramInt);
  
  private static native long nCreate(Context paramContext, String paramString1, String paramString2, String paramString3, IConnectionProxy paramIConnectionProxy);
  
  private native int nDispose(long paramLong);
  
  private native int nGetEffectInfo(long paramLong, int paramInt1, int paramInt2);
  
  private native int nGetPlayerInfo(long paramLong, int paramInt);
  
  private native int nMute(long paramLong, int paramInt);
  
  private native int nPause(long paramLong, int paramInt);
  
  private native int nPlay(long paramLong, int paramInt1, int paramInt2);
  
  private native int nRemoveResource(long paramLong, int paramInt);
  
  private native int nResume(long paramLong, int paramInt);
  
  private native int nSeek(long paramLong1, int paramInt, long paramLong2);
  
  private native int nStop(long paramLong, int paramInt);
  
  private native int nUnmute(long paramLong, int paramInt);
  
  private native int nUpdate(long paramLong1, int paramInt, long paramLong2);
  
  private static void updateSDKHealthState(Throwable paramThrowable)
  {
    sSDKHealthState = false;
    Log.e(TAG, "TouchSense SDK has encountered a fatal error and is now inoperative! Haptics will not be played.");
    paramThrowable.printStackTrace();
  }
  
  private final boolean versionCheck()
  {
    Object localObject = new int[5];
    Object tmp5_4 = localObject;
    tmp5_4[0] = 41;
    Object tmp10_5 = tmp5_4;
    tmp10_5[1] = 42;
    Object tmp15_10 = tmp10_5;
    tmp15_10[2] = 43;
    Object tmp20_15 = tmp15_10;
    tmp20_15[3] = 44;
    Object tmp25_20 = tmp20_15;
    tmp25_20[4] = 45;
    tmp25_20;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      int j;
      if (i < localObject.length)
      {
        j = getPlayerInfo(localObject[i]);
        if (j >= 0) {}
      }
      else
      {
        localObject = localStringBuilder.toString().replaceAll("(\\.0)+$", "");
        Log.i(TAG, "Native version: " + (String)localObject + ", Jar version: " + "v2.1.14.22");
        return "v2.1.14.22".contains((CharSequence)localObject);
      }
      if (i != 0) {
        localStringBuilder.append(".");
      }
      localStringBuilder.append(j);
      i += 1;
    }
  }
  
  public final int addResource(String paramString, int paramInt)
  {
    if (sSDKHealthState) {
      return _nAddResource(this.mNativeInstance, paramString, paramInt);
    }
    return -15;
  }
  
  public final int dispose()
  {
    if (this.mConnectionProxy != null)
    {
      this.mConnectionProxy.abort();
      this.mConnectionProxy = null;
    }
    if (sSDKHealthState) {
      return _nDispose(this.mNativeInstance);
    }
    return -15;
  }
  
  public final int getEffectInfo(int paramInt1, int paramInt2)
  {
    if (sSDKHealthState) {
      return _nGetEffectInfo(this.mNativeInstance, paramInt1, paramInt2);
    }
    return -15;
  }
  
  public final int getPlayerInfo(int paramInt)
  {
    if (sSDKHealthState) {
      return _nGetPlayerInfo(this.mNativeInstance, paramInt);
    }
    return -15;
  }
  
  public final int mute(int paramInt)
  {
    if (sSDKHealthState) {
      return _nMute(this.mNativeInstance, paramInt);
    }
    return -15;
  }
  
  public final int pause(int paramInt)
  {
    if (sSDKHealthState) {
      return _nPause(this.mNativeInstance, paramInt);
    }
    return -15;
  }
  
  public final int play(int paramInt)
  {
    return play(paramInt, 2);
  }
  
  public final int play(int paramInt1, int paramInt2)
  {
    if (sSDKHealthState) {
      return _nPlay(this.mNativeInstance, paramInt1, paramInt2);
    }
    return -15;
  }
  
  public final int removeResource(int paramInt)
  {
    if (sSDKHealthState) {
      return _nRemoveResource(this.mNativeInstance, paramInt);
    }
    return -15;
  }
  
  public final int resume(int paramInt)
  {
    if (sSDKHealthState) {
      return _nResume(this.mNativeInstance, paramInt);
    }
    return -15;
  }
  
  public final int seek(int paramInt, long paramLong)
  {
    if (sSDKHealthState) {
      return _nSeek(this.mNativeInstance, paramInt, paramLong);
    }
    return -15;
  }
  
  public final int stop(int paramInt)
  {
    if (sSDKHealthState) {
      return _nStop(this.mNativeInstance, paramInt);
    }
    return -15;
  }
  
  public final int unmute(int paramInt)
  {
    if (sSDKHealthState) {
      return _nUnmute(this.mNativeInstance, paramInt);
    }
    return -15;
  }
  
  public final int update(int paramInt, long paramLong)
  {
    if (sSDKHealthState) {
      return _nUpdate(this.mNativeInstance, paramInt, paramLong);
    }
    return -15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.immersion.touchsensesdk.HapticMediaPlayer
 * JD-Core Version:    0.7.0.1
 */