package com.tencent.avcore.jni.mav;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.engine.mav.IMavAdapter;
import com.tencent.avcore.engine.mav.IMavEventListener;
import com.tencent.avcore.engine.mav.MavEventId;
import com.tencent.avcore.engine.mav.MavNativeEventParams;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import com.tencent.avcore.netchannel.IMavNetCallback;
import com.tencent.avcore.netchannel.IMavNetChannel;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVNativeEventProcessor;

public class MavEngineJni
  implements MavEventId, IMavNetCallback
{
  static final String TAG = "MavEngineJni";
  protected final IMavAdapter mAdapter;
  private int mAppId;
  protected AVNativeEventProcessor mEventCallback;
  protected MavEngineJni.NativeEventHandler mEventHandler;
  protected IMavEventListener mEventListener;
  protected IMavNetChannel mNetChannel;
  protected final AVCoreSystemInfo mSysInfo;
  
  MavEngineJni(AVCoreSystemInfo paramAVCoreSystemInfo, IMavAdapter paramIMavAdapter)
  {
    this.mSysInfo = paramAVCoreSystemInfo;
    this.mAdapter = paramIMavAdapter;
    this.mEventCallback = this.mAdapter.getNativeEventProcessor();
    AVCoreLog.e("MavEngineJni", "MavEngineJni, callback[" + this.mEventCallback + "]");
  }
  
  private String getAppId()
  {
    String str = "";
    try
    {
      int i = this.mAppId;
      str = String.valueOf(i);
    }
    catch (Exception localException)
    {
      while (!AVCoreLog.isColorLevel()) {}
      AVCoreLog.e("MavEngineJni", "getAppId", localException);
    }
    return str;
    return "";
  }
  
  private byte[] getConfigInfoFromFile()
  {
    if (this.mAdapter != null) {
      return this.mAdapter.getConfigInfoFromFile();
    }
    return null;
  }
  
  private String getDeviceName()
  {
    return AVCoreSystemInfo.getDeviceName();
  }
  
  private int getOsType()
  {
    if (this.mSysInfo != null)
    {
      int j = this.mSysInfo.getOsType();
      int i = j;
      if (j == 200)
      {
        if ((Build.VERSION.SDK_INT < 21) || (Build.VERSION.SDK_INT > 22)) {
          break label45;
        }
        i = 118;
      }
      label45:
      do
      {
        return i;
        if (Build.VERSION.SDK_INT == 23) {
          return 119;
        }
        if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25)) {
          return 120;
        }
        if ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)) {
          return 121;
        }
        i = j;
      } while (Build.VERSION.SDK_INT != 28);
      return 122;
    }
    return 0;
  }
  
  private int getProductId()
  {
    return 0;
  }
  
  private String getReleaseVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  private String getSharpConfigPayloadFromFile()
  {
    if (this.mAdapter != null) {
      return this.mAdapter.getSharpConfigPayloadFromFile();
    }
    return "";
  }
  
  private int getSharpConfigVersionFromFile()
  {
    if (this.mAdapter != null) {
      return this.mAdapter.getSharpConfigVersionFromFile();
    }
    return 0;
  }
  
  private void onGAudioNativeEvent(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, long paramLong2, int paramInt6)
  {
    if (paramInt1 == 170)
    {
      paramInt1 = (int)((0xFF000000 & paramLong2) >> 24);
      paramInt2 = (int)((0xFF0000 & paramLong2) >> 16);
      paramInt3 = (int)((0xFF00 & paramLong2) >> 8);
      paramInt4 = (int)(0xFF & paramLong2);
      if (this.mAdapter != null) {
        this.mAdapter.onReceiveAudio(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    while (this.mEventHandler == null) {
      return;
    }
    MavNativeEventParams localMavNativeEventParams = new MavNativeEventParams();
    localMavNativeEventParams.detail = paramArrayOfByte;
    localMavNativeEventParams.info = paramLong2;
    localMavNativeEventParams.groupId = paramLong1;
    localMavNativeEventParams.relationType = paramInt2;
    localMavNativeEventParams.multiAVType = paramInt3;
    localMavNativeEventParams.multiSubType = paramInt4;
    if (paramArrayOfByte == null) {}
    for (paramInt2 = 0;; paramInt2 = paramArrayOfByte.length)
    {
      localMavNativeEventParams.bufferLen = paramInt2;
      localMavNativeEventParams.flag = paramInt6;
      paramArrayOfByte = this.mEventHandler.obtainMessage();
      if (paramArrayOfByte == null) {
        break;
      }
      paramArrayOfByte.what = paramInt1;
      paramArrayOfByte.obj = localMavNativeEventParams;
      this.mEventHandler.sendMessage(paramArrayOfByte);
      return;
    }
  }
  
  /* Error */
  private String queryCameraParameters()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/avcore/jni/mav/MavEngineJni:mAdapter	Lcom/tencent/avcore/engine/mav/IMavAdapter;
    //   6: ifnull +25 -> 31
    //   9: aload_0
    //   10: getfield 35	com/tencent/avcore/jni/mav/MavEngineJni:mAdapter	Lcom/tencent/avcore/engine/mav/IMavAdapter;
    //   13: invokeinterface 187 1 0
    //   18: astore_1
    //   19: aload_1
    //   20: invokestatic 193	com/tencent/avcore/config/CameraConfigHelper:getInstance	(Landroid/content/Context;)Lcom/tencent/avcore/config/CameraConfigHelper;
    //   23: invokevirtual 196	com/tencent/avcore/config/CameraConfigHelper:getCameraParameters	()Ljava/lang/String;
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: areturn
    //   31: aconst_null
    //   32: astore_1
    //   33: goto -14 -> 19
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	MavEngineJni
    //   18	15	1	localObject1	Object
    //   36	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	36	finally
    //   19	27	36	finally
  }
  
  static native void regCallbacks();
  
  private void sendGAudioCMD(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.sendMultiVideoMsg(paramLong1, paramLong2, paramArrayOfByte);
    }
  }
  
  static native void setAndroidPath(String paramString);
  
  native int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  native void checkScreenShareAvaliable();
  
  native int commonRequest(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, byte[] paramArrayOfByte, int paramInt8);
  
  native int debugSwitch(boolean paramBoolean);
  
  native void enableDumpAudioData(boolean paramBoolean);
  
  native void enableLocalSpeechRecognizeModel(boolean paramBoolean);
  
  native boolean enableLoopback(boolean paramBoolean);
  
  native String getAVGQuality();
  
  native long getEncodeFrameFunctionPtrFunPtr();
  
  native long getEnterRoomTime();
  
  native int getInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  native int getNetLevel();
  
  native int getNetState();
  
  native long getNetTrafficSize(long paramLong);
  
  native String getNetWorkQualityRTT();
  
  native int getOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native long getRoomId();
  
  native int getRoomUserClientVersion(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
  
  native int getRoomUserTerminalType(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
  
  native int getVideoAbilityLevel();
  
  native int getVolume();
  
  native int ignore(int paramInt1, long paramLong, int paramInt2);
  
  native void init(Context paramContext, long paramLong, int paramInt, String paramString1, SDKConfigInfo paramSDKConfigInfo, String paramString2, String paramString3);
  
  native int invite(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3);
  
  native int inviteM(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4);
  
  @Deprecated
  native int invitePstn(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  native boolean isEnableLoopback();
  
  native int kickOutPstnUsers();
  
  native void lockVideoMaxQP(int paramInt);
  
  native int modifyGroupAdmin(long paramLong, boolean paramBoolean);
  
  native int onRecvGAudioCMD(int paramInt, byte[] paramArrayOfByte);
  
  native byte[] postData(long paramLong, byte[] paramArrayOfByte);
  
  native int quit(int paramInt);
  
  native int readDataFromTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public void receiveGatewayMsg(String paramString, int paramInt)
  {
    setNetIPAndPort(paramString, paramInt);
  }
  
  public int receiveMultiVideoMsg(int paramInt, byte[] paramArrayOfByte)
  {
    return onRecvGAudioCMD(paramInt, paramArrayOfByte);
  }
  
  native int registerAudioDataCallback(int paramInt, boolean paramBoolean);
  
  native int registerTRAE(int paramInt);
  
  native int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  native int requestCamera(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  native int requestMemPosInfoList();
  
  native int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  native int sendShareFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native int sendShareFrame2NativeBmp(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  native void sendTransferMsg(long[] paramArrayOfLong, byte[] paramArrayOfByte);
  
  native void setAECMode(int paramInt);
  
  native int setApType(int paramInt);
  
  public void setAppId(int paramInt)
  {
    this.mAppId = paramInt;
  }
  
  native int setAudioDataFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native void setAudioDataSendByDefault(boolean paramBoolean);
  
  native void setAudioDataSink(boolean paramBoolean);
  
  native boolean setAudioNoiseCtrlParam(int paramInt1, int paramInt2, int paramInt3);
  
  native int setAudioOutputMode(int paramInt);
  
  public void setEventListener(IMavEventListener paramIMavEventListener)
  {
    this.mEventListener = paramIMavEventListener;
    Looper localLooper2 = Looper.getMainLooper();
    Looper localLooper1 = localLooper2;
    if (localLooper2 == null) {
      localLooper1 = Looper.myLooper();
    }
    this.mEventHandler = new MavEngineJni.NativeEventHandler(localLooper1, paramIMavEventListener, this.mEventCallback);
  }
  
  native int setHowlingDetectEnable(boolean paramBoolean);
  
  native boolean setMicByAdmin(long paramLong, boolean paramBoolean);
  
  native boolean setMicMode(int paramInt);
  
  public void setNetChannel(IMavNetChannel paramIMavNetChannel)
  {
    this.mNetChannel = paramIMavNetChannel;
    this.mNetChannel.setNetCallback(this);
  }
  
  native int setNetIPAndPort(String paramString, int paramInt);
  
  native int setOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  native void setProcessDecoderFrameFunctionptr(long paramLong);
  
  native int setShareEncParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  native void setVideoDataSendByDefault(boolean paramBoolean);
  
  native void setVideoDataSink(boolean paramBoolean);
  
  native void setVideoJitterLength(int paramInt);
  
  native int setVoiceType(int paramInt);
  
  native int startAudioRecv();
  
  native int startAudioSend(boolean paramBoolean);
  
  native int startShareSend(int paramInt);
  
  native int startVideoRecv(long[] paramArrayOfLong, int paramInt);
  
  native int startVideoSend();
  
  native int stopAudioRecv();
  
  native int stopAudioSend(boolean paramBoolean);
  
  native int stopShareSend(int paramInt);
  
  native int stopVideoRecv();
  
  native int stopVideoSend();
  
  native int switchToAudioMode();
  
  native void uninit();
  
  native int unregisterAudioDataCallback(int paramInt);
  
  native int unregisterTRAE(int paramInt);
  
  native int updateRoomInfo(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  native int updateRoomUserTerminalInfo(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int paramInt4);
  
  native int writeDataToTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.mav.MavEngineJni
 * JD-Core Version:    0.7.0.1
 */