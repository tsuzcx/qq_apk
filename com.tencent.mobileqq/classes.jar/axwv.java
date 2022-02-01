import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class axwv
{
  private axwb jdField_a_of_type_Axwb = new axwb(40001);
  private axwh jdField_a_of_type_Axwh;
  private axwx jdField_a_of_type_Axwx;
  private axxv jdField_a_of_type_Axxv;
  private axyl jdField_a_of_type_Axyl;
  private String jdField_a_of_type_JavaLangString;
  
  axwv(axwh paramaxwh)
  {
    this.jdField_a_of_type_Axwh = paramaxwh;
    this.jdField_a_of_type_Axxv = new axxv("category", axwj.l, axwj.j, axwj.k);
  }
  
  int a()
  {
    if ((this.jdField_a_of_type_Axwb != null) && (this.jdField_a_of_type_Axwb.a("category"))) {
      this.jdField_a_of_type_Axwx = null;
    }
    if (this.jdField_a_of_type_Axwb == null) {
      return 40001;
    }
    return this.jdField_a_of_type_Axwb.a;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Axwx = null;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationCategoryDetector", 2, "[status][category] persistPoiData. status: " + paramLong + " category: " + this.jdField_a_of_type_Axwx);
    }
    if ((this.jdField_a_of_type_Axwx != null) && (axwx.a(this.jdField_a_of_type_Axwx) == paramLong)) {
      this.jdField_a_of_type_Axxv.a(this.jdField_a_of_type_Axyl.a);
    }
  }
  
  public void a(axyl paramaxyl, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationCategoryDetector", 2, "[status][category] detect: " + paramaxyl + " curRate: " + paramDouble);
    }
    if ((paramaxyl == null) || (paramDouble > axwj.a))
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Axwx = null;
      this.jdField_a_of_type_Axwb.a();
      this.jdField_a_of_type_Axyl = null;
      return;
    }
    this.jdField_a_of_type_Axyl = paramaxyl;
    try
    {
      this.jdField_a_of_type_Axxv.a(paramaxyl.a, new axww(this));
      return;
    }
    catch (Throwable paramaxyl)
    {
      QLog.e("LocationCategoryDetector", 1, "getPoiWithLatLngError", paramaxyl);
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
      this.jdField_a_of_type_Axwx = null;
      this.jdField_a_of_type_Axwb.a();
      return;
    }
    label208:
    axwx localaxwx;
    if (i < Math.min(paramPoiBean.poiArray.length, axwj.d))
    {
      Poi localPoi = paramPoiBean.poiArray[i];
      if (localPoi._distance > axwj.g) {
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
      Iterator localIterator = axwj.b.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localaxwx = (axwx)localIterator.next();
          if (axwx.a(localaxwx, (String[])localObject))
          {
            localObject = localaxwx;
            if (QLog.isColorLevel()) {
              QLog.d("LocationCategoryDetector", 2, "[status][category] onFetchPoi success poi: " + this.jdField_a_of_type_JavaLangString + " category: " + localPoi.category);
            }
          }
        }
      }
    }
    for (Object localObject = localaxwx;; localObject = null)
    {
      this.jdField_a_of_type_Axwx = ((axwx)localObject);
      if (this.jdField_a_of_type_Axwx == null) {
        break label208;
      }
      this.jdField_a_of_type_Axwb.a(axwx.a(this.jdField_a_of_type_Axwx));
      if (this.jdField_a_of_type_Axwh != null) {
        this.jdField_a_of_type_Axwh.a();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LocationCategoryDetector", 2, "[status][category] getPoiWithLatLng onResult: " + this.jdField_a_of_type_JavaLangString + " category: " + this.jdField_a_of_type_Axwx + " status: " + this.jdField_a_of_type_Axwb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwv
 * JD-Core Version:    0.7.0.1
 */