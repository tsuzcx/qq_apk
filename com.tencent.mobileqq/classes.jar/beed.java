import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class beed
  implements View.OnClickListener
{
  beed(beec parambeec) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof bedx))
    {
      bedx localbedx = (bedx)paramView.getTag();
      if ((this.a.a != null) && (localbedx.a.isClickable())) {
        this.a.a.onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beed
 * JD-Core Version:    0.7.0.1
 */