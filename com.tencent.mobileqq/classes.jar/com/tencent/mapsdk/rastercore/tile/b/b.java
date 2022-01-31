package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.rastercore.d.e;
import java.net.MalformedURLException;
import java.net.URL;

public class b
  extends a
{
  private String[] a = { "https://s0.map.gtimg.com/oversea", "https://s1.map.gtimg.com/oversea", "https://s2.map.gtimg.com/oversea", "https://s3.map.gtimg.com/oversea" };
  
  public URL getTileUrl(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    int i = e.t();
    int j = e.s();
    paramVarArgs = e.v();
    int k = e.u();
    int m = a(paramInt1 + paramInt2, this.a.length);
    Object localObject = this.a[m];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("?z=").append(paramInt3).append("&x=").append(paramInt1).append("&y=").append(paramInt2).append("&styleid=").append(k).append("&scene=").append(i).append("&version=").append(j).append("&ch=").append(paramVarArgs);
    paramVarArgs = localStringBuilder.toString();
    try
    {
      localObject = new URL(paramVarArgs);
      return localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      new StringBuilder("Unable to new URL with ").append(paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b.b
 * JD-Core Version:    0.7.0.1
 */