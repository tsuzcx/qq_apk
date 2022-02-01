import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbpv
  implements View.OnClickListener
{
  bbpv(bbpu parambbpu) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpv
 * JD-Core Version:    0.7.0.1
 */