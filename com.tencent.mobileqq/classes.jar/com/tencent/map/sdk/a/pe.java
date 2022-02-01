package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;

public final class pe
  extends Handler
{
  private final pn a;
  
  public pe(pn parampn)
  {
    this.a = parampn;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((pn)localObject1).f();
    if (localObject1 == null) {
      return;
    }
    if (this.a.w)
    {
      if (paramMessage.what == 0)
      {
        paramMessage = this.a;
        paramMessage.ag = false;
        paramMessage.ah = true;
        paramMessage.onCameraChange((CameraPosition)localObject1);
      }
      else if (paramMessage.what == 1)
      {
        paramMessage = this.a;
        paramMessage.ag = true;
        if ((paramMessage.ag) && (this.a.ai == 0))
        {
          paramMessage = this.a;
          paramMessage.ah = false;
          paramMessage.onCameraChangeFinished((CameraPosition)localObject1);
        }
        if ((this.a.p != null) && (this.a.aa)) {
          this.a.p.onMapStable();
        }
        paramMessage = this.a.az.b;
        if ((paramMessage.v != null) && (paramMessage.v.a())) {
          paramMessage.v.b();
        }
      }
    }
    else if (paramMessage.what == 2)
    {
      if (this.a.x != null) {
        this.a.x.onMapLoaded();
      }
      this.a.w = true;
    }
    if (this.a.k != null)
    {
      paramMessage = this.a.k;
      if ((paramMessage.a != null) && (paramMessage.a.az != null)) {
        if (paramMessage.a.az.c() < 7)
        {
          paramMessage.b();
        }
        else if (!jx.d())
        {
          if (paramMessage.b != null) {
            paramMessage.b();
          }
        }
        else
        {
          jv.a();
          localObject1 = jv.d("china");
          if (paramMessage.a == null) {}
          Object localObject2;
          do
          {
            bool = true;
            break;
            localObject2 = paramMessage.a.q();
          } while ((localObject2 == null) || (localObject1 == null));
          boolean bool = jv.a((fw[])localObject2, (fw[])localObject1);
          if (bool)
          {
            if (paramMessage.b != null) {
              paramMessage.b();
            }
          }
          else if ((paramMessage.b == null) && (paramMessage.b == null) && (paramMessage.a != null) && (paramMessage.a.az != null) && (paramMessage.a.az.b != null))
          {
            localObject1 = paramMessage.a.az.b;
            ((lw)localObject1).d(false);
            ((lw)localObject1).e(false);
            if (paramMessage.c == null)
            {
              paramMessage.c = new TileOverlayOptions();
              localObject2 = new ka(paramMessage.c, paramMessage.d, paramMessage.a.aF);
              paramMessage.c.tileProvider((TileProvider)localObject2).betterQuality(false).zIndex(1).diskCacheDir("rastermap/world");
            }
            paramMessage.b = ((lw)localObject1).D.a(paramMessage.c);
          }
        }
      }
    }
    if (this.a.m != null) {
      this.a.m.a(this.a.p(), this.a.az.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pe
 * JD-Core Version:    0.7.0.1
 */