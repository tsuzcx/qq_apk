import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class apdq
  implements Manager
{
  private apeo jdField_a_of_type_Apeo;
  private apet jdField_a_of_type_Apet;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Object b = new Object();
  
  public apdq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public apeo a()
  {
    if (this.jdField_a_of_type_Apeo != null) {
      return this.jdField_a_of_type_Apeo;
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_Apeo == null) {
        this.jdField_a_of_type_Apeo = new apeo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      apeo localapeo = this.jdField_a_of_type_Apeo;
      return localapeo;
    }
  }
  
  public apet a()
  {
    if (this.jdField_a_of_type_Apet != null) {
      return this.jdField_a_of_type_Apet;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Apet == null) {
        this.jdField_a_of_type_Apet = new apet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      apet localapet = this.jdField_a_of_type_Apet;
      return localapet;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Apet != null) {
      this.jdField_a_of_type_Apet.b();
    }
    this.jdField_a_of_type_Apet = null;
    if (this.jdField_a_of_type_Apeo != null)
    {
      this.jdField_a_of_type_Apeo.a();
      this.jdField_a_of_type_Apeo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdq
 * JD-Core Version:    0.7.0.1
 */