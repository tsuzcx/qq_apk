import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

public class aodf
  extends AbsPreDownloadTask
{
  aodc jdField_a_of_type_Aodc;
  aode jdField_a_of_type_Aode;
  
  public aodf(QQAppInterface paramQQAppInterface, aode paramaode, aodc paramaodc)
  {
    super(paramQQAppInterface, paramaode.b);
    this.jdField_a_of_type_Aode = paramaode;
    this.jdField_a_of_type_Aodc = paramaodc;
  }
  
  public void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realCancel");
    }
  }
  
  public void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realStart");
    }
    aodc.a(this.jdField_a_of_type_Aodc, this.jdField_a_of_type_Aode);
  }
  
  public String toString()
  {
    return "[DownloadTask] mInfo=" + this.jdField_a_of_type_Aode + ", mDownloader=" + this.jdField_a_of_type_Aodc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodf
 * JD-Core Version:    0.7.0.1
 */