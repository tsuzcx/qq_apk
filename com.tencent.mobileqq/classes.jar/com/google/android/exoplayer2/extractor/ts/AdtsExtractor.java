package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class AdtsExtractor
  implements Extractor
{
  public static final ExtractorsFactory FACTORY = new AdtsExtractor.1();
  private static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
  private static final int MAX_PACKET_SIZE = 200;
  private static final int MAX_SNIFF_BYTES = 8192;
  private final long firstSampleTimestampUs;
  private final ParsableByteArray packetBuffer;
  private final AdtsReader reader;
  private boolean startedPacket;
  
  public AdtsExtractor()
  {
    this(0L);
  }
  
  public AdtsExtractor(long paramLong)
  {
    this.firstSampleTimestampUs = paramLong;
    this.reader = new AdtsReader(true);
    this.packetBuffer = new ParsableByteArray(200);
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.reader.createTracks(paramExtractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
    paramExtractorOutput.endTracks();
    paramExtractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    int i = paramExtractorInput.read(this.packetBuffer.data, 0, 200);
    if (i == -1) {
      return -1;
    }
    this.packetBuffer.setPosition(0);
    this.packetBuffer.setLimit(i);
    if (!this.startedPacket)
    {
      this.reader.packetStarted(this.firstSampleTimestampUs, true);
      this.startedPacket = true;
    }
    this.reader.consume(this.packetBuffer);
    return 0;
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    this.startedPacket = false;
    this.reader.seek();
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    ParsableByteArray localParsableByteArray = new ParsableByteArray(10);
    ParsableBitArray localParsableBitArray = new ParsableBitArray(localParsableByteArray.data);
    int i = 0;
    for (;;)
    {
      paramExtractorInput.peekFully(localParsableByteArray.data, 0, 10);
      localParsableByteArray.setPosition(0);
      if (localParsableByteArray.readUnsignedInt24() != ID3_TAG)
      {
        paramExtractorInput.resetPeekPosition();
        paramExtractorInput.advancePeekPosition(i);
        j = i;
        int m = 0;
        int k = 0;
        for (;;)
        {
          paramExtractorInput.peekFully(localParsableByteArray.data, 0, 2);
          localParsableByteArray.setPosition(0);
          if ((localParsableByteArray.readUnsignedShort() & 0xFFF6) != 65520)
          {
            paramExtractorInput.resetPeekPosition();
            j += 1;
            if (j - i >= 8192) {
              return false;
            }
            paramExtractorInput.advancePeekPosition(j);
            break;
          }
          m += 1;
          if ((m >= 4) && (k > 188)) {
            return true;
          }
          paramExtractorInput.peekFully(localParsableByteArray.data, 0, 4);
          localParsableBitArray.setPosition(14);
          int n = localParsableBitArray.readBits(13);
          if (n <= 6) {
            return false;
          }
          paramExtractorInput.advancePeekPosition(n - 6);
          k += n;
        }
      }
      localParsableByteArray.skipBytes(3);
      int j = localParsableByteArray.readSynchSafeInt();
      i += j + 10;
      paramExtractorInput.advancePeekPosition(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.AdtsExtractor
 * JD-Core Version:    0.7.0.1
 */