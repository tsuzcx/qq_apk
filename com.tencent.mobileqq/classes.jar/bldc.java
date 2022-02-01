import android.app.Activity;
import android.os.IBinder;
import android.widget.Button;

public class bldc
  extends blcx
{
  public boolean b = true;
  
  public bldc(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131705417));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldc
 * JD-Core Version:    0.7.0.1
 */