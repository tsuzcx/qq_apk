package com.google.android.exoplayer2.extractor.mp4;

abstract interface AtomParsers$SampleSizeBox
{
  public abstract int getSampleCount();
  
  public abstract boolean isFixedSampleSize();
  
  public abstract int readNextSampleSize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
 * JD-Core Version:    0.7.0.1
 */