import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class bdlj
  implements ITMAssistantDownloadLogListener
{
  SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
  
  bdlj(bdle parambdle) {}
  
  public void onLog(ArrayList<TMAssistantDownloadLogInfo> paramArrayList)
  {
    if ((paramArrayList == null) && (QLog.isColorLevel())) {
      QLog.i("DownloadManager_", 2, "logList is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdlj
 * JD-Core Version:    0.7.0.1
 */