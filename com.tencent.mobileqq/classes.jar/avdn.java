import android.widget.CompoundButton;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class avdn
  implements avdp
{
  public avdn(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean, AppletItem paramAppletItem)
  {
    int i = 1;
    ArrayList localArrayList;
    if (paramAppletItem != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsSettingFragment", 2, "OnChangeSwitchListener onChangeSwitchListener " + paramAppletItem.toString() + ",  isChecked:" + paramBoolean);
      }
      this.a.a(true);
      paramCompoundButton.setChecked(paramBoolean);
      paramCompoundButton = (apeb)AppletsSettingFragment.a(this.a).a(148);
      localArrayList = new ArrayList();
      if (!paramBoolean) {
        break label113;
      }
    }
    for (;;)
    {
      paramAppletItem.a(i);
      localArrayList.add(paramAppletItem);
      paramCompoundButton.a(localArrayList);
      return;
      label113:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdn
 * JD-Core Version:    0.7.0.1
 */