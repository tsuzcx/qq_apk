package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class RawResourceDataSource
  implements DataSource
{
  public static final String RAW_RESOURCE_SCHEME = "rawresource";
  private AssetFileDescriptor assetFileDescriptor;
  private long bytesRemaining;
  private InputStream inputStream;
  private final TransferListener<? super RawResourceDataSource> listener;
  private boolean opened;
  private final Resources resources;
  private Uri uri;
  
  public RawResourceDataSource(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RawResourceDataSource(Context paramContext, TransferListener<? super RawResourceDataSource> paramTransferListener)
  {
    this.resources = paramContext.getResources();
    this.listener = paramTransferListener;
  }
  
  public static Uri buildRawResourceUri(int paramInt)
  {
    return Uri.parse("rawresource:///" + paramInt);
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 75	com/google/android/exoplayer2/upstream/RawResourceDataSource:uri	Landroid/net/Uri;
    //   5: aload_0
    //   6: getfield 77	com/google/android/exoplayer2/upstream/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 77	com/google/android/exoplayer2/upstream/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   16: invokevirtual 81	java/io/InputStream:close	()V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 77	com/google/android/exoplayer2/upstream/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   24: aload_0
    //   25: getfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   28: ifnull +10 -> 38
    //   31: aload_0
    //   32: getfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   35: invokevirtual 86	android/content/res/AssetFileDescriptor:close	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   43: aload_0
    //   44: getfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   47: ifeq +25 -> 72
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   55: aload_0
    //   56: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   59: ifnull +13 -> 72
    //   62: aload_0
    //   63: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   66: aload_0
    //   67: invokeinterface 94 2 0
    //   72: return
    //   73: astore_1
    //   74: new 96	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 99	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   89: aload_0
    //   90: getfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   93: ifeq +25 -> 118
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   101: aload_0
    //   102: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   105: ifnull +13 -> 118
    //   108: aload_0
    //   109: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   112: aload_0
    //   113: invokeinterface 94 2 0
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: new 96	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 99	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 77	com/google/android/exoplayer2/upstream/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   136: aload_0
    //   137: getfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   140: ifnull +10 -> 150
    //   143: aload_0
    //   144: getfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   147: invokevirtual 86	android/content/res/AssetFileDescriptor:close	()V
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   155: aload_0
    //   156: getfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   159: ifeq +25 -> 184
    //   162: aload_0
    //   163: iconst_0
    //   164: putfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   167: aload_0
    //   168: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   171: ifnull +13 -> 184
    //   174: aload_0
    //   175: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   178: aload_0
    //   179: invokeinterface 94 2 0
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: new 96	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   190: dup
    //   191: aload_1
    //   192: invokespecial 99	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   195: athrow
    //   196: astore_1
    //   197: aload_0
    //   198: aconst_null
    //   199: putfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   202: aload_0
    //   203: getfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   206: ifeq +25 -> 231
    //   209: aload_0
    //   210: iconst_0
    //   211: putfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   214: aload_0
    //   215: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   218: ifnull +13 -> 231
    //   221: aload_0
    //   222: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   225: aload_0
    //   226: invokeinterface 94 2 0
    //   231: aload_1
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	RawResourceDataSource
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
      if (!TextUtils.equals("rawresource", this.uri.getScheme())) {
        throw new RawResourceDataSource.RawResourceDataSourceException("URI must use scheme rawresource");
      }
    }
    catch (IOException paramDataSpec)
    {
      throw new RawResourceDataSource.RawResourceDataSourceException(paramDataSpec);
    }
    try
    {
      int i = Integer.parseInt(this.uri.getLastPathSegment());
      this.assetFileDescriptor = this.resources.openRawResourceFd(i);
      this.inputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
      this.inputStream.skip(this.assetFileDescriptor.getStartOffset());
      if (this.inputStream.skip(paramDataSpec.position) < paramDataSpec.position) {
        throw new EOFException();
      }
    }
    catch (NumberFormatException paramDataSpec)
    {
      throw new RawResourceDataSource.RawResourceDataSourceException("Resource identifier must be an integer.");
    }
    if (paramDataSpec.length != -1L)
    {
      this.bytesRemaining = paramDataSpec.length;
      this.opened = true;
      if (this.listener != null) {
        this.listener.onTransferStart(this, paramDataSpec);
      }
      return this.bytesRemaining;
    }
    long l2 = this.assetFileDescriptor.getLength();
    if (l2 == -1L) {}
    for (;;)
    {
      this.bytesRemaining = l1;
      break;
      l1 = paramDataSpec.position;
      l1 = l2 - l1;
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
            throw new RawResourceDataSource.RawResourceDataSourceException(new EOFException());
            long l = Math.min(this.bytesRemaining, paramInt2);
            paramInt2 = (int)l;
          }
          if (this.bytesRemaining == -1L) {
            break label133;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          throw new RawResourceDataSource.RawResourceDataSourceException(paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.RawResourceDataSource
 * JD-Core Version:    0.7.0.1
 */