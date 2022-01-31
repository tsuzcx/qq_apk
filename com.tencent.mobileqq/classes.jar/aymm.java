import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aymm
  extends Handler
{
  aymm(ayml paramayml, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Activity localActivity;
    if ((this.a.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      localActivity = null;
      if (localActivity != null) {
        break label75;
      }
      QLog.d("ThemeSwitchManager", 2, "handleMessage activity is not TitleBarActivity, , what=" + paramMessage.what);
    }
    label75:
    do
    {
      return;
      localActivity = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
    } while ((localActivity.isFinishing()) || ((this.a.jdField_a_of_type_Bcqf != null) && (this.a.jdField_a_of_type_Bcqf.isShowing())));
    this.a.jdField_a_of_type_Bcqf = new bcqf(localActivity, ((BaseActivity)localActivity).getTitleBarHeight());
    this.a.jdField_a_of_type_Bcqf.setCancelable(true);
    this.a.jdField_a_of_type_Bcqf.c(2131719980);
    this.a.jdField_a_of_type_Bcqf.show();
    return;
    this.a.c();
    bcql.a(localActivity, ajya.a(2131714934), 4000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aymm
 * JD-Core Version:    0.7.0.1
 */