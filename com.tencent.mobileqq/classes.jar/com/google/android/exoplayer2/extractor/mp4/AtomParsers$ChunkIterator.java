package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class AtomParsers$ChunkIterator
{
  private final ParsableByteArray chunkOffsets;
  private final boolean chunkOffsetsAreLongs;
  public int index;
  public final int length;
  private int nextSamplesPerChunkChangeIndex;
  public int numSamples;
  public long offset;
  private int remainingSamplesPerChunkChanges;
  private final ParsableByteArray stsc;
  
  public AtomParsers$ChunkIterator(ParsableByteArray paramParsableByteArray1, ParsableByteArray paramParsableByteArray2, boolean paramBoolean)
  {
    this.stsc = paramParsableByteArray1;
    this.chunkOffsets = paramParsableByteArray2;
    this.chunkOffsetsAreLongs = paramBoolean;
    paramParsableByteArray2.setPosition(12);
    this.length = paramParsableByteArray2.readUnsignedIntToInt();
    paramParsableByteArray1.setPosition(12);
    this.remainingSamplesPerChunkChanges = paramParsableByteArray1.readUnsignedIntToInt();
    if (paramParsableByteArray1.readInt() == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      Assertions.checkState(paramBoolean, "first_chunk must be 1");
      this.index = -1;
      return;
    }
  }
  
  public boolean moveNext()
  {
    int i = this.index + 1;
    this.index = i;
    if (i == this.length) {
      return false;
    }
    long l;
    if (this.chunkOffsetsAreLongs)
    {
      l = this.chunkOffsets.readUnsignedLongToLong();
      this.offset = l;
      if (this.index == this.nextSamplesPerChunkChangeIndex)
      {
        this.numSamples = this.stsc.readUnsignedIntToInt();
        this.stsc.skipBytes(4);
        i = this.remainingSamplesPerChunkChanges - 1;
        this.remainingSamplesPerChunkChanges = i;
        if (i <= 0) {
          break label116;
        }
      }
    }
    label116:
    for (i = this.stsc.readUnsignedIntToInt() - 1;; i = -1)
    {
      this.nextSamplesPerChunkChangeIndex = i;
      return true;
      l = this.chunkOffsets.readUnsignedInt();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.AtomParsers.ChunkIterator
 * JD-Core Version:    0.7.0.1
 */