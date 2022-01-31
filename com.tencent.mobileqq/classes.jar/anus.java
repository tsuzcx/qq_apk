import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

class anus
  extends VasQuickUpdateManager.CallBacker
{
  anus(anuq paramanuq, MessengerService paramMessengerService) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && ("cardWZ.zip".equals(paramString1)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a != null)
      {
        paramString1 = new Bundle();
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a.putString("cmd", "card_download_wzry_template");
        paramString1.putInt("result", paramInt1);
        paramString1.putString("message", paramString3);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a.putBundle("response", paramString1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a = null;
      }
      paramVasQuickUpdateManager.removeCallBacker(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anus
 * JD-Core Version:    0.7.0.1
 */