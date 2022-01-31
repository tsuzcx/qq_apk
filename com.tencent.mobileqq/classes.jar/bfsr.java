import android.app.Activity;
import android.os.IBinder;
import android.widget.Button;

public class bfsr
  extends bfsm
{
  public boolean b = true;
  
  public bfsr(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131705933));
    }
    b();
  }
  
  protected void a(IBinder paramIBinder)
  {
    if (this.b) {
      super.a(paramIBinder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfsr
 * JD-Core Version:    0.7.0.1
 */