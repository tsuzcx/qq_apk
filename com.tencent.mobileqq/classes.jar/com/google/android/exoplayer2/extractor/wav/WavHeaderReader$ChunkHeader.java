package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class WavHeaderReader$ChunkHeader
{
  public static final int SIZE_IN_BYTES = 8;
  public final int id;
  public final long size;
  
  private WavHeaderReader$ChunkHeader(int paramInt, long paramLong)
  {
    this.id = paramInt;
    this.size = paramLong;
  }
  
  public static ChunkHeader peek(ExtractorInput paramExtractorInput, ParsableByteArray paramParsableByteArray)
  {
    paramExtractorInput.peekFully(paramParsableByteArray.data, 0, 8);
    paramParsableByteArray.setPosition(0);
    return new ChunkHeader(paramParsableByteArray.readInt(), paramParsableByteArray.readLittleEndianUnsignedInt());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.wav.WavHeaderReader.ChunkHeader
 * JD-Core Version:    0.7.0.1
 */