import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bfqg
{
  private bfqi jdField_a_of_type_Bfqi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bfqg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bfqi a()
  {
    bfqi localbfqi = new bfqi(new bfqh(this));
    if (QLog.isColorLevel()) {
      QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + localbfqi);
    }
    return localbfqi;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfqi != null)
    {
      this.jdField_a_of_type_Bfqi.a();
      this.jdField_a_of_type_Bfqi = null;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bfqi == null) {
      this.jdField_a_of_type_Bfqi = a();
    }
    this.jdField_a_of_type_Bfqi.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bfqi == null) {
      this.jdField_a_of_type_Bfqi = a();
    }
    this.jdField_a_of_type_Bfqi.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bfqi == null) {
      this.jdField_a_of_type_Bfqi = a();
    }
    this.jdField_a_of_type_Bfqi.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bfqi == null) {
      this.jdField_a_of_type_Bfqi = a();
    }
    this.jdField_a_of_type_Bfqi.a(4, paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqg
 * JD-Core Version:    0.7.0.1
 */