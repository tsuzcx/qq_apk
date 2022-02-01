package com.tencent.avcore.jni.mav;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import nbp;
import nca;
import ncb;
import ncc;
import nci;

public class MavEngineProxy
  implements ncb
{
  private MavEngineJni mMavEngineJni;
  
  public int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return this.mMavEngineJni.accept(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public int commonRequest(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, byte[] paramArrayOfByte, int paramInt8)
  {
    return this.mMavEngineJni.commonRequest(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramString, paramInt7, paramArrayOfByte, paramInt8);
  }
  
  public int debugSwitch(boolean paramBoolean)
  {
    return this.mMavEngineJni.debugSwitch(paramBoolean);
  }
  
  public void enableDumpAudioData(boolean paramBoolean)
  {
    this.mMavEngineJni.enableDumpAudioData(paramBoolean);
  }
  
  public void enableLocalSpeechRecognizeModel(boolean paramBoolean)
  {
    this.mMavEngineJni.enableLocalSpeechRecognizeModel(paramBoolean);
  }
  
  public boolean enableLoopback(boolean paramBoolean)
  {
    return this.mMavEngineJni.enableLoopback(paramBoolean);
  }
  
  public String getAVGQuality()
  {
    return this.mMavEngineJni.getAVGQuality();
  }
  
  public long getEncodeFrameFunctionPtrFunPtr()
  {
    return this.mMavEngineJni.getEncodeFrameFunctionPtrFunPtr();
  }
  
  public long getEnterRoomTime()
  {
    return this.mMavEngineJni.getEnterRoomTime();
  }
  
  public int getInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    return this.mMavEngineJni.getInviteStrategy(paramArrayOfLong, paramInt1, paramArrayOfString, paramInt2);
  }
  
  public int getNetLevel()
  {
    return this.mMavEngineJni.getNetLevel();
  }
  
  public int getNetState()
  {
    return this.mMavEngineJni.getNetState();
  }
  
  public long getNetTrafficSize(long paramLong)
  {
    return this.mMavEngineJni.getNetTrafficSize(paramLong);
  }
  
  public String getNetWorkQualityRTT()
  {
    return this.mMavEngineJni.getNetWorkQualityRTT();
  }
  
  public int getOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.mMavEngineJni.getOutputFormat(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public long getRoomId()
  {
    return this.mMavEngineJni.getRoomId();
  }
  
  public int getRoomUserClientVersion(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    return this.mMavEngineJni.getRoomUserClientVersion(paramInt1, paramLong1, paramInt2, paramLong2);
  }
  
  public int getRoomUserTerminalType(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    return this.mMavEngineJni.getRoomUserTerminalType(paramInt1, paramLong1, paramInt2, paramLong2);
  }
  
  public int getVideoAbilityLevel()
  {
    return this.mMavEngineJni.getVideoAbilityLevel();
  }
  
  public int getVolume()
  {
    return this.mMavEngineJni.getVolume();
  }
  
  public int ignore(int paramInt1, long paramLong, int paramInt2)
  {
    return this.mMavEngineJni.ignore(paramInt1, paramLong, paramInt2);
  }
  
  public void init(Context paramContext, long paramLong, int paramInt, String paramString, SDKConfigInfo paramSDKConfigInfo)
  {
    this.mMavEngineJni.init(paramContext, paramLong, paramInt, paramString, paramSDKConfigInfo);
  }
  
  protected void initEngine(nbp paramnbp, nca paramnca, String paramString)
  {
    this.mMavEngineJni = new MavEngineJni(paramnbp, paramnca);
    MavEngineJni.regCallbacks();
    setAndroidPath(paramString);
  }
  
  public int invite(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mMavEngineJni.invite(paramArrayOfLong, paramInt1, paramInt2, paramInt3);
  }
  
  public int inviteM(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    return this.mMavEngineJni.inviteM(paramArrayOfLong, paramInt1, paramArrayOfString, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4);
  }
  
  public boolean isEnableLoopback()
  {
    return this.mMavEngineJni.isEnableLoopback();
  }
  
  public void lockVideoMaxQP(int paramInt)
  {
    this.mMavEngineJni.lockVideoMaxQP(paramInt);
  }
  
  public int modifyGroupAdmin(long paramLong, boolean paramBoolean)
  {
    return this.mMavEngineJni.modifyGroupAdmin(paramLong, paramBoolean);
  }
  
  public byte[] postData(long paramLong, byte[] paramArrayOfByte)
  {
    return this.mMavEngineJni.postData(paramLong, paramArrayOfByte);
  }
  
  public int quit(int paramInt)
  {
    return this.mMavEngineJni.quit(paramInt);
  }
  
  public int readDataFromTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return this.mMavEngineJni.readDataFromTRAE(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public int registerAudioDataCallback(int paramInt, boolean paramBoolean)
  {
    return this.mMavEngineJni.registerAudioDataCallback(paramInt, paramBoolean);
  }
  
  public int registerTRAE(int paramInt)
  {
    return this.mMavEngineJni.registerTRAE(paramInt);
  }
  
  public int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return this.mMavEngineJni.request(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public int requestCamera(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.mMavEngineJni.requestCamera(paramInt1, paramLong, paramInt2, paramInt3, paramInt4);
  }
  
  public int requestMemPosInfoList()
  {
    return this.mMavEngineJni.requestMemPosInfoList();
  }
  
  public int sendAudioData(byte[] paramArrayOfByte, int paramInt)
  {
    return this.mMavEngineJni.sendAudioData(paramArrayOfByte, paramInt);
  }
  
  public int sendShareFrame2Native(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.mMavEngineJni.sendShareFrame2Native(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int sendShareFrame2NativeBmp(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return this.mMavEngineJni.sendShareFrame2NativeBmp(paramBitmap, paramInt1, paramInt2);
  }
  
  public void sendTransferMsg(long[] paramArrayOfLong, byte[] paramArrayOfByte)
  {
    this.mMavEngineJni.sendTransferMsg(paramArrayOfLong, paramArrayOfByte);
  }
  
  public void setAECMode(int paramInt)
  {
    this.mMavEngineJni.setAECMode(paramInt);
  }
  
  public void setAndroidPath(String paramString)
  {
    MavEngineJni.setAndroidPath(paramString);
  }
  
  public int setApType(int paramInt)
  {
    return this.mMavEngineJni.setApType(paramInt);
  }
  
  public void setAppId(int paramInt)
  {
    this.mMavEngineJni.setAppId(paramInt);
  }
  
  public int setAudioDataFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.mMavEngineJni.setAudioDataFormat(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAudioDataSendByDefault(boolean paramBoolean)
  {
    this.mMavEngineJni.setAudioDataSendByDefault(paramBoolean);
  }
  
  public void setAudioDataSink(boolean paramBoolean)
  {
    this.mMavEngineJni.setAudioDataSink(paramBoolean);
  }
  
  public boolean setAudioNoiseCtrlParam(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mMavEngineJni.setAudioNoiseCtrlParam(paramInt1, paramInt2, paramInt3);
  }
  
  public int setAudioOutputMode(int paramInt)
  {
    return this.mMavEngineJni.setAudioOutputMode(paramInt);
  }
  
  public void setEventListener(ncc paramncc)
  {
    this.mMavEngineJni.setEventListener(paramncc);
  }
  
  public int setHowlingDetectEnable(boolean paramBoolean)
  {
    return this.mMavEngineJni.setHowlingDetectEnable(paramBoolean);
  }
  
  public boolean setMicByAdmin(long paramLong, boolean paramBoolean)
  {
    return this.mMavEngineJni.setMicByAdmin(paramLong, paramBoolean);
  }
  
  public boolean setMicMode(int paramInt)
  {
    return this.mMavEngineJni.setMicMode(paramInt);
  }
  
  public void setNetChannel(nci paramnci)
  {
    this.mMavEngineJni.setNetChannel(paramnci);
  }
  
  public int setOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.mMavEngineJni.setOutputFormat(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setProcessDecoderFrameFunctionptr(long paramLong)
  {
    this.mMavEngineJni.setProcessDecoderFrameFunctionptr(paramLong);
  }
  
  public int setShareEncParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    return this.mMavEngineJni.setShareEncParam(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void setVideoDataSendByDefault(boolean paramBoolean)
  {
    this.mMavEngineJni.setVideoDataSendByDefault(paramBoolean);
  }
  
  public void setVideoDataSink(boolean paramBoolean)
  {
    this.mMavEngineJni.setVideoDataSink(paramBoolean);
  }
  
  public void setVideoJitterLength(int paramInt)
  {
    this.mMavEngineJni.setVideoJitterLength(paramInt);
  }
  
  public int setVoiceType(int paramInt)
  {
    return this.mMavEngineJni.setVoiceType(paramInt);
  }
  
  public int startAudioRecv()
  {
    return this.mMavEngineJni.startAudioRecv();
  }
  
  public int startAudioSend(boolean paramBoolean)
  {
    return this.mMavEngineJni.startAudioSend(paramBoolean);
  }
  
  public int startShareSend(int paramInt)
  {
    return this.mMavEngineJni.startShareSend(paramInt);
  }
  
  public int startVideoRecv(long[] paramArrayOfLong, int paramInt)
  {
    return this.mMavEngineJni.startVideoRecv(paramArrayOfLong, paramInt);
  }
  
  public int startVideoSend()
  {
    return this.mMavEngineJni.startVideoSend();
  }
  
  public int stopAudioRecv()
  {
    return this.mMavEngineJni.stopAudioRecv();
  }
  
  public int stopAudioSend(boolean paramBoolean)
  {
    return this.mMavEngineJni.stopAudioSend(paramBoolean);
  }
  
  public int stopShareSend(int paramInt)
  {
    return this.mMavEngineJni.stopShareSend(paramInt);
  }
  
  public int stopVideoRecv()
  {
    return this.mMavEngineJni.stopVideoRecv();
  }
  
  public int stopVideoSend()
  {
    return this.mMavEngineJni.stopVideoSend();
  }
  
  public int switchToAudioMode()
  {
    return this.mMavEngineJni.switchToAudioMode();
  }
  
  public void uninit()
  {
    this.mMavEngineJni.uninit();
  }
  
  public int unregisterAudioDataCallback(int paramInt)
  {
    return this.mMavEngineJni.unregisterAudioDataCallback(paramInt);
  }
  
  public int unregisterTRAE(int paramInt)
  {
    return this.mMavEngineJni.unregisterTRAE(paramInt);
  }
  
  public int updateRoomInfo(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return this.mMavEngineJni.updateRoomInfo(paramInt1, paramLong, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public int updateRoomUserTerminalInfo(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    return this.mMavEngineJni.updateRoomUserTerminalInfo(paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramInt4);
  }
  
  public int writeDataToTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return this.mMavEngineJni.writeDataToTRAE(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avcore.jni.mav.MavEngineProxy
 * JD-Core Version:    0.7.0.1
 */