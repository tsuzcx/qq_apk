import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bgyx
{
  private bgyz jdField_a_of_type_Bgyz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bgyx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bgyz a()
  {
    bgyz localbgyz = new bgyz(new bgyy(this));
    if (QLog.isColorLevel()) {
      QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + localbgyz);
    }
    return localbgyz;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bgyz != null)
    {
      this.jdField_a_of_type_Bgyz.a();
      this.jdField_a_of_type_Bgyz = null;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bgyz == null) {
      this.jdField_a_of_type_Bgyz = a();
    }
    this.jdField_a_of_type_Bgyz.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bgyz == null) {
      this.jdField_a_of_type_Bgyz = a();
    }
    this.jdField_a_of_type_Bgyz.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bgyz == null) {
      this.jdField_a_of_type_Bgyz = a();
    }
    this.jdField_a_of_type_Bgyz.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bgyz == null) {
      this.jdField_a_of_type_Bgyz = a();
    }
    this.jdField_a_of_type_Bgyz.a(4, paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgyx
 * JD-Core Version:    0.7.0.1
 */