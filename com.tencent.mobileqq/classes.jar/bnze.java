import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import com.tencent.qphone.base.util.QLog;

public class bnze
{
  private static final String jdField_a_of_type_JavaLangString = bnze.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bgpa jdField_a_of_type_Bgpa;
  
  public bnze(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Bgpa != null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131698216);
    this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131693473), new bnzf(this, paramRunnable));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bgpa != null) {
      this.jdField_a_of_type_Bgpa.hide();
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      b(paramRunnable);
      if (!this.jdField_a_of_type_Bgpa.isShowing())
      {
        this.jdField_a_of_type_Bgpa.setCancelable(false);
        this.jdField_a_of_type_Bgpa.show();
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
 * Qualified Name:     bnze
 * JD-Core Version:    0.7.0.1
 */