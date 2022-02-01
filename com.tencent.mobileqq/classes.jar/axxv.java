import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.1;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

public class axxv
{
  private int jdField_a_of_type_Int;
  private axxo jdField_a_of_type_Axxo;
  private axxr jdField_a_of_type_Axxr;
  private axxt jdField_a_of_type_Axxt;
  private final String jdField_a_of_type_JavaLangString;
  
  public axxv(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Axxt = new axxt(paramString);
    this.jdField_a_of_type_Axxo = new axxo(paramString, paramInt3);
    this.jdField_a_of_type_Axxr = new axxr(paramString, Math.max(this.jdField_a_of_type_Axxo.a() + paramInt2, 10));
  }
  
  private void a(LatLng paramLatLng, int paramInt, axxz paramaxxz)
  {
    this.jdField_a_of_type_Axxt.a(paramLatLng, paramInt, new axxy(this, paramLatLng, paramInt, paramaxxz));
  }
  
  private boolean a(LatLng paramLatLng, int paramInt, axxz paramaxxz)
  {
    return this.jdField_a_of_type_Axxr.a(paramLatLng, paramInt, paramaxxz);
  }
  
  private boolean b(LatLng paramLatLng, int paramInt, axxz paramaxxz)
  {
    return this.jdField_a_of_type_Axxo.a(paramLatLng, paramInt, new axxx(this, paramLatLng, paramInt, paramaxxz));
  }
  
  public void a(LatLng paramLatLng)
  {
    a(paramLatLng, new axxw(this, paramLatLng));
  }
  
  public void a(LatLng paramLatLng, axxz paramaxxz)
  {
    ThreadManager.getSubThreadHandler().post(new PoiLoader.1(this, paramLatLng, paramaxxz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxv
 * JD-Core Version:    0.7.0.1
 */