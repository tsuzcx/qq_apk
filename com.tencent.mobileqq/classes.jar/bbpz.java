import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbpz
  implements View.OnClickListener
{
  bbpz(bbpy parambbpy) {}
  
  public void onClick(View paramView)
  {
    bbpy.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpz
 * JD-Core Version:    0.7.0.1
 */