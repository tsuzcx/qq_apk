import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;

public class aqjf
  extends Handler
{
  public aqjf(QQSettingChatOperationFragment paramQQSettingChatOperationFragment) {}
  
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
      return;
    }
    QQSettingChatOperationFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqjf
 * JD-Core Version:    0.7.0.1
 */