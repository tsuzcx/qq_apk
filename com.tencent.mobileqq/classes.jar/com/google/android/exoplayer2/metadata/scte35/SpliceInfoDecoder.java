package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.nio.ByteBuffer;

public final class SpliceInfoDecoder
  implements MetadataDecoder
{
  private static final int TYPE_PRIVATE_COMMAND = 255;
  private static final int TYPE_SPLICE_INSERT = 5;
  private static final int TYPE_SPLICE_NULL = 0;
  private static final int TYPE_SPLICE_SCHEDULE = 4;
  private static final int TYPE_TIME_SIGNAL = 6;
  private final ParsableByteArray sectionData = new ParsableByteArray();
  private final ParsableBitArray sectionHeader = new ParsableBitArray();
  private TimestampAdjuster timestampAdjuster;
  
  public Metadata decode(MetadataInputBuffer paramMetadataInputBuffer)
  {
    if ((this.timestampAdjuster == null) || (paramMetadataInputBuffer.subsampleOffsetUs != this.timestampAdjuster.getTimestampOffsetUs()))
    {
      this.timestampAdjuster = new TimestampAdjuster(paramMetadataInputBuffer.timeUs);
      this.timestampAdjuster.adjustSampleTimestamp(paramMetadataInputBuffer.timeUs - paramMetadataInputBuffer.subsampleOffsetUs);
    }
    paramMetadataInputBuffer = paramMetadataInputBuffer.data;
    byte[] arrayOfByte = paramMetadataInputBuffer.array();
    int i = paramMetadataInputBuffer.limit();
    this.sectionData.reset(arrayOfByte, i);
    this.sectionHeader.reset(arrayOfByte, i);
    this.sectionHeader.skipBits(39);
    long l = this.sectionHeader.readBits(1) << 32 | this.sectionHeader.readBits(32);
    this.sectionHeader.skipBits(20);
    i = this.sectionHeader.readBits(12);
    int j = this.sectionHeader.readBits(8);
    paramMetadataInputBuffer = null;
    this.sectionData.skipBytes(14);
    if (j != 0)
    {
      if (j != 255)
      {
        if (j != 4)
        {
          if (j != 5)
          {
            if (j == 6) {
              paramMetadataInputBuffer = TimeSignalCommand.parseFromSection(this.sectionData, l, this.timestampAdjuster);
            }
          }
          else {
            paramMetadataInputBuffer = SpliceInsertCommand.parseFromSection(this.sectionData, l, this.timestampAdjuster);
          }
        }
        else {
          paramMetadataInputBuffer = SpliceScheduleCommand.parseFromSection(this.sectionData);
        }
      }
      else {
        paramMetadataInputBuffer = PrivateCommand.parseFromSection(this.sectionData, i, l);
      }
    }
    else {
      paramMetadataInputBuffer = new SpliceNullCommand();
    }
    if (paramMetadataInputBuffer == null) {
      return new Metadata(new Metadata.Entry[0]);
    }
    return new Metadata(new Metadata.Entry[] { paramMetadataInputBuffer });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder
 * JD-Core Version:    0.7.0.1
 */