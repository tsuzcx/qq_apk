import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avam
  implements View.OnClickListener
{
  avam(aval paramaval) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avam
 * JD-Core Version:    0.7.0.1
 */