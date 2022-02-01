package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.util.Arrays;

public final class DefaultExtractorInput
  implements ExtractorInput
{
  private static final int PEEK_MAX_FREE_SPACE = 524288;
  private static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 65536;
  private static final int SCRATCH_SPACE_SIZE = 4096;
  private final DataSource dataSource;
  private byte[] peekBuffer;
  private int peekBufferLength;
  private int peekBufferPosition;
  private long position;
  private final byte[] scratchSpace;
  private final long streamLength;
  
  public DefaultExtractorInput(DataSource paramDataSource, long paramLong1, long paramLong2)
  {
    this.dataSource = paramDataSource;
    this.position = paramLong1;
    this.streamLength = paramLong2;
    this.peekBuffer = new byte[65536];
    this.scratchSpace = new byte[4096];
  }
  
  private void commitBytesRead(int paramInt)
  {
    if (paramInt != -1) {
      this.position += paramInt;
    }
  }
  
  private void ensureSpaceForPeek(int paramInt)
  {
    paramInt = this.peekBufferPosition + paramInt;
    byte[] arrayOfByte = this.peekBuffer;
    if (paramInt > arrayOfByte.length)
    {
      paramInt = Util.constrainValue(arrayOfByte.length * 2, 65536 + paramInt, paramInt + 524288);
      this.peekBuffer = Arrays.copyOf(this.peekBuffer, paramInt);
    }
  }
  
  private int readFromDataSource(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (!Thread.interrupted())
    {
      paramInt1 = this.dataSource.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
      if (paramInt1 == -1)
      {
        if ((paramInt3 == 0) && (paramBoolean)) {
          return -1;
        }
        throw new EOFException();
      }
      return paramInt3 + paramInt1;
    }
    throw new InterruptedException();
  }
  
  private int readFromPeekBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.peekBufferLength;
    if (i == 0) {
      return 0;
    }
    paramInt2 = Math.min(i, paramInt2);
    System.arraycopy(this.peekBuffer, 0, paramArrayOfByte, paramInt1, paramInt2);
    updatePeekBuffer(paramInt2);
    return paramInt2;
  }
  
  private int skipFromPeekBuffer(int paramInt)
  {
    paramInt = Math.min(this.peekBufferLength, paramInt);
    updatePeekBuffer(paramInt);
    return paramInt;
  }
  
  private void updatePeekBuffer(int paramInt)
  {
    this.peekBufferLength -= paramInt;
    this.peekBufferPosition = 0;
    byte[] arrayOfByte2 = this.peekBuffer;
    int i = this.peekBufferLength;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (i < arrayOfByte2.length - 524288) {
      arrayOfByte1 = new byte[i + 65536];
    }
    System.arraycopy(this.peekBuffer, paramInt, arrayOfByte1, 0, this.peekBufferLength);
    this.peekBuffer = arrayOfByte1;
  }
  
  public void advancePeekPosition(int paramInt)
  {
    advancePeekPosition(paramInt, false);
  }
  
  public boolean advancePeekPosition(int paramInt, boolean paramBoolean)
  {
    ensureSpaceForPeek(paramInt);
    int i = Math.min(this.peekBufferLength - this.peekBufferPosition, paramInt);
    while (i < paramInt)
    {
      int j = readFromDataSource(this.peekBuffer, this.peekBufferPosition, paramInt, i, paramBoolean);
      i = j;
      if (j == -1) {
        return false;
      }
    }
    this.peekBufferPosition += paramInt;
    this.peekBufferLength = Math.max(this.peekBufferLength, this.peekBufferPosition);
    return true;
  }
  
  public long getLength()
  {
    return this.streamLength;
  }
  
  public long getPeekPosition()
  {
    return this.position + this.peekBufferPosition;
  }
  
  public long getPosition()
  {
    return this.position;
  }
  
  public void peekFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    peekFully(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public boolean peekFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!advancePeekPosition(paramInt2, paramBoolean)) {
      return false;
    }
    System.arraycopy(this.peekBuffer, this.peekBufferPosition - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    return true;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = readFromPeekBuffer(paramArrayOfByte, paramInt1, paramInt2);
    int i = j;
    if (j == 0) {
      i = readFromDataSource(paramArrayOfByte, paramInt1, paramInt2, 0, true);
    }
    commitBytesRead(i);
    return i;
  }
  
  public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    readFully(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public boolean readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (int i = readFromPeekBuffer(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = readFromDataSource(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    commitBytesRead(i);
    return i != -1;
  }
  
  public void resetPeekPosition()
  {
    this.peekBufferPosition = 0;
  }
  
  public <E extends Throwable> void setRetryPosition(long paramLong, E paramE)
  {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    this.position = paramLong;
    throw paramE;
  }
  
  public int skip(int paramInt)
  {
    int j = skipFromPeekBuffer(paramInt);
    int i = j;
    if (j == 0)
    {
      byte[] arrayOfByte = this.scratchSpace;
      i = readFromDataSource(arrayOfByte, 0, Math.min(paramInt, arrayOfByte.length), 0, true);
    }
    commitBytesRead(i);
    return i;
  }
  
  public void skipFully(int paramInt)
  {
    skipFully(paramInt, false);
  }
  
  public boolean skipFully(int paramInt, boolean paramBoolean)
  {
    int j;
    for (int i = skipFromPeekBuffer(paramInt); (i < paramInt) && (i != -1); i = readFromDataSource(this.scratchSpace, -i, j, i, paramBoolean)) {
      j = Math.min(paramInt, this.scratchSpace.length + i);
    }
    commitBytesRead(i);
    return i != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.DefaultExtractorInput
 * JD-Core Version:    0.7.0.1
 */