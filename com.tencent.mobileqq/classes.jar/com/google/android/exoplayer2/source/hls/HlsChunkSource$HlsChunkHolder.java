package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;

public final class HlsChunkSource$HlsChunkHolder
{
  public Chunk chunk;
  public boolean endOfStream;
  public HlsMasterPlaylist.HlsUrl playlist;
  
  public HlsChunkSource$HlsChunkHolder()
  {
    clear();
  }
  
  public void clear()
  {
    this.chunk = null;
    this.endOfStream = false;
    this.playlist = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsChunkSource.HlsChunkHolder
 * JD-Core Version:    0.7.0.1
 */