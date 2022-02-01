package com.tencent.TMG.sdk;

import android.util.Log;
import com.tencent.TMG.channel.AVAppChannel;
import com.tencent.TMG.channel.AVChannelManager;
import com.tencent.TMG.utils.QLog;

public class IMChannel
{
  public static final int ERR_FAILED = 1;
  public static final int ERR_OK = 0;
  public static String LOGTAG = "IMChannel";
  public int mNativeEntity;
  
  public IMChannel(int paramInt)
  {
    this.mNativeEntity = paramInt;
  }
  
  public static int getServerEnvType()
  {
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      return localAVAppChannel.getServerEnvType();
    }
    return -1;
  }
  
  public long getSelfTinyId()
  {
    long l = 0L;
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      l = localAVAppChannel.getTinyId();
    }
    Log.d(LOGTAG, "GetSelfTinyId selfTinyId: " + l);
    return l;
  }
  
  public void identifierToTinyId(IMChannel.ToTinyIdParam paramToTinyIdParam, int paramInt)
  {
    QLog.d(LOGTAG, 0, "java IMChannel identifierToTinyId");
    IMChannel.IdToIdCallbackImpl localIdToIdCallbackImpl = new IMChannel.IdToIdCallbackImpl(this, paramInt);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.identifierToTinyId(paramToTinyIdParam.accountType, paramToTinyIdParam.appIdAt3rd, paramToTinyIdParam.identifierList, localIdToIdCallbackImpl);
    }
  }
  
  public void multiVideoAppRequest(byte[] paramArrayOfByte, int paramInt)
  {
    IMChannel.CsCmdCallbackImpl localCsCmdCallbackImpl = new IMChannel.CsCmdCallbackImpl(this, paramInt);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.requestAppCmd(paramArrayOfByte, localCsCmdCallbackImpl);
    }
  }
  
  public void multiVideoAppRequest(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    IMChannel.CsCmdCallbackImpl localCsCmdCallbackImpl = new IMChannel.CsCmdCallbackImpl(this, paramInt2);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.requestAppCmd(paramArrayOfByte, paramInt1, localCsCmdCallbackImpl);
    }
  }
  
  public void multiVideoConfigRequest(byte[] paramArrayOfByte, int paramInt)
  {
    QLog.i(LOGTAG, 0, "multiVideoConfigRequest length:" + paramArrayOfByte.length);
    IMChannel.CsCmdCallbackImpl localCsCmdCallbackImpl = new IMChannel.CsCmdCallbackImpl(this, paramInt);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.requestCmd("VideoCCSvc.opensdk", paramArrayOfByte, localCsCmdCallbackImpl);
    }
  }
  
  public void multiVideoInfoRequest(byte[] paramArrayOfByte, int paramInt)
  {
    IMChannel.CsCmdCallbackImpl localCsCmdCallbackImpl = new IMChannel.CsCmdCallbackImpl(this, paramInt);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.requestInfoCmd(paramArrayOfByte, localCsCmdCallbackImpl);
    }
  }
  
  public native void nativeIdToIdCallback(int paramInt, IMChannel.IdToIdResult paramIdToIdResult);
  
  public native void nativeMultiVideoCallback(int paramInt, IMChannel.MultiVideoResult paramMultiVideoResult);
  
  public native void nativeQualityReportCallback(int paramInt, IMChannel.QualityReportResult paramQualityReportResult);
  
  public void qualityReportRequest(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    IMChannel.QualityReportCallback localQualityReportCallback = new IMChannel.QualityReportCallback(this, paramInt2);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.requestReportCmd(paramInt1, paramArrayOfByte, localQualityReportCallback);
    }
  }
  
  public void tinyIdToIdentifier(long[] paramArrayOfLong, int paramInt)
  {
    IMChannel.IdToIdCallbackImpl localIdToIdCallbackImpl = new IMChannel.IdToIdCallbackImpl(this, paramInt);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.tinyIdToIdentifier(paramArrayOfLong, localIdToIdCallbackImpl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.IMChannel
 * JD-Core Version:    0.7.0.1
 */