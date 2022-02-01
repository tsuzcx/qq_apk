package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class SectionReader
  implements TsPayloadReader
{
  private static final int DEFAULT_SECTION_BUFFER_LENGTH = 32;
  private static final int MAX_SECTION_LENGTH = 4098;
  private static final int SECTION_HEADER_LENGTH = 3;
  private int bytesRead;
  private final SectionPayloadReader reader;
  private final ParsableByteArray sectionData;
  private boolean sectionSyntaxIndicator;
  private int totalSectionLength;
  private boolean waitingForPayloadStart;
  
  public SectionReader(SectionPayloadReader paramSectionPayloadReader)
  {
    this.reader = paramSectionPayloadReader;
    this.sectionData = new ParsableByteArray(32);
  }
  
  public void consume(ParsableByteArray paramParsableByteArray, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = paramParsableByteArray.readUnsignedByte() + paramParsableByteArray.getPosition();; i = -1)
    {
      if (this.waitingForPayloadStart)
      {
        if (!paramBoolean) {
          return;
        }
        this.waitingForPayloadStart = false;
        paramParsableByteArray.setPosition(i);
        this.bytesRead = 0;
      }
      label41:
      while (paramParsableByteArray.bytesLeft() > 0) {
        if (this.bytesRead < 3)
        {
          if (this.bytesRead == 0)
          {
            i = paramParsableByteArray.readUnsignedByte();
            paramParsableByteArray.setPosition(paramParsableByteArray.getPosition() - 1);
            if (i == 255)
            {
              this.waitingForPayloadStart = true;
              return;
            }
          }
          i = Math.min(paramParsableByteArray.bytesLeft(), 3 - this.bytesRead);
          paramParsableByteArray.readBytes(this.sectionData.data, this.bytesRead, i);
          this.bytesRead = (i + this.bytesRead);
          if (this.bytesRead == 3)
          {
            this.sectionData.reset(3);
            this.sectionData.skipBytes(1);
            i = this.sectionData.readUnsignedByte();
            int j = this.sectionData.readUnsignedByte();
            if ((i & 0x80) != 0) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              this.sectionSyntaxIndicator = paramBoolean;
              this.totalSectionLength = (((i & 0xF) << 8 | j) + 3);
              if (this.sectionData.capacity() >= this.totalSectionLength) {
                break;
              }
              byte[] arrayOfByte = this.sectionData.data;
              this.sectionData.reset(Math.min(4098, Math.max(this.totalSectionLength, arrayOfByte.length * 2)));
              System.arraycopy(arrayOfByte, 0, this.sectionData.data, 0, 3);
              break;
            }
          }
        }
        else
        {
          i = Math.min(paramParsableByteArray.bytesLeft(), this.totalSectionLength - this.bytesRead);
          paramParsableByteArray.readBytes(this.sectionData.data, this.bytesRead, i);
          this.bytesRead = (i + this.bytesRead);
          if (this.bytesRead == this.totalSectionLength)
          {
            if (!this.sectionSyntaxIndicator) {
              break label394;
            }
            if (Util.crc(this.sectionData.data, 0, this.totalSectionLength, -1) != 0)
            {
              this.waitingForPayloadStart = true;
              return;
            }
            this.sectionData.reset(this.totalSectionLength - 4);
          }
        }
      }
      for (;;)
      {
        this.reader.consume(this.sectionData);
        this.bytesRead = 0;
        break label41;
        break;
        label394:
        this.sectionData.reset(this.totalSectionLength);
      }
    }
  }
  
  public void init(TimestampAdjuster paramTimestampAdjuster, ExtractorOutput paramExtractorOutput, TsPayloadReader.TrackIdGenerator paramTrackIdGenerator)
  {
    this.reader.init(paramTimestampAdjuster, paramExtractorOutput, paramTrackIdGenerator);
    this.waitingForPayloadStart = true;
  }
  
  public void seek()
  {
    this.waitingForPayloadStart = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.SectionReader
 * JD-Core Version:    0.7.0.1
 */