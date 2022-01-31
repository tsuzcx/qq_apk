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

public abstract class bfbi
  extends behn
{
  protected Activity a;
  protected ViewGroup a;
  protected bekp a;
  protected bfbj a;
  protected bfcb a;
  protected bfdt a;
  protected JsPluginEngine a;
  protected MiniAppInfo a;
  protected String a;
  
  public bfbi()
  {
    this.jdField_a_of_type_Bfbj = new bfbj(this);
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
  
  public behp a()
  {
    return this.jdField_a_of_type_Bfdt;
  }
  
  public behs a()
  {
    return this.jdField_a_of_type_Bfcb;
  }
  
  public bfbj a()
  {
    return this.jdField_a_of_type_Bfbj;
  }
  
  public JsPluginEngine a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine;
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
    return bete.a().b().baseLibVersion;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_Bfcb.a() != null)) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_Bfcb.a());
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == paramActivity) && (this.jdField_a_of_type_AndroidViewViewGroup == paramViewGroup)) {
      return;
    }
    this.jdField_a_of_type_Bfcb.a(paramActivity);
    if ((this.jdField_a_of_type_Bfcb.a() != null) && (this.jdField_a_of_type_Bfcb.a().getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_Bfcb.a().getParent()).removeView(this.jdField_a_of_type_Bfcb.a());
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramViewGroup.addView(this.jdField_a_of_type_Bfcb.a(), new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void a(bfdt parambfdt)
  {
    Context localContext = MiniAppEnv.g().getContext();
    if (parambfdt != null)
    {
      this.jdField_a_of_type_Bfdt = parambfdt;
      int i = this.jdField_a_of_type_Bfdt.a();
      Log.i("BaseAppBrandRuntime", "customJsService " + parambfdt + ",status=" + i);
      if (i != 0) {
        this.jdField_a_of_type_Bfdt = null;
      }
      if (this.jdField_a_of_type_Bfdt != null) {
        this.jdField_a_of_type_Bfdt.a(this.jdField_a_of_type_Bfbj);
      }
    }
    if (this.jdField_a_of_type_Bfdt == null) {
      this.jdField_a_of_type_Bfdt = new bfdg(this, this.jdField_a_of_type_Bfbj);
    }
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine = new JsPluginEngine(localContext);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    if (this.jdField_a_of_type_Bekp != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    this.jdField_a_of_type_Bekp = ((bekp)paramMiniAppInfo.apkgInfo);
    bejl.a().a(this.jdField_a_of_type_Bekp, false);
    this.jdField_a_of_type_JavaLangString = paramString;
    b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, false);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bfcb != null) {
      this.jdField_a_of_type_Bfcb.a(paramMiniAppInfo, paramBoolean);
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
    this.jdField_a_of_type_Bfdt.a((bekp)paramMiniAppInfo.apkgInfo);
    this.jdField_a_of_type_Bfcb.setApkgInfo((bekp)paramMiniAppInfo.apkgInfo);
    Object localObject2 = paramMiniAppInfo.launchParam.c;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((bekp)paramMiniAppInfo.apkgInfo).a.jdField_a_of_type_JavaLangString;
    }
    localObject2 = this.jdField_a_of_type_Bfcb;
    if (paramBoolean) {}
    for (paramMiniAppInfo = "reLaunch";; paramMiniAppInfo = "appLaunch")
    {
      ((bfcb)localObject2).a((String)localObject1, paramMiniAppInfo);
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bfcb != null) {
      this.jdField_a_of_type_Bfcb.a();
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
    if (this.jdField_a_of_type_Bfcb != null) {
      this.jdField_a_of_type_Bfcb.b();
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bfcb != null)
    {
      this.jdField_a_of_type_Bfcb.c();
      this.jdField_a_of_type_Bfcb.a(false);
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
    return (this.jdField_a_of_type_Bfcb != null) && (this.jdField_a_of_type_Bfcb.a(1, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbi
 * JD-Core Version:    0.7.0.1
 */