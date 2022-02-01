package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class HevcConfig
{
  public final List<byte[]> initializationData;
  public final int nalUnitLengthFieldLength;
  
  private HevcConfig(List<byte[]> paramList, int paramInt)
  {
    this.initializationData = paramList;
    this.nalUnitLengthFieldLength = paramInt;
  }
  
  public static HevcConfig parse(ParsableByteArray paramParsableByteArray)
  {
    try
    {
      paramParsableByteArray.skipBytes(21);
      n = paramParsableByteArray.readUnsignedByte();
      i1 = paramParsableByteArray.readUnsignedByte();
      m = paramParsableByteArray.getPosition();
      j = 0;
      i = 0;
    }
    catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
    {
      for (;;)
      {
        int n;
        int i1;
        int m;
        int j;
        int i;
        int i2;
        int k;
        int i3;
        byte[] arrayOfByte;
        paramParsableByteArray = new ParserException("Error parsing HEVC config", paramParsableByteArray);
        for (;;)
        {
          throw paramParsableByteArray;
        }
        j += 1;
        continue;
        k += 1;
        continue;
        if (i == 0) {
          paramParsableByteArray = null;
        }
      }
    }
    if (j < i1)
    {
      paramParsableByteArray.skipBytes(1);
      i2 = paramParsableByteArray.readUnsignedShort();
      k = 0;
      while (k < i2)
      {
        i3 = paramParsableByteArray.readUnsignedShort();
        i += i3 + 4;
        paramParsableByteArray.skipBytes(i3);
        k += 1;
      }
    }
    paramParsableByteArray.setPosition(m);
    arrayOfByte = new byte[i];
    k = 0;
    j = 0;
    if (k < i1)
    {
      paramParsableByteArray.skipBytes(1);
      i2 = paramParsableByteArray.readUnsignedShort();
      m = 0;
      while (m < i2)
      {
        i3 = paramParsableByteArray.readUnsignedShort();
        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, arrayOfByte, j, NalUnitUtil.NAL_START_CODE.length);
        j += NalUnitUtil.NAL_START_CODE.length;
        System.arraycopy(paramParsableByteArray.data, paramParsableByteArray.getPosition(), arrayOfByte, j, i3);
        j += i3;
        paramParsableByteArray.skipBytes(i3);
        m += 1;
      }
      paramParsableByteArray = Collections.singletonList(arrayOfByte);
      paramParsableByteArray = new HevcConfig(paramParsableByteArray, (n & 0x3) + 1);
      return paramParsableByteArray;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.video.HevcConfig
 * JD-Core Version:    0.7.0.1
 */