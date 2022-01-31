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

public class bhch
  implements bhbo
{
  private int jdField_a_of_type_Int;
  private bgho jdField_a_of_type_Bgho;
  private bgjw jdField_a_of_type_Bgjw;
  private bgnf jdField_a_of_type_Bgnf;
  private bgnw jdField_a_of_type_Bgnw;
  private bhas jdField_a_of_type_Bhas;
  private bheq jdField_a_of_type_Bheq;
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
  
  public bhch(bgho parambgho, bhas parambhas)
  {
    this.jdField_a_of_type_Bgho = parambgho;
    this.jdField_a_of_type_Bhas = parambhas;
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
    while (this.jdField_a_of_type_Bgjw == null) {
      return;
    }
    if (this.c) {}
    for (String str = "1";; str = "0")
    {
      bgxl.a(215, str, this.jdField_a_of_type_Bgho.a());
      str = QUAUtil.getWebViewUA() + " tissue";
      HashMap localHashMap = new HashMap();
      localHashMap.put("apkgUnpackPath", this.jdField_a_of_type_Bgjw.apkgFolderPath);
      localHashMap.put("appName", "search_result");
      localHashMap.put("pagePath", this.jdField_a_of_type_Bheq.a());
      localHashMap.put("query", this.jdField_a_of_type_Bheq.a());
      localHashMap.put("jssdkPath", AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().getBaselib().miniappWebviewStr);
      localHashMap.put("launchParams", bgkz.a(bgkz.a(this.jdField_a_of_type_JavaLangString)));
      localHashMap.put("logLevel", Integer.valueOf(6 - QMLog.getLogLevel()));
      localHashMap.put("customUserAgent", str);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_Bgho != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Bgho.a() != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Bgho.a().appMode != null) {
            bool1 = this.jdField_a_of_type_Bgho.a().appMode.closeTopRightCapsule;
          }
        }
      }
      localHashMap.put("topRightBtnHidden", Boolean.valueOf(bool1));
      QMLog.w("miniapp-start-TISSUE", "systemUA" + str);
      QMLog.w("miniapp-start-TISSUE", " miniapp launch" + this.jdField_a_of_type_Bgjw.appId);
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
  
  public bgjy a(int paramInt)
  {
    bgka localbgka = new bgka();
    Object localObject;
    if (this.jdField_a_of_type_Bheq != null)
    {
      localObject = this.jdField_a_of_type_Bheq.b();
      localObject = localbgka.a((String)localObject);
      if (this.jdField_a_of_type_IoFlutterViewFlutterView == null) {
        break label58;
      }
    }
    label58:
    for (paramInt = this.jdField_a_of_type_IoFlutterViewFlutterView.getHeight();; paramInt = 0)
    {
      return ((bgka)localObject).c(paramInt).a();
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
  
  public String a(bgid parambgid)
  {
    QMLog.d("miniapp-TISSUE", parambgid.jdField_a_of_type_JavaLangString + ": " + parambgid.b);
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel != null) {
      d("appDidDisappear");
    }
    if (this.jdField_a_of_type_Bhas != null) {
      this.jdField_a_of_type_Bhas.a("onAppEnterBackground", "{}", 0);
    }
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null) {
      this.jdField_a_of_type_IoFlutterViewFlutterView.onPause();
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "showToastView toastView=" + this.jdField_a_of_type_Bgnw);
    }
    if (this.jdField_a_of_type_Bgho.a() == null)
    {
      QMLog.w("TissueRenderer", "Failed to showToastView, activity is null");
      return;
    }
    if ((paramInt1 == 1) || ((paramInt1 == 0) && ("loading".equals(paramString1))))
    {
      if (this.jdField_a_of_type_Bgnw == null) {
        this.jdField_a_of_type_Bgnw = new bgnw(this.jdField_a_of_type_Bgho.a(), (ViewGroup)this.jdField_a_of_type_Bgho.a().findViewById(16908290));
      }
      this.jdField_a_of_type_Bgnw.a(paramInt1, paramString1, paramString2, paramCharSequence, paramInt2, paramBoolean);
      return;
    }
    for (;;)
    {
      bgnf localbgnf;
      try
      {
        localbgnf = new bgnf(this.jdField_a_of_type_Bgho.a());
        if (!TextUtils.isEmpty(paramString2))
        {
          localbgnf.a(new BitmapDrawable(paramString2));
          localbgnf.a(paramCharSequence);
          localbgnf.c(paramInt2);
          localbgnf.a();
          this.jdField_a_of_type_Bgnf = localbgnf;
          return;
        }
      }
      catch (Throwable paramString1)
      {
        QMLog.e("TissueRenderer", "showToastView error.", paramString1);
        return;
      }
      if ("none".equals(paramString1)) {
        localbgnf.b(-1);
      } else {
        localbgnf.a(bgnw.a(paramString1));
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    QMLog.w("miniapp-start-TISSUE", "flutterView start run" + System.currentTimeMillis());
    bgxl.a(212, "", this.jdField_a_of_type_Bgho.a());
    FlutterMain.setNativeLibDir(TissueGlobal.tissueEnv.getNativeLibDir());
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null) {
      return;
    }
    QMLog.w("miniapp-start-TISSUE", "start create flutterView " + System.currentTimeMillis());
    this.jdField_a_of_type_IoFlutterViewFlutterView = bhcf.a(paramActivity, "", this.jdField_a_of_type_IoFlutterViewFlutterNativeView);
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel = new MethodChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "flutter_method_channel");
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel.setMethodCallHandler(new bhci(this));
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel = new BasicMessageChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "com.tencent.tissue/basic_channel", StandardMessageCodec.INSTANCE);
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel.setMessageHandler(new bhcj(this));
    new BasicMessageChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "com.tencent.tissue/log_channel", BinaryCodec.INSTANCE).setMessageHandler(new bhck(this));
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments = new FlutterRunArguments();
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments.bundlePath = FlutterMain.findAppBundlePath();
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments.entrypoint = "main";
    this.jdField_a_of_type_IoFlutterViewFlutterView.runFromBundle(this.jdField_a_of_type_IoFlutterViewFlutterRunArguments);
    QflutterLogPlugin.setLog(new bhcl(this));
    bhdn.a(this.jdField_a_of_type_IoFlutterViewFlutterView.getPluginRegistry());
    this.jdField_a_of_type_IoFlutterViewFlutterView.onStart();
    this.jdField_a_of_type_IoFlutterViewFlutterView.onPostResume();
    QMLog.w("miniapp-start-TISSUE", "flutterView run end" + System.currentTimeMillis());
    bgxl.a(213, "", this.jdField_a_of_type_Bgho.a());
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
    if ((paramBoolean) && (this.jdField_a_of_type_Bhas != null) && (this.jdField_a_of_type_Bhas.a()) && (!TextUtils.isEmpty(paramMiniAppInfo.launchParam.entryPath)))
    {
      str = paramMiniAppInfo.launchParam.entryPath;
      this.jdField_a_of_type_Bhas.a(paramMiniAppInfo.launchParam.entryPath);
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      if ((this.jdField_a_of_type_Bhas != null) && (this.jdField_a_of_type_Bhas.a()) && (!TextUtils.isEmpty(str))) {
        paramMiniAppInfo = bgkl.a(str, paramMiniAppInfo);
      }
      try
      {
        paramMiniAppInfo.put("reLaunch", paramBoolean);
        QMLog.i("TissueRenderer", "appLaunchInfo : " + paramMiniAppInfo.toString());
        this.jdField_a_of_type_Bhas.a("onAppEnterForeground", paramMiniAppInfo.toString(), 0);
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
    Object localObject = new bheq(paramString);
    paramString = ((bheq)localObject).a();
    localObject = ((bheq)localObject).a();
    this.jdField_a_of_type_Int += 1;
    a("navigateTo", new TissuePageContainer.5(this, paramString, (Map)localObject, paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bheq = new bheq(paramString1);
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
      a("operateVideoPlayer", bgkz.a(bgkz.a(paramString2)));
      return;
    }
    for (;;)
    {
      try
      {
        localObject = bgkz.a(paramString2);
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
      localObject = bgkz.a((JSONObject)localObject);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    MiniAppInfo localMiniAppInfo;
    if (this.jdField_a_of_type_Bgho != null)
    {
      localMiniAppInfo = this.jdField_a_of_type_Bgho.a();
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
      QMLog.d("TissueRenderer", "updateToastMsg toastView=" + this.jdField_a_of_type_Bgnw);
    }
    if (this.jdField_a_of_type_Bgnw == null) {
      return;
    }
    this.jdField_a_of_type_Bgnw.a(paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    paramString = new bheq(paramString);
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
    return ((this.jdField_a_of_type_Bgnw != null) && (this.jdField_a_of_type_Bgnw.a())) || (this.jdField_a_of_type_Bgnf != null);
  }
  
  public void d()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TissueRenderer", "hideToastView toastView=" + this.jdField_a_of_type_Bgnw);
    }
    if (this.jdField_a_of_type_Bgnw != null)
    {
      this.jdField_a_of_type_Bgnw.a();
      this.jdField_a_of_type_Bgnw = null;
    }
    if (this.jdField_a_of_type_Bgnf != null)
    {
      this.jdField_a_of_type_Bgnf.a();
      this.jdField_a_of_type_Bgnf = null;
    }
  }
  
  public void setApkgInfo(bgjw parambgjw)
  {
    this.jdField_a_of_type_Bgjw = parambgjw;
  }
  
  public void setNaviVisibility(int paramInt) {}
  
  public void setTabBarVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhch
 * JD-Core Version:    0.7.0.1
 */