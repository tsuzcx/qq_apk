import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.1.1;

public class aqjb
  implements bclo
{
  public aqjb(QQSettingChatOperationFragment paramQQSettingChatOperationFragment) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    axqy.b(QQSettingChatOperationFragment.a(this.a), "CliOper", "", "", "Setting_tab", "Clean_chat_log", 0, 0, "0", "0", "", "");
    axqy.b(null, "dc00898", "", "", "0X800A0C4", "0X800A0C4", 0, 0, "", "", "", "");
    if (!this.a.getActivity().isFinishing()) {
      QQSettingChatOperationFragment.a(this.a, true);
    }
    ThreadManagerV2.excute(new QQSettingChatOperationFragment.1.1(this), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqjb
 * JD-Core Version:    0.7.0.1
 */