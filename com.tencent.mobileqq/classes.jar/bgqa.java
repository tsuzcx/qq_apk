import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.log.QMLog;

public class bgqa
  extends bgpz
{
  public bgqa(AppRuntimeLoaderManager paramAppRuntimeLoaderManager) {}
  
  public void a(bgpy parambgpy)
  {
    if ((parambgpy == null) || (parambgpy.a == null)) {
      return;
    }
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "OnRuntimeEvent message:" + parambgpy);
    AppRuntimeLoaderManager.access$000(this.a, parambgpy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqa
 * JD-Core Version:    0.7.0.1
 */