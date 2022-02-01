package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class SampleMetadataQueue
{
  private static final int SAMPLE_CAPACITY_INCREMENT = 1000;
  private int absoluteFirstIndex;
  private int capacity = 1000;
  private TrackOutput.CryptoData[] cryptoDatas;
  private int[] flags;
  private Format[] formats;
  private long largestDiscardedTimestampUs;
  private long largestQueuedTimestampUs;
  private int length;
  private long[] offsets;
  private int readPosition;
  private int relativeFirstIndex;
  private int[] sizes;
  private int[] sourceIds;
  private long[] timesUs;
  private Format upstreamFormat;
  private boolean upstreamFormatRequired;
  private boolean upstreamKeyframeRequired;
  private int upstreamSourceId;
  
  public SampleMetadataQueue()
  {
    int i = this.capacity;
    this.sourceIds = new int[i];
    this.offsets = new long[i];
    this.timesUs = new long[i];
    this.flags = new int[i];
    this.sizes = new int[i];
    this.cryptoDatas = new TrackOutput.CryptoData[i];
    this.formats = new Format[i];
    this.largestDiscardedTimestampUs = -9223372036854775808L;
    this.largestQueuedTimestampUs = -9223372036854775808L;
    this.upstreamFormatRequired = true;
    this.upstreamKeyframeRequired = true;
  }
  
  private long discardSamples(int paramInt)
  {
    this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(paramInt));
    this.length -= paramInt;
    this.absoluteFirstIndex += paramInt;
    this.relativeFirstIndex += paramInt;
    int i = this.relativeFirstIndex;
    int j = this.capacity;
    if (i >= j) {
      this.relativeFirstIndex = (i - j);
    }
    this.readPosition -= paramInt;
    if (this.readPosition < 0) {
      this.readPosition = 0;
    }
    if (this.length == 0)
    {
      i = this.relativeFirstIndex;
      paramInt = i;
      if (i == 0) {
        paramInt = this.capacity;
      }
      paramInt -= 1;
      return this.offsets[paramInt] + this.sizes[paramInt];
    }
    return this.offsets[this.relativeFirstIndex];
  }
  
  private int findSampleBefore(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    int i = paramInt1;
    paramInt1 = 0;
    int j = -1;
    while ((paramInt1 < paramInt2) && (this.timesUs[i] <= paramLong))
    {
      if ((!paramBoolean) || ((this.flags[i] & 0x1) != 0)) {
        j = paramInt1;
      }
      int k = i + 1;
      i = k;
      if (k == this.capacity) {
        i = 0;
      }
      paramInt1 += 1;
    }
    return j;
  }
  
  private long getLargestTimestamp(int paramInt)
  {
    long l = -9223372036854775808L;
    if (paramInt == 0) {
      return -9223372036854775808L;
    }
    int i = getRelativeIndex(paramInt - 1);
    int j = 0;
    while (j < paramInt)
    {
      l = Math.max(l, this.timesUs[i]);
      if ((this.flags[i] & 0x1) != 0) {
        return l;
      }
      int k = i - 1;
      i = k;
      if (k == -1) {
        i = this.capacity - 1;
      }
      j += 1;
    }
    return l;
  }
  
  private int getRelativeIndex(int paramInt)
  {
    paramInt = this.relativeFirstIndex + paramInt;
    int i = this.capacity;
    if (paramInt < i) {
      return paramInt;
    }
    return paramInt - i;
  }
  
  public int advanceTo(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      int i = getRelativeIndex(this.readPosition);
      if ((hasNextSample()) && (paramLong >= this.timesUs[i]) && ((paramLong <= this.largestQueuedTimestampUs) || (paramBoolean2)))
      {
        i = findSampleBefore(i, this.length - this.readPosition, paramLong, paramBoolean1);
        if (i == -1) {
          return -1;
        }
        this.readPosition += i;
        return i;
      }
      return -1;
    }
    finally {}
  }
  
  public int advanceToEnd()
  {
    try
    {
      int i = this.length;
      int j = this.readPosition;
      this.readPosition = this.length;
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean attemptSplice(long paramLong)
  {
    try
    {
      int i = this.length;
      boolean bool = false;
      if (i == 0)
      {
        l = this.largestDiscardedTimestampUs;
        if (paramLong > l) {
          bool = true;
        }
        return bool;
      }
      long l = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition));
      if (l >= paramLong) {
        return false;
      }
      int j = this.length;
      i = getRelativeIndex(this.length - 1);
      while ((j > this.readPosition) && (this.timesUs[i] >= paramLong))
      {
        int k = j - 1;
        int m = i - 1;
        j = k;
        i = m;
        if (m == -1)
        {
          i = this.capacity - 1;
          j = k;
        }
      }
      discardUpstreamSamples(this.absoluteFirstIndex + j);
      return true;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void commitSample(long paramLong1, int paramInt1, long paramLong2, int paramInt2, TrackOutput.CryptoData paramCryptoData)
  {
    for (;;)
    {
      try
      {
        bool = this.upstreamKeyframeRequired;
        if (bool)
        {
          if ((paramInt1 & 0x1) == 0) {
            return;
          }
          this.upstreamKeyframeRequired = false;
        }
        if (!this.upstreamFormatRequired)
        {
          bool = true;
          Assertions.checkState(bool);
          commitSampleTimestamp(paramLong1);
          int i = getRelativeIndex(this.length);
          this.timesUs[i] = paramLong1;
          this.offsets[i] = paramLong2;
          this.sizes[i] = paramInt2;
          this.flags[i] = paramInt1;
          this.cryptoDatas[i] = paramCryptoData;
          this.formats[i] = this.upstreamFormat;
          this.sourceIds[i] = this.upstreamSourceId;
          this.length += 1;
          if (this.length == this.capacity)
          {
            paramInt1 = this.capacity + 1000;
            paramCryptoData = new int[paramInt1];
            long[] arrayOfLong1 = new long[paramInt1];
            long[] arrayOfLong2 = new long[paramInt1];
            int[] arrayOfInt1 = new int[paramInt1];
            int[] arrayOfInt2 = new int[paramInt1];
            TrackOutput.CryptoData[] arrayOfCryptoData = new TrackOutput.CryptoData[paramInt1];
            Format[] arrayOfFormat = new Format[paramInt1];
            paramInt2 = this.capacity - this.relativeFirstIndex;
            System.arraycopy(this.offsets, this.relativeFirstIndex, arrayOfLong1, 0, paramInt2);
            System.arraycopy(this.timesUs, this.relativeFirstIndex, arrayOfLong2, 0, paramInt2);
            System.arraycopy(this.flags, this.relativeFirstIndex, arrayOfInt1, 0, paramInt2);
            System.arraycopy(this.sizes, this.relativeFirstIndex, arrayOfInt2, 0, paramInt2);
            System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, arrayOfCryptoData, 0, paramInt2);
            System.arraycopy(this.formats, this.relativeFirstIndex, arrayOfFormat, 0, paramInt2);
            System.arraycopy(this.sourceIds, this.relativeFirstIndex, paramCryptoData, 0, paramInt2);
            i = this.relativeFirstIndex;
            System.arraycopy(this.offsets, 0, arrayOfLong1, paramInt2, i);
            System.arraycopy(this.timesUs, 0, arrayOfLong2, paramInt2, i);
            System.arraycopy(this.flags, 0, arrayOfInt1, paramInt2, i);
            System.arraycopy(this.sizes, 0, arrayOfInt2, paramInt2, i);
            System.arraycopy(this.cryptoDatas, 0, arrayOfCryptoData, paramInt2, i);
            System.arraycopy(this.formats, 0, arrayOfFormat, paramInt2, i);
            System.arraycopy(this.sourceIds, 0, paramCryptoData, paramInt2, i);
            this.offsets = arrayOfLong1;
            this.timesUs = arrayOfLong2;
            this.flags = arrayOfInt1;
            this.sizes = arrayOfInt2;
            this.cryptoDatas = arrayOfCryptoData;
            this.formats = arrayOfFormat;
            this.sourceIds = paramCryptoData;
            this.relativeFirstIndex = 0;
            this.length = this.capacity;
            this.capacity = paramInt1;
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void commitSampleTimestamp(long paramLong)
  {
    try
    {
      this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long discardTo(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if ((this.length != 0) && (paramLong >= this.timesUs[this.relativeFirstIndex]))
      {
        if ((paramBoolean2) && (this.readPosition != this.length)) {
          i = this.readPosition + 1;
        } else {
          i = this.length;
        }
        int i = findSampleBefore(this.relativeFirstIndex, i, paramLong, paramBoolean1);
        if (i == -1) {
          return -1L;
        }
        paramLong = discardSamples(i);
        return paramLong;
      }
      return -1L;
    }
    finally {}
  }
  
  public long discardToEnd()
  {
    try
    {
      int i = this.length;
      if (i == 0) {
        return -1L;
      }
      long l = discardSamples(this.length);
      return l;
    }
    finally {}
  }
  
  public long discardToRead()
  {
    try
    {
      int i = this.readPosition;
      if (i == 0) {
        return -1L;
      }
      long l = discardSamples(this.readPosition);
      return l;
    }
    finally {}
  }
  
  public long discardUpstreamSamples(int paramInt)
  {
    paramInt = getWriteIndex() - paramInt;
    boolean bool;
    if ((paramInt >= 0) && (paramInt <= this.length - this.readPosition)) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    this.length -= paramInt;
    this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.length));
    paramInt = this.length;
    if (paramInt == 0) {
      return 0L;
    }
    paramInt = getRelativeIndex(paramInt - 1);
    return this.offsets[paramInt] + this.sizes[paramInt];
  }
  
  public boolean format(Format paramFormat)
  {
    if (paramFormat == null) {}
    try
    {
      this.upstreamFormatRequired = true;
      return false;
    }
    finally {}
    this.upstreamFormatRequired = false;
    boolean bool = Util.areEqual(paramFormat, this.upstreamFormat);
    if (bool) {
      return false;
    }
    this.upstreamFormat = paramFormat;
    return true;
  }
  
  public int getFirstIndex()
  {
    return this.absoluteFirstIndex;
  }
  
  public long getFirstTimestampUs()
  {
    try
    {
      long l;
      if (this.length == 0) {
        l = -9223372036854775808L;
      } else {
        l = this.timesUs[this.relativeFirstIndex];
      }
      return l;
    }
    finally {}
  }
  
  public long getLargestQueuedTimestampUs()
  {
    try
    {
      long l = this.largestQueuedTimestampUs;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getReadIndex()
  {
    return this.absoluteFirstIndex + this.readPosition;
  }
  
  public Format getUpstreamFormat()
  {
    try
    {
      Format localFormat;
      if (this.upstreamFormatRequired) {
        localFormat = null;
      } else {
        localFormat = this.upstreamFormat;
      }
      return localFormat;
    }
    finally {}
  }
  
  public int getWriteIndex()
  {
    return this.absoluteFirstIndex + this.length;
  }
  
  public boolean hasNextSample()
  {
    try
    {
      int i = this.readPosition;
      int j = this.length;
      boolean bool;
      if (i != j) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int peekSourceId()
  {
    int i = getRelativeIndex(this.readPosition);
    if (hasNextSample()) {
      return this.sourceIds[i];
    }
    return this.upstreamSourceId;
  }
  
  public int read(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean1, boolean paramBoolean2, Format paramFormat, SampleMetadataQueue.SampleExtrasHolder paramSampleExtrasHolder)
  {
    try
    {
      if (!hasNextSample())
      {
        if (paramBoolean2)
        {
          paramDecoderInputBuffer.setFlags(4);
          return -4;
        }
        if ((this.upstreamFormat != null) && ((paramBoolean1) || (this.upstreamFormat != paramFormat)))
        {
          paramFormatHolder.format = this.upstreamFormat;
          return -5;
        }
        return -3;
      }
      int i = getRelativeIndex(this.readPosition);
      if ((!paramBoolean1) && (this.formats[i] == paramFormat))
      {
        paramBoolean1 = paramDecoderInputBuffer.isFlagsOnly();
        if (paramBoolean1) {
          return -3;
        }
        paramDecoderInputBuffer.timeUs = this.timesUs[i];
        paramDecoderInputBuffer.setFlags(this.flags[i]);
        paramSampleExtrasHolder.size = this.sizes[i];
        paramSampleExtrasHolder.offset = this.offsets[i];
        paramSampleExtrasHolder.cryptoData = this.cryptoDatas[i];
        this.readPosition += 1;
        return -4;
      }
      paramFormatHolder.format = this.formats[i];
      return -5;
    }
    finally {}
  }
  
  public void reset(boolean paramBoolean)
  {
    this.length = 0;
    this.absoluteFirstIndex = 0;
    this.relativeFirstIndex = 0;
    this.readPosition = 0;
    this.upstreamKeyframeRequired = true;
    this.largestDiscardedTimestampUs = -9223372036854775808L;
    this.largestQueuedTimestampUs = -9223372036854775808L;
    if (paramBoolean)
    {
      this.upstreamFormat = null;
      this.upstreamFormatRequired = true;
    }
  }
  
  public void rewind()
  {
    try
    {
      this.readPosition = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean setReadPosition(int paramInt)
  {
    try
    {
      if ((this.absoluteFirstIndex <= paramInt) && (paramInt <= this.absoluteFirstIndex + this.length))
      {
        this.readPosition = (paramInt - this.absoluteFirstIndex);
        return true;
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void sourceId(int paramInt)
  {
    this.upstreamSourceId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SampleMetadataQueue
 * JD-Core Version:    0.7.0.1
 */