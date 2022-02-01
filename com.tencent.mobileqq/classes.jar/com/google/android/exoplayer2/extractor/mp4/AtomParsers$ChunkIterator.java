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
    int i = paramParsableByteArray1.readInt();
    paramBoolean = true;
    if (i != 1) {
      paramBoolean = false;
    }
    Assertions.checkState(paramBoolean, "first_chunk must be 1");
    this.index = -1;
  }
  
  public boolean moveNext()
  {
    int i = this.index + 1;
    this.index = i;
    if (i == this.length) {
      return false;
    }
    long l;
    if (this.chunkOffsetsAreLongs) {
      l = this.chunkOffsets.readUnsignedLongToLong();
    } else {
      l = this.chunkOffsets.readUnsignedInt();
    }
    this.offset = l;
    if (this.index == this.nextSamplesPerChunkChangeIndex)
    {
      this.numSamples = this.stsc.readUnsignedIntToInt();
      this.stsc.skipBytes(4);
      i = this.remainingSamplesPerChunkChanges - 1;
      this.remainingSamplesPerChunkChanges = i;
      if (i > 0) {
        i = this.stsc.readUnsignedIntToInt() - 1;
      } else {
        i = -1;
      }
      this.nextSamplesPerChunkChangeIndex = i;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.AtomParsers.ChunkIterator
 * JD-Core Version:    0.7.0.1
 */