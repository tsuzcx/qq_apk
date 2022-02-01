import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awvp
  implements View.OnClickListener
{
  awvp(awur paramawur) {}
  
  public void onClick(View paramView)
  {
    this.a.d(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvp
 * JD-Core Version:    0.7.0.1
 */