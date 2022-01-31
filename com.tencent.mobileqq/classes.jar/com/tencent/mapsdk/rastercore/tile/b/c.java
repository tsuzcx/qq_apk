package com.tencent.mapsdk.rastercore.tile.b;

import java.net.MalformedURLException;
import java.net.URL;

public final class c
  extends a
{
  private String[] a = { "https://p0.map.gtimg.com/sateTiles", "https://p1.map.gtimg.com/sateTiles", "https://p2.map.gtimg.com/sateTiles", "https://p3.map.gtimg.com/sateTiles" };
  
  public c(int paramInt)
  {
    super(paramInt);
  }
  
  public final URL getTileUrl(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    paramInt2 = (int)(Math.pow(2.0D, paramInt3) - paramInt2 - 1.0D);
    int i = a(paramInt1 + paramInt2, 4);
    paramVarArgs = this.a[i] + '/' + paramInt3 + '/' + (paramInt1 >> 4) + '/' + (paramInt2 >> 4) + '/' + paramInt1 + '_' + paramInt2 + ".jpg";
    try
    {
      URL localURL = new URL(paramVarArgs);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      new StringBuilder("Unable to new URL with ").append(paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b.c
 * JD-Core Version:    0.7.0.1
 */