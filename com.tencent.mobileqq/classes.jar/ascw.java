import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;

public class ascw
  extends Handler
{
  public ascw(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = this.a.getActivity();
      if ((paramMessage != null) && (!paramMessage.isFinishing()))
      {
        this.a.jdField_a_of_type_Bepp.a(this.a.getString(2131690861));
        this.a.jdField_a_of_type_Bepp.d(2130849053);
        this.a.jdField_a_of_type_Bepp.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_Bepp == null) || (!this.a.jdField_a_of_type_Bepp.isShowing()));
    this.a.jdField_a_of_type_Bepp.cancel();
    this.a.jdField_a_of_type_Bepp.a(this.a.getString(2131690863));
    this.a.jdField_a_of_type_Bepp.c(true);
    this.a.jdField_a_of_type_Bepp.a(false);
    this.a.jdField_a_of_type_Bepp.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascw
 * JD-Core Version:    0.7.0.1
 */