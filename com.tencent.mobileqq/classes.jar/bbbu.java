import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbbu
  implements View.OnClickListener
{
  bbbu(bbbt parambbbt) {}
  
  public void onClick(View paramView)
  {
    bbbt.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbu
 * JD-Core Version:    0.7.0.1
 */