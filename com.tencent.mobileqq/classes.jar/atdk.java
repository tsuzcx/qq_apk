import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class atdk
  extends ashp
{
  asbj jdField_a_of_type_Asbj = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString = "DiscOfflinePreviewController<FileAssistant>";
  String b;
  String c;
  
  public atdk(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramString1;
    this.c = paramString2;
    b();
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asbj != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Asbj);
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.b))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, " init OfflinePreviewController error,uuid is null,stack:" + aszt.a());
      if (this.jdField_a_of_type_Aruk != null) {
        this.jdField_a_of_type_Aruk.a(false, "", "", -100005L, "", "", null, this.b, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(this.c, this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Asbj = new atdl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Asbj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atdk
 * JD-Core Version:    0.7.0.1
 */