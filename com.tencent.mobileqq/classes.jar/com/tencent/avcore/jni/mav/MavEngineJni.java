package com.tencent.avcore.jni.mav;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.avcore.config.CameraConfigHelper;
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
    paramAVCoreSystemInfo = new StringBuilder();
    paramAVCoreSystemInfo.append("MavEngineJni, callback[");
    paramAVCoreSystemInfo.append(this.mEventCallback);
    paramAVCoreSystemInfo.append("]");
    AVCoreLog.e("MavEngineJni", paramAVCoreSystemInfo.toString());
  }
  
  private String getAppId()
  {
    try
    {
      int i = this.mAppId;
      return String.valueOf(i);
    }
    catch (Exception localException)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("MavEngineJni", "getAppId", localException);
      }
    }
    return "";
  }
  
  private byte[] getConfigInfoFromFile()
  {
    IMavAdapter localIMavAdapter = this.mAdapter;
    if (localIMavAdapter != null) {
      return localIMavAdapter.getConfigInfoFromFile();
    }
    return null;
  }
  
  private String getDeviceName()
  {
    return AVCoreSystemInfo.getDeviceName();
  }
  
  private int getOsType()
  {
    AVCoreSystemInfo localAVCoreSystemInfo = this.mSysInfo;
    if (localAVCoreSystemInfo != null)
    {
      int j = localAVCoreSystemInfo.getOsType();
      int i = j;
      if (j == 200)
      {
        if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT <= 22)) {
          return 118;
        }
        if (Build.VERSION.SDK_INT == 23) {
          return 119;
        }
        if ((Build.VERSION.SDK_INT != 24) && (Build.VERSION.SDK_INT != 25))
        {
          if ((Build.VERSION.SDK_INT != 26) && (Build.VERSION.SDK_INT != 27))
          {
            i = j;
            if (Build.VERSION.SDK_INT == 28) {
              return 122;
            }
          }
          else
          {
            return 121;
          }
        }
        else {
          i = 120;
        }
      }
      return i;
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
    IMavAdapter localIMavAdapter = this.mAdapter;
    if (localIMavAdapter != null) {
      return localIMavAdapter.getSharpConfigPayloadFromFile();
    }
    return "";
  }
  
  private int getSharpConfigVersionFromFile()
  {
    IMavAdapter localIMavAdapter = this.mAdapter;
    if (localIMavAdapter != null) {
      return localIMavAdapter.getSharpConfigVersionFromFile();
    }
    return 0;
  }
  
  private void onGAudioNativeEvent(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, long paramLong2, int paramInt6)
  {
    Object localObject;
    if (paramInt1 == 170)
    {
      paramInt1 = (int)((0xFF000000 & paramLong2) >> 24);
      paramInt2 = (int)((0xFF0000 & paramLong2) >> 16);
      paramInt3 = (int)((0xFF00 & paramLong2) >> 8);
      paramInt4 = (int)(paramLong2 & 0xFF);
      localObject = this.mAdapter;
      if (localObject != null) {
        ((IMavAdapter)localObject).onReceiveAudio(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    else if (this.mEventHandler != null)
    {
      localObject = new MavNativeEventParams();
      ((MavNativeEventParams)localObject).detail = paramArrayOfByte;
      ((MavNativeEventParams)localObject).info = paramLong2;
      ((MavNativeEventParams)localObject).groupId = paramLong1;
      ((MavNativeEventParams)localObject).relationType = paramInt2;
      ((MavNativeEventParams)localObject).multiAVType = paramInt3;
      ((MavNativeEventParams)localObject).multiSubType = paramInt4;
      if (paramArrayOfByte == null) {
        paramInt2 = 0;
      } else {
        paramInt2 = paramArrayOfByte.length;
      }
      ((MavNativeEventParams)localObject).bufferLen = paramInt2;
      ((MavNativeEventParams)localObject).flag = paramInt6;
      paramArrayOfByte = this.mEventHandler.obtainMessage();
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.what = paramInt1;
        paramArrayOfByte.obj = localObject;
        this.mEventHandler.sendMessage(paramArrayOfByte);
      }
    }
  }
  
  private String queryCameraParameters()
  {
    for (;;)
    {
      try
      {
        if (this.mAdapter != null)
        {
          Object localObject1 = this.mAdapter.getContext();
          localObject1 = CameraConfigHelper.getInstance((Context)localObject1).getCameraParameters();
          return localObject1;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  static native void regCallbacks();
  
  private void sendGAudioCMD(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    IMavNetChannel localIMavNetChannel = this.mNetChannel;
    if (localIMavNetChannel != null) {
      localIMavNetChannel.sendMultiVideoMsg(paramLong1, paramLong2, paramArrayOfByte);
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
  
  native void init(Context paramContext, long paramLong, int paramInt, String paramString1, SDKConfigInfo paramSDKConfigInfo, String paramString2, String paramString3, String paramString4);
  
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
  
  native int quitRoom(int paramInt);
  
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
  
  native void setQosParams(String paramString);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.mav.MavEngineJni
 * JD-Core Version:    0.7.0.1
 */