import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.qphone.base.util.QLog;

public class amgk
  extends akim
{
  public amgk(MessageNotificationSettingFragment paramMessageNotificationSettingFragment) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MessageNotificationSettingFragment", 2, "onOIDB0XA80_0_Ret: invoked.  isSuccess : " + paramBoolean + " op: " + paramInt1 + " type: " + Integer.toHexString(paramInt2));
    }
    if (paramBoolean) {
      MessageNotificationSettingFragment.a(this.a).a(paramString1, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgk
 * JD-Core Version:    0.7.0.1
 */