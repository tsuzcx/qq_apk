import android.view.ViewTreeObserver;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class awth
  implements TencentMap.OnMapLoadedCallback
{
  public awth(MapWidget paramMapWidget) {}
  
  public void onMapLoaded()
  {
    awpi localawpi = this.a.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (QLog.isColorLevel()) {
      QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. selfItem: ", localawpi.a() });
    }
    if ((localawpi.a() != null) && (!awtg.a(this.a.getContext(), this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, localawpi.a())))
    {
      this.a.a(false);
      this.a.setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. success moveMapToSelfCenter selfItem: ", localawpi.a() });
      }
    }
    for (;;)
    {
      if (MapWidget.a(this.a) != null)
      {
        if (this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition() != null) {
          break;
        }
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new awti(this));
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. failed moveMapToSelfCenter selfItem: ", localawpi.a() });
      }
    }
    MapWidget.a(this.a).a(this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().target);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awth
 * JD-Core Version:    0.7.0.1
 */