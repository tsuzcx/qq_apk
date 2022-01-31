import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class aphz
  implements Manager
{
  private apix jdField_a_of_type_Apix;
  private apjc jdField_a_of_type_Apjc;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Object b = new Object();
  
  public aphz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public apix a()
  {
    if (this.jdField_a_of_type_Apix != null) {
      return this.jdField_a_of_type_Apix;
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_Apix == null) {
        this.jdField_a_of_type_Apix = new apix(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      apix localapix = this.jdField_a_of_type_Apix;
      return localapix;
    }
  }
  
  public apjc a()
  {
    if (this.jdField_a_of_type_Apjc != null) {
      return this.jdField_a_of_type_Apjc;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Apjc == null) {
        this.jdField_a_of_type_Apjc = new apjc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      apjc localapjc = this.jdField_a_of_type_Apjc;
      return localapjc;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Apjc != null) {
      this.jdField_a_of_type_Apjc.b();
    }
    this.jdField_a_of_type_Apjc = null;
    if (this.jdField_a_of_type_Apix != null)
    {
      this.jdField_a_of_type_Apix.a();
      this.jdField_a_of_type_Apix = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphz
 * JD-Core Version:    0.7.0.1
 */