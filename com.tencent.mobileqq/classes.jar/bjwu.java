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

public abstract class bjwu
  implements IEventReceiver
{
  @NonNull
  public final bjww a;
  public bjye a;
  protected long d;
  public boolean j;
  
  public bjwu(@NonNull bjww parambjww)
  {
    this.jdField_a_of_type_Bjww = parambjww;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bjye == null) {
      awag.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  @NonNull
  public Context a()
  {
    d();
    return this.jdField_a_of_type_Bjye.a();
  }
  
  @NonNull
  public Resources a()
  {
    d();
    return this.jdField_a_of_type_Bjye.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    d();
    View localView = this.jdField_a_of_type_Bjye.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public bjwv a(Class<? extends bjwv> paramClass)
  {
    d();
    return this.jdField_a_of_type_Bjww.a(paramClass);
  }
  
  @NonNull
  public bjye a()
  {
    d();
    return this.jdField_a_of_type_Bjye;
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
  
  public void a(int paramInt, @NonNull bkkm parambkkm)
  {
    a(parambkkm);
  }
  
  public void a(Bundle paramBundle)
  {
    d();
  }
  
  public void a(bjye parambjye)
  {
    if (this.jdField_a_of_type_Bjye != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (parambjye == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Bjye = parambjye;
  }
  
  @Deprecated
  public void a(@NonNull bkkm parambkkm) {}
  
  public void a(Class<? extends bjwv> paramClass, bjwv parambjwv)
  {
    d();
    this.jdField_a_of_type_Bjww.a(paramClass, parambjwv);
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
  
  public void aU_() {}
  
  public void aV_()
  {
    d();
  }
  
  public void aZ_()
  {
    d();
  }
  
  public void a_(int paramInt, Object paramObject) {}
  
  public void ad_() {}
  
  public void b(Bundle paramBundle)
  {
    d();
  }
  
  public void b(@NonNull bkkm parambkkm)
  {
    ((bjbk)bjae.a(5)).a(this.jdField_a_of_type_Bjye.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Bjww.i();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Bjye == null) || (this.jdField_a_of_type_Bjye.getActivity() == null) || (this.jdField_a_of_type_Bjye.getActivity().isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_Bjye.getActivity().isDestroyed()));
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
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Bjww.isValidate();
  }
  
  public void j_(boolean paramBoolean)
  {
    d();
  }
  
  public void m() {}
  
  public void u()
  {
    this.jdField_a_of_type_Bjye = null;
  }
  
  public void z_()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwu
 * JD-Core Version:    0.7.0.1
 */