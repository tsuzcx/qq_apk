package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Constructor;

public final class DefaultDataSource
  implements DataSource
{
  private static final String SCHEME_ASSET = "asset";
  private static final String SCHEME_CONTENT = "content";
  private static final String SCHEME_RAW = "rawresource";
  private static final String SCHEME_RTMP = "rtmp";
  private static final String TAG = "DefaultDataSource";
  private DataSource assetDataSource;
  private final DataSource baseDataSource;
  private DataSource contentDataSource;
  private final Context context;
  private DataSource dataSchemeDataSource;
  private DataSource dataSource;
  private DataSource fileDataSource;
  private final TransferListener<? super DataSource> listener;
  private DataSource rawResourceDataSource;
  private DataSource rtmpDataSource;
  
  public DefaultDataSource(Context paramContext, TransferListener<? super DataSource> paramTransferListener, DataSource paramDataSource)
  {
    this.context = paramContext.getApplicationContext();
    this.listener = paramTransferListener;
    this.baseDataSource = ((DataSource)Assertions.checkNotNull(paramDataSource));
  }
  
  public DefaultDataSource(Context paramContext, TransferListener<? super DataSource> paramTransferListener, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramContext, paramTransferListener, new DefaultHttpDataSource(paramString, null, paramTransferListener, paramInt1, paramInt2, paramBoolean, null));
  }
  
  public DefaultDataSource(Context paramContext, TransferListener<? super DataSource> paramTransferListener, String paramString, boolean paramBoolean)
  {
    this(paramContext, paramTransferListener, paramString, 8000, 8000, paramBoolean);
  }
  
  private DataSource getAssetDataSource()
  {
    if (this.assetDataSource == null) {
      this.assetDataSource = new AssetDataSource(this.context, this.listener);
    }
    return this.assetDataSource;
  }
  
  private DataSource getContentDataSource()
  {
    if (this.contentDataSource == null) {
      this.contentDataSource = new ContentDataSource(this.context, this.listener);
    }
    return this.contentDataSource;
  }
  
  private DataSource getDataSchemeDataSource()
  {
    if (this.dataSchemeDataSource == null) {
      this.dataSchemeDataSource = new DataSchemeDataSource();
    }
    return this.dataSchemeDataSource;
  }
  
  private DataSource getFileDataSource()
  {
    if (this.fileDataSource == null) {
      this.fileDataSource = new FileDataSource(this.listener);
    }
    return this.fileDataSource;
  }
  
  private DataSource getRawResourceDataSource()
  {
    if (this.rawResourceDataSource == null) {
      this.rawResourceDataSource = new RawResourceDataSource(this.context, this.listener);
    }
    return this.rawResourceDataSource;
  }
  
  private DataSource getRtmpDataSource()
  {
    if (this.rtmpDataSource == null) {}
    try
    {
      try
      {
        this.rtmpDataSource = ((DataSource)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]));
      }
      catch (Exception localException)
      {
        throw new RuntimeException("Error instantiating RTMP extension", localException);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label48:
      break label48;
    }
    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
    if (this.rtmpDataSource == null) {
      this.rtmpDataSource = this.baseDataSource;
    }
    return this.rtmpDataSource;
  }
  
  public void close()
  {
    DataSource localDataSource = this.dataSource;
    if (localDataSource != null) {
      try
      {
        localDataSource.close();
        return;
      }
      finally
      {
        this.dataSource = null;
      }
    }
  }
  
  public Uri getUri()
  {
    DataSource localDataSource = this.dataSource;
    if (localDataSource == null) {
      return null;
    }
    return localDataSource.getUri();
  }
  
  public long open(DataSpec paramDataSpec)
  {
    boolean bool;
    if (this.dataSource == null) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkState(bool);
    String str = paramDataSpec.uri.getScheme();
    if (Util.isLocalFileUri(paramDataSpec.uri))
    {
      if (paramDataSpec.uri.getPath().startsWith("/android_asset/")) {
        this.dataSource = getAssetDataSource();
      } else {
        this.dataSource = getFileDataSource();
      }
    }
    else if ("asset".equals(str)) {
      this.dataSource = getAssetDataSource();
    } else if ("content".equals(str)) {
      this.dataSource = getContentDataSource();
    } else if ("rtmp".equals(str)) {
      this.dataSource = getRtmpDataSource();
    } else if ("data".equals(str)) {
      this.dataSource = getDataSchemeDataSource();
    } else if ("rawresource".equals(str)) {
      this.dataSource = getRawResourceDataSource();
    } else {
      this.dataSource = this.baseDataSource;
    }
    return this.dataSource.open(paramDataSpec);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.dataSource.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DefaultDataSource
 * JD-Core Version:    0.7.0.1
 */