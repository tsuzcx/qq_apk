import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbwh
  implements View.OnClickListener
{
  bbwh(bbwb parambbwb) {}
  
  public void onClick(View paramView)
  {
    bbwb.a(this.a, bbwb.a(this.a));
    bbwb.b(this.a, System.currentTimeMillis());
    if (bbwb.a(this.a) - bbwb.b(this.a) < 300L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bbwb.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwh
 * JD-Core Version:    0.7.0.1
 */