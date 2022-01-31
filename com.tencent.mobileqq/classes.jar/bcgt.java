import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class bcgt
  implements ITMAssistantDownloadLogListener
{
  SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
  
  bcgt(bcgo parambcgo) {}
  
  public void onLog(ArrayList<TMAssistantDownloadLogInfo> paramArrayList)
  {
    if ((paramArrayList == null) && (QLog.isColorLevel())) {
      QLog.i("DownloadManager_", 2, "logList is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcgt
 * JD-Core Version:    0.7.0.1
 */