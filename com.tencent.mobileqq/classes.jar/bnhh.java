import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.share.QZoneShareActivity;

public class bnhh
  implements View.OnClickListener
{
  public bnhh(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onClick(View paramView)
  {
    QZoneShareActivity.f(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhh
 * JD-Core Version:    0.7.0.1
 */