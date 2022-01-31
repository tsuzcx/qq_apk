import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;
import com.tencent.mobileqq.triton.sdk.download.ITDownloadListener;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.minigame.utils.TTHandleThread;
import java.io.File;
import java.util.Set;
import org.json.JSONObject;

public class bevg
  implements IQQEnv
{
  private static String[] a = { "vivo Xplay5A", "vivo X7", "vivo X7Plus", "OPPO R9 Plusm A" };
  
  public static boolean a()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
  }
  
  public static boolean b()
  {
    return false;
  }
  
  public int blackScreenDetectInterval()
  {
    return bexm.a();
  }
  
  public void cleanCache()
  {
    try
    {
      String str = beqz.a + bevz.a().a() + "_debug";
      if (new File(str).exists()) {
        belh.a(str, false);
      }
      str = bfhg.b + bfgt.c(bevz.a().a());
      if (new File(str).exists()) {
        belh.a(str, false);
      }
      str = "/data/data/com.tencent.mobileqq/cache/mini/" + beut.a().a() + "/" + bevz.a().a();
      if (new File(str).exists()) {
        belh.a(str, false);
      }
      bexk.a().e("QQEnvImp", "cleanCache succeed!");
      return;
    }
    catch (Exception localException)
    {
      bexk.a().e("QQEnvImp", "cleanCache exception", localException);
    }
  }
  
  public boolean download(String paramString, ITDownloadListener paramITDownloadListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = bejl.a().g(paramString);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, str, 30, new bevh(this, paramITDownloadListener, paramString, str));
    bexk.a().i("[download]", "from:" + paramString + ", to:" + str);
    return true;
  }
  
  public boolean enableOpengles3()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = a;
    int k = arrayOfString.length;
    int i = 0;
    int j = 1;
    while (i < k)
    {
      if (str.equalsIgnoreCase(arrayOfString[i])) {
        j = 0;
      }
      i += 1;
    }
    boolean bool1 = bool2;
    if (bexm.e())
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int frameNoChangeLimit()
  {
    return bexm.d();
  }
  
  public boolean gameErrorDialogEnable()
  {
    return (bexm.c()) && (!bexm.d());
  }
  
  public String getAppId()
  {
    return bevz.a().a();
  }
  
  public String getBaseEnginePath()
  {
    return bewb.a().a();
  }
  
  public int getBenchmarkLevel()
  {
    return belb.a();
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, MiniGameInfo paramMiniGameInfo)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (!TextUtils.isEmpty(paramString))
    {
      if (bexo.a(paramString)) {
        return localMiniAppProxy.getDrawable(paramContext, paramString, 0, 0, new ColorDrawable(0));
      }
      return localMiniAppProxy.getDrawable(paramContext, getResPath(paramString, "", paramMiniGameInfo), 0, 0, new ColorDrawable(0));
    }
    return null;
  }
  
  public String getGameConfig(MiniGameInfo paramMiniGameInfo, String paramString)
  {
    if ((paramMiniGameInfo == null) || (paramMiniGameInfo.gameConfigJson == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return null;
      paramMiniGameInfo = paramMiniGameInfo.gameConfigJson.opt(paramString);
    } while (paramMiniGameInfo == null);
    return paramMiniGameInfo.toString();
  }
  
  public String getGameEnvVersion()
  {
    MiniAppInfo localMiniAppInfo = beqy.a().a();
    if (localMiniAppInfo != null) {
      return localMiniAppInfo.getVerTypeStr();
    }
    return "release";
  }
  
  public String getGlobalConfig()
  {
    return "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = '" + bfhg.a + "usr';\n__wxConfig.platform = 'android';\n__wxConfig.QUA = '" + bfhk.b() + "';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n";
  }
  
  public Set<String> getLogBlackList()
  {
    return bexn.b();
  }
  
  public Set<String> getLogWhiteList()
  {
    return bexn.a();
  }
  
  public String getPlatformName()
  {
    return "qq";
  }
  
  public String getPlatformVersion()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
  }
  
  public String getResPath(String paramString1, String paramString2, MiniGameInfo paramMiniGameInfo)
  {
    return bejl.a().a(paramString1);
  }
  
  public String getTmpFilePath(MiniGameInfo paramMiniGameInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      return bejl.a().g(paramString);
    }
    return bejl.a().b(paramString);
  }
  
  public String getWxFilePath(String paramString)
  {
    return bejl.a().e(paramString);
  }
  
  public boolean isDebug()
  {
    return a();
  }
  
  public boolean isNotchValid()
  {
    return false;
  }
  
  public int jsErrorDetectInterval()
  {
    return bexm.b();
  }
  
  public void killSelf(Context paramContext)
  {
    bexk.a().e("QQEnvImp", "minigame kill self!");
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).finish();
    }
    Process.killProcess(Process.myPid());
  }
  
  public int noPresentDurationLimit()
  {
    return bexm.e();
  }
  
  public int noPresentTouchLimit()
  {
    return bexm.f();
  }
  
  public int parseColor(String paramString)
  {
    return bfgh.a(paramString);
  }
  
  public void postRunable(Runnable paramRunnable)
  {
    TTHandleThread.a().b(paramRunnable);
  }
  
  public void postRunableDelayed(Runnable paramRunnable, long paramLong)
  {
    TTHandleThread.a().a(paramRunnable, paramLong);
  }
  
  public int presentDetectInterval()
  {
    return bexm.c();
  }
  
  public String readFileToString(File paramFile)
  {
    try
    {
      paramFile = belh.b(paramFile);
      return paramFile;
    }
    catch (Exception paramFile) {}
    return null;
  }
  
  public void reportDC04266(int paramInt, String paramString)
  {
    bezi.a(behu.a(), paramInt, paramString, "1");
    bewc.a().a();
  }
  
  public void reportDC04902(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (!paramString.equals("game_start")) {
        break label18;
      }
      beza.a();
    }
    label18:
    while ((paramString.equals("game_end")) || (!paramString.equals("draw_frame"))) {
      return;
    }
    beza.a(paramLong);
  }
  
  public void showGameErrorDialog(Context paramContext, DialogCallback paramDialogCallback)
  {
    paramContext = beld.a(paramContext, 230, null, bexm.a(), "取消", "确定", new bevi(this, paramDialogCallback), new bevj(this, paramDialogCallback));
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    bezi.a(bevz.a().a(), 1024, "1");
  }
  
  public void updateDisplayFrameTime(long paramLong, boolean paramBoolean)
  {
    beza.a(paramLong, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevg
 * JD-Core Version:    0.7.0.1
 */