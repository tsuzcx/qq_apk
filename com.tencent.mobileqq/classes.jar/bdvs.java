import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.core.page.tissue.TissuePageContainer.4;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterRunArguments;
import io.flutter.view.FlutterView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bdvs
  implements bdvc
{
  private bdcz jdField_a_of_type_Bdcz;
  private bdfx jdField_a_of_type_Bdfx;
  private bdvf jdField_a_of_type_Bdvf;
  public BasicMessageChannel a;
  MethodChannel jdField_a_of_type_IoFlutterPluginCommonMethodChannel;
  private FlutterNativeView jdField_a_of_type_IoFlutterViewFlutterNativeView;
  private FlutterRunArguments jdField_a_of_type_IoFlutterViewFlutterRunArguments;
  private FlutterView jdField_a_of_type_IoFlutterViewFlutterView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public bdvs(bdcz parambdcz, bdvf parambdvf)
  {
    this.jdField_a_of_type_Bdcz = parambdcz;
    this.jdField_a_of_type_Bdvf = parambdvf;
  }
  
  private void a(String paramString, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appPtr", Integer.valueOf(2333));
    localHashMap.put("method", paramString);
    localHashMap.put("data", paramMap);
    bdew.c().post(new TissuePageContainer.4(this, localHashMap));
  }
  
  private void d()
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {}
    while (this.jdField_a_of_type_Bdfx == null) {
      return;
    }
    if (this.c) {}
    for (Object localObject = "1";; localObject = "0")
    {
      bdsc.a(215, (String)localObject, this.jdField_a_of_type_Bdcz.a());
      localObject = new HashMap();
      ((Map)localObject).put("apkgUnpackPath", this.jdField_a_of_type_Bdfx.jdField_a_of_type_JavaLangString);
      ((Map)localObject).put("appName", "search_result");
      ((Map)localObject).put("query", new HashMap());
      ((Map)localObject).put("launchParams", bdgq.a(bdgq.a(this.jdField_a_of_type_JavaLangString)));
      ((Map)localObject).put("logLevel", Integer.valueOf(6 - bdnw.a()));
      bdnw.c("miniapp-start-TISSUE", " miniapp launch" + this.jdField_a_of_type_Bdfx.d);
      a("appLaunch", (Map)localObject);
      return;
    }
  }
  
  private void d(String paramString)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Boolean) {
      this.c = true;
    }
    d();
  }
  
  private void e(String paramString)
  {
    a(paramString, new HashMap());
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
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(bdfs parambdfs)
  {
    bdnw.a("miniapp-TISSUE", parambdfs.jdField_a_of_type_JavaLangString + ": " + parambdfs.jdField_b_of_type_JavaLangString);
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel != null) {
      e("appDidDisappear");
    }
  }
  
  public void a(Activity paramActivity)
  {
    bdnw.c("miniapp-start-TISSUE", "flutterView start run" + System.currentTimeMillis());
    bdsc.a(212, "", this.jdField_a_of_type_Bdcz.a());
    FlutterMain.setNativeLibDir(bdgd.a.getNativeLibDir());
    if (this.jdField_a_of_type_IoFlutterViewFlutterView != null) {
      return;
    }
    bdnw.c("miniapp-start-TISSUE", "start create flutterView " + System.currentTimeMillis());
    this.jdField_a_of_type_IoFlutterViewFlutterView = bdvq.a(paramActivity, "", this.jdField_a_of_type_IoFlutterViewFlutterNativeView);
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel = new MethodChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "flutter_method_channel");
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel.setMethodCallHandler(new bdvt(this));
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel = new BasicMessageChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "com.tencent.tissue/basic_channel", StandardMessageCodec.INSTANCE);
    this.jdField_a_of_type_IoFlutterPluginCommonBasicMessageChannel.setMessageHandler(new bdvu(this));
    new BasicMessageChannel(this.jdField_a_of_type_IoFlutterViewFlutterView, "com.tencent.tissue/log_channel", BinaryCodec.INSTANCE).setMessageHandler(new bdvv(this));
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments = new FlutterRunArguments();
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments.bundlePath = FlutterMain.findAppBundlePath();
    this.jdField_a_of_type_IoFlutterViewFlutterRunArguments.entrypoint = "main";
    this.jdField_a_of_type_IoFlutterViewFlutterView.runFromBundle(this.jdField_a_of_type_IoFlutterViewFlutterRunArguments);
    GeneratedPluginRegistrant.registerWith(this.jdField_a_of_type_IoFlutterViewFlutterView.getPluginRegistry());
    this.jdField_a_of_type_IoFlutterViewFlutterView.onStart();
    this.jdField_a_of_type_IoFlutterViewFlutterView.onPostResume();
    bdnw.c("miniapp-start-TISSUE", "flutterView run end" + System.currentTimeMillis());
    bdsc.a(213, "", this.jdField_a_of_type_Bdcz.a());
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean) {}
  
  public void a(FlutterNativeView paramFlutterNativeView)
  {
    this.jdField_a_of_type_IoFlutterViewFlutterNativeView = paramFlutterNativeView;
  }
  
  public void a(Object paramObject) {}
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ("flutter_launch".equals(paramString1))
    {
      bdnw.a("miniapp-TISSUE", " app service load done");
      d(paramString2);
      return;
    }
    for (;;)
    {
      try
      {
        localObject = bdgq.a(paramString2);
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
        bdnw.d("miniapp-TISSUE", "", paramArrayOfInt);
        continue;
      }
      bdnw.a("miniapp-TISSUE", paramString1 + ": " + paramString2);
      return;
      localObject = bdgq.a((JSONObject)localObject);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c() {}
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setApkgInfo(bdfx parambdfx)
  {
    this.jdField_a_of_type_Bdfx = parambdfx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdvs
 * JD-Core Version:    0.7.0.1
 */