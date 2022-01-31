import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bayh
{
  private bayj jdField_a_of_type_Bayj;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bayh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bayj a()
  {
    bayj localbayj = new bayj(new bayi(this));
    if (QLog.isColorLevel()) {
      QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + localbayj);
    }
    return localbayj;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bayj != null) {
      this.jdField_a_of_type_Bayj.a();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bayj == null) {
      this.jdField_a_of_type_Bayj = a();
    }
    this.jdField_a_of_type_Bayj.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bayj == null) {
      this.jdField_a_of_type_Bayj = a();
    }
    this.jdField_a_of_type_Bayj.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bayj == null) {
      this.jdField_a_of_type_Bayj = a();
    }
    this.jdField_a_of_type_Bayj.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bayj == null) {
      this.jdField_a_of_type_Bayj = a();
    }
    this.jdField_a_of_type_Bayj.a(4, paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bayh
 * JD-Core Version:    0.7.0.1
 */