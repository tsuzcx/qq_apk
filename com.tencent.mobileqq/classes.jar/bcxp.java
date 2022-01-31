import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bcxp
{
  private bcxr jdField_a_of_type_Bcxr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bcxp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bcxr a()
  {
    bcxr localbcxr = new bcxr(new bcxq(this));
    if (QLog.isColorLevel()) {
      QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + localbcxr);
    }
    return localbcxr;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bcxr != null)
    {
      this.jdField_a_of_type_Bcxr.a();
      this.jdField_a_of_type_Bcxr = null;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bcxr == null) {
      this.jdField_a_of_type_Bcxr = a();
    }
    this.jdField_a_of_type_Bcxr.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bcxr == null) {
      this.jdField_a_of_type_Bcxr = a();
    }
    this.jdField_a_of_type_Bcxr.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bcxr == null) {
      this.jdField_a_of_type_Bcxr = a();
    }
    this.jdField_a_of_type_Bcxr.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bcxr == null) {
      this.jdField_a_of_type_Bcxr = a();
    }
    this.jdField_a_of_type_Bcxr.a(4, paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxp
 * JD-Core Version:    0.7.0.1
 */