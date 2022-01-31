import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apar
  extends aozs
{
  aouj jdField_a_of_type_Aouj = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b = "OfflinePreviewController<FileAssistant>";
  
  public apar(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(paramString)) {
      QLog.e(this.b, 1, " init OfflinePreviewController error,uuid is null,stack:" + apue.a());
    }
    a();
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aouj = new apas(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aouj);
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.e(this.b, 1, " init OfflinePreviewController error,uuid is null,stack:" + apue.a());
      if (this.jdField_a_of_type_Aool != null) {
        this.jdField_a_of_type_Aool.a(false, "", "", -100005L, "", "", null, this.jdField_a_of_type_JavaLangString, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aouj != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aouj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apar
 * JD-Core Version:    0.7.0.1
 */