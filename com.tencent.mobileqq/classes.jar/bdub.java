import android.net.Uri;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class bdub
  extends bdvu
{
  public bdub(PathTraceManager paramPathTraceManager, String paramString1, String paramString2) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("PathTraceManager", 1, "voice down");
    }
    parambdvv = new File(this.jdField_a_of_type_JavaLangString);
    try
    {
      ndr.a(parambdvv, PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager));
      i = 1;
    }
    catch (IOException parambdvv)
    {
      for (;;)
      {
        QLog.i("PathTraceManager", 1, "unzip fail");
        int i = 0;
      }
    }
    if (i != 0)
    {
      QLog.d("PathTraceManager", 1, "unzip success");
      if (this.b != null) {
        bdaz.a(Uri.fromFile(new File(PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager), this.b + ".mp3")), false, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdub
 * JD-Core Version:    0.7.0.1
 */