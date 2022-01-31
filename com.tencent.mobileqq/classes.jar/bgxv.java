import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import com.tencent.qqmini.sdk.minigame.GameRuntimeLoader;

public final class bgxv
  implements bguo<GameRuntimeLoader>
{
  public GameRuntimeLoader a(Context paramContext, Bundle paramBundle)
  {
    paramContext = new GameRuntimeLoader(paramContext, null);
    if (paramBundle != null)
    {
      paramBundle = (EngineChannel)paramBundle.getParcelable("engineChannel");
      if (paramBundle != null) {
        paramContext.setEngineChannel(paramBundle);
      }
    }
    return paramContext;
  }
  
  public void a(Bundle paramBundle) {}
  
  public boolean a(Bundle paramBundle)
  {
    return true;
  }
  
  public boolean a(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.isEngineTypeMiniGame());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxv
 * JD-Core Version:    0.7.0.1
 */