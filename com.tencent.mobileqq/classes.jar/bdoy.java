import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.debug.GameDebugInfo;
import com.tencent.mobileqq.triton.sdk.game.GamePluginInfo;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.minigame.GamePage.1;
import com.tencent.qqmini.sdk.minigame.GamePage.2;
import com.tencent.qqmini.sdk.minigame.ui.VConsoleDragView;
import com.tencent.qqmini.sdk.minigame.ui.VConsoleView;
import com.tencent.qqmini.sdk.minigame.widget.GameNavigationBar;
import com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView;
import java.io.File;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class bdoy
  implements bdqx
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bdrg jdField_a_of_type_Bdrg;
  private ITTEngine jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine;
  private MiniGameInfo jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo;
  private VConsoleDragView jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView;
  private VConsoleView jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView;
  private GameNavigationBar jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar;
  private MiniAppMonitorInfoView jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  bdoy(ITTEngine paramITTEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine = paramITTEngine;
  }
  
  private bdnl a()
  {
    bdmy localbdmy = new bdmy();
    localbdmy.jdField_a_of_type_Int = 0;
    localbdmy.jdField_a_of_type_JavaLangString = "gray";
    localbdmy.c = "default";
    bdnl localbdnl = new bdnl();
    localbdnl.jdField_a_of_type_Bdmy = localbdmy;
    localbdnl.jdField_a_of_type_Int = bdyn.a("#ffffff");
    localbdnl.jdField_a_of_type_JavaLangString = "dark";
    localbdnl.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    localbdnl.b = 50;
    return localbdnl;
  }
  
  private MiniGameInfo a(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMiniAppInfo != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMiniAppInfo.appId)) {
        if (paramMiniAppInfo.debugInfo == null) {
          break label145;
        }
      }
    }
    label145:
    for (localObject1 = new GameDebugInfo(paramMiniAppInfo.debugInfo.b, paramMiniAppInfo.debugInfo.jdField_a_of_type_JavaLangString, 8507);; localObject1 = null)
    {
      if (paramMiniAppInfo.miniGamePluginInfo != null) {
        localObject2 = paramMiniAppInfo.miniGamePluginInfo;
      }
      for (localObject2 = Collections.singletonList(new GamePluginInfo(((MiniGamePluginInfo)localObject2).jdField_a_of_type_JavaLangString, ((MiniGamePluginInfo)localObject2).b, ((MiniGamePluginInfo)localObject2).c, bdnx.a((MiniGamePluginInfo)localObject2) + File.separator + "plugin.js"));; localObject2 = null)
      {
        localObject1 = new MiniGameInfo(paramMiniAppInfo.appId, paramMiniAppInfo.version, paramMiniAppInfo.verType, null, (GameDebugInfo)localObject1, (List)localObject2);
        return localObject1;
      }
    }
  }
  
  private VConsoleDragView a()
  {
    VConsoleDragView localVConsoleDragView = new VConsoleDragView(this.jdField_a_of_type_AndroidAppActivity);
    localVConsoleDragView.setImageResource(2130840746);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(bdyn.a(this.jdField_a_of_type_AndroidAppActivity, 90.0F), -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    localLayoutParams.setMargins(0, 0, bdyn.a(this.jdField_a_of_type_AndroidAppActivity, 12.0F), bdyn.a(this.jdField_a_of_type_AndroidAppActivity, 12.0F));
    localVConsoleDragView.setLayoutParams(localLayoutParams);
    localVConsoleDragView.setListener(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GamePage.2(this, localVConsoleDragView), 1500L);
    return localVConsoleDragView;
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
    {
      bdnw.c("GamePage", "Failed to attach navigation bar, root view is null");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar != null) && (this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar.getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar.getParent()).removeView(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar);
    }
    paramViewGroup.addView(this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar);
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo == null) {
      bdnw.c("GamePage", "Failed to attach vConsole view, game info is null");
    }
    while (!bdzf.a().getBoolean(this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.gameId + "_debug", false)) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView = a();
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView);
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView.bringToFront();
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView.setVisibility(0);
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo == null) {
      bdnw.c("GamePage", "Failed to attach game surface view, game info is null");
    }
    do
    {
      return;
      d();
      bdnw.b("GamePage", " createGameView width :" + this.jdField_a_of_type_Int + " height:" + this.b);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.createGameView(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView, 0);
      bdet.a().a(this.jdField_a_of_type_AndroidAppActivity, (ViewGroup)this.jdField_a_of_type_AndroidViewView);
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getGameLauncher();
    } while (paramViewGroup == null);
    paramViewGroup.setCurrentGame(this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo);
  }
  
  private void c(MiniAppInfo paramMiniAppInfo)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while ((paramMiniAppInfo == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    bdew.a(new GamePage.1(this, paramMiniAppInfo, this.jdField_a_of_type_AndroidAppActivity), 16, null, false);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView != null) && (this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView.getVisibility() == 0);
  }
  
  private void d()
  {
    MiniGameInfo localMiniGameInfo = this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo;
    Object localObject;
    int j;
    int i;
    int k;
    if (bdqa.a().a() != null)
    {
      localObject = bdqa.a().a().a;
      localMiniGameInfo.gameConfigJson = ((JSONObject)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.gameConfigJson != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.openDataPath = this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.gameConfigJson.optString("openDataContext", null);
        this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.deviceOrientation = this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.gameConfigJson.optString("deviceOrientation", null);
        if ("landscape".equals(this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.deviceOrientation))
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
          if (this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar != null) {
            this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar.a();
          }
          if (this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView != null) {
            this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView.a();
          }
        }
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.gameConfigJson.optBoolean("showStatusBar", false);
        bdnw.b("GamePage", "initGameUI game config showStatusBar=" + bool);
        if (!bool) {
          this.jdField_a_of_type_AndroidAppActivity.getWindow().setFlags(1024, 1024);
        }
      }
      bdnw.d("GamePage", "initGameUI start create game SurfaceView & inject preload js");
      System.currentTimeMillis();
      j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().widthPixels;
      i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().heightPixels;
      if (Build.VERSION.SDK_INT >= 17)
      {
        localObject = new DisplayMetrics();
        ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
        i = ((DisplayMetrics)localObject).heightPixels;
        j = ((DisplayMetrics)localObject).widthPixels;
        this.jdField_a_of_type_Float = ((DisplayMetrics)localObject).density;
        if (!Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
          break label425;
        }
        k = j;
        if (Settings.Secure.getInt(this.jdField_a_of_type_AndroidAppActivity.getContentResolver(), "display_notch_status", 0) == 1)
        {
          k = j;
          if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.isOrientationLandscape()) {
            k = j - bdyn.d(this.jdField_a_of_type_AndroidAppActivity);
          }
        }
        j = k;
      }
    }
    for (;;)
    {
      int m;
      if ((!this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.isOrientationLandscape()) || (j > i))
      {
        m = i;
        k = j;
        if (!this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.isOrientationLandscape())
        {
          m = i;
          k = j;
          if (i > j) {}
        }
      }
      else
      {
        k = i;
        m = j;
      }
      this.jdField_a_of_type_Int = k;
      this.b = m;
      return;
      localObject = null;
      break;
      label425:
      if ((Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) && (Settings.Global.getInt(this.jdField_a_of_type_AndroidAppActivity.getContentResolver(), "force_black", 0) == 1))
      {
        bdnw.b("GamePage", "xiaomi has notch");
        if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo.isOrientationLandscape())
        {
          j -= bdyn.d(this.jdField_a_of_type_AndroidAppActivity);
        }
        else
        {
          k = bdyn.d(this.jdField_a_of_type_AndroidAppActivity);
          i -= k;
        }
      }
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView != null) && (this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView.getVisibility() == 0);
  }
  
  private void e()
  {
    if (c()) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView = new VConsoleView(this.jdField_a_of_type_AndroidAppActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView);
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView.setVisibility(8);
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView.bringToFront();
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView.bringToFront();
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView.setListener(null);
  }
  
  CapsuleButton a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar.a();
  }
  
  public void a() {}
  
  public void a(double paramDouble)
  {
    if (d()) {
      this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView.a(paramDouble);
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    a(paramViewGroup);
    c(paramViewGroup);
    b(paramViewGroup);
  }
  
  public void a(bdcz parambdcz)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar = new GameNavigationBar(parambdcz.a());
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar.setContentDescription("NavigationBar");
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar.setId(2131304604);
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar.a(parambdcz);
    this.jdField_a_of_type_ComTencentQqminiSdkMinigameWidgetGameNavigationBar.a(a());
    this.jdField_a_of_type_Bdrg = new bdrg();
    bdrj.a().a(Process.myPid(), this.jdField_a_of_type_Bdrg);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkGameMiniGameInfo = a(paramMiniAppInfo);
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b() {}
  
  public void b(MiniAppInfo paramMiniAppInfo)
  {
    c(paramMiniAppInfo);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView != null) {
        break label89;
      }
      this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView = new MiniAppMonitorInfoView(this.jdField_a_of_type_AndroidAppActivity, null, 1);
      this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView.setMiniAppType(1);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView, localLayoutParams);
      this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView.setVisibility(0);
      this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView.a();
    }
    for (;;)
    {
      return d();
      label89:
      if (this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView.b();
        this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView.a();
        this.jdField_a_of_type_ComTencentQqminiSdkMonitorUiMiniAppMonitorInfoView.setVisibility(0);
      }
    }
  }
  
  public void c()
  {
    e();
    this.jdField_a_of_type_Bdrg.a(this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleView, this.jdField_a_of_type_ComTencentQqminiSdkMinigameUiVConsoleDragView, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdoy
 * JD-Core Version:    0.7.0.1
 */