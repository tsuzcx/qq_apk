import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class arku
  implements Manager
{
  private arls jdField_a_of_type_Arls;
  private arlx jdField_a_of_type_Arlx;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Object b = new Object();
  
  public arku(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public arls a()
  {
    if (this.jdField_a_of_type_Arls != null) {
      return this.jdField_a_of_type_Arls;
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_Arls == null) {
        this.jdField_a_of_type_Arls = new arls(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      arls localarls = this.jdField_a_of_type_Arls;
      return localarls;
    }
  }
  
  public arlx a()
  {
    if (this.jdField_a_of_type_Arlx != null) {
      return this.jdField_a_of_type_Arlx;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Arlx == null) {
        this.jdField_a_of_type_Arlx = new arlx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      arlx localarlx = this.jdField_a_of_type_Arlx;
      return localarlx;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Arlx != null) {
      this.jdField_a_of_type_Arlx.b();
    }
    this.jdField_a_of_type_Arlx = null;
    if (this.jdField_a_of_type_Arls != null)
    {
      this.jdField_a_of_type_Arls.a();
      this.jdField_a_of_type_Arls = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arku
 * JD-Core Version:    0.7.0.1
 */