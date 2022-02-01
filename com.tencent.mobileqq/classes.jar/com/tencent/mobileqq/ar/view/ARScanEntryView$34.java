package com.tencent.mobileqq.ar.view;

import android.content.Context;
import android.graphics.Point;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

class ARScanEntryView$34
  implements TencentMap.OnMapLoadedCallback
{
  ARScanEntryView$34(ARScanEntryView paramARScanEntryView) {}
  
  public void onMapLoaded()
  {
    Object localObject = this.a;
    ((ARScanEntryView)localObject).o = true;
    if (ARScanEntryView.x((ARScanEntryView)localObject) != null)
    {
      localObject = ARScanEntryView.x(this.a).getMap().getProjection();
      TencentMap localTencentMap = ARScanEntryView.x(this.a).getMap();
      if ((localObject != null) && (localTencentMap != null))
      {
        Point localPoint = ((Projection)localObject).toScreenLocation(localTencentMap.getCameraPosition().target);
        if (localPoint != null)
        {
          localPoint.offset(0, AIOUtils.b(60.0F, this.a.E.getResources()) * -1);
          localTencentMap.moveCamera(CameraUpdateFactory.newLatLng(((Projection)localObject).fromScreenLocation(localPoint)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.34
 * JD-Core Version:    0.7.0.1
 */