package com.google.android.exoplayer2.source.hls;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
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
    paramObject = null;
    if (paramHlsMediaChunk != null) {
      if (paramHlsMediaChunk.hlsUrl != paramHlsUrl)
      {
        paramBoolean1 = true;
        this.shouldSpliceIn = paramBoolean1;
        if ((paramHlsMediaChunk.discontinuitySequenceNumber == paramInt2) && (!this.shouldSpliceIn)) {
          break label269;
        }
        paramHlsUrl = null;
        label122:
        paramHlsExtractorFactory = paramHlsExtractorFactory.createExtractor(paramHlsUrl, paramDataSpec1.uri, this.trackFormat, paramList, paramDrmInitData, paramTimestampAdjuster);
        this.extractor = ((Extractor)paramHlsExtractorFactory.first);
        this.isPackedAudioExtractor = ((Boolean)paramHlsExtractorFactory.second).booleanValue();
        if (this.extractor != paramHlsUrl) {
          break label291;
        }
        paramBoolean1 = true;
        label182:
        this.reusingExtractor = paramBoolean1;
        if ((!this.reusingExtractor) || (paramDataSpec2 == null)) {
          break label297;
        }
        paramBoolean1 = true;
        label203:
        this.initLoadCompleted = paramBoolean1;
        if (!this.isPackedAudioExtractor) {
          break label330;
        }
        if ((paramHlsMediaChunk == null) || (paramHlsMediaChunk.id3Data == null)) {
          break label303;
        }
        this.id3Decoder = paramHlsMediaChunk.id3Decoder;
        this.id3Data = paramHlsMediaChunk.id3Data;
      }
    }
    for (;;)
    {
      this.initDataSource = paramDataSource;
      this.uid = uidSource.getAndIncrement();
      return;
      paramBoolean1 = false;
      break;
      label269:
      paramHlsUrl = paramHlsMediaChunk.extractor;
      break label122;
      this.shouldSpliceIn = false;
      paramHlsUrl = paramObject;
      break label122;
      label291:
      paramBoolean1 = false;
      break label182;
      label297:
      paramBoolean1 = false;
      break label203;
      label303:
      this.id3Decoder = new Id3Decoder();
      this.id3Data = new ParsableByteArray(10);
      continue;
      label330:
      this.id3Decoder = null;
      this.id3Data = null;
    }
  }
  
  private static DataSource buildDataSource(DataSource paramDataSource, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject = paramDataSource;
    if (paramArrayOfByte1 != null) {
      localObject = new Aes128DataSource(paramDataSource, paramArrayOfByte1, paramArrayOfByte2);
    }
    return localObject;
  }
  
  /* Error */
  private void loadMedia()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_0
    //   5: getfield 83	com/google/android/exoplayer2/source/hls/HlsMediaChunk:isEncrypted	Z
    //   8: ifeq +170 -> 178
    //   11: aload_0
    //   12: getfield 156	com/google/android/exoplayer2/source/hls/HlsMediaChunk:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   15: astore 6
    //   17: aload_0
    //   18: getfield 158	com/google/android/exoplayer2/source/hls/HlsMediaChunk:bytesLoaded	I
    //   21: ifeq +152 -> 173
    //   24: aload_0
    //   25: getfield 74	com/google/android/exoplayer2/source/hls/HlsMediaChunk:isMasterTimestampSource	Z
    //   28: ifne +169 -> 197
    //   31: aload_0
    //   32: getfield 76	com/google/android/exoplayer2/source/hls/HlsMediaChunk:timestampAdjuster	Lcom/google/android/exoplayer2/util/TimestampAdjuster;
    //   35: invokevirtual 163	com/google/android/exoplayer2/util/TimestampAdjuster:waitUntilInitialized	()V
    //   38: new 165	com/google/android/exoplayer2/extractor/DefaultExtractorInput
    //   41: dup
    //   42: aload_0
    //   43: getfield 79	com/google/android/exoplayer2/source/hls/HlsMediaChunk:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   46: aload 6
    //   48: getfield 169	com/google/android/exoplayer2/upstream/DataSpec:absoluteStreamPosition	J
    //   51: aload_0
    //   52: getfield 79	com/google/android/exoplayer2/source/hls/HlsMediaChunk:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   55: aload 6
    //   57: invokeinterface 175 2 0
    //   62: invokespecial 178	com/google/android/exoplayer2/extractor/DefaultExtractorInput:<init>	(Lcom/google/android/exoplayer2/upstream/DataSource;JJ)V
    //   65: astore 6
    //   67: aload_0
    //   68: getfield 123	com/google/android/exoplayer2/source/hls/HlsMediaChunk:isPackedAudioExtractor	Z
    //   71: ifeq +56 -> 127
    //   74: aload_0
    //   75: getfield 180	com/google/android/exoplayer2/source/hls/HlsMediaChunk:id3TimestampPeeked	Z
    //   78: ifne +49 -> 127
    //   81: aload_0
    //   82: aload 6
    //   84: invokespecial 184	com/google/android/exoplayer2/source/hls/HlsMediaChunk:peekId3PrivTimestamp	(Lcom/google/android/exoplayer2/extractor/ExtractorInput;)J
    //   87: lstore 4
    //   89: aload_0
    //   90: iconst_1
    //   91: putfield 180	com/google/android/exoplayer2/source/hls/HlsMediaChunk:id3TimestampPeeked	Z
    //   94: aload_0
    //   95: getfield 186	com/google/android/exoplayer2/source/hls/HlsMediaChunk:output	Lcom/google/android/exoplayer2/source/hls/HlsSampleStreamWrapper;
    //   98: astore 7
    //   100: lload 4
    //   102: ldc2_w 187
    //   105: lcmp
    //   106: ifeq +119 -> 225
    //   109: aload_0
    //   110: getfield 76	com/google/android/exoplayer2/source/hls/HlsMediaChunk:timestampAdjuster	Lcom/google/android/exoplayer2/util/TimestampAdjuster;
    //   113: lload 4
    //   115: invokevirtual 192	com/google/android/exoplayer2/util/TimestampAdjuster:adjustTsTimestamp	(J)J
    //   118: lstore 4
    //   120: aload 7
    //   122: lload 4
    //   124: invokevirtual 198	com/google/android/exoplayer2/source/hls/HlsSampleStreamWrapper:setSampleOffsetUs	(J)V
    //   127: iload_3
    //   128: istore_2
    //   129: iload_1
    //   130: ifeq +16 -> 146
    //   133: aload 6
    //   135: aload_0
    //   136: getfield 158	com/google/android/exoplayer2/source/hls/HlsMediaChunk:bytesLoaded	I
    //   139: invokeinterface 203 2 0
    //   144: iload_3
    //   145: istore_2
    //   146: iload_2
    //   147: ifne +87 -> 234
    //   150: aload_0
    //   151: getfield 205	com/google/android/exoplayer2/source/hls/HlsMediaChunk:loadCanceled	Z
    //   154: ifne +80 -> 234
    //   157: aload_0
    //   158: getfield 112	com/google/android/exoplayer2/source/hls/HlsMediaChunk:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   161: aload 6
    //   163: aconst_null
    //   164: invokeinterface 209 3 0
    //   169: istore_2
    //   170: goto -24 -> 146
    //   173: iconst_0
    //   174: istore_1
    //   175: goto -151 -> 24
    //   178: aload_0
    //   179: getfield 156	com/google/android/exoplayer2/source/hls/HlsMediaChunk:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   182: aload_0
    //   183: getfield 158	com/google/android/exoplayer2/source/hls/HlsMediaChunk:bytesLoaded	I
    //   186: i2l
    //   187: invokevirtual 213	com/google/android/exoplayer2/upstream/DataSpec:subrange	(J)Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   190: astore 6
    //   192: iconst_0
    //   193: istore_1
    //   194: goto -170 -> 24
    //   197: aload_0
    //   198: getfield 76	com/google/android/exoplayer2/source/hls/HlsMediaChunk:timestampAdjuster	Lcom/google/android/exoplayer2/util/TimestampAdjuster;
    //   201: invokevirtual 217	com/google/android/exoplayer2/util/TimestampAdjuster:getFirstSampleTimestampUs	()J
    //   204: ldc2_w 218
    //   207: lcmp
    //   208: ifne -170 -> 38
    //   211: aload_0
    //   212: getfield 76	com/google/android/exoplayer2/source/hls/HlsMediaChunk:timestampAdjuster	Lcom/google/android/exoplayer2/util/TimestampAdjuster;
    //   215: aload_0
    //   216: getfield 222	com/google/android/exoplayer2/source/hls/HlsMediaChunk:startTimeUs	J
    //   219: invokevirtual 225	com/google/android/exoplayer2/util/TimestampAdjuster:setFirstSampleTimestampUs	(J)V
    //   222: goto -184 -> 38
    //   225: aload_0
    //   226: getfield 222	com/google/android/exoplayer2/source/hls/HlsMediaChunk:startTimeUs	J
    //   229: lstore 4
    //   231: goto -111 -> 120
    //   234: aload_0
    //   235: aload 6
    //   237: invokeinterface 228 1 0
    //   242: aload_0
    //   243: getfield 156	com/google/android/exoplayer2/source/hls/HlsMediaChunk:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   246: getfield 169	com/google/android/exoplayer2/upstream/DataSpec:absoluteStreamPosition	J
    //   249: lsub
    //   250: l2i
    //   251: putfield 158	com/google/android/exoplayer2/source/hls/HlsMediaChunk:bytesLoaded	I
    //   254: aload_0
    //   255: getfield 79	com/google/android/exoplayer2/source/hls/HlsMediaChunk:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   258: invokestatic 234	com/google/android/exoplayer2/util/Util:closeQuietly	(Lcom/google/android/exoplayer2/upstream/DataSource;)V
    //   261: return
    //   262: astore 7
    //   264: aload_0
    //   265: aload 6
    //   267: invokeinterface 228 1 0
    //   272: aload_0
    //   273: getfield 156	com/google/android/exoplayer2/source/hls/HlsMediaChunk:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   276: getfield 169	com/google/android/exoplayer2/upstream/DataSpec:absoluteStreamPosition	J
    //   279: lsub
    //   280: l2i
    //   281: putfield 158	com/google/android/exoplayer2/source/hls/HlsMediaChunk:bytesLoaded	I
    //   284: aload 7
    //   286: athrow
    //   287: astore 6
    //   289: aload_0
    //   290: getfield 79	com/google/android/exoplayer2/source/hls/HlsMediaChunk:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   293: invokestatic 234	com/google/android/exoplayer2/util/Util:closeQuietly	(Lcom/google/android/exoplayer2/upstream/DataSource;)V
    //   296: aload 6
    //   298: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	HlsMediaChunk
    //   1	193	1	i	int
    //   128	42	2	j	int
    //   3	142	3	k	int
    //   87	143	4	l	long
    //   15	251	6	localObject1	Object
    //   287	10	6	localObject2	Object
    //   98	23	7	localHlsSampleStreamWrapper	HlsSampleStreamWrapper
    //   262	23	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   150	170	262	finally
    //   38	100	287	finally
    //   109	120	287	finally
    //   120	127	287	finally
    //   133	144	287	finally
    //   225	231	287	finally
    //   234	254	287	finally
    //   264	287	287	finally
  }
  
  /* Error */
  private void maybeLoadInitData()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 127	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initLoadCompleted	Z
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: getfield 70	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initDataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield 70	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initDataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   19: aload_0
    //   20: getfield 237	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initSegmentBytesLoaded	I
    //   23: i2l
    //   24: invokevirtual 213	com/google/android/exoplayer2/upstream/DataSpec:subrange	(J)Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   27: astore_2
    //   28: new 165	com/google/android/exoplayer2/extractor/DefaultExtractorInput
    //   31: dup
    //   32: aload_0
    //   33: getfield 133	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initDataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   36: aload_2
    //   37: getfield 169	com/google/android/exoplayer2/upstream/DataSpec:absoluteStreamPosition	J
    //   40: aload_0
    //   41: getfield 133	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initDataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   44: aload_2
    //   45: invokeinterface 175 2 0
    //   50: invokespecial 178	com/google/android/exoplayer2/extractor/DefaultExtractorInput:<init>	(Lcom/google/android/exoplayer2/upstream/DataSource;JJ)V
    //   53: astore_2
    //   54: iconst_0
    //   55: istore_1
    //   56: iload_1
    //   57: ifne +25 -> 82
    //   60: aload_0
    //   61: getfield 205	com/google/android/exoplayer2/source/hls/HlsMediaChunk:loadCanceled	Z
    //   64: ifne +18 -> 82
    //   67: aload_0
    //   68: getfield 112	com/google/android/exoplayer2/source/hls/HlsMediaChunk:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
    //   71: aload_2
    //   72: aconst_null
    //   73: invokeinterface 209 3 0
    //   78: istore_1
    //   79: goto -23 -> 56
    //   82: aload_0
    //   83: aload_2
    //   84: invokeinterface 228 1 0
    //   89: aload_0
    //   90: getfield 70	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initDataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   93: getfield 169	com/google/android/exoplayer2/upstream/DataSpec:absoluteStreamPosition	J
    //   96: lsub
    //   97: l2i
    //   98: putfield 237	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initSegmentBytesLoaded	I
    //   101: aload_0
    //   102: getfield 79	com/google/android/exoplayer2/source/hls/HlsMediaChunk:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   105: invokestatic 234	com/google/android/exoplayer2/util/Util:closeQuietly	(Lcom/google/android/exoplayer2/upstream/DataSource;)V
    //   108: aload_0
    //   109: iconst_1
    //   110: putfield 127	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initLoadCompleted	Z
    //   113: return
    //   114: astore_3
    //   115: aload_0
    //   116: aload_2
    //   117: invokeinterface 228 1 0
    //   122: aload_0
    //   123: getfield 70	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initDataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
    //   126: getfield 169	com/google/android/exoplayer2/upstream/DataSpec:absoluteStreamPosition	J
    //   129: lsub
    //   130: l2i
    //   131: putfield 237	com/google/android/exoplayer2/source/hls/HlsMediaChunk:initSegmentBytesLoaded	I
    //   134: aload_3
    //   135: athrow
    //   136: astore_2
    //   137: aload_0
    //   138: getfield 79	com/google/android/exoplayer2/source/hls/HlsMediaChunk:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
    //   141: invokestatic 234	com/google/android/exoplayer2/util/Util:closeQuietly	(Lcom/google/android/exoplayer2/upstream/DataSource;)V
    //   144: aload_2
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	HlsMediaChunk
    //   55	24	1	i	int
    //   27	90	2	localObject1	Object
    //   136	9	2	localObject2	Object
    //   114	21	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   60	79	114	finally
    //   28	54	136	finally
    //   82	101	136	finally
    //   115	136	136	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsMediaChunk
 * JD-Core Version:    0.7.0.1
 */