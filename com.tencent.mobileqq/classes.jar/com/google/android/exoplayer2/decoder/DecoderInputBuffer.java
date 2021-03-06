package com.google.android.exoplayer2.decoder;

import java.nio.ByteBuffer;

public class DecoderInputBuffer
  extends Buffer
{
  public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
  public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
  public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
  private final int bufferReplacementMode;
  public final CryptoInfo cryptoInfo = new CryptoInfo();
  public ByteBuffer data;
  public long timeUs;
  
  public DecoderInputBuffer(int paramInt)
  {
    this.bufferReplacementMode = paramInt;
  }
  
  private ByteBuffer createReplacementByteBuffer(int paramInt)
  {
    int i = this.bufferReplacementMode;
    if (i == 1) {
      return ByteBuffer.allocate(paramInt);
    }
    if (i == 2) {
      return ByteBuffer.allocateDirect(paramInt);
    }
    Object localObject = this.data;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ByteBuffer)localObject).capacity();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Buffer too small (");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" < ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(")");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public static DecoderInputBuffer newFlagsOnlyInstance()
  {
    return new DecoderInputBuffer(0);
  }
  
  public void clear()
  {
    super.clear();
    ByteBuffer localByteBuffer = this.data;
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
  }
  
  public void ensureSpaceForWrite(int paramInt)
  {
    ByteBuffer localByteBuffer = this.data;
    if (localByteBuffer == null)
    {
      this.data = createReplacementByteBuffer(paramInt);
      return;
    }
    int i = localByteBuffer.capacity();
    int j = this.data.position();
    paramInt += j;
    if (i >= paramInt) {
      return;
    }
    localByteBuffer = createReplacementByteBuffer(paramInt);
    if (j > 0)
    {
      this.data.position(0);
      this.data.limit(j);
      localByteBuffer.put(this.data);
    }
    this.data = localByteBuffer;
  }
  
  public final void flip()
  {
    this.data.flip();
  }
  
  public final boolean isEncrypted()
  {
    return getFlag(1073741824);
  }
  
  public final boolean isFlagsOnly()
  {
    return (this.data == null) && (this.bufferReplacementMode == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.decoder.DecoderInputBuffer
 * JD-Core Version:    0.7.0.1
 */