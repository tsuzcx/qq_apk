import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

public class azex
{
  public final float a;
  public final long a;
  public final LatLng a;
  public final String a;
  
  public azex(LatLng paramLatLng, String paramString, float paramFloat, long paramLong)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long >= azcv.N;
  }
  
  @NotNull
  public String toString()
  {
    return "Location{latLng=" + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + ", provider='" + this.jdField_a_of_type_JavaLangString + ", accuracy=" + this.jdField_a_of_type_Float + ", time=" + new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_Long)) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azex
 * JD-Core Version:    0.7.0.1
 */