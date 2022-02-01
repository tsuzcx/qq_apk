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
    if (paramLong1 >= 0L)
    {
      bool = true;
      Assertions.checkArgument(bool);
      if (paramLong2 < 0L) {
        break label103;
      }
      bool = true;
      label28:
      Assertions.checkArgument(bool);
      if ((paramLong3 <= 0L) && (paramLong3 != -1L)) {
        break label109;
      }
    }
    label103:
    label109:
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      this.uri = paramUri;
      this.postBody = paramArrayOfByte;
      this.absoluteStreamPosition = paramLong1;
      this.position = paramLong2;
      this.length = paramLong3;
      this.key = paramString;
      this.flags = paramInt;
      return;
      bool = false;
      break;
      bool = false;
      break label28;
    }
  }
  
  public boolean isFlagSet(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public DataSpec subrange(long paramLong)
  {
    long l = -1L;
    if (this.length == -1L) {}
    for (;;)
    {
      return subrange(paramLong, l);
      l = this.length - paramLong;
    }
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
    return "DataSpec[" + this.uri + ", " + Arrays.toString(this.postBody) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DataSpec
 * JD-Core Version:    0.7.0.1
 */