import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class begw
  implements begz, behc
{
  protected begx a;
  protected beru a;
  
  public int a()
  {
    return 0;
  }
  
  public abstract begy a();
  
  public abstract behb a();
  
  public beru a()
  {
    return this.jdField_a_of_type_Beru;
  }
  
  public abstract IJsPluginEngine a();
  
  public abstract CapsuleButton a();
  
  public Object a(beju parambeju)
  {
    if (parambeju != null) {
      return parambeju.a(this);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Begx != null) {
      this.jdField_a_of_type_Begx.onRuntimeMessage(paramInt, paramObject);
    }
  }
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(Activity paramActivity, ViewGroup paramViewGroup);
  
  public void a(begx parambegx)
  {
    this.jdField_a_of_type_Begx = parambegx;
  }
  
  public abstract void a(MiniAppInfo paramMiniAppInfo, String paramString);
  
  public void a(boolean paramBoolean)
  {
    MiniAppInfo localMiniAppInfo = a();
    if (localMiniAppInfo == null) {
      return;
    }
    bfgv.a().edit().putBoolean(localMiniAppInfo.appId + "_debug", paramBoolean).apply();
  }
  
  public boolean a()
  {
    MiniAppInfo localMiniAppInfo = a();
    if (localMiniAppInfo == null) {
      return false;
    }
    return bfgv.a().getBoolean(localMiniAppInfo.appId + "_debug", false);
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
 * Qualified Name:     begw
 * JD-Core Version:    0.7.0.1
 */