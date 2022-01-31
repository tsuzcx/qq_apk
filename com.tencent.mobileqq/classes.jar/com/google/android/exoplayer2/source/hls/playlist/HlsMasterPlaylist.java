package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HlsMasterPlaylist
  extends HlsPlaylist
{
  public final List<HlsMasterPlaylist.HlsUrl> audios;
  public final Format muxedAudioFormat;
  public final List<Format> muxedCaptionFormats;
  public final List<HlsMasterPlaylist.HlsUrl> subtitles;
  public final List<HlsMasterPlaylist.HlsUrl> variants;
  
  public HlsMasterPlaylist(String paramString, List<String> paramList, List<HlsMasterPlaylist.HlsUrl> paramList1, List<HlsMasterPlaylist.HlsUrl> paramList2, List<HlsMasterPlaylist.HlsUrl> paramList3, Format paramFormat, List<Format> paramList4)
  {
    super(paramString, paramList);
    this.variants = Collections.unmodifiableList(paramList1);
    this.audios = Collections.unmodifiableList(paramList2);
    this.subtitles = Collections.unmodifiableList(paramList3);
    this.muxedAudioFormat = paramFormat;
    if (paramList4 != null) {}
    for (paramString = Collections.unmodifiableList(paramList4);; paramString = null)
    {
      this.muxedCaptionFormats = paramString;
      return;
    }
  }
  
  private static List<HlsMasterPlaylist.HlsUrl> copyRenditionsList(List<HlsMasterPlaylist.HlsUrl> paramList, List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList(paramList1.size());
    int i = 0;
    while (i < paramList.size())
    {
      HlsMasterPlaylist.HlsUrl localHlsUrl = (HlsMasterPlaylist.HlsUrl)paramList.get(i);
      if (paramList1.contains(localHlsUrl.url)) {
        localArrayList.add(localHlsUrl);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static HlsMasterPlaylist createSingleVariantMasterPlaylist(String paramString)
  {
    paramString = Collections.singletonList(HlsMasterPlaylist.HlsUrl.createMediaPlaylistHlsUrl(paramString));
    List localList = Collections.emptyList();
    return new HlsMasterPlaylist(null, Collections.emptyList(), paramString, localList, localList, null, null);
  }
  
  public HlsMasterPlaylist copy(List<String> paramList)
  {
    return new HlsMasterPlaylist(this.baseUri, this.tags, copyRenditionsList(this.variants, paramList), copyRenditionsList(this.audios, paramList), copyRenditionsList(this.subtitles, paramList), this.muxedAudioFormat, this.muxedCaptionFormats);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist
 * JD-Core Version:    0.7.0.1
 */