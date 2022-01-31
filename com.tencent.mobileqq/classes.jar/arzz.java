import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

final class arzz
  extends Handler
{
  arzz(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10000001)
    {
      paramMessage = (ProgressBar)arzy.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131366570);
      localDrawable = arzy.jdField_a_of_type_AndroidAppProgressDialog.getContext().getResources().getDrawable(2130839315);
      paramMessage.setIndeterminateDrawable(localDrawable);
      paramMessage.setBackgroundDrawable(localDrawable);
      ((TextView)arzy.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131365146)).setText(2131719279);
      arzy.a().sendEmptyMessageDelayed(10000002, 2000L);
    }
    while ((paramMessage.what != 10000002) || (arzy.jdField_a_of_type_AndroidAppProgressDialog == null))
    {
      Drawable localDrawable;
      return;
    }
    try
    {
      arzy.jdField_a_of_type_Boolean = false;
      arzy.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      return;
    }
    finally
    {
      arzy.jdField_a_of_type_AndroidAppProgressDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arzz
 * JD-Core Version:    0.7.0.1
 */