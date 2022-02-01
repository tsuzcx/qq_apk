package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

abstract class TagPayloadReader
{
  protected final TrackOutput output;
  
  protected TagPayloadReader(TrackOutput paramTrackOutput)
  {
    this.output = paramTrackOutput;
  }
  
  public final void consume(ParsableByteArray paramParsableByteArray, long paramLong)
  {
    if (parseHeader(paramParsableByteArray)) {
      parsePayload(paramParsableByteArray, paramLong);
    }
  }
  
  protected abstract boolean parseHeader(ParsableByteArray paramParsableByteArray);
  
  protected abstract void parsePayload(ParsableByteArray paramParsableByteArray, long paramLong);
  
  public abstract void seek();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.flv.TagPayloadReader
 * JD-Core Version:    0.7.0.1
 */