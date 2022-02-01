import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.1;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

public class azkn
{
  private int jdField_a_of_type_Int;
  private azkg jdField_a_of_type_Azkg;
  private azkj jdField_a_of_type_Azkj;
  private azkl jdField_a_of_type_Azkl;
  private final String jdField_a_of_type_JavaLangString;
  
  public azkn(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Azkl = new azkl(paramString);
    this.jdField_a_of_type_Azkg = new azkg(paramString, paramInt3);
    this.jdField_a_of_type_Azkj = new azkj(paramString, Math.max(this.jdField_a_of_type_Azkg.a() + paramInt2, 10));
  }
  
  private void a(LatLng paramLatLng, int paramInt, azkr paramazkr)
  {
    this.jdField_a_of_type_Azkl.a(paramLatLng, paramInt, new azkq(this, paramLatLng, paramInt, paramazkr));
  }
  
  private boolean a(LatLng paramLatLng, int paramInt, azkr paramazkr)
  {
    return this.jdField_a_of_type_Azkj.a(paramLatLng, paramInt, paramazkr);
  }
  
  private boolean b(LatLng paramLatLng, int paramInt, azkr paramazkr)
  {
    return this.jdField_a_of_type_Azkg.a(paramLatLng, paramInt, new azkp(this, paramLatLng, paramInt, paramazkr));
  }
  
  public void a(LatLng paramLatLng)
  {
    a(paramLatLng, new azko(this, paramLatLng));
  }
  
  public void a(LatLng paramLatLng, azkr paramazkr)
  {
    ThreadManager.getSubThreadHandler().post(new PoiLoader.1(this, paramLatLng, paramazkr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkn
 * JD-Core Version:    0.7.0.1
 */