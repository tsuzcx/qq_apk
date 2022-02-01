import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.PhotoPlusManager;
import java.util.concurrent.ConcurrentHashMap;

public class bmgc
  extends biht
{
  public bmgc(PhotoPlusManager paramPhotoPlusManager, String paramString1, String paramString2, String paramString3) {}
  
  public void onCancel(bihu parambihu)
  {
    PhotoPlusManager.a(this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bihu parambihu)
  {
    PhotoPlusManager.a(this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager).remove(this.jdField_a_of_type_JavaLangString);
    if (parambihu.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[onDone] download finished " + this.b);
      }
      if (TextUtils.isEmpty(this.c)) {
        this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      parambihu = azul.a(this.jdField_a_of_type_JavaLangString);
      if (this.c.equalsIgnoreCase(parambihu))
      {
        this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[onDone] checkMd5 failed: " + this.jdField_a_of_type_JavaLangString);
      }
      bhmi.d(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.d("PhotoPlusManager", 2, "[onDone] downloadFile failed: " + parambihu.b + " code=" + parambihu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgc
 * JD-Core Version:    0.7.0.1
 */