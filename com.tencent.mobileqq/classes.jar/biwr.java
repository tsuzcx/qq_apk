import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;

public abstract class biwr
{
  protected Activity a;
  protected View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  protected biws a;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public biwr(Activity paramActivity, View paramView, biws parambiws)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Biws = parambiws;
  }
  
  public biwr(Activity paramActivity, ViewStub paramViewStub, biws parambiws)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Biws = parambiws;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    return null;
  }
  
  protected abstract void a();
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  protected void a(View paramView) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  protected final void j()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
    this.jdField_a_of_type_Boolean = true;
    a(localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwr
 * JD-Core Version:    0.7.0.1
 */