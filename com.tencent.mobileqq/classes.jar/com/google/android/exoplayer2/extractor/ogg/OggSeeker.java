package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;

abstract interface OggSeeker
{
  public abstract SeekMap createSeekMap();
  
  public abstract long read(ExtractorInput paramExtractorInput);
  
  public abstract long startSeek(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.OggSeeker
 * JD-Core Version:    0.7.0.1
 */