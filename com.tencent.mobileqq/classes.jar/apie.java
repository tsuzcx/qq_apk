import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.2.1;
import com.tencent.qphone.base.util.QLog;

public class apie
  implements amkg
{
  public apie(FileBrowserActivity paramFileBrowserActivity) {}
  
  public void onServiceSyncSucc(boolean paramBoolean)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("FileBrowserActivity<FileAssistant>", 4, "color note update.");
    }
    ThreadManagerV2.getUIHandlerV2().post(new FileBrowserActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apie
 * JD-Core Version:    0.7.0.1
 */