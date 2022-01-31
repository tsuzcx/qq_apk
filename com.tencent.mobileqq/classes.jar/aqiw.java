import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;

public class aqiw
  implements CompoundButton.OnCheckedChangeListener
{
  public aqiw(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    int i;
    if (paramBoolean)
    {
      i = 1;
      axqw.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      ((ajuf)QQSettingAutoDownloadAndSaveFragment.a(this.a).a(4)).c();
      ajuf.a(QQSettingAutoDownloadAndSaveFragment.a(this.a), paramBoolean);
      if (!paramBoolean) {
        break label134;
      }
      if (akva.a().a() != 4) {
        akva.a().a();
      }
      axqw.b(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ((MessageHandler)QQSettingAutoDownloadAndSaveFragment.a(this.a).a(0)).f(paramBoolean);
      return;
      i = 0;
      break;
      label134:
      akva.a().b();
      axqw.b(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqiw
 * JD-Core Version:    0.7.0.1
 */