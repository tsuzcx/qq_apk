import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class azkp
  implements azkr
{
  azkp(azkn paramazkn, LatLng paramLatLng, int paramInt, azkr paramazkr) {}
  
  public void a(PoiBean paramPoiBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + azkn.a(this.jdField_a_of_type_Azkn) + "] loadPoiFromDisk. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + paramPoiBean);
    }
    if (paramPoiBean != null) {
      azkn.a(this.jdField_a_of_type_Azkn).a(paramPoiBean.latLng, this.jdField_a_of_type_Int, paramPoiBean);
    }
    this.jdField_a_of_type_Azkr.a(paramPoiBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkp
 * JD-Core Version:    0.7.0.1
 */