import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;

public abstract class bhey
  extends bgls
{
  protected Activity a;
  protected ViewGroup a;
  protected bgod a;
  protected bhez a;
  protected bhfv a;
  protected bhhq a;
  protected JsPluginEngine a;
  protected MiniAppInfo a;
  protected String a;
  
  public bhey()
  {
    this.jdField_a_of_type_Bhez = new bhez(this);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public Context a()
  {
    return AppLoaderFactory.g().getMiniAppEnv().getContext();
  }
  
  public bglu a()
  {
    return this.jdField_a_of_type_Bhhq;
  }
  
  public bglx a()
  {
    return this.jdField_a_of_type_Bhfv;
  }
  
  public bhez a()
  {
    return this.jdField_a_of_type_Bhez;
  }
  
  public JsPluginEngine a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public ShareState a()
  {
    return null;
  }
  
  public String a()
  {
    return bgvs.a().b().baseLibVersion;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_Bhfv.a() != null)) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Bhfv.a());
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == paramActivity) && (this.jdField_a_of_type_AndroidViewViewGroup == paramViewGroup)) {
      return;
    }
    this.jdField_a_of_type_Bhfv.a(paramActivity);
    if ((this.jdField_a_of_type_Bhfv.a() != null) && (this.jdField_a_of_type_Bhfv.a().getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_Bhfv.a().getParent()).removeView(this.jdField_a_of_type_Bhfv.a());
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramViewGroup.addView(this.jdField_a_of_type_Bhfv.a(), new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void a(bhhq parambhhq)
  {
    Context localContext = AppLoaderFactory.g().getMiniAppEnv().getContext();
    if (parambhhq != null)
    {
      this.jdField_a_of_type_Bhhq = parambhhq;
      int i = this.jdField_a_of_type_Bhhq.a();
      Log.i("BaseAppBrandRuntime", "customJsService " + parambhhq + ",status=" + i);
      if (i != 0) {
        this.jdField_a_of_type_Bhhq = null;
      }
      if (this.jdField_a_of_type_Bhhq != null) {
        this.jdField_a_of_type_Bhhq.a(this.jdField_a_of_type_Bhez);
      }
    }
    if (this.jdField_a_of_type_Bhhq == null) {
      this.jdField_a_of_type_Bhhq = new bhhd(this, this.jdField_a_of_type_Bhez);
    }
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine = new JsPluginEngine(localContext);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if (this.jdField_a_of_type_Bgod != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    this.jdField_a_of_type_Bgod = ((bgod)paramMiniAppInfo.apkgInfo);
    bgnt.a().a(this.jdField_a_of_type_Bgod, false);
    this.jdField_a_of_type_JavaLangString = paramString;
    a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, false, null);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bhfv != null) {
      this.jdField_a_of_type_Bhfv.a(paramMiniAppInfo, paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onResume();
    }
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onCreate(this);
    this.jdField_a_of_type_Bhhq.a((bgod)paramMiniAppInfo.apkgInfo);
    this.jdField_a_of_type_Bhfv.setApkgInfo((bgod)paramMiniAppInfo.apkgInfo);
    Object localObject = paramMiniAppInfo.launchParam.entryPath;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      if (TextUtils.isEmpty(paramString)) {
        if ((paramMiniAppInfo != null) && (paramMiniAppInfo.apkgInfo != null) && (((bgod)paramMiniAppInfo.apkgInfo).a != null)) {
          paramMiniAppInfo = ((bgod)paramMiniAppInfo.apkgInfo).a.entryPagePath;
        }
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_Bhfv;
        if (paramBoolean) {}
        for (paramString = "reLaunch";; paramString = "appLaunch")
        {
          ((bhfv)localObject).a(paramMiniAppInfo, paramString);
          return;
          paramMiniAppInfo = null;
          break;
        }
        paramMiniAppInfo = paramString;
      }
      paramString = (String)localObject;
    }
  }
  
  public byte[] a(int paramInt)
  {
    return new byte[0];
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bhfv != null) {
      this.jdField_a_of_type_Bhfv.a();
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onPause();
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bhfv != null) {
      this.jdField_a_of_type_Bhfv.b();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Bhfv != null) && (this.jdField_a_of_type_Bhfv.a(1, -1));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bhfv != null)
    {
      this.jdField_a_of_type_Bhfv.c();
      this.jdField_a_of_type_Bhfv.a(false);
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhey
 * JD-Core Version:    0.7.0.1
 */