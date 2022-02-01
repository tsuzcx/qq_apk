import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.Set;

public class ayrq
  extends ayrp
{
  private LRULinkedHashMap<LatLng, PoiBean> a;
  
  ayrq(String paramString, int paramInt)
  {
    super(paramString);
    jdField_a_of_type_JavaLangString = "MemoryLoader";
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(paramInt);
  }
  
  public void a(LatLng paramLatLng, int paramInt, PoiBean paramPoiBean)
  {
    if (a(paramLatLng, paramInt, new ayrr(this, paramLatLng, paramInt, paramPoiBean)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] memPut [fail already exist]. latLng: " + paramLatLng + " acceptAccuracy: " + paramInt + " poiBean: " + paramPoiBean);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] memPut poiBean: " + paramPoiBean);
    }
    a("memPut", paramPoiBean);
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramPoiBean.latLng, paramPoiBean);
  }
  
  public boolean a(LatLng paramLatLng, int paramInt, ayry paramayry)
  {
    Object localObject = this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.keySet().iterator();
    LatLng localLatLng;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localLatLng = (LatLng)((Iterator)localObject).next();
    } while (!a(localLatLng, paramLatLng, paramInt));
    for (localObject = (PoiBean)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(localLatLng);; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[status][poiLoader][" + this.b + "] memGet latLng: " + paramLatLng + " result: " + localObject);
      }
      a("memGet", (PoiBean)localObject);
      if (localObject != null) {
        paramayry.a((PoiBean)localObject);
      }
      return localObject != null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrq
 * JD-Core Version:    0.7.0.1
 */