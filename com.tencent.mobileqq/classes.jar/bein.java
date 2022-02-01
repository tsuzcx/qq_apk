import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bein
  extends Handler
{
  bein(beim parambeim, Looper paramLooper)
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
    } while ((localActivity.isFinishing()) || ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing())));
    this.a.jdField_a_of_type_Bisl = new bisl(localActivity, ((BaseActivity)localActivity).getTitleBarHeight());
    this.a.jdField_a_of_type_Bisl.setCancelable(true);
    this.a.jdField_a_of_type_Bisl.c(2131719138);
    this.a.jdField_a_of_type_Bisl.show();
    return;
    this.a.c();
    QQToast.a(localActivity, anvx.a(2131714305), 4000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bein
 * JD-Core Version:    0.7.0.1
 */