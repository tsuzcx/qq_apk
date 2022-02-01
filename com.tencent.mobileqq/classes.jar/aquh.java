import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class aquh
  implements Manager
{
  private aqvf jdField_a_of_type_Aqvf;
  private aqvk jdField_a_of_type_Aqvk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Object b = new Object();
  
  public aquh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public aqvf a()
  {
    if (this.jdField_a_of_type_Aqvf != null) {
      return this.jdField_a_of_type_Aqvf;
    }
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_Aqvf == null) {
        this.jdField_a_of_type_Aqvf = new aqvf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aqvf localaqvf = this.jdField_a_of_type_Aqvf;
      return localaqvf;
    }
  }
  
  public aqvk a()
  {
    if (this.jdField_a_of_type_Aqvk != null) {
      return this.jdField_a_of_type_Aqvk;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Aqvk == null) {
        this.jdField_a_of_type_Aqvk = new aqvk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aqvk localaqvk = this.jdField_a_of_type_Aqvk;
      return localaqvk;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aqvk != null) {
      this.jdField_a_of_type_Aqvk.b();
    }
    this.jdField_a_of_type_Aqvk = null;
    if (this.jdField_a_of_type_Aqvf != null)
    {
      this.jdField_a_of_type_Aqvf.a();
      this.jdField_a_of_type_Aqvf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aquh
 * JD-Core Version:    0.7.0.1
 */