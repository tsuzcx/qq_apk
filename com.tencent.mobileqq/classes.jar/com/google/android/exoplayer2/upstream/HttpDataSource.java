package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Predicate;
import java.util.List;
import java.util.Map;

public abstract interface HttpDataSource
  extends DataSource
{
  public static final Predicate<String> REJECT_PAYWALL_TYPES = new HttpDataSource.1();
  
  public abstract void clearAllRequestProperties();
  
  public abstract void clearRequestProperty(String paramString);
  
  public abstract void close();
  
  public abstract Map<String, List<String>> getResponseHeaders();
  
  public abstract long open(DataSpec paramDataSpec);
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void setRequestProperty(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.HttpDataSource
 * JD-Core Version:    0.7.0.1
 */