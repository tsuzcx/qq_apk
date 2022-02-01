import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.nearby.NearbyJsInterface;

public class axvq
  implements INetEventHandler
{
  private int jdField_a_of_type_Int = -1;
  
  public axvq(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = nnr.a();
    NearbyJsInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface, this.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvq
 * JD-Core Version:    0.7.0.1
 */