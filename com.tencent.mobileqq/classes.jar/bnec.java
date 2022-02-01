import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class bnec
  implements IEventReceiver
{
  protected long a;
  @NonNull
  public final bnee a;
  public bnew a;
  public boolean g;
  
  public bnec(@NonNull bnee parambnee)
  {
    this.jdField_a_of_type_Bnee = parambnee;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bnew == null) {
      bahf.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  @NonNull
  public Context a()
  {
    b();
    return this.jdField_a_of_type_Bnew.a();
  }
  
  @NonNull
  public Resources a()
  {
    b();
    return this.jdField_a_of_type_Bnew.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    b();
    View localView = this.jdField_a_of_type_Bnew.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public bned a(Class<? extends bned> paramClass)
  {
    b();
    return this.jdField_a_of_type_Bnee.a(paramClass);
  }
  
  @NonNull
  public bnew a()
  {
    b();
    return this.jdField_a_of_type_Bnew;
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
  
  public void a(int paramInt, @NonNull bnot parambnot)
  {
    a(parambnot);
  }
  
  public void a(int paramInt, Object paramObject) {}
  
  public void a(Bundle paramBundle)
  {
    b();
  }
  
  public void a(bnew parambnew)
  {
    if (this.jdField_a_of_type_Bnew != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (parambnew == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Bnew = parambnew;
  }
  
  @Deprecated
  public void a(@NonNull bnot parambnot) {}
  
  public void a(Class<? extends bned> paramClass, bned parambned)
  {
    b();
    this.jdField_a_of_type_Bnee.a(paramClass, parambned);
  }
  
  public void a(@NonNull Error paramError) {}
  
  protected boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void aF_()
  {
    b();
  }
  
  public void aG_()
  {
    b();
  }
  
  public void aJ_()
  {
    b();
  }
  
  public void b(Bundle paramBundle)
  {
    b();
  }
  
  public void b(@NonNull bnot parambnot)
  {
    ((bmrr)bmql.a(5)).a(this.jdField_a_of_type_Bnew.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Bnee.h();
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
    return this.jdField_a_of_type_Bnee.isValidate();
  }
  
  public void j()
  {
    b();
  }
  
  public boolean j_()
  {
    b();
    return false;
  }
  
  public void m() {}
  
  public void o()
  {
    this.jdField_a_of_type_Bnew = null;
  }
  
  public void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnec
 * JD-Core Version:    0.7.0.1
 */