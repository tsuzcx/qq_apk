import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class arxv
  implements Manager
{
  private aryu jdField_a_of_type_Aryu;
  private aryz jdField_a_of_type_Aryz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Object b = new Object();
  
  public arxv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public aryu a()
  {
    if (this.jdField_a_of_type_Aryu != null) {
      return this.jdField_a_of_type_Aryu;
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_Aryu == null) {
        this.jdField_a_of_type_Aryu = new aryu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aryu localaryu = this.jdField_a_of_type_Aryu;
      return localaryu;
    }
  }
  
  public aryz a()
  {
    if (this.jdField_a_of_type_Aryz != null) {
      return this.jdField_a_of_type_Aryz;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Aryz == null) {
        this.jdField_a_of_type_Aryz = new aryz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aryz localaryz = this.jdField_a_of_type_Aryz;
      return localaryz;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aryz != null) {
      this.jdField_a_of_type_Aryz.b();
    }
    this.jdField_a_of_type_Aryz = null;
    if (this.jdField_a_of_type_Aryu != null)
    {
      this.jdField_a_of_type_Aryu.a();
      this.jdField_a_of_type_Aryu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxv
 * JD-Core Version:    0.7.0.1
 */