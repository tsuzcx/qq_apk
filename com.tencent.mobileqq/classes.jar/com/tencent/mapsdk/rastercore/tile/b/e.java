package com.tencent.mapsdk.rastercore.tile.b;

import java.net.MalformedURLException;
import java.net.URL;

public final class e
  extends a
{
  private static final String[] a = { "https://rtt2.map.qq.com", "https://rtt2a.map.qq.com", "https://rtt2b.map.qq.com", "https://rtt2c.map.qq.com" };
  
  public e(int paramInt)
  {
    super(paramInt);
  }
  
  public final URL getTileUrl(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    if (paramInt3 < 10) {
      return null;
    }
    paramVarArgs = a[((paramInt1 + paramInt2) % a.length)];
    paramInt2 = (int)(Math.pow(2.0D, paramInt3) - paramInt2 - 1.0D);
    paramVarArgs = paramVarArgs + "/rtt/?z=" + paramInt3 + "&x=" + paramInt1 + "&y=" + paramInt2 + "&ref=android2DSdk&timeKey=" + System.currentTimeMillis();
    try
    {
      URL localURL = new URL(paramVarArgs);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      getClass().getSimpleName();
      new StringBuilder("Can not convert ").append(paramVarArgs).append(" to URL.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b.e
 * JD-Core Version:    0.7.0.1
 */