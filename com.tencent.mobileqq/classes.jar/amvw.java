import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class amvw
  implements Manager
{
  private amwu jdField_a_of_type_Amwu;
  private amwz jdField_a_of_type_Amwz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Object b = new Object();
  
  public amvw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public amwu a()
  {
    if (this.jdField_a_of_type_Amwu != null) {
      return this.jdField_a_of_type_Amwu;
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_Amwu == null) {
        this.jdField_a_of_type_Amwu = new amwu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      amwu localamwu = this.jdField_a_of_type_Amwu;
      return localamwu;
    }
  }
  
  public amwz a()
  {
    if (this.jdField_a_of_type_Amwz != null) {
      return this.jdField_a_of_type_Amwz;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Amwz == null) {
        this.jdField_a_of_type_Amwz = new amwz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      amwz localamwz = this.jdField_a_of_type_Amwz;
      return localamwz;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Amwz != null) {
      this.jdField_a_of_type_Amwz.b();
    }
    this.jdField_a_of_type_Amwz = null;
    if (this.jdField_a_of_type_Amwu != null)
    {
      this.jdField_a_of_type_Amwu.a();
      this.jdField_a_of_type_Amwu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amvw
 * JD-Core Version:    0.7.0.1
 */