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

public abstract class bjxl
  implements IEventReceiver
{
  @NonNull
  public final bjxn a;
  public bjyv a;
  protected long d;
  public boolean j;
  
  public bjxl(@NonNull bjxn parambjxn)
  {
    this.jdField_a_of_type_Bjxn = parambjxn;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bjyv == null) {
      awai.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  @NonNull
  public Context a()
  {
    d();
    return this.jdField_a_of_type_Bjyv.a();
  }
  
  @NonNull
  public Resources a()
  {
    d();
    return this.jdField_a_of_type_Bjyv.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    d();
    View localView = this.jdField_a_of_type_Bjyv.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public bjxm a(Class<? extends bjxm> paramClass)
  {
    d();
    return this.jdField_a_of_type_Bjxn.a(paramClass);
  }
  
  @NonNull
  public bjyv a()
  {
    d();
    return this.jdField_a_of_type_Bjyv;
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
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    a(parambkld);
  }
  
  public void a(Bundle paramBundle)
  {
    d();
  }
  
  public void a(bjyv parambjyv)
  {
    if (this.jdField_a_of_type_Bjyv != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (parambjyv == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Bjyv = parambjyv;
  }
  
  @Deprecated
  public void a(@NonNull bkld parambkld) {}
  
  public void a(Class<? extends bjxm> paramClass, bjxm parambjxm)
  {
    d();
    this.jdField_a_of_type_Bjxn.a(paramClass, parambjxm);
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
  
  public void ad_() {}
  
  public void b(Bundle paramBundle)
  {
    d();
  }
  
  public void b(@NonNull bkld parambkld)
  {
    ((bjcb)bjav.a(5)).a(this.jdField_a_of_type_Bjyv.getActivity());
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
    return this.jdField_a_of_type_Bjxn.i();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Bjyv == null) || (this.jdField_a_of_type_Bjyv.getActivity() == null) || (this.jdField_a_of_type_Bjyv.getActivity().isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_Bjyv.getActivity().isDestroyed()));
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
    return this.jdField_a_of_type_Bjxn.isValidate();
  }
  
  public void j_(boolean paramBoolean)
  {
    d();
  }
  
  public void m() {}
  
  public void u()
  {
    this.jdField_a_of_type_Bjyv = null;
  }
  
  public void z_()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjxl
 * JD-Core Version:    0.7.0.1
 */