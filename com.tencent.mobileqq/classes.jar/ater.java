import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ater
  extends atdl
{
  asyw jdField_a_of_type_Asyw = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c = "OfflinePreviewController<FileAssistant>";
  
  public ater(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e(this.c, 1, " init OfflinePreviewController error,uuid is null,stack:" + atvo.a());
    }
    b();
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asyw != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Asyw);
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.e(this.c, 1, " init OfflinePreviewController error,uuid is null,stack:" + atvo.a());
      if (this.jdField_a_of_type_Asrx != null) {
        this.jdField_a_of_type_Asrx.a(false, "", "", -100005L, "", "", null, this.jdField_a_of_type_JavaLangString, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Asyw = new ates(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Asyw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ater
 * JD-Core Version:    0.7.0.1
 */