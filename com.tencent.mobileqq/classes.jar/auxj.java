import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auxj
  implements CompoundButton.OnCheckedChangeListener
{
  public auxj(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    int i;
    if (paramBoolean)
    {
      i = 1;
      bdla.b((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      localObject = (ansg)QQSettingAutoDownloadAndSaveFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
      ((ansg)localObject).d();
      ansg.a(QQSettingAutoDownloadAndSaveFragment.a(this.a), paramBoolean);
      if (!paramBoolean) {
        break label138;
      }
      if (bgvx.a().a() != 4) {
        bgvx.a().a();
      }
      bdla.b(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ((ansg)localObject).a(paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label138:
      bgvx.a().b();
      bdla.b(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxj
 * JD-Core Version:    0.7.0.1
 */