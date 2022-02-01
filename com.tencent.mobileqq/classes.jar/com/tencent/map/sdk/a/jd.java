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
    parampn = this.b;
    if (parampn != null)
    {
      jc.a(parampn.ay);
      parampn = new jf(this.b.ay, this);
      new jf.b(parampn, (byte)0).execute(new Context[] { parampn.a });
    }
  }
  
  public final void a()
  {
    if (this.a == null)
    {
      Object localObject1 = this.b;
      if (localObject1 != null)
      {
        if (((pt)localObject1).az == null) {
          return;
        }
        localObject1 = this.b.az;
        Object localObject2;
        if (this.c == null)
        {
          this.c = new TileOverlayOptions();
          localObject2 = new je(this.c);
          this.c.tileProvider((TileProvider)localObject2).diskCacheDir("rastermap/handdraw").zIndex(2);
        }
        ((pm)localObject1).e(19);
        this.a = ((pm)localObject1).a(this.c);
        localObject1 = this.a;
        if (localObject1 != null)
        {
          localObject2 = localObject1.getClass().getDeclaredFields();
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            localObject1 = localObject2[i];
            if (((Field)localObject1).getType() == ix.class) {
              try
              {
                ((Field)localObject1).setAccessible(true);
                localObject2 = (ix)((Field)localObject1).get(this.a);
                if ((((ix)localObject2).k != null) && (((ix)localObject2).i >= 0))
                {
                  iy localiy = ((ix)localObject2).k;
                  i = ((ix)localObject2).i;
                  if (localiy.a != null)
                  {
                    localObject2 = localiy.a;
                    if ((((pf)localObject2).b != 0L) && (((pf)localObject2).f != null)) {
                      ((pf)localObject2).f.a(new pf.25((pf)localObject2, i));
                    }
                  }
                }
                ((Field)localObject1).setAccessible(false);
                return;
              }
              catch (IllegalAccessException localIllegalAccessException)
              {
                or.b("SketchOverlayManager set data level with reflect", localIllegalAccessException);
                return;
              }
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public final void b()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (je)((TileOverlayOptions)localObject).getTileProvider();
      je.a = jc.a();
      if (((je)localObject).b != null) {
        ((je)localObject).b.versionInfo(je.a());
      }
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((TileOverlay)localObject).clearTileCache();
      this.a.reload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jd
 * JD-Core Version:    0.7.0.1
 */