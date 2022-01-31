import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import com.tencent.qphone.base.util.QLog;

public class blfi
{
  private static final String jdField_a_of_type_JavaLangString = blfi.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bdfq jdField_a_of_type_Bdfq;
  
  public blfi(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Bdfq != null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131699714);
    this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694205), new blfj(this, paramRunnable));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdfq != null) {
      this.jdField_a_of_type_Bdfq.hide();
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      b(paramRunnable);
      if (!this.jdField_a_of_type_Bdfq.isShowing())
      {
        this.jdField_a_of_type_Bdfq.setCancelable(false);
        this.jdField_a_of_type_Bdfq.show();
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
 * Qualified Name:     blfi
 * JD-Core Version:    0.7.0.1
 */