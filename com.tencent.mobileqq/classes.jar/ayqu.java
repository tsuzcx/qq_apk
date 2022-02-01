import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ayqu
{
  private ayqa jdField_a_of_type_Ayqa = new ayqa(40001);
  private ayqg jdField_a_of_type_Ayqg;
  private ayqw jdField_a_of_type_Ayqw;
  private ayru jdField_a_of_type_Ayru;
  private aysk jdField_a_of_type_Aysk;
  private String jdField_a_of_type_JavaLangString;
  
  ayqu(ayqg paramayqg)
  {
    this.jdField_a_of_type_Ayqg = paramayqg;
    this.jdField_a_of_type_Ayru = new ayru("category", ayqi.l, ayqi.j, ayqi.k);
  }
  
  int a()
  {
    if (this.jdField_a_of_type_Ayqa.a("category")) {
      this.jdField_a_of_type_Ayqw = null;
    }
    if (this.jdField_a_of_type_Ayqa == null) {
      return 40001;
    }
    return this.jdField_a_of_type_Ayqa.a;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ayqw = null;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationCategoryDetector", 2, "[status][category] persistPoiData. status: " + paramLong + " category: " + this.jdField_a_of_type_Ayqw);
    }
    if ((this.jdField_a_of_type_Ayqw != null) && (ayqw.a(this.jdField_a_of_type_Ayqw) == paramLong)) {
      this.jdField_a_of_type_Ayru.a(this.jdField_a_of_type_Aysk.a);
    }
  }
  
  public void a(aysk paramaysk, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationCategoryDetector", 2, "[status][category] detect: " + paramaysk + " curRate: " + paramDouble);
    }
    if ((paramaysk == null) || (paramDouble > ayqi.a))
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Ayqw = null;
      this.jdField_a_of_type_Ayqa.a();
      this.jdField_a_of_type_Aysk = null;
      return;
    }
    this.jdField_a_of_type_Aysk = paramaysk;
    try
    {
      this.jdField_a_of_type_Ayru.a(paramaysk.a, new ayqv(this));
      return;
    }
    catch (Throwable paramaysk)
    {
      QLog.e("LocationCategoryDetector", 1, "getPoiWithLatLngError", paramaysk);
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
      this.jdField_a_of_type_Ayqw = null;
      this.jdField_a_of_type_Ayqa.a();
      return;
    }
    label208:
    ayqw localayqw;
    if (i < Math.min(paramPoiBean.poiArray.length, ayqi.d))
    {
      Poi localPoi = paramPoiBean.poiArray[i];
      if (localPoi._distance > ayqi.g) {
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
      Iterator localIterator = ayqi.b.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localayqw = (ayqw)localIterator.next();
          if (ayqw.a(localayqw, (String[])localObject))
          {
            localObject = localayqw;
            if (QLog.isColorLevel()) {
              QLog.d("LocationCategoryDetector", 2, "[status][category] onFetchPoi success poi: " + this.jdField_a_of_type_JavaLangString + " category: " + localPoi.category);
            }
          }
        }
      }
    }
    for (Object localObject = localayqw;; localObject = null)
    {
      this.jdField_a_of_type_Ayqw = ((ayqw)localObject);
      if (this.jdField_a_of_type_Ayqw == null) {
        break label208;
      }
      this.jdField_a_of_type_Ayqa.a(ayqw.a(this.jdField_a_of_type_Ayqw));
      if (this.jdField_a_of_type_Ayqg != null) {
        this.jdField_a_of_type_Ayqg.a();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LocationCategoryDetector", 2, "[status][category] getPoiWithLatLng onResult: " + this.jdField_a_of_type_JavaLangString + " category: " + this.jdField_a_of_type_Ayqw + " status: " + this.jdField_a_of_type_Ayqa);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqu
 * JD-Core Version:    0.7.0.1
 */