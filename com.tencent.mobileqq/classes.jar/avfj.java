import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avfj
  implements CompoundButton.OnCheckedChangeListener
{
  public avfj(QQSettingAutoDownloadAndSaveFragment paramQQSettingAutoDownloadAndSaveFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = QQSettingAutoDownloadAndSaveFragment.a(this.a);
    int i;
    if (paramBoolean)
    {
      i = 1;
      bdll.b((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      localObject = (anvl)QQSettingAutoDownloadAndSaveFragment.a(this.a).a(4);
      ((anvl)localObject).d();
      anvl.a(QQSettingAutoDownloadAndSaveFragment.a(this.a), paramBoolean);
      if (!paramBoolean) {
        break label136;
      }
      if (bhdu.a().a() != 4) {
        bhdu.a().a();
      }
      bdll.b(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ((anvl)localObject).a(paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      label136:
      bhdu.a().b();
      bdll.b(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfj
 * JD-Core Version:    0.7.0.1
 */