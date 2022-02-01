import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbqe
  implements View.OnClickListener
{
  bbqe(bbqd parambbqd) {}
  
  public void onClick(View paramView)
  {
    bbqd.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqe
 * JD-Core Version:    0.7.0.1
 */