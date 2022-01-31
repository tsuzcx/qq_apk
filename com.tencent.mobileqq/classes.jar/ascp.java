import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import mqq.app.AppRuntime;

public class ascp
  implements CompoundButton.OnCheckedChangeListener
{
  public ascp(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bhnu.a(false, paramBoolean);
    paramCompoundButton = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      azmj.b(null, "CliOper", "", paramCompoundButton, "0X800A6E4", "0X800A6E4", 0, i, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascp
 * JD-Core Version:    0.7.0.1
 */