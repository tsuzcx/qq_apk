import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqru
  extends aqsu
{
  aqnl jdField_a_of_type_Aqnl = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString = "DiscOfflinePreviewController<FileAssistant>";
  String b;
  String c;
  
  public aqru(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramString1;
    this.c = paramString2;
    a();
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqnl = new aqrv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqnl);
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.b))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, " init OfflinePreviewController error,uuid is null,stack:" + arni.a());
      if (this.jdField_a_of_type_Aqho != null) {
        this.jdField_a_of_type_Aqho.a(false, "", "", -100005L, "", "", null, this.b, null);
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.c, this.b);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aqnl != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqru
 * JD-Core Version:    0.7.0.1
 */