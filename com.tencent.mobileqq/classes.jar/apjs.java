import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apjs
  extends bezs
{
  apjp jdField_a_of_type_Apjp;
  apjr jdField_a_of_type_Apjr;
  
  public apjs(QQAppInterface paramQQAppInterface, apjr paramapjr, apjp paramapjp)
  {
    super(paramQQAppInterface, paramapjr.b);
    this.jdField_a_of_type_Apjr = paramapjr;
    this.jdField_a_of_type_Apjp = paramapjp;
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realCancel");
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realStart");
    }
    apjp.a(this.jdField_a_of_type_Apjp, this.jdField_a_of_type_Apjr);
  }
  
  public String toString()
  {
    return "[DownloadTask] mInfo=" + this.jdField_a_of_type_Apjr + ", mDownloader=" + this.jdField_a_of_type_Apjp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjs
 * JD-Core Version:    0.7.0.1
 */