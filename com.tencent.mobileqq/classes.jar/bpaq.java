import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import com.tencent.qphone.base.util.QLog;

public class bpaq
{
  private static final String jdField_a_of_type_JavaLangString = bpaq.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bhpc jdField_a_of_type_Bhpc;
  
  public bpaq(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Bhpc != null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131698318);
    this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131693485), new bpar(this, paramRunnable));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhpc != null) {
      this.jdField_a_of_type_Bhpc.hide();
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      b(paramRunnable);
      if (!this.jdField_a_of_type_Bhpc.isShowing())
      {
        this.jdField_a_of_type_Bhpc.setCancelable(false);
        this.jdField_a_of_type_Bhpc.show();
      }
      return;
    }
    catch (WindowManager.BadTokenException paramRunnable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(jdField_a_of_type_JavaLangString, 2, "", paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpaq
 * JD-Core Version:    0.7.0.1
 */