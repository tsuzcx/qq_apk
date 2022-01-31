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

public abstract class bmnh
  implements IEventReceiver
{
  @NonNull
  public final bmnj a;
  public bmor a;
  protected long d;
  public boolean j;
  
  public bmnh(@NonNull bmnj parambmnj)
  {
    this.jdField_a_of_type_Bmnj = parambmnj;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bmor == null) {
      axwq.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  @NonNull
  public Context a()
  {
    d();
    return this.jdField_a_of_type_Bmor.a();
  }
  
  @NonNull
  public Resources a()
  {
    d();
    return this.jdField_a_of_type_Bmor.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    d();
    View localView = this.jdField_a_of_type_Bmor.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public bmni a(Class<? extends bmni> paramClass)
  {
    d();
    return this.jdField_a_of_type_Bmnj.a(paramClass);
  }
  
  @NonNull
  public bmor a()
  {
    d();
    return this.jdField_a_of_type_Bmor;
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
  
  public void a(int paramInt, @NonNull bnaz parambnaz)
  {
    a(parambnaz);
  }
  
  public void a(Bundle paramBundle)
  {
    d();
  }
  
  public void a(bmor parambmor)
  {
    if (this.jdField_a_of_type_Bmor != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (parambmor == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Bmor = parambmor;
  }
  
  @Deprecated
  public void a(@NonNull bnaz parambnaz) {}
  
  public void a(Class<? extends bmni> paramClass, bmni parambmni)
  {
    d();
    this.jdField_a_of_type_Bmnj.a(paramClass, parambmni);
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
  
  public void aV_() {}
  
  public void aW_()
  {
    d();
  }
  
  public void a_(int paramInt, Object paramObject) {}
  
  public void ai_() {}
  
  public void b(Bundle paramBundle)
  {
    d();
  }
  
  public void b(@NonNull bnaz parambnaz)
  {
    ((blrx)blqr.a(5)).a(this.jdField_a_of_type_Bmor.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public void ba_()
  {
    d();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Bmnj.i();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Bmor == null) || (this.jdField_a_of_type_Bmor.getActivity() == null) || (this.jdField_a_of_type_Bmor.getActivity().isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_Bmor.getActivity().isDestroyed()));
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
    return this.jdField_a_of_type_Bmnj.isValidate();
  }
  
  public void m() {}
  
  public void u()
  {
    this.jdField_a_of_type_Bmor = null;
  }
  
  public void z_()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnh
 * JD-Core Version:    0.7.0.1
 */