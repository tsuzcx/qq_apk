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
    int j = -1;
    int k = 0;
    int m;
    try
    {
      paramParsableByteArray.skipBytes(4);
      m = (paramParsableByteArray.readUnsignedByte() & 0x3) + 1;
      if (m == 3) {
        throw new IllegalStateException();
      }
    }
    catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
    {
      throw new ParserException("Error parsing AVC config", paramParsableByteArray);
    }
    ArrayList localArrayList = new ArrayList();
    int n = paramParsableByteArray.readUnsignedByte() & 0x1F;
    int i = 0;
    while (i < n)
    {
      localArrayList.add(buildNalUnitForChild(paramParsableByteArray));
      i += 1;
    }
    int i1 = paramParsableByteArray.readUnsignedByte();
    i = k;
    while (i < i1)
    {
      localArrayList.add(buildNalUnitForChild(paramParsableByteArray));
      i += 1;
    }
    float f = 1.0F;
    if (n > 0)
    {
      paramParsableByteArray = (byte[])localArrayList.get(0);
      paramParsableByteArray = NalUnitUtil.parseSpsNalUnit((byte[])localArrayList.get(0), m, paramParsableByteArray.length);
      i = paramParsableByteArray.width;
      j = paramParsableByteArray.height;
      f = paramParsableByteArray.pixelWidthAspectRatio;
    }
    for (;;)
    {
      paramParsableByteArray = new AvcConfig(localArrayList, m, i, j, f);
      return paramParsableByteArray;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.video.AvcConfig
 * JD-Core Version:    0.7.0.1
 */