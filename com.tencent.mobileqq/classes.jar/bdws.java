import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.flutter.FlutterRuntimeLoader;

public final class bdws
  implements bdlr<FlutterRuntimeLoader>
{
  public FlutterRuntimeLoader a(Context paramContext, Bundle paramBundle)
  {
    return new FlutterRuntimeLoader(paramContext);
  }
  
  public void a(Bundle paramBundle) {}
  
  public boolean a(Bundle paramBundle)
  {
    if ((bdgd.a != null) && (!TextUtils.isEmpty(bdgd.a.getNativeLibDir()))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    if (paramBundle != null) {
      try
      {
        paramBundle = (String)paramBundle.get("tissuenativelibdir");
        if (bdgd.a == null) {
          bdgd.a = new bdwt(this, paramBundle);
        }
        boolean bool = TextUtils.isEmpty(bdgd.a.getNativeLibDir());
        if (!bool) {}
        for (bool = true;; bool = false) {
          return bool;
        }
        return false;
      }
      catch (Throwable paramBundle) {}
    }
  }
  
  public boolean a(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.isEngineTypeMiniApp()) && (paramMiniAppInfo.supportNativeRenderMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdws
 * JD-Core Version:    0.7.0.1
 */