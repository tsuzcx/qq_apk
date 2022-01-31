import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class bfkg
  implements ITMAssistantDownloadLogListener
{
  SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
  
  bfkg(bfkb parambfkb) {}
  
  public void onLog(ArrayList<TMAssistantDownloadLogInfo> paramArrayList)
  {
    if ((paramArrayList == null) && (QLog.isColorLevel())) {
      QLog.i("DownloadManager_", 2, "logList is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfkg
 * JD-Core Version:    0.7.0.1
 */