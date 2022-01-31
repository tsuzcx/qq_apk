package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.rastercore.b;
import java.net.MalformedURLException;
import java.net.URL;

public final class d
  extends a
{
  private static final String[] a = { "http://mapar0.myapp.com/myapp/shuttle/qqraster/", "http://mapar1.myapp.com/myapp/shuttle/qqraster/", "http://mapar2.myapp.com/myapp/shuttle/qqraster/", "http://mapar3.myapp.com/myapp/shuttle/qqraster/" };
  
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
      for (;;)
      {
        Object localObject;
        k = m;
        i = j;
      }
    }
    paramVarArgs = a[((paramInt1 + paramInt2) % a.length)];
    paramInt2 = (int)(Math.pow(2.0D, paramInt3) - paramInt2 - 1.0D);
    localObject = new StringBuilder(128);
    ((StringBuilder)localObject).append(paramVarArgs);
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append("z=");
    ((StringBuilder)localObject).append(paramInt3 - 1);
    ((StringBuilder)localObject).append("&x=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("&y=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("&styleid=");
    ((StringBuilder)localObject).append(b.e);
    ((StringBuilder)localObject).append("&scene=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("&version=");
    ((StringBuilder)localObject).append(k);
    paramVarArgs = ((StringBuilder)localObject).toString();
    try
    {
      localObject = new URL(paramVarArgs);
      return localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      getClass().getSimpleName();
      new StringBuilder("Can not convert ").append(paramVarArgs).append(" to URL.");
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b.d
 * JD-Core Version:    0.7.0.1
 */