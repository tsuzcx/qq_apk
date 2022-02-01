package com.tencent.avcore.engine.mav;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.avcore.jni.data.SDKConfigInfo;

public abstract interface IMavEngine
  extends IAVEngineCommon
{
  public abstract int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void checkScreenShareAvaliable();
  
  public abstract int commonRequest(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, byte[] paramArrayOfByte, int paramInt8);
  
  public abstract int debugSwitch(boolean paramBoolean);
  
  public abstract void enableAIDenoise(boolean paramBoolean);
  
  public abstract void enableDumpAudioData(boolean paramBoolean);
  
  public abstract boolean enableLoopback(boolean paramBoolean);
  
  public abstract String getAVGQuality();
  
  public abstract long getEncodeFrameFunctionPtrFunPtr();
  
  public abstract long getEnterRoomTime();
  
  public abstract int getInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public abstract int getNetLevel();
  
  public abstract int getNetState();
  
  public abstract long getNetTrafficSize(long paramLong);
  
  public abstract String getNetWorkQualityRTT();
  
  public abstract int getOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract long getRoomId();
  
  public abstract int getRoomUserClientVersion(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
  
  public abstract int getRoomUserTerminalType(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
  
  public abstract int getVideoAbilityLevel();
  
  public abstract int getVolume();
  
  public abstract int ignore(int paramInt1, long paramLong, int paramInt2);
  
  public abstract void init(Context paramContext, long paramLong, int paramInt, String paramString1, SDKConfigInfo paramSDKConfigInfo, String paramString2, String paramString3, String paramString4, boolean paramBoolean);
  
  public abstract int invite(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int inviteM(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4);
  
  public abstract boolean isEnableLoopback();
  
  public abstract void lockVideoMaxQP(int paramInt);
  
  public abstract int modifyGroupAdmin(long paramLong, boolean paramBoolean);
  
  public abstract byte[] postData(long paramLong, byte[] paramArrayOfByte);
  
  public abstract int quitRoom(int paramInt);
  
  public abstract int readDataFromTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract int registerTRAE(int paramInt);
  
  public abstract int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public abstract int requestCamera(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract int requestMemPosInfoList();
  
  public abstract int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public abstract int sendShareFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract int sendShareFrame2NativeBmp(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public abstract void sendTransferMsg(long[] paramArrayOfLong, byte[] paramArrayOfByte);
  
  public abstract void setAECMode(int paramInt);
  
  public abstract void setAndroidPath(String paramString);
  
  public abstract int setApType(int paramInt);
  
  public abstract void setAppId(int paramInt);
  
  public abstract void setAudioDataSendByDefault(boolean paramBoolean);
  
  public abstract void setAudioDataSink(boolean paramBoolean);
  
  public abstract boolean setAudioNoiseCtrlParam(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int setAudioOutputMode(int paramInt);
  
  public abstract int setHowlingDetectEnable(boolean paramBoolean);
  
  public abstract boolean setMicByAdmin(long paramLong, boolean paramBoolean);
  
  public abstract boolean setMicMode(int paramInt);
  
  public abstract int setOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setProcessDecoderFrameFunctionptr(long paramLong);
  
  public abstract void setQosParams(String paramString);
  
  public abstract int setShareEncParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public abstract void setVideoDataSendByDefault(boolean paramBoolean);
  
  public abstract void setVideoDataSink(boolean paramBoolean);
  
  public abstract void setVideoJitterLength(int paramInt);
  
  public abstract int setVoiceType(int paramInt);
  
  public abstract int startAudioRecv();
  
  public abstract int startAudioSend(boolean paramBoolean);
  
  public abstract int startShareSend(int paramInt);
  
  public abstract int startVideoRecv(long[] paramArrayOfLong, int paramInt);
  
  public abstract int startVideoSend();
  
  public abstract int stopAudioRecv();
  
  public abstract int stopAudioSend(boolean paramBoolean);
  
  public abstract int stopShareSend(int paramInt);
  
  public abstract int stopVideoRecv();
  
  public abstract int stopVideoSend();
  
  public abstract int switchToAudioMode();
  
  public abstract void uninit();
  
  public abstract int unregisterTRAE(int paramInt);
  
  public abstract int updateRoomInfo(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract int updateRoomUserTerminalInfo(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int paramInt4);
  
  public abstract int writeDataToTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.engine.mav.IMavEngine
 * JD-Core Version:    0.7.0.1
 */