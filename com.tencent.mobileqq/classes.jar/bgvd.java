import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public class bgvd
  extends Handler
{
  public bgvd(AutoLocationMapView paramAutoLocationMapView) {}
  
  public void handleMessage(Message paramMessage)
  {
    GeoPoint localGeoPoint = (GeoPoint)paramMessage.obj;
    this.a.getMap().clear();
    if (paramMessage.arg1 == 0)
    {
      this.a.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D)));
      this.a.getMap().moveCamera(CameraUpdateFactory.zoomTo(this.a.getMap().getMaxZoomLevel()));
      Bitmap localBitmap = bhgm.a(this.a.getContext().getResources(), 2130842461);
      awtg.a(this.a.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(localBitmap)).snippet("").position(new LatLng(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D))));
    }
    if (this.a.a != null) {
      this.a.a.a(paramMessage.arg1, localGeoPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvd
 * JD-Core Version:    0.7.0.1
 */