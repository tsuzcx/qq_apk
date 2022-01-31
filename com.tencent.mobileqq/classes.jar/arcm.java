import android.view.ViewTreeObserver;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class arcm
  implements TencentMap.OnMapLoadedCallback
{
  public arcm(MapWidget paramMapWidget) {}
  
  public void onMapLoaded()
  {
    aqyu localaqyu = this.a.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (QLog.isColorLevel()) {
      QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. selfItem: ", localaqyu.a() });
    }
    if ((localaqyu.a() != null) && (!arcl.a(this.a.getContext(), this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, localaqyu.a()))) {
      this.a.a(false);
    }
    if (MapWidget.a(this.a) != null)
    {
      if (this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition() == null) {
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new arcn(this));
      }
    }
    else {
      return;
    }
    MapWidget.a(this.a).a(this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().target);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arcm
 * JD-Core Version:    0.7.0.1
 */