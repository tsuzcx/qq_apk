import android.text.TextUtils;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.util.WeakReference;

class azdm
  implements azel
{
  azdm(azdl paramazdl, LatLng paramLatLng, int paramInt) {}
  
  public void a(PoiBean paramPoiBean)
  {
    azdn localazdn = (azdn)azdl.a(this.jdField_a_of_type_Azdl).get();
    if (localazdn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] getPoiWithLatLng error. mCallback is null ");
      }
      return;
    }
    if ((paramPoiBean == null) || (paramPoiBean.adInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] getPoiWithLatLng error. adInfo is null ");
      }
      localazdn.a(404, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.latitude, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.longitude, "", "", azdl.a(this.jdField_a_of_type_Azdl), azdl.a(this.jdField_a_of_type_Azdl));
      return;
    }
    String str1;
    if (TextUtils.isEmpty(paramPoiBean.adInfo.city))
    {
      str1 = "";
      if (!TextUtils.isEmpty(paramPoiBean.adInfo.district)) {
        break label213;
      }
    }
    label213:
    for (String str2 = "";; str2 = paramPoiBean.adInfo.district)
    {
      str1 = str1 + str2;
      localazdn.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.latitude, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng.longitude, paramPoiBean.adInfo.adcode, str1, azdl.a(this.jdField_a_of_type_Azdl), azdl.a(this.jdField_a_of_type_Azdl));
      return;
      str1 = paramPoiBean.adInfo.city;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdm
 * JD-Core Version:    0.7.0.1
 */