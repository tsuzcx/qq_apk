import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;

class asjl
  extends aoeg
{
  asjl(asiw paramasiw, Bundle paramBundle, MessengerService paramMessengerService, boolean paramBoolean) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    int i = 1;
    super.onFollowPublicAccount(paramBoolean, paramString);
    try
    {
      Object localObject = new Bundle();
      if (paramBoolean) {}
      for (;;)
      {
        ((Bundle)localObject).putInt("retCode", i);
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        if (QLog.isColorLevel()) {
          QLog.d("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW success! isFollow: " + this.jdField_a_of_type_Boolean + "  uin: " + paramString);
        }
        localObject = new Intent("com.tencent.mobileqq.PublicAccountObserver");
        ((Intent)localObject).putExtra("action", "follow");
        ((Intent)localObject).putExtra("isSuccess", paramBoolean);
        ((Intent)localObject).putExtra("uin", paramString);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.getApplicationContext().sendBroadcast((Intent)localObject);
        aaak.a().a(new FollowUpdateEvent(1, paramString));
        return;
        i = 0;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! " + QLog.getStackTraceString(paramString));
    }
  }
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    int i = 0;
    super.onUnfollowPublicAccount(paramBoolean, paramString);
    try
    {
      Object localObject = new Bundle();
      if (paramBoolean) {
        i = 1;
      }
      ((Bundle)localObject).putInt("retCode", i);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      if (QLog.isColorLevel()) {
        QLog.d("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! isFollow: " + this.jdField_a_of_type_Boolean + "  uin: " + paramString);
      }
      localObject = new Intent("com.tencent.mobileqq.PublicAccountObserver");
      ((Intent)localObject).putExtra("action", "unFollow");
      ((Intent)localObject).putExtra("isSuccess", paramBoolean);
      ((Intent)localObject).putExtra("uin", paramString);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.getApplicationContext().sendBroadcast((Intent)localObject);
      aaak.a().a(new FollowUpdateEvent(0, paramString));
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("MessengerService$IncomingHandler", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW failed! " + QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjl
 * JD-Core Version:    0.7.0.1
 */