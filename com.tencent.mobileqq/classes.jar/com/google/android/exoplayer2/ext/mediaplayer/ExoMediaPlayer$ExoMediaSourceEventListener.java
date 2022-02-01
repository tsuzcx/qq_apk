package com.google.android.exoplayer2.ext.mediaplayer;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

class ExoMediaPlayer$ExoMediaSourceEventListener
  implements MediaSourceEventListener
{
  private ExoMediaPlayer$ExoMediaSourceEventListener(ExoMediaPlayer paramExoMediaPlayer) {}
  
  public void onDownstreamFormatChanged(int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong) {}
  
  public void onLoadCanceled(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
  
  public void onLoadCompleted(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
  
  public void onLoadError(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    paramFormat = ExoMediaPlayer.getLogger();
    paramObject = new StringBuilder();
    paramObject.append("loadError ");
    paramObject.append(paramDataSpec);
    paramObject.append(",");
    paramObject.append(paramInt1);
    paramObject.append(",");
    paramObject.append(paramInt2);
    paramObject.append(",");
    paramObject.append(paramLong3);
    paramObject.append("\n");
    paramObject.append(ExoMediaPlayerUtils.getPrintableStackTrace(paramIOException));
    paramFormat.i("ExoMediaPlayer", paramObject.toString());
  }
  
  public void onLoadStarted(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3)
  {
    paramFormat = ExoMediaPlayer.getLogger();
    paramObject = new StringBuilder();
    paramObject.append("loadStart ");
    paramObject.append(paramDataSpec);
    paramObject.append(",");
    paramObject.append(paramInt1);
    paramObject.append(",");
    paramObject.append(paramInt2);
    paramObject.append(",");
    paramObject.append(paramLong3);
    paramFormat.i("ExoMediaPlayer", paramObject.toString());
  }
  
  public void onUpstreamDiscarded(int paramInt, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer.ExoMediaSourceEventListener
 * JD-Core Version:    0.7.0.1
 */