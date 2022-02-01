import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class azej
  implements azel
{
  azej(azeh paramazeh, LatLng paramLatLng, int paramInt, azel paramazel) {}
  
  public void a(PoiBean paramPoiBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + azeh.a(this.jdField_a_of_type_Azeh) + "] loadPoiFromDisk. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + paramPoiBean);
    }
    if (paramPoiBean != null) {
      azeh.a(this.jdField_a_of_type_Azeh).a(paramPoiBean.latLng, this.jdField_a_of_type_Int, paramPoiBean);
    }
    this.jdField_a_of_type_Azel.a(paramPoiBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azej
 * JD-Core Version:    0.7.0.1
 */