import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.1;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.2;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.3;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.4;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.5;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.6;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.7;
import com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.8;
import com.tencent.qqmini.sdk.minigame.ui.GameUIProxy;
import com.tencent.qqmini.sdk.minigame.ui.LoadingUI;
import org.json.JSONObject;

public class bewi
  extends bepn
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private GameUIProxy jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy;
  private LoadingUI jdField_a_of_type_ComTencentQqminiSdkMinigameUiLoadingUI;
  
  public bewi(GameUIProxy paramGameUIProxy)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy = paramGameUIProxy;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getMiniAppInfo();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getActivity();
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiLoadingUI = this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getLoadingUI();
  }
  
  private begy a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.getJsService();
  }
  
  private void a()
  {
    JSONObject localJSONObject;
    StringBuilder localStringBuilder;
    if (a() != null)
    {
      localJSONObject = bevi.a().b();
      localStringBuilder = new StringBuilder().append("onShow(");
      if (localJSONObject != null) {
        break label69;
      }
    }
    label69:
    for (String str = "";; str = localJSONObject.toString())
    {
      besl.d("GameRuntimeStateObserver", str + ")");
      a().a("onAppEnterForeground", localJSONObject.toString(), -1);
      return;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  private void b()
  {
    if (a() != null)
    {
      besl.d("GameRuntimeStateObserver", "onHide()");
      a().a("onAppEnterBackground", "", -1);
    }
  }
  
  private void c()
  {
    if (a() != null)
    {
      besl.d("GameRuntimeStateObserver", "onAppStop()");
      a().a("onAppStop", "", -1);
    }
  }
  
  public void a(bepm parambepm)
  {
    long l1;
    long l2;
    switch (parambepm.jdField_a_of_type_Int)
    {
    default: 
    case 2011: 
    case 2012: 
    case 2013: 
    case 2001: 
    case 2002: 
    case 2003: 
    case 2021: 
      do
      {
        do
        {
          do
          {
            return;
            besl.b("GameRuntimeStateObserver", "Game engine loading");
          } while (!(parambepm.jdField_a_of_type_JavaLangObject instanceof String));
          a(new GameRuntimeStateObserver.1(this, (String)parambepm.jdField_a_of_type_JavaLangObject));
          return;
          besl.b("GameRuntimeStateObserver", "Game engine loaded");
          if ((parambepm.jdField_a_of_type_JavaLangObject instanceof String)) {
            a(new GameRuntimeStateObserver.2(this, (String)parambepm.jdField_a_of_type_JavaLangObject));
          }
          if (parambepm.jdField_a_of_type_Bepv != null) {
            parambepm.jdField_a_of_type_Bepv.notifyRuntimeEvent(4, new Object[0]);
          }
          l1 = System.currentTimeMillis();
          l2 = this.jdField_a_of_type_Long;
          beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1033, null, null, null, 0, "1", l1 - l2, null);
          return;
          besl.b("GameRuntimeStateObserver", "Failed to load game engine");
          if ((parambepm.jdField_a_of_type_JavaLangObject instanceof Integer))
          {
            if (((Integer)parambepm.jdField_a_of_type_JavaLangObject).intValue() != 104) {
              break label338;
            }
            this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.showUpdateMobileQQDialog();
          }
          for (;;)
          {
            beye.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 510);
            l1 = System.currentTimeMillis();
            l2 = this.jdField_a_of_type_Long;
            beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1033, null, null, null, -1, "1", l1 - l2, null);
            a(new GameRuntimeStateObserver.4(this));
            return;
            a(new GameRuntimeStateObserver.3(this));
          }
          besl.b("GameRuntimeStateObserver", "Game package loading");
        } while (!(parambepm.jdField_a_of_type_JavaLangObject instanceof Float));
        parambepm = (Float)parambepm.jdField_a_of_type_JavaLangObject;
        if ((parambepm.floatValue() > 0.0F) && (parambepm.floatValue() < 1.0F)) {
          this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiGameUIProxy.setPackageDownloadFlag(true);
        }
        a(new GameRuntimeStateObserver.5(this, parambepm));
        return;
        besl.b("GameRuntimeStateObserver", "Game package loaded");
        a(new GameRuntimeStateObserver.6(this));
        l1 = System.currentTimeMillis();
        l2 = this.jdField_a_of_type_Long;
        beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1036, null, null, null, 0, "1", l1 - l2, null);
        return;
        besl.b("GameRuntimeStateObserver", "Failed to load game package");
        a(new GameRuntimeStateObserver.7(this));
        l1 = System.currentTimeMillis();
        l2 = this.jdField_a_of_type_Long;
        beye.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 511);
        beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1036, null, null, null, -1, "1", l1 - l2, null);
        return;
        besl.b("GameRuntimeStateObserver", "Game First render");
        bevl.a().b();
        a(new GameRuntimeStateObserver.8(this));
      } while (parambepm.jdField_a_of_type_Bepv == null);
      parambepm.jdField_a_of_type_Bepv.notifyRuntimeEvent(11, new Object[0]);
      return;
    case 2031: 
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
      beyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 1037, null, null, null, 0, "1", l1 - l2, null);
      return;
    case 2041: 
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      a();
      return;
    case 63: 
    case 2051: 
      a();
      return;
    case 2052: 
      label338:
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewi
 * JD-Core Version:    0.7.0.1
 */