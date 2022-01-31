import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;

class bcqd
  extends Handler
{
  bcqd(bcqc parambcqc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bcqe localbcqe = (bcqe)paramMessage.obj;
    paramMessage = localbcqe.jdField_a_of_type_JavaLangString;
    if ((paramMessage == null) || (paramMessage.length() == 0)) {}
    for (;;)
    {
      try
      {
        String str = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(localbcqe.b);
        paramMessage = str;
        if (this.a.jdField_a_of_type_AndroidWidgetToast != null) {
          break label116;
        }
        this.a.jdField_a_of_type_AndroidWidgetToast = bcpw.a(this.a.jdField_a_of_type_AndroidContentContext, localbcqe.jdField_a_of_type_Int, paramMessage, localbcqe.c).a(localbcqe.d);
        if (this.a.jdField_a_of_type_AndroidWidgetToast != null) {
          this.a.jdField_a_of_type_AndroidWidgetToast.show();
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      try
      {
        label116:
        View localView = this.a.jdField_a_of_type_AndroidWidgetToast.getView();
        ((TextView)localView.findViewById(2131377522)).setText(paramMessage);
        ((ImageView)localView.findViewById(2131377519)).setImageResource(bcpw.a(localbcqe.jdField_a_of_type_Int));
        this.a.jdField_a_of_type_AndroidWidgetToast.setDuration(localbcqe.c);
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        this.a.jdField_a_of_type_AndroidWidgetToast = null;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQToastNotifier", 2, paramMessage.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcqd
 * JD-Core Version:    0.7.0.1
 */