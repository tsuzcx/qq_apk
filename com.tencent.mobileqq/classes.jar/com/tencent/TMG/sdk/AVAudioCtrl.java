package com.tencent.TMG.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.TMG.audio.TraeAudioManager;
import com.tencent.TMG.audio.TraeAudioSession;
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
  private AVAudioCtrl.Delegate mDelegate = null;
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
  
  public boolean enableMic(boolean paramBoolean, AVAudioCtrl.EnableMicCompleteCallback paramEnableMicCompleteCallback)
  {
    if (this.mIsCalling) {
      return false;
    }
    AVAudioCtrl.EnableMicCompleteCallback localEnableMicCompleteCallback = paramEnableMicCompleteCallback;
    if (paramEnableMicCompleteCallback == null) {
      localEnableMicCompleteCallback = new AVAudioCtrl.EnableMicCompleteCallback();
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
  
  public boolean enableSpeaker(boolean paramBoolean, AVAudioCtrl.EnableSpeakerCompleteCallback paramEnableSpeakerCompleteCallback)
  {
    if (this.mIsCalling) {
      return false;
    }
    AVAudioCtrl.EnableSpeakerCompleteCallback localEnableSpeakerCompleteCallback = paramEnableSpeakerCompleteCallback;
    if (paramEnableSpeakerCompleteCallback == null) {
      localEnableSpeakerCompleteCallback = new AVAudioCtrl.EnableSpeakerCompleteCallback();
    }
    return nativeEnableSpeaker(this.mAppContext, paramBoolean, localEnableSpeakerCompleteCallback);
  }
  
  public int fillExternalAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      if (this.isEnableExternalAudioDataInput)
      {
        if ((this.audioDataByteBuffer != null) && (this.audioDataByteBuffer.capacity() != paramInt1))
        {
          NioUtils.destroyDirectByteBuffer(this.audioDataByteBuffer);
          this.audioDataByteBuffer = null;
        }
        if (this.audioDataByteBuffer == null) {
          this.audioDataByteBuffer = NioUtils.createDirectByteBuffer(paramInt1);
        }
        this.audioDataByteBuffer.put(paramArrayOfByte, 0, paramInt1);
        this.audioDataByteBuffer.clear();
        paramInt1 = nativeFillExternalAudioFrame(this.audioDataByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4);
        return paramInt1;
      }
      return 1;
    }
    finally {}
  }
  
  public native AVAudioCtrl.AudioFrameDesc getAudioDataFormat(int paramInt);
  
  public native float getAudioDataVolume(int paramInt);
  
  public int getAudioOutputMode()
  {
    if (this.mSelectedDeviceName.endsWith("DEVICE_SPEAKERPHONE")) {
      return 1;
    }
    if (this.mSelectedDeviceName.endsWith("DEVICE_WIREDHEADSET")) {
      return 0;
    }
    if (this.mSelectedDeviceName.endsWith("DEVICE_BLUETOOTHHEADSET")) {
      return 0;
    }
    this.mSelectedDeviceName.endsWith("DEVICE_EARPHONE");
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
      this.mAudioSession = new TraeAudioSession(paramContext, new AVAudioCtrl.1(this));
      this.mAudioSession.startService(this.mAudioSessionType);
      this.mAudioSession.getDeviceList();
    }
    if (this.mPhoneStatusListener == null) {
      this.mPhoneStatusListener = new AVAudioCtrl.MyPhoneStatusListener(this);
    }
    if (this.mPhoneStatusMonitor == null) {
      this.mPhoneStatusMonitor = new PhoneStatusMonitor(paramContext, this.mPhoneStatusListener);
    }
    return true;
  }
  
  native boolean initNative(int paramInt);
  
  native boolean nativeEnableMic(boolean paramBoolean, AVAudioCtrl.EnableMicCompleteCallback paramEnableMicCompleteCallback);
  
  native boolean nativeEnablePreview(Context paramContext, boolean paramBoolean, int paramInt);
  
  native boolean nativeEnableSpeaker(Context paramContext, boolean paramBoolean, AVAudioCtrl.EnableSpeakerCompleteCallback paramEnableSpeakerCompleteCallback);
  
  native int nativeGetMicState();
  
  native int nativeGetSpeakerState();
  
  native int nativeSetSpeakerAudioVolume(String[] paramArrayOfString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, AVAudioCtrl.SetSpeakerVolumeCompleteCallback paramSetSpeakerVolumeCompleteCallback);
  
  public native void pauseAudio();
  
  @Deprecated
  public native int registAudioDataCallback(int paramInt, AVAudioCtrl.RegistAudioDataCompleteCallback paramRegistAudioDataCompleteCallback);
  
  public native int registAudioDataCallbackWithByteBuffer(int paramInt, AVAudioCtrl.RegistAudioDataCompleteCallbackWithByteBuffer paramRegistAudioDataCompleteCallbackWithByteBuffer);
  
  public native void resumeAudio();
  
  public native int setAudioDataFormat(int paramInt, AVAudioCtrl.AudioFrameDesc paramAudioFrameDesc);
  
  public native int setAudioDataVolume(int paramInt, float paramFloat);
  
  public boolean setAudioOutputMode(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      if (this.mDeviceList != null)
      {
        if (this.mAudioSession == null) {
          return false;
        }
        int i = 0;
        do
        {
          int j = 0;
          for (;;)
          {
            localObject = this.mDeviceList;
            paramInt = i;
            if (j >= localObject.length) {
              break;
            }
            paramInt = i;
            if (i != 0) {
              break;
            }
            if ("DEVICE_WIREDHEADSET".equals(localObject[j]))
            {
              this.mAudioSession.connectDevice("DEVICE_WIREDHEADSET");
              paramInt = 1;
              break;
            }
            j += 1;
          }
          j = 0;
          for (;;)
          {
            localObject = this.mDeviceList;
            i = paramInt;
            if (j >= localObject.length) {
              break;
            }
            i = paramInt;
            if (paramInt != 0) {
              break;
            }
            if ("DEVICE_BLUETOOTHHEADSET".equals(localObject[j]))
            {
              this.mAudioSession.connectDevice("DEVICE_BLUETOOTHHEADSET");
              i = 1;
              break;
            }
            j += 1;
          }
          j = 0;
          for (;;)
          {
            localObject = this.mDeviceList;
            paramInt = i;
            if (j >= localObject.length) {
              break;
            }
            paramInt = i;
            if (i != 0) {
              break;
            }
            if ("DEVICE_EARPHONE".equals(localObject[j]))
            {
              this.mAudioSession.connectDevice("DEVICE_EARPHONE");
              paramInt = 1;
              break;
            }
            j += 1;
          }
          i = paramInt;
        } while (paramInt == 0);
        return true;
      }
      return false;
    }
    if (1 == paramInt)
    {
      localObject = this.mAudioSession;
      if (localObject == null) {
        return false;
      }
      ((TraeAudioSession)localObject).connectDevice("DEVICE_SPEAKERPHONE");
      return true;
    }
    return false;
  }
  
  public void setDelegate(AVAudioCtrl.Delegate paramDelegate)
  {
    this.mDelegate = paramDelegate;
  }
  
  public void setIsSystemApp(boolean paramBoolean)
  {
    this.isSystemApp = paramBoolean;
  }
  
  public int setSpeakerAudioVolume(String[] paramArrayOfString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, AVAudioCtrl.SetSpeakerVolumeCompleteCallback paramSetSpeakerVolumeCompleteCallback)
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
    TraeAudioSession localTraeAudioSession = this.mAudioSession;
    if (localTraeAudioSession != null)
    {
      localTraeAudioSession.startService(this.mAudioSessionType);
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
    //   1: getfield 69	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +39 -> 45
    //   9: aload_1
    //   10: aconst_null
    //   11: invokevirtual 323	com/tencent/TMG/audio/TraeAudioSession:setCallback	(Lcom/tencent/TMG/audio/TraeAudioSession$ITraeAudioCallback;)V
    //   14: aload_0
    //   15: getfield 69	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   18: invokevirtual 309	com/tencent/TMG/audio/TraeAudioSession:stopService	()I
    //   21: pop
    //   22: aload_0
    //   23: getfield 69	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   26: invokevirtual 326	com/tencent/TMG/audio/TraeAudioSession:release	()V
    //   29: goto +11 -> 40
    //   32: astore_1
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 69	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   38: aload_1
    //   39: athrow
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 69	com/tencent/TMG/sdk/AVAudioCtrl:mAudioSession	Lcom/tencent/TMG/audio/TraeAudioSession;
    //   45: invokestatic 328	com/tencent/TMG/audio/TraeAudioManager:uninit	()V
    //   48: aload_0
    //   49: getfield 255	com/tencent/TMG/sdk/AVAudioCtrl:mPhoneStatusMonitor	Lcom/tencent/TMG/utils/PhoneStatusMonitor;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull +12 -> 66
    //   57: aload_1
    //   58: invokevirtual 329	com/tencent/TMG/utils/PhoneStatusMonitor:uninit	()V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 255	com/tencent/TMG/sdk/AVAudioCtrl:mPhoneStatusMonitor	Lcom/tencent/TMG/utils/PhoneStatusMonitor;
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 250	com/tencent/TMG/sdk/AVAudioCtrl:mPhoneStatusListener	Lcom/tencent/TMG/utils/PhoneStatusMonitor$PhoneStatusListener;
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 59	com/tencent/TMG/sdk/AVAudioCtrl:mIsPauseByUser	Z
    //   76: aload_0
    //   77: invokevirtual 333	com/tencent/TMG/sdk/AVAudioCtrl:uninitNative	()Z
    //   80: pop
    //   81: return
    //   82: astore_1
    //   83: goto -43 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	AVAudioCtrl
    //   4	6	1	localTraeAudioSession	TraeAudioSession
    //   32	7	1	localObject	Object
    //   52	6	1	localPhoneStatusMonitor	PhoneStatusMonitor
    //   82	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   14	29	32	finally
    //   14	29	82	java/lang/Exception
  }
  
  native boolean uninitNative();
  
  public native int unregistAudioDataCallback(int paramInt);
  
  public native int unregistAudioDataCallbackAll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVAudioCtrl
 * JD-Core Version:    0.7.0.1
 */