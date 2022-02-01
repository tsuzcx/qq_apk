package com.google.android.exoplayer2.extractor;

public abstract interface Extractor
{
  public static final int RESULT_CONTINUE = 0;
  public static final int RESULT_END_OF_INPUT = -1;
  public static final int RESULT_SEEK = 1;
  
  public abstract void init(ExtractorOutput paramExtractorOutput);
  
  public abstract int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder);
  
  public abstract void release();
  
  public abstract void seek(long paramLong1, long paramLong2);
  
  public abstract boolean sniff(ExtractorInput paramExtractorInput);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.Extractor
 * JD-Core Version:    0.7.0.1
 */