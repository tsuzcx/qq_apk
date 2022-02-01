package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.FlacStreamInfo;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;

final class FlacReader
  extends StreamReader
{
  private static final byte AUDIO_PACKET_TYPE = -1;
  private static final int FRAME_HEADER_SAMPLE_NUMBER_OFFSET = 4;
  private static final byte SEEKTABLE_PACKET_TYPE = 3;
  private FlacReader.FlacOggSeeker flacOggSeeker;
  private FlacStreamInfo streamInfo;
  
  private int getFlacFrameBlockSize(ParsableByteArray paramParsableByteArray)
  {
    int i = (paramParsableByteArray.data[2] & 0xFF) >> 4;
    int j;
    switch (i)
    {
    default: 
      return -1;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
      j = 256;
      i -= 8;
    case 6: 
    case 7: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        return j << i;
        paramParsableByteArray.skipBytes(4);
        paramParsableByteArray.readUtf8EncodedLong();
        if (i == 6) {
          i = paramParsableByteArray.readUnsignedByte();
        } else {
          i = paramParsableByteArray.readUnsignedShort();
        }
        paramParsableByteArray.setPosition(0);
        return i + 1;
        j = 576;
        i -= 2;
      }
    }
    return 192;
  }
  
  private static boolean isAudioPacket(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte[0] == -1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean verifyBitstreamType(ParsableByteArray paramParsableByteArray)
  {
    return (paramParsableByteArray.bytesLeft() >= 5) && (paramParsableByteArray.readUnsignedByte() == 127) && (paramParsableByteArray.readUnsignedInt() == 1179402563L);
  }
  
  protected long preparePayload(ParsableByteArray paramParsableByteArray)
  {
    if (!isAudioPacket(paramParsableByteArray.data)) {
      return -1L;
    }
    return getFlacFrameBlockSize(paramParsableByteArray);
  }
  
  protected boolean readHeaders(ParsableByteArray paramParsableByteArray, long paramLong, StreamReader.SetupData paramSetupData)
  {
    byte[] arrayOfByte = paramParsableByteArray.data;
    if (this.streamInfo == null)
    {
      this.streamInfo = new FlacStreamInfo(arrayOfByte, 17);
      paramParsableByteArray = Arrays.copyOfRange(arrayOfByte, 9, paramParsableByteArray.limit());
      paramParsableByteArray[4] = -128;
      paramParsableByteArray = Collections.singletonList(paramParsableByteArray);
      paramSetupData.format = Format.createAudioSampleFormat(null, "audio/flac", null, -1, this.streamInfo.bitRate(), this.streamInfo.channels, this.streamInfo.sampleRate, paramParsableByteArray, null, 0, null);
    }
    else if ((arrayOfByte[0] & 0x7F) == 3)
    {
      this.flacOggSeeker = new FlacReader.FlacOggSeeker(this);
      this.flacOggSeeker.parseSeekTable(paramParsableByteArray);
    }
    else if (isAudioPacket(arrayOfByte))
    {
      paramParsableByteArray = this.flacOggSeeker;
      if (paramParsableByteArray != null)
      {
        paramParsableByteArray.setFirstFrameOffset(paramLong);
        paramSetupData.oggSeeker = this.flacOggSeeker;
      }
      return false;
    }
    return true;
  }
  
  protected void reset(boolean paramBoolean)
  {
    super.reset(paramBoolean);
    if (paramBoolean)
    {
      this.streamInfo = null;
      this.flacOggSeeker = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.FlacReader
 * JD-Core Version:    0.7.0.1
 */