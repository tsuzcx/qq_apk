package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.Format;

public final class HlsMasterPlaylist$HlsUrl
{
  public final Format format;
  public final String url;
  
  public HlsMasterPlaylist$HlsUrl(String paramString, Format paramFormat)
  {
    this.url = paramString;
    this.format = paramFormat;
  }
  
  public static HlsUrl createMediaPlaylistHlsUrl(String paramString)
  {
    return new HlsUrl(paramString, Format.createContainerFormat("0", "application/x-mpegURL", null, null, -1, 0, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl
 * JD-Core Version:    0.7.0.1
 */