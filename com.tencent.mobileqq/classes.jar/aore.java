import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment;
import com.tencent.qphone.base.util.QLog;

public class aore
  extends anuw
{
  public aore(HiddenChatSettingFragment paramHiddenChatSettingFragment) {}
  
  protected void onSetHiddenSession(boolean paramBoolean, int paramInt)
  {
    super.onSetHiddenSession(paramBoolean, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("HiddenChatSetting", 2, "onSetHiddenSession " + paramBoolean + " type=" + paramInt);
    }
    if (paramInt == 42318) {
      if (!paramBoolean) {
        HiddenChatSettingFragment.a(this.a, HiddenChatSettingFragment.a(this.a), aorf.a(HiddenChatSettingFragment.a(this.a).c(), this.a.getActivity()));
      }
    }
    while ((paramInt != 42319) || (paramBoolean)) {
      return;
    }
    HiddenChatSettingFragment.a(this.a, HiddenChatSettingFragment.b(this.a), aorf.b(HiddenChatSettingFragment.a(this.a).c(), this.a.getActivity()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aore
 * JD-Core Version:    0.7.0.1
 */