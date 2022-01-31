import android.os.Message;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.qphone.base.util.QLog;

public class aogu
  extends aywb
{
  public aogu(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqo localayqo = (ayqo)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1003: 
      if (localayqo.b == 23)
      {
        ExtendFriendEditFragment.a(this.a, ((aysv)localayqo.a).o);
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload success. url = " + ExtendFriendEditFragment.a(this.a));
        }
        if (this.a.a != null)
        {
          this.a.a.a(ExtendFriendEditFragment.a(this.a));
          ExtendFriendEditFragment.a(this.a, this.a.a.a());
        }
      }
      aokp.a().e(true, 0);
      return;
    }
    if ((localayqo.b == 23) && (QLog.isColorLevel())) {
      QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload fail.");
    }
    ExtendFriendEditFragment.a(this.a).dismiss();
    bcql.a(ExtendFriendEditFragment.a(this.a), ajya.a(2131704281), 0).a();
    aokp.a().e(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogu
 * JD-Core Version:    0.7.0.1
 */