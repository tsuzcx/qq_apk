import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bqee
  implements View.OnClickListener
{
  bqee(bqeb parambqeb) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(22);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqee
 * JD-Core Version:    0.7.0.1
 */