import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfvv
  implements View.OnClickListener
{
  bfvv(bfvu parambfvu) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvv
 * JD-Core Version:    0.7.0.1
 */