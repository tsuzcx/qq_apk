import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment;
import com.tencent.qphone.base.util.QLog;

public class amex
  extends allb
{
  public amex(HiddenChatSettingFragment paramHiddenChatSettingFragment) {}
  
  protected void onSetHiddenSession(boolean paramBoolean, int paramInt)
  {
    super.onSetHiddenSession(paramBoolean, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("HiddenChatSetting", 2, "onSetHiddenSession " + paramBoolean + " type=" + paramInt);
    }
    if (paramInt == 42318) {
      if (!paramBoolean) {
        HiddenChatSettingFragment.a(this.a, HiddenChatSettingFragment.a(this.a), amey.a(HiddenChatSettingFragment.a(this.a).c(), this.a.getActivity()));
      }
    }
    while ((paramInt != 42319) || (paramBoolean)) {
      return;
    }
    HiddenChatSettingFragment.a(this.a, HiddenChatSettingFragment.b(this.a), amey.b(HiddenChatSettingFragment.a(this.a).c(), this.a.getActivity()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amex
 * JD-Core Version:    0.7.0.1
 */