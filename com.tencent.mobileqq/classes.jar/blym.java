import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blym
  implements View.OnClickListener
{
  blym(blyk paramblyk) {}
  
  public void onClick(View paramView)
  {
    bmbc.a().an();
    blyk.a(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blym
 * JD-Core Version:    0.7.0.1
 */