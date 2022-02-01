import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayic
  implements View.OnClickListener
{
  ayic(ayib paramayib) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof ayid)))
    {
      ayid localayid = (ayid)paramView.getTag();
      this.a.a.a(localayid);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayic
 * JD-Core Version:    0.7.0.1
 */