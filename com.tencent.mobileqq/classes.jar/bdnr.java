import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;

public abstract interface bdnr
{
  public abstract void init(Context paramContext);
  
  public abstract boolean isMiniProcess(String paramString);
  
  public abstract void onAppBackground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onAppForeground(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onAppStart(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void onAppStop(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo, Bundle paramBundle);
  
  public abstract void preloadDownloadPackage(MiniAppInfo paramMiniAppInfo);
  
  public abstract void preloadMiniApp(Bundle paramBundle);
  
  public abstract void registerProcessInfo(List<bdns> paramList);
  
  public abstract void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdnr
 * JD-Core Version:    0.7.0.1
 */