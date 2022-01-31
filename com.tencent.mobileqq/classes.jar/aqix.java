import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class aqix
  implements CompoundButton.OnCheckedChangeListener
{
  public aqix(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a.getActivity(), null, this.a.getString(2131695322), "qqsetting_auto_receive_magic_face_key", paramBoolean);
    paramCompoundButton = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      axqy.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_auto_receive_pic", 0, i, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqix
 * JD-Core Version:    0.7.0.1
 */