package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.rastercore.b;
import java.net.MalformedURLException;
import java.net.URL;

public final class f
  extends a
{
  private String[] a = { "https://m0.map.gtimg.com/hwap", "https://m1.map.gtimg.com/hwap", "https://m2.map.gtimg.com/hwap", "https://m3.map.gtimg.com/hwap" };
  
  public final URL getTileUrl(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    int n = 0;
    j = 0;
    m = b.a;
    k = m;
    i = j;
    if (paramVarArgs != null)
    {
      k = m;
      i = j;
      j = n;
    }
    for (;;)
    {
      try
      {
        if (paramVarArgs.length == 2)
        {
          j = n;
          i = Integer.parseInt(paramVarArgs[0].toString());
          j = i;
          k = Integer.parseInt(paramVarArgs[1].toString());
        }
      }
      catch (Exception paramVarArgs)
      {
        k = m;
        i = j;
        continue;
      }
      try
      {
        j = a(paramInt1 + paramInt2, this.a.length);
        paramInt2 = (int)(Math.pow(2.0D, paramInt3) - paramInt2 - 1.0D);
        paramVarArgs = new StringBuilder(128);
        paramVarArgs.append(this.a[j]);
        paramVarArgs.append("?");
        paramVarArgs.append("z=");
        paramVarArgs.append(paramInt3 - 1);
        paramVarArgs.append("&x=");
        paramVarArgs.append(paramInt1);
        paramVarArgs.append("&y=");
        paramVarArgs.append(paramInt2);
        paramVarArgs.append("&styleid=");
        paramVarArgs.append(b.e);
        paramVarArgs.append("&scene=");
        paramVarArgs.append(i);
        paramVarArgs.append("&version=");
        paramVarArgs.append(k);
        paramVarArgs = new URL(paramVarArgs.toString());
        return paramVarArgs;
      }
      catch (MalformedURLException paramVarArgs)
      {
        new StringBuilder("Error new URL with str:").append(null);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b.f
 * JD-Core Version:    0.7.0.1
 */