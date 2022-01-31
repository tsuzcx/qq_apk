import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class asgu
  implements CompoundButton.OnCheckedChangeListener
{
  public asgu(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a.getActivity(), null, this.a.getString(2131695482), "qqsetting_auto_receive_pic_key", paramBoolean);
    paramCompoundButton = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      azqs.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_auto_receive_pic", 0, i, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgu
 * JD-Core Version:    0.7.0.1
 */