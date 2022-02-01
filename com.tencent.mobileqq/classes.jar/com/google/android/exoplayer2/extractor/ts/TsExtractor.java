package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TsExtractor
  implements Extractor
{
  private static final long AC3_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("AC-3");
  private static final int BUFFER_SIZE = 9400;
  private static final long E_AC3_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("EAC3");
  public static final ExtractorsFactory FACTORY = new TsExtractor.1();
  private static final long HEVC_FORMAT_IDENTIFIER = Util.getIntegerCodeForString("HEVC");
  private static final int MAX_PID_PLUS_ONE = 8192;
  public static final int MODE_HLS = 2;
  public static final int MODE_MULTI_PMT = 0;
  public static final int MODE_SINGLE_PMT = 1;
  private static final int SNIFF_TS_PACKET_COUNT = 5;
  private static final int TS_PACKET_SIZE = 188;
  private static final int TS_PAT_PID = 0;
  public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
  public static final int TS_STREAM_TYPE_AAC_LATM = 17;
  public static final int TS_STREAM_TYPE_AC3 = 129;
  public static final int TS_STREAM_TYPE_DTS = 138;
  public static final int TS_STREAM_TYPE_DVBSUBS = 89;
  public static final int TS_STREAM_TYPE_E_AC3 = 135;
  public static final int TS_STREAM_TYPE_H262 = 2;
  public static final int TS_STREAM_TYPE_H264 = 27;
  public static final int TS_STREAM_TYPE_H265 = 36;
  public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
  public static final int TS_STREAM_TYPE_ID3 = 21;
  public static final int TS_STREAM_TYPE_MPA = 3;
  public static final int TS_STREAM_TYPE_MPA_LSF = 4;
  public static final int TS_STREAM_TYPE_SPLICE_INFO = 134;
  private static final int TS_SYNC_BYTE = 71;
  private final SparseIntArray continuityCounters;
  private TsPayloadReader id3Reader;
  private final int mode;
  private ExtractorOutput output;
  private final TsPayloadReader.Factory payloadReaderFactory;
  private int remainingPmts;
  private final List<TimestampAdjuster> timestampAdjusters;
  private final SparseBooleanArray trackIds;
  private boolean tracksEnded;
  private final ParsableByteArray tsPacketBuffer;
  private final SparseArray<TsPayloadReader> tsPayloadReaders;
  
  public TsExtractor()
  {
    this(0);
  }
  
  public TsExtractor(int paramInt)
  {
    this(1, paramInt);
  }
  
  public TsExtractor(int paramInt1, int paramInt2)
  {
    this(paramInt1, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(paramInt2));
  }
  
  public TsExtractor(int paramInt, TimestampAdjuster paramTimestampAdjuster, TsPayloadReader.Factory paramFactory)
  {
    this.payloadReaderFactory = ((TsPayloadReader.Factory)Assertions.checkNotNull(paramFactory));
    this.mode = paramInt;
    if ((paramInt == 1) || (paramInt == 2)) {
      this.timestampAdjusters = Collections.singletonList(paramTimestampAdjuster);
    }
    for (;;)
    {
      this.tsPacketBuffer = new ParsableByteArray(9400);
      this.trackIds = new SparseBooleanArray();
      this.tsPayloadReaders = new SparseArray();
      this.continuityCounters = new SparseIntArray();
      resetPayloadReaders();
      return;
      this.timestampAdjusters = new ArrayList();
      this.timestampAdjusters.add(paramTimestampAdjuster);
    }
  }
  
  private void resetPayloadReaders()
  {
    this.trackIds.clear();
    this.tsPayloadReaders.clear();
    SparseArray localSparseArray = this.payloadReaderFactory.createInitialPayloadReaders();
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      this.tsPayloadReaders.put(localSparseArray.keyAt(i), localSparseArray.valueAt(i));
      i += 1;
    }
    this.tsPayloadReaders.put(0, new SectionReader(new TsExtractor.PatReader(this)));
    this.id3Reader = null;
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.output = paramExtractorOutput;
    paramExtractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    paramPositionHolder = this.tsPacketBuffer.data;
    if (9400 - this.tsPacketBuffer.getPosition() < 188)
    {
      i = this.tsPacketBuffer.bytesLeft();
      if (i > 0) {
        System.arraycopy(paramPositionHolder, this.tsPacketBuffer.getPosition(), paramPositionHolder, 0, i);
      }
      this.tsPacketBuffer.reset(paramPositionHolder, i);
    }
    int j;
    while (this.tsPacketBuffer.bytesLeft() < 188)
    {
      i = this.tsPacketBuffer.limit();
      j = paramExtractorInput.read(paramPositionHolder, i, 9400 - i);
      if (j == -1) {
        return -1;
      }
      this.tsPacketBuffer.setLimit(i + j);
    }
    int k = this.tsPacketBuffer.limit();
    int i = this.tsPacketBuffer.getPosition();
    while ((i < k) && (paramPositionHolder[i] != 71)) {
      i += 1;
    }
    this.tsPacketBuffer.setPosition(i);
    int m = i + 188;
    if (m > k) {
      return 0;
    }
    int i1 = this.tsPacketBuffer.readInt();
    if ((0x800000 & i1) != 0)
    {
      this.tsPacketBuffer.setPosition(m);
      return 0;
    }
    boolean bool;
    int n;
    if ((0x400000 & i1) != 0)
    {
      bool = true;
      n = (0x1FFF00 & i1) >> 8;
      if ((i1 & 0x20) == 0) {
        break label292;
      }
      i = 1;
      label242:
      if ((i1 & 0x10) == 0) {
        break label297;
      }
      j = 1;
      label253:
      if (j == 0) {
        break label303;
      }
    }
    label292:
    label297:
    label303:
    for (paramExtractorInput = (TsPayloadReader)this.tsPayloadReaders.get(n);; paramExtractorInput = null)
    {
      if (paramExtractorInput != null) {
        break label308;
      }
      this.tsPacketBuffer.setPosition(m);
      return 0;
      bool = false;
      break;
      i = 0;
      break label242;
      j = 0;
      break label253;
    }
    label308:
    if (this.mode != 2)
    {
      j = i1 & 0xF;
      i1 = this.continuityCounters.get(n, j - 1);
      this.continuityCounters.put(n, j);
      if (i1 == j)
      {
        this.tsPacketBuffer.setPosition(m);
        return 0;
      }
      if (j != (i1 + 1 & 0xF)) {
        paramExtractorInput.seek();
      }
    }
    if (i != 0)
    {
      i = this.tsPacketBuffer.readUnsignedByte();
      this.tsPacketBuffer.skipBytes(i);
    }
    this.tsPacketBuffer.setLimit(m);
    paramExtractorInput.consume(this.tsPacketBuffer, bool);
    this.tsPacketBuffer.setLimit(k);
    this.tsPacketBuffer.setPosition(m);
    return 0;
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    int j = this.timestampAdjusters.size();
    int i = 0;
    while (i < j)
    {
      ((TimestampAdjuster)this.timestampAdjusters.get(i)).reset();
      i += 1;
    }
    this.tsPacketBuffer.reset();
    this.continuityCounters.clear();
    resetPayloadReaders();
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    boolean bool2 = false;
    byte[] arrayOfByte = this.tsPacketBuffer.data;
    paramExtractorInput.peekFully(arrayOfByte, 0, 940);
    int i = 0;
    boolean bool1 = bool2;
    int j;
    if (i < 188) {
      j = 0;
    }
    for (;;)
    {
      if (j == 5)
      {
        paramExtractorInput.skipFully(i);
        bool1 = true;
        return bool1;
      }
      if (arrayOfByte[(j * 188 + i)] != 71)
      {
        i += 1;
        break;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.TsExtractor
 * JD-Core Version:    0.7.0.1
 */