package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.SequenceableLoader.Callback;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;

public abstract interface HlsSampleStreamWrapper$Callback
  extends SequenceableLoader.Callback<HlsSampleStreamWrapper>
{
  public abstract void onPlaylistRefreshRequired(HlsMasterPlaylist.HlsUrl paramHlsUrl);
  
  public abstract void onPrepared();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
 * JD-Core Version:    0.7.0.1
 */