package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import java.net.URLDecoder;

public final class DataSchemeDataSource
  implements DataSource
{
  public static final String SCHEME_DATA = "data";
  private int bytesRead;
  private byte[] data;
  private DataSpec dataSpec;
  
  public void close()
  {
    this.dataSpec = null;
    this.data = null;
  }
  
  public Uri getUri()
  {
    DataSpec localDataSpec = this.dataSpec;
    if (localDataSpec != null) {
      return localDataSpec.uri;
    }
    return null;
  }
  
  public long open(DataSpec paramDataSpec)
  {
    this.dataSpec = paramDataSpec;
    paramDataSpec = paramDataSpec.uri;
    Object localObject = paramDataSpec.getScheme();
    StringBuilder localStringBuilder1;
    if ("data".equals(localObject))
    {
      localObject = paramDataSpec.getSchemeSpecificPart().split(",");
      if (localObject.length <= 2)
      {
        paramDataSpec = localObject[1];
        if (localObject[0].contains(";base64")) {
          try
          {
            this.data = Base64.decode(paramDataSpec, 0);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("Error while parsing Base64 encoded string: ");
            localStringBuilder2.append(paramDataSpec);
            throw new ParserException(localStringBuilder2.toString(), localIllegalArgumentException);
          }
        } else {
          this.data = URLDecoder.decode(paramDataSpec, "US-ASCII").getBytes();
        }
        return this.data.length;
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Unexpected URI format: ");
      localStringBuilder1.append(paramDataSpec);
      throw new ParserException(localStringBuilder1.toString());
    }
    paramDataSpec = new StringBuilder();
    paramDataSpec.append("Unsupported scheme: ");
    paramDataSpec.append(localStringBuilder1);
    throw new ParserException(paramDataSpec.toString());
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    int i = this.data.length - this.bytesRead;
    if (i == 0) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, i);
    System.arraycopy(this.data, this.bytesRead, paramArrayOfByte, paramInt1, paramInt2);
    this.bytesRead += paramInt2;
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DataSchemeDataSource
 * JD-Core Version:    0.7.0.1
 */