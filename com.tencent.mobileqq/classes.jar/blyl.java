import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blyl
  implements View.OnClickListener
{
  blyl(blyk paramblyk) {}
  
  public void onClick(View paramView)
  {
    blyk.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyl
 * JD-Core Version:    0.7.0.1
 */