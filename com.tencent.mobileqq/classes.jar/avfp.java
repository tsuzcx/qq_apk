import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class avfp
  extends anyu
{
  public avfp(QQSettingChatOperationFragment paramQQSettingChatOperationFragment) {}
  
  protected void onSetGeneralSettingsC2CRoaming(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SecuritySettingActivity", 2, "onSetGeneralSettingsC2CRoaming issuc =" + paramBoolean);
    }
    this.a.a();
    paramMap = this.a.getActivity();
    if (paramMap == null)
    {
      QLog.e("QQSettingChatOperationFragment", 1, "onSetGeneralSettingsC2CRoaming: activity is null");
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(paramMap.getApplicationContext(), 2, 2131694460, 0).b(this.a.getActivity().getTitleBarHeight());
      return;
    }
    FormSwitchItem localFormSwitchItem;
    if (QQSettingChatOperationFragment.a(this.a) != null)
    {
      QQSettingChatOperationFragment.a(this.a).setOnCheckedChangeListener(null);
      localFormSwitchItem = QQSettingChatOperationFragment.a(this.a);
      if (QQSettingChatOperationFragment.a(this.a).e() != 1) {
        break label176;
      }
    }
    label176:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localFormSwitchItem.setChecked(paramBoolean);
      QQSettingChatOperationFragment.a(this.a).setOnCheckedChangeListener(this.a);
      QQToast.a(paramMap.getApplicationContext(), 2131694459, 0).b(paramMap.getTitleBarHeight());
      return;
    }
  }
  
  protected void onSetMessageRaoam(boolean paramBoolean)
  {
    if (paramBoolean) {
      QQSettingChatOperationFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfp
 * JD-Core Version:    0.7.0.1
 */