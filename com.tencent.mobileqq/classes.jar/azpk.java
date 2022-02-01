import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;

public class azpk
  extends VasQuickUpdateManager.CallBacker
{
  public azpk(VasProfileTemplateController paramVasProfileTemplateController) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if (VipProfileCardDiyActivity.a(paramLong, paramString1, VasProfileTemplateController.a(this.a).a.diyTextFontId))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate DIY text font download,  errorCode=%s httpCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      if (paramInt1 == 0)
      {
        paramString1 = VasProfileTemplateController.a(this.a).b.obtainMessage();
        paramString1.what = 5;
        paramString1.obj = VasProfileTemplateController.a(this.a).a;
        paramString1.arg1 = 0;
        paramString1.arg2 = 17;
        VasProfileTemplateController.a(this.a).b.sendMessage(paramString1);
      }
      paramVasQuickUpdateManager.removeCallBacker(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpk
 * JD-Core Version:    0.7.0.1
 */