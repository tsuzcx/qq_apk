import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Random;

public class ausi
  extends ayts
{
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  public ausi(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    jdField_a_of_type_Int = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      super.a(new ayuz(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface));
      super.d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    super.b(paramToServiceMsg, null, ausj.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausi
 * JD-Core Version:    0.7.0.1
 */