import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class anmj
  implements Manager
{
  private annh jdField_a_of_type_Annh;
  private annm jdField_a_of_type_Annm;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Object b = new Object();
  
  public anmj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public annh a()
  {
    if (this.jdField_a_of_type_Annh != null) {
      return this.jdField_a_of_type_Annh;
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_Annh == null) {
        this.jdField_a_of_type_Annh = new annh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      annh localannh = this.jdField_a_of_type_Annh;
      return localannh;
    }
  }
  
  public annm a()
  {
    if (this.jdField_a_of_type_Annm != null) {
      return this.jdField_a_of_type_Annm;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Annm == null) {
        this.jdField_a_of_type_Annm = new annm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      annm localannm = this.jdField_a_of_type_Annm;
      return localannm;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Annm != null) {
      this.jdField_a_of_type_Annm.b();
    }
    this.jdField_a_of_type_Annm = null;
    if (this.jdField_a_of_type_Annh != null)
    {
      this.jdField_a_of_type_Annh.a();
      this.jdField_a_of_type_Annh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anmj
 * JD-Core Version:    0.7.0.1
 */