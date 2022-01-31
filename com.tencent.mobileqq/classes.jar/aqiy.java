import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;

public class aqiy
  implements CompoundButton.OnCheckedChangeListener
{
  public aqiy(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    int i;
    if (paramBoolean)
    {
      i = 1;
      axqy.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      ((ajud)QQSettingAutoDownloadAndSaveFragment.a(this.a).a(4)).c();
      ajud.a(QQSettingAutoDownloadAndSaveFragment.a(this.a), paramBoolean);
      if (!paramBoolean) {
        break label134;
      }
      if (akuz.a().a() != 4) {
        akuz.a().a();
      }
      axqy.b(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ((MessageHandler)QQSettingAutoDownloadAndSaveFragment.a(this.a).a(0)).f(paramBoolean);
      return;
      i = 0;
      break;
      label134:
      akuz.a().b();
      axqy.b(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqiy
 * JD-Core Version:    0.7.0.1
 */