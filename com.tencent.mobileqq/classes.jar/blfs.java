import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;

public abstract class blfs
{
  protected Activity a;
  protected View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  protected blft a;
  private volatile boolean jdField_a_of_type_Boolean;
  
  @Deprecated
  public blfs(Activity paramActivity, View paramView, blft paramblft)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Blft = paramblft;
  }
  
  public blfs(Activity paramActivity, ViewStub paramViewStub, blft paramblft)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Blft = paramblft;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    return null;
  }
  
  protected abstract void a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  protected void a(View paramView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfs
 * JD-Core Version:    0.7.0.1
 */