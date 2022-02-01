package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import java.io.InputStream;
import java.util.List;

public final class FilteringHlsPlaylistParser
  implements ParsingLoadable.Parser<HlsPlaylist>
{
  private final List<String> filter;
  private final HlsPlaylistParser hlsPlaylistParser = new HlsPlaylistParser();
  
  public FilteringHlsPlaylistParser(List<String> paramList)
  {
    this.filter = paramList;
  }
  
  public HlsPlaylist parse(Uri paramUri, InputStream paramInputStream)
  {
    paramInputStream = this.hlsPlaylistParser.parse(paramUri, paramInputStream);
    paramUri = paramInputStream;
    if ((paramInputStream instanceof HlsMasterPlaylist)) {
      paramUri = ((HlsMasterPlaylist)paramInputStream).copy(this.filter);
    }
    return paramUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParser
 * JD-Core Version:    0.7.0.1
 */