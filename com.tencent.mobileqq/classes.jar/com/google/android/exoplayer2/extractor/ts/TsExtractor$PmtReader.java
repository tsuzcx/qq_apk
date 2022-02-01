package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TsExtractor$PmtReader
  implements SectionPayloadReader
{
  private static final int TS_PMT_DESC_AC3 = 106;
  private static final int TS_PMT_DESC_DTS = 123;
  private static final int TS_PMT_DESC_DVBSUBS = 89;
  private static final int TS_PMT_DESC_EAC3 = 122;
  private static final int TS_PMT_DESC_ISO639_LANG = 10;
  private static final int TS_PMT_DESC_REGISTRATION = 5;
  private final int pid;
  private final ParsableBitArray pmtScratch = new ParsableBitArray(new byte[5]);
  private final SparseIntArray trackIdToPidScratch = new SparseIntArray();
  private final SparseArray<TsPayloadReader> trackIdToReaderScratch = new SparseArray();
  
  public TsExtractor$PmtReader(TsExtractor paramTsExtractor, int paramInt)
  {
    this.pid = paramInt;
  }
  
  private TsPayloadReader.EsInfo readEsInfo(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    int i = paramParsableByteArray.getPosition();
    int j = paramInt + i;
    Object localObject1 = null;
    paramInt = -1;
    Object localObject4;
    for (Object localObject2 = null; paramParsableByteArray.getPosition() < j; localObject2 = localObject4)
    {
      int m = paramParsableByteArray.readUnsignedByte();
      int k = paramParsableByteArray.readUnsignedByte();
      k = paramParsableByteArray.getPosition() + k;
      if (m == 5)
      {
        long l = paramParsableByteArray.readUnsignedInt();
        if (l != TsExtractor.access$900())
        {
          if (l == TsExtractor.access$1000()) {
            break label144;
          }
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (l != TsExtractor.access$1100()) {
            break label296;
          }
          paramInt = 36;
          localObject3 = localObject1;
          localObject4 = localObject2;
          break label296;
        }
      }
      else
      {
        if (m != 106) {
          break label137;
        }
      }
      paramInt = 129;
      Object localObject3 = localObject1;
      localObject4 = localObject2;
      break label296;
      label137:
      if (m == 122)
      {
        label144:
        paramInt = 135;
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
      else if (m == 123)
      {
        paramInt = 138;
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
      else if (m == 10)
      {
        localObject3 = paramParsableByteArray.readString(3).trim();
        localObject4 = localObject2;
      }
      else
      {
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (m == 89)
        {
          localObject4 = new ArrayList();
          while (paramParsableByteArray.getPosition() < k)
          {
            localObject2 = paramParsableByteArray.readString(3).trim();
            paramInt = paramParsableByteArray.readUnsignedByte();
            localObject3 = new byte[4];
            paramParsableByteArray.readBytes((byte[])localObject3, 0, 4);
            ((List)localObject4).add(new TsPayloadReader.DvbSubtitleInfo((String)localObject2, paramInt, (byte[])localObject3));
          }
          paramInt = 89;
          localObject3 = localObject1;
        }
      }
      label296:
      paramParsableByteArray.skipBytes(k - paramParsableByteArray.getPosition());
      localObject1 = localObject3;
    }
    paramParsableByteArray.setPosition(j);
    return new TsPayloadReader.EsInfo(paramInt, localObject1, (List)localObject2, Arrays.copyOfRange(paramParsableByteArray.data, i, j));
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    if (paramParsableByteArray.readUnsignedByte() != 2) {
      return;
    }
    int i = TsExtractor.access$200(this.this$0);
    int k = 0;
    TimestampAdjuster localTimestampAdjuster;
    if ((i != 1) && (TsExtractor.access$200(this.this$0) != 2) && (TsExtractor.access$100(this.this$0) != 1))
    {
      localTimestampAdjuster = new TimestampAdjuster(((TimestampAdjuster)TsExtractor.access$300(this.this$0).get(0)).getFirstSampleTimestampUs());
      TsExtractor.access$300(this.this$0).add(localTimestampAdjuster);
    }
    else
    {
      localTimestampAdjuster = (TimestampAdjuster)TsExtractor.access$300(this.this$0).get(0);
    }
    paramParsableByteArray.skipBytes(2);
    int i1 = paramParsableByteArray.readUnsignedShort();
    paramParsableByteArray.skipBytes(5);
    paramParsableByteArray.readBytes(this.pmtScratch, 2);
    this.pmtScratch.skipBits(4);
    paramParsableByteArray.skipBytes(this.pmtScratch.readBits(12));
    Object localObject;
    if ((TsExtractor.access$200(this.this$0) == 2) && (TsExtractor.access$400(this.this$0) == null))
    {
      localObject = new TsPayloadReader.EsInfo(21, null, null, new byte[0]);
      TsExtractor localTsExtractor = this.this$0;
      TsExtractor.access$402(localTsExtractor, TsExtractor.access$500(localTsExtractor).createPayloadReader(21, (TsPayloadReader.EsInfo)localObject));
      TsExtractor.access$400(this.this$0).init(localTimestampAdjuster, TsExtractor.access$600(this.this$0), new TsPayloadReader.TrackIdGenerator(i1, 21, 8192));
    }
    this.trackIdToReaderScratch.clear();
    this.trackIdToPidScratch.clear();
    int n;
    int m;
    for (int j = paramParsableByteArray.bytesLeft(); j > 0; j = n)
    {
      paramParsableByteArray.readBytes(this.pmtScratch, 5);
      n = this.pmtScratch.readBits(8);
      this.pmtScratch.skipBits(3);
      m = this.pmtScratch.readBits(13);
      this.pmtScratch.skipBits(4);
      int i2 = this.pmtScratch.readBits(12);
      localObject = readEsInfo(paramParsableByteArray, i2);
      i = n;
      if (n == 6) {
        i = ((TsPayloadReader.EsInfo)localObject).streamType;
      }
      n = j - (i2 + 5);
      if (TsExtractor.access$200(this.this$0) == 2) {
        j = i;
      } else {
        j = m;
      }
      if (!TsExtractor.access$700(this.this$0).get(j))
      {
        if ((TsExtractor.access$200(this.this$0) == 2) && (i == 21)) {
          localObject = TsExtractor.access$400(this.this$0);
        } else {
          localObject = TsExtractor.access$500(this.this$0).createPayloadReader(i, (TsPayloadReader.EsInfo)localObject);
        }
        if ((TsExtractor.access$200(this.this$0) != 2) || (m < this.trackIdToPidScratch.get(j, 8192)))
        {
          this.trackIdToPidScratch.put(j, m);
          this.trackIdToReaderScratch.put(j, localObject);
        }
      }
    }
    j = this.trackIdToPidScratch.size();
    i = 0;
    while (i < j)
    {
      m = this.trackIdToPidScratch.keyAt(i);
      TsExtractor.access$700(this.this$0).put(m, true);
      paramParsableByteArray = (TsPayloadReader)this.trackIdToReaderScratch.valueAt(i);
      if (paramParsableByteArray != null)
      {
        if (paramParsableByteArray != TsExtractor.access$400(this.this$0)) {
          paramParsableByteArray.init(localTimestampAdjuster, TsExtractor.access$600(this.this$0), new TsPayloadReader.TrackIdGenerator(i1, m, 8192));
        }
        TsExtractor.access$000(this.this$0).put(this.trackIdToPidScratch.valueAt(i), paramParsableByteArray);
      }
      i += 1;
    }
    if (TsExtractor.access$200(this.this$0) == 2)
    {
      if (!TsExtractor.access$800(this.this$0))
      {
        TsExtractor.access$600(this.this$0).endTracks();
        TsExtractor.access$102(this.this$0, 0);
        TsExtractor.access$802(this.this$0, true);
      }
    }
    else
    {
      TsExtractor.access$000(this.this$0).remove(this.pid);
      paramParsableByteArray = this.this$0;
      if (TsExtractor.access$200(paramParsableByteArray) == 1) {
        i = k;
      } else {
        i = TsExtractor.access$100(this.this$0) - 1;
      }
      TsExtractor.access$102(paramParsableByteArray, i);
      if (TsExtractor.access$100(this.this$0) == 0)
      {
        TsExtractor.access$600(this.this$0).endTracks();
        TsExtractor.access$802(this.this$0, true);
      }
    }
  }
  
  public void init(TimestampAdjuster paramTimestampAdjuster, ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.TsExtractor.PmtReader
 * JD-Core Version:    0.7.0.1
 */