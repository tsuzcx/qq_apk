import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;
import com.tencent.mobileqq.triton.sdk.download.ITDownloadListener;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.minigame.utils.TTHandleThread;
import java.io.File;
import java.util.Set;
import org.json.JSONObject;

public class bdpl
  implements IQQEnv
{
  private static String[] a = { "vivo Xplay5A", "vivo X7", "vivo X7Plus", "OPPO R9 Plusm A" };
  
  private String a(String paramString1, String paramString2)
  {
    boolean bool1 = bdoa.a().c(paramString1);
    boolean bool2 = bdoa.a().c(paramString2);
    bdrb.a().i("QQEnvImp", "getNewestBaseLib, path1:" + paramString1 + ", valid1:" + bool1 + ", path2:" + paramString2 + ", valid2:" + bool2);
    if ((bool1) && (bool2))
    {
      localEngineVersion1 = EngineVersion.a(paramString1);
      localEngineVersion2 = EngineVersion.a(paramString2);
      if ((localEngineVersion1 != null) && (localEngineVersion2 != null)) {
        if (EngineVersion.a(localEngineVersion1.b, localEngineVersion2.b) < 0) {}
      }
    }
    while (bool1)
    {
      EngineVersion localEngineVersion1;
      EngineVersion localEngineVersion2;
      do
      {
        return paramString1;
        return paramString2;
      } while ((localEngineVersion1 != null) || (localEngineVersion2 == null));
      return paramString2;
    }
    if (bool2) {
      return paramString2;
    }
    return null;
  }
  
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
    return bdrd.a();
  }
  
  public void cleanCache()
  {
    try
    {
      Object localObject = bdly.a + bdqa.a().a() + "_debug";
      if (new File((String)localObject).exists()) {
        bdgo.a((String)localObject, false);
      }
      localObject = bdyz.b + bdyv.c(bdqa.a().a());
      if (new File((String)localObject).exists()) {
        bdgo.a((String)localObject, false);
      }
      localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      localObject = "/data/data/com.tencent.mobileqq/cache/mini/" + ((MiniAppProxy)localObject).getAccount() + "/" + bdqa.a().a();
      if (new File((String)localObject).exists()) {
        bdgo.a((String)localObject, false);
      }
      bdrb.a().e("QQEnvImp", "cleanCache succeed!");
      return;
    }
    catch (Exception localException)
    {
      bdrb.a().e("QQEnvImp", "cleanCache exception", localException);
    }
  }
  
  public boolean download(String paramString, ITDownloadListener paramITDownloadListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = bdeu.a().g(paramString);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, str, 30, new bdpm(this, paramITDownloadListener, paramString, str));
    bdrb.a().i("[download]", "from:" + paramString + ", to:" + str);
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
    if (bdrd.e())
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
    return bdrd.d();
  }
  
  public boolean gameErrorDialogEnable()
  {
    return (bdrd.c()) && (!bdrd.d());
  }
  
  public String getAppId()
  {
    return bdqa.a().a();
  }
  
  public String getBaseEnginePath()
  {
    String str1 = bdzf.a().getString("downloadUrl", "mini");
    String str2 = bdzf.a().getString("version", "1.10.0.00173");
    str2 = bdoa.a().b(str1, str2);
    String str3 = bdoa.a().b("mini", "1.10.0.00173");
    str1 = null;
    if (0 == 0) {
      str1 = MiniAppEnv.g().getContext().getFilesDir() + "/xminilib/1.0.0";
    }
    str1 = a(str1, a(str2, str3));
    bdrb.a().i("QQEnvImp", "getBaseEnginePath, retPath:" + str1);
    return str1;
  }
  
  public int getBenchmarkLevel()
  {
    return bdqz.a();
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, MiniGameInfo paramMiniGameInfo)
  {
    Drawable localDrawable = null;
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (!TextUtils.isEmpty(paramString))
    {
      if (bdrf.a(paramString)) {
        localDrawable = localMiniAppProxy.getDrawable(paramContext, paramString, 0, 0, null);
      }
    }
    else {
      return localDrawable;
    }
    return localMiniAppProxy.getDrawable(paramContext, getResPath(paramString, "", paramMiniGameInfo), 0, 0, null);
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
    MiniAppInfo localMiniAppInfo = bdlx.a().a();
    if (localMiniAppInfo != null) {
      return localMiniAppInfo.getVerTypeStr();
    }
    return "release";
  }
  
  public String getGlobalConfig()
  {
    return "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = '" + bdyz.a + "usr';\n__wxConfig.platform = 'android';\n__wxConfig.QUA = '" + bdzd.b() + "';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n";
  }
  
  public Set<String> getLogBlackList()
  {
    return bdre.b();
  }
  
  public Set<String> getLogWhiteList()
  {
    return bdre.a();
  }
  
  public String getMiniGamePath(MiniGameInfo paramMiniGameInfo)
  {
    return bdpp.a(paramMiniGameInfo);
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
    return bdeu.a().a(paramString1);
  }
  
  public String getTmpFilePath(MiniGameInfo paramMiniGameInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      return bdeu.a().g(paramString);
    }
    return bdeu.a().b(paramString);
  }
  
  public String getWxFilePath(String paramString)
  {
    return bdeu.a().e(paramString);
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
    return bdrd.b();
  }
  
  public void killSelf(Context paramContext)
  {
    bdrb.a().e("QQEnvImp", "minigame kill self!");
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).finish();
    }
    Process.killProcess(Process.myPid());
  }
  
  public int noPresentDurationLimit()
  {
    return bdrd.e();
  }
  
  public int noPresentTouchLimit()
  {
    return bdrd.f();
  }
  
  public int parseColor(String paramString)
  {
    return bdyk.a(paramString);
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
    return bdrd.c();
  }
  
  public String readFileToString(File paramFile)
  {
    try
    {
      paramFile = bdgo.b(paramFile);
      return paramFile;
    }
    catch (Exception paramFile) {}
    return null;
  }
  
  public void reportDC04266(int paramInt, String paramString)
  {
    bdsu.a(bddc.a(), paramInt, paramString, "1");
    bdqc.a().a();
  }
  
  public void reportDC04902(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (!paramString.equals("game_start")) {
        break label18;
      }
      bdsm.a();
    }
    label18:
    while ((paramString.equals("game_end")) || (!paramString.equals("draw_frame"))) {
      return;
    }
    bdsm.a(paramLong);
  }
  
  public void showGameErrorDialog(Context paramContext, DialogCallback paramDialogCallback)
  {
    paramContext = bdgk.a(paramContext, 230, null, bdrd.a(), "取消", "确定", new bdpn(this, paramDialogCallback), new bdpo(this, paramDialogCallback));
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    bdsu.a(bdqa.a().a(), 1024, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpl
 * JD-Core Version:    0.7.0.1
 */