import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class azjn
{
  private azit jdField_a_of_type_Azit = new azit(40001);
  private aziz jdField_a_of_type_Aziz;
  private azjp jdField_a_of_type_Azjp;
  private azkn jdField_a_of_type_Azkn;
  private azld jdField_a_of_type_Azld;
  private String jdField_a_of_type_JavaLangString;
  
  azjn(aziz paramaziz)
  {
    this.jdField_a_of_type_Aziz = paramaziz;
    this.jdField_a_of_type_Azkn = new azkn("category", azjb.l, azjb.j, azjb.k);
  }
  
  int a()
  {
    if (this.jdField_a_of_type_Azit.a("category")) {
      this.jdField_a_of_type_Azjp = null;
    }
    if (this.jdField_a_of_type_Azit == null) {
      return 40001;
    }
    return this.jdField_a_of_type_Azit.a;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Azjp = null;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationCategoryDetector", 2, "[status][category] persistPoiData. status: " + paramLong + " category: " + this.jdField_a_of_type_Azjp);
    }
    if ((this.jdField_a_of_type_Azjp != null) && (azjp.a(this.jdField_a_of_type_Azjp) == paramLong)) {
      this.jdField_a_of_type_Azkn.a(this.jdField_a_of_type_Azld.a);
    }
  }
  
  public void a(azld paramazld, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationCategoryDetector", 2, "[status][category] detect: " + paramazld + " curRate: " + paramDouble);
    }
    if ((paramazld == null) || (paramDouble > azjb.a))
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Azjp = null;
      this.jdField_a_of_type_Azit.a();
      this.jdField_a_of_type_Azld = null;
      return;
    }
    this.jdField_a_of_type_Azld = paramazld;
    try
    {
      this.jdField_a_of_type_Azkn.a(paramazld.a, new azjo(this));
      return;
    }
    catch (Throwable paramazld)
    {
      QLog.e("LocationCategoryDetector", 1, "getPoiWithLatLngError", paramazld);
    }
  }
  
  void a(PoiBean paramPoiBean)
  {
    int j = 0;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("[status][category] getPoiWithLatLng onResult poi_size: ");
      if ((paramPoiBean != null) && (paramPoiBean.poiArray != null)) {
        break label89;
      }
    }
    label89:
    for (int i = 0;; i = paramPoiBean.poiArray.length)
    {
      QLog.d("LocationCategoryDetector", 2, i);
      if ((paramPoiBean != null) && (paramPoiBean.poiArray != null))
      {
        i = j;
        if (paramPoiBean.poiArray.length > 0) {
          break;
        }
      }
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Azjp = null;
      this.jdField_a_of_type_Azit.a();
      return;
    }
    label208:
    azjp localazjp;
    if (i < Math.min(paramPoiBean.poiArray.length, azjb.d))
    {
      Poi localPoi = paramPoiBean.poiArray[i];
      if (localPoi._distance > azjb.g) {
        if (QLog.isColorLevel()) {
          QLog.d("LocationCategoryDetector", 2, "[status][category] onFetchPoi fail far poi: " + localPoi.title + "-" + localPoi.category + "-" + localPoi._distance + " category: " + localPoi.category);
        }
      }
      do
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaLangString = (localPoi.title + "-" + localPoi.category + "-" + localPoi._distance);
        if (QLog.isColorLevel()) {
          QLog.d("LocationCategoryDetector", 2, "[status][category] onFetchPoi poi: " + this.jdField_a_of_type_JavaLangString + " category: " + localPoi.category);
        }
      } while (localPoi.category == null);
      localObject = localPoi.category.split(":");
      Iterator localIterator = azjb.b.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localazjp = (azjp)localIterator.next();
          if (azjp.a(localazjp, (String[])localObject))
          {
            localObject = localazjp;
            if (QLog.isColorLevel()) {
              QLog.d("LocationCategoryDetector", 2, "[status][category] onFetchPoi success poi: " + this.jdField_a_of_type_JavaLangString + " category: " + localPoi.category);
            }
          }
        }
      }
    }
    for (Object localObject = localazjp;; localObject = null)
    {
      this.jdField_a_of_type_Azjp = ((azjp)localObject);
      if (this.jdField_a_of_type_Azjp == null) {
        break label208;
      }
      this.jdField_a_of_type_Azit.a(azjp.a(this.jdField_a_of_type_Azjp));
      if (this.jdField_a_of_type_Aziz != null) {
        this.jdField_a_of_type_Aziz.a();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LocationCategoryDetector", 2, "[status][category] getPoiWithLatLng onResult: " + this.jdField_a_of_type_JavaLangString + " category: " + this.jdField_a_of_type_Azjp + " status: " + this.jdField_a_of_type_Azit);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjn
 * JD-Core Version:    0.7.0.1
 */