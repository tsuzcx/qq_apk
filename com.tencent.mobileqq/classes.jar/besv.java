import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface besv
{
  public abstract void init(Context paramContext);
  
  public abstract void onAppBackground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle);
  
  public abstract void onAppDestroy(Bundle paramBundle);
  
  public abstract void onAppForeground(MiniAppInfo paramMiniAppInfo, Bundle paramBundle);
  
  public abstract void onAppStart(MiniAppInfo paramMiniAppInfo, Bundle paramBundle);
  
  public abstract void startMiniApp(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     besv
 * JD-Core Version:    0.7.0.1
 */