package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class Sniffer
{
  private static final int ID_EBML = 440786851;
  private static final int SEARCH_LENGTH = 1024;
  private int peekLength;
  private final ParsableByteArray scratch = new ParsableByteArray(8);
  
  private long readUint(ExtractorInput paramExtractorInput)
  {
    byte[] arrayOfByte = this.scratch.data;
    int k = 0;
    paramExtractorInput.peekFully(arrayOfByte, 0, 1);
    int m = this.scratch.data[0] & 0xFF;
    if (m == 0) {
      return -9223372036854775808L;
    }
    int j = 128;
    int i = 0;
    while ((m & j) == 0)
    {
      j >>= 1;
      i += 1;
    }
    j = m & (j ^ 0xFFFFFFFF);
    paramExtractorInput.peekFully(this.scratch.data, 1, i);
    while (k < i)
    {
      paramExtractorInput = this.scratch.data;
      k += 1;
      j = (paramExtractorInput[k] & 0xFF) + (j << 8);
    }
    this.peekLength += i + 1;
    return j;
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    long l2 = paramExtractorInput.getLength();
    long l3 = 1024L;
    long l1 = l3;
    if (l2 != -1L) {
      if (l2 > 1024L) {
        l1 = l3;
      } else {
        l1 = l2;
      }
    }
    int i = (int)l1;
    paramExtractorInput.peekFully(this.scratch.data, 0, 4);
    l1 = this.scratch.readUnsignedInt();
    this.peekLength = 4;
    while (l1 != 440786851L)
    {
      int j = this.peekLength + 1;
      this.peekLength = j;
      if (j == i) {
        return false;
      }
      paramExtractorInput.peekFully(this.scratch.data, 0, 1);
      l1 = l1 << 8 & 0xFFFFFF00 | this.scratch.data[0] & 0xFF;
    }
    l1 = readUint(paramExtractorInput);
    l3 = this.peekLength;
    if (l1 != -9223372036854775808L)
    {
      if ((l2 != -1L) && (l3 + l1 >= l2)) {
        return false;
      }
      long l4;
      for (;;)
      {
        i = this.peekLength;
        l2 = i;
        l4 = l3 + l1;
        if (l2 >= l4) {
          break label293;
        }
        if (readUint(paramExtractorInput) == -9223372036854775808L) {
          return false;
        }
        l2 = readUint(paramExtractorInput);
        if (l2 < 0L) {
          break;
        }
        if (l2 > 2147483647L) {
          return false;
        }
        if (l2 != 0L)
        {
          paramExtractorInput.advancePeekPosition((int)l2);
          this.peekLength = ((int)(this.peekLength + l2));
        }
      }
      return false;
      label293:
      return i == l4;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mkv.Sniffer
 * JD-Core Version:    0.7.0.1
 */