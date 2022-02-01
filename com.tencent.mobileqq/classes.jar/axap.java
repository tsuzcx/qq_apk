import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axap
  implements View.OnClickListener
{
  axap(awzr paramawzr) {}
  
  public void onClick(View paramView)
  {
    awzr.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axap
 * JD-Core Version:    0.7.0.1
 */