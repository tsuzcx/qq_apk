import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class anjr
  implements Manager
{
  private bggv jdField_a_of_type_Bggv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public Object a;
  
  public anjr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public bggv a()
  {
    if (this.jdField_a_of_type_Bggv == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Bggv == null) {
        this.jdField_a_of_type_Bggv = new bggv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return this.jdField_a_of_type_Bggv;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bggv != null) {
      this.jdField_a_of_type_Bggv.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjr
 * JD-Core Version:    0.7.0.1
 */