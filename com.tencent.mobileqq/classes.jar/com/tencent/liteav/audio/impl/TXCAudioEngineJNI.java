package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import com.tencent.liteav.audio.TXCAudioEncoderConfig;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.g;
import com.tencent.liteav.audio.impl.earmonitor.TXSystemAudioKit;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.basic.util.h;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCAudioEngineJNI
{
  private static final String TAG = "TXCAudioEngineJNI";
  private static WeakReference<g> mAudioCaptureDataListener = null;
  private static TXCAudioEngineJNI.a mAudioDumpingListener;
  private static WeakReference<e> mMixedAllDataListener = new WeakReference(null);
  private static AudioManager sAudioManager;
  
  static
  {
    h.f();
    nativeCacheClassForNative();
    mAudioDumpingListener = null;
  }
  
  public static void InitTraeEngineLibrary(Context paramContext)
  {
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioEngineJNI", "InitTraeEngineLibrary failed, context is null!");
      return;
    }
    try
    {
      paramContext = paramContext.getApplicationInfo();
      String str1 = paramContext.nativeLibraryDir;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.dataDir);
      ((StringBuilder)localObject).append("/lib");
      String str2 = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/data/data/");
      ((StringBuilder)localObject).append(paramContext.packageName);
      ((StringBuilder)localObject).append("/lib");
      String str3 = ((StringBuilder)localObject).toString();
      localObject = h.g();
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add_libpath:");
      ((StringBuilder)localObject).append(str1);
      nativeAppendLibraryPath(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add_libpath:");
      ((StringBuilder)localObject).append(str2);
      nativeAppendLibraryPath(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add_libpath:");
      ((StringBuilder)localObject).append(str3);
      nativeAppendLibraryPath(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add_libpath:");
      ((StringBuilder)localObject).append(paramContext);
      nativeAppendLibraryPath(((StringBuilder)localObject).toString());
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      TXCLog.e("TXCAudioEngineJNI", "init trae engine library failed.", paramContext);
    }
  }
  
  public static void SetAudioDumpingListener(TXCAudioEngineJNI.a parama)
  {
    mAudioDumpingListener = parama;
  }
  
  private static AudioManager getAudioManager()
  {
    if (sAudioManager == null) {
      sAudioManager = (AudioManager)TXCAudioEngine.getInstance().getAppContext().getSystemService("audio");
    }
    return sAudioManager;
  }
  
  public static int getAudioMode()
  {
    try
    {
      AudioManager localAudioManager = getAudioManager();
      if (localAudioManager != null)
      {
        int i = localAudioManager.getMode();
        return i;
      }
    }
    catch (Exception localException)
    {
      label15:
      break label15;
    }
    return -1;
  }
  
  public static StatusBucket getStatus(int paramInt)
  {
    return nativeGetStatus(paramInt);
  }
  
  public static int getSystemVolume()
  {
    try
    {
      if (getAudioMode() != 0) {
        break label33;
      }
      i = 3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AudioManager localAudioManager;
        continue;
        label33:
        int i = 0;
      }
    }
    localAudioManager = getAudioManager();
    if (localAudioManager != null)
    {
      i = localAudioManager.getStreamVolume(i);
      return i;
    }
    return -1;
  }
  
  public static boolean isAppInBackground()
  {
    return h.a(TXCAudioEngine.getInstance().getAppContext());
  }
  
  public static native void nativeAppendLibraryPath(String paramString);
  
  public static native void nativeCacheClassForNative();
  
  public static boolean nativeCheckTraeEngine(Context paramContext)
  {
    if (paramContext == null)
    {
      TXCLog.e("TXCAudioEngineJNI", "nativeCheckTraeEngine failed, context is null!");
      return false;
    }
    if (h.a("traeimp-rtmp"))
    {
      TXCLog.e("TXCAudioEngineJNI", "link traeimp-rtmp success !");
      return true;
    }
    paramContext = paramContext.getApplicationInfo();
    String str3 = paramContext.nativeLibraryDir;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.dataDir);
    ((StringBuilder)localObject).append("/lib");
    String str1 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/data/data/");
    ((StringBuilder)localObject).append(paramContext.packageName);
    ((StringBuilder)localObject).append("/lib");
    String str2 = ((StringBuilder)localObject).toString();
    localObject = h.g();
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append("/libtraeimp-rtmp.so");
    if (new File(((StringBuilder)localObject).toString()).exists()) {}
    do
    {
      do
      {
        do
        {
          i = 1;
          break;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("nativeCheckTraeEngine load so error ");
          ((StringBuilder)localObject).append(str3);
          ((StringBuilder)localObject).append("/libtraeimp-rtmp.so");
          TXCLog.w("TXCAudioEngineJNI", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append("/libtraeimp-rtmp.so");
        } while (new File(((StringBuilder)localObject).toString()).exists());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("nativeCheckTraeEngine load so error ");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append("/libtraeimp-rtmp.so");
        TXCLog.w("TXCAudioEngineJNI", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append("/libtraeimp-rtmp.so");
      } while (new File(((StringBuilder)localObject).toString()).exists());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("nativeCheckTraeEngine load so error ");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("/libtraeimp-rtmp.so");
      TXCLog.w("TXCAudioEngineJNI", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("/libtraeimp-rtmp.so");
    } while (new File(((StringBuilder)localObject).toString()).exists());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("nativeCheckTraeEngine load so error ");
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("/libtraeimp-rtmp.so");
    TXCLog.w("TXCAudioEngineJNI", ((StringBuilder)localObject).toString());
    int i = 0;
    if (i != 0) {
      return true;
    }
    TXCLog.e("TXCAudioEngineJNI", "nativeCheckTraeEngine failed, can not find trae libs !");
    return false;
  }
  
  public static native void nativeClean();
  
  public static native void nativeCloseAudioTunnel(int paramInt);
  
  public static native void nativeDeleteAudioSessionDuplicate();
  
  public static native void nativeEnableAudioEarMonitoring(boolean paramBoolean);
  
  public static native void nativeEnableAudioVolumeEvaluation(boolean paramBoolean, int paramInt);
  
  public static native void nativeEnableAutoRestartDevice(boolean paramBoolean);
  
  public static native void nativeEnableCaptureEOSMode(boolean paramBoolean);
  
  public static native void nativeEnableDeviceAbnormalDetection(boolean paramBoolean);
  
  public static native void nativeEnableEncodedDataCallback(boolean paramBoolean);
  
  public static native void nativeEnableEncodedDataPackWithTRAEHeaderCallback(boolean paramBoolean);
  
  public static native void nativeEnableInbandFEC(boolean paramBoolean);
  
  public static native void nativeEnableMixMode(boolean paramBoolean);
  
  public static native void nativeForceCallbackMixedPlayAudioFrame(boolean paramBoolean);
  
  public static native int nativeGetEncoderChannels();
  
  public static native TXCAudioEncoderConfig nativeGetEncoderConfig();
  
  public static native int nativeGetEncoderSampleRate();
  
  public static native int nativeGetMixingPlayoutVolumeLevel();
  
  public static native int nativeGetRemotePlayoutVolumeLevel(String paramString);
  
  public static native int nativeGetSoftwareCaptureVolumeLevel();
  
  public static native StatusBucket nativeGetStatus(int paramInt);
  
  public static native void nativeInitAudioDevice();
  
  public static native void nativeInitBeforeEngineCreate(Context paramContext);
  
  public static native boolean nativeIsAudioDeviceCapturing();
  
  public static native boolean nativeIsAudioDevicePlaying();
  
  public static native boolean nativeIsDataCallbackFormatInvalid(int paramInt1, int paramInt2, int paramInt3);
  
  public static native boolean nativeIsRemoteAudioPlaying(String paramString);
  
  public static native void nativeMuteLocalAudio(boolean paramBoolean);
  
  public static native void nativeMuteRemoteAudio(String paramString, boolean paramBoolean);
  
  public static native void nativeMuteRemoteAudioInSpeaker(String paramString, boolean paramBoolean);
  
  public static native void nativeNewAudioSessionDuplicate(Context paramContext);
  
  public static native void nativeNotifySystemEarMonitoringInitializing();
  
  public static native int nativeOpenAudioTunnel(boolean paramBoolean);
  
  public static native void nativePauseAudioCapture(boolean paramBoolean);
  
  public static native void nativePauseLocalAudio();
  
  public static native void nativeResumeAudioCapture();
  
  public static native void nativeResumeLocalAudio();
  
  public static native void nativeSendCustomPCMData(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public static native void nativeSetAudioCacheParams(int paramInt1, int paramInt2);
  
  public static native void nativeSetAudioEarMonitoringVolume(int paramInt);
  
  public static native void nativeSetAudioEncoderParam(int paramInt1, int paramInt2);
  
  public static native void nativeSetAudioEngineCaptureDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineCaptureRawDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineEncodedDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineMixedAllDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineRemoteStreamDataListener(String paramString, boolean paramBoolean);
  
  public static native void nativeSetAudioPlayoutTunnelEnabled(boolean paramBoolean);
  
  public static native void nativeSetAudioQuality(int paramInt1, int paramInt2);
  
  public static native void nativeSetAudioRoute(int paramInt);
  
  public static native void nativeSetCaptureDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetCaptureVoiceChanger(int paramInt);
  
  public static native void nativeSetEncoderChannels(int paramInt);
  
  public static native void nativeSetEncoderFECPercent(float paramFloat);
  
  public static native void nativeSetEncoderSampleRate(int paramInt);
  
  public static native void nativeSetEventCallbackEnabled(boolean paramBoolean);
  
  public static native void nativeSetLocalProcessedDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetMaxSelectedPlayStreams(int paramInt);
  
  public static native void nativeSetMixingPlayoutVolume(float paramFloat);
  
  public static native void nativeSetPlayoutDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetPlayoutDataListener(boolean paramBoolean);
  
  public static native void nativeSetPlayoutDevice(int paramInt);
  
  public static native void nativeSetRecordReverb(int paramInt);
  
  public static native void nativeSetRemoteAudioBlockThreshold(String paramString, long paramLong);
  
  public static native void nativeSetRemoteAudioCacheParams(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetRemoteAudioJitterCycle(String paramString, long paramLong);
  
  public static native void nativeSetRemotePlayoutVolume(String paramString, int paramInt);
  
  public static native void nativeSetRemoteStreamDataCallbackFormat(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetSoftAEC(int paramInt);
  
  public static native void nativeSetSoftAGC(int paramInt);
  
  public static native void nativeSetSoftANS(int paramInt);
  
  public static native void nativeSetSoftwareCaptureVolume(float paramFloat);
  
  public static native void nativeSetSystemEarMonitoring(TXSystemAudioKit paramTXSystemAudioKit);
  
  public static native void nativeSetSystemVolumeType(int paramInt);
  
  public static native void nativeSetTRAEConfig(String paramString);
  
  public static native void nativeStartLocalAudio(int paramInt, boolean paramBoolean);
  
  public static native int nativeStartLocalAudioDumping(int paramInt1, int paramInt2, String paramString);
  
  public static native String nativeStartRemoteAudio(TXCAudioEngine paramTXCAudioEngine, boolean paramBoolean, String paramString);
  
  public static native void nativeStopLocalAudio();
  
  public static native void nativeStopLocalAudioDumping();
  
  public static native void nativeStopRemoteAudio(String paramString);
  
  public static native void nativeUnInitAudioDevice();
  
  public static native void nativeUseSysAudioDevice(boolean paramBoolean);
  
  public static native void nativeWriteDataToTunnel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte);
  
  public static void onError(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TXCAudioEngine.getInstance().onError(paramString1, paramInt, paramString2, paramString3);
  }
  
  public static void onEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TXCAudioEngine.getInstance().onEvent(paramString1, paramInt, paramString2, paramString3);
  }
  
  public static void onLocalAudioWriteFail()
  {
    TXCAudioEngineJNI.a locala = mAudioDumpingListener;
    if (locala != null) {
      locala.onLocalAudioWriteFailed();
    }
  }
  
  public static void onMixedAllData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    e locale = (e)mMixedAllDataListener.get();
    if (locale != null) {
      locale.onMixedAllData(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public static void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    WeakReference localWeakReference = mAudioCaptureDataListener;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((g)mAudioCaptureDataListener.get()).onRecordEncData(paramArrayOfByte, paramLong, paramInt1, paramInt2, 16);
    }
  }
  
  public static void onRecordError(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRecordError: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString);
    TXCLog.e("TXCAudioEngineJNI", ((StringBuilder)localObject).toString());
    localObject = mAudioCaptureDataListener;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((g)mAudioCaptureDataListener.get()).onRecordError(paramInt, paramString);
    }
  }
  
  public static void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    WeakReference localWeakReference = mAudioCaptureDataListener;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((g)mAudioCaptureDataListener.get()).onRecordPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public static void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    WeakReference localWeakReference = mAudioCaptureDataListener;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((g)mAudioCaptureDataListener.get()).onRecordRawPcmData(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, false);
    }
  }
  
  public static void onWarning(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TXCAudioEngine.getInstance().onWarning(paramString1, paramInt, paramString2, paramString3);
  }
  
  public static void pauseAudioCapture(boolean paramBoolean)
  {
    nativePauseAudioCapture(paramBoolean);
  }
  
  public static void resumeAudioCapture() {}
  
  public static void sendCustomPCMData(a parama)
  {
    nativeSendCustomPCMData(parama.f, parama.f.length, parama.e, parama.a, parama.b);
  }
  
  public static void sendCustomPCMData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    nativeSendCustomPCMData(paramArrayOfByte, paramArrayOfByte.length, 0L, paramInt1, paramInt2);
  }
  
  public static void setAudioCaptureDataListener(WeakReference<g> paramWeakReference)
  {
    mAudioCaptureDataListener = paramWeakReference;
    paramWeakReference = mAudioCaptureDataListener;
    boolean bool2 = false;
    boolean bool1;
    if (paramWeakReference == null) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    nativeSetAudioEngineCaptureDataCallback(bool1);
    if (mAudioCaptureDataListener == null) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    nativeSetAudioEngineCaptureRawDataCallback(bool1);
    if (mAudioCaptureDataListener == null) {
      bool1 = bool2;
    } else {
      bool1 = true;
    }
    nativeSetAudioEngineEncodedDataCallback(bool1);
  }
  
  public static void setMixedAllDataListener(e parame)
  {
    mMixedAllDataListener = new WeakReference(parame);
    boolean bool;
    if (parame != null) {
      bool = true;
    } else {
      bool = false;
    }
    nativeSetAudioEngineMixedAllDataCallback(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.TXCAudioEngineJNI
 * JD-Core Version:    0.7.0.1
 */