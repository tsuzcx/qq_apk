import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class anve
  implements MiniAppLauncher.MiniAppLaunchListener
{
  anve(anuq paramanuq, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    Bundle localBundle;
    if (paramBundle != null) {
      localBundle = new Bundle();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", paramBundle.getLong("retCode", 0L));
      if (!paramBoolean) {
        localJSONObject.put("msg", paramBundle.getString("errMsg"));
      }
      localBundle.putString("result", localJSONObject.toString());
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("launchMiniAppById", 1, "launchMiniAppById error,", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anve
 * JD-Core Version:    0.7.0.1
 */