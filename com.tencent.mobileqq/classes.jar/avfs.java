import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;

public class avfs
  extends Handler
{
  public avfs(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
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
        this.a.jdField_a_of_type_Bjbs.a(this.a.getString(2131690709));
        this.a.jdField_a_of_type_Bjbs.d(2130849677);
        this.a.jdField_a_of_type_Bjbs.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_Bjbs == null) || (!this.a.jdField_a_of_type_Bjbs.isShowing()));
    this.a.jdField_a_of_type_Bjbs.cancel();
    this.a.jdField_a_of_type_Bjbs.a(this.a.getString(2131690711));
    this.a.jdField_a_of_type_Bjbs.c(true);
    this.a.jdField_a_of_type_Bjbs.a(false);
    this.a.jdField_a_of_type_Bjbs.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfs
 * JD-Core Version:    0.7.0.1
 */