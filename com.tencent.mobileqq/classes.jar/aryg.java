import android.view.ViewTreeObserver;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class aryg
  implements TencentMap.OnMapLoadedCallback
{
  public aryg(MapWidget paramMapWidget) {}
  
  public void onMapLoaded()
  {
    aruk localaruk = this.a.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (QLog.isColorLevel()) {
      QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. selfItem: ", localaruk.a() });
    }
    if ((localaruk.a() != null) && (!aryf.a(this.a.getContext(), this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, localaruk.a())))
    {
      this.a.a(false);
      this.a.setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. success moveMapToSelfCenter selfItem: ", localaruk.a() });
      }
    }
    for (;;)
    {
      if (MapWidget.a(this.a) != null)
      {
        if (this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition() != null) {
          break;
        }
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new aryh(this));
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. failed moveMapToSelfCenter selfItem: ", localaruk.a() });
      }
    }
    MapWidget.a(this.a).a(this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().target);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aryg
 * JD-Core Version:    0.7.0.1
 */