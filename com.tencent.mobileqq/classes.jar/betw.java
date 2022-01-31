import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class betw
  implements TencentMap.OnCameraChangeListener
{
  public betw(QQMapView paramQQMapView) {}
  
  public void onCameraChange(CameraPosition paramCameraPosition)
  {
    if ((this.a.jdField_a_of_type_Betx != null) && (!this.a.jdField_a_of_type_Boolean))
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_a_of_type_Betx.onMapScrollStart(new GeoPoint((int)(paramCameraPosition.target.getLatitude() * 1000000.0D), (int)(paramCameraPosition.target.getLongitude() * 1000000.0D)));
    }
  }
  
  public void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    if (this.a.jdField_a_of_type_Boolean) {
      QQMapView.a(this.a, paramCameraPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betw
 * JD-Core Version:    0.7.0.1
 */