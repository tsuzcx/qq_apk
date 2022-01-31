import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqyc
  extends aqxd
{
  aqru jdField_a_of_type_Aqru = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b = "OfflinePreviewController<FileAssistant>";
  
  public aqyc(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(paramString)) {
      QLog.e(this.b, 1, " init OfflinePreviewController error,uuid is null,stack:" + arrr.a());
    }
    a();
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqru = new aqyd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqru);
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.e(this.b, 1, " init OfflinePreviewController error,uuid is null,stack:" + arrr.a());
      if (this.jdField_a_of_type_Aqlx != null) {
        this.jdField_a_of_type_Aqlx.a(false, "", "", -100005L, "", "", null, this.jdField_a_of_type_JavaLangString, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aqru != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqru);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyc
 * JD-Core Version:    0.7.0.1
 */