package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.Tile;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.raster.model.TileProvider;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class a
{
  private static final Comparator<a> m = new a((byte)0);
  private final int a;
  private final int b;
  private final int c;
  private MapTile.MapSource d;
  private int e;
  private int f = 0;
  private TileProvider g;
  private Bitmap h;
  private String i;
  private boolean j = true;
  private volatile boolean k = false;
  private com.tencent.mapsdk.rastercore.e.a.f l;
  
  public a(TileProvider paramTileProvider, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, MapTile.MapSource paramMapSource)
  {
    this.g = paramTileProvider;
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramMapSource;
    this.e = paramInt5;
    this.f = paramInt4;
  }
  
  public a(com.tencent.mapsdk.rastercore.e.a.f paramf, int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = paramf.f();
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.l = paramf;
    this.i = paramf.g();
    this.j = paramf.h();
  }
  
  public static Comparator<a> k()
  {
    return m;
  }
  
  public final String a()
  {
    return this.i;
  }
  
  public final void a(Bitmap paramBitmap)
  {
    this.h = paramBitmap;
    if (paramBitmap != null) {
      this.h.setDensity(com.tencent.mapsdk.rastercore.d.f.s());
    }
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    if ((this.l != null) && (!this.l.e())) {}
    while ((this.h == null) || (this.h.isRecycled())) {
      return false;
    }
    try
    {
      paramCanvas.drawBitmap(this.h, 0.0F, 0.0F, null);
      return true;
    }
    catch (Exception paramCanvas)
    {
      if ((this.h != null) && (!this.h.isRecycled())) {
        this.h.recycle();
      }
      this.h = null;
    }
    return false;
  }
  
  public final boolean a(com.tencent.mapsdk.rastercore.e.a.f paramf)
  {
    if (this.l == null) {
      return false;
    }
    return this.l.equals(paramf);
  }
  
  public final byte[] a(boolean paramBoolean, String paramString)
  {
    try
    {
      if ((this.f != 7) || (this.d != MapTile.MapSource.TENCENT))
      {
        Tile localTile = this.g.getTile(this.a, this.b, this.c, this.d, new Object[] { Integer.valueOf(this.e), paramString, Boolean.valueOf(paramBoolean) });
        paramString = localTile;
        if (localTile != null) {
          return localTile.getData();
        }
      }
      else
      {
        paramString = this.g.getTile(this.a, this.b, this.c, this.d, new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.f) });
      }
      if (paramString != null)
      {
        paramString = paramString.getData();
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      new StringBuilder("get tile raises exception:").append(paramString.getMessage());
    }
    return null;
  }
  
  public final int b()
  {
    return this.a;
  }
  
  public final int c()
  {
    return this.b;
  }
  
  public final int d()
  {
    return this.c;
  }
  
  public final TileProvider e()
  {
    return this.g;
  }
  
  public final Bitmap f()
  {
    return this.h;
  }
  
  public final boolean g()
  {
    return this.j;
  }
  
  public final void h()
  {
    this.k = true;
    if ((this.h != null) && (!this.h.isRecycled())) {
      this.h.recycle();
    }
    this.h = null;
  }
  
  public final boolean i()
  {
    return this.k;
  }
  
  public final float j()
  {
    if (this.l != null) {
      return this.l.a();
    }
    return (1.0F / -1.0F);
  }
  
  public final int l()
  {
    return this.e;
  }
  
  public final MapTile.MapSource m()
  {
    return this.d;
  }
  
  public final int n()
  {
    return this.f;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(this.f);
    localStringBuilder.append("_");
    localStringBuilder.append(this.e);
    localStringBuilder.append("_");
    localStringBuilder.append(this.d);
    localStringBuilder.append("_");
    localStringBuilder.append(this.g.getClass().getCanonicalName());
    return localStringBuilder.toString();
  }
  
  static final class a
    implements Comparator<a>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.a
 * JD-Core Version:    0.7.0.1
 */