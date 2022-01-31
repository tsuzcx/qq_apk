import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;
import org.json.JSONObject;

public abstract class bmiv
  implements IEventReceiver
{
  @NonNull
  public final bmix a;
  public bmkf a;
  protected long d;
  public boolean j;
  
  public bmiv(@NonNull bmix parambmix)
  {
    this.jdField_a_of_type_Bmix = parambmix;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bmkf == null) {
      axsh.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  @NonNull
  public Context a()
  {
    d();
    return this.jdField_a_of_type_Bmkf.a();
  }
  
  @NonNull
  public Resources a()
  {
    d();
    return this.jdField_a_of_type_Bmkf.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    d();
    View localView = this.jdField_a_of_type_Bmkf.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public bmiw a(Class<? extends bmiw> paramClass)
  {
    d();
    return this.jdField_a_of_type_Bmix.a(paramClass);
  }
  
  @NonNull
  public bmkf a()
  {
    d();
    return this.jdField_a_of_type_Bmkf;
  }
  
  protected String a(int paramInt)
  {
    d();
    return a().getString(paramInt);
  }
  
  public void a()
  {
    d();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a_(paramInt2, paramObject);
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    a(parambmwn);
  }
  
  public void a(Bundle paramBundle)
  {
    d();
  }
  
  public void a(bmkf parambmkf)
  {
    if (this.jdField_a_of_type_Bmkf != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (parambmkf == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Bmkf = parambmkf;
  }
  
  @Deprecated
  public void a(@NonNull bmwn parambmwn) {}
  
  public void a(Class<? extends bmiw> paramClass, bmiw parambmiw)
  {
    d();
    this.jdField_a_of_type_Bmix.a(paramClass, parambmiw);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public void a(JSONObject paramJSONObject) {}
  
  public boolean a()
  {
    d();
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void aY_() {}
  
  public void aZ_()
  {
    d();
  }
  
  public void a_(int paramInt, Object paramObject) {}
  
  public void al_() {}
  
  public void b(Bundle paramBundle)
  {
    d();
  }
  
  public void b(@NonNull bmwn parambmwn)
  {
    ((blnl)blmf.a(5)).a(this.jdField_a_of_type_Bmkf.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public void bd_()
  {
    d();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Bmix.i();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Bmkf == null) || (this.jdField_a_of_type_Bmkf.getActivity() == null) || (this.jdField_a_of_type_Bmkf.getActivity().isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_Bmkf.getActivity().isDestroyed()));
  }
  
  public void f()
  {
    d();
  }
  
  public void g()
  {
    this.j = true;
    u();
  }
  
  public void i_(boolean paramBoolean)
  {
    d();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Bmix.isValidate();
  }
  
  public void m() {}
  
  public void u()
  {
    this.jdField_a_of_type_Bmkf = null;
  }
  
  public void z_()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmiv
 * JD-Core Version:    0.7.0.1
 */