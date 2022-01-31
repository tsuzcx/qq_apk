package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

final class PsExtractor$PesReader
{
  private static final int PES_SCRATCH_SIZE = 64;
  private boolean dtsFlag;
  private int extendedHeaderLength;
  private final ElementaryStreamReader pesPayloadReader;
  private final ParsableBitArray pesScratch;
  private boolean ptsFlag;
  private boolean seenFirstDts;
  private long timeUs;
  private final TimestampAdjuster timestampAdjuster;
  
  public PsExtractor$PesReader(ElementaryStreamReader paramElementaryStreamReader, TimestampAdjuster paramTimestampAdjuster)
  {
    this.pesPayloadReader = paramElementaryStreamReader;
    this.timestampAdjuster = paramTimestampAdjuster;
    this.pesScratch = new ParsableBitArray(new byte[64]);
  }
  
  private void parseHeader()
  {
    this.pesScratch.skipBits(8);
    this.ptsFlag = this.pesScratch.readBit();
    this.dtsFlag = this.pesScratch.readBit();
    this.pesScratch.skipBits(6);
    this.extendedHeaderLength = this.pesScratch.readBits(8);
  }
  
  private void parseHeaderExtension()
  {
    this.timeUs = 0L;
    if (this.ptsFlag)
    {
      this.pesScratch.skipBits(4);
      long l1 = this.pesScratch.readBits(3);
      this.pesScratch.skipBits(1);
      long l2 = this.pesScratch.readBits(15) << 15;
      this.pesScratch.skipBits(1);
      long l3 = this.pesScratch.readBits(15);
      this.pesScratch.skipBits(1);
      if ((!this.seenFirstDts) && (this.dtsFlag))
      {
        this.pesScratch.skipBits(4);
        long l4 = this.pesScratch.readBits(3);
        this.pesScratch.skipBits(1);
        long l5 = this.pesScratch.readBits(15) << 15;
        this.pesScratch.skipBits(1);
        long l6 = this.pesScratch.readBits(15);
        this.pesScratch.skipBits(1);
        this.timestampAdjuster.adjustTsTimestamp(l4 << 30 | l5 | l6);
        this.seenFirstDts = true;
      }
      this.timeUs = this.timestampAdjuster.adjustTsTimestamp(l1 << 30 | l2 | l3);
    }
  }
  
  public void consume(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.readBytes(this.pesScratch.data, 0, 3);
    this.pesScratch.setPosition(0);
    parseHeader();
    paramParsableByteArray.readBytes(this.pesScratch.data, 0, this.extendedHeaderLength);
    this.pesScratch.setPosition(0);
    parseHeaderExtension();
    this.pesPayloadReader.packetStarted(this.timeUs, true);
    this.pesPayloadReader.consume(paramParsableByteArray);
    this.pesPayloadReader.packetFinished();
  }
  
  public void seek()
  {
    this.seenFirstDts = false;
    this.pesPayloadReader.seek();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.PsExtractor.PesReader
 * JD-Core Version:    0.7.0.1
 */