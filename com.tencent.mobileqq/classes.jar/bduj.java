import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class bduj
  extends bdcw
{
  protected Activity a;
  protected ViewGroup a;
  protected bdfx a;
  protected bduk a;
  protected bdvc a;
  protected bdwp a;
  protected JsPluginEngine a;
  protected MiniAppInfo a;
  protected String a;
  
  public bduj()
  {
    this.jdField_a_of_type_Bduk = new bduk(this);
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
    return MiniAppEnv.g().getContext();
  }
  
  public bdcy a()
  {
    return this.jdField_a_of_type_Bdwp;
  }
  
  public bdda a()
  {
    return this.jdField_a_of_type_Bdvc;
  }
  
  public bduk a()
  {
    return this.jdField_a_of_type_Bduk;
  }
  
  public CapsuleButton a()
  {
    return null;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  public String a()
  {
    return bdoa.a().b().baseLibVersion;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_Bdvc.a() != null)) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Bdvc.a());
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == paramActivity) && (this.jdField_a_of_type_AndroidViewViewGroup == paramViewGroup)) {
      return;
    }
    this.jdField_a_of_type_Bdvc.a(paramActivity);
    if ((this.jdField_a_of_type_Bdvc.a() != null) && (this.jdField_a_of_type_Bdvc.a().getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_Bdvc.a().getParent()).removeView(this.jdField_a_of_type_Bdvc.a());
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramViewGroup.addView(this.jdField_a_of_type_Bdvc.a(), new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void a(bdwp parambdwp)
  {
    Context localContext = MiniAppEnv.g().getContext();
    if (parambdwp != null)
    {
      this.jdField_a_of_type_Bdwp = parambdwp;
      int i = this.jdField_a_of_type_Bdwp.a();
      Log.i("BaseAppBrandRuntime", "customJsService " + parambdwp + ",status=" + i);
      if (i != 0) {
        this.jdField_a_of_type_Bdwp = null;
      }
      if (this.jdField_a_of_type_Bdwp != null) {
        this.jdField_a_of_type_Bdwp.a(this.jdField_a_of_type_Bduk);
      }
    }
    if (this.jdField_a_of_type_Bdwp == null) {
      this.jdField_a_of_type_Bdwp = new bdwg(this, this.jdField_a_of_type_Bduk);
    }
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine = new JsPluginEngine(localContext);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if (this.jdField_a_of_type_Bdfx != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    this.jdField_a_of_type_Bdfx = ((bdfx)paramMiniAppInfo.apkgInfo);
    bdeu.a().a(this.jdField_a_of_type_Bdfx);
    this.jdField_a_of_type_JavaLangString = paramString;
    b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, false);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bdvc != null) {
      this.jdField_a_of_type_Bdvc.a(paramMiniAppInfo, paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onResume();
    }
  }
  
  public byte[] a(int paramInt)
  {
    return new byte[0];
  }
  
  public void b(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onCreate(this);
    this.jdField_a_of_type_Bdwp.a((bdfx)paramMiniAppInfo.apkgInfo);
    this.jdField_a_of_type_Bdvc.setApkgInfo((bdfx)paramMiniAppInfo.apkgInfo);
    Object localObject2 = paramMiniAppInfo.launchParam.c;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((bdfx)paramMiniAppInfo.apkgInfo).a.jdField_a_of_type_JavaLangString;
    }
    localObject2 = this.jdField_a_of_type_Bdvc;
    if (paramBoolean) {}
    for (paramMiniAppInfo = "reLaunch";; paramMiniAppInfo = "appLaunch")
    {
      ((bdvc)localObject2).a((String)localObject1, paramMiniAppInfo);
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bdvc != null) {
      this.jdField_a_of_type_Bdvc.a();
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
    if (this.jdField_a_of_type_Bdvc != null) {
      this.jdField_a_of_type_Bdvc.b();
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bdvc != null)
    {
      this.jdField_a_of_type_Bdvc.c();
      this.jdField_a_of_type_Bdvc.a(false);
    }
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onDestroy();
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public boolean f()
  {
    return false;
  }
  
  public boolean g()
  {
    return (this.jdField_a_of_type_Bdvc != null) && (this.jdField_a_of_type_Bdvc.a(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bduj
 * JD-Core Version:    0.7.0.1
 */