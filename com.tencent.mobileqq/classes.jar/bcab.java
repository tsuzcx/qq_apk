import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class bcab
  implements CompoundButton.OnCheckedChangeListener
{
  public bcab(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("口算开关状态改变 ");
      if (!paramBoolean) {
        break label70;
      }
    }
    label70:
    for (paramCompoundButton = "on";; paramCompoundButton = "off")
    {
      QLog.d("PublishHomeWorkFragment", 2, paramCompoundButton);
      this.a.e = paramBoolean;
      if (this.a.e) {
        this.a.a.setChecked(true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcab
 * JD-Core Version:    0.7.0.1
 */