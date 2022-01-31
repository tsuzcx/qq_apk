package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;

public abstract interface TrackOutput
{
  public abstract void format(Format paramFormat);
  
  public abstract int sampleData(ExtractorInput paramExtractorInput, int paramInt, boolean paramBoolean);
  
  public abstract void sampleData(ParsableByteArray paramParsableByteArray, int paramInt);
  
  public abstract void sampleMetadata(long paramLong, int paramInt1, int paramInt2, int paramInt3, TrackOutput.CryptoData paramCryptoData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.TrackOutput
 * JD-Core Version:    0.7.0.1
 */