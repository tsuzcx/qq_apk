import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcid
  implements View.OnClickListener
{
  bcid(bcia parambcia) {}
  
  public void onClick(View paramView)
  {
    bcia.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcid
 * JD-Core Version:    0.7.0.1
 */