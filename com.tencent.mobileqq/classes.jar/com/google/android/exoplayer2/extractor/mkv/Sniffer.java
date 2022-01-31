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
    int m = 0;
    paramExtractorInput.peekFully(this.scratch.data, 0, 1);
    int k = this.scratch.data[0] & 0xFF;
    if (k == 0) {
      return -9223372036854775808L;
    }
    int j = 128;
    int i = 0;
    while ((k & j) == 0)
    {
      i += 1;
      j >>= 1;
    }
    k = (j ^ 0xFFFFFFFF) & k;
    paramExtractorInput.peekFully(this.scratch.data, 1, i);
    j = m;
    while (j < i)
    {
      k = (k << 8) + (this.scratch.data[(j + 1)] & 0xFF);
      j += 1;
    }
    this.peekLength += i + 1;
    return k;
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    long l2 = paramExtractorInput.getLength();
    long l1;
    if ((l2 == -1L) || (l2 > 1024L))
    {
      l1 = 1024L;
      int i = (int)l1;
      paramExtractorInput.peekFully(this.scratch.data, 0, 4);
      l1 = this.scratch.readUnsignedInt();
      this.peekLength = 4;
      label64:
      if (l1 == 440786851L) {
        break label143;
      }
      int j = this.peekLength + 1;
      this.peekLength = j;
      if (j != i) {
        break label99;
      }
    }
    label99:
    long l3;
    label143:
    do
    {
      return false;
      l1 = l2;
      break;
      paramExtractorInput.peekFully(this.scratch.data, 0, 1);
      l1 = l1 << 8 & 0xFFFFFF00 | this.scratch.data[0] & 0xFF;
      break label64;
      l1 = readUint(paramExtractorInput);
      l3 = this.peekLength;
    } while ((l1 == -9223372036854775808L) || ((l2 != -1L) && (l3 + l1 >= l2)));
    for (;;)
    {
      if (this.peekLength >= l3 + l1) {
        break label267;
      }
      if (readUint(paramExtractorInput) == -9223372036854775808L) {
        break;
      }
      l2 = readUint(paramExtractorInput);
      if ((l2 < 0L) || (l2 > 2147483647L)) {
        break;
      }
      if (l2 != 0L)
      {
        paramExtractorInput.advancePeekPosition((int)l2);
        this.peekLength = ((int)(l2 + this.peekLength));
      }
    }
    label267:
    if (this.peekLength == l1 + l3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mkv.Sniffer
 * JD-Core Version:    0.7.0.1
 */