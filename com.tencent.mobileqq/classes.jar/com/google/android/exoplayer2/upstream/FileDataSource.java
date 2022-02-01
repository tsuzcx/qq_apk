package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource
  implements DataSource
{
  private long bytesRemaining;
  private RandomAccessFile file;
  private final TransferListener<? super FileDataSource> listener;
  private boolean opened;
  private Uri uri;
  
  public FileDataSource()
  {
    this(null);
  }
  
  public FileDataSource(TransferListener<? super FileDataSource> paramTransferListener)
  {
    this.listener = paramTransferListener;
  }
  
  public void close()
  {
    this.uri = null;
    try
    {
      if (this.file != null) {
        this.file.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      throw new FileDataSource.FileDataSourceException(localIOException);
    }
    finally
    {
      this.file = null;
      if (this.opened)
      {
        this.opened = false;
        if (this.listener != null) {
          this.listener.onTransferEnd(this);
        }
      }
    }
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    for (;;)
    {
      try
      {
        this.uri = paramDataSpec.uri;
        this.file = new RandomAccessFile(paramDataSpec.uri.getPath(), "r");
        this.file.seek(paramDataSpec.position);
        if (paramDataSpec.length == -1L)
        {
          l = this.file.length() - paramDataSpec.position;
          this.bytesRemaining = l;
          if (this.bytesRemaining >= 0L) {
            break;
          }
          throw new EOFException();
        }
      }
      catch (IOException paramDataSpec)
      {
        throw new FileDataSource.FileDataSourceException(paramDataSpec);
      }
      long l = paramDataSpec.length;
    }
    this.opened = true;
    if (this.listener != null) {
      this.listener.onTransferStart(this, paramDataSpec);
    }
    return this.bytesRemaining;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      return paramInt1;
      if (this.bytesRemaining == 0L) {
        return -1;
      }
      try
      {
        paramInt2 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(this.bytesRemaining, paramInt2));
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          continue;
        }
        this.bytesRemaining -= paramInt2;
        paramInt1 = paramInt2;
        if (this.listener == null) {
          continue;
        }
        this.listener.onBytesTransferred(this, paramInt2);
        return paramInt2;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new FileDataSource.FileDataSourceException(paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.FileDataSource
 * JD-Core Version:    0.7.0.1
 */