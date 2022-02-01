import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.1;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

public class azeh
{
  private int jdField_a_of_type_Int;
  private azea jdField_a_of_type_Azea;
  private azed jdField_a_of_type_Azed;
  private azef jdField_a_of_type_Azef;
  private final String jdField_a_of_type_JavaLangString;
  
  public azeh(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Azef = new azef(paramString);
    this.jdField_a_of_type_Azea = new azea(paramString, paramInt3);
    this.jdField_a_of_type_Azed = new azed(paramString, Math.max(this.jdField_a_of_type_Azea.a() + paramInt2, 10));
  }
  
  private void a(LatLng paramLatLng, int paramInt, azel paramazel)
  {
    this.jdField_a_of_type_Azef.a(paramLatLng, paramInt, new azek(this, paramLatLng, paramInt, paramazel));
  }
  
  private boolean a(LatLng paramLatLng, int paramInt, azel paramazel)
  {
    return this.jdField_a_of_type_Azed.a(paramLatLng, paramInt, paramazel);
  }
  
  private boolean b(LatLng paramLatLng, int paramInt, azel paramazel)
  {
    return this.jdField_a_of_type_Azea.a(paramLatLng, paramInt, new azej(this, paramLatLng, paramInt, paramazel));
  }
  
  public void a(LatLng paramLatLng)
  {
    a(paramLatLng, new azei(this, paramLatLng));
  }
  
  public void a(LatLng paramLatLng, azel paramazel)
  {
    ThreadManager.getSubThreadHandler().post(new PoiLoader.1(this, paramLatLng, paramazel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azeh
 * JD-Core Version:    0.7.0.1
 */