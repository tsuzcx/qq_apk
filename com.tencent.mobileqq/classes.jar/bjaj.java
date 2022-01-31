import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import com.tencent.qphone.base.util.QLog;

public class bjaj
{
  private static final String jdField_a_of_type_JavaLangString = bjaj.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bbgu jdField_a_of_type_Bbgu;
  
  public bjaj(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Bbgu != null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131699364);
    this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694088), new bjak(this, paramRunnable));
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      b(paramRunnable);
      if (!this.jdField_a_of_type_Bbgu.isShowing())
      {
        this.jdField_a_of_type_Bbgu.setCancelable(false);
        this.jdField_a_of_type_Bbgu.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjaj
 * JD-Core Version:    0.7.0.1
 */