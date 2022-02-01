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
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 34	com/google/android/exoplayer2/upstream/FileDataSource:uri	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 36	com/google/android/exoplayer2/upstream/FileDataSource:file	Ljava/io/RandomAccessFile;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 36	com/google/android/exoplayer2/upstream/FileDataSource:file	Ljava/io/RandomAccessFile;
    //   16: invokevirtual 40	java/io/RandomAccessFile:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 36	com/google/android/exoplayer2/upstream/FileDataSource:file	Ljava/io/RandomAccessFile;
    //   24: aload_0
    //   25: getfield 42	com/google/android/exoplayer2/upstream/FileDataSource:opened	Z
    //   28: ifeq +24 -> 52
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 42	com/google/android/exoplayer2/upstream/FileDataSource:opened	Z
    //   36: aload_0
    //   37: getfield 27	com/google/android/exoplayer2/upstream/FileDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +10 -> 52
    //   45: aload_1
    //   46: aload_0
    //   47: invokeinterface 48 2 0
    //   52: return
    //   53: astore_1
    //   54: goto +13 -> 67
    //   57: astore_1
    //   58: new 50	com/google/android/exoplayer2/upstream/FileDataSource$FileDataSourceException
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 53	com/google/android/exoplayer2/upstream/FileDataSource$FileDataSourceException:<init>	(Ljava/io/IOException;)V
    //   66: athrow
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 36	com/google/android/exoplayer2/upstream/FileDataSource:file	Ljava/io/RandomAccessFile;
    //   72: aload_0
    //   73: getfield 42	com/google/android/exoplayer2/upstream/FileDataSource:opened	Z
    //   76: ifeq +24 -> 100
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield 42	com/google/android/exoplayer2/upstream/FileDataSource:opened	Z
    //   84: aload_0
    //   85: getfield 27	com/google/android/exoplayer2/upstream/FileDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +10 -> 100
    //   93: aload_2
    //   94: aload_0
    //   95: invokeinterface 48 2 0
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	FileDataSource
    //   40	6	1	localTransferListener1	TransferListener
    //   53	1	1	localObject	Object
    //   57	44	1	localIOException	IOException
    //   88	6	2	localTransferListener2	TransferListener
    // Exception table:
    //   from	to	target	type
    //   5	19	53	finally
    //   58	67	53	finally
    //   5	19	57	java/io/IOException
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    try
    {
      this.uri = paramDataSpec.uri;
      this.file = new RandomAccessFile(paramDataSpec.uri.getPath(), "r");
      this.file.seek(paramDataSpec.position);
      if (paramDataSpec.length == -1L) {
        l = this.file.length() - paramDataSpec.position;
      } else {
        l = paramDataSpec.length;
      }
      this.bytesRemaining = l;
      long l = this.bytesRemaining;
      if (l >= 0L)
      {
        this.opened = true;
        TransferListener localTransferListener = this.listener;
        if (localTransferListener != null) {
          localTransferListener.onTransferStart(this, paramDataSpec);
        }
        return this.bytesRemaining;
      }
      throw new EOFException();
    }
    catch (IOException paramDataSpec)
    {
      throw new FileDataSource.FileDataSourceException(paramDataSpec);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l = this.bytesRemaining;
    if (l == 0L) {
      return -1;
    }
    try
    {
      paramInt1 = this.file.read(paramArrayOfByte, paramInt1, (int)Math.min(l, paramInt2));
      if (paramInt1 > 0)
      {
        this.bytesRemaining -= paramInt1;
        paramArrayOfByte = this.listener;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.onBytesTransferred(this, paramInt1);
        }
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new FileDataSource.FileDataSourceException(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.FileDataSource
 * JD-Core Version:    0.7.0.1
 */