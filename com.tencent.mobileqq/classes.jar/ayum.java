import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayum
  implements View.OnClickListener
{
  ayum(ayul paramayul) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof ayun)))
    {
      ayun localayun = (ayun)paramView.getTag();
      this.a.a.a(localayun);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayum
 * JD-Core Version:    0.7.0.1
 */