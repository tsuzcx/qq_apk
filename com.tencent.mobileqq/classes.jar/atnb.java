import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class atnb
  extends atlv
{
  atfq jdField_a_of_type_Atfq = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public atnb(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("OfflinePreviewController<FileAssistant>", 1, " init OfflinePreviewController error,uuid is null,stack:" + auea.a());
    }
    b();
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Atfq != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.e("OfflinePreviewController<FileAssistant>", 1, " init OfflinePreviewController error,uuid is null,stack:" + auea.a());
      if (this.jdField_a_of_type_Asyq != null) {
        this.jdField_a_of_type_Asyq.a(false, "", "", -100005L, "", "", null, this.jdField_a_of_type_JavaLangString, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(this.jdField_a_of_type_JavaLangString, this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Atfq = new atnc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atnb
 * JD-Core Version:    0.7.0.1
 */