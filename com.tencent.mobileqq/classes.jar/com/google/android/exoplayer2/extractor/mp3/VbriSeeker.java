package com.google.android.exoplayer2.extractor.mp3;

import android.util.Log;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class VbriSeeker
  implements Mp3Extractor.Seeker
{
  private static final String TAG = "VbriSeeker";
  private final long durationUs;
  private final long[] positions;
  private final long[] timesUs;
  
  private VbriSeeker(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong)
  {
    this.timesUs = paramArrayOfLong1;
    this.positions = paramArrayOfLong2;
    this.durationUs = paramLong;
  }
  
  public static VbriSeeker create(long paramLong1, long paramLong2, MpegAudioHeader paramMpegAudioHeader, ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.skipBytes(10);
    int i = paramParsableByteArray.readInt();
    if (i <= 0) {
      return null;
    }
    int j = paramMpegAudioHeader.sampleRate;
    long l1 = i;
    if (j >= 32000) {
      i = 1152;
    } else {
      i = 576;
    }
    l1 = Util.scaleLargeTimestamp(l1, 1000000L * i, j);
    int k = paramParsableByteArray.readUnsignedShort();
    int m = paramParsableByteArray.readUnsignedShort();
    int n = paramParsableByteArray.readUnsignedShort();
    paramParsableByteArray.skipBytes(2);
    long l2 = paramMpegAudioHeader.frameSize;
    paramMpegAudioHeader = new long[k];
    long[] arrayOfLong = new long[k];
    j = 0;
    long l3 = paramLong2 + l2;
    l2 = paramLong2;
    paramLong2 = l3;
    while (j < k)
    {
      paramMpegAudioHeader[j] = (j * l1 / k);
      arrayOfLong[j] = Math.max(l2, paramLong2);
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 4) {
              return null;
            }
            i = paramParsableByteArray.readUnsignedIntToInt();
          }
          else
          {
            i = paramParsableByteArray.readUnsignedInt24();
          }
        }
        else {
          i = paramParsableByteArray.readUnsignedShort();
        }
      }
      else {
        i = paramParsableByteArray.readUnsignedByte();
      }
      l2 += i * m;
      j += 1;
    }
    if ((paramLong1 != -1L) && (paramLong1 != l2))
    {
      paramParsableByteArray = new StringBuilder();
      paramParsableByteArray.append("VBRI data size mismatch: ");
      paramParsableByteArray.append(paramLong1);
      paramParsableByteArray.append(", ");
      paramParsableByteArray.append(l2);
      Log.w("VbriSeeker", paramParsableByteArray.toString());
    }
    return new VbriSeeker(paramMpegAudioHeader, arrayOfLong, l1);
  }
  
  public long getDurationUs()
  {
    return this.durationUs;
  }
  
  public SeekMap.SeekPoints getSeekPoints(long paramLong)
  {
    int i = Util.binarySearchFloor(this.timesUs, paramLong, true, true);
    SeekPoint localSeekPoint = new SeekPoint(this.timesUs[i], this.positions[i]);
    if (localSeekPoint.timeUs < paramLong)
    {
      long[] arrayOfLong = this.timesUs;
      if (i != arrayOfLong.length - 1)
      {
        i += 1;
        return new SeekMap.SeekPoints(localSeekPoint, new SeekPoint(arrayOfLong[i], this.positions[i]));
      }
    }
    return new SeekMap.SeekPoints(localSeekPoint);
  }
  
  public long getTimeUs(long paramLong)
  {
    return this.timesUs[Util.binarySearchFloor(this.positions, paramLong, true, true)];
  }
  
  public boolean isSeekable()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp3.VbriSeeker
 * JD-Core Version:    0.7.0.1
 */