import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aowc
  extends beat
{
  aovz jdField_a_of_type_Aovz;
  aowb jdField_a_of_type_Aowb;
  
  public aowc(QQAppInterface paramQQAppInterface, aowb paramaowb, aovz paramaovz)
  {
    super(paramQQAppInterface, paramaowb.b);
    this.jdField_a_of_type_Aowb = paramaowb;
    this.jdField_a_of_type_Aovz = paramaovz;
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
    aovz.a(this.jdField_a_of_type_Aovz, this.jdField_a_of_type_Aowb);
  }
  
  public String toString()
  {
    return "[DownloadTask] mInfo=" + this.jdField_a_of_type_Aowb + ", mDownloader=" + this.jdField_a_of_type_Aovz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowc
 * JD-Core Version:    0.7.0.1
 */