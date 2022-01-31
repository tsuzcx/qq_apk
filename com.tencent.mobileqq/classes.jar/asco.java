import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import mqq.app.AppRuntime;

public class asco
  implements CompoundButton.OnCheckedChangeListener
{
  public asco(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    bhnu.a(true, paramBoolean);
    paramCompoundButton = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (paramBoolean) {}
    for (;;)
    {
      azmj.b(null, "CliOper", "", paramCompoundButton, "0X800A6E3", "0X800A6E3", 0, i, "", "", "", "");
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asco
 * JD-Core Version:    0.7.0.1
 */