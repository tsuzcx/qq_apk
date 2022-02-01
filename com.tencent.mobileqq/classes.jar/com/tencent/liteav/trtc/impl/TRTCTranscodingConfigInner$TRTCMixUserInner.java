package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudDef.TRTCMixUser;

public class TRTCTranscodingConfigInner$TRTCMixUserInner
  extends TRTCCloudDef.TRTCMixUser
{
  public String streamId = "";
  
  public TRTCTranscodingConfigInner$TRTCMixUserInner() {}
  
  public TRTCTranscodingConfigInner$TRTCMixUserInner(TRTCCloudDef.TRTCMixUser paramTRTCMixUser)
  {
    super(paramTRTCMixUser);
  }
  
  public TRTCTranscodingConfigInner$TRTCMixUserInner(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", streamId=");
    localStringBuilder.append(this.streamId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCTranscodingConfigInner.TRTCMixUserInner
 * JD-Core Version:    0.7.0.1
 */