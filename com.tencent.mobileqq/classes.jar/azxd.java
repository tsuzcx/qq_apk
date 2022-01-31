import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class azxd
{
  private azxf jdField_a_of_type_Azxf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public azxd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private azxf a()
  {
    azxf localazxf = new azxf(new azxe(this));
    if (QLog.isColorLevel()) {
      QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + localazxf);
    }
    return localazxf;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Azxf != null) {
      this.jdField_a_of_type_Azxf.a();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Azxf == null) {
      this.jdField_a_of_type_Azxf = a();
    }
    this.jdField_a_of_type_Azxf.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Azxf == null) {
      this.jdField_a_of_type_Azxf = a();
    }
    this.jdField_a_of_type_Azxf.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Azxf == null) {
      this.jdField_a_of_type_Azxf = a();
    }
    this.jdField_a_of_type_Azxf.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Azxf == null) {
      this.jdField_a_of_type_Azxf = a();
    }
    this.jdField_a_of_type_Azxf.a(4, paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azxd
 * JD-Core Version:    0.7.0.1
 */