package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public abstract interface AdsMediaSource$MediaSourceFactory
{
  public abstract MediaSource createMediaSource(Uri paramUri, @Nullable Handler paramHandler, @Nullable MediaSourceEventListener paramMediaSourceEventListener);
  
  public abstract int[] getSupportedTypes();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
 * JD-Core Version:    0.7.0.1
 */