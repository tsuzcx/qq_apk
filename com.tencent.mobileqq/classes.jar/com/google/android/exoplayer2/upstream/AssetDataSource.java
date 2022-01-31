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
  
  public void close()
  {
    this.uri = null;
    try
    {
      if (this.inputStream != null) {
        this.inputStream.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      throw new AssetDataSource.AssetDataSourceException(localIOException);
    }
    finally
    {
      this.inputStream = null;
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
      String str2;
      try
      {
        this.uri = paramDataSpec.uri;
        str2 = this.uri.getPath();
        if (str2.startsWith("/android_asset/"))
        {
          str1 = str2.substring(15);
          this.inputStream = this.assetManager.open(str1, 1);
          if (this.inputStream.skip(paramDataSpec.position) >= paramDataSpec.position) {
            break;
          }
          throw new EOFException();
        }
      }
      catch (IOException paramDataSpec)
      {
        throw new AssetDataSource.AssetDataSourceException(paramDataSpec);
      }
      String str1 = str2;
      if (str2.startsWith("/")) {
        str1 = str2.substring(1);
      }
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
      this.bytesRemaining = this.inputStream.available();
      if (this.bytesRemaining == 2147483647L) {
        this.bytesRemaining = -1L;
      }
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
            throw new AssetDataSource.AssetDataSourceException(new EOFException());
            long l = Math.min(this.bytesRemaining, paramInt2);
            paramInt2 = (int)l;
          }
          if (this.bytesRemaining == -1L) {
            break label133;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          throw new AssetDataSource.AssetDataSourceException(paramArrayOfByte);
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
 * Qualified Name:     com.google.android.exoplayer2.upstream.AssetDataSource
 * JD-Core Version:    0.7.0.1
 */