import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;

public class baib
  extends VasQuickUpdateManager.CallBacker
{
  public baib(VasProfileTemplateController paramVasProfileTemplateController, azxy paramazxy, Card paramCard) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && ("cardWZ.zip".equals(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate WZRY template download,  errorCode=%s httpCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      if (VasProfileTemplateController.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController).b != null)
      {
        if (this.jdField_a_of_type_Azxy.a(VasProfileTemplateController.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController), this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId)) {
          VasProfileTemplateController.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController).jdField_a_of_type_Azxy = this.jdField_a_of_type_Azxy;
        }
        VasProfileTemplateController.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasProfileTemplateController).b.obtainMessage(5, 0, 12, this.jdField_a_of_type_ComTencentMobileqqDataCard).sendToTarget();
      }
      paramVasQuickUpdateManager.removeCallBacker(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baib
 * JD-Core Version:    0.7.0.1
 */