import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bevj
  implements View.OnClickListener
{
  bevj(bevi parambevi) {}
  
  public void onClick(View paramView)
  {
    if (bevi.a(this.a) != null) {
      bevi.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bevj
 * JD-Core Version:    0.7.0.1
 */