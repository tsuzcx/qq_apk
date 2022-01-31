import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class anme
  implements Manager
{
  private annc jdField_a_of_type_Annc;
  private annh jdField_a_of_type_Annh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Object b = new Object();
  
  public anme(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public annc a()
  {
    if (this.jdField_a_of_type_Annc != null) {
      return this.jdField_a_of_type_Annc;
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_Annc == null) {
        this.jdField_a_of_type_Annc = new annc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      annc localannc = this.jdField_a_of_type_Annc;
      return localannc;
    }
  }
  
  public annh a()
  {
    if (this.jdField_a_of_type_Annh != null) {
      return this.jdField_a_of_type_Annh;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Annh == null) {
        this.jdField_a_of_type_Annh = new annh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      annh localannh = this.jdField_a_of_type_Annh;
      return localannh;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Annh != null) {
      this.jdField_a_of_type_Annh.b();
    }
    this.jdField_a_of_type_Annh = null;
    if (this.jdField_a_of_type_Annc != null)
    {
      this.jdField_a_of_type_Annc.a();
      this.jdField_a_of_type_Annc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anme
 * JD-Core Version:    0.7.0.1
 */