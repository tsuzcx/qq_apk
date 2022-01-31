import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;

public class aqjh
  extends Handler
{
  public aqjh(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
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
        this.a.jdField_a_of_type_Bcqf.a(this.a.getString(2131690809));
        this.a.jdField_a_of_type_Bcqf.d(2130848623);
        this.a.jdField_a_of_type_Bcqf.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_Bcqf == null) || (!this.a.jdField_a_of_type_Bcqf.isShowing()));
    this.a.jdField_a_of_type_Bcqf.cancel();
    this.a.jdField_a_of_type_Bcqf.a(this.a.getString(2131690811));
    this.a.jdField_a_of_type_Bcqf.c(true);
    this.a.jdField_a_of_type_Bcqf.a(false);
    this.a.jdField_a_of_type_Bcqf.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqjh
 * JD-Core Version:    0.7.0.1
 */