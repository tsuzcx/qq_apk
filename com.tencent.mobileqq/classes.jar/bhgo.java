import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.tissue.TissuePageContainer.5;
import com.tencent.qqmini.sdk.runtime.core.page.tissue.TissuePageContainer.6;
import com.tencent.qqmini.sdk.runtime.core.page.tissue.TissuePageContainer.7;
import com.tencent.qqmini.sdk.runtime.core.page.tissue.TissuePageContainer.8;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterRunArguments;
import io.flutter.view.FlutterView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bhgo
  implements bhfv
{
  private int jdField_a_of_type_Int;
  private bglv jdField_a_of_type_Bglv;
  private bgod jdField_a_of_type_Bgod;
  private bgrm jdField_a_of_type_Bgrm;
  private bgsd jdField_a_of_type_Bgsd;
  private bhez jdField_a_of_type_Bhez;
  private bhix jdField_a_of_type_Bhix;
  public BasicMessageChannel a;
  MethodChannel jdField_a_of_type_IoFlutterPluginCommonMethodChannel;
  private FlutterNativeView jdField_a_of_type_IoFlutterViewFlutterNativeView;
  private FlutterRunArguments jdField_a_of_type_IoFlutterViewFlutterRunArguments;
  private FlutterView jdField_a_of_type_IoFlutterViewFlutterView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public bhgo(bglv parambglv, bhez parambhez)
  {
    this.jdField_a_of_type_Bglv = parambglv;
    this.jdField_a_of_type_Bhez = parambhez;
  }
  
  private void a(String paramString, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appPtr", Integer.valueOf(2333));
    localHashMap.put("method", paramString);
    localHashMap.put("data", paramMap);
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel.send(localHashMap);
      return;
    }
    ThreadManager.c().post(new TissuePageContainer.8(this, localHashMap));
  }
  
  private void c(String paramString)
  {
    this.b = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Boolean) {
      this.c = true;
    }
    e();
  }
  
  private void d(String paramString)
  {
    a(paramString, new HashMap());
  }
  
  private void e()
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.b)) {}
    while (this.jdField_a_of_type_Bgod == null) {
      return;
    }
    if (this.c) {}
    for (String str = "1";; str = "0")
    {
      bhbs.a(215, str, this.jdField_a_of_type_Bglv.a());
      str = QUAUtil.getWebViewUA() + " tissue";
      HashMap localHashMap = new HashMap();
      localHashMap.put("apkgUnpackPath", this.jdField_a_of_type_Bgod.apkgFolderPath);
      localHashMap.put("appName", "search_result");
      localHashMap.put("pagePath", this.jdField_a_of_type_Bhix.a());
      localHashMap.put("query", this.jdField_a_of_type_Bhix.a());
      localHashMap.put("jssdkPath", AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().getBaselib().miniappWebviewStr);
      localHashMap.put("launchParams", bgpg.a(bgpg.a(this.jdField_a_of_type_JavaLangString)));
      localHashMap.put("logLevel", Integer.valueOf(6 - QMLog.getLogLevel()));
      localHashMap.put("customUserAgent", str);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_Bglv != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Bglv.a() != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Bglv.a().appMode != null) {
            bool1 = this.jdField_a_of_type_Bglv.a().appMode.closeTopRightCapsule;
          }
        }
      }
      localHashMap.put("topRightBtnHidden", Boolean.valueOf(bool1));
      QMLog.w("miniapp-start-TISSUE", "systemUA" + str);
      QMLog.w("miniapp-start-TISSUE", " miniapp launch" + this.jdField_a_of_type_Bgod.appId);
      a("appLaunch", localHashMap);
      return;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_IoFlutterViewFlutterView;
  }
  
  public bgof a(int paramInt)
  {
    bgoh localbgoh = new bgoh();
    Object localObject;
    if (this.jdField_a_of_type_Bhix != null)
    {
      localObject = this.jdField_a_of_type_Bhix.b();
      localObject = localbgoh.a((String)localObject);
      if (this.jdField_a_of_type_IoFlutterViewFlutterView == null) {
        break label58;
      }
    }
    label58:
    for (paramInt = this.jdField_a_of_type_IoFlutterViewFlutterView.getHeight();; paramInt = 0)
    {
      return ((bgoh)localObject).c(paramInt).a();
      localObject = null;
      break;
    }
  }
  
  public CapsuleButton a()
  {
    return null;
  }
  
  public String a()
  {
    return "";
  }
  
  public String a(bgmk parambgmk)
  {
    QMLog.d("miniapp-TISSUE", parambgmk.jdField_a_of_type_JavaLangString + ": " + parambgmk.b);
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel != null) {
      d("appDidDisappear");
    }
    if (this.jdField_a_of_type_Bhez != null) {
      this.jdField_a_of_type_Bhez.a("onAppEnterBackground", "{}", 0);
    }
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null) {
      this.jdField_a_of_type_IoFlutterViewFlutterView.onPause();
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "showToastView toastView=" + this.jdField_a_of_type_Bgsd);
    }
    if (this.jdField_a_of_type_Bglv.a() == null)
    {
      QMLog.w("TissueRenderer", "Failed to showToastView, activity is null");
      return;
    }
    if ((paramInt1 == 1) || ((paramInt1 == 0) && ("loading".equals(paramString1))))
    {
      if (this.jdField_a_of_type_Bgsd == null) {
        this.jdField_a_of_type_Bgsd = new bgsd(this.jdField_a_of_type_Bglv.a(), (ViewGroup)this.jdField_a_of_type_Bglv.a().findViewById(16908290));
      }
      this.jdField_a_of_type_Bgsd.a(paramInt1, paramString1, paramString2, paramCharSequence, paramInt2, paramBoolean);
      return;
    }
    for (;;)
    {
      bgrm localbgrm;
      try
      {
        localbgrm = new bgrm(this.jdField_a_of_type_Bglv.a());
        if (!TextUtils.isEmpty(paramString2))
        {
          localbgrm.a(new BitmapDrawable(paramString2));
          localbgrm.a(paramCharSequence);
          localbgrm.c(paramInt2);
          localbgrm.a();
          this.jdField_a_of_type_Bgrm = localbgrm;
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QMLog.e("TissueRenderer", "showToastView error.", paramString1);
        return;
      }
      if ("none".equals(paramString1)) {
        localbgrm.b(-1);
      } else {
        localbgrm.a(bgsd.a(paramString1));
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    QMLog.w("miniapp-start-TISSUE", "flutterView start run" + System.currentTimeMillis());
    bhbs.a(212, "", this.jdField_a_of_type_Bglv.a());
    FlutterMain.setNativeLibDir(TissueGlobal.tissueEnv.getNativeLibDir());
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null) {
      return;
    }
    QMLog.w("miniapp-start-TISSUE", "start create flutterView " + System.currentTimeMillis());
    this.jdField_a_of_type_IoFlutterViewFlutterView = bhgm.a(paramActivity, "", this.jdField_a_of_type_IoFlutterViewFlutterNativeView);
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel = new MethodChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "flutter_method_channel");
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel.setMethodCallHandler(new bhgp(this));
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel = new BasicMessageChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "com.tencent.tissue/basic_channel", StandardMessageCodec.INSTANCE);
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel.setMessageHandler(new bhgq(this));
    new BasicMessageChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "com.tencent.tissue/log_channel", BinaryCodec.INSTANCE).setMessageHandler(new bhgr(this));
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments = new FlutterRunArguments();
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments.bundlePath = FlutterMain.findAppBundlePath();
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments.entrypoint = "main";
    this.jdField_a_of_type_IoFlutterViewFlutterView.runFromBundle(this.jdField_a_of_type_IoFlutterViewFlutterRunArguments);
    QflutterLogPlugin.setLog(new bhgs(this));
    bhhu.a(this.jdField_a_of_type_IoFlutterViewFlutterView.getPluginRegistry());
    this.jdField_a_of_type_IoFlutterViewFlutterView.onStart();
    this.jdField_a_of_type_IoFlutterViewFlutterView.onPostResume();
    QMLog.w("miniapp-start-TISSUE", "flutterView run end" + System.currentTimeMillis());
    bhbs.a(213, "", this.jdField_a_of_type_Bglv.a());
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null)
    {
      if (this.e) {
        this.jdField_a_of_type_IoFlutterViewFlutterView.onPostResume();
      }
      this.e = true;
    }
    String str = null;
    if ((paramBoolean) && (this.jdField_a_of_type_Bhez != null) && (this.jdField_a_of_type_Bhez.a()) && (!TextUtils.isEmpty(paramMiniAppInfo.launchParam.entryPath)))
    {
      str = paramMiniAppInfo.launchParam.entryPath;
      this.jdField_a_of_type_Bhez.a(paramMiniAppInfo.launchParam.entryPath);
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      if ((this.jdField_a_of_type_Bhez != null) && (this.jdField_a_of_type_Bhez.a()) && (!TextUtils.isEmpty(str))) {
        paramMiniAppInfo = bgos.a(str, paramMiniAppInfo);
      }
      try
      {
        paramMiniAppInfo.put("reLaunch", paramBoolean);
        QMLog.i("TissueRenderer", "appLaunchInfo : " + paramMiniAppInfo.toString());
        this.jdField_a_of_type_Bhez.a("onAppEnterForeground", paramMiniAppInfo.toString(), 0);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("TissueRenderer", "appLaunchInfo error.", localThrowable);
        }
      }
    }
  }
  
  public void a(FlutterNativeView paramFlutterNativeView)
  {
    this.jdField_a_of_type_IoFlutterViewFlutterNativeView = paramFlutterNativeView;
  }
  
  public void a(Object paramObject) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new bhix(paramString);
    paramString = ((bhix)localObject).a();
    localObject = ((bhix)localObject).a();
    this.jdField_a_of_type_Int += 1;
    a("navigateTo", new TissuePageContainer.5(this, paramString, (Map)localObject, paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bhix = new bhix(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ("flutter_launch".equals(paramString1))
    {
      QMLog.d("miniapp-TISSUE", " app service load done");
      c(paramString2);
      return;
    }
    if ("operateVideoPlayer".equals(paramString1))
    {
      QMLog.d("QFV", " from app-service operateVideoPlayer:" + paramString2);
      a("operateVideoPlayer", bgpg.a(bgpg.a(paramString2)));
      return;
    }
    for (;;)
    {
      try
      {
        localObject = bgpg.a(paramString2);
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", paramString1);
        if (localObject != null) {
          continue;
        }
        localObject = new HashMap();
        localHashMap.put("data", localObject);
        if (paramArrayOfInt != null) {
          localHashMap.put("pageIDs", paramArrayOfInt);
        }
        if (this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel != null) {
          a("publishHandler", localHashMap);
        }
      }
      catch (Exception paramArrayOfInt)
      {
        Object localObject;
        QMLog.e("miniapp-TISSUE", "", paramArrayOfInt);
        continue;
      }
      QMLog.d("miniapp-TISSUE", paramString1 + ": " + paramString2);
      return;
      localObject = bgpg.a((JSONObject)localObject);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    MiniAppInfo localMiniAppInfo;
    if (this.jdField_a_of_type_Bglv != null)
    {
      localMiniAppInfo = this.jdField_a_of_type_Bglv.a();
      if (DebugUtil.getDebugEnabled(localMiniAppInfo)) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      DebugUtil.setDebugEnabled(localMiniAppInfo, bool);
      return bool;
      localMiniAppInfo = null;
      break;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 0) {
      return false;
    }
    a("navigateBack", new TissuePageContainer.7(this, paramInt1, paramInt2));
    this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int - paramInt1, 0);
    return true;
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null) {
      this.jdField_a_of_type_IoFlutterViewFlutterView.onStop();
    }
  }
  
  public void b(String paramString)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "updateToastMsg toastView=" + this.jdField_a_of_type_Bgsd);
    }
    if (this.jdField_a_of_type_Bgsd == null) {
      return;
    }
    this.jdField_a_of_type_Bgsd.a(paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    paramString = new bhix(paramString);
    a("redirectTo", new TissuePageContainer.6(this, paramString.a(), paramString.a(), paramInt));
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return -1;
  }
  
  public void c() {}
  
  public boolean c()
  {
    return ((this.jdField_a_of_type_Bgsd != null) && (this.jdField_a_of_type_Bgsd.a())) || (this.jdField_a_of_type_Bgrm != null);
  }
  
  public void d()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "hideToastView toastView=" + this.jdField_a_of_type_Bgsd);
    }
    if (this.jdField_a_of_type_Bgsd != null)
    {
      this.jdField_a_of_type_Bgsd.a();
      this.jdField_a_of_type_Bgsd = null;
    }
    if (this.jdField_a_of_type_Bgrm != null)
    {
      this.jdField_a_of_type_Bgrm.a();
      this.jdField_a_of_type_Bgrm = null;
    }
  }
  
  public void setApkgInfo(bgod parambgod)
  {
    this.jdField_a_of_type_Bgod = parambgod;
  }
  
  public void setNaviVisibility(int paramInt) {}
  
  public void setTabBarVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgo
 * JD-Core Version:    0.7.0.1
 */