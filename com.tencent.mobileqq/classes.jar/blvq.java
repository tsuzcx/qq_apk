import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.PhotoPlusManager;
import java.util.concurrent.ConcurrentHashMap;

public class blvq
  extends bhyn
{
  public blvq(PhotoPlusManager paramPhotoPlusManager, String paramString1, String paramString2, String paramString3) {}
  
  public void onCancel(bhyo parambhyo)
  {
    PhotoPlusManager.a(this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bhyo parambhyo)
  {
    PhotoPlusManager.a(this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager).remove(this.jdField_a_of_type_JavaLangString);
    if (parambhyo.a() == 3)
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
      parambhyo = aznv.a(this.jdField_a_of_type_JavaLangString);
      if (this.c.equalsIgnoreCase(parambhyo))
      {
        this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[onDone] checkMd5 failed: " + this.jdField_a_of_type_JavaLangString);
      }
      FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.d("PhotoPlusManager", 2, "[onDone] downloadFile failed: " + parambhyo.b + " code=" + parambhyo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvq
 * JD-Core Version:    0.7.0.1
 */