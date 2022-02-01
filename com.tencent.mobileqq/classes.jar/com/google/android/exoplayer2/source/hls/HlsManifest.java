package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;

public final class HlsManifest
{
  public final HlsMasterPlaylist masterPlaylist;
  public final HlsMediaPlaylist mediaPlaylist;
  
  HlsManifest(HlsMasterPlaylist paramHlsMasterPlaylist, HlsMediaPlaylist paramHlsMediaPlaylist)
  {
    this.masterPlaylist = paramHlsMasterPlaylist;
    this.mediaPlaylist = paramHlsMediaPlaylist;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsManifest
 * JD-Core Version:    0.7.0.1
 */