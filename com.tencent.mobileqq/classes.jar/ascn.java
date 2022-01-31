import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;

public class ascn
  implements CompoundButton.OnCheckedChangeListener
{
  public ascn(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    int i;
    if (paramBoolean)
    {
      i = 1;
      azmj.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      ((allq)QQSettingAutoDownloadAndSaveFragment.a(this.a).a(4)).c();
      allq.a(QQSettingAutoDownloadAndSaveFragment.a(this.a), paramBoolean);
      if (!paramBoolean) {
        break label134;
      }
      if (amlp.a().a() != 4) {
        amlp.a().a();
      }
      azmj.b(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ((MessageHandler)QQSettingAutoDownloadAndSaveFragment.a(this.a).a(0)).f(paramBoolean);
      return;
      i = 0;
      break;
      label134:
      amlp.a().b();
      azmj.b(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascn
 * JD-Core Version:    0.7.0.1
 */