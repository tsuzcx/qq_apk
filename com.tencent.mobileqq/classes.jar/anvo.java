import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class anvo
  implements Manager
{
  private bhgw jdField_a_of_type_Bhgw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  
  public anvo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public bhgw a()
  {
    if (this.jdField_a_of_type_Bhgw == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bhgw == null) {
        this.jdField_a_of_type_Bhgw = new bhgw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Bhgw;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bhgw != null) {
      this.jdField_a_of_type_Bhgw.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvo
 * JD-Core Version:    0.7.0.1
 */