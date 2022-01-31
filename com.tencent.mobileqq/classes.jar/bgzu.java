import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.1;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.2;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.3;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.4;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.5;
import com.tencent.qqmini.sdk.minigame.ui.GameUIProxy;
import com.tencent.qqmini.sdk.minigame.ui.LoadingUI;
import org.json.JSONObject;

public class bgzu
  extends bgug
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private GameUIProxy jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy;
  private LoadingUI jdField_a_of_type_ComTencentQqminiSdkMinigameUiLoadingUI;
  private long b;
  private long c;
  private long d;
  private long e;
  
  public bgzu(GameUIProxy paramGameUIProxy)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy = paramGameUIProxy;
  }
  
  private bglu a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getJsService();
  }
  
  private void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  private void a(String paramString, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiLoadingUI == null) {
      return;
    }
    a(new GameRuntimeStateObserver.5(this, paramString, paramFloat));
  }
  
  private void b()
  {
    if (a() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getGameRuntime().a();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    JSONObject localJSONObject = ((bgza)localObject).b();
    StringBuilder localStringBuilder = new StringBuilder().append("onShow(");
    if (localJSONObject == null) {}
    for (Object localObject = "";; localObject = localJSONObject.toString())
    {
      QMLog.i("GameRuntimeState", (String)localObject + "). " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      a().a("onAppEnterForeground", localJSONObject.toString(), -1);
      return;
    }
  }
  
  private void c()
  {
    if (a() != null)
    {
      QMLog.i("GameRuntimeState", "onHide(). " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      a().a("onAppEnterBackground", "", -1);
    }
  }
  
  private void d()
  {
    if (a() != null)
    {
      QMLog.i("GameRuntimeState", "onAppStop(). " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      a().a("onAppStop", "", -1);
    }
  }
  
  public void a()
  {
    this.b = System.currentTimeMillis();
  }
  
  public void a(bguf parambguf)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getMiniAppInfo();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getActivity();
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiLoadingUI = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getLoadingUI();
    switch (parambguf.jdField_a_of_type_Int)
    {
    default: 
    case 20: 
    case 2011: 
    case 2012: 
    case 2013: 
    case 2001: 
    case 2002: 
    case 2003: 
    case 2021: 
    case 2031: 
    case 63: 
    case 2032: 
      do
      {
        do
        {
          do
          {
            return;
            QMLog.i("GameRuntimeState", "User click. onCreate/onNewIntent. " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            return;
            QMLog.i("GameRuntimeState", "Game engine loading. " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
          } while (!(parambguf.jdField_a_of_type_JavaLangObject instanceof bgzw));
          parambguf = (bgzw)parambguf.jdField_a_of_type_JavaLangObject;
          a(parambguf.a(), parambguf.a());
          return;
          QMLog.i("GameRuntimeState", "Game engine loaded. " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
          if ((parambguf.jdField_a_of_type_JavaLangObject instanceof String)) {
            a((String)parambguf.jdField_a_of_type_JavaLangObject, 1.0F);
          }
          if (parambguf.jdField_a_of_type_Bgun != null) {
            parambguf.jdField_a_of_type_Bgun.notifyRuntimeEvent(4, new Object[0]);
          }
          l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
          bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1033, null, String.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getStatMode()), null, 0, "1", l1, null);
          QMLog.e("[minigame][timecost] ", "step[load baseLib] succeed, cost time: " + l1);
          return;
          QMLog.i("GameRuntimeState", "Failed to load game engine. " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
          if ((parambguf.jdField_a_of_type_JavaLangObject instanceof Integer))
          {
            if (((Integer)parambguf.jdField_a_of_type_JavaLangObject).intValue() != 104) {
              break label525;
            }
            this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.showUpdateMobileQQDialog();
          }
          for (;;)
          {
            bhbx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 510);
            l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
            bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1033, null, String.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getStatMode()), null, -1, "1", l1, null);
            QMLog.e("[minigame][timecost] ", "step[load baseLib] fail, cost time: " + l1);
            a(new GameRuntimeStateObserver.2(this));
            return;
            a(new GameRuntimeStateObserver.1(this));
          }
          QMLog.i("GameRuntimeState", "Game package loading. " + parambguf.jdField_a_of_type_JavaLangObject + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        } while (!(parambguf.jdField_a_of_type_JavaLangObject instanceof bgzw));
        parambguf = (bgzw)parambguf.jdField_a_of_type_JavaLangObject;
        if (parambguf.a()) {
          this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.setPackageDownloadFlag(true);
        }
        a(parambguf.a(), parambguf.a());
        return;
        QMLog.i("GameRuntimeState", "Game package loaded. " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        a("100%", 1.0F);
        long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1036, null, this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getLaunchMsg(), null, 0, "1", l1, null);
        QMLog.e("[minigame][timecost] ", "step[load gpkg] succeed, cost time: " + l1);
        return;
        QMLog.i("GameRuntimeState", "Failed to load game package. " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        a(new GameRuntimeStateObserver.3(this));
        l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        bhbx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 511);
        bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1036, null, null, null, -1, "1", l1, null);
        QMLog.e("[minigame][timecost] ", "step[load gpkg] fail, cost time: " + l1);
        return;
        l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1037, null, this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getLaunchMsg(), null, 0, "1", l1, null);
        QMLog.e("[minigame][timecost] ", "[MiniEng] step[init runTime] cost time " + l1 + ", include steps[load baseLib, load gpkg]");
        return;
        QMLog.i("GameRuntimeState", "Game surface create. " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        this.c = System.currentTimeMillis();
        return;
        QMLog.i("GameRuntimeState", "Game launched. " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        this.d = System.currentTimeMillis();
        return;
        QMLog.i("GameRuntimeState", "Game First render. " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        int i = 0;
        if ((parambguf.jdField_a_of_type_JavaLangObject instanceof Integer)) {
          i = ((Integer)parambguf.jdField_a_of_type_JavaLangObject).intValue();
        }
        this.e = System.currentTimeMillis();
        l1 = this.e;
        long l2 = this.c;
        long l3 = this.e - this.b;
        long l4 = this.e;
        long l5 = this.d;
        bhck.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1043, null, this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getLaunchMsg(), null, i, "1", l3, null);
        QMLog.e("[minigame][timecost] ", "step[onFirstFrameAppear] (首帧出现) cost time " + (l1 - l2) + "(from create surfaceView), " + l3 + "(from onCreate) " + (l4 - l5) + " ms(from gameLaunched)");
        a(new GameRuntimeStateObserver.4(this));
      } while (parambguf.jdField_a_of_type_Bgun == null);
      parambguf.jdField_a_of_type_Bgun.notifyRuntimeEvent(11, new Object[0]);
      return;
    case 2051: 
      b();
      return;
    case 2052: 
      label525:
      c();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzu
 * JD-Core Version:    0.7.0.1
 */