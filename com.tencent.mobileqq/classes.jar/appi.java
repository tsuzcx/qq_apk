import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;

public class appi
  implements CompoundButton.OnCheckedChangeListener
{
  public appi(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    int i;
    if (paramBoolean)
    {
      i = 1;
      awqx.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      ((ajgd)QQSettingAutoDownloadAndSaveFragment.a(this.a).a(4)).c();
      ajgd.a(QQSettingAutoDownloadAndSaveFragment.a(this.a), paramBoolean);
      if (!paramBoolean) {
        break label134;
      }
      if (akgo.a().a() != 4) {
        akgo.a().a();
      }
      awqx.b(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ((MessageHandler)QQSettingAutoDownloadAndSaveFragment.a(this.a).a(0)).f(paramBoolean);
      return;
      i = 0;
      break;
      label134:
      akgo.a().b();
      awqx.b(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     appi
 * JD-Core Version:    0.7.0.1
 */