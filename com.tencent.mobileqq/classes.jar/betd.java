import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import java.io.File;

public class betd
{
  public static final String a = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/minigame/";
  public static final String b = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/mini/";
  
  public static String a(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      return "";
    }
    if (paramMiniAppInfo.verType == 3) {
      return b(paramMiniAppInfo) + bfgt.c(paramMiniAppInfo.appId) + "_" + paramMiniAppInfo.version;
    }
    return b(paramMiniAppInfo) + paramMiniAppInfo.appId + "_debug";
  }
  
  public static String a(MiniGamePluginInfo paramMiniGamePluginInfo)
  {
    return a + bfgt.c(paramMiniGamePluginInfo.b) + "_plugin_" + paramMiniGamePluginInfo.c;
  }
  
  public static boolean a(MiniAppInfo paramMiniAppInfo)
  {
    return new File(a(paramMiniAppInfo)).exists();
  }
  
  public static String b(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {
      return a;
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     betd
 * JD-Core Version:    0.7.0.1
 */