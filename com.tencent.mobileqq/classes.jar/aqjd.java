import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;

public class aqjd
  extends Handler
{
  public aqjd(QQSettingChatOperationFragment paramQQSettingChatOperationFragment) {}
  
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
          this.a.jdField_a_of_type_Bcpq.a(this.a.getString(2131690809));
          this.a.jdField_a_of_type_Bcpq.d(2130848617);
          this.a.jdField_a_of_type_Bcpq.b(false);
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
        return;
      } while ((this.a.jdField_a_of_type_Bcpq == null) || (!this.a.jdField_a_of_type_Bcpq.isShowing()));
      this.a.jdField_a_of_type_Bcpq.cancel();
      this.a.jdField_a_of_type_Bcpq.a(this.a.getString(2131690811));
      this.a.jdField_a_of_type_Bcpq.c(true);
      this.a.jdField_a_of_type_Bcpq.a(false);
      this.a.jdField_a_of_type_Bcpq.b(true);
      return;
    }
    QQSettingChatOperationFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqjd
 * JD-Core Version:    0.7.0.1
 */