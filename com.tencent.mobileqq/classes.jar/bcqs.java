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

class bcqs
  extends Handler
{
  bcqs(bcqr parambcqr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bcqt localbcqt = (bcqt)paramMessage.obj;
    paramMessage = localbcqt.jdField_a_of_type_JavaLangString;
    if ((paramMessage == null) || (paramMessage.length() == 0)) {}
    for (;;)
    {
      try
      {
        String str = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(localbcqt.b);
        paramMessage = str;
        if (this.a.jdField_a_of_type_AndroidWidgetToast != null) {
          break label116;
        }
        this.a.jdField_a_of_type_AndroidWidgetToast = bcql.a(this.a.jdField_a_of_type_AndroidContentContext, localbcqt.jdField_a_of_type_Int, paramMessage, localbcqt.c).a(localbcqt.d);
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
        ((ImageView)localView.findViewById(2131377519)).setImageResource(bcql.a(localbcqt.jdField_a_of_type_Int));
        this.a.jdField_a_of_type_AndroidWidgetToast.setDuration(localbcqt.c);
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
 * Qualified Name:     bcqs
 * JD-Core Version:    0.7.0.1
 */