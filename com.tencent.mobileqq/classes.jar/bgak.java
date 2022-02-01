import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgak
  implements CompoundButton.OnCheckedChangeListener
{
  public bgak(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.a(paramCompoundButton, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgak
 * JD-Core Version:    0.7.0.1
 */