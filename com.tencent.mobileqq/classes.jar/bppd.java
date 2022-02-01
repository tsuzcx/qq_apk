import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class bppd
  implements zqq
{
  bppd(String paramString, bppq parambppq) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onFailure: invoked. info: Failed to convert sample rate. message = " + paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Bppq != null) && (localFile.exists()))
    {
      this.jdField_a_of_type_Bppq.a(localFile);
      this.jdField_a_of_type_Bppq.c();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("HumUtils", 2, "onFinish: audioFile not exist. audioFile = " + localFile);
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onStart: invoked. info: ");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onSuccess: invoked. info: message = " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppd
 * JD-Core Version:    0.7.0.1
 */