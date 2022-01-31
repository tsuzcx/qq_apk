package com.tencent.TMG.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.TMG.audio.TraeAudioManager;
import com.tencent.TMG.audio.TraeAudioSession;
import com.tencent.TMG.audio.TraeAudioSession.ITraeAudioCallback;
import com.tencent.TMG.utils.NioUtils;
import com.tencent.TMG.utils.PhoneStatusMonitor;
import com.tencent.TMG.utils.PhoneStatusMonitor.PhoneStatusListener;
import java.nio.ByteBuffer;

public class AVAudioCtrl
{
  public static final int AUDIO_CODEC_TYPE_CELT = 4103;
  public static final int AUDIO_CODEC_TYPE_SILK = 4102;
  public static final int AUDIO_DEVICE_CLOSE = 0;
  public static final int AUDIO_DEVICE_NOT_EXIST = 3;
  public static final int AUDIO_DEVICE_OPEN = 1;
  public static final int AUDIO_DEVICE_OPERATING = 2;
  public static final int AUDIO_ERROR = -1;
  public static final int OUTPUT_MODE_HEADSET = 0;
  public static final int OUTPUT_MODE_SPEAKER = 1;
  static final String TAG = "SdkJni";
  private ByteBuffer audioDataByteBuffer = null;
  private boolean isEnableExternalAudioDataInput = false;
  private boolean isSystemApp = false;
  private Context mAppContext;
  private TraeAudioSession mAudioSession = null;
  private String mAudioSessionType = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  private String mAudioStateBeforePhoneCall = "DEVICE_NONE";
  private Delegate mDelegate = null;
  private String[] mDeviceList;
  boolean mIsCalling = false;
  boolean mIsPauseByUser = false;
  private PhoneStatusMonitor.PhoneStatusListener mPhoneStatusListener;
  private PhoneStatusMonitor mPhoneStatusMonitor;
  private String mSelectedDeviceName = "";
  private int mVoiceStreamType = 0;
  int nativeObj = 0;
  
  private native int nativeChangeAudioCategory(int paramInt);
  
  private native boolean nativeEnableLoopback(boolean paramBoolean);
  
  private native int nativeFillExternalAudioFrame(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int GetAudioCategory();
  
  public native int GetAudioDataDBVolume(int paramInt);
  
  public void PauseAudioByUser()
  {
    this.mIsPauseByUser = true;
    pauseAudio();
  }
  
  public void ResumeAudioByUser()
  {
    this.mIsPauseByUser = false;
    resumeAudio();
  }
  
  public native int SetAudioDataDBVolume(int paramInt1, int paramInt2);
  
  public int changeAudioCategory(int paramInt)
  {
    return nativeChangeAudioCategory(paramInt);
  }
  
  public void enableExternalAudioDataInput(boolean paramBoolean)
  {
    try
    {
      if (this.audioDataByteBuffer != null)
      {
        NioUtils.destroyDirectByteBuffer(this.audioDataByteBuffer);
        this.audioDataByteBuffer = null;
      }
      this.isEnableExternalAudioDataInput = paramBoolean;
      return;
    }
    finally {}
  }
  
  public boolean enableLoopback(boolean paramBoolean)
  {
    return nativeEnableLoopback(paramBoolean);
  }
  
  @Deprecated
  public boolean enableMic(boolean paramBoolean)
  {
    return enableMic(paramBoolean, null);
  }
  
  public boolean enableMic(boolean paramBoolean, EnableMicCompleteCallback paramEnableMicCompleteCallback)
  {
    if (this.mIsCalling) {
      return false;
    }
    EnableMicCompleteCallback localEnableMicCompleteCallback = paramEnableMicCompleteCallback;
    if (paramEnableMicCompleteCallback == null) {
      localEnableMicCompleteCallback = new EnableMicCompleteCallback();
    }
    return nativeEnableMic(paramBoolean, localEnableMicCompleteCallback);
  }
  
  public boolean enablePreview(boolean paramBoolean, int paramInt)
  {
    if (this.mIsCalling) {
      return false;
    }
    return nativeEnablePreview(this.mAppContext, paramBoolean, paramInt);
  }
  
  @Deprecated
  public boolean enableSpeaker(boolean paramBoolean)
  {
    return enableSpeaker(paramBoolean, null);
  }
  
  public boolean enableSpeaker(boolean paramBoolean, EnableSpeakerCompleteCallback paramEnableSpeakerCompleteCallback)
  {
    if (this.mIsCalling) {
      return false;
    }
    EnableSpeakerCompleteCallback localEnableSpeakerCompleteCallback = paramEnableSpeakerCompleteCallback;
    if (paramEnableSpeakerCompleteCallback == null) {
      localEnableSpeakerCompleteCallback = new EnableSpeakerCompleteCallback();
    }
    return nativeEnableSpeaker(this.mAppContext, paramBoolean, localEnableSpeakerCompleteCallback);
  }
  
  /* Error */
  public int fillExternalAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 124	com/tencent/TMG/sdk/AVAudioCtrl:isEnableExternalAudioDataInput	Z
    //   6: ifeq +87 -> 93
    //   9: aload_0
    //   10: getfield 122	com/tencent/TMG/sdk/AVAudioCtrl:audioDataByteBuffer	Ljava/nio/ByteBuffer;
    //   13: ifnull +27 -> 40
    //   16: aload_0
    //   17: getfield 122	com/tencent/TMG/sdk/AVAudioCtrl:audioDataByteBuffer	Ljava/nio/ByteBuffer;
    //   20: invokevirtual 211	java/nio/ByteBuffer:capacity	()I
    //   23: iload_2
    //   24: if_icmpeq +16 -> 40
    //   27: aload_0
    //   28: getfield 122	com/tencent/TMG/sdk/AVAudioCtrl:audioDataByteBuffer	Ljava/nio/ByteBuffer;
    //   31: invokestatic 174	com/tencent/TMG/utils/NioUtils:destroyDirectByteBuffer	(Ljava/nio/ByteBuffer;)Z
    //   34: pop
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 122	com/tencent/TMG/sdk/AVAudioCtrl:audioDataByteBuffer	Ljava/nio/ByteBuffer;
    //   40: aload_0
    //   41: getfield 122	com/tencent/TMG/sdk/AVAudioCtrl:audioDataByteBuffer	Ljava/nio/ByteBuffer;
    //   44: ifnonnull +11 -> 55
    //   47: aload_0
    //   48: iload_2
    //   49: invokestatic 215	com/tencent/TMG/utils/NioUtils:createDirectByteBuffer	(I)Ljava/nio/ByteBuffer;
    //   52: putfield 122	com/tencent/TMG/sdk/AVAudioCtrl:audioDataByteBuffer	Ljava/nio/ByteBuffer;
    //   55: aload_0
    //   56: getfield 122	com/tencent/TMG/sdk/AVAudioCtrl:audioDataByteBuffer	Ljava/nio/ByteBuffer;
    //   59: aload_1
    //   60: iconst_0
    //   61: iload_2
    //   62: invokevirtual 219	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   65: pop
    //   66: aload_0
    //   67: getfield 122	com/tencent/TMG/sdk/AVAudioCtrl:audioDataByteBuffer	Ljava/nio/ByteBuffer;
    //   70: invokevirtual 223	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   73: pop
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 122	com/tencent/TMG/sdk/AVAudioCtrl:audioDataByteBuffer	Ljava/nio/ByteBuffer;
    //   79: iload_2
    //   80: iload_3
    //   81: iload 4
    //   83: iload 5
    //   85: invokespecial 225	com/tencent/TMG/sdk/AVAudioCtrl:nativeFillExternalAudioFrame	(Ljava/nio/ByteBuffer;IIII)I
    //   88: istore_2
    //   89: aload_0
    //   90: monitorexit
    //   91: iload_2
    //   92: ireturn
    //   93: iconst_1
    //   94: istore_2
    //   95: goto -6 -> 89
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	AVAudioCtrl
    //   0	103	1	paramArrayOfByte	byte[]
    //   0	103	2	paramInt1	int
    //   0	103	3	paramInt2	int
    //   0	103	4	paramInt3	int
    //   0	103	5	paramInt4	int
    // Exception table:
    //   from	to	target	type
    //   2	40	98	finally
    //   40	55	98	finally
    //   55	89	98	finally
  }
  
  public native AudioFrameDesc getAudioDataFormat(int paramInt);
  
  public native float getAudioDataVolume(int paramInt);
  
  public int getAudioOutputMode()
  {
    int j = 0;
    int i;
    if (this.mSelectedDeviceName.endsWith("DEVICE_SPEAKERPHONE")) {
      i = 1;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (this.mSelectedDeviceName.endsWith("DEVICE_WIREDHEADSET"));
        i = j;
      } while (this.mSelectedDeviceName.endsWith("DEVICE_BLUETOOTHHEADSET"));
      i = j;
    } while (!this.mSelectedDeviceName.endsWith("DEVICE_EARPHONE"));
    return 0;
  }
  
  public native int getDynamicVolume();
  
  public native int getDynamicVolumeById(String paramString);
  
  public int getMicState()
  {
    return nativeGetMicState();
  }
  
  public native String getQualityTips();
  
  public int getSpeakerState()
  {
    return nativeGetSpeakerState();
  }
  
  public native int getVolume();
  
  boolean init(Context paramContext, int paramInt)
  {
    if (!initNative(paramInt)) {
      return false;
    }
    this.mAppContext = paramContext;
    TraeAudioManager.init(paramContext);
    if (this.mAudioSession == null)
    {
      this.mAudioSession = new TraeAudioSession(paramContext, new TraeAudioSession.ITraeAudioCallback()
      {
        public void onAudioRouteSwitchEnd(String paramAnonymousString, long paramAnonymousLong) {}
        
        public void onAudioRouteSwitchStart(String paramAnonymousString1, String paramAnonymousString2) {}
        
        public void onConnectDeviceRes(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          Log.e("SdkJni", "onConnectDeviceRes" + paramAnonymousString);
          if ((paramAnonymousInt != 0) || (!paramAnonymousBoolean)) {}
          while (!paramAnonymousBoolean) {
            return;
          }
          AVAudioCtrl.access$002(AVAudioCtrl.this, paramAnonymousString);
        }
        
        public void onDeviceChangabledUpdate(boolean paramAnonymousBoolean) {}
        
        public void onDeviceListUpdate(String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          Log.e("SdkJni", "Connect Device:" + paramAnonymousString1);
          AVAudioCtrl.access$002(AVAudioCtrl.this, paramAnonymousString1);
          AVAudioCtrl.access$102(AVAudioCtrl.this, paramAnonymousArrayOfString);
          if (AVAudioCtrl.this.mDelegate != null)
          {
            paramAnonymousArrayOfString = AVAudioCtrl.this.mDelegate;
            if (!AVAudioCtrl.this.mSelectedDeviceName.endsWith("DEVICE_SPEAKERPHONE")) {
              break label151;
            }
          }
          label151:
          for (int i = 1;; i = 0)
          {
            paramAnonymousArrayOfString.onOutputModeChange(i);
            if (!AVAudioCtrl.this.mAudioStateBeforePhoneCall.equals("DEVICE_NONE"))
            {
              Log.e("SdkJni", "!mAudioStateBeforePhoneCall.equals(TraeAudioManager.DEVICE_NONE");
              if (!paramAnonymousString1.equals(AVAudioCtrl.this.mAudioStateBeforePhoneCall)) {
                AVAudioCtrl.this.mAudioSession.connectDevice(AVAudioCtrl.this.mAudioStateBeforePhoneCall);
              }
              AVAudioCtrl.access$302(AVAudioCtrl.this, "DEVICE_NONE");
            }
            return;
          }
        }
        
        public void onGetConnectedDeviceRes(int paramAnonymousInt, String paramAnonymousString)
        {
          Log.e("SdkJni", "onGetConnectedDeviceRes" + paramAnonymousString);
        }
        
        public void onGetConnectingDeviceRes(int paramAnonymousInt, String paramAnonymousString)
        {
          Log.e("SdkJni", "onGetConnectingDeviceRes" + paramAnonymousString);
        }
        
        public void onGetDeviceListRes(int paramAnonymousInt, String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          Log.e("SdkJni", "onGetDeviceListRes" + paramAnonymousString1);
          if (paramAnonymousInt != 0) {
            return;
          }
          AVAudioCtrl.access$102(AVAudioCtrl.this, paramAnonymousArrayOfString);
          AVAudioCtrl.access$002(AVAudioCtrl.this, paramAnonymousString1);
        }
        
        public void onGetStreamTypeRes(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AVAudioCtrl.access$502(AVAudioCtrl.this, paramAnonymousInt2);
        }
        
        public void onIsDeviceChangabledRes(int paramAnonymousInt, boolean paramAnonymousBoolean) {}
        
        public void onRingCompletion(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onServiceStateUpdate(boolean paramAnonymousBoolean) {}
        
        public void onStreamTypeUpdate(int paramAnonymousInt)
        {
          AVAudioCtrl.access$502(AVAudioCtrl.this, paramAnonymousInt);
        }
        
        public void onVoicecallPreprocessRes(int paramAnonymousInt) {}
      });
      this.mAudioSession.startService(this.mAudioSessionType);
      this.mAudioSession.getDeviceList();
    }
    if (this.mPhoneStatusListener == null) {
      this.mPhoneStatusListener = new MyPhoneStatusListener();
    }
    if (this.mPhoneStatusMonitor == null) {
      this.mPhoneStatusMonitor = new PhoneStatusMonitor(paramContext, this.mPhoneStatusListener);
    }
    return true;
  }
  
  native boolean initNative(int paramInt);
  
  native boolean nativeEnableMic(boolean paramBoolean, EnableMicCompleteCallback paramEnableMicCompleteCallback);
  
  native boolean nativeEnablePreview(Context paramContext, boolean paramBoolean, int paramInt);
  
  native boolean nativeEnableSpeaker(Context paramContext, boolean paramBoolean, EnableSpeakerCompleteCallback paramEnableSpeakerCompleteCallback);
  
  native int nativeGetMicState();
  
  native int nativeGetSpeakerState();
  
  native int nativeSetSpeakerAudioVolume(String[] paramArrayOfString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, SetSpeakerVolumeCompleteCallback paramSetSpeakerVolumeCompleteCallback);
  
  public native void pauseAudio();
  
  @Deprecated
  public native int registAudioDataCallback(int paramInt, RegistAudioDataCompleteCallback paramRegistAudioDataCompleteCallback);
  
  public native int registAudioDataCallbackWithByteBuffer(int paramInt, RegistAudioDataCompleteCallbackWithByteBuffer paramRegistAudioDataCompleteCallbackWithByteBuffer);
  
  public native void resumeAudio();
  
  public native int setAudioDataFormat(int paramInt, AudioFrameDesc paramAudioFrameDesc);
  
  public native int setAudioDataVolume(int paramInt, float paramFloat);
  
  public boolean setAudioOutputMode(int paramInt)
  {
    if (paramInt == 0) {
      if ((this.mDeviceList != null) && (this.mAudioSession != null)) {}
    }
    label24:
    label69:
    while ((1 != paramInt) || (this.mAudioSession == null))
    {
      return false;
      int i = 0;
      int j = 0;
      paramInt = i;
      if (j < this.mDeviceList.length)
      {
        paramInt = i;
        if (i == 0)
        {
          if (!"DEVICE_WIREDHEADSET".equals(this.mDeviceList[j])) {
            break label165;
          }
          this.mAudioSession.connectDevice("DEVICE_WIREDHEADSET");
          paramInt = 1;
        }
      }
      j = 0;
      i = paramInt;
      if (j < this.mDeviceList.length)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          if (!"DEVICE_BLUETOOTHHEADSET".equals(this.mDeviceList[j])) {
            break label172;
          }
          this.mAudioSession.connectDevice("DEVICE_BLUETOOTHHEADSET");
          i = 1;
        }
      }
      j = 0;
      for (;;)
      {
        paramInt = i;
        if (j < this.mDeviceList.length)
        {
          paramInt = i;
          if (i == 0)
          {
            if (!"DEVICE_EARPHONE".equals(this.mDeviceList[j])) {
              break label179;
            }
            this.mAudioSession.connectDevice("DEVICE_EARPHONE");
            paramInt = 1;
          }
        }
        i = paramInt;
        if (paramInt == 0) {
          break;
        }
        return true;
        j += 1;
        break label24;
        j += 1;
        break label69;
        j += 1;
      }
    }
    label165:
    label172:
    label179:
    this.mAudioSession.connectDevice("DEVICE_SPEAKERPHONE");
    return true;
  }
  
  public void setDelegate(Delegate paramDelegate)
  {
    this.mDelegate = paramDelegate;
  }
  
  public void setIsSystemApp(boolean paramBoolean)
  {
    this.isSystemApp = paramBoolean;
  }
  
  public int setSpeakerAudioVolume(String[] paramArrayOfString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, SetSpeakerVolumeCompleteCallback paramSetSpeakerVolumeCompleteCallback)
  {
    if (this.mIsCalling) {
      return 1;
    }
    if (this.mAudioSession != null) {
      return nativeSetSpeakerAudioVolume(paramArrayOfString, paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3, paramSetSpeakerVolumeCompleteCallback);
    }
    Log.e("SdkJni", "AVAudioCtrl setSpeakerAudioVolume mAudioSession = null");
    return 1;
  }
  
  public native int setVoiceType(int paramInt);
  
  public void startTRAEService()
  {
    if (this.mAudioSession != null)
    {
      this.mAudioSession.startService(this.mAudioSessionType);
      Log.e("SdkJni", "AVAudioCtrl startTRAEService succ");
      return;
    }
    Log.e("SdkJni", "AVAudioCtrl startTRAEService mAudioSession = null");
  }
  
  public void startTRAEServiceWhenIsSystemApp()
  {
    if (this.mAudioSession != null)
    {
      resumeAudio();
      this.mAudioSession.startService(this.mAudioSessionType);
      Log.e("SdkJni", "AVAudioCtrl startTRAEServiceWhenIsSystemApp succ");
      return;
    }
    Log.e("SdkJni", "AVAudioCtrl startTRAEServiceWhenIsSystemApp mAudioSession = null");
  }
  
  public void stopTRAEService()
  {
    if (this.mAudioSession != null)
    {
      Log.e("SdkJni", "AVAudioCtrl stopTRAEService succ");
      this.mAudioSession.stopService();
      return;
    }
    Log.e("SdkJni", "AVAudioCtrl stopTRAEService mAudioSession = null");
  }
  
  public void stopTRAEServiceWhenIsSystemApp()
  {
    if (this.mAudioSession != null)
    {
      Log.e("SdkJni", "AVAudioCtrl stopTRAEServiceWhenIsSystemApp succ");
      pauseAudio();
      this.mAudioSession.stopService();
      return;
    }
    Log.e("SdkJni", "AVAudioCtrl stopTRAEServiceWhenIsSystemApp mAudioSession = null");
  }
  
  /* Error */
  void uninit()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   4: ifnull +31 -> 35
    //   7: aload_0
    //   8: getfield 110	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   11: aconst_null
    //   12: invokevirtual 356	com/tencent/TMG/audio/TraeAudioSession:setCallback	(Lcom/tencent/TMG/audio/TraeAudioSession$ITraeAudioCallback;)V
    //   15: aload_0
    //   16: getfield 110	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   19: invokevirtual 342	com/tencent/TMG/audio/TraeAudioSession:stopService	()I
    //   22: pop
    //   23: aload_0
    //   24: getfield 110	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   27: invokevirtual 359	com/tencent/TMG/audio/TraeAudioSession:release	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 110	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   35: invokestatic 361	com/tencent/TMG/audio/TraeAudioManager:uninit	()V
    //   38: aload_0
    //   39: getfield 288	com/tencent/TMG/sdk/AVAudioCtrl:mPhoneStatusMonitor	Lcom/tencent/TMG/utils/PhoneStatusMonitor;
    //   42: ifnull +15 -> 57
    //   45: aload_0
    //   46: getfield 288	com/tencent/TMG/sdk/AVAudioCtrl:mPhoneStatusMonitor	Lcom/tencent/TMG/utils/PhoneStatusMonitor;
    //   49: invokevirtual 362	com/tencent/TMG/utils/PhoneStatusMonitor:uninit	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 288	com/tencent/TMG/sdk/AVAudioCtrl:mPhoneStatusMonitor	Lcom/tencent/TMG/utils/PhoneStatusMonitor;
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 285	com/tencent/TMG/sdk/AVAudioCtrl:mPhoneStatusListener	Lcom/tencent/TMG/utils/PhoneStatusMonitor$PhoneStatusListener;
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 100	com/tencent/TMG/sdk/AVAudioCtrl:mIsPauseByUser	Z
    //   67: aload_0
    //   68: invokevirtual 366	com/tencent/TMG/sdk/AVAudioCtrl:uninitNative	()Z
    //   71: pop
    //   72: return
    //   73: astore_1
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 110	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   79: goto -44 -> 35
    //   82: astore_1
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 110	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	AVAudioCtrl
    //   73	1	1	localException	java.lang.Exception
    //   82	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	30	73	java/lang/Exception
    //   15	30	82	finally
  }
  
  native boolean uninitNative();
  
  public native int unregistAudioDataCallback(int paramInt);
  
  public native int unregistAudioDataCallbackAll();
  
  public static class AudioDataSourceType
  {
    public static final int AUDIO_DATA_SOURCE_AACRAWSTREAM = 8;
    public static final int AUDIO_DATA_SOURCE_END = 9;
    public static final int AUDIO_DATA_SOURCE_MIC = 0;
    public static final int AUDIO_DATA_SOURCE_MIXTOPLAY = 3;
    public static final int AUDIO_DATA_SOURCE_MIXTOSEND = 1;
    public static final int AUDIO_DATA_SOURCE_NETSTREM = 5;
    public static final int AUDIO_DATA_SOURCE_PLAY = 4;
    public static final int AUDIO_DATA_SOURCE_SEND = 2;
    public static final int AUDIO_DATA_SOURCE_SyncMixToSend = 7;
    public static final int AUDIO_DATA_SOURCE_VOICEDISPOSE = 6;
  }
  
  @Deprecated
  public static class AudioFrame
    extends AVAudioCtrl.AudioFrameWithoutData
  {
    public byte[] data;
  }
  
  public static class AudioFrameDesc
  {
    public int bits;
    public int channelNum;
    public int sampleRate;
    public int srcTye;
  }
  
  public static class AudioFrameWithByteBuffer
    extends AVAudioCtrl.AudioFrameWithoutData
  {
    public ByteBuffer data;
  }
  
  static class AudioFrameWithoutData
  {
    public int bits;
    public int channelNum;
    public int dataLen;
    public String identifier;
    public int sampleRate;
    public int srcTye;
    public long timeStamp;
  }
  
  public static class Delegate
  {
    static final String TAG = "SdkJni";
    
    protected void onOutputModeChange(int paramInt)
    {
      Log.d("SdkJni", "onOutputModeChange outputMode = " + paramInt);
    }
  }
  
  public static class EnableMicCompleteCallback
  {
    static final String TAG = "SdkJni";
    
    protected void onComplete(boolean paramBoolean, int paramInt)
    {
      Log.d("SdkJni", "EnableMicCompleteCallback.OnComplete. result = " + paramInt);
    }
  }
  
  public static class EnableSpeakerCompleteCallback
  {
    static final String TAG = "SdkJni";
    
    protected void onComplete(boolean paramBoolean, int paramInt)
    {
      Log.d("SdkJni", "EnableSpeakerCompleteCallback.OnComplete. enable = " + paramBoolean + "  result = " + paramInt);
    }
  }
  
  class MyPhoneStatusListener
    implements PhoneStatusMonitor.PhoneStatusListener
  {
    MyPhoneStatusListener() {}
    
    public void onCallStateChanged(boolean paramBoolean)
    {
      if (AVAudioCtrl.this.isSystemApp) {
        Log.e("SdkJni", "onCallStateChanged isSystemApp return");
      }
      do
      {
        do
        {
          do
          {
            return;
            Log.e("SdkJni", "onCallStateChanged isCalling: " + paramBoolean);
            AVAudioCtrl.this.mIsCalling = paramBoolean;
            if (!paramBoolean) {
              break;
            }
          } while (AVAudioCtrl.this.mIsPauseByUser);
          AVAudioCtrl.this.pauseAudio();
          Log.e("SdkJni", "MyPhoneStatusListener iscalling ");
        } while (AVAudioCtrl.this.mAudioSession == null);
        Log.e("SdkJni", "MyPhoneStatusListener stopService ");
        AVAudioCtrl.this.mAudioSession.stopService();
        return;
        Log.e("SdkJni", "MyPhoneStatusListener notcalling ");
      } while (AVAudioCtrl.this.mIsPauseByUser);
      if (AVAudioCtrl.this.mAudioSession != null)
      {
        AVAudioCtrl.this.mAudioSession.startService(AVAudioCtrl.this.mAudioSessionType);
        Log.e("SdkJni", "MyPhoneStatusListener startService ");
      }
      AVAudioCtrl.this.resumeAudio();
    }
  }
  
  @Deprecated
  public static class RegistAudioDataCompleteCallback
  {
    static final String TAG = "SdkJni";
    
    protected int onComplete(AVAudioCtrl.AudioFrame paramAudioFrame, int paramInt)
    {
      return 1;
    }
  }
  
  public static abstract interface RegistAudioDataCompleteCallbackWithByteBuffer
  {
    public abstract int onComplete(AVAudioCtrl.AudioFrameWithByteBuffer paramAudioFrameWithByteBuffer, int paramInt);
  }
  
  public static class SetSpeakerVolumeCompleteCallback
  {
    static final String TAG = "SdkJni";
    
    protected void onComplete(int paramInt)
    {
      Log.e("SdkJni", "SetSpeakerVolumeCompleteCallback.OnComplete， result = " + paramInt);
    }
  }
  
  public static class VoiceType
  {
    public static final int VOICE_TYPE_CAGED_ANIMAL = 7;
    public static final int VOICE_TYPE_DEAD_FATBOY = 10;
    public static final int VOICE_TYPE_DIALECT = 8;
    public static final int VOICE_TYPE_HEAVY_GARTEN = 5;
    public static final int VOICE_TYPE_INTANGIBLE = 3;
    public static final int VOICE_TYPE_KINDER_GARTEN = 4;
    public static final int VOICE_TYPE_LOLITA = 1;
    public static final int VOICE_TYPE_METAL_ROBOT = 9;
    public static final int VOICE_TYPE_OPTIMUS_PRIME = 6;
    public static final int VOICE_TYPE_ORIGINAL_SOUND = 0;
    public static final int VOICE_TYPE_UNCLE = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioCtrl
 * JD-Core Version:    0.7.0.1
 */