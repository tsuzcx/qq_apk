import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class botu
  implements IEventReceiver
{
  protected long a;
  @NonNull
  public final botw a;
  public bouo a;
  public boolean g;
  
  public botu(@NonNull botw parambotw)
  {
    this.jdField_a_of_type_Botw = parambotw;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bouo == null) {
      bbnu.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  @NonNull
  public Context a()
  {
    b();
    return this.jdField_a_of_type_Bouo.a();
  }
  
  @NonNull
  public Resources a()
  {
    b();
    return this.jdField_a_of_type_Bouo.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    b();
    View localView = this.jdField_a_of_type_Bouo.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public botv a(Class<? extends botv> paramClass)
  {
    b();
    return this.jdField_a_of_type_Botw.a(paramClass);
  }
  
  @NonNull
  public bouo a()
  {
    b();
    return this.jdField_a_of_type_Bouo;
  }
  
  protected String a(int paramInt)
  {
    b();
    return a().getString(paramInt);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    b();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a(paramInt2, paramObject);
  }
  
  public void a(int paramInt, @NonNull bpel parambpel)
  {
    a(parambpel);
  }
  
  public void a(int paramInt, Object paramObject) {}
  
  public void a(Bundle paramBundle)
  {
    b();
  }
  
  public void a(bouo parambouo)
  {
    if (this.jdField_a_of_type_Bouo != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (parambouo == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Bouo = parambouo;
  }
  
  @Deprecated
  public void a(@NonNull bpel parambpel) {}
  
  public void a(Class<? extends botv> paramClass, botv parambotv)
  {
    b();
    this.jdField_a_of_type_Botw.a(paramClass, parambotv);
  }
  
  public void a(@NonNull Error paramError) {}
  
  protected boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void aH_()
  {
    b();
  }
  
  public void aI_()
  {
    b();
  }
  
  public void aL_()
  {
    b();
  }
  
  public void b(Bundle paramBundle)
  {
    b();
  }
  
  public void b(@NonNull bpel parambpel)
  {
    ((bohj)bogd.a(5)).a(this.jdField_a_of_type_Bouo.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Botw.h();
  }
  
  public void e(boolean paramBoolean)
  {
    b();
  }
  
  public void g()
  {
    this.g = true;
    o();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Botw.isValidate();
  }
  
  public void j()
  {
    b();
  }
  
  public boolean l_()
  {
    b();
    return false;
  }
  
  public void m() {}
  
  public void o()
  {
    this.jdField_a_of_type_Bouo = null;
  }
  
  public void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botu
 * JD-Core Version:    0.7.0.1
 */