import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.ui.GameUIProxy;

public class bgvo
  implements bgwb
{
  public bgvo(GameUIProxy paramGameUIProxy) {}
  
  public void a()
  {
    QMLog.e("UIProxy", "home pressed!");
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(2053, new Object[0]);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    QMLog.e("UIProxy", "rencent task to front!");
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(2053, new Object[0]);
  }
  
  public void c()
  {
    QMLog.e("UIProxy", "screen off");
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(2053, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvo
 * JD-Core Version:    0.7.0.1
 */