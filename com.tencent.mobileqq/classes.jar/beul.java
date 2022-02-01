import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class beul
  implements View.OnClickListener
{
  beul(beuj parambeuj) {}
  
  public void onClick(View paramView)
  {
    if (beuj.a(this.a) != null)
    {
      beuj.a(this.a).a(paramView);
      if (beuj.a(this.a) != null) {
        beuj.a(this.a).b(paramView, 0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beul
 * JD-Core Version:    0.7.0.1
 */