package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

final class kj$2
  implements Runnable
{
  kj$2(kj paramkj, String paramString1, String paramString2, LatLng paramLatLng, String[] paramArrayOfString, int paramInt) {}
  
  public final void run()
  {
    kj localkj = this.f;
    String str1 = this.a;
    String str2 = this.b;
    LatLng localLatLng = this.c;
    String[] arrayOfString = this.d;
    int j = this.e;
    Object localObject;
    int i;
    if (localkj.d != null)
    {
      if (localkj.d.az == null) {
        return;
      }
      localObject = localkj.d.az;
      int k = ((pm)localObject).c;
      i = 0;
      if ((str1 != null) && (arrayOfString != null) && (arrayOfString.length > 0) && (j >= 0) && (k >= 16))
      {
        if ((localkj.e != null) && (!localkj.h))
        {
          localkj.h = true;
          if ((localkj.d != null) && (localkj.d.n != null)) {
            localkj.d.n.a(true);
          }
          localkj.e.onIndoorBuildingFocused();
        }
        ((pm)localObject).e(Math.min(localkj.d.g, 22));
        if (localkj.e != null)
        {
          localObject = new ArrayList();
          k = arrayOfString.length;
          while (i < k)
          {
            ((List)localObject).add(new IndoorLevel(arrayOfString[i]));
            i += 1;
          }
        }
      }
    }
    try
    {
      if ((localkj.i != null) && (localkj.i.getBuidlingId().equals(str1)))
      {
        i = localkj.i.getActiveLevelIndex();
        if (i == j) {
          return;
        }
      }
    }
    catch (Exception localException)
    {
      label272:
      break label272;
    }
    localkj.i = new IndoorBuilding(str1, str2, localLatLng, (List)localObject, j);
    if ((localkj.d != null) && (localkj.d.n != null) && (localkj.d.n.b) && (localkj.d.az.c() >= 16)) {
      localkj.d.n.a(localkj.i);
    }
    localkj.e.onIndoorLevelActivated(localkj.i);
    return;
    localkj.c();
    if (localkj.h)
    {
      localkj.h = false;
      localkj.i = null;
      if ((localkj.d != null) && (localkj.d.n != null)) {
        localkj.d.n.a(false);
      }
      if (localkj.e != null) {
        localkj.e.onIndoorBuildingDeactivated();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.kj.2
 * JD-Core Version:    0.7.0.1
 */