package com.tencent.ilive.opensdk.bridgeinterface;

import com.tencent.ilive.opensdk.coreinterface.IColorSpaceTransform;

public class RtcColorSpaceTransform
  implements IColorSpaceTransform
{
  public long getPTS()
  {
    return 0L;
  }
  
  public int i420ToNV12(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int i420ToRGBA(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int nv21Toi420Rotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return 0;
  }
  
  public int rgba2I420(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.bridgeinterface.RtcColorSpaceTransform
 * JD-Core Version:    0.7.0.1
 */