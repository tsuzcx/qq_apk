package com.tencent.avcore.jni.dav;

import android.content.Context;
import com.tencent.avcore.jni.data.AVCorePbInfo;
import com.tencent.avcore.jni.data.NetAddr;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import nbp;
import nbx;
import nby;
import nbz;
import ncg;

public class DavEngineProxy
  implements nby
{
  private DavEngineJni mJniImpl;
  
  public int accept(long paramLong, int paramInt1, int paramInt2)
  {
    return this.mJniImpl.accept(paramLong, paramInt1, paramInt2);
  }
  
  public int acceptVideoMode(long paramLong)
  {
    return this.mJniImpl.acceptVideoMode(paramLong);
  }
  
  public int cancelVideoMode(long paramLong)
  {
    return this.mJniImpl.cancelVideoMode(paramLong);
  }
  
  public int close(long paramLong, int paramInt)
  {
    return this.mJniImpl.close(paramLong, paramInt);
  }
  
  public int doQuaReport(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    return this.mJniImpl.doQuaReport(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public void enableDumpAudioData(boolean paramBoolean)
  {
    this.mJniImpl.enableDumpAudioData(paramBoolean);
  }
  
  public void enableLocalSpeechRecognizeModel(boolean paramBoolean) {}
  
  public boolean enableLoopback(boolean paramBoolean)
  {
    return this.mJniImpl.enableLoopback(paramBoolean);
  }
  
  public String getAVSDKInfo(long paramLong, String paramString)
  {
    return this.mJniImpl.getAVSDKInfo(paramLong, paramString);
  }
  
  public int getBusiTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return this.mJniImpl.getBusiTypeFromCmdPkg(paramBoolean, paramArrayOfByte, paramInt);
  }
  
  public long getChatRoomID(long paramLong)
  {
    return this.mJniImpl.getChatRoomID(paramLong);
  }
  
  public int getCmdTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    return this.mJniImpl.getCmdTypeFromCmdPkg(paramBoolean, paramArrayOfByte, paramInt);
  }
  
  public long getEncodeFrameFunctionPtrFunPtr()
  {
    return this.mJniImpl.getEncodeFrameFunctionPtrFunPtr();
  }
  
  public byte[] getInterestingString(long paramLong)
  {
    return this.mJniImpl.getInterestingString(paramLong);
  }
  
  public long getOnPeerFrameRenderEndFunctionPtr()
  {
    return this.mJniImpl.getOnPeerFrameRenderEndFunctionPtr();
  }
  
  public int getSdkVersion()
  {
    return this.mJniImpl.getSdkVersion();
  }
  
  public int getVolume(boolean paramBoolean)
  {
    return this.mJniImpl.getVolume(paramBoolean);
  }
  
  public int hasAVShiftAbility(long paramLong)
  {
    return this.mJniImpl.hasAVShiftAbility(paramLong);
  }
  
  public int ignore(long paramLong)
  {
    return this.mJniImpl.ignore(paramLong);
  }
  
  public int init(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt, String paramString12, SDKConfigInfo paramSDKConfigInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString13)
  {
    return this.mJniImpl.init(paramContext, paramLong, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramInt, paramString12, paramSDKConfigInfo, paramBoolean1, paramBoolean2, paramString13);
  }
  
  public void initContext()
  {
    this.mJniImpl.initContext();
  }
  
  public void initEngine(nbp paramnbp, ncg paramncg, nbx paramnbx, nbz paramnbz)
  {
    this.mJniImpl = new DavEngineJni(paramnbp, paramncg, paramnbx, paramnbz);
  }
  
  public boolean isEnableLoopback()
  {
    return this.mJniImpl.isEnableLoopback();
  }
  
  public boolean isEngineActive()
  {
    return this.mJniImpl.isEngineActive();
  }
  
  public int notifyAnotherSelfIsRing(long paramLong, boolean paramBoolean)
  {
    return this.mJniImpl.notifyAnotherSelfIsRing(paramLong, paramBoolean);
  }
  
  public int notifyAnotherTerChatStatus(long paramLong, int paramInt)
  {
    return this.mJniImpl.notifyAnotherTerChatStatus(paramLong, paramInt);
  }
  
  public int onLogOutByKicked()
  {
    return this.mJniImpl.onLogOutByKicked();
  }
  
  public void onProcessExit()
  {
    this.mJniImpl.onProcessExit();
  }
  
  public int onRecvVideoCloudConfig(byte[] paramArrayOfByte)
  {
    return this.mJniImpl.onRecvVideoCloudConfig(paramArrayOfByte);
  }
  
  public byte[] postData(long paramLong, byte[] paramArrayOfByte)
  {
    return this.mJniImpl.postData(paramLong, paramArrayOfByte);
  }
  
  public void postInNativeEventHandler(Runnable paramRunnable, long paramLong)
  {
    this.mJniImpl.postInNativeEventHandler(paramRunnable, paramLong);
  }
  
  public AVCorePbInfo processQCallPush(byte[] paramArrayOfByte, AVCorePbInfo paramAVCorePbInfo)
  {
    return this.mJniImpl.processQCallPush(paramArrayOfByte, paramAVCorePbInfo);
  }
  
  public boolean quaReport(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4)
  {
    return this.mJniImpl.quaReport(paramLong1, paramLong2, paramLong3, paramInt, paramLong4);
  }
  
  public int registerAudioDataCallback(int paramInt, boolean paramBoolean)
  {
    return this.mJniImpl.registerAudioDataCallback(paramInt, paramBoolean);
  }
  
  public int reject(long paramLong, int paramInt)
  {
    return this.mJniImpl.reject(paramLong, paramInt);
  }
  
  public int rejectVideoMode(long paramLong)
  {
    return this.mJniImpl.rejectVideoMode(paramLong);
  }
  
  public int request(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return this.mJniImpl.request(paramLong, paramInt1, paramInt2, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public int requestByMobileNo(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, byte[] paramArrayOfByte, String paramString4, int paramInt4, int paramInt5)
  {
    return this.mJniImpl.requestByMobileNo(paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, paramArrayOfByte, paramString4, paramInt4, paramInt5);
  }
  
  public int requestFromQQToUnQQ(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString, int paramInt3)
  {
    return this.mJniImpl.requestFromQQToUnQQ(paramLong, paramInt1, paramInt2, paramArrayOfByte, paramString, paramInt3);
  }
  
  public int requestFromTempChat(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    return this.mJniImpl.requestFromTempChat(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramLong3, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt4, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6);
  }
  
  public int requestReConnect(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    return this.mJniImpl.requestReConnect(paramLong1, paramInt1, paramInt2, paramLong2);
  }
  
  public int requestSharp(long paramLong, int paramInt1, int paramInt2)
  {
    return this.mJniImpl.requestSharp(paramLong, paramInt1, paramInt2);
  }
  
  public int requestSwitchTerminal(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    return this.mJniImpl.requestSwitchTerminal(paramLong1, paramInt1, paramInt2, paramLong2);
  }
  
  public int requestUnQQ(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mJniImpl.requestUnQQ(paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  public int requestVideoMode(long paramLong)
  {
    return this.mJniImpl.requestVideoMode(paramLong);
  }
  
  public int sendAVFunChatMsg(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    return this.mJniImpl.sendAVFunChatMsg(paramLong, paramInt, paramArrayOfByte);
  }
  
  public int sendAudioData(byte[] paramArrayOfByte, int paramInt)
  {
    return this.mJniImpl.sendAudioData(paramArrayOfByte, paramInt);
  }
  
  public int sendDTMFMessage(long paramLong, char paramChar)
  {
    return this.mJniImpl.sendDTMFMessage(paramLong, paramChar);
  }
  
  public int sendQueryRoomInfoRequest(long paramLong1, long paramLong2)
  {
    return this.mJniImpl.sendQueryRoomInfoRequest(paramLong1, paramLong2);
  }
  
  public int sendRecordingRequest(long paramLong1, boolean paramBoolean, NetAddr[] paramArrayOfNetAddr, long paramLong2)
  {
    return this.mJniImpl.sendRecordingRequest(paramLong1, paramBoolean, paramArrayOfNetAddr, paramLong2);
  }
  
  public int sendSelectVideoModeRequest(long paramLong, int paramInt)
  {
    return this.mJniImpl.sendSelectVideoModeRequest(paramLong, paramInt);
  }
  
  public void sendTransferMsg(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.mJniImpl.sendTransferMsg(paramLong, paramInt, paramArrayOfByte);
  }
  
  public void setAVSDKInfo(long paramLong, String paramString1, String paramString2)
  {
    this.mJniImpl.setAVSDKInfo(paramLong, paramString1, paramString2);
  }
  
  public int setApType(int paramInt)
  {
    return this.mJniImpl.setApType(paramInt);
  }
  
  public int setAudioDataFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.mJniImpl.setAudioDataFormat(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAudioDataSendByDefault(boolean paramBoolean)
  {
    this.mJniImpl.setAudioDataSendByDefault(paramBoolean);
  }
  
  public void setAudioDataSink(boolean paramBoolean)
  {
    this.mJniImpl.setAudioDataSink(paramBoolean);
  }
  
  public void setAudioOpt(boolean paramBoolean)
  {
    this.mJniImpl.setAudioOpt(paramBoolean);
  }
  
  public int setAudioOutputMode(int paramInt)
  {
    return this.mJniImpl.setAudioOutputMode(paramInt);
  }
  
  public void setCarrierType(long paramLong, String paramString1, String paramString2)
  {
    this.mJniImpl.setCarrierType(paramLong, paramString1, paramString2);
  }
  
  public int setGatewayIp(String paramString)
  {
    return this.mJniImpl.setGatewayIp(paramString);
  }
  
  public int setGatewayTestResult(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mJniImpl.setGatewayTestResult(paramInt1, paramInt2, paramInt3);
  }
  
  public int setGroundGlassSwitch(long paramLong, int paramInt)
  {
    return this.mJniImpl.setGroundGlassSwitch(paramLong, paramInt);
  }
  
  public void setProcessDecoderFrameFunctionptr(long paramLong)
  {
    this.mJniImpl.setProcessDecoderFrameFunctionptr(paramLong);
  }
  
  public int setProductId(int paramInt)
  {
    return this.mJniImpl.setProductId(paramInt);
  }
  
  public int setSelfUin(long paramLong)
  {
    return this.mJniImpl.setSelfUin(paramLong);
  }
  
  public void setVideoJitterLength(int paramInt)
  {
    this.mJniImpl.setVideoJitterLength(paramInt);
  }
  
  public int setVoiceType(int paramInt)
  {
    return this.mJniImpl.setVoiceType(paramInt);
  }
  
  public int setupDeviceInfos(String paramString)
  {
    return this.mJniImpl.setupDeviceInfos(paramString);
  }
  
  public int startAudioRecv()
  {
    return this.mJniImpl.startAudioRecv();
  }
  
  public int startAudioSend()
  {
    return this.mJniImpl.startAudioSend();
  }
  
  public int startVideoSend()
  {
    return this.mJniImpl.startVideoSend();
  }
  
  public int stopAudioRecv()
  {
    return this.mJniImpl.stopAudioRecv();
  }
  
  public int stopAudioSend()
  {
    return this.mJniImpl.stopAudioSend();
  }
  
  public int stopVideoSend()
  {
    return this.mJniImpl.stopVideoSend();
  }
  
  public int switchAudio(long paramLong)
  {
    return this.mJniImpl.switchAudio(paramLong);
  }
  
  public int switchVideo(long paramLong)
  {
    return this.mJniImpl.switchVideo(paramLong);
  }
  
  public int uninit()
  {
    return this.mJniImpl.uninit();
  }
  
  public int unregisterAudioDataCallback(int paramInt)
  {
    return this.mJniImpl.unregisterAudioDataCallback(paramInt, false);
  }
  
  public int unregisterAudioDataCallbackAll()
  {
    return this.mJniImpl.unregisterAudioDataCallbackAll();
  }
  
  public int updateConfigInfo()
  {
    return this.mJniImpl.updateConfigInfo();
  }
  
  public int updateNetworkTestResult(long paramLong, int paramInt)
  {
    return this.mJniImpl.updateNetworkTestResult(paramLong, paramInt);
  }
  
  public int updateProcessInfo(long paramLong, String paramString1, String paramString2)
  {
    return this.mJniImpl.updateProcessInfo(paramLong, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avcore.jni.dav.DavEngineProxy
 * JD-Core Version:    0.7.0.1
 */