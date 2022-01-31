import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class baki
  extends Handler
{
  baki(bakh parambakh, Looper paramLooper)
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
    } while ((localActivity.isFinishing()) || ((this.a.jdField_a_of_type_Bepp != null) && (this.a.jdField_a_of_type_Bepp.isShowing())));
    this.a.jdField_a_of_type_Bepp = new bepp(localActivity, ((BaseActivity)localActivity).getTitleBarHeight());
    this.a.jdField_a_of_type_Bepp.setCancelable(true);
    this.a.jdField_a_of_type_Bepp.c(2131720515);
    this.a.jdField_a_of_type_Bepp.show();
    return;
    this.a.c();
    QQToast.a(localActivity, alpo.a(2131715306), 4000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baki
 * JD-Core Version:    0.7.0.1
 */