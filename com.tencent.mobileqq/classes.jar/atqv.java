import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

final class atqv
  extends Handler
{
  atqv(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10000001)
    {
      paramMessage = (ProgressBar)atqu.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131366685);
      localDrawable = atqu.jdField_a_of_type_AndroidAppProgressDialog.getContext().getResources().getDrawable(2130839404);
      paramMessage.setIndeterminateDrawable(localDrawable);
      paramMessage.setBackgroundDrawable(localDrawable);
      ((TextView)atqu.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131365231)).setText(2131719760);
      atqu.a().sendEmptyMessageDelayed(10000002, 2000L);
    }
    while ((paramMessage.what != 10000002) || (atqu.jdField_a_of_type_AndroidAppProgressDialog == null))
    {
      Drawable localDrawable;
      return;
    }
    try
    {
      atqu.jdField_a_of_type_Boolean = false;
      atqu.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      return;
    }
    finally
    {
      atqu.jdField_a_of_type_AndroidAppProgressDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atqv
 * JD-Core Version:    0.7.0.1
 */