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
    if (this.bufferReplacementMode == 1) {
      return ByteBuffer.allocate(paramInt);
    }
    if (this.bufferReplacementMode == 2) {
      return ByteBuffer.allocateDirect(paramInt);
    }
    if (this.data == null) {}
    for (int i = 0;; i = this.data.capacity()) {
      throw new IllegalStateException("Buffer too small (" + i + " < " + paramInt + ")");
    }
  }
  
  public static DecoderInputBuffer newFlagsOnlyInstance()
  {
    return new DecoderInputBuffer(0);
  }
  
  public void clear()
  {
    super.clear();
    if (this.data != null) {
      this.data.clear();
    }
  }
  
  public void ensureSpaceForWrite(int paramInt)
  {
    if (this.data == null) {
      this.data = createReplacementByteBuffer(paramInt);
    }
    int i;
    int j;
    do
    {
      return;
      i = this.data.capacity();
      j = this.data.position();
      paramInt = j + paramInt;
    } while (i >= paramInt);
    ByteBuffer localByteBuffer = createReplacementByteBuffer(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.decoder.DecoderInputBuffer
 * JD-Core Version:    0.7.0.1
 */