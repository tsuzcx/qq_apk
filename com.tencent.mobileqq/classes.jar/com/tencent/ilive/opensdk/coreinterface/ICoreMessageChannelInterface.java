package com.tencent.ilive.opensdk.coreinterface;

import com.tencent.ilive.opensdk.callbacks.RtcCsCmdCallback;
import com.tencent.ilive.opensdk.params.RtcStartParam;

public abstract interface ICoreMessageChannelInterface
{
  public abstract long getTinyId();
  
  public abstract boolean loginWithParam(RtcStartParam paramRtcStartParam);
  
  public abstract boolean requestAppCmd(byte[] paramArrayOfByte, int paramInt, RtcCsCmdCallback paramRtcCsCmdCallback);
  
  public abstract boolean requestAppCmd(byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback);
  
  public abstract boolean requestCmd(String paramString, byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback);
  
  public abstract boolean requestInfoCmd(byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback);
  
  public abstract boolean requestReportCmd(int paramInt, byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.coreinterface.ICoreMessageChannelInterface
 * JD-Core Version:    0.7.0.1
 */