import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awuu
  implements View.OnClickListener
{
  awuu(awur paramawur) {}
  
  public void onClick(View paramView)
  {
    this.a.h(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuu
 * JD-Core Version:    0.7.0.1
 */