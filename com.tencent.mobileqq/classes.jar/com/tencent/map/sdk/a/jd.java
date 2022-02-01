package com.tencent.map.sdk.a;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.lang.reflect.Field;

public final class jd
  implements jf.a
{
  public TileOverlay a = null;
  private pn b = null;
  private TileOverlayOptions c;
  
  public jd(pn parampn)
  {
    this.b = parampn;
    if (this.b != null)
    {
      jc.a(this.b.ay);
      parampn = new jf(this.b.ay, this);
      new jf.b(parampn, (byte)0).execute(new Context[] { parampn.a });
    }
  }
  
  public final void a()
  {
    int i = 0;
    if ((this.a != null) || (this.b == null) || (this.b.az == null)) {}
    for (;;)
    {
      return;
      pm localpm = this.b.az;
      Object localObject;
      if (this.c == null)
      {
        this.c = new TileOverlayOptions();
        localObject = new je(this.c);
        this.c.tileProvider((TileProvider)localObject).diskCacheDir("rastermap/handdraw").zIndex(2);
      }
      localpm.e(19);
      this.a = localpm.a(this.c);
      if (this.a != null)
      {
        localObject = this.a.getClass().getDeclaredFields();
        int j = localObject.length;
        while (i < j)
        {
          localpm = localObject[i];
          if (localpm.getType() == ix.class) {
            for (;;)
            {
              try
              {
                localpm.setAccessible(true);
                localObject = (ix)localpm.get(this.a);
                if ((((ix)localObject).k == null) || (((ix)localObject).i < 0))
                {
                  localpm.setAccessible(false);
                  return;
                }
              }
              catch (IllegalAccessException localIllegalAccessException)
              {
                or.b("SketchOverlayManager set data level with reflect", localIllegalAccessException);
                return;
              }
              iy localiy = ((ix)localObject).k;
              i = ((ix)localObject).i;
              if (localiy.a != null)
              {
                localObject = localiy.a;
                if ((((pf)localObject).b != 0L) && (((pf)localObject).f != null)) {
                  ((pf)localObject).f.a(new pf.25((pf)localObject, i));
                }
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public final void b()
  {
    if (this.c != null)
    {
      je localje = (je)this.c.getTileProvider();
      je.a = jc.a();
      if (localje.b != null) {
        localje.b.versionInfo(je.a());
      }
    }
    if (this.a != null)
    {
      this.a.clearTileCache();
      this.a.reload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jd
 * JD-Core Version:    0.7.0.1
 */