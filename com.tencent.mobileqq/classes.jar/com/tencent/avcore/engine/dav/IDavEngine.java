package com.tencent.avcore.engine.dav;

import android.content.Context;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.avcore.jni.data.AVCorePbInfo;
import com.tencent.avcore.jni.data.NetAddr;
import com.tencent.avcore.jni.data.SDKConfigInfo;

public abstract interface IDavEngine
  extends IAVEngineCommon
{
  public abstract int accept(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int acceptVideoMode(long paramLong);
  
  public abstract int cancelVideoMode(long paramLong);
  
  public abstract int close(long paramLong, int paramInt);
  
  public abstract int doQuaReport(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public abstract void enableDumpAudioData(boolean paramBoolean);
  
  public abstract boolean enableLoopback(boolean paramBoolean);
  
  public abstract String getAVSDKInfo(long paramLong, String paramString);
  
  public abstract int getBusiTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  public abstract long getChatRoomID(long paramLong);
  
  public abstract int getCmdTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  public abstract long getEncodeFrameFunctionPtrFunPtr();
  
  public abstract byte[] getInterestingString(long paramLong);
  
  public abstract long getOnPeerFrameRenderEndFunctionPtr();
  
  public abstract int getSdkVersion();
  
  public abstract int getVolume(boolean paramBoolean);
  
  public abstract int hasAVShiftAbility(long paramLong);
  
  public abstract int ignore(long paramLong);
  
  public abstract int init(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt, String paramString12, SDKConfigInfo paramSDKConfigInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString13, String paramString14, String paramString15, String paramString16);
  
  public abstract boolean isEnableLoopback();
  
  public abstract boolean isEngineActive();
  
  public abstract int notifyAnotherSelfIsRing(long paramLong, boolean paramBoolean);
  
  public abstract int notifyAnotherTerChatStatus(long paramLong, int paramInt);
  
  public abstract int onLogOutByKicked();
  
  public abstract void onProcessExit();
  
  public abstract int onRecvVideoCloudConfig(byte[] paramArrayOfByte);
  
  public abstract byte[] postData(long paramLong, byte[] paramArrayOfByte);
  
  public abstract AVCorePbInfo processQCallPush(byte[] paramArrayOfByte, AVCorePbInfo paramAVCorePbInfo);
  
  public abstract boolean quaReport(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
  
  public abstract int registerAudioDataCallback(int paramInt, boolean paramBoolean);
  
  public abstract int reject(long paramLong, int paramInt);
  
  public abstract int rejectVideoMode(long paramLong);
  
  public abstract int request(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract int requestByMobileNo(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, byte[] paramArrayOfByte, String paramString4, int paramInt4, int paramInt5);
  
  public abstract int requestFromQQToUnQQ(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString, int paramInt3);
  
  public abstract int requestFromTempChat(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6);
  
  public abstract int requestReConnect(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  public abstract int requestSharp(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int requestSwitchTerminal(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  public abstract int requestUnQQ(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int requestVideoMode(long paramLong);
  
  public abstract int sendAVFunChatMsg(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public abstract int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public abstract int sendDTMFMessage(long paramLong, char paramChar);
  
  public abstract int sendQueryRoomInfoRequest(long paramLong1, long paramLong2);
  
  public abstract int sendRecordingRequest(long paramLong1, boolean paramBoolean, NetAddr[] paramArrayOfNetAddr, long paramLong2);
  
  public abstract int sendSelectVideoModeRequest(long paramLong, int paramInt);
  
  public abstract void sendTransferMsg(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public abstract void setAVSDKInfo(long paramLong, String paramString1, String paramString2);
  
  public abstract int setApType(int paramInt);
  
  public abstract int setAudioDataFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setAudioDataSendByDefault(boolean paramBoolean);
  
  public abstract void setAudioDataSink(boolean paramBoolean);
  
  public abstract void setAudioOpt(boolean paramBoolean);
  
  public abstract int setAudioOutputMode(int paramInt);
  
  public abstract void setCarrierType(long paramLong, String paramString1, String paramString2);
  
  public abstract int setGatewayIp(String paramString);
  
  public abstract int setGatewayTestResult(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int setGroundGlassSwitch(long paramLong, int paramInt);
  
  public abstract void setProcessDecoderFrameFunctionptr(long paramLong);
  
  public abstract int setProductId(int paramInt);
  
  public abstract void setQosParams(String paramString);
  
  public abstract int setSelfUin(long paramLong);
  
  public abstract void setVideoJitterLength(int paramInt);
  
  public abstract int setVoiceType(int paramInt);
  
  public abstract int setupDeviceInfos(String paramString);
  
  public abstract int startAudioRecv();
  
  public abstract int startAudioSend();
  
  public abstract int startVideoSend();
  
  public abstract int stopAudioRecv();
  
  public abstract int stopAudioSend();
  
  public abstract int stopVideoSend();
  
  public abstract int switchAudio(long paramLong);
  
  public abstract int switchVideo(long paramLong);
  
  public abstract int uninit();
  
  public abstract int unregisterAudioDataCallback(int paramInt);
  
  public abstract int unregisterAudioDataCallbackAll();
  
  public abstract int updateConfigInfo();
  
  public abstract int updateNetworkTestResult(long paramLong, int paramInt);
  
  public abstract int updateProcessInfo(long paramLong, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.engine.dav.IDavEngine
 * JD-Core Version:    0.7.0.1
 */