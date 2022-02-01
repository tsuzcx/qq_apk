import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class auhr
  extends atlv
{
  atfq jdField_a_of_type_Atfq = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString = "DiscOfflinePreviewController<FileAssistant>";
  String b;
  String c;
  
  public auhr(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
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
    if (this.jdField_a_of_type_Atfq != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.b))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, " init OfflinePreviewController error,uuid is null,stack:" + auea.a());
      if (this.jdField_a_of_type_Asyq != null) {
        this.jdField_a_of_type_Asyq.a(false, "", "", -100005L, "", "", null, this.b, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(this.c, this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Atfq = new auhs(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhr
 * JD-Core Version:    0.7.0.1
 */