import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awij
  implements View.OnClickListener
{
  awij(awih paramawih) {}
  
  public void onClick(View paramView)
  {
    awim localawim = (awim)paramView.getTag();
    if (this.a.a != null) {
      this.a.a.a(paramView, localawim.a, localawim.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awij
 * JD-Core Version:    0.7.0.1
 */