import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class biar
  implements TencentMap.OnCameraChangeListener
{
  public biar(QQMapView paramQQMapView) {}
  
  public void onCameraChange(CameraPosition paramCameraPosition)
  {
    if ((this.a.jdField_a_of_type_Biat != null) && (!this.a.jdField_a_of_type_Boolean))
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_a_of_type_Biat.onMapScrollStart(new GeoPoint((int)(paramCameraPosition.target.getLatitude() * 1000000.0D), (int)(paramCameraPosition.target.getLongitude() * 1000000.0D)));
    }
  }
  
  public void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    if (this.a.jdField_a_of_type_Boolean) {
      QQMapView.a(this.a, paramCameraPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biar
 * JD-Core Version:    0.7.0.1
 */