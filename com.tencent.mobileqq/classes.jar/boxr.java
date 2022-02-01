import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class boxr
  implements View.OnClickListener
{
  boxr(boxn paramboxn) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxr
 * JD-Core Version:    0.7.0.1
 */