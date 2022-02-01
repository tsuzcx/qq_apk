import com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.GetResourceRespInfo;

public class ansc
  extends AbsPreDownloadTask
{
  public File a;
  public GetResourceRespInfo a;
  
  public ansc(QQAppInterface paramQQAppInterface, String paramString, GetResourceRespInfo paramGetResourceRespInfo, File paramFile)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo = paramGetResourceRespInfo;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "DownloadTask realCancel");
    }
  }
  
  public void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "DownloadTask realStart");
    }
    String str = this.key;
    QQAppInterface localQQAppInterface = this.app;
    GetResourceRespInfo localGetResourceRespInfo = this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo;
    ThreadManagerV2.excute(new ConditionSearchManager.DownloadTask.1(this, str, this.jdField_a_of_type_JavaIoFile, localQQAppInterface, localGetResourceRespInfo), 128, null, true);
  }
  
  public String toString()
  {
    return "[DownloadTask] url=" + this.key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansc
 * JD-Core Version:    0.7.0.1
 */