import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class atwl
  extends atvf
{
  atpa jdField_a_of_type_Atpa = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public atwl(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("OfflinePreviewController<FileAssistant>", 1, " init OfflinePreviewController error,uuid is null,stack:" + aunj.a());
    }
    b();
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Atpa != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.e("OfflinePreviewController<FileAssistant>", 1, " init OfflinePreviewController error,uuid is null,stack:" + aunj.a());
      if (this.jdField_a_of_type_Atib != null) {
        this.jdField_a_of_type_Atib.a(false, "", "", -100005L, "", "", null, this.jdField_a_of_type_JavaLangString, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Atpa = new atwm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwl
 * JD-Core Version:    0.7.0.1
 */