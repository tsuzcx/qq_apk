import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqeb
  implements View.OnClickListener
{
  public aqeb(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    ArkIDESettingFragment.a(this.a, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqeb
 * JD-Core Version:    0.7.0.1
 */