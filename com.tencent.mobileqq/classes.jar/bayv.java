import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bayv
{
  private bayx jdField_a_of_type_Bayx;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bayv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bayx a()
  {
    bayx localbayx = new bayx(new bayw(this));
    if (QLog.isColorLevel()) {
      QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + localbayx);
    }
    return localbayx;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bayx != null) {
      this.jdField_a_of_type_Bayx.a();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bayx == null) {
      this.jdField_a_of_type_Bayx = a();
    }
    this.jdField_a_of_type_Bayx.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bayx == null) {
      this.jdField_a_of_type_Bayx = a();
    }
    this.jdField_a_of_type_Bayx.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bayx == null) {
      this.jdField_a_of_type_Bayx = a();
    }
    this.jdField_a_of_type_Bayx.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bayx == null) {
      this.jdField_a_of_type_Bayx = a();
    }
    this.jdField_a_of_type_Bayx.a(4, paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bayv
 * JD-Core Version:    0.7.0.1
 */