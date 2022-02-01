import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class bisz
  extends Handler
{
  bisz(bisy parambisy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bita localbita = (bita)paramMessage.obj;
    paramMessage = localbita.jdField_a_of_type_JavaLangString;
    if ((paramMessage == null) || (paramMessage.length() == 0)) {}
    for (;;)
    {
      try
      {
        String str = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(localbita.b);
        paramMessage = str;
        if (this.a.jdField_a_of_type_AndroidWidgetToast != null) {
          break label116;
        }
        this.a.jdField_a_of_type_AndroidWidgetToast = QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, localbita.jdField_a_of_type_Int, paramMessage, localbita.c).a(localbita.d);
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
        ((TextView)localView.findViewById(2131379183)).setText(paramMessage);
        ((ImageView)localView.findViewById(2131379180)).setImageResource(QQToast.a(localbita.jdField_a_of_type_Int));
        this.a.jdField_a_of_type_AndroidWidgetToast.setDuration(localbita.c);
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
 * Qualified Name:     bisz
 * JD-Core Version:    0.7.0.1
 */