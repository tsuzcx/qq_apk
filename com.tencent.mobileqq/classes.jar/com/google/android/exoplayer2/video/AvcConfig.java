package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.NalUnitUtil.SpsData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class AvcConfig
{
  public final int height;
  public final List<byte[]> initializationData;
  public final int nalUnitLengthFieldLength;
  public final float pixelWidthAspectRatio;
  public final int width;
  
  private AvcConfig(List<byte[]> paramList, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.initializationData = paramList;
    this.nalUnitLengthFieldLength = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.pixelWidthAspectRatio = paramFloat;
  }
  
  private static byte[] buildNalUnitForChild(ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.readUnsignedShort();
    int j = paramParsableByteArray.getPosition();
    paramParsableByteArray.skipBytes(i);
    return CodecSpecificDataUtil.buildNalUnit(paramParsableByteArray.data, j, i);
  }
  
  public static AvcConfig parse(ParsableByteArray paramParsableByteArray)
  {
    try
    {
      paramParsableByteArray.skipBytes(4);
      k = (paramParsableByteArray.readUnsignedByte() & 0x3) + 1;
      if (k == 3) {
        break label165;
      }
      localArrayList = new ArrayList();
      j = paramParsableByteArray.readUnsignedByte() & 0x1F;
      i = 0;
      while (i < j)
      {
        localArrayList.add(buildNalUnitForChild(paramParsableByteArray));
        i += 1;
      }
      int m = paramParsableByteArray.readUnsignedByte();
      i = 0;
      while (i < m)
      {
        localArrayList.add(buildNalUnitForChild(paramParsableByteArray));
        i += 1;
      }
      if (j <= 0) {
        break label193;
      }
      paramParsableByteArray = (byte[])localArrayList.get(0);
      paramParsableByteArray = NalUnitUtil.parseSpsNalUnit((byte[])localArrayList.get(0), k, paramParsableByteArray.length);
      i = paramParsableByteArray.width;
      j = paramParsableByteArray.height;
      f = paramParsableByteArray.pixelWidthAspectRatio;
    }
    catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
    {
      for (;;)
      {
        int k;
        ArrayList localArrayList;
        label165:
        paramParsableByteArray = new ParserException("Error parsing AVC config", paramParsableByteArray);
        for (;;)
        {
          throw paramParsableByteArray;
        }
        label193:
        int i = -1;
        int j = -1;
        float f = 1.0F;
      }
    }
    return new AvcConfig(localArrayList, k, i, j, f);
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.video.AvcConfig
 * JD-Core Version:    0.7.0.1
 */