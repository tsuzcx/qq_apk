import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.flutter.FlutterRuntimeLoader;

public final class bhdl
  implements bgqh<FlutterRuntimeLoader>
{
  public FlutterRuntimeLoader a(Context paramContext, Bundle paramBundle)
  {
    return new FlutterRuntimeLoader(paramContext);
  }
  
  public void a(Bundle paramBundle) {}
  
  public boolean a(Bundle paramBundle)
  {
    if ((TissueGlobal.tissueEnv != null) && (!TextUtils.isEmpty(TissueGlobal.tissueEnv.getNativeLibDir()))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    if (paramBundle != null) {
      try
      {
        paramBundle = (String)paramBundle.get("tissuenativelibdir");
        if (TissueGlobal.tissueEnv == null) {
          TissueGlobal.tissueEnv = new bhdm(this, paramBundle);
        }
        boolean bool = TextUtils.isEmpty(TissueGlobal.tissueEnv.getNativeLibDir());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdl
 * JD-Core Version:    0.7.0.1
 */