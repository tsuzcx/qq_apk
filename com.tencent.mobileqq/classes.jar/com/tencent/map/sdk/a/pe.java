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
    if (this.a == null) {}
    label304:
    label562:
    for (;;)
    {
      return;
      Object localObject1 = this.a.f();
      if (localObject1 != null)
      {
        if (this.a.w) {
          if (paramMessage.what == 0)
          {
            this.a.ag = false;
            this.a.ah = true;
            this.a.onCameraChange((CameraPosition)localObject1);
            if (this.a.k != null)
            {
              paramMessage = this.a.k;
              if ((paramMessage.a != null) && (paramMessage.a.az != null)) {
                break label304;
              }
            }
          }
        }
        for (;;)
        {
          if (this.a.m == null) {
            break label562;
          }
          this.a.m.a(this.a.p(), this.a.az.a());
          return;
          if (paramMessage.what != 1) {
            break;
          }
          this.a.ag = true;
          if ((this.a.ag) && (this.a.ai == 0))
          {
            this.a.ah = false;
            this.a.onCameraChangeFinished((CameraPosition)localObject1);
          }
          if ((this.a.p != null) && (this.a.aa)) {
            this.a.p.onMapStable();
          }
          paramMessage = this.a.az.b;
          if ((paramMessage.v == null) || (!paramMessage.v.a())) {
            break;
          }
          paramMessage.v.b();
          break;
          if (paramMessage.what != 2) {
            break;
          }
          if (this.a.x != null) {
            this.a.x.onMapLoaded();
          }
          this.a.w = true;
          break;
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
            boolean bool;
            if (paramMessage.a == null) {
              bool = true;
            }
            Object localObject2;
            for (;;)
            {
              if (!bool) {
                break label416;
              }
              if (paramMessage.b == null) {
                break;
              }
              paramMessage.b();
              break;
              localObject2 = paramMessage.a.q();
              if ((localObject2 == null) || (localObject1 == null)) {
                bool = true;
              } else {
                bool = jv.a((fw[])localObject2, (fw[])localObject1);
              }
            }
            if ((paramMessage.b == null) && (paramMessage.b == null) && (paramMessage.a != null) && (paramMessage.a.az != null) && (paramMessage.a.az.b != null))
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pe
 * JD-Core Version:    0.7.0.1
 */