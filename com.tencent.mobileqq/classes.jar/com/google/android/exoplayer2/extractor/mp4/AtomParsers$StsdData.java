package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;

final class AtomParsers$StsdData
{
  public static final int STSD_HEADER_SIZE = 8;
  public Format format;
  public int nalUnitLengthFieldLength;
  public int requiredSampleTransformation;
  public final TrackEncryptionBox[] trackEncryptionBoxes;
  
  public AtomParsers$StsdData(int paramInt)
  {
    this.trackEncryptionBoxes = new TrackEncryptionBox[paramInt];
    this.requiredSampleTransformation = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData
 * JD-Core Version:    0.7.0.1
 */