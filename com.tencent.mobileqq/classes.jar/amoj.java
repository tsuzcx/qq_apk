import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amoj
  implements View.OnClickListener
{
  amoj(amoi paramamoi) {}
  
  public void onClick(View paramView)
  {
    amoi.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amoj
 * JD-Core Version:    0.7.0.1
 */