package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class DataSpec
{
  public static final int FLAG_ALLOW_CACHING_UNKNOWN_LENGTH = 2;
  public static final int FLAG_ALLOW_GZIP = 1;
  public final long absoluteStreamPosition;
  public final int flags;
  @Nullable
  public final String key;
  public final long length;
  public final long position;
  public final byte[] postBody;
  public final Uri uri;
  
  public DataSpec(Uri paramUri)
  {
    this(paramUri, 0);
  }
  
  public DataSpec(Uri paramUri, int paramInt)
  {
    this(paramUri, 0L, -1L, null, paramInt);
  }
  
  public DataSpec(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    this(paramUri, null, paramLong1, paramLong2, paramLong3, paramString, paramInt);
  }
  
  public DataSpec(Uri paramUri, long paramLong1, long paramLong2, @Nullable String paramString)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, 0);
  }
  
  public DataSpec(Uri paramUri, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, paramInt);
  }
  
  public DataSpec(Uri paramUri, byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, @Nullable String paramString, int paramInt)
  {
    boolean bool2 = true;
    if (paramLong1 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    if (paramLong2 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    boolean bool1 = bool2;
    if (paramLong3 <= 0L) {
      if (paramLong3 == -1L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    Assertions.checkArgument(bool1);
    this.uri = paramUri;
    this.postBody = paramArrayOfByte;
    this.absoluteStreamPosition = paramLong1;
    this.position = paramLong2;
    this.length = paramLong3;
    this.key = paramString;
    this.flags = paramInt;
  }
  
  public boolean isFlagSet(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public DataSpec subrange(long paramLong)
  {
    long l2 = this.length;
    long l1 = -1L;
    if (l2 != -1L) {
      l1 = l2 - paramLong;
    }
    return subrange(paramLong, l1);
  }
  
  public DataSpec subrange(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (this.length == paramLong2)) {
      return this;
    }
    return new DataSpec(this.uri, this.postBody, this.absoluteStreamPosition + paramLong1, this.position + paramLong1, paramLong2, this.key, this.flags);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataSpec[");
    localStringBuilder.append(this.uri);
    localStringBuilder.append(", ");
    localStringBuilder.append(Arrays.toString(this.postBody));
    localStringBuilder.append(", ");
    localStringBuilder.append(this.absoluteStreamPosition);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.position);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.length);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.key);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.flags);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DataSpec
 * JD-Core Version:    0.7.0.1
 */