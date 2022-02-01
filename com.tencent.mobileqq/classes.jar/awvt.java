import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awvt
  implements View.OnClickListener
{
  awvt(awur paramawur) {}
  
  public void onClick(View paramView)
  {
    this.a.i(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvt
 * JD-Core Version:    0.7.0.1
 */