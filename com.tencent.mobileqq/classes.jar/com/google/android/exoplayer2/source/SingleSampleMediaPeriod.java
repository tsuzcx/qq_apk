package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import java.io.IOException;
import java.util.ArrayList;

final class SingleSampleMediaPeriod
  implements MediaPeriod, Loader.Callback<SingleSampleMediaPeriod.SourceLoadable>
{
  private static final int INITIAL_SAMPLE_SIZE = 1024;
  private final DataSource.Factory dataSourceFactory;
  private final DataSpec dataSpec;
  private final long durationUs;
  private int errorCount;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  final Format format;
  final Loader loader;
  boolean loadingFinished;
  boolean loadingSucceeded;
  private final int minLoadableRetryCount;
  byte[] sampleData;
  int sampleSize;
  private final ArrayList<SingleSampleMediaPeriod.SampleStreamImpl> sampleStreams;
  private final TrackGroupArray tracks;
  final boolean treatLoadErrorsAsEndOfStream;
  
  public SingleSampleMediaPeriod(DataSpec paramDataSpec, DataSource.Factory paramFactory, Format paramFormat, long paramLong, int paramInt, MediaSourceEventListener.EventDispatcher paramEventDispatcher, boolean paramBoolean)
  {
    this.dataSpec = paramDataSpec;
    this.dataSourceFactory = paramFactory;
    this.format = paramFormat;
    this.durationUs = paramLong;
    this.minLoadableRetryCount = paramInt;
    this.eventDispatcher = paramEventDispatcher;
    this.treatLoadErrorsAsEndOfStream = paramBoolean;
    this.tracks = new TrackGroupArray(new TrackGroup[] { new TrackGroup(new Format[] { paramFormat }) });
    this.sampleStreams = new ArrayList();
    this.loader = new Loader("Loader:SingleSampleMediaPeriod");
  }
  
  public boolean continueLoading(long paramLong)
  {
    if ((this.loadingFinished) || (this.loader.isLoading())) {
      return false;
    }
    paramLong = this.loader.startLoading(new SingleSampleMediaPeriod.SourceLoadable(this.dataSpec, this.dataSourceFactory.createDataSource()), this, this.minLoadableRetryCount);
    this.eventDispatcher.loadStarted(this.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, paramLong);
    return true;
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean) {}
  
  public long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters)
  {
    return paramLong;
  }
  
  public long getBufferedPositionUs()
  {
    if (this.loadingFinished) {
      return -9223372036854775808L;
    }
    return 0L;
  }
  
  public long getNextLoadPositionUs()
  {
    if ((this.loadingFinished) || (this.loader.isLoading())) {
      return -9223372036854775808L;
    }
    return 0L;
  }
  
  public TrackGroupArray getTrackGroups()
  {
    return this.tracks;
  }
  
  public void maybeThrowPrepareError() {}
  
  public void onLoadCanceled(SingleSampleMediaPeriod.SourceLoadable paramSourceLoadable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.eventDispatcher.loadCanceled(paramSourceLoadable.dataSpec, 1, -1, null, 0, null, 0L, this.durationUs, paramLong1, paramLong2, SingleSampleMediaPeriod.SourceLoadable.access$100(paramSourceLoadable));
  }
  
  public void onLoadCompleted(SingleSampleMediaPeriod.SourceLoadable paramSourceLoadable, long paramLong1, long paramLong2)
  {
    this.eventDispatcher.loadCompleted(paramSourceLoadable.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, paramLong1, paramLong2, SingleSampleMediaPeriod.SourceLoadable.access$100(paramSourceLoadable));
    this.sampleSize = SingleSampleMediaPeriod.SourceLoadable.access$100(paramSourceLoadable);
    this.sampleData = SingleSampleMediaPeriod.SourceLoadable.access$200(paramSourceLoadable);
    this.loadingFinished = true;
    this.loadingSucceeded = true;
  }
  
  public int onLoadError(SingleSampleMediaPeriod.SourceLoadable paramSourceLoadable, long paramLong1, long paramLong2, IOException paramIOException)
  {
    this.errorCount += 1;
    if ((this.treatLoadErrorsAsEndOfStream) && (this.errorCount >= this.minLoadableRetryCount)) {}
    for (boolean bool = true;; bool = false)
    {
      this.eventDispatcher.loadError(paramSourceLoadable.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, paramLong1, paramLong2, SingleSampleMediaPeriod.SourceLoadable.access$100(paramSourceLoadable), paramIOException, bool);
      if (!bool) {
        break;
      }
      this.loadingFinished = true;
      return 2;
    }
    return 0;
  }
  
  public void prepare(MediaPeriod.Callback paramCallback, long paramLong)
  {
    paramCallback.onPrepared(this);
  }
  
  public long readDiscontinuity()
  {
    return -9223372036854775807L;
  }
  
  public void reevaluateBuffer(long paramLong) {}
  
  public void release()
  {
    this.loader.release();
  }
  
  public long seekToUs(long paramLong)
  {
    int i = 0;
    while (i < this.sampleStreams.size())
    {
      ((SingleSampleMediaPeriod.SampleStreamImpl)this.sampleStreams.get(i)).reset();
      i += 1;
    }
    return paramLong;
  }
  
  public long selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int i = 0;
    while (i < paramArrayOfTrackSelection.length)
    {
      if ((paramArrayOfSampleStream[i] != null) && ((paramArrayOfTrackSelection[i] == null) || (paramArrayOfBoolean1[i] == 0)))
      {
        this.sampleStreams.remove(paramArrayOfSampleStream[i]);
        paramArrayOfSampleStream[i] = null;
      }
      if ((paramArrayOfSampleStream[i] == null) && (paramArrayOfTrackSelection[i] != null))
      {
        SingleSampleMediaPeriod.SampleStreamImpl localSampleStreamImpl = new SingleSampleMediaPeriod.SampleStreamImpl(this, null);
        this.sampleStreams.add(localSampleStreamImpl);
        paramArrayOfSampleStream[i] = localSampleStreamImpl;
        paramArrayOfBoolean2[i] = true;
      }
      i += 1;
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SingleSampleMediaPeriod
 * JD-Core Version:    0.7.0.1
 */