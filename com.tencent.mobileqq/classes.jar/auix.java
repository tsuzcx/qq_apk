import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auix
  implements View.OnClickListener
{
  auix(auiv paramauiv) {}
  
  public void onClick(View paramView)
  {
    auiv.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auix
 * JD-Core Version:    0.7.0.1
 */