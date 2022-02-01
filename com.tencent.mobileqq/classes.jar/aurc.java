import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aurc
  extends atvf
{
  atpa jdField_a_of_type_Atpa = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString = "DiscOfflinePreviewController<FileAssistant>";
  String b;
  String c;
  
  public aurc(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
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
    if (this.jdField_a_of_type_Atpa != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.b))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, " init OfflinePreviewController error,uuid is null,stack:" + aunj.a());
      if (this.jdField_a_of_type_Atib != null) {
        this.jdField_a_of_type_Atib.a(false, "", "", -100005L, "", "", null, this.b, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.c, this.b);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Atpa = new aurd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurc
 * JD-Core Version:    0.7.0.1
 */