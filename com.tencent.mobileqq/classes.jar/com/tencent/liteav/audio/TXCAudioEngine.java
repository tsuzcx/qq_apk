package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI.a;
import com.tencent.liteav.audio.impl.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TXCAudioEngine
  implements b
{
  private static final int EVT_AUDIO_DEVICE_RESTART_WHEN_USING_STABLE_SAMPLERATE = 10056;
  private static final int EVT_AUDIO_DEVICE_ROLLBACK_TO_STABLE_SAMPLERATE = 10055;
  private static final String TAG = "AudioEngine :TXCAudioEngine_java";
  private static volatile boolean has_init = false;
  private static boolean has_trae;
  private static WeakReference<d> mAudioCoreDataListener;
  protected static Context mContext;
  protected static final HashMap<String, WeakReference<d>> mJitterDataListenerMap;
  private static final Object mJitterDataListenerMapLock;
  protected static final HashMap<String, WeakReference<c>> mJitterEventListenerMap;
  private static final Object mJitterEventListenerMapLock;
  static TXCAudioEngine sInstance = new TXCAudioEngine();
  private final ArrayList<WeakReference<com.tencent.liteav.basic.b.a>> mCallbackList = new ArrayList();
  protected boolean mDeviceIsRecording = false;
  protected boolean mIsCallComed = false;
  protected boolean mIsCustomRecord = false;
  
  static
  {
    mContext = null;
    has_trae = false;
    mAudioCoreDataListener = null;
    mJitterDataListenerMap = new HashMap();
    mJitterDataListenerMapLock = new Object();
    mJitterEventListenerMap = new HashMap();
    mJitterEventListenerMapLock = new Object();
  }
  
  public static void CreateInstance(Context paramContext, String paramString)
  {
    try
    {
      CreateInstanceWithoutInitDevice(paramContext, paramString);
      TXCAudioEngineJNI.nativeInitAudioDevice();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void CreateInstanceWithoutInitDevice(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        TXCLog.i("AudioEngine :TXCAudioEngine_java", "CreateInstance: ");
        mContext = paramContext.getApplicationContext();
        if (has_init)
        {
          TXCLog.i("AudioEngine :TXCAudioEngine_java", "CreateInstance already created~ ");
          return;
        }
        if (TXCAudioEngineJNI.nativeCheckTraeEngine(paramContext)) {
          has_trae = true;
        }
        if (!has_trae)
        {
          bool = true;
          TXCAudioEngineJNI.nativeUseSysAudioDevice(bool);
          if (has_trae)
          {
            TXCAudioEngineJNI.InitTraeEngineLibrary(paramContext);
            TXCAudioEngineJNI.nativeSetTRAEConfig(paramString);
            TXCAudioEngineJNI.nativeInitBeforeEngineCreate(paramContext);
            com.tencent.liteav.audio.impl.a.a().a(paramContext.getApplicationContext());
            com.tencent.liteav.audio.impl.a.a().a(sInstance);
            TXCAudioEngineJNI.nativeNewAudioSessionDuplicate(mContext);
          }
          else
          {
            TXCMultAudioTrackPlayer.getInstance();
            TXCAudioSysRecord.getInstance();
          }
          has_init = true;
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public static String buildTRAEConfig(Context paramContext, Boolean paramBoolean, boolean paramBoolean1, long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append("sharp {\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("  os android\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("  trae {\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("    dev {\n");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (paramBoolean != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("  closeOpensl ");
      if (paramBoolean.booleanValue()) {
        paramBoolean = "n";
      } else {
        paramBoolean = "y";
      }
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("\n");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    long l = a.a().b("timestamp_rollback_to_stable_samplerate", 0L);
    boolean bool;
    if (System.currentTimeMillis() - l < paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "low latency samplerate, enable: %b, isBlocked: %b, blockTime: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Long.valueOf(paramLong) });
    paramBoolean = (Boolean)localObject1;
    if (!bool)
    {
      paramBoolean = (Boolean)localObject1;
      if (paramBoolean1)
      {
        paramBoolean = (Boolean)localObject1;
        if (getLowLatencySampleRate(paramContext) == 48000)
        {
          paramContext = new StringBuilder();
          paramContext.append((String)localObject1);
          paramContext.append("  component 1\n");
          paramContext = paramContext.toString();
          paramBoolean = new StringBuilder();
          paramBoolean.append(paramContext);
          paramBoolean.append("  cap {\n");
          paramContext = paramBoolean.toString();
          paramBoolean = new StringBuilder();
          paramBoolean.append(paramContext);
          paramBoolean.append("    hw_sr 48000\n");
          paramContext = paramBoolean.toString();
          paramBoolean = new StringBuilder();
          paramBoolean.append(paramContext);
          paramBoolean.append("  }\n");
          paramContext = paramBoolean.toString();
          paramBoolean = new StringBuilder();
          paramBoolean.append(paramContext);
          paramBoolean.append("  play {\n");
          paramContext = paramBoolean.toString();
          paramBoolean = new StringBuilder();
          paramBoolean.append(paramContext);
          paramBoolean.append("    hw_sr 48000\n");
          paramContext = paramBoolean.toString();
          paramBoolean = new StringBuilder();
          paramBoolean.append(paramContext);
          paramBoolean.append("  }");
          paramBoolean = paramBoolean.toString();
        }
      }
    }
    paramContext = new StringBuilder();
    paramContext.append(paramBoolean);
    paramContext.append("    }\n");
    paramContext = paramContext.toString();
    paramBoolean = new StringBuilder();
    paramBoolean.append(paramContext);
    paramBoolean.append("  }\n");
    paramContext = paramBoolean.toString();
    paramBoolean = new StringBuilder();
    paramBoolean.append(paramContext);
    paramBoolean.append("}");
    return paramBoolean.toString();
  }
  
  public static void enableAudioEarMonitoring(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableAudioEarMonitoring: ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeEnableAudioEarMonitoring(paramBoolean);
  }
  
  public static boolean enableAudioVolumeEvaluation(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableAudioVolumeEvaluation : ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("interval:");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeEnableAudioVolumeEvaluation(paramBoolean, paramInt);
    return true;
  }
  
  public static TXCAudioEngine getInstance()
  {
    return sInstance;
  }
  
  private static int getLowLatencySampleRate(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      if (paramContext != null) {
        try
        {
          int i = Integer.parseInt(paramContext.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
          return i;
        }
        catch (NumberFormatException paramContext)
        {
          TXCLog.e("AudioEngine :TXCAudioEngine_java", "can't parse low latency samplerate", paramContext);
        }
      }
    }
    return -1;
  }
  
  public static int getMixingPlayoutVolumeLevel()
  {
    return TXCAudioEngineJNI.nativeGetMixingPlayoutVolumeLevel();
  }
  
  private void handleAudioEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (paramInt == 10055)
    {
      a.a().a("timestamp_rollback_to_stable_samplerate", System.currentTimeMillis());
      return;
    }
    if (paramInt == 10056)
    {
      a.a().a("timestamp_rollback_to_stable_samplerate", 0L);
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "audio device restart when using stable samplerate");
    }
  }
  
  public static boolean hasTrae()
  {
    return has_trae;
  }
  
  public static void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      synchronized (mJitterEventListenerMapLock)
      {
        if (mJitterEventListenerMap.get(paramString1) != null)
        {
          localc = (c)((WeakReference)mJitterEventListenerMap.get(paramString1)).get();
          if (localc != null)
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onAudioJitterBufferNotify  cur state ");
            ((StringBuilder)???).append(paramInt);
            TXCLog.i("AudioEngine :TXCAudioEngine_java", ((StringBuilder)???).toString());
            localc.onAudioJitterBufferNotify(paramString1, paramInt, paramString2);
          }
          return;
        }
      }
      c localc = null;
    }
  }
  
  public static void onAudioPlayPcmData(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (mJitterDataListenerMapLock)
      {
        if (mJitterDataListenerMap.get(paramString) != null)
        {
          locald = (d)((WeakReference)mJitterDataListenerMap.get(paramString)).get();
          if (locald != null) {
            locald.onAudioPlayPcmData(paramString, paramArrayOfByte, paramLong, paramInt1, paramInt2);
          }
          return;
        }
      }
      d locald = null;
    }
  }
  
  public static void onCorePlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = mAudioCoreDataListener;
    if (localObject != null)
    {
      localObject = (d)((WeakReference)localObject).get();
      if (localObject != null) {
        ((d)localObject).onAudioPlayPcmData(null, paramArrayOfByte, paramLong, paramInt1, paramInt2);
      }
    }
  }
  
  public static void setAudioEarMonitoringVolume(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioEarMonitoringVolume: ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeSetAudioEarMonitoringVolume(paramInt);
  }
  
  public static void setAudioRoute(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioRoute: ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeSetAudioRoute(paramInt);
  }
  
  public static void setPlayoutDataListener(d paramd)
  {
    mAudioCoreDataListener = new WeakReference(paramd);
    boolean bool;
    if (paramd == null) {
      bool = false;
    } else {
      bool = true;
    }
    TXCAudioEngineJNI.nativeSetPlayoutDataListener(bool);
  }
  
  public static void setSystemVolumeType(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSystemVolumeType: ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeSetSystemVolumeType(paramInt);
  }
  
  public void EnableMixMode(boolean paramBoolean)
  {
    TXCAudioEngineJNI.nativeEnableMixMode(paramBoolean);
  }
  
  public void UnInitAudioDevice() {}
  
  public void addEventCallback(WeakReference<com.tencent.liteav.basic.b.a> paramWeakReference)
  {
    if (paramWeakReference == null) {
      return;
    }
    synchronized (this.mCallbackList)
    {
      this.mCallbackList.add(paramWeakReference);
      TXCAudioEngineJNI.nativeSetEventCallbackEnabled(true);
      return;
    }
  }
  
  public void clean() {}
  
  public void enableAutoRestartDevice(boolean paramBoolean)
  {
    TXCAudioEngineJNI.nativeEnableAutoRestartDevice(paramBoolean);
  }
  
  public boolean enableCaptureEOSMode(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableEosMode ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeEnableCaptureEOSMode(paramBoolean);
    return true;
  }
  
  public void enableEncodedDataCallback(boolean paramBoolean)
  {
    TXCAudioEngineJNI.nativeEnableEncodedDataCallback(paramBoolean);
  }
  
  public void enableEncodedDataPackWithTRAEHeaderCallback(boolean paramBoolean)
  {
    TXCAudioEngineJNI.nativeEnableEncodedDataPackWithTRAEHeaderCallback(paramBoolean);
  }
  
  public void enableSoftAEC(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableSoftAEC: enable = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" level = ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftAEC(paramInt);
  }
  
  public void enableSoftAGC(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableSoftAGC: enable = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" level = ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftAGC(paramInt);
  }
  
  public void enableSoftANS(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableSoftANS: enable = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" level = ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    if (!paramBoolean) {
      paramInt = 0;
    }
    TXCAudioEngineJNI.nativeSetSoftANS(paramInt);
  }
  
  public void forceCallbackMixedPlayAudioFrame(boolean paramBoolean)
  {
    TXCAudioEngineJNI.nativeForceCallbackMixedPlayAudioFrame(paramBoolean);
  }
  
  public int getAECType()
  {
    return 2;
  }
  
  public TXCAudioEncoderConfig getAudioEncoderConfig()
  {
    return TXCAudioEngineJNI.nativeGetEncoderConfig();
  }
  
  public int getEncoderChannels()
  {
    return TXCAudioEngineJNI.nativeGetEncoderChannels();
  }
  
  public int getEncoderSampleRate()
  {
    return TXCAudioEngineJNI.nativeGetEncoderSampleRate();
  }
  
  public int getPlayAECType()
  {
    if (has_trae) {
      return 2;
    }
    return 0;
  }
  
  public int getPlayChannels()
  {
    return 2;
  }
  
  public int getPlaySampleRate()
  {
    return 48000;
  }
  
  public int getRemotePlayoutVolumeLevel(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    return TXCAudioEngineJNI.nativeGetRemotePlayoutVolumeLevel(paramString);
  }
  
  public int getSoftwareCaptureVolumeLevel()
  {
    return TXCAudioEngineJNI.nativeGetSoftwareCaptureVolumeLevel();
  }
  
  public StatusBucket getStatus(int paramInt)
  {
    return TXCAudioEngineJNI.getStatus(paramInt);
  }
  
  public boolean isAudioDeviceCapturing()
  {
    boolean bool = TXCAudioEngineJNI.nativeIsAudioDeviceCapturing();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isRecording: ");
    localStringBuilder.append(bool);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    return bool;
  }
  
  public boolean isRemoteAudioPlaying(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return TXCAudioEngineJNI.nativeIsRemoteAudioPlaying(paramString);
  }
  
  public boolean muteLocalAudio(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRecordMute: ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeMuteLocalAudio(paramBoolean);
    return true;
  }
  
  public void muteRemoteAudio(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    TXCAudioEngineJNI.nativeMuteRemoteAudio(paramString, paramBoolean);
  }
  
  public void muteRemoteAudioInSpeaker(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    TXCAudioEngineJNI.nativeMuteRemoteAudioInSpeaker(paramString, paramBoolean);
  }
  
  public void onCallStateChanged(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_OFFHOOK!");
        TXCAudioEngineJNI.pauseAudioCapture(true);
        TXAudioEffectManagerImpl.getInstance().interruptAllMusics();
        this.mIsCallComed = true;
        return;
      }
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_RINGING!");
      return;
    }
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_IDLE!");
    if (this.mIsCallComed)
    {
      this.mIsCallComed = false;
      TXCAudioEngineJNI.resumeAudioCapture();
      TXAudioEffectManagerImpl.getInstance().recoverAllMusics();
    }
  }
  
  public void onError(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mCallbackList)
    {
      if (this.mCallbackList.size() <= 0) {
        return;
      }
      Iterator localIterator = this.mCallbackList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.liteav.basic.b.a locala = (com.tencent.liteav.basic.b.a)((WeakReference)localIterator.next()).get();
        if (locala != null) {
          localArrayList.add(locala);
        } else {
          localIterator.remove();
        }
      }
      if (this.mCallbackList.size() <= 0) {
        TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false);
      }
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        ((com.tencent.liteav.basic.b.a)((Iterator)???).next()).onError(paramString1, paramInt, paramString2, paramString3);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void onEvent(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    handleAudioEvent(paramString1, paramInt, paramString2, paramString3);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mCallbackList)
    {
      if (this.mCallbackList.size() <= 0) {
        return;
      }
      Iterator localIterator = this.mCallbackList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.liteav.basic.b.a locala = (com.tencent.liteav.basic.b.a)((WeakReference)localIterator.next()).get();
        if (locala != null) {
          localArrayList.add(locala);
        } else {
          localIterator.remove();
        }
      }
      if (this.mCallbackList.size() <= 0) {
        TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false);
      }
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        ((com.tencent.liteav.basic.b.a)((Iterator)???).next()).onEvent(paramString1, paramInt, paramString2, paramString3);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public int pauseAudioCapture(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseAudioCapture: ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.pauseAudioCapture(paramBoolean);
    return 0;
  }
  
  public void pauseLocalAudio() {}
  
  public int resumeAudioCapture()
  {
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "resumeRecord");
    TXCAudioEngineJNI.resumeAudioCapture();
    return 0;
  }
  
  public void resumeLocalAudio() {}
  
  public void sendCustomPCMData(com.tencent.liteav.basic.structs.a parama)
  {
    TXCAudioEngineJNI.sendCustomPCMData(parama);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    TXCAudioEngineJNI.sendCustomPCMData(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean setAudioCaptureDataListener(e parame)
  {
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordListener ");
    if (parame == null) {
      TXCAudioEngineJNI.setAudioCaptureDataListener(null);
    } else {
      TXCAudioEngineJNI.setAudioCaptureDataListener(new WeakReference(parame));
    }
    return true;
  }
  
  public void setAudioDumpingListener(TXCAudioEngineJNI.a parama)
  {
    TXCAudioEngineJNI.SetAudioDumpingListener(parama);
  }
  
  public boolean setAudioEncoderParam(int paramInt1, int paramInt2)
  {
    TXCAudioEngineJNI.nativeSetAudioEncoderParam(paramInt1, paramInt2);
    return true;
  }
  
  public void setAudioQuality(int paramInt1, int paramInt2)
  {
    TXCAudioEngineJNI.nativeSetAudioQuality(paramInt1, paramInt2);
  }
  
  public void setCaptureDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCaptureDataCallbackFormat: sampleRate-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" channels-");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" length-");
    localStringBuilder.append(paramInt3);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeSetCaptureDataCallbackFormat(paramInt1, paramInt2, paramInt3);
  }
  
  public void setEncoderChannels(int paramInt)
  {
    TXCAudioEngineJNI.nativeSetEncoderChannels(paramInt);
  }
  
  public boolean setEncoderFECPercent(float paramFloat)
  {
    TXCAudioEngineJNI.nativeSetEncoderFECPercent(paramFloat);
    return true;
  }
  
  public void setEncoderSampleRate(int paramInt)
  {
    TXCAudioEngineJNI.nativeSetEncoderSampleRate(paramInt);
  }
  
  public void setMaxSelectedPlayStreams(int paramInt)
  {
    TXCAudioEngineJNI.nativeSetMaxSelectedPlayStreams(paramInt);
  }
  
  public boolean setMixingPlayoutVolume(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayoutVolume: ");
    localStringBuilder.append(paramFloat);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeSetMixingPlayoutVolume(paramFloat);
    return true;
  }
  
  public void setPlayoutDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayoutDataCallbackFormat: sampleRate-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" channels-");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" length-");
    localStringBuilder.append(paramInt3);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeSetPlayoutDataCallbackFormat(paramInt1, paramInt2, paramInt3);
  }
  
  public void setRemoteAudioCacheParams(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    TXCAudioEngineJNI.nativeSetRemoteAudioCacheParams(paramString, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public void setRemoteAudioStreamEventListener(String paramString, c paramc)
  {
    if (paramString == null) {
      return;
    }
    synchronized (mJitterEventListenerMapLock)
    {
      mJitterEventListenerMap.put(paramString, new WeakReference(paramc));
      return;
    }
  }
  
  public void setRemotePlayoutVolume(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    TXCAudioEngineJNI.nativeSetRemotePlayoutVolume(paramString, paramInt);
  }
  
  public void setRemoteStreamDataCallbackFormat(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRemoteStreamDataCallbackFormat: id-");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" sampleRate-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" channels-");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" length-");
    localStringBuilder.append(paramInt3);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeSetRemoteStreamDataCallbackFormat(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean setReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setReverbType: ");
    localStringBuilder.append(paramTXVoiceReverbType.getNativeValue());
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeSetRecordReverb(paramTXVoiceReverbType.getNativeValue());
    return true;
  }
  
  public void setSetAudioEngineRemoteStreamDataListener(String paramString, d paramd)
  {
    if (paramString == null) {
      return;
    }
    synchronized (mJitterDataListenerMapLock)
    {
      mJitterDataListenerMap.put(paramString, new WeakReference(paramd));
      boolean bool;
      if (paramd == null) {
        bool = false;
      } else {
        bool = true;
      }
      TXCAudioEngineJNI.nativeSetAudioEngineRemoteStreamDataListener(paramString, bool);
      return;
    }
  }
  
  public boolean setSoftwareCaptureVolume(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRecordVolume: ");
    localStringBuilder.append(paramFloat);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeSetSoftwareCaptureVolume(paramFloat);
    return true;
  }
  
  public boolean setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVoiceChangerType ");
    localStringBuilder.append(paramTXVoiceChangerType.getNativeValue());
    TXCLog.i("AudioEngine :TXCAudioEngine_java", localStringBuilder.toString());
    TXCAudioEngineJNI.nativeSetCaptureVoiceChanger(paramTXVoiceChangerType.getNativeValue());
    return true;
  }
  
  public int startLocalAudio(int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startLocalAudio audioFormat:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", ((StringBuilder)localObject).toString());
    localObject = mContext;
    if (localObject == null)
    {
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "Please call CreateInstance fisrt!!!");
      return -901;
    }
    TXCAudioEngineJNI.InitTraeEngineLibrary((Context)localObject);
    TXCAudioEngineJNI.nativeStartLocalAudio(paramInt, paramBoolean);
    this.mDeviceIsRecording = true;
    return 0;
  }
  
  public int startLocalAudioDumping(int paramInt1, int paramInt2, String paramString)
  {
    return TXCAudioEngineJNI.nativeStartLocalAudioDumping(paramInt1, paramInt2, paramString);
  }
  
  public void startRemoteAudio(String paramString, boolean paramBoolean)
  {
    TXCAudioEngineJNI.nativeStartRemoteAudio(sInstance, paramBoolean, paramString);
    TXCAudioEngineJNI.nativeSetRemoteAudioJitterCycle(paramString, com.tencent.liteav.basic.d.c.a().a("Audio", "LIVE_JitterCycle"));
    TXCAudioEngineJNI.nativeSetRemoteAudioBlockThreshold(paramString, com.tencent.liteav.basic.d.c.a().a("Audio", "LoadingThreshold"));
  }
  
  public int stopLocalAudio()
  {
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "stopLocalAudio");
    TXCAudioEngineJNI.nativeStopLocalAudio();
    this.mDeviceIsRecording = false;
    return 0;
  }
  
  public void stopLocalAudioDumping() {}
  
  public void stopRemoteAudio(String paramString)
  {
    if (paramString == null) {
      return;
    }
    TXCAudioEngineJNI.nativeStopRemoteAudio(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCAudioEngine
 * JD-Core Version:    0.7.0.1
 */