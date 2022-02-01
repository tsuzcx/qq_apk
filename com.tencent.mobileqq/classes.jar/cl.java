import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

public class cl
  implements CompoundButton.OnCheckedChangeListener
{
  public cl(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool;
    if (!LiteAdvanceActivity.a(this.a, paramBoolean))
    {
      Switch localSwitch = LiteAdvanceActivity.a(this.a);
      if (!paramBoolean)
      {
        bool = true;
        localSwitch.setChecked(bool);
        QQToast.a(this.a, 1, anvx.a(2131705677), 0).b(this.a.getTitleBarHeight());
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      LiteAdvanceActivity.b(this.a, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cl
 * JD-Core Version:    0.7.0.1
 */