import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.qphone.base.util.QLog;

public class aqnn
  extends aofu
{
  public aqnn(MessageNotificationSettingFragment paramMessageNotificationSettingFragment) {}
  
  protected void onOIDB0XA80_0_Ret(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MessageNotificationSettingFragment", 2, "onOIDB0XA80_0_Ret: invoked.  isSuccess : " + paramBoolean + " op: " + paramInt1 + " type: " + Integer.toHexString(paramInt2));
    }
    if (paramBoolean) {
      MessageNotificationSettingFragment.a(this.a).a(paramString1, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnn
 * JD-Core Version:    0.7.0.1
 */