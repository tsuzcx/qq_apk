package com.tencent.mmkv;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MMKV
  implements SharedPreferences, SharedPreferences.Editor
{
  private static final EnumMap<MMKVRecoverStrategic, Integer> a = new EnumMap(MMKVRecoverStrategic.class);
  private static final EnumMap<MMKVLogLevel, Integer> b;
  private static final MMKVLogLevel[] c = { MMKVLogLevel.LevelDebug, MMKVLogLevel.LevelInfo, MMKVLogLevel.LevelWarning, MMKVLogLevel.LevelError, MMKVLogLevel.LevelNone };
  private static final Set<Long> d = new HashSet();
  private static String e = null;
  private static boolean f = true;
  private static final HashMap<String, Parcelable.Creator<?>> g = new HashMap();
  private static MMKVHandler h;
  private static boolean i = false;
  private static MMKVContentChangeNotification j;
  private final long nativeHandle;
  
  static
  {
    EnumMap localEnumMap = a;
    MMKVRecoverStrategic localMMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
    Integer localInteger1 = Integer.valueOf(0);
    localEnumMap.put(localMMKVRecoverStrategic, localInteger1);
    localEnumMap = a;
    localMMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorRecover;
    Integer localInteger2 = Integer.valueOf(1);
    localEnumMap.put(localMMKVRecoverStrategic, localInteger2);
    b = new EnumMap(MMKVLogLevel.class);
    b.put(MMKVLogLevel.LevelDebug, localInteger1);
    b.put(MMKVLogLevel.LevelInfo, localInteger2);
    b.put(MMKVLogLevel.LevelWarning, Integer.valueOf(2));
    b.put(MMKVLogLevel.LevelError, Integer.valueOf(3));
    b.put(MMKVLogLevel.LevelNone, Integer.valueOf(4));
  }
  
  private MMKV(long paramLong)
  {
    this.nativeHandle = paramLong;
  }
  
  private static int a(MMKVLogLevel paramMMKVLogLevel)
  {
    int m = MMKV.1.a[paramMMKVLogLevel.ordinal()];
    int k = 4;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4) {
            return 1;
          }
        }
        else {
          return 3;
        }
      }
      else {
        return 2;
      }
    }
    else {
      k = 0;
    }
    return k;
  }
  
  @Nullable
  public static MMKV a()
  {
    if (e != null) {
      return a(getDefaultMMKV(1, null), "DefaultMMKV", 1);
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  @Nullable
  public static MMKV a(int paramInt, @Nullable String paramString)
  {
    if (e != null) {
      return a(getDefaultMMKV(paramInt, paramString), "DefaultMMKV", paramInt);
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  @Nullable
  private static MMKV a(long paramLong, String paramString, int paramInt)
  {
    if (paramLong == 0L) {
      return null;
    }
    if (!f) {
      return new MMKV(paramLong);
    }
    synchronized (d)
    {
      if (!d.contains(Long.valueOf(paramLong)))
      {
        if (!checkProcessMode(paramLong))
        {
          StringBuilder localStringBuilder;
          if (paramInt == 1)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Opening a multi-process MMKV instance [");
            localStringBuilder.append(paramString);
            localStringBuilder.append("] with SINGLE_PROCESS_MODE!");
            paramString = localStringBuilder.toString();
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Opening a MMKV instance [");
            localStringBuilder.append(paramString);
            localStringBuilder.append("] with MULTI_PROCESS_MODE, ");
            paramString = localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append("while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!");
            paramString = localStringBuilder.toString();
          }
          throw new IllegalArgumentException(paramString);
        }
        d.add(Long.valueOf(paramLong));
      }
      return new MMKV(paramLong);
    }
  }
  
  @Nullable
  public static MMKV a(Context paramContext, String paramString1, int paramInt1, int paramInt2, @Nullable String paramString2)
  {
    if (e != null)
    {
      Object localObject1 = MMKVContentProvider.a(paramContext, Process.myPid());
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        if (((String)localObject1).contains(":"))
        {
          localObject1 = MMKVContentProvider.a(paramContext);
          if (localObject1 == null)
          {
            a(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
            return null;
          }
          Object localObject2 = MMKVLogLevel.LevelInfo;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getting parcelable mmkv in process, Uri = ");
          localStringBuilder.append(localObject1);
          a((MMKVLogLevel)localObject2, localStringBuilder.toString());
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("KEY_SIZE", paramInt1);
          ((Bundle)localObject2).putInt("KEY_MODE", paramInt2);
          if (paramString2 != null) {
            ((Bundle)localObject2).putString("KEY_CRYPT", paramString2);
          }
          paramContext = paramContext.getContentResolver().call((Uri)localObject1, "mmkvFromAshmemID", paramString1, (Bundle)localObject2);
          if (paramContext != null)
          {
            paramContext.setClassLoader(ParcelableMMKV.class.getClassLoader());
            paramContext = (ParcelableMMKV)paramContext.getParcelable("KEY");
            if (paramContext != null)
            {
              paramContext = paramContext.a();
              if (paramContext != null)
              {
                paramString1 = MMKVLogLevel.LevelInfo;
                paramString2 = new StringBuilder();
                paramString2.append(paramContext.mmapID());
                paramString2.append(" fd = ");
                paramString2.append(paramContext.ashmemFD());
                paramString2.append(", meta fd = ");
                paramString2.append(paramContext.ashmemMetaFD());
                a(paramString1, paramString2.toString());
              }
              return paramContext;
            }
          }
          return null;
        }
        a(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
        return new MMKV(getMMKVWithIDAndSize(paramString1, paramInt1, paramInt2 | 0x8, paramString2));
      }
      a(MMKVLogLevel.LevelError, "process name detect fail, try again later");
      return null;
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  @Nullable
  public static MMKV a(String paramString, int paramInt)
  {
    if (e != null) {
      return a(getMMKVWithID(paramString, paramInt, null, null), paramString, paramInt);
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  public static MMKV a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return new MMKV(getMMKVWithAshmemFD(paramString1, paramInt1, paramInt2, paramString2));
  }
  
  @Nullable
  public static MMKV a(String paramString1, int paramInt, @Nullable String paramString2)
  {
    if (e != null) {
      return a(getMMKVWithID(paramString1, paramInt, paramString2, null), paramString1, paramInt);
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  public static String a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/mmkv");
    return a(paramContext, localStringBuilder.toString(), null, MMKVLogLevel.LevelInfo);
  }
  
  public static String a(Context paramContext, String paramString, MMKV.LibLoader paramLibLoader, MMKVLogLevel paramMMKVLogLevel)
  {
    if ((paramContext.getApplicationInfo().flags & 0x2) == 0) {
      c();
    } else {
      b();
    }
    return a(paramString, paramLibLoader, paramMMKVLogLevel);
  }
  
  @Deprecated
  public static String a(String paramString, MMKV.LibLoader paramLibLoader)
  {
    return a(paramString, paramLibLoader, MMKVLogLevel.LevelInfo);
  }
  
  private static String a(String paramString, MMKV.LibLoader paramLibLoader, MMKVLogLevel paramMMKVLogLevel)
  {
    if (paramLibLoader != null) {
      paramLibLoader.loadLibrary("mmkv");
    } else {
      System.loadLibrary("mmkv");
    }
    jniInitialize(paramString, a(paramMMKVLogLevel));
    e = paramString;
    return e;
  }
  
  public static void a(MMKVHandler paramMMKVHandler)
  {
    h = paramMMKVHandler;
    if (h.wantLogRedirecting())
    {
      setCallbackHandler(true, true);
      i = true;
      return;
    }
    setCallbackHandler(false, true);
    i = false;
  }
  
  private static void a(MMKVLogLevel paramMMKVLogLevel, String paramString)
  {
    Object localObject = Thread.currentThread().getStackTrace();
    localObject = localObject[(localObject.length - 1)];
    paramMMKVLogLevel = (Integer)b.get(paramMMKVLogLevel);
    int k;
    if (paramMMKVLogLevel == null) {
      k = 0;
    } else {
      k = paramMMKVLogLevel.intValue();
    }
    mmkvLogImp(k, ((StackTraceElement)localObject).getFileName(), ((StackTraceElement)localObject).getLineNumber(), ((StackTraceElement)localObject).getMethodName(), paramString);
  }
  
  public static void b()
  {
    synchronized (d)
    {
      f = true;
      Log.i("MMKV", "Enable checkProcessMode()");
      return;
    }
  }
  
  public static void c()
  {
    synchronized (d)
    {
      f = false;
      Log.i("MMKV", "Disable checkProcessMode()");
      return;
    }
  }
  
  private static native boolean checkProcessMode(long paramLong);
  
  private native boolean containsKey(long paramLong, String paramString);
  
  private native long count(long paramLong);
  
  private static native long createNB(int paramInt);
  
  private native boolean decodeBool(long paramLong, String paramString, boolean paramBoolean);
  
  @Nullable
  private native byte[] decodeBytes(long paramLong, String paramString);
  
  private native double decodeDouble(long paramLong, String paramString, double paramDouble);
  
  private native float decodeFloat(long paramLong, String paramString, float paramFloat);
  
  private native int decodeInt(long paramLong, String paramString, int paramInt);
  
  private native long decodeLong(long paramLong1, String paramString, long paramLong2);
  
  @Nullable
  private native String decodeString(long paramLong, String paramString1, @Nullable String paramString2);
  
  @Nullable
  private native String[] decodeStringSet(long paramLong, String paramString);
  
  private static native void destroyNB(long paramLong, int paramInt);
  
  private native boolean encodeBool(long paramLong, String paramString, boolean paramBoolean);
  
  private native boolean encodeBytes(long paramLong, String paramString, @Nullable byte[] paramArrayOfByte);
  
  private native boolean encodeDouble(long paramLong, String paramString, double paramDouble);
  
  private native boolean encodeFloat(long paramLong, String paramString, float paramFloat);
  
  private native boolean encodeInt(long paramLong, String paramString, int paramInt);
  
  private native boolean encodeLong(long paramLong1, String paramString, long paramLong2);
  
  private native boolean encodeSet(long paramLong, String paramString, @Nullable String[] paramArrayOfString);
  
  private native boolean encodeString(long paramLong, String paramString1, @Nullable String paramString2);
  
  private static native long getDefaultMMKV(int paramInt, @Nullable String paramString);
  
  private static native long getMMKVWithAshmemFD(String paramString1, int paramInt1, int paramInt2, @Nullable String paramString2);
  
  private static native long getMMKVWithID(String paramString1, int paramInt, @Nullable String paramString2, @Nullable String paramString3);
  
  private static native long getMMKVWithIDAndSize(String paramString1, int paramInt1, int paramInt2, @Nullable String paramString2);
  
  public static native boolean isFileValid(String paramString1, @Nullable String paramString2);
  
  private static native void jniInitialize(String paramString, int paramInt);
  
  private static void mmkvLogImp(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    MMKVHandler localMMKVHandler = h;
    if ((localMMKVHandler != null) && (i))
    {
      localMMKVHandler.mmkvLog(c[paramInt1], paramString1, paramInt2, paramString2, paramString3);
      return;
    }
    paramInt1 = MMKV.1.a[c[paramInt1].ordinal()];
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 5) {
            return;
          }
          Log.i("MMKV", paramString3);
          return;
        }
        Log.e("MMKV", paramString3);
        return;
      }
      Log.w("MMKV", paramString3);
      return;
    }
    Log.d("MMKV", paramString3);
  }
  
  private static void onContentChangedByOuterProcess(String paramString)
  {
    MMKVContentChangeNotification localMMKVContentChangeNotification = j;
    if (localMMKVContentChangeNotification != null) {
      localMMKVContentChangeNotification.a(paramString);
    }
  }
  
  public static native void onExit();
  
  private static int onMMKVCRCCheckFail(String paramString)
  {
    MMKVRecoverStrategic localMMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
    Object localObject = h;
    if (localObject != null) {
      localMMKVRecoverStrategic = ((MMKVHandler)localObject).onMMKVCRCCheckFail(paramString);
    }
    localObject = MMKVLogLevel.LevelInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Recover strategic for ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is ");
    localStringBuilder.append(localMMKVRecoverStrategic);
    a((MMKVLogLevel)localObject, localStringBuilder.toString());
    paramString = (Integer)a.get(localMMKVRecoverStrategic);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  private static int onMMKVFileLengthError(String paramString)
  {
    MMKVRecoverStrategic localMMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
    Object localObject = h;
    if (localObject != null) {
      localMMKVRecoverStrategic = ((MMKVHandler)localObject).onMMKVFileLengthError(paramString);
    }
    localObject = MMKVLogLevel.LevelInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Recover strategic for ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is ");
    localStringBuilder.append(localMMKVRecoverStrategic);
    a((MMKVLogLevel)localObject, localStringBuilder.toString());
    paramString = (Integer)a.get(localMMKVRecoverStrategic);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public static native int pageSize();
  
  private native void removeValueForKey(long paramLong, String paramString);
  
  private static native void setCallbackHandler(boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void setLogLevel(int paramInt);
  
  private static native void setWantsContentChangeNotify(boolean paramBoolean);
  
  private native void sync(boolean paramBoolean);
  
  private native long totalSize(long paramLong);
  
  private native int valueSize(long paramLong, String paramString, boolean paramBoolean);
  
  public static native String version();
  
  private native int writeValueToNB(long paramLong1, String paramString, long paramLong2, int paramInt);
  
  @Nullable
  public String a(String paramString)
  {
    return decodeString(this.nativeHandle, paramString, null);
  }
  
  @Nullable
  public Set<String> a(String paramString, @Nullable Set<String> paramSet, Class<? extends Set> paramClass)
  {
    paramString = decodeStringSet(this.nativeHandle, paramString);
    if (paramString == null) {
      return paramSet;
    }
    try
    {
      paramClass = (Set)paramClass.newInstance();
      paramClass.addAll(Arrays.asList(paramString));
      return paramClass;
    }
    catch (IllegalAccessException|InstantiationException paramString) {}
    return paramSet;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    return encodeLong(this.nativeHandle, paramString, paramLong);
  }
  
  public boolean a(String paramString1, @Nullable String paramString2)
  {
    return encodeString(this.nativeHandle, paramString1, paramString2);
  }
  
  public boolean a(String paramString, @Nullable Set<String> paramSet)
  {
    long l = this.nativeHandle;
    if (paramSet == null) {
      paramSet = null;
    } else {
      paramSet = (String[])paramSet.toArray(new String[0]);
    }
    return encodeSet(l, paramString, paramSet);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    return encodeBool(this.nativeHandle, paramString, paramBoolean);
  }
  
  public boolean a(String paramString, @Nullable byte[] paramArrayOfByte)
  {
    return encodeBytes(this.nativeHandle, paramString, paramArrayOfByte);
  }
  
  @Nullable
  public native String[] allKeys();
  
  public void apply()
  {
    sync(false);
  }
  
  public native int ashmemFD();
  
  public native int ashmemMetaFD();
  
  public long b(String paramString, long paramLong)
  {
    return decodeLong(this.nativeHandle, paramString, paramLong);
  }
  
  @Nullable
  public String b(String paramString1, @Nullable String paramString2)
  {
    return decodeString(this.nativeHandle, paramString1, paramString2);
  }
  
  @Nullable
  public Set<String> b(String paramString, @Nullable Set<String> paramSet)
  {
    return a(paramString, paramSet, HashSet.class);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    return encodeInt(this.nativeHandle, paramString, paramInt);
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    return decodeBool(this.nativeHandle, paramString, paramBoolean);
  }
  
  @Nullable
  public byte[] b(String paramString)
  {
    return b(paramString, null);
  }
  
  @Nullable
  public byte[] b(String paramString, @Nullable byte[] paramArrayOfByte)
  {
    paramString = decodeBytes(this.nativeHandle, paramString);
    if (paramString != null) {
      return paramString;
    }
    return paramArrayOfByte;
  }
  
  public int c(String paramString, int paramInt)
  {
    return decodeInt(this.nativeHandle, paramString, paramInt);
  }
  
  public boolean c(String paramString)
  {
    return containsKey(this.nativeHandle, paramString);
  }
  
  public native void checkContentChangedByOuterProcess();
  
  public native void checkReSetCryptKey(@Nullable String paramString);
  
  public SharedPreferences.Editor clear()
  {
    clearAll();
    return this;
  }
  
  public native void clearAll();
  
  public native void clearMemoryCache();
  
  public native void close();
  
  public boolean commit()
  {
    sync(true);
    return true;
  }
  
  public boolean contains(String paramString)
  {
    return c(paramString);
  }
  
  @Nullable
  public native String cryptKey();
  
  public long d()
  {
    return totalSize(this.nativeHandle);
  }
  
  public void d(String paramString)
  {
    removeValueForKey(this.nativeHandle, paramString);
  }
  
  public SharedPreferences.Editor edit()
  {
    return this;
  }
  
  public Map<String, ?> getAll()
  {
    throw new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return decodeBool(this.nativeHandle, paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return decodeFloat(this.nativeHandle, paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return decodeInt(this.nativeHandle, paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return decodeLong(this.nativeHandle, paramString, paramLong);
  }
  
  @Nullable
  public String getString(String paramString1, @Nullable String paramString2)
  {
    return decodeString(this.nativeHandle, paramString1, paramString2);
  }
  
  @Nullable
  public Set<String> getStringSet(String paramString, @Nullable Set<String> paramSet)
  {
    return b(paramString, paramSet);
  }
  
  public native void lock();
  
  public native String mmapID();
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    encodeBool(this.nativeHandle, paramString, paramBoolean);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    encodeFloat(this.nativeHandle, paramString, paramFloat);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    encodeInt(this.nativeHandle, paramString, paramInt);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    encodeLong(this.nativeHandle, paramString, paramLong);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, @Nullable String paramString2)
  {
    encodeString(this.nativeHandle, paramString1, paramString2);
    return this;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, @Nullable Set<String> paramSet)
  {
    a(paramString, paramSet);
    return this;
  }
  
  public native boolean reKey(@Nullable String paramString);
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    throw new UnsupportedOperationException("Not implement in MMKV");
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    d(paramString);
    return this;
  }
  
  public native void removeValuesForKeys(String[] paramArrayOfString);
  
  public native void trim();
  
  public native boolean tryLock();
  
  public native void unlock();
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    throw new UnsupportedOperationException("Not implement in MMKV");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mmkv.MMKV
 * JD-Core Version:    0.7.0.1
 */