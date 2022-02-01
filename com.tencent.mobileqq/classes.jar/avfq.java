import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;

public class avfq
  extends Handler
{
  public avfq(QQSettingChatOperationFragment paramQQSettingChatOperationFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        return;
        if ((this.a.getActivity() != null) && (!this.a.getActivity().isFinishing()))
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
      return;
    }
    QQSettingChatOperationFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfq
 * JD-Core Version:    0.7.0.1
 */