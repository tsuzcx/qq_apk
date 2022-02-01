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
    paramAllocator = this.firstAllocationNode;
    this.readAllocationNode = paramAllocator;
    this.writeAllocationNode = paramAllocator;
  }
  
  private void advanceReadTo(long paramLong)
  {
    while (paramLong >= this.readAllocationNode.endPosition) {
      this.readAllocationNode = this.readAllocationNode.next;
    }
  }
  
  private void clearAllocationNodes(SampleQueue.AllocationNode paramAllocationNode)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void discardDownstreamTo(long paramLong)
  {
    if (paramLong == -1L) {
      return;
    }
    while (paramLong >= this.firstAllocationNode.endPosition)
    {
      this.allocator.release(this.firstAllocationNode.allocation);
      this.firstAllocationNode = this.firstAllocationNode.clear();
    }
    if (this.readAllocationNode.startPosition < this.firstAllocationNode.startPosition) {
      this.readAllocationNode = this.firstAllocationNode;
    }
  }
  
  private static Format getAdjustedSampleFormat(Format paramFormat, long paramLong)
  {
    if (paramFormat == null) {
      return null;
    }
    Format localFormat = paramFormat;
    if (paramLong != 0L)
    {
      localFormat = paramFormat;
      if (paramFormat.subsampleOffsetUs != 9223372036854775807L) {
        localFormat = paramFormat.copyWithSubsampleOffsetUs(paramFormat.subsampleOffsetUs + paramLong);
      }
    }
    return localFormat;
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
      paramLong = l;
      i = j;
      if (l == this.readAllocationNode.endPosition)
      {
        this.readAllocationNode = this.readAllocationNode.next;
        paramLong = l;
        i = j;
      }
    }
  }
  
  private void readEncryptionData(DecoderInputBuffer paramDecoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder paramSampleExtrasHolder)
  {
    long l1 = paramSampleExtrasHolder.offset;
    this.scratch.reset(1);
    readData(l1, this.scratch.data, 1);
    l1 += 1L;
    Object localObject1 = this.scratch.data;
    int k = 0;
    int j = localObject1[0];
    if ((j & 0x80) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    j &= 0x7F;
    if (paramDecoderInputBuffer.cryptoInfo.iv == null) {
      paramDecoderInputBuffer.cryptoInfo.iv = new byte[16];
    }
    readData(l1, paramDecoderInputBuffer.cryptoInfo.iv, j);
    l1 += j;
    if (i != 0)
    {
      this.scratch.reset(2);
      readData(l1, this.scratch.data, 2);
      l1 += 2L;
      j = this.scratch.readUnsignedShort();
    }
    else
    {
      j = 1;
    }
    Object localObject2 = paramDecoderInputBuffer.cryptoInfo.numBytesOfClearData;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length >= j) {}
    }
    else
    {
      localObject1 = new int[j];
    }
    Object localObject3 = paramDecoderInputBuffer.cryptoInfo.numBytesOfEncryptedData;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (localObject3.length >= j) {}
    }
    else
    {
      localObject2 = new int[j];
    }
    if (i != 0)
    {
      i = j * 6;
      this.scratch.reset(i);
      readData(l1, this.scratch.data, i);
      long l2 = l1 + i;
      this.scratch.setPosition(0);
      i = k;
      for (;;)
      {
        l1 = l2;
        if (i >= j) {
          break;
        }
        localObject1[i] = this.scratch.readUnsignedShort();
        localObject2[i] = this.scratch.readUnsignedIntToInt();
        i += 1;
      }
    }
    localObject1[0] = 0;
    localObject2[0] = (paramSampleExtrasHolder.size - (int)(l1 - paramSampleExtrasHolder.offset));
    localObject3 = paramSampleExtrasHolder.cryptoData;
    paramDecoderInputBuffer.cryptoInfo.set(j, (int[])localObject1, (int[])localObject2, ((TrackOutput.CryptoData)localObject3).encryptionKey, paramDecoderInputBuffer.cryptoInfo.iv, ((TrackOutput.CryptoData)localObject3).cryptoMode, ((TrackOutput.CryptoData)localObject3).encryptedBlocks, ((TrackOutput.CryptoData)localObject3).clearBlocks);
    int i = (int)(l1 - paramSampleExtrasHolder.offset);
    paramSampleExtrasHolder.offset += i;
    paramSampleExtrasHolder.size -= i;
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
    long l = this.totalBytesWritten;
    SampleQueue.AllocationNode localAllocationNode1;
    if ((l != 0L) && (l != this.firstAllocationNode.startPosition))
    {
      for (localAllocationNode1 = this.firstAllocationNode; this.totalBytesWritten > localAllocationNode1.endPosition; localAllocationNode1 = localAllocationNode1.next) {}
      SampleQueue.AllocationNode localAllocationNode3 = localAllocationNode1.next;
      clearAllocationNodes(localAllocationNode3);
      localAllocationNode1.next = new SampleQueue.AllocationNode(localAllocationNode1.endPosition, this.allocationLength);
      SampleQueue.AllocationNode localAllocationNode2;
      if (this.totalBytesWritten == localAllocationNode1.endPosition) {
        localAllocationNode2 = localAllocationNode1.next;
      } else {
        localAllocationNode2 = localAllocationNode1;
      }
      this.writeAllocationNode = localAllocationNode2;
      if (this.readAllocationNode == localAllocationNode3) {
        this.readAllocationNode = localAllocationNode1.next;
      }
    }
    else
    {
      clearAllocationNodes(this.firstAllocationNode);
      this.firstAllocationNode = new SampleQueue.AllocationNode(this.totalBytesWritten, this.allocationLength);
      localAllocationNode1 = this.firstAllocationNode;
      this.readAllocationNode = localAllocationNode1;
      this.writeAllocationNode = localAllocationNode1;
    }
  }
  
  public void format(Format paramFormat)
  {
    Format localFormat = getAdjustedSampleFormat(paramFormat, this.sampleOffsetUs);
    boolean bool = this.metadataQueue.format(localFormat);
    this.lastUnadjustedFormat = paramFormat;
    this.pendingFormatAdjustment = false;
    paramFormat = this.upstreamFormatChangeListener;
    if ((paramFormat != null) && (bool)) {
      paramFormat.onUpstreamFormatChanged(localFormat);
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
    int i = this.metadataQueue.read(paramFormatHolder, paramDecoderInputBuffer, paramBoolean1, paramBoolean2, this.downstreamFormat, this.extrasHolder);
    if (i != -5)
    {
      if (i != -4)
      {
        if (i == -3) {
          return -3;
        }
        throw new IllegalStateException();
      }
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
    this.downstreamFormat = paramFormatHolder.format;
    return -5;
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
    SampleQueue.AllocationNode localAllocationNode = this.firstAllocationNode;
    this.readAllocationNode = localAllocationNode;
    this.writeAllocationNode = localAllocationNode;
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
    if (this.pendingSplice) {
      if ((paramInt1 & 0x1) != 0)
      {
        if (!this.metadataQueue.attemptSplice(paramLong)) {
          return;
        }
        this.pendingSplice = false;
      }
      else
      {
        return;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SampleQueue
 * JD-Core Version:    0.7.0.1
 */