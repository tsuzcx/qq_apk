package com.google.android.exoplayer2.source.hls;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class HlsMediaChunk
  extends MediaChunk
{
  private static final String PRIV_TIMESTAMP_FRAME_OWNER = "com.apple.streaming.transportStreamTimestamp";
  private static final AtomicInteger uidSource = new AtomicInteger();
  private int bytesLoaded;
  public final int discontinuitySequenceNumber;
  private final Extractor extractor;
  private final boolean hasGapTag;
  public final HlsMasterPlaylist.HlsUrl hlsUrl;
  private final ParsableByteArray id3Data;
  private final Id3Decoder id3Decoder;
  private boolean id3TimestampPeeked;
  private final DataSource initDataSource;
  private final DataSpec initDataSpec;
  private boolean initLoadCompleted;
  private int initSegmentBytesLoaded;
  private final boolean isEncrypted;
  private final boolean isMasterTimestampSource;
  private final boolean isPackedAudioExtractor;
  private volatile boolean loadCanceled;
  private volatile boolean loadCompleted;
  private HlsSampleStreamWrapper output;
  private final boolean reusingExtractor;
  private final boolean shouldSpliceIn;
  private final TimestampAdjuster timestampAdjuster;
  public final int uid;
  
  public HlsMediaChunk(HlsExtractorFactory paramHlsExtractorFactory, DataSource paramDataSource, DataSpec paramDataSpec1, DataSpec paramDataSpec2, HlsMasterPlaylist.HlsUrl paramHlsUrl, List<Format> paramList, int paramInt1, Object paramObject, long paramLong1, long paramLong2, long paramLong3, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, TimestampAdjuster paramTimestampAdjuster, HlsMediaChunk paramHlsMediaChunk, DrmInitData paramDrmInitData, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(buildDataSource(paramDataSource, paramArrayOfByte1, paramArrayOfByte2), paramDataSpec1, paramHlsUrl.format, paramInt1, paramObject, paramLong1, paramLong2, paramLong3);
    this.discontinuitySequenceNumber = paramInt2;
    this.initDataSpec = paramDataSpec2;
    this.hlsUrl = paramHlsUrl;
    this.isMasterTimestampSource = paramBoolean2;
    this.timestampAdjuster = paramTimestampAdjuster;
    this.isEncrypted = (this.dataSource instanceof Aes128DataSource);
    this.hasGapTag = paramBoolean1;
    paramBoolean2 = true;
    if (paramHlsMediaChunk != null)
    {
      if (paramHlsMediaChunk.hlsUrl != paramHlsUrl) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      this.shouldSpliceIn = paramBoolean1;
      if ((paramHlsMediaChunk.discontinuitySequenceNumber == paramInt2) && (!this.shouldSpliceIn)) {
        paramHlsUrl = paramHlsMediaChunk.extractor;
      } else {
        paramHlsUrl = null;
      }
    }
    else
    {
      this.shouldSpliceIn = false;
      paramHlsUrl = null;
    }
    paramHlsExtractorFactory = paramHlsExtractorFactory.createExtractor(paramHlsUrl, paramDataSpec1.uri, this.trackFormat, paramList, paramDrmInitData, paramTimestampAdjuster);
    this.extractor = ((Extractor)paramHlsExtractorFactory.first);
    this.isPackedAudioExtractor = ((Boolean)paramHlsExtractorFactory.second).booleanValue();
    if (this.extractor == paramHlsUrl) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.reusingExtractor = paramBoolean1;
    if ((this.reusingExtractor) && (paramDataSpec2 != null)) {
      paramBoolean1 = paramBoolean2;
    } else {
      paramBoolean1 = false;
    }
    this.initLoadCompleted = paramBoolean1;
    if (this.isPackedAudioExtractor)
    {
      if (paramHlsMediaChunk != null)
      {
        paramHlsExtractorFactory = paramHlsMediaChunk.id3Data;
        if (paramHlsExtractorFactory != null)
        {
          this.id3Decoder = paramHlsMediaChunk.id3Decoder;
          this.id3Data = paramHlsExtractorFactory;
          break label328;
        }
      }
      this.id3Decoder = new Id3Decoder();
      this.id3Data = new ParsableByteArray(10);
    }
    else
    {
      this.id3Decoder = null;
      this.id3Data = null;
    }
    label328:
    this.initDataSource = paramDataSource;
    this.uid = uidSource.getAndIncrement();
  }
  
  private static DataSource buildDataSource(DataSource paramDataSource, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null) {
      return new Aes128DataSource(paramDataSource, paramArrayOfByte1, paramArrayOfByte2);
    }
    return paramDataSource;
  }
  
  private void loadMedia()
  {
    boolean bool = this.isEncrypted;
    int k = 0;
    Object localObject3;
    Object localObject1;
    if (bool)
    {
      localObject3 = this.dataSpec;
      localObject1 = localObject3;
      if (this.bytesLoaded != 0)
      {
        i = 1;
        localObject1 = localObject3;
        break label55;
      }
    }
    else
    {
      localObject1 = this.dataSpec.subrange(this.bytesLoaded);
    }
    int i = 0;
    label55:
    if (!this.isMasterTimestampSource) {
      this.timestampAdjuster.waitUntilInitialized();
    } else if (this.timestampAdjuster.getFirstSampleTimestampUs() == 9223372036854775807L) {
      this.timestampAdjuster.setFirstSampleTimestampUs(this.startTimeUs);
    }
    try
    {
      localObject1 = new DefaultExtractorInput(this.dataSource, ((DataSpec)localObject1).absoluteStreamPosition, this.dataSource.open((DataSpec)localObject1));
      if ((this.isPackedAudioExtractor) && (!this.id3TimestampPeeked))
      {
        long l = peekId3PrivTimestamp((ExtractorInput)localObject1);
        this.id3TimestampPeeked = true;
        localObject3 = this.output;
        if (l != -9223372036854775807L) {
          l = this.timestampAdjuster.adjustTsTimestamp(l);
        } else {
          l = this.startTimeUs;
        }
        ((HlsSampleStreamWrapper)localObject3).setSampleOffsetUs(l);
      }
      int j = k;
      if (i != 0)
      {
        ((ExtractorInput)localObject1).skipFully(this.bytesLoaded);
        j = k;
      }
      for (;;)
      {
        if (j == 0) {}
        try
        {
          if (!this.loadCanceled) {
            j = this.extractor.read((ExtractorInput)localObject1, null);
          }
        }
        finally
        {
          this.bytesLoaded = ((int)(((ExtractorInput)localObject1).getPosition() - this.dataSpec.absoluteStreamPosition));
        }
      }
      Util.closeQuietly(this.dataSource);
      return;
    }
    finally
    {
      Util.closeQuietly(this.dataSource);
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void maybeLoadInitData()
  {
    if (!this.initLoadCompleted)
    {
      Object localObject1 = this.initDataSpec;
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((DataSpec)localObject1).subrange(this.initSegmentBytesLoaded);
      try
      {
        localObject1 = new DefaultExtractorInput(this.initDataSource, ((DataSpec)localObject1).absoluteStreamPosition, this.initDataSource.open((DataSpec)localObject1));
        int i = 0;
        for (;;)
        {
          if (i == 0) {}
          try
          {
            if (!this.loadCanceled) {
              i = this.extractor.read((ExtractorInput)localObject1, null);
            }
          }
          finally
          {
            this.initSegmentBytesLoaded = ((int)(((ExtractorInput)localObject1).getPosition() - this.initDataSpec.absoluteStreamPosition));
          }
        }
        Util.closeQuietly(this.dataSource);
        this.initLoadCompleted = true;
        return;
      }
      finally
      {
        Util.closeQuietly(this.dataSource);
      }
    }
  }
  
  private long peekId3PrivTimestamp(ExtractorInput paramExtractorInput)
  {
    paramExtractorInput.resetPeekPosition();
    if (!paramExtractorInput.peekFully(this.id3Data.data, 0, 10, true)) {
      return -9223372036854775807L;
    }
    this.id3Data.reset(10);
    if (this.id3Data.readUnsignedInt24() != Id3Decoder.ID3_TAG) {
      return -9223372036854775807L;
    }
    this.id3Data.skipBytes(3);
    int i = this.id3Data.readSynchSafeInt();
    int j = i + 10;
    Object localObject;
    if (j > this.id3Data.capacity())
    {
      localObject = this.id3Data.data;
      this.id3Data.reset(j);
      System.arraycopy(localObject, 0, this.id3Data.data, 0, 10);
    }
    if (!paramExtractorInput.peekFully(this.id3Data.data, 10, i, true)) {
      return -9223372036854775807L;
    }
    paramExtractorInput = this.id3Decoder.decode(this.id3Data.data, i);
    if (paramExtractorInput == null) {
      return -9223372036854775807L;
    }
    j = paramExtractorInput.length();
    i = 0;
    while (i < j)
    {
      localObject = paramExtractorInput.get(i);
      if ((localObject instanceof PrivFrame))
      {
        localObject = (PrivFrame)localObject;
        if ("com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame)localObject).owner))
        {
          System.arraycopy(((PrivFrame)localObject).privateData, 0, this.id3Data.data, 0, 8);
          this.id3Data.reset(8);
          return this.id3Data.readLong() & 0xFFFFFFFF;
        }
      }
      i += 1;
    }
    return -9223372036854775807L;
  }
  
  public long bytesLoaded()
  {
    return this.bytesLoaded;
  }
  
  public void cancelLoad()
  {
    this.loadCanceled = true;
  }
  
  public void init(HlsSampleStreamWrapper paramHlsSampleStreamWrapper)
  {
    this.output = paramHlsSampleStreamWrapper;
    paramHlsSampleStreamWrapper.init(this.uid, this.shouldSpliceIn, this.reusingExtractor);
    if (!this.reusingExtractor) {
      this.extractor.init(paramHlsSampleStreamWrapper);
    }
  }
  
  public boolean isLoadCanceled()
  {
    return this.loadCanceled;
  }
  
  public boolean isLoadCompleted()
  {
    return this.loadCompleted;
  }
  
  public void load()
  {
    maybeLoadInitData();
    if (!this.loadCanceled)
    {
      if (!this.hasGapTag) {
        loadMedia();
      }
      this.loadCompleted = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsMediaChunk
 * JD-Core Version:    0.7.0.1
 */