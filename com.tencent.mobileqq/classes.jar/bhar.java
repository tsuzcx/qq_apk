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

public abstract class bhar
  extends bghl
{
  protected Activity a;
  protected ViewGroup a;
  protected bgjw a;
  protected bhas a;
  protected bhbo a;
  protected bhdj a;
  protected JsPluginEngine a;
  protected MiniAppInfo a;
  protected String a;
  
  public bhar()
  {
    this.jdField_a_of_type_Bhas = new bhas(this);
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
  
  public bghn a()
  {
    return this.jdField_a_of_type_Bhdj;
  }
  
  public bghq a()
  {
    return this.jdField_a_of_type_Bhbo;
  }
  
  public bhas a()
  {
    return this.jdField_a_of_type_Bhas;
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
    return bgrl.a().b().baseLibVersion;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_Bhbo.a() != null)) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Bhbo.a());
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == paramActivity) && (this.jdField_a_of_type_AndroidViewViewGroup == paramViewGroup)) {
      return;
    }
    this.jdField_a_of_type_Bhbo.a(paramActivity);
    if ((this.jdField_a_of_type_Bhbo.a() != null) && (this.jdField_a_of_type_Bhbo.a().getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_Bhbo.a().getParent()).removeView(this.jdField_a_of_type_Bhbo.a());
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramViewGroup.addView(this.jdField_a_of_type_Bhbo.a(), new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void a(bhdj parambhdj)
  {
    Context localContext = AppLoaderFactory.g().getMiniAppEnv().getContext();
    if (parambhdj != null)
    {
      this.jdField_a_of_type_Bhdj = parambhdj;
      int i = this.jdField_a_of_type_Bhdj.a();
      Log.i("BaseAppBrandRuntime", "customJsService " + parambhdj + ",status=" + i);
      if (i != 0) {
        this.jdField_a_of_type_Bhdj = null;
      }
      if (this.jdField_a_of_type_Bhdj != null) {
        this.jdField_a_of_type_Bhdj.a(this.jdField_a_of_type_Bhas);
      }
    }
    if (this.jdField_a_of_type_Bhdj == null) {
      this.jdField_a_of_type_Bhdj = new bhcw(this, this.jdField_a_of_type_Bhas);
    }
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine = new JsPluginEngine(localContext);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if (this.jdField_a_of_type_Bgjw != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    this.jdField_a_of_type_Bgjw = ((bgjw)paramMiniAppInfo.apkgInfo);
    bgjm.a().a(this.jdField_a_of_type_Bgjw, false);
    this.jdField_a_of_type_JavaLangString = paramString;
    a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, false, null);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bhbo != null) {
      this.jdField_a_of_type_Bhbo.a(paramMiniAppInfo, paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onResume();
    }
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onCreate(this);
    this.jdField_a_of_type_Bhdj.a((bgjw)paramMiniAppInfo.apkgInfo);
    this.jdField_a_of_type_Bhbo.setApkgInfo((bgjw)paramMiniAppInfo.apkgInfo);
    Object localObject = paramMiniAppInfo.launchParam.entryPath;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      if (TextUtils.isEmpty(paramString)) {
        if ((paramMiniAppInfo != null) && (paramMiniAppInfo.apkgInfo != null) && (((bgjw)paramMiniAppInfo.apkgInfo).a != null)) {
          paramMiniAppInfo = ((bgjw)paramMiniAppInfo.apkgInfo).a.entryPagePath;
        }
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_Bhbo;
        if (paramBoolean) {}
        for (paramString = "reLaunch";; paramString = "appLaunch")
        {
          ((bhbo)localObject).a(paramMiniAppInfo, paramString);
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
    if (this.jdField_a_of_type_Bhbo != null) {
      this.jdField_a_of_type_Bhbo.a();
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
    if (this.jdField_a_of_type_Bhbo != null) {
      this.jdField_a_of_type_Bhbo.b();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Bhbo != null) && (this.jdField_a_of_type_Bhbo.a(1, -1));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bhbo != null)
    {
      this.jdField_a_of_type_Bhbo.c();
      this.jdField_a_of_type_Bhbo.a(false);
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhar
 * JD-Core Version:    0.7.0.1
 */