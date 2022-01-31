import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.log.QMLog;

public class bguh
  extends bgug
{
  public bguh(AppRuntimeLoaderManager paramAppRuntimeLoaderManager) {}
  
  public void a(bguf parambguf)
  {
    if ((parambguf == null) || (parambguf.a == null)) {
      return;
    }
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", "OnRuntimeEvent message:" + parambguf);
    AppRuntimeLoaderManager.access$000(this.a, parambguf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bguh
 * JD-Core Version:    0.7.0.1
 */