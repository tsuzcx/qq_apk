package com.google.android.exoplayer2.source.hls.playlist;

import java.util.Collections;
import java.util.List;

public abstract class HlsPlaylist
{
  public final String baseUri;
  public final List<String> tags;
  
  protected HlsPlaylist(String paramString, List<String> paramList)
  {
    this.baseUri = paramString;
    this.tags = Collections.unmodifiableList(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist
 * JD-Core Version:    0.7.0.1
 */