import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import com.tencent.qphone.base.util.QLog;

public class bljp
{
  private static final String jdField_a_of_type_JavaLangString = bljp.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bdjz jdField_a_of_type_Bdjz;
  
  public bljp(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Bdjz != null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131699726);
    this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694207), new bljq(this, paramRunnable));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdjz != null) {
      this.jdField_a_of_type_Bdjz.hide();
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      b(paramRunnable);
      if (!this.jdField_a_of_type_Bdjz.isShowing())
      {
        this.jdField_a_of_type_Bdjz.setCancelable(false);
        this.jdField_a_of_type_Bdjz.show();
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
 * Qualified Name:     bljp
 * JD-Core Version:    0.7.0.1
 */