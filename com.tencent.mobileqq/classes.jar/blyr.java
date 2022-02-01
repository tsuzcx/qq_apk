import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blyr
  implements View.OnClickListener
{
  blyr(blyk paramblyk) {}
  
  public void onClick(View paramView)
  {
    blyk.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyr
 * JD-Core Version:    0.7.0.1
 */