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
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = new mv((pn)localObject, paramPolygonOptions);
    ((mv)localObject).a(paramPolygonOptions);
    ((mv)localObject).d();
    if (!this.a.a((mu)localObject)) {
      return null;
    }
    this.a.az.b.k();
    return new Polygon(paramPolygonOptions, paramkp, ((mu)localObject).L);
  }
  
  public final void a()
  {
    pn localpn = this.a;
    if (localpn != null) {
      localpn.c(mv.class);
    }
  }
  
  public final void a(String paramString)
  {
    pn localpn = this.a;
    if (localpn == null) {
      return;
    }
    localpn.a(paramString, true);
    this.a.az.b.k();
  }
  
  public final void a(String paramString, float paramFloat)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        paramString.a(paramFloat);
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    synchronized (((pn)???).a)
    {
      paramString = this.a.c(paramString);
      if (paramString == null) {
        return;
      }
      paramString.c(paramInt);
      this.a.az.b.k();
      return;
    }
  }
  
  public final void a(String paramString, PolygonOptions paramPolygonOptions)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mv)) {
          return;
        }
        ((mv)paramString).a(paramPolygonOptions);
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void a(String paramString, List<LatLng> paramList)
  {
    Object localObject = this.a;
    if (localObject != null) {
      if (((pt)localObject).az == null) {
        return;
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        if (!(paramString instanceof mv)) {
          return;
        }
        mv localmv = (mv)paramString;
        paramString = null;
        if (paramList != null)
        {
          int j = paramList.size();
          if (j > 0)
          {
            localObject = new ArrayList();
            i = 0;
            paramString = (String)localObject;
            if (i < j)
            {
              paramString = (LatLng)paramList.get(i);
              if (paramString == null) {
                break label180;
              }
              paramString = fz.a(paramString);
              if (paramString == null) {
                break label180;
              }
              ((ArrayList)localObject).add(paramString);
              break label180;
            }
          }
        }
        localmv.a(paramString);
        localmv.d();
        this.a.az.b.k();
        return;
      }
      return;
      label180:
      i += 1;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        paramString.c(paramBoolean);
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final List<gg> b(String paramString)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return null;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if ((paramString != null) && ((paramString instanceof mv)))
        {
          paramString = (mv)paramString;
          ??? = new ArrayList(1);
          ((List)???).add(paramString);
          return ???;
        }
        return null;
      }
    }
    return null;
  }
  
  public final void b(String paramString, float paramFloat)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        paramString.b(paramFloat);
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void b(String paramString, int paramInt)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        paramString.b(paramInt);
        this.a.az.b.k();
        return;
      }
    }
  }
  
  public final void c(String paramString, int paramInt)
  {
    ??? = this.a;
    if (??? != null)
    {
      if (((pt)???).az == null) {
        return;
      }
      synchronized (this.a.a)
      {
        paramString = this.a.c(paramString);
        if (paramString == null) {
          return;
        }
        paramString.d(paramInt);
        paramString.d();
        this.a.az.b.k();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ls
 * JD-Core Version:    0.7.0.1
 */