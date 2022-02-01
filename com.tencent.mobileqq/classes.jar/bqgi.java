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

public abstract class bqgi
  implements IEventReceiver
{
  @NonNull
  public final bqgk a;
  public bqhs a;
  protected long d;
  public boolean j;
  
  public bqgi(@NonNull bqgk parambqgk)
  {
    this.jdField_a_of_type_Bqgk = parambqgk;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bqhs == null) {
      bbnk.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  @NonNull
  public Context a()
  {
    d();
    return this.jdField_a_of_type_Bqhs.a();
  }
  
  @NonNull
  public Resources a()
  {
    d();
    return this.jdField_a_of_type_Bqhs.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    d();
    View localView = this.jdField_a_of_type_Bqhs.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public bqgj a(Class<? extends bqgj> paramClass)
  {
    d();
    return this.jdField_a_of_type_Bqgk.a(paramClass);
  }
  
  @NonNull
  public bqhs a()
  {
    d();
    return this.jdField_a_of_type_Bqhs;
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
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    a(parambqua);
  }
  
  public void a(Bundle paramBundle)
  {
    d();
  }
  
  public void a(bqhs parambqhs)
  {
    if (this.jdField_a_of_type_Bqhs != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (parambqhs == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Bqhs = parambqhs;
  }
  
  @Deprecated
  public void a(@NonNull bqua parambqua) {}
  
  public void a(Class<? extends bqgj> paramClass, bqgj parambqgj)
  {
    d();
    this.jdField_a_of_type_Bqgk.a(paramClass, parambqgj);
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
  
  public void b(@NonNull bqua parambqua)
  {
    ((bpmw)bplq.a(5)).a(this.jdField_a_of_type_Bqhs.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Bqgk.i();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Bqhs == null) || (this.jdField_a_of_type_Bqhs.getActivity() == null) || (this.jdField_a_of_type_Bqhs.getActivity().isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (this.jdField_a_of_type_Bqhs.getActivity().isDestroyed()));
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
    return this.jdField_a_of_type_Bqgk.isValidate();
  }
  
  public void m() {}
  
  public void u()
  {
    this.jdField_a_of_type_Bqhs = null;
  }
  
  public void y_()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqgi
 * JD-Core Version:    0.7.0.1
 */