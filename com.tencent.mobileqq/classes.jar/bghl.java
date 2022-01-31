import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;

public abstract class bghl
  implements bgho, bghs
{
  protected bghm a;
  protected bght a;
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public abstract bghn a();
  
  public abstract bghq a();
  
  public abstract IJsPluginEngine a();
  
  public abstract ShareState a();
  
  public Object a(bghv parambghv)
  {
    if (parambghv != null) {
      return parambghv.perform(this);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Bghm != null) {
      this.jdField_a_of_type_Bghm.onRuntimeMessage(paramInt, paramObject);
    }
  }
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(Activity paramActivity, ViewGroup paramViewGroup);
  
  public void a(bghm parambghm)
  {
    this.jdField_a_of_type_Bghm = parambghm;
  }
  
  public void a(bght parambght)
  {
    this.jdField_a_of_type_Bght = parambght;
  }
  
  public void a(bgib parambgib) {}
  
  public abstract void a(MiniAppInfo paramMiniAppInfo, String paramString);
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bghl
 * JD-Core Version:    0.7.0.1
 */