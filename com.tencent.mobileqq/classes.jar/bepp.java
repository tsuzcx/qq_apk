import android.os.Bundle;
import android.os.IInterface;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface bepp
  extends IInterface
{
  public abstract Bundle a(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void a();
  
  public abstract void a(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle);
  
  public abstract void a(MiniAppInfo paramMiniAppInfo);
  
  public abstract void a(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver);
  
  public abstract void a(String paramString1, String paramString2, Bundle paramBundle, bepu parambepu);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepp
 * JD-Core Version:    0.7.0.1
 */