import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;

public abstract class bowm
{
  protected Activity a;
  protected View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  protected bown a;
  private volatile boolean jdField_a_of_type_Boolean;
  
  @Deprecated
  public bowm(Activity paramActivity, View paramView, bown parambown)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Bown = parambown;
  }
  
  public bowm(Activity paramActivity, ViewStub paramViewStub, bown parambown)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Bown = parambown;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    return null;
  }
  
  protected abstract void a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  protected void a(View paramView) {}
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void g() {}
  
  public void m() {}
  
  public void n() {}
  
  protected final void o()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
    this.jdField_a_of_type_Boolean = true;
    a(localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowm
 * JD-Core Version:    0.7.0.1
 */