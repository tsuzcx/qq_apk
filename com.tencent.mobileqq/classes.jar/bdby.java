import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bdby
{
  private bdca jdField_a_of_type_Bdca;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bdby(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private bdca a()
  {
    bdca localbdca = new bdca(new bdbz(this));
    if (QLog.isColorLevel()) {
      QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + localbdca);
    }
    return localbdca;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdca != null)
    {
      this.jdField_a_of_type_Bdca.a();
      this.jdField_a_of_type_Bdca = null;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bdca == null) {
      this.jdField_a_of_type_Bdca = a();
    }
    this.jdField_a_of_type_Bdca.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bdca == null) {
      this.jdField_a_of_type_Bdca = a();
    }
    this.jdField_a_of_type_Bdca.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bdca == null) {
      this.jdField_a_of_type_Bdca = a();
    }
    this.jdField_a_of_type_Bdca.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bdca == null) {
      this.jdField_a_of_type_Bdca = a();
    }
    this.jdField_a_of_type_Bdca.a(4, paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdby
 * JD-Core Version:    0.7.0.1
 */