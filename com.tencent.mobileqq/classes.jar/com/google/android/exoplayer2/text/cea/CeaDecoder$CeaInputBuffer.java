package com.google.android.exoplayer2.text.cea;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;

final class CeaDecoder$CeaInputBuffer
  extends SubtitleInputBuffer
  implements Comparable<CeaInputBuffer>
{
  private long queuedInputBufferCount;
  
  public int compareTo(@NonNull CeaInputBuffer paramCeaInputBuffer)
  {
    if (isEndOfStream() != paramCeaInputBuffer.isEndOfStream()) {
      if (!isEndOfStream()) {}
    }
    long l1;
    do
    {
      return 1;
      return -1;
      long l2 = this.timeUs - paramCeaInputBuffer.timeUs;
      l1 = l2;
      if (l2 == 0L)
      {
        l2 = this.queuedInputBufferCount - paramCeaInputBuffer.queuedInputBufferCount;
        l1 = l2;
        if (l2 == 0L) {
          return 0;
        }
      }
    } while (l1 > 0L);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.CeaDecoder.CeaInputBuffer
 * JD-Core Version:    0.7.0.1
 */