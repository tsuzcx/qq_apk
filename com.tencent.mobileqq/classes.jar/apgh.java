import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

public class apgh
  extends AbsPreDownloadTask
{
  apge jdField_a_of_type_Apge;
  apgg jdField_a_of_type_Apgg;
  
  public apgh(QQAppInterface paramQQAppInterface, apgg paramapgg, apge paramapge)
  {
    super(paramQQAppInterface, paramapgg.b);
    this.jdField_a_of_type_Apgg = paramapgg;
    this.jdField_a_of_type_Apge = paramapge;
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
    apge.a(this.jdField_a_of_type_Apge, this.jdField_a_of_type_Apgg);
  }
  
  public String toString()
  {
    return "[DownloadTask] mInfo=" + this.jdField_a_of_type_Apgg + ", mDownloader=" + this.jdField_a_of_type_Apge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgh
 * JD-Core Version:    0.7.0.1
 */