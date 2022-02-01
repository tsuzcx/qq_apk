package com.tencent.map.sdk.a;

import com.tencent.tencentmap.io.QStorageManager;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.io.File;

public final class jz
{
  public pn a = null;
  public TileOverlay b = null;
  public TileOverlayOptions c;
  public Language d = Language.zh;
  public volatile boolean e = false;
  
  public jz(pn parampn)
  {
    this.a = parampn;
    parampn = new StringBuilder();
    parampn.append(QStorageManager.getStorageRootPath(this.a.ay));
    parampn.append("/tencentmapsdk/rastermap/unmainland");
    on.c(parampn.toString());
    parampn = new StringBuilder();
    parampn.append(QStorageManager.getInstance(this.a.ay).getDataDir().getPath());
    parampn.append("/rastermap/taiwan");
    on.c(parampn.toString());
  }
  
  public final void a()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((ka)((TileOverlayOptions)localObject).getTileProvider()).a();
    }
    localObject = this.b;
    if (localObject != null) {
      ((TileOverlay)localObject).reload();
    }
  }
  
  public final void b()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((pt)localObject).az != null) && (this.a.az.b != null))
    {
      if (this.b == null) {
        return;
      }
      localObject = this.a.az;
      lw locallw = ((pm)localObject).b;
      locallw.d(((pm)localObject).e);
      locallw.e(true);
      this.b.remove();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.jz
 * JD-Core Version:    0.7.0.1
 */