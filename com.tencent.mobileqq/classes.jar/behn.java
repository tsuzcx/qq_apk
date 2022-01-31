import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class behn
  implements behq, beht
{
  protected beho a;
  protected besl a;
  
  public int a()
  {
    return 0;
  }
  
  public abstract behp a();
  
  public abstract behs a();
  
  public besl a()
  {
    return this.jdField_a_of_type_Besl;
  }
  
  public abstract IJsPluginEngine a();
  
  public abstract CapsuleButton a();
  
  public Object a(bekl parambekl)
  {
    if (parambekl != null) {
      return parambekl.a(this);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Beho != null) {
      this.jdField_a_of_type_Beho.onRuntimeMessage(paramInt, paramObject);
    }
  }
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(Activity paramActivity, ViewGroup paramViewGroup);
  
  public void a(beho parambeho)
  {
    this.jdField_a_of_type_Beho = parambeho;
  }
  
  public abstract void a(MiniAppInfo paramMiniAppInfo, String paramString);
  
  public void a(boolean paramBoolean)
  {
    MiniAppInfo localMiniAppInfo = a();
    if (localMiniAppInfo == null) {
      return;
    }
    bfhm.a().edit().putBoolean(localMiniAppInfo.appId + "_debug", paramBoolean).apply();
  }
  
  public boolean a()
  {
    MiniAppInfo localMiniAppInfo = a();
    if (localMiniAppInfo == null) {
      return false;
    }
    return bfhm.a().getBoolean(localMiniAppInfo.appId + "_debug", false);
  }
  
  public void b() {}
  
  public boolean b()
  {
    return false;
  }
  
  public abstract boolean c();
  
  public abstract boolean d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     behn
 * JD-Core Version:    0.7.0.1
 */