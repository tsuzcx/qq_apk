import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListenerAdapter;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.NetworkState;
import java.util.List;

public class amwo
  extends ModuleDownloadListenerAdapter
{
  public amwo(QzoneModuleManager paramQzoneModuleManager) {}
  
  private void a()
  {
    if (!NetworkState.isWifiConn())
    {
      QLog.w("QzoneModuleManager", 1, "isWifiConn:false,so stop update.");
      return;
    }
    QzoneModuleManager.access$008(this.a);
    for (;;)
    {
      if (QzoneModuleManager.access$000(this.a) < QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.size())
      {
        String str = (String)QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.get(QzoneModuleManager.access$000(this.a));
        if (this.a.checkIfNeedUpdate(str)) {
          this.a.updateModule(str, this);
        }
      }
      else
      {
        if (QzoneModuleManager.access$000(this.a) != QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.size()) {
          break;
        }
        QLog.i("QzoneModuleManager", 1, "updateAllModules completed--totalModules:" + QzoneModuleManager.access$000(this.a));
        return;
      }
      QzoneModuleManager.access$008(this.a);
    }
  }
  
  public void onDownloadCanceled(String paramString)
  {
    super.onDownloadCanceled(paramString);
    a();
  }
  
  public void onDownloadFailed(String paramString)
  {
    super.onDownloadFailed(paramString);
    a();
  }
  
  public void onDownloadSucceed(String paramString)
  {
    super.onDownloadSucceed(paramString);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwo
 * JD-Core Version:    0.7.0.1
 */