import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auif
  implements View.OnClickListener
{
  auif(auid paramauid) {}
  
  public void onClick(View paramView)
  {
    this.a.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auif
 * JD-Core Version:    0.7.0.1
 */