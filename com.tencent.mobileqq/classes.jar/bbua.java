import android.net.Uri;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class bbua
  extends bbwf
{
  public bbua(PathTraceManager paramPathTraceManager, String paramString1, String paramString2) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("PathTraceManager", 1, "voice down");
    }
    parambbwg = new File(this.jdField_a_of_type_JavaLangString);
    try
    {
      nay.a(parambbwg, PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager));
      i = 1;
    }
    catch (IOException parambbwg)
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
        bbbr.a(Uri.fromFile(new File(PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager), this.b + ".mp3")), false, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbua
 * JD-Core Version:    0.7.0.1
 */