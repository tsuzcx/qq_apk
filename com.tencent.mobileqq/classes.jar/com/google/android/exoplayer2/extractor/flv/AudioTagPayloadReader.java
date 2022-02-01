package com.google.android.exoplayer2.extractor.flv;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;

final class AudioTagPayloadReader
  extends TagPayloadReader
{
  private static final int AAC_PACKET_TYPE_AAC_RAW = 1;
  private static final int AAC_PACKET_TYPE_SEQUENCE_HEADER = 0;
  private static final int AUDIO_FORMAT_AAC = 10;
  private static final int AUDIO_FORMAT_ALAW = 7;
  private static final int AUDIO_FORMAT_MP3 = 2;
  private static final int AUDIO_FORMAT_ULAW = 8;
  private static final int[] AUDIO_SAMPLING_RATE_TABLE = { 5512, 11025, 22050, 44100 };
  private int audioFormat;
  private boolean hasOutputFormat;
  private boolean hasParsedAudioDataHeader;
  
  public AudioTagPayloadReader(TrackOutput paramTrackOutput)
  {
    super(paramTrackOutput);
  }
  
  protected boolean parseHeader(ParsableByteArray paramParsableByteArray)
  {
    int i;
    if (!this.hasParsedAudioDataHeader)
    {
      i = paramParsableByteArray.readUnsignedByte();
      this.audioFormat = (i >> 4 & 0xF);
      if (this.audioFormat == 2)
      {
        paramParsableByteArray = Format.createAudioSampleFormat(null, "audio/mpeg", null, -1, -1, 1, AUDIO_SAMPLING_RATE_TABLE[(i >> 2 & 0x3)], null, null, 0, null);
        this.output.format(paramParsableByteArray);
        this.hasOutputFormat = true;
        this.hasParsedAudioDataHeader = true;
      }
    }
    for (;;)
    {
      return true;
      if ((this.audioFormat == 7) || (this.audioFormat == 8))
      {
        if (this.audioFormat == 7)
        {
          paramParsableByteArray = "audio/g711-alaw";
          label106:
          if ((i & 0x1) != 1) {
            break label157;
          }
        }
        label157:
        for (i = 2;; i = 3)
        {
          paramParsableByteArray = Format.createAudioSampleFormat(null, paramParsableByteArray, null, -1, -1, 1, 8000, i, null, null, 0, null);
          this.output.format(paramParsableByteArray);
          this.hasOutputFormat = true;
          break;
          paramParsableByteArray = "audio/g711-mlaw";
          break label106;
        }
      }
      if (this.audioFormat == 10) {
        break;
      }
      throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.audioFormat);
      paramParsableByteArray.skipBytes(1);
    }
  }
  
  protected void parsePayload(ParsableByteArray paramParsableByteArray, long paramLong)
  {
    if (this.audioFormat == 2)
    {
      i = paramParsableByteArray.bytesLeft();
      this.output.sampleData(paramParsableByteArray, i);
      this.output.sampleMetadata(paramLong, 1, i, 0, null);
    }
    do
    {
      return;
      i = paramParsableByteArray.readUnsignedByte();
      if ((i == 0) && (!this.hasOutputFormat))
      {
        byte[] arrayOfByte = new byte[paramParsableByteArray.bytesLeft()];
        paramParsableByteArray.readBytes(arrayOfByte, 0, arrayOfByte.length);
        paramParsableByteArray = CodecSpecificDataUtil.parseAacAudioSpecificConfig(arrayOfByte);
        paramParsableByteArray = Format.createAudioSampleFormat(null, "audio/mp4a-latm", null, -1, -1, ((Integer)paramParsableByteArray.second).intValue(), ((Integer)paramParsableByteArray.first).intValue(), Collections.singletonList(arrayOfByte), null, 0, null);
        this.output.format(paramParsableByteArray);
        this.hasOutputFormat = true;
        return;
      }
    } while ((this.audioFormat == 10) && (i != 1));
    int i = paramParsableByteArray.bytesLeft();
    this.output.sampleData(paramParsableByteArray, i);
    this.output.sampleMetadata(paramLong, 1, i, 0, null);
  }
  
  public void seek() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.flv.AudioTagPayloadReader
 * JD-Core Version:    0.7.0.1
 */