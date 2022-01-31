package com.google.android.exoplayer2.extractor;

public abstract interface ExtractorOutput
{
  public abstract void endTracks();
  
  public abstract void seekMap(SeekMap paramSeekMap);
  
  public abstract TrackOutput track(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ExtractorOutput
 * JD-Core Version:    0.7.0.1
 */