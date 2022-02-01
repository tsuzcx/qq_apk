package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource
  implements DataSource
{
  private final AssetManager assetManager;
  private long bytesRemaining;
  private InputStream inputStream;
  private final TransferListener<? super AssetDataSource> listener;
  private boolean opened;
  private Uri uri;
  
  public AssetDataSource(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AssetDataSource(Context paramContext, TransferListener<? super AssetDataSource> paramTransferListener)
  {
    this.assetManager = paramContext.getAssets();
    this.listener = paramTransferListener;
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 45	com/google/android/exoplayer2/upstream/AssetDataSource:uri	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 47	com/google/android/exoplayer2/upstream/AssetDataSource:inputStream	Ljava/io/InputStream;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 47	com/google/android/exoplayer2/upstream/AssetDataSource:inputStream	Ljava/io/InputStream;
    //   16: invokevirtual 51	java/io/InputStream:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 47	com/google/android/exoplayer2/upstream/AssetDataSource:inputStream	Ljava/io/InputStream;
    //   24: aload_0
    //   25: getfield 53	com/google/android/exoplayer2/upstream/AssetDataSource:opened	Z
    //   28: ifeq +24 -> 52
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 53	com/google/android/exoplayer2/upstream/AssetDataSource:opened	Z
    //   36: aload_0
    //   37: getfield 38	com/google/android/exoplayer2/upstream/AssetDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +10 -> 52
    //   45: aload_1
    //   46: aload_0
    //   47: invokeinterface 59 2 0
    //   52: return
    //   53: astore_1
    //   54: goto +13 -> 67
    //   57: astore_1
    //   58: new 61	com/google/android/exoplayer2/upstream/AssetDataSource$AssetDataSourceException
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 64	com/google/android/exoplayer2/upstream/AssetDataSource$AssetDataSourceException:<init>	(Ljava/io/IOException;)V
    //   66: athrow
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 47	com/google/android/exoplayer2/upstream/AssetDataSource:inputStream	Ljava/io/InputStream;
    //   72: aload_0
    //   73: getfield 53	com/google/android/exoplayer2/upstream/AssetDataSource:opened	Z
    //   76: ifeq +24 -> 100
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield 53	com/google/android/exoplayer2/upstream/AssetDataSource:opened	Z
    //   84: aload_0
    //   85: getfield 38	com/google/android/exoplayer2/upstream/AssetDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +10 -> 100
    //   93: aload_2
    //   94: aload_0
    //   95: invokeinterface 59 2 0
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	AssetDataSource
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
      String str = this.uri.getPath();
      Object localObject;
      if (str.startsWith("/android_asset/"))
      {
        localObject = str.substring(15);
      }
      else
      {
        localObject = str;
        if (str.startsWith("/")) {
          localObject = str.substring(1);
        }
      }
      this.inputStream = this.assetManager.open((String)localObject, 1);
      if (this.inputStream.skip(paramDataSpec.position) >= paramDataSpec.position)
      {
        if (paramDataSpec.length != -1L)
        {
          this.bytesRemaining = paramDataSpec.length;
        }
        else
        {
          this.bytesRemaining = this.inputStream.available();
          if (this.bytesRemaining == 2147483647L) {
            this.bytesRemaining = -1L;
          }
        }
        this.opened = true;
        localObject = this.listener;
        if (localObject != null) {
          ((TransferListener)localObject).onTransferStart(this, paramDataSpec);
        }
        return this.bytesRemaining;
      }
      throw new EOFException();
    }
    catch (IOException paramDataSpec)
    {
      throw new AssetDataSource.AssetDataSourceException(paramDataSpec);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l1 = this.bytesRemaining;
    if (l1 == 0L) {
      return -1;
    }
    long l2;
    if (l1 != -1L) {
      l2 = paramInt2;
    }
    try
    {
      paramInt2 = (int)Math.min(l1, l2);
      paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 == -1)
      {
        if (this.bytesRemaining == -1L) {
          return -1;
        }
        throw new AssetDataSource.AssetDataSourceException(new EOFException());
      }
      l1 = this.bytesRemaining;
      if (l1 != -1L) {
        this.bytesRemaining = (l1 - paramInt1);
      }
      paramArrayOfByte = this.listener;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.onBytesTransferred(this, paramInt1);
      }
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new AssetDataSource.AssetDataSourceException(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.AssetDataSource
 * JD-Core Version:    0.7.0.1
 */