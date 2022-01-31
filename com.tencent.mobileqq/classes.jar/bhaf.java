import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.app.AppRuntimeLoader;

public final class bhaf
  implements bgqh<AppRuntimeLoader>
{
  public AppRuntimeLoader a(Context paramContext, Bundle paramBundle)
  {
    return new AppRuntimeLoader(paramContext);
  }
  
  public void a(Bundle paramBundle) {}
  
  public boolean a(Bundle paramBundle)
  {
    return true;
  }
  
  public boolean a(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.isEngineTypeMiniApp());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhaf
 * JD-Core Version:    0.7.0.1
 */