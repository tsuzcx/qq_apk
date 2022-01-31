package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.Tile;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.e.a.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class a
{
  private static final Comparator<a> l = new a((byte)0);
  private final int a;
  private final int b;
  private final int c;
  private MapTile.MapSource d;
  private final int e;
  private final int f;
  private TileProvider g;
  private Bitmap h;
  private String i;
  private volatile boolean j = false;
  private f k;
  
  public a(TileProvider paramTileProvider, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, MapTile.MapSource paramMapSource, String paramString)
  {
    this.g = paramTileProvider;
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.e = paramInt4;
    this.i = paramString;
    this.d = paramMapSource;
    this.f = paramInt5;
  }
  
  public a(f paramf, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramf.f(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MapTile.MapSource.CUSTOMER, paramf.g());
    this.k = paramf;
    paramf.h();
  }
  
  public static Comparator<a> k()
  {
    return l;
  }
  
  public final String a()
  {
    return this.i;
  }
  
  public final void a(Bitmap paramBitmap)
  {
    this.h = paramBitmap;
    if (paramBitmap != null) {
      this.h.setDensity(e.B());
    }
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    if ((this.k != null) && (!this.k.e())) {}
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
  
  public final boolean a(f paramf)
  {
    if (this.k == null) {
      return false;
    }
    return this.k.equals(paramf);
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
  
  public final byte[] g()
  {
    try
    {
      Object localObject = this.g.getTile(this.a, this.b, this.c, this.d, new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.f) });
      if (localObject != null)
      {
        localObject = ((Tile)localObject).getData();
        return localObject;
      }
      return null;
    }
    catch (Exception localException)
    {
      new StringBuilder("get tile raises exception:").append(localException.getMessage());
    }
    return null;
  }
  
  public final void h()
  {
    this.j = true;
    if ((this.h != null) && (!this.h.isRecycled())) {
      this.h.recycle();
    }
    this.h = null;
  }
  
  public final boolean i()
  {
    return this.j;
  }
  
  public final float j()
  {
    if (this.k != null) {
      return this.k.a();
    }
    return (1.0F / -1.0F);
  }
  
  public final int l()
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