import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class bdcw
  implements bdcz, bddb
{
  protected bdcx a;
  protected bdgb a;
  
  public int a()
  {
    return 0;
  }
  
  public abstract bdcy a();
  
  public abstract bdda a();
  
  public bdgb a()
  {
    return this.jdField_a_of_type_Bdgb;
  }
  
  public abstract CapsuleButton a();
  
  public Object a(bdft parambdft)
  {
    if (parambdft != null) {
      return parambdft.a(this);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Bdcx != null) {
      this.jdField_a_of_type_Bdcx.onRuntimeMessage(paramInt, paramObject);
    }
  }
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(Activity paramActivity, ViewGroup paramViewGroup);
  
  public void a(bdcx parambdcx)
  {
    this.jdField_a_of_type_Bdcx = parambdcx;
  }
  
  public abstract void a(MiniAppInfo paramMiniAppInfo, String paramString);
  
  public void a(boolean paramBoolean)
  {
    MiniAppInfo localMiniAppInfo = a();
    if (localMiniAppInfo == null) {
      return;
    }
    bdzf.a().edit().putBoolean(localMiniAppInfo.appId + "_debug", paramBoolean).apply();
  }
  
  public boolean a()
  {
    MiniAppInfo localMiniAppInfo = a();
    if (localMiniAppInfo == null) {
      return false;
    }
    return bdzf.a().getBoolean(localMiniAppInfo.appId + "_debug", false);
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
 * Qualified Name:     bdcw
 * JD-Core Version:    0.7.0.1
 */