import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

final class awva
  extends Handler
{
  awva(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10000001)
    {
      paramMessage = (ProgressBar)awuz.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131367008);
      localDrawable = awuz.jdField_a_of_type_AndroidAppProgressDialog.getContext().getResources().getDrawable(2130839593);
      paramMessage.setIndeterminateDrawable(localDrawable);
      paramMessage.setBackgroundDrawable(localDrawable);
      ((TextView)awuz.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131365519)).setText(2131717890);
      awuz.a().sendEmptyMessageDelayed(10000002, 2000L);
    }
    while ((paramMessage.what != 10000002) || (awuz.jdField_a_of_type_AndroidAppProgressDialog == null))
    {
      Drawable localDrawable;
      return;
    }
    try
    {
      awuz.jdField_a_of_type_Boolean = false;
      awuz.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      return;
    }
    finally
    {
      awuz.jdField_a_of_type_AndroidAppProgressDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awva
 * JD-Core Version:    0.7.0.1
 */