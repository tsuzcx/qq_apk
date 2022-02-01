import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class ansj
  implements Manager
{
  private bgyx jdField_a_of_type_Bgyx;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  
  public ansj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public bgyx a()
  {
    if (this.jdField_a_of_type_Bgyx == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bgyx == null) {
        this.jdField_a_of_type_Bgyx = new bgyx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Bgyx;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bgyx != null) {
      this.jdField_a_of_type_Bgyx.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansj
 * JD-Core Version:    0.7.0.1
 */