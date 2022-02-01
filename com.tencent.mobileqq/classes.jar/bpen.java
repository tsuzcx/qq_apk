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

public abstract class bpen
  implements IEventReceiver
{
  @NonNull
  public final bpep a;
  public bpfx a;
  protected long d;
  public boolean j;
  
  public bpen(@NonNull bpep parambpep)
  {
    this.jdField_a_of_type_Bpep = parambpep;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bpfx == null) {
      baur.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  @NonNull
  public Context a()
  {
    d();
    return this.jdField_a_of_type_Bpfx.a();
  }
  
  @NonNull
  public Resources a()
  {
    d();
    return this.jdField_a_of_type_Bpfx.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    d();
    View localView = this.jdField_a_of_type_Bpfx.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public bpeo a(Class<? extends bpeo> paramClass)
  {
    d();
    return this.jdField_a_of_type_Bpep.a(paramClass);
  }
  
  @NonNull
  public bpfx a()
  {
    d();
    return this.jdField_a_of_type_Bpfx;
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
  
  public void a(int paramInt, @NonNull bpsf parambpsf)
  {
    a(parambpsf);
  }
  
  public void a(Bundle paramBundle)
  {
    d();
  }
  
  public void a(bpfx parambpfx)
  {
    if (this.jdField_a_of_type_Bpfx != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (parambpfx == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Bpfx = parambpfx;
  }
  
  @Deprecated
  public void a(@NonNull bpsf parambpsf) {}
  
  public void a(Class<? extends bpeo> paramClass, bpeo parambpeo)
  {
    d();
    this.jdField_a_of_type_Bpep.a(paramClass, parambpeo);
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
  
  public void aT_() {}
  
  public void aU_()
  {
    d();
  }
  
  public void aY_()
  {
    d();
  }
  
  public void a_(int paramInt, Object paramObject) {}
  
  public void ad_() {}
  
  public void b(Bundle paramBundle)
  {
    d();
  }
  
  public void b(@NonNull bpsf parambpsf)
  {
    ((bolb)bojv.a(5)).a(this.jdField_a_of_type_Bpfx.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Bpep.i();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Bpfx == null) || (this.jdField_a_of_type_Bpfx.getActivity() == null) || (this.jdField_a_of_type_Bpfx.getActivity().isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_Bpfx.getActivity().isDestroyed()));
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
  
  public void h_(boolean paramBoolean)
  {
    d();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Bpep.isValidate();
  }
  
  public void m() {}
  
  public void u()
  {
    this.jdField_a_of_type_Bpfx = null;
  }
  
  public void y_()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpen
 * JD-Core Version:    0.7.0.1
 */