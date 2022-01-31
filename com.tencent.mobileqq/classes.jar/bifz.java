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

public abstract class bifz
  implements IEventReceiver
{
  @NonNull
  public final bigb a;
  public bihj a;
  protected long d;
  public boolean j;
  
  public bifz(@NonNull bigb parambigb)
  {
    this.jdField_a_of_type_Bigb = parambigb;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bihj == null) {
      avan.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  public void B_()
  {
    d();
  }
  
  @NonNull
  public Context a()
  {
    d();
    return this.jdField_a_of_type_Bihj.a();
  }
  
  @NonNull
  public Resources a()
  {
    d();
    return this.jdField_a_of_type_Bihj.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    d();
    View localView = this.jdField_a_of_type_Bihj.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public biga a(Class<? extends biga> paramClass)
  {
    d();
    return this.jdField_a_of_type_Bigb.a(paramClass);
  }
  
  @NonNull
  public bihj a()
  {
    d();
    return this.jdField_a_of_type_Bihj;
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
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    a(parambitz);
  }
  
  public void a(Bundle paramBundle)
  {
    d();
  }
  
  public void a(bihj parambihj)
  {
    if (this.jdField_a_of_type_Bihj != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (parambihj == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Bihj = parambihj;
  }
  
  @Deprecated
  public void a(@NonNull bitz parambitz) {}
  
  public void a(Class<? extends biga> paramClass, biga parambiga)
  {
    d();
    this.jdField_a_of_type_Bigb.a(paramClass, parambiga);
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
  
  public void a_(int paramInt, Object paramObject) {}
  
  public void ag_() {}
  
  public void b(Bundle paramBundle)
  {
    d();
  }
  
  public void b(@NonNull bitz parambitz)
  {
    ((bhgs)bhfm.a(5)).a(this.jdField_a_of_type_Bihj.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public void ba_() {}
  
  public void bb_()
  {
    d();
  }
  
  public void bf_()
  {
    d();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Bigb.i();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Bihj == null) || (this.jdField_a_of_type_Bihj.getActivity() == null) || (this.jdField_a_of_type_Bihj.getActivity().isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_Bihj.getActivity().isDestroyed()));
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
    return this.jdField_a_of_type_Bigb.isValidate();
  }
  
  public void j_(boolean paramBoolean)
  {
    d();
  }
  
  public void m() {}
  
  public void u()
  {
    this.jdField_a_of_type_Bihj = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bifz
 * JD-Core Version:    0.7.0.1
 */