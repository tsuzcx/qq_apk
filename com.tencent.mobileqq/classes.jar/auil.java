import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auil
  implements View.OnClickListener
{
  auil(auik paramauik) {}
  
  public void onClick(View paramView)
  {
    this.a.m();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auil
 * JD-Core Version:    0.7.0.1
 */