package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.nio.ByteBuffer;

public final class SampleQueue
  implements TrackOutput
{
  public static final int ADVANCE_FAILED = -1;
  private static final int INITIAL_SCRATCH_SIZE = 32;
  private final int allocationLength;
  private final Allocator allocator;
  private Format downstreamFormat;
  private final SampleMetadataQueue.SampleExtrasHolder extrasHolder;
  private SampleQueue.AllocationNode firstAllocationNode;
  private Format lastUnadjustedFormat;
  private final SampleMetadataQueue metadataQueue;
  private boolean pendingFormatAdjustment;
  private boolean pendingSplice;
  private SampleQueue.AllocationNode readAllocationNode;
  private long sampleOffsetUs;
  private final ParsableByteArray scratch;
  private long totalBytesWritten;
  private SampleQueue.UpstreamFormatChangedListener upstreamFormatChangeListener;
  private SampleQueue.AllocationNode writeAllocationNode;
  
  public SampleQueue(Allocator paramAllocator)
  {
    this.allocator = paramAllocator;
    this.allocationLength = paramAllocator.getIndividualAllocationLength();
    this.metadataQueue = new SampleMetadataQueue();
    this.extrasHolder = new SampleMetadataQueue.SampleExtrasHolder();
    this.scratch = new ParsableByteArray(32);
    this.firstAllocationNode = new SampleQueue.AllocationNode(0L, this.allocationLength);
    this.readAllocationNode = this.firstAllocationNode;
    this.writeAllocationNode = this.firstAllocationNode;
  }
  
  private void advanceReadTo(long paramLong)
  {
    while (paramLong >= this.readAllocationNode.endPosition) {
      this.readAllocationNode = this.readAllocationNode.next;
    }
  }
  
  private void clearAllocationNodes(SampleQueue.AllocationNode paramAllocationNode)
  {
    int j = 0;
    if (!paramAllocationNode.wasInitialized) {
      return;
    }
    if (this.writeAllocationNode.wasInitialized) {}
    Allocation[] arrayOfAllocation;
    for (int i = 1;; i = 0)
    {
      arrayOfAllocation = new Allocation[i + (int)(this.writeAllocationNode.startPosition - paramAllocationNode.startPosition) / this.allocationLength];
      i = j;
      while (i < arrayOfAllocation.length)
      {
        arrayOfAllocation[i] = paramAllocationNode.allocation;
        paramAllocationNode = paramAllocationNode.clear();
        i += 1;
      }
    }
    this.allocator.release(arrayOfAllocation);
  }
  
  private void discardDownstreamTo(long paramLong)
  {
    if (paramLong == -1L) {}
    do
    {
      return;
      while (paramLong >= this.firstAllocationNode.endPosition)
      {
        this.allocator.release(this.firstAllocationNode.allocation);
        this.firstAllocationNode = this.firstAllocationNode.clear();
      }
    } while (this.readAllocationNode.startPosition >= this.firstAllocationNode.startPosition);
    this.readAllocationNode = this.firstAllocationNode;
  }
  
  private static Format getAdjustedSampleFormat(Format paramFormat, long paramLong)
  {
    Format localFormat;
    if (paramFormat == null) {
      localFormat = null;
    }
    do
    {
      do
      {
        return localFormat;
        localFormat = paramFormat;
      } while (paramLong == 0L);
      localFormat = paramFormat;
    } while (paramFormat.subsampleOffsetUs == 9223372036854775807L);
    return paramFormat.copyWithSubsampleOffsetUs(paramFormat.subsampleOffsetUs + paramLong);
  }
  
  private void postAppend(int paramInt)
  {
    this.totalBytesWritten += paramInt;
    if (this.totalBytesWritten == this.writeAllocationNode.endPosition) {
      this.writeAllocationNode = this.writeAllocationNode.next;
    }
  }
  
  private int preAppend(int paramInt)
  {
    if (!this.writeAllocationNode.wasInitialized) {
      this.writeAllocationNode.initialize(this.allocator.allocate(), new SampleQueue.AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
    }
    return Math.min(paramInt, (int)(this.writeAllocationNode.endPosition - this.totalBytesWritten));
  }
  
  private void readData(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    advanceReadTo(paramLong);
    while (paramInt > 0)
    {
      int j = Math.min(paramInt, (int)(this.readAllocationNode.endPosition - paramLong));
      paramByteBuffer.put(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(paramLong), j);
      int i = paramInt - j;
      long l = paramLong + j;
      paramLong = l;
      paramInt = i;
      if (l == this.readAllocationNode.endPosition)
      {
        this.readAllocationNode = this.readAllocationNode.next;
        paramLong = l;
        paramInt = i;
      }
    }
  }
  
  private void readData(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    advanceReadTo(paramLong);
    int i = paramInt;
    while (i > 0)
    {
      int k = Math.min(i, (int)(this.readAllocationNode.endPosition - paramLong));
      System.arraycopy(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(paramLong), paramArrayOfByte, paramInt - i, k);
      int j = i - k;
      long l = paramLong + k;
      i = j;
      paramLong = l;
      if (l == this.readAllocationNode.endPosition)
      {
        this.readAllocationNode = this.readAllocationNode.next;
        i = j;
        paramLong = l;
      }
    }
  }
  
  private void readEncryptionData(DecoderInputBuffer paramDecoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder paramSampleExtrasHolder)
  {
    int j = 1;
    int k = 0;
    long l1 = paramSampleExtrasHolder.offset;
    this.scratch.reset(1);
    readData(l1, this.scratch.data, 1);
    l1 += 1L;
    int m = this.scratch.data[0];
    int i;
    if ((m & 0x80) != 0)
    {
      i = 1;
      m &= 0x7F;
      if (paramDecoderInputBuffer.cryptoInfo.iv == null) {
        paramDecoderInputBuffer.cryptoInfo.iv = new byte[16];
      }
      readData(l1, paramDecoderInputBuffer.cryptoInfo.iv, m);
      l1 += m;
      if (i == 0) {
        break label307;
      }
      this.scratch.reset(2);
      readData(l1, this.scratch.data, 2);
      j = this.scratch.readUnsignedShort();
      l1 += 2L;
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    long l2;
    label307:
    for (;;)
    {
      localObject2 = paramDecoderInputBuffer.cryptoInfo.numBytesOfClearData;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length >= j) {}
      }
      else
      {
        localObject1 = new int[j];
      }
      localObject3 = paramDecoderInputBuffer.cryptoInfo.numBytesOfEncryptedData;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (localObject3.length >= j) {}
      }
      else
      {
        localObject2 = new int[j];
      }
      if (i == 0) {
        break label394;
      }
      i = j * 6;
      this.scratch.reset(i);
      readData(l1, this.scratch.data, i);
      l2 = i;
      this.scratch.setPosition(0);
      i = k;
      while (i < j)
      {
        localObject1[i] = this.scratch.readUnsignedShort();
        localObject2[i] = this.scratch.readUnsignedIntToInt();
        i += 1;
      }
      i = 0;
      break;
    }
    l1 += l2;
    for (;;)
    {
      localObject3 = paramSampleExtrasHolder.cryptoData;
      paramDecoderInputBuffer.cryptoInfo.set(j, (int[])localObject1, (int[])localObject2, ((TrackOutput.CryptoData)localObject3).encryptionKey, paramDecoderInputBuffer.cryptoInfo.iv, ((TrackOutput.CryptoData)localObject3).cryptoMode, ((TrackOutput.CryptoData)localObject3).encryptedBlocks, ((TrackOutput.CryptoData)localObject3).clearBlocks);
      i = (int)(l1 - paramSampleExtrasHolder.offset);
      paramSampleExtrasHolder.offset += i;
      paramSampleExtrasHolder.size -= i;
      return;
      label394:
      localObject1[0] = 0;
      localObject2[0] = (paramSampleExtrasHolder.size - (int)(l1 - paramSampleExtrasHolder.offset));
    }
  }
  
  public int advanceTo(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.metadataQueue.advanceTo(paramLong, paramBoolean1, paramBoolean2);
  }
  
  public int advanceToEnd()
  {
    return this.metadataQueue.advanceToEnd();
  }
  
  public void discardTo(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    discardDownstreamTo(this.metadataQueue.discardTo(paramLong, paramBoolean1, paramBoolean2));
  }
  
  public void discardToEnd()
  {
    discardDownstreamTo(this.metadataQueue.discardToEnd());
  }
  
  public void discardToRead()
  {
    discardDownstreamTo(this.metadataQueue.discardToRead());
  }
  
  public void discardUpstreamSamples(int paramInt)
  {
    this.totalBytesWritten = this.metadataQueue.discardUpstreamSamples(paramInt);
    if ((this.totalBytesWritten == 0L) || (this.totalBytesWritten == this.firstAllocationNode.startPosition))
    {
      clearAllocationNodes(this.firstAllocationNode);
      this.firstAllocationNode = new SampleQueue.AllocationNode(this.totalBytesWritten, this.allocationLength);
      this.readAllocationNode = this.firstAllocationNode;
      this.writeAllocationNode = this.firstAllocationNode;
      return;
    }
    for (SampleQueue.AllocationNode localAllocationNode1 = this.firstAllocationNode; this.totalBytesWritten > localAllocationNode1.endPosition; localAllocationNode1 = localAllocationNode1.next) {}
    SampleQueue.AllocationNode localAllocationNode3 = localAllocationNode1.next;
    clearAllocationNodes(localAllocationNode3);
    localAllocationNode1.next = new SampleQueue.AllocationNode(localAllocationNode1.endPosition, this.allocationLength);
    if (this.totalBytesWritten == localAllocationNode1.endPosition) {}
    for (SampleQueue.AllocationNode localAllocationNode2 = localAllocationNode1.next;; localAllocationNode2 = localAllocationNode1)
    {
      this.writeAllocationNode = localAllocationNode2;
      if (this.readAllocationNode != localAllocationNode3) {
        break;
      }
      this.readAllocationNode = localAllocationNode1.next;
      return;
    }
  }
  
  public void format(Format paramFormat)
  {
    Format localFormat = getAdjustedSampleFormat(paramFormat, this.sampleOffsetUs);
    boolean bool = this.metadataQueue.format(localFormat);
    this.lastUnadjustedFormat = paramFormat;
    this.pendingFormatAdjustment = false;
    if ((this.upstreamFormatChangeListener != null) && (bool)) {
      this.upstreamFormatChangeListener.onUpstreamFormatChanged(localFormat);
    }
  }
  
  public int getFirstIndex()
  {
    return this.metadataQueue.getFirstIndex();
  }
  
  public long getFirstTimestampUs()
  {
    return this.metadataQueue.getFirstTimestampUs();
  }
  
  public long getLargestQueuedTimestampUs()
  {
    return this.metadataQueue.getLargestQueuedTimestampUs();
  }
  
  public int getReadIndex()
  {
    return this.metadataQueue.getReadIndex();
  }
  
  public Format getUpstreamFormat()
  {
    return this.metadataQueue.getUpstreamFormat();
  }
  
  public int getWriteIndex()
  {
    return this.metadataQueue.getWriteIndex();
  }
  
  public boolean hasNextSample()
  {
    return this.metadataQueue.hasNextSample();
  }
  
  public int peekSourceId()
  {
    return this.metadataQueue.peekSourceId();
  }
  
  public int read(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    switch (this.metadataQueue.read(paramFormatHolder, paramDecoderInputBuffer, paramBoolean1, paramBoolean2, this.downstreamFormat, this.extrasHolder))
    {
    default: 
      throw new IllegalStateException();
    case -5: 
      this.downstreamFormat = paramFormatHolder.format;
      return -5;
    case -4: 
      if (!paramDecoderInputBuffer.isEndOfStream())
      {
        if (paramDecoderInputBuffer.timeUs < paramLong) {
          paramDecoderInputBuffer.addFlag(-2147483648);
        }
        if (paramDecoderInputBuffer.isEncrypted()) {
          readEncryptionData(paramDecoderInputBuffer, this.extrasHolder);
        }
        paramDecoderInputBuffer.ensureSpaceForWrite(this.extrasHolder.size);
        readData(this.extrasHolder.offset, paramDecoderInputBuffer.data, this.extrasHolder.size);
      }
      return -4;
    }
    return -3;
  }
  
  public void reset()
  {
    reset(false);
  }
  
  public void reset(boolean paramBoolean)
  {
    this.metadataQueue.reset(paramBoolean);
    clearAllocationNodes(this.firstAllocationNode);
    this.firstAllocationNode = new SampleQueue.AllocationNode(0L, this.allocationLength);
    this.readAllocationNode = this.firstAllocationNode;
    this.writeAllocationNode = this.firstAllocationNode;
    this.totalBytesWritten = 0L;
    this.allocator.trim();
  }
  
  public void rewind()
  {
    this.metadataQueue.rewind();
    this.readAllocationNode = this.firstAllocationNode;
  }
  
  public int sampleData(ExtractorInput paramExtractorInput, int paramInt, boolean paramBoolean)
  {
    paramInt = preAppend(paramInt);
    paramInt = paramExtractorInput.read(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), paramInt);
    if (paramInt == -1)
    {
      if (paramBoolean) {
        return -1;
      }
      throw new EOFException();
    }
    postAppend(paramInt);
    return paramInt;
  }
  
  public void sampleData(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    while (paramInt > 0)
    {
      int i = preAppend(paramInt);
      paramParsableByteArray.readBytes(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), i);
      paramInt -= i;
      postAppend(i);
    }
  }
  
  public void sampleMetadata(long paramLong, int paramInt1, int paramInt2, int paramInt3, TrackOutput.CryptoData paramCryptoData)
  {
    if (this.pendingFormatAdjustment) {
      format(this.lastUnadjustedFormat);
    }
    if (this.pendingSplice)
    {
      if (((paramInt1 & 0x1) == 0) || (!this.metadataQueue.attemptSplice(paramLong))) {
        return;
      }
      this.pendingSplice = false;
    }
    long l1 = this.sampleOffsetUs;
    long l2 = this.totalBytesWritten;
    long l3 = paramInt2;
    long l4 = paramInt3;
    this.metadataQueue.commitSample(paramLong + l1, paramInt1, l2 - l3 - l4, paramInt2, paramCryptoData);
  }
  
  public boolean setReadPosition(int paramInt)
  {
    return this.metadataQueue.setReadPosition(paramInt);
  }
  
  public void setSampleOffsetUs(long paramLong)
  {
    if (this.sampleOffsetUs != paramLong)
    {
      this.sampleOffsetUs = paramLong;
      this.pendingFormatAdjustment = true;
    }
  }
  
  public void setUpstreamFormatChangeListener(SampleQueue.UpstreamFormatChangedListener paramUpstreamFormatChangedListener)
  {
    this.upstreamFormatChangeListener = paramUpstreamFormatChangedListener;
  }
  
  public void sourceId(int paramInt)
  {
    this.metadataQueue.sourceId(paramInt);
  }
  
  public void splice()
  {
    this.pendingSplice = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SampleQueue
 * JD-Core Version:    0.7.0.1
 */