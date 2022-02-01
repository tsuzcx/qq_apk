package com.google.android.exoplayer2.source.ads;

import android.view.ViewGroup;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.IOException;

public abstract interface AdsLoader
{
  public abstract void attachPlayer(ExoPlayer paramExoPlayer, AdsLoader.EventListener paramEventListener, ViewGroup paramViewGroup);
  
  public abstract void detachPlayer();
  
  public abstract void handlePrepareError(int paramInt1, int paramInt2, IOException paramIOException);
  
  public abstract void release();
  
  public abstract void setSupportedContentTypes(int... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ads.AdsLoader
 * JD-Core Version:    0.7.0.1
 */