import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amxl
  extends bazx
{
  amxi jdField_a_of_type_Amxi;
  amxk jdField_a_of_type_Amxk;
  
  public amxl(QQAppInterface paramQQAppInterface, amxk paramamxk, amxi paramamxi)
  {
    super(paramQQAppInterface, paramamxk.b);
    this.jdField_a_of_type_Amxk = paramamxk;
    this.jdField_a_of_type_Amxi = paramamxi;
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
    amxi.a(this.jdField_a_of_type_Amxi, this.jdField_a_of_type_Amxk);
  }
  
  public String toString()
  {
    return "[DownloadTask] mInfo=" + this.jdField_a_of_type_Amxk + ", mDownloader=" + this.jdField_a_of_type_Amxi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxl
 * JD-Core Version:    0.7.0.1
 */