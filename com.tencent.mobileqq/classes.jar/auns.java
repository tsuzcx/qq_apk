import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;

public class auns
  extends Handler
{
  public auns(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
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
        this.a.jdField_a_of_type_Biau.a(this.a.getString(2131690709));
        this.a.jdField_a_of_type_Biau.d(2130849667);
        this.a.jdField_a_of_type_Biau.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_Biau == null) || (!this.a.jdField_a_of_type_Biau.isShowing()));
    this.a.jdField_a_of_type_Biau.cancel();
    this.a.jdField_a_of_type_Biau.a(this.a.getString(2131690711));
    this.a.jdField_a_of_type_Biau.c(true);
    this.a.jdField_a_of_type_Biau.a(false);
    this.a.jdField_a_of_type_Biau.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auns
 * JD-Core Version:    0.7.0.1
 */