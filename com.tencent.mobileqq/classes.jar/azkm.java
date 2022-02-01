import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject.ReverseAddressResult;
import com.tencent.map.tools.net.http.HttpResponseListener;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class azkm
  implements HttpResponseListener<BaseObject>
{
  private final azkr jdField_a_of_type_Azkr;
  private final LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  
  public azkm(azkl paramazkl, LatLng paramLatLng, azkr paramazkr)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
    this.jdField_a_of_type_Azkr = paramazkr;
  }
  
  public void a(int paramInt, BaseObject paramBaseObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(azki.a, 2, "[status][poiLoader][" + this.jdField_a_of_type_Azkl.b + "] netGet onSuccess. resultCode : " + paramInt + " result : " + paramBaseObject);
    }
    if ((paramBaseObject instanceof Geo2AddressResultObject))
    {
      paramBaseObject = (Geo2AddressResultObject)paramBaseObject;
      if ((paramBaseObject.result != null) && (paramBaseObject.result.pois != null) && (paramBaseObject.result.pois.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(azki.a, 2, "[status][poiLoader][" + this.jdField_a_of_type_Azkl.b + "]  netGet invoked success. latLng : " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " poi_size : " + paramBaseObject.result.pois.size());
        }
        Poi[] arrayOfPoi = new Poi[paramBaseObject.result.pois.size()];
        paramBaseObject = new PoiBean(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramBaseObject.result.ad_info, (Poi[])paramBaseObject.result.pois.toArray(arrayOfPoi));
        this.jdField_a_of_type_Azkl.a("netGet", paramBaseObject);
        this.jdField_a_of_type_Azkr.a(paramBaseObject);
      }
    }
  }
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    QLog.e(azki.a, 1, paramThrowable, new Object[] { "[status][poiLoader][" + this.jdField_a_of_type_Azkl.b + "] netGet invoked fail. latLng : " + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + " errorCode : " + paramInt + " errorMsg : " + paramString });
    this.jdField_a_of_type_Azkr.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkm
 * JD-Core Version:    0.7.0.1
 */