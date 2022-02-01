import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class axxx
  implements axxz
{
  axxx(axxv paramaxxv, LatLng paramLatLng, int paramInt, axxz paramaxxz) {}
  
  public void a(PoiBean paramPoiBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiLoader", 2, "[status][poiLoader][" + axxv.a(this.jdField_a_of_type_Axxv) + "] loadPoiFromDisk. latLng: " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poiBean: " + paramPoiBean);
    }
    if (paramPoiBean != null) {
      axxv.a(this.jdField_a_of_type_Axxv).a(paramPoiBean.latLng, this.jdField_a_of_type_Int, paramPoiBean);
    }
    this.jdField_a_of_type_Axxz.a(paramPoiBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxx
 * JD-Core Version:    0.7.0.1
 */