package com.tencent.mapsdk.rastercore.e.a;

import android.content.Context;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.a.1;
import com.tencent.mapsdk.rastercore.tile.a.a;
import java.io.File;

public final class f
{
  private static int h = 0;
  private e a;
  private final String b;
  private boolean c = true;
  private float d = (1.0F / -1.0F);
  private boolean e = true;
  private TileProvider f;
  private String g;
  
  public f(e parame, TileOverlayOptions paramTileOverlayOptions)
  {
    StringBuilder localStringBuilder = new StringBuilder("TileOverlay_");
    int i = h;
    h = i + 1;
    this.b = i;
    this.a = parame;
    this.g = (e.a().getPackageName() + File.separator + this.b);
    this.e = paramTileOverlayOptions.getDiskCacheEnabled();
    this.f = paramTileOverlayOptions.getTileProvider();
    this.d = paramTileOverlayOptions.getZIndex();
    this.c = paramTileOverlayOptions.isVisible();
  }
  
  public static void c()
  {
    a.a().b();
  }
  
  public final float a()
  {
    return this.d;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    this.a.a(false, false);
  }
  
  public final void b()
  {
    this.a.g().a(this);
  }
  
  public final String d()
  {
    return this.b;
  }
  
  public final boolean e()
  {
    return this.c;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        bool1 = bool2;
        if (this.b.equals(paramObject.b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final TileProvider f()
  {
    return this.f;
  }
  
  public final String g()
  {
    return this.g;
  }
  
  public final boolean h()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.e.a.f
 * JD-Core Version:    0.7.0.1
 */