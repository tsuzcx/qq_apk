import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class amfn
  implements CompoundButton.OnCheckedChangeListener
{
  amfn(amfm paramamfm) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = ((Integer)paramCompoundButton.getTag()).intValue();
    AppletItem localAppletItem = (AppletItem)this.a.a.get(i);
    amfm.a(this.a).a(paramCompoundButton, paramBoolean, localAppletItem);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfn
 * JD-Core Version:    0.7.0.1
 */