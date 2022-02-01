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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rawresource:///");
    localStringBuilder.append(paramInt);
    return Uri.parse(localStringBuilder.toString());
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
    //   47: ifeq +24 -> 71
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   55: aload_0
    //   56: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +10 -> 71
    //   64: aload_1
    //   65: aload_0
    //   66: invokeinterface 94 2 0
    //   71: return
    //   72: astore_1
    //   73: goto +13 -> 86
    //   76: astore_1
    //   77: new 96	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 99	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   85: athrow
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   91: aload_0
    //   92: getfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   95: ifeq +24 -> 119
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   103: aload_0
    //   104: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   107: astore_2
    //   108: aload_2
    //   109: ifnull +10 -> 119
    //   112: aload_2
    //   113: aload_0
    //   114: invokeinterface 94 2 0
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto +13 -> 135
    //   125: astore_1
    //   126: new 96	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   129: dup
    //   130: aload_1
    //   131: invokespecial 99	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   134: athrow
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 77	com/google/android/exoplayer2/upstream/RawResourceDataSource:inputStream	Ljava/io/InputStream;
    //   140: aload_0
    //   141: getfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   144: ifnull +10 -> 154
    //   147: aload_0
    //   148: getfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   151: invokevirtual 86	android/content/res/AssetFileDescriptor:close	()V
    //   154: aload_0
    //   155: aconst_null
    //   156: putfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   159: aload_0
    //   160: getfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   163: ifeq +24 -> 187
    //   166: aload_0
    //   167: iconst_0
    //   168: putfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   171: aload_0
    //   172: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   175: astore_2
    //   176: aload_2
    //   177: ifnull +10 -> 187
    //   180: aload_2
    //   181: aload_0
    //   182: invokeinterface 94 2 0
    //   187: aload_1
    //   188: athrow
    //   189: astore_1
    //   190: goto +13 -> 203
    //   193: astore_1
    //   194: new 96	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException
    //   197: dup
    //   198: aload_1
    //   199: invokespecial 99	com/google/android/exoplayer2/upstream/RawResourceDataSource$RawResourceDataSourceException:<init>	(Ljava/io/IOException;)V
    //   202: athrow
    //   203: aload_0
    //   204: aconst_null
    //   205: putfield 83	com/google/android/exoplayer2/upstream/RawResourceDataSource:assetFileDescriptor	Landroid/content/res/AssetFileDescriptor;
    //   208: aload_0
    //   209: getfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   212: ifeq +24 -> 236
    //   215: aload_0
    //   216: iconst_0
    //   217: putfield 88	com/google/android/exoplayer2/upstream/RawResourceDataSource:opened	Z
    //   220: aload_0
    //   221: getfield 44	com/google/android/exoplayer2/upstream/RawResourceDataSource:listener	Lcom/google/android/exoplayer2/upstream/TransferListener;
    //   224: astore_2
    //   225: aload_2
    //   226: ifnull +10 -> 236
    //   229: aload_2
    //   230: aload_0
    //   231: invokeinterface 94 2 0
    //   236: aload_1
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	RawResourceDataSource
    //   59	6	1	localTransferListener1	TransferListener
    //   72	1	1	localObject1	Object
    //   76	44	1	localIOException1	IOException
    //   121	1	1	localObject2	Object
    //   125	63	1	localIOException2	IOException
    //   189	1	1	localObject3	Object
    //   193	44	1	localIOException3	IOException
    //   107	123	2	localTransferListener2	TransferListener
    // Exception table:
    //   from	to	target	type
    //   24	38	72	finally
    //   77	86	72	finally
    //   24	38	76	java/io/IOException
    //   5	19	121	finally
    //   126	135	121	finally
    //   5	19	125	java/io/IOException
    //   140	154	189	finally
    //   194	203	189	finally
    //   140	154	193	java/io/IOException
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
      boolean bool = TextUtils.equals("rawresource", this.uri.getScheme());
      if (!bool) {}
    }
    catch (IOException paramDataSpec)
    {
      int i;
      label205:
      throw new RawResourceDataSource.RawResourceDataSourceException(paramDataSpec);
    }
    try
    {
      i = Integer.parseInt(this.uri.getLastPathSegment());
      this.assetFileDescriptor = this.resources.openRawResourceFd(i);
      this.inputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
      this.inputStream.skip(this.assetFileDescriptor.getStartOffset());
      if (this.inputStream.skip(paramDataSpec.position) >= paramDataSpec.position)
      {
        long l2 = paramDataSpec.length;
        long l1 = -1L;
        if (l2 != -1L)
        {
          this.bytesRemaining = paramDataSpec.length;
        }
        else
        {
          l2 = this.assetFileDescriptor.getLength();
          if (l2 != -1L) {
            l1 = l2 - paramDataSpec.position;
          }
          this.bytesRemaining = l1;
        }
        this.opened = true;
        TransferListener localTransferListener = this.listener;
        if (localTransferListener != null) {
          localTransferListener.onTransferStart(this, paramDataSpec);
        }
        return this.bytesRemaining;
      }
      throw new EOFException();
    }
    catch (NumberFormatException paramDataSpec)
    {
      break label205;
    }
    throw new RawResourceDataSource.RawResourceDataSourceException("Resource identifier must be an integer.");
    throw new RawResourceDataSource.RawResourceDataSourceException("URI must use scheme rawresource");
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
        throw new RawResourceDataSource.RawResourceDataSourceException(new EOFException());
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
      throw new RawResourceDataSource.RawResourceDataSourceException(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.RawResourceDataSource
 * JD-Core Version:    0.7.0.1
 */