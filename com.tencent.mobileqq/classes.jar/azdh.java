import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class azdh
{
  private azcn jdField_a_of_type_Azcn = new azcn(40001);
  private azct jdField_a_of_type_Azct;
  private azdj jdField_a_of_type_Azdj;
  private azeh jdField_a_of_type_Azeh;
  private azex jdField_a_of_type_Azex;
  private String jdField_a_of_type_JavaLangString;
  
  azdh(azct paramazct)
  {
    this.jdField_a_of_type_Azct = paramazct;
    this.jdField_a_of_type_Azeh = new azeh("category", azcv.l, azcv.j, azcv.k);
  }
  
  int a()
  {
    if ((this.jdField_a_of_type_Azcn != null) && (this.jdField_a_of_type_Azcn.a("category"))) {
      this.jdField_a_of_type_Azdj = null;
    }
    if (this.jdField_a_of_type_Azcn == null) {
      return 40001;
    }
    return this.jdField_a_of_type_Azcn.a;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Azdj = null;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationCategoryDetector", 2, "[status][category] persistPoiData. status: " + paramLong + " category: " + this.jdField_a_of_type_Azdj);
    }
    if ((this.jdField_a_of_type_Azdj != null) && (azdj.a(this.jdField_a_of_type_Azdj) == paramLong)) {
      this.jdField_a_of_type_Azeh.a(this.jdField_a_of_type_Azex.a);
    }
  }
  
  public void a(azex paramazex, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationCategoryDetector", 2, "[status][category] detect: " + paramazex + " curRate: " + paramDouble);
    }
    if ((paramazex == null) || (paramDouble > azcv.a))
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Azdj = null;
      this.jdField_a_of_type_Azcn.a();
      this.jdField_a_of_type_Azex = null;
      return;
    }
    this.jdField_a_of_type_Azex = paramazex;
    try
    {
      this.jdField_a_of_type_Azeh.a(paramazex.a, new azdi(this));
      return;
    }
    catch (Throwable paramazex)
    {
      QLog.e("LocationCategoryDetector", 1, "getPoiWithLatLngError", paramazex);
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
      this.jdField_a_of_type_Azdj = null;
      this.jdField_a_of_type_Azcn.a();
      return;
    }
    label208:
    azdj localazdj;
    if (i < Math.min(paramPoiBean.poiArray.length, azcv.d))
    {
      Poi localPoi = paramPoiBean.poiArray[i];
      if (localPoi._distance > azcv.g) {
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
      Iterator localIterator = azcv.b.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localazdj = (azdj)localIterator.next();
          if (azdj.a(localazdj, (String[])localObject))
          {
            localObject = localazdj;
            if (QLog.isColorLevel()) {
              QLog.d("LocationCategoryDetector", 2, "[status][category] onFetchPoi success poi: " + this.jdField_a_of_type_JavaLangString + " category: " + localPoi.category);
            }
          }
        }
      }
    }
    for (Object localObject = localazdj;; localObject = null)
    {
      this.jdField_a_of_type_Azdj = ((azdj)localObject);
      if (this.jdField_a_of_type_Azdj == null) {
        break label208;
      }
      this.jdField_a_of_type_Azcn.a(azdj.a(this.jdField_a_of_type_Azdj));
      if (this.jdField_a_of_type_Azct != null) {
        this.jdField_a_of_type_Azct.a();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LocationCategoryDetector", 2, "[status][category] getPoiWithLatLng onResult: " + this.jdField_a_of_type_JavaLangString + " category: " + this.jdField_a_of_type_Azdj + " status: " + this.jdField_a_of_type_Azcn);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdh
 * JD-Core Version:    0.7.0.1
 */