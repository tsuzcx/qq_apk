package androidx.versionedparcelable;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class VersionedParcelStream$1
  extends FilterInputStream
{
  VersionedParcelStream$1(VersionedParcelStream paramVersionedParcelStream, InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public int read()
  {
    if ((this.this$0.mFieldSize != -1) && (this.this$0.mCount >= this.this$0.mFieldSize)) {
      throw new IOException();
    }
    int i = super.read();
    VersionedParcelStream localVersionedParcelStream = this.this$0;
    localVersionedParcelStream.mCount += 1;
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.this$0.mFieldSize != -1) && (this.this$0.mCount >= this.this$0.mFieldSize)) {
      throw new IOException();
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 > 0)
    {
      paramArrayOfByte = this.this$0;
      paramArrayOfByte.mCount += paramInt1;
    }
    return paramInt1;
  }
  
  public long skip(long paramLong)
  {
    if ((this.this$0.mFieldSize != -1) && (this.this$0.mCount >= this.this$0.mFieldSize)) {
      throw new IOException();
    }
    paramLong = super.skip(paramLong);
    if (paramLong > 0L)
    {
      VersionedParcelStream localVersionedParcelStream = this.this$0;
      localVersionedParcelStream.mCount += (int)paramLong;
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.versionedparcelable.VersionedParcelStream.1
 * JD-Core Version:    0.7.0.1
 */