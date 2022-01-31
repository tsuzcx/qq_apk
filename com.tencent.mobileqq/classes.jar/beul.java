import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.minigame.GameRuntimeLoader;

public final class beul
  implements bepw<GameRuntimeLoader>
{
  public GameRuntimeLoader a(Context paramContext, Bundle paramBundle)
  {
    return new GameRuntimeLoader(paramContext, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beul
 * JD-Core Version:    0.7.0.1
 */