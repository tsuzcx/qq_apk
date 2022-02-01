import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class ampw
  implements Manager
{
  private bfqg jdField_a_of_type_Bfqg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  
  public ampw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public bfqg a()
  {
    if (this.jdField_a_of_type_Bfqg == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bfqg == null) {
        this.jdField_a_of_type_Bfqg = new bfqg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Bfqg;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bfqg != null) {
      this.jdField_a_of_type_Bfqg.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampw
 * JD-Core Version:    0.7.0.1
 */