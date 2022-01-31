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

public class beup
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
    return bewv.a();
  }
  
  public void cleanCache()
  {
    try
    {
      String str = beqi.a + bevi.a().a() + "_debug";
      if (new File(str).exists()) {
        bekq.a(str, false);
      }
      str = bfgp.b + bfgc.c(bevi.a().a());
      if (new File(str).exists()) {
        bekq.a(str, false);
      }
      str = "/data/data/com.tencent.mobileqq/cache/mini/" + beuc.a().a() + "/" + bevi.a().a();
      if (new File(str).exists()) {
        bekq.a(str, false);
      }
      bewt.a().e("QQEnvImp", "cleanCache succeed!");
      return;
    }
    catch (Exception localException)
    {
      bewt.a().e("QQEnvImp", "cleanCache exception", localException);
    }
  }
  
  public boolean download(String paramString, ITDownloadListener paramITDownloadListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = beiu.a().g(paramString);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, str, 30, new beuq(this, paramITDownloadListener, paramString, str));
    bewt.a().i("[download]", "from:" + paramString + ", to:" + str);
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
    if (bewv.e())
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
    return bewv.d();
  }
  
  public boolean gameErrorDialogEnable()
  {
    return (bewv.c()) && (!bewv.d());
  }
  
  public String getAppId()
  {
    return bevi.a().a();
  }
  
  public String getBaseEnginePath()
  {
    return bevk.a().a();
  }
  
  public int getBenchmarkLevel()
  {
    return bekk.a();
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, MiniGameInfo paramMiniGameInfo)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (!TextUtils.isEmpty(paramString))
    {
      if (bewx.a(paramString)) {
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
    MiniAppInfo localMiniAppInfo = beqh.a().a();
    if (localMiniAppInfo != null) {
      return localMiniAppInfo.getVerTypeStr();
    }
    return "release";
  }
  
  public String getGlobalConfig()
  {
    return "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = '" + bfgp.a + "usr';\n__wxConfig.platform = 'android';\n__wxConfig.QUA = '" + bfgt.b() + "';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n";
  }
  
  public Set<String> getLogBlackList()
  {
    return beww.b();
  }
  
  public Set<String> getLogWhiteList()
  {
    return beww.a();
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
    return beiu.a().a(paramString1);
  }
  
  public String getTmpFilePath(MiniGameInfo paramMiniGameInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      return beiu.a().g(paramString);
    }
    return beiu.a().b(paramString);
  }
  
  public String getWxFilePath(String paramString)
  {
    return beiu.a().e(paramString);
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
    return bewv.b();
  }
  
  public void killSelf(Context paramContext)
  {
    bewt.a().e("QQEnvImp", "minigame kill self!");
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).finish();
    }
    Process.killProcess(Process.myPid());
  }
  
  public int noPresentDurationLimit()
  {
    return bewv.e();
  }
  
  public int noPresentTouchLimit()
  {
    return bewv.f();
  }
  
  public int parseColor(String paramString)
  {
    return bffq.a(paramString);
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
    return bewv.c();
  }
  
  public String readFileToString(File paramFile)
  {
    try
    {
      paramFile = bekq.b(paramFile);
      return paramFile;
    }
    catch (Exception paramFile) {}
    return null;
  }
  
  public void reportDC04266(int paramInt, String paramString)
  {
    beyr.a(behd.a(), paramInt, paramString, "1");
    bevl.a().a();
  }
  
  public void reportDC04902(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (!paramString.equals("game_start")) {
        break label18;
      }
      beyj.a();
    }
    label18:
    while ((paramString.equals("game_end")) || (!paramString.equals("draw_frame"))) {
      return;
    }
    beyj.a(paramLong);
  }
  
  public void showGameErrorDialog(Context paramContext, DialogCallback paramDialogCallback)
  {
    paramContext = bekm.a(paramContext, 230, null, bewv.a(), "取消", "确定", new beur(this, paramDialogCallback), new beus(this, paramDialogCallback));
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    beyr.a(bevi.a().a(), 1024, "1");
  }
  
  public void updateDisplayFrameTime(long paramLong, boolean paramBoolean)
  {
    beyj.a(paramLong, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beup
 * JD-Core Version:    0.7.0.1
 */