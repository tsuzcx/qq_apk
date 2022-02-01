import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amft
  implements View.OnClickListener
{
  amft(amfr paramamfr) {}
  
  public void onClick(View paramView)
  {
    amfr.a(this.a).onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amft
 * JD-Core Version:    0.7.0.1
 */