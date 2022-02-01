import android.content.Intent;
import android.os.Message;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.CoverTransProcessorHandler.1;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.CoverTransProcessorHandler.2;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class apva
  extends bdzm
{
  WeakReference<QQAppInterface> a;
  WeakReference<SelectCoverActivity> b;
  
  public apva(QQAppInterface paramQQAppInterface, SelectCoverActivity paramSelectCoverActivity)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramSelectCoverActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    SelectCoverActivity localSelectCoverActivity = (SelectCoverActivity)this.b.get();
    if ((localQQAppInterface == null) || (localSelectCoverActivity == null)) {}
    Object localObject;
    label298:
    do
    {
      return;
      localObject = (bduk)paramMessage.obj;
      switch (paramMessage.what)
      {
      case 1004: 
      default: 
        return;
      case 1003: 
        if (((bduk)localObject).b == 48)
        {
          paramMessage = ((bdwp)((bduk)localObject).a).a;
          if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = " + paramMessage);
          }
          paramMessage = (anip)localQQAppInterface.a(2);
          if (paramMessage != null) {
            paramMessage.a(true, localQQAppInterface.getCurrentAccountUin(), 0);
          }
          bghy.a(null);
          if (((Integer)axdz.a(localQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
            axdz.a(localQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
          }
          if (localSelectCoverActivity.jdField_d_of_type_Int != 3)
          {
            int i = localSelectCoverActivity.f;
            localObject = localSelectCoverActivity.c;
            String str = localSelectCoverActivity.jdField_d_of_type_JavaLangString;
            if (localSelectCoverActivity.a)
            {
              paramMessage = "1";
              bcst.b(localQQAppInterface, "dc00898", "", "", "0X800711D", "0X800711D", 0, 0, String.valueOf(i), (String)localObject, str, paramMessage);
            }
          }
          else
          {
            if (!SelectCoverActivity.a(localSelectCoverActivity)) {
              break label298;
            }
            paramMessage = new Intent();
            paramMessage.putExtra("key_photo_file_path", SelectCoverActivity.a(localSelectCoverActivity));
            localSelectCoverActivity.setResult(-1, paramMessage);
          }
          for (;;)
          {
            localSelectCoverActivity.finish();
            return;
            paramMessage = "0";
            break;
            if (localSelectCoverActivity.jdField_d_of_type_Int == 3)
            {
              paramMessage = new Intent(localSelectCoverActivity, AvatarPendantActivity.class);
              localObject = localSelectCoverActivity.getIntent();
              paramMessage.putExtra("fromThirdApp", true);
              paramMessage.putExtra("pkg_name", ((Intent)localObject).getStringExtra("pkg_name"));
              paramMessage.putExtra("app_name", ((Intent)localObject).getStringExtra("app_name"));
              localObject = ((Intent)localObject).getStringExtra("share_id");
              paramMessage.putExtra("share_id", (String)localObject);
              bcst.b(localQQAppInterface, "dc00898", "", "", "0X8009DFA", "0X8009DFA", 0, 0, (String)localObject, "", "", "");
              paramMessage.putExtra("AllInOne", new ProfileActivity.AllInOne(localQQAppInterface.getCurrentAccountUin(), 0));
              localSelectCoverActivity.startActivity(paramMessage);
            }
            else
            {
              localSelectCoverActivity.setResult(-1);
            }
          }
        }
        if (((bduk)localObject).b == 36)
        {
          paramMessage = ((bdwp)((bduk)localObject).a).b;
          if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), big video upload success. videoId = " + paramMessage);
          }
          ThreadManager.post(new SelectCoverActivity.CoverTransProcessorHandler.1(this, localSelectCoverActivity, localQQAppInterface), 8, null, true);
          return;
        }
        if (((bduk)localObject).b == 37)
        {
          paramMessage = ((bdwp)((bduk)localObject).a).b;
          if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), medium video upload success. videoId = " + paramMessage);
          }
          ThreadManager.post(new SelectCoverActivity.CoverTransProcessorHandler.2(this, localSelectCoverActivity, localQQAppInterface), 8, null, true);
          return;
        }
        break;
      }
    } while (((bduk)localObject).b != 38);
    paramMessage = ((bdwp)((bduk)localObject).a).b;
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), small video upload success. videoId = " + paramMessage);
    }
    apux.a(localQQAppInterface, localSelectCoverActivity.b);
    bghy.a(localSelectCoverActivity.b);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed.");
    }
    SelectCoverActivity.a(localSelectCoverActivity, 2, anni.a(2131712478), 0);
    bghy.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apva
 * JD-Core Version:    0.7.0.1
 */