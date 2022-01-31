import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.qflutter.log.qflutter_log.QflutterLogPlugin;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.core.page.tissue.TissuePageContainer.5;
import com.tencent.qqmini.sdk.runtime.core.page.tissue.TissuePageContainer.6;
import com.tencent.qqmini.sdk.runtime.core.page.tissue.TissuePageContainer.7;
import com.tencent.qqmini.sdk.runtime.core.page.tissue.TissuePageContainer.8;
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

public class bfca
  implements bfbk
{
  private int jdField_a_of_type_Int;
  private begz jdField_a_of_type_Begz;
  private bejy jdField_a_of_type_Bejy;
  private bfbn jdField_a_of_type_Bfbn;
  private bfdz jdField_a_of_type_Bfdz;
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
  
  public bfca(begz parambegz, bfbn parambfbn)
  {
    this.jdField_a_of_type_Begz = parambegz;
    this.jdField_a_of_type_Bfbn = parambfbn;
  }
  
  private void a(String paramString, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appPtr", Integer.valueOf(2333));
    localHashMap.put("method", paramString);
    localHashMap.put("data", paramMap);
    beiw.c().post(new TissuePageContainer.8(this, localHashMap));
  }
  
  private void b(String paramString)
  {
    this.b = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Boolean) {
      this.c = true;
    }
    d();
  }
  
  private void c(String paramString)
  {
    a(paramString, new HashMap());
  }
  
  private void d()
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.b)) {}
    while (this.jdField_a_of_type_Bejy == null) {
      return;
    }
    if (this.c) {}
    for (String str = "1";; str = "0")
    {
      bexz.a(215, str, this.jdField_a_of_type_Begz.a());
      str = bfgt.d();
      HashMap localHashMap = new HashMap();
      localHashMap.put("apkgUnpackPath", this.jdField_a_of_type_Bejy.jdField_a_of_type_JavaLangString);
      localHashMap.put("appName", "search_result");
      localHashMap.put("pagePath", this.jdField_a_of_type_Bfdz.a());
      localHashMap.put("query", this.jdField_a_of_type_Bfdz.a());
      localHashMap.put("jssdkPath", MiniAppEnv.g().getBaselibLoader().getBaselib().e);
      localHashMap.put("launchParams", beks.a(beks.a(this.jdField_a_of_type_JavaLangString)));
      localHashMap.put("logLevel", Integer.valueOf(6 - besl.a()));
      localHashMap.put("customUserAgent", str);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_Begz != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Begz.a() != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Begz.a().appMode != null) {
            bool1 = this.jdField_a_of_type_Begz.a().appMode.d;
          }
        }
      }
      localHashMap.put("topRightBtnHidden", Boolean.valueOf(bool1));
      besl.c("miniapp-start-TISSUE", "systemUA" + str);
      besl.c("miniapp-start-TISSUE", " miniapp launch" + this.jdField_a_of_type_Bejy.d);
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
  
  public String a()
  {
    if (this.jdField_a_of_type_Bfdz != null) {
      return this.jdField_a_of_type_Bfdz.b();
    }
    return null;
  }
  
  public String a(bejs parambejs)
  {
    besl.a("miniapp-TISSUE", parambejs.jdField_a_of_type_JavaLangString + ": " + parambejs.b);
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel != null) {
      c("appDidDisappear");
    }
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null) {
      this.jdField_a_of_type_IoFlutterViewFlutterView.onPause();
    }
  }
  
  public void a(Activity paramActivity)
  {
    besl.c("miniapp-start-TISSUE", "flutterView start run" + System.currentTimeMillis());
    bexz.a(212, "", this.jdField_a_of_type_Begz.a());
    FlutterMain.setNativeLibDir(bekd.a.getNativeLibDir());
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null) {
      return;
    }
    besl.c("miniapp-start-TISSUE", "start create flutterView " + System.currentTimeMillis());
    this.jdField_a_of_type_IoFlutterViewFlutterView = bfby.a(paramActivity, "", this.jdField_a_of_type_IoFlutterViewFlutterNativeView);
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel = new MethodChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "flutter_method_channel");
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel.setMethodCallHandler(new bfcb(this));
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel = new BasicMessageChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "com.tencent.tissue/basic_channel", StandardMessageCodec.INSTANCE);
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel.setMessageHandler(new bfcc(this));
    new BasicMessageChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "com.tencent.tissue/log_channel", BinaryCodec.INSTANCE).setMessageHandler(new bfcd(this));
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments = new FlutterRunArguments();
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments.bundlePath = FlutterMain.findAppBundlePath();
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments.entrypoint = "main";
    this.jdField_a_of_type_IoFlutterViewFlutterView.runFromBundle(this.jdField_a_of_type_IoFlutterViewFlutterRunArguments);
    QflutterLogPlugin.setLog(new bfce(this));
    bfdh.a(this.jdField_a_of_type_IoFlutterViewFlutterView.getPluginRegistry());
    this.jdField_a_of_type_IoFlutterViewFlutterView.onStart();
    this.jdField_a_of_type_IoFlutterViewFlutterView.onPostResume();
    besl.c("miniapp-start-TISSUE", "flutterView run end" + System.currentTimeMillis());
    bexz.a(213, "", this.jdField_a_of_type_Begz.a());
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null)
    {
      if (this.e) {
        this.jdField_a_of_type_IoFlutterViewFlutterView.onPostResume();
      }
      this.e = true;
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
    Object localObject = new bfdz(paramString);
    paramString = ((bfdz)localObject).a();
    localObject = ((bfdz)localObject).a();
    this.jdField_a_of_type_Int += 1;
    a("navigateTo", new TissuePageContainer.5(this, paramString, (Map)localObject, paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bfdz = new bfdz(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ("flutter_launch".equals(paramString1))
    {
      besl.a("miniapp-TISSUE", " app service load done");
      b(paramString2);
      return;
    }
    for (;;)
    {
      try
      {
        localObject = beks.a(paramString2);
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
        besl.d("miniapp-TISSUE", "", paramArrayOfInt);
        continue;
      }
      besl.a("miniapp-TISSUE", paramString1 + ": " + paramString2);
      return;
      localObject = beks.a((JSONObject)localObject);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 0) {
      return false;
    }
    a("navigateBack", new TissuePageContainer.7(this, paramInt1, paramInt2));
    this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int - paramInt1, 0);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null) {
      this.jdField_a_of_type_IoFlutterViewFlutterView.onStop();
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    paramString = new bfdz(paramString);
    a("redirectTo", new TissuePageContainer.6(this, paramString.a(), paramString.a(), paramInt));
  }
  
  public void c() {}
  
  public void setApkgInfo(bejy parambejy)
  {
    this.jdField_a_of_type_Bejy = parambejy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfca
 * JD-Core Version:    0.7.0.1
 */