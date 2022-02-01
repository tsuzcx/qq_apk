import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bhgw
{
  private bhgy jdField_a_of_type_Bhgy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bhgw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bhgy a()
  {
    bhgy localbhgy = new bhgy(new bhgx(this));
    if (QLog.isColorLevel()) {
      QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + localbhgy);
    }
    return localbhgy;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhgy != null)
    {
      this.jdField_a_of_type_Bhgy.a();
      this.jdField_a_of_type_Bhgy = null;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bhgy == null) {
      this.jdField_a_of_type_Bhgy = a();
    }
    this.jdField_a_of_type_Bhgy.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bhgy == null) {
      this.jdField_a_of_type_Bhgy = a();
    }
    this.jdField_a_of_type_Bhgy.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bhgy == null) {
      this.jdField_a_of_type_Bhgy = a();
    }
    this.jdField_a_of_type_Bhgy.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bhgy == null) {
      this.jdField_a_of_type_Bhgy = a();
    }
    this.jdField_a_of_type_Bhgy.a(4, paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgw
 * JD-Core Version:    0.7.0.1
 */