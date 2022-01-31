package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.ParsableByteArray;

final class AtomParsers$Stz2SampleSizeBox
  implements AtomParsers.SampleSizeBox
{
  private int currentByte;
  private final ParsableByteArray data;
  private final int fieldSize;
  private final int sampleCount;
  private int sampleIndex;
  
  public AtomParsers$Stz2SampleSizeBox(Atom.LeafAtom paramLeafAtom)
  {
    this.data = paramLeafAtom.data;
    this.data.setPosition(12);
    this.fieldSize = (this.data.readUnsignedIntToInt() & 0xFF);
    this.sampleCount = this.data.readUnsignedIntToInt();
  }
  
  public int getSampleCount()
  {
    return this.sampleCount;
  }
  
  public boolean isFixedSampleSize()
  {
    return false;
  }
  
  public int readNextSampleSize()
  {
    if (this.fieldSize == 8) {
      return this.data.readUnsignedByte();
    }
    if (this.fieldSize == 16) {
      return this.data.readUnsignedShort();
    }
    int i = this.sampleIndex;
    this.sampleIndex = (i + 1);
    if (i % 2 == 0)
    {
      this.currentByte = this.data.readUnsignedByte();
      return (this.currentByte & 0xF0) >> 4;
    }
    return this.currentByte & 0xF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.AtomParsers.Stz2SampleSizeBox
 * JD-Core Version:    0.7.0.1
 */