package com.google.android.exoplayer2.source.chunk;

public final class ChunkHolder
{
  public Chunk chunk;
  public boolean endOfStream;
  
  public void clear()
  {
    this.chunk = null;
    this.endOfStream = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.ChunkHolder
 * JD-Core Version:    0.7.0.1
 */