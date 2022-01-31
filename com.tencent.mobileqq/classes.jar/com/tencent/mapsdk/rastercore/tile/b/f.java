package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.rastercore.d.h;
import java.net.MalformedURLException;
import java.net.URL;

public class f
  extends a
{
  private String[] a = { "https://s0.map.gtimg.com/oversea", "https://s1.map.gtimg.com/oversea", "https://s2.map.gtimg.com/oversea", "https://s3.map.gtimg.com/oversea" };
  
  public f(int paramInt)
  {
    super(paramInt);
  }
  
  public URL getTileUrl(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    int i = a(paramInt1 + paramInt2, this.a.length);
    paramVarArgs = this.a[i];
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramVarArgs);
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append("z=").append(paramInt3);
    ((StringBuilder)localObject).append("&x=").append(paramInt1);
    ((StringBuilder)localObject).append("&y=").append(paramInt2);
    ((StringBuilder)localObject).append("&styleid=").append(h.e());
    ((StringBuilder)localObject).append("&scene=").append(h.f());
    ((StringBuilder)localObject).append("&version=").append(h.g());
    ((StringBuilder)localObject).append("&ch=").append(com.tencent.mapsdk.rastercore.d.f.q());
    paramVarArgs = ((StringBuilder)localObject).toString();
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
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b.f
 * JD-Core Version:    0.7.0.1
 */