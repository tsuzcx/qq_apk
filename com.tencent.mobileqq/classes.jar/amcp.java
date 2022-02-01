import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amcp
  implements View.OnClickListener
{
  amcp(amco paramamco) {}
  
  public void onClick(View paramView)
  {
    amco.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcp
 * JD-Core Version:    0.7.0.1
 */