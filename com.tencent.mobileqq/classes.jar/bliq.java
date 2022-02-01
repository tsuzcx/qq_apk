import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bliq
  implements View.OnClickListener
{
  bliq(blip paramblip) {}
  
  public void onClick(View paramView)
  {
    this.a.b(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bliq
 * JD-Core Version:    0.7.0.1
 */