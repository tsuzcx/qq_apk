import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amsw
  extends bavo
{
  amst jdField_a_of_type_Amst;
  amsv jdField_a_of_type_Amsv;
  
  public amsw(QQAppInterface paramQQAppInterface, amsv paramamsv, amst paramamst)
  {
    super(paramQQAppInterface, paramamsv.b);
    this.jdField_a_of_type_Amsv = paramamsv;
    this.jdField_a_of_type_Amst = paramamst;
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
    amst.a(this.jdField_a_of_type_Amst, this.jdField_a_of_type_Amsv);
  }
  
  public String toString()
  {
    return "[DownloadTask] mInfo=" + this.jdField_a_of_type_Amsv + ", mDownloader=" + this.jdField_a_of_type_Amst;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsw
 * JD-Core Version:    0.7.0.1
 */