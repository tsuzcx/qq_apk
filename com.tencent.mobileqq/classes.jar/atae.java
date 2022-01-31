import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.nearby.NearbyJsInterface;

public class atae
  implements INetEventHandler
{
  private int jdField_a_of_type_Int = -1;
  
  public atae(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = naj.a();
    NearbyJsInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface, this.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atae
 * JD-Core Version:    0.7.0.1
 */