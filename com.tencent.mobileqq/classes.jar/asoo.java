import android.os.Message;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class asoo
  extends TransProcessorHandler
{
  public asoo(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1003: 
      if (localFileMsg.fileType == 23)
      {
        ExtendFriendEditFragment.a(this.a, ((NearbyPeoplePhotoUploadProcessor)localFileMsg.processor).mUrl);
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload success. url = " + ExtendFriendEditFragment.a(this.a));
        }
        if (this.a.a != null)
        {
          this.a.a.a(ExtendFriendEditFragment.a(this.a));
          ExtendFriendEditFragment.a(this.a, this.a.a.a());
        }
      }
      assw.a().d(true, 0);
      return;
    }
    if ((localFileMsg.fileType == 23) && (QLog.isColorLevel())) {
      QLog.i("ExtendFriendProfileEdit", 2, "mFileUploadHandler.handleMessage(), upload fail.");
    }
    ExtendFriendEditFragment.a(this.a).dismiss();
    QQToast.a(ExtendFriendEditFragment.a(this.a), anvx.a(2131703750), 0).a();
    assw.a().d(false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoo
 * JD-Core Version:    0.7.0.1
 */