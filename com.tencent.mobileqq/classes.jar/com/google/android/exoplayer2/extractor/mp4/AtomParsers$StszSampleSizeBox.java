package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.ParsableByteArray;

final class AtomParsers$StszSampleSizeBox
  implements AtomParsers.SampleSizeBox
{
  private final ParsableByteArray data;
  private final int fixedSampleSize;
  private final int sampleCount;
  
  public AtomParsers$StszSampleSizeBox(Atom.LeafAtom paramLeafAtom)
  {
    this.data = paramLeafAtom.data;
    this.data.setPosition(12);
    this.fixedSampleSize = this.data.readUnsignedIntToInt();
    this.sampleCount = this.data.readUnsignedIntToInt();
  }
  
  public int getSampleCount()
  {
    return this.sampleCount;
  }
  
  public boolean isFixedSampleSize()
  {
    return this.fixedSampleSize != 0;
  }
  
  public int readNextSampleSize()
  {
    int j = this.fixedSampleSize;
    int i = j;
    if (j == 0) {
      i = this.data.readUnsignedIntToInt();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.AtomParsers.StszSampleSizeBox
 * JD-Core Version:    0.7.0.1
 */