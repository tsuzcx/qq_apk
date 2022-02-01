package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class OpusReader
  extends StreamReader
{
  private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
  private static final int OPUS_CODE = Util.getIntegerCodeForString("Opus");
  private static final byte[] OPUS_SIGNATURE = { 79, 112, 117, 115, 72, 101, 97, 100 };
  private static final int SAMPLE_RATE = 48000;
  private boolean headerRead;
  
  private long getPacketDurationUs(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte[0] & 0xFF;
    int m = k & 0x3;
    int i = 2;
    int j;
    if (m != 0)
    {
      j = i;
      if (m != 1)
      {
        j = i;
        if (m != 2) {
          j = paramArrayOfByte[1] & 0x3F;
        }
      }
    }
    else
    {
      j = 1;
    }
    i = k >> 3;
    k = i & 0x3;
    if (i >= 16) {
      i = 2500 << k;
    } else if (i >= 12) {
      i = 10000 << (k & 0x1);
    } else if (k == 3) {
      i = 60000;
    } else {
      i = 10000 << k;
    }
    return j * i;
  }
  
  private void putNativeOrderLong(List<byte[]> paramList, int paramInt)
  {
    long l = paramInt * 1000000000L / 48000L;
    paramList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(l).array());
  }
  
  public static boolean verifyBitstreamType(ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.bytesLeft();
    byte[] arrayOfByte1 = OPUS_SIGNATURE;
    if (i < arrayOfByte1.length) {
      return false;
    }
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
    paramParsableByteArray.readBytes(arrayOfByte2, 0, arrayOfByte1.length);
    return Arrays.equals(arrayOfByte2, OPUS_SIGNATURE);
  }
  
  protected long preparePayload(ParsableByteArray paramParsableByteArray)
  {
    return convertTimeToGranule(getPacketDurationUs(paramParsableByteArray.data));
  }
  
  protected boolean readHeaders(ParsableByteArray paramParsableByteArray, long paramLong, StreamReader.SetupData paramSetupData)
  {
    boolean bool2 = this.headerRead;
    boolean bool1 = true;
    if (!bool2)
    {
      paramParsableByteArray = Arrays.copyOf(paramParsableByteArray.data, paramParsableByteArray.limit());
      int i = paramParsableByteArray[9];
      int j = paramParsableByteArray[11];
      int k = paramParsableByteArray[10];
      ArrayList localArrayList = new ArrayList(3);
      localArrayList.add(paramParsableByteArray);
      putNativeOrderLong(localArrayList, (j & 0xFF) << 8 | k & 0xFF);
      putNativeOrderLong(localArrayList, 3840);
      paramSetupData.format = Format.createAudioSampleFormat(null, "audio/opus", null, -1, -1, i & 0xFF, 48000, localArrayList, null, 0, null);
      this.headerRead = true;
      return true;
    }
    if (paramParsableByteArray.readInt() != OPUS_CODE) {
      bool1 = false;
    }
    paramParsableByteArray.setPosition(0);
    return bool1;
  }
  
  protected void reset(boolean paramBoolean)
  {
    super.reset(paramBoolean);
    if (paramBoolean) {
      this.headerRead = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.OpusReader
 * JD-Core Version:    0.7.0.1
 */