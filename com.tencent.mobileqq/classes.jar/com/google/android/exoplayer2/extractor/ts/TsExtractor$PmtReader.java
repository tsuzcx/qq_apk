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
    int j = paramParsableByteArray.getPosition();
    int k = j + paramInt;
    paramInt = -1;
    Object localObject1 = null;
    Object localObject3 = null;
    if (paramParsableByteArray.getPosition() < k)
    {
      int i = paramParsableByteArray.readUnsignedByte();
      int m = paramParsableByteArray.readUnsignedByte() + paramParsableByteArray.getPosition();
      long l;
      Object localObject4;
      Object localObject2;
      if (i == 5)
      {
        l = paramParsableByteArray.readUnsignedInt();
        if (l == TsExtractor.access$900())
        {
          paramInt = 129;
          localObject4 = localObject1;
          localObject2 = localObject3;
        }
      }
      label240:
      do
      {
        for (;;)
        {
          paramParsableByteArray.skipBytes(m - paramParsableByteArray.getPosition());
          localObject3 = localObject2;
          localObject1 = localObject4;
          break;
          if (l == TsExtractor.access$1000())
          {
            paramInt = 135;
            localObject2 = localObject3;
            localObject4 = localObject1;
          }
          else
          {
            localObject2 = localObject3;
            localObject4 = localObject1;
            if (l == TsExtractor.access$1100())
            {
              paramInt = 36;
              localObject2 = localObject3;
              localObject4 = localObject1;
              continue;
              if (i == 106)
              {
                paramInt = 129;
                localObject2 = localObject3;
                localObject4 = localObject1;
              }
              else if (i == 122)
              {
                paramInt = 135;
                localObject2 = localObject3;
                localObject4 = localObject1;
              }
              else if (i == 123)
              {
                paramInt = 138;
                localObject2 = localObject3;
                localObject4 = localObject1;
              }
              else
              {
                if (i != 10) {
                  break label240;
                }
                localObject4 = paramParsableByteArray.readString(3).trim();
                localObject2 = localObject3;
              }
            }
          }
        }
        localObject2 = localObject3;
        localObject4 = localObject1;
      } while (i != 89);
      i = 89;
      localObject3 = new ArrayList();
      for (;;)
      {
        localObject2 = localObject3;
        localObject4 = localObject1;
        paramInt = i;
        if (paramParsableByteArray.getPosition() >= m) {
          break;
        }
        localObject2 = paramParsableByteArray.readString(3).trim();
        paramInt = paramParsableByteArray.readUnsignedByte();
        localObject4 = new byte[4];
        paramParsableByteArray.readBytes((byte[])localObject4, 0, 4);
        ((List)localObject3).add(new TsPayloadReader.DvbSubtitleInfo((String)localObject2, paramInt, (byte[])localObject4));
      }
    }
    paramParsableByteArray.setPosition(k);
    return new TsPayloadReader.EsInfo(paramInt, localObject1, (List)localObject3, Arrays.copyOfRange(paramParsableByteArray.data, j, k));
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    if (paramParsableByteArray.readUnsignedByte() != 2) {}
    label221:
    label499:
    do
    {
      return;
      TimestampAdjuster localTimestampAdjuster;
      int n;
      int m;
      if ((TsExtractor.access$200(this.this$0) == 1) || (TsExtractor.access$200(this.this$0) == 2) || (TsExtractor.access$100(this.this$0) == 1))
      {
        localTimestampAdjuster = (TimestampAdjuster)TsExtractor.access$300(this.this$0).get(0);
        paramParsableByteArray.skipBytes(2);
        n = paramParsableByteArray.readUnsignedShort();
        paramParsableByteArray.skipBytes(5);
        paramParsableByteArray.readBytes(this.pmtScratch, 2);
        this.pmtScratch.skipBits(4);
        paramParsableByteArray.skipBytes(this.pmtScratch.readBits(12));
        if ((TsExtractor.access$200(this.this$0) == 2) && (TsExtractor.access$400(this.this$0) == null))
        {
          localObject = new TsPayloadReader.EsInfo(21, null, null, new byte[0]);
          TsExtractor.access$402(this.this$0, TsExtractor.access$500(this.this$0).createPayloadReader(21, (TsPayloadReader.EsInfo)localObject));
          TsExtractor.access$400(this.this$0).init(localTimestampAdjuster, TsExtractor.access$600(this.this$0), new TsPayloadReader.TrackIdGenerator(n, 21, 8192));
        }
        this.trackIdToReaderScratch.clear();
        this.trackIdToPidScratch.clear();
        j = paramParsableByteArray.bytesLeft();
        if (j <= 0) {
          break label499;
        }
        paramParsableByteArray.readBytes(this.pmtScratch, 5);
        k = this.pmtScratch.readBits(8);
        this.pmtScratch.skipBits(3);
        m = this.pmtScratch.readBits(13);
        this.pmtScratch.skipBits(4);
        int i1 = this.pmtScratch.readBits(12);
        localObject = readEsInfo(paramParsableByteArray, i1);
        i = k;
        if (k == 6) {
          i = ((TsPayloadReader.EsInfo)localObject).streamType;
        }
        j -= i1 + 5;
        if (TsExtractor.access$200(this.this$0) != 2) {
          break label393;
        }
      }
      for (int k = i;; k = m)
      {
        if (!TsExtractor.access$700(this.this$0).get(k)) {
          break label400;
        }
        break label221;
        localTimestampAdjuster = new TimestampAdjuster(((TimestampAdjuster)TsExtractor.access$300(this.this$0).get(0)).getFirstSampleTimestampUs());
        TsExtractor.access$300(this.this$0).add(localTimestampAdjuster);
        break;
      }
      if ((TsExtractor.access$200(this.this$0) == 2) && (i == 21)) {}
      for (Object localObject = TsExtractor.access$400(this.this$0);; localObject = TsExtractor.access$500(this.this$0).createPayloadReader(i, (TsPayloadReader.EsInfo)localObject))
      {
        if ((TsExtractor.access$200(this.this$0) != 2) || (m < this.trackIdToPidScratch.get(k, 8192)))
        {
          this.trackIdToPidScratch.put(k, m);
          this.trackIdToReaderScratch.put(k, localObject);
        }
        break;
      }
      int j = this.trackIdToPidScratch.size();
      i = 0;
      while (i < j)
      {
        k = this.trackIdToPidScratch.keyAt(i);
        TsExtractor.access$700(this.this$0).put(k, true);
        paramParsableByteArray = (TsPayloadReader)this.trackIdToReaderScratch.valueAt(i);
        if (paramParsableByteArray != null)
        {
          if (paramParsableByteArray != TsExtractor.access$400(this.this$0)) {
            paramParsableByteArray.init(localTimestampAdjuster, TsExtractor.access$600(this.this$0), new TsPayloadReader.TrackIdGenerator(n, k, 8192));
          }
          TsExtractor.access$000(this.this$0).put(this.trackIdToPidScratch.valueAt(i), paramParsableByteArray);
        }
        i += 1;
      }
      if (TsExtractor.access$200(this.this$0) != 2) {
        break;
      }
    } while (TsExtractor.access$800(this.this$0));
    label393:
    label400:
    TsExtractor.access$600(this.this$0).endTracks();
    TsExtractor.access$102(this.this$0, 0);
    TsExtractor.access$802(this.this$0, true);
    return;
    TsExtractor.access$000(this.this$0).remove(this.pid);
    paramParsableByteArray = this.this$0;
    if (TsExtractor.access$200(this.this$0) == 1) {}
    for (int i = 0;; i = TsExtractor.access$100(this.this$0) - 1)
    {
      TsExtractor.access$102(paramParsableByteArray, i);
      if (TsExtractor.access$100(this.this$0) != 0) {
        break;
      }
      TsExtractor.access$600(this.this$0).endTracks();
      TsExtractor.access$802(this.this$0, true);
      return;
    }
  }
  
  public void init(TimestampAdjuster paramTimestampAdjuster, ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.TsExtractor.PmtReader
 * JD-Core Version:    0.7.0.1
 */