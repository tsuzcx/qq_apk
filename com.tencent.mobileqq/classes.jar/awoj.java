import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

final class awoj
  extends Handler
{
  awoj(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10000001)
    {
      paramMessage = (ProgressBar)awoi.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131367140);
      localDrawable = awoi.jdField_a_of_type_AndroidAppProgressDialog.getContext().getResources().getDrawable(2130839651);
      paramMessage.setIndeterminateDrawable(localDrawable);
      paramMessage.setBackgroundDrawable(localDrawable);
      ((TextView)awoi.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131365644)).setText(2131718515);
      awoi.a().sendEmptyMessageDelayed(10000002, 2000L);
    }
    while ((paramMessage.what != 10000002) || (awoi.jdField_a_of_type_AndroidAppProgressDialog == null))
    {
      Drawable localDrawable;
      return;
    }
    try
    {
      awoi.jdField_a_of_type_Boolean = false;
      awoi.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      return;
    }
    finally
    {
      awoi.jdField_a_of_type_AndroidAppProgressDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awoj
 * JD-Core Version:    0.7.0.1
 */