package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource
  implements DataSource
{
  private AssetFileDescriptor assetFileDescriptor;
  private long bytesRemaining;
  private FileInputStream inputStream;
  private final TransferListener<? super ContentDataSource> listener;
  private boolean opened;
  private final ContentResolver resolver;
  private Uri uri;
  
  public ContentDataSource(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentDataSource(Context paramContext, TransferListener<? super ContentDataSource> paramTransferListener)
  {
    this.resolver = paramContext.getContentResolver();
    this.listener = paramTransferListener;
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 47	com/google/android/exoplayer2/upstream/ContentDataSource:uri	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 49	com/google/android/exoplayer2/upstream/ContentDataSource:inputStream	Ljava/io/FileInputStream;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 49	com/google/android/exoplayer2/upstream/ContentDataSource:inputStream	Ljava/io/FileInputStream;
    //   16: invokevirtual 53	java/io/FileInputStream:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 49	com/google/android/exoplayer2/upstream/ContentDataSource:inputStream	Ljava/io/FileInputStream;
    //   24: aload_0
    //   25: getfield 55	com/google/android/exoplayer2/upstream/ContentDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   28: ifnull +10 -> 38
    //   31: aload_0
    //   32: getfield 55	com/google/android/exoplayer2/upstream/ContentDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   35: invokevirtual 58	android/content/res/AssetFileDescriptor:close	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 55	com/google/android/exoplayer2/upstream/ContentDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   43: aload_0
    //   44: getfield 60	com/google/android/exoplayer2/upstream/ContentDataSource:opened	Z
    //   47: ifeq +25 -> 72
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 60	com/google/android/exoplayer2/upstream/ContentDataSource:opened	Z
    //   55: aload_0
    //   56: getfield 40	com/google/android/exoplayer2/upstream/ContentDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   59: ifnull +13 -> 72
    //   62: aload_0
    //   63: getfield 40	com/google/android/exoplayer2/upstream/ContentDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   66: aload_0
    //   67: invokeinterface 66 2 0
    //   72: return
    //   73: astore_1
    //   74: new 68	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 71	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException:<init>	(Ljava/io/IOException;)V
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 55	com/google/android/exoplayer2/upstream/ContentDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   89: aload_0
    //   90: getfield 60	com/google/android/exoplayer2/upstream/ContentDataSource:opened	Z
    //   93: ifeq +25 -> 118
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 60	com/google/android/exoplayer2/upstream/ContentDataSource:opened	Z
    //   101: aload_0
    //   102: getfield 40	com/google/android/exoplayer2/upstream/ContentDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   105: ifnull +13 -> 118
    //   108: aload_0
    //   109: getfield 40	com/google/android/exoplayer2/upstream/ContentDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   112: aload_0
    //   113: invokeinterface 66 2 0
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: new 68	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 71	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException:<init>	(Ljava/io/IOException;)V
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 49	com/google/android/exoplayer2/upstream/ContentDataSource:inputStream	Ljava/io/FileInputStream;
    //   136: aload_0
    //   137: getfield 55	com/google/android/exoplayer2/upstream/ContentDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   140: ifnull +10 -> 150
    //   143: aload_0
    //   144: getfield 55	com/google/android/exoplayer2/upstream/ContentDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   147: invokevirtual 58	android/content/res/AssetFileDescriptor:close	()V
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 55	com/google/android/exoplayer2/upstream/ContentDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   155: aload_0
    //   156: getfield 60	com/google/android/exoplayer2/upstream/ContentDataSource:opened	Z
    //   159: ifeq +25 -> 184
    //   162: aload_0
    //   163: iconst_0
    //   164: putfield 60	com/google/android/exoplayer2/upstream/ContentDataSource:opened	Z
    //   167: aload_0
    //   168: getfield 40	com/google/android/exoplayer2/upstream/ContentDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   171: ifnull +13 -> 184
    //   174: aload_0
    //   175: getfield 40	com/google/android/exoplayer2/upstream/ContentDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   178: aload_0
    //   179: invokeinterface 66 2 0
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: new 68	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException
    //   190: dup
    //   191: aload_1
    //   192: invokespecial 71	com/google/android/exoplayer2/upstream/ContentDataSource$ContentDataSourceException:<init>	(Ljava/io/IOException;)V
    //   195: athrow
    //   196: astore_1
    //   197: aload_0
    //   198: aconst_null
    //   199: putfield 55	com/google/android/exoplayer2/upstream/ContentDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   202: aload_0
    //   203: getfield 60	com/google/android/exoplayer2/upstream/ContentDataSource:opened	Z
    //   206: ifeq +25 -> 231
    //   209: aload_0
    //   210: iconst_0
    //   211: putfield 60	com/google/android/exoplayer2/upstream/ContentDataSource:opened	Z
    //   214: aload_0
    //   215: getfield 40	com/google/android/exoplayer2/upstream/ContentDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   218: ifnull +13 -> 231
    //   221: aload_0
    //   222: getfield 40	com/google/android/exoplayer2/upstream/ContentDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   225: aload_0
    //   226: invokeinterface 66 2 0
    //   231: aload_1
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	ContentDataSource
    //   73	6	1	localIOException1	IOException
    //   83	36	1	localObject1	Object
    //   120	6	1	localIOException2	IOException
    //   130	55	1	localObject2	Object
    //   186	6	1	localIOException3	IOException
    //   196	36	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   24	38	73	java/io/IOException
    //   24	38	83	finally
    //   74	83	83	finally
    //   5	19	120	java/io/IOException
    //   5	19	130	finally
    //   121	130	130	finally
    //   136	150	186	java/io/IOException
    //   136	150	196	finally
    //   187	196	196	finally
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    long l1 = -1L;
    try
    {
      this.uri = paramDataSpec.uri;
      this.assetFileDescriptor = this.resolver.openAssetFileDescriptor(this.uri, "r");
      if (this.assetFileDescriptor == null) {
        throw new FileNotFoundException("Could not open file descriptor for: " + this.uri);
      }
    }
    catch (IOException paramDataSpec)
    {
      throw new ContentDataSource.ContentDataSourceException(paramDataSpec);
    }
    this.inputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
    long l2 = this.assetFileDescriptor.getStartOffset();
    l2 = this.inputStream.skip(paramDataSpec.position + l2) - l2;
    if (l2 != paramDataSpec.position) {
      throw new EOFException();
    }
    if (paramDataSpec.length != -1L) {
      this.bytesRemaining = paramDataSpec.length;
    }
    for (;;)
    {
      this.opened = true;
      if (this.listener != null) {
        this.listener.onTransferStart(this, paramDataSpec);
      }
      return this.bytesRemaining;
      long l3 = this.assetFileDescriptor.getLength();
      if (l3 == -1L)
      {
        FileChannel localFileChannel = this.inputStream.getChannel();
        l2 = localFileChannel.size();
        if (l2 == 0L) {}
        for (;;)
        {
          this.bytesRemaining = l1;
          break;
          l1 = l2 - localFileChannel.position();
        }
      }
      this.bytesRemaining = (l3 - l2);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = -1;
    int i;
    if (paramInt2 == 0) {
      i = 0;
    }
    for (;;)
    {
      return i;
      i = j;
      if (this.bytesRemaining != 0L) {
        try
        {
          if (this.bytesRemaining == -1L) {}
          for (;;)
          {
            paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
            if (paramInt1 != -1) {
              break label111;
            }
            i = j;
            if (this.bytesRemaining == -1L) {
              break;
            }
            throw new ContentDataSource.ContentDataSourceException(new EOFException());
            long l = Math.min(this.bytesRemaining, paramInt2);
            paramInt2 = (int)l;
          }
          if (this.bytesRemaining == -1L) {
            break label133;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          throw new ContentDataSource.ContentDataSourceException(paramArrayOfByte);
        }
      }
    }
    label111:
    this.bytesRemaining -= paramInt1;
    label133:
    if (this.listener != null) {
      this.listener.onBytesTransferred(this, paramInt1);
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.ContentDataSource
 * JD-Core Version:    0.7.0.1
 */