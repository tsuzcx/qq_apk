import android.app.Activity;
import android.os.IBinder;
import android.widget.Button;

public class bjrq
  extends bjrl
{
  public boolean b = true;
  
  public bjrq(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131705066));
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
 * Qualified Name:     bjrq
 * JD-Core Version:    0.7.0.1
 */