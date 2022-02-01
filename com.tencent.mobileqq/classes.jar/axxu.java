import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject.ReverseAddressResult;
import com.tencent.map.tools.net.http.HttpResponseListener;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class axxu
  implements HttpResponseListener<BaseObject>
{
  private final axxz jdField_a_of_type_Axxz;
  private final LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  
  public axxu(axxt paramaxxt, LatLng paramLatLng, axxz paramaxxz)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
    this.jdField_a_of_type_Axxz = paramaxxz;
  }
  
  public void a(int paramInt, BaseObject paramBaseObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(axxq.a, 2, "[status][poiLoader][" + this.jdField_a_of_type_Axxt.b + "] netGet onSuccess. resultCode : " + paramInt + " result : " + paramBaseObject);
    }
    if ((paramBaseObject instanceof Geo2AddressResultObject))
    {
      paramBaseObject = (Geo2AddressResultObject)paramBaseObject;
      if ((paramBaseObject.result != null) && (paramBaseObject.result.pois != null) && (paramBaseObject.result.pois.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(axxq.a, 2, "[status][poiLoader][" + this.jdField_a_of_type_Axxt.b + "]  netGet invoked success. latLng : " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poi_size : " + paramBaseObject.result.pois.size());
        }
        Poi[] arrayOfPoi = new Poi[paramBaseObject.result.pois.size()];
        paramBaseObject = new PoiBean(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramBaseObject.result.ad_info, (Poi[])paramBaseObject.result.pois.toArray(arrayOfPoi));
        this.jdField_a_of_type_Axxt.a("netGet", paramBaseObject);
        this.jdField_a_of_type_Axxz.a(paramBaseObject);
      }
    }
  }
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    QLog.e(axxq.a, 1, paramThrowable, new Object[] { "[status][poiLoader][" + this.jdField_a_of_type_Axxt.b + "] netGet invoked fail. latLng : " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " errorCode : " + paramInt + " errorMsg : " + paramString });
    this.jdField_a_of_type_Axxz.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxu
 * JD-Core Version:    0.7.0.1
 */