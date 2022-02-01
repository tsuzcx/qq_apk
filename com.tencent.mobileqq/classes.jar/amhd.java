import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amhd
  implements View.OnClickListener
{
  amhd(amhc paramamhc) {}
  
  public void onClick(View paramView)
  {
    amhc.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhd
 * JD-Core Version:    0.7.0.1
 */