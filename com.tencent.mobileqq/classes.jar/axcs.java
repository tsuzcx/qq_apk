import android.os.Bundle;
import com.tencent.mobileqq.nearby.NearbyJsInterface;

public class axcs
  implements aaob
{
  public axcs(NearbyJsInterface paramNearbyJsInterface, aanz paramaanz, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("nearbyVideoConfig");
    this.jdField_a_of_type_Aanz.b(new axct(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axcs
 * JD-Core Version:    0.7.0.1
 */