import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.nearby.NearbyJsInterface;

public class axpa
  implements INetEventHandler
{
  private int jdField_a_of_type_Int = -1;
  
  public axpa(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = HttpUtil.getNetWorkType();
    NearbyJsInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface, this.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpa
 * JD-Core Version:    0.7.0.1
 */