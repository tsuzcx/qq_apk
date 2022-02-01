import android.os.Message;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class asyb
  extends beyf
{
  public asyb(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1003: 
      if (localbete.b == 23)
      {
        ExtendFriendEditFragment.a(this.a, ((bevi)localbete.a).o);
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload success. url = " + ExtendFriendEditFragment.a(this.a));
        }
        if (this.a.a != null)
        {
          this.a.a.a(ExtendFriendEditFragment.a(this.a));
          ExtendFriendEditFragment.a(this.a, this.a.a.a());
        }
      }
      atci.a().d(true, 0);
      return;
    }
    if ((localbete.b == 23) && (QLog.isColorLevel())) {
      QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload fail.");
    }
    ExtendFriendEditFragment.a(this.a).dismiss();
    QQToast.a(ExtendFriendEditFragment.a(this.a), anzj.a(2131703169), 0).a();
    atci.a().d(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyb
 * JD-Core Version:    0.7.0.1
 */