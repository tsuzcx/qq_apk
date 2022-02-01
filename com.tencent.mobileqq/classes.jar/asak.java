import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class asak
  implements Manager
{
  private asbi jdField_a_of_type_Asbi;
  private asbn jdField_a_of_type_Asbn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Object b = new Object();
  
  public asak(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public asbi a()
  {
    if (this.jdField_a_of_type_Asbi != null) {
      return this.jdField_a_of_type_Asbi;
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_Asbi == null) {
        this.jdField_a_of_type_Asbi = new asbi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      asbi localasbi = this.jdField_a_of_type_Asbi;
      return localasbi;
    }
  }
  
  public asbn a()
  {
    if (this.jdField_a_of_type_Asbn != null) {
      return this.jdField_a_of_type_Asbn;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Asbn == null) {
        this.jdField_a_of_type_Asbn = new asbn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      asbn localasbn = this.jdField_a_of_type_Asbn;
      return localasbn;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Asbn != null) {
      this.jdField_a_of_type_Asbn.b();
    }
    this.jdField_a_of_type_Asbn = null;
    if (this.jdField_a_of_type_Asbi != null)
    {
      this.jdField_a_of_type_Asbi.a();
      this.jdField_a_of_type_Asbi = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asak
 * JD-Core Version:    0.7.0.1
 */