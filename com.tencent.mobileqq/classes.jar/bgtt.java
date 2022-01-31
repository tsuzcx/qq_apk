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
import com.tencent.qqmini.sdk.minigame.GameRuntimeLoader;
import com.tencent.qqmini.sdk.minigame.utils.TTHandleThread;
import com.tencent.qqmini.sdk.utils.ColorUtils;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.File;
import java.util.Set;
import org.json.JSONObject;

public class bgtt
  implements IQQEnv
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "vivo Xplay5A", "vivo X7", "vivo X7Plus", "OPPO R9 Plusm A" };
  private GameRuntimeLoader jdField_a_of_type_ComTencentQqminiSdkMinigameGameRuntimeLoader;
  
  public bgtt(GameRuntimeLoader paramGameRuntimeLoader)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameGameRuntimeLoader = paramGameRuntimeLoader;
  }
  
  public static boolean a()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
  }
  
  public int blackScreenDetectInterval()
  {
    return GameWnsUtils.getGameErrorBlackDetectInterval();
  }
  
  public void cleanCache()
  {
    try
    {
      bgiv.a(bgte.a().a(), this.jdField_a_of_type_ComTencentQqminiSdkMinigameGameRuntimeLoader.getGameInfoManager().a(), false);
      return;
    }
    catch (Exception localException)
    {
      bgwc.a().e("QQEnvImp", "cleanCache exception", localException);
    }
  }
  
  public boolean download(String paramString, ITDownloadListener paramITDownloadListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = bgjm.a().g(paramString);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString, null, str, 30, new bgtu(this, paramITDownloadListener, paramString, str));
    bgwc.a().i("[download]", "from:" + paramString + ", to:" + str);
    return true;
  }
  
  public boolean enableOpengles3()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
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
    if (GameWnsUtils.enableOpengles3())
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
    return GameWnsUtils.getFrameNoChangeLimit();
  }
  
  public boolean gameErrorDialogEnable()
  {
    return (GameWnsUtils.getGameErrorDialogEnable()) && (!GameWnsUtils.getGameErrorDialogIsBlack());
  }
  
  public String getAppId()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkMinigameGameRuntimeLoader.getGameInfoManager().a();
  }
  
  public String getBaseEnginePath()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkMinigameGameRuntimeLoader.getLibVersionManager().a();
  }
  
  public int getBenchmarkLevel()
  {
    return bgkn.a();
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, MiniGameInfo paramMiniGameInfo)
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (!TextUtils.isEmpty(paramString))
    {
      if (bgwg.a(paramString)) {
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
    MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_ComTencentQqminiSdkMinigameGameRuntimeLoader.getMiniAppInfo();
    if (localMiniAppInfo != null) {
      return localMiniAppInfo.getVerTypeStr();
    }
    return "release";
  }
  
  public String getGlobalConfig()
  {
    return "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = '" + MiniSDKConst.STR_WXFILE + "usr';\n__wxConfig.platform = 'android';\n__wxConfig.QUA = '" + QUAUtil.getPlatformQUA() + "';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n";
  }
  
  public Set<String> getLogBlackList()
  {
    return bgwe.b();
  }
  
  public Set<String> getLogWhiteList()
  {
    return bgwe.a();
  }
  
  public String getPlatformName()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppName();
  }
  
  public String getPlatformVersion()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
  }
  
  public String getResPath(String paramString1, String paramString2, MiniGameInfo paramMiniGameInfo)
  {
    return bgjm.a().a(paramString1);
  }
  
  public String getTmpFilePath(MiniGameInfo paramMiniGameInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      return bgjm.a().g(paramString);
    }
    return bgjm.a().b(paramString);
  }
  
  public String getWxFilePath(String paramString)
  {
    return bgjm.a().e(paramString);
  }
  
  public boolean isDebug()
  {
    return a();
  }
  
  public boolean isNotchValid()
  {
    return LiuHaiUtils.isLiuHaiUseValid();
  }
  
  public int jsErrorDetectInterval()
  {
    return GameWnsUtils.getGameJsErrorDetectInterval();
  }
  
  public void killSelf(Context paramContext)
  {
    bgwc.a().e("QQEnvImp", "minigame kill self!");
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).finish();
    }
    Process.killProcess(Process.myPid());
  }
  
  public int noPresentDurationLimit()
  {
    return GameWnsUtils.getNoPresentDurationLimit();
  }
  
  public int noPresentTouchLimit()
  {
    return GameWnsUtils.getNoPresentTouchLimit();
  }
  
  public int parseColor(String paramString)
  {
    return ColorUtils.parseColor(paramString);
  }
  
  public void postRunable(Runnable paramRunnable)
  {
    TTHandleThread.a().c(paramRunnable);
  }
  
  public void postRunableDelayed(Runnable paramRunnable, long paramLong)
  {
    TTHandleThread.a().a(paramRunnable, paramLong);
  }
  
  public int presentDetectInterval()
  {
    return GameWnsUtils.getGamePresentDetectInterval();
  }
  
  public String readFileToString(File paramFile)
  {
    try
    {
      paramFile = bgkv.b(paramFile);
      return paramFile;
    }
    catch (Exception paramFile) {}
    return null;
  }
  
  public void reportDC04266(int paramInt, String paramString)
  {
    bgyd.a(bghu.a(), paramInt, paramString, "1");
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameGameRuntimeLoader.getReportManager().a();
  }
  
  public void reportDC04902(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (!paramString.equals("game_start")) {
        break label28;
      }
      bgxv.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameGameRuntimeLoader.getMiniAppInfoForReport().appId);
    }
    label28:
    while ((paramString.equals("game_end")) || (!paramString.equals("draw_frame"))) {
      return;
    }
    bgxv.a(paramLong);
  }
  
  public void showGameErrorDialog(Context paramContext, DialogCallback paramDialogCallback)
  {
    paramContext = bgkp.a(paramContext, 230, null, GameWnsUtils.getGameErrorDialogContent(), "取消", "确定", new bgtv(this, paramDialogCallback), new bgtw(this, paramDialogCallback));
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    bgyd.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameGameRuntimeLoader.getGameInfoManager().a(), 1024, "1");
  }
  
  public void updateDisplayFrameTime(long paramLong, boolean paramBoolean)
  {
    bgxv.a(paramLong, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtt
 * JD-Core Version:    0.7.0.1
 */