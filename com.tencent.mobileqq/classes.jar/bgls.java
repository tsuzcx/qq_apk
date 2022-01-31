import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;

public abstract class bgls
  implements bglv, bglz
{
  protected bglt a;
  protected bgma a;
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public abstract bglu a();
  
  public abstract bglx a();
  
  public abstract IJsPluginEngine a();
  
  public abstract ShareState a();
  
  public Object a(bgmc parambgmc)
  {
    if (parambgmc != null) {
      return parambgmc.perform(this);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Bglt != null) {
      this.jdField_a_of_type_Bglt.onRuntimeMessage(paramInt, paramObject);
    }
  }
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(Activity paramActivity, ViewGroup paramViewGroup);
  
  public void a(bglt parambglt)
  {
    this.jdField_a_of_type_Bglt = parambglt;
  }
  
  public void a(bgma parambgma)
  {
    this.jdField_a_of_type_Bgma = parambgma;
  }
  
  public void a(bgmi parambgmi) {}
  
  public abstract void a(MiniAppInfo paramMiniAppInfo, String paramString);
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgls
 * JD-Core Version:    0.7.0.1
 */