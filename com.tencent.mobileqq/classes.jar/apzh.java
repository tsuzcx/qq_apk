import android.os.Message;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class apzh
  extends baua
{
  public apzh(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    baoj localbaoj = (baoj)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1003: 
      if (localbaoj.b == 23)
      {
        ExtendFriendEditFragment.a(this.a, ((baqs)localbaoj.a).o);
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload success. url = " + ExtendFriendEditFragment.a(this.a));
        }
        if (this.a.a != null)
        {
          this.a.a.a(ExtendFriendEditFragment.a(this.a));
          ExtendFriendEditFragment.a(this.a, this.a.a.a());
        }
      }
      aqcx.a().d(true, 0);
      return;
    }
    if ((localbaoj.b == 23) && (QLog.isColorLevel())) {
      QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload fail.");
    }
    ExtendFriendEditFragment.a(this.a).dismiss();
    QQToast.a(ExtendFriendEditFragment.a(this.a), alpo.a(2131704653), 0).a();
    aqcx.a().d(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzh
 * JD-Core Version:    0.7.0.1
 */