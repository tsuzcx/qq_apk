package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

final class OggPacket
{
  private int currentSegmentIndex = -1;
  private final ParsableByteArray packetArray = new ParsableByteArray(new byte[65025], 0);
  private final OggPageHeader pageHeader = new OggPageHeader();
  private boolean populated;
  private int segmentCount;
  
  private int calculatePacketSize(int paramInt)
  {
    int i = 0;
    this.segmentCount = 0;
    int j;
    int k;
    do
    {
      j = i;
      if (this.segmentCount + paramInt >= this.pageHeader.pageSegmentCount) {
        break;
      }
      int[] arrayOfInt = this.pageHeader.laces;
      j = this.segmentCount;
      this.segmentCount = (j + 1);
      k = arrayOfInt[(j + paramInt)];
      j = i + k;
      i = j;
    } while (k == 255);
    return j;
  }
  
  public OggPageHeader getPageHeader()
  {
    return this.pageHeader;
  }
  
  public ParsableByteArray getPayload()
  {
    return this.packetArray;
  }
  
  public boolean populate(ExtractorInput paramExtractorInput)
  {
    if (paramExtractorInput != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      if (this.populated)
      {
        this.populated = false;
        this.packetArray.reset();
      }
      if (this.populated) {
        break label284;
      }
      if (this.currentSegmentIndex >= 0) {
        break label123;
      }
      if (this.pageHeader.populate(paramExtractorInput, true)) {
        break;
      }
      return false;
    }
    int i = this.pageHeader.headerSize;
    if (((this.pageHeader.type & 0x1) == 1) && (this.packetArray.limit() == 0)) {
      i += calculatePacketSize(0);
    }
    for (int j = this.segmentCount + 0;; j = 0)
    {
      paramExtractorInput.skipFully(i);
      this.currentSegmentIndex = j;
      label123:
      j = calculatePacketSize(this.currentSegmentIndex);
      i = this.currentSegmentIndex + this.segmentCount;
      if (j > 0)
      {
        if (this.packetArray.capacity() < this.packetArray.limit() + j) {
          this.packetArray.data = Arrays.copyOf(this.packetArray.data, this.packetArray.limit() + j);
        }
        paramExtractorInput.readFully(this.packetArray.data, this.packetArray.limit(), j);
        this.packetArray.setLimit(j + this.packetArray.limit());
        if (this.pageHeader.laces[(i - 1)] != 255)
        {
          bool = true;
          label248:
          this.populated = bool;
        }
      }
      else
      {
        if (i != this.pageHeader.pageSegmentCount) {
          break label281;
        }
        i = -1;
      }
      label281:
      for (;;)
      {
        this.currentSegmentIndex = i;
        break;
        bool = false;
        break label248;
      }
      label284:
      return true;
    }
  }
  
  public void reset()
  {
    this.pageHeader.reset();
    this.packetArray.reset();
    this.currentSegmentIndex = -1;
    this.populated = false;
  }
  
  public void trimPayload()
  {
    if (this.packetArray.data.length == 65025) {
      return;
    }
    this.packetArray.data = Arrays.copyOf(this.packetArray.data, Math.max(65025, this.packetArray.limit()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.OggPacket
 * JD-Core Version:    0.7.0.1
 */