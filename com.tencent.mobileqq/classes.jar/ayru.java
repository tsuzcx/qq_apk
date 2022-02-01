import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.1;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

public class ayru
{
  private int jdField_a_of_type_Int;
  private ayrn jdField_a_of_type_Ayrn;
  private ayrq jdField_a_of_type_Ayrq;
  private ayrs jdField_a_of_type_Ayrs;
  private final String jdField_a_of_type_JavaLangString;
  
  public ayru(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ayrs = new ayrs(paramString);
    this.jdField_a_of_type_Ayrn = new ayrn(paramString, paramInt3);
    this.jdField_a_of_type_Ayrq = new ayrq(paramString, Math.max(this.jdField_a_of_type_Ayrn.a() + paramInt2, 10));
  }
  
  private void a(LatLng paramLatLng, int paramInt, ayry paramayry)
  {
    this.jdField_a_of_type_Ayrs.a(paramLatLng, paramInt, new ayrx(this, paramLatLng, paramInt, paramayry));
  }
  
  private boolean a(LatLng paramLatLng, int paramInt, ayry paramayry)
  {
    return this.jdField_a_of_type_Ayrq.a(paramLatLng, paramInt, paramayry);
  }
  
  private boolean b(LatLng paramLatLng, int paramInt, ayry paramayry)
  {
    return this.jdField_a_of_type_Ayrn.a(paramLatLng, paramInt, new ayrw(this, paramLatLng, paramInt, paramayry));
  }
  
  public void a(LatLng paramLatLng)
  {
    a(paramLatLng, new ayrv(this, paramLatLng));
  }
  
  public void a(LatLng paramLatLng, ayry paramayry)
  {
    ThreadManager.getSubThreadHandler().post(new PoiLoader.1(this, paramLatLng, paramayry));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayru
 * JD-Core Version:    0.7.0.1
 */