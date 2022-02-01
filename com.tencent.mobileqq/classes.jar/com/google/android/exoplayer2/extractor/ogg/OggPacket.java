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
    boolean bool;
    if (paramExtractorInput != null) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    if (this.populated)
    {
      this.populated = false;
      this.packetArray.reset();
    }
    while (!this.populated)
    {
      if (this.currentSegmentIndex < 0)
      {
        if (!this.pageHeader.populate(paramExtractorInput, true)) {
          return false;
        }
        i = this.pageHeader.headerSize;
        if (((this.pageHeader.type & 0x1) == 1) && (this.packetArray.limit() == 0))
        {
          i += calculatePacketSize(0);
          j = this.segmentCount + 0;
        }
        else
        {
          j = 0;
        }
        paramExtractorInput.skipFully(i);
        this.currentSegmentIndex = j;
      }
      int i = calculatePacketSize(this.currentSegmentIndex);
      int j = this.currentSegmentIndex + this.segmentCount;
      if (i > 0)
      {
        if (this.packetArray.capacity() < this.packetArray.limit() + i)
        {
          localParsableByteArray = this.packetArray;
          localParsableByteArray.data = Arrays.copyOf(localParsableByteArray.data, this.packetArray.limit() + i);
        }
        paramExtractorInput.readFully(this.packetArray.data, this.packetArray.limit(), i);
        ParsableByteArray localParsableByteArray = this.packetArray;
        localParsableByteArray.setLimit(localParsableByteArray.limit() + i);
        if (this.pageHeader.laces[(j - 1)] != 255) {
          bool = true;
        } else {
          bool = false;
        }
        this.populated = bool;
      }
      i = j;
      if (j == this.pageHeader.pageSegmentCount) {
        i = -1;
      }
      this.currentSegmentIndex = i;
    }
    return true;
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
    ParsableByteArray localParsableByteArray = this.packetArray;
    localParsableByteArray.data = Arrays.copyOf(localParsableByteArray.data, Math.max(65025, this.packetArray.limit()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.OggPacket
 * JD-Core Version:    0.7.0.1
 */