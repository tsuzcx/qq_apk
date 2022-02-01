package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

class TsExtractor$PatReader
  implements SectionPayloadReader
{
  private final ParsableBitArray patScratch = new ParsableBitArray(new byte[4]);
  
  public TsExtractor$PatReader(TsExtractor paramTsExtractor) {}
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    if (paramParsableByteArray.readUnsignedByte() != 0) {}
    do
    {
      return;
      paramParsableByteArray.skipBytes(7);
      int j = paramParsableByteArray.bytesLeft() / 4;
      int i = 0;
      if (i < j)
      {
        paramParsableByteArray.readBytes(this.patScratch, 4);
        int k = this.patScratch.readBits(16);
        this.patScratch.skipBits(3);
        if (k == 0) {
          this.patScratch.skipBits(13);
        }
        for (;;)
        {
          i += 1;
          break;
          k = this.patScratch.readBits(13);
          TsExtractor.access$000(this.this$0).put(k, new SectionReader(new TsExtractor.PmtReader(this.this$0, k)));
          TsExtractor.access$108(this.this$0);
        }
      }
    } while (TsExtractor.access$200(this.this$0) == 2);
    TsExtractor.access$000(this.this$0).remove(0);
  }
  
  public void init(TimestampAdjuster paramTimestampAdjuster, ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.TsExtractor.PatReader
 * JD-Core Version:    0.7.0.1
 */