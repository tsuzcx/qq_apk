package com.tencent.mapsdk.rastercore.tile;

import android.os.Handler;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.rastercore.tile.b.b;

public final class f
{
  private boolean a = false;
  private com.tencent.mapsdk.rastercore.e.a.f b;
  private com.tencent.mapsdk.rastercore.d.f c;
  private Handler d = new Handler();
  private a e;
  private float f = 0.0F;
  
  public f(com.tencent.mapsdk.rastercore.d.f paramf)
  {
    this.c = paramf;
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a) && (this.b != null)) {
      return;
    }
    if (paramBoolean)
    {
      TileOverlayOptions localTileOverlayOptions = new TileOverlayOptions();
      localTileOverlayOptions.tileProvider(b.a(this.c, MapTile.MapSource.TRAFFIC)).diskCacheEnabled(false).visible(true).zIndex(0.0F);
      this.b = this.c.g().a(localTileOverlayOptions);
      this.e = new a(60000);
      this.d.post(this.e);
    }
    for (;;)
    {
      this.a = paramBoolean;
      return;
      if (this.b == null) {
        break;
      }
      this.b.b();
      this.b = null;
      this.e.a(false);
      this.d.removeCallbacks(this.e);
      this.e = null;
    }
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  final class a
    implements Runnable
  {
    private boolean a = true;
    private int b = 60000;
    
    public a(int paramInt) {}
    
    public final void a(boolean paramBoolean)
    {
      this.a = false;
    }
    
    public final void run()
    {
      f.a(f.this).a(false, false);
      if (this.a) {
        f.b(f.this).postDelayed(this, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.f
 * JD-Core Version:    0.7.0.1
 */