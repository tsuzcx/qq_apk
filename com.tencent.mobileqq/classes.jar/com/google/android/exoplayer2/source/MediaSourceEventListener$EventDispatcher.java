package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class MediaSourceEventListener$EventDispatcher
{
  @Nullable
  private final Handler handler;
  @Nullable
  private final MediaSourceEventListener listener;
  private final long mediaTimeOffsetMs;
  
  public MediaSourceEventListener$EventDispatcher(@Nullable Handler paramHandler, @Nullable MediaSourceEventListener paramMediaSourceEventListener)
  {
    this(paramHandler, paramMediaSourceEventListener, 0L);
  }
  
  public MediaSourceEventListener$EventDispatcher(@Nullable Handler paramHandler, @Nullable MediaSourceEventListener paramMediaSourceEventListener, long paramLong)
  {
    if (paramMediaSourceEventListener != null) {}
    for (paramHandler = (Handler)Assertions.checkNotNull(paramHandler);; paramHandler = null)
    {
      this.handler = paramHandler;
      this.listener = paramMediaSourceEventListener;
      this.mediaTimeOffsetMs = paramLong;
      return;
    }
  }
  
  private long adjustMediaTime(long paramLong)
  {
    paramLong = C.usToMs(paramLong);
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    return this.mediaTimeOffsetMs + paramLong;
  }
  
  public EventDispatcher copyWithMediaTimeOffsetMs(long paramLong)
  {
    return new EventDispatcher(this.handler, this.listener, paramLong);
  }
  
  public void downstreamFormatChanged(int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong)
  {
    if ((this.listener != null) && (this.handler != null)) {
      this.handler.post(new MediaSourceEventListener.EventDispatcher.6(this, paramInt1, paramFormat, paramInt2, paramObject, paramLong));
    }
  }
  
  public void loadCanceled(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    if ((this.listener != null) && (this.handler != null)) {
      this.handler.post(new MediaSourceEventListener.EventDispatcher.3(this, paramDataSpec, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5));
    }
  }
  
  public void loadCanceled(DataSpec paramDataSpec, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    loadCanceled(paramDataSpec, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
  }
  
  public void loadCompleted(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    if ((this.listener != null) && (this.handler != null)) {
      this.handler.post(new MediaSourceEventListener.EventDispatcher.2(this, paramDataSpec, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5));
    }
  }
  
  public void loadCompleted(DataSpec paramDataSpec, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    loadCompleted(paramDataSpec, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3);
  }
  
  public void loadError(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
  {
    if ((this.listener != null) && (this.handler != null)) {
      this.handler.post(new MediaSourceEventListener.EventDispatcher.4(this, paramDataSpec, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramIOException, paramBoolean));
    }
  }
  
  public void loadError(DataSpec paramDataSpec, int paramInt, long paramLong1, long paramLong2, long paramLong3, IOException paramIOException, boolean paramBoolean)
  {
    loadError(paramDataSpec, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramIOException, paramBoolean);
  }
  
  public void loadStarted(DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((this.listener != null) && (this.handler != null)) {
      this.handler.post(new MediaSourceEventListener.EventDispatcher.1(this, paramDataSpec, paramInt1, paramInt2, paramFormat, paramInt3, paramObject, paramLong1, paramLong2, paramLong3));
    }
  }
  
  public void loadStarted(DataSpec paramDataSpec, int paramInt, long paramLong)
  {
    loadStarted(paramDataSpec, paramInt, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, paramLong);
  }
  
  public void upstreamDiscarded(int paramInt, long paramLong1, long paramLong2)
  {
    if ((this.listener != null) && (this.handler != null)) {
      this.handler.post(new MediaSourceEventListener.EventDispatcher.5(this, paramInt, paramLong1, paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher
 * JD-Core Version:    0.7.0.1
 */