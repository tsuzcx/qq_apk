package com.tencent.TMG.sdk;

import android.util.Log;
import com.tencent.TMG.channel.AVAppChannel;
import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;
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
    Object localObject = AVChannelManager.getAppChannel();
    long l;
    if (localObject != null) {
      l = ((AVAppChannel)localObject).getTinyId();
    } else {
      l = 0L;
    }
    localObject = LOGTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetSelfTinyId selfTinyId: ");
    localStringBuilder.append(l);
    Log.d((String)localObject, localStringBuilder.toString());
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
    Object localObject1 = LOGTAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("multiVideoConfigRequest length:");
    ((StringBuilder)localObject2).append(paramArrayOfByte.length);
    QLog.i((String)localObject1, 0, ((StringBuilder)localObject2).toString());
    localObject1 = new IMChannel.CsCmdCallbackImpl(this, paramInt);
    localObject2 = AVChannelManager.getAppChannel();
    if (localObject2 != null) {
      ((AVAppChannel)localObject2).requestCmd("VideoCCSvc.opensdk", paramArrayOfByte, (AVAppChannel.CsCmdCallback)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.IMChannel
 * JD-Core Version:    0.7.0.1
 */