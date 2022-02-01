import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayxf
  implements View.OnClickListener
{
  ayxf(ayxd paramayxd) {}
  
  public void onClick(View paramView)
  {
    ayxd.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxf
 * JD-Core Version:    0.7.0.1
 */