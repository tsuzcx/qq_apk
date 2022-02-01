import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atsj
  implements CompoundButton.OnCheckedChangeListener
{
  public atsj(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    int i;
    if (paramBoolean)
    {
      i = 1;
      bcef.b((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      localObject = (ampt)QQSettingAutoDownloadAndSaveFragment.a(this.a).getBusinessHandler(4);
      ((ampt)localObject).d();
      ampt.a(QQSettingAutoDownloadAndSaveFragment.a(this.a), paramBoolean);
      if (!paramBoolean) {
        break label136;
      }
      if (bfng.a().a() != 4) {
        bfng.a().a();
      }
      bcef.b(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ((ampt)localObject).a(paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label136:
      bfng.a().b();
      bcef.b(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsj
 * JD-Core Version:    0.7.0.1
 */