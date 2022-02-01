import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.PluginIphoneTitleBarActivity;

public class blwx
  implements View.OnClickListener
{
  public blwx(PluginIphoneTitleBarActivity paramPluginIphoneTitleBarActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwx
 * JD-Core Version:    0.7.0.1
 */