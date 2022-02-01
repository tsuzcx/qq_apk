package com.tencent.ilive.opensdk.callbacks;

import com.tencent.ilive.opensdk.coreinterface.ICoreMessageChannelInterface;
import com.tencent.ilive.opensdk.params.RtcStartParam;

public class RtcCoreMessageChannel
  implements ICoreMessageChannelInterface
{
  public long getTinyId()
  {
    return 0L;
  }
  
  public boolean loginWithParam(RtcStartParam paramRtcStartParam)
  {
    return false;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, int paramInt, RtcCsCmdCallback paramRtcCsCmdCallback)
  {
    return false;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback)
  {
    return false;
  }
  
  public boolean requestCmd(String paramString, byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback)
  {
    return false;
  }
  
  public boolean requestInfoCmd(byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback)
  {
    return false;
  }
  
  public boolean requestReportCmd(int paramInt, byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.callbacks.RtcCoreMessageChannel
 * JD-Core Version:    0.7.0.1
 */