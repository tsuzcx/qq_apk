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
    for (;;)
    {
      int j;
      int i;
      int k;
      try
      {
        paramParsableByteArray.skipBytes(21);
        int n = paramParsableByteArray.readUnsignedByte();
        int i1 = paramParsableByteArray.readUnsignedByte();
        int m = paramParsableByteArray.getPosition();
        j = 0;
        i = 0;
        if (j < i1)
        {
          paramParsableByteArray.skipBytes(1);
          i2 = paramParsableByteArray.readUnsignedShort();
          k = 0;
          if (k >= i2) {
            break label220;
          }
          i3 = paramParsableByteArray.readUnsignedShort();
          i += i3 + 4;
          paramParsableByteArray.skipBytes(i3);
          k += 1;
          continue;
        }
        paramParsableByteArray.setPosition(m);
        arrayOfByte = new byte[i];
        k = 0;
        j = 0;
        if (k >= i1) {
          break label234;
        }
        paramParsableByteArray.skipBytes(1);
        int i2 = paramParsableByteArray.readUnsignedShort();
        m = 0;
        if (m >= i2) {
          break label227;
        }
        int i3 = paramParsableByteArray.readUnsignedShort();
        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, arrayOfByte, j, NalUnitUtil.NAL_START_CODE.length);
        j += NalUnitUtil.NAL_START_CODE.length;
        System.arraycopy(paramParsableByteArray.data, paramParsableByteArray.getPosition(), arrayOfByte, j, i3);
        j += i3;
        paramParsableByteArray.skipBytes(i3);
        m += 1;
        continue;
        return new HevcConfig(paramParsableByteArray, (n & 0x3) + 1);
      }
      catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
      {
        byte[] arrayOfByte;
        throw new ParserException("Error parsing HEVC config", paramParsableByteArray);
      }
      paramParsableByteArray = Collections.singletonList(arrayOfByte);
      continue;
      label220:
      j += 1;
      continue;
      label227:
      k += 1;
      continue;
      label234:
      if (i == 0) {
        paramParsableByteArray = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.video.HevcConfig
 * JD-Core Version:    0.7.0.1
 */