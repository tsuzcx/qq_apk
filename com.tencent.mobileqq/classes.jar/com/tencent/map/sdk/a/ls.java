package com.tencent.map.sdk.a;

import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import java.util.ArrayList;
import java.util.List;

public final class ls
  implements la
{
  public pn a = null;
  
  public ls(IMapRenderView paramIMapRenderView)
  {
    this.a = ((pn)paramIMapRenderView.getVectorMapDelegate());
  }
  
  public final Polygon a(PolygonOptions paramPolygonOptions, kp paramkp)
  {
    if (this.a == null) {}
    mv localmv;
    do
    {
      return null;
      localmv = new mv(this.a, paramPolygonOptions);
      localmv.a(paramPolygonOptions);
      localmv.d();
    } while (!this.a.a(localmv));
    this.a.az.b.k();
    return new Polygon(paramPolygonOptions, paramkp, localmv.L);
  }
  
  public final void a()
  {
    if (this.a != null) {
      this.a.c(mv.class);
    }
  }
  
  public final void a(String paramString)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramString, true);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, float paramFloat)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.a(paramFloat);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, int paramInt)
  {
    if (this.a == null) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.c(paramInt);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, PolygonOptions paramPolygonOptions)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mv)) {
      return;
    }
    ((mv)paramString).a(paramPolygonOptions);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, List<LatLng> paramList)
  {
    Object localObject = null;
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    if (!(paramString instanceof mv)) {
      return;
    }
    mv localmv = (mv)paramString;
    if (paramList == null) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      localmv.a(paramString);
      localmv.d();
      this.a.az.b.k();
      return;
      int j = paramList.size();
      paramString = (String)localObject;
      if (j > 0)
      {
        paramString = new ArrayList();
        int i = 0;
        while (i < j)
        {
          localObject = (LatLng)paramList.get(i);
          if (localObject != null)
          {
            localObject = fz.a((LatLng)localObject);
            if (localObject != null) {
              paramString.add(localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.c(paramBoolean);
    this.a.az.b.k();
  }
  
  public final List<gg> b(String paramString)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return null;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if ((paramString == null) || (!(paramString instanceof mv))) {
        return null;
      }
      paramString = (mv)paramString;
      ??? = new ArrayList(1);
      ((List)???).add(paramString);
      return ???;
    }
  }
  
  public final void b(String paramString, float paramFloat)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.b(paramFloat);
    this.a.az.b.k();
  }
  
  public final void b(String paramString, int paramInt)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.b(paramInt);
    this.a.az.b.k();
  }
  
  public final void c(String paramString, int paramInt)
  {
    if ((this.a == null) || (this.a.az == null)) {
      return;
    }
    synchronized (this.a.a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
    }
    paramString.d(paramInt);
    paramString.d();
    this.a.az.b.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ls
 * JD-Core Version:    0.7.0.1
 */