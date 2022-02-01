package com.tencent.ilive.opensdk.bridgeinterface;

import com.tencent.ilive.opensdk.coreinterface.IMusicDecoderEx;

public class SimpleMusicDecoder
  implements IMusicDecoderEx
{
  public int get(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getChannels()
  {
    return 0;
  }
  
  public int getDubFrameLen()
  {
    return 0;
  }
  
  public int getDubInfoChannels()
  {
    return 0;
  }
  
  public int getDubInfoSampleRate()
  {
    return 0;
  }
  
  public long getLength()
  {
    return 0L;
  }
  
  public int getOrgFrameLen()
  {
    return 0;
  }
  
  public int getSampleRate()
  {
    return 0;
  }
  
  public long getTimestamp()
  {
    return 0L;
  }
  
  public boolean hasDubInfo()
  {
    return false;
  }
  
  public int open(String paramString1, String paramString2)
  {
    return 0;
  }
  
  public void seekTo(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.bridgeinterface.SimpleMusicDecoder
 * JD-Core Version:    0.7.0.1
 */